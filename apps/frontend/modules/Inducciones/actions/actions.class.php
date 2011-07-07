<?php

/**
 * donanteCausaMuerte actions.
 *
 * @package    transplantes
 * @subpackage donanteCausaMuerte
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class InduccionesActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->list = InduccionesHandler::retrieveAll();
	//Induccion
  }

  public function executeNew(sfWebRequest $request)
  {
    $this->form = new InduccionForm();
    
    $body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));    
  }

  
  public function executeSave(sfWebRequest $request)
  {
      $auxForm = new InduccionForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
		$induccion = Doctrine_Core::getTable('Induccion')->find($id);
		$this->forward404Unless($induccion);
		$form = new InduccionForm($induccion);		
        $isNew = false;
      }
      else
      {
        
        $form = new InduccionForm(); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $induccion = $form->save();
        $form = new InduccionForm($induccion);
        $body = $this->getPartial('small_form', array('form'=>$form));
        
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$induccion->getId(), 'nombre'=>$induccion->getNombre(), 'body' => $body)));
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

    $this->forward404Unless($induccion = Doctrine_Core::getTable('Induccion')->find(array($request->getParameter('id'))), sprintf('Object Induccion does not exist (%s).', $request->getParameter('id')));
    try
    {
      if($induccion->delete())
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
    $induccion = Doctrine_Core::getTable('Induccion')->find($request->getParameter('id'));
    $this->forward404Unless($induccion);
    
    $this->form = new InduccionForm($induccion);
    
    $body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));
  }  

}
