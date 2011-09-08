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
	$this->list = complicacionesHandler::retrieveAllComplicacionesTipo();
    
    $body = $this->getPartial('indexTemplate', array('list'=>$this->list));
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));
  }

  
  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($complicacionTipo = complicacionesHandler::retrieveComplicacionesTipoById(array($request->getParameter('id'))), sprintf('Object complicaciones tipo does not exist (%s).', $request->getParameter('id')));
    $this->form = new ComplicacionesTiposForm($complicacionTipo);
	
	$body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));
  }
  
  
  public function executeSave(sfWebRequest $request)
  {
      $auxForm = new ComplicacionesTiposForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $complicacionTipo = complicacionesHandler::retrieveComplicacionesTipoById($id);
        $this->forward404Unless($complicacionTipo);
        $form = new ComplicacionesTiposForm($complicacionTipo); 
        $isNew = false;
      }
      else
      {
        
        $form = new ComplicacionesTiposForm(); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $complicacionTipo = $form->save();
        $form = new ComplicacionesTiposForm($complicacionTipo);
        $body = $this->getPartial('small_form', array('form'=>$form));
        
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$complicacionTipo->getId(), 'nombre'=>$complicacionTipo->getNombre(), 'body' => $body)));
      }
      else
      {
        $body = $this->getPartial('small_form', array('form'=>$form));
        return $this->renderText(mdBasicFunction::basic_json_response(false, array('body' => $body)));
      }
  }
  
  
  public function executeNew(sfWebRequest $request)
  {
    $this->form = new ComplicacionesTiposForm();
  
	$body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body))); 
	
  }
  
  public function executeDelete(sfWebRequest $request)
  {
    //$request->checkCSRFProtection();

    $this->forward404Unless($complicacionTipo = complicacionesHandler::retrieveComplicacionesTipoById(array($request->getParameter('id'))), sprintf('Object complicaciones tipo does not exist (%s).', $request->getParameter('id')));
    try
    {
      if($complicacionTipo->delete())
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

  public function executeEditValor(sfWebRequest $request)
  {
    $this->forward404Unless($complicacionTipoValor = complicacionesHandler::retrieveComplicacionesValorTipoById(array($request->getParameter('id'))), sprintf('Object complicaciones tipo does not exist (%s).', $request->getParameter('id')));
    $this->form = new ComplicacionesTiposValoresForm($complicacionTipoValor);
	
	$body = $this->getPartial('small_form_valor', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));
  }
  
  
  public function executeSaveValor(sfWebRequest $request)
  {
      $auxForm = new ComplicacionesTiposValoresForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $complicacionTipoValor = complicacionesHandler::retrieveComplicacionesValorTipoById($id);
        $this->forward404Unless($complicacionTipoValor);
        $form = new ComplicacionesTiposValoresForm($complicacionTipoValor); 
        $isNew = false;
      }
      else
      {
        
        $form = new ComplicacionesTiposValoresForm(); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $complicacionTipoValor = $form->save();
        $form = new ComplicacionesTiposValoresForm($complicacionTipoValor);
        $body = $this->getPartial('small_form_valor', array('form'=>$form));
        
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$complicacionTipoValor->getId(), 'nombre'=>$complicacionTipoValor->getNombre(), 'body' => $body)));
      }
      else
      {
        $body = $this->getPartial('small_form_valor', array('form'=>$form));
        return $this->renderText(mdBasicFunction::basic_json_response(false, array('body' => $body)));
      }
  }
  
  
  public function executeNewValor(sfWebRequest $request)
  {
	$tipoId = $request->getParameter('id');
	$complicacionTiposValores = new ComplicacionesTiposValores();
	$complicacionTiposValores->setComplicacionTipoId($tipoId);
	
    $this->form = new ComplicacionesTiposValoresForm($complicacionTiposValores);
  
	$body = $this->getPartial('small_form_valor', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body))); 
	
  }
  
  public function executeDeleteValor(sfWebRequest $request)
  {
    //$request->checkCSRFProtection();

    $this->forward404Unless($complicacionTipoValor = complicacionesHandler::retrieveComplicacionesValorTipoById(array($request->getParameter('id'))), sprintf('Object complicaciones tipo does not exist (%s).', $request->getParameter('id')));
    try
    {
      if($complicacionTipoValor->delete())
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
  
  public function executeRetrieveAllComplicacionesTipoValores(sfWebRequest $request)
  {
    $list = complicacionesHandler::retrieveAllComplicacionesTipoValor();
    $return = array();
    foreach($list as $valor)
    {
      $aux = array();
      $aux['id'] = $valor->getId();
      $aux['name'] = $valor->__toString();
      array_push($return, $aux);
    }
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('list' => $return)));
  }
  
}
