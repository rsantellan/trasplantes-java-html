<?php

/**
 * EvolucionTrasplanteEcoCardio filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseEvolucionTrasplanteEcoCardioFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'trasplante_id'   => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => true)),
      'fecha'           => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate(), 'with_empty' => false)),
      'fevi_normal'     => new sfWidgetFormFilterInput(),
      'insuf_hipodiast' => new sfWidgetFormFilterInput(),
      'iao'             => new sfWidgetFormFilterInput(),
      'eao'             => new sfWidgetFormFilterInput(),
      'im'              => new sfWidgetFormFilterInput(),
      'em'              => new sfWidgetFormFilterInput(),
      'ip'              => new sfWidgetFormFilterInput(),
      'ep'              => new sfWidgetFormFilterInput(),
      'it'              => new sfWidgetFormFilterInput(),
      'et'              => new sfWidgetFormFilterInput(),
      'derrame'         => new sfWidgetFormFilterInput(),
      'calcif_valvular' => new sfWidgetFormFilterInput(),
      'hvi'             => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'trasplante_id'   => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Trasplante'), 'column' => 'id')),
      'fecha'           => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'fevi_normal'     => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'insuf_hipodiast' => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'iao'             => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'eao'             => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'im'              => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'em'              => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'ip'              => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'ep'              => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'it'              => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'et'              => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'derrame'         => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'calcif_valvular' => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'hvi'             => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
    ));

    $this->widgetSchema->setNameFormat('evolucion_trasplante_eco_cardio_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'EvolucionTrasplanteEcoCardio';
  }

  public function getFields()
  {
    return array(
      'id'              => 'Number',
      'trasplante_id'   => 'ForeignKey',
      'fecha'           => 'Date',
      'fevi_normal'     => 'Number',
      'insuf_hipodiast' => 'Number',
      'iao'             => 'Number',
      'eao'             => 'Number',
      'im'              => 'Number',
      'em'              => 'Number',
      'ip'              => 'Number',
      'ep'              => 'Number',
      'it'              => 'Number',
      'et'              => 'Number',
      'derrame'         => 'Number',
      'calcif_valvular' => 'Number',
      'hvi'             => 'Number',
    );
  }
}
