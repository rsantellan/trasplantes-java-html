<?php

/**
 * EvolucionTrasplanteexamenes filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseEvolucionTrasplanteexamenesFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'normal'       => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'comentario'   => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'normal'       => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'comentario'   => new sfValidatorPass(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('evolucion_trasplanteexamenes_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'EvolucionTrasplanteexamenes';
  }

  public function getFields()
  {
    return array(
      'idtrasplante' => 'Number',
      'fecha'        => 'Date',
      'tipo'         => 'Text',
      'normal'       => 'Number',
      'comentario'   => 'Text',
    );
  }
}
