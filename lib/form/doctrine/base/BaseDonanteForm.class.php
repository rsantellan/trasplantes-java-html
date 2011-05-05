<?php

/**
 * Donante form base class.
 *
 * @method Donante getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseDonanteForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'                   => new sfWidgetFormInputHidden(),
      'tipo_donante'         => new sfWidgetFormInputText(),
      'sexo_donante'         => new sfWidgetFormInputText(),
      'edad_donante'         => new sfWidgetFormInputText(),
      'enastab_hemod'        => new sfWidgetFormInputText(),
      'causa_muerte_donante' => new sfWidgetFormInputText(),
      'cr_p'                 => new sfWidgetFormInputText(),
      'otros'                => new sfWidgetFormInputText(),
      'grupo_sang'           => new sfWidgetFormInputText(),
      'relacion_filiar'      => new sfWidgetFormInputText(),
      'peso'                 => new sfWidgetFormInputText(),
      'altura'               => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'id'                   => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'tipo_donante'         => new sfValidatorString(array('max_length' => 10)),
      'sexo_donante'         => new sfValidatorString(array('max_length' => 1, 'required' => false)),
      'edad_donante'         => new sfValidatorInteger(array('required' => false)),
      'enastab_hemod'        => new sfValidatorInteger(array('required' => false)),
      'causa_muerte_donante' => new sfValidatorInteger(array('required' => false)),
      'cr_p'                 => new sfValidatorNumber(array('required' => false)),
      'otros'                => new sfValidatorString(array('max_length' => 255, 'required' => false)),
      'grupo_sang'           => new sfValidatorString(array('max_length' => 2, 'required' => false)),
      'relacion_filiar'      => new sfValidatorString(array('max_length' => 11, 'required' => false)),
      'peso'                 => new sfValidatorInteger(array('required' => false)),
      'altura'               => new sfValidatorInteger(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('donante[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'Donante';
  }

}
