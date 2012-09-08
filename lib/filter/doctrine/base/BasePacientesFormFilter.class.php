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
      'the'              => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'ci'               => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'nombre'           => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'apellido'         => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'num_fnr'          => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'raza'             => new sfWidgetFormChoice(array('choices' => array('' => '', 'Blanca' => 'Blanca', 'Negra' => 'Negra', 'Asiática' => 'Asiática', 'Indio americana' => 'Indio americana'))),
      'sexo'             => new sfWidgetFormChoice(array('choices' => array('' => '', 'M' => 'M', 'F' => 'F'))),
      'fecha_nacimiento' => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate(), 'with_empty' => false)),
      'fecha_dialisis'   => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate())),
      'sin_dialisis'     => new sfWidgetFormChoice(array('choices' => array('' => '', 'NO' => 'NO', 'SI' => 'SI'))),
      'nefropatia_id'    => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Nefropatia'), 'add_empty' => true)),
      'grupo_sanguineo'  => new sfWidgetFormChoice(array('choices' => array('' => '', 'A' => 'A', 'B' => 'B', 'AB' => 'AB', 'O' => 'O'))),
    ));

    $this->setValidators(array(
      'the'              => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'ci'               => new sfValidatorPass(array('required' => false)),
      'nombre'           => new sfValidatorPass(array('required' => false)),
      'apellido'         => new sfValidatorPass(array('required' => false)),
      'num_fnr'          => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'raza'             => new sfValidatorChoice(array('required' => false, 'choices' => array('Blanca' => 'Blanca', 'Negra' => 'Negra', 'Asiática' => 'Asiática', 'Indio americana' => 'Indio americana'))),
      'sexo'             => new sfValidatorChoice(array('required' => false, 'choices' => array('M' => 'M', 'F' => 'F'))),
      'fecha_nacimiento' => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'fecha_dialisis'   => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'sin_dialisis'     => new sfValidatorChoice(array('required' => false, 'choices' => array('NO' => 'NO', 'SI' => 'SI'))),
      'nefropatia_id'    => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Nefropatia'), 'column' => 'id')),
      'grupo_sanguineo'  => new sfValidatorChoice(array('required' => false, 'choices' => array('A' => 'A', 'B' => 'B', 'AB' => 'AB', 'O' => 'O'))),
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
      'id'               => 'Number',
      'the'              => 'Number',
      'ci'               => 'Text',
      'nombre'           => 'Text',
      'apellido'         => 'Text',
      'num_fnr'          => 'Number',
      'raza'             => 'Enum',
      'sexo'             => 'Enum',
      'fecha_nacimiento' => 'Date',
      'fecha_dialisis'   => 'Date',
      'sin_dialisis'     => 'Enum',
      'nefropatia_id'    => 'ForeignKey',
      'grupo_sanguineo'  => 'Enum',
    );
  }
}
