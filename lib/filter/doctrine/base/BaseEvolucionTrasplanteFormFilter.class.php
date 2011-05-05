<?php

/**
 * EvolucionTrasplante filter form base class.
 *
 * @package    transplantes
 * @subpackage filter
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormFilterGeneratedTemplate.php 29570 2010-05-21 14:49:47Z Kris.Wallsmith $
 */
abstract class BaseEvolucionTrasplanteFormFilter extends BaseFormFilterDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'pas'          => new sfWidgetFormFilterInput(),
      'pad'          => new sfWidgetFormFilterInput(),
      'diuresis'     => new sfWidgetFormFilterInput(),
      'peso'         => new sfWidgetFormFilterInput(),
      'urea'         => new sfWidgetFormFilterInput(),
      'creatinina'   => new sfWidgetFormFilterInput(),
      'ht'           => new sfWidgetFormFilterInput(),
      'hb'           => new sfWidgetFormFilterInput(),
      'gb'           => new sfWidgetFormFilterInput(),
      'plaquetas'    => new sfWidgetFormFilterInput(),
      'sodio'        => new sfWidgetFormFilterInput(),
      'potasio'      => new sfWidgetFormFilterInput(),
      'cloro'        => new sfWidgetFormFilterInput(),
      'calcio'       => new sfWidgetFormFilterInput(),
      'fosforo'      => new sfWidgetFormFilterInput(),
      'glicemia'     => new sfWidgetFormFilterInput(),
      'uricemia'     => new sfWidgetFormFilterInput(),
      'prot_u'       => new sfWidgetFormFilterInput(),
      'ccreatinina'  => new sfWidgetFormFilterInput(),
      'curea'        => new sfWidgetFormFilterInput(),
      'na_u'         => new sfWidgetFormFilterInput(),
      'k_u'          => new sfWidgetFormFilterInput(),
      'cya_pv'       => new sfWidgetFormFilterInput(),
      'cya_pp'       => new sfWidgetFormFilterInput(),
      'fk_p'         => new sfWidgetFormFilterInput(),
      'mfm_p'        => new sfWidgetFormFilterInput(),
      'eve_p'        => new sfWidgetFormFilterInput(),
      'bd'           => new sfWidgetFormFilterInput(),
      'bi'           => new sfWidgetFormFilterInput(),
      'tgo'          => new sfWidgetFormFilterInput(),
      'tgp'          => new sfWidgetFormFilterInput(),
      'gammagt'      => new sfWidgetFormFilterInput(),
      'f_alc'        => new sfWidgetFormFilterInput(),
      't_prot'       => new sfWidgetFormFilterInput(),
      'kptt'         => new sfWidgetFormFilterInput(),
      'howell'       => new sfWidgetFormFilterInput(),
      'fibrinogeno'  => new sfWidgetFormFilterInput(),
      'colesterol'   => new sfWidgetFormFilterInput(),
      'hdl'          => new sfWidgetFormFilterInput(),
      'ldl'          => new sfWidgetFormFilterInput(),
      'r_at'         => new sfWidgetFormFilterInput(),
      'tg'           => new sfWidgetFormFilterInput(),
      'hna1c'        => new sfWidgetFormFilterInput(),
      'albumina'     => new sfWidgetFormFilterInput(),
      'globulinas'   => new sfWidgetFormFilterInput(),
      'pthi'         => new sfWidgetFormFilterInput(),
      'otros'        => new sfWidgetFormFilterInput(),
      'numpthi'      => new sfWidgetFormFilterInput(),
    ));

    $this->setValidators(array(
      'pas'          => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'pad'          => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'diuresis'     => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'peso'         => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'urea'         => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'creatinina'   => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'ht'           => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'hb'           => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'gb'           => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'plaquetas'    => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'sodio'        => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'potasio'      => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'cloro'        => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'calcio'       => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'fosforo'      => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'glicemia'     => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'uricemia'     => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'prot_u'       => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'ccreatinina'  => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'curea'        => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'na_u'         => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'k_u'          => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'cya_pv'       => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'cya_pp'       => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'fk_p'         => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'mfm_p'        => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'eve_p'        => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'bd'           => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'bi'           => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'tgo'          => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'tgp'          => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'gammagt'      => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'f_alc'        => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      't_prot'       => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'kptt'         => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'howell'       => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'fibrinogeno'  => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'colesterol'   => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'hdl'          => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'ldl'          => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'r_at'         => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'tg'           => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'hna1c'        => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'albumina'     => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'globulinas'   => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
      'pthi'         => new sfValidatorPass(array('required' => false)),
      'otros'        => new sfValidatorPass(array('required' => false)),
      'numpthi'      => new sfValidatorSchemaFilter('text', new sfValidatorNumber(array('required' => false))),
    ));

    $this->widgetSchema->setNameFormat('evolucion_trasplante_filters[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'EvolucionTrasplante';
  }

  public function getFields()
  {
    return array(
      'idtrasplante' => 'Number',
      'fecha'        => 'Date',
      'pas'          => 'Number',
      'pad'          => 'Number',
      'diuresis'     => 'Number',
      'peso'         => 'Number',
      'urea'         => 'Number',
      'creatinina'   => 'Number',
      'ht'           => 'Number',
      'hb'           => 'Number',
      'gb'           => 'Number',
      'plaquetas'    => 'Number',
      'sodio'        => 'Number',
      'potasio'      => 'Number',
      'cloro'        => 'Number',
      'calcio'       => 'Number',
      'fosforo'      => 'Number',
      'glicemia'     => 'Number',
      'uricemia'     => 'Number',
      'prot_u'       => 'Number',
      'ccreatinina'  => 'Number',
      'curea'        => 'Number',
      'na_u'         => 'Number',
      'k_u'          => 'Number',
      'cya_pv'       => 'Number',
      'cya_pp'       => 'Number',
      'fk_p'         => 'Number',
      'mfm_p'        => 'Number',
      'eve_p'        => 'Number',
      'bd'           => 'Number',
      'bi'           => 'Number',
      'tgo'          => 'Number',
      'tgp'          => 'Number',
      'gammagt'      => 'Number',
      'f_alc'        => 'Number',
      't_prot'       => 'Number',
      'kptt'         => 'Number',
      'howell'       => 'Number',
      'fibrinogeno'  => 'Number',
      'colesterol'   => 'Number',
      'hdl'          => 'Number',
      'ldl'          => 'Number',
      'r_at'         => 'Number',
      'tg'           => 'Number',
      'hna1c'        => 'Number',
      'albumina'     => 'Number',
      'globulinas'   => 'Number',
      'pthi'         => 'Text',
      'otros'        => 'Text',
      'numpthi'      => 'Number',
    );
  }
}
