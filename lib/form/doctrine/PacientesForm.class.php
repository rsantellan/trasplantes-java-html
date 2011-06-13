<?php

/**
 * Pacientes form.
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormTemplate.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class PacientesForm extends BasePacientesForm
{
  public function configure()
  {
	unset($this["the"]);
	$years = range(1920,date('Y'));
	
	$this->widgetSchema['fecha_nacimiento'] = new sfWidgetFormDate(
														array(
															'format' => '%year% %month% %day%',
															'years' =>array_combine($years, $years)));

	$this->widgetSchema['fecha_dialisis'] = new sfWidgetFormDate(
														array(
															'format' => '%year% %month% %day%',
															'years' =>array_combine($years, $years)));

  }
}
