<?php

/**
 * Tratamiento filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseTratamientoFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'dosis'        => new sfWidgetFormFilterInput(),
      'fecha_fin'    => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate())),
    ));

    $this->setValidators(array(
      'dosis'        => new sfValidatorPass(array('required' => false)),
      'fecha_fin'    => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
    ));

    $this->widgetSchema->setNameFormat('tratamiento_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'Tratamiento';
  }

  public function getFields()
  {
    return array(
      'the'          => 'Number',
      'medicacion'   => 'Number',
      'dosis'        => 'Text',
      'fecha_inicio' => 'Date',
      'fecha_fin'    => 'Date',
    );
  }
}
