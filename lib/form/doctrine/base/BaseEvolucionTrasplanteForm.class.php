<?php

/**
 * EvolucionTrasplante form base class.
 *
 * @method EvolucionTrasplante getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseEvolucionTrasplanteForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'idtrasplante' => new sfWidgetFormInputHidden(),
      'fecha'        => new sfWidgetFormInputHidden(),
      'pas'          => new sfWidgetFormInputText(),
      'pad'          => new sfWidgetFormInputText(),
      'diuresis'     => new sfWidgetFormInputText(),
      'peso'         => new sfWidgetFormInputText(),
      'urea'         => new sfWidgetFormInputText(),
      'creatinina'   => new sfWidgetFormInputText(),
      'ht'           => new sfWidgetFormInputText(),
      'hb'           => new sfWidgetFormInputText(),
      'gb'           => new sfWidgetFormInputText(),
      'plaquetas'    => new sfWidgetFormInputText(),
      'sodio'        => new sfWidgetFormInputText(),
      'potasio'      => new sfWidgetFormInputText(),
      'cloro'        => new sfWidgetFormInputText(),
      'calcio'       => new sfWidgetFormInputText(),
      'fosforo'      => new sfWidgetFormInputText(),
      'glicemia'     => new sfWidgetFormInputText(),
      'uricemia'     => new sfWidgetFormInputText(),
      'prot_u'       => new sfWidgetFormInputText(),
      'ccreatinina'  => new sfWidgetFormInputText(),
      'curea'        => new sfWidgetFormInputText(),
      'na_u'         => new sfWidgetFormInputText(),
      'k_u'          => new sfWidgetFormInputText(),
      'cya_pv'       => new sfWidgetFormInputText(),
      'cya_pp'       => new sfWidgetFormInputText(),
      'fk_p'         => new sfWidgetFormInputText(),
      'mfm_p'        => new sfWidgetFormInputText(),
      'eve_p'        => new sfWidgetFormInputText(),
      'bd'           => new sfWidgetFormInputText(),
      'bi'           => new sfWidgetFormInputText(),
      'tgo'          => new sfWidgetFormInputText(),
      'tgp'          => new sfWidgetFormInputText(),
      'gammagt'      => new sfWidgetFormInputText(),
      'f_alc'        => new sfWidgetFormInputText(),
      't_prot'       => new sfWidgetFormInputText(),
      'kptt'         => new sfWidgetFormInputText(),
      'howell'       => new sfWidgetFormInputText(),
      'fibrinogeno'  => new sfWidgetFormInputText(),
      'colesterol'   => new sfWidgetFormInputText(),
      'hdl'          => new sfWidgetFormInputText(),
      'ldl'          => new sfWidgetFormInputText(),
      'r_at'         => new sfWidgetFormInputText(),
      'tg'           => new sfWidgetFormInputText(),
      'hna1c'        => new sfWidgetFormInputText(),
      'albumina'     => new sfWidgetFormInputText(),
      'globulinas'   => new sfWidgetFormInputText(),
      'pthi'         => new sfWidgetFormInputText(),
      'otros'        => new sfWidgetFormInputText(),
      'numpthi'      => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'idtrasplante' => new sfValidatorChoice(array('choices' => array($this->getObject()->get('idtrasplante')), 'empty_value' => $this->getObject()->get('idtrasplante'), 'required' => false)),
      'fecha'        => new sfValidatorChoice(array('choices' => array($this->getObject()->get('fecha')), 'empty_value' => $this->getObject()->get('fecha'), 'required' => false)),
      'pas'          => new sfValidatorNumber(array('required' => false)),
      'pad'          => new sfValidatorNumber(array('required' => false)),
      'diuresis'     => new sfValidatorNumber(array('required' => false)),
      'peso'         => new sfValidatorNumber(array('required' => false)),
      'urea'         => new sfValidatorNumber(array('required' => false)),
      'creatinina'   => new sfValidatorNumber(array('required' => false)),
      'ht'           => new sfValidatorNumber(array('required' => false)),
      'hb'           => new sfValidatorNumber(array('required' => false)),
      'gb'           => new sfValidatorNumber(array('required' => false)),
      'plaquetas'    => new sfValidatorNumber(array('required' => false)),
      'sodio'        => new sfValidatorNumber(array('required' => false)),
      'potasio'      => new sfValidatorNumber(array('required' => false)),
      'cloro'        => new sfValidatorNumber(array('required' => false)),
      'calcio'       => new sfValidatorNumber(array('required' => false)),
      'fosforo'      => new sfValidatorNumber(array('required' => false)),
      'glicemia'     => new sfValidatorNumber(array('required' => false)),
      'uricemia'     => new sfValidatorNumber(array('required' => false)),
      'prot_u'       => new sfValidatorNumber(array('required' => false)),
      'ccreatinina'  => new sfValidatorNumber(array('required' => false)),
      'curea'        => new sfValidatorNumber(array('required' => false)),
      'na_u'         => new sfValidatorNumber(array('required' => false)),
      'k_u'          => new sfValidatorNumber(array('required' => false)),
      'cya_pv'       => new sfValidatorNumber(array('required' => false)),
      'cya_pp'       => new sfValidatorNumber(array('required' => false)),
      'fk_p'         => new sfValidatorNumber(array('required' => false)),
      'mfm_p'        => new sfValidatorNumber(array('required' => false)),
      'eve_p'        => new sfValidatorNumber(array('required' => false)),
      'bd'           => new sfValidatorNumber(array('required' => false)),
      'bi'           => new sfValidatorNumber(array('required' => false)),
      'tgo'          => new sfValidatorNumber(array('required' => false)),
      'tgp'          => new sfValidatorNumber(array('required' => false)),
      'gammagt'      => new sfValidatorNumber(array('required' => false)),
      'f_alc'        => new sfValidatorNumber(array('required' => false)),
      't_prot'       => new sfValidatorNumber(array('required' => false)),
      'kptt'         => new sfValidatorNumber(array('required' => false)),
      'howell'       => new sfValidatorNumber(array('required' => false)),
      'fibrinogeno'  => new sfValidatorNumber(array('required' => false)),
      'colesterol'   => new sfValidatorNumber(array('required' => false)),
      'hdl'          => new sfValidatorNumber(array('required' => false)),
      'ldl'          => new sfValidatorNumber(array('required' => false)),
      'r_at'         => new sfValidatorNumber(array('required' => false)),
      'tg'           => new sfValidatorNumber(array('required' => false)),
      'hna1c'        => new sfValidatorNumber(array('required' => false)),
      'albumina'     => new sfValidatorNumber(array('required' => false)),
      'globulinas'   => new sfValidatorNumber(array('required' => false)),
      'pthi'         => new sfValidatorString(array('max_length' => 10, 'required' => false)),
      'otros'        => new sfValidatorString(array('max_length' => 255, 'required' => false)),
      'numpthi'      => new sfValidatorNumber(array('required' => false)),
    ));

    $this->widgetSchema->setNameFormat('evolucion_trasplante[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'EvolucionTrasplante';
  }

}
