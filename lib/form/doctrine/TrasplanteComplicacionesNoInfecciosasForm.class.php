<?php

/**
 * TrasplanteComplicacionesNoInfecciosas form.
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormTemplate.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class TrasplanteComplicacionesNoInfecciosasForm extends BaseTrasplanteComplicacionesNoInfecciosasForm
{
  public function configure()
  {
	unset($this["evolucion"]);
	
	$this->widgetSchema['trasplante_id'] = new sfWidgetFormInputHidden();
	$trasplanteId = $this->getObject()->getTrasplanteId();
	$trasplante = trasplanteHandler::retriveById($trasplanteId, Doctrine_Core::HYDRATE_ARRAY );
	if(!$trasplante)
	{
	  throw new Exception("Se debe siempre especificar el trasplante id al que pertenece", 150);
	}
	$age = mdBasicFunction::calculateAge($trasplante["fecha"], true);
    $years = range(date('Y') - $age,date('Y'));
    $years = array_combine($years, $years);
    
    $this->widgetSchema['fecha'] = new sfWidgetFormDate(
                              array(
                                'format' => '%year% %month% %day%',
                                'years' => $years));
	$this->widgetSchema['internado'] =  new sfWidgetFormChoice(array(
                                                              'expanded' => true,
                                                              'choices'  => datosBasicosHandler::yesOrNoChoicesOptions(),
                                                            ));
  }
}
