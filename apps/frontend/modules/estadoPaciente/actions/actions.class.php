<?php

/**
 * estadoPaciente actions.
 *
 * @package    transplantes
 * @subpackage estadoPaciente
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class estadoPacienteActions extends sfActions
{
 /**
  * Executes index action
  *
  * @param sfRequest $request A request object
  */
  public function executeEdit(sfWebRequest $request)
  {
    $this->id = $request->getParameter("id");
    $this->forward404Unless($this->id);
    $this->muerte = PacienteHandler::retrivePacienteMuerteByPacienteId($this->id, Doctrine_Core::HYDRATE_ARRAY); 
    $this->perdidas = PacienteHandler::retrivePacientePerdidasByPacienteId($this->id, Doctrine_Core::HYDRATE_ARRAY); 
    $this->cantidad_pre_trasplantes = preTrasplanteHandler::retrieveNumberPreTrasplantesOfPaciente($this->id);
  }
}
