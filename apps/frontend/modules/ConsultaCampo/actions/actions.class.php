<?php

/**
 * ConsultaCampo actions.
 *
 * @package    transplantes
 * @subpackage ConsultaCampo
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class ConsultaCampoActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->consulta_campos = Doctrine_Core::getTable('ConsultaCampo')
      ->createQuery('a')
      ->execute();
  }

  public function executeNew(sfWebRequest $request)
  {
    $this->form = new ConsultaCampoForm();
  }

  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new ConsultaCampoForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($consulta_campo = Doctrine_Core::getTable('ConsultaCampo')->find(array($request->getParameter('id'))), sprintf('Object consulta_campo does not exist (%s).', $request->getParameter('id')));
    $this->form = new ConsultaCampoForm($consulta_campo);
  }

  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($consulta_campo = Doctrine_Core::getTable('ConsultaCampo')->find(array($request->getParameter('id'))), sprintf('Object consulta_campo does not exist (%s).', $request->getParameter('id')));
    $this->form = new ConsultaCampoForm($consulta_campo);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }

  public function executeDelete(sfWebRequest $request)
  {
    $request->checkCSRFProtection();

    $this->forward404Unless($consulta_campo = Doctrine_Core::getTable('ConsultaCampo')->find(array($request->getParameter('id'))), sprintf('Object consulta_campo does not exist (%s).', $request->getParameter('id')));
    $consulta_campo->delete();

    $this->redirect('ConsultaCampo/index');
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $consulta_campo = $form->save();

      $this->redirect('ConsultaCampo/edit?id='.$consulta_campo->getId());
    }
  }
}
