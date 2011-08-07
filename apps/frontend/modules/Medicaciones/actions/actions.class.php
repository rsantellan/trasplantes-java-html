<?php

/**
 * Medicaciones actions.
 *
 * @package    transplantes
 * @subpackage Medicaciones
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class MedicacionesActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->medicacioness = Doctrine_Core::getTable('Medicaciones')
      ->createQuery('a')
      ->execute();
  }

  public function executeShow(sfWebRequest $request)
  {
    $this->medicaciones = Doctrine_Core::getTable('Medicaciones')->find(array($request->getParameter('id')));
    $this->forward404Unless($this->medicaciones);
  }

  public function executeNew(sfWebRequest $request)
  {
    $this->form = new MedicacionesForm();
  }

  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new MedicacionesForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($medicaciones = Doctrine_Core::getTable('Medicaciones')->find(array($request->getParameter('id'))), sprintf('Object medicaciones does not exist (%s).', $request->getParameter('id')));
    $this->form = new MedicacionesForm($medicaciones);
  }

  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($medicaciones = Doctrine_Core::getTable('Medicaciones')->find(array($request->getParameter('id'))), sprintf('Object medicaciones does not exist (%s).', $request->getParameter('id')));
    $this->form = new MedicacionesForm($medicaciones);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }

  public function executeDelete(sfWebRequest $request)
  {
    $request->checkCSRFProtection();

    $this->forward404Unless($medicaciones = Doctrine_Core::getTable('Medicaciones')->find(array($request->getParameter('id'))), sprintf('Object medicaciones does not exist (%s).', $request->getParameter('id')));
    $medicaciones->delete();

    $this->redirect('Medicaciones/index');
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $medicaciones = $form->save();

      $this->redirect('Medicaciones/edit?id='.$medicaciones->getId());
    }
  }
}
