<?php

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of trasplanteEvolucionHandler
 *
 * @author Rodrigo Santellan
 */
class trasplanteEvolucionHandler {
    
  public static function retriveAllEvolucionTrasplanteCmv($trasplanteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("EvolucionTrasplanteCmv")->retrieveAll($trasplanteId, $hydrationMode);
  }
  
  public static function retriveEvolucionTrasplanteCmv($evolucionCmvId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("EvolucionTrasplanteCmv")->retriveById($evolucionCmvId, $hydrationMode);
  }
  
  public static function retriveAllEvolucionTrasplanteEcg($trasplanteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("EvolucionTrasplanteEcg")->retrieveAll($trasplanteId, $hydrationMode);
  }
  
  public static function retriveEvolucionTrasplanteEcg($evolucionEcgId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("EvolucionTrasplanteEcg")->retriveById($evolucionEcgId, $hydrationMode);
  }
  
  public static function retriveAllEvolucionTrasplanteEcocardio($trasplanteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("EvolucionTrasplanteEcoCardio")->retrieveAll($trasplanteId, $hydrationMode);
  }
  
  public static function retriveEvolucionTrasplanteEcocardio($evolucionEcoCardioId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("EvolucionTrasplanteEcoCardio")->retriveById($evolucionEcoCardioId, $hydrationMode);
  }  
}

