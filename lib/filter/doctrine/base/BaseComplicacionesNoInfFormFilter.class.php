<?php

/**
 * ComplicacionesNoInf filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseComplicacionesNoInfFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id_complicacion'    => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'id_complicacion'    => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
    ));

    $this->widgetSchema->setNameFormat('complicaciones_no_inf_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'ComplicacionesNoInf';
  }

  public function getFields()
  {
    return array(
      'id_tr_complicacion' => 'Number',
      'id_complicacion'    => 'Number',
    );
  }
}
