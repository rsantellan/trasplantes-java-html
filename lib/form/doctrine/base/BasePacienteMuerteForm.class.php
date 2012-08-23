<?php

/**
 * PacienteMuerte form base class.
 *
 * @method PacienteMuerte getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BasePacienteMuerteForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'                      => new sfWidgetFormInputHidden(),
      'paciente_id'             => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Pacientes'), 'add_empty' => true)),
      'causa_muerte_id'         => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('PacienteCausaMuerte'), 'add_empty' => false)),
      'fecha_muerte'            => new sfWidgetFormDate(),
      'transplante_funcionando' => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'id'                      => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'paciente_id'             => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Pacientes'), 'required' => false)),
      'causa_muerte_id'         => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('PacienteCausaMuerte'))),
      'fecha_muerte'            => new sfValidatorDate(),
      'transplante_funcionando' => new sfValidatorInteger(array('required' => false)),
    ));

    $this->validatorSchema->setPostValidator(
      new sfValidatorDoctrineUnique(array('model' => 'PacienteMuerte', 'column' => array('paciente_id')))
    );

    $this->widgetSchema->setNameFormat('paciente_muerte[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'PacienteMuerte';
  }

}
