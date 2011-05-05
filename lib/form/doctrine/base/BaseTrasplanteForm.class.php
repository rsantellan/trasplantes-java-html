<?php

/**
 * Trasplante form base class.
 *
 * @method Trasplante getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseTrasplanteForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'                   => new sfWidgetFormInputHidden(),
      'pretrasplante'        => new sfWidgetFormInputText(),
      'fecha'                => new sfWidgetFormDate(),
      'num_tr'               => new sfWidgetFormInputText(),
      'id_donante'           => new sfWidgetFormInputText(),
      'inestab_hemod'        => new sfWidgetFormInputText(),
      'rinhon'               => new sfWidgetFormInputText(),
      'anomalia_vasc'        => new sfWidgetFormInputText(),
      'num_art'              => new sfWidgetFormInputText(),
      'num_venas'            => new sfWidgetFormInputText(),
      'ureter'               => new sfWidgetFormInputText(),
      'num_comp_a_b'         => new sfWidgetFormInputText(),
      'num_comp_dr'          => new sfWidgetFormInputText(),
      'num_imcomp_a_b'       => new sfWidgetFormInputText(),
      'num_imcomp_dr'        => new sfWidgetFormInputText(),
      'autoac'               => new sfWidgetFormInputText(),
      'pra_max'              => new sfWidgetFormInputText(),
      'pra_tr'               => new sfWidgetFormInputText(),
      'trans_previas'        => new sfWidgetFormInputText(),
      'num_transf'           => new sfWidgetFormInputText(),
      'embarazo'             => new sfWidgetFormInputText(),
      'num_embarazo'         => new sfWidgetFormInputText(),
      'liq_perfusion'        => new sfWidgetFormInputText(),
      'tq_de_banco'          => new sfWidgetFormInputText(),
      'lado_implante'        => new sfWidgetFormInputText(),
      'anast_venosa'         => new sfWidgetFormInputText(),
      'anast_arterial'       => new sfWidgetFormInputText(),
      'anast_ureteral'       => new sfWidgetFormInputText(),
      't_isq_cal_min'        => new sfWidgetFormInputText(),
      't_isq_fria_hs'        => new sfWidgetFormInputText(),
      't_isq_fria_min'       => new sfWidgetFormInputText(),
      't_isq_tibia_hs'       => new sfWidgetFormInputText(),
      'repercusion'          => new sfWidgetFormInputText(),
      'sangrado_i_op'        => new sfWidgetFormInputText(),
      'lesion_arterial'      => new sfWidgetFormInputText(),
      'lesion_venosa'        => new sfWidgetFormInputText(),
      'necesidad_repefundir' => new sfWidgetFormInputText(),
      'otras_compl_quirur'   => new sfWidgetFormInputText(),
      'diuresis_i_op'        => new sfWidgetFormInputText(),
      'cr_inicial'           => new sfWidgetFormInputText(),
      'dia_rec_diuresis'     => new sfWidgetFormInputText(),
      'dia_rec_funcional'    => new sfWidgetFormInputText(),
      'dialisis'             => new sfWidgetFormInputText(),
      'num_de_hd'            => new sfWidgetFormInputText(),
      'comentario'           => new sfWidgetFormInputText(),
      'fecha_alta'           => new sfWidgetFormDate(),
      'created_at'           => new sfWidgetFormDateTime(),
      'updated_at'           => new sfWidgetFormDateTime(),
    ));

    $this->setValidators(array(
      'id'                   => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'pretrasplante'        => new sfValidatorInteger(array('required' => false)),
      'fecha'                => new sfValidatorDate(array('required' => false)),
      'num_tr'               => new sfValidatorInteger(array('required' => false)),
      'id_donante'           => new sfValidatorString(array('max_length' => 20, 'required' => false)),
      'inestab_hemod'        => new sfValidatorInteger(array('required' => false)),
      'rinhon'               => new sfValidatorString(array('max_length' => 10, 'required' => false)),
      'anomalia_vasc'        => new sfValidatorInteger(array('required' => false)),
      'num_art'              => new sfValidatorInteger(array('required' => false)),
      'num_venas'            => new sfValidatorInteger(array('required' => false)),
      'ureter'               => new sfValidatorString(array('max_length' => 5, 'required' => false)),
      'num_comp_a_b'         => new sfValidatorInteger(array('required' => false)),
      'num_comp_dr'          => new sfValidatorInteger(array('required' => false)),
      'num_imcomp_a_b'       => new sfValidatorInteger(array('required' => false)),
      'num_imcomp_dr'        => new sfValidatorInteger(array('required' => false)),
      'autoac'               => new sfValidatorInteger(array('required' => false)),
      'pra_max'              => new sfValidatorString(array('max_length' => 10, 'required' => false)),
      'pra_tr'               => new sfValidatorString(array('max_length' => 20, 'required' => false)),
      'trans_previas'        => new sfValidatorInteger(array('required' => false)),
      'num_transf'           => new sfValidatorInteger(array('required' => false)),
      'embarazo'             => new sfValidatorString(array('max_length' => 9, 'required' => false)),
      'num_embarazo'         => new sfValidatorInteger(array('required' => false)),
      'liq_perfusion'        => new sfValidatorString(array('max_length' => 11, 'required' => false)),
      'tq_de_banco'          => new sfValidatorInteger(array('required' => false)),
      'lado_implante'        => new sfValidatorString(array('max_length' => 10, 'required' => false)),
      'anast_venosa'         => new sfValidatorString(array('max_length' => 17, 'required' => false)),
      'anast_arterial'       => new sfValidatorString(array('max_length' => 17, 'required' => false)),
      'anast_ureteral'       => new sfValidatorString(array('max_length' => 9, 'required' => false)),
      't_isq_cal_min'        => new sfValidatorInteger(array('required' => false)),
      't_isq_fria_hs'        => new sfValidatorInteger(array('required' => false)),
      't_isq_fria_min'       => new sfValidatorInteger(array('required' => false)),
      't_isq_tibia_hs'       => new sfValidatorInteger(array('required' => false)),
      'repercusion'          => new sfValidatorString(array('max_length' => 7, 'required' => false)),
      'sangrado_i_op'        => new sfValidatorInteger(array('required' => false)),
      'lesion_arterial'      => new sfValidatorInteger(array('required' => false)),
      'lesion_venosa'        => new sfValidatorInteger(array('required' => false)),
      'necesidad_repefundir' => new sfValidatorInteger(array('required' => false)),
      'otras_compl_quirur'   => new sfValidatorString(array('max_length' => 250, 'required' => false)),
      'diuresis_i_op'        => new sfValidatorInteger(array('required' => false)),
      'cr_inicial'           => new sfValidatorNumber(array('required' => false)),
      'dia_rec_diuresis'     => new sfValidatorInteger(array('required' => false)),
      'dia_rec_funcional'    => new sfValidatorInteger(array('required' => false)),
      'dialisis'             => new sfValidatorInteger(array('required' => false)),
      'num_de_hd'            => new sfValidatorInteger(array('required' => false)),
      'comentario'           => new sfValidatorString(array('max_length' => 255, 'required' => false)),
      'fecha_alta'           => new sfValidatorDate(array('required' => false)),
      'created_at'           => new sfValidatorDateTime(),
      'updated_at'           => new sfValidatorDateTime(),
    ));

    $this->widgetSchema->setNameFormat('trasplante[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'Trasplante';
  }

}
