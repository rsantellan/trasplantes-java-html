<?php

/**
 * EvolucionTrasplanteExamenes filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseEvolucionTrasplanteExamenesFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'trasplante_id'                         => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => true)),
      'fecha'                                 => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate(), 'with_empty' => false)),
      'evolucion_trasplante_examenes_tipo_id' => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('EvolucionTrasplanteExamenesTipo'), 'add_empty' => true)),
      'tipo'                                  => new sfWidgetFormChoice(array('choices' => array('' => '', 'Normal' => 'Normal', 'Patologico' => 'Patologico'))),
      'comentario'                            => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'trasplante_id'                         => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Trasplante'), 'column' => 'id')),
      'fecha'                                 => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'evolucion_trasplante_examenes_tipo_id' => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('EvolucionTrasplanteExamenesTipo'), 'column' => 'id')),
      'tipo'                                  => new sfValidatorChoice(array('required' => false, 'choices' => array('Normal' => 'Normal', 'Patologico' => 'Patologico'))),
      'comentario'                            => new sfValidatorPass(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('evolucion_trasplante_examenes_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'EvolucionTrasplanteExamenes';
  }

  public function getFields()
  {
    return array(
      'id'                                    => 'Number',
      'trasplante_id'                         => 'ForeignKey',
      'fecha'                                 => 'Date',
      'evolucion_trasplante_examenes_tipo_id' => 'ForeignKey',
      'tipo'                                  => 'Enum',
      'comentario'                            => 'Text',
    );
  }
}
