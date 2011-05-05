<?php

/**
 * Cmv form base class.
 *
 * @method Cmv getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseCmvForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'                 => new sfWidgetFormInputHidden(),
      'trasplante_id'      => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => false)),
      'fecha'              => new sfWidgetFormDate(),
      'cmv_diagnostico_id' => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Cmvdiagnostico'), 'add_empty' => false)),
      'tipo'               => new sfWidgetFormInputText(),
      'cmv_droga_id'       => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Cmvdrogas'), 'add_empty' => false)),
      'dias_tratamiento'   => new sfWidgetFormInputText(),
      'efecto_secundario'  => new sfWidgetFormInputText(),
      'created_at'         => new sfWidgetFormDateTime(),
      'updated_at'         => new sfWidgetFormDateTime(),
    ));

    $this->setValidators(array(
      'id'                 => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'trasplante_id'      => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'))),
      'fecha'              => new sfValidatorDate(),
      'cmv_diagnostico_id' => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Cmvdiagnostico'))),
      'tipo'               => new sfValidatorInteger(),
      'cmv_droga_id'       => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Cmvdrogas'))),
      'dias_tratamiento'   => new sfValidatorInteger(array('required' => false)),
      'efecto_secundario'  => new sfValidatorString(array('max_length' => 255, 'required' => false)),
      'created_at'         => new sfValidatorDateTime(),
      'updated_at'         => new sfValidatorDateTime(),
    ));

    $this->widgetSchema->setNameFormat('cmv[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'Cmv';
  }

}
