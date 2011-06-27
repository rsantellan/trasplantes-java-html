<?php

/**
 * TrasplanteReoperacion filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseTrasplanteReoperacionFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'trasplante_id'              => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => true)),
      'fecha'                      => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate(), 'with_empty' => false)),
      'descripcion'                => new sfWidgetFormFilterInput(),
      'trasplante_complicacion_id' => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('TrasplanteComplicaciones'), 'add_empty' => true)),
    ));

    $this->setValidators(array(
      'trasplante_id'              => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Trasplante'), 'column' => 'id')),
      'fecha'                      => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'descripcion'                => new sfValidatorPass(array('required' => false)),
      'trasplante_complicacion_id' => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('TrasplanteComplicaciones'), 'column' => 'id')),
    ));

    $this->widgetSchema->setNameFormat('trasplante_reoperacion_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'TrasplanteReoperacion';
  }

  public function getFields()
  {
    return array(
      'id'                         => 'Number',
      'trasplante_id'              => 'ForeignKey',
      'fecha'                      => 'Date',
      'descripcion'                => 'Text',
      'trasplante_complicacion_id' => 'ForeignKey',
    );
  }
}
