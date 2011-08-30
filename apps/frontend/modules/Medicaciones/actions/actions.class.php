<?php

/**
 * Medicaciones actions.
 *
 * @package    transplantes
 * @subpackage Medicaciones
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class MedicacionesActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
	$this->list = MedicacionHandler::retrieveAllMedicaciones();
    
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
    $this->forward404Unless($medicaciones = MedicacionHandler::retrieveById(array($request->getParameter('id'))), sprintf('Object medicaciones does not exist (%s).', $request->getParameter('id')));
    $this->form = new MedicacionesForm($medicaciones);
	
	$body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));
  }
  
  
  public function executeSave(sfWebRequest $request)
  {
      $auxForm = new MedicacionesForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $medicaciones = MedicacionHandler::retrieveById($id);
        $this->forward404Unless($medicaciones);
        $form = new MedicacionesForm($medicaciones); 
        $isNew = false;
      }
      else
      {
        
        $form = new MedicacionesForm(); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $medicaciones = $form->save();
        $form = new MedicacionesForm($medicaciones);
        $body = $this->getPartial('small_form', array('form'=>$form));
        
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$medicaciones->getId(), 'nombre'=>$medicaciones->getNombre(), 'body' => $body)));
      }
      else
      {
        $body = $this->getPartial('small_form', array('form'=>$form));
        return $this->renderText(mdBasicFunction::basic_json_response(false, array('body' => $body)));
      }
  }
  
  
  public function executeNew(sfWebRequest $request)
  {
    $this->form = new MedicacionesForm();
  
	$body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body))); 
	
  }
  
    public function executeDelete(sfWebRequest $request)
  {
    //$request->checkCSRFProtection();

    $this->forward404Unless($medicacion = MedicacionHandler::retrieveById(array($request->getParameter('id'))), sprintf('Object medicacion does not exist (%s).', $request->getParameter('id')));
    try
    {
      if($medicacion->delete())
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
  
  public function executeShow(sfWebRequest $request)
  {
    $this->medicaciones = Doctrine_Core::getTable('Medicaciones')->find(array($request->getParameter('id')));
    $this->forward404Unless($this->medicaciones);
  }

  

  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new MedicacionesForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }

  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($medicaciones = Doctrine_Core::getTable('Medicaciones')->find(array($request->getParameter('id'))), sprintf('Object medicaciones does not exist (%s).', $request->getParameter('id')));
    $this->form = new MedicacionesForm($medicaciones);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }


  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $medicaciones = $form->save();

      $this->redirect('Medicaciones/edit?id='.$medicaciones->getId());
    }
  }
}
