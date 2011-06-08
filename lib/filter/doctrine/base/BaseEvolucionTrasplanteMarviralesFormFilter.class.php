<?php

/**
 * EvolucionTrasplanteMarvirales filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseEvolucionTrasplanteMarviralesFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'trasplante_id' => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => true)),
      'fecha'         => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate(), 'with_empty' => false)),
      'hsv'           => new sfWidgetFormFilterInput(),
      'aghbs'         => new sfWidgetFormChoice(array('choices' => array('' => '', 'Indeterminado' => 'Indeterminado', 'Negativo' => 'Negativo', 'Positivo' => 'Positivo', 'Sin datos' => 'Sin datos'))),
      'hbsac'         => new sfWidgetFormChoice(array('choices' => array('' => '', 'Indeterminado' => 'Indeterminado', 'Negativo' => 'Negativo', 'Positivo' => 'Positivo', 'Sin datos' => 'Sin datos'))),
      'hbcac'         => new sfWidgetFormChoice(array('choices' => array('' => '', 'Indeterminado' => 'Indeterminado', 'Negativo' => 'Negativo', 'Positivo' => 'Positivo', 'Sin datos' => 'Sin datos'))),
      'hvc'           => new sfWidgetFormChoice(array('choices' => array('' => '', 'Indeterminado' => 'Indeterminado', 'Negativo' => 'Negativo', 'Positivo' => 'Positivo', 'Sin datos' => 'Sin datos'))),
      'hiv'           => new sfWidgetFormChoice(array('choices' => array('' => '', 'Indeterminado' => 'Indeterminado', 'Negativo' => 'Negativo', 'Positivo' => 'Positivo', 'Sin datos' => 'Sin datos'))),
    ));

    $this->setValidators(array(
      'trasplante_id' => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Trasplante'), 'column' => 'id')),
      'fecha'         => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'hsv'           => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'aghbs'         => new sfValidatorChoice(array('required' => false, 'choices' => array('Indeterminado' => 'Indeterminado', 'Negativo' => 'Negativo', 'Positivo' => 'Positivo', 'Sin datos' => 'Sin datos'))),
      'hbsac'         => new sfValidatorChoice(array('required' => false, 'choices' => array('Indeterminado' => 'Indeterminado', 'Negativo' => 'Negativo', 'Positivo' => 'Positivo', 'Sin datos' => 'Sin datos'))),
      'hbcac'         => new sfValidatorChoice(array('required' => false, 'choices' => array('Indeterminado' => 'Indeterminado', 'Negativo' => 'Negativo', 'Positivo' => 'Positivo', 'Sin datos' => 'Sin datos'))),
      'hvc'           => new sfValidatorChoice(array('required' => false, 'choices' => array('Indeterminado' => 'Indeterminado', 'Negativo' => 'Negativo', 'Positivo' => 'Positivo', 'Sin datos' => 'Sin datos'))),
      'hiv'           => new sfValidatorChoice(array('required' => false, 'choices' => array('Indeterminado' => 'Indeterminado', 'Negativo' => 'Negativo', 'Positivo' => 'Positivo', 'Sin datos' => 'Sin datos'))),
    ));

    $this->widgetSchema->setNameFormat('evolucion_trasplante_marvirales_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'EvolucionTrasplanteMarvirales';
  }

  public function getFields()
  {
    return array(
      'id'            => 'Number',
      'trasplante_id' => 'ForeignKey',
      'fecha'         => 'Date',
      'hsv'           => 'Number',
      'aghbs'         => 'Enum',
      'hbsac'         => 'Enum',
      'hbcac'         => 'Enum',
      'hvc'           => 'Enum',
      'hiv'           => 'Enum',
    );
  }
}
