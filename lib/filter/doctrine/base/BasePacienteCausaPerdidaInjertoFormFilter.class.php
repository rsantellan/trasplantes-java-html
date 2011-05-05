<?php

/**
 * PacienteCausaPerdidaInjerto filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BasePacienteCausaPerdidaInjertoFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'detalles' => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'detalles' => new sfValidatorPass(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('paciente_causa_perdida_injerto_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'PacienteCausaPerdidaInjerto';
  }

  public function getFields()
  {
    return array(
      'id'       => 'Number',
      'detalles' => 'Text',
    );
  }
}
