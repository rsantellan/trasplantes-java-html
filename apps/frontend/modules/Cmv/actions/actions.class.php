<?php

/**
 * Cmv actions.
 *
 * @package    transplantes
 * @subpackage Cmv
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class CmvActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->id = $request->getParameter('id');
    $this->forward404Unless($this->id);
    $this->cmvs = cmvHandler::retrieveByTrasplanteId($this->id);
  }

  public function executeShow(sfWebRequest $request)
  {
    $this->cmv = Doctrine_Core::getTable('Cmv')->find(array($request->getParameter('id')));
    $this->forward404Unless($this->cmv);
  }

  public function executeNew(sfWebRequest $request)
  {
    $trasplanteId = $request->getParameter('id');
    $this->forward404Unless($trasplanteId);
    $cmv = new Cmv();
    $cmv->setTrasplanteId($trasplanteId);
    
    $this->form = new CmvForm($cmv);
  }

  public function executeSave(sfWebRequest $request)
  {
      $parameters = $request->getPostParameters();
      
      $auxForm = new CmvForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $Cmv = Doctrine::getTable('Cmv')->find($id);
        $this->forward404Unless($Cmv);
        $form = new CmvForm($Cmv); 
        $isNew = false;
      }
      else
      {
        $evolucion = new Cmv();
        $evolucion->setTrasplanteId($parameters["trasplante_id"]);
        $form = new CmvForm($evolucion); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $CmvAux = $form->save();
        $form = new CmvForm($CmvAux);
        $body = $this->getPartial("cmvList", array( "cmv" => $CmvAux));
        
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$CmvAux->getId(), 'body' => $body)));
      }
      else
      {
        $body = $this->getPartial('small_form', array('form'=>$form));
        $errores = $form->getFormattedErrors();
        return $this->renderText(mdBasicFunction::basic_json_response(false, array('errores' => $errores, 'body' => $body)));
      }
  }  
  
  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($cmv = Doctrine_Core::getTable('Cmv')->find(array($request->getParameter('id'))), sprintf('Object cmv does not exist (%s).', $request->getParameter('id')));
    $this->form = new CmvForm($cmv);
  }


  public function executeDelete(sfWebRequest $request)
  {
    //$request->checkCSRFProtection();

    $this->forward404Unless($cmv = Doctrine_Core::getTable('Cmv')->find(array($request->getParameter('id'))), sprintf('Object cmv does not exist (%s).', $request->getParameter('id')));
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
      
      return $this->renderText(mdBasicFunction::basic_json_response(false, array("error" => $e->getCode())));
    }
  }

}
