<?php

/**
 * DonanteOrganos filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseDonanteOrganosFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id_donante' => new sfWidgetFormFilterInput(array('with_empty' => false)),
      'organo'     => new sfWidgetFormFilterInput(array('with_empty' => false)),
    ));

    $this->setValidators(array(
      'id_donante' => new sfValidatorPass(array('required' => false)),
      'organo'     => new sfValidatorPass(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('donante_organos_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'DonanteOrganos';
  }

  public function getFields()
  {
    return array(
      'id'         => 'Number',
      'id_donante' => 'Text',
      'organo'     => 'Text',
    );
  }
}
