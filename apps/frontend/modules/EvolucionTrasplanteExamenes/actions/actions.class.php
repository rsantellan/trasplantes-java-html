<?php

/**
 * EvolucionTrasplanteExamenes actions.
 *
 * @package    transplantes
 * @subpackage EvolucionTrasplanteExamenes
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class EvolucionTrasplanteExamenesActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->evolucion_trasplante_exameness = Doctrine_Core::getTable('EvolucionTrasplanteExamenes')
      ->createQuery('a')
      ->execute();
  }

  public function executeNew(sfWebRequest $request)
  {
    $this->form = new EvolucionTrasplanteExamenesForm();
  }

  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new EvolucionTrasplanteExamenesForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($evolucion_trasplante_examenes = Doctrine_Core::getTable('EvolucionTrasplanteExamenes')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_examenes does not exist (%s).', $request->getParameter('id')));
    $this->form = new EvolucionTrasplanteExamenesForm($evolucion_trasplante_examenes);
  }

  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($evolucion_trasplante_examenes = Doctrine_Core::getTable('EvolucionTrasplanteExamenes')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_examenes does not exist (%s).', $request->getParameter('id')));
    $this->form = new EvolucionTrasplanteExamenesForm($evolucion_trasplante_examenes);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }

  public function executeDelete(sfWebRequest $request)
  {
    $request->checkCSRFProtection();

    $this->forward404Unless($evolucion_trasplante_examenes = Doctrine_Core::getTable('EvolucionTrasplanteExamenes')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_examenes does not exist (%s).', $request->getParameter('id')));
    $evolucion_trasplante_examenes->delete();

    $this->redirect('EvolucionTrasplanteExamenes/index');
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $evolucion_trasplante_examenes = $form->save();

      $this->redirect('EvolucionTrasplanteExamenes/edit?id='.$evolucion_trasplante_examenes->getId());
    }
  }
}
