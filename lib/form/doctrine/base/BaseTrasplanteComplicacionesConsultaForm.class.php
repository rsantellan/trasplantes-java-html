<?php

/**
 * TrasplanteComplicacionesConsulta form base class.
 *
 * @method TrasplanteComplicacionesConsulta getObject() Returns the current form's model object
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormGeneratedTemplate.php 29553 2010-05-20 14:33:00Z Kris.Wallsmith $
 */
abstract class BaseTrasplanteComplicacionesConsultaForm extends BaseFormDoctrine
{
  public function setup()
  {
    $this->setWidgets(array(
      'id'                     => new sfWidgetFormInputHidden(),
      'trasplante_id'          => new sfWidgetFormInputText(),
      'complicacion_id'        => new sfWidgetFormInputText(),
      'complicacion_class'     => new sfWidgetFormInputText(),
      'dias_desde_trasplante'  => new sfWidgetFormInputText(),
      'meses_desde_trasplante' => new sfWidgetFormInputText(),
      'years_desde_trasplante' => new sfWidgetFormInputText(),
    ));

    $this->setValidators(array(
      'id'                     => new sfValidatorChoice(array('choices' => array($this->getObject()->get('id')), 'empty_value' => $this->getObject()->get('id'), 'required' => false)),
      'trasplante_id'          => new sfValidatorInteger(),
      'complicacion_id'        => new sfValidatorInteger(),
      'complicacion_class'     => new sfValidatorString(array('max_length' => 50)),
      'dias_desde_trasplante'  => new sfValidatorInteger(),
      'meses_desde_trasplante' => new sfValidatorInteger(),
      'years_desde_trasplante' => new sfValidatorInteger(),
    ));

    $this->widgetSchema->setNameFormat('trasplante_complicaciones_consulta[%s]');

    $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);

    $this->setupInheritance();

    parent::setup();
  }

  public function getModelName()
  {
    return 'TrasplanteComplicacionesConsulta';
  }

}
