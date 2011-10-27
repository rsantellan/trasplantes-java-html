<?php

/**
 * reoperaciones actions.
 *
 * @package    transplantes
 * @subpackage reoperaciones
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class reoperacionesActions extends sfActions
{
  
  public function executeMostrar(sfWebRequest $request)
  {
	$this->reoperaciones = ReoperacionesHandler::retrieveReoperacionesFromTrasplante($request->getParameter('id'));
  }
  
  public function executeIndex(sfWebRequest $request)
  {
    $this->trasplante_reoperacions = Doctrine_Core::getTable('TrasplanteReoperacion')
      ->createQuery('a')
      ->execute();
  }

  
  public function executeNew(sfWebRequest $request)
  {
    $this->form = new TrasplanteReoperacionForm();
  }

  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new TrasplanteReoperacionForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($trasplante_reoperacion = Doctrine_Core::getTable('TrasplanteReoperacion')->find(array($request->getParameter('id'))), sprintf('Object trasplante_reoperacion does not exist (%s).', $request->getParameter('id')));
    $this->form = new TrasplanteReoperacionForm($trasplante_reoperacion);
  }

  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($trasplante_reoperacion = Doctrine_Core::getTable('TrasplanteReoperacion')->find(array($request->getParameter('id'))), sprintf('Object trasplante_reoperacion does not exist (%s).', $request->getParameter('id')));
    $this->form = new TrasplanteReoperacionForm($trasplante_reoperacion);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }

  public function executeDelete(sfWebRequest $request)
  {
    $request->checkCSRFProtection();

    $this->forward404Unless($trasplante_reoperacion = Doctrine_Core::getTable('TrasplanteReoperacion')->find(array($request->getParameter('id'))), sprintf('Object trasplante_reoperacion does not exist (%s).', $request->getParameter('id')));
    $trasplante_reoperacion->delete();

    $this->redirect('reoperaciones/index');
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $trasplante_reoperacion = $form->save();

      $this->redirect('reoperaciones/edit?id='.$trasplante_reoperacion->getId());
    }
  }
}
