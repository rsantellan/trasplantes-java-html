<?php

/**
 * EvolucionTrasplanteCmv form base class.
 *
 * @method EvolucionTrasplanteCmv getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseEvolucionTrasplanteCmvForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'            => new sfWidgetFormInputHidden(),
      'trasplante_id' => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => false)),
      'fecha'         => new sfWidgetFormDate(),
      'igg_cmv'       => new sfWidgetFormInputText(),
      'igm_cmv'       => new sfWidgetFormInputText(),
      'pcr_cmv'       => new sfWidgetFormInputText(),
      'ag_pp65'       => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'id'            => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'trasplante_id' => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'))),
      'fecha'         => new sfValidatorDate(),
      'igg_cmv'       => new sfValidatorInteger(array('required' => false)),
      'igm_cmv'       => new sfValidatorInteger(array('required' => false)),
      'pcr_cmv'       => new sfValidatorInteger(array('required' => false)),
      'ag_pp65'       => new sfValidatorInteger(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('evolucion_trasplante_cmv[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'EvolucionTrasplanteCmv';
  }

}
