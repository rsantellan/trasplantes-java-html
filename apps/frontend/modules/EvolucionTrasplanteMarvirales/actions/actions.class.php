<?php

/**
 * EvolucionTrasplanteMarvirales actions.
 *
 * @package    transplantes
 * @subpackage EvolucionTrasplanteMarvirales
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class EvolucionTrasplanteMarviralesActions extends sfActions
{

  public function executeNew(sfWebRequest $request)
  {
    $trasplanteId = $request->getParameter('id');
    $this->forward404Unless($trasplanteId);
    $evolucion = new EvolucionTrasplanteMarvirales();
    $evolucion->setTrasplanteId($trasplanteId);    
    $this->form = new EvolucionTrasplanteMarviralesForm($evolucion);
  }

  
  public function executeSave(sfWebRequest $request)
  {
      $parameters = $request->getPostParameters();
      
      $auxForm = new EvolucionTrasplanteMarviralesForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $EvolucionTrasplanteMarvirales = Doctrine::getTable('EvolucionTrasplanteMarvirales')->find($id);
        $this->forward404Unless($EvolucionTrasplanteMarvirales);
        $form = new EvolucionTrasplanteMarviralesForm($EvolucionTrasplanteMarvirales); 
        $isNew = false;
      }
      else
      {
        $evolucion = new EvolucionTrasplanteMarvirales();
        $evolucion->setTrasplanteId($parameters["trasplante_id"]);
        $form = new EvolucionTrasplanteMarviralesForm($evolucion); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $EvolucionTrasplanteMarviralesAux = $form->save();
        $form = new EvolucionTrasplanteMarviralesForm($EvolucionTrasplanteMarviralesAux);
        $body = $this->getPartial("listadoEvolucion", array( "evolucion" => $EvolucionTrasplanteMarviralesAux));
        
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$EvolucionTrasplanteMarviralesAux->getId(), 'body' => $body)));
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
	$this->evolucion = trasplanteEvolucionHandler::retriveEvolucionTrasplanteMarvirales($this->id);
	
	$this->forward404Unless($this->evolucion);
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($evolucion_trasplante_marvirales = Doctrine_Core::getTable('EvolucionTrasplanteMarvirales')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_marvirales does not exist (%s).', $request->getParameter('id')));
    $this->form = new EvolucionTrasplanteMarviralesForm($evolucion_trasplante_marvirales);
  }


  public function executeDelete(sfWebRequest $request)
  {
 
    $this->forward404Unless($evolucion_trasplante_marvirales = Doctrine_Core::getTable('EvolucionTrasplanteMarvirales')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_marvirales does not exist (%s).', $request->getParameter('id')));
    try
    {
      if($evolucion_trasplante_marvirales->delete())
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
