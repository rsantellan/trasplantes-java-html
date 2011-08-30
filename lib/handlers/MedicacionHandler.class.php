<?php

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of MedicacionHandler
 *
 * @author Rodrigo Santellan
 */
class MedicacionHandler {
  
  public static function retrieveAllMedicaciones($hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
	return Doctrine::getTable("Medicaciones")->retrieveAll($hydrationMode);
  }
  
  public static function retrieveById($id, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
	return Doctrine::getTable("Medicaciones")->retriveById($id, $hydrationMode);
  }
}


