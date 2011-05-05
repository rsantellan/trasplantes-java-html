<?php

/**
 * CmvUsoEnfermedades filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseCmvUsoEnfermedadesFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
    ));

    $this->setValidators(array(
    ));

    $this->widgetSchema->setNameFormat('cmv_uso_enfermedades_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'CmvUsoEnfermedades';
  }

  public function getFields()
  {
    return array(
      'trasplante'      => 'Number',
      'fecha'           => 'Date',
      'cmvenfermedades' => 'Number',
    );
  }
}
