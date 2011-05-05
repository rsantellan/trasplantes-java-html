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
      'id'               => new sfWidgetFormInputHidden(),
      'the'              => new sfWidgetFormInputText(),
      'ci'               => new sfWidgetFormInputText(),
      'nombre'           => new sfWidgetFormInputText(),
      'apellido'         => new sfWidgetFormInputText(),
      'num_fnr'          => new sfWidgetFormInputText(),
      'raza'             => new sfWidgetFormInputText(),
      'sexo'             => new sfWidgetFormInputText(),
      'fecha_nacimiento' => new sfWidgetFormDate(),
      'fecha_dialisis'   => new sfWidgetFormDate(),
      'nefropatia_id'    => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Nefropatia'), 'add_empty' => false)),
      'grupo_sanguineo'  => new sfWidgetFormChoice(array('choices' => array('A' => 'A', 'B' => 'B', 'AB' => 'AB', 'O' => 'O'))),
    ));

    $this->setValidators(array(
      'id'               => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'the'              => new sfValidatorInteger(),
      'ci'               => new sfValidatorString(array('max_length' => 12)),
      'nombre'           => new sfValidatorString(array('max_length' => 50)),
      'apellido'         => new sfValidatorString(array('max_length' => 50)),
      'num_fnr'          => new sfValidatorInteger(),
      'raza'             => new sfValidatorString(array('max_length' => 15)),
      'sexo'             => new sfValidatorString(array('max_length' => 1)),
      'fecha_nacimiento' => new sfValidatorDate(),
      'fecha_dialisis'   => new sfValidatorDate(),
      'nefropatia_id'    => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Nefropatia'))),
      'grupo_sanguineo'  => new sfValidatorChoice(array('choices' => array(0 => 'A', 1 => 'B', 2 => 'AB', 3 => 'O'))),
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
