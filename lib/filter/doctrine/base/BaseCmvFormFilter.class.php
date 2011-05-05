<?php

/**
 * Cmv filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseCmvFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'diagnostico'      => new sfWidgetFormFilterInput(),
      'tm'               => new sfWidgetFormFilterInput(),
      'sindromeviral'    => new sfWidgetFormFilterInput(),
      'profilaxis'       => new sfWidgetFormFilterInput(),
      'droga'            => new sfWidgetFormFilterInput(),
      'diastm'           => new sfWidgetFormFilterInput(),
      'efectosecundario' => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'diagnostico'      => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'tm'               => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'sindromeviral'    => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'profilaxis'       => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'droga'            => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'diastm'           => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'efectosecundario' => new sfValidatorPass(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('cmv_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'Cmv';
  }

  public function getFields()
  {
    return array(
      'trasplante'       => 'Number',
      'fecha'            => 'Date',
      'diagnostico'      => 'Number',
      'tm'               => 'Number',
      'sindromeviral'    => 'Number',
      'profilaxis'       => 'Number',
      'droga'            => 'Number',
      'diastm'           => 'Number',
      'efectosecundario' => 'Text',
    );
  }
}
