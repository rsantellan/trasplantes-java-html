<?php

/**
 * Nefropatia filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseNefropatiaFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'nefropatia' => new sfWidgetFormFilterInput(array('with_empty' => false)),
    ));

    $this->setValidators(array(
      'nefropatia' => new sfValidatorPass(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('nefropatia_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'Nefropatia';
  }

  public function getFields()
  {
    return array(
      'id'         => 'Number',
      'nefropatia' => 'Text',
    );
  }
}
