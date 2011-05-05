<?php

/**
 * CmvUsoEnfermedades form base class.
 *
 * @method CmvUsoEnfermedades getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseCmvUsoEnfermedadesForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'trasplante'      => new sfWidgetFormInputHidden(),
      'fecha'           => new sfWidgetFormInputHidden(),
      'cmvenfermedades' => new sfWidgetFormInputHidden(),
      'created_at'      => new sfWidgetFormDateTime(),
      'updated_at'      => new sfWidgetFormDateTime(),
    ));

    $this->setValidators(array(
      'trasplante'      => new sfValidatorChoice(array('choices' => array($this->getObject()->get('trasplante')), 'empty_value' => $this->getObject()->get('trasplante'), 'required' => false)),
      'fecha'           => new sfValidatorChoice(array('choices' => array($this->getObject()->get('fecha')), 'empty_value' => $this->getObject()->get('fecha'), 'required' => false)),
      'cmvenfermedades' => new sfValidatorChoice(array('choices' => array($this->getObject()->get('cmvenfermedades')), 'empty_value' => $this->getObject()->get('cmvenfermedades'), 'required' => false)),
      'created_at'      => new sfValidatorDateTime(),
      'updated_at'      => new sfValidatorDateTime(),
    ));

    $this->widgetSchema->setNameFormat('cmv_uso_enfermedades[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'CmvUsoEnfermedades';
  }

}
