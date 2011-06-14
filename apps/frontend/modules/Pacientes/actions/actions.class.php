<?php

/**
 * Pacientes actions.
 *
 * @package    transplantes
 * @subpackage Pacientes
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class PacientesActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->pacientess = Doctrine_Core::getTable('Pacientes')
      ->createQuery('a')
      ->execute();
  }

  public function executeShow(sfWebRequest $request)
  {
    $this->pacientes = Doctrine_Core::getTable('Pacientes')->find(array($request->getParameter('id')));
    $this->forward404Unless($this->pacientes);
  }

  public function executeNew(sfWebRequest $request)
  {
    $this->form = new PacientesForm();
  }

  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new PacientesForm();

    $return = $this->processForm($request, $this->form);
	if($return != 0)
	{
	  sfContext::getInstance()->getConfiguration()->loadHelpers(array('Url'));
	  $this->redirect(url_for("@mostrarPaciente?id=".$request->getParameter('id')));	
	}
	else
	{
	  $this->setTemplate('new');
	} 
    //$this->setTemplate('new');
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($pacientes = Doctrine_Core::getTable('Pacientes')->find(array($request->getParameter('id'))), sprintf('Object pacientes does not exist (%s).', $request->getParameter('id')));
    $this->form = new PacientesForm($pacientes);
  }

  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($pacientes = Doctrine_Core::getTable('Pacientes')->find(array($request->getParameter('id'))), sprintf('Object pacientes does not exist (%s).', $request->getParameter('id')));
    $this->form = new PacientesForm($pacientes);

    $return = $this->processForm($request, $this->form);
	if($return != 0)
	{
	  sfContext::getInstance()->getConfiguration()->loadHelpers(array('Url'));
	  $this->redirect(url_for("@mostrarPaciente?id=".$request->getParameter('id')));	
	}
	else
	{
	  $this->setTemplate('edit');
	}  
  }

  public function executeDelete(sfWebRequest $request)
  {
    $request->checkCSRFProtection();

    $this->forward404Unless($pacientes = Doctrine_Core::getTable('Pacientes')->find(array($request->getParameter('id'))), sprintf('Object pacientes does not exist (%s).', $request->getParameter('id')));
    $pacientes->delete();

    $this->redirect('Pacientes/index');
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
	$form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $pacientes = $form->save();
	  $cacheManager = $this->getContext()->getViewCacheManager();
	  if($cacheManager)
	  {
		$cacheManager->remove('@sf_cache_partial?module=Pacientes&action=_paciente_small_ul_info&sf_cache_key='.$pacientes->getId());
	  }
	  
	  return $pacientes->getId();
    }
	return 0;
  }
  
  public function executeBuscar(sfWebRequest $request)
  {
    $this->buscarForm = new buscarPacienteForm();
  }
  
  public function executeBuscarAccion(sfWebRequest $request)
  {
    $buscarForm = new buscarPacienteForm();
    $parameters = $request->getParameter($buscarForm->getName());
    $id = $parameters["nombre"];
    $this->forward404Unless($id);
    sfContext::getInstance()->getConfiguration()->loadHelpers(array('Url'));
    $this->redirect(url_for("@mostrarPaciente?id=".$id));
  }
  
  public function executeMostrar(sfWebRequest $request)
  {
    $id = $request->getParameter("id");
    $this->forward404Unless($id);
    $this->paciente = PacienteHandler::retriveById($id, Doctrine::HYDRATE_ARRAY);
  }  
}
