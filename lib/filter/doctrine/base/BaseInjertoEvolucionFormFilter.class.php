<?php

/**
 * InjertoEvolucion filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseInjertoEvolucionFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'trasplante_id'       => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => true)),
      'fecha'               => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate(), 'with_empty' => false)),
      'tm'                  => new sfWidgetFormFilterInput(),
      'tm_cual'             => new sfWidgetFormFilterInput(),
      'gp_de_novo'          => new sfWidgetFormFilterInput(),
      'recidiva_gp_de_novo' => new sfWidgetFormFilterInput(),
      'ra'                  => new sfWidgetFormFilterInput(),
      'rc'                  => new sfWidgetFormFilterInput(),
      'ra_tratamiento_id'   => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Ratratamiento'), 'add_empty' => true)),
      'en_trasplante'       => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'trasplante_id'       => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Trasplante'), 'column' => 'id')),
      'fecha'               => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'tm'                  => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'tm_cual'             => new sfValidatorPass(array('required' => false)),
      'gp_de_novo'          => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'recidiva_gp_de_novo' => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'ra'                  => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'rc'                  => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'ra_tratamiento_id'   => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Ratratamiento'), 'column' => 'id')),
      'en_trasplante'       => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
    ));

    $this->widgetSchema->setNameFormat('injerto_evolucion_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'InjertoEvolucion';
  }

  public function getFields()
  {
    return array(
      'id'                  => 'Number',
      'trasplante_id'       => 'ForeignKey',
      'fecha'               => 'Date',
      'tm'                  => 'Number',
      'tm_cual'             => 'Text',
      'gp_de_novo'          => 'Number',
      'recidiva_gp_de_novo' => 'Number',
      'ra'                  => 'Number',
      'rc'                  => 'Number',
      'ra_tratamiento_id'   => 'ForeignKey',
      'en_trasplante'       => 'Number',
    );
  }
}
