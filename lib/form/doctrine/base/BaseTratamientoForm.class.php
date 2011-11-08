<?php

/**
 * Tratamiento form base class.
 *
 * @method Tratamiento getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseTratamientoForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'            => new sfWidgetFormInputHidden(),
      'paciente_id'   => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Pacientes'), 'add_empty' => false)),
      'medicacion_id' => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Medicaciones'), 'add_empty' => true)),
      'dosis'         => new sfWidgetFormInputText(),
      'fecha_inicio'  => new sfWidgetFormDate(),
      'fecha_fin'     => new sfWidgetFormDate(),
    ));

    $this->setValidators(array(
      'id'            => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'paciente_id'   => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Pacientes'))),
      'medicacion_id' => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Medicaciones'), 'required' => false)),
      'dosis'         => new sfValidatorString(array('max_length' => 50, 'required' => false)),
      'fecha_inicio'  => new sfValidatorDate(),
      'fecha_fin'     => new sfValidatorDate(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('tratamiento[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'Tratamiento';
  }

}
