<?php

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of complicacionesHandler
 *
 * @author Rodrigo Santellan
 */
class complicacionesHandler {
  
  public static function retrieveAllComplicacionesNoInfecciosas($trasplanteId, $enEvolucion, $isQuery = false, $hydrationMode = Doctrine_Core::HYDRATE_RECORD )
  {
	return Doctrine::getTable("TrasplanteComplicaciones")->retrieveAllComplicacionesNoInfecciosas($trasplanteId, $enEvolucion, $isQuery, $hydrationMode );
  }
  
}

