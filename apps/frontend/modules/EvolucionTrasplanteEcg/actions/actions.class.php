<?php

/**
 * EvolucionTrasplanteEcg actions.
 *
 * @package    transplantes
 * @subpackage EvolucionTrasplanteEcg
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class EvolucionTrasplanteEcgActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->evolucion_trasplante_ecgs = Doctrine_Core::getTable('EvolucionTrasplanteEcg')
      ->createQuery('a')
      ->execute();
  }

  public function executeNew(sfWebRequest $request)
  {
    $trasplanteId = $request->getParameter('id');
    $this->forward404Unless($trasplanteId);
    $evolucion = new EvolucionTrasplanteEcg();
    $evolucion->setTrasplanteId($trasplanteId);
    $this->form = new EvolucionTrasplanteEcgForm($evolucion);
  }

  
  public function executeSave(sfWebRequest $request)
  {
      $parameters = $request->getPostParameters();
      
      $auxForm = new EvolucionTrasplanteEcgForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $EvolucionTrasplanteEcg = Doctrine::getTable('EvolucionTrasplanteEcg')->find($id);
        $this->forward404Unless($EvolucionTrasplanteEcg);
        $form = new EvolucionTrasplanteEcgForm($EvolucionTrasplanteEcg); 
        $isNew = false;
      }
      else
      {
        $evolucion = new EvolucionTrasplanteEcg();
        $evolucion->setTrasplanteId($parameters["trasplante_id"]);
        $form = new EvolucionTrasplanteEcgForm($evolucion); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $EvolucionTrasplanteEcgAux = $form->save();
        $form = new EvolucionTrasplanteEcgForm($EvolucionTrasplanteEcgAux);
        $body = $this->getPartial("listadoEvolucion", array( "evolucion" => $EvolucionTrasplanteEcgAux));
        
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$EvolucionTrasplanteEcgAux->getId(), 'body' => $body)));
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
	$this->evolucion = trasplanteEvolucionHandler::retriveEvolucionTrasplanteEcg($this->id);
	
	$this->forward404Unless($this->evolucion);
  }
  
  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($evolucion_trasplante_ecg = Doctrine_Core::getTable('EvolucionTrasplanteEcg')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_cmv does not exist (%s).', $request->getParameter('id')));
    $this->form = new EvolucionTrasplanteEcgForm($evolucion_trasplante_ecg);
  }
  
  public function executeDelete(sfWebRequest $request)
  {
    //$request->checkCSRFProtection();

    $this->forward404Unless($evolucion_trasplante_ecg = Doctrine_Core::getTable('EvolucionTrasplanteEcg')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_cmv does not exist (%s).', $request->getParameter('id')));
    try
    {
      if($evolucion_trasplante_ecg->delete())
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
