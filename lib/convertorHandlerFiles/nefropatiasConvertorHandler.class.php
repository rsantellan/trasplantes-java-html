<?php

class nefropatiasConvertorHandler
{
  
  public static function saveAllNefropatias($username,$password, $database, $starting = 0, $quantity =0)
  {
        mysql_connect("localhost",$username,$password);
        
        @mysql_select_db($database) or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        
        if($starting == 0 && $quantity == 0)
        {
          $query="SELECT * FROM nefropatia";
        }
        else
        {
          $query="SELECT * FROM nefropatia LIMIT ".$starting.", ".$quantity;
        }
        
        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        //sfContext::getInstance()->getLogger()->err($num);
        while ($i < $num) {
          $id = mysql_result($result,$i,"ID");
          $name = mysql_result($result,$i,"NEFROPATIA");
          $Nefropatia = new Nefropatia();
          $Nefropatia->setId($id);
          $Nefropatia->setNombre($name);
          $Nefropatia->save();
          $i++;
          $Nefropatia->free(true);
        }

        if($num == 0 || $num == "0")
        {
          return 0;
        }
        return 1;

  }
  
}
