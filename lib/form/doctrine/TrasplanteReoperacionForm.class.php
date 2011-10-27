<?php

/**
 * TrasplanteReoperacion form.
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormTemplate.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class TrasplanteReoperacionForm extends BaseTrasplanteReoperacionForm
{
  public function configure()
  {
	$this->widgetSchema['trasplante_id'] = new sfWidgetFormInputHidden();
	
	
	$this->widgetSchema['fecha'] = new sfWidgetFormDate(
                              array(
                                'format' => '%year% %month% %day%',
                                'years' => $years));

	
  }
}
