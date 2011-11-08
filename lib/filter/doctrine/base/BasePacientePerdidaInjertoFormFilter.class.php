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
      'paciente_id'                       => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Pacientes'), 'add_empty' => true)),
      'paciente_causa_perdida_injerto_id' => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('PacienteCausaPerdidaInjerto'), 'add_empty' => true)),
      'fecha_perdida'                     => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate(), 'with_empty' => false)),
      'paciente_pre_trasplante_id'        => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Pacientepretrasplante'), 'add_empty' => true)),
    ));

    $this->setValidators(array(
      'paciente_id'                       => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Pacientes'), 'column' => 'id')),
      'paciente_causa_perdida_injerto_id' => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('PacienteCausaPerdidaInjerto'), 'column' => 'id')),
      'fecha_perdida'                     => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'paciente_pre_trasplante_id'        => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Pacientepretrasplante'), 'column' => 'id')),
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
      'id'                                => 'Number',
      'paciente_id'                       => 'ForeignKey',
      'paciente_causa_perdida_injerto_id' => 'ForeignKey',
      'fecha_perdida'                     => 'Date',
      'paciente_pre_trasplante_id'        => 'ForeignKey',
    );
  }
}
