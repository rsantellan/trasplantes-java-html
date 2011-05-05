<?php

/**
 * DonanteOrganos form base class.
 *
 * @method DonanteOrganos getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseDonanteOrganosForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'         => new sfWidgetFormInputHidden(),
      'id_donante' => new sfWidgetFormInputText(),
      'organo'     => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'id'         => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'id_donante' => new sfValidatorString(array('max_length' => 20)),
      'organo'     => new sfValidatorString(array('max_length' => 10)),
    ));

    $this->widgetSchema->setNameFormat('donante_organos[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'DonanteOrganos';
  }

}
