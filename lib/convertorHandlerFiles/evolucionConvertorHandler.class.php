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
          
          $trasplante = Doctrine::getTable("Trasplante")->find($IdTrasplante);

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
            $object->setTrasplanteId($IdTrasplante);
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
          
          $trasplante = Doctrine::getTable("Trasplante")->find($IdTrasplante);

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
            $object->setTrasplanteId($IdTrasplante);
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
                              
          $trasplante = Doctrine::getTable("Trasplante")->find($IdTrasplante);

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
            $object->setTrasplanteId($IdTrasplante);
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
}

