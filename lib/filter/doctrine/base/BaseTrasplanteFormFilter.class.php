<?php

/**
 * Trasplante filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseTrasplanteFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'paciente_pre_trasplante_id'        => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Pacientepretrasplante'), 'add_empty' => true)),
      'fecha'                             => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate(), 'with_empty' => false)),
      'numero_de_transplantes_realizados' => new sfWidgetFormFilterInput(),
      'donante_id'                        => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Donante'), 'add_empty' => true)),
      'inestab_hemodial'                  => new sfWidgetFormChoice(array('choices' => array('' => 'yes or no', 1 => 'yes', 0 => 'no'))),
      'rinhon'                            => new sfWidgetFormChoice(array('choices' => array('' => '', 'Derecho' => 'Derecho', 'Izquierdo' => 'Izquierdo'))),
      'anomalia_vascular'                 => new sfWidgetFormChoice(array('choices' => array('' => 'yes or no', 1 => 'yes', 0 => 'no'))),
      'numero_arterias'                   => new sfWidgetFormChoice(array('choices' => array('' => '', 1 => '1', 2 => '2', 3 => '3'))),
      'numero_venas'                      => new sfWidgetFormChoice(array('choices' => array('' => '', 1 => '1', 2 => '2', 3 => '3'))),
      'ureter'                            => new sfWidgetFormChoice(array('choices' => array('' => '', 'Unico' => 'Unico', 'Doble' => 'Doble'))),
      'numero_compatibilidad_ab'          => new sfWidgetFormFilterInput(),
      'numero_compatibilidad_dr'          => new sfWidgetFormFilterInput(),
      'numero_incompatibilidad_ab'        => new sfWidgetFormFilterInput(),
      'numero_incompatibilidad_dr'        => new sfWidgetFormFilterInput(),
      'autoac'                            => new sfWidgetFormChoice(array('choices' => array('' => 'yes or no', 1 => 'yes', 0 => 'no'))),
      'pra_max'                           => new sfWidgetFormFilterInput(),
      'pra_tr'                            => new sfWidgetFormFilterInput(),
      'trans_previas'                     => new sfWidgetFormChoice(array('choices' => array('' => 'yes or no', 1 => 'yes', 0 => 'no'))),
      'numero_transf'                     => new sfWidgetFormFilterInput(),
      'embarazo'                          => new sfWidgetFormChoice(array('choices' => array('' => '', 'si' => 'si', 'no' => 'no', 'no aplica' => 'no aplica'))),
      'numero_embarazo'                   => new sfWidgetFormFilterInput(),
      'liquido_perfusion'                 => new sfWidgetFormChoice(array('choices' => array('' => '', 'Eurocollins' => 'Eurocollins', 'WC' => 'WC', 'Custodiol' => 'Custodiol', 'Otro' => 'Otro'))),
      'tq_de_banco'                       => new sfWidgetFormChoice(array('choices' => array('' => 'yes or no', 1 => 'yes', 0 => 'no'))),
      'lado_implante'                     => new sfWidgetFormChoice(array('choices' => array('' => '', 'Derecho' => 'Derecho', 'Izquierdo' => 'Izquierdo'))),
      'anast_venosa'                      => new sfWidgetFormChoice(array('choices' => array('' => '', 'Termino lateral' => 'Termino lateral', 'Termino terminal' => 'Termino terminal', 'otra' => 'otra'))),
      'anast_arterial'                    => new sfWidgetFormChoice(array('choices' => array('' => '', 'Termino lateral' => 'Termino lateral', 'Termino terminal' => 'Termino terminal', 'otra' => 'otra'))),
      'anast_ureteral'                    => new sfWidgetFormChoice(array('choices' => array('' => '', 'Alferez' => 'Alferez', 'Taguchi' => 'Taguchi', 'Gregoire' => 'Gregoire', 'Lick' => 'Lick', 'Otra' => 'Otra'))),
      't_isq_cal_min'                     => new sfWidgetFormFilterInput(),
      't_isq_fria_hs'                     => new sfWidgetFormFilterInput(),
      't_isq_fria_min'                    => new sfWidgetFormFilterInput(),
      't_isq_tibia_hs'                    => new sfWidgetFormFilterInput(),
      'reperfusion'                       => new sfWidgetFormChoice(array('choices' => array('' => '', 'buena' => 'buena', 'regular' => 'regular', 'mala' => 'mala'))),
      'sangrado_i_op'                     => new sfWidgetFormChoice(array('choices' => array('' => 'yes or no', 1 => 'yes', 0 => 'no'))),
      'lesion_arterial'                   => new sfWidgetFormChoice(array('choices' => array('' => 'yes or no', 1 => 'yes', 0 => 'no'))),
      'lesion_venosa'                     => new sfWidgetFormChoice(array('choices' => array('' => 'yes or no', 1 => 'yes', 0 => 'no'))),
      'necesidad_repefundir'              => new sfWidgetFormChoice(array('choices' => array('' => 'yes or no', 1 => 'yes', 0 => 'no'))),
      'otras_compl_quirur'                => new sfWidgetFormFilterInput(),
      'diuresis_i_op'                     => new sfWidgetFormChoice(array('choices' => array('' => 'yes or no', 1 => 'yes', 0 => 'no'))),
      'cr_inicial'                        => new sfWidgetFormFilterInput(),
      'dia_rec_diuresis'                  => new sfWidgetFormFilterInput(),
      'dia_rec_funcional'                 => new sfWidgetFormFilterInput(),
      'dialisis'                          => new sfWidgetFormFilterInput(),
      'num_de_hd'                         => new sfWidgetFormFilterInput(),
      'comentario'                        => new sfWidgetFormFilterInput(),
      'fecha_alta'                        => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate())),
      'edad_receptor'                     => new sfWidgetFormFilterInput(),
      'created_at'                        => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate(), 'with_empty' => false)),
      'updated_at'                        => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate(), 'with_empty' => false)),
      'trasplante_inducciones_list'       => new sfWidgetFormDoctrineChoice(array('multiple' => true, 'model' => 'Induccion')),
      'trasplante_inmunosupresores_list'  => new sfWidgetFormDoctrineChoice(array('multiple' => true, 'model' => 'Inmunosupresores')),
    ));

    $this->setValidators(array(
      'paciente_pre_trasplante_id'        => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Pacientepretrasplante'), 'column' => 'id')),
      'fecha'                             => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'numero_de_transplantes_realizados' => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'donante_id'                        => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Donante'), 'column' => 'id')),
      'inestab_hemodial'                  => new sfValidatorChoice(array('required' => false, 'choices' => array('', 1, 0))),
      'rinhon'                            => new sfValidatorChoice(array('required' => false, 'choices' => array('Derecho' => 'Derecho', 'Izquierdo' => 'Izquierdo'))),
      'anomalia_vascular'                 => new sfValidatorChoice(array('required' => false, 'choices' => array('', 1, 0))),
      'numero_arterias'                   => new sfValidatorChoice(array('required' => false, 'choices' => array(1 => '1', 2 => '2', 3 => '3'))),
      'numero_venas'                      => new sfValidatorChoice(array('required' => false, 'choices' => array(1 => '1', 2 => '2', 3 => '3'))),
      'ureter'                            => new sfValidatorChoice(array('required' => false, 'choices' => array('Unico' => 'Unico', 'Doble' => 'Doble'))),
      'numero_compatibilidad_ab'          => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'numero_compatibilidad_dr'          => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'numero_incompatibilidad_ab'        => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'numero_incompatibilidad_dr'        => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'autoac'                            => new sfValidatorChoice(array('required' => false, 'choices' => array('', 1, 0))),
      'pra_max'                           => new sfValidatorPass(array('required' => false)),
      'pra_tr'                            => new sfValidatorPass(array('required' => false)),
      'trans_previas'                     => new sfValidatorChoice(array('required' => false, 'choices' => array('', 1, 0))),
      'numero_transf'                     => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'embarazo'                          => new sfValidatorChoice(array('required' => false, 'choices' => array('si' => 'si', 'no' => 'no', 'no aplica' => 'no aplica'))),
      'numero_embarazo'                   => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'liquido_perfusion'                 => new sfValidatorChoice(array('required' => false, 'choices' => array('Eurocollins' => 'Eurocollins', 'WC' => 'WC', 'Custodiol' => 'Custodiol', 'Otro' => 'Otro'))),
      'tq_de_banco'                       => new sfValidatorChoice(array('required' => false, 'choices' => array('', 1, 0))),
      'lado_implante'                     => new sfValidatorChoice(array('required' => false, 'choices' => array('Derecho' => 'Derecho', 'Izquierdo' => 'Izquierdo'))),
      'anast_venosa'                      => new sfValidatorChoice(array('required' => false, 'choices' => array('Termino lateral' => 'Termino lateral', 'Termino terminal' => 'Termino terminal', 'otra' => 'otra'))),
      'anast_arterial'                    => new sfValidatorChoice(array('required' => false, 'choices' => array('Termino lateral' => 'Termino lateral', 'Termino terminal' => 'Termino terminal', 'otra' => 'otra'))),
      'anast_ureteral'                    => new sfValidatorChoice(array('required' => false, 'choices' => array('Alferez' => 'Alferez', 'Taguchi' => 'Taguchi', 'Gregoire' => 'Gregoire', 'Lick' => 'Lick', 'Otra' => 'Otra'))),
      't_isq_cal_min'                     => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      't_isq_fria_hs'                     => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      't_isq_fria_min'                    => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      't_isq_tibia_hs'                    => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'reperfusion'                       => new sfValidatorChoice(array('required' => false, 'choices' => array('buena' => 'buena', 'regular' => 'regular', 'mala' => 'mala'))),
      'sangrado_i_op'                     => new sfValidatorChoice(array('required' => false, 'choices' => array('', 1, 0))),
      'lesion_arterial'                   => new sfValidatorChoice(array('required' => false, 'choices' => array('', 1, 0))),
      'lesion_venosa'                     => new sfValidatorChoice(array('required' => false, 'choices' => array('', 1, 0))),
      'necesidad_repefundir'              => new sfValidatorChoice(array('required' => false, 'choices' => array('', 1, 0))),
      'otras_compl_quirur'                => new sfValidatorPass(array('required' => false)),
      'diuresis_i_op'                     => new sfValidatorChoice(array('required' => false, 'choices' => array('', 1, 0))),
      'cr_inicial'                        => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'dia_rec_diuresis'                  => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'dia_rec_funcional'                 => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'dialisis'                          => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'num_de_hd'                         => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'comentario'                        => new sfValidatorPass(array('required' => false)),
      'fecha_alta'                        => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'edad_receptor'                     => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'created_at'                        => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDateTime(array('required' => false, 'datetime_output' => 'Y-m-d 00:00:00')), 'to_date' => new sfValidatorDateTime(array('required' => false, 'datetime_output' => 'Y-m-d 23:59:59')))),
      'updated_at'                        => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDateTime(array('required' => false, 'datetime_output' => 'Y-m-d 00:00:00')), 'to_date' => new sfValidatorDateTime(array('required' => false, 'datetime_output' => 'Y-m-d 23:59:59')))),
      'trasplante_inducciones_list'       => new sfValidatorDoctrineChoice(array('multiple' => true, 'model' => 'Induccion', 'required' => false)),
      'trasplante_inmunosupresores_list'  => new sfValidatorDoctrineChoice(array('multiple' => true, 'model' => 'Inmunosupresores', 'required' => false)),
    ));

    $this->widgetSchema->setNameFormat('trasplante_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function addTrasplanteInduccionesListColumnQuery(Doctrine_Query $query, $field, $values)
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
      ->leftJoin($query->getRootAlias().'.TrasplanteInduccion TrasplanteInduccion')
      ->andWhereIn('TrasplanteInduccion.induccion_id', $values)
    ;
  }

  public function addTrasplanteInmunosupresoresListColumnQuery(Doctrine_Query $query, $field, $values)
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
      ->leftJoin($query->getRootAlias().'.TrasplanteInmunosupresores TrasplanteInmunosupresores')
      ->andWhereIn('TrasplanteInmunosupresores.inmunosupresores_id', $values)
    ;
  }

  public function getModelName()
  {
    return 'Trasplante';
  }

  public function getFields()
  {
    return array(
      'id'                                => 'Number',
      'paciente_pre_trasplante_id'        => 'ForeignKey',
      'fecha'                             => 'Date',
      'numero_de_transplantes_realizados' => 'Number',
      'donante_id'                        => 'ForeignKey',
      'inestab_hemodial'                  => 'Boolean',
      'rinhon'                            => 'Enum',
      'anomalia_vascular'                 => 'Boolean',
      'numero_arterias'                   => 'Enum',
      'numero_venas'                      => 'Enum',
      'ureter'                            => 'Enum',
      'numero_compatibilidad_ab'          => 'Number',
      'numero_compatibilidad_dr'          => 'Number',
      'numero_incompatibilidad_ab'        => 'Number',
      'numero_incompatibilidad_dr'        => 'Number',
      'autoac'                            => 'Boolean',
      'pra_max'                           => 'Text',
      'pra_tr'                            => 'Text',
      'trans_previas'                     => 'Boolean',
      'numero_transf'                     => 'Number',
      'embarazo'                          => 'Enum',
      'numero_embarazo'                   => 'Number',
      'liquido_perfusion'                 => 'Enum',
      'tq_de_banco'                       => 'Boolean',
      'lado_implante'                     => 'Enum',
      'anast_venosa'                      => 'Enum',
      'anast_arterial'                    => 'Enum',
      'anast_ureteral'                    => 'Enum',
      't_isq_cal_min'                     => 'Number',
      't_isq_fria_hs'                     => 'Number',
      't_isq_fria_min'                    => 'Number',
      't_isq_tibia_hs'                    => 'Number',
      'reperfusion'                       => 'Enum',
      'sangrado_i_op'                     => 'Boolean',
      'lesion_arterial'                   => 'Boolean',
      'lesion_venosa'                     => 'Boolean',
      'necesidad_repefundir'              => 'Boolean',
      'otras_compl_quirur'                => 'Text',
      'diuresis_i_op'                     => 'Boolean',
      'cr_inicial'                        => 'Number',
      'dia_rec_diuresis'                  => 'Number',
      'dia_rec_funcional'                 => 'Number',
      'dialisis'                          => 'Number',
      'num_de_hd'                         => 'Number',
      'comentario'                        => 'Text',
      'fecha_alta'                        => 'Date',
      'edad_receptor'                     => 'Number',
      'created_at'                        => 'Date',
      'updated_at'                        => 'Date',
      'trasplante_inducciones_list'       => 'ManyKey',
      'trasplante_inmunosupresores_list'  => 'ManyKey',
    );
  }
}
