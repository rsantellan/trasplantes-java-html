<?php

/**
 * TrasplanteReoperacion form.
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormTemplate.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class TrasplanteReoperacionForm extends BaseTrasplanteReoperacionForm
{
  public function configure()
  {
	$this->widgetSchema['trasplante_id'] = new sfWidgetFormInputHidden();
	
    $trasplante_id = $this->getObject()->getTrasplanteId();
    $trasplante = trasplanteHandler::retriveById($trasplante_id, Doctrine_Core::HYDRATE_ARRAY);
    $age = mdBasicFunction::calculateAge($trasplante["fecha"], true);
    $years = range(date('Y') - $age, date('Y')+ 1);
    $years = array_combine($years, $years);
	
	$this->widgetSchema['fecha'] = new sfWidgetFormDate(
                              array(
                                'format' => '%year% %month% %day%',
                                'years' => $years));
	
	$this->widgetSchema['descripcion'] = new sfWidgetFormTextarea();

	$this->widgetSchema['es_infecciosa'] = new sfWidgetFormChoice(array(
                    'expanded' => true,
                    'choices' => datosBasicosHandler::yesOrNoChoicesOptions(),
                ));
	
	$complicacion_infecciosas = complicacionesHandler::retrieveAllComplicacionesInfecciosas($trasplante_id, false);
	$complicacion_infecciosas_ev = complicacionesHandler::retrieveAllComplicacionesInfecciosas($trasplante_id, true);
	//$result = array_merge($complicacion_infecciosas, $complicacion_infecciosas_ev);
	$c_infecciosas = array();
	$c_infecciosas[null] = " ";
	foreach($complicacion_infecciosas as $com)
	{
	  $c_infecciosas[$com->getId()] = $com->showDate();
	}
	
	foreach($complicacion_infecciosas_ev as $com)
	{
	  $c_infecciosas[$com->getId()] = $com->showDate();
	}
	$this->widgetSchema['trasplante_complicacion_infeccion_id'] = new sfWidgetFormChoice(array(
	  'choices' => $c_infecciosas,
	));

	$complicacion_no_infecciosas = complicacionesHandler::retrieveAllComplicacionesNoInfecciosas($trasplante_id, false);
	$complicacion_no_infecciosas_ev = complicacionesHandler::retrieveAllComplicacionesNoInfecciosas($trasplante_id, true);
	//$result = array_merge($complicacion_infecciosas, $complicacion_infecciosas_ev);
	$c_no_infecciosas = array();
	$c_no_infecciosas[null] = " ";
	foreach($complicacion_no_infecciosas as $com)
	{
	  $c_no_infecciosas[$com->getId()] = $com->showDate();
	}
	
	foreach($complicacion_no_infecciosas_ev as $com)
	{
	  $c_no_infecciosas[$com->getId()] = $com->showDate();
	}
	$this->widgetSchema['trasplante_complicacion_no_infeccion_id'] = new sfWidgetFormChoice(array(
	  'choices' => $c_no_infecciosas,
	));
  }
}
