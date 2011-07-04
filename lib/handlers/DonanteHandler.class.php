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
   * Obtiene todos los organos disponibles para los donantes
   * @param Doctrine_Core $hydrationMode
   * @return Depende del tipo de hidratacion
   */
  public static function retrieveAllOrganos($hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("Organos")->retrieveAll($hydrationMode);
  }
  
  /**
   * Obtiene todos los antecedentes disponibles para los donantes
   * @param Doctrine_Core $hydrationMode
   * @return Depende del tipo de hidratacion
   */
  public static function retrieveAllAntecedentes($hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("AntecedentesDeDonante")->retrieveAll($hydrationMode);
  }
  
  public static function saveSerolesOfDonante($donanteId, $seroles_valores_id_list)
  {
    //Borro todos los seroles que ya existian.
    $antiguos = self::retrieveAllSerolesOfDonante($donanteId);
    foreach($antiguos as $donante_serol)
    {
      $donante_serol->delete();
    }
    
    // Ahora agrego los nuevos.
    foreach($seroles_valores_id_list as $seroles_valores_id)
    {
      $serolValor = serolHandler::retrieveSerolValor($seroles_valores_id);
      $DonanteSerol = new DonanteSerol();
      $DonanteSerol->setDonanteId($donanteId);
      $DonanteSerol->setSerolId($serolValor->getSerolId());
      $DonanteSerol->setSerolValorId($serolValor->getId());
      $DonanteSerol->save();
    }
  }
  
  public static function retrieveAllSerolesOfDonante($donanteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("DonanteSerol")->retrieveAllSeroles($donanteId, $hydrationMode);
  }
    
}

