<?php

/**
 * TrasplanteComplicacionesInfecciosas form.
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormTemplate.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class TrasplanteComplicacionesInfecciosasForm extends BaseTrasplanteComplicacionesInfecciosasForm
{
  public function configure()
  {
$this->widgetSchema['evolucion'] = new sfWidgetFormInputHidden();
	$this->validatorSchema['evolucion'] = new sfValidatorBoolean();
	$this->widgetSchema['trasplante_id'] = new sfWidgetFormInputHidden();
	$trasplanteId = $this->getObject()->getTrasplanteId();
	$trasplante = trasplanteHandler::retriveById($trasplanteId, Doctrine_Core::HYDRATE_ARRAY );
	if($trasplante)
	{
	  $age = mdBasicFunction::calculateAge($trasplante["fecha"], true);
	  
	}
	else
	{
	  $age = 100;
	}
    $years = range(date('Y') - $age,date('Y'));
    $years = array_combine($years, $years);
    
    $this->widgetSchema['fecha'] = new sfWidgetFormDate(
                              array(
                                'format' => '%year% %month% %day%',
                                'years' => $years));
	if($this->getObject()->getEvolucion() == 1 )
	{
		$this->widgetSchema['internado'] =  new sfWidgetFormChoice(array(
                                                              'expanded' => true,
                                                              'choices'  => datosBasicosHandler::yesOrNoChoicesOptions(),
                                                            ));	  
	}
	else 
	{
	  $this->widgetSchema['internado'] = new sfWidgetFormInputHidden();
	  $this->widgetSchema['dias_de_internacion'] = new sfWidgetFormInputHidden();
	}	
  }
}
