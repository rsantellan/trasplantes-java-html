<?php

/**
 * manejadorEvoluciones actions.
 *
 * @package    transplantes
 * @subpackage manejadorEvoluciones
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class manejadorEvolucionesActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->trasplanteId = $request->getParameter('id');
    $this->forward404Unless($this->trasplanteId);
    
    $this->listEvolucionesCmv = trasplanteEvolucionHandler::retriveAllEvolucionTrasplanteCmv($this->trasplanteId);
    
    $this->listEvolucionesEcg = trasplanteEvolucionHandler::retriveAllEvolucionTrasplanteEcg($this->trasplanteId);
  }
}
