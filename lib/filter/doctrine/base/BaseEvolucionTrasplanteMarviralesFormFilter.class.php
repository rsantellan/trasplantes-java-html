<?php

/**
 * EvolucionTrasplanteMarvirales filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseEvolucionTrasplanteMarviralesFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'hsv'          => new sfWidgetFormFilterInput(),
      'aghbs'        => new sfWidgetFormFilterInput(),
      'hbsac'        => new sfWidgetFormFilterInput(),
      'hbcac'        => new sfWidgetFormFilterInput(),
      'hvc'          => new sfWidgetFormFilterInput(),
      'hiv'          => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'hsv'          => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'aghbs'        => new sfValidatorPass(array('required' => false)),
      'hbsac'        => new sfValidatorPass(array('required' => false)),
      'hbcac'        => new sfValidatorPass(array('required' => false)),
      'hvc'          => new sfValidatorPass(array('required' => false)),
      'hiv'          => new sfValidatorPass(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('evolucion_trasplante_marvirales_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'EvolucionTrasplanteMarvirales';
  }

  public function getFields()
  {
    return array(
      'idtrasplante' => 'Number',
      'fecha'        => 'Date',
      'hsv'          => 'Number',
      'aghbs'        => 'Text',
      'hbsac'        => 'Text',
      'hbcac'        => 'Text',
      'hvc'          => 'Text',
      'hiv'          => 'Text',
    );
  }
}
