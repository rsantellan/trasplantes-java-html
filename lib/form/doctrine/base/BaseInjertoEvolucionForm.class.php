<?php

/**
 * InjertoEvolucion form base class.
 *
 * @method InjertoEvolucion getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseInjertoEvolucionForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'                  => new sfWidgetFormInputHidden(),
      'trasplante_id'       => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => false)),
      'fecha'               => new sfWidgetFormDate(),
      'tm'                  => new sfWidgetFormInputText(),
      'tm_cual'             => new sfWidgetFormInputText(),
      'gp_de_novo'          => new sfWidgetFormInputText(),
      'recidiva_gp_de_novo' => new sfWidgetFormInputText(),
      'ra'                  => new sfWidgetFormInputText(),
      'rc'                  => new sfWidgetFormInputText(),
      'ra_tratamiento_id'   => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Ratratamiento'), 'add_empty' => false)),
      'en_trasplante'       => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'id'                  => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'trasplante_id'       => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'))),
      'fecha'               => new sfValidatorDate(),
      'tm'                  => new sfValidatorInteger(array('required' => false)),
      'tm_cual'             => new sfValidatorString(array('max_length' => 255, 'required' => false)),
      'gp_de_novo'          => new sfValidatorInteger(array('required' => false)),
      'recidiva_gp_de_novo' => new sfValidatorInteger(array('required' => false)),
      'ra'                  => new sfValidatorInteger(array('required' => false)),
      'rc'                  => new sfValidatorInteger(array('required' => false)),
      'ra_tratamiento_id'   => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Ratratamiento'))),
      'en_trasplante'       => new sfValidatorInteger(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('injerto_evolucion[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'InjertoEvolucion';
  }

}
