<?php

/**
 * TrasplanteInduccion form base class.
 *
 * @method TrasplanteInduccion getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseTrasplanteInduccionForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id_trasplante' => new sfWidgetFormInputHidden(),
      'id_induccion'  => new sfWidgetFormInputHidden(),
      'valor'         => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'id_trasplante' => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id_trasplante')), 'empty_value' => $this->getObject()->get('id_trasplante'), 'required' => false)),
      'id_induccion'  => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id_induccion')), 'empty_value' => $this->getObject()->get('id_induccion'), 'required' => false)),
      'valor'         => new sfValidatorInteger(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('trasplante_induccion[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'TrasplanteInduccion';
  }

}
