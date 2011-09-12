<?php

/**
 * Germen actions.
 *
 * @package    transplantes
 * @subpackage Germen
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class GermenActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
	$this->list = complicacionesHandler::retrieveAllGermenes();
    
    $body = $this->getPartial('indexTemplate', array('list'=>$this->list));
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));
	
	/*
    $this->medicacioness = Doctrine_Core::getTable('Medicaciones')
      ->createQuery('a')
      ->execute();
	 * 
	 */
  }


  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($germen = complicacionesHandler::retrieveGermenById(array($request->getParameter('id'))), sprintf('Object medicaciones does not exist (%s).', $request->getParameter('id')));
    $this->form = new GermenesForm($germen);
	
	$body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));
  }
  
  
  public function executeSave(sfWebRequest $request)
  {
	
      $auxForm = new GermenesForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $germen = complicacionesHandler::retrieveGermenById($id);
        $this->forward404Unless($germen);
        $form = new GermenesForm($germen); 
        $isNew = false;
      }
      else
      {
        
        $form = new GermenesForm(); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $germen = $form->save();
        $form = new GermenesForm($germen);
        $body = $this->getPartial('small_form', array('form'=>$form));
        
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$germen->getId(), 'nombre'=>$germen->getNombre(), 'body' => $body)));
      }
      else
      {
        $body = $this->getPartial('small_form', array('form'=>$form));
        return $this->renderText(mdBasicFunction::basic_json_response(false, array('body' => $body)));
      }
  }
  
  
  public function executeNew(sfWebRequest $request)
  {
    $this->form = new GermenesForm();
  
	$body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body))); 
	
  }
  
    public function executeDelete(sfWebRequest $request)
  {
    //$request->checkCSRFProtection();

    $this->forward404Unless($germen = complicacionesHandler::retrieveGermenById(array($request->getParameter('id'))), sprintf('Object medicacion does not exist (%s).', $request->getParameter('id')));
    try
    {
      if($germen->delete())
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
  
}
