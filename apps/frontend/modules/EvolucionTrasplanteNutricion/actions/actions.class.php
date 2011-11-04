<?php

/**
 * EvolucionTrasplanteNutricion actions.
 *
 * @package    transplantes
 * @subpackage EvolucionTrasplanteNutricion
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class EvolucionTrasplanteNutricionActions extends sfActions
{

  public function executeNew(sfWebRequest $request)
  {
    $trasplanteId = $request->getParameter('id');
    $this->forward404Unless($trasplanteId);
    $evolucion = new EvolucionTrasplanteNutricion();
    $evolucion->setTrasplanteId($trasplanteId);
    $this->form = new EvolucionTrasplanteNutricionForm($evolucion);
  }

  public function executeSave(sfWebRequest $request)
  {
      $parameters = $request->getPostParameters();
      
      $auxForm = new EvolucionTrasplanteNutricionForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $EvolucionTrasplanteNutricion = Doctrine::getTable('EvolucionTrasplanteNutricion')->find($id);
        $this->forward404Unless($EvolucionTrasplanteNutricion);
        $form = new EvolucionTrasplanteNutricionForm($EvolucionTrasplanteNutricion); 
        $isNew = false;
      }
      else
      {
        $evolucion = new EvolucionTrasplanteNutricion();
        $evolucion->setTrasplanteId($parameters["trasplante_id"]);
        $form = new EvolucionTrasplanteNutricionForm($evolucion); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $EvolucionTrasplanteNutricionAux = $form->save();
        $form = new EvolucionTrasplanteNutricionForm($EvolucionTrasplanteNutricionAux);
        $body = $this->getPartial("listadoEvolucion", array( "evolucion" => $EvolucionTrasplanteNutricionAux));
        
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$EvolucionTrasplanteNutricionAux->getId(), 'body' => $body)));
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
	$this->evolucion = trasplanteEvolucionHandler::retriveEvolucionTrasplanteNutricion($this->id);
	
	$this->forward404Unless($this->evolucion);
  }  

  public function executeDelete(sfWebRequest $request)
  {
    $this->forward404Unless($evolucion_trasplante_nutricion = Doctrine_Core::getTable('EvolucionTrasplanteNutricion')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_nutricion does not exist (%s).', $request->getParameter('id')));
    try
    {
      if($evolucion_trasplante_nutricion->delete())
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
  
// De aca para abajo... mmmm no deberia ir  
  
  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new EvolucionTrasplanteNutricionForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($evolucion_trasplante_nutricion = Doctrine_Core::getTable('EvolucionTrasplanteNutricion')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_nutricion does not exist (%s).', $request->getParameter('id')));
    $this->form = new EvolucionTrasplanteNutricionForm($evolucion_trasplante_nutricion);
  }

  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($evolucion_trasplante_nutricion = Doctrine_Core::getTable('EvolucionTrasplanteNutricion')->find(array($request->getParameter('id'))), sprintf('Object evolucion_trasplante_nutricion does not exist (%s).', $request->getParameter('id')));
    $this->form = new EvolucionTrasplanteNutricionForm($evolucion_trasplante_nutricion);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }



  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $evolucion_trasplante_nutricion = $form->save();

      $this->redirect('EvolucionTrasplanteNutricion/edit?id='.$evolucion_trasplante_nutricion->getId());
    }
  }
}
