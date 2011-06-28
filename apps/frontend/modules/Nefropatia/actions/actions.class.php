<?php

/**
 * Nefropatia actions.
 *
 * @package    transplantes
 * @subpackage Nefropatia
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class NefropatiaActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->list = NefropatiaHandler::retrieveAll();
  }

  public function executeShow(sfWebRequest $request)
  {
    $this->nefropatia = Doctrine_Core::getTable('Nefropatia')->find(array($request->getParameter('id')));
    $this->forward404Unless($this->nefropatia);
  }

  public function executeNew(sfWebRequest $request)
  {
    $this->form = new NefropatiaForm();
    
    $body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));    
  }

  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new NefropatiaForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($nefropatia = Doctrine_Core::getTable('Nefropatia')->find(array($request->getParameter('id'))), sprintf('Object nefropatia does not exist (%s).', $request->getParameter('id')));
    $this->form = new NefropatiaForm($nefropatia);
    
    $body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));
    
  }

  public function executeSave(sfWebRequest $request)
  {
      $auxForm = new NefropatiaForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $nefropatia = Doctrine::getTable('Nefropatia')->find($id);
        $this->forward404Unless($nefropatia);
        $form = new NefropatiaForm($nefropatia); 
        $isNew = false;
      }
      else
      {
        
        $form = new NefropatiaForm(); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $nefropatia = $form->save();
        $form = new NefropatiaForm($nefropatia);
        $body = $this->getPartial('small_form', array('form'=>$form));
        
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$nefropatia->getId(), 'nombre'=>$nefropatia->getNombre(), 'body' => $body)));
      }
      else
      {
        $body = $this->getPartial('small_form', array('form'=>$form));
        return $this->renderText(mdBasicFunction::basic_json_response(false, array('body' => $body)));
      }
  }
  
  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($nefropatia = Doctrine_Core::getTable('Nefropatia')->find(array($request->getParameter('id'))), sprintf('Object nefropatia does not exist (%s).', $request->getParameter('id')));
    $this->form = new NefropatiaForm($nefropatia);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }

  public function executeDelete(sfWebRequest $request)
  {
    //$request->checkCSRFProtection();
    //die('jaja');
    
    $this->forward404Unless($nefropatia = Doctrine_Core::getTable('Nefropatia')->find(array($request->getParameter('id'))), sprintf('Object nefropatia does not exist (%s).', $request->getParameter('id')));
    try
    {
      if($nefropatia->delete())
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

    
    //$this->redirect('Nefropatia/index');
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $nefropatia = $form->save();

      $this->redirect('Nefropatia/edit?id='.$nefropatia->getId());
    }
  }
}
