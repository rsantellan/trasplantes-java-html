<?php

/**
 * Trasplante form.
 *
 * @package    transplantes
 * @subpackage form
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: sfDoctrineFormTemplate.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class TrasplanteForm extends BaseTrasplanteForm
{
  public function configure()
  {
    unset($this["created_at"], $this["updated_at"], $this["fecha_alta"]);
    
    
  }
}
