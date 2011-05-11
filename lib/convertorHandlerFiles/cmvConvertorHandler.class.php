<?php

class cmvConvertorHandler
{
  
  public static function startAll($username,$password, $database)
  {
    self::saveAllDiagnosticos($username, $password, $database);
    self::saveAllDrogas($username, $password, $database);
    self::saveAllCMV($username, $password, $database);
    self::saveAllEmfermedades($username, $password, $database);
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
            $tipo = 2;
          }
          if($SindromeViral == 1)
          {
            $tipo = 2;
          }
          if($Profilaxis == 1)
          {
            $tipo = 3;
          }
          $cmv = new Cmv();
          $cmv->setTrasplanteId($Trasplante);
          $cmv->setFecha($FECHA);
          $cmv->setCmvDiagnosticoId($Diagnostico);
          $cmv->setDiasTratamiento($diasTm);
          $cmv->setCmvDrogaId($Droga);
          $cmv->setEfectoSecundario($EfectoSecundario);
          $cmv->setTipo($tipo);
          $cmv->save();
          
          $i++;
          $cmv->free(true);
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
          $cmv = cmvHandler::retrieveByTrasplanteIdAndDate($Trasplante, $FECHA);
          if($cmv)
          {
            $cmvEmfermedades = new CmvUsoEnfermedades();
            $cmvEmfermedades->setCmvId($cmv->getId());
            $cmvEmfermedades->setCmvEmfermedadesId($cmvenfermedades);
            $cmvEmfermedades->save();
            $cmvEmfermedades->free(true);
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
