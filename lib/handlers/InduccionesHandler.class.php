<?php

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of InmunoSupresoresHandler
 *
 * @author Rodrigo Santellan
 */
class InduccionesHandler {
  
  
  /**
   * Obtiene todos los inmunosupresores
   * @param type $hydrationMode
   * @return type 
   */
  public static function retrieveAll($hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("Induccion")->retrieveAll($hydrationMode);
  }
  
}


