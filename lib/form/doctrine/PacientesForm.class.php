<?php

/**
 * Pacientes form.
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormTemplate.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class PacientesForm extends BasePacientesForm {

    public function configure() {
        unset($this["the"]);
        //$years = range(1920, date('Y'));
        $years = range(1920, date('Y')+ 1);
        $years = (array_combine($years, $years));

        $this->widgetSchema['fecha_nacimiento'] = new sfWidgetFormDate(
                        array(
                            'format' => '%year% %month% %day%',
                            'years' => $years));

        $this->widgetSchema['fecha_dialisis'] = new sfWidgetFormDate(
                        array(
                            'format' => '%year% %month% %day%',
                            'years' => $years));


        //post validator check to make sure end date > start date
        /*
		$this->validatorSchema->setPostValidator(
                new sfValidatorAnd(array(
                    new sfValidatorSchemaCompare('fecha_nacimiento', '<', 'fecha_dialisis',
                            array('throw_global_error' => true),
                            array('invalid' => 'La fecha de nacimiento ("%fecha_nacimiento%") no puede ser mayor que la de dialisis ("%fecha_dialisis%")<br />')
                        )
                    )
                )
        );
		*/
    }

}
