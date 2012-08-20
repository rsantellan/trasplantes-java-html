<?php

/**
 * causaPerdidaInjerto actions.
 *
 * @package    transplantes
 * @subpackage causaPerdidaInjerto
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class causaPerdidaInjertoActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->list = PacientePerdidahandler::retrieveAllCausas();
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($paciente_causa_perdida_injerto = Doctrine_Core::getTable('PacienteCausaPerdidaInjerto')->find(array($request->getParameter('id'))), sprintf('Object paciente_causa_perdida_injerto does not exist (%s).', $request->getParameter('id')));
    $this->form = new PacienteCausaPerdidaInjertoForm($paciente_causa_perdida_injerto);
    
    $body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body))); 
  }
  
  public function executeNew(sfWebRequest $request)
  {
    $this->form = new PacienteCausaPerdidaInjertoForm();
    
    $body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body))); 
  }

  public function executeSave(sfWebRequest $request)
  {
      $auxForm = new PacienteCausaPerdidaInjertoForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $causa= Doctrine::getTable('PacienteCausaPerdidaInjerto')->find($id);
        $this->forward404Unless($causa);
        $form = new PacienteCausaPerdidaInjertoForm($causa); 
        $isNew = false;
      }
      else
      {
        
        $form = new PacienteCausaPerdidaInjertoForm(); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $causa = $form->save();
        $form = new PacienteCausaPerdidaInjertoForm($causa);
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
		
		$this->forward404Unless($paciente_causa_perdida_injerto = Doctrine_Core::getTable('PacienteCausaPerdidaInjerto')->find(array($request->getParameter('id'))), sprintf('Object paciente_causa_perdida_injerto does not exist (%s).', $request->getParameter('id')));
    try
    {
      if($paciente_causa_perdida_injerto->delete())
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
  }  
}
