<?php

/**
 * TrasplanteInmunosupresores form base class.
 *
 * @method TrasplanteInmunosupresores getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseTrasplanteInmunosupresoresForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'trasplante_id'       => new sfWidgetFormInputHidden(),
      'inmunosupresores_id' => new sfWidgetFormInputHidden(),
    ));

    $this->setValidators(array(
      'trasplante_id'       => new sfValidatorChoice(array('choices' => array($this->getObject()->get('trasplante_id')), 'empty_value' => $this->getObject()->get('trasplante_id'), 'required' => false)),
      'inmunosupresores_id' => new sfValidatorChoice(array('choices' => array($this->getObject()->get('inmunosupresores_id')), 'empty_value' => $this->getObject()->get('inmunosupresores_id'), 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('trasplante_inmunosupresores[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'TrasplanteInmunosupresores';
  }

}
