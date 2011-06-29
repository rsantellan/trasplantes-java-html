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
      'identificador'             => new sfWidgetFormFilterInput(),
      'tipo_donante'              => new sfWidgetFormChoice(array('choices' => array('' => '', 'Cadavérico' => 'Cadavérico', 'Vivo' => 'Vivo'))),
      'sexo_donante'              => new sfWidgetFormChoice(array('choices' => array('' => '', 'M' => 'M', 'F' => 'F'))),
      'edad_donante'              => new sfWidgetFormFilterInput(),
      'enastab_hemod'             => new sfWidgetFormFilterInput(),
      'donante_causa_muerte_id'   => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('DonanteCausaMuerte'), 'add_empty' => true)),
      'cr_p'                      => new sfWidgetFormFilterInput(),
      'otros'                     => new sfWidgetFormFilterInput(),
      'grupo_sanguineo'           => new sfWidgetFormChoice(array('choices' => array('' => '', 'A' => 'A', 'B' => 'B', 'AB' => 'AB', 'O' => 'O'))),
      'relacion_filiar'           => new sfWidgetFormChoice(array('choices' => array('' => '', 'sin relacion' => 'sin relacion', 'padre/madre' => 'padre/madre', 'hermano/a' => 'hermano/a', 'Hijo/a' => 'Hijo/a', 'esposo/a' => 'esposo/a', 'otro' => 'otro'))),
      'peso'                      => new sfWidgetFormFilterInput(),
      'altura'                    => new sfWidgetFormFilterInput(),
      'donante_organos_list'      => new sfWidgetFormDoctrineChoice(array('multiple' => true, 'model' => 'Organos')),
      'donante_antecedentes_list' => new sfWidgetFormDoctrineChoice(array('multiple' => true, 'model' => 'AntecedentesDeDonante')),
    ));

    $this->setValidators(array(
      'identificador'             => new sfValidatorPass(array('required' => false)),
      'tipo_donante'              => new sfValidatorChoice(array('required' => false, 'choices' => array('Cadavérico' => 'Cadavérico', 'Vivo' => 'Vivo'))),
      'sexo_donante'              => new sfValidatorChoice(array('required' => false, 'choices' => array('M' => 'M', 'F' => 'F'))),
      'edad_donante'              => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'enastab_hemod'             => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'donante_causa_muerte_id'   => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('DonanteCausaMuerte'), 'column' => 'id')),
      'cr_p'                      => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'otros'                     => new sfValidatorPass(array('required' => false)),
      'grupo_sanguineo'           => new sfValidatorChoice(array('required' => false, 'choices' => array('A' => 'A', 'B' => 'B', 'AB' => 'AB', 'O' => 'O'))),
      'relacion_filiar'           => new sfValidatorChoice(array('required' => false, 'choices' => array('sin relacion' => 'sin relacion', 'padre/madre' => 'padre/madre', 'hermano/a' => 'hermano/a', 'Hijo/a' => 'Hijo/a', 'esposo/a' => 'esposo/a', 'otro' => 'otro'))),
      'peso'                      => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'altura'                    => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'donante_organos_list'      => new sfValidatorDoctrineChoice(array('multiple' => true, 'model' => 'Organos', 'required' => false)),
      'donante_antecedentes_list' => new sfValidatorDoctrineChoice(array('multiple' => true, 'model' => 'AntecedentesDeDonante', 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('donante_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function addDonanteOrganosListColumnQuery(Doctrine_Query $query, $field, $values)
  {
    if (!is_array($values))
    {
      $values = array($values);
    }

    if (!count($values))
    {
      return;
    }

    $query
      ->leftJoin($query->getRootAlias().'.DonanteOrganos DonanteOrganos')
      ->andWhereIn('DonanteOrganos.organo_id', $values)
    ;
  }

  public function addDonanteAntecedentesListColumnQuery(Doctrine_Query $query, $field, $values)
  {
    if (!is_array($values))
    {
      $values = array($values);
    }

    if (!count($values))
    {
      return;
    }

    $query
      ->leftJoin($query->getRootAlias().'.DonanteAntecedentes DonanteAntecedentes')
      ->andWhereIn('DonanteAntecedentes.antecedente_de_donante_id', $values)
    ;
  }

  public function getModelName()
  {
    return 'Donante';
  }

  public function getFields()
  {
    return array(
      'id'                        => 'Number',
      'identificador'             => 'Text',
      'tipo_donante'              => 'Enum',
      'sexo_donante'              => 'Enum',
      'edad_donante'              => 'Number',
      'enastab_hemod'             => 'Number',
      'donante_causa_muerte_id'   => 'ForeignKey',
      'cr_p'                      => 'Number',
      'otros'                     => 'Text',
      'grupo_sanguineo'           => 'Enum',
      'relacion_filiar'           => 'Enum',
      'peso'                      => 'Number',
      'altura'                    => 'Number',
      'donante_organos_list'      => 'ManyKey',
      'donante_antecedentes_list' => 'ManyKey',
    );
  }
}
