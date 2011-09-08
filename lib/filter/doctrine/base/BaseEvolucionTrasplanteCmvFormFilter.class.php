<?php

/**
 * EvolucionTrasplanteCmv filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseEvolucionTrasplanteCmvFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'trasplante_id' => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => true)),
      'fecha'         => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate(), 'with_empty' => false)),
      'igg_cmv'       => new sfWidgetFormFilterInput(),
      'igm_cmv'       => new sfWidgetFormFilterInput(),
      'pcr_cmv'       => new sfWidgetFormFilterInput(),
      'ag_pp65'       => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'trasplante_id' => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Trasplante'), 'column' => 'id')),
      'fecha'         => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'igg_cmv'       => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'igm_cmv'       => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'pcr_cmv'       => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'ag_pp65'       => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
    ));

    $this->widgetSchema->setNameFormat('evolucion_trasplante_cmv_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'EvolucionTrasplanteCmv';
  }

  public function getFields()
  {
    return array(
      'id'            => 'Number',
      'trasplante_id' => 'ForeignKey',
      'fecha'         => 'Date',
      'igg_cmv'       => 'Number',
      'igm_cmv'       => 'Number',
      'pcr_cmv'       => 'Number',
      'ag_pp65'       => 'Number',
    );
  }
}
