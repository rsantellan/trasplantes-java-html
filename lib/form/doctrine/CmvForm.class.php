<?php

/**
 * Cmv form.
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormTemplate.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class CmvForm extends BaseCmvForm 
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
        $this->widgetSchema['tipo'] = new sfWidgetFormChoice(array(
                    'expanded' => false,
                    'choices' => datosBasicosHandler::cmvChoicesOptions(),
                ));
        $this->setDefault('tipo', 0);
        $this->widgetSchema['cmv_emfermedades_list'] = new sfWidgetFormDoctrineChoice(array('multiple' => true, 'model' => 'Cmvemfermedades', 'expanded' => true));
    }

}
