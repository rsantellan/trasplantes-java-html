<?php

/**
 * InjertoEvolucion actions.
 *
 * @package    transplantes
 * @subpackage InjertoEvolucion
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class InjertoEvolucionActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->trasplanteId = $request->getParameter('id');
    $this->forward404Unless($this->trasplanteId);
    $this->evolucionTrasplante = injertoEvolucionHandler::retrieveInjertoEvolucionOfTrasplanteEnTrasplante($this->trasplanteId);
    $this->evolucionEvolucion = injertoEvolucionHandler::retrieveInjertoEvolucionOfTrasplanteEnEvolucion($this->trasplanteId);
    $this->injerto_evolucions = Doctrine_Core::getTable('InjertoEvolucion')
      ->createQuery('a')
      ->execute();
  }

  public function executeShow(sfWebRequest $request)
  {
    $this->injerto_evolucion = Doctrine_Core::getTable('InjertoEvolucion')->find(array($request->getParameter('id')));
    $this->forward404Unless($this->injerto_evolucion);
  }

  public function executeNew(sfWebRequest $request)
  {
    $this->form = new InjertoEvolucionForm();
  }

  public function executeNewTrasplante(sfWebRequest $request)
  {
    $trasplanteId = $request->getParameter('id');
    $this->forward404Unless($trasplanteId);
    $injerto = new InjertoEvolucion();
    $injerto->setTrasplanteId($trasplanteId);
    $injerto->setEnTrasplante(true);
    $this->form = new InjertoEvolucionForm($injerto);
    $this->setTemplate("new");
  }
  
  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new InjertoEvolucionForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($injerto_evolucion = Doctrine_Core::getTable('InjertoEvolucion')->find(array($request->getParameter('id'))), sprintf('Object injerto_evolucion does not exist (%s).', $request->getParameter('id')));
    $this->form = new InjertoEvolucionForm($injerto_evolucion);
  }

  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($injerto_evolucion = Doctrine_Core::getTable('InjertoEvolucion')->find(array($request->getParameter('id'))), sprintf('Object injerto_evolucion does not exist (%s).', $request->getParameter('id')));
    $this->form = new InjertoEvolucionForm($injerto_evolucion);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }

  public function executeDelete(sfWebRequest $request)
  {
    $request->checkCSRFProtection();

    $this->forward404Unless($injerto_evolucion = Doctrine_Core::getTable('InjertoEvolucion')->find(array($request->getParameter('id'))), sprintf('Object injerto_evolucion does not exist (%s).', $request->getParameter('id')));
    $injerto_evolucion->delete();

    $this->redirect('InjertoEvolucion/index');
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $injerto_evolucion = $form->save();

      $this->redirect('InjertoEvolucion/edit?id='.$injerto_evolucion->getId());
    }
  }
}
