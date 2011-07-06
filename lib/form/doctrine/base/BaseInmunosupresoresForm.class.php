<?php

/**
 * Inmunosupresores form base class.
 *
 * @method Inmunosupresores getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseInmunosupresoresForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'              => new sfWidgetFormInputHidden(),
      'nombre'          => new sfWidgetFormInputText(),
      'trasplante_list' => new sfWidgetFormDoctrineChoice(array('multiple' => true, 'model' => 'Trasplante')),
    ));

    $this->setValidators(array(
      'id'              => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'nombre'          => new sfValidatorString(array('max_length' => 50)),
      'trasplante_list' => new sfValidatorDoctrineChoice(array('multiple' => true, 'model' => 'Trasplante', 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('inmunosupresores[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'Inmunosupresores';
  }

  public function updateDefaultsFromObject()
  {
    parent::updateDefaultsFromObject();

    if (isset($this->widgetSchema['trasplante_list']))
    {
      $this->setDefault('trasplante_list', $this->object->Trasplante->getPrimaryKeys());
    }

  }

  protected function doSave($con = null)
  {
    $this->saveTrasplanteList($con);

    parent::doSave($con);
  }

  public function saveTrasplanteList($con = null)
  {
    if (!$this->isValid())
    {
      throw $this->getErrorSchema();
    }

    if (!isset($this->widgetSchema['trasplante_list']))
    {
      // somebody has unset this widget
      return;
    }

    if (null === $con)
    {
      $con = $this->getConnection();
    }

    $existing = $this->object->Trasplante->getPrimaryKeys();
    $values = $this->getValue('trasplante_list');
    if (!is_array($values))
    {
      $values = array();
    }

    $unlink = array_diff($existing, $values);
    if (count($unlink))
    {
      $this->object->unlink('Trasplante', array_values($unlink));
    }

    $link = array_diff($values, $existing);
    if (count($link))
    {
      $this->object->link('Trasplante', array_values($link));
    }
  }

}
