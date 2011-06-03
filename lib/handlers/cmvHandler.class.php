<?php
/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of cmvHandler
 *
 * @author rodrigo
 */
class cmvHandler {
  
  public static function retrieveByTrasplanteIdAndDate($trasplanteId, $fecha)
  {
    return Doctrine::getTable("cmv")->retrieveByTrasplanteIdAndDate($trasplanteId, $fecha);
  }

}

