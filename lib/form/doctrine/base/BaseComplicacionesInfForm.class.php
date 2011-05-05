<?php

/**
 * ComplicacionesInf form base class.
 *
 * @method ComplicacionesInf getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseComplicacionesInfForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id_tr_complicacion' => new sfWidgetFormInputHidden(),
      'infeccion'          => new sfWidgetFormInputText(),
      'germen'             => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'id_tr_complicacion' => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id_tr_complicacion')), 'empty_value' => $this->getObject()->get('id_tr_complicacion'), 'required' => false)),
      'infeccion'          => new sfValidatorInteger(),
      'germen'             => new sfValidatorInteger(),
    ));

    $this->widgetSchema->setNameFormat('complicaciones_inf[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'ComplicacionesInf';
  }

}
