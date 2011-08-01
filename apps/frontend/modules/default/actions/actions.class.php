<?php

/**
 * default actions.
 *
 * @package    default
 * @subpackage default
 * @author     Your name here
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class defaultActions extends sfActions
{

    public function executeIndex(sfWebRequest $request)
    {
        /*mysql_connect("localhost","root","root");
        
        @mysql_select_db("trasplante") or die( "Unable to select database");
        mysql_query("set names 'utf8'");
        
        $query= "SELECT t.*, ci.INFECCION, ci.GERMEN FROM trasplante_complicaciones t, complicaciones_inf ci where t.id = ci.ID_TR_COMPLICACION";
        $result=mysql_query($query);
        $num=mysql_numrows($result);
        mysql_close();
        $i=0;
        while ($i < $num) {
          var_dump(mysql_fetch_array($result));
          die;
          $i++;
        }*/
        
    }  
    
    public function executeError404(sfWebRequest $request)
    {
        
    }      
}
