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
      'the'                 => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'fecha_ingreso_lista' => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate())),
      'fecha_egreso'        => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate())),
      'modalidad_d'         => new sfWidgetFormFilterInput(),
      'pbr'                 => new sfWidgetFormFilterInput(),
      'diabetes'            => new sfWidgetFormFilterInput(),
      'hta'                 => new sfWidgetFormFilterInput(),
      'obesidad'            => new sfWidgetFormFilterInput(),
      'imc'                 => new sfWidgetFormFilterInput(),
      'dislipemia'          => new sfWidgetFormFilterInput(),
      'tabaquismo'          => new sfWidgetFormFilterInput(),
      'origen'              => new sfWidgetFormFilterInput(),
      'iam'                 => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'ave'                 => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'revasc_cardio'       => new sfWidgetFormFilterInput(array('with_empty' => false)),
    ));

    $this->setValidators(array(
      'the'                 => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'fecha_ingreso_lista' => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'fecha_egreso'        => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'modalidad_d'         => new sfValidatorPass(array('required' => false)),
      'pbr'                 => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'diabetes'            => new sfValidatorPass(array('required' => false)),
      'hta'                 => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'obesidad'            => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'imc'                 => new sfValidatorPass(array('required' => false)),
      'dislipemia'          => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'tabaquismo'          => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'origen'              => new sfValidatorPass(array('required' => false)),
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
      'the'                 => 'Number',
      'fecha_ingreso_lista' => 'Date',
      'fecha_egreso'        => 'Date',
      'modalidad_d'         => 'Text',
      'pbr'                 => 'Number',
      'diabetes'            => 'Text',
      'hta'                 => 'Number',
      'obesidad'            => 'Number',
      'imc'                 => 'Text',
      'dislipemia'          => 'Number',
      'tabaquismo'          => 'Number',
      'origen'              => 'Text',
      'iam'                 => 'Number',
      'ave'                 => 'Number',
      'revasc_cardio'       => 'Number',
    );
  }
}
