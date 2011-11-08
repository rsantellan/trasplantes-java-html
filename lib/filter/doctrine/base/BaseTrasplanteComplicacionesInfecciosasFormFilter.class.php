<?php

/**
 * TrasplanteComplicacionesInfecciosas filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseTrasplanteComplicacionesInfecciosasFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'trasplante_id'       => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => true)),
      'fecha'               => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate(), 'with_empty' => false)),
      'medicacion_id'       => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Medicaciones'), 'add_empty' => true)),
      'infeccion_id'        => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Infeccion'), 'add_empty' => true)),
      'germen_id'           => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Germenes'), 'add_empty' => true)),
      'internado'           => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'dias_de_internacion' => new sfWidgetFormFilterInput(),
      'evolucion'           => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'comentario'          => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'trasplante_id'       => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Trasplante'), 'column' => 'id')),
      'fecha'               => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'medicacion_id'       => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Medicaciones'), 'column' => 'id')),
      'infeccion_id'        => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Infeccion'), 'column' => 'id')),
      'germen_id'           => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Germenes'), 'column' => 'id')),
      'internado'           => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'dias_de_internacion' => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'evolucion'           => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'comentario'          => new sfValidatorPass(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('trasplante_complicaciones_infecciosas_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'TrasplanteComplicacionesInfecciosas';
  }

  public function getFields()
  {
    return array(
      'id'                  => 'Number',
      'trasplante_id'       => 'ForeignKey',
      'fecha'               => 'Date',
      'medicacion_id'       => 'ForeignKey',
      'infeccion_id'        => 'ForeignKey',
      'germen_id'           => 'ForeignKey',
      'internado'           => 'Number',
      'dias_de_internacion' => 'Number',
      'evolucion'           => 'Number',
      'comentario'          => 'Text',
    );
  }
}
