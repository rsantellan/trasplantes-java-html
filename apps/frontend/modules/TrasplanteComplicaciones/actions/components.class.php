<?php

class TrasplanteComplicacionesComponents extends sfComponents 
{

  public function executeComplicacionesBox(sfWebRequest $request) {
      $this->complicaciones_no_infecciosas_trasplante = complicacionesHandler::retrieveAllComplicacionesNoInfecciosas($this->id, false, false, Doctrine_Core::HYDRATE_ARRAY);
	  $this->complicaciones_infecciosas_trasplante = complicacionesHandler::retrieveAllComplicacionesInfecciosas($this->id, false, false, Doctrine_Core::HYDRATE_ARRAY);
	  $this->complicaciones_no_infecciosas_evolucion = complicacionesHandler::retrieveAllComplicacionesNoInfecciosas($this->id, true, false, Doctrine_Core::HYDRATE_ARRAY);
	  $this->complicaciones_infecciosas_evolucion = complicacionesHandler::retrieveAllComplicacionesInfecciosas($this->id, true, false, Doctrine_Core::HYDRATE_ARRAY);

  }
  
}
