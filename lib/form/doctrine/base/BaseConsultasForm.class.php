<?php

/**
 * Consultas form base class.
 *
 * @method Consultas getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseConsultasForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'        => new sfWidgetFormInputHidden(),
      'nombre'    => new sfWidgetFormInputText(),
      'sentencia' => new sfWidgetFormTextarea(),
      'tipos'     => new sfWidgetFormTextarea(),
      'nombres'   => new sfWidgetFormTextarea(),
    ));

    $this->setValidators(array(
      'id'        => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'nombre'    => new sfValidatorString(array('max_length' => 45)),
      'sentencia' => new sfValidatorString(array('max_length' => 10000)),
      'tipos'     => new sfValidatorString(array('max_length' => 10000)),
      'nombres'   => new sfValidatorString(array('max_length' => 10000)),
    ));

    $this->widgetSchema->setNameFormat('consultas[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'Consultas';
  }

}
