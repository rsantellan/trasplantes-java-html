<?php

/**
 * Tratamiento actions.
 *
 * @package    transplantes
 * @subpackage Tratamiento
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class TratamientoActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->paciente_id = $request->getParameter('id');
    $this->forward404Unless($this->paciente_id);
    $this->tratamientos = tratamientoHandler::retriveAllTratamientosOfPaciente($this->paciente_id);
    
  }


  public function executeNew(sfWebRequest $request)
  {
    $this->paciente_id = $request->getParameter('id');
    $this->forward404Unless($this->paciente_id);
    $tratamiento = new Tratamiento();
    $tratamiento->setPacienteId($this->paciente_id);
    $this->form = new TratamientoForm($tratamiento);
  }

  
  public function executeSave(sfWebRequest $request)
  {
      $parameters = $request->getPostParameters();
      
      $auxForm = new TratamientoForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $tratamiento = Doctrine::getTable('Tratamiento')->find($id);
        $this->forward404Unless($tratamiento);
        $form = new TratamientoForm($tratamiento); 
        $isNew = false;
      }
      else
      {
        
        $form = new TratamientoForm(); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $tratamientoAux = $form->save();
        $form = new TratamientoForm($tratamientoAux);
        $body = $this->getPartial("table_row", array( "tratamiento" => $tratamientoAux));
        
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$tratamientoAux->getId(), 'body' => $body)));
      }
      else
      {
        $body = $this->getPartial('small_form', array('form'=>$form));
        return $this->renderText(mdBasicFunction::basic_json_response(false, array('body' => $body)));
      }
  }  

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($tratamiento = Doctrine_Core::getTable('Tratamiento')->find(array($request->getParameter('id'))), sprintf('Object tratamiento does not exist (%s).', $request->getParameter('id')));
    $this->form = new TratamientoForm($tratamiento);
  }
  
  public function executeCambiarFechaAlta(sfWebRequest $request)
  {
    $id = $request->getParameter("id");
    $defaults = array();
    $defaults["id"] = $id;
    $this->form = new cambiarFechaFinTratamientoForm($defaults);
  }
  
  public function executeGuardarFechaAlta(sfWebRequest $request)
  {
    $parameters = $request->getPostParameters();
    $id = $parameters["cambiarFechaAltaTratamiento"]["id"];
    $defaults = array();
    $defaults["id"] = $id;
    $this->form = new cambiarFechaFinTratamientoForm($defaults);
    $this->form->bind($request->getParameter($this->form->getName()));
    if($this->form->isValid())
    {
      $this->form->save();
      $tratamiento = tratamientoHandler::retriveById($id);
      $body = $this->getPartial("table_row", array( "tratamiento" => $tratamiento));
      $label = "soy una label";//format_date($trasplante["fecha_alta"], 'D');
      return $this->renderText(mdBasicFunction::basic_json_response(true, array('id'=>$id, 'body' => $body)));
    }
    else
    {
      $body = $this->getPartial("Tratamiento/fechaAltaForm", array('form' => $this->form));
      
      return $this->renderText(mdBasicFunction::basic_json_response(false, array('body' => $body)));
      
    }
    die;
  }
  
  public function executeDelete(sfWebRequest $request)
  {
      
    $this->forward404Unless($tratamiento = Doctrine_Core::getTable('Tratamiento')->find(array($request->getParameter('id'))), sprintf('Object tratamiento does not exist (%s).', $request->getParameter('id')));
    try
    {
      if($tratamiento->delete())
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
  
  public function executeShow(sfWebRequest $request)
  {
    $this->tratamiento = Doctrine_Core::getTable('Tratamiento')->find(array($request->getParameter('id')));
    $this->forward404Unless($this->tratamiento);
  }
  
  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new TratamientoForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }



  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($tratamiento = Doctrine_Core::getTable('Tratamiento')->find(array($request->getParameter('id'))), sprintf('Object tratamiento does not exist (%s).', $request->getParameter('id')));
    $this->form = new TratamientoForm($tratamiento);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }



  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $tratamiento = $form->save();

      $this->redirect('Tratamiento/edit?id='.$tratamiento->getId());
    }
  }
}
