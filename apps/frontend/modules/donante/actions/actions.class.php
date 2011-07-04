<?php

/**
 * donante actions.
 *
 * @package    transplantes
 * @subpackage donante
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class donanteActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->list = DonanteHandler::retrieveAll();
  }

  public function executeShow(sfWebRequest $request)
  {
    $this->donante = Doctrine_Core::getTable('Donante')->find(array($request->getParameter('id')));
    $this->forward404Unless($this->donante);
  }

  public function executeNew(sfWebRequest $request)
  {
    $this->form = new DonanteForm();
	
	$body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body))); 
  }
  
  public function executeSave(sfWebRequest $request)
  {
      $parameters = $request->getPostParameters();
      $seroles_info = $parameters["seroles"];
      $seroles_valores =  $seroles_info["valor"];
      $seroles_array = array();
      foreach($seroles_valores as $tipo)
      {
        foreach($tipo as $valor)
        {
          array_push($seroles_array, $valor);
        }
      }
      //var_dump($seroles_array);
      //die;
      
      $auxForm = new DonanteForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $donante = Doctrine::getTable('Donante')->find($id);
        $this->forward404Unless($donante);
        $form = new DonanteForm($donante); 
        $isNew = false;
      }
      else
      {
        
        $form = new DonanteForm(); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $donante = $form->save();
        Donantehandler::saveSerolesOfDonante($donante->getId(), $seroles_array);
        $form = new DonanteForm($donante);
        $body = $this->getPartial('small_form', array('form'=>$form));
        
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$donante->getId(), 'identificador'=>$donante->getIdentificador(), 'body' => $body)));
      }
      else
      {
        $body = $this->getPartial('small_form', array('form'=>$form));
        return $this->renderText(mdBasicFunction::basic_json_response(false, array('body' => $body)));
      }
  }  

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($donante = Doctrine_Core::getTable('Donante')->find(array($request->getParameter('id'))), sprintf('Object donante does not exist (%s).', $request->getParameter('id')));
    $this->form = new DonanteForm($donante);
	
	$body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));
  }  
  
  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new DonanteForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }



  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($donante = Doctrine_Core::getTable('Donante')->find(array($request->getParameter('id'))), sprintf('Object donante does not exist (%s).', $request->getParameter('id')));
    $this->form = new DonanteForm($donante);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }

  public function executeDelete(sfWebRequest $request)
  {
    $this->forward404Unless($donante = Doctrine_Core::getTable('Donante')->find(array($request->getParameter('id'))), sprintf('Object donante does not exist (%s).', $request->getParameter('id')));
    $donante->delete();

	try
	{
	  if($donante->delete())
	  {  
		return $this->renderText(mdBasicFunction::basic_json_response(true, array('id'=>$request->getParameter('id'))));
	  }
	  else
	  {
		return $this->renderText(mdBasicFunction::basic_json_response(false, array()));
	  }	  
	}catch(Exception $e)
	{
	  return $this->renderText(mdBasicFunction::basic_json_response(false, array('error_code' => $e->getCode())));
	}
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $donante = $form->save();

      $this->redirect('donante/edit?id='.$donante->getId());
    }
  }
}
