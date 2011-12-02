<?php

/**
 * ResultadoPbr filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseResultadoPbrFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'grado'                    => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'criterio'                 => new sfWidgetFormFilterInput(),
      'injerto_evoluciones_list' => new sfWidgetFormDoctrineChoice(array('multiple' => true, 'model' => 'InjertoEvolucion')),
    ));

    $this->setValidators(array(
      'grado'                    => new sfValidatorPass(array('required' => false)),
      'criterio'                 => new sfValidatorPass(array('required' => false)),
      'injerto_evoluciones_list' => new sfValidatorDoctrineChoice(array('multiple' => true, 'model' => 'InjertoEvolucion', 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('resultado_pbr_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function addInjertoEvolucionesListColumnQuery(Doctrine_Query $query, $field, $values)
  {
    if (!is_array($values))
    {
      $values = array($values);
    }

    if (!count($values))
    {
      return;
    }

    $query
      ->leftJoin($query->getRootAlias().'.InjertoEvolucionPbr InjertoEvolucionPbr')
      ->andWhereIn('InjertoEvolucionPbr.injerto_evolucion_id', $values)
    ;
  }

  public function getModelName()
  {
    return 'ResultadoPbr';
  }

  public function getFields()
  {
    return array(
      'id'                       => 'Number',
      'grado'                    => 'Text',
      'criterio'                 => 'Text',
      'injerto_evoluciones_list' => 'ManyKey',
    );
  }
}
