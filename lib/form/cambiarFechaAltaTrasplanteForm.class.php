<?php

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Cambiar la fecha de alta del trasplante
 *
 * @author Rodrigo Santellan
 */
class cambiarFechaAltaTrasplanteForm extends sfForm 
{
  public function configure()
  {
    //var_dump($this->getDefaults());
    
    //$this->widgetSchema['id'] = new sfWidgetFormInputHidden();
    $defaults = $this->getDefaults();
    $id = $defaults["id"];
    $trasplante = trasplanteHandler::retriveById($id, Doctrine_Core::HYDRATE_ARRAY );
    $age = mdBasicFunction::calculateAge($trasplante["fecha"], true);
    $years = range(date('Y') - $age,date('Y'));
    $years = array_combine($years, $years);
    $pacientes = array();
    $this->setWidgets(array(
        'id'  => new sfWidgetFormInputHidden(),
        'fecha'    => new sfWidgetFormDate(
                              array(
                                'format' => '%year% %month% %day%',
                                'years' => $years))
    ));

    $error_message = array(
    'required'=>'Requerido.',
    'invalid' => 'Email invalido.'
    );

    $this->setValidators(array(
        'id'    => new sfValidatorPass(array('required' => true),$error_message),
        'fecha'    => new sfValidatorDate(array('required' => true),$error_message)
    ));

    $this->widgetSchema->setNameFormat('cambiarFechaAltaTrasplante[%s]');

  }  
  
  public function save($con = null) 
  {
    $tainted = $this->getTaintedValues();
    var_dump($tainted);
    $fecha = $tainted["fecha"];
    $date = date("Y-m-d", mktime(0, 0, 0, $fecha["month"], $fecha["day"], $fecha["year"]));
    $trasplante = trasplanteHandler::retriveById($tainted["id"]);
    $trasplante->setFechaAlta($date);
    $trasplante->save();
    die;
    
  }
  
  //$this->getErrorSchema()->addError(new sfValidatorError(new sfValidatorSchema(), __('Please reenter the new password.')), 'password');
}

  
