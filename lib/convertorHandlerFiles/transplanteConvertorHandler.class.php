<?php

class transplanteConvertorHandler
{

  public static function saveTrasplanteSerol($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        $query="SELECT * FROM trasplante_serol";
        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM trasplante_serol";
        }
        else
        {
          $query="SELECT * FROM trasplante_serol LIMIT ".$starting.", ".$quantity;
        }
        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        while ($i < $num) {
          $id = mysql_result($result,$i,"id_trasplante");
          $serolId = mysql_result($result,$i,"id_serol");
          $valor = mysql_result($result,$i,"valor");

          //var_dump($valor);
          $SerolValor = Doctrine::getTable("SerolValor")->findOneBy("valor", $valor);
          if(!$SerolValor)
          {
            die("inconscitencia de datos en la tabla donante_serol!!");
          }

          $serol = Doctrine::getTable("Serol")->findOneBy("id", $serolId);

          if(!$serol)
          {
            die("inconscitencia de datos en la tabla donante_serol!!");
          }
          
          $trasplante = Doctrine::getTable("Trasplante")->find($id);

          $save = true;
          if(!$trasplante)
          {
            echo "El trasplante con id: ".$id." no existe en la base serol incompleto para guardar\n";
            
            $save = false;
          }

          if($save)
          {
            $TrasplanteSerol = new TrasplanteSerol();
            $TrasplanteSerol->setTrasplanteId($trasplante->getId());
            $TrasplanteSerol->setSerolId($serol->getId());
            $TrasplanteSerol->setSerolValorId($SerolValor->getId());
            $TrasplanteSerol->save();
            $TrasplanteSerol->free(true);
            $trasplante->free(true);
            $serol->free(true);
            $SerolValor->free(true);
          }
          else
          {
//            echo "Existe un registro sin DONANTE asociado";
//            echo " DONANTE supuesto id: ".$id." ";
//            echo "\n";
          }
          $i++;
        }
        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }







