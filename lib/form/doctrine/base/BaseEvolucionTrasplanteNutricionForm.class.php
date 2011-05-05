<?php

/**
 * EvolucionTrasplanteNutricion form base class.
 *
 * @method EvolucionTrasplanteNutricion getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseEvolucionTrasplanteNutricionForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'idtrasplante'       => new sfWidgetFormInputHidden(),
      'fecha'              => new sfWidgetFormInputHidden(),
      'talla'              => new sfWidgetFormInputText(),
      'peso_deseado'       => new sfWidgetFormInputText(),
      'estructura_osea'    => new sfWidgetFormInputText(),
      'impresion'          => new sfWidgetFormInputText(),
      'peso_real'          => new sfWidgetFormInputText(),
      'p_tricipital'       => new sfWidgetFormInputText(),
      'p_tricipital_p'     => new sfWidgetFormInputText(),
      'p_subescapular'     => new sfWidgetFormInputText(),
      'p_subescapular_p'   => new sfWidgetFormInputText(),
      'sum_pliegues'       => new sfWidgetFormInputText(),
      'p_sum_pliegues'     => new sfWidgetFormInputText(),
      'cf_brazo'           => new sfWidgetFormInputText(),
      'p_cf_brazo'         => new sfWidgetFormInputText(),
      'cf_musc_brazo'      => new sfWidgetFormInputText(),
      'p_cf_musc_brazo'    => new sfWidgetFormInputText(),
      'area_brazo'         => new sfWidgetFormInputText(),
      'area_musc_brazo'    => new sfWidgetFormInputText(),
      'p_area_musc_brazo'  => new sfWidgetFormInputText(),
      'area_grasa_brazo'   => new sfWidgetFormInputText(),
      'p_area_grasa_brazo' => new sfWidgetFormInputText(),
      'r_cintura_cadera'   => new sfWidgetFormInputText(),
      'diag_nutricional'   => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'idtrasplante'       => new sfValidatorChoice(array('choices' => array($this->getObject()->get('idtrasplante')), 'empty_value' => $this->getObject()->get('idtrasplante'), 'required' => false)),
      'fecha'              => new sfValidatorChoice(array('choices' => array($this->getObject()->get('fecha')), 'empty_value' => $this->getObject()->get('fecha'), 'required' => false)),
      'talla'              => new sfValidatorInteger(array('required' => false)),
      'peso_deseado'       => new sfValidatorInteger(array('required' => false)),
      'estructura_osea'    => new sfValidatorString(array('max_length' => 8, 'required' => false)),
      'impresion'          => new sfValidatorString(array('max_length' => 11, 'required' => false)),
      'peso_real'          => new sfValidatorInteger(array('required' => false)),
      'p_tricipital'       => new sfValidatorInteger(array('required' => false)),
      'p_tricipital_p'     => new sfValidatorString(array('max_length' => 6, 'required' => false)),
      'p_subescapular'     => new sfValidatorInteger(array('required' => false)),
      'p_subescapular_p'   => new sfValidatorString(array('max_length' => 6, 'required' => false)),
      'sum_pliegues'       => new sfValidatorInteger(array('required' => false)),
      'p_sum_pliegues'     => new sfValidatorString(array('max_length' => 6, 'required' => false)),
      'cf_brazo'           => new sfValidatorInteger(array('required' => false)),
      'p_cf_brazo'         => new sfValidatorString(array('max_length' => 6, 'required' => false)),
      'cf_musc_brazo'      => new sfValidatorInteger(array('required' => false)),
      'p_cf_musc_brazo'    => new sfValidatorString(array('max_length' => 6, 'required' => false)),
      'area_brazo'         => new sfValidatorInteger(array('required' => false)),
      'area_musc_brazo'    => new sfValidatorInteger(array('required' => false)),
      'p_area_musc_brazo'  => new sfValidatorString(array('max_length' => 6, 'required' => false)),
      'area_grasa_brazo'   => new sfValidatorInteger(array('required' => false)),
      'p_area_grasa_brazo' => new sfValidatorString(array('max_length' => 6, 'required' => false)),
      'r_cintura_cadera'   => new sfValidatorInteger(array('required' => false)),
      'diag_nutricional'   => new sfValidatorString(array('max_length' => 13, 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('evolucion_trasplante_nutricion[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'EvolucionTrasplanteNutricion';
  }

}
