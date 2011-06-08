<?php

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of buscarPaciente
 *
 * @author Rodrigo Santellan
 */
class buscarPacienteForm extends sfForm 
{
public function configure()
  {
	$pacientes = PacienteHandler::retrieveAllPacientesNamesArray();
    $this->setWidgets(array(
        'nombre'    => new sfWidgetFormChoiceAutocompleteComboBox(array(
                'choices' => $pacientes
					))
    ));

    $error_message = array(
    'required'=>'Requerido.',
    'invalid' => 'Email invalido.'
    );

    $this->setValidators(array(
        'nombre'    => new sfValidatorPass(array('required' => false),$error_message)
    ));

    $this->widgetSchema->setNameFormat('buscarPaciente[%s]');

  }  
  
}


