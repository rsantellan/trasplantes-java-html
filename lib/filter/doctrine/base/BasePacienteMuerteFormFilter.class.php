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
      'causa_muerte_id'         => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('PacienteCausaMuerte'), 'add_empty' => true)),
      'fecha_muerte'            => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate(), 'with_empty' => false)),
      'transplante_funcionando' => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'causa_muerte_id'         => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('PacienteCausaMuerte'), 'column' => 'id')),
      'fecha_muerte'            => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'transplante_funcionando' => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
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
      'paciente_id'             => 'Number',
      'causa_muerte_id'         => 'ForeignKey',
      'fecha_muerte'            => 'Date',
      'transplante_funcionando' => 'Number',
    );
  }
}
