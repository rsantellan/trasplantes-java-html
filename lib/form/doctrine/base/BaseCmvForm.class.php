<?php

/**
 * Cmv form base class.
 *
 * @method Cmv getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseCmvForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'                    => new sfWidgetFormInputHidden(),
      'trasplante_id'         => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => false)),
      'fecha'                 => new sfWidgetFormDate(),
      'cmv_diagnostico_id'    => new sfWidgetFormInputText(),
      'tipo'                  => new sfWidgetFormInputText(),
      'cmv_droga_id'          => new sfWidgetFormInputText(),
      'dias_tratamiento'      => new sfWidgetFormInputText(),
      'efecto_secundario'     => new sfWidgetFormInputText(),
      'cmv_emfermedades_list' => new sfWidgetFormDoctrineChoice(array('multiple' => true, 'model' => 'Cmvemfermedades')),
    ));

    $this->setValidators(array(
      'id'                    => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'trasplante_id'         => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'))),
      'fecha'                 => new sfValidatorDate(),
      'cmv_diagnostico_id'    => new sfValidatorInteger(),
      'tipo'                  => new sfValidatorInteger(),
      'cmv_droga_id'          => new sfValidatorInteger(),
      'dias_tratamiento'      => new sfValidatorInteger(array('required' => false)),
      'efecto_secundario'     => new sfValidatorString(array('max_length' => 255, 'required' => false)),
      'cmv_emfermedades_list' => new sfValidatorDoctrineChoice(array('multiple' => true, 'model' => 'Cmvemfermedades', 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('cmv[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'Cmv';
  }

  public function updateDefaultsFromObject()
  {
    parent::updateDefaultsFromObject();

    if (isset($this->widgetSchema['cmv_emfermedades_list']))
    {
      $this->setDefault('cmv_emfermedades_list', $this->object->CmvEmfermedades->getPrimaryKeys());
    }

  }

  protected function doSave($con = null)
  {
    $this->saveCmvEmfermedadesList($con);

    parent::doSave($con);
  }

  public function saveCmvEmfermedadesList($con = null)
  {
    if (!$this->isValid())
    {
      throw $this->getErrorSchema();
    }

    if (!isset($this->widgetSchema['cmv_emfermedades_list']))
    {
      // somebody has unset this widget
      return;
    }

    if (null === $con)
    {
      $con = $this->getConnection();
    }

    $existing = $this->object->CmvEmfermedades->getPrimaryKeys();
    $values = $this->getValue('cmv_emfermedades_list');
    if (!is_array($values))
    {
      $values = array();
    }

    $unlink = array_diff($existing, $values);
    if (count($unlink))
    {
      $this->object->unlink('CmvEmfermedades', array_values($unlink));
    }

    $link = array_diff($values, $existing);
    if (count($link))
    {
      $this->object->link('CmvEmfermedades', array_values($link));
    }
  }

}
