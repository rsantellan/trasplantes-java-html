<?php

/**
 * ComplicacionesNoInfecciosas filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseComplicacionesNoInfecciosasFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'complicacion_valor_id' => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('ComplicacionesTiposValores'), 'add_empty' => true)),
    ));

    $this->setValidators(array(
      'complicacion_valor_id' => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('ComplicacionesTiposValores'), 'column' => 'id')),
    ));

    $this->widgetSchema->setNameFormat('complicaciones_no_infecciosas_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'ComplicacionesNoInfecciosas';
  }

  public function getFields()
  {
    return array(
      'tr_complicacion_id'    => 'Number',
      'complicacion_valor_id' => 'ForeignKey',
    );
  }
}
