<?php

/**
 * EvolucionTrasplanteEcodopler filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseEvolucionTrasplanteEcodoplerFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'estructura'    => new sfWidgetFormFilterInput(),
      'dilatacion'    => new sfWidgetFormFilterInput(),
      'colecciones'   => new sfWidgetFormFilterInput(),
      'eje_arterial'  => new sfWidgetFormFilterInput(),
      'eje_venoso'    => new sfWidgetFormFilterInput(),
      'arteria_renal' => new sfWidgetFormFilterInput(),
      'vena_renal'    => new sfWidgetFormFilterInput(),
      'anast_venosa'  => new sfWidgetFormFilterInput(),
      'anast_renosa'  => new sfWidgetFormFilterInput(),
      'indice'        => new sfWidgetFormFilterInput(),
      'otros'         => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'estructura'    => new sfValidatorPass(array('required' => false)),
      'dilatacion'    => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'colecciones'   => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'eje_arterial'  => new sfValidatorPass(array('required' => false)),
      'eje_venoso'    => new sfValidatorPass(array('required' => false)),
      'arteria_renal' => new sfValidatorPass(array('required' => false)),
      'vena_renal'    => new sfValidatorPass(array('required' => false)),
      'anast_venosa'  => new sfValidatorPass(array('required' => false)),
      'anast_renosa'  => new sfValidatorPass(array('required' => false)),
      'indice'        => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'otros'         => new sfValidatorPass(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('evolucion_trasplante_ecodopler_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'EvolucionTrasplanteEcodopler';
  }

  public function getFields()
  {
    return array(
      'idtrasplante'  => 'Number',
      'fecha'         => 'Date',
      'estructura'    => 'Text',
      'dilatacion'    => 'Number',
      'colecciones'   => 'Number',
      'eje_arterial'  => 'Text',
      'eje_venoso'    => 'Text',
      'arteria_renal' => 'Text',
      'vena_renal'    => 'Text',
      'anast_venosa'  => 'Text',
      'anast_renosa'  => 'Text',
      'indice'        => 'Number',
      'otros'         => 'Text',
    );
  }
}
