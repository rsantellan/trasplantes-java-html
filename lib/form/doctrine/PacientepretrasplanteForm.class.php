<?php

/**
 * Pacientepretrasplante form.
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormTemplate.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class PacientepretrasplanteForm extends BasePacientepretrasplanteForm
{
  public function configure()
  {
	unset($this["fecha_egreso"], $this["meses_en_lista"]);
	$paciente_id = $this->getObject()->getPacienteId();
	$paciente = PacienteHandler::retriveById($paciente_id, Doctrine_Core::HYDRATE_ARRAY);
	$age = mdBasicFunction::calculateAge($paciente["fecha_nacimiento"], true);
  $years = range(date('Y') - $age,date('Y'));
  $years = array_combine($years, $years);
  
	$this->widgetSchema['paciente_id'] = new sfWidgetFormInputHidden();
	
	$this->widgetSchema['fecha_ingreso_lista'] = new sfWidgetFormDate(
                              array(
                                'format' => '%year% %month% %day%',
                                'years' => $years));
	
	$this->widgetSchema['pbr'] =  new sfWidgetFormChoice(array(
                                                              'expanded' => true,
                                                              'choices'  => datosBasicosHandler::yesOrNoChoicesOptions(),
                                                            ));
	$this->widgetSchema['hta'] =  new sfWidgetFormChoice(array(
                                                              'expanded' => true,
                                                              'choices'  => datosBasicosHandler::yesOrNoChoicesOptions(),
                                                            ));
	$this->widgetSchema['obesidad'] =  new sfWidgetFormChoice(array(
                                                              'expanded' => true,
                                                              'choices'  => datosBasicosHandler::yesOrNoChoicesOptions(),
                                                            ));
	$this->widgetSchema['dislipemia'] =  new sfWidgetFormChoice(array(
                                                              'expanded' => true,
                                                              'choices'  => datosBasicosHandler::yesOrNoChoicesOptions(),
                                                            ));
	$this->widgetSchema['tabaquismo'] =  new sfWidgetFormChoice(array(
                                                              'expanded' => true,
                                                              'choices'  => datosBasicosHandler::yesOrNoChoicesOptions(),
                                                            ));
	$this->widgetSchema['iam'] =  new sfWidgetFormChoice(array(
                                                              'expanded' => true,
                                                              'choices'  => datosBasicosHandler::yesOrNoChoicesOptions(),
                                                            ));
	$this->widgetSchema['ave'] =  new sfWidgetFormChoice(array(
                                                              'expanded' => true,
                                                              'choices'  => datosBasicosHandler::yesOrNoChoicesOptions(),
                                                            ));
	$this->widgetSchema['revasc_cardio'] =  new sfWidgetFormChoice(array(
                                                              'expanded' => true,
                                                              'choices'  => datosBasicosHandler::yesOrNoChoicesOptions(),
                                                            ));
  }
}
