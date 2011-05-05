<?php

/**
 * TrasplanteSerol form base class.
 *
 * @method TrasplanteSerol getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseTrasplanteSerolForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id_trasplante' => new sfWidgetFormInputHidden(),
      'id_serol'      => new sfWidgetFormInputHidden(),
      'valor'         => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'id_trasplante' => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id_trasplante')), 'empty_value' => $this->getObject()->get('id_trasplante'), 'required' => false)),
      'id_serol'      => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id_serol')), 'empty_value' => $this->getObject()->get('id_serol'), 'required' => false)),
      'valor'         => new sfValidatorString(array('max_length' => 50, 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('trasplante_serol[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'TrasplanteSerol';
  }

}
