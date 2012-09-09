<?php

class reportes2Handler 
{
  
  public static function CrearReporteDeFondo($year = null)
  {
    $objPHPExcel = reportesHandler::createPHPEXCELSheet();
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
            ->setCellValue($letter, "DIABÉTICO PRE TR");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "NEFROPATIA (CÓDIGO DEL FNR)");    
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "MES DEL TRASPLANTE"); 
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "AÑO DEL TRASPLANTE");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "SITUACIÓN ACTUAL"); 
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "MES EGRESO");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "AÑO EGRESO");   
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "FECHA MUERTE");  
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "CAUSA MUERTE");  
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "TR FUNCIONANDO EN MUERTE");  
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");    
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "FECHA PERDIDA INJERTO");
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
            ->setCellValue($letter, "VIVO O CADAVERICO");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "CAUSA MUERTE");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "N° INCOMPATIBILIDAD AB");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "N° INCOMPATIBILIDAD DR");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "ISQUEMIA FRÍA");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "INDUCCIÓN: MARQUE LO QUE INCLUYÓ");
            

    $datos = Doctrine::getTable('Consulta')->retrieveConsultaTotalReporteDeFondo($year);
    if(is_null($year))
    {
      $fileFolder = 'completo'.DIRECTORY_SEPARATOR;
    }
    else
    {
      $fileFolder = $year.DIRECTORY_SEPARATOR;
    }
    $position = 2;
    foreach($datos as $row)
    {
      $pacienteMuerte = Doctrine::getTable('Consulta')->retrievePacienteCausaDeMuerte($row["P_ID"]);
      $preTrasplantePerdida = Doctrine::getTable('Consulta')->retrievePreTrasplantePerdidaInjerto($row["PPT_ID"]);
      $trasplanteInducciones = Doctrine::getTable('Consulta')->retrieveTrasplanteInducciones($row["T_ID"]);
      $meses_en_dialisis = "N/A";
      if($row["SIN_DIALISIS"] == "NO")
      {
        $meses_en_dialisis = basicFunction::calculateDifferenceInMonth($row["FECHA_DIALISIS"], $row["T_FECHA"]);
      }
      $estado = "3. VIVO EN TR";
      if(count($pacienteMuerte) > 0)
      {
        $estado = "2: FALLECIO EN TR";
      }
      else
      {
        if(count($preTrasplantePerdida) > 0)
        {
          $estado = "1: EN DIALISIS";
        }
      }
      $index = 0;
      // HOSPITAL 
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["CENTRO"]);      
      // NUMERO ASIGNADO
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["THE"]);
      // DIABETES
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["DIABETES"]);
      // NEFROPATIA
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["NEFROPATIA"]); 
      // MES DEL TRASPLANTE
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["MES_TRASPLANTE"]);        
      
      // AÑO DEL TRASPLANTE
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["FECHA_TRASPLANTE"]);
              
      // ESTADO ACTUAL DEL PACIENTE
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $estado);
      
      // MES EGRESO
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["MES_ALTA"]);
      // AÑO EGRESO
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["FECHA_ALTA"]);
      // CAUSA MUERTE
      $texto = "NO APLICA";
      if(count($pacienteMuerte) > 0)
      {
        $muerte = array_pop($pacienteMuerte);
        // FECHA MUERTE
        $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
        $index++;
        $objPHPExcel->getActiveSheet()
                ->setCellValue($letter, $muerte["FECHA_MUERTE"]);
        // CAUSA MUERTE
        $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
        $index++;
        $objPHPExcel->getActiveSheet()
                ->setCellValue($letter, $muerte["CAUSA_MUERTE"]);
        // TR FUNCIONANDO EN MUERTE
        $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
        $index++;
        $objPHPExcel->getActiveSheet()
                ->setCellValue($letter, $muerte["TRASPLANTE_FUNCIONANDO"]);
      }
      else
      {
        // FECHA MUERTE
        $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
        $index++;
        $objPHPExcel->getActiveSheet()
                ->setCellValue($letter, $texto);
        // CAUSA MUERTE
        $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
        $index++;
        $objPHPExcel->getActiveSheet()
                ->setCellValue($letter, $texto);
        // TR FUNCIONANDO EN MUERTE
        $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
        $index++;
        $objPHPExcel->getActiveSheet()
                ->setCellValue($letter, $texto);
      }
        
      if(count($preTrasplantePerdida) > 0)
      {
        $perdida = array_pop($preTrasplantePerdida);
        // FECHA PERDIDA INJERTO
        $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
        $index++;
        $objPHPExcel->getActiveSheet()
                ->setCellValue($letter, $perdida["fecha_perdida"]);
        // CAUSA PERDIDA INJERTO
        $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
        $index++;
        $objPHPExcel->getActiveSheet()
                ->setCellValue($letter, $perdida["nombre"]);
      }
      else
      {
        // FECHA PERDIDA INJERTO
        $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
        $index++;
        $objPHPExcel->getActiveSheet()
                ->setCellValue($letter, $texto);
        // CAUSA PERDIDA INJERTO
        $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
        $index++;
        $objPHPExcel->getActiveSheet()
                ->setCellValue($letter, $texto);
      }

      // EDAD AL TRASPLANTE
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["EDAD_RECEPTOR"]);

      // SEXO
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["SEXO"]);      
      // MESES EN DIALISIS
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $meses_en_dialisis);      
      // MESES EN LISTA DE ESPERA
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["MESES_EN_LISTA"]);    
      // EDAD DE DADOR
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["EDAD_DONANTE"]);
      // SEXO DADOR
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["SEXO_DONANTE"]);
              
      // VIVO O CADAVERICO
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["TIPO_DONANTE"]);
      // CAUSA MUERTE
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["CAUSA_MUERTE_DONANTE"]);
      
      // N° INCOMPATIBILIDAD AB
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["NUMERO_INCOMPATIBILIDAD_AB"]);
      // N° INCOMPATIBILIDAD DR
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["NUMERO_INCOMPATIBILIDAD_DR"]);
              
      // NUMERO DE T isq fria en hs y min
      $t_isq = $row["T_ISQ_FRIA_HS"]." : ".$row["T_ISQ_FRIA_MIN"];
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $t_isq);   
      
      // INDUCCIÓN
      $inducciones = "";
      $induccionCounter = 0;
      foreach($trasplanteInducciones as $induccion)
      {
        $inducciones .= $induccion["NOMBRE"];
        if($induccionCounter < count($trasplanteInducciones) -1)
        {
          $inducciones .= "\n";
        }
        $induccionCounter ++;
      }
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $inducciones);      
      $position++;         
      unset($pacienteMuerte);
      unset($preTrasplantePerdida);
      unset($trasplanteInducciones);          
    }
    foreach($objPHPExcel->getActiveSheet()->getRowDimensions() as $rd) { 
      $rd->setRowHeight(-1);
    }
    $fileName = 'reporte.xls';
    $objWriter = PHPExcel_IOFactory::createWriter($objPHPExcel, 'Excel5');
    $realPath = sfConfig::get('sf_cache_dir').DIRECTORY_SEPARATOR."reportes".DIRECTORY_SEPARATOR."reporteFondo2".DIRECTORY_SEPARATOR;
    MdFileHandler::checkPathFormat($realPath.$fileFolder);
    $objWriter->save($realPath.$fileFolder.$fileName);
  }

  public static function CrearReporteDeFondoPreTrasplanteRACMV($situationYear = 2008, $year = null)
  {
    $objPHPExcel = reportesHandler::createPHPEXCELSheet();
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
            ->setCellValue($letter, "DIABÉTICO PRE TR");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "NEFROPATIA (CÓDIGO DEL FNR)");    
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "MES DEL TRASPLANTE"); 
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "AÑO DEL TRASPLANTE");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "SITUACIÓN ACTUAL"); 
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "MES EGRESO");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "AÑO EGRESO");   
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "FECHA MUERTE");  
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "CAUSA MUERTE");  
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "TR FUNCIONANDO EN MUERTE");  
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");    
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "FECHA PERDIDA INJERTO");
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
            ->setCellValue($letter, "VIVO O CADAVERICO");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "CAUSA MUERTE");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "N° INCOMPATIBILIDAD AB");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "N° INCOMPATIBILIDAD DR");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "ISQUEMIA FRÍA");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "INDUCCIÓN: MARQUE LO QUE INCLUYÓ");

    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "HTA");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "Obesidad");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "IMC");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "Dislipemia");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "Tabaquismo");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "Diabetes");                         
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "RA Rechazo Agudo"); 
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "RA Fecha Rechazo Agudo");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "CMV");
    $letter = (string)(mdBasicFunction::retrieveLeters($index)."1");
    $index++;
    $objPHPExcel->getActiveSheet()
            ->setCellValue($letter, "CMV Fecha");   
    

    $datos = Doctrine::getTable('Consulta')->retrieveConsultaPreTrasplanteRACMV($year);
    if(is_null($year))
    {
      $fileFolder = 'completo'.DIRECTORY_SEPARATOR.$situationYear.DIRECTORY_SEPARATOR;
    }
    else
    {
      $fileFolder = $year.DIRECTORY_SEPARATOR.$situationYear.DIRECTORY_SEPARATOR;
    }
    $position = 2;
    foreach($datos as $row)
    {
      $pacienteMuerte = Doctrine::getTable('Consulta')->retrievePacienteCausaDeMuerte($row["P_ID"]);
      $preTrasplantePerdida = Doctrine::getTable('Consulta')->retrievePreTrasplantePerdidaInjerto($row["PPT_ID"]);
      $trasplanteInducciones = Doctrine::getTable('Consulta')->retrieveTrasplanteInducciones($row["T_ID"]);
      $trasplanteInjertoEvolucionRa = Doctrine::getTable('Consulta')->retrieveTrasplanteInjertoEvolucionConRA($row["T_ID"]);
      $trasplanteCmv = Doctrine::getTable('Consulta')->retrieveTrasplanteCmvConEmfermedadSindromeViral($row["T_ID"]);
      
      $meses_en_dialisis = "N/A";
      if($row["SIN_DIALISIS"] == "NO")
      {
        $meses_en_dialisis = basicFunction::calculateDifferenceInMonth($row["FECHA_DIALISIS"], $row["T_FECHA"]);
      }
      
      $estado = "3. VIVO EN TR";
      $finish_date_string = $year."-12-31";
      $finish_date = new DateTime($finish_date_string);
      $is_death = false;
      if(count($pacienteMuerte) > 0)
      {
        $death_date = new DateTime($pacienteMuerte[0]["FECHA_MUERTE"]);
        if($death_date < $finish_date)
        {
          $is_death = true;
          $estado = "2: FALLECIO EN TR";
        }
        unset($death_date);
      }
      if(!$is_death)
      {
        if(count($preTrasplantePerdida) > 0)
        {
          $lost_date = new DateTime($preTrasplantePerdida[0]["fecha_perdida"]);
          if($lost_date < $finish_date)
          {
            $estado = "1: EN DIALISIS";
          }
        }
      }
      
      $index = 0;
      // HOSPITAL 
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["CENTRO"]);      
      // NUMERO ASIGNADO
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["THE"]);
      // DIABETES
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["DIABETES"]);
      // NEFROPATIA
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["NEFROPATIA"]); 
      // MES DEL TRASPLANTE
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["MES_TRASPLANTE"]);        
      
      // AÑO DEL TRASPLANTE
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["FECHA_TRASPLANTE"]);
              
      // ESTADO ACTUAL DEL PACIENTE
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $estado);
      
      // MES EGRESO
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["MES_ALTA"]);
      // AÑO EGRESO
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["FECHA_ALTA"]);
      // CAUSA MUERTE
      $texto = "NO APLICA";
      if(count($pacienteMuerte) > 0)
      {
        $muerte = array_pop($pacienteMuerte);
        // FECHA MUERTE
        $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
        $index++;
        $objPHPExcel->getActiveSheet()
                ->setCellValue($letter, $muerte["FECHA_MUERTE"]);
        // CAUSA MUERTE
        $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
        $index++;
        $objPHPExcel->getActiveSheet()
                ->setCellValue($letter, $muerte["CAUSA_MUERTE"]);
        // TR FUNCIONANDO EN MUERTE
        $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
        $index++;
        $objPHPExcel->getActiveSheet()
                ->setCellValue($letter, $muerte["TRASPLANTE_FUNCIONANDO"]);
      }
      else
      {
        // FECHA MUERTE
        $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
        $index++;
        $objPHPExcel->getActiveSheet()
                ->setCellValue($letter, $texto);
        // CAUSA MUERTE
        $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
        $index++;
        $objPHPExcel->getActiveSheet()
                ->setCellValue($letter, $texto);
        // TR FUNCIONANDO EN MUERTE
        $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
        $index++;
        $objPHPExcel->getActiveSheet()
                ->setCellValue($letter, $texto);
      }
        
      if(count($preTrasplantePerdida) > 0)
      {
        $perdida = array_pop($preTrasplantePerdida);
        // FECHA PERDIDA INJERTO
        $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
        $index++;
        $objPHPExcel->getActiveSheet()
                ->setCellValue($letter, $perdida["fecha_perdida"]);
        // CAUSA PERDIDA INJERTO
        $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
        $index++;
        $objPHPExcel->getActiveSheet()
                ->setCellValue($letter, $perdida["nombre"]);
      }
      else
      {
        // FECHA PERDIDA INJERTO
        $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
        $index++;
        $objPHPExcel->getActiveSheet()
                ->setCellValue($letter, $texto);
        // CAUSA PERDIDA INJERTO
        $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
        $index++;
        $objPHPExcel->getActiveSheet()
                ->setCellValue($letter, $texto);
      }

      // EDAD AL TRASPLANTE
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["EDAD_RECEPTOR"]);

      // SEXO
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["SEXO"]);      
      // MESES EN DIALISIS
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $meses_en_dialisis);      
      // MESES EN LISTA DE ESPERA
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["MESES_EN_LISTA"]);    
      // EDAD DE DADOR
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["EDAD_DONANTE"]);
      // SEXO DADOR
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["SEXO_DONANTE"]);
              
      // VIVO O CADAVERICO
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["TIPO_DONANTE"]);
      // CAUSA MUERTE
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["CAUSA_MUERTE_DONANTE"]);
      
      // N° INCOMPATIBILIDAD AB
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["NUMERO_INCOMPATIBILIDAD_AB"]);
      // N° INCOMPATIBILIDAD DR
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["NUMERO_INCOMPATIBILIDAD_DR"]);
              
      // NUMERO DE T isq fria en hs y min
      $t_isq = $row["T_ISQ_FRIA_HS"]." : ".$row["T_ISQ_FRIA_MIN"];
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $t_isq);   
      
      // INDUCCIÓN
      $inducciones = "";
      $induccionCounter = 0;
      foreach($trasplanteInducciones as $induccion)
      {
        $inducciones .= $induccion["NOMBRE"];
        if($induccionCounter < count($trasplanteInducciones) -1)
        {
          $inducciones .= "\n";
        }
        $induccionCounter ++;
      }
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $inducciones);
              
      // HTA
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["HTA"]);
      // Obesidad
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["OBESIDAD"]);
      // IMC
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["IMC"]);
      // Dislipemia
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["DISLIPEMIA"]);
      // Tabaquismo
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["TABAQUISMO"]);
      // Diabetes
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $row["DIABETES"]);                                  

      $ra_rechazo = "FALSO";
      $ra_fecha = " - ";
      if(count($trasplanteInjertoEvolucionRa) > 0)
      {
        $aux = array_pop($trasplanteInjertoEvolucionRa);
        $ra_rechazo = "VERDADERO";
        $ra_fecha = $aux["FECHA"];
      }
      // RA Rechazo Agudo
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $ra_rechazo);

      // RA Fecha Rechazo Agudo
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $ra_fecha);

      $cmvIndex = 1;
      $cmvCounter = 0;
      $textoCmv = "";
      $textoCmvFecha = "";
      
      foreach($trasplanteCmv as $mCmv)
      {
        $textoCmv .= $cmvIndex.": ";
        if($mCmv["TIPO"] == "0")
        {
          $textoCmv .= "Enfermedad ";
        }
        if($mCmv["TIPO"] == "2")
        {
          $textoCmv .= "Sindrome Viral";
        }
        $textoCmvFecha .= $cmvIndex.": ".$mCmv["FECHA"];
        
        if($cmvCounter < count($trasplanteCmv) -1)
        {
          $textoCmv .= "\n";
          $textoCmvFecha .= "\n";
        }
        
        $cmvCounter ++;
        $cmvIndex ++;
      }
      // CMV
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $textoCmv);

      // CMV Fecha
      $letter = (string)(mdBasicFunction::retrieveLeters($index).$position);
      $index++;
      $objPHPExcel->getActiveSheet()
              ->setCellValue($letter, $textoCmvFecha);
                            
      $position++;         
      unset($pacienteMuerte);
      unset($preTrasplantePerdida);
      unset($trasplanteInducciones);
      unset($trasplanteCmv);
      unset($trasplanteInjertoEvolucionRa);          
    }
    
    $fileName = 'reporte.xls';
    $objWriter = PHPExcel_IOFactory::createWriter($objPHPExcel, 'Excel5');
    $realPath = sfConfig::get('sf_cache_dir').DIRECTORY_SEPARATOR."reportes".DIRECTORY_SEPARATOR."reporteFondoPreTrasplante2".DIRECTORY_SEPARATOR;
    MdFileHandler::checkPathFormat($realPath.$fileFolder);
    $objWriter->save($realPath.$fileFolder.$fileName);
  }
  
}
