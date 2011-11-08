<?php

/**
 * EvolucionTrasplanteCounter form base class.
 *
 * @method EvolucionTrasplanteCounter getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseEvolucionTrasplanteCounterForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'            => new sfWidgetFormInputHidden(),
      'trasplante_id' => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => false)),
      'object_class'  => new sfWidgetFormInputText(),
      'object_id'     => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'id'            => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'trasplante_id' => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'))),
      'object_class'  => new sfValidatorString(array('max_length' => 128)),
      'object_id'     => new sfValidatorInteger(),
    ));

    $this->widgetSchema->setNameFormat('evolucion_trasplante_counter[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'EvolucionTrasplanteCounter';
  }

}
