<?php

/**
 * Pacientes filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BasePacientesFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'ci'               => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'nombre'           => new sfWidgetFormFilterInput(),
      'apellido'         => new sfWidgetFormFilterInput(),
      'num_fnr'          => new sfWidgetFormFilterInput(),
      'raza'             => new sfWidgetFormFilterInput(),
      'sexo'             => new sfWidgetFormFilterInput(),
      'fecha_nacimiento' => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate())),
      'fecha_dialisis'   => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate())),
      'nefropatia'       => new sfWidgetFormFilterInput(),
      'grupo_sang'       => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'ci'               => new sfValidatorPass(array('required' => false)),
      'nombre'           => new sfValidatorPass(array('required' => false)),
      'apellido'         => new sfValidatorPass(array('required' => false)),
      'num_fnr'          => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'raza'             => new sfValidatorPass(array('required' => false)),
      'sexo'             => new sfValidatorPass(array('required' => false)),
      'fecha_nacimiento' => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'fecha_dialisis'   => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'nefropatia'       => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'grupo_sang'       => new sfValidatorPass(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('pacientes_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'Pacientes';
  }

  public function getFields()
  {
    return array(
      'the'              => 'Number',
      'ci'               => 'Text',
      'nombre'           => 'Text',
      'apellido'         => 'Text',
      'num_fnr'          => 'Number',
      'raza'             => 'Text',
      'sexo'             => 'Text',
      'fecha_nacimiento' => 'Date',
      'fecha_dialisis'   => 'Date',
      'nefropatia'       => 'Number',
      'grupo_sang'       => 'Text',
    );
  }
}
