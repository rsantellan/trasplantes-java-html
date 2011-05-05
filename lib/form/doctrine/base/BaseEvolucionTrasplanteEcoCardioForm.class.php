<?php

/**
 * EvolucionTrasplanteEcoCardio form base class.
 *
 * @method EvolucionTrasplanteEcoCardio getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseEvolucionTrasplanteEcoCardioForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'idtrasplante'    => new sfWidgetFormInputHidden(),
      'fecha'           => new sfWidgetFormInputHidden(),
      'fevi_normal'     => new sfWidgetFormInputText(),
      'insuf_hipodiast' => new sfWidgetFormInputText(),
      'i_ao'            => new sfWidgetFormInputText(),
      'e_ao'            => new sfWidgetFormInputText(),
      'i_m'             => new sfWidgetFormInputText(),
      'e_m'             => new sfWidgetFormInputText(),
      'i_p'             => new sfWidgetFormInputText(),
      'e_p'             => new sfWidgetFormInputText(),
      'i_t'             => new sfWidgetFormInputText(),
      'e_t'             => new sfWidgetFormInputText(),
      'derrame'         => new sfWidgetFormInputText(),
      'calcif_valvular' => new sfWidgetFormInputText(),
      'hvi'             => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'idtrasplante'    => new sfValidatorChoice(array('choices' => array($this->getObject()->get('idtrasplante')), 'empty_value' => $this->getObject()->get('idtrasplante'), 'required' => false)),
      'fecha'           => new sfValidatorChoice(array('choices' => array($this->getObject()->get('fecha')), 'empty_value' => $this->getObject()->get('fecha'), 'required' => false)),
      'fevi_normal'     => new sfValidatorInteger(array('required' => false)),
      'insuf_hipodiast' => new sfValidatorInteger(array('required' => false)),
      'i_ao'            => new sfValidatorInteger(array('required' => false)),
      'e_ao'            => new sfValidatorInteger(array('required' => false)),
      'i_m'             => new sfValidatorInteger(array('required' => false)),
      'e_m'             => new sfValidatorInteger(array('required' => false)),
      'i_p'             => new sfValidatorInteger(array('required' => false)),
      'e_p'             => new sfValidatorInteger(array('required' => false)),
      'i_t'             => new sfValidatorInteger(array('required' => false)),
      'e_t'             => new sfValidatorInteger(array('required' => false)),
      'derrame'         => new sfValidatorInteger(array('required' => false)),
      'calcif_valvular' => new sfValidatorInteger(array('required' => false)),
      'hvi'             => new sfValidatorInteger(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('evolucion_trasplante_eco_cardio[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'EvolucionTrasplanteEcoCardio';
  }

}
