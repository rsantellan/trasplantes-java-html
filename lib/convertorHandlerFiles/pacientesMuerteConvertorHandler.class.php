<?php

class pacientesMuerteConvertorHandler
{
  
  public static function saveAllPacientesCausaDeMuerte($username,$password, $database)
  {
        mysql_connect("localhost",$username,$password);
        
        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        $query="SELECT * FROM paciente_causa_muerte";
        $result=mysql_query($query);

        $num=mysql_numrows($result);
        $i=0;
        while ($i < $num) {
          $id = mysql_result($result,$i,"ID");
          $DETALLES = mysql_result($result,$i,"DETALLES");
          $PacienteCausaMuerte = new PacienteCausaMuerte();
          $PacienteCausaMuerte->setId($id);
          $PacienteCausaMuerte->setNombre($DETALLES);
          $PacienteCausaMuerte->save();
          $i++;
        }         
        mysql_close();
  }

  public static function saveAllPacientesMuertes($username,$password, $database)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        $query="SELECT * FROM paciente_muerte";
        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        while ($i < $num) {
          $THE = mysql_result($result,$i,"THE");
          $CAUSA = mysql_result($result,$i,"CAUSA");
          $FECHA_MUERTE = mysql_result($result,$i,"FECHA_MUERTE");
          $TR_Funcionando = mysql_result($result,$i,"TR_Funcionando");

          $paciente = Doctrine::getTable("Pacientes")->findOneBy("the", $THE);
          if(!$paciente)
          {
            die("inconscitencia de datos!!");
          }

          $pacienteMuerte = new PacienteMuerte();
          $pacienteMuerte->setPacienteId($paciente->getId());
          $pacienteMuerte->setCausaMuerteId($CAUSA);
          $pacienteMuerte->setFechaMuerte($FECHA_MUERTE);
          $pacienteMuerte->setTransplanteFuncionando($TR_Funcionando);
          $pacienteMuerte->save();
          $i++;
        }
        
  }
  
}
