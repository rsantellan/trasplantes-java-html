<?php

/**
 * ConsultaCampo form base class.
 *
 * @method ConsultaCampo getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseConsultaCampoForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'          => new sfWidgetFormInputHidden(),
      'nombre'      => new sfWidgetFormInputText(),
      'consulta_id' => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Consulta'), 'add_empty' => false)),
    ));

    $this->setValidators(array(
      'id'          => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'nombre'      => new sfValidatorString(array('max_length' => 45)),
      'consulta_id' => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Consulta'))),
    ));

    $this->widgetSchema->setNameFormat('consulta_campo[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'ConsultaCampo';
  }

}
