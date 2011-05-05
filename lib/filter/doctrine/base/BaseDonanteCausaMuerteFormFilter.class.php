<?php

/**
 * DonanteCausaMuerte filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseDonanteCausaMuerteFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'detalles' => new sfWidgetFormFilterInput(array('with_empty' => false)),
    ));

    $this->setValidators(array(
      'detalles' => new sfValidatorPass(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('donante_causa_muerte_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'DonanteCausaMuerte';
  }

  public function getFields()
  {
    return array(
      'id'       => 'Number',
      'detalles' => 'Text',
    );
  }
}
