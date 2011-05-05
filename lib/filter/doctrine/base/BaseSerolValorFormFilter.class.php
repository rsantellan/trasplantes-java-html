<?php

/**
 * SerolValor filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseSerolValorFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'    => new sfWidgetFormFilterInput(),
      'valor' => new sfWidgetFormFilterInput(array('with_empty' => false)),
    ));

    $this->setValidators(array(
      'id'    => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'valor' => new sfValidatorPass(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('serol_valor_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'SerolValor';
  }

  public function getFields()
  {
    return array(
      'id'    => 'Number',
      'valor' => 'Text',
    );
  }
}
