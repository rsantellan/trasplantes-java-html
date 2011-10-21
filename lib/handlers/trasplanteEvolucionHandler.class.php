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
    
  public static function retriveEvolucionTrasplanteCmv($trasplanteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("EvolucionTrasplanteCmv")->retrieveAll($trasplanteId, $hydrationMode);
  }
}

