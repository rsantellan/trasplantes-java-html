<?php

/**
 * PacientePerdidaInjerto form base class.
 *
 * @method PacientePerdidaInjerto getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BasePacientePerdidaInjertoForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'the'              => new sfWidgetFormInputHidden(),
      'causa'            => new sfWidgetFormInputText(),
      'fecha_perdida'    => new sfWidgetFormInputHidden(),
      'id_pretrasplante' => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'the'              => new sfValidatorChoice(array('choices' => array($this->getObject()->get('the')), 'empty_value' => $this->getObject()->get('the'), 'required' => false)),
      'causa'            => new sfValidatorInteger(array('required' => false)),
      'fecha_perdida'    => new sfValidatorChoice(array('choices' => array($this->getObject()->get('fecha_perdida')), 'empty_value' => $this->getObject()->get('fecha_perdida'), 'required' => false)),
      'id_pretrasplante' => new sfValidatorInteger(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('paciente_perdida_injerto[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'PacientePerdidaInjerto';
  }

}
