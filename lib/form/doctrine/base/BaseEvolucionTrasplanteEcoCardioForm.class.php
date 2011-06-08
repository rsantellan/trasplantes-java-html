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
      'id'              => new sfWidgetFormInputHidden(),
      'trasplante_id'   => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => false)),
      'fecha'           => new sfWidgetFormDate(),
      'fevi_normal'     => new sfWidgetFormInputText(),
      'insuf_hipodiast' => new sfWidgetFormInputText(),
      'iao'             => new sfWidgetFormInputText(),
      'eao'             => new sfWidgetFormInputText(),
      'im'              => new sfWidgetFormInputText(),
      'em'              => new sfWidgetFormInputText(),
      'ip'              => new sfWidgetFormInputText(),
      'ep'              => new sfWidgetFormInputText(),
      'it'              => new sfWidgetFormInputText(),
      'et'              => new sfWidgetFormInputText(),
      'derrame'         => new sfWidgetFormInputText(),
      'calcif_valvular' => new sfWidgetFormInputText(),
      'hvi'             => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'id'              => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'trasplante_id'   => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'))),
      'fecha'           => new sfValidatorDate(),
      'fevi_normal'     => new sfValidatorInteger(array('required' => false)),
      'insuf_hipodiast' => new sfValidatorInteger(array('required' => false)),
      'iao'             => new sfValidatorInteger(array('required' => false)),
      'eao'             => new sfValidatorInteger(array('required' => false)),
      'im'              => new sfValidatorInteger(array('required' => false)),
      'em'              => new sfValidatorInteger(array('required' => false)),
      'ip'              => new sfValidatorInteger(array('required' => false)),
      'ep'              => new sfValidatorInteger(array('required' => false)),
      'it'              => new sfValidatorInteger(array('required' => false)),
      'et'              => new sfValidatorInteger(array('required' => false)),
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
