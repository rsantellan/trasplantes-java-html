<?php

/**
 * EvolucionTrasplanteCmv actions.
 *
 * @package    transplantes
 * @subpackage EvolucionTrasplanteCmv
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class EvolucionTrasplanteCmvActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->evolucion_trasplante_cmvs = Doctrine_Core::getTable('EvolucionTrasplanteCmv')
      ->createQuery('a')
      ->execute();
  }

  public function executeShow(sfWebRequest $request)
  {
    $this->evolucion_trasplante_cmv = Doctrine_Core::getTable('EvolucionTrasplanteCmv')->find(array($request->getParameter('id')));
    $this->forward404Unless($this->evolucion_trasplante_cmv);
  }

  public function executeNew(sfWebRequest $request)
  {
    $this->form = new EvolucionTrasplanteCmvForm();
  }

  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new EvolucionTrasplanteCmvForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($evolucion_trasplante_cmv = Doctrine_Core::getTable('EvolucionTrasplanteCmv')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_cmv does not exist (%s).', $request->getParameter('id')));
    $this->form = new EvolucionTrasplanteCmvForm($evolucion_trasplante_cmv);
  }

  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($evolucion_trasplante_cmv = Doctrine_Core::getTable('EvolucionTrasplanteCmv')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_cmv does not exist (%s).', $request->getParameter('id')));
    $this->form = new EvolucionTrasplanteCmvForm($evolucion_trasplante_cmv);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }

  public function executeDelete(sfWebRequest $request)
  {
    $request->checkCSRFProtection();

    $this->forward404Unless($evolucion_trasplante_cmv = Doctrine_Core::getTable('EvolucionTrasplanteCmv')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_cmv does not exist (%s).', $request->getParameter('id')));
    $evolucion_trasplante_cmv->delete();

    $this->redirect('EvolucionTrasplanteCmv/index');
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $evolucion_trasplante_cmv = $form->save();

      $this->redirect('EvolucionTrasplanteCmv/edit?id='.$evolucion_trasplante_cmv->getId());
    }
  }
}
