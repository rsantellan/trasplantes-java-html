<?php

/**
 * EvolucionTrasplanteEcografia form base class.
 *
 * @method EvolucionTrasplanteEcografia getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseEvolucionTrasplanteEcografiaForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'            => new sfWidgetFormInputHidden(),
      'trasplante_id' => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => false)),
      'fecha'         => new sfWidgetFormDate(),
      'diametros'     => new sfWidgetFormInputText(),
      'dilatacion'    => new sfWidgetFormInputText(),
      'litiasin'      => new sfWidgetFormInputText(),
      'vejiga'        => new sfWidgetFormInputText(),
      'espesor'       => new sfWidgetFormInputText(),
      'otros'         => new sfWidgetFormTextarea(),
    ));

    $this->setValidators(array(
      'id'            => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'trasplante_id' => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'))),
      'fecha'         => new sfValidatorDate(),
      'diametros'     => new sfValidatorString(array('max_length' => 45, 'required' => false)),
      'dilatacion'    => new sfValidatorInteger(array('required' => false)),
      'litiasin'      => new sfValidatorInteger(array('required' => false)),
      'vejiga'        => new sfValidatorString(array('max_length' => 255, 'required' => false)),
      'espesor'       => new sfValidatorInteger(array('required' => false)),
      'otros'         => new sfValidatorString(array('max_length' => 1000, 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('evolucion_trasplante_ecografia[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'EvolucionTrasplanteEcografia';
  }

}
