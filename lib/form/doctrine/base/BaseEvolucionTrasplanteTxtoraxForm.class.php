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
      'id'              => new sfWidgetFormInputHidden(),
      'trasplante_id'   => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => false)),
      'fecha'           => new sfWidgetFormDate(),
      'rct'             => new sfWidgetFormInputText(),
      'foco'            => new sfWidgetFormInputText(),
      'lateralizado'    => new sfWidgetFormChoice(array('choices' => array('Izquierda' => 'Izquierda', 'Derecha' => 'Derecha', 'Bilateral' => 'Bilateral'))),
      'derrame_pleural' => new sfWidgetFormInputText(),
      'lateral_derrame' => new sfWidgetFormChoice(array('choices' => array('Izquierda' => 'Izquierda', 'Derecha' => 'Derecha', 'Bilateral' => 'Bilateral'))),
      'secuelas'        => new sfWidgetFormInputText(),
      'otros'           => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'id'              => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'trasplante_id'   => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'))),
      'fecha'           => new sfValidatorDate(),
      'rct'             => new sfValidatorInteger(array('required' => false)),
      'foco'            => new sfValidatorInteger(array('required' => false)),
      'lateralizado'    => new sfValidatorChoice(array('choices' => array(0 => 'Izquierda', 1 => 'Derecha', 2 => 'Bilateral'))),
      'derrame_pleural' => new sfValidatorInteger(array('required' => false)),
      'lateral_derrame' => new sfValidatorChoice(array('choices' => array(0 => 'Izquierda', 1 => 'Derecha', 2 => 'Bilateral'))),
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
