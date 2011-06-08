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
      'trasplante_id' => new sfWidgetFormInputHidden(),
      'induccion_id'  => new sfWidgetFormInputHidden(),
    ));

    $this->setValidators(array(
      'trasplante_id' => new sfValidatorChoice(array('choices' => array($this->getObject()->get('trasplante_id')), 'empty_value' => $this->getObject()->get('trasplante_id'), 'required' => false)),
      'induccion_id'  => new sfValidatorChoice(array('choices' => array($this->getObject()->get('induccion_id')), 'empty_value' => $this->getObject()->get('induccion_id'), 'required' => false)),
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
