<?php

/**
 * EvolucionTrasplanteEcodopler actions.
 *
 * @package    transplantes
 * @subpackage EvolucionTrasplanteEcodopler
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class EvolucionTrasplanteEcodoplerActions extends sfActions
{

  public function executeNew(sfWebRequest $request)
  {
    $trasplanteId = $request->getParameter('id');
    $this->forward404Unless($trasplanteId);
    $evolucion = new EvolucionTrasplanteEcodopler();
    $evolucion->setTrasplanteId($trasplanteId);      
    $this->form = new EvolucionTrasplanteEcodoplerForm($evolucion);
  }

  public function executeSave(sfWebRequest $request)
  {
      $parameters = $request->getPostParameters();
      
      $auxForm = new EvolucionTrasplanteEcodoplerForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $EvolucionTrasplanteEcodopler = Doctrine::getTable('EvolucionTrasplanteEcodopler')->find($id);
        $this->forward404Unless($EvolucionTrasplanteEcodopler);
        $form = new EvolucionTrasplanteEcodoplerForm($EvolucionTrasplanteEcodopler); 
        $isNew = false;
      }
      else
      {
        $evolucion = new EvolucionTrasplanteEcodopler();
        $evolucion->setTrasplanteId($parameters["trasplante_id"]);
        $form = new EvolucionTrasplanteEcodoplerForm($evolucion); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $EvolucionTrasplanteEcodoplerAux = $form->save();
        $form = new EvolucionTrasplanteEcodoplerForm($EvolucionTrasplanteEcodoplerAux);
        $body = $this->getPartial("listadoEvolucion", array( "evolucion" => $EvolucionTrasplanteEcodoplerAux));
        
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$EvolucionTrasplanteEcodoplerAux->getId(), 'body' => $body)));
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
	$this->evolucion = trasplanteEvolucionHandler::retriveEvolucionTrasplanteEcodopler($this->id);
	
	$this->forward404Unless($this->evolucion);
  }  
  

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($evolucion_trasplante_ecodopler = Doctrine_Core::getTable('EvolucionTrasplanteEcodopler')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_ecodopler does not exist (%s).', $request->getParameter('id')));
    $this->form = new EvolucionTrasplanteEcodoplerForm($evolucion_trasplante_ecodopler);
  }

  public function executeDelete(sfWebRequest $request)
  {
    $this->forward404Unless($evolucion_trasplante_ecodopler = Doctrine_Core::getTable('EvolucionTrasplanteEcodopler')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_ecodopler does not exist (%s).', $request->getParameter('id')));
    
    try
    {
      if($evolucion_trasplante_ecodopler->delete())
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

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $evolucion_trasplante_ecodopler = $form->save();

      $this->redirect('EvolucionTrasplanteEcodopler/edit?id='.$evolucion_trasplante_ecodopler->getId());
    }
  }
}
