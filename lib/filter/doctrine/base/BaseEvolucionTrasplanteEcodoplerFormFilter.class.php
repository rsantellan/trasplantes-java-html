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
      'trasplante_id' => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Trasplante'), 'add_empty' => true)),
      'fecha'         => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate(), 'with_empty' => false)),
      'estructura'    => new sfWidgetFormChoice(array('choices' => array('' => '', 'Bien' => 'Bien', 'Mal' => 'Mal'))),
      'dilatacion'    => new sfWidgetFormFilterInput(),
      'colecciones'   => new sfWidgetFormFilterInput(),
      'eje_arterial'  => new sfWidgetFormChoice(array('choices' => array('' => '', 'Bien' => 'Bien', 'Mal' => 'Mal'))),
      'eje_venoso'    => new sfWidgetFormChoice(array('choices' => array('' => '', 'Bien' => 'Bien', 'Mal' => 'Mal'))),
      'arteria_renal' => new sfWidgetFormChoice(array('choices' => array('' => '', 'Bien' => 'Bien', 'Mal' => 'Mal'))),
      'vena_renal'    => new sfWidgetFormChoice(array('choices' => array('' => '', 'Bien' => 'Bien', 'Mal' => 'Mal'))),
      'anast_venosa'  => new sfWidgetFormChoice(array('choices' => array('' => '', 'Bien' => 'Bien', 'Mal' => 'Mal'))),
      'anast_renosa'  => new sfWidgetFormChoice(array('choices' => array('' => '', 'Bien' => 'Bien', 'Mal' => 'Mal'))),
      'indice'        => new sfWidgetFormFilterInput(),
      'otros'         => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'trasplante_id' => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Trasplante'), 'column' => 'id')),
      'fecha'         => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'estructura'    => new sfValidatorChoice(array('required' => false, 'choices' => array('Bien' => 'Bien', 'Mal' => 'Mal'))),
      'dilatacion'    => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'colecciones'   => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'eje_arterial'  => new sfValidatorChoice(array('required' => false, 'choices' => array('Bien' => 'Bien', 'Mal' => 'Mal'))),
      'eje_venoso'    => new sfValidatorChoice(array('required' => false, 'choices' => array('Bien' => 'Bien', 'Mal' => 'Mal'))),
      'arteria_renal' => new sfValidatorChoice(array('required' => false, 'choices' => array('Bien' => 'Bien', 'Mal' => 'Mal'))),
      'vena_renal'    => new sfValidatorChoice(array('required' => false, 'choices' => array('Bien' => 'Bien', 'Mal' => 'Mal'))),
      'anast_venosa'  => new sfValidatorChoice(array('required' => false, 'choices' => array('Bien' => 'Bien', 'Mal' => 'Mal'))),
      'anast_renosa'  => new sfValidatorChoice(array('required' => false, 'choices' => array('Bien' => 'Bien', 'Mal' => 'Mal'))),
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
      'id'            => 'Number',
      'trasplante_id' => 'ForeignKey',
      'fecha'         => 'Date',
      'estructura'    => 'Enum',
      'dilatacion'    => 'Number',
      'colecciones'   => 'Number',
      'eje_arterial'  => 'Enum',
      'eje_venoso'    => 'Enum',
      'arteria_renal' => 'Enum',
      'vena_renal'    => 'Enum',
      'anast_venosa'  => 'Enum',
      'anast_renosa'  => 'Enum',
      'indice'        => 'Number',
      'otros'         => 'Text',
    );
  }
}
