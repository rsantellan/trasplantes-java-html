<?php

/**
 * AntecedentesDeDonante form base class.
 *
 * @method AntecedentesDeDonante getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseAntecedentesDeDonanteForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'            => new sfWidgetFormInputHidden(),
      'nombre'        => new sfWidgetFormInputText(),
      'donantes_list' => new sfWidgetFormDoctrineChoice(array('multiple' => true, 'model' => 'Donante')),
    ));

    $this->setValidators(array(
      'id'            => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'nombre'        => new sfValidatorString(array('max_length' => 255)),
      'donantes_list' => new sfValidatorDoctrineChoice(array('multiple' => true, 'model' => 'Donante', 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('antecedentes_de_donante[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'AntecedentesDeDonante';
  }

  public function updateDefaultsFromObject()
  {
    parent::updateDefaultsFromObject();

    if (isset($this->widgetSchema['donantes_list']))
    {
      $this->setDefault('donantes_list', $this->object->Donantes->getPrimaryKeys());
    }

  }

  protected function doSave($con = null)
  {
    $this->saveDonantesList($con);

    parent::doSave($con);
  }

  public function saveDonantesList($con = null)
  {
    if (!$this->isValid())
    {
      throw $this->getErrorSchema();
    }

    if (!isset($this->widgetSchema['donantes_list']))
    {
      // somebody has unset this widget
      return;
    }

    if (null === $con)
    {
      $con = $this->getConnection();
    }

    $existing = $this->object->Donantes->getPrimaryKeys();
    $values = $this->getValue('donantes_list');
    if (!is_array($values))
    {
      $values = array();
    }

    $unlink = array_diff($existing, $values);
    if (count($unlink))
    {
      $this->object->unlink('Donantes', array_values($unlink));
    }

    $link = array_diff($values, $existing);
    if (count($link))
    {
      $this->object->link('Donantes', array_values($link));
    }
  }

}
