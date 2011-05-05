<?php

/**
 * TrasplanteReoperacion form base class.
 *
 * @method TrasplanteReoperacion getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseTrasplanteReoperacionForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id_trasplante' => new sfWidgetFormInputHidden(),
      'fecha'         => new sfWidgetFormInputHidden(),
      'descripcion'   => new sfWidgetFormInputText(),
      'complicacion'  => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'id_trasplante' => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id_trasplante')), 'empty_value' => $this->getObject()->get('id_trasplante'), 'required' => false)),
      'fecha'         => new sfValidatorChoice(array('choices' => array($this->getObject()->get('fecha')), 'empty_value' => $this->getObject()->get('fecha'), 'required' => false)),
      'descripcion'   => new sfValidatorString(array('max_length' => 50, 'required' => false)),
      'complicacion'  => new sfValidatorInteger(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('trasplante_reoperacion[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'TrasplanteReoperacion';
  }

}
