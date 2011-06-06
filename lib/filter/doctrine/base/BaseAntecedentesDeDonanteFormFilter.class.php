<?php

/**
 * AntecedentesDeDonante filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseAntecedentesDeDonanteFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'nombre'        => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'donantes_list' => new sfWidgetFormDoctrineChoice(array('multiple' => true, 'model' => 'Donante')),
    ));

    $this->setValidators(array(
      'nombre'        => new sfValidatorPass(array('required' => false)),
      'donantes_list' => new sfValidatorDoctrineChoice(array('multiple' => true, 'model' => 'Donante', 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('antecedentes_de_donante_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function addDonantesListColumnQuery(Doctrine_Query $query, $field, $values)
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
      ->leftJoin($query->getRootAlias().'.DonanteAntecedentes DonanteAntecedentes')
      ->andWhereIn('DonanteAntecedentes.donante_id', $values)
    ;
  }

  public function getModelName()
  {
    return 'AntecedentesDeDonante';
  }

  public function getFields()
  {
    return array(
      'id'            => 'Number',
      'nombre'        => 'Text',
      'donantes_list' => 'ManyKey',
    );
  }
}
