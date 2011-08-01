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
          $SerolValor = Doctrine::getTable("SerolValor")->retrieveByValorAndSerolId($valor, $serolId);
          //$SerolValor = Doctrine::getTable("SerolValor")->findOneBy("valor", $valor);
          if(!$SerolValor)
          {
            die("inconscitencia de datos en la tabla donante_serol!!");
          }

          $serol = Doctrine::getTable("Serol")->findOneBy("id", $serolId);

          if(!$serol)
          {
            die("inconscitencia de datos en la tabla donante_serol!!");
          }
          $idPretrasplante = transplanteConvertorHandler::retrievePreTrasplanteId($username,$password, $database, $id);
          $trasplante = Doctrine::getTable("Trasplante")->findOneBy("paciente_pre_trasplante_id", $idPretrasplante);
          //$trasplante = Doctrine::getTable("Trasplante")->find($id);

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
          $idPretrasplante = transplanteConvertorHandler::retrievePreTrasplanteId($username,$password, $database, $id);
          $trasplante = Doctrine::getTable("Trasplante")->findOneBy("paciente_pre_trasplante_id", $idPretrasplante);
          $save = true;
          if(!$trasplante)
          {
            echo "El trasplante con id: ".$id." no existe en la base Inducciones incompleto para guardar\n";

            $save = false;
          }

          if($save)
          {
            $object = new TrasplanteInduccion();
            $object->setTrasplanteId($trasplante->getId());
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
          $idPretrasplante = transplanteConvertorHandler::retrievePreTrasplanteId($username,$password, $database, $id);
          $trasplante = Doctrine::getTable("Trasplante")->findOneBy("paciente_pre_trasplante_id", $idPretrasplante);

          $save = true;
          if(!$trasplante)
          {
            echo "El trasplante con id: ".$id." no existe en la base trasplante_inmunosupresores incompleto para guardar\n";

            $save = false;
          }

          if($save)
          {
            $object = new TrasplanteInmunosupresores();
            $object->setTrasplanteId($trasplante->getId());
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
  
  public static function retrievePreTrasplanteId($username,$password, $database, $oldTrasplanteId)
  {
    mysql_connect("localhost",$username,$password);

    @mysql_select_db($database) or die( "Unable to select database");
    mysql_query("set names 'utf8'"); 
    $query="SELECT PreTrasplante FROM trasplante WHERE id = ".$oldTrasplanteId;    
    $result=mysql_query($query);
    $num=mysql_numrows($result);
    mysql_close();    
    $i=0;
    $id = 0;
    while ($i < $num) {
        $id = mysql_result($result,$i,"PreTrasplante");
        $i++;
    }
    return $id;
    //SELECT `PreTrasplante` FROM `trasplante` WHERE `id` = 1
  }
  
  public static function saveAllTrasplanteReoperacion($username,$password, $database, $starting = 0, $quantity =0)
  {
      //return true;
      mysql_connect("localhost",$username,$password);

      @mysql_select_db($database) or die( "Unable to select database");
      mysql_query("set names 'utf8'");

      if($starting == 0 && $quantity == 0)
      {
        $query="SELECT * FROM trasplante_reoperacion";
      }
      else
      {
        $query="SELECT * FROM trasplante_reoperacion LIMIT ".$starting.", ".$quantity;
      }

      $result=mysql_query($query);
      $num=mysql_numrows($result);
      mysql_close();
      $i=0;
      //sfContext::getInstance()->getLogger()->err($num);
      while ($i < $num) {
        $id_trasplante = mysql_result($result,$i,"id_trasplante");
        $fecha = mysql_result($result,$i,"fecha");
        $descripcion = mysql_result($result,$i,"descripcion");
        $complicacionId = mysql_result($result,$i,"complicacion");
        //echo "El trasplante con id: ".$fecha."\n";
        $idPretrasplante = transplanteConvertorHandler::retrievePreTrasplanteId($username,$password, $database, $id_trasplante);
        $trasplante = Doctrine::getTable("Trasplante")->findOneBy("paciente_pre_trasplante_id", $idPretrasplante);

        $save = true;
        if(!$trasplante)
        {
          echo "El trasplante con id: ".$idPretrasplante." no existe en la base trasplante_reoperacion incompleto para guardar\n";

          $save = false;
        }
        $infecciosa = false;
        $complicacion = Doctrine::getTable("TrasplanteComplicacionesNoInfecciosas")->find($complicacionId);
        if(!$complicacion)
        {
          $complicacion = Doctrine::getTable("TrasplanteComplicacionesInfecciosas")->find($complicacionId);
          if(!$complicacion)
          {
            echo "El TrasplanteComplicaciones con id: ".$complicacionId." no existe en la base trasplante_reoperacion incompleto para guardar\n";
            $save = false;
          }
          else
          {
            $infecciosa = true;
          }
        }

        if($save)
        {
          $object = new TrasplanteReoperacion();
          $object->setTrasplanteId($trasplante->getId());
          $object->setFecha($fecha);
          $object->setDescripcion($descripcion);
          if($infecciosa)
          {
            $object->setTrasplanteComplicacionInfeccionId($complicacion->getId());
          }
          else
          {
            $object->setTrasplanteComplicacionNoInfeccionId($complicacion->getId());
          }
          $object->setEsInfecciosa($infecciosa);
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

  public static function saveAllTrasplanteInjertoEvolucion($username,$password, $database, $starting = 0, $quantity =0)
  {
      mysql_connect("localhost",$username,$password);

      @mysql_select_db($database) or die( "Unable to select database");
      mysql_query("set names 'utf8'");

      if($starting == 0 && $quantity == 0)
      {
        $query="SELECT * FROM injerto_evolucion";
      }
      else
      {
        $query="SELECT * FROM injerto_evolucion LIMIT ".$starting.", ".$quantity;
      }

      $result=mysql_query($query);
      $num=mysql_numrows($result);
      mysql_close();
      $i=0;
      //sfContext::getInstance()->getLogger()->err($num);
      while ($i < $num) {
        $PreTrasplante = mysql_result($result,$i,"PreTrasplante");
        $FECHA = mysql_result($result,$i,"FECHA");
        $TM = mysql_result($result,$i,"TM");
        $TM_CUAL = mysql_result($result,$i,"TM_CUAL");
        $GP_DE_NOVO = mysql_result($result,$i,"GP_DE_NOVO");
        $Recidiva_GP_DE_NOVO = mysql_result($result,$i,"Recidiva_GP_DE_NOVO");
        $RA = mysql_result($result,$i,"RA");
        $RC = mysql_result($result,$i,"RC");
        $tratamiento = mysql_result($result,$i,"tratamiento");
        $en_trasplante = mysql_result($result,$i,"trasplante");
                        
        $trasplante = Doctrine::getTable("Trasplante")->findOneBy("paciente_pre_trasplante_id", $PreTrasplante);

        $save = true;
        if(!$trasplante)
        {
          echo "El trasplante con id: ".$PreTrasplante." no existe en la base injerto_evolucion incompleto para guardar\n";

          $save = false;
        }

        $raTratamiento = Doctrine::getTable("Ratratamiento")->find($tratamiento);
        if(!$raTratamiento)
        {
          echo "El Ratratamiento con id: ".$tratamiento." no existe en la base injerto_evolucion incompleto para guardar\n";

          $save = false;
        }

        if($save)
        {
          $object = new InjertoEvolucion();
          $object->setTrasplanteId($trasplante->getId());
          $object->setFecha($FECHA);
          $object->setTm($TM);
          $object->setTmCual($TM_CUAL);
          $object->setGpDeNovo($GP_DE_NOVO);
          $object->setRecidivaGpDeNovo($Recidiva_GP_DE_NOVO);
          $object->setRa($RA);

          $object->setRc($RC);
          $object->setRaTratamientoId($raTratamiento->getId());
          $object->setEnTrasplante($en_trasplante);                    
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

  public static function saveAllTrasplanteInjertoEvolucionPbr($username,$password, $database, $starting = 0, $quantity =0)
  {
      mysql_connect("localhost",$username,$password);

      @mysql_select_db($database) or die( "Unable to select database");
      mysql_query("set names 'utf8'");

      if($starting == 0 && $quantity == 0)
      {
        $query="SELECT * FROM injerto_evolucion_pbr";
      }
      else
      {
        $query="SELECT * FROM injerto_evolucion_pbr LIMIT ".$starting.", ".$quantity;
      }

      $result=mysql_query($query);
      $num=mysql_numrows($result);
      mysql_close();
      $i=0;
      //sfContext::getInstance()->getLogger()->err($num);
      while ($i < $num) {
        $PreTrasplante = mysql_result($result,$i,"PreTrasplante");
        $FECHA = mysql_result($result,$i,"FECHA");
        $RESULTADO_PBR = mysql_result($result,$i,"RESULTADO_PBR");
                                
        $trasplante = Doctrine::getTable("Trasplante")->findOneBy("paciente_pre_trasplante_id", $PreTrasplante);

        $save = true;
        if(!$trasplante)
        {
          echo "El trasplante con id: ".$PreTrasplante." no existe en la base injerto_evolucion_pbr incompleto para guardar\n";

          $save = false;
        }

        if($save)
        {
            $InjertoEvolucion = Doctrine::getTable("InjertoEvolucion")->retrieveByTrasplanteIdAndDate($trasplante->getId(), $FECHA);
            
            if(!$InjertoEvolucion)
            {
              echo "El InjertoEvolucion con id: ".$trasplante->getId()." no existe en la base injerto_evolucion incompleto para guardar\n";

              $save = false;
            }
        }

        $ResultadoPbr = Doctrine::getTable("ResultadoPbr")->find($RESULTADO_PBR);

        if(!$ResultadoPbr)
        {
          echo "El ResultadoPbr con id: ".$ResultadoPbr." no existe en la base ResultadoPbr incompleto para guardar\n";

          $save = false;
        }

        if($save)
        {
          $object = new InjertoEvolucionPbr();
          $object->setInjertoEvolucionId($InjertoEvolucion->getId());
          $object->setResultadoPbrId($RESULTADO_PBR);
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
  
  public static function cargarEdadesDelReceptorEnTrasplante()
  {
    $trasplantesIds = trasplanteHandler::retriveAllTrasplantesId();
    foreach($trasplantesIds as $id)
    {
      $paciente = PacienteHandler::retrivePacienteByTrasplanteId($id[0], Doctrine::HYDRATE_ARRAY);
      $fecha_nacimiento = $paciente[0]['fecha_nacimiento'];
      
      $trasplante = Doctrine::getTable("Trasplante")->find($id[0]);
      $fecha = $trasplante->getFecha();
      $age = basicFunction::calculateDifferenceInYears($fecha_nacimiento, $fecha);
      $trasplante->setEdadReceptor($age);
      $trasplante->save();
      $trasplante->free(true);
    }
  }
  
  public static function cargarMesesEnListaPaciente()
  {
    $pacientePreTrasplantesIds = preTrasplanteHandler::retrieveAllPacientepreTrasplantesIds();
    foreach($pacientePreTrasplantesIds as $id)
    {
      $fecha = trasplanteHandler::retrieveTrasplanteFechaFromPreTrasplanteId($id[0]);
      $pacientePreTrasplante = Doctrine::getTable("Pacientepretrasplante")->find($id[0]);
      $return = basicFunction::calculateDifferenceInMonth($pacientePreTrasplante->getFechaIngresoLista(), $fecha[0][0]);
      if($return !== false)
      {
        $pacientePreTrasplante->setMesesEnLista($return);
        $pacientePreTrasplante->save();
      }
      else
      {
        echo "Fecha ingreso a la lista: ".$pacientePreTrasplante->getFechaIngresoLista()."\n";
        echo "Fecha del trasplante: ".$fecha[0][0]."\n";
        echo "Id del pretrasplantes: ".$id[0]."\n";
      }
    }

  }
  
  
}
