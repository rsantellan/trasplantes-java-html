<?php

class pacientesConvertorHandler
{
  
  public static function saveAllPacientes($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);
        
        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        $query="SELECT * FROM pacientes";
        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM pacientes";
        }
        else
        {
          $query="SELECT * FROM pacientes LIMIT ".$starting.", ".$quantity;
        }
        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        while ($i < $num) {
          $THE = mysql_result($result,$i,"THE");
          $CI = mysql_result($result,$i,"CI");
          $NOMBRE = mysql_result($result,$i,"NOMBRE");
          $APELLIDO = mysql_result($result,$i,"APELLIDO");
          $NUM_FNR = mysql_result($result,$i,"NUM_FNR");
          $RAZA = mysql_result($result,$i,"RAZA");
          $SEXO = mysql_result($result,$i,"SEXO");
          $FECHA_NACIMIENTO = mysql_result($result,$i,"FECHA_NACIMIENTO");
          $FECHA_DIALISIS = mysql_result($result,$i,"FECHA_DIALISIS");
          $NEFROPATIA = mysql_result($result,$i,"NEFROPATIA");
          $GRUPO_SANG = mysql_result($result,$i,"GRUPO_SANG");

          $paciente = new Pacientes();
          $paciente->setThe($THE);
          $paciente->setCi($CI);
          $paciente->setNombre($NOMBRE);
          $paciente->setApellido($APELLIDO);
          $paciente->setNumFnr($NUM_FNR);
          $paciente->setRaza($RAZA);
          $paciente->setFechaNacimiento($FECHA_NACIMIENTO);
          $paciente->setFechaDialisis($FECHA_DIALISIS);
          $paciente->setNefropatiaId($NEFROPATIA);
          $paciente->setGrupoSanguineo($GRUPO_SANG);
          $paciente->setSexo($SEXO);
          $paciente->save();
          $paciente->free(true);
          $i++;
        }         
        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }

  public static function saveAllPacientesPreTransplantes($username,$password, $database, $starting = 0, $quantity =0, $log = false)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        $query="SELECT * FROM pacientepretrasplante";
        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM pacientepretrasplante";
        }
        else
        {
          $query="SELECT * FROM pacientepretrasplante LIMIT ".$starting.", ".$quantity;
        }
        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;

        if($log)
        {
          $echo =  "En caso de Modalidad D nula se pondra HD";
          //sfContext::getInstance()->getLogger()->err($echo);
          $echo =  "En caso de IMC nula se pondra entre 20 y 25";
          //sfContext::getInstance()->getLogger()->err($echo);
        }

        while ($i < $num) {
          $ID = mysql_result($result,$i,"ID");
          $THE = mysql_result($result,$i,"THE");
          $FECHA_INGRESO_LISTA = mysql_result($result,$i,"FECHA_INGRESO_LISTA");
          $FECHA_EGRESO = mysql_result($result,$i,"FECHA_EGRESO");
          $MODALIDAD_D = mysql_result($result,$i,"MODALIDAD_D");
          $DIABETES = mysql_result($result,$i,"DIABETES");
          $HTA = mysql_result($result,$i,"HTA");
          $OBESIDAD = mysql_result($result,$i,"OBESIDAD");
          $IMC = mysql_result($result,$i,"IMC");
          $DISLIPEMIA = mysql_result($result,$i,"DISLIPEMIA");
          $TABAQUISMO = mysql_result($result,$i,"TABAQUISMO");
          $ORIGEN = mysql_result($result,$i,"ORIGEN");
          $IAM = mysql_result($result,$i,"IAM");
          $AVE = mysql_result($result,$i,"AVE");
          $REVASC_CARDIO = mysql_result($result,$i,"REVASC_CARDIO");

          $paciente = Doctrine::getTable("Pacientes")->findOneBy("the", $THE);
          if(!$paciente)
          {
            die("inconscitencia de datos en la tabla pacientes!!");
          }
          if($MODALIDAD_D == "null")
          {
            if($log)
            {
              $echo =  "Modalidad D del pretransplante es nula: ";
              //sfContext::getInstance()->getLogger()->err($echo);
              $echo =  "Paciente THE: ".$ID." ";
              //sfContext::getInstance()->getLogger()->err($echo);
              $MODALIDAD_D = "HD";
            }

          }

          if($IMC == "null")
          {
            if($log)
            {
              $echo =  "IMC del pretransplante es nula: ";
              //sfContext::getInstance()->getLogger()->err($echo);
              $echo =  "Paciente THE: ".$ID." ";
              //sfContext::getInstance()->getLogger()->err($echo);
            }

            $IMC = "entre 20 y 25";            
          }          
          
          $preTransplante = new Pacientepretrasplante();
          $preTransplante->setId($ID);
          $preTransplante->setThe($ID);
          $preTransplante->setPacienteId($paciente->getId());
          $preTransplante->setFechaIngresoLista($FECHA_INGRESO_LISTA);
          $preTransplante->setFechaEgreso($FECHA_EGRESO);
          $preTransplante->setModalidadD($MODALIDAD_D);
          $preTransplante->setDiabetes($DIABETES);
          $preTransplante->setHta($HTA);
          $preTransplante->setObesidad($OBESIDAD);
          $preTransplante->setImc($IMC);
          $preTransplante->setDislipemia($DISLIPEMIA);
          $preTransplante->setTabaquismo($TABAQUISMO);
          $preTransplante->setOrigen($ORIGEN);
          $preTransplante->setIam($IAM);
          $preTransplante->setAve($AVE);
          $preTransplante->setRevascCardio($REVASC_CARDIO);

          $preTransplante->save();
          $preTransplante->free(true);
          $paciente->free(true);
          $i++;
        }
        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }
  
}
