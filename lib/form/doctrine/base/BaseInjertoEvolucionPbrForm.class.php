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
      'injerto_evolucion_id' => new sfWidgetFormInputHidden(),
      'resultado_pbr_id'     => new sfWidgetFormInputHidden(),
    ));

    $this->setValidators(array(
      'injerto_evolucion_id' => new sfValidatorChoice(array('choices' => array($this->getObject()->get('injerto_evolucion_id')), 'empty_value' => $this->getObject()->get('injerto_evolucion_id'), 'required' => false)),
      'resultado_pbr_id'     => new sfValidatorChoice(array('choices' => array($this->getObject()->get('resultado_pbr_id')), 'empty_value' => $this->getObject()->get('resultado_pbr_id'), 'required' => false)),
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
