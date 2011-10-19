<?php

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of tratamientoHandler
 *
 * @author Rodrigo Santellan
 */
class tratamientoHandler {
    
  public static function retriveAllTratamientosOfPaciente($pacienteId , $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
      return Doctrine::getTable("Tratamiento")->retriveAllTratamientosOfPaciente($pacienteId , $hydrationMode);
  }
  
  public static function retriveById($tratamientoId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
    return Doctrine::getTable("Tratamiento")->retriveById($tratamientoId, $hydrationMode);
  }  
}

