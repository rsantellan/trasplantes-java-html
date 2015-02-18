<?php

/**
 * Tratamiento form.
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormTemplate.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class TratamientoForm extends BaseTratamientoForm
{
  public function configure()
  {
    unset($this["fecha_fin"]);
    $paciente_id = $this->getObject()->getPacienteId();
    $paciente = PacienteHandler::retriveById($paciente_id, Doctrine_Core::HYDRATE_ARRAY);
    $this->widgetSchema['paciente_id'] = new sfWidgetFormInputHidden();
    $age = mdBasicFunction::calculateAge($paciente["fecha_dialisis"], true);
    $fechaData = explode('-', $paciente["fecha_dialisis"]);
    $years = range((int) $fechaData[0] - $age, date('Y') + 1);
    $years = range(date('Y') - $age,date('Y'));
    $years = array_combine($years, $years);

    $this->widgetSchema['fecha'] = new sfWidgetFormDate(
                  array(
                    'format' => '%year% %month% %day%',
                    'years' => $years));
  }
}
