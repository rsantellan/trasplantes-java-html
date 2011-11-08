<?php

/**
 * EvolucionTrasplanteTxtorax form.
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormTemplate.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class EvolucionTrasplanteTxtoraxForm extends BaseEvolucionTrasplanteTxtoraxForm
{
  public function configure()
  {
    $this->widgetSchema['trasplante_id'] = new sfWidgetFormInputHidden();
    $trasplante_id = $this->getObject()->getTrasplanteId();
    $trasplante = trasplanteHandler::retriveById($trasplante_id, Doctrine_Core::HYDRATE_ARRAY);
    $age = mdBasicFunction::calculateAge($trasplante["fecha"], true);
    $years = range(date('Y') - $age, date('Y'));
    $years = array_combine($years, $years);

    $this->widgetSchema['fecha'] = new sfWidgetFormDate(
        array(
            'format' => '%year% %month% %day%',
            'years' => $years));
    $this->widgetSchema['foco'] = new sfWidgetFormChoice(array(
                    'expanded' => true,
                    'choices' => datosBasicosHandler::yesOrNoChoicesOptions(),
                ));
    $this->widgetSchema['derrame_pleural'] = new sfWidgetFormChoice(array(
                    'expanded' => true,
                    'choices' => datosBasicosHandler::yesOrNoChoicesOptions(),
                ));
    $this->widgetSchema['secuelas'] = new sfWidgetFormChoice(array(
                    'expanded' => true,
                    'choices' => datosBasicosHandler::yesOrNoChoicesOptions(),
                ));
    $this->setDefault("foco", 0);
    $this->setDefault("derrame_pleural", 0);
    $this->setDefault("secuelas", 0);
    $this->widgetSchema['otros'] = new sfWidgetFormTextarea();
  }
}
