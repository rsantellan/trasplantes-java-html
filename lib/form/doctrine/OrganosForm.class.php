<?php

/**
 * Organos form.
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormTemplate.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class OrganosForm extends BaseOrganosForm
{
  public function configure()
  {
    unset($this['donantes_list']);
    $this->widgetSchema['id'] = new sfWidgetFormInputHidden();
    
  }
}
