<?php

/**
 * TrasplanteComplicaciones form base class.
 *
 * @method TrasplanteComplicaciones getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseTrasplanteComplicacionesForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'                  => new sfWidgetFormInputHidden(),
      'idpretrasplante'     => new sfWidgetFormInputText(),
      'fecha'               => new sfWidgetFormDate(),
      'medicacion'          => new sfWidgetFormInputText(),
      'internado'           => new sfWidgetFormInputText(),
      'dias_de_internacion' => new sfWidgetFormInputText(),
      'evolucion'           => new sfWidgetFormInputText(),
      'comentario'          => new sfWidgetFormTextarea(),
    ));

    $this->setValidators(array(
      'id'                  => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'idpretrasplante'     => new sfValidatorInteger(array('required' => false)),
      'fecha'               => new sfValidatorDate(),
      'medicacion'          => new sfValidatorInteger(),
      'internado'           => new sfValidatorInteger(),
      'dias_de_internacion' => new sfValidatorInteger(array('required' => false)),
      'evolucion'           => new sfValidatorInteger(),
      'comentario'          => new sfValidatorString(array('max_length' => 1000, 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('trasplante_complicaciones[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'TrasplanteComplicaciones';
  }

}
