<?php

/**
 * Donante form.
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormTemplate.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class DonanteForm extends BaseDonanteForm
{
  public function configure()
  {
	$this->widgetSchema['sexo_donante'] =  new sfWidgetFormChoice(array(
												'expanded' => true,
												'choices'  => array('M' => 'M', 'F' => 'F'),
											  ));
	
	$years = range(1, 100);
	$years = array_combine($years, $years);
	$this->widgetSchema['edad_donante'] = new sfWidgetFormChoice(array('choices' => $years));
	$this->widgetSchema['otros'] = new sfWidgetFormTextarea();
  }
}
