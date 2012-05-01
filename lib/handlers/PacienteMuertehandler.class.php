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


	public static function retrieveAll(){
		return Doctrine_Core::getTable('PacienteCausaMuerte')
      ->createQuery('a')
      ->execute();
	}
	
  public static function retrieveCausaById($pacienteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("PacienteCausaMuerte")->retriveById($pacienteId, $hydrationMode);
  }
  
  public static function retrieveByPacienteId($pacienteId)
  {
    return Doctrine::getTable("PacienteMuerte")->retriveByPacienteId($pacienteId);
  }
}

