<?php

/**
 * consulta actions.
 *
 * @package    transplantes
 * @subpackage consulta
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class consultaActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->consultas = Doctrine_Core::getTable('consulta')
      ->createQuery('a')
      ->execute();
  }

  public function executeShow(sfWebRequest $request)
  {
    $this->consulta = Doctrine_Core::getTable('consulta')->find(array($request->getParameter('id')));
    $this->forward404Unless($this->consulta);
    //var_dump($this->consulta->retrieveFieldsList());die;
    //$lista = $this->consulta->getConsultaCampo();
    //var_dump(count($lista));
    $q = Doctrine_Manager::getInstance()->getCurrentConnection();
    $this->result = $q->fetchAssoc($this->consulta->getSentencia());	
  }
  
  public function executeRetrieveComplications(sfWebRequest $request)
  {
      $sql_basica_pacientes = 'select 
        paciente_pre_trasplante.id as ppid, paciente_pre_trasplante.the, pacientes.id as pid, pacientes.nombre, pacientes.apellido, pacientes.num_fnr, pacientes.sexo, YEAR(CURRENT_TIMESTAMP) - YEAR(pacientes.fecha_nacimiento) - (RIGHT(CURRENT_TIMESTAMP, 5) < RIGHT(pacientes.fecha_nacimiento, 5)) as edad, pacientes.fecha_nacimiento, nefropatia.nombre as nefropatia, paciente_pre_trasplante.origen,
        IF( paciente_pre_trasplante.tabaquismo=1,  "Si",  "No" ) AS tabaquismo,
        IF( paciente_pre_trasplante.dislipemia=1,  "Si",  "No" ) AS dislipemia,
        paciente_pre_trasplante.diabetes,
        IF( paciente_pre_trasplante.hta=1,  "Si",  "No" ) AS HTA,
        paciente_pre_trasplante.imc as IMC,
        IF( paciente_pre_trasplante.obesidad=1,  "Si",  "No" ) AS Obesidad,
        IF( paciente_pre_trasplante.iam=1,  "Si",  "No" ) AS Iam,
        IF( paciente_pre_trasplante.ave=1,  "Si",  "No" ) AS Ave,
        IF(pacientes.sin_dialisis="SI", "Sin dialisis", YEAR(paciente_pre_trasplante.fecha_egreso) - YEAR(pacientes.fecha_dialisis) - (RIGHT(paciente_pre_trasplante.fecha_egreso, 5) < RIGHT(pacientes.fecha_dialisis, 5))) AS "Tiempo en dialisis",
        paciente_pre_trasplante.fecha_egreso AS "Fecha TR"
        from 
        pacientes, nefropatia, paciente_pre_trasplante
        where
        pacientes.nefropatia_id = nefropatia.id
        and
        pacientes.id = paciente_pre_trasplante.paciente_id
        order by paciente_pre_trasplante.id';
     
     
     $sql_infecciosa = 'select trasplante_complicaciones_infecciosas.fecha, medicaciones.nombre as medicacion, infeccion.nombre as infeccion, germenes.nombre as germen,
        IF( trasplante_complicaciones_infecciosas.internado=1,  "Si",  "No" ) AS Internado, trasplante_complicaciones_infecciosas.dias_de_internacion,
        IF( trasplante_complicaciones_infecciosas.evolucion=1,  "Si",  "No" ) AS "En evolucion"
        from 
        trasplante_complicaciones_infecciosas, germenes, infeccion, medicaciones, trasplante, paciente_pre_trasplante
        where 
        medicaciones.id = trasplante_complicaciones_infecciosas.medicacion_id
        and
        germenes.id = trasplante_complicaciones_infecciosas.germen_id
        and
        infeccion.id = trasplante_complicaciones_infecciosas.infeccion_id
        and 
        trasplante.id = trasplante_complicaciones_infecciosas.trasplante_id
        and 
        paciente_pre_trasplante.id = trasplante.paciente_pre_trasplante_id
        and
        paciente_pre_trasplante.id = ?
     ';
     
     $sql_no_infecciosa = '
                 select
            trasplante_complicaciones_no_infecciosas.fecha, medicaciones.nombre as medicacion, 
            complicaciones_tipos.nombre as "Tipo", complicaciones_tipos_valores.nombre as Valor,
            IF( trasplante_complicaciones_no_infecciosas.internado=1,  "Si",  "No" ) AS Internado, 
            trasplante_complicaciones_no_infecciosas.dias_de_internacion,
            IF( trasplante_complicaciones_no_infecciosas.evolucion=1,  "Si",  "No" ) AS "En evolucion"
            from 
            trasplante_complicaciones_no_infecciosas, medicaciones, complicaciones_tipos_valores, complicaciones_tipos, trasplante, paciente_pre_trasplante
            where 
            medicaciones.id = trasplante_complicaciones_no_infecciosas.medicacion_id
            and
            complicaciones_tipos.id = complicaciones_tipos_valores.complicacion_tipo_id
            and 
            complicaciones_tipos_valores.id = trasplante_complicaciones_no_infecciosas.complicacion_valor_id
            and 
            trasplante.id = trasplante_complicaciones_no_infecciosas.trasplante_id
            and 
            paciente_pre_trasplante.id = trasplante.paciente_pre_trasplante_id
            and
            paciente_pre_trasplante.id = ?
            ';
            
     $sql_cmv_basico = '
            select cmv.id, cmv.fecha, cmv.tipo, cmv_diagnostico.nombre as diagnostico, cmv_drogas.nombre as droga, cmv.dias_tratamiento
            from cmv, cmv_diagnostico, cmv_drogas, trasplante, paciente_pre_trasplante
            where 
            cmv.cmv_diagnostico_id = cmv_diagnostico.id
            and
            cmv_drogas.id = cmv.cmv_droga_id
            and 
            trasplante.id = cmv.trasplante_id
            and 
            paciente_pre_trasplante.id = trasplante.paciente_pre_trasplante_id
            and
            paciente_pre_trasplante.id = ?
     ';
     $sql_cmv_emfermedades = '
        select cmv_emfermedades.nombre, cmv_uso_enfermedades.cmv_id
        from cmv_uso_enfermedades, cmv_emfermedades
        where cmv_emfermedades.id = cmv_uso_enfermedades.cmv_emfermedades_id
        and cmv_uso_enfermedades.cmv_id = ?
     ';
     
     $sql_tratamientos = '
select tratamiento.dosis, tratamiento.fecha_inicio, tratamiento.fecha_fin, medicaciones.nombre as medicacion
from tratamiento, medicaciones
where 
tratamiento.medicacion_id = medicaciones.id
and tratamiento.paciente_id = ?
     ';
     
     $sql_injerto_evolucion = '
     select 
    injerto_evolucion.id,
    injerto_evolucion.fecha,
    injerto_evolucion.tm,
    injerto_evolucion.gp_de_novo,
    injerto_evolucion.recidiva_gp_de_novo,
    injerto_evolucion.ra,
    injerto_evolucion.rc,
    ratratamiento.nombre as ratratamiento
    from 
    injerto_evolucion, ratratamiento, trasplante, paciente_pre_trasplante 
    where 
    injerto_evolucion.ra_tratamiento_id = ratratamiento.id
    and 
    trasplante.id = injerto_evolucion.trasplante_id
    and 
    paciente_pre_trasplante.id = trasplante.paciente_pre_trasplante_id
    and
    paciente_pre_trasplante.id = ?
     ';
     
     $sql_injerto_evolucion_pbr = '
     select resultado_pbr.grado, resultado_pbr.criterio
from resultado_pbr, injerto_evolucion_pbr
where injerto_evolucion_pbr.resultado_pbr_id = resultado_pbr.id
and injerto_evolucion_pbr.injerto_evolucion_id = ?
     ';
     
     $q = Doctrine_Manager::getInstance()->getCurrentConnection();
     $pacientes_basic_result = $q->fetchAssoc($sql_basica_pacientes);
     $filename = "reporte";
     $csv_filename = $filename."_".date("Y-m-d_H-i",time()).".csv";
     $fd = fopen ("/tmp/".$csv_filename, "w");
     $is_first = true;
     foreach($pacientes_basic_result as $paciente)
     {
         $salida = array();
         $salida["the"] = $paciente["the"];
         $salida["nombre"] = $paciente["nombre"];
         $salida["apellido"] = $paciente["apellido"];
         $salida["num_fnr"] = $paciente["num_fnr"];
         $salida["sexo"] = $paciente["sexo"];
         $salida["edad"] = $paciente["edad"];
         $salida["fecha_nacimiento"] = $paciente["fecha_nacimiento"];
         $salida["nefropatia"] = $paciente["nefropatia"];
         $salida["origen"] = $paciente["origen"];
         $salida["tabaquismo"] = $paciente["tabaquismo"];
         $salida["dislipemia"] = $paciente["dislipemia"];
         $salida["diabetes"] = $paciente["diabetes"];
         $salida["HTA"] = $paciente["HTA"];
         $salida["IMC"] = $paciente["IMC"];
         $salida["Obesidad"] = $paciente["Obesidad"];
         $salida["Iam"] = $paciente["Iam"];
         $salida["Ave"] = $paciente["Ave"];
         $salida["Tiempo en dialisis"] = $paciente["Tiempo en dialisis"];
         $salida["Fecha TR"] = $paciente["Fecha TR"];
         //var_dump($paciente);
         //echo '<hr/>';
         $infecciosas = $q->fetchAssoc($sql_infecciosa,array($paciente["ppid"]));
         $salidaInfecciosa = "";
         $auxInfecciosa = array();
         foreach($infecciosas as $infeccion)
         {
             /*
             $auxInfecciosa["fecha"] = $infeccion["fecha"];
             $auxInfecciosa["medicacion"] = $infeccion["medicacion"];
             $auxInfecciosa["infeccion"] = $infeccion["infeccion"];
             $auxInfecciosa["germen"] = $infeccion["germen"];
             $auxInfecciosa["Internado"] = $infeccion["Internado"];
             $auxInfecciosa["dias_de_internacion"] = $infeccion["dias_de_internacion"];
             */
             $salidaInfecciosa .= implode("->", $infeccion)."|";
             //var_dump($infeccion);
             //echo '<hr/>';
         }
         $salida["Infecciones(Fecha| medicacion| infeccion| germen| internado| dias de internacion| en evolucion)"] = $salidaInfecciosa;
         $noinfecciosas = $q->fetchAssoc($sql_no_infecciosa,array($paciente["ppid"]));
         $salidaNoInfecciosa = "";
         foreach($noinfecciosas as $noinfeccion)
         {
             $salidaNoInfecciosa .= implode("->", $noinfeccion)."|";
             //var_dump($noinfeccion);
             //echo '<hr/>';
         }
         $salida["No Infecciones(Fecha| Medicacion| Tipo| Valor| Internado| Dias de internacion| en evolucion)"] = $salidaNoInfecciosa;
         $cmvs = $q->fetchAssoc($sql_cmv_basico, array($paciente["ppid"]));
         $salidaCmv = "";
         
         foreach($cmvs as $cmv)
         {
             $auxCmv = array();
             $auxCmv["fecha"] = $cmv["fecha"];
             $auxCmv["tipo"] = $cmv["tipo"];
             $auxCmv["diagnostico"] = $cmv["diagnostico"];
             $auxCmv["droga"] = $cmv["droga"];
             $auxCmv["dias_tratamiento"] = $cmv["dias_tratamiento"];
             
             //var_dump($cmv);
             $auxEmfermedad = "";
             $cmvemfermedades = $q->fetchAssoc($sql_cmv_emfermedades, array($cmv['id']));
             foreach($cmvemfermedades as $emfermedad)
             {
                 $auxEmfermedad .= $emfermedad["nombre"]." - ";
                 //echo '<br/>';
                 //var_dump($emfermedad);
             }
             $auxCmv["emfermedadades"] = $auxEmfermedad;
             $salidaCmv .= implode("->", $auxCmv)."|";
             //echo '<hr/>';
         }
         $salida["Cmv(fecha| tipo| diagnostico| droga| dias tratamiento| listado emfermedades)"] = $salidaCmv;
         $injertos_evoluciones = $q->fetchAssoc($sql_injerto_evolucion, array($paciente["ppid"]));
         $salidaInjerto = "";
         
         foreach($injertos_evoluciones as $injevo)
         {
             $auxInjevo = array();
             $auxInjevo["fecha"] = $injevo["fecha"];
             $auxInjevo["tm"] = $injevo["tm"];
             $auxInjevo["gp_de_novo"] = $injevo["gp_de_novo"];
             $auxInjevo["recidiva_gp_de_novo"] = $injevo["recidiva_gp_de_novo"];
             $auxInjevo["ra"] = $injevo["ra"];
             $auxInjevo["rc"] = $injevo["rc"];
             $auxInjevo["ratratamiento"] = $injevo["ratratamiento"];
             //var_dump($injevo);
             $injertos_evoluciones_pbr = $q->fetchAssoc($sql_injerto_evolucion_pbr, array($injevo['id']));
             $aux_pbr = "";
             foreach($injertos_evoluciones_pbr as $injevopbr)
             {
                 $aux_pbr .= "G:".$injevopbr["grado"]."::C:".$injevopbr["criterio"];
                 //echo '<br/>';
                 //var_dump($injevopbr);
             }
             $auxInjevo["pbrs"] = $aux_pbr;
             //echo '<hr/>';
             $salidaInjerto .= implode("->", $auxInjevo);
         }
         $salida["Injerto Evolucion (Fecha| tm| gp de novo| recidiva gp de novo | ra | rc | tratamiento | pbr)"] = $salidaInjerto;
         $tratamientos = $q->fetchAssoc($sql_tratamientos, array($paciente["pid"]));
         $salidaTratamientos = "";
         foreach($tratamientos as $tratamiento)
         {
             $salidaTratamientos .= implode("->", $tratamiento);
             //var_dump($tratamiento);
             //echo '<hr/>';
         }
         $salida["Tratamiento (Dosis | Fecha Inicio| Fecha Fin| Medicacion)"] = $salidaTratamientos;
         if($is_first)
         {
             $keys = array_keys($salida);
             fputcsv($fd, $keys);   
             $is_first = false;
         }
         fputcsv($fd, $salida);
         
         //echo '<hr/><hr/><hr/><hr/><hr/><hr/><hr/><hr/>';
     }
     fclose($fd);
    // disable caching
    
    $aFile = "/tmp/".$csv_filename;
    $new_file_name = str_replace('.csv', '.xlsx', $csv_filename);
    $xlsFile = "/tmp/".$new_file_name;//, "/tmp/".$csv_filename.".xls";
    //var_dump($xlsFile);die;
    $this->convertCsvToXls($aFile, $xlsFile);
    
    if (!is_readable($xlsFile))
            die('File not found or inaccessible!');

    $size = filesize($xlsFile);
    $name = rawurldecode($new_file_name);
    
    $now = gmdate("D, d M Y H:i:s");
    header("Expires: Tue, 03 Jul 2001 06:00:00 GMT");
    header("Cache-Control: max-age=0, no-cache, must-revalidate, proxy-revalidate");
    header("Last-Modified: ".$now."GMT");

    // force download  
    header("Content-Type: application/force-download");
    header("Content-Type: application/octet-stream");
    header("Content-Type: application/download");

    // disposition / encoding on response body
    header("Content-Disposition: attachment;filename=".$name."");
    header("Content-Transfer-Encoding: binary");
    
    $new_length = $size;
    header("Content-Length: " . $size);
    //echo file_get_contents($csv_filename);
    
    $chunksize = 1 * (1024 * 1024); //you may want to change this
    $bytes_send = 0;
    if ($file = fopen($xlsFile, 'r')) {
        if (isset($_SERVER['HTTP_RANGE']))
            fseek($file, $range);

        while (!feof($file) &&
        (!connection_aborted()) &&
        ($bytes_send < $new_length)
        ) {
            $buffer = fread($file, $chunksize);
            print($buffer); //echo($buffer); // is also possible
            flush();
            $bytes_send += strlen($buffer);
        }
        fclose($file);
    } else
        die('Error - can not open file.');
     die();
  }
  
   /**
     * Read given csv file and write all rows to given xls file
     * 
     * @param string $csv_file Resource path of the csv file
     * @param string $xls_file Resource path of the excel file
     * @param string $csv_enc Encoding of the csv file, use utf8 if null
     * @throws Exception
     */
    private function convertCsvToXls($csv_file, $xls_file, $csv_enc=null) 
    {
        //set cache
        $cacheMethod = PHPExcel_CachedObjectStorageFactory::cache_to_phpTemp;
        PHPExcel_Settings::setCacheStorageMethod($cacheMethod);
        
        //open csv file
        $objReader = new PHPExcel_Reader_CSV();
        if ($csv_enc != null)
            $objReader->setInputEncoding($csv_enc);
        $objPHPExcel = $objReader->load($csv_file);
        $in_sheet = $objPHPExcel->getActiveSheet();

        //open excel file
        $objPHPExcel = new PHPExcel();
        $out_sheet = $objPHPExcel->getActiveSheet();
        
        //row index start from 1
        $row_index = 0;
        foreach ($in_sheet->getRowIterator() as $row) {
            $row_index++;
            $cellIterator = $row->getCellIterator();
            $cellIterator->setIterateOnlyExistingCells(false);
            
            //column index start from 0
            $column_index = -1;
            foreach ($cellIterator as $cell) {
                $column_index++;
                $out_sheet->setCellValueByColumnAndRow($column_index, $row_index, $cell->getValue());
            }
        }
        
        //write excel file
        $objWriter = new PHPExcel_Writer_Excel2007($objPHPExcel);
        $objWriter->save($xls_file);
    } 

  public function executeNew(sfWebRequest $request)
  {
    $this->form = new consultaForm();
  }

  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new consultaForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($consulta = Doctrine_Core::getTable('consulta')->find(array($request->getParameter('id'))), sprintf('Object consulta does not exist (%s).', $request->getParameter('id')));
    $this->form = new consultaForm($consulta);
  }

  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($consulta = Doctrine_Core::getTable('consulta')->find(array($request->getParameter('id'))), sprintf('Object consulta does not exist (%s).', $request->getParameter('id')));
    $this->form = new consultaForm($consulta);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }

  public function executeDelete(sfWebRequest $request)
  {
    $request->checkCSRFProtection();

    $this->forward404Unless($consulta = Doctrine_Core::getTable('consulta')->find(array($request->getParameter('id'))), sprintf('Object consulta does not exist (%s).', $request->getParameter('id')));
    $consulta->delete();

    $this->redirect('consulta/index');
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $consulta = $form->save();

      $this->redirect('consulta/edit?id='.$consulta->getId());
    }
  }
  
  public function executeConsultaGermenesInfecciones(sfWebRequest $request)
  {
     $this->germenes = Doctrine_Core::getTable('germenes')
      ->createQuery('a')
      ->execute();
     
     $this->infecciones = Doctrine_Core::getTable('infeccion')
      ->createQuery('a')
      ->execute();
     
     $this->germen_id = $request->getParameter("g", 0);
     $this->infeccion_id = $request->getParameter("i", 0);
     $this->result =  Doctrine::getTable('consulta')->retrieveGermenesInfeccionesData($this->germen_id, $this->infeccion_id);
     
  }
  
  public function executeConsultaTrasplanteComplicaciones(sfWebRequest $request)
  {
    $maximos = Doctrine::getTable('TrasplanteComplicacionesConsulta')->getMaximunNumbers();
    $this->days = range(0, (int) $maximos['d']);
    $this->months = range(0, (int) $maximos['m']);
    $this->years = range(0, (int) $maximos['y']);
    
    $this->dia = $request->getParameter("d", 0);
    $this->mes = $request->getParameter("m", 0);
    $this->mYear = $request->getParameter("y", 0);
    $this->datos = array();
    $this->datosInfecciosas = array();
    $this->datosNoInfecciosas = array();
    $this->plotEnable = false;
    if($this->dia > 0)
    {
      $this->datos = Doctrine::getTable('TrasplanteComplicacionesConsulta')->getByDays($this->dia);
      $this->datosInfecciosas = Doctrine::getTable('TrasplanteComplicacionesConsulta')->getByDays($this->dia, TrasplanteComplicacionesConsulta::INFECCIOSAS);
      $this->datosNoInfecciosas = Doctrine::getTable('TrasplanteComplicacionesConsulta')->getByDays($this->dia, TrasplanteComplicacionesConsulta::NOINFECCIOSAS);
      $this->plotEnable = true;
    }  
    else 
    {
      if($this->mes > 0)
      {
        $this->datos = Doctrine::getTable('TrasplanteComplicacionesConsulta')->getByMonth($this->mes);
        $this->datosInfecciosas = Doctrine::getTable('TrasplanteComplicacionesConsulta')->getByMonth($this->mes, TrasplanteComplicacionesConsulta::INFECCIOSAS);
        $this->datosNoInfecciosas = Doctrine::getTable('TrasplanteComplicacionesConsulta')->getByMonth($this->mes, TrasplanteComplicacionesConsulta::NOINFECCIOSAS);
        $this->plotEnable = true;
      }
      else
      {
        if($this->mYear > 0)
        {
          $this->datos = Doctrine::getTable('TrasplanteComplicacionesConsulta')->getByYear($this->mYear);
          $this->datosInfecciosas = Doctrine::getTable('TrasplanteComplicacionesConsulta')->getByYear($this->mYear, TrasplanteComplicacionesConsulta::INFECCIOSAS);
          $this->datosNoInfecciosas = Doctrine::getTable('TrasplanteComplicacionesConsulta')->getByYear($this->mYear, TrasplanteComplicacionesConsulta::NOINFECCIOSAS);
          $this->plotEnable = true;
        }
      }
    }
  }
  
  public function executeConsultaInducciones(sfWebRequest $request)
  {
    $auxInducciones = Doctrine::getTable('Induccion')->findAll(Doctrine_Core::HYDRATE_ARRAY);
    $inducciones = array();
    foreach($auxInducciones as $induccion)
    {
      $inducciones[$induccion["id"]] = $induccion["nombre"];
    }
    
    $pacientes = Doctrine::getTable("Consulta")->retrievePacientesInducciones();
    
    $listado = array();
    foreach($pacientes as $paciente)
    {
      if(!isset($listado[$paciente["ID"]]))
      {
        $row = array();
        $row["ID"] = $paciente["ID"];
        $row["THE"] = $paciente["THE"];
        $row["NOMBRE"] = $paciente["NOMBRE"];
        $row["APELLIDO"] = $paciente["APELLIDO"];
        foreach($inducciones as $induccion)
        {
          $row[$induccion] = "NO";
        }
        $listado[$paciente["ID"]] = $row;
      }
      $listado[$paciente["ID"]][$inducciones[$paciente["INDUCCION"]]] = "SI";
    }
    $this->result = $listado;
    
  }
  
  public function executeConsultaInmunosupresores(sfWebRequest $request)
  {
    $auxInmunosupresores = Doctrine::getTable('Inmunosupresores')->findAll(Doctrine_Core::HYDRATE_ARRAY);
    $inmunosupresores = array();
    foreach($auxInmunosupresores as $inmunosupresor)
    {
      $inmunosupresores[$inmunosupresor["id"]] = $inmunosupresor["nombre"];
    }
    
    $pacientes = Doctrine::getTable("Consulta")->retrievePacientesInmunosupresores();
    
    $listado = array();
    foreach($pacientes as $paciente)
    {
      if(!isset($listado[$paciente["ID"]]))
      {
        $row = array();
        $row["ID"] = $paciente["ID"];
        $row["THE"] = $paciente["THE"];
        $row["NOMBRE"] = $paciente["NOMBRE"];
        $row["APELLIDO"] = $paciente["APELLIDO"];
        foreach($inmunosupresores as $inmunosupresor)
        {
          $row[$inmunosupresor] = "NO";
        }
        $listado[$paciente["ID"]] = $row;
      }
      $listado[$paciente["ID"]][$inmunosupresores[$paciente["INMUNOSUPRESOR"]]] = "SI";
    }
    $this->result = $listado;
    
  }
}
