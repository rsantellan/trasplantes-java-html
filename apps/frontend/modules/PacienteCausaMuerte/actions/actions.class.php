<?php

/**
 * PacienteCausaMuerte actions.
 *
 * @package    transplantes
 * @subpackage PacienteCausaMuerte
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class PacienteCausaMuerteActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->list = PacienteMuertehandler::retrieveAll();
  }

	public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($paciente_causa_muerte = Doctrine_Core::getTable('PacienteCausaMuerte')->find(array($request->getParameter('id'))), sprintf('Object paciente_causa_muerte does not exist (%s).', $request->getParameter('id')));
    $this->form = new PacienteCausaMuerteForm($paciente_causa_muerte);
		
		$body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body))); 
  }
	
  public function executeNew(sfWebRequest $request)
  {
		$this->form = new PacienteCausaMuerteForm();
    
    $body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body))); 
		
    //$this->form = new PacienteCausaMuerteForm();
  }

	public function executeSave(sfWebRequest $request)
  {
      $auxForm = new PacienteCausaMuerteForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $causa= Doctrine::getTable('PacienteCausaMuerte')->find($id);
        $this->forward404Unless($causa);
        $form = new PacienteCausaMuerteForm($causa); 
        $isNew = false;
      }
      else
      {
        
        $form = new PacienteCausaMuerteForm(); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $causa = $form->save();
        $form = new PacienteCausaMuerteForm($causa);
        $body = $this->getPartial('small_form', array('form'=>$form));
        
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$causa->getId(), 'nombre'=>$causa->getNombre(), 'body' => $body)));
      }
      else
      {
        $body = $this->getPartial('small_form', array('form'=>$form));
        return $this->renderText(mdBasicFunction::basic_json_response(false, array('body' => $body)));
      }
  }
	
	public function executeDelete(sfWebRequest $request)
  {
		
		$this->forward404Unless($paciente_causa_muerte = Doctrine_Core::getTable('PacienteCausaMuerte')->find(array($request->getParameter('id'))), sprintf('Object paciente_causa_muerte does not exist (%s).', $request->getParameter('id')));
    try
    {
      if($paciente_causa_muerte->delete())
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
		
		
//    $request->checkCSRFProtection();
//
//    $this->forward404Unless($paciente_causa_muerte = Doctrine_Core::getTable('PacienteCausaMuerte')->find(array($request->getParameter('id'))), sprintf('Object paciente_causa_muerte does not exist (%s).', $request->getParameter('id')));
//    $paciente_causa_muerte->delete();
//
//    $this->redirect('PacienteCausaMuerte/index');
  }
	
	
	/***
	 * 
	 * De aca para abajo va a ser dudoso que me sirva.
	 * TODO limpiar
	 * 
	 */
	public function executeShow(sfWebRequest $request)
  {
    $this->paciente_causa_muerte = Doctrine_Core::getTable('PacienteCausaMuerte')->find(array($request->getParameter('id')));
    $this->forward404Unless($this->paciente_causa_muerte);
  }
	
  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new PacienteCausaMuerteForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }

  

  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($paciente_causa_muerte = Doctrine_Core::getTable('PacienteCausaMuerte')->find(array($request->getParameter('id'))), sprintf('Object paciente_causa_muerte does not exist (%s).', $request->getParameter('id')));
    $this->form = new PacienteCausaMuerteForm($paciente_causa_muerte);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $paciente_causa_muerte = $form->save();

      $this->redirect('PacienteCausaMuerte/edit?id='.$paciente_causa_muerte->getId());
    }
  }
}
