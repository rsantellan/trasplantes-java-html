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
	return Doctrine::getTable("TrasplanteComplicacionesNoInfecciosas")->retrieveAllComplicacionesNoInfecciosas($trasplanteId, $enEvolucion, $isQuery, $hydrationMode );
  }

  public static function retrieveAllComplicacionesInfecciosas($trasplanteId, $enEvolucion, $isQuery = false, $hydrationMode = Doctrine_Core::HYDRATE_RECORD )
  {
	return Doctrine::getTable("TrasplanteComplicacionesInfecciosas")->retrieveAllComplicacionesInfecciosas($trasplanteId, $enEvolucion, $isQuery, $hydrationMode );
  }
  
  public static function retrieveComplicacionNoInfecciosa($id, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
	return Doctrine::getTable("TrasplanteComplicacionesNoInfecciosas")->retrieveComplicacionNoInfecciosa($id, $hydrationMode);
  }

  public static function retrieveComplicacionInfecciosa($id, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
	return Doctrine::getTable("TrasplanteComplicacionesInfecciosas")->retriveById($id, $hydrationMode);
  }
    
  public static function retrieveAllComplicacionesTipo($hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
	return Doctrine::getTable("ComplicacionesTipos")->retrieveAll($hydrationMode);
  }
  
  public static function retrieveComplicacionesTipoById($id, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
	return Doctrine::getTable("ComplicacionesTipos")->retriveById($id, $hydrationMode);
  }
  
  public static function retrieveAllComplicacionesTipoValor($hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
	return Doctrine::getTable("ComplicacionesTiposValores")->retrieveAll($hydrationMode);
  }
  
  public static function retrieveComplicacionesValorTipoById($id, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
	return Doctrine::getTable("ComplicacionesTiposValores")->retriveById($id, $hydrationMode);
  }  
  
  public static function retrieveAllInfecciones($hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
	return Doctrine::getTable("Infeccion")->retrieveAll($hydrationMode);
  }
  
  public static function retrieveInfeccionById($id, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
	return Doctrine::getTable("Infeccion")->retriveById($id, $hydrationMode);
  } 

  public static function retrieveAllGermenes($hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
	return Doctrine::getTable("Germenes")->retrieveAll($hydrationMode);
  }
  
  public static function retrieveGermenById($id, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
	return Doctrine::getTable("Germenes")->retriveById($id, $hydrationMode);
  }
  
}

