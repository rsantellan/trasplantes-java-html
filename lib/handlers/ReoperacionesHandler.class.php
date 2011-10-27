<?php

/**
 * Description of ReoperacionesHandler
 *
 * @author Rodrigo Santellan
 */
class ReoperacionesHandler {
  
  public static function retrieveReoperacionesFromTrasplante($trasplanteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
  {
	return Doctrine::getTable("TrasplanteReoperacion")->retrieveReoperacionesFromTrasplante($trasplanteId, $hydrationMode);
  }
}
