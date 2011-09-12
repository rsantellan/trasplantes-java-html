<?php

/**
 * TrasplanteComplicaciones actions.
 *
 * @package    transplantes
 * @subpackage TrasplanteComplicaciones
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class TrasplanteComplicacionesActions extends sfActions
{
  
  public function executeMostrar(sfWebRequest $request)
  {
	$this->trasplanteId = $request->getParameter('trasplanteId');
	$this->forward404Unless($this->trasplanteId);
  }

  public function executeMostrarNoInfecciosa(sfWebRequest $request)
  {
	$this->id = $request->getParameter('id');
	$this->complicacion = complicacionesHandler::retrieveComplicacionNoInfecciosa($this->id);
	
	$this->forward404Unless($this->complicacion);
  }

  public function executeMostrarInfecciosa(sfWebRequest $request)
  {
	$this->id = $request->getParameter('id');
	$this->complicacion = complicacionesHandler::retrieveComplicacionInfecciosa($this->id);
	
	$this->forward404Unless($this->complicacion);
  }
  
  public function executeAgregarComplicacionInfecciosaTrasplante(sfWebRequest $request)
  {
    $trasplanteId = $request->getParameter('trasplanteId');
    $this->forward404Unless($trasplanteId);
    $complicacion = new TrasplanteComplicacionesInfecciosas();
    $complicacion->setTrasplanteId($trasplanteId);
    $complicacion->setEvolucion(0);
    $complicacion->setInternado(true);
    $complicacion->setDiasDeInternacion(0);
    $this->form = new TrasplanteComplicacionesInfecciosasForm($complicacion);  
  }  

  public function executeAgregarComplicacionInfecciosaEvolucion(sfWebRequest $request)
  {
    $trasplanteId = $request->getParameter('trasplanteId');
    $this->forward404Unless($trasplanteId);
    $complicacion = new TrasplanteComplicacionesInfecciosas();
    $complicacion->setTrasplanteId($trasplanteId);
    $complicacion->setEvolucion(1);
    $this->form = new TrasplanteComplicacionesInfecciosasForm($complicacion);  
  } 
    
  public function executeAgregarComplicacionNoInfecciosaTrasplante(sfWebRequest $request)
  {
    $trasplanteId = $request->getParameter('trasplanteId');
    $this->forward404Unless($trasplanteId);
    $complicacion = new TrasplanteComplicacionesNoInfecciosas();
    $complicacion->setTrasplanteId($trasplanteId);
    $complicacion->setEvolucion(0);
    $complicacion->setInternado(true);
    $complicacion->setDiasDeInternacion(0);
    $this->form = new TrasplanteComplicacionesNoInfecciosasForm($complicacion);  
  }  

  public function executeAgregarComplicacionNoInfecciosaEvolucion(sfWebRequest $request)
  {
    $trasplanteId = $request->getParameter('trasplanteId');
    $this->forward404Unless($trasplanteId);
    $complicacion = new TrasplanteComplicacionesNoInfecciosas();
    $complicacion->setTrasplanteId($trasplanteId);
    $complicacion->setEvolucion(1);
    //$complicacion->setInternado(true);
    //$complicacion->setDiasDeInternacion(0);
    $this->form = new TrasplanteComplicacionesNoInfecciosasForm($complicacion);  
  }
  
  public function executeEditarComplicacionNoInfecciosa(sfWebRequest $request)
  {
	$this->id = $request->getParameter('id');
	$complicacion = complicacionesHandler::retrieveComplicacionNoInfecciosa($this->id);
	$this->form = new TrasplanteComplicacionesNoInfecciosasForm($complicacion);
  }

  public function executeEditarComplicacionInfecciosa(sfWebRequest $request)
  {
	$this->id = $request->getParameter('id');
	$complicacion = complicacionesHandler::retrieveComplicacionInfecciosa($this->id);
	$this->form = new TrasplanteComplicacionesNoInfecciosasForm($complicacion);
  }
  
  public function executeSaveFormComplicacionNoInfecciosa(sfWebRequest $request)
  {
      $auxForm = new TrasplanteComplicacionesNoInfecciosasForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $TrasplanteComplicacionesNoInfecciosas = Doctrine::getTable('TrasplanteComplicacionesNoInfecciosas')->find($id);
        $this->forward404Unless($TrasplanteComplicacionesNoInfecciosas);
        $form = new TrasplanteComplicacionesNoInfecciosasForm($TrasplanteComplicacionesNoInfecciosas); 
        $isNew = false;
      }
      else
      {
        
        $form = new TrasplanteComplicacionesNoInfecciosasForm(); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $complicacion = $form->save();
        $body = $this->getPartial("li_complicacion_no_infecciosa", array("id" => $complicacion->getId(), "fecha" => $complicacion->getFecha()));
        //$body = "";
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$complicacion->getId(), 'body' => $body, 'is_evolucion' => $complicacion->getEvolucion())));
      }
      else
      {
        $body = $this->getPartial('small_form', array('form'=>$form));
        return $this->renderText(mdBasicFunction::basic_json_response(false, array('body' => $body)));
      }	
  }
  
  public function executeSaveFormComplicacionInfecciosa(sfWebRequest $request)
  {
      $auxForm = new TrasplanteComplicacionesInfecciosasForm();
      $parameters = $request->getParameter($auxForm->getName());
      $id = $parameters["id"];
      $isNew = true;
      if($id)
      {
        $TrasplanteComplicacionesInfecciosas = Doctrine::getTable('TrasplanteComplicacionesInfecciosas')->find($id);
        $this->forward404Unless($TrasplanteComplicacionesInfecciosas);
        $form = new TrasplanteComplicacionesInfecciosasForm($TrasplanteComplicacionesInfecciosas); 
        $isNew = false;
      }
      else
      {
        
        $form = new TrasplanteComplicacionesInfecciosasForm(); 
      }
      $form->bind($parameters);
      if ($form->isValid())
      {
        $complicacion = $form->save();
        $body = $this->getPartial("li_complicacion_no_infecciosa", array("id" => $complicacion->getId(), "fecha" => $complicacion->getFecha()));
        //$body = "";
        return $this->renderText(mdBasicFunction::basic_json_response(true, array('isnew'=>$isNew, 'id'=>$complicacion->getId(), 'body' => $body, 'is_evolucion' => $complicacion->getEvolucion())));
      }
      else
      {
        $body = $this->getPartial('small_form', array('form'=>$form));
        return $this->renderText(mdBasicFunction::basic_json_response(false, array('body' => $body)));
      }	
  }
    
  /*
   * 
   * De aca para abajo no sirve nada
   */
  
  public function executeIndex(sfWebRequest $request)
  {
    $this->trasplante_complicacioness = Doctrine_Core::getTable('TrasplanteComplicaciones')
      ->createQuery('a')
      ->execute();
  }

  public function executeShow(sfWebRequest $request)
  {
    $this->trasplante_complicaciones = Doctrine_Core::getTable('TrasplanteComplicaciones')->find(array($request->getParameter('id')));
    $this->forward404Unless($this->trasplante_complicaciones);
  }

  public function executeNew(sfWebRequest $request)
  {
    $this->form = new TrasplanteComplicacionesForm();
  }

  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new TrasplanteComplicacionesForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($trasplante_complicaciones = Doctrine_Core::getTable('TrasplanteComplicaciones')->find(array($request->getParameter('id'))), sprintf('Object trasplante_complicaciones does not exist (%s).', $request->getParameter('id')));
    $this->form = new TrasplanteComplicacionesForm($trasplante_complicaciones);
  }

  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($trasplante_complicaciones = Doctrine_Core::getTable('TrasplanteComplicaciones')->find(array($request->getParameter('id'))), sprintf('Object trasplante_complicaciones does not exist (%s).', $request->getParameter('id')));
    $this->form = new TrasplanteComplicacionesForm($trasplante_complicaciones);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }

  public function executeDelete(sfWebRequest $request)
  {
    $request->checkCSRFProtection();

    $this->forward404Unless($trasplante_complicaciones = Doctrine_Core::getTable('TrasplanteComplicaciones')->find(array($request->getParameter('id'))), sprintf('Object trasplante_complicaciones does not exist (%s).', $request->getParameter('id')));
    $trasplante_complicaciones->delete();

    $this->redirect('TrasplanteComplicaciones/index');
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $trasplante_complicaciones = $form->save();

      $this->redirect('TrasplanteComplicaciones/edit?id='.$trasplante_complicaciones->getId());
    }
  }
}
