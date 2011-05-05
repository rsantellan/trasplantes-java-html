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
      'fevi_normal'     => new sfWidgetFormFilterInput(),
      'insuf_hipodiast' => new sfWidgetFormFilterInput(),
      'i_ao'            => new sfWidgetFormFilterInput(),
      'e_ao'            => new sfWidgetFormFilterInput(),
      'i_m'             => new sfWidgetFormFilterInput(),
      'e_m'             => new sfWidgetFormFilterInput(),
      'i_p'             => new sfWidgetFormFilterInput(),
      'e_p'             => new sfWidgetFormFilterInput(),
      'i_t'             => new sfWidgetFormFilterInput(),
      'e_t'             => new sfWidgetFormFilterInput(),
      'derrame'         => new sfWidgetFormFilterInput(),
      'calcif_valvular' => new sfWidgetFormFilterInput(),
      'hvi'             => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'fevi_normal'     => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'insuf_hipodiast' => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'i_ao'            => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'e_ao'            => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'i_m'             => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'e_m'             => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'i_p'             => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'e_p'             => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'i_t'             => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'e_t'             => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
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
      'idtrasplante'    => 'Number',
      'fecha'           => 'Date',
      'fevi_normal'     => 'Number',
      'insuf_hipodiast' => 'Number',
      'i_ao'            => 'Number',
      'e_ao'            => 'Number',
      'i_m'             => 'Number',
      'e_m'             => 'Number',
      'i_p'             => 'Number',
      'e_p'             => 'Number',
      'i_t'             => 'Number',
      'e_t'             => 'Number',
      'derrame'         => 'Number',
      'calcif_valvular' => 'Number',
      'hvi'             => 'Number',
    );
  }
}
