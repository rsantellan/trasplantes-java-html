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
  
  public static function retriveAllEvolucionTrasplanteNutricion($trasplanteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("EvolucionTrasplanteNutricion")->retrieveAll($trasplanteId, $hydrationMode);
  }
  
  public static function retriveEvolucionTrasplanteNutricion($evolucionNutricionId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("EvolucionTrasplanteNutricion")->retriveById($evolucionNutricionId, $hydrationMode);
  } 
  
  public static function retriveAllEvolucionTrasplanteParaclinicas($trasplanteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("EvolucionTrasplanteParaclinica")->retrieveAll($trasplanteId, $hydrationMode);
  }
  
  public static function retriveEvolucionTrasplanteParaclinicas($evolucionParaclinicaId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("EvolucionTrasplanteParaclinica")->retriveById($evolucionParaclinicaId, $hydrationMode);
  }
  
  public static function retriveAllEvolucionTrasplanteEcodopler($trasplanteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("EvolucionTrasplanteEcodopler")->retrieveAll($trasplanteId, $hydrationMode);
  }
  
  public static function retriveEvolucionTrasplanteEcodopler($evolucionEcodoplerId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("EvolucionTrasplanteEcodopler")->retriveById($evolucionEcodoplerId, $hydrationMode);
  }
  
  public static function retriveAllEvolucionTrasplanteEcografia($trasplanteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("EvolucionTrasplanteEcografia")->retrieveAll($trasplanteId, $hydrationMode);
  }
  
  public static function retriveEvolucionTrasplanteEcografia($evolucionEcografiaId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("EvolucionTrasplanteEcografia")->retriveById($evolucionEcografiaId, $hydrationMode);
  }
  
  public static function retriveAllEvolucionTrasplanteMarvirales($trasplanteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("EvolucionTrasplanteMarvirales")->retrieveAll($trasplanteId, $hydrationMode);
  }
  
  public static function retriveEvolucionTrasplanteMarvirales($evolucionMarviralId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("EvolucionTrasplanteMarvirales")->retriveById($evolucionMarviralId, $hydrationMode);
  }  
  
  public static function retriveAllEvolucionTrasplanteTxTorax($trasplanteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("EvolucionTrasplanteTxtorax")->retrieveAll($trasplanteId, $hydrationMode);
  }
  
  public static function retriveEvolucionTrasplanteTxTorax($evolucionTxToraxId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("EvolucionTrasplanteTxtorax")->retriveById($evolucionTxToraxId, $hydrationMode);
  } 
  
  public static function retriveAllEvolucionTrasplanteExamenes($trasplanteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("EvolucionTrasplanteExamenes")->retrieveAll($trasplanteId, $hydrationMode);
  }
  
  public static function retriveEvolucionTrasplanteExamenes($evolucionExamenId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("EvolucionTrasplanteExamenes")->retriveById($evolucionExamenId, $hydrationMode);
  } 
}

