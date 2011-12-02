<?php

/**
 * InjertoEvolucion actions.
 *
 * @package    transplantes
 * @subpackage InjertoEvolucion
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class InjertoEvolucionActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->trasplanteId = $request->getParameter('id');
    $this->forward404Unless($this->trasplanteId);
    $this->evolucionTrasplante = injertoEvolucionHandler::retrieveInjertoEvolucionOfTrasplanteEnTrasplante($this->trasplanteId);
    $this->evolucionEvolucion = injertoEvolucionHandler::retrieveInjertoEvolucionOfTrasplanteEnEvolucion($this->trasplanteId);
    $this->injerto_evolucions = array();
  }

  public function executeShow(sfWebRequest $request)
  {
    $this->injerto_evolucion = Doctrine_Core::getTable('InjertoEvolucion')->find(array($request->getParameter('id')));
    $this->forward404Unless($this->injerto_evolucion);
  }

  public function executeNew(sfWebRequest $request)
  {
    $this->form = new InjertoEvolucionForm();
  }

  public function executeNewEvolucion(sfWebRequest $request)
  {
    $trasplanteId = $request->getParameter('id');
    $this->forward404Unless($trasplanteId);
    $injerto = new InjertoEvolucion();
    $injerto->setTrasplanteId($trasplanteId);
    $injerto->setEnTrasplante(false);
    $this->form = new InjertoEvolucionForm($injerto);
    $this->setTemplate("new");
  }

  public function executeNewTrasplante(sfWebRequest $request)
  {
    $trasplanteId = $request->getParameter('id');
    $this->forward404Unless($trasplanteId);
    $injerto = new InjertoEvolucion();
    $injerto->setTrasplanteId($trasplanteId);
    $injerto->setEnTrasplante(true);
    $this->form = new InjertoEvolucionForm($injerto);
    $this->setTemplate("new");
  }
  
  
  public function executeSave(sfWebRequest $request)
  {
      $parameters = $request->getPostParameters();
      
      $auxForm = new InjertoEvolucionForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $InjertoEvolucion = Doctrine::getTable('InjertoEvolucion')->find($id);
        $this->forward404Unless($InjertoEvolucion);
        $form = new InjertoEvolucionForm($InjertoEvolucion); 
        $isNew = false;
      }
      else
      {
        $evolucion = new InjertoEvolucion();
        $evolucion->setTrasplanteId($parameters["trasplante_id"]);
        $form = new InjertoEvolucionForm($evolucion); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $InjertoEvolucionAux = $form->save();
        $form = new InjertoEvolucionForm($InjertoEvolucionAux);
        $body = $this->getPartial("injertoEvolucionLista", array( "injerto" => $InjertoEvolucionAux));
        
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$InjertoEvolucionAux->getId(), 'body' => $body, 'trasplante' => $InjertoEvolucionAux->getEnTrasplante())));
      }
      else
      {
        $body = $this->getPartial('small_form', array('form'=>$form));
        return $this->renderText(mdBasicFunction::basic_json_response(false, array('body' => $body)));
      }
  }
  
  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new InjertoEvolucionForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($injerto_evolucion = Doctrine_Core::getTable('InjertoEvolucion')->find(array($request->getParameter('id'))), sprintf('Object injerto_evolucion does not exist (%s).', $request->getParameter('id')));
    $this->form = new InjertoEvolucionForm($injerto_evolucion);
  }

  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($injerto_evolucion = Doctrine_Core::getTable('InjertoEvolucion')->find(array($request->getParameter('id'))), sprintf('Object injerto_evolucion does not exist (%s).', $request->getParameter('id')));
    $this->form = new InjertoEvolucionForm($injerto_evolucion);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }

  public function executeDelete(sfWebRequest $request)
  {
    $this->forward404Unless($cmv = Doctrine_Core::getTable('InjertoEvolucion')->find(array($request->getParameter('id'))), sprintf('Object injerto_evolucion does not exist (%s).', $request->getParameter('id')));
    try
    {
      if($cmv->delete())
      {  
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('id'=>$request->getParameter('id'))));
      }
      else
      {
        return $this->renderText(mdBasicFunction::basic_json_response(false, array()));
      }      
    }catch(Exception $e)
    {
      //throw $e;
      return $this->renderText(mdBasicFunction::basic_json_response(false, array("error" => $e->getCode())));
    }
    /*
    $request->checkCSRFProtection();

    $this->forward404Unless($injerto_evolucion = Doctrine_Core::getTable('InjertoEvolucion')->find(array($request->getParameter('id'))), sprintf('Object injerto_evolucion does not exist (%s).', $request->getParameter('id')));
    $injerto_evolucion->delete();

    $this->redirect('InjertoEvolucion/index');
    */ 
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $injerto_evolucion = $form->save();

      $this->redirect('InjertoEvolucion/edit?id='.$injerto_evolucion->getId());
    }
  }
}
