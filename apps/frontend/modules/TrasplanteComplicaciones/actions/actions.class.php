<?php

/**
 * TrasplanteComplicaciones actions.
 *
 * @package    transplantes
 * @subpackage TrasplanteComplicaciones
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class TrasplanteComplicacionesActions extends sfActions
{
  
  public function executeMostrar(sfWebRequest $request)
  {
	$this->trasplanteId = $request->getParameter('trasplanteId');
	$this->forward404Unless($this->trasplanteId);
  }
  
  public function executeIndex(sfWebRequest $request)
  {
    $this->trasplante_complicacioness = Doctrine_Core::getTable('TrasplanteComplicaciones')
      ->createQuery('a')
      ->execute();
  }

  public function executeShow(sfWebRequest $request)
  {
    $this->trasplante_complicaciones = Doctrine_Core::getTable('TrasplanteComplicaciones')->find(array($request->getParameter('id')));
    $this->forward404Unless($this->trasplante_complicaciones);
  }

  public function executeNew(sfWebRequest $request)
  {
    $this->form = new TrasplanteComplicacionesForm();
  }

  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new TrasplanteComplicacionesForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($trasplante_complicaciones = Doctrine_Core::getTable('TrasplanteComplicaciones')->find(array($request->getParameter('id'))), sprintf('Object trasplante_complicaciones does not exist (%s).', $request->getParameter('id')));
    $this->form = new TrasplanteComplicacionesForm($trasplante_complicaciones);
  }

  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($trasplante_complicaciones = Doctrine_Core::getTable('TrasplanteComplicaciones')->find(array($request->getParameter('id'))), sprintf('Object trasplante_complicaciones does not exist (%s).', $request->getParameter('id')));
    $this->form = new TrasplanteComplicacionesForm($trasplante_complicaciones);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }

  public function executeDelete(sfWebRequest $request)
  {
    $request->checkCSRFProtection();

    $this->forward404Unless($trasplante_complicaciones = Doctrine_Core::getTable('TrasplanteComplicaciones')->find(array($request->getParameter('id'))), sprintf('Object trasplante_complicaciones does not exist (%s).', $request->getParameter('id')));
    $trasplante_complicaciones->delete();

    $this->redirect('TrasplanteComplicaciones/index');
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $trasplante_complicaciones = $form->save();

      $this->redirect('TrasplanteComplicaciones/edit?id='.$trasplante_complicaciones->getId());
    }
  }
}
