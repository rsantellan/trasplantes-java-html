<?php

/**
 * SerolValor form.
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormTemplate.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class SerolValorForm extends BaseSerolValorForm
{
  public function configure()
  {
    $this->widgetSchema['serol_id'] = new sfWidgetFormInputHidden();
  }
}
