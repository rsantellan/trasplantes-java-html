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
class InmunoSupresoresHandler {
  
  
  /**
   * Obtiene todos los inmunosupresores
   * @param type $hydrationMode
   * @return type 
   */
  public static function retrieveAll($hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("Inmunosupresores")->retrieveAll($hydrationMode);
  }
  
}


