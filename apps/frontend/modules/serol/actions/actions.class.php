<?php

/**
 * donanteCausaMuerte actions.
 *
 * @package    transplantes
 * @subpackage donanteCausaMuerte
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class serolActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->list = serolHandler::retrieveAllSeroles();
    $this->trasplante = $request->getParameter('trasplante', 0);
    if($this->trasplante == 0)
	{
	  $body = $this->getPartial('indexTemplate', array('list'=>$this->list, 'trasplante' => $this->trasplante));
	  return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));	  
	}
	
  }
/*
  public function executeShow(sfWebRequest $request)
  {
    $this->donante_causa_muerte = Doctrine_Core::getTable('DonanteCausaMuerte')->find(array($request->getParameter('id')));
    $this->forward404Unless($this->donante_causa_muerte);
  }
*/
  public function executeNew(sfWebRequest $request)
  {
    $this->form = new SerolForm();
    
    $body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));    
  }

  
  public function executeSave(sfWebRequest $request)
  {
      $auxForm = new SerolForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $serol = Doctrine_Core::getTable('Serol')->find($id);
        $this->forward404Unless($serol);
        $form = new SerolForm($serol);
        $isNew = false;
      }
      else
      {
        
        $form = new SerolForm(); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $serol = $form->save();
        $form = new SerolForm($serol);
        $body = $this->getPartial('small_form', array('form'=>$form));
        $serol_div = $this->getPartial("donante/container_seroles", array('serol' => $serol, 'serolesAsociados' => array()));
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$serol->getId(), 'nombre'=>$serol->getTipo(), 'body' => $body, 'serol_div' => $serol_div)));
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
    
    $this->forward404Unless($serol = Doctrine_Core::getTable('Serol')->find(array($request->getParameter('id'))), sprintf('Object donante_causa_muerte does not exist (%s).', $request->getParameter('id')));
    try
    {
      if($serol->delete())
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
    $this->forward404Unless($serol = Doctrine_Core::getTable('Serol')->find(array($request->getParameter('id'))), sprintf('Object donante_causa_muerte does not exist (%s).', $request->getParameter('id')));
    $this->form = new SerolForm($serol);
	
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
