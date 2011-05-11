<?php

/**
 * Cmv filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseCmvFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'trasplante_id'         => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => true)),
      'fecha'                 => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate(), 'with_empty' => false)),
      'cmv_diagnostico_id'    => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'tipo'                  => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'cmv_droga_id'          => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'dias_tratamiento'      => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'efecto_secundario'     => new sfWidgetFormFilterInput(),
      'created_at'            => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate(), 'with_empty' => false)),
      'updated_at'            => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate(), 'with_empty' => false)),
      'cmv_emfermedades_list' => new sfWidgetFormDoctrineChoice(array('multiple' => true, 'model' => 'Cmvemfermedades')),
    ));

    $this->setValidators(array(
      'trasplante_id'         => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Trasplante'), 'column' => 'id')),
      'fecha'                 => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'cmv_diagnostico_id'    => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'tipo'                  => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'cmv_droga_id'          => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'dias_tratamiento'      => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'efecto_secundario'     => new sfValidatorPass(array('required' => false)),
      'created_at'            => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDateTime(array('required' => false, 'datetime_output' => 'Y-m-d 00:00:00')), 'to_date' => new sfValidatorDateTime(array('required' => false, 'datetime_output' => 'Y-m-d 23:59:59')))),
      'updated_at'            => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDateTime(array('required' => false, 'datetime_output' => 'Y-m-d 00:00:00')), 'to_date' => new sfValidatorDateTime(array('required' => false, 'datetime_output' => 'Y-m-d 23:59:59')))),
      'cmv_emfermedades_list' => new sfValidatorDoctrineChoice(array('multiple' => true, 'model' => 'Cmvemfermedades', 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('cmv_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function addCmvEmfermedadesListColumnQuery(Doctrine_Query $query, $field, $values)
  {
    if (!is_array($values))
    {
      $values = array($values);
    }

    if (!count($values))
    {
      return;
    }

    $query
      ->leftJoin($query->getRootAlias().'.CmvUsoEnfermedades CmvUsoEnfermedades')
      ->andWhereIn('CmvUsoEnfermedades.cmv_emfermedades_id', $values)
    ;
  }

  public function getModelName()
  {
    return 'Cmv';
  }

  public function getFields()
  {
    return array(
      'id'                    => 'Number',
      'trasplante_id'         => 'ForeignKey',
      'fecha'                 => 'Date',
      'cmv_diagnostico_id'    => 'Number',
      'tipo'                  => 'Number',
      'cmv_droga_id'          => 'Number',
      'dias_tratamiento'      => 'Number',
      'efecto_secundario'     => 'Text',
      'created_at'            => 'Date',
      'updated_at'            => 'Date',
      'cmv_emfermedades_list' => 'ManyKey',
    );
  }
}
