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
      'idtrasplante' => new sfWidgetFormInputHidden(),
      'fecha'        => new sfWidgetFormInputHidden(),
      'diametros'    => new sfWidgetFormInputText(),
      'dilatacion'   => new sfWidgetFormInputText(),
      'litiasin'     => new sfWidgetFormInputText(),
      'vejiga'       => new sfWidgetFormInputText(),
      'espesor'      => new sfWidgetFormInputText(),
      'otros'        => new sfWidgetFormTextarea(),
    ));

    $this->setValidators(array(
      'idtrasplante' => new sfValidatorChoice(array('choices' => array($this->getObject()->get('idtrasplante')), 'empty_value' => $this->getObject()->get('idtrasplante'), 'required' => false)),
      'fecha'        => new sfValidatorChoice(array('choices' => array($this->getObject()->get('fecha')), 'empty_value' => $this->getObject()->get('fecha'), 'required' => false)),
      'diametros'    => new sfValidatorString(array('max_length' => 45)),
      'dilatacion'   => new sfValidatorInteger(),
      'litiasin'     => new sfValidatorInteger(),
      'vejiga'       => new sfValidatorString(array('max_length' => 255, 'required' => false)),
      'espesor'      => new sfValidatorInteger(),
      'otros'        => new sfValidatorString(array('max_length' => 1000, 'required' => false)),
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
