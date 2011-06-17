<?php

/**
 * PacienteMuerte actions.
 *
 * @package    transplantes
 * @subpackage PacienteMuerte
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class PacienteMuerteActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->paciente_muertes = Doctrine_Core::getTable('PacienteMuerte')
      ->createQuery('a')
      ->execute();
  }

  public function executeNew(sfWebRequest $request)
  {
    $paciente_muerte = new PacienteMuerte();
    $paciente_muerte->setPacienteId($request->getParameter('id'));
    $this->form = new PacienteMuerteForm($paciente_muerte);
  }

  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new PacienteMuerteForm();

    $this->processForm($request, $this->form);
    $return = $this->processForm($request, $this->form);
    
    if($return != 0)
    {
      sfContext::getInstance()->getConfiguration()->loadHelpers(array('Url'));
      $this->redirect(url_for("@editarEstadoPaciente?id=".$return));	
    }
    else
    {
      $this->setTemplate('new');
    }
  }

  public function executeEdit(sfWebRequest $request)
  {
    $paciente_muerte =PacienteMuertehandler::retrieveByPacienteId($request->getParameter('id'));
    $this->forward404Unless($paciente_muerte, sprintf('Object paciente_muerte does not exist (%s).', $request->getParameter('paciente_id')));
    $this->form = new PacienteMuerteForm($paciente_muerte);
  }

  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $paciente_muerte =PacienteMuertehandler::retrieveByPacienteId($request->getParameter('paciente_id'));
    $this->forward404Unless($paciente_muerte, sprintf('Object paciente_muerte does not exist (%s).', $request->getParameter('paciente_id')));
    $this->form = new PacienteMuerteForm($paciente_muerte);

    $return = $this->processForm($request, $this->form);
    
    if($return != 0)
    {
      sfContext::getInstance()->getConfiguration()->loadHelpers(array('Url'));
      $this->redirect(url_for("@editarEstadoPaciente?id=".$return));	
    }
    else
    {
      $this->setTemplate('edit');
    }
  }

  public function executeDelete(sfWebRequest $request)
  {
    $request->checkCSRFProtection();

    $paciente_muerte =PacienteMuertehandler::retrieveByPacienteId($request->getParameter('id'));
    $this->forward404Unless($paciente_muerte, sprintf('Object paciente_muerte does not exist (%s).', $request->getParameter('paciente_id')));
    $paciente_muerte->delete();

    $this->redirect('PacienteMuerte/index');
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $paciente_muerte = $form->save();
      $cacheManager = $this->getContext()->getViewCacheManager();
      if($cacheManager)
      {
        $cacheManager->remove('@sf_cache_partial?module=Pacientes&action=_paciente_small_estado&sf_cache_key='.$paciente_muerte->getPacienteId());
      }      
      return $paciente_muerte->getPacienteId();
      //$this->redirect('PacienteMuerte/edit?id='.$paciente_muerte->getPacienteId());
    }
    return 0;
  }
}
