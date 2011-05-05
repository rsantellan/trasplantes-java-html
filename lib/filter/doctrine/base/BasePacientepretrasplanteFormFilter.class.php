<?php

/**
 * Pacientepretrasplante filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BasePacientepretrasplanteFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'paciente_id'         => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Pacientes'), 'add_empty' => true)),
      'the'                 => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'fecha_ingreso_lista' => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate(), 'with_empty' => false)),
      'fecha_egreso'        => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate())),
      'modalidad_d'         => new sfWidgetFormChoice(array('choices' => array('' => '', 'HD' => 'HD', 'DPCA' => 'DPCA', 'HD+DPCA' => 'HD+DPCA', 'TR' => 'TR', 'HD+TR' => 'HD+TR', 'DPCA+TR' => 'DPCA+TR', 'HD+TR+DPCA' => 'HD+TR+DPCA', 'TM' => 'TM'))),
      'diabetes'            => new sfWidgetFormChoice(array('choices' => array('' => '', 'No' => 'No', 'Tipo I' => 'Tipo I', 'Tipo II' => 'Tipo II'))),
      'imc'                 => new sfWidgetFormChoice(array('choices' => array('' => '', '<20' => '<20', 'entre 20 y 25' => 'entre 20 y 25', '>25' => '>25'))),
      'origen'              => new sfWidgetFormChoice(array('choices' => array('' => '', 'MSP' => 'MSP', 'IAMC' => 'IAMC', 'Otra' => 'Otra'))),
      'pbr'                 => new sfWidgetFormFilterInput(),
      'hta'                 => new sfWidgetFormFilterInput(),
      'obesidad'            => new sfWidgetFormFilterInput(),
      'dislipemia'          => new sfWidgetFormFilterInput(),
      'tabaquismo'          => new sfWidgetFormFilterInput(),
      'iam'                 => new sfWidgetFormFilterInput(),
      'ave'                 => new sfWidgetFormFilterInput(),
      'revasc_cardio'       => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'paciente_id'         => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Pacientes'), 'column' => 'id')),
      'the'                 => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'fecha_ingreso_lista' => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'fecha_egreso'        => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'modalidad_d'         => new sfValidatorChoice(array('required' => false, 'choices' => array('HD' => 'HD', 'DPCA' => 'DPCA', 'HD+DPCA' => 'HD+DPCA', 'TR' => 'TR', 'HD+TR' => 'HD+TR', 'DPCA+TR' => 'DPCA+TR', 'HD+TR+DPCA' => 'HD+TR+DPCA', 'TM' => 'TM'))),
      'diabetes'            => new sfValidatorChoice(array('required' => false, 'choices' => array('No' => 'No', 'Tipo I' => 'Tipo I', 'Tipo II' => 'Tipo II'))),
      'imc'                 => new sfValidatorChoice(array('required' => false, 'choices' => array('<20' => '<20', 'entre 20 y 25' => 'entre 20 y 25', '>25' => '>25'))),
      'origen'              => new sfValidatorChoice(array('required' => false, 'choices' => array('MSP' => 'MSP', 'IAMC' => 'IAMC', 'Otra' => 'Otra'))),
      'pbr'                 => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'hta'                 => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'obesidad'            => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'dislipemia'          => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'tabaquismo'          => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'iam'                 => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'ave'                 => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'revasc_cardio'       => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
    ));

    $this->widgetSchema->setNameFormat('pacientepretrasplante_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'Pacientepretrasplante';
  }

  public function getFields()
  {
    return array(
      'id'                  => 'Number',
      'paciente_id'         => 'ForeignKey',
      'the'                 => 'Number',
      'fecha_ingreso_lista' => 'Date',
      'fecha_egreso'        => 'Date',
      'modalidad_d'         => 'Enum',
      'diabetes'            => 'Enum',
      'imc'                 => 'Enum',
      'origen'              => 'Enum',
      'pbr'                 => 'Number',
      'hta'                 => 'Number',
      'obesidad'            => 'Number',
      'dislipemia'          => 'Number',
      'tabaquismo'          => 'Number',
      'iam'                 => 'Number',
      'ave'                 => 'Number',
      'revasc_cardio'       => 'Number',
    );
  }
}
