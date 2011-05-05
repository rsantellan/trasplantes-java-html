<?php

/**
 * EvolucionTrasplanteEcg form base class.
 *
 * @method EvolucionTrasplanteEcg getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseEvolucionTrasplanteEcgForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'idtrasplante' => new sfWidgetFormInputHidden(),
      'fecha'        => new sfWidgetFormInputHidden(),
      'rs_ecg'       => new sfWidgetFormInputText(),
      'hvi_ecg'      => new sfWidgetFormInputText(),
      'onda_q_ecg'   => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'idtrasplante' => new sfValidatorChoice(array('choices' => array($this->getObject()->get('idtrasplante')), 'empty_value' => $this->getObject()->get('idtrasplante'), 'required' => false)),
      'fecha'        => new sfValidatorChoice(array('choices' => array($this->getObject()->get('fecha')), 'empty_value' => $this->getObject()->get('fecha'), 'required' => false)),
      'rs_ecg'       => new sfValidatorString(array('max_length' => 8, 'required' => false)),
      'hvi_ecg'      => new sfValidatorString(array('max_length' => 8, 'required' => false)),
      'onda_q_ecg'   => new sfValidatorString(array('max_length' => 8, 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('evolucion_trasplante_ecg[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'EvolucionTrasplanteEcg';
  }

}
