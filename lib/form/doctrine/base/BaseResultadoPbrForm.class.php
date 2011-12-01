<?php

/**
 * ResultadoPbr form base class.
 *
 * @method ResultadoPbr getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseResultadoPbrForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'                       => new sfWidgetFormInputHidden(),
      'grado'                    => new sfWidgetFormInputText(),
      'criterio'                 => new sfWidgetFormInputText(),
      'injerto_evoluciones_list' => new sfWidgetFormDoctrineChoice(array('multiple' => true, 'model' => 'InjertoEvolucion')),
    ));

    $this->setValidators(array(
      'id'                       => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'grado'                    => new sfValidatorString(array('max_length' => 50)),
      'criterio'                 => new sfValidatorString(array('max_length' => 50, 'required' => false)),
      'injerto_evoluciones_list' => new sfValidatorDoctrineChoice(array('multiple' => true, 'model' => 'InjertoEvolucion', 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('resultado_pbr[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'ResultadoPbr';
  }

  public function updateDefaultsFromObject()
  {
    parent::updateDefaultsFromObject();

    if (isset($this->widgetSchema['injerto_evoluciones_list']))
    {
      $this->setDefault('injerto_evoluciones_list', $this->object->InjertoEvoluciones->getPrimaryKeys());
    }

  }

  protected function doSave($con = null)
  {
    $this->saveInjertoEvolucionesList($con);

    parent::doSave($con);
  }

  public function saveInjertoEvolucionesList($con = null)
  {
    if (!$this->isValid())
    {
      throw $this->getErrorSchema();
    }

    if (!isset($this->widgetSchema['injerto_evoluciones_list']))
    {
      // somebody has unset this widget
      return;
    }

    if (null === $con)
    {
      $con = $this->getConnection();
    }

    $existing = $this->object->InjertoEvoluciones->getPrimaryKeys();
    $values = $this->getValue('injerto_evoluciones_list');
    if (!is_array($values))
    {
      $values = array();
    }

    $unlink = array_diff($existing, $values);
    if (count($unlink))
    {
      $this->object->unlink('InjertoEvoluciones', array_values($unlink));
    }

    $link = array_diff($values, $existing);
    if (count($link))
    {
      $this->object->link('InjertoEvoluciones', array_values($link));
    }
  }

}
