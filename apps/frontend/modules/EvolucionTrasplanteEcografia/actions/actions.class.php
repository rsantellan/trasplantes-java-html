<?php

/**
 * EvolucionTrasplanteEcografia actions.
 *
 * @package    transplantes
 * @subpackage EvolucionTrasplanteEcografia
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class EvolucionTrasplanteEcografiaActions extends sfActions
{

  public function executeNew(sfWebRequest $request)
  {
    $trasplanteId = $request->getParameter('id');
    $this->forward404Unless($trasplanteId);
    $evolucion = new EvolucionTrasplanteEcografia();
    $evolucion->setTrasplanteId($trasplanteId);    
    $this->form = new EvolucionTrasplanteEcografiaForm($evolucion);
  }

  public function executeSave(sfWebRequest $request)
  {
      $parameters = $request->getPostParameters();
      
      $auxForm = new EvolucionTrasplanteEcografiaForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $EvolucionTrasplanteEcografia = Doctrine::getTable('EvolucionTrasplanteEcografia')->find($id);
        $this->forward404Unless($EvolucionTrasplanteEcografia);
        $form = new EvolucionTrasplanteEcografiaForm($EvolucionTrasplanteEcografia); 
        $isNew = false;
      }
      else
      {
        $evolucion = new EvolucionTrasplanteEcografia();
        $evolucion->setTrasplanteId($parameters["trasplante_id"]);
        $form = new EvolucionTrasplanteEcografiaForm($evolucion); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $EvolucionTrasplanteEcografiaAux = $form->save();
        $form = new EvolucionTrasplanteEcografiaForm($EvolucionTrasplanteEcografiaAux);
        $body = $this->getPartial("listadoEvolucion", array( "evolucion" => $EvolucionTrasplanteEcografiaAux));
        
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$EvolucionTrasplanteEcografiaAux->getId(), 'body' => $body)));
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
	$this->evolucion = trasplanteEvolucionHandler::retriveEvolucionTrasplanteEcografia($this->id);
	
	$this->forward404Unless($this->evolucion);
  }
  
  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($evolucion_trasplante_ecografia = Doctrine_Core::getTable('EvolucionTrasplanteEcografia')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_ecografia does not exist (%s).', $request->getParameter('id')));
    $this->form = new EvolucionTrasplanteEcografiaForm($evolucion_trasplante_ecografia);
  }

  public function executeDelete(sfWebRequest $request)
  {

    $this->forward404Unless($evolucion_trasplante_ecografia = Doctrine_Core::getTable('EvolucionTrasplanteEcografia')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_ecografia does not exist (%s).', $request->getParameter('id')));

    try
    {
      if($evolucion_trasplante_ecografia->delete())
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
