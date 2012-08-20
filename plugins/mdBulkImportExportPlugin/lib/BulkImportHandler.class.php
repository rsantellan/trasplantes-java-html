<?php

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of BulkImportHandler
 *
 * @author rodrigo
 */
class BulkImportHandler {

    //const UPLOAD_PATH = sfConfig::get('sf_upload_dir') . "/bulk";

    public static function retrieveAvailableClasses() {
        $list = array();
        $list["mdDynamicContent"] = "contenidos";
        $list["mdProduct"] = "productos";
        return $list;
    }

    public static function retrieveImagesUploadPath() {
        return sfConfig::get('sf_upload_dir') . "/bulk/images";
    }

    public static function retrieveXlsUploadPath() {
        return sfConfig::get('sf_upload_dir') . "/bulk/xls";
    }

    public static function startBulkImport($quantity_of_processing = 20) {
        $list = self::retrieveXMLFileList();
        $cantidad = 0;
        foreach ($list as $file) {
            $index = 4; //delay. cuantas filas se saltean desde el comienzo del archivo
            $cantidad += self::proccessBulkImport(self::retrieveXlsUploadPath()."/".$file, $index, $quantity_of_processing);
        }
				return $cantidad;
    }

    public static function retrieveObjectClassProfileIdHasCategoryHasImages($file)
    {
        $data = new Spreadsheet_Excel_Reader();
        $data->setOutputEncoding('CP1251'); // Set output Encoding.

        $data->read($file);
        $options = array();
        if($data->sheets[0]['numRows'] > 0)
        {
            $first_row = $data->sheets[0]['cells'][1];
            $options['class'] = $first_row[2];
            $options['md_profile_id'] = $first_row[3];
            if(isset($first_row[4]))
            {
                $options['category'] = true;
            }
            else
            {
                $options['category'] = false;
            }
            if(isset($first_row[5]))
            {
                $options['images'] = true;
            }
            else
            {
                $options['images'] = false;
            }
        }
        return $options;
    }

    private static function proccessBulkImport($file, $row, $quantity_of_processing = 20) {
        $data = new Spreadsheet_Excel_Reader();
        $data->setOutputEncoding('CP1251'); // Set output Encoding.

        $data->read($file);
        $index = 0;
        for ($i = $row; $i < count($data->sheets[0]['cells']); $i++) {
            $index++;
						self::processRow($data->sheets[0]['cells'][$i],$index);
            if ($index == $quantity_of_processing) {
                break;
            }
        }
        return $index;
    }

