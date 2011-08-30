<?php

/**
 * ComplicacionesTipos actions.
 *
 * @package    transplantes
 * @subpackage ComplicacionesTipos
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class ComplicacionesTiposActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->complicaciones_tiposs = Doctrine_Core::getTable('ComplicacionesTipos')
      ->createQuery('a')
      ->execute();
  }

  public function executeNew(sfWebRequest $request)
  {
    $this->form = new ComplicacionesTiposForm();
  }

  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new ComplicacionesTiposForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($complicaciones_tipos = Doctrine_Core::getTable('ComplicacionesTipos')->find(array($request->getParameter('id'))), sprintf('Object complicaciones_tipos does not exist (%s).', $request->getParameter('id')));
    $this->form = new ComplicacionesTiposForm($complicaciones_tipos);
  }

  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($complicaciones_tipos = Doctrine_Core::getTable('ComplicacionesTipos')->find(array($request->getParameter('id'))), sprintf('Object complicaciones_tipos does not exist (%s).', $request->getParameter('id')));
    $this->form = new ComplicacionesTiposForm($complicaciones_tipos);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }

  public function executeDelete(sfWebRequest $request)
  {
    $request->checkCSRFProtection();

    $this->forward404Unless($complicaciones_tipos = Doctrine_Core::getTable('ComplicacionesTipos')->find(array($request->getParameter('id'))), sprintf('Object complicaciones_tipos does not exist (%s).', $request->getParameter('id')));
    $complicaciones_tipos->delete();

    $this->redirect('ComplicacionesTipos/index');
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $complicaciones_tipos = $form->save();

      $this->redirect('ComplicacionesTipos/edit?id='.$complicaciones_tipos->getId());
    }
  }
}
