<?php

class pacientesMuerteConvertorHandler
{
  
  public static function saveAllPacientesCausaDeMuerte($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);
        
        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        
        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM paciente_causa_muerte";
        }
        else
        {
          $query="SELECT * FROM paciente_causa_muerte LIMIT ".$starting.", ".$quantity;
        }
        $result=mysql_query($query);

        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        while ($i < $num) {
          $id = mysql_result($result,$i,"ID");
          $DETALLES = mysql_result($result,$i,"DETALLES");
          
          echo 'Salvando la causa de muerte del paciente : '.$id. '---\n';
          echo '\n';
          $PacienteCausaMuerte = new PacienteCausaMuerte();
          $PacienteCausaMuerte->setId($id);
          $PacienteCausaMuerte->setNombre($DETALLES);
          $PacienteCausaMuerte->save();
          $PacienteCausaMuerte->free(true);
          $i++;
        }         
        
        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;
  }

  public static function saveAllPacientesMuertes($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);

        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        $query="SELECT * FROM paciente_muerte";
        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM paciente_muerte";
        }
        else
        {
          $query="SELECT * FROM paciente_muerte LIMIT ".$starting.", ".$quantity;
        }
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

          echo 'Salvando la causa de muerte del paciente : '.$THE. '---\n';
          echo '\n';
          $pacienteMuerte = new PacienteMuerte();
          $pacienteMuerte->setPacienteId($paciente->getId());
          $pacienteMuerte->setCausaMuerteId($CAUSA);
          $pacienteMuerte->setFechaMuerte($FECHA_MUERTE);
          $pacienteMuerte->setTransplanteFuncionando($TR_Funcionando);
          $pacienteMuerte->save();
          $pacienteMuerte->free(true);
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
