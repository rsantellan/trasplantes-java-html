<?php

/**
 * PacientePerdidaInjerto form base class.
 *
 * @method PacientePerdidaInjerto getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BasePacientePerdidaInjertoForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'                                => new sfWidgetFormInputHidden(),
      'paciente_id'                       => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Pacientes'), 'add_empty' => false)),
      'paciente_causa_perdida_injerto_id' => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('PacienteCausaPerdidaInjerto'), 'add_empty' => false)),
      'fecha_perdida'                     => new sfWidgetFormDate(),
      'paciente_pre_trasplante_id'        => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Pacientepretrasplante'), 'add_empty' => false)),
    ));

    $this->setValidators(array(
      'id'                                => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'paciente_id'                       => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Pacientes'))),
      'paciente_causa_perdida_injerto_id' => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('PacienteCausaPerdidaInjerto'))),
      'fecha_perdida'                     => new sfValidatorDate(),
      'paciente_pre_trasplante_id'        => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Pacientepretrasplante'))),
    ));

    $this->widgetSchema->setNameFormat('paciente_perdida_injerto[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'PacientePerdidaInjerto';
  }

}
