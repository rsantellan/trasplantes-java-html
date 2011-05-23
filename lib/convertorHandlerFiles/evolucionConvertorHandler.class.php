<?php
/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of evolucionConvertorHandler
 *
 * @author rodrigo
 */
class evolucionConvertorHandler {

  public static function saveAllEvolucionCmv($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");

        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM evolucion_trasplante_cmv";
        }
        else
        {
          $query="SELECT * FROM evolucion_trasplante_cmv LIMIT ".$starting.", ".$quantity;
        }

        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        //sfContext::getInstance()->getLogger()->err($num);
        while ($i < $num) {
          $IdTrasplante = mysql_result($result,$i,"IdTrasplante");
          $FECHA = mysql_result($result,$i,"FECHA");
          $IgG_CMV = mysql_result($result,$i,"IgG_CMV");
          $IgM_CMV = mysql_result($result,$i,"IgM_CMV");
          $PCR_CMV = mysql_result($result,$i,"PCR_CMV");
          $Ag_pp65 = mysql_result($result,$i,"Ag_pp65");
          
          $idPretrasplante = transplanteConvertorHandler::retrievePreTrasplanteId($username,$password, $database, $IdTrasplante);
          $trasplante = Doctrine::getTable("Trasplante")->findOneBy("paciente_pre_trasplante_id", $idPretrasplante);          
          
          $save = true;
          if(!$trasplante)
          {
            echo "El trasplante con id: ".$IdTrasplante." no existe en la base evolucion_trasplante_cmv incompleto para guardar\n";

            $save = false;
          }

          if($save)
          {
            $object = new EvolucionTrasplanteCmv();
            $object->setFecha($FECHA);
            $object->setTrasplanteId($trasplante->getId());
            $object->setIggCmv($IgG_CMV);
            $object->setIgmCmv($IgM_CMV);
            $object->setPcrCmv($PCR_CMV);
            $object->setAgPp65($Ag_pp65);
            $object->save();

            $object->free(true);
          }
          $i++;

        }

        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }


  public static function saveAllEvolucionEcg($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");

        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM evolucion_trasplante_ecg";
        }
        else
        {
          $query="SELECT * FROM evolucion_trasplante_ecg LIMIT ".$starting.", ".$quantity;
        }

        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        //sfContext::getInstance()->getLogger()->err($num);
        while ($i < $num) {
          $IdTrasplante = mysql_result($result,$i,"IdTrasplante");
          $FECHA = mysql_result($result,$i,"FECHA");
          $RS_ECG = mysql_result($result,$i,"RS_ECG");
          $HVI_ECG = mysql_result($result,$i,"HVI_ECG");
          $Onda_Q_ECG = mysql_result($result,$i,"Onda_Q_ECG");
          
          $idPretrasplante = transplanteConvertorHandler::retrievePreTrasplanteId($username,$password, $database, $IdTrasplante);
          $trasplante = Doctrine::getTable("Trasplante")->findOneBy("paciente_pre_trasplante_id", $idPretrasplante);          


          $save = true;
          if(!$trasplante)
          {
            echo "El trasplante con id: ".$IdTrasplante." no existe en la base evolucion_trasplante_ecg incompleto para guardar\n";

            $save = false;
          }

          if($save)
          {
            $object = new EvolucionTrasplanteEcg();
            $object->setFecha($FECHA);
            $object->setTrasplanteId($trasplante->getId());
            $object->setRsEcg($RS_ECG);
            $object->setHviEcg($HVI_ECG);
            $object->setOndaQEcg($Onda_Q_ECG);
            $object->save();

            $object->free(true);
          }
          $i++;

        }

        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }
  
  public static function saveAllEvolucionEcoCardio($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");

        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM evolucion_trasplante_eco_cardio";
        }
        else
        {
          $query="SELECT * FROM evolucion_trasplante_eco_cardio LIMIT ".$starting.", ".$quantity;
        }

        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        //sfContext::getInstance()->getLogger()->err($num);
        while ($i < $num) {
          $IdTrasplante = mysql_result($result,$i,"IdTrasplante");
          $FECHA = mysql_result($result,$i,"FECHA");
          $FEVI_NORMAL = mysql_result($result,$i,"FEVI_NORMAL");
          $Insuf_Hipodiast = mysql_result($result,$i,"Insuf_Hipodiast");
          $I_Ao = mysql_result($result,$i,"I_Ao");
          $E_Ao = mysql_result($result,$i,"E_Ao");
          $I_M = mysql_result($result,$i,"I_M");
          $E_M = mysql_result($result,$i,"E_M");
          $I_P = mysql_result($result,$i,"I_P");
          $E_P = mysql_result($result,$i,"E_P");
          $I_T = mysql_result($result,$i,"I_T");
          $E_T = mysql_result($result,$i,"E_T");
          $Derrame = mysql_result($result,$i,"Derrame");
          $Calcif_valvular = mysql_result($result,$i,"Calcif_valvular");
          $HVI = mysql_result($result,$i,"HVI");
                              
          $idPretrasplante = transplanteConvertorHandler::retrievePreTrasplanteId($username,$password, $database, $IdTrasplante);
          $trasplante = Doctrine::getTable("Trasplante")->findOneBy("paciente_pre_trasplante_id", $idPretrasplante);          

          $save = true;
          if(!$trasplante)
          {
            echo "El trasplante con id: ".$IdTrasplante." no existe en la base evolucion_trasplante_eco_cardio incompleto para guardar\n";

            $save = false;
          }

          if($save)
          {
            $object = new EvolucionTrasplanteEcoCardio();
            $object->setFecha($FECHA);
            $object->setTrasplanteId($trasplante->getId());
            $object->setFeviNormal($FEVI_NORMAL);
            $object->setInsufHipodiast($Insuf_Hipodiast);
            $object->setIao($I_Ao);
            $object->setEao($E_Ao);
            $object->setIm($I_M);
            $object->setEm($E_M);
            $object->setIp($I_P);
            $object->setEp($E_P); 
            $object->setIt($I_T);
            $object->setEt($E_T);
            $object->setDerrame($Derrame);
            $object->setCalcifValvular($Calcif_valvular);
            $object->setHvi($HVI); 
                                   
            $object->save();

            $object->free(true);
          }
          $i++;

        }

        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  } 
  
  public static function saveAllEvolucionNutricionales($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");

        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM evolucion_trasplante_nutricion";
        }
        else
        {
          $query="SELECT * FROM evolucion_trasplante_nutricion LIMIT ".$starting.", ".$quantity;
        }

        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        //sfContext::getInstance()->getLogger()->err($num);
        while ($i < $num) {
          $IdTrasplante = mysql_result($result,$i,"IdTrasplante");
          $FECHA = mysql_result($result,$i,"FECHA");
          $TALLA = mysql_result($result,$i,"TALLA");
          $PESO_DESEADO = mysql_result($result,$i,"PESO_DESEADO");
          $ESTRUCTURA_OSEA = mysql_result($result,$i,"ESTRUCTURA_OSEA");
          $IMPRESION = mysql_result($result,$i,"IMPRESION");
          $PESO_REAL = mysql_result($result,$i,"PESO_REAL");
          $P_TRICIPITAL = mysql_result($result,$i,"P_TRICIPITAL");
          $P_TRICIPITAL_P = mysql_result($result,$i,"P_TRICIPITAL_P");
          $P_SUBESCAPULAR = mysql_result($result,$i,"P_SUBESCAPULAR");
          $P_SUBESCAPULAR_P = mysql_result($result,$i,"P_SUBESCAPULAR_P");
          $SUM_PLIEGUES = mysql_result($result,$i,"SUM_PLIEGUES");
          $P_SUM_PLIEGUES = mysql_result($result,$i,"P_SUM_PLIEGUES");
          $CF_BRAZO = mysql_result($result,$i,"CF_BRAZO");
          $P_CF_BRAZO = mysql_result($result,$i,"P_CF_BRAZO");
          
          $CF_MUSC_BRAZO = mysql_result($result,$i,"CF_MUSC_BRAZO");
          $P_CF_MUSC_BRAZO = mysql_result($result,$i,"P_CF_MUSC_BRAZO");
          $AREA_BRAZO = mysql_result($result,$i,"AREA_BRAZO");
          $AREA_MUSC_BRAZO = mysql_result($result,$i,"AREA_MUSC_BRAZO");
          $P_AREA_MUSC_BRAZO = mysql_result($result,$i,"P_AREA_MUSC_BRAZO");
          $AREA_GRASA_BRAZO = mysql_result($result,$i,"AREA_GRASA_BRAZO");
          $P_AREA_GRASA_BRAZO = mysql_result($result,$i,"P_AREA_GRASA_BRAZO");
          $R_CINTURA_CADERA = mysql_result($result,$i,"R_CINTURA_CADERA");
          $DIAG_NUTRICIONAL = mysql_result($result,$i,"DIAG_NUTRICIONAL");
                              
          $idPretrasplante = transplanteConvertorHandler::retrievePreTrasplanteId($username,$password, $database, $IdTrasplante);
          $trasplante = Doctrine::getTable("Trasplante")->findOneBy("paciente_pre_trasplante_id", $idPretrasplante);          

          $save = true;
          if(!$trasplante)
          {
            echo "El trasplante con id: ".$IdTrasplante." no existe en la base evolucion_trasplante_eco_cardio incompleto para guardar\n";

            $save = false;
          }

          if($save)
          {
            $object = new EvolucionTrasplanteNutricion();
            $object->setFecha($FECHA);
            $object->setTrasplanteId($trasplante->getId());
            $object->setTalla($TALLA);
            $object->setPesoDeseado($PESO_DESEADO);
            $object->setEstructuraOsea($ESTRUCTURA_OSEA);
            $object->setImpresion($IMPRESION);
            $object->setPesoReal($PESO_REAL);
            $object->setPTricipital($P_TRICIPITAL);
            $object->setPTricipitalP($P_TRICIPITAL_P);
            $object->setPSubescapular($P_SUBESCAPULAR); 
            $object->setPSubescapularP($P_SUBESCAPULAR_P);
            $object->setSumPliegues($SUM_PLIEGUES);
            $object->setPSumPliegues($P_SUM_PLIEGUES);
            $object->setCfBrazo($CF_BRAZO);
            $object->setPCfBrazo($P_CF_BRAZO); 

            $object->setCfMuscBrazo($CF_MUSC_BRAZO);
            $object->setPCfMuscBrazo($P_CF_MUSC_BRAZO);
            $object->setAreaBrazo($AREA_BRAZO);
            $object->setAreaMuscBrazo($AREA_MUSC_BRAZO); 
            $object->setPAreaMuscBrazo($P_AREA_MUSC_BRAZO);
            $object->setAreaGrasaBrazo($AREA_GRASA_BRAZO);
            $object->setPAreaGrasaBrazo($P_AREA_GRASA_BRAZO);
            $object->setRCinturaCadera($R_CINTURA_CADERA);
            $object->setDiagNutricional($DIAG_NUTRICIONAL);
                                               
            $object->save();

            $object->free(true);
          }
          $i++;

        }

        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }   
  
  public static function saveAllEvolucionParaclinica($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");

        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM evolucion_trasplante";
        }
        else
        {
          $query="SELECT * FROM evolucion_trasplante LIMIT ".$starting.", ".$quantity;
        }

        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        //sfContext::getInstance()->getLogger()->err($num);
        while ($i < $num) {

          $object = new EvolucionTrasplanteParaclinica();
          
          $IdTrasplante = mysql_result($result,$i,"IdTrasplante");
          $FECHA = mysql_result($result,$i,"FECHA");
          $PAS = mysql_result($result,$i,"PAS");
          $PAD = mysql_result($result,$i,"PAD");
          $DIURESIS = mysql_result($result,$i,"DIURESIS");
          $PESO = mysql_result($result,$i,"PESO");

          $object->setFecha($FECHA);
          $object->setPas($PAS);
          $object->setPad($PAD);
          $object->setDiuresis($DIURESIS);
          $object->setPeso($PESO);

          $UREA = mysql_result($result,$i,"UREA");
          $CREATININA = mysql_result($result,$i,"CREATININA");
          $HT = mysql_result($result,$i,"HT");
          $HB = mysql_result($result,$i,"HB");
          $GB = mysql_result($result,$i,"GB");
          $PLAQUETAS = mysql_result($result,$i,"PLAQUETAS");

          $object->setUrea($UREA);
          $object->setCreatinina($CREATININA);
          $object->setHt($HT);
          $object->setHb($HB);
          $object->setGb($GB);
          $object->setPlaquetas($PLAQUETAS);
                              
          $SODIO = mysql_result($result,$i,"SODIO");
          $POTASIO = mysql_result($result,$i,"POTASIO");
          $CLORO = mysql_result($result,$i,"CLORO");
          $CALCIO = mysql_result($result,$i,"CALCIO");
          $FOSFORO = mysql_result($result,$i,"FOSFORO");
          $GLICEMIA = mysql_result($result,$i,"GLICEMIA");

          $object->setSodio($SODIO);
          $object->setPotasio($POTASIO);
          $object->setCloro($CLORO);
          $object->setCalcio($CALCIO);
          $object->setFosforo($FOSFORO);
          $object->setGlicemia($GLICEMIA);
          
          $URICEMIA = mysql_result($result,$i,"URICEMIA");
          $PROT_U = mysql_result($result,$i,"PROT_U");
          $CCREATININA = mysql_result($result,$i,"CCREATININA");
          $CUREA = mysql_result($result,$i,"CUREA");
          $NA_U = mysql_result($result,$i,"NA_U");
          $K_U = mysql_result($result,$i,"K_U");

          $object->setUricemia($URICEMIA);
          $object->setProtU($PROT_U);
          $object->setCcreatinina($CCREATININA);
          $object->setCurea($CUREA);
          $object->setNaU($NA_U);
          $object->setKu($K_U);
              
          $CyA_PV = mysql_result($result,$i,"CyA_PV");
          $CyA_PP = mysql_result($result,$i,"CyA_PP");
          $FK_P = mysql_result($result,$i,"FK_P");
          $MFM_P = mysql_result($result,$i,"MFM_P");
          $EVE_P = mysql_result($result,$i,"EVE_P");
          $BD = mysql_result($result,$i,"BD");

          $object->setCyaPv($CyA_PV);
          $object->setCyaPp($CyA_PP);
          $object->setFkP($FK_P);
          $object->setMfmP($MFM_P);
          $object->setEveP($EVE_P);
          $object->setBd($BD);
                    
          $BI = mysql_result($result,$i,"BI");
          $TGO = mysql_result($result,$i,"TGO");
          $TGP = mysql_result($result,$i,"TGP");
          $GAMMAGT = mysql_result($result,$i,"GAMMAGT");
          $F_ALC = mysql_result($result,$i,"F_ALC");
          $T_PROT = mysql_result($result,$i,"T_PROT");

          $object->setBi($BI);
          $object->setTgo($TGO);
          $object->setTgp($TGP);
          $object->setGammagt($GAMMAGT);
          $object->setFAlc($F_ALC);
          $object->setTProt($T_PROT);
                    
          $KPTT = mysql_result($result,$i,"KPTT");
          $HOWELL = mysql_result($result,$i,"HOWELL");
          $FIBRINOGENO = mysql_result($result,$i,"FIBRINOGENO");
          $COLESTEROL = mysql_result($result,$i,"COLESTEROL");
          $HDL = mysql_result($result,$i,"HDL");
          $LDL = mysql_result($result,$i,"LDL");
          
          $object->setKptt($KPTT);
          $object->setHowell($HOWELL);
          $object->setFibrinogeno($FIBRINOGENO);
          $object->setColesterol($COLESTEROL);
          $object->setHdl($HDL);
          $object->setLdl($LDL);
          
          $R_AT = mysql_result($result,$i,"R_AT");
          $TG = mysql_result($result,$i,"TG");
          $HNA1C = mysql_result($result,$i,"HNA1C");
          $ALBUMINA = mysql_result($result,$i,"ALBUMINA");
          $GLOBULINAS = mysql_result($result,$i,"GLOBULINAS");
          $PTHi = mysql_result($result,$i,"PTHi");

          $object->setRAt($R_AT);
          $object->setTg($TG);
          $object->setHna1c($HNA1C);
          $object->setAlbumina($ALBUMINA);
          $object->setGlobulinas($GLOBULINAS);
          $object->setPthi($PTHi);
                    
          $OTROS = mysql_result($result,$i,"OTROS");
          $NUMPTHi = mysql_result($result,$i,"NUMPTHi");

          $object->setOtros($OTROS);
          $object->setNumpthi($NUMPTHi);
                                                                                          
          $idPretrasplante = transplanteConvertorHandler::retrievePreTrasplanteId($username,$password, $database, $IdTrasplante);
          $trasplante = Doctrine::getTable("Trasplante")->findOneBy("paciente_pre_trasplante_id", $idPretrasplante);          

          $save = true;
          if(!$trasplante)
          {
            echo "El trasplante con id: ".$IdTrasplante." no existe en la base evolucion_trasplante incompleto para guardar\n";

            $save = false;
          }

          if($save)
          {
            $object->setTrasplanteId($trasplante->getId());
            $object->save();
          }
          $object->free(true);
          $i++;

        }

        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }  

  public static function saveAllEvolucionEcoDopler($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");

        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM evolucion_trasplante_ecodopler";
        }
        else
        {
          $query="SELECT * FROM evolucion_trasplante_ecodopler LIMIT ".$starting.", ".$quantity;
        }

        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        //sfContext::getInstance()->getLogger()->err($num);
        while ($i < $num) {
          $IdTrasplante = mysql_result($result,$i,"IdTrasplante");
          $FECHA = mysql_result($result,$i,"FECHA");
          $ESTRUCTURA = mysql_result($result,$i,"ESTRUCTURA");
          $DILATACION = mysql_result($result,$i,"DILATACION");
          $COLECCIONES = mysql_result($result,$i,"COLECCIONES");
          $EJE_ARTERIAL = mysql_result($result,$i,"EJE_ARTERIAL");
          $EJE_VENOSO = mysql_result($result,$i,"EJE_VENOSO");
          $ARTERIA_RENAL = mysql_result($result,$i,"ARTERIA_RENAL");
          $VENA_RENAL = mysql_result($result,$i,"VENA_RENAL");
          $ANAST_VENOSA = mysql_result($result,$i,"ANAST_VENOSA");

          $ANAST_RENOSA = mysql_result($result,$i,"ANAST_RENOSA");
          $INDICE = mysql_result($result,$i,"INDICE");
          $setOtros = mysql_result($result,$i,"OTROS");
                              
          $idPretrasplante = transplanteConvertorHandler::retrievePreTrasplanteId($username,$password, $database, $IdTrasplante);
          $trasplante = Doctrine::getTable("Trasplante")->findOneBy("paciente_pre_trasplante_id", $idPretrasplante);          

          $save = true;
          if(!$trasplante)
          {
            echo "El trasplante con id: ".$IdTrasplante." no existe en la base evolucion_trasplante_ecodopler incompleto para guardar\n";

            $save = false;
          }

          if($save)
          {
            $object = new EvolucionTrasplanteEcodopler();
            $object->setFecha($FECHA);
            $object->setTrasplanteId($trasplante->getId());
            $object->setEstructura($ESTRUCTURA);
            $object->setDilatacion($DILATACION);
            $object->setColecciones($COLECCIONES);
            $object->setEjeArterial($EJE_ARTERIAL);
            
            $object->setEjeVenoso($EJE_VENOSO);
            $object->setArteriaRenal($ARTERIA_RENAL);
            $object->setVenaRenal($VENA_RENAL);
            $object->setAnastVenosa($ANAST_VENOSA);

            $object->setAnastRenosa($ANAST_RENOSA);
            $object->setIndice($INDICE);
            $object->setOtros($setOtros);
                        
            $object->save();

            $object->free(true);
          }
          $i++;

        }

        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }

  public static function saveAllEvolucionEcografias($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");

        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM evolucion_trasplante_ecografia";
        }
        else
        {
          $query="SELECT * FROM evolucion_trasplante_ecografia LIMIT ".$starting.", ".$quantity;
        }

        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        //sfContext::getInstance()->getLogger()->err($num);
        while ($i < $num) {
          $IdTrasplante = mysql_result($result,$i,"IdTrasplante");
          $FECHA = mysql_result($result,$i,"FECHA");
          $Diametros = mysql_result($result,$i,"Diametros");
          $Dilatacion = mysql_result($result,$i,"Dilatacion");
          $Litiasin = mysql_result($result,$i,"Litiasin");
          $Vejiga = mysql_result($result,$i,"Vejiga");
          $Espesor = mysql_result($result,$i,"Espesor");
          $OTROS = mysql_result($result,$i,"OTROS");
                              
          $idPretrasplante = transplanteConvertorHandler::retrievePreTrasplanteId($username,$password, $database, $IdTrasplante);
          $trasplante = Doctrine::getTable("Trasplante")->findOneBy("paciente_pre_trasplante_id", $idPretrasplante);          

          $save = true;
          if(!$trasplante)
          {
            echo "El trasplante con id: ".$IdTrasplante." no existe en la base evolucion_trasplante_ecografia incompleto para guardar\n";

            $save = false;
          }

          if($save)
          {
            $object = new EvolucionTrasplanteEcografia();
            $object->setFecha($FECHA);
            $object->setTrasplanteId($trasplante->getId());
            $object->setDiametros($Diametros);
            $object->setDilatacion($Dilatacion);
            $object->setLitiasin($Litiasin);
            $object->setVejiga($Vejiga);
            $object->setEspesor($Espesor);
            $object->setOtros($OTROS);
                       
            $object->save();

            $object->free(true);
          }
          $i++;

        }

        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }

  public static function saveAllEvolucionMarvirales($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");

        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM evolucion_trasplante_marvirales";
        }
        else
        {
          $query="SELECT * FROM evolucion_trasplante_marvirales LIMIT ".$starting.", ".$quantity;
        }

        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        //sfContext::getInstance()->getLogger()->err($num);
        while ($i < $num) {
          $IdTrasplante = mysql_result($result,$i,"IdTrasplante");
          $FECHA = mysql_result($result,$i,"FECHA");
          $HSV = mysql_result($result,$i,"HSV");
          $AGHBS = mysql_result($result,$i,"AGHBS");
          $HBSAC = mysql_result($result,$i,"HBSAC");
          $HBCAC = mysql_result($result,$i,"HBCAC");
          $HVC = mysql_result($result,$i,"HVC");
          $HIV = mysql_result($result,$i,"HIV");
                              
          $idPretrasplante = transplanteConvertorHandler::retrievePreTrasplanteId($username,$password, $database, $IdTrasplante);
          $trasplante = Doctrine::getTable("Trasplante")->findOneBy("paciente_pre_trasplante_id", $idPretrasplante);          

          $save = true;
          if(!$trasplante)
          {
            echo "El trasplante con id: ".$IdTrasplante." no existe en la base evolucion_trasplante_marvirales incompleto para guardar\n";

            $save = false;
          }

          if($save)
          {
            $object = new EvolucionTrasplanteMarvirales();
            $object->setFecha($FECHA);
            $object->setTrasplanteId($trasplante->getId());
            $object->setHsv($HSV);
            $object->setAghbs($AGHBS);
            $object->setHbsac($HBSAC);
            $object->setHbcac($HBCAC);
            $object->setHvc($HVC);
            $object->setHiv($HIV);
                       
            $object->save();

            $object->free(true);
          }
          $i++;

        }

        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }

  public static function saveAllEvolucionTxTorax($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");

        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM evolucion_trasplante_txtorax";
        }
        else
        {
          $query="SELECT * FROM evolucion_trasplante_txtorax LIMIT ".$starting.", ".$quantity;
        }

        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        //sfContext::getInstance()->getLogger()->err($num);
        while ($i < $num) {
          $IdTrasplante = mysql_result($result,$i,"IdTrasplante");
          $FECHA = mysql_result($result,$i,"FECHA");
          $RCT = mysql_result($result,$i,"RCT");
          $FOCO = mysql_result($result,$i,"FOCO");
          $LATERALIZADO = mysql_result($result,$i,"LATERALIZADO");
          $DERRAME_PLEURAL = mysql_result($result,$i,"DERRAME_PLEURAL");
          $LATERAL_DERRAME = mysql_result($result,$i,"LATERAL_DERRAME");
          $SECUELAS = mysql_result($result,$i,"SECUELAS");
          $OTROS = mysql_result($result,$i,"OTROS");
                              
          $idPretrasplante = transplanteConvertorHandler::retrievePreTrasplanteId($username,$password, $database, $IdTrasplante);
          $trasplante = Doctrine::getTable("Trasplante")->findOneBy("paciente_pre_trasplante_id", $idPretrasplante);          

          $save = true;
          if(!$trasplante)
          {
            echo "El trasplante con id: ".$IdTrasplante." no existe en la base evolucion_trasplante_marvirales incompleto para guardar\n";

            $save = false;
          }

          if($save)
          {
            $object = new EvolucionTrasplanteTxtorax();
            $object->setFecha($FECHA);
            $object->setTrasplanteId($trasplante->getId());
            $object->setRct($RCT);
            $object->setFoco($FOCO);
            $object->setLateralizado($LATERALIZADO);
            $object->setDerramePleural($DERRAME_PLEURAL);
            $object->setLateralDerrame($LATERAL_DERRAME);
            $object->setSecuelas($SECUELAS);
            $object->setOtros($OTROS);           
            $object->save();

            $object->free(true);
          }
          $i++;

        }

        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }

  public static function saveAllEvolucionExamenenes($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");

        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM evolucion_trasplanteexamenes";
        }
        else
        {
          $query="SELECT * FROM evolucion_trasplanteexamenes LIMIT ".$starting.", ".$quantity;
        }

        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        //sfContext::getInstance()->getLogger()->err($num);
        while ($i < $num) {
          $IdTrasplante = mysql_result($result,$i,"IdTrasplante");
          $FECHA = mysql_result($result,$i,"FECHA");
          $Tipo = mysql_result($result,$i,"Tipo");
          $Normal = mysql_result($result,$i,"Normal");
          $Comentario = mysql_result($result,$i,"Comentario");
          
          if($Normal == "1")
          {
            $Normal = "Normal";
          }
          else
          {
            $Normal = "Patologico";
          }
          
          $idPretrasplante = transplanteConvertorHandler::retrievePreTrasplanteId($username,$password, $database, $IdTrasplante);
          $trasplante = Doctrine::getTable("Trasplante")->findOneBy("paciente_pre_trasplante_id", $idPretrasplante);          

          $EvolucionTrasplanteExamenesTipo = Doctrine::getTable("EvolucionTrasplanteExamenesTipo")->findOneBy("nombre", $Tipo);
          $save = true;
          if(!$trasplante)
          {
            echo "El trasplante con id: ".$IdTrasplante." no existe en la base evolucion_trasplanteexamenes incompleto para guardar\n";

            $save = false;
          }

          if(!$EvolucionTrasplanteExamenesTipo)
          {
            echo "El EvolucionTrasplanteExamenesTipo con nombre: ".$Tipo." e id: ".$IdTrasplante ." no existe en la base evolucion_trasplanteexamenes incompleto para guardar\n";

            $save = false;
          }
          
          if($save)
          {
            $object = new EvolucionTrasplanteExamenes();
            $object->setFecha($FECHA);
            $object->setTrasplanteId($trasplante->getId());
            $object->setEvolucionTrasplanteExamenesTipoId($EvolucionTrasplanteExamenesTipo->getId());
            $object->setTipo($Normal);
            $object->setComentario($Comentario);
            $object->save();

            $object->free(true);
          }
          $i++;

        }

        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }
    
}

