<?php

/**
 * Donanterefantecedentes form base class.
 *
 * @method Donanterefantecedentes getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseDonanterefantecedentesForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id_donante'     => new sfWidgetFormInputHidden(),
      'id_antecedente' => new sfWidgetFormInputHidden(),
    ));

    $this->setValidators(array(
      'id_donante'     => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id_donante')), 'empty_value' => $this->getObject()->get('id_donante'), 'required' => false)),
      'id_antecedente' => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id_antecedente')), 'empty_value' => $this->getObject()->get('id_antecedente'), 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('donanterefantecedentes[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'Donanterefantecedentes';
  }

}
