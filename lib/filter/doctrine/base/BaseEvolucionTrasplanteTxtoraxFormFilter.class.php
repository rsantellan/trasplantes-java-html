<?php

/**
 * EvolucionTrasplanteTxtorax filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseEvolucionTrasplanteTxtoraxFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'rct'             => new sfWidgetFormFilterInput(),
      'foco'            => new sfWidgetFormFilterInput(),
      'lateralizado'    => new sfWidgetFormFilterInput(),
      'derrame_pleural' => new sfWidgetFormFilterInput(),
      'lateral_derrame' => new sfWidgetFormFilterInput(),
      'secuelas'        => new sfWidgetFormFilterInput(),
      'otros'           => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'rct'             => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'foco'            => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'lateralizado'    => new sfValidatorPass(array('required' => false)),
      'derrame_pleural' => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'lateral_derrame' => new sfValidatorPass(array('required' => false)),
      'secuelas'        => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'otros'           => new sfValidatorPass(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('evolucion_trasplante_txtorax_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'EvolucionTrasplanteTxtorax';
  }

  public function getFields()
  {
    return array(
      'idtrasplante'    => 'Number',
      'fecha'           => 'Date',
      'rct'             => 'Number',
      'foco'            => 'Number',
      'lateralizado'    => 'Text',
      'derrame_pleural' => 'Number',
      'lateral_derrame' => 'Text',
      'secuelas'        => 'Number',
      'otros'           => 'Text',
    );
  }
}
