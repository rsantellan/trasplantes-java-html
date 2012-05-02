<?php

/**
 * PacientePerdidaInjerto form.
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormTemplate.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class PacientePerdidaInjertoForm extends BasePacientePerdidaInjertoForm
{
  public function configure()
  {
    //unset($this['paciente_id']);
    
    $this->widgetSchema['paciente_id'] = new sfWidgetFormInputHidden();
    $this->widgetSchema['paciente_pre_trasplante_id'] = new sfWidgetFormInputHidden();

    $paciente_pre_trasplante_id = $this->getObject()->getPacientePreTrasplanteId();
    $preTrasplante = preTrasplanteHandler::retriveById($paciente_pre_trasplante_id, Doctrine_Core::HYDRATE_ARRAY);

    $age = mdBasicFunction::calculateAge($preTrasplante["fecha_ingreso_lista"], true);
    $years = range(date('Y') - $age,date('Y'));
    $years = array_combine($years, $years);
    
    $this->widgetSchema['fecha_perdida'] = new sfWidgetFormDate(
                          array(
                            'format' => '%year% %month% %day%',
                            'years' => $years));
                            
    $this->validatorSchema['fecha_perdida'] = new sfValidatorDate(array(
                                        'min' => $preTrasplante["fecha_ingreso_lista"],
                                        'date_format_range_error' => 'Y/m/d'));                            
  }
}
