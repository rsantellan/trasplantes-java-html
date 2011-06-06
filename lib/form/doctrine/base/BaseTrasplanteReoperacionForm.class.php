<?php

/**
 * TrasplanteReoperacion form base class.
 *
 * @method TrasplanteReoperacion getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseTrasplanteReoperacionForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'                         => new sfWidgetFormInputHidden(),
      'trasplante_id'              => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => false)),
      'fecha'                      => new sfWidgetFormDate(),
      'descripcion'                => new sfWidgetFormInputText(),
      'trasplante_complicacion_id' => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('TrasplanteComplicaciones'), 'add_empty' => false)),
    ));

    $this->setValidators(array(
      'id'                         => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'trasplante_id'              => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'))),
      'fecha'                      => new sfValidatorDate(),
      'descripcion'                => new sfValidatorString(array('max_length' => 64, 'required' => false)),
      'trasplante_complicacion_id' => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('TrasplanteComplicaciones'))),
    ));

    $this->widgetSchema->setNameFormat('trasplante_reoperacion[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'TrasplanteReoperacion';
  }

}
