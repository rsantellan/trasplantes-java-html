<?php

/**
 * Description of EvolucionTrasplanteCounterBehaviorListener
 *
 * @author Rodrigo Santellan
 */
class EvolucionTrasplanteCounterBehaviorListener extends Doctrine_Record_Listener {

    public function postSave(Doctrine_Event $event) {
        $object = $event->getInvoker();
        if (!Doctrine::getTable('EvolucionTrasplanteCounter')->retrieveByObject($object->getId(), $object->getClassName())) {
            $etCounter = new EvolucionTrasplanteCounter();
            $etCounter->setObjectClass($object->getClassName());
            $etCounter->setObjectId($object->getId());
            $etCounter->setTrasplanteId($object->getTrasplanteId());
            $etCounter->save();
        }
    }

    public function preDelete(Doctrine_Event $event) {
        $object = $event->getInvoker();
        $counter = Doctrine::getTable('EvolucionTrasplanteCounter')->retrieveByObject($object->getId(), $object->getClassName());
        $counter->delete();
    }

}

