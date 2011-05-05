<?php

/**
 * Donante filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseDonanteFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'tipo_donante'         => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'sexo_donante'         => new sfWidgetFormFilterInput(),
      'edad_donante'         => new sfWidgetFormFilterInput(),
      'enastab_hemod'        => new sfWidgetFormFilterInput(),
      'causa_muerte_donante' => new sfWidgetFormFilterInput(),
      'cr_p'                 => new sfWidgetFormFilterInput(),
      'otros'                => new sfWidgetFormFilterInput(),
      'grupo_sang'           => new sfWidgetFormFilterInput(),
      'relacion_filiar'      => new sfWidgetFormFilterInput(),
      'peso'                 => new sfWidgetFormFilterInput(),
      'altura'               => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'tipo_donante'         => new sfValidatorPass(array('required' => false)),
      'sexo_donante'         => new sfValidatorPass(array('required' => false)),
      'edad_donante'         => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'enastab_hemod'        => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'causa_muerte_donante' => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'cr_p'                 => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'otros'                => new sfValidatorPass(array('required' => false)),
      'grupo_sang'           => new sfValidatorPass(array('required' => false)),
      'relacion_filiar'      => new sfValidatorPass(array('required' => false)),
      'peso'                 => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'altura'               => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
    ));

    $this->widgetSchema->setNameFormat('donante_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'Donante';
  }

  public function getFields()
  {
    return array(
      'id'                   => 'Text',
      'tipo_donante'         => 'Text',
      'sexo_donante'         => 'Text',
      'edad_donante'         => 'Number',
      'enastab_hemod'        => 'Number',
      'causa_muerte_donante' => 'Number',
      'cr_p'                 => 'Number',
      'otros'                => 'Text',
      'grupo_sang'           => 'Text',
      'relacion_filiar'      => 'Text',
      'peso'                 => 'Number',
      'altura'               => 'Number',
    );
  }
}
