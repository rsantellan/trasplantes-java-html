<?php

/**
 * EvolucionTrasplanteEcoCardio form.
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormTemplate.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class EvolucionTrasplanteEcoCardioForm extends BaseEvolucionTrasplanteEcoCardioForm
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
        
        $this->widgetSchema['fevi_normal'] = new sfWidgetFormChoice(array(
                    'expanded' => true,
                    'choices' => datosBasicosHandler::yesOrNoChoicesOptions(),
                ));
        $this->widgetSchema['insuf_hipodiast'] = new sfWidgetFormChoice(array(
                    'expanded' => true,
                    'choices' => datosBasicosHandler::yesOrNoChoicesOptions(),
                ));
        $this->widgetSchema['iao'] = new sfWidgetFormChoice(array(
                    'expanded' => true,
                    'choices' => datosBasicosHandler::yesOrNoChoicesOptions(),
                ));
        $this->widgetSchema['eao'] = new sfWidgetFormChoice(array(
                    'expanded' => true,
                    'choices' => datosBasicosHandler::yesOrNoChoicesOptions(),
                ));
        $this->widgetSchema['im'] = new sfWidgetFormChoice(array(
                    'expanded' => true,
                    'choices' => datosBasicosHandler::yesOrNoChoicesOptions(),
                ));
        $this->widgetSchema['em'] = new sfWidgetFormChoice(array(
                    'expanded' => true,
                    'choices' => datosBasicosHandler::yesOrNoChoicesOptions(),
                ));
        $this->widgetSchema['ip'] = new sfWidgetFormChoice(array(
                    'expanded' => true,
                    'choices' => datosBasicosHandler::yesOrNoChoicesOptions(),
                ));
        $this->widgetSchema['ep'] = new sfWidgetFormChoice(array(
                    'expanded' => true,
                    'choices' => datosBasicosHandler::yesOrNoChoicesOptions(),
                ));
        $this->widgetSchema['it'] = new sfWidgetFormChoice(array(
                    'expanded' => true,
                    'choices' => datosBasicosHandler::yesOrNoChoicesOptions(),
                ));
        $this->widgetSchema['et'] = new sfWidgetFormChoice(array(
                    'expanded' => true,
                    'choices' => datosBasicosHandler::yesOrNoChoicesOptions(),
                ));
        $this->widgetSchema['derrame'] = new sfWidgetFormChoice(array(
                    'expanded' => true,
                    'choices' => datosBasicosHandler::yesOrNoChoicesOptions(),
                ));
        $this->widgetSchema['calcif_valvular'] = new sfWidgetFormChoice(array(
                    'expanded' => true,
                    'choices' => datosBasicosHandler::yesOrNoChoicesOptions(),
                ));
        $this->widgetSchema['hvi'] = new sfWidgetFormChoice(array(
                    'expanded' => true,
                    'choices' => datosBasicosHandler::yesOrNoChoicesOptions(),
                ));
        
  }
}
