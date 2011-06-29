<?php

/**
 * donanteCausaMuerte actions.
 *
 * @package    transplantes
 * @subpackage donanteCausaMuerte
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class donanteCausaMuerteActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->list = DonanteHandler::retrieveAllCausaMuerte();
    
    $body = $this->getPartial('indexTemplate', array('list'=>$this->list));
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));
  }

  public function executeShow(sfWebRequest $request)
  {
    $this->donante_causa_muerte = Doctrine_Core::getTable('DonanteCausaMuerte')->find(array($request->getParameter('id')));
    $this->forward404Unless($this->donante_causa_muerte);
  }

  public function executeNew(sfWebRequest $request)
  {
    $this->form = new DonanteCausaMuerteForm();
    
    $body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));    
  }

  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new DonanteCausaMuerteForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($donante_causa_muerte = Doctrine_Core::getTable('DonanteCausaMuerte')->find(array($request->getParameter('id'))), sprintf('Object donante_causa_muerte does not exist (%s).', $request->getParameter('id')));
    $this->form = new DonanteCausaMuerteForm($donante_causa_muerte);
  }

  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($donante_causa_muerte = Doctrine_Core::getTable('DonanteCausaMuerte')->find(array($request->getParameter('id'))), sprintf('Object donante_causa_muerte does not exist (%s).', $request->getParameter('id')));
    $this->form = new DonanteCausaMuerteForm($donante_causa_muerte);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }

  public function executeDelete(sfWebRequest $request)
  {
    $request->checkCSRFProtection();

    $this->forward404Unless($donante_causa_muerte = Doctrine_Core::getTable('DonanteCausaMuerte')->find(array($request->getParameter('id'))), sprintf('Object donante_causa_muerte does not exist (%s).', $request->getParameter('id')));
    $donante_causa_muerte->delete();

    $this->redirect('donanteCausaMuerte/index');
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $donante_causa_muerte = $form->save();

      $this->redirect('donanteCausaMuerte/edit?id='.$donante_causa_muerte->getId());
    }
  }
}
