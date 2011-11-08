<?php

/**
 * EvolucionTrasplanteTxtorax actions.
 *
 * @package    transplantes
 * @subpackage EvolucionTrasplanteTxtorax
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class EvolucionTrasplanteTxtoraxActions extends sfActions
{
  public function executeNew(sfWebRequest $request)
  {
    $trasplanteId = $request->getParameter('id');
    $this->forward404Unless($trasplanteId);
    $evolucion = new EvolucionTrasplanteTxtorax();
    $evolucion->setTrasplanteId($trasplanteId);     
    $this->form = new EvolucionTrasplanteTxtoraxForm($evolucion);
  }
  
  public function executeSave(sfWebRequest $request)
  {
      $parameters = $request->getPostParameters();
      
      $auxForm = new EvolucionTrasplanteTxtoraxForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $EvolucionTrasplanteTxtorax = Doctrine::getTable('EvolucionTrasplanteTxtorax')->find($id);
        $this->forward404Unless($EvolucionTrasplanteTxtorax);
        $form = new EvolucionTrasplanteTxtoraxForm($EvolucionTrasplanteTxtorax); 
        $isNew = false;
      }
      else
      {
        $evolucion = new EvolucionTrasplanteTxtorax();
        $evolucion->setTrasplanteId($parameters["trasplante_id"]);
        $form = new EvolucionTrasplanteTxtoraxForm($evolucion); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $EvolucionTrasplanteTxtoraxAux = $form->save();
        $form = new EvolucionTrasplanteTxtoraxForm($EvolucionTrasplanteTxtoraxAux);
        $body = $this->getPartial("listadoEvolucion", array( "evolucion" => $EvolucionTrasplanteTxtoraxAux));
        
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$EvolucionTrasplanteTxtoraxAux->getId(), 'body' => $body)));
      }
      else
      {
        $body = $this->getPartial('small_form', array('form'=>$form));
        return $this->renderText(mdBasicFunction::basic_json_response(false, array('body' => $body)));
      }
  }


  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($evolucion_trasplante_txtorax = Doctrine_Core::getTable('EvolucionTrasplanteTxtorax')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_txtorax does not exist (%s).', $request->getParameter('id')));
    $this->form = new EvolucionTrasplanteTxtoraxForm($evolucion_trasplante_txtorax);
  }


  public function executeDelete(sfWebRequest $request)
  {

    $this->forward404Unless($evolucion_trasplante_txtorax = Doctrine_Core::getTable('EvolucionTrasplanteTxtorax')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_txtorax does not exist (%s).', $request->getParameter('id')));
    try
    {
      if($evolucion_trasplante_txtorax->delete())
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
	$this->evolucion = trasplanteEvolucionHandler::retriveEvolucionTrasplanteTxTorax($this->id);
	
	$this->forward404Unless($this->evolucion);
  }
}
