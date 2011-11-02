<?php

/**
 * EvolucionTrasplanteEcoCardio actions.
 *
 * @package    transplantes
 * @subpackage EvolucionTrasplanteEcoCardio
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class EvolucionTrasplanteEcoCardioActions extends sfActions
{
  
  public function executeNew(sfWebRequest $request)
  {
    $trasplanteId = $request->getParameter('id');
    $this->forward404Unless($trasplanteId);
    $evolucion = new EvolucionTrasplanteEcoCardio();
    $evolucion->setTrasplanteId($trasplanteId);
    $this->form = new EvolucionTrasplanteEcoCardioForm($evolucion);
  }
  
  public function executeSave(sfWebRequest $request)
  {
      $parameters = $request->getPostParameters();
      
      $auxForm = new EvolucionTrasplanteEcoCardioForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $EvolucionTrasplanteEcocardio = Doctrine::getTable('EvolucionTrasplanteEcoCardio')->find($id);
        $this->forward404Unless($EvolucionTrasplanteEcocardio);
        $form = new EvolucionTrasplanteEcoCardioForm($EvolucionTrasplanteEcocardio); 
        $isNew = false;
      }
      else
      {
        $evolucion = new EvolucionTrasplanteEcoCardio();
        $evolucion->setTrasplanteId($parameters["trasplante_id"]);
        $form = new EvolucionTrasplanteEcoCardioForm($evolucion); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $EvolucionTrasplanteEcocardioAux = $form->save();
        $form = new EvolucionTrasplanteEcoCardioForm($EvolucionTrasplanteEcocardioAux);
        $body = $this->getPartial("listadoEvolucion", array( "evolucion" => $EvolucionTrasplanteEcocardioAux));
        
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$EvolucionTrasplanteEcocardioAux->getId(), 'body' => $body)));
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

    $this->forward404Unless($evolucion_trasplante_ecocardio = Doctrine_Core::getTable('EvolucionTrasplanteEcoCardio')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_cmv does not exist (%s).', $request->getParameter('id')));
    try
    {
      if($evolucion_trasplante_ecocardio->delete())
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
  
  
  public function executeMostrar(sfWebRequest $request)
  {
	$this->id = $request->getParameter('id');
	$this->evolucion = trasplanteEvolucionHandler::retriveEvolucionTrasplanteEcocardio($this->id);
	
	$this->forward404Unless($this->evolucion);
  }
  
  
  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($evolucion_trasplante_eco_cardio = Doctrine_Core::getTable('EvolucionTrasplanteEcoCardio')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_eco_cardio does not exist (%s).', $request->getParameter('id')));
    $this->form = new EvolucionTrasplanteEcoCardioForm($evolucion_trasplante_eco_cardio);
  }
  /*
  public function executeIndex(sfWebRequest $request)
  {
    $this->evolucion_trasplante_eco_cardios = Doctrine_Core::getTable('EvolucionTrasplanteEcoCardio')
      ->createQuery('a')
      ->execute();
  }

  public function executeShow(sfWebRequest $request)
  {
    $this->evolucion_trasplante_eco_cardio = Doctrine_Core::getTable('EvolucionTrasplanteEcoCardio')->find(array($request->getParameter('id')));
    $this->forward404Unless($this->evolucion_trasplante_eco_cardio);
  }



  
  
  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new EvolucionTrasplanteEcoCardioForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }



  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($evolucion_trasplante_eco_cardio = Doctrine_Core::getTable('EvolucionTrasplanteEcoCardio')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_eco_cardio does not exist (%s).', $request->getParameter('id')));
    $this->form = new EvolucionTrasplanteEcoCardioForm($evolucion_trasplante_eco_cardio);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }

  public function executeDelete(sfWebRequest $request)
  {
    $request->checkCSRFProtection();

    $this->forward404Unless($evolucion_trasplante_eco_cardio = Doctrine_Core::getTable('EvolucionTrasplanteEcoCardio')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_eco_cardio does not exist (%s).', $request->getParameter('id')));
    $evolucion_trasplante_eco_cardio->delete();

    $this->redirect('EvolucionTrasplanteEcoCardio/index');
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $evolucion_trasplante_eco_cardio = $form->save();

      $this->redirect('EvolucionTrasplanteEcoCardio/edit?id='.$evolucion_trasplante_eco_cardio->getId());
    }
  }*/
}
