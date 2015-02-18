<?php

/**
 * EvolucionTrasplanteParaclinica form.
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormTemplate.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class EvolucionTrasplanteParaclinicaForm extends BaseEvolucionTrasplanteParaclinicaForm
{
  public function configure()
  {
    $this->widgetSchema['trasplante_id'] = new sfWidgetFormInputHidden();
    $trasplante_id = $this->getObject()->getTrasplanteId();
    $trasplante = trasplanteHandler::retriveById($trasplante_id, Doctrine_Core::HYDRATE_ARRAY);
    $age = mdBasicFunction::calculateAge($trasplante["fecha"], true);
    $fechaData = explode('-', $trasplante["fecha"]);
    $years = range((int) $fechaData[0] - $age, date('Y')+ 1);
    $years = array_combine($years, $years);

    $this->widgetSchema['fecha'] = new sfWidgetFormDate(
        array(
            'format' => '%year% %month% %day%',
            'years' => $years));
    
    $this->widgetSchema['otros'] = new sfWidgetFormTextarea();
  }
}
