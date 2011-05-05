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
      'the'                 => new sfWidgetFormInputText(),
      'fecha_ingreso_lista' => new sfWidgetFormDate(),
      'fecha_egreso'        => new sfWidgetFormDate(),
      'modalidad_d'         => new sfWidgetFormInputText(),
      'pbr'                 => new sfWidgetFormInputText(),
      'diabetes'            => new sfWidgetFormInputText(),
      'hta'                 => new sfWidgetFormInputText(),
      'obesidad'            => new sfWidgetFormInputText(),
      'imc'                 => new sfWidgetFormInputText(),
      'dislipemia'          => new sfWidgetFormInputText(),
      'tabaquismo'          => new sfWidgetFormInputText(),
      'origen'              => new sfWidgetFormInputText(),
      'iam'                 => new sfWidgetFormInputText(),
      'ave'                 => new sfWidgetFormInputText(),
      'revasc_cardio'       => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'id'                  => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'the'                 => new sfValidatorInteger(),
      'fecha_ingreso_lista' => new sfValidatorDate(array('required' => false)),
      'fecha_egreso'        => new sfValidatorDate(array('required' => false)),
      'modalidad_d'         => new sfValidatorString(array('max_length' => 10, 'required' => false)),
      'pbr'                 => new sfValidatorInteger(array('required' => false)),
      'diabetes'            => new sfValidatorString(array('max_length' => 7, 'required' => false)),
      'hta'                 => new sfValidatorInteger(array('required' => false)),
      'obesidad'            => new sfValidatorInteger(array('required' => false)),
      'imc'                 => new sfValidatorString(array('max_length' => 13, 'required' => false)),
      'dislipemia'          => new sfValidatorInteger(array('required' => false)),
      'tabaquismo'          => new sfValidatorInteger(array('required' => false)),
      'origen'              => new sfValidatorString(array('max_length' => 4, 'required' => false)),
      'iam'                 => new sfValidatorInteger(array('required' => false)),
      'ave'                 => new sfValidatorInteger(array('required' => false)),
      'revasc_cardio'       => new sfValidatorInteger(array('required' => false)),
    ));

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
