<?php

/**
 * Inmunosupresores filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseInmunosupresoresFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'nombre'          => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'trasplante_list' => new sfWidgetFormDoctrineChoice(array('multiple' => true, 'model' => 'Trasplante')),
    ));

    $this->setValidators(array(
      'nombre'          => new sfValidatorPass(array('required' => false)),
      'trasplante_list' => new sfValidatorDoctrineChoice(array('multiple' => true, 'model' => 'Trasplante', 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('inmunosupresores_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function addTrasplanteListColumnQuery(Doctrine_Query $query, $field, $values)
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
      ->leftJoin($query->getRootAlias().'.TrasplanteInmunosupresores TrasplanteInmunosupresores')
      ->andWhereIn('TrasplanteInmunosupresores.trasplante_id', $values)
    ;
  }

  public function getModelName()
  {
    return 'Inmunosupresores';
  }

  public function getFields()
  {
    return array(
      'id'              => 'Number',
      'nombre'          => 'Text',
      'trasplante_list' => 'ManyKey',
    );
  }
}
