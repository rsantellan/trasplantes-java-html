<?php

/**
 * Pacientes form base class.
 *
 * @method Pacientes getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BasePacientesForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'the'              => new sfWidgetFormInputHidden(),
      'ci'               => new sfWidgetFormInputText(),
      'nombre'           => new sfWidgetFormInputText(),
      'apellido'         => new sfWidgetFormInputText(),
      'num_fnr'          => new sfWidgetFormInputText(),
      'raza'             => new sfWidgetFormInputText(),
      'sexo'             => new sfWidgetFormInputText(),
      'fecha_nacimiento' => new sfWidgetFormDate(),
      'fecha_dialisis'   => new sfWidgetFormDate(),
      'nefropatia'       => new sfWidgetFormInputText(),
      'grupo_sang'       => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'the'              => new sfValidatorChoice(array('choices' => array($this->getObject()->get('the')), 'empty_value' => $this->getObject()->get('the'), 'required' => false)),
      'ci'               => new sfValidatorString(array('max_length' => 12)),
      'nombre'           => new sfValidatorString(array('max_length' => 50, 'required' => false)),
      'apellido'         => new sfValidatorString(array('max_length' => 50, 'required' => false)),
      'num_fnr'          => new sfValidatorInteger(array('required' => false)),
      'raza'             => new sfValidatorString(array('max_length' => 15, 'required' => false)),
      'sexo'             => new sfValidatorString(array('max_length' => 1, 'required' => false)),
      'fecha_nacimiento' => new sfValidatorDate(array('required' => false)),
      'fecha_dialisis'   => new sfValidatorDate(array('required' => false)),
      'nefropatia'       => new sfValidatorInteger(array('required' => false)),
      'grupo_sang'       => new sfValidatorString(array('max_length' => 2, 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('pacientes[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'Pacientes';
  }

}
