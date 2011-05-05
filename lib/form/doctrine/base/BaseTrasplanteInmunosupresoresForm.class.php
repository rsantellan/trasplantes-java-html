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
      'id_trasplante'       => new sfWidgetFormInputHidden(),
      'id_inmunosupresores' => new sfWidgetFormInputHidden(),
      'valor'               => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'id_trasplante'       => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id_trasplante')), 'empty_value' => $this->getObject()->get('id_trasplante'), 'required' => false)),
      'id_inmunosupresores' => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id_inmunosupresores')), 'empty_value' => $this->getObject()->get('id_inmunosupresores'), 'required' => false)),
      'valor'               => new sfValidatorInteger(array('required' => false)),
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
