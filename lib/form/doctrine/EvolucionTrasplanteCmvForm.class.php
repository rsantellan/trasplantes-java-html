<?php

/**
 * EvolucionTrasplanteCmv form.
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormTemplate.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class EvolucionTrasplanteCmvForm extends BaseEvolucionTrasplanteCmvForm {

    public function configure() {
        $this->widgetSchema['trasplante_id'] = new sfWidgetFormInputHidden();

        $this->widgetSchema['igg_cmv'] = new sfWidgetFormChoice(array(
                    'expanded' => true,
                    'choices' => datosBasicosHandler::yesOrNoChoicesOptions(),
                ));
        $this->widgetSchema['igm_cmv'] = new sfWidgetFormChoice(array(
                    'expanded' => true,
                    'choices' => datosBasicosHandler::yesOrNoChoicesOptions(),
                ));
        $this->widgetSchema['pcr_cmv'] = new sfWidgetFormChoice(array(
                    'expanded' => true,
                    'choices' => datosBasicosHandler::yesOrNoChoicesOptions(),
                ));
        $this->widgetSchema['ag_pp65'] = new sfWidgetFormChoice(array(
                    'expanded' => true,
                    'choices' => datosBasicosHandler::yesOrNoChoicesOptions(),
                ));
        $this->setDefault('igg_cmv', 0);
        $this->setDefault('igm_cmv', 0);
        $this->setDefault('pcr_cmv', 0);
        $this->setDefault('ag_pp65', 0);
        
        $trasplante_id = $this->getObject()->getTrasplanteId();
        $trasplante = trasplanteHandler::retriveById($trasplante_id, Doctrine_Core::HYDRATE_ARRAY);
        $age = mdBasicFunction::calculateAge($trasplante["fecha"], true);
        $years = range(date('Y') - $age,date('Y'));
        $years = array_combine($years, $years);

        $this->widgetSchema['fecha'] = new sfWidgetFormDate(
                                  array(
                                    'format' => '%year% %month% %day%',
                                    'years' => $years));
    }

}
