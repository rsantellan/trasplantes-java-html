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
      'the'          => new sfWidgetFormInputHidden(),
      'medicacion'   => new sfWidgetFormInputHidden(),
      'dosis'        => new sfWidgetFormInputText(),
      'fecha_inicio' => new sfWidgetFormInputHidden(),
      'fecha_fin'    => new sfWidgetFormDate(),
    ));

    $this->setValidators(array(
      'the'          => new sfValidatorChoice(array('choices' => array($this->getObject()->get('the')), 'empty_value' => $this->getObject()->get('the'), 'required' => false)),
      'medicacion'   => new sfValidatorChoice(array('choices' => array($this->getObject()->get('medicacion')), 'empty_value' => $this->getObject()->get('medicacion'), 'required' => false)),
      'dosis'        => new sfValidatorString(array('max_length' => 50, 'required' => false)),
      'fecha_inicio' => new sfValidatorChoice(array('choices' => array($this->getObject()->get('fecha_inicio')), 'empty_value' => $this->getObject()->get('fecha_inicio'), 'required' => false)),
      'fecha_fin'    => new sfValidatorDate(array('required' => false)),
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
