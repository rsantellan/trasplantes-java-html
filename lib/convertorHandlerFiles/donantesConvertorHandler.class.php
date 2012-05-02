<?php

class donantesConvertorHandler
{

  public static function proccessDonantes($username,$password, $database)
  {
    echo "---------------------Salvando tablas auxiliares. -------------------------------------\n";
    self::saveAuxiliarTables($username, $password, $database);
    echo "---------------------Salvando a los donantes.-----------------------------------------\n";
    self::saveAllDonantes($username, $password, $database);
    echo "---------------------Salvando a los organos.------------------------------------------\n";
    self::saveDonanteOrganos($username, $password, $database);
    echo "---------------------Salvando a los antecedentes de donantes.-------------------------\n";
    self::saveDonanteAntecedentes($username, $password, $database);
    echo "---------------------Salvando a los seroles.------------------------------------------\n";
    self::saveDonanteSerol($username, $password, $database);
  }

  public static function saveAuxiliarTables($username,$password, $database)
  {
    echo "---------------------Salvando los antecedentes.---------------------------------------\n";
    self::saveAllAntecedentes($username, $password, $database);
    echo "---------------------Salvando las causas de muertes.----------------------------------\n";
    self::saveAllCausasDeMuerte($username, $password, $database);
    echo "---------------------Salvando los seroles.--------------------------------------------\n";
    self::saveAllSeroles($username, $password, $database);
    echo "---------------------Salvando los valores de los seroles.-----------------------------\n";
    self::saveAllSerolesValores($username, $password, $database);
  }

