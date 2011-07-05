<?php

/**
 * donanteCausaMuerte actions.
 *
 * @package    transplantes
 * @subpackage donanteCausaMuerte
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class serolValorActions extends sfActions
{

  public function executeNew(sfWebRequest $request)
  {
    $serol_id = $request->getParameter('id');
    $this->forward404Unless($serol_id);
    
    $serolValor = new SerolValor();
    $serolValor->setSerolId($serol_id);
    
    $this->form = new SerolValorForm($serolValor);
    
    $body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));    
  }

  
  public function executeSave(sfWebRequest $request)
  {
      $auxForm = new SerolValorForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $serolValor = Doctrine_Core::getTable('SerolValor')->find($id);
        $this->forward404Unless($serolValor);
        $form = new SerolValorForm($serolValor);
        $isNew = false;
      }
      else
      {
        
        $form = new SerolValorForm(); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $serolValor = $form->save();
        $form = new SerolValorForm($serolValor);
        $body = $this->getPartial('small_form', array('form'=>$form));
        $serol_div = $this->getPartial("donante/container_seroles", array('serol' => $serolValor->getSerol(), 'serolesAsociados' => array()));
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$serolValor->getId(), 'nombre'=>$serolValor->getValor(), 'body' => $body, 'serol_div' => $serol_div, 'serol_id' => $serolValor->getSerolId())));
      }
      else
      {
        $body = $this->getPartial('small_form', array('form'=>$form));
        return $this->renderText(mdBasicFunction::basic_json_response(false, array('body' => $body)));
      }
  }

  public function executeDelete(sfWebRequest $request)
  {
    //$request->checkCSRFProtection();
    
    $this->forward404Unless($serolValor = Doctrine_Core::getTable('SerolValor')->find(array($request->getParameter('id'))), sprintf('Object donante_causa_muerte does not exist (%s).', $request->getParameter('id')));
    try
    {
      $serol_id = $serolValor->getSerolId();
      if($serolValor->delete())
      {  
        $serol = Doctrine_Core::getTable('Serol')->find($serol_id);
        $serol_div = $this->getPartial("donante/container_seroles", array('serol' => $serol, 'serolesAsociados' => array()));
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('id'=>$request->getParameter('id'), 'serol_div' => $serol_div, 'serol_id' => $serol_id)));
      }
      else
      {
        return $this->renderText(mdBasicFunction::basic_json_response(false, array()));
      }      
    }catch(Exception $e)
    {
      
      return $this->renderText(mdBasicFunction::basic_json_response(false, array("error" => $e->getCode())));
    }
	
    //$this->redirect('donanteCausaMuerte/index');
  }  

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($serolValor = Doctrine_Core::getTable('SerolValor')->find(array($request->getParameter('id'))), sprintf('Object donante_causa_muerte does not exist (%s).', $request->getParameter('id')));
    $this->form = new SerolValorForm($serolValor);
	
    $body = $this->getPartial('small_form', array('form'=>$this->form));
    
    return $this->renderText(mdBasicFunction::basic_json_response(true, array('body' => $body)));
  }
    
}
