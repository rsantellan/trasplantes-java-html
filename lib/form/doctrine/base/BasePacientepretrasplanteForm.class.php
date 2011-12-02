<?php

/**
 * Pacientepretrasplante form base class.
 *
 * @method Pacientepretrasplante getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BasePacientepretrasplanteForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'                  => new sfWidgetFormInputHidden(),
      'paciente_id'         => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Pacientes'), 'add_empty' => false)),
      'the'                 => new sfWidgetFormInputText(),
      'fecha_ingreso_lista' => new sfWidgetFormDate(),
      'fecha_egreso'        => new sfWidgetFormDate(),
      'modalidad_d'         => new sfWidgetFormChoice(array('choices' => array('HD' => 'HD', 'DPCA' => 'DPCA', 'HD+DPCA' => 'HD+DPCA', 'TR' => 'TR', 'HD+TR' => 'HD+TR', 'DPCA+TR' => 'DPCA+TR', 'HD+TR+DPCA' => 'HD+TR+DPCA', 'TM' => 'TM'))),
      'diabetes'            => new sfWidgetFormChoice(array('choices' => array('No' => 'No', 'Tipo I' => 'Tipo I', 'Tipo II' => 'Tipo II'))),
      'imc'                 => new sfWidgetFormChoice(array('choices' => array('<20' => '<20', 'entre 20 y 25' => 'entre 20 y 25', '>25' => '>25'))),
      'origen'              => new sfWidgetFormChoice(array('choices' => array('MSP' => 'MSP', 'IAMC' => 'IAMC', 'Otra' => 'Otra'))),
      'pbr'                 => new sfWidgetFormInputText(),
      'hta'                 => new sfWidgetFormInputText(),
      'obesidad'            => new sfWidgetFormInputText(),
      'dislipemia'          => new sfWidgetFormInputText(),
      'tabaquismo'          => new sfWidgetFormInputText(),
      'iam'                 => new sfWidgetFormInputText(),
      'ave'                 => new sfWidgetFormInputText(),
      'revasc_cardio'       => new sfWidgetFormInputText(),
      'meses_en_lista'      => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'id'                  => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'paciente_id'         => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Pacientes'))),
      'the'                 => new sfValidatorInteger(),
      'fecha_ingreso_lista' => new sfValidatorDate(),
      'fecha_egreso'        => new sfValidatorDate(array('required' => false)),
      'modalidad_d'         => new sfValidatorChoice(array('choices' => array(0 => 'HD', 1 => 'DPCA', 2 => 'HD+DPCA', 3 => 'TR', 4 => 'HD+TR', 5 => 'DPCA+TR', 6 => 'HD+TR+DPCA', 7 => 'TM'))),
      'diabetes'            => new sfValidatorChoice(array('choices' => array(0 => 'No', 1 => 'Tipo I', 2 => 'Tipo II'))),
      'imc'                 => new sfValidatorChoice(array('choices' => array(0 => '<20', 1 => 'entre 20 y 25', 2 => '>25'))),
      'origen'              => new sfValidatorChoice(array('choices' => array(0 => 'MSP', 1 => 'IAMC', 2 => 'Otra'))),
      'pbr'                 => new sfValidatorInteger(array('required' => false)),
      'hta'                 => new sfValidatorInteger(array('required' => false)),
      'obesidad'            => new sfValidatorInteger(array('required' => false)),
      'dislipemia'          => new sfValidatorInteger(array('required' => false)),
      'tabaquismo'          => new sfValidatorInteger(array('required' => false)),
      'iam'                 => new sfValidatorInteger(array('required' => false)),
      'ave'                 => new sfValidatorInteger(array('required' => false)),
      'revasc_cardio'       => new sfValidatorInteger(array('required' => false)),
      'meses_en_lista'      => new sfValidatorInteger(array('required' => false)),
    ));

    $this->validatorSchema->setPostValidator(
      new sfValidatorDoctrineUnique(array('model' => 'Pacientepretrasplante', 'column' => array('the')))
    );

    $this->widgetSchema->setNameFormat('pacientepretrasplante[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'Pacientepretrasplante';
  }

}
