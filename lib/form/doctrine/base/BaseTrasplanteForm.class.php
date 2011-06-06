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
      'id'                                => new sfWidgetFormInputHidden(),
      'paciente_pre_trasplante_id'        => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Pacientepretrasplante'), 'add_empty' => false)),
      'fecha'                             => new sfWidgetFormDate(),
      'numero_de_transplantes_realizados' => new sfWidgetFormInputText(),
      'donante_id'                        => new sfWidgetFormDoctrineChoice(array('model' => $this->getRelatedModelName('Donante'), 'add_empty' => false)),
      'inestab_hemodial'                  => new sfWidgetFormInputText(),
      'rinhon'                            => new sfWidgetFormInputText(),
      'anomalia_vascular'                 => new sfWidgetFormInputText(),
      'numero_arterias'                   => new sfWidgetFormInputText(),
      'numero_venas'                      => new sfWidgetFormInputText(),
      'ureter'                            => new sfWidgetFormInputText(),
      'numero_compatibilidad_ab'          => new sfWidgetFormInputText(),
      'numero_compatibilidad_dr'          => new sfWidgetFormInputText(),
      'numero_incompatibilidad_ab'        => new sfWidgetFormInputText(),
      'numero_incompatibilidad_dr'        => new sfWidgetFormInputText(),
      'autoac'                            => new sfWidgetFormInputText(),
      'pra_max'                           => new sfWidgetFormInputText(),
      'pra_tr'                            => new sfWidgetFormInputText(),
      'trans_previas'                     => new sfWidgetFormInputText(),
      'numero_transf'                     => new sfWidgetFormInputText(),
      'embarazo'                          => new sfWidgetFormChoice(array('choices' => array('si' => 'si', 'no' => 'no', 'no aplica' => 'no aplica'))),
      'numero_embarazo'                   => new sfWidgetFormInputText(),
      'liquido_perfusion'                 => new sfWidgetFormChoice(array('choices' => array('Eurocollins' => 'Eurocollins', 'WC' => 'WC', 'Custodiol' => 'Custodiol', 'Otro' => 'Otro'))),
      'tq_de_banco'                       => new sfWidgetFormInputText(),
      'lado_implante'                     => new sfWidgetFormChoice(array('choices' => array('Derecho' => 'Derecho', 'Izquierdo' => 'Izquierdo'))),
      'anast_venosa'                      => new sfWidgetFormChoice(array('choices' => array('Termino lateral' => 'Termino lateral', 'Termino terminal' => 'Termino terminal', 'otra' => 'otra'))),
      'anast_arterial'                    => new sfWidgetFormChoice(array('choices' => array('Termino lateral' => 'Termino lateral', 'Termino terminal' => 'Termino terminal', 'otra' => 'otra'))),
      'anast_ureteral'                    => new sfWidgetFormChoice(array('choices' => array('Alferez' => 'Alferez', 'Taguchi' => 'Taguchi', 'Gregoire' => 'Gregoire', 'Lick' => 'Lick', 'Otra' => 'Otra'))),
      't_isq_cal_min'                     => new sfWidgetFormInputText(),
      't_isq_fria_hs'                     => new sfWidgetFormInputText(),
      't_isq_fria_min'                    => new sfWidgetFormInputText(),
      't_isq_tibia_hs'                    => new sfWidgetFormInputText(),
      'reperfusion'                       => new sfWidgetFormChoice(array('choices' => array('buena' => 'buena', 'regular' => 'regular', 'mala' => 'mala'))),
      'sangrado_i_op'                     => new sfWidgetFormInputText(),
      'lesion_arterial'                   => new sfWidgetFormInputText(),
      'lesion_venosa'                     => new sfWidgetFormInputText(),
      'necesidad_repefundir'              => new sfWidgetFormInputText(),
      'otras_compl_quirur'                => new sfWidgetFormInputText(),
      'diuresis_i_op'                     => new sfWidgetFormInputText(),
      'cr_inicial'                        => new sfWidgetFormInputText(),
      'dia_rec_diuresis'                  => new sfWidgetFormInputText(),
      'dia_rec_funcional'                 => new sfWidgetFormInputText(),
      'dialisis'                          => new sfWidgetFormInputText(),
      'num_de_hd'                         => new sfWidgetFormInputText(),
      'comentario'                        => new sfWidgetFormInputText(),
      'fecha_alta'                        => new sfWidgetFormDate(),
      'edad_receptor'                     => new sfWidgetFormInputText(),
      'created_at'                        => new sfWidgetFormDateTime(),
      'updated_at'                        => new sfWidgetFormDateTime(),
    ));

    $this->setValidators(array(
      'id'                                => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'paciente_pre_trasplante_id'        => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Pacientepretrasplante'))),
      'fecha'                             => new sfValidatorDate(),
      'numero_de_transplantes_realizados' => new sfValidatorInteger(array('required' => false)),
      'donante_id'                        => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Donante'))),
      'inestab_hemodial'                  => new sfValidatorInteger(array('required' => false)),
      'rinhon'                            => new sfValidatorString(array('max_length' => 10, 'required' => false)),
      'anomalia_vascular'                 => new sfValidatorInteger(array('required' => false)),
      'numero_arterias'                   => new sfValidatorInteger(array('required' => false)),
      'numero_venas'                      => new sfValidatorInteger(array('required' => false)),
      'ureter'                            => new sfValidatorString(array('max_length' => 5, 'required' => false)),
      'numero_compatibilidad_ab'          => new sfValidatorInteger(array('required' => false)),
      'numero_compatibilidad_dr'          => new sfValidatorInteger(array('required' => false)),
      'numero_incompatibilidad_ab'        => new sfValidatorInteger(array('required' => false)),
      'numero_incompatibilidad_dr'        => new sfValidatorInteger(array('required' => false)),
      'autoac'                            => new sfValidatorInteger(array('required' => false)),
      'pra_max'                           => new sfValidatorString(array('max_length' => 10, 'required' => false)),
      'pra_tr'                            => new sfValidatorString(array('max_length' => 20, 'required' => false)),
      'trans_previas'                     => new sfValidatorInteger(array('required' => false)),
      'numero_transf'                     => new sfValidatorInteger(array('required' => false)),
      'embarazo'                          => new sfValidatorChoice(array('choices' => array(0 => 'si', 1 => 'no', 2 => 'no aplica'), 'required' => false)),
      'numero_embarazo'                   => new sfValidatorInteger(array('required' => false)),
      'liquido_perfusion'                 => new sfValidatorChoice(array('choices' => array(0 => 'Eurocollins', 1 => 'WC', 2 => 'Custodiol', 3 => 'Otro'))),
      'tq_de_banco'                       => new sfValidatorInteger(array('required' => false)),
      'lado_implante'                     => new sfValidatorChoice(array('choices' => array(0 => 'Derecho', 1 => 'Izquierdo'))),
      'anast_venosa'                      => new sfValidatorChoice(array('choices' => array(0 => 'Termino lateral', 1 => 'Termino terminal', 2 => 'otra'))),
      'anast_arterial'                    => new sfValidatorChoice(array('choices' => array(0 => 'Termino lateral', 1 => 'Termino terminal', 2 => 'otra'))),
      'anast_ureteral'                    => new sfValidatorChoice(array('choices' => array(0 => 'Alferez', 1 => 'Taguchi', 2 => 'Gregoire', 3 => 'Lick', 4 => 'Otra'))),
      't_isq_cal_min'                     => new sfValidatorInteger(array('required' => false)),
      't_isq_fria_hs'                     => new sfValidatorInteger(array('required' => false)),
      't_isq_fria_min'                    => new sfValidatorInteger(array('required' => false)),
      't_isq_tibia_hs'                    => new sfValidatorInteger(array('required' => false)),
      'reperfusion'                       => new sfValidatorChoice(array('choices' => array(0 => 'buena', 1 => 'regular', 2 => 'mala'))),
      'sangrado_i_op'                     => new sfValidatorInteger(array('required' => false)),
      'lesion_arterial'                   => new sfValidatorInteger(array('required' => false)),
      'lesion_venosa'                     => new sfValidatorInteger(array('required' => false)),
      'necesidad_repefundir'              => new sfValidatorInteger(array('required' => false)),
      'otras_compl_quirur'                => new sfValidatorString(array('max_length' => 250, 'required' => false)),
      'diuresis_i_op'                     => new sfValidatorInteger(array('required' => false)),
      'cr_inicial'                        => new sfValidatorNumber(array('required' => false)),
      'dia_rec_diuresis'                  => new sfValidatorInteger(array('required' => false)),
      'dia_rec_funcional'                 => new sfValidatorInteger(array('required' => false)),
      'dialisis'                          => new sfValidatorInteger(array('required' => false)),
      'num_de_hd'                         => new sfValidatorInteger(array('required' => false)),
      'comentario'                        => new sfValidatorString(array('max_length' => 255, 'required' => false)),
      'fecha_alta'                        => new sfValidatorDate(array('required' => false)),
      'edad_receptor'                     => new sfValidatorInteger(array('required' => false)),
      'created_at'                        => new sfValidatorDateTime(),
      'updated_at'                        => new sfValidatorDateTime(),
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
