<?php

/**
 * ComplicacionesNoInfecciosas form base class.
 *
 * @method ComplicacionesNoInfecciosas getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseComplicacionesNoInfecciosasForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'tr_complicacion_id'    => new sfWidgetFormInputHidden(),
      'complicacion_valor_id' => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('ComplicacionesTiposValores'), 'add_empty' => false)),
    ));

    $this->setValidators(array(
      'tr_complicacion_id'    => new sfValidatorChoice(array('choices' => array($this->getObject()->get('tr_complicacion_id')), 'empty_value' => $this->getObject()->get('tr_complicacion_id'), 'required' => false)),
      'complicacion_valor_id' => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('ComplicacionesTiposValores'))),
    ));

    $this->widgetSchema->setNameFormat('complicaciones_no_infecciosas[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'ComplicacionesNoInfecciosas';
  }

}