    private static function processRow($data,$index) {
        if (!isset($data[2])) //si la primer celda no esta vacia proceso
					return false;
				
				// celda 1 - busco el producto que tenga el codigo
				
				$objects = mdAttributeHandler::searchContents($data[2], 'mdProduct', 'es', 'codigo');

				// si me devuelve mas de uno, error porque debería ser único
				if(count($objects)>1)
					die('error - mas de un producto con el mismo codigo');
         elseif(count($objects)==1){ //si es uno solo uso el objeto para editar
              $object = mdProductHandler::retrieveMdProductById($objects[0]);
         }else{ //me creo un producto nuevo
        	$object = new mdProduct;
	        try
	        {
	        	$mdUserId = sfContext::getInstance()->getUser()->getMdUserId();
	        }catch(Exception $e){
						$mdUserId = 1;
					}
					$object->setMdUnitId(1);
					$object->setPrice(0);
					$object->setMdCurrencyId(sfConfig::get('sf_plugins_products_default_currency',1));
        	$object->setMdUserIdTmp($mdUserId);
					$isNew = true;
				}

        // celda 2 - nombre del producto
				if(isset($data[3]))
					$object->setName($data[3],'es');

				//celdas 3 y 4 - Categorias padre
				if(isset($data[4]) and isset($data[5])){
					//busco la categoria que el slug del campo del excel sea igual al label
					$cat_parent = mdCategoryHandler::retrieveMdCategoryByLabel(mdBasicFunction::slugify($data[5]));
					if(!$cat_parent){
						$cat_parent = new mdCategory();
						$cat_parent->setLabel(mdBasicFunction::slugify($data[5]));
						$cat_parent->setName($data[5],'es');
						$cat_parent->setObjectClassName('mdProduct');
						$cat_parent->save();
					}
				}
				
				//celdas 5 y 6 - Categoría hijo
				if(isset($data[6]) and isset($data[7])){
					$cat_son = mdCategoryHandler::retrieveMdCategoryByLabelAndParentId(mdBasicFunction::slugify($data[7]) . '_' . $cat_parent->getId(),$cat_parent->getId());
					if(!$cat_son){
						$cat_son = new mdCategory();
						$cat_son->setLabel(mdBasicFunction::slugify($data[7]) . '_' . $cat_parent->getId());
						$cat_son->setName($data[7],'es');
						$cat_son->setObjectClassName('mdProduct');
						$cat_son->setMdCategoryParentId($cat_parent->getId());
						$cat_son->save();	
					}else{
						//chequeo si tiene el mismo padre
						if($cat_son->getMdCategoryParentId() != $cat_parent->getId())
							die('Categoría hija de distinto padre');
					}
				}
				

				
				//salvo el producto
				$object->save();

				//le seteo la prioridad
				$object->setPriority($index);
				$object->save();
								
				//borro las relaciones con categorías del producto en caso de que existan
				mdCategoryHandler::removeMdCategoryObjectByObject($object);
				//relaciono el producto con la categoría hijo
				mdCategoryHandler::addCategoryToObject($object, $cat_son);
				
				//si el objeto era nuevo le creo el profile y el atributo codigo
				if(isset($isNew)){
					$object->executeAddProfile(1);
					mdAttributeObject::createAndSave($object->getId(), $object->getObjectClass(), 1, 1, $data[2]);
				}
					
				if(isset($data[8])){
					//salvo el campo descripcion
					$descripcion = $data[8];

					//$descripcion = iconv("UTF-8","ISO-8859-1", $descripcion);
					var_dump($descripcion);
					$descripcion = iconv("UTF-8","ISO-8859-1//TRANSLIT",$descripcion);
					
					$lineas = explode(PHP_EOL,$descripcion);
					for($i=0;$i<count($lineas);$i++){
						$palabras = explode(':',$lineas[$i]);
						if(count($palabras)>0){
							$palabras[0] = '<strong>' . $palabras[0] . '</strong>';
						}
						$lineas[$i] = implode(':', $palabras);
					}
					$descripcion = implode('<br/>', $lineas);
					mdAttributeObject::createAndSave($object->getId(), $object->getObjectClass(), 2, 1, $descripcion);
				}
				$processImages = true;
				if($processImages){
					
					//proceso las imagenes
					$image = $data[2]. '.jpg';
					$ext = substr(strrchr($image, '.'), 1);
					$serverPath = self::retrieveImagesUploadPath().'/'. $image;
	        $path_info = pathinfo($serverPath);
	        $file_extension = $path_info ["extension"];
	        $path = $object->getPath();
	        $realPath = sfConfig::get('sf_upload_dir') . $path;
	        $randName = md5(rand() * time());
	        $file_name = $randName . "." . $file_extension;

					if(file_exists($serverPath)){
		        try {
		            MdFileHandler::checkPathFormat($realPath);
		            copy($serverPath, $realPath . $file_name);
		        } catch (Exception $e) {
		            print_r($e->getMessage());
		        }
		        try {
		            $mdMedia = $object->retrieveMdMedia();
		            $mdMedia->upload(sfContext::getInstance()->getUser()->getMdPassport()->getMdUser(), $object, array('filename' => $file_name, 'name' => $image, 'type' => $ext));
								//todo BORRAR LA IMAGEN DEL UPLOAD/BULK
								unlink($serverPath);
		        } catch (Exception $e) {
		            print_r($image);
		            print_r($e->getMessage());
		        }
					}
				}
				
				/*
        $class_fields = $object->retrieveBackUpFields();
        $mdAttributeList = mdProfileHandler::retrieveAllProfileAtributes($md_profile_id);
        $started = false;
        $index = 2;
        foreach($class_fields as $field)
        {
            if($started)
            {
                $object->set($field, $data[$index]);
                $index ++;
            }
            else
            {
                $started = true;
            }
        }
        $mdUserId = 1;
        try
        {
            $mdUserId = sfContext::getInstance()->getUser()->getMdUserId();
        }catch(Exception $e)
        {
            
        }

        $object->save();
        $object->executeAddProfile($md_profile_id);
        foreach($mdAttributeList as $key => $field)
        {
            mdAttributeObject::createAndSave($object->getId(), $object->getObjectClass(), $key, $md_profile_id, isset($data[$index]) ? $data[$index] : "");
            $index ++;
        }

        if($has_category)
        {
            $categories = isset($data[$index]) ? $data[$index] : "";
            $categoriesList = explode("|", $categories);
            foreach ($categoriesList as $cat) {
                $mdCategory = Doctrine::getTable('mdCategory')->findOneBy('label', $cat);
                if ($mdCategory) {
                    mdCategoryHandler::addCategoryToObject($object, $mdCategory);
                }
            }
            $index ++;
        }
        if($has_images)
        {
            $image_string = $data[$index];
            $imageList = explode("|", $image_string);
            foreach($imageList as $image)
            {
                $ext = substr(strrchr($image, '.'), 1);
                $append = "";
                if($object_class != "")
                {
                    $append .= "/".$object_class;
                }
                if($md_profile_id != "")
                {
                    $append .= "/".$md_profile_id;
                }
                $serverPath = self::retrieveImagesUploadPath().$append.'/'. $image;
                $path_info = pathinfo($serverPath);
                $file_extension = $path_info ["extension"];
                $path = $object->getPath();
                $realPath = sfConfig::get('sf_upload_dir') . $path;
                $randName = md5(rand() * time());
                $file_name = $randName . "." . $file_extension;
                try {
                    MdFileHandler::checkPathFormat($realPath);
                    copy($serverPath, $realPath . $file_name);
                } catch (Exception $e) {
                    print_r($e->getMessage());
                }
                try {
                    $mdMedia = $object->retrieveMdMedia();
                    $mdMedia->upload(sfContext::getInstance()->getUser()->getMdPassport()->getMdUser(), $object, array('filename' => $file_name, 'name' => $image, 'type' => $ext));
                } catch (Exception $e) {
                    print_r($image);
                    print_r($e->getMessage());
                }
						}
				}
								*/
			
    }

    public static function retrieveXMLFileList() {
        $array = array();
        $path = self::retrieveXlsUploadPath();
        $path = MdFileHandler::checkPathFormat($path);
        if (is_dir($path)) {
            if ($dh = opendir($path)) {
                while (($file = readdir($dh)) !== false) {

                    //echo '<br>Nombre de archivo:' . $file . ' : Es un: ' . filetype($path . $file);

                    if (is_dir($path . $file) AND $file != '.' AND $file != '..' AND $file != '.svn') {

                        //echo '<br>Directorio:' . $path . $file;
                        self::getList($path . $file . "/");
                    } else {

                        if ($file != '.' AND $file != '..' AND $file != '.svn') {
                            array_push($array, $file);
                        }
                    }
                }
                closedir($dh);
            }
        } else {

            throw new Exception('invalid source');
        }
        return $array;
    }

}

