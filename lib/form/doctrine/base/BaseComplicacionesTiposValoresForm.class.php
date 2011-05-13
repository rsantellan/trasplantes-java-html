<?php

/**
 * ComplicacionesTiposValores form base class.
 *
 * @method ComplicacionesTiposValores getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseComplicacionesTiposValoresForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'                   => new sfWidgetFormInputHidden(),
      'nombre'               => new sfWidgetFormInputText(),
      'complicacion_tipo_id' => new sfWidgetFormInputHidden(),
    ));

    $this->setValidators(array(
      'id'                   => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'nombre'               => new sfValidatorString(array('max_length' => 50)),
      'complicacion_tipo_id' => new sfValidatorChoice(array('choices' => array($this->getObject()->get('complicacion_tipo_id')), 'empty_value' => $this->getObject()->get('complicacion_tipo_id'), 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('complicaciones_tipos_valores[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'ComplicacionesTiposValores';
  }

}
