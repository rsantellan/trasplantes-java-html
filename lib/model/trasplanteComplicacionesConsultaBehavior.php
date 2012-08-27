<?php
 
class trasplanteComplicacionesConsultaBehavior extends Doctrine_Template
{
    public function setTableDefinition()
    {
        $this->addListener(new trasplanteComplicacionesConsultaBehaviorListener());
    }
}
