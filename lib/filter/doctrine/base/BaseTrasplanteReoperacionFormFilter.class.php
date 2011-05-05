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
      'descripcion'   => new sfWidgetFormFilterInput(),
      'complicacion'  => new sfWidgetFormFilterInput(array('with_empty' => false)),
    ));

    $this->setValidators(array(
      'descripcion'   => new sfValidatorPass(array('required' => false)),
      'complicacion'  => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
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
      'id_trasplante' => 'Number',
      'fecha'         => 'Date',
      'descripcion'   => 'Text',
      'complicacion'  => 'Number',
    );
  }
}
