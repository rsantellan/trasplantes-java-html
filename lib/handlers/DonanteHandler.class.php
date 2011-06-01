<?php
/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of PacienteMuertehandler
 *
 * @author rodrigo
 */
class Donantehandler {


  public static function retrieveById($id, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("Donante")->retriveById($id, $hydrationMode);
  }
  
  public static function retrieveCausaMuerteDonanteById($id, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("DonanteCausaMuerte")->retriveById($id, $hydrationMode);
  }  
}

