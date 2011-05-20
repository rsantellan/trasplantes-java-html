<?php

/**
 * Trasplante actions.
 *
 * @package    transplantes
 * @subpackage Trasplante
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class TrasplanteActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->trasplantes = Doctrine_Core::getTable('Trasplante')
      ->createQuery('a')
      ->execute();
  }

  public function executeShow(sfWebRequest $request)
  {
    $this->trasplante = Doctrine_Core::getTable('Trasplante')->find(array($request->getParameter('id')));
    $this->forward404Unless($this->trasplante);
  }

  public function executeNew(sfWebRequest $request)
  {
    $this->form = new TrasplanteForm();
  }

  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new TrasplanteForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($trasplante = Doctrine_Core::getTable('Trasplante')->find(array($request->getParameter('id'))), sprintf('Object trasplante does not exist (%s).', $request->getParameter('id')));
    $this->form = new TrasplanteForm($trasplante);
  }

  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($trasplante = Doctrine_Core::getTable('Trasplante')->find(array($request->getParameter('id'))), sprintf('Object trasplante does not exist (%s).', $request->getParameter('id')));
    $this->form = new TrasplanteForm($trasplante);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }

  public function executeDelete(sfWebRequest $request)
  {
    $request->checkCSRFProtection();

    $this->forward404Unless($trasplante = Doctrine_Core::getTable('Trasplante')->find(array($request->getParameter('id'))), sprintf('Object trasplante does not exist (%s).', $request->getParameter('id')));
    $trasplante->delete();

    $this->redirect('Trasplante/index');
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    //print_r($request->getParameter($form->getName()));
    //die;
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $trasplante = $form->save();

      $this->redirect('Trasplante/edit?id='.$trasplante->getId());
    }
  }
}
