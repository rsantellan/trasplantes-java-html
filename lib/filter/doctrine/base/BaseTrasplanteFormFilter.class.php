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
      'inestab_hemodial'                  => new sfWidgetFormFilterInput(),
      'rinhon'                            => new sfWidgetFormChoice(array('choices' => array('' => '', 'Derecho' => 'Derecho', 'Izquierdo' => 'Izquierdo'))),
      'anomalia_vascular'                 => new sfWidgetFormFilterInput(),
      'numero_arterias'                   => new sfWidgetFormFilterInput(),
      'numero_venas'                      => new sfWidgetFormFilterInput(),
      'ureter'                            => new sfWidgetFormFilterInput(),
      'numero_compatibilidad_ab'          => new sfWidgetFormFilterInput(),
      'numero_compatibilidad_dr'          => new sfWidgetFormFilterInput(),
      'numero_incompatibilidad_ab'        => new sfWidgetFormFilterInput(),
      'numero_incompatibilidad_dr'        => new sfWidgetFormFilterInput(),
      'autoac'                            => new sfWidgetFormFilterInput(),
      'pra_max'                           => new sfWidgetFormFilterInput(),
      'pra_tr'                            => new sfWidgetFormFilterInput(),
      'trans_previas'                     => new sfWidgetFormFilterInput(),
      'numero_transf'                     => new sfWidgetFormFilterInput(),
      'embarazo'                          => new sfWidgetFormChoice(array('choices' => array('' => '', 'si' => 'si', 'no' => 'no', 'no aplica' => 'no aplica'))),
      'numero_embarazo'                   => new sfWidgetFormFilterInput(),
      'liquido_perfusion'                 => new sfWidgetFormChoice(array('choices' => array('' => '', 'Eurocollins' => 'Eurocollins', 'WC' => 'WC', 'Custodiol' => 'Custodiol', 'Otro' => 'Otro'))),
      'tq_de_banco'                       => new sfWidgetFormFilterInput(),
      'lado_implante'                     => new sfWidgetFormChoice(array('choices' => array('' => '', 'Derecho' => 'Derecho', 'Izquierdo' => 'Izquierdo'))),
      'anast_venosa'                      => new sfWidgetFormChoice(array('choices' => array('' => '', 'Termino lateral' => 'Termino lateral', 'Termino terminal' => 'Termino terminal', 'otra' => 'otra'))),
      'anast_arterial'                    => new sfWidgetFormChoice(array('choices' => array('' => '', 'Termino lateral' => 'Termino lateral', 'Termino terminal' => 'Termino terminal', 'otra' => 'otra'))),
      'anast_ureteral'                    => new sfWidgetFormChoice(array('choices' => array('' => '', 'Alferez' => 'Alferez', 'Taguchi' => 'Taguchi', 'Gregoire' => 'Gregoire', 'Lick' => 'Lick', 'Otra' => 'Otra'))),
      't_isq_cal_min'                     => new sfWidgetFormFilterInput(),
      't_isq_fria_hs'                     => new sfWidgetFormFilterInput(),
      't_isq_fria_min'                    => new sfWidgetFormFilterInput(),
      't_isq_tibia_hs'                    => new sfWidgetFormFilterInput(),
      'reperfusion'                       => new sfWidgetFormChoice(array('choices' => array('' => '', 'buena' => 'buena', 'regular' => 'regular', 'mala' => 'mala'))),
      'sangrado_i_op'                     => new sfWidgetFormFilterInput(),
      'lesion_arterial'                   => new sfWidgetFormFilterInput(),
      'lesion_venosa'                     => new sfWidgetFormFilterInput(),
      'necesidad_repefundir'              => new sfWidgetFormFilterInput(),
      'otras_compl_quirur'                => new sfWidgetFormFilterInput(),
      'diuresis_i_op'                     => new sfWidgetFormFilterInput(),
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
    ));

    $this->setValidators(array(
      'paciente_pre_trasplante_id'        => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Pacientepretrasplante'), 'column' => 'id')),
      'fecha'                             => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'numero_de_transplantes_realizados' => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'donante_id'                        => new sfValidatorDoctrineChoice(array('required' => false, 'model' => $this->getRelatedModelName('Donante'), 'column' => 'id')),
      'inestab_hemodial'                  => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'rinhon'                            => new sfValidatorChoice(array('required' => false, 'choices' => array('Derecho' => 'Derecho', 'Izquierdo' => 'Izquierdo'))),
      'anomalia_vascular'                 => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'numero_arterias'                   => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'numero_venas'                      => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'ureter'                            => new sfValidatorPass(array('required' => false)),
      'numero_compatibilidad_ab'          => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'numero_compatibilidad_dr'          => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'numero_incompatibilidad_ab'        => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'numero_incompatibilidad_dr'        => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'autoac'                            => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'pra_max'                           => new sfValidatorPass(array('required' => false)),
      'pra_tr'                            => new sfValidatorPass(array('required' => false)),
      'trans_previas'                     => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'numero_transf'                     => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'embarazo'                          => new sfValidatorChoice(array('required' => false, 'choices' => array('si' => 'si', 'no' => 'no', 'no aplica' => 'no aplica'))),
      'numero_embarazo'                   => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'liquido_perfusion'                 => new sfValidatorChoice(array('required' => false, 'choices' => array('Eurocollins' => 'Eurocollins', 'WC' => 'WC', 'Custodiol' => 'Custodiol', 'Otro' => 'Otro'))),
      'tq_de_banco'                       => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'lado_implante'                     => new sfValidatorChoice(array('required' => false, 'choices' => array('Derecho' => 'Derecho', 'Izquierdo' => 'Izquierdo'))),
      'anast_venosa'                      => new sfValidatorChoice(array('required' => false, 'choices' => array('Termino lateral' => 'Termino lateral', 'Termino terminal' => 'Termino terminal', 'otra' => 'otra'))),
      'anast_arterial'                    => new sfValidatorChoice(array('required' => false, 'choices' => array('Termino lateral' => 'Termino lateral', 'Termino terminal' => 'Termino terminal', 'otra' => 'otra'))),
      'anast_ureteral'                    => new sfValidatorChoice(array('required' => false, 'choices' => array('Alferez' => 'Alferez', 'Taguchi' => 'Taguchi', 'Gregoire' => 'Gregoire', 'Lick' => 'Lick', 'Otra' => 'Otra'))),
      't_isq_cal_min'                     => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      't_isq_fria_hs'                     => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      't_isq_fria_min'                    => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      't_isq_tibia_hs'                    => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'reperfusion'                       => new sfValidatorChoice(array('required' => false, 'choices' => array('buena' => 'buena', 'regular' => 'regular', 'mala' => 'mala'))),
      'sangrado_i_op'                     => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'lesion_arterial'                   => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'lesion_venosa'                     => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'necesidad_repefundir'              => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'otras_compl_quirur'                => new sfValidatorPass(array('required' => false)),
      'diuresis_i_op'                     => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
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
    ));

    $this->widgetSchema->setNameFormat('trasplante_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
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
      'inestab_hemodial'                  => 'Number',
      'rinhon'                            => 'Enum',
      'anomalia_vascular'                 => 'Number',
      'numero_arterias'                   => 'Number',
      'numero_venas'                      => 'Number',
      'ureter'                            => 'Text',
      'numero_compatibilidad_ab'          => 'Number',
      'numero_compatibilidad_dr'          => 'Number',
      'numero_incompatibilidad_ab'        => 'Number',
      'numero_incompatibilidad_dr'        => 'Number',
      'autoac'                            => 'Number',
      'pra_max'                           => 'Text',
      'pra_tr'                            => 'Text',
      'trans_previas'                     => 'Number',
      'numero_transf'                     => 'Number',
      'embarazo'                          => 'Enum',
      'numero_embarazo'                   => 'Number',
      'liquido_perfusion'                 => 'Enum',
      'tq_de_banco'                       => 'Number',
      'lado_implante'                     => 'Enum',
      'anast_venosa'                      => 'Enum',
      'anast_arterial'                    => 'Enum',
      'anast_ureteral'                    => 'Enum',
      't_isq_cal_min'                     => 'Number',
      't_isq_fria_hs'                     => 'Number',
      't_isq_fria_min'                    => 'Number',
      't_isq_tibia_hs'                    => 'Number',
      'reperfusion'                       => 'Enum',
      'sangrado_i_op'                     => 'Number',
      'lesion_arterial'                   => 'Number',
      'lesion_venosa'                     => 'Number',
      'necesidad_repefundir'              => 'Number',
      'otras_compl_quirur'                => 'Text',
      'diuresis_i_op'                     => 'Number',
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
    );
  }
}
