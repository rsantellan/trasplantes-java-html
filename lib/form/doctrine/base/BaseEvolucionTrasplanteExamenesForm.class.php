<?php

/**
 * EvolucionTrasplanteExamenes form base class.
 *
 * @method EvolucionTrasplanteExamenes getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseEvolucionTrasplanteExamenesForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'                                    => new sfWidgetFormInputHidden(),
      'trasplante_id'                         => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => false)),
      'fecha'                                 => new sfWidgetFormDate(),
      'evolucion_trasplante_examenes_tipo_id' => new sfWidgetFormInputText(),
      'tipo'                                  => new sfWidgetFormChoice(array('choices' => array('Normal' => 'Normal', 'Patologico' => 'Patologico'))),
      'comentario'                            => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'id'                                    => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'trasplante_id'                         => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'))),
      'fecha'                                 => new sfValidatorDate(),
      'evolucion_trasplante_examenes_tipo_id' => new sfValidatorInteger(),
      'tipo'                                  => new sfValidatorChoice(array('choices' => array(0 => 'Normal', 1 => 'Patologico'))),
      'comentario'                            => new sfValidatorString(array('max_length' => 255, 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('evolucion_trasplante_examenes[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'EvolucionTrasplanteExamenes';
  }

}
