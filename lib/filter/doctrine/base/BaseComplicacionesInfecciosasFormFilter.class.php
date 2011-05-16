<?php

/**
 * ComplicacionesInfecciosas filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseComplicacionesInfecciosasFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'infeccion_id'       => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Infeccion'), 'add_empty' => true)),
      'germen_id'          => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Germenes'), 'add_empty' => true)),
    ));

    $this->setValidators(array(
      'infeccion_id'       => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Infeccion'), 'column' => 'id')),
      'germen_id'          => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Germenes'), 'column' => 'id')),
    ));

    $this->widgetSchema->setNameFormat('complicaciones_infecciosas_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'ComplicacionesInfecciosas';
  }

  public function getFields()
  {
    return array(
      'tr_complicacion_id' => 'Number',
      'infeccion_id'       => 'ForeignKey',
      'germen_id'          => 'ForeignKey',
    );
  }
}
