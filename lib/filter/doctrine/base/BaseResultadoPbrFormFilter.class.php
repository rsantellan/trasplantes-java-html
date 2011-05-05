<?php

/**
 * ResultadoPbr filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseResultadoPbrFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'grado'    => new sfWidgetFormFilterInput(),
      'criterio' => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'grado'    => new sfValidatorPass(array('required' => false)),
      'criterio' => new sfValidatorPass(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('resultado_pbr_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'ResultadoPbr';
  }

  public function getFields()
  {
    return array(
      'id'       => 'Number',
      'grado'    => 'Text',
      'criterio' => 'Text',
    );
  }
}
