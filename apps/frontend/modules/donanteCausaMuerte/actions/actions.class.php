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

  
  public function executeSave(sfWebRequest $request)
  {
      $auxForm = new DonanteCausaMuerteForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $donante_causa_muerte = Doctrine_Core::getTable('DonanteCausaMuerte')->find($id);
        $this->forward404Unless($donante_causa_muerte);
        $form = new DonanteCausaMuerteForm($donante_causa_muerte); 
        $isNew = false;
      }
      else
      {
        
        $form = new DonanteCausaMuerteForm(); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $donante_causa_muerte = $form->save();
        $form = new DonanteCausaMuerteForm($donante_causa_muerte);
        $body = $this->getPartial('small_form', array('form'=>$form));
        
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$donante_causa_muerte->getId(), 'nombre'=>$donante_causa_muerte->getNombre(), 'body' => $body)));
      }
      else
      {
        $body = $this->getPartial('small_form', array('form'=>$form));
        return $this->renderText(mdBasicFunction::basic_json_response(false, array('body' => $body)));
      }
  }

  public function executeDelete(sfWebRequest $request)
  {
    //$request->checkCSRFProtection();

    $this->forward404Unless($donante_causa_muerte = Doctrine_Core::getTable('DonanteCausaMuerte')->find(array($request->getParameter('id'))), sprintf('Object donante_causa_muerte does not exist (%s).', $request->getParameter('id')));
    try
    {
      if($donante_causa_muerte->delete())
      {  
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('id'=>$request->getParameter('id'))));
      }
      else
      {
        return $this->renderText(mdBasicFunction::basic_json_response(false, array()));
      }      
    }catch(Exception $e)
    {
      
      return $this->renderText(mdBasicFunction::basic_json_response(false, array("error" => $e->getCode())));
    }
	
    //$this->redirect('donanteCausaMuerte/index');
  }  
  
  
  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($donante_causa_muerte = Doctrine_Core::getTable('DonanteCausaMuerte')->find(array($request->getParameter('id'))), sprintf('Object donante_causa_muerte does not exist (%s).', $request->getParameter('id')));
    $this->form = new DonanteCausaMuerteForm($donante_causa_muerte);
	
	$body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));
  }
  
  /**
   *
   * 
   * No uso nada mas para abajo
   * 
   * 
   */
  
  
  
  

  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new DonanteCausaMuerteForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }  
  
  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($donante_causa_muerte = Doctrine_Core::getTable('DonanteCausaMuerte')->find(array($request->getParameter('id'))), sprintf('Object donante_causa_muerte does not exist (%s).', $request->getParameter('id')));
    $this->form = new DonanteCausaMuerteForm($donante_causa_muerte);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
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
