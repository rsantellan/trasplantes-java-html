<?php


/**
 * Description of EvolucionTrasplanteCounterBehavior
 *
 * @author Rodrigo Santellan
 */
class EvolucionTrasplanteCounterBehavior extends Doctrine_Template
{
    
    public function setTableDefinition()
    {
        $this->addListener(new EvolucionTrasplanteCounterBehaviorListener());
    }
}

