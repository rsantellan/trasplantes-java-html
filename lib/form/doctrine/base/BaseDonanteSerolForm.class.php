<?php

/**
 * DonanteSerol form base class.
 *
 * @method DonanteSerol getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseDonanteSerolForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id_donante' => new sfWidgetFormInputHidden(),
      'id_serol'   => new sfWidgetFormInputHidden(),
      'valor'      => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'id_donante' => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id_donante')), 'empty_value' => $this->getObject()->get('id_donante'), 'required' => false)),
      'id_serol'   => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id_serol')), 'empty_value' => $this->getObject()->get('id_serol'), 'required' => false)),
      'valor'      => new sfValidatorString(array('max_length' => 50)),
    ));

    $this->widgetSchema->setNameFormat('donante_serol[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'DonanteSerol';
  }

}
