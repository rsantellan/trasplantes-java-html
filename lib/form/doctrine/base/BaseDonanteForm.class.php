<?php

/**
 * Donante form base class.
 *
 * @method Donante getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseDonanteForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'                        => new sfWidgetFormInputHidden(),
      'identificador'             => new sfWidgetFormInputText(),
      'tipo_donante'              => new sfWidgetFormChoice(array('choices' => array('Cadavérico' => 'Cadavérico', 'Vivo' => 'Vivo'))),
      'sexo_donante'              => new sfWidgetFormChoice(array('choices' => array('M' => 'M', 'F' => 'F'))),
      'edad_donante'              => new sfWidgetFormInputText(),
      'enastab_hemod'             => new sfWidgetFormInputText(),
      'donante_causa_muerte_id'   => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('DonanteCausaMuerte'), 'add_empty' => false)),
      'cr_p'                      => new sfWidgetFormInputText(),
      'otros'                     => new sfWidgetFormInputText(),
      'grupo_sanguineo'           => new sfWidgetFormChoice(array('choices' => array('A' => 'A', 'B' => 'B', 'AB' => 'AB', 'O' => 'O'))),
      'relacion_filiar'           => new sfWidgetFormChoice(array('choices' => array('padre/madre' => 'padre/madre', 'hermano/a' => 'hermano/a', 'Hijo/a' => 'Hijo/a', 'esposo/a' => 'esposo/a', 'otro' => 'otro'))),
      'peso'                      => new sfWidgetFormInputText(),
      'altura'                    => new sfWidgetFormInputText(),
      'donante_organos_list'      => new sfWidgetFormDoctrineChoice(array('multiple' => true, 'model' => 'Organos')),
      'donante_antecedentes_list' => new sfWidgetFormDoctrineChoice(array('multiple' => true, 'model' => 'AntecedentesDeDonante')),
    ));

    $this->setValidators(array(
      'id'                        => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'identificador'             => new sfValidatorString(array('max_length' => 20, 'required' => false)),
      'tipo_donante'              => new sfValidatorChoice(array('choices' => array(0 => 'Cadavérico', 1 => 'Vivo'))),
      'sexo_donante'              => new sfValidatorChoice(array('choices' => array(0 => 'M', 1 => 'F'))),
      'edad_donante'              => new sfValidatorInteger(array('required' => false)),
      'enastab_hemod'             => new sfValidatorInteger(array('required' => false)),
      'donante_causa_muerte_id'   => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('DonanteCausaMuerte'))),
      'cr_p'                      => new sfValidatorNumber(array('required' => false)),
      'otros'                     => new sfValidatorString(array('max_length' => 255, 'required' => false)),
      'grupo_sanguineo'           => new sfValidatorChoice(array('choices' => array(0 => 'A', 1 => 'B', 2 => 'AB', 3 => 'O'))),
      'relacion_filiar'           => new sfValidatorChoice(array('choices' => array(0 => 'padre/madre', 1 => 'hermano/a', 2 => 'Hijo/a', 3 => 'esposo/a', 4 => 'otro'), 'required' => false)),
      'peso'                      => new sfValidatorInteger(array('required' => false)),
      'altura'                    => new sfValidatorNumber(array('required' => false)),
      'donante_organos_list'      => new sfValidatorDoctrineChoice(array('multiple' => true, 'model' => 'Organos', 'required' => false)),
      'donante_antecedentes_list' => new sfValidatorDoctrineChoice(array('multiple' => true, 'model' => 'AntecedentesDeDonante', 'required' => false)),
    ));

    $this->validatorSchema->setPostValidator(
      new sfValidatorDoctrineUnique(array('model' => 'Donante', 'column' => array('identificador')))
    );

    $this->widgetSchema->setNameFormat('donante[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'Donante';
  }

  public function updateDefaultsFromObject()
  {
    parent::updateDefaultsFromObject();

    if (isset($this->widgetSchema['donante_organos_list']))
    {
      $this->setDefault('donante_organos_list', $this->object->DonanteOrganos->getPrimaryKeys());
    }

    if (isset($this->widgetSchema['donante_antecedentes_list']))
    {
      $this->setDefault('donante_antecedentes_list', $this->object->DonanteAntecedentes->getPrimaryKeys());
    }

  }

  protected function doSave($con = null)
  {
    $this->saveDonanteOrganosList($con);
    $this->saveDonanteAntecedentesList($con);

    parent::doSave($con);
  }

  public function saveDonanteOrganosList($con = null)
  {
    if (!$this->isValid())
    {
      throw $this->getErrorSchema();
    }

    if (!isset($this->widgetSchema['donante_organos_list']))
    {
      // somebody has unset this widget
      return;
    }

    if (null === $con)
    {
      $con = $this->getConnection();
    }

    $existing = $this->object->DonanteOrganos->getPrimaryKeys();
    $values = $this->getValue('donante_organos_list');
    if (!is_array($values))
    {
      $values = array();
    }

    $unlink = array_diff($existing, $values);
    if (count($unlink))
    {
      $this->object->unlink('DonanteOrganos', array_values($unlink));
    }

    $link = array_diff($values, $existing);
    if (count($link))
    {
      $this->object->link('DonanteOrganos', array_values($link));
    }
  }

  public function saveDonanteAntecedentesList($con = null)
  {
    if (!$this->isValid())
    {
      throw $this->getErrorSchema();
    }

    if (!isset($this->widgetSchema['donante_antecedentes_list']))
    {
      // somebody has unset this widget
      return;
    }

    if (null === $con)
    {
      $con = $this->getConnection();
    }

    $existing = $this->object->DonanteAntecedentes->getPrimaryKeys();
    $values = $this->getValue('donante_antecedentes_list');
    if (!is_array($values))
    {
      $values = array();
    }

    $unlink = array_diff($existing, $values);
    if (count($unlink))
    {
      $this->object->unlink('DonanteAntecedentes', array_values($unlink));
    }

    $link = array_diff($values, $existing);
    if (count($link))
    {
      $this->object->link('DonanteAntecedentes', array_values($link));
    }
  }

}
