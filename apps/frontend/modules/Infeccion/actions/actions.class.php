<?php

/**
 * Infeccion actions.
 *
 * @package    transplantes
 * @subpackage Infeccion
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class InfeccionActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
	$this->list = complicacionesHandler::retrieveAllInfecciones();
    
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
    $this->forward404Unless($infeccion = complicacionesHandler::retrieveInfeccionById(array($request->getParameter('id'))), sprintf('Object medicaciones does not exist (%s).', $request->getParameter('id')));
    $this->form = new InfeccionForm($infeccion);
	
	$body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));
  }
  
  
  public function executeSave(sfWebRequest $request)
  {
      $auxForm = new InfeccionForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $infeccion = complicacionesHandler::retrieveInfeccionById($id);
        $this->forward404Unless($infeccion);
        $form = new InfeccionForm($infeccion); 
        $isNew = false;
      }
      else
      {
        
        $form = new InfeccionForm(); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $infeccion = $form->save();
        $form = new InfeccionForm($infeccion);
        $body = $this->getPartial('small_form', array('form'=>$form));
        
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$infeccion->getId(), 'nombre'=>$infeccion->getNombre(), 'body' => $body)));
      }
      else
      {
        $body = $this->getPartial('small_form', array('form'=>$form));
        return $this->renderText(mdBasicFunction::basic_json_response(false, array('body' => $body)));
      }
  }
  
  
  public function executeNew(sfWebRequest $request)
  {
    $this->form = new InfeccionForm();
  
	$body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body))); 
	
  }
  
    public function executeDelete(sfWebRequest $request)
  {
    //$request->checkCSRFProtection();

    $this->forward404Unless($infeccion = complicacionesHandler::retrieveInfeccionById(array($request->getParameter('id'))), sprintf('Object medicacion does not exist (%s).', $request->getParameter('id')));
    try
    {
      if($infeccion->delete())
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
