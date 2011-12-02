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
      'inestab_hemodial'                  => new sfWidgetFormInputCheckbox(),
      'rinhon'                            => new sfWidgetFormChoice(array('choices' => array('Derecho' => 'Derecho', 'Izquierdo' => 'Izquierdo'))),
      'anomalia_vascular'                 => new sfWidgetFormInputCheckbox(),
      'numero_arterias'                   => new sfWidgetFormChoice(array('choices' => array(1 => '1', 2 => '2', 3 => '3'))),
      'numero_venas'                      => new sfWidgetFormChoice(array('choices' => array(1 => '1', 2 => '2', 3 => '3'))),
      'ureter'                            => new sfWidgetFormChoice(array('choices' => array('Unico' => 'Unico', 'Doble' => 'Doble'))),
      'numero_compatibilidad_ab'          => new sfWidgetFormInputText(),
      'numero_compatibilidad_dr'          => new sfWidgetFormInputText(),
      'numero_incompatibilidad_ab'        => new sfWidgetFormInputText(),
      'numero_incompatibilidad_dr'        => new sfWidgetFormInputText(),
      'autoac'                            => new sfWidgetFormInputCheckbox(),
      'pra_max'                           => new sfWidgetFormInputText(),
      'pra_tr'                            => new sfWidgetFormInputText(),
      'trans_previas'                     => new sfWidgetFormInputCheckbox(),
      'numero_transf'                     => new sfWidgetFormInputText(),
      'embarazo'                          => new sfWidgetFormChoice(array('choices' => array('si' => 'si', 'no' => 'no', 'no aplica' => 'no aplica'))),
      'numero_embarazo'                   => new sfWidgetFormInputText(),
      'liquido_perfusion'                 => new sfWidgetFormChoice(array('choices' => array('Eurocollins' => 'Eurocollins', 'WC' => 'WC', 'Custodiol' => 'Custodiol', 'Otro' => 'Otro'))),
      'tq_de_banco'                       => new sfWidgetFormInputCheckbox(),
      'lado_implante'                     => new sfWidgetFormChoice(array('choices' => array('Derecho' => 'Derecho', 'Izquierdo' => 'Izquierdo'))),
      'anast_venosa'                      => new sfWidgetFormChoice(array('choices' => array('Termino lateral' => 'Termino lateral', 'Termino terminal' => 'Termino terminal', 'otra' => 'otra'))),
      'anast_arterial'                    => new sfWidgetFormChoice(array('choices' => array('Termino lateral' => 'Termino lateral', 'Termino terminal' => 'Termino terminal', 'otra' => 'otra'))),
      'anast_ureteral'                    => new sfWidgetFormChoice(array('choices' => array('Alferez' => 'Alferez', 'Taguchi' => 'Taguchi', 'Gregoire' => 'Gregoire', 'Lick' => 'Lick', 'Otra' => 'Otra'))),
      't_isq_cal_min'                     => new sfWidgetFormInputText(),
      't_isq_fria_hs'                     => new sfWidgetFormInputText(),
      't_isq_fria_min'                    => new sfWidgetFormInputText(),
      't_isq_tibia_hs'                    => new sfWidgetFormInputText(),
      'reperfusion'                       => new sfWidgetFormChoice(array('choices' => array('buena' => 'buena', 'regular' => 'regular', 'mala' => 'mala'))),
      'sangrado_i_op'                     => new sfWidgetFormInputCheckbox(),
      'lesion_arterial'                   => new sfWidgetFormInputCheckbox(),
      'lesion_venosa'                     => new sfWidgetFormInputCheckbox(),
      'necesidad_repefundir'              => new sfWidgetFormInputCheckbox(),
      'otras_compl_quirur'                => new sfWidgetFormInputText(),
      'diuresis_i_op'                     => new sfWidgetFormInputCheckbox(),
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
      'trasplante_inducciones_list'       => new sfWidgetFormDoctrineChoice(array('multiple' => true, 'model' => 'Induccion')),
      'trasplante_inmunosupresores_list'  => new sfWidgetFormDoctrineChoice(array('multiple' => true, 'model' => 'Inmunosupresores')),
    ));

    $this->setValidators(array(
      'id'                                => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'paciente_pre_trasplante_id'        => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Pacientepretrasplante'))),
      'fecha'                             => new sfValidatorDate(),
      'numero_de_transplantes_realizados' => new sfValidatorInteger(array('required' => false)),
      'donante_id'                        => new sfValidatorDoctrineChoice(array('model' => $this->getRelatedModelName('Donante'))),
      'inestab_hemodial'                  => new sfValidatorBoolean(array('required' => false)),
      'rinhon'                            => new sfValidatorChoice(array('choices' => array(0 => 'Derecho', 1 => 'Izquierdo'))),
      'anomalia_vascular'                 => new sfValidatorBoolean(array('required' => false)),
      'numero_arterias'                   => new sfValidatorChoice(array('choices' => array(0 => '1', 1 => '2', 2 => '3'))),
      'numero_venas'                      => new sfValidatorChoice(array('choices' => array(0 => '1', 1 => '2', 2 => '3'))),
      'ureter'                            => new sfValidatorChoice(array('choices' => array(0 => 'Unico', 1 => 'Doble'))),
      'numero_compatibilidad_ab'          => new sfValidatorInteger(array('required' => false)),
      'numero_compatibilidad_dr'          => new sfValidatorInteger(array('required' => false)),
      'numero_incompatibilidad_ab'        => new sfValidatorInteger(array('required' => false)),
      'numero_incompatibilidad_dr'        => new sfValidatorInteger(array('required' => false)),
      'autoac'                            => new sfValidatorBoolean(array('required' => false)),
      'pra_max'                           => new sfValidatorString(array('max_length' => 10, 'required' => false)),
      'pra_tr'                            => new sfValidatorString(array('max_length' => 20, 'required' => false)),
      'trans_previas'                     => new sfValidatorBoolean(array('required' => false)),
      'numero_transf'                     => new sfValidatorInteger(array('required' => false)),
      'embarazo'                          => new sfValidatorChoice(array('choices' => array(0 => 'si', 1 => 'no', 2 => 'no aplica'), 'required' => false)),
      'numero_embarazo'                   => new sfValidatorInteger(array('required' => false)),
      'liquido_perfusion'                 => new sfValidatorChoice(array('choices' => array(0 => 'Eurocollins', 1 => 'WC', 2 => 'Custodiol', 3 => 'Otro'))),
      'tq_de_banco'                       => new sfValidatorBoolean(array('required' => false)),
      'lado_implante'                     => new sfValidatorChoice(array('choices' => array(0 => 'Derecho', 1 => 'Izquierdo'))),
      'anast_venosa'                      => new sfValidatorChoice(array('choices' => array(0 => 'Termino lateral', 1 => 'Termino terminal', 2 => 'otra'))),
      'anast_arterial'                    => new sfValidatorChoice(array('choices' => array(0 => 'Termino lateral', 1 => 'Termino terminal', 2 => 'otra'))),
      'anast_ureteral'                    => new sfValidatorChoice(array('choices' => array(0 => 'Alferez', 1 => 'Taguchi', 2 => 'Gregoire', 3 => 'Lick', 4 => 'Otra'))),
      't_isq_cal_min'                     => new sfValidatorInteger(array('required' => false)),
      't_isq_fria_hs'                     => new sfValidatorInteger(array('required' => false)),
      't_isq_fria_min'                    => new sfValidatorInteger(array('required' => false)),
      't_isq_tibia_hs'                    => new sfValidatorInteger(array('required' => false)),
      'reperfusion'                       => new sfValidatorChoice(array('choices' => array(0 => 'buena', 1 => 'regular', 2 => 'mala'))),
      'sangrado_i_op'                     => new sfValidatorBoolean(array('required' => false)),
      'lesion_arterial'                   => new sfValidatorBoolean(array('required' => false)),
      'lesion_venosa'                     => new sfValidatorBoolean(array('required' => false)),
      'necesidad_repefundir'              => new sfValidatorBoolean(array('required' => false)),
      'otras_compl_quirur'                => new sfValidatorString(array('max_length' => 250, 'required' => false)),
      'diuresis_i_op'                     => new sfValidatorBoolean(array('required' => false)),
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
      'trasplante_inducciones_list'       => new sfValidatorDoctrineChoice(array('multiple' => true, 'model' => 'Induccion', 'required' => false)),
      'trasplante_inmunosupresores_list'  => new sfValidatorDoctrineChoice(array('multiple' => true, 'model' => 'Inmunosupresores', 'required' => false)),
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

  public function updateDefaultsFromObject()
  {
    parent::updateDefaultsFromObject();

    if (isset($this->widgetSchema['trasplante_inducciones_list']))
    {
      $this->setDefault('trasplante_inducciones_list', $this->object->TrasplanteInducciones->getPrimaryKeys());
    }

    if (isset($this->widgetSchema['trasplante_inmunosupresores_list']))
    {
      $this->setDefault('trasplante_inmunosupresores_list', $this->object->TrasplanteInmunosupresores->getPrimaryKeys());
    }

  }

  protected function doSave($con = null)
  {
    $this->saveTrasplanteInduccionesList($con);
    $this->saveTrasplanteInmunosupresoresList($con);

    parent::doSave($con);
  }

  public function saveTrasplanteInduccionesList($con = null)
  {
    if (!$this->isValid())
    {
      throw $this->getErrorSchema();
    }

    if (!isset($this->widgetSchema['trasplante_inducciones_list']))
    {
      // somebody has unset this widget
      return;
    }

    if (null === $con)
    {
      $con = $this->getConnection();
    }

    $existing = $this->object->TrasplanteInducciones->getPrimaryKeys();
    $values = $this->getValue('trasplante_inducciones_list');
    if (!is_array($values))
    {
      $values = array();
    }

    $unlink = array_diff($existing, $values);
    if (count($unlink))
    {
      $this->object->unlink('TrasplanteInducciones', array_values($unlink));
    }

    $link = array_diff($values, $existing);
    if (count($link))
    {
      $this->object->link('TrasplanteInducciones', array_values($link));
    }
  }

  public function saveTrasplanteInmunosupresoresList($con = null)
  {
    if (!$this->isValid())
    {
      throw $this->getErrorSchema();
    }

    if (!isset($this->widgetSchema['trasplante_inmunosupresores_list']))
    {
      // somebody has unset this widget
      return;
    }

    if (null === $con)
    {
      $con = $this->getConnection();
    }

    $existing = $this->object->TrasplanteInmunosupresores->getPrimaryKeys();
    $values = $this->getValue('trasplante_inmunosupresores_list');
    if (!is_array($values))
    {
      $values = array();
    }

    $unlink = array_diff($existing, $values);
    if (count($unlink))
    {
      $this->object->unlink('TrasplanteInmunosupresores', array_values($unlink));
    }

    $link = array_diff($values, $existing);
    if (count($link))
    {
      $this->object->link('TrasplanteInmunosupresores', array_values($link));
    }
  }

}
