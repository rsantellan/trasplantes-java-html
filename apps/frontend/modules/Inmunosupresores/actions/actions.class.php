<?php

/**
 * donanteCausaMuerte actions.
 *
 * @package    transplantes
 * @subpackage donanteCausaMuerte
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class InmunosupresoresActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->list = DonanteHandler::retrieveAllOrganos();
    
    $body = $this->getPartial('indexTemplate', array('list'=>$this->list));
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));
  }

  public function executeShow(sfWebRequest $request)
  {
    $this->organo = Doctrine_Core::getTable('Organos')->find(array($request->getParameter('id')));
    $this->forward404Unless($this->organo);
  }

  public function executeNew(sfWebRequest $request)
  {
    $this->form = new OrganosForm();
    
    $body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));    
  }

  
  public function executeSave(sfWebRequest $request)
  {
      $auxForm = new OrganosForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $organo = Doctrine_Core::getTable('Organos')->find($id);
        $this->forward404Unless($organo);
        $form = new OrganosForm($organo); 
        $isNew = false;
      }
      else
      {
        
        $form = new OrganosForm(); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $organo = $form->save();
        $form = new OrganosForm($organo);
        $body = $this->getPartial('small_form', array('form'=>$form));
        
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$organo->getId(), 'nombre'=>$organo->getNombre(), 'body' => $body)));
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

    $this->forward404Unless($organo = Doctrine_Core::getTable('Organos')->find(array($request->getParameter('id'))), sprintf('Object donante_causa_muerte does not exist (%s).', $request->getParameter('id')));
    try
    {
      if($organo->delete())
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
    $organo = Doctrine_Core::getTable('Organos')->find($request->getParameter('id'));
    $this->forward404Unless($organo);
    
    $this->form = new OrganosForm($organo);
    
    $body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));
  }  

}
