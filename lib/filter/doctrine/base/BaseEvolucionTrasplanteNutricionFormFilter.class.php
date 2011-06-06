<?php

/**
 * EvolucionTrasplanteNutricion filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseEvolucionTrasplanteNutricionFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'trasplante_id'      => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => true)),
      'fecha'              => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate(), 'with_empty' => false)),
      'talla'              => new sfWidgetFormFilterInput(),
      'peso_deseado'       => new sfWidgetFormFilterInput(),
      'estructura_osea'    => new sfWidgetFormChoice(array('choices' => array('' => '', 'Pequeña' => 'Pequeña', 'Mediana' => 'Mediana', 'Grande' => 'Grande'))),
      'impresion'          => new sfWidgetFormChoice(array('choices' => array('' => '', 'Adelgazado' => 'Adelgazado', 'Normopeso' => 'Normopeso', 'Sobrepeso' => 'Sobrepeso', 'Obesidad' => 'Obesidad'))),
      'peso_real'          => new sfWidgetFormFilterInput(),
      'p_tricipital'       => new sfWidgetFormFilterInput(),
      'p_tricipital_p'     => new sfWidgetFormChoice(array('choices' => array('' => '', '<10' => '<10', '10-25' => '10-25', '26-50' => '26-50', '51-75' => '51-75', '76-91' => '76-91', '>90' => '>90'))),
      'p_subescapular'     => new sfWidgetFormFilterInput(),
      'p_subescapular_p'   => new sfWidgetFormChoice(array('choices' => array('' => '', '<10' => '<10', '10-25' => '10-25', '26-50' => '26-50', '51-75' => '51-75', '76-91' => '76-91', '>90' => '>90'))),
      'sum_pliegues'       => new sfWidgetFormFilterInput(),
      'p_sum_pliegues'     => new sfWidgetFormChoice(array('choices' => array('' => '', '<10' => '<10', '10-25' => '10-25', '26-50' => '26-50', '51-75' => '51-75', '76-91' => '76-91', '>90' => '>90'))),
      'cf_brazo'           => new sfWidgetFormFilterInput(),
      'p_cf_brazo'         => new sfWidgetFormChoice(array('choices' => array('' => '', '<10' => '<10', '10-25' => '10-25', '26-50' => '26-50', '51-75' => '51-75', '76-91' => '76-91', '>90' => '>90'))),
      'cf_musc_brazo'      => new sfWidgetFormFilterInput(),
      'p_cf_musc_brazo'    => new sfWidgetFormChoice(array('choices' => array('' => '', '<10' => '<10', '10-25' => '10-25', '26-50' => '26-50', '51-75' => '51-75', '76-91' => '76-91', '>90' => '>90'))),
      'area_brazo'         => new sfWidgetFormFilterInput(),
      'area_musc_brazo'    => new sfWidgetFormFilterInput(),
      'p_area_musc_brazo'  => new sfWidgetFormChoice(array('choices' => array('' => '', '<10' => '<10', '10-25' => '10-25', '26-50' => '26-50', '51-75' => '51-75', '76-91' => '76-91', '>90' => '>90'))),
      'area_grasa_brazo'   => new sfWidgetFormFilterInput(),
      'p_area_grasa_brazo' => new sfWidgetFormChoice(array('choices' => array('' => '', '<10' => '<10', '10-25' => '10-25', '26-50' => '26-50', '51-75' => '51-75', '76-91' => '76-91', '>90' => '>90'))),
      'r_cintura_cadera'   => new sfWidgetFormFilterInput(),
      'diag_nutricional'   => new sfWidgetFormChoice(array('choices' => array('' => '', 'Desnleve' => 'Desnleve', 'Desnmoderada' => 'Desnmoderada', 'Desnsevera' => 'Desnsevera', 'Normopeso' => 'Normopeso', 'Sobrepeso' => 'Sobrepeso', 'Obesidad' => 'Obesidad'))),
    ));

    $this->setValidators(array(
      'trasplante_id'      => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Trasplante'), 'column' => 'id')),
      'fecha'              => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'talla'              => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'peso_deseado'       => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'estructura_osea'    => new sfValidatorChoice(array('required' => false, 'choices' => array('Pequeña' => 'Pequeña', 'Mediana' => 'Mediana', 'Grande' => 'Grande'))),
      'impresion'          => new sfValidatorChoice(array('required' => false, 'choices' => array('Adelgazado' => 'Adelgazado', 'Normopeso' => 'Normopeso', 'Sobrepeso' => 'Sobrepeso', 'Obesidad' => 'Obesidad'))),
      'peso_real'          => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'p_tricipital'       => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'p_tricipital_p'     => new sfValidatorChoice(array('required' => false, 'choices' => array('<10' => '<10', '10-25' => '10-25', '26-50' => '26-50', '51-75' => '51-75', '76-91' => '76-91', '>90' => '>90'))),
      'p_subescapular'     => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'p_subescapular_p'   => new sfValidatorChoice(array('required' => false, 'choices' => array('<10' => '<10', '10-25' => '10-25', '26-50' => '26-50', '51-75' => '51-75', '76-91' => '76-91', '>90' => '>90'))),
      'sum_pliegues'       => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'p_sum_pliegues'     => new sfValidatorChoice(array('required' => false, 'choices' => array('<10' => '<10', '10-25' => '10-25', '26-50' => '26-50', '51-75' => '51-75', '76-91' => '76-91', '>90' => '>90'))),
      'cf_brazo'           => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'p_cf_brazo'         => new sfValidatorChoice(array('required' => false, 'choices' => array('<10' => '<10', '10-25' => '10-25', '26-50' => '26-50', '51-75' => '51-75', '76-91' => '76-91', '>90' => '>90'))),
      'cf_musc_brazo'      => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'p_cf_musc_brazo'    => new sfValidatorChoice(array('required' => false, 'choices' => array('<10' => '<10', '10-25' => '10-25', '26-50' => '26-50', '51-75' => '51-75', '76-91' => '76-91', '>90' => '>90'))),
      'area_brazo'         => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'area_musc_brazo'    => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'p_area_musc_brazo'  => new sfValidatorChoice(array('required' => false, 'choices' => array('<10' => '<10', '10-25' => '10-25', '26-50' => '26-50', '51-75' => '51-75', '76-91' => '76-91', '>90' => '>90'))),
      'area_grasa_brazo'   => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'p_area_grasa_brazo' => new sfValidatorChoice(array('required' => false, 'choices' => array('<10' => '<10', '10-25' => '10-25', '26-50' => '26-50', '51-75' => '51-75', '76-91' => '76-91', '>90' => '>90'))),
      'r_cintura_cadera'   => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'diag_nutricional'   => new sfValidatorChoice(array('required' => false, 'choices' => array('Desnleve' => 'Desnleve', 'Desnmoderada' => 'Desnmoderada', 'Desnsevera' => 'Desnsevera', 'Normopeso' => 'Normopeso', 'Sobrepeso' => 'Sobrepeso', 'Obesidad' => 'Obesidad'))),
    ));

    $this->widgetSchema->setNameFormat('evolucion_trasplante_nutricion_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'EvolucionTrasplanteNutricion';
  }

  public function getFields()
  {
    return array(
      'id'                 => 'Number',
      'trasplante_id'      => 'ForeignKey',
      'fecha'              => 'Date',
      'talla'              => 'Number',
      'peso_deseado'       => 'Number',
      'estructura_osea'    => 'Enum',
      'impresion'          => 'Enum',
      'peso_real'          => 'Number',
      'p_tricipital'       => 'Number',
      'p_tricipital_p'     => 'Enum',
      'p_subescapular'     => 'Number',
      'p_subescapular_p'   => 'Enum',
      'sum_pliegues'       => 'Number',
      'p_sum_pliegues'     => 'Enum',
      'cf_brazo'           => 'Number',
      'p_cf_brazo'         => 'Enum',
      'cf_musc_brazo'      => 'Number',
      'p_cf_musc_brazo'    => 'Enum',
      'area_brazo'         => 'Number',
      'area_musc_brazo'    => 'Number',
      'p_area_musc_brazo'  => 'Enum',
      'area_grasa_brazo'   => 'Number',
      'p_area_grasa_brazo' => 'Enum',
      'r_cintura_cadera'   => 'Number',
      'diag_nutricional'   => 'Enum',
    );
  }
}
