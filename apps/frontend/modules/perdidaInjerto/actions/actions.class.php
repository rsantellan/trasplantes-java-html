<?php

/**
 * perdidaInjerto actions.
 *
 * @package    transplantes
 * @subpackage perdidaInjerto
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class perdidaInjertoActions extends sfActions
{
  
  public function executeIndex(sfWebRequest $request)
  {
    $this->paciente_perdida_injertos = Doctrine_Core::getTable('PacientePerdidaInjerto')
      ->createQuery('a')
      ->execute();
  }

  public function executeShow(sfWebRequest $request)
  {
    $this->paciente_perdida_injerto = Doctrine_Core::getTable('PacientePerdidaInjerto')->find(array($request->getParameter('id')));
    $this->forward404Unless($this->paciente_perdida_injerto);
  }


  public function executeNew(sfWebRequest $request)
  {
    $id = $request->getParameter('id');
    $aux = new PacientePerdidaInjerto();
    $aux->setPacienteId($id);
    $this->form = new PacientePerdidaInjertoForm($aux);
  }

  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new PacientePerdidaInjertoForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($paciente_perdida_injerto = Doctrine_Core::getTable('PacientePerdidaInjerto')->find(array($request->getParameter('id'))), sprintf('Object paciente_perdida_injerto does not exist (%s).', $request->getParameter('id')));
    $this->form = new PacientePerdidaInjertoForm($paciente_perdida_injerto);
  }

  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($paciente_perdida_injerto = Doctrine_Core::getTable('PacientePerdidaInjerto')->find(array($request->getParameter('id'))), sprintf('Object paciente_perdida_injerto does not exist (%s).', $request->getParameter('id')));
    $this->form = new PacientePerdidaInjertoForm($paciente_perdida_injerto);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }

  public function executeDelete(sfWebRequest $request)
  {
    $request->checkCSRFProtection();

    $this->forward404Unless($paciente_perdida_injerto = Doctrine_Core::getTable('PacientePerdidaInjerto')->find(array($request->getParameter('id'))), sprintf('Object paciente_perdida_injerto does not exist (%s).', $request->getParameter('id')));
    $paciente_perdida_injerto->delete();

    $this->redirect('perdidaInjerto/index');
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $paciente_perdida_injerto = $form->save();

      $this->redirect('perdidaInjerto/edit?id='.$paciente_perdida_injerto->getId());
    }
  }
}
