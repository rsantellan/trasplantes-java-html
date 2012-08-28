<?php

/**
 * consulta actions.
 *
 * @package    transplantes
 * @subpackage consulta
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class consultaActions extends sfActions
{
  public function executeIndex(sfWebRequest $request)
  {
    $this->consultas = Doctrine_Core::getTable('consulta')
      ->createQuery('a')
      ->execute();
  }

  public function executeShow(sfWebRequest $request)
  {
    $this->consulta = Doctrine_Core::getTable('consulta')->find(array($request->getParameter('id')));
    $this->forward404Unless($this->consulta);
    //var_dump($this->consulta->retrieveFieldsList());die;
    //$lista = $this->consulta->getConsultaCampo();
    //var_dump(count($lista));
    $q = Doctrine_Manager::getInstance()->getCurrentConnection();
    $this->result = $q->fetchAssoc($this->consulta->getSentencia());	
  }

  public function executeNew(sfWebRequest $request)
  {
    $this->form = new consultaForm();
  }

  public function executeCreate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST));

    $this->form = new consultaForm();

    $this->processForm($request, $this->form);

    $this->setTemplate('new');
  }

  public function executeEdit(sfWebRequest $request)
  {
    $this->forward404Unless($consulta = Doctrine_Core::getTable('consulta')->find(array($request->getParameter('id'))), sprintf('Object consulta does not exist (%s).', $request->getParameter('id')));
    $this->form = new consultaForm($consulta);
  }

  public function executeUpdate(sfWebRequest $request)
  {
    $this->forward404Unless($request->isMethod(sfRequest::POST) || $request->isMethod(sfRequest::PUT));
    $this->forward404Unless($consulta = Doctrine_Core::getTable('consulta')->find(array($request->getParameter('id'))), sprintf('Object consulta does not exist (%s).', $request->getParameter('id')));
    $this->form = new consultaForm($consulta);

    $this->processForm($request, $this->form);

    $this->setTemplate('edit');
  }

  public function executeDelete(sfWebRequest $request)
  {
    $request->checkCSRFProtection();

    $this->forward404Unless($consulta = Doctrine_Core::getTable('consulta')->find(array($request->getParameter('id'))), sprintf('Object consulta does not exist (%s).', $request->getParameter('id')));
    $consulta->delete();

    $this->redirect('consulta/index');
  }

  protected function processForm(sfWebRequest $request, sfForm $form)
  {
    $form->bind($request->getParameter($form->getName()), $request->getFiles($form->getName()));
    if ($form->isValid())
    {
      $consulta = $form->save();

      $this->redirect('consulta/edit?id='.$consulta->getId());
    }
  }
  
  public function executeConsultaGermenesInfecciones(sfWebRequest $request)
  {
     $this->germenes = Doctrine_Core::getTable('germenes')
      ->createQuery('a')
      ->execute();
     
     $this->infecciones = Doctrine_Core::getTable('infeccion')
      ->createQuery('a')
      ->execute();
     
     $this->germen_id = $request->getParameter("g", 0);
     $this->infeccion_id = $request->getParameter("i", 0);
     $this->result =  Doctrine::getTable('consulta')->retrieveGermenesInfeccionesData($this->germen_id, $this->infeccion_id);
     
  }
  
  public function executeConsultaTrasplanteComplicaciones(sfWebRequest $request)
  {
    $maximos = Doctrine::getTable('TrasplanteComplicacionesConsulta')->getMaximunNumbers();
    $this->days = range(0, (int) $maximos['d']);
    $this->months = range(0, (int) $maximos['m']);
    $this->years = range(0, (int) $maximos['y']);
    
    $this->dia = $request->getParameter("d", 0);
    $this->mes = $request->getParameter("m", 0);
    $this->mYear = $request->getParameter("y", 0);
    $this->datos = array();
    $this->datosInfecciosas = array();
    $this->datosNoInfecciosas = array();
    $this->plotEnable = false;
    if($this->dia > 0)
    {
      $this->datos = Doctrine::getTable('TrasplanteComplicacionesConsulta')->getByDays($this->dia);
      $this->datosInfecciosas = Doctrine::getTable('TrasplanteComplicacionesConsulta')->getByDays($this->dia, TrasplanteComplicacionesConsulta::INFECCIOSAS);
      $this->datosNoInfecciosas = Doctrine::getTable('TrasplanteComplicacionesConsulta')->getByDays($this->dia, TrasplanteComplicacionesConsulta::NOINFECCIOSAS);
      $this->plotEnable = true;
    }  
    else 
    {
      if($this->mes > 0)
      {
        $this->datos = Doctrine::getTable('TrasplanteComplicacionesConsulta')->getByMonth($this->mes);
        $this->datosInfecciosas = Doctrine::getTable('TrasplanteComplicacionesConsulta')->getByMonth($this->mes, TrasplanteComplicacionesConsulta::INFECCIOSAS);
        $this->datosNoInfecciosas = Doctrine::getTable('TrasplanteComplicacionesConsulta')->getByMonth($this->mes, TrasplanteComplicacionesConsulta::NOINFECCIOSAS);
        $this->plotEnable = true;
      }
      else
      {
        if($this->mYear > 0)
        {
          $this->datos = Doctrine::getTable('TrasplanteComplicacionesConsulta')->getByYear($this->mYear);
          $this->datosInfecciosas = Doctrine::getTable('TrasplanteComplicacionesConsulta')->getByYear($this->mYear, TrasplanteComplicacionesConsulta::INFECCIOSAS);
          $this->datosNoInfecciosas = Doctrine::getTable('TrasplanteComplicacionesConsulta')->getByYear($this->mYear, TrasplanteComplicacionesConsulta::NOINFECCIOSAS);
          $this->plotEnable = true;
        }
      }
    }
  }
}
