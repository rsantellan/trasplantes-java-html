<?php

/**
 * EvolucionTrasplanteCmv actions.
 *
 * @package    transplantes
 * @subpackage EvolucionTrasplanteCmv
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class EvolucionTrasplanteCmvActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->evolucion_trasplante_cmvs = Doctrine_Core::getTable('EvolucionTrasplanteCmv')
      ->createQuery('a')
      ->execute();
  }

  public function executeNew(sfWebRequest $request)
  {
    $trasplanteId = $request->getParameter('id');
    $this->forward404Unless($trasplanteId);
    $evolucion = new EvolucionTrasplanteCmv();
    $evolucion->setTrasplanteId($trasplanteId);
    $this->form = new EvolucionTrasplanteCmvForm($evolucion);
  }

  public function executeSave(sfWebRequest $request)
  {
      $parameters = $request->getPostParameters();
      
      $auxForm = new EvolucionTrasplanteCmvForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $EvolucionTrasplanteCmv = Doctrine::getTable('EvolucionTrasplanteCmv')->find($id);
        $this->forward404Unless($EvolucionTrasplanteCmv);
        $form = new EvolucionTrasplanteCmvForm($EvolucionTrasplanteCmv); 
        $isNew = false;
      }
      else
      {
        $evolucion = new EvolucionTrasplanteCmv();
        $evolucion->setTrasplanteId($parameters["trasplante_id"]);
        $form = new EvolucionTrasplanteCmvForm($evolucion); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $EvolucionTrasplanteCmvAux = $form->save();
        $form = new EvolucionTrasplanteCmvForm($EvolucionTrasplanteCmvAux);
        $body = $this->getPartial("listadoEvolucion", array( "evolucion" => $EvolucionTrasplanteCmvAux));
        
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$EvolucionTrasplanteCmvAux->getId(), 'body' => $body)));
      }
      else
      {
        $body = $this->getPartial('small_form', array('form'=>$form));
        return $this->renderText(mdBasicFunction::basic_json_response(false, array('body' => $body)));
      }
  }
  
  public function executeMostrar(sfWebRequest $request)
  {
	$this->id = $request->getParameter('id');
	$this->evolucion = trasplanteEvolucionHandler::retriveEvolucionTrasplanteCmv($this->id);
	
	$this->forward404Unless($this->evolucion);
  }
  
  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new EvolucionTrasplanteCmvForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($evolucion_trasplante_cmv = Doctrine_Core::getTable('EvolucionTrasplanteCmv')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_cmv does not exist (%s).', $request->getParameter('id')));
    $this->form = new EvolucionTrasplanteCmvForm($evolucion_trasplante_cmv);
  }

  
  public function executeDelete(sfWebRequest $request)
  {
    //$request->checkCSRFProtection();

    $this->forward404Unless($evolucion_trasplante_cmv = Doctrine_Core::getTable('EvolucionTrasplanteCmv')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_cmv does not exist (%s).', $request->getParameter('id')));
    try
    {
      if($evolucion_trasplante_cmv->delete())
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
