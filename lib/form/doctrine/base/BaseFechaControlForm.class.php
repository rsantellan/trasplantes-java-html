<?php

/**
 * FechaControl form base class.
 *
 * @method FechaControl getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseFechaControlForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'    => new sfWidgetFormInputHidden(),
      'fecha' => new sfWidgetFormInputText(),
      'anos'  => new sfWidgetFormInputText(),
      'meses' => new sfWidgetFormInputText(),
      'dias'  => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'id'    => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'fecha' => new sfValidatorString(array('max_length' => 50, 'required' => false)),
      'anos'  => new sfValidatorInteger(array('required' => false)),
      'meses' => new sfValidatorInteger(array('required' => false)),
      'dias'  => new sfValidatorInteger(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('fecha_control[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'FechaControl';
  }

}
