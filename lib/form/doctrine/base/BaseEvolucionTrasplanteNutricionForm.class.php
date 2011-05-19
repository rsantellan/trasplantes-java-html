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
      'id'                 => new sfWidgetFormInputHidden(),
      'trasplante_id'      => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => false)),
      'fecha'              => new sfWidgetFormDate(),
      'talla'              => new sfWidgetFormInputText(),
      'peso_deseado'       => new sfWidgetFormInputText(),
      'estructura_osea'    => new sfWidgetFormChoice(array('choices' => array('Pequeña' => 'Pequeña', 'Mediana' => 'Mediana', 'Grande' => 'Grande'))),
      'impresion'          => new sfWidgetFormChoice(array('choices' => array('Adelgazado' => 'Adelgazado', 'Normopeso' => 'Normopeso', 'Sobrepeso' => 'Sobrepeso', 'Obesidad' => 'Obesidad'))),
      'peso_real'          => new sfWidgetFormInputText(),
      'p_tricipital'       => new sfWidgetFormInputText(),
      'p_tricipital_p'     => new sfWidgetFormChoice(array('choices' => array('<10' => '<10', '10-25' => '10-25', '26-50' => '26-50', '51-75' => '51-75', '76-91' => '76-91', '>90' => '>90'))),
      'p_subescapular'     => new sfWidgetFormInputText(),
      'p_subescapular_p'   => new sfWidgetFormChoice(array('choices' => array('<10' => '<10', '10-25' => '10-25', '26-50' => '26-50', '51-75' => '51-75', '76-91' => '76-91', '>90' => '>90'))),
      'sum_pliegues'       => new sfWidgetFormInputText(),
      'p_sum_pliegues'     => new sfWidgetFormChoice(array('choices' => array('<10' => '<10', '10-25' => '10-25', '26-50' => '26-50', '51-75' => '51-75', '76-91' => '76-91', '>90' => '>90'))),
      'cf_brazo'           => new sfWidgetFormInputText(),
      'p_cf_brazo'         => new sfWidgetFormChoice(array('choices' => array('<10' => '<10', '10-25' => '10-25', '26-50' => '26-50', '51-75' => '51-75', '76-91' => '76-91', '>90' => '>90'))),
      'cf_musc_brazo'      => new sfWidgetFormInputText(),
      'p_cf_musc_brazo'    => new sfWidgetFormChoice(array('choices' => array('<10' => '<10', '10-25' => '10-25', '26-50' => '26-50', '51-75' => '51-75', '76-91' => '76-91', '>90' => '>90'))),
      'area_brazo'         => new sfWidgetFormInputText(),
      'area_musc_brazo'    => new sfWidgetFormInputText(),
      'p_area_musc_brazo'  => new sfWidgetFormChoice(array('choices' => array('<10' => '<10', '10-25' => '10-25', '26-50' => '26-50', '51-75' => '51-75', '76-91' => '76-91', '>90' => '>90'))),
      'area_grasa_brazo'   => new sfWidgetFormInputText(),
      'p_area_grasa_brazo' => new sfWidgetFormChoice(array('choices' => array('<10' => '<10', '10-25' => '10-25', '26-50' => '26-50', '51-75' => '51-75', '76-91' => '76-91', '>90' => '>90'))),
      'r_cintura_cadera'   => new sfWidgetFormInputText(),
      'diag_nutricional'   => new sfWidgetFormChoice(array('choices' => array('Desnleve' => 'Desnleve', 'Desnmoderada' => 'Desnmoderada', 'Desnsevera' => 'Desnsevera', 'Normopeso' => 'Normopeso', 'Sobrepeso' => 'Sobrepeso', 'Obesidad' => 'Obesidad'))),
    ));

    $this->setValidators(array(
      'id'                 => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'trasplante_id'      => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'))),
      'fecha'              => new sfValidatorDate(),
      'talla'              => new sfValidatorInteger(array('required' => false)),
      'peso_deseado'       => new sfValidatorInteger(array('required' => false)),
      'estructura_osea'    => new sfValidatorChoice(array('choices' => array(0 => 'Pequeña', 1 => 'Mediana', 2 => 'Grande'))),
      'impresion'          => new sfValidatorChoice(array('choices' => array(0 => 'Adelgazado', 1 => 'Normopeso', 2 => 'Sobrepeso', 3 => 'Obesidad'))),
      'peso_real'          => new sfValidatorInteger(array('required' => false)),
      'p_tricipital'       => new sfValidatorInteger(array('required' => false)),
      'p_tricipital_p'     => new sfValidatorChoice(array('choices' => array(0 => '<10', 1 => '10-25', 2 => '26-50', 3 => '51-75', 4 => '76-91', 5 => '>90'))),
      'p_subescapular'     => new sfValidatorInteger(array('required' => false)),
      'p_subescapular_p'   => new sfValidatorChoice(array('choices' => array(0 => '<10', 1 => '10-25', 2 => '26-50', 3 => '51-75', 4 => '76-91', 5 => '>90'))),
      'sum_pliegues'       => new sfValidatorInteger(array('required' => false)),
      'p_sum_pliegues'     => new sfValidatorChoice(array('choices' => array(0 => '<10', 1 => '10-25', 2 => '26-50', 3 => '51-75', 4 => '76-91', 5 => '>90'))),
      'cf_brazo'           => new sfValidatorInteger(array('required' => false)),
      'p_cf_brazo'         => new sfValidatorChoice(array('choices' => array(0 => '<10', 1 => '10-25', 2 => '26-50', 3 => '51-75', 4 => '76-91', 5 => '>90'))),
      'cf_musc_brazo'      => new sfValidatorInteger(array('required' => false)),
      'p_cf_musc_brazo'    => new sfValidatorChoice(array('choices' => array(0 => '<10', 1 => '10-25', 2 => '26-50', 3 => '51-75', 4 => '76-91', 5 => '>90'))),
      'area_brazo'         => new sfValidatorInteger(array('required' => false)),
      'area_musc_brazo'    => new sfValidatorInteger(array('required' => false)),
      'p_area_musc_brazo'  => new sfValidatorChoice(array('choices' => array(0 => '<10', 1 => '10-25', 2 => '26-50', 3 => '51-75', 4 => '76-91', 5 => '>90'))),
      'area_grasa_brazo'   => new sfValidatorInteger(array('required' => false)),
      'p_area_grasa_brazo' => new sfValidatorChoice(array('choices' => array(0 => '<10', 1 => '10-25', 2 => '26-50', 3 => '51-75', 4 => '76-91', 5 => '>90'))),
      'r_cintura_cadera'   => new sfValidatorInteger(array('required' => false)),
      'diag_nutricional'   => new sfValidatorChoice(array('choices' => array(0 => 'Desnleve', 1 => 'Desnmoderada', 2 => 'Desnsevera', 3 => 'Normopeso', 4 => 'Sobrepeso', 5 => 'Obesidad'))),
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
