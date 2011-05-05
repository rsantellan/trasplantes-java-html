<?php

/**
 * EvolucionTrasplanteEcografia filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseEvolucionTrasplanteEcografiaFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'diametros'    => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'dilatacion'   => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'litiasin'     => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'vejiga'       => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'espesor'      => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'otros'        => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'diametros'    => new sfValidatorPass(array('required' => false)),
      'dilatacion'   => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'litiasin'     => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'vejiga'       => new sfValidatorPass(array('required' => false)),
      'espesor'      => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'otros'        => new sfValidatorPass(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('evolucion_trasplante_ecografia_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'EvolucionTrasplanteEcografia';
  }

  public function getFields()
  {
    return array(
      'idtrasplante' => 'Number',
      'fecha'        => 'Date',
      'diametros'    => 'Text',
      'dilatacion'   => 'Number',
      'litiasin'     => 'Number',
      'vejiga'       => 'Text',
      'espesor'      => 'Number',
      'otros'        => 'Text',
    );
  }
}
