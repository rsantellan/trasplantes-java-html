<?php

/**
 * EvolucionTrasplanteEcografia actions.
 *
 * @package    transplantes
 * @subpackage EvolucionTrasplanteEcografia
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class EvolucionTrasplanteEcografiaActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->evolucion_trasplante_ecografias = Doctrine_Core::getTable('EvolucionTrasplanteEcografia')
      ->createQuery('a')
      ->execute();
  }

  public function executeNew(sfWebRequest $request)
  {
    $this->form = new EvolucionTrasplanteEcografiaForm();
  }

  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new EvolucionTrasplanteEcografiaForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($evolucion_trasplante_ecografia = Doctrine_Core::getTable('EvolucionTrasplanteEcografia')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_ecografia does not exist (%s).', $request->getParameter('id')));
    $this->form = new EvolucionTrasplanteEcografiaForm($evolucion_trasplante_ecografia);
  }

  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($evolucion_trasplante_ecografia = Doctrine_Core::getTable('EvolucionTrasplanteEcografia')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_ecografia does not exist (%s).', $request->getParameter('id')));
    $this->form = new EvolucionTrasplanteEcografiaForm($evolucion_trasplante_ecografia);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }

  public function executeDelete(sfWebRequest $request)
  {
    $request->checkCSRFProtection();

    $this->forward404Unless($evolucion_trasplante_ecografia = Doctrine_Core::getTable('EvolucionTrasplanteEcografia')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_ecografia does not exist (%s).', $request->getParameter('id')));
    $evolucion_trasplante_ecografia->delete();

    $this->redirect('EvolucionTrasplanteEcografia/index');
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $evolucion_trasplante_ecografia = $form->save();

      $this->redirect('EvolucionTrasplanteEcografia/edit?id='.$evolucion_trasplante_ecografia->getId());
    }
  }
}
