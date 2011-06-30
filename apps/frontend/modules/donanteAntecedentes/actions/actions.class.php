<?php

/**
 * donanteCausaMuerte actions.
 *
 * @package    transplantes
 * @subpackage donanteCausaMuerte
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class donanteAntecedentesActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->list = DonanteHandler::retrieveAllAntecedentes();
    
    $body = $this->getPartial('indexTemplate', array('list'=>$this->list));
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));
  }

  public function executeNew(sfWebRequest $request)
  {
    $this->form = new AntecedentesDeDonanteForm();
    
    $body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));    
  }

  
  public function executeSave(sfWebRequest $request)
  {
      $auxForm = new AntecedentesDeDonanteForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $antecedente = Doctrine_Core::getTable('AntecedentesDeDonante')->find($id);
        $this->forward404Unless($antecedente);
        $form = new AntecedentesDeDonanteForm($antecedente); 
        $isNew = false;
      }
      else
      {
        
        $form = new AntecedentesDeDonanteForm(); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $antecedente = $form->save();
        $form = new AntecedentesDeDonanteForm($antecedente);
        $body = $this->getPartial('small_form', array('form'=>$form));
        
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$antecedente->getId(), 'nombre'=>$antecedente->getNombre(), 'body' => $body)));
      }
      else
      {
        $body = $this->getPartial('small_form', array('form'=>$form));
        return $this->renderText(mdBasicFunction::basic_json_response(false, array('body' => $body)));
      }
  }

  public function executeEdit(sfWebRequest $request)
  {
    $antecedente = Doctrine_Core::getTable('AntecedentesDeDonante')->find($request->getParameter('id'));
    $this->forward404Unless($antecedente);
    $this->form = new AntecedentesDeDonanteForm($antecedente); 
    
    $body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));
  } 

  public function executeDelete(sfWebRequest $request)
  {
    //$request->checkCSRFProtection();

    $this->forward404Unless($antecedente = Doctrine_Core::getTable('AntecedentesDeDonante')->find(array($request->getParameter('id'))), sprintf('Object donante_causa_muerte does not exist (%s).', $request->getParameter('id')));
    try
    {
      if($antecedente->delete())
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
