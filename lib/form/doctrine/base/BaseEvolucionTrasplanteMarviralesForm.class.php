<?php

/**
 * EvolucionTrasplanteMarvirales form base class.
 *
 * @method EvolucionTrasplanteMarvirales getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseEvolucionTrasplanteMarviralesForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'idtrasplante' => new sfWidgetFormInputHidden(),
      'fecha'        => new sfWidgetFormInputHidden(),
      'hsv'          => new sfWidgetFormInputText(),
      'aghbs'        => new sfWidgetFormInputText(),
      'hbsac'        => new sfWidgetFormInputText(),
      'hbcac'        => new sfWidgetFormInputText(),
      'hvc'          => new sfWidgetFormInputText(),
      'hiv'          => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'idtrasplante' => new sfValidatorChoice(array('choices' => array($this->getObject()->get('idtrasplante')), 'empty_value' => $this->getObject()->get('idtrasplante'), 'required' => false)),
      'fecha'        => new sfValidatorChoice(array('choices' => array($this->getObject()->get('fecha')), 'empty_value' => $this->getObject()->get('fecha'), 'required' => false)),
      'hsv'          => new sfValidatorInteger(array('required' => false)),
      'aghbs'        => new sfValidatorString(array('max_length' => 13, 'required' => false)),
      'hbsac'        => new sfValidatorString(array('max_length' => 13, 'required' => false)),
      'hbcac'        => new sfValidatorString(array('max_length' => 13, 'required' => false)),
      'hvc'          => new sfValidatorString(array('max_length' => 13, 'required' => false)),
      'hiv'          => new sfValidatorString(array('max_length' => 13, 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('evolucion_trasplante_marvirales[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'EvolucionTrasplanteMarvirales';
  }

}
