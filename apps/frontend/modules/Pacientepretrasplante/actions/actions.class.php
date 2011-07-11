<?php

/**
 * Pacientepretrasplante actions.
 *
 * @package    transplantes
 * @subpackage Pacientepretrasplante
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class PacientepretrasplanteActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->pacientepretrasplantes = Doctrine_Core::getTable('Pacientepretrasplante')
      ->createQuery('a')
      ->execute();
  }

  public function executeShow(sfWebRequest $request)
  {
    $this->pacientepretrasplante = Doctrine_Core::getTable('Pacientepretrasplante')->find(array($request->getParameter('id')));
    $this->forward404Unless($this->pacientepretrasplante);
  }

  public function executeNew(sfWebRequest $request)
  {
	$paciente_id = $request->getParameter('paciente_id');
	$pacientePreTrasplante = new Pacientepretrasplante();
	$pacientePreTrasplante->setPacienteId($paciente_id);
    $this->form = new PacientepretrasplanteForm($pacientePreTrasplante);
  }

  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new PacientepretrasplanteForm();

    $return = $this->processForm($request, $this->form);
    if(count($return) != 0)
    {
      sfContext::getInstance()->getConfiguration()->loadHelpers(array('Url'));
      $this->redirect(url_for("@mostrarPaciente?id=".$return["paciente_id"]));
    }
    $this->setTemplate('new');
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($pacientepretrasplante = Doctrine_Core::getTable('Pacientepretrasplante')->find(array($request->getParameter('id'))), sprintf('Object pacientepretrasplante does not exist (%s).', $request->getParameter('id')));
    $this->form = new PacientepretrasplanteForm($pacientepretrasplante);
  }

  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($pacientepretrasplante = Doctrine_Core::getTable('Pacientepretrasplante')->find(array($request->getParameter('id'))), sprintf('Object pacientepretrasplante does not exist (%s).', $request->getParameter('id')));
    $this->form = new PacientepretrasplanteForm($pacientepretrasplante);

    $return = $this->processForm($request, $this->form);
    if(count($return) != 0)
    {
      sfContext::getInstance()->getConfiguration()->loadHelpers(array('Url'));
      $this->redirect(url_for("@mostrarPaciente?id=".$return["paciente_id"]));
    }
    $this->setTemplate('edit');
  }

  public function executeDelete(sfWebRequest $request)
  {
    $request->checkCSRFProtection();

    $this->forward404Unless($pacientepretrasplante = Doctrine_Core::getTable('Pacientepretrasplante')->find(array($request->getParameter('id'))), sprintf('Object pacientepretrasplante does not exist (%s).', $request->getParameter('id')));
    $pacientepretrasplante->delete();

    $this->redirect('Pacientepretrasplante/index');
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
	$return = array();
    if ($form->isValid())
    {
      $pacientepretrasplante = $form->save();

	  $this->refresCache($pacientepretrasplante->getId(), $pacientepretrasplante->getPacienteId()); 
	  
	  $return["id"] = $pacientepretrasplante->getId();
	  $return["paciente_id"] = $pacientepretrasplante->getPacienteId();
	  return $return;
    }
	return $return;
  }
  
  protected function refresCache($preTrasplanteId, $pacienteId)
  {
	$cacheManager = $this->getContext()->getViewCacheManager();
	if($cacheManager)
	{
	  $cacheManager->remove('@sf_cache_partial?module=Pacientes&action=_paciente_small_estado&sf_cache_key='.$preTrasplanteId);
	} 	
  }
  
}
