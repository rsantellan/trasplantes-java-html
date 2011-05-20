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
      'trasplante_id' => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => true)),
      'fecha'         => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate(), 'with_empty' => false)),
      'diametros'     => new sfWidgetFormFilterInput(),
      'dilatacion'    => new sfWidgetFormFilterInput(),
      'litiasin'      => new sfWidgetFormFilterInput(),
      'vejiga'        => new sfWidgetFormFilterInput(),
      'espesor'       => new sfWidgetFormFilterInput(),
      'otros'         => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'trasplante_id' => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Trasplante'), 'column' => 'id')),
      'fecha'         => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'diametros'     => new sfValidatorPass(array('required' => false)),
      'dilatacion'    => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'litiasin'      => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'vejiga'        => new sfValidatorPass(array('required' => false)),
      'espesor'       => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'otros'         => new sfValidatorPass(array('required' => false)),
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
      'id'            => 'Number',
      'trasplante_id' => 'ForeignKey',
      'fecha'         => 'Date',
      'diametros'     => 'Text',
      'dilatacion'    => 'Number',
      'litiasin'      => 'Number',
      'vejiga'        => 'Text',
      'espesor'       => 'Number',
      'otros'         => 'Text',
    );
  }
}
