<?php

/**
 * EvolucionTrasplanteexamenes form base class.
 *
 * @method EvolucionTrasplanteexamenes getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseEvolucionTrasplanteexamenesForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'idtrasplante' => new sfWidgetFormInputHidden(),
      'fecha'        => new sfWidgetFormInputHidden(),
      'tipo'         => new sfWidgetFormInputHidden(),
      'normal'       => new sfWidgetFormInputText(),
      'comentario'   => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'idtrasplante' => new sfValidatorChoice(array('choices' => array($this->getObject()->get('idtrasplante')), 'empty_value' => $this->getObject()->get('idtrasplante'), 'required' => false)),
      'fecha'        => new sfValidatorChoice(array('choices' => array($this->getObject()->get('fecha')), 'empty_value' => $this->getObject()->get('fecha'), 'required' => false)),
      'tipo'         => new sfValidatorChoice(array('choices' => array($this->getObject()->get('tipo')), 'empty_value' => $this->getObject()->get('tipo'), 'required' => false)),
      'normal'       => new sfValidatorInteger(),
      'comentario'   => new sfValidatorString(array('max_length' => 255, 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('evolucion_trasplanteexamenes[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'EvolucionTrasplanteexamenes';
  }

}
