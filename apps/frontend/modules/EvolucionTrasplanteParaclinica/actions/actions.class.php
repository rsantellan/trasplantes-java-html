<?php

/**
 * EvolucionTrasplanteParaclinica actions.
 *
 * @package    transplantes
 * @subpackage EvolucionTrasplanteParaclinica
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class EvolucionTrasplanteParaclinicaActions extends sfActions
{

  public function executeNew(sfWebRequest $request)
  {
    $trasplanteId = $request->getParameter('id');
    $this->forward404Unless($trasplanteId);
    $evolucion = new EvolucionTrasplanteParaclinica();
    $evolucion->setTrasplanteId($trasplanteId);
    $this->form = new EvolucionTrasplanteParaclinicaForm($evolucion);
  }

  public function executeSave(sfWebRequest $request)
  {
      $parameters = $request->getPostParameters();
      
      $auxForm = new EvolucionTrasplanteParaclinicaForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $EvolucionTrasplanteParaclinica = Doctrine::getTable('EvolucionTrasplanteParaclinica')->find($id);
        $this->forward404Unless($EvolucionTrasplanteParaclinica);
        $form = new EvolucionTrasplanteParaclinicaForm($EvolucionTrasplanteParaclinica); 
        $isNew = false;
      }
      else
      {
        $evolucion = new EvolucionTrasplanteParaclinica();
        $evolucion->setTrasplanteId($parameters["trasplante_id"]);
        $form = new EvolucionTrasplanteParaclinicaForm($evolucion); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $EvolucionTrasplanteParaclinicaAux = $form->save();
        $form = new EvolucionTrasplanteParaclinicaForm($EvolucionTrasplanteParaclinicaAux);
        $body = $this->getPartial("listadoEvolucion", array( "evolucion" => $EvolucionTrasplanteParaclinicaAux));
        
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$EvolucionTrasplanteParaclinicaAux->getId(), 'body' => $body)));
      }
      else
      {
        $body = $this->getPartial('small_form', array('form'=>$form));
        return $this->renderText(mdBasicFunction::basic_json_response(false, array('body' => $body)));
      }
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($evolucion_trasplante_paraclinica = Doctrine_Core::getTable('EvolucionTrasplanteParaclinica')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_paraclinica does not exist (%s).', $request->getParameter('id')));
    $this->form = new EvolucionTrasplanteParaclinicaForm($evolucion_trasplante_paraclinica);
  }
  

  public function executeMostrar(sfWebRequest $request)
  {
	$this->id = $request->getParameter('id');
	$this->evolucion = trasplanteEvolucionHandler::retriveEvolucionTrasplanteParaclinicas($this->id);
	
	$this->forward404Unless($this->evolucion);
  }    
  
  public function executeDelete(sfWebRequest $request)
  {
    $this->forward404Unless($evolucion_trasplante_paraclinica = Doctrine_Core::getTable('EvolucionTrasplanteParaclinica')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_paraclinica does not exist (%s).', $request->getParameter('id')));
    try
    {
      if($evolucion_trasplante_paraclinica->delete())
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