// DE ACA PARA ABAJO NO FUNCA POR DOCTRINE....
  public static function saveAllTransplantes($username,$password, $database)
  {

    $starting = 0;
    $quantity = 1;
    $hasMore = true;
    echo memory_get_usage();
    while($hasMore)
    {
      echo memory_get_usage();
      $hasMore = self::doRealTransplanteSave($username, $password, $database, $starting, $quantity);
      $starting++;
    }
    


  }

  public static function doRealTransplanteSave($username,$password, $database, $starting, $quantity)
  {
        $m_conn = mysql_connect("localhost",$username,$password);
        @mysql_select_db($database,$m_conn) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        $query="SELECT * FROM trasplante LIMIT ".$starting.", ".$quantity;
        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        while ($i < $num) {
          $save = true;
          $transplate = new Trasplante();
          $id = mysql_result($result,$i,"id");
          $transplate->setId($transplate);
          $PreTrasplante = mysql_result($result,$i,"PreTrasplante");
          $preTransplateObj = Doctrine::getTable("Pacientepretrasplante")->find($PreTrasplante);
          if(!$preTransplateObj)
          {
//            echo "Existe un transplante sin Pacientepretrasplante asociado";
//            echo " Pacientepretrasplante supuesto id: ".$id." ";
//            echo "\n";
//            $save = false;
          }
          else
          {
            $transplate->setPacientePreTrasplanteId($preTransplateObj->getId());
            
          }
          $transplate->setPacientePreTrasplanteId($PreTrasplante);
          $FECHA = mysql_result($result,$i,"FECHA");
          $transplate->setFecha($FECHA);
          $NUM_TR = mysql_result($result,$i,"NUM_TR");
          $transplate->setNumeroDeTransplantesRealizados($NUM_TR);
          $ID_DONANTE = mysql_result($result,$i,"ID_DONANTE");
          $donante = Doctrine::getTable("Donante")->findOneBy("identificador", $ID_DONANTE);
          if(!$donante)
          {
//            echo "Existe un registro sin DONANTE asociado";
//            echo " DONANTE supuesto id: ".$ID_DONANTE." ";
//            echo "\n";
            $save = false;
          }
          else
          {
            $transplate->setDonanteId($donante->getId());
          }
          $donante = NULL;
          unset($donante);
          $preTransplateObj = NULL;
          unset($preTransplateObj);
          $INESTAB_HEMOD = mysql_result($result,$i,"INESTAB_HEMOD");
          $transplate->setInestabHemodial($INESTAB_HEMOD);
          $RINHON = mysql_result($result,$i,"RINHON");
          $transplate->setRinhon($RINHON);
          $ANOMALIA_VASC = mysql_result($result,$i,"ANOMALIA_VASC");
          $transplate->setAnomaliaVascular($ANOMALIA_VASC);
          $NUM_ART = mysql_result($result,$i,"NUM_ART");
          $transplate->setNumeroArterias($NUM_ART);
          $NUM_VENAS = mysql_result($result,$i,"NUM_VENAS");
          $transplate->setNumeroVenas($NUM_VENAS);
          $URETER = mysql_result($result,$i,"URETER");
          $transplate->setUreter($URETER);
          $NUM_COMP_A_B = mysql_result($result,$i,"NUM_COMP_A_B");
          $transplate->setNumeroCompatibilidadAB($NUM_COMP_A_B);
          $NUM_COMP_DR = mysql_result($result,$i,"NUM_COMP_DR");
          $transplate->setNumeroCompatibilidadDr($NUM_COMP_DR);
          $NUM_IMCOMP_A_B = mysql_result($result,$i,"NUM_IMCOMP_A_B");
          $transplate->setNumeroIncompatibilidadAB($NUM_IMCOMP_A_B);
          $NUM_IMCOMP_DR = mysql_result($result,$i,"NUM_IMCOMP_DR");
          $transplate->setNumeroIncompatibilidadDr($NUM_IMCOMP_DR);
          $AUTOAC = mysql_result($result,$i,"AUTOAC");
          $transplate->setAutoac($AUTOAC);
          $PRA_MAX = mysql_result($result,$i,"PRA_MAX");
          $transplate->setPraMax($PRA_MAX);
          $PRA_TR = mysql_result($result,$i,"PRA_TR");
          $transplate->setPraTr($PRA_TR);
          $TRANS_PREVIAS = mysql_result($result,$i,"TRANS_PREVIAS");
          $transplate->setTransPrevias($TRANS_PREVIAS);
          $NUM_TRANSF = mysql_result($result,$i,"NUM_TRANSF");
          $transplate->setNumeroTransf($NUM_TRANSF);
          $EMBARAZO = mysql_result($result,$i,"EMBARAZO");
          $transplate->setEmbarazo($EMBARAZO);
          $NUM_EMBARAZO = mysql_result($result,$i,"NUM_EMBARAZO");
          $transplate->setNumeroEmbarazo($NUM_EMBARAZO);
          $LIQ_PERFUSION = mysql_result($result,$i,"LIQ_PERFUSION");
          $transplate->setLiquidoPerfusion($LIQ_PERFUSION);
          $TQ_DE_BANCO = mysql_result($result,$i,"TQ_DE_BANCO");
          $transplate->setTqDeBanco($TQ_DE_BANCO);
          $LADO_IMPLANTE = mysql_result($result,$i,"LADO_IMPLANTE");
          $transplate->setLadoImplante($LADO_IMPLANTE);
          $ANAST_VENOSA = mysql_result($result,$i,"ANAST_ARTERIAL");
          $transplate->setAnastVenosa($ANAST_VENOSA);
          $ANAST_URETERAL = mysql_result($result,$i,"ANAST_URETERAL");
          $transplate->setAnastUreteral($ANAST_URETERAL);
          $T_ISQ_CAL_MIN = mysql_result($result,$i,"T_ISQ_CAL_MIN");
          $transplate->setTIsqCalMin($T_ISQ_CAL_MIN);
          $T_ISQ_FRIA_HS = mysql_result($result,$i,"T_ISQ_FRIA_HS");
          $transplate->setTIsqFriaHs($T_ISQ_FRIA_HS);
          $T_ISQ_FRIA_MIN = mysql_result($result,$i,"T_ISQ_FRIA_MIN");
          $transplate->setTIsqFriaMin($T_ISQ_FRIA_MIN);
          $T_ISQ_TIBIA_HS = mysql_result($result,$i,"T_ISQ_TIBIA_HS");
          $transplate->setTIsqTibiaHs($T_ISQ_TIBIA_HS);
          $REPERCUSION = mysql_result($result,$i,"REPERCUSION");
          $transplate->setReperfusion($REPERCUSION);
          $SANGRADO_I_OP = mysql_result($result,$i,"SANGRADO_I_OP");
          $transplate->setSangradoIOp($SANGRADO_I_OP);
          $LESION_ARTERIAL = mysql_result($result,$i,"LESION_ARTERIAL");
          $transplate->setLesionArterial($LESION_ARTERIAL);
          $LESION_VENOSA = mysql_result($result,$i,"LESION_VENOSA");
          $transplate->setLesionVenosa($LESION_VENOSA);
          $NECESIDAD_REPEFUNDIR = mysql_result($result,$i,"NECESIDAD_REPEFUNDIR");
          $transplate->setNecesidadRepefundir($NECESIDAD_REPEFUNDIR);
          $OTRAS_COMPL_QUIRUR = mysql_result($result,$i,"OTRAS_COMPL_QUIRUR");
          $transplate->setOtrasComplQuirur($OTRAS_COMPL_QUIRUR);
          $DIURESIS_I_OP = mysql_result($result,$i,"DIURESIS_I_OP");
          $transplate->setDiuresisIOp($DIURESIS_I_OP);
          $CR_INICIAL = mysql_result($result,$i,"CR_INICIAL");
          $transplate->setCrInicial($CR_INICIAL);
          $DIA_REC_DIURESIS = mysql_result($result,$i,"DIA_REC_DIURESIS");
          $transplate->setDiaRecDiuresis($DIA_REC_DIURESIS);
          $DIA_REC_FUNCIONAL = mysql_result($result,$i,"DIA_REC_FUNCIONAL");
          $transplate->setDiaRecFuncional($DIA_REC_FUNCIONAL);
          $DIALISIS = mysql_result($result,$i,"DIALISIS");
          $transplate->setDialisis($DIALISIS);
          $NUM_DE_HD = mysql_result($result,$i,"NUM_DE_HD");
          $transplate->setNumDeHd($NUM_DE_HD);
          $COMENTARIO = mysql_result($result,$i,"COMENTARIO");
          $transplate->setComentario($COMENTARIO);
          $FECHA_ALTA = mysql_result($result,$i,"FECHA_ALTA");
          $transplate->setFechaAlta($FECHA_ALTA);
          
          if($save)
          {
            sfContext::getInstance()->getLogger()->info("Guardando");
            $transplate->save();
          }
          $transplate = NULL;
          unset($transplate);

          $i++;
          //sleep(10);
        }

        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }
  
}
