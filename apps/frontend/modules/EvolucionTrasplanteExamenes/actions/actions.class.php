<?php

/**
 * EvolucionTrasplanteExamenes actions.
 *
 * @package    transplantes
 * @subpackage EvolucionTrasplanteExamenes
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class EvolucionTrasplanteExamenesActions extends sfActions
{
  public function executeNew(sfWebRequest $request)
  {
    $trasplanteId = $request->getParameter('id');
    $this->forward404Unless($trasplanteId);
    $evolucion = new EvolucionTrasplanteExamenes();
    $evolucion->setTrasplanteId($trasplanteId);    
    $this->form = new EvolucionTrasplanteExamenesForm($evolucion);
  }

  public function executeSave(sfWebRequest $request)
  {
      $parameters = $request->getPostParameters();
      
      $auxForm = new EvolucionTrasplanteExamenesForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $EvolucionTrasplanteExamenes = Doctrine::getTable('EvolucionTrasplanteExamenes')->find($id);
        $this->forward404Unless($EvolucionTrasplanteExamenes);
        $form = new EvolucionTrasplanteExamenesForm($EvolucionTrasplanteExamenes); 
        $isNew = false;
      }
      else
      {
        $evolucion = new EvolucionTrasplanteExamenes();
        $evolucion->setTrasplanteId($parameters["trasplante_id"]);
        $form = new EvolucionTrasplanteExamenesForm($evolucion); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $EvolucionTrasplanteExamenesAux = $form->save();
        $form = new EvolucionTrasplanteExamenesForm($EvolucionTrasplanteExamenesAux);
        $body = $this->getPartial("listadoEvolucion", array( "evolucion" => $EvolucionTrasplanteExamenesAux));
        
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$EvolucionTrasplanteExamenesAux->getId(), 'body' => $body)));
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
	$this->evolucion = trasplanteEvolucionHandler::retriveEvolucionTrasplanteExamenes($this->id);
	
	$this->forward404Unless($this->evolucion);
  }
  
  
  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($evolucion_trasplante_examenes = Doctrine_Core::getTable('EvolucionTrasplanteExamenes')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_examenes does not exist (%s).', $request->getParameter('id')));
    $this->form = new EvolucionTrasplanteExamenesForm($evolucion_trasplante_examenes);
  }


  public function executeDelete(sfWebRequest $request)
  {

    $this->forward404Unless($evolucion_trasplante_examenes = Doctrine_Core::getTable('EvolucionTrasplanteExamenes')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_examenes does not exist (%s).', $request->getParameter('id')));

    try
    {
      if($evolucion_trasplante_examenes->delete())
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
