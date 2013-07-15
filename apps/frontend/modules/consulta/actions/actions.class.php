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
  
  public function executeRetrieveComplications(sfWebRequest $request)
  {
      $sql_basica_pacientes = 'select 
        paciente_pre_trasplante.id, pacientes.nombre, pacientes.apellido, pacientes.num_fnr, pacientes.sexo, YEAR(CURRENT_TIMESTAMP) - YEAR(pacientes.fecha_nacimiento) - (RIGHT(CURRENT_TIMESTAMP, 5) < RIGHT(pacientes.fecha_nacimiento, 5)) as edad, pacientes.fecha_nacimiento, nefropatia.nombre as nefropatia, paciente_pre_trasplante.origen,
        IF( paciente_pre_trasplante.tabaquismo=1,  "Si",  "No" ) AS tabaquismo,
        IF( paciente_pre_trasplante.dislipemia=1,  "Si",  "No" ) AS dislipemia,
        paciente_pre_trasplante.diabetes,
        IF( paciente_pre_trasplante.hta=1,  "Si",  "No" ) AS HTA,
        paciente_pre_trasplante.imc as IMC,
        IF( paciente_pre_trasplante.obesidad=1,  "Si",  "No" ) AS Obesidad,
        IF( paciente_pre_trasplante.iam=1,  "Si",  "No" ) AS Iam,
        IF( paciente_pre_trasplante.ave=1,  "Si",  "No" ) AS Ave,
        IF(pacientes.sin_dialisis="SI", "Sin dialisis", YEAR(paciente_pre_trasplante.fecha_egreso) - YEAR(pacientes.fecha_dialisis) - (RIGHT(paciente_pre_trasplante.fecha_egreso, 5) < RIGHT(pacientes.fecha_dialisis, 5))) AS "Tiempo en dialisis",
        paciente_pre_trasplante.fecha_egreso AS "Fecha TR"
        from 
        pacientes, nefropatia, paciente_pre_trasplante
        where
        pacientes.nefropatia_id = nefropatia.id
        and
        pacientes.id = paciente_pre_trasplante.paciente_id';
     $q = Doctrine_Manager::getInstance()->getCurrentConnection();
     $basic_result = $q->fetchAssoc($sql_basica_pacientes);
     var_dump($basic_result);
     
     $sql_infecciosa = 'select trasplante_complicaciones_infecciosas.fecha, medicaciones.nombre as medicacion, infeccion.nombre as infeccion, germenes.nombre as germen,
        IF( trasplante_complicaciones_infecciosas.internado=1,  "Si",  "No" ) AS Internado, trasplante_complicaciones_infecciosas.dias_de_internacion,
        IF( trasplante_complicaciones_infecciosas.evolucion=1,  "Si",  "No" ) AS "En evolucion"
        from 
        trasplante_complicaciones_infecciosas, germenes, infeccion, medicaciones, trasplante, paciente_pre_trasplante
        where 
        medicaciones.id = trasplante_complicaciones_infecciosas.medicacion_id
        and
        germenes.id = trasplante_complicaciones_infecciosas.germen_id
        and
        infeccion.id = trasplante_complicaciones_infecciosas.infeccion_id
        and 
        trasplante.id = trasplante_complicaciones_infecciosas.trasplante_id
        and 
        paciente_pre_trasplante.id = trasplante.paciente_pre_trasplante_id
        and
        paciente_pre_trasplante.id = ?
     ';
     
     $sql_no_infecciosa = '
                 select
            trasplante_complicaciones_no_infecciosas.fecha, medicaciones.nombre as medicacion, 
            complicaciones_tipos.nombre as "Tipo", complicaciones_tipos_valores.nombre as Valor,
            IF( trasplante_complicaciones_no_infecciosas.internado=1,  "Si",  "No" ) AS Internado, 
            trasplante_complicaciones_no_infecciosas.dias_de_internacion,
            IF( trasplante_complicaciones_no_infecciosas.evolucion=1,  "Si",  "No" ) AS "En evolucion"
            from 
            trasplante_complicaciones_no_infecciosas, medicaciones, complicaciones_tipos_valores, complicaciones_tipos, trasplante, paciente_pre_trasplante
            where 
            medicaciones.id = trasplante_complicaciones_no_infecciosas.medicacion_id
            and
            complicaciones_tipos.id = complicaciones_tipos_valores.complicacion_tipo_id
            and 
            complicaciones_tipos_valores.id = trasplante_complicaciones_no_infecciosas.complicacion_valor_id
            and 
            trasplante.id = trasplante_complicaciones_no_infecciosas.trasplante_id
            and 
            paciente_pre_trasplante.id = trasplante.paciente_pre_trasplante_id
            and
            paciente_pre_trasplante.id = ?
            ';
            
     $sql_cmv_basico = '
            select cmv.fecha, cmv.tipo, cmv_diagnostico.nombre as diagnostico, cmv_drogas.nombre as droga, cmv.dias_tratamiento
            from cmv, cmv_diagnostico, cmv_drogas, trasplante, paciente_pre_trasplante
            where 
            cmv.cmv_diagnostico_id = cmv_diagnostico.id
            and
            cmv_drogas.id = cmv.cmv_droga_id
            and 
            trasplante.id = cmv.trasplante_id
            and 
            paciente_pre_trasplante.id = trasplante.paciente_pre_trasplante_id
            and
            paciente_pre_trasplante.id = ?
     ';
     $sql_cmv_emfermedades = '
        select cmv_emfermedades.nombre, cmv_uso_enfermedades.cmv_id
        from cmv_uso_enfermedades, cmv_emfermedades
        where cmv_emfermedades.id = cmv_uso_enfermedades.cmv_emfermedades_id
        and cmv_uso_enfermedades.cmv_id = ?
     ';
     
     $sql_tratamientos = '
select tratamiento.dosis, tratamiento.fecha_inicio, tratamiento.fecha_fin, medicaciones.nombre as medicacion
from tratamiento, medicaciones
where 
tratamiento.medicacion_id = medicaciones.id
and tratamiento.paciente_id = ?
     ';
     die;
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
  
  public function executeConsultaInducciones(sfWebRequest $request)
  {
    $auxInducciones = Doctrine::getTable('Induccion')->findAll(Doctrine_Core::HYDRATE_ARRAY);
    $inducciones = array();
    foreach($auxInducciones as $induccion)
    {
      $inducciones[$induccion["id"]] = $induccion["nombre"];
    }
    
    $pacientes = Doctrine::getTable("Consulta")->retrievePacientesInducciones();
    
    $listado = array();
    foreach($pacientes as $paciente)
    {
      if(!isset($listado[$paciente["ID"]]))
      {
        $row = array();
        $row["ID"] = $paciente["ID"];
        $row["THE"] = $paciente["THE"];
        $row["NOMBRE"] = $paciente["NOMBRE"];
        $row["APELLIDO"] = $paciente["APELLIDO"];
        foreach($inducciones as $induccion)
        {
          $row[$induccion] = "NO";
        }
        $listado[$paciente["ID"]] = $row;
      }
      $listado[$paciente["ID"]][$inducciones[$paciente["INDUCCION"]]] = "SI";
    }
    $this->result = $listado;
    
  }
  
  public function executeConsultaInmunosupresores(sfWebRequest $request)
  {
    $auxInmunosupresores = Doctrine::getTable('Inmunosupresores')->findAll(Doctrine_Core::HYDRATE_ARRAY);
    $inmunosupresores = array();
    foreach($auxInmunosupresores as $inmunosupresor)
    {
      $inmunosupresores[$inmunosupresor["id"]] = $inmunosupresor["nombre"];
    }
    
    $pacientes = Doctrine::getTable("Consulta")->retrievePacientesInmunosupresores();
    
    $listado = array();
    foreach($pacientes as $paciente)
    {
      if(!isset($listado[$paciente["ID"]]))
      {
        $row = array();
        $row["ID"] = $paciente["ID"];
        $row["THE"] = $paciente["THE"];
        $row["NOMBRE"] = $paciente["NOMBRE"];
        $row["APELLIDO"] = $paciente["APELLIDO"];
        foreach($inmunosupresores as $inmunosupresor)
        {
          $row[$inmunosupresor] = "NO";
        }
        $listado[$paciente["ID"]] = $row;
      }
      $listado[$paciente["ID"]][$inmunosupresores[$paciente["INMUNOSUPRESOR"]]] = "SI";
    }
    $this->result = $listado;
    
  }
}
