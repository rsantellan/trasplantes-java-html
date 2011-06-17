<?php

/**
 * Base project form.
 * 
 * @package    transplantes
 * @subpackage form
 * @author     Your name here 
 * @version    SVN: $Id: BaseForm.class.php 20147 2009-07-13 11:46:57Z FabianLange $
 */
class BaseForm extends sfFormSymfony
{
    public function render($attributes = array()) {
         return strtr(
                 $this->getWidgetSchema()->getFormFormatter()->getDecoratorFormat(),
                 array('%content%' => parent::render($attributes))
         );
     }  
}
