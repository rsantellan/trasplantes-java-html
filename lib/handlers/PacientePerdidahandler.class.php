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
class PacientePerdidahandler 
{
  
  public static function retrieveCausaById($pacienteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("PacienteCausaPerdidaInjerto")->retriveById($pacienteId, $hydrationMode);
  }
}