  public static function saveAllSeroles($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);
        
        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        //$query="SELECT * FROM serol";
        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM serol";
        }
        else
        {
          $query="SELECT * FROM serol LIMIT ".$starting.", ".$quantity;
        }
        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        while ($i < $num) {
          $id = mysql_result($result,$i,"id");
          $tipo = mysql_result($result,$i,"tipo");
/*
          echo 'Salvando los seroles : '.$id. ' ---\n';
          echo '\n';
  */        
          $serol = new Serol();
          $serol->setId($id);
          $serol->setTipo($tipo);
          $serol->save();
          $serol->free(true);
          $i++;
        }
        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }
  
  public static function saveAllSerolesValores($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);
        
        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        $query="SELECT * FROM serol_valor";
        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM serol_valor";
        }
        else
        {
          $query="SELECT * FROM serol_valor LIMIT ".$starting.", ".$quantity;
        }
        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        while ($i < $num) {
          $id = mysql_result($result,$i,"id");
          $tipo = mysql_result($result,$i,"valor");
/*
          echo 'Salvando los valores de los seroles : '.$id. ' ---\n';
          echo '\n';
  */        
          $serolValor = new SerolValor();
          $serolValor->setSerolId($id);
          $serolValor->setValor($tipo);
          $serolValor->save();
          $serolValor->free(true);
          $i++;
        }

        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }

  public static function saveAllAntecedentes($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);
        
        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM donante_antecedentes";
        }
        else
        {
          $query="SELECT * FROM donante_antecedentes LIMIT ".$starting.", ".$quantity;
        }
        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        while ($i < $num) {
          $id = mysql_result($result,$i,"ID");
          $name = mysql_result($result,$i,"DETALLES");
          /*
          echo 'Salvando el antecedente de donante : '.$id. ' ---\n';
          echo '\n';
          */
          $donanteAntecedente = new AntecedentesDeDonante();
          $donanteAntecedente->setId($id);
          $donanteAntecedente->setNombre($name);
          $donanteAntecedente->save();
          $donanteAntecedente->free(true);
          $i++;
        }         
        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }

  public static function saveAllCausasDeMuerte($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM donante_causa_muerte";
        }
        else
        {
          $query="SELECT * FROM donante_causa_muerte LIMIT ".$starting.", ".$quantity;
        }
        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        while ($i < $num) {
          $id = mysql_result($result,$i,"ID");
          $name = mysql_result($result,$i,"DETALLES");
/*
          echo 'Salvando las causas de muerte del donante : '.$id. ' ---\n';
          echo '\n';
  */        
          $donanteCausaMuerte = new DonanteCausaMuerte();
          $donanteCausaMuerte->setId($id);
          $donanteCausaMuerte->setNombre($name);
          $donanteCausaMuerte->save();
          $donanteCausaMuerte->free(true);
          $i++;
        }
        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }

  public static function saveAllDonantes($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM donante";
        }
        else
        {
          $query="SELECT * FROM donante LIMIT ".$starting.", ".$quantity;
        }
        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        while ($i < $num) {
          $id = mysql_result($result,$i,"ID");
          $TIPO_DONANTE = mysql_result($result,$i,"TIPO_DONANTE");
          $SEXO_DONANTE = mysql_result($result,$i,"SEXO_DONANTE");
          $EDAD_DONANTE = mysql_result($result,$i,"EDAD_DONANTE");
          $ENASTAB_HEMOD = mysql_result($result,$i,"ENASTAB_HEMOD");
          $TIPO_DONANTE = mysql_result($result,$i,"TIPO_DONANTE");
          $CAUSA_MUERTE_DONANTE = mysql_result($result,$i,"CAUSA_MUERTE_DONANTE");
          $CR_P = mysql_result($result,$i,"CR_P");
          $OTROS = mysql_result($result,$i,"OTROS");
          $GRUPO_SANG = mysql_result($result,$i,"GRUPO_SANG");
          $RELACION_FILIAR = mysql_result($result,$i,"RELACION_FILIAR");
          $PESO = mysql_result($result,$i,"PESO");          
          $ALTURA = mysql_result($result,$i,"ALTURA");

          if($RELACION_FILIAR == "" || $RELACION_FILIAR == "null")
          {
            $RELACION_FILIAR = null;
          }
          if(is_null($PESO))
          {
            $PESO = 0;
          }
          if(is_null($ALTURA))
          {
            $ALTURA = 0;
          }
/*
          echo 'Salvando los donantes : '.$id. ' ---\n';
          echo '\n';
  */        
          $donante = new Donante();
          $donante->setIdentificador($id);
          $donante->setTipoDonante($TIPO_DONANTE);
          $donante->setSexoDonante($SEXO_DONANTE);
          $donante->setEnastabHemod($ENASTAB_HEMOD);
          $donante->setTipoDonante($TIPO_DONANTE);
          $donante->setEdadDonante($EDAD_DONANTE);
          $donante->setDonanteCausaMuerteId($CAUSA_MUERTE_DONANTE);
          $donante->setCrP($CR_P);
          $donante->setOtros($OTROS);
          $donante->setGrupoSanguineo($GRUPO_SANG);
          $donante->setRelacionFiliar($RELACION_FILIAR);
          $donante->setPeso($PESO);
          $donante->setAltura($ALTURA);

          $donante->save();
          $donante->free(true);
          $i++;
        }

        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }

  public static function saveDonanteOrganos($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        $query="SELECT * FROM donante_organos";
        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM donante_organos";
        }
        else
        {
          $query="SELECT * FROM donante_organos LIMIT ".$starting.", ".$quantity;
        }
        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        while ($i < $num) {
          $id = mysql_result($result,$i,"ID_DONANTE");
          $name = mysql_result($result,$i,"ORGANO");
          if($name == "Rinhon")
          {
            $name = "Riñon";
          }
          
          $organo = Doctrine::getTable("Organos")->findOneBy("nombre", $name);
          if(!$organo)
          {
            die("inconscitencia de datos en la tabla donante_organos!!");
          }

          $donante = Doctrine::getTable("Donante")->findOneBy("identificador", $id);
          
          $save = true;
          if(!$donante)
          {
            $save = false;
          }

          if($save)
          {
            $DonanteOrganos = new DonanteOrganos();
            $DonanteOrganos->setDonanteId($donante->getId());
            $DonanteOrganos->setOrganoId($organo->getId());
            $DonanteOrganos->save();
            $DonanteOrganos->free(true);
            $donante->free(true);
            $organo->free(true);
          }
          else
          {
            echo "Existe un registro sin DONANTE asociado";
            echo " DONANTE supuesto id: ".$id." ";
            echo "\n";
          }
          $i++;
        }

        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }

  public static function saveDonanteAntecedentes($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        $query="SELECT * FROM donanterefantecedentes";
        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM donanterefantecedentes";
        }
        else
        {
          $query="SELECT * FROM donanterefantecedentes LIMIT ".$starting.", ".$quantity;
        }
        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        while ($i < $num) {
          $id = mysql_result($result,$i,"ID_DONANTE");
          $name = mysql_result($result,$i,"ID_ANTECEDENTE");

          $antecedente = Doctrine::getTable("AntecedentesDeDonante")->findOneBy("id", $name);
          if(!$antecedente)
          {
            die("inconscitencia de datos en la tabla donanterefantecedentes!!");
          }

          $donante = Doctrine::getTable("Donante")->findOneBy("identificador", $id);

          $save = true;
          if(!$donante)
          {
            $save = false;
          }

          if($save)
          {
            $donanteAntecedente = new DonanteAntecedentes();
            $donanteAntecedente->setDonanteId($donante->getId());
            $donanteAntecedente->setAntecedenteDeDonanteId($antecedente->getId());
            $donanteAntecedente->save();
            $donanteAntecedente->free(true);
            $donante->free(true);
            $antecedente->free(true);
          }
          else
          {
            echo "Existe un registro sin DONANTE asociado";
            echo " DONANTE supuesto id: ".$id." ";
            echo "\n";
          }
          $i++;
        }
        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }

  public static function saveDonanteSerol($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        $query="SELECT * FROM donante_serol";
        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM donante_serol";
        }
        else
        {
          $query="SELECT * FROM donante_serol LIMIT ".$starting.", ".$quantity;
        }
        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        while ($i < $num) {
          $id = mysql_result($result,$i,"id_donante");
          $serolId = mysql_result($result,$i,"id_serol");
          $valor = mysql_result($result,$i,"valor");

          //var_dump($valor);
          $SerolValor = Doctrine::getTable("SerolValor")->retrieveByValorAndSerolId($valor, $serolId);
          if(!$SerolValor)
          {
            die("inconscitencia de datos en la tabla donante_serol!!");
          }

          $serol = Doctrine::getTable("Serol")->findOneBy("id", $serolId);

          if(!$serol)
          {
            die("inconscitencia de datos en la tabla donante_serol!!");
          }
          
          $donante = Doctrine::getTable("Donante")->findOneBy("identificador", $id);

          $save = true;
          if(!$donante)
          {
            $save = false;
          }

          if($save)
          {
            $donanteSerol = new DonanteSerol();
            $donanteSerol->setDonanteId($donante->getId());
            $donanteSerol->setSerolId($serol->getId());
            $donanteSerol->setSerolValorId($SerolValor->getId());
            $donanteSerol->save();
            $donanteSerol->free(true);
            $donante->free(true);
            $serol->free(true);
            $SerolValor->free(true);
          }
          else
          {
            echo "Existe un registro sin DONANTE asociado";
            echo " DONANTE supuesto id: ".$id." ";
            echo "\n";
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
