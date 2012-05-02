<?php

class cmvConvertorHandler
{
  
  public static function startAll($username,$password, $database)
  {
    echo "---------------------------Guarda los cmv diagnosticos---------------------------------------\n";
    self::saveAllDiagnosticos($username, $password, $database);
    echo "---------------------------Guarda los cmv drogas---------------------------------------\n";
    self::saveAllDrogas($username, $password, $database);
    echo "---------------------------Guarda los cmv---------------------------------------\n";
    self::saveAllCMV($username, $password, $database);
    echo "---------------------------Guarda las cmv emfermedades---------------------------------------\n";
    self::saveAllEmfermedades($username, $password, $database);
    echo "---------------------------Guarda los usos de cmv emfermedades---------------------------------------\n";
    self::saveAllUsoEmfermedades($username, $password, $database);
  }

    public static function saveAllEmfermedades($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");

        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM cmvemfermedades";
        }
        else
        {
          $query="SELECT * FROM cmvemfermedades LIMIT ".$starting.", ".$quantity;
        }

        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        //sfContext::getInstance()->getLogger()->err($num);
        while ($i < $num) {
          $id = mysql_result($result,$i,"ID");
          $name = mysql_result($result,$i,"NOMBRE");
          $cmvEmfermedad = new Cmvemfermedades();
          $cmvEmfermedad->setId($id);
          $cmvEmfermedad->setNombre($name);
          $cmvEmfermedad->save();
          $i++;
          $cmvEmfermedad->free(true);
        }

        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;

  }

  public static function saveAllDiagnosticos($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);
        
        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        
        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM cmvdiagnostico";
        }
        else
        {
          $query="SELECT * FROM cmvdiagnostico LIMIT ".$starting.", ".$quantity;
        }
        
        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        //sfContext::getInstance()->getLogger()->err($num);
        while ($i < $num) {
          $id = mysql_result($result,$i,"ID");
          $name = mysql_result($result,$i,"NOMBRE");
          $Cmvdiagnostico = new Cmvdiagnostico();
          $Cmvdiagnostico->setId($id);
          $Cmvdiagnostico->setNombre($name);
          $Cmvdiagnostico->save();
          $i++;
          $Cmvdiagnostico->free(true);
        }

        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;

  }

  public static function saveAllDrogas($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");

        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM cmvdrogas";
        }
        else
        {
          $query="SELECT * FROM cmvdrogas LIMIT ".$starting.", ".$quantity;
        }

        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        //sfContext::getInstance()->getLogger()->err($num);
        while ($i < $num) {
          $id = mysql_result($result,$i,"ID");
          $name = mysql_result($result,$i,"NOMBRE");
          $CmvDrogas = new CmvDrogas();
          $CmvDrogas->setId($id);
          $CmvDrogas->setNombre($name);
          $CmvDrogas->save();
          $i++;
          $CmvDrogas->free(true);
        }

        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }

  public static function saveAllCMV($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");

        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM cmv";
        }
        else
        {
          $query="SELECT * FROM cmv LIMIT ".$starting.", ".$quantity;
        }

        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        //sfContext::getInstance()->getLogger()->err($num);
        while ($i < $num) {
          $Trasplante = mysql_result($result,$i,"Trasplante");
          $FECHA = mysql_result($result,$i,"FECHA");
          $Diagnostico = mysql_result($result,$i,"Diagnostico");
          $TM = mysql_result($result,$i,"TM");
          $SindromeViral = mysql_result($result,$i,"SindromeViral");
          $Profilaxis = mysql_result($result,$i,"Profilaxis");
          $Droga = mysql_result($result,$i,"Droga");
          $diasTm = mysql_result($result,$i,"diasTm");          
          $EfectoSecundario = mysql_result($result,$i,"EfectoSecundario");
          $tipo = 0;
          if($TM == 1)
          {
            $tipo = 1;
          }
          if($SindromeViral == 1)
          {
            $tipo = 2;
          }
          if($Profilaxis == 1)
          {
            $tipo = 3;
          }
          echo 'el id del transplante en lo viejo es : '.$Trasplante."--\n";
          mysql_connect("localhost",$username,$password);

          @mysql_select_db($database) or die( "Unable to select database");
          mysql_query("set names 'utf8'");
          
          $sql_trasplante = "SELECT `PreTrasplante` as pt , `FECHA` as fecha FROM `trasplante` WHERE `id` =".$Trasplante;
          $result_tras = mysql_query($sql_trasplante);
          $num_tras = mysql_numrows($result_tras);
          if($num_tras > 0)
          {
            $pretrasplante_id = mysql_result($result_tras,0,"pt");
            $fecha_aux = mysql_result($result,0,"fecha");
          }
          mysql_close();
          if($num_tras > 0)
          {
            $transplante_aux = trasplanteHandler::retriveByPacientePreTrasplanteId($pretrasplante_id, Doctrine_Core::HYDRATE_ARRAY);
            //var_dump($transplante_aux);
            $cmv = new Cmv();
            $cmv->setTrasplanteId($transplante_aux["id"]);
            $cmv->setFecha($FECHA);
            $cmv->setCmvDiagnosticoId($Diagnostico);
            $cmv->setDiasTratamiento($diasTm);
            $cmv->setCmvDrogaId($Droga);
            $cmv->setEfectoSecundario($EfectoSecundario);
            $cmv->setTipo($tipo);
            $cmv->save();
            $cmv->free(true);
          }
          else
          {
            throw new Exception("Error al buscar el trasplante, inconsistencia en los datos.", 1230);
          }
          
          
          
          $i++;
          
        }

        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;

  }

  public static function saveAllUsoEmfermedades($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");

        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM cmv_uso_enfermedades";
        }
        else
        {
          $query="SELECT * FROM cmv_uso_enfermedades LIMIT ".$starting.", ".$quantity;
        }

        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        //sfContext::getInstance()->getLogger()->err($num);
        while ($i < $num) {
          $Trasplante = mysql_result($result,$i,"Trasplante");
          $FECHA = mysql_result($result,$i,"FECHA");
          $cmvenfermedades = mysql_result($result,$i,"cmvenfermedades");
          echo 'Cmv emfermedad Trasplante: '.$Trasplante. ' Fecha: '.$FECHA. ' emfermedad : '.$cmvenfermedades. ' ----\n';
          mysql_connect("localhost",$username,$password);

          @mysql_select_db($database) or die( "Unable to select database");
          mysql_query("set names 'utf8'");
          
          $sql_trasplante = "SELECT `PreTrasplante` as pt , `FECHA` as fecha FROM `trasplante` WHERE `id` =".$Trasplante;
          $result_tras = mysql_query($sql_trasplante);
          $num_tras = mysql_numrows($result_tras);
          if($num_tras > 0)
          {
            $pretrasplante_id = mysql_result($result_tras,0,"pt");
            $fecha_aux = mysql_result($result,0,"fecha");
          }
          mysql_close();
          if($num_tras >0)
          {
            echo 'CMV emfermedad : encontro un trasplante para esta emfermedad \n';
            $transplante_aux = trasplanteHandler::retriveByPacientePreTrasplanteId($pretrasplante_id, Doctrine_Core::HYDRATE_ARRAY);
            $cmv = cmvHandler::retrieveByTrasplanteIdAndDate($transplante_aux["id"], $FECHA);
            if($cmv)
            {
              echo 'Encontro un cmv \n';
              $cmvEmfermedades = new CmvUsoEnfermedades();
              $cmvEmfermedades->setCmvId($cmv->getId());
              $cmvEmfermedades->setCmvEmfermedadesId($cmvenfermedades);
              $cmvEmfermedades->save();
              $cmvEmfermedades->free(true);
            }
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
