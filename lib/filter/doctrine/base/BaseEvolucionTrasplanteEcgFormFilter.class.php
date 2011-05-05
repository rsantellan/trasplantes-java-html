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
      'rs_ecg'       => new sfWidgetFormFilterInput(),
      'hvi_ecg'      => new sfWidgetFormFilterInput(),
      'onda_q_ecg'   => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'rs_ecg'       => new sfValidatorPass(array('required' => false)),
      'hvi_ecg'      => new sfValidatorPass(array('required' => false)),
      'onda_q_ecg'   => new sfValidatorPass(array('required' => false)),
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
      'idtrasplante' => 'Number',
      'fecha'        => 'Date',
      'rs_ecg'       => 'Text',
      'hvi_ecg'      => 'Text',
      'onda_q_ecg'   => 'Text',
    );
  }
}
