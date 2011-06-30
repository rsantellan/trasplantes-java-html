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
  
    /**
   * Obtiene todos los donantes
   * @param Doctrine_Core $hydrationMode
   * @return Depende del tipo de hidratacion
   */
  public static function retrieveAll($hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
	return Doctrine::getTable("Donante")->retrieveAll($hydrationMode);
  }
  
  /**
   * Obtiene todas las causas de muertes de donantes
   * @param Doctrine_Core $hydrationMode
   * @return Depende del tipo de hidratacion
   */
  public static function retrieveAllCausaMuerte($hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
	return Doctrine::getTable("DonanteCausaMuerte")->retrieveAll($hydrationMode);
  }
  
  /**
   * Obtiene todas las causas de muertes de donantes
   * @param Doctrine_Core $hydrationMode
   * @return Depende del tipo de hidratacion
   */
  public static function retrieveAllOrganos($hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
	return Doctrine::getTable("Organos")->retrieveAll($hydrationMode);
  }
  
  
}

