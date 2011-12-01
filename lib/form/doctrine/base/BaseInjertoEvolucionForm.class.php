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
      'id'                          => new sfWidgetFormInputHidden(),
      'trasplante_id'               => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => false)),
      'fecha'                       => new sfWidgetFormDate(),
      'tm'                          => new sfWidgetFormInputText(),
      'tm_cual'                     => new sfWidgetFormInputText(),
      'gp_de_novo'                  => new sfWidgetFormInputText(),
      'recidiva_gp_de_novo'         => new sfWidgetFormInputText(),
      'ra'                          => new sfWidgetFormInputText(),
      'rc'                          => new sfWidgetFormInputText(),
      'ra_tratamiento_id'           => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Ratratamiento'), 'add_empty' => false)),
      'en_trasplante'               => new sfWidgetFormInputText(),
      'injerto_evolucion_pbrs_list' => new sfWidgetFormDoctrineChoice(array('multiple' => true, 'model' => 'ResultadoPbr')),
    ));

    $this->setValidators(array(
      'id'                          => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'trasplante_id'               => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'))),
      'fecha'                       => new sfValidatorDate(),
      'tm'                          => new sfValidatorInteger(array('required' => false)),
      'tm_cual'                     => new sfValidatorString(array('max_length' => 255, 'required' => false)),
      'gp_de_novo'                  => new sfValidatorInteger(array('required' => false)),
      'recidiva_gp_de_novo'         => new sfValidatorInteger(array('required' => false)),
      'ra'                          => new sfValidatorInteger(array('required' => false)),
      'rc'                          => new sfValidatorInteger(array('required' => false)),
      'ra_tratamiento_id'           => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Ratratamiento'))),
      'en_trasplante'               => new sfValidatorInteger(array('required' => false)),
      'injerto_evolucion_pbrs_list' => new sfValidatorDoctrineChoice(array('multiple' => true, 'model' => 'ResultadoPbr', 'required' => false)),
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

  public function updateDefaultsFromObject()
  {
    parent::updateDefaultsFromObject();

    if (isset($this->widgetSchema['injerto_evolucion_pbrs_list']))
    {
      $this->setDefault('injerto_evolucion_pbrs_list', $this->object->InjertoEvolucionPbrs->getPrimaryKeys());
    }

  }

  protected function doSave($con = null)
  {
    $this->saveInjertoEvolucionPbrsList($con);

    parent::doSave($con);
  }

  public function saveInjertoEvolucionPbrsList($con = null)
  {
    if (!$this->isValid())
    {
      throw $this->getErrorSchema();
    }

    if (!isset($this->widgetSchema['injerto_evolucion_pbrs_list']))
    {
      // somebody has unset this widget
      return;
    }

    if (null === $con)
    {
      $con = $this->getConnection();
    }

    $existing = $this->object->InjertoEvolucionPbrs->getPrimaryKeys();
    $values = $this->getValue('injerto_evolucion_pbrs_list');
    if (!is_array($values))
    {
      $values = array();
    }

    $unlink = array_diff($existing, $values);
    if (count($unlink))
    {
      $this->object->unlink('InjertoEvolucionPbrs', array_values($unlink));
    }

    $link = array_diff($values, $existing);
    if (count($link))
    {
      $this->object->link('InjertoEvolucionPbrs', array_values($link));
    }
  }

}
