<?php

/**
 * Trasplante actions.
 *
 * @package    transplantes
 * @subpackage Trasplante
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class TrasplanteActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->trasplantes = Doctrine_Core::getTable('Trasplante')
      ->createQuery('a')
      ->execute();
  }

  public function executeShow(sfWebRequest $request)
  {
    $this->id = $request->getParameter('id');
    $paciente = PacienteHandler::retrivePacienteByTrasplanteId($request->getParameter('id'), Doctrine_Core::HYDRATE_ARRAY);
    $this->pacienteId = $paciente[0]["id"];
    $this->trasplante = trasplanteHandler::retriveById($request->getParameter('id'), Doctrine_Core::HYDRATE_ARRAY );
    $this->forward404Unless($this->trasplante);
    $this->forward404Unless($this->pacienteId);
  }

  public function executeNew(sfWebRequest $request)
  {
    $paciente_id = $request->getParameter("paciente_id");
    $this->forward404Unless($paciente_id);
    $pre_trasplante_id = $request->getParameter("pre_trasplante_id");
    $this->forward404Unless($pre_trasplante_id);
    $trasplante = new Trasplante();
    $trasplante->setPacientePreTrasplanteId($pre_trasplante_id);     
    $this->form = new TrasplanteForm($trasplante);
  }

  public function executeSave(sfWebRequest $request)
  {
      $parameters = $request->getPostParameters();
      $seroles_array = array();
      if(isset($parameters["seroles"]))
      {
        $seroles_info = $parameters["seroles"];
        $seroles_valores =  $seroles_info["valor"];        
        foreach($seroles_valores as $tipo)
        {
          foreach($tipo as $valor)
          {
            array_push($seroles_array, $valor);
          }
        }        
      }
      
      $auxForm = new TrasplanteForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $trasplante = Doctrine::getTable('Trasplante')->find($id);
        $this->forward404Unless($trasplante);
        $this->form = new TrasplanteForm($trasplante); 
        $isNew = false;
      }
      else
      {
        $pre_trasplante_id = $parameters["paciente_pre_trasplante_id"];
        $trasplante = new Trasplante();
        $trasplante->setPacientePreTrasplanteId($pre_trasplante_id);     
        $this->form = new TrasplanteForm($trasplante);        
      }
      $this->form->bind($parameters);
      if ($this->form->isValid())
      {
        $trasplante = $this->form->save();
        trasplanteHandler::saveSerolesOfTrasplante($trasplante->getId(), $seroles_array);
        sfContext::getInstance()->getConfiguration()->loadHelpers(array('Url'));
        $this->redirect(url_for("@mostrarTrasplante?id=".$trasplante->getId()));
      }
      else
      {
        //$body = $this->getPartial('small_form', array('form'=>$form));
        //return $this->renderText(mdBasicFunction::basic_json_response(false, array('body' => $body)));
      }            
      //die;	
      $this->setTemplate('new');
  } 
  
  public function executeCambiarFechaAlta(sfWebRequest $request)
  {
    $id = $request->getParameter("id");
    $defaults = array();
    $defaults["id"] = $id;
    $this->form = new cambiarFechaAltaTrasplanteForm($defaults);
  }

  public function executeGuardarFechaAlta(sfWebRequest $request)
  {
    $parameters = $request->getPostParameters();
    $id = $parameters["cambiarFechaAltaTrasplante"]["id"];
    $defaults = array();
    $defaults["id"] = $id;
    $this->form = new cambiarFechaAltaTrasplanteForm($defaults);
    $this->form->bind($request->getParameter($this->form->getName()));
    if($this->form->isValid())
    {
      $this->form->save();
      $trasplante = trasplanteHandler::retriveById($id, Doctrine_Core::HYDRATE_ARRAY);
      sfContext::getInstance()->getConfiguration()->loadHelpers(array('Date'));
      $label = format_date($trasplante["fecha_alta"], 'D');
      return $this->renderText(mdBasicFunction::basic_json_response(true, array('label' => $label)));
    }
    else
    {
      $body = $this->getPartial("Trasplante/fechaAltaForm", array('form' => $this->form));
      
      return $this->renderText(mdBasicFunction::basic_json_response(false, array('body' => $body)));
      
    }
    die;
  }  
  
  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new TrasplanteForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($trasplante = Doctrine_Core::getTable('Trasplante')->find(array($request->getParameter('id'))), sprintf('Object trasplante does not exist (%s).', $request->getParameter('id')));
    $this->form = new TrasplanteForm($trasplante);
    $this->setTemplate('new');
  }

  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($trasplante = Doctrine_Core::getTable('Trasplante')->find(array($request->getParameter('id'))), sprintf('Object trasplante does not exist (%s).', $request->getParameter('id')));
    $this->form = new TrasplanteForm($trasplante);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }

  public function executeDelete(sfWebRequest $request)
  {
    $request->checkCSRFProtection();

    $this->forward404Unless($trasplante = Doctrine_Core::getTable('Trasplante')->find(array($request->getParameter('id'))), sprintf('Object trasplante does not exist (%s).', $request->getParameter('id')));
    $trasplante->delete();

    $this->redirect('Trasplante/index');
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $trasplante = $form->save();

      $this->redirect('Trasplante/edit?id='.$trasplante->getId());
    }
  }
}
