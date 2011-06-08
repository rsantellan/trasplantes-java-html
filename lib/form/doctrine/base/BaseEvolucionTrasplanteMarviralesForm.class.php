<?php

/**
 * EvolucionTrasplanteMarvirales form base class.
 *
 * @method EvolucionTrasplanteMarvirales getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseEvolucionTrasplanteMarviralesForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'            => new sfWidgetFormInputHidden(),
      'trasplante_id' => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => false)),
      'fecha'         => new sfWidgetFormDate(),
      'hsv'           => new sfWidgetFormInputText(),
      'aghbs'         => new sfWidgetFormChoice(array('choices' => array('Indeterminado' => 'Indeterminado', 'Negativo' => 'Negativo', 'Positivo' => 'Positivo', 'Sin datos' => 'Sin datos'))),
      'hbsac'         => new sfWidgetFormChoice(array('choices' => array('Indeterminado' => 'Indeterminado', 'Negativo' => 'Negativo', 'Positivo' => 'Positivo', 'Sin datos' => 'Sin datos'))),
      'hbcac'         => new sfWidgetFormChoice(array('choices' => array('Indeterminado' => 'Indeterminado', 'Negativo' => 'Negativo', 'Positivo' => 'Positivo', 'Sin datos' => 'Sin datos'))),
      'hvc'           => new sfWidgetFormChoice(array('choices' => array('Indeterminado' => 'Indeterminado', 'Negativo' => 'Negativo', 'Positivo' => 'Positivo', 'Sin datos' => 'Sin datos'))),
      'hiv'           => new sfWidgetFormChoice(array('choices' => array('Indeterminado' => 'Indeterminado', 'Negativo' => 'Negativo', 'Positivo' => 'Positivo', 'Sin datos' => 'Sin datos'))),
    ));

    $this->setValidators(array(
      'id'            => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'trasplante_id' => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'))),
      'fecha'         => new sfValidatorDate(),
      'hsv'           => new sfValidatorInteger(array('required' => false)),
      'aghbs'         => new sfValidatorChoice(array('choices' => array(0 => 'Indeterminado', 1 => 'Negativo', 2 => 'Positivo', 3 => 'Sin datos'))),
      'hbsac'         => new sfValidatorChoice(array('choices' => array(0 => 'Indeterminado', 1 => 'Negativo', 2 => 'Positivo', 3 => 'Sin datos'))),
      'hbcac'         => new sfValidatorChoice(array('choices' => array(0 => 'Indeterminado', 1 => 'Negativo', 2 => 'Positivo', 3 => 'Sin datos'))),
      'hvc'           => new sfValidatorChoice(array('choices' => array(0 => 'Indeterminado', 1 => 'Negativo', 2 => 'Positivo', 3 => 'Sin datos'))),
      'hiv'           => new sfValidatorChoice(array('choices' => array(0 => 'Indeterminado', 1 => 'Negativo', 2 => 'Positivo', 3 => 'Sin datos'))),
    ));

    $this->widgetSchema->setNameFormat('evolucion_trasplante_marvirales[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'EvolucionTrasplanteMarvirales';
  }

}
