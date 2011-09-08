<?php

/**
 * Tratamiento filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseTratamientoFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'paciente_id'   => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Pacientes'), 'add_empty' => true)),
      'medicacion_id' => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Medicaciones'), 'add_empty' => true)),
      'dosis'         => new sfWidgetFormFilterInput(),
      'fecha_inicio'  => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate(), 'with_empty' => false)),
      'fecha_fin'     => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate())),
    ));

    $this->setValidators(array(
      'paciente_id'   => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Pacientes'), 'column' => 'id')),
      'medicacion_id' => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Medicaciones'), 'column' => 'id')),
      'dosis'         => new sfValidatorPass(array('required' => false)),
      'fecha_inicio'  => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'fecha_fin'     => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
    ));

    $this->widgetSchema->setNameFormat('tratamiento_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'Tratamiento';
  }

  public function getFields()
  {
    return array(
      'id'            => 'Number',
      'paciente_id'   => 'ForeignKey',
      'medicacion_id' => 'ForeignKey',
      'dosis'         => 'Text',
      'fecha_inicio'  => 'Date',
      'fecha_fin'     => 'Date',
    );
  }
}
