<?php

/**
 * PacientePerdidaInjerto filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BasePacientePerdidaInjertoFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'causa'            => new sfWidgetFormFilterInput(),
      'id_pretrasplante' => new sfWidgetFormFilterInput(array('with_empty' => false)),
    ));

    $this->setValidators(array(
      'causa'            => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'id_pretrasplante' => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
    ));

    $this->widgetSchema->setNameFormat('paciente_perdida_injerto_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'PacientePerdidaInjerto';
  }

  public function getFields()
  {
    return array(
      'the'              => 'Number',
      'causa'            => 'Number',
      'fecha_perdida'    => 'Date',
      'id_pretrasplante' => 'Number',
    );
  }
}
