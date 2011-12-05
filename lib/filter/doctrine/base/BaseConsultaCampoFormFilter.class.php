<?php

/**
 * ConsultaCampo filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseConsultaCampoFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'nombre'         => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'nombre_visible' => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'consulta_id'    => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Consulta'), 'add_empty' => true)),
      'tipo_id'        => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('ConsultaCampoTipo'), 'add_empty' => true)),
    ));

    $this->setValidators(array(
      'nombre'         => new sfValidatorPass(array('required' => false)),
      'nombre_visible' => new sfValidatorPass(array('required' => false)),
      'consulta_id'    => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Consulta'), 'column' => 'id')),
      'tipo_id'        => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('ConsultaCampoTipo'), 'column' => 'id')),
    ));

    $this->widgetSchema->setNameFormat('consulta_campo_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'ConsultaCampo';
  }

  public function getFields()
  {
    return array(
      'id'             => 'Number',
      'nombre'         => 'Text',
      'nombre_visible' => 'Text',
      'consulta_id'    => 'ForeignKey',
      'tipo_id'        => 'ForeignKey',
    );
  }
}
