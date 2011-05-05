<?php

/**
 * EvolucionTrasplanteEcodopler form base class.
 *
 * @method EvolucionTrasplanteEcodopler getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseEvolucionTrasplanteEcodoplerForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'idtrasplante'  => new sfWidgetFormInputHidden(),
      'fecha'         => new sfWidgetFormInputHidden(),
      'estructura'    => new sfWidgetFormInputText(),
      'dilatacion'    => new sfWidgetFormInputText(),
      'colecciones'   => new sfWidgetFormInputText(),
      'eje_arterial'  => new sfWidgetFormInputText(),
      'eje_venoso'    => new sfWidgetFormInputText(),
      'arteria_renal' => new sfWidgetFormInputText(),
      'vena_renal'    => new sfWidgetFormInputText(),
      'anast_venosa'  => new sfWidgetFormInputText(),
      'anast_renosa'  => new sfWidgetFormInputText(),
      'indice'        => new sfWidgetFormInputText(),
      'otros'         => new sfWidgetFormTextarea(),
    ));

    $this->setValidators(array(
      'idtrasplante'  => new sfValidatorChoice(array('choices' => array($this->getObject()->get('idtrasplante')), 'empty_value' => $this->getObject()->get('idtrasplante'), 'required' => false)),
      'fecha'         => new sfValidatorChoice(array('choices' => array($this->getObject()->get('fecha')), 'empty_value' => $this->getObject()->get('fecha'), 'required' => false)),
      'estructura'    => new sfValidatorString(array('max_length' => 20, 'required' => false)),
      'dilatacion'    => new sfValidatorInteger(array('required' => false)),
      'colecciones'   => new sfValidatorInteger(array('required' => false)),
      'eje_arterial'  => new sfValidatorString(array('max_length' => 20, 'required' => false)),
      'eje_venoso'    => new sfValidatorString(array('max_length' => 20, 'required' => false)),
      'arteria_renal' => new sfValidatorString(array('max_length' => 20, 'required' => false)),
      'vena_renal'    => new sfValidatorString(array('max_length' => 20, 'required' => false)),
      'anast_venosa'  => new sfValidatorString(array('max_length' => 20, 'required' => false)),
      'anast_renosa'  => new sfValidatorString(array('max_length' => 20, 'required' => false)),
      'indice'        => new sfValidatorNumber(array('required' => false)),
      'otros'         => new sfValidatorString(array('max_length' => 1000, 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('evolucion_trasplante_ecodopler[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'EvolucionTrasplanteEcodopler';
  }

}
