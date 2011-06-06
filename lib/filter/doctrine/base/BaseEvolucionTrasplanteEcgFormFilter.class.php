<?php

/**
 * EvolucionTrasplanteEcg filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseEvolucionTrasplanteEcgFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'trasplante_id' => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => true)),
      'fecha'         => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate(), 'with_empty' => false)),
      'rs_ecg'        => new sfWidgetFormChoice(array('choices' => array('' => '', 'Ausente' => 'Ausente', 'Presente' => 'Presente', 'Falta' => 'Falta'))),
      'hvi_ecg'       => new sfWidgetFormChoice(array('choices' => array('' => '', 'Ausente' => 'Ausente', 'Presente' => 'Presente', 'Falta' => 'Falta'))),
      'onda_q_ecg'    => new sfWidgetFormChoice(array('choices' => array('' => '', 'Ausente' => 'Ausente', 'Presente' => 'Presente', 'Falta' => 'Falta'))),
    ));

    $this->setValidators(array(
      'trasplante_id' => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Trasplante'), 'column' => 'id')),
      'fecha'         => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'rs_ecg'        => new sfValidatorChoice(array('required' => false, 'choices' => array('Ausente' => 'Ausente', 'Presente' => 'Presente', 'Falta' => 'Falta'))),
      'hvi_ecg'       => new sfValidatorChoice(array('required' => false, 'choices' => array('Ausente' => 'Ausente', 'Presente' => 'Presente', 'Falta' => 'Falta'))),
      'onda_q_ecg'    => new sfValidatorChoice(array('required' => false, 'choices' => array('Ausente' => 'Ausente', 'Presente' => 'Presente', 'Falta' => 'Falta'))),
    ));

    $this->widgetSchema->setNameFormat('evolucion_trasplante_ecg_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'EvolucionTrasplanteEcg';
  }

  public function getFields()
  {
    return array(
      'id'            => 'Number',
      'trasplante_id' => 'ForeignKey',
      'fecha'         => 'Date',
      'rs_ecg'        => 'Enum',
      'hvi_ecg'       => 'Enum',
      'onda_q_ecg'    => 'Enum',
    );
  }
}
