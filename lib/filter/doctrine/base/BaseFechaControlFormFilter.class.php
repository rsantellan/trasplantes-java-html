<?php

/**
 * FechaControl filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseFechaControlFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'fecha' => new sfWidgetFormFilterInput(),
      'anos'  => new sfWidgetFormFilterInput(),
      'meses' => new sfWidgetFormFilterInput(),
      'dias'  => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'fecha' => new sfValidatorPass(array('required' => false)),
      'anos'  => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'meses' => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'dias'  => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
    ));

    $this->widgetSchema->setNameFormat('fecha_control_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'FechaControl';
  }

  public function getFields()
  {
    return array(
      'id'    => 'Number',
      'fecha' => 'Text',
      'anos'  => 'Number',
      'meses' => 'Number',
      'dias'  => 'Number',
    );
  }
}
