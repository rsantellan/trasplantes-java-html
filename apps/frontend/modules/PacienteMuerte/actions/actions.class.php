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
    $this->form = new PacienteMuerteForm();
  }

  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new PacienteMuerteForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($paciente_muerte = Doctrine_Core::getTable('PacienteMuerte')->find(array($request->getParameter('paciente_id'))), sprintf('Object paciente_muerte does not exist (%s).', $request->getParameter('paciente_id')));
    $this->form = new PacienteMuerteForm($paciente_muerte);
  }

  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($paciente_muerte = Doctrine_Core::getTable('PacienteMuerte')->find(array($request->getParameter('paciente_id'))), sprintf('Object paciente_muerte does not exist (%s).', $request->getParameter('paciente_id')));
    $this->form = new PacienteMuerteForm($paciente_muerte);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }

  public function executeDelete(sfWebRequest $request)
  {
    $request->checkCSRFProtection();

    $this->forward404Unless($paciente_muerte = Doctrine_Core::getTable('PacienteMuerte')->find(array($request->getParameter('paciente_id'))), sprintf('Object paciente_muerte does not exist (%s).', $request->getParameter('paciente_id')));
    $paciente_muerte->delete();

    $this->redirect('PacienteMuerte/index');
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $paciente_muerte = $form->save();

      $this->redirect('PacienteMuerte/edit?paciente_id='.$paciente_muerte->getPacienteId());
    }
  }
}
