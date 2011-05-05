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
      'pretrasplante'        => new sfWidgetFormFilterInput(),
      'fecha'                => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate())),
      'num_tr'               => new sfWidgetFormFilterInput(),
      'id_donante'           => new sfWidgetFormFilterInput(),
      'inestab_hemod'        => new sfWidgetFormFilterInput(),
      'rinhon'               => new sfWidgetFormFilterInput(),
      'anomalia_vasc'        => new sfWidgetFormFilterInput(),
      'num_art'              => new sfWidgetFormFilterInput(),
      'num_venas'            => new sfWidgetFormFilterInput(),
      'ureter'               => new sfWidgetFormFilterInput(),
      'num_comp_a_b'         => new sfWidgetFormFilterInput(),
      'num_comp_dr'          => new sfWidgetFormFilterInput(),
      'num_imcomp_a_b'       => new sfWidgetFormFilterInput(),
      'num_imcomp_dr'        => new sfWidgetFormFilterInput(),
      'autoac'               => new sfWidgetFormFilterInput(),
      'pra_max'              => new sfWidgetFormFilterInput(),
      'pra_tr'               => new sfWidgetFormFilterInput(),
      'trans_previas'        => new sfWidgetFormFilterInput(),
      'num_transf'           => new sfWidgetFormFilterInput(),
      'embarazo'             => new sfWidgetFormFilterInput(),
      'num_embarazo'         => new sfWidgetFormFilterInput(),
      'liq_perfusion'        => new sfWidgetFormFilterInput(),
      'tq_de_banco'          => new sfWidgetFormFilterInput(),
      'lado_implante'        => new sfWidgetFormFilterInput(),
      'anast_venosa'         => new sfWidgetFormFilterInput(),
      'anast_arterial'       => new sfWidgetFormFilterInput(),
      'anast_ureteral'       => new sfWidgetFormFilterInput(),
      't_isq_cal_min'        => new sfWidgetFormFilterInput(),
      't_isq_fria_hs'        => new sfWidgetFormFilterInput(),
      't_isq_fria_min'       => new sfWidgetFormFilterInput(),
      't_isq_tibia_hs'       => new sfWidgetFormFilterInput(),
      'repercusion'          => new sfWidgetFormFilterInput(),
      'sangrado_i_op'        => new sfWidgetFormFilterInput(),
      'lesion_arterial'      => new sfWidgetFormFilterInput(),
      'lesion_venosa'        => new sfWidgetFormFilterInput(),
      'necesidad_repefundir' => new sfWidgetFormFilterInput(),
      'otras_compl_quirur'   => new sfWidgetFormFilterInput(),
      'diuresis_i_op'        => new sfWidgetFormFilterInput(),
      'cr_inicial'           => new sfWidgetFormFilterInput(),
      'dia_rec_diuresis'     => new sfWidgetFormFilterInput(),
      'dia_rec_funcional'    => new sfWidgetFormFilterInput(),
      'dialisis'             => new sfWidgetFormFilterInput(),
      'num_de_hd'            => new sfWidgetFormFilterInput(),
      'comentario'           => new sfWidgetFormFilterInput(),
      'fecha_alta'           => new sfWidgetFormFilterDate(array('from_date' => new sfWidgetFormDate(), 'to_date' => new sfWidgetFormDate())),
    ));

    $this->setValidators(array(
      'pretrasplante'        => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'fecha'                => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
      'num_tr'               => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'id_donante'           => new sfValidatorPass(array('required' => false)),
      'inestab_hemod'        => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'rinhon'               => new sfValidatorPass(array('required' => false)),
      'anomalia_vasc'        => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'num_art'              => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'num_venas'            => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'ureter'               => new sfValidatorPass(array('required' => false)),
      'num_comp_a_b'         => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'num_comp_dr'          => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'num_imcomp_a_b'       => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'num_imcomp_dr'        => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'autoac'               => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'pra_max'              => new sfValidatorPass(array('required' => false)),
      'pra_tr'               => new sfValidatorPass(array('required' => false)),
      'trans_previas'        => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'num_transf'           => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'embarazo'             => new sfValidatorPass(array('required' => false)),
      'num_embarazo'         => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'liq_perfusion'        => new sfValidatorPass(array('required' => false)),
      'tq_de_banco'          => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'lado_implante'        => new sfValidatorPass(array('required' => false)),
      'anast_venosa'         => new sfValidatorPass(array('required' => false)),
      'anast_arterial'       => new sfValidatorPass(array('required' => false)),
      'anast_ureteral'       => new sfValidatorPass(array('required' => false)),
      't_isq_cal_min'        => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      't_isq_fria_hs'        => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      't_isq_fria_min'       => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      't_isq_tibia_hs'       => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'repercusion'          => new sfValidatorPass(array('required' => false)),
      'sangrado_i_op'        => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'lesion_arterial'      => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'lesion_venosa'        => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'necesidad_repefundir' => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'otras_compl_quirur'   => new sfValidatorPass(array('required' => false)),
      'diuresis_i_op'        => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'cr_inicial'           => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'dia_rec_diuresis'     => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'dia_rec_funcional'    => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'dialisis'             => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'num_de_hd'            => new sfValidatorSchemaFilter('text', new sfValidatorInteger(array('required' => false))),
      'comentario'           => new sfValidatorPass(array('required' => false)),
      'fecha_alta'           => new sfValidatorDateRange(array('required' => false, 'from_date' => new sfValidatorDate(array('required' => false)), 'to_date' => new sfValidatorDateTime(array('required' => false)))),
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
      'id'                   => 'Number',
      'pretrasplante'        => 'Number',
      'fecha'                => 'Date',
      'num_tr'               => 'Number',
      'id_donante'           => 'Text',
      'inestab_hemod'        => 'Number',
      'rinhon'               => 'Text',
      'anomalia_vasc'        => 'Number',
      'num_art'              => 'Number',
      'num_venas'            => 'Number',
      'ureter'               => 'Text',
      'num_comp_a_b'         => 'Number',
      'num_comp_dr'          => 'Number',
      'num_imcomp_a_b'       => 'Number',
      'num_imcomp_dr'        => 'Number',
      'autoac'               => 'Number',
      'pra_max'              => 'Text',
      'pra_tr'               => 'Text',
      'trans_previas'        => 'Number',
      'num_transf'           => 'Number',
      'embarazo'             => 'Text',
      'num_embarazo'         => 'Number',
      'liq_perfusion'        => 'Text',
      'tq_de_banco'          => 'Number',
      'lado_implante'        => 'Text',
      'anast_venosa'         => 'Text',
      'anast_arterial'       => 'Text',
      'anast_ureteral'       => 'Text',
      't_isq_cal_min'        => 'Number',
      't_isq_fria_hs'        => 'Number',
      't_isq_fria_min'       => 'Number',
      't_isq_tibia_hs'       => 'Number',
      'repercusion'          => 'Text',
      'sangrado_i_op'        => 'Number',
      'lesion_arterial'      => 'Number',
      'lesion_venosa'        => 'Number',
      'necesidad_repefundir' => 'Number',
      'otras_compl_quirur'   => 'Text',
      'diuresis_i_op'        => 'Number',
      'cr_inicial'           => 'Number',
      'dia_rec_diuresis'     => 'Number',
      'dia_rec_funcional'    => 'Number',
      'dialisis'             => 'Number',
      'num_de_hd'            => 'Number',
      'comentario'           => 'Text',
      'fecha_alta'           => 'Date',
    );
  }
}
