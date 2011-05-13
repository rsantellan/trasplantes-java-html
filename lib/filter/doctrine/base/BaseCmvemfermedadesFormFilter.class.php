<?php

/**
 * Cmvemfermedades filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseCmvemfermedadesFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'nombre'    => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'cmvs_list' => new sfWidgetFormDoctrineChoice(array('multiple' => true, 'model' => 'Cmv')),
    ));

    $this->setValidators(array(
      'nombre'    => new sfValidatorPass(array('required' => false)),
      'cmvs_list' => new sfValidatorDoctrineChoice(array('multiple' => true, 'model' => 'Cmv', 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('cmvemfermedades_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function addCmvsListColumnQuery(Doctrine_Query $query, $field, $values)
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
      ->leftJoin($query->getRootAlias().'.CmvUsoEnfermedades CmvUsoEnfermedades')
      ->andWhereIn('CmvUsoEnfermedades.cmv_id', $values)
    ;
  }

  public function getModelName()
  {
    return 'Cmvemfermedades';
  }

  public function getFields()
  {
    return array(
      'id'        => 'Number',
      'nombre'    => 'Text',
      'cmvs_list' => 'ManyKey',
    );
  }
}
