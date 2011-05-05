<?php

/**
 * InjertoEvolucion form base class.
 *
 * @method InjertoEvolucion getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseInjertoEvolucionForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'pretrasplante'       => new sfWidgetFormInputHidden(),
      'fecha'               => new sfWidgetFormInputHidden(),
      'tm'                  => new sfWidgetFormInputText(),
      'tm_cual'             => new sfWidgetFormInputText(),
      'gp_de_novo'          => new sfWidgetFormInputText(),
      'recidiva_gp_de_novo' => new sfWidgetFormInputText(),
      'ra'                  => new sfWidgetFormInputText(),
      'rc'                  => new sfWidgetFormInputText(),
      'tratamiento'         => new sfWidgetFormInputText(),
      'trasplante'          => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'pretrasplante'       => new sfValidatorChoice(array('choices' => array($this->getObject()->get('pretrasplante')), 'empty_value' => $this->getObject()->get('pretrasplante'), 'required' => false)),
      'fecha'               => new sfValidatorChoice(array('choices' => array($this->getObject()->get('fecha')), 'empty_value' => $this->getObject()->get('fecha'), 'required' => false)),
      'tm'                  => new sfValidatorInteger(array('required' => false)),
      'tm_cual'             => new sfValidatorString(array('max_length' => 255, 'required' => false)),
      'gp_de_novo'          => new sfValidatorInteger(array('required' => false)),
      'recidiva_gp_de_novo' => new sfValidatorInteger(array('required' => false)),
      'ra'                  => new sfValidatorInteger(array('required' => false)),
      'rc'                  => new sfValidatorInteger(array('required' => false)),
      'tratamiento'         => new sfValidatorInteger(array('required' => false)),
      'trasplante'          => new sfValidatorInteger(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('injerto_evolucion[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'InjertoEvolucion';
  }

}
