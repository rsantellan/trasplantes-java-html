<?php

/**
 * ComplicacionesInf filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseComplicacionesInfFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'infeccion'          => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'germen'             => new sfWidgetFormFilterInput(array('with_empty' => false)),
    ));

    $this->setValidators(array(
      'infeccion'          => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'germen'             => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
    ));

    $this->widgetSchema->setNameFormat('complicaciones_inf_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'ComplicacionesInf';
  }

  public function getFields()
  {
    return array(
      'id_tr_complicacion' => 'Number',
      'infeccion'          => 'Number',
      'germen'             => 'Number',
    );
  }
}
