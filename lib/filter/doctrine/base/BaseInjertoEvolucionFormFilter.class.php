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
      'tm'                  => new sfWidgetFormFilterInput(),
      'tm_cual'             => new sfWidgetFormFilterInput(),
      'gp_de_novo'          => new sfWidgetFormFilterInput(),
      'recidiva_gp_de_novo' => new sfWidgetFormFilterInput(),
      'ra'                  => new sfWidgetFormFilterInput(),
      'rc'                  => new sfWidgetFormFilterInput(),
      'tratamiento'         => new sfWidgetFormFilterInput(),
      'trasplante'          => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'tm'                  => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'tm_cual'             => new sfValidatorPass(array('required' => false)),
      'gp_de_novo'          => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'recidiva_gp_de_novo' => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'ra'                  => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'rc'                  => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'tratamiento'         => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'trasplante'          => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
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
      'pretrasplante'       => 'Number',
      'fecha'               => 'Date',
      'tm'                  => 'Number',
      'tm_cual'             => 'Text',
      'gp_de_novo'          => 'Number',
      'recidiva_gp_de_novo' => 'Number',
      'ra'                  => 'Number',
      'rc'                  => 'Number',
      'tratamiento'         => 'Number',
      'trasplante'          => 'Number',
    );
  }
}
