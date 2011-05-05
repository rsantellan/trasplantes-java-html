<?php

/**
 * InjertoEvolucionPbr form base class.
 *
 * @method InjertoEvolucionPbr getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseInjertoEvolucionPbrForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'pretrasplante' => new sfWidgetFormInputHidden(),
      'fecha'         => new sfWidgetFormInputHidden(),
      'resultado_pbr' => new sfWidgetFormInputHidden(),
    ));

    $this->setValidators(array(
      'pretrasplante' => new sfValidatorChoice(array('choices' => array($this->getObject()->get('pretrasplante')), 'empty_value' => $this->getObject()->get('pretrasplante'), 'required' => false)),
      'fecha'         => new sfValidatorChoice(array('choices' => array($this->getObject()->get('fecha')), 'empty_value' => $this->getObject()->get('fecha'), 'required' => false)),
      'resultado_pbr' => new sfValidatorChoice(array('choices' => array($this->getObject()->get('resultado_pbr')), 'empty_value' => $this->getObject()->get('resultado_pbr'), 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('injerto_evolucion_pbr[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'InjertoEvolucionPbr';
  }

}
