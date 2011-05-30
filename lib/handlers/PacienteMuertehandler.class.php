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
class PacienteMuertehandler {


  public static function retrieveCausaById($pacienteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("PacienteCausaMuerte")->retriveById($pacienteId, $hydrationMode);
  }
}

