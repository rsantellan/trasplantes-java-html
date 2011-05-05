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
      'paciente_id'             => new sfWidgetFormInputHidden(),
      'causa_muerte_id'         => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('PacienteCausaMuerte'), 'add_empty' => false)),
      'fecha_muerte'            => new sfWidgetFormDate(),
      'transplante_funcionando' => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'paciente_id'             => new sfValidatorChoice(array('choices' => array($this->getObject()->get('paciente_id')), 'empty_value' => $this->getObject()->get('paciente_id'), 'required' => false)),
      'causa_muerte_id'         => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('PacienteCausaMuerte'))),
      'fecha_muerte'            => new sfValidatorDate(),
      'transplante_funcionando' => new sfValidatorInteger(array('required' => false)),
    ));

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
