<?php

/**
 * TrasplanteComplicaciones filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseTrasplanteComplicacionesFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'idpretrasplante'     => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'fecha'               => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate(), 'with_empty' => false)),
      'medicacion'          => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'internado'           => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'dias_de_internacion' => new sfWidgetFormFilterInput(),
      'evolucion'           => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'comentario'          => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'idpretrasplante'     => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'fecha'               => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'medicacion'          => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'internado'           => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'dias_de_internacion' => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'evolucion'           => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'comentario'          => new sfValidatorPass(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('trasplante_complicaciones_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'TrasplanteComplicaciones';
  }

  public function getFields()
  {
    return array(
      'id'                  => 'Number',
      'idpretrasplante'     => 'Number',
      'fecha'               => 'Date',
      'medicacion'          => 'Number',
      'internado'           => 'Number',
      'dias_de_internacion' => 'Number',
      'evolucion'           => 'Number',
      'comentario'          => 'Text',
    );
  }
}
