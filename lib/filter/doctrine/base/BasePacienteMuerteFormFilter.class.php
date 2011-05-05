<?php

/**
 * PacienteMuerte filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BasePacienteMuerteFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'causa'          => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'fecha_muerte'   => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate(), 'with_empty' => false)),
      'tr_funcionando' => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'causa'          => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'fecha_muerte'   => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'tr_funcionando' => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
    ));

    $this->widgetSchema->setNameFormat('paciente_muerte_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'PacienteMuerte';
  }

  public function getFields()
  {
    return array(
      'the'            => 'Number',
      'causa'          => 'Number',
      'fecha_muerte'   => 'Date',
      'tr_funcionando' => 'Number',
    );
  }
}
