<?php

/**
 * Consultas filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseConsultasFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'nombre'    => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'sentencia' => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'tipos'     => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'nombres'   => new sfWidgetFormFilterInput(array('with_empty' => false)),
    ));

    $this->setValidators(array(
      'nombre'    => new sfValidatorPass(array('required' => false)),
      'sentencia' => new sfValidatorPass(array('required' => false)),
      'tipos'     => new sfValidatorPass(array('required' => false)),
      'nombres'   => new sfValidatorPass(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('consultas_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'Consultas';
  }

  public function getFields()
  {
    return array(
      'id'        => 'Number',
      'nombre'    => 'Text',
      'sentencia' => 'Text',
      'tipos'     => 'Text',
      'nombres'   => 'Text',
    );
  }
}
