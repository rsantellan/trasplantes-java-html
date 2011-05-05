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
      'talla'              => new sfWidgetFormFilterInput(),
      'peso_deseado'       => new sfWidgetFormFilterInput(),
      'estructura_osea'    => new sfWidgetFormFilterInput(),
      'impresion'          => new sfWidgetFormFilterInput(),
      'peso_real'          => new sfWidgetFormFilterInput(),
      'p_tricipital'       => new sfWidgetFormFilterInput(),
      'p_tricipital_p'     => new sfWidgetFormFilterInput(),
      'p_subescapular'     => new sfWidgetFormFilterInput(),
      'p_subescapular_p'   => new sfWidgetFormFilterInput(),
      'sum_pliegues'       => new sfWidgetFormFilterInput(),
      'p_sum_pliegues'     => new sfWidgetFormFilterInput(),
      'cf_brazo'           => new sfWidgetFormFilterInput(),
      'p_cf_brazo'         => new sfWidgetFormFilterInput(),
      'cf_musc_brazo'      => new sfWidgetFormFilterInput(),
      'p_cf_musc_brazo'    => new sfWidgetFormFilterInput(),
      'area_brazo'         => new sfWidgetFormFilterInput(),
      'area_musc_brazo'    => new sfWidgetFormFilterInput(),
      'p_area_musc_brazo'  => new sfWidgetFormFilterInput(),
      'area_grasa_brazo'   => new sfWidgetFormFilterInput(),
      'p_area_grasa_brazo' => new sfWidgetFormFilterInput(),
      'r_cintura_cadera'   => new sfWidgetFormFilterInput(),
      'diag_nutricional'   => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'talla'              => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'peso_deseado'       => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'estructura_osea'    => new sfValidatorPass(array('required' => false)),
      'impresion'          => new sfValidatorPass(array('required' => false)),
      'peso_real'          => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'p_tricipital'       => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'p_tricipital_p'     => new sfValidatorPass(array('required' => false)),
      'p_subescapular'     => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'p_subescapular_p'   => new sfValidatorPass(array('required' => false)),
      'sum_pliegues'       => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'p_sum_pliegues'     => new sfValidatorPass(array('required' => false)),
      'cf_brazo'           => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'p_cf_brazo'         => new sfValidatorPass(array('required' => false)),
      'cf_musc_brazo'      => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'p_cf_musc_brazo'    => new sfValidatorPass(array('required' => false)),
      'area_brazo'         => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'area_musc_brazo'    => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'p_area_musc_brazo'  => new sfValidatorPass(array('required' => false)),
      'area_grasa_brazo'   => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'p_area_grasa_brazo' => new sfValidatorPass(array('required' => false)),
      'r_cintura_cadera'   => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'diag_nutricional'   => new sfValidatorPass(array('required' => false)),
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
      'idtrasplante'       => 'Number',
      'fecha'              => 'Date',
      'talla'              => 'Number',
      'peso_deseado'       => 'Number',
      'estructura_osea'    => 'Text',
      'impresion'          => 'Text',
      'peso_real'          => 'Number',
      'p_tricipital'       => 'Number',
      'p_tricipital_p'     => 'Text',
      'p_subescapular'     => 'Number',
      'p_subescapular_p'   => 'Text',
      'sum_pliegues'       => 'Number',
      'p_sum_pliegues'     => 'Text',
      'cf_brazo'           => 'Number',
      'p_cf_brazo'         => 'Text',
      'cf_musc_brazo'      => 'Number',
      'p_cf_musc_brazo'    => 'Text',
      'area_brazo'         => 'Number',
      'area_musc_brazo'    => 'Number',
      'p_area_musc_brazo'  => 'Text',
      'area_grasa_brazo'   => 'Number',
      'p_area_grasa_brazo' => 'Text',
      'r_cintura_cadera'   => 'Number',
      'diag_nutricional'   => 'Text',
    );
  }
}
