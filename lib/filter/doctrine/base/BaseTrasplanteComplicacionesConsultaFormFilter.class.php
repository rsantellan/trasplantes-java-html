<?php

/**
 * TrasplanteComplicacionesConsulta filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseTrasplanteComplicacionesConsultaFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'trasplante_id'          => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'complicacion_id'        => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'complicacion_class'     => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'dias_desde_trasplante'  => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'meses_desde_trasplante' => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'years_desde_trasplante' => new sfWidgetFormFilterInput(array('with_empty' => false)),
    ));

    $this->setValidators(array(
      'trasplante_id'          => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'complicacion_id'        => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'complicacion_class'     => new sfValidatorPass(array('required' => false)),
      'dias_desde_trasplante'  => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'meses_desde_trasplante' => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'years_desde_trasplante' => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
    ));

    $this->widgetSchema->setNameFormat('trasplante_complicaciones_consulta_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'TrasplanteComplicacionesConsulta';
  }

  public function getFields()
  {
    return array(
      'id'                     => 'Number',
      'trasplante_id'          => 'Number',
      'complicacion_id'        => 'Number',
      'complicacion_class'     => 'Text',
      'dias_desde_trasplante'  => 'Number',
      'meses_desde_trasplante' => 'Number',
      'years_desde_trasplante' => 'Number',
    );
  }
}
