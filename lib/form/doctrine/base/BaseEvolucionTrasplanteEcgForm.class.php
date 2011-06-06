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
      'id'            => new sfWidgetFormInputHidden(),
      'trasplante_id' => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => false)),
      'fecha'         => new sfWidgetFormDate(),
      'rs_ecg'        => new sfWidgetFormChoice(array('choices' => array('Ausente' => 'Ausente', 'Presente' => 'Presente', 'Falta' => 'Falta'))),
      'hvi_ecg'       => new sfWidgetFormChoice(array('choices' => array('Ausente' => 'Ausente', 'Presente' => 'Presente', 'Falta' => 'Falta'))),
      'onda_q_ecg'    => new sfWidgetFormChoice(array('choices' => array('Ausente' => 'Ausente', 'Presente' => 'Presente', 'Falta' => 'Falta'))),
    ));

    $this->setValidators(array(
      'id'            => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'trasplante_id' => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'))),
      'fecha'         => new sfValidatorDate(),
      'rs_ecg'        => new sfValidatorChoice(array('choices' => array(0 => 'Ausente', 1 => 'Presente', 2 => 'Falta'))),
      'hvi_ecg'       => new sfValidatorChoice(array('choices' => array(0 => 'Ausente', 1 => 'Presente', 2 => 'Falta'))),
      'onda_q_ecg'    => new sfValidatorChoice(array('choices' => array(0 => 'Ausente', 1 => 'Presente', 2 => 'Falta'))),
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
