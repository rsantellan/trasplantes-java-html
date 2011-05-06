<?php

class nefropatiasConvertorHandler
{
  
  public static function saveAllNefropatias($username,$password, $database)
  {
        mysql_connect("localhost",$username,$password);
        
        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        $query="SELECT * FROM nefropatia";
        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        while ($i < $num) {
          $id = mysql_result($result,$i,"ID");
          $name = mysql_result($result,$i,"NEFROPATIA");
          $Nefropatia = new Nefropatia();
          $Nefropatia->setId($id);
          $Nefropatia->setNombre($name);
          $Nefropatia->save();
          $i++;
        }         

  }
  
}
