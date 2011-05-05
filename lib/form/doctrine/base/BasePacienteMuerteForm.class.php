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
      'the'            => new sfWidgetFormInputHidden(),
      'causa'          => new sfWidgetFormInputText(),
      'fecha_muerte'   => new sfWidgetFormDate(),
      'tr_funcionando' => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'the'            => new sfValidatorChoice(array('choices' => array($this->getObject()->get('the')), 'empty_value' => $this->getObject()->get('the'), 'required' => false)),
      'causa'          => new sfValidatorInteger(),
      'fecha_muerte'   => new sfValidatorDate(),
      'tr_funcionando' => new sfValidatorInteger(array('required' => false)),
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
