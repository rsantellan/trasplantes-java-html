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
          $i++;
        }
        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }

  public static function saveAllInducciones($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");

        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM induccion";
        }
        else
        {
          $query="SELECT * FROM induccion LIMIT ".$starting.", ".$quantity;
        }

        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        //sfContext::getInstance()->getLogger()->err($num);
        while ($i < $num) {
          $id = mysql_result($result,$i,"id");
          $name = mysql_result($result,$i,"tipo");

          
          $object = new Induccion();
          $object->setId($id);
          $object->setNombre($name);
          $object->save();
          $i++;
          $object->free(true);
        }

        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;

  }

  public static function saveAllTrasplanteInducciones($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");

        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM trasplante_induccion";
        }
        else
        {
          $query="SELECT * FROM trasplante_induccion LIMIT ".$starting.", ".$quantity;
        }

        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        //sfContext::getInstance()->getLogger()->err($num);
        while ($i < $num) {
          $id = mysql_result($result,$i,"id_trasplante");
          $idInduccion = mysql_result($result,$i,"id_induccion");
          $name = mysql_result($result,$i,"valor");

          $trasplante = Doctrine::getTable("Trasplante")->find($id);

          $save = true;
          if(!$trasplante)
          {
            echo "El trasplante con id: ".$id." no existe en la base Inducciones incompleto para guardar\n";

            $save = false;
          }

          if($save)
          {
            $object = new TrasplanteInduccion();
            $object->setTrasplanteId($id);
            $object->setInduccionId($idInduccion);
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

  public static function saveAllInmunosupresores($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");

        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM inmunosupresores";
        }
        else
        {
          $query="SELECT * FROM inmunosupresores LIMIT ".$starting.", ".$quantity;
        }

        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        //sfContext::getInstance()->getLogger()->err($num);
        while ($i < $num) {
          $id = mysql_result($result,$i,"id");
          $name = mysql_result($result,$i,"tipo");


          $object = new Inmunosupresores();
          $object->setId($id);
          $object->setNombre($name);
          $object->save();
          $i++;
          $object->free(true);
        }

        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;

  }

  public static function saveAllTrasplanteInmunosupresores($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");

        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM trasplante_inmunosupresores";
        }
        else
        {
          $query="SELECT * FROM trasplante_inmunosupresores LIMIT ".$starting.", ".$quantity;
        }

        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        //sfContext::getInstance()->getLogger()->err($num);
        while ($i < $num) {
          $id = mysql_result($result,$i,"id_trasplante");
          $idInduccion = mysql_result($result,$i,"id_inmunosupresores");
          $name = mysql_result($result,$i,"valor");

          $trasplante = Doctrine::getTable("Trasplante")->find($id);

          $save = true;
          if(!$trasplante)
          {
            echo "El trasplante con id: ".$id." no existe en la base trasplante_inmunosupresores incompleto para guardar\n";

            $save = false;
          }

          if($save)
          {
            $object = new TrasplanteInmunosupresores();
            $object->setTrasplanteId($id);
            $object->setInmunosupresoresId($idInduccion);
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

  public static function saveAllResultadosPbr($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");

        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM resultado_pbr";
        }
        else
        {
          $query="SELECT * FROM resultado_pbr LIMIT ".$starting.", ".$quantity;
        }

        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        //sfContext::getInstance()->getLogger()->err($num);
        while ($i < $num) {
          $id = mysql_result($result,$i,"ID");
          $name = mysql_result($result,$i,"GRADO");
          $criterio = mysql_result($result,$i,"CRITERIO");

          $object = new ResultadoPbr();
          $object->setId($id);
          $object->setGrado($name);
          $object->setCriterio($criterio);
          $object->save();
          $i++;
          $object->free(true);
        }

        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }

  public static function saveAllRaTratamiento($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");

        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM ratratamiento";
        }
        else
        {
          $query="SELECT * FROM ratratamiento LIMIT ".$starting.", ".$quantity;
        }

        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        //sfContext::getInstance()->getLogger()->err($num);
        while ($i < $num) {
          $id = mysql_result($result,$i,"ID");
          $name = mysql_result($result,$i,"NOMBRE");


          $object = new Ratratamiento();
          $object->setId($id);
          $object->setNombre($name);
          $object->save();
          $i++;
          $object->free(true);
        }

        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;

  }
}
