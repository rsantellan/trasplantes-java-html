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
      'id'            => new sfWidgetFormInputHidden(),
      'trasplante_id' => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => false)),
      'fecha'         => new sfWidgetFormDate(),
      'estructura'    => new sfWidgetFormChoice(array('choices' => array('Bien' => 'Bien', 'Mal' => 'Mal'))),
      'dilatacion'    => new sfWidgetFormInputText(),
      'colecciones'   => new sfWidgetFormInputText(),
      'eje_arterial'  => new sfWidgetFormChoice(array('choices' => array('Bien' => 'Bien', 'Mal' => 'Mal'))),
      'eje_venoso'    => new sfWidgetFormChoice(array('choices' => array('Bien' => 'Bien', 'Mal' => 'Mal'))),
      'arteria_renal' => new sfWidgetFormChoice(array('choices' => array('Bien' => 'Bien', 'Mal' => 'Mal'))),
      'vena_renal'    => new sfWidgetFormChoice(array('choices' => array('Bien' => 'Bien', 'Mal' => 'Mal'))),
      'anast_venosa'  => new sfWidgetFormChoice(array('choices' => array('Bien' => 'Bien', 'Mal' => 'Mal'))),
      'anast_renosa'  => new sfWidgetFormChoice(array('choices' => array('Bien' => 'Bien', 'Mal' => 'Mal'))),
      'indice'        => new sfWidgetFormInputText(),
      'otros'         => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'id'            => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'trasplante_id' => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'))),
      'fecha'         => new sfValidatorDate(),
      'estructura'    => new sfValidatorChoice(array('choices' => array(0 => 'Bien', 1 => 'Mal'))),
      'dilatacion'    => new sfValidatorInteger(array('required' => false)),
      'colecciones'   => new sfValidatorInteger(array('required' => false)),
      'eje_arterial'  => new sfValidatorChoice(array('choices' => array(0 => 'Bien', 1 => 'Mal'))),
      'eje_venoso'    => new sfValidatorChoice(array('choices' => array(0 => 'Bien', 1 => 'Mal'))),
      'arteria_renal' => new sfValidatorChoice(array('choices' => array(0 => 'Bien', 1 => 'Mal'))),
      'vena_renal'    => new sfValidatorChoice(array('choices' => array(0 => 'Bien', 1 => 'Mal'))),
      'anast_venosa'  => new sfValidatorChoice(array('choices' => array(0 => 'Bien', 1 => 'Mal'))),
      'anast_renosa'  => new sfValidatorChoice(array('choices' => array(0 => 'Bien', 1 => 'Mal'))),
      'indice'        => new sfValidatorNumber(array('required' => false)),
      'otros'         => new sfValidatorString(array('max_length' => 255, 'required' => false)),
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
