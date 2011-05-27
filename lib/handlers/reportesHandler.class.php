<?php

class reportesHandler 
{

  public static function CrearReporteDeFondo($year = null)
  {
    $objPHPExcel = new PHPExcel();
    $objPHPExcel->getProperties()
            ->setCreator("Rodrigo Santellan")
            ->setLastModifiedBy("Rodrigo Santellan")
            ->setTitle("Office 2007 XLSX Document")
            ->setSubject("Office 2007 XLSX Document")
            ->setDescription("Test document for Office 2007 XLSX, generated using PHP classes.");

    $objPHPExcel->setActiveSheetIndex(0);
    $index = 0;
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "CENTRO");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "NUM REG ASIGNADO POR EL CENTRO");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "DIAB&Eacute;TICO PRE TR");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "NEFROPATIA (C&Oacute;DIGO DEL FNR)");    
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "MES DEL TRASPLANTE"); 
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "A&Ntilde;O DEL TRASPLANTE");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "SITUACI&Oacute;N ACTUAL"); 
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "MES EGRESO");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "A&Ntilde;O EGRESO");   
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "CAUSA MUERTE");  
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "CAUSA PERDIDA INJERTO");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "EDAD AL TRASPLANTE");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "SEXO");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "MESES EN DIALISIS");            
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "MESES EN LISTA DE ESPERA");            
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "EDAD DE DADOR"); 
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "SEXO DADOR"); 
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "VIVO O CADAV&Eacute;RICO");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "CAUSA MUERTE");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "N&deg; INCOMPATIBILIDAD AB");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "N&deg; INCOMPATIBILIDAD DR");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "IF: ISQUEMIA FR&Iacute;A");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "INDUCCI&Oacute;N: MARQUE LO QUE INCLUY&Oacute;");

    $pacientePreTrasplantesIds = preTrasplanteHandler::retrieveAllPacientepreTrasplantesIds();
    $position = 2;
    foreach($pacientePreTrasplantesIds as $pacientePreTrasplantesId)
    {
      $preTrasplante = preTrasplanteHandler::retriveById($pacientePreTrasplantesId[0], Doctrine::HYDRATE_ARRAY);

      $index = 0;
      // HOSPITAL 
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, "THE");      
      
      // NUMERO ASIGNADO
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $preTrasplante["the"]);
      // DIABETES
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $preTrasplante["diabetes"]);   
              
      $nefropatia = PacienteHandler::retriveNefropatiaByPacienteId($preTrasplante["paciente_id"], Doctrine::HYDRATE_ARRAY);
      // NEFROPATIA
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $nefropatia["nombre"]);       
      unset($nefropatia);
      $trasplante = trasplanteHandler::retriveByPacientePreTrasplanteId($preTrasplante["id"], Doctrine::HYDRATE_ARRAY);
      
      $fecha = $trasplante["fecha"];
      $fechaList = explode("-", $fecha);
      
      // MES DEL TRASPLANTE
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $fechaList[1]);        
      
      // ANIO DEL TRASPLANTE
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $fechaList[0]);         

      $pacienteMuerte = PacienteHandler::retrivePacienteMuerteByPacienteId($preTrasplante["paciente_id"], Doctrine::HYDRATE_ARRAY);
      $pacientePerdidas = PacienteHandler::retrivePacientePerdidasByPacienteId($preTrasplante["paciente_id"], Doctrine::HYDRATE_ARRAY);
      
      $cantidadDePreTrasplantes = preTrasplanteHandler::retrieveNumberPreTrasplantesOfPaciente($preTrasplante["paciente_id"]);
      $cantidadDePreTrasplantes = $cantidadDePreTrasplantes[0][0];

      $estado =  "3. VIVO EN TR";
      if($pacienteMuerte)
      {
        $estado =  "2: FALLECIO EN TR";
      }
      else
      {
        if((int)$cantidadDePreTrasplantes == count($pacientePerdidas))
        {
          $estado =  "1: EN DIALISIS";
        }
      }
      // ESTADO ACTUAL DEL PACIENTE
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $estado); 

      if($pacienteMuerte)
      {
        $fecha_muerte = $pacienteMuerte["fecha_muerte"];
        
        $fechaList = explode("-", $fecha_muerte);
        
        // MES DE LA MUERTE
        $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
        $index++;
        $objPHPExcel->getActiveSheet()
                ->setCellValue($letter, $fechaList[1]);        
        
        // ANIO DE LA MUERTE
        $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
        $index++;
        $objPHPExcel->getActiveSheet()
                ->setCellValue($letter, $fechaList[0]);        
      }
      else
      {
        $conPerdida = false;
        $counter = 0;
        
        while($counter < count($pacientePerdidas) && !$conPerdida)
        {
          if($pacientePerdidas["paciente_pre_trasplante_id"] == $preTrasplante["id"])
          {
            $conPerdida = true; 
          }
          $counter++;
        }
        
        if(!$conPerdida)
        {
          // MES DE LA MUERTE
          $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
          $index++;
          $objPHPExcel->getActiveSheet()
                  ->setCellValue($letter, "Sin Alta");        
          
          // ANIO DE LA MUERTE
          $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
          $index++;
          $objPHPExcel->getActiveSheet()
                  ->setCellValue($letter, "Sin Alta");            
        }
        else
        {
          
        }
      }      
                    
      $position++;
    }
                                                                                                                        
    $objWriter = PHPExcel_IOFactory::createWriter($objPHPExcel, 'Excel5');
    $realPath = sfConfig::get('sf_cache_dir')."/reportes/";
    MdFileHandler::checkPathFormat($realPath);
    $objWriter->save($realPath.'reporte.xls');
  }

}
