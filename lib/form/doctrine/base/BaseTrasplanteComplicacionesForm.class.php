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
      'trasplante_id'       => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => false)),
      'fecha'               => new sfWidgetFormDate(),
      'medicacion_id'       => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Medicaciones'), 'add_empty' => false)),
      'internado'           => new sfWidgetFormInputText(),
      'dias_de_internacion' => new sfWidgetFormInputText(),
      'evolucion'           => new sfWidgetFormInputText(),
      'comentario'          => new sfWidgetFormTextarea(),
      'infecciosa'          => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'id'                  => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'trasplante_id'       => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'))),
      'fecha'               => new sfValidatorDate(),
      'medicacion_id'       => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Medicaciones'))),
      'internado'           => new sfValidatorInteger(),
      'dias_de_internacion' => new sfValidatorInteger(array('required' => false)),
      'evolucion'           => new sfValidatorInteger(),
      'comentario'          => new sfValidatorString(array('max_length' => 1000, 'required' => false)),
      'infecciosa'          => new sfValidatorInteger(array('required' => false)),
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
