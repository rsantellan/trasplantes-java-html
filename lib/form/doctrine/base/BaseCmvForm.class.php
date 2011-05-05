<?php

/**
 * Cmv form base class.
 *
 * @method Cmv getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseCmvForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'trasplante'       => new sfWidgetFormInputHidden(),
      'fecha'            => new sfWidgetFormInputHidden(),
      'diagnostico'      => new sfWidgetFormInputText(),
      'tm'               => new sfWidgetFormInputText(),
      'sindromeviral'    => new sfWidgetFormInputText(),
      'profilaxis'       => new sfWidgetFormInputText(),
      'droga'            => new sfWidgetFormInputText(),
      'diastm'           => new sfWidgetFormInputText(),
      'efectosecundario' => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'trasplante'       => new sfValidatorChoice(array('choices' => array($this->getObject()->get('trasplante')), 'empty_value' => $this->getObject()->get('trasplante'), 'required' => false)),
      'fecha'            => new sfValidatorChoice(array('choices' => array($this->getObject()->get('fecha')), 'empty_value' => $this->getObject()->get('fecha'), 'required' => false)),
      'diagnostico'      => new sfValidatorInteger(array('required' => false)),
      'tm'               => new sfValidatorInteger(array('required' => false)),
      'sindromeviral'    => new sfValidatorInteger(array('required' => false)),
      'profilaxis'       => new sfValidatorInteger(array('required' => false)),
      'droga'            => new sfValidatorInteger(array('required' => false)),
      'diastm'           => new sfValidatorInteger(array('required' => false)),
      'efectosecundario' => new sfValidatorString(array('max_length' => 255, 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('cmv[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'Cmv';
  }

}
