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
      'trasplante_id'   => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => true)),
      'fecha'           => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate(), 'with_empty' => false)),
      'rct'             => new sfWidgetFormFilterInput(),
      'foco'            => new sfWidgetFormFilterInput(),
      'lateralizado'    => new sfWidgetFormChoice(array('choices' => array('' => '', 'Izquierda' => 'Izquierda', 'Derecha' => 'Derecha', 'Bilateral' => 'Bilateral'))),
      'derrame_pleural' => new sfWidgetFormFilterInput(),
      'lateral_derrame' => new sfWidgetFormChoice(array('choices' => array('' => '', 'Izquierda' => 'Izquierda', 'Derecha' => 'Derecha', 'Bilateral' => 'Bilateral'))),
      'secuelas'        => new sfWidgetFormFilterInput(),
      'otros'           => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'trasplante_id'   => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Trasplante'), 'column' => 'id')),
      'fecha'           => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'rct'             => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'foco'            => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'lateralizado'    => new sfValidatorChoice(array('required' => false, 'choices' => array('Izquierda' => 'Izquierda', 'Derecha' => 'Derecha', 'Bilateral' => 'Bilateral'))),
      'derrame_pleural' => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'lateral_derrame' => new sfValidatorChoice(array('required' => false, 'choices' => array('Izquierda' => 'Izquierda', 'Derecha' => 'Derecha', 'Bilateral' => 'Bilateral'))),
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
      'id'              => 'Number',
      'trasplante_id'   => 'ForeignKey',
      'fecha'           => 'Date',
      'rct'             => 'Number',
      'foco'            => 'Number',
      'lateralizado'    => 'Enum',
      'derrame_pleural' => 'Number',
      'lateral_derrame' => 'Enum',
      'secuelas'        => 'Number',
      'otros'           => 'Text',
    );
  }
}
