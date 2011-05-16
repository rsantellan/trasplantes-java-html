<?php

class complicacionHandler
{
  
  public static function saveAllComplicacionesTipo($username,$password, $database, $starting = 0, $quantity =0)
  {
        self::saveAllComplicacionesTipoSimple($username,$password, $database, $starting, $quantity);
        mysql_connect("localhost",$username,$password);
        
        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        //$query="SELECT * FROM serol";
        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM complicaciones_tipos";
        }
        else
        {
          $query="SELECT * FROM complicaciones_tipos LIMIT ".$starting.", ".$quantity;
        }
        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        while ($i < $num) {
          $id = mysql_result($result,$i,"id");
          $tipo = mysql_result($result,$i,"TIPO");
          $name = mysql_result($result,$i,"NOMBRE");
          $ComplicacionesTipos = Doctrine::getTable("ComplicacionesTipos")->findOneBy("nombre", $tipo);
          $ComplicacionesTiposValores = new ComplicacionesTiposValores();
          $ComplicacionesTiposValores->setNombre($name);
          $ComplicacionesTiposValores->setComplicacionTipoId($ComplicacionesTipos->getId());
          $ComplicacionesTiposValores->save();
          $ComplicacionesTipos->free(true);
          $ComplicacionesTiposValores->free(true);
          $i++;
        }
        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }
  
  public static function saveAllComplicacionesTipoSimple($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);
        
        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        //$query="SELECT * FROM serol";
        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM complicaciones_tipos";
        }
        else
        {
          $query="SELECT * FROM complicaciones_tipos LIMIT ".$starting.", ".$quantity;
        }
        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        while ($i < $num) {
          $id = mysql_result($result,$i,"id");
          $tipo = mysql_result($result,$i,"TIPO");
          $name = mysql_result($result,$i,"NOMBRE");
          
          $ComplicacionesTipos = Doctrine::getTable("ComplicacionesTipos")->findOneBy("nombre", $tipo);
          if(!$ComplicacionesTipos)
          {
              $ComplicacionesTipos = new ComplicacionesTipos();
              $ComplicacionesTipos->setNombre($tipo);
              $ComplicacionesTipos->save();
              $ComplicacionesTipos = Doctrine::getTable("ComplicacionesTipos")->findOneBy("nombre", $tipo);
          }
          $ComplicacionesTipos->free(true);
          $i++;
        }
        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }
  public static function saveAllMedicaciones($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);
        
        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM medicaciones";
        }
        else
        {
          $query="SELECT * FROM medicaciones LIMIT ".$starting.", ".$quantity;
        }
        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        while ($i < $num) {
          $id = mysql_result($result,$i,"ID");
          $name = mysql_result($result,$i,"NOMBRE");
          
          $Medicaciones = new Medicaciones();
          $Medicaciones->setId($id);
          $Medicaciones->setNombre($name);
          $Medicaciones->save();
          $Medicaciones->free(true);
          $i++;
        }         
        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }

  public static function saveAllTrasplantesComplicaciones($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);
        
        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM trasplante_complicaciones";
        }
        else
        {
          $query="SELECT * FROM trasplante_complicaciones LIMIT ".$starting.", ".$quantity;
        }
        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        while ($i < $num) {
          $id = mysql_result($result,$i,"ID");
          $IdPreTrasplante = mysql_result($result,$i,"IdPreTrasplante");
          $FECHA = mysql_result($result,$i,"FECHA");
          $MEDICACION = mysql_result($result,$i,"MEDICACION");
          $INTERNADO = mysql_result($result,$i,"INTERNADO");
          $DIAS_DE_INTERNACION = mysql_result($result,$i,"DIAS_DE_INTERNACION");
          $EVOLUCION = mysql_result($result,$i,"EVOLUCION");
          $COMENTARIO = mysql_result($result,$i,"COMENTARIO");

                    
          $trasplante = Doctrine::getTable("Trasplante")->findOneBy("paciente_pre_trasplante_id", $IdPreTrasplante);
          if($trasplante)
          {
            $TrasplanteComplicaciones = new TrasplanteComplicaciones();
            $TrasplanteComplicaciones->setId($id);
            $TrasplanteComplicaciones->setTrasplanteId($trasplante->getId());
            $TrasplanteComplicaciones->setFecha($FECHA);
            $TrasplanteComplicaciones->setMedicacionId($MEDICACION);
            $TrasplanteComplicaciones->setInternado($INTERNADO);
            $TrasplanteComplicaciones->setDiasDeInternacion($DIAS_DE_INTERNACION);
            $TrasplanteComplicaciones->setEvolucion($EVOLUCION);
            $TrasplanteComplicaciones->setComentario($COMENTARIO);
            $TrasplanteComplicaciones->save();
            $TrasplanteComplicaciones->free(true);            
          }
          else
          {
            echo "No se encontro ningun trasplante con id: ".$IdPreTrasplante."\n";
          }
          

          $i++;
        }         
        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }

  public static function retrieveNewComplicacionTipoValorOfOldId($username,$password, $database, $oldId)
  {
        mysql_connect("localhost",$username,$password);
        
        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        $query="SELECT * FROM complicaciones_tipos where id = ".$oldId;
        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;   
        while ($i < $num) {
          $id = mysql_result($result,$i,"id");
          $tipo = mysql_result($result,$i,"TIPO");
          $name = mysql_result($result,$i,"NOMBRE");
          $ComplicacionesTipos = Doctrine::getTable("ComplicacionesTipos")->findOneBy("nombre", $tipo);
          $complicacionesTiposValor = Doctrine::getTable("ComplicacionesTiposValores")->retrieveOneByComplicacionTipoIdAndName($ComplicacionesTipos->getId(), $name);
          return $complicacionesTiposValor;
          $i++;
        } 
        return null;
  }

  public static function saveAllComplicacionesNoInfecciosas($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);
        
        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM complicaciones_no_inf";
        }
        else
        {
          $query="SELECT * FROM complicaciones_no_inf LIMIT ".$starting.", ".$quantity;
        }
        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        while ($i < $num) {
          $id = mysql_result($result,$i,"ID_TR_COMPLICACION");
          $complicacion = mysql_result($result,$i,"ID_COMPLICACION");
          $TrasplanteComplicaciones = Doctrine::getTable("TrasplanteComplicaciones")->find($id);
          $complicacionValor = self::retrieveNewComplicacionTipoValorOfOldId($username,$password, $database,$complicacion);//Doctrine::getTable("ComplicacionesTiposValores")->find($complicacion);
          if($TrasplanteComplicaciones && $complicacionValor)
          {
              $ComplicacionesNoInfecciosas = new ComplicacionesNoInfecciosas();
              $ComplicacionesNoInfecciosas->setTrComplicacionId($TrasplanteComplicaciones->getId());
              $ComplicacionesNoInfecciosas->setComplicacionValorId($complicacionValor->getId());
              $ComplicacionesNoInfecciosas->save();
              $ComplicacionesNoInfecciosas->free(true);
              $TrasplanteComplicaciones->free(true);
              $complicacionValor->free(true);
          }
          else
          {
            echo $id;
            echo "\n";            
            if(!$TrasplanteComplicaciones)
            {
              echo "Existe un complicaciones_no_inf sin TrasplanteComplicaciones asociado";
              echo " TrasplanteComplicaciones supuesto id: ".$id." ";
              echo "\n";               
            }
            if(!$complicacionValor)
            {
              echo "Existe un complicaciones_no_inf sin complicacionValor asociado";
              echo " complicacionValor supuesto id: ".$complicacion." ";
              echo "\n";              
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

  public static function saveAllInfeccion($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);
        
        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM infeccion";
        }
        else
        {
          $query="SELECT * FROM infeccion LIMIT ".$starting.", ".$quantity;
        }
        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        while ($i < $num) {
          $id = mysql_result($result,$i,"ID");
          $name = mysql_result($result,$i,"NOMBRE");
          
          $object = new Infeccion();
          $object->setId($id);
          $object->setNombre($name);
          $object->save();
          $object->free(true);
          $i++;
        }         
        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }
  
  public static function saveAllGermenes($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);
        
        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM germenes";
        }
        else
        {
          $query="SELECT * FROM germenes LIMIT ".$starting.", ".$quantity;
        }
        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        while ($i < $num) {
          $id = mysql_result($result,$i,"ID");
          $name = mysql_result($result,$i,"NOMBRE");
          
          $object = new Germenes();
          $object->setId($id);
          $object->setNombre($name);
          $object->save();
          $object->free(true);
          $i++;
        }         
        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }

  public static function saveAllComplicacionesInfecciosas($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);
        
        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM complicaciones_inf";
        }
        else
        {
          $query="SELECT * FROM complicaciones_inf LIMIT ".$starting.", ".$quantity;
        }
        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        while ($i < $num) {
          $id = mysql_result($result,$i,"ID_TR_COMPLICACION");
          $INFECCIONID = mysql_result($result,$i,"INFECCION");
          $GERMENID = mysql_result($result,$i,"GERMEN");
          $TrasplanteComplicaciones = Doctrine::getTable("TrasplanteComplicaciones")->find($id);
          $infeccion = Doctrine::getTable("Infeccion")->find($INFECCIONID);
          $germen = Doctrine::getTable("Germenes")->find($GERMENID);

          if($TrasplanteComplicaciones && $infeccion && $germen)
          {
              $ComplicacionesInfecciosas = new ComplicacionesInfecciosas();
              $ComplicacionesInfecciosas->setTrComplicacionId($TrasplanteComplicaciones->getId());
              $ComplicacionesInfecciosas->setInfeccionId($infeccion->getId());
              $ComplicacionesInfecciosas->setGermenId($germen->getId());
              $ComplicacionesInfecciosas->save();
              $ComplicacionesInfecciosas->free(true);
              $TrasplanteComplicaciones->free(true);
              $infeccion->free(true);
              $germen->free(true);
          }
          else
          {
            echo $id;
            echo "\n";            
            if(!$TrasplanteComplicaciones)
            {
              echo "Existe un complicaciones_inf sin TrasplanteComplicaciones asociado";
              echo " TrasplanteComplicaciones supuesto id: ".$id." ";
              echo "\n";               
            }
            if(!$infeccion)
            {
              echo "Existe un complicaciones_inf sin INFECCION asociado";
              echo " INFECCION supuesto id: ".$INFECCION." ";
              echo "\n";              
            }
            if(!$germen)
            {
              echo "Existe un complicaciones_inf sin GERMEN asociado";
              echo " GERMEN supuesto id: ".$GERMENID." ";
              echo "\n";              
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
