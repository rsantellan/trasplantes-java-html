<?php

/**
 * EvolucionTrasplanteTxtorax form base class.
 *
 * @method EvolucionTrasplanteTxtorax getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseEvolucionTrasplanteTxtoraxForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'idtrasplante'    => new sfWidgetFormInputHidden(),
      'fecha'           => new sfWidgetFormInputHidden(),
      'rct'             => new sfWidgetFormInputText(),
      'foco'            => new sfWidgetFormInputText(),
      'lateralizado'    => new sfWidgetFormInputText(),
      'derrame_pleural' => new sfWidgetFormInputText(),
      'lateral_derrame' => new sfWidgetFormInputText(),
      'secuelas'        => new sfWidgetFormInputText(),
      'otros'           => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'idtrasplante'    => new sfValidatorChoice(array('choices' => array($this->getObject()->get('idtrasplante')), 'empty_value' => $this->getObject()->get('idtrasplante'), 'required' => false)),
      'fecha'           => new sfValidatorChoice(array('choices' => array($this->getObject()->get('fecha')), 'empty_value' => $this->getObject()->get('fecha'), 'required' => false)),
      'rct'             => new sfValidatorInteger(array('required' => false)),
      'foco'            => new sfValidatorInteger(array('required' => false)),
      'lateralizado'    => new sfValidatorString(array('max_length' => 9, 'required' => false)),
      'derrame_pleural' => new sfValidatorInteger(array('required' => false)),
      'lateral_derrame' => new sfValidatorString(array('max_length' => 9, 'required' => false)),
      'secuelas'        => new sfValidatorInteger(array('required' => false)),
      'otros'           => new sfValidatorString(array('max_length' => 255, 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('evolucion_trasplante_txtorax[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'EvolucionTrasplanteTxtorax';
  }

}
