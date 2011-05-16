<?php

/**
 * ComplicacionesTiposValores filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseComplicacionesTiposValoresFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'nombre'               => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'complicacion_tipo_id' => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('ComplicacionesTipos'), 'add_empty' => true)),
    ));

    $this->setValidators(array(
      'nombre'               => new sfValidatorPass(array('required' => false)),
      'complicacion_tipo_id' => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('ComplicacionesTipos'), 'column' => 'id')),
    ));

    $this->widgetSchema->setNameFormat('complicaciones_tipos_valores_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'ComplicacionesTiposValores';
  }

  public function getFields()
  {
    return array(
      'id'                   => 'Number',
      'nombre'               => 'Text',
      'complicacion_tipo_id' => 'ForeignKey',
    );
  }
}
