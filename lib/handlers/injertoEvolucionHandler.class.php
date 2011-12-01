<?php

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of injertoEvolucionHandler
 *
 * @author Rodrigo Santellan
 */
class injertoEvolucionHandler {
    
    public static function retrieveAllInjertosEvolucion($hydrationMode = Doctrine_Core::HYDRATE_RECORD)
    {
       return Doctrine_Core::getTable('InjertoEvolucion')
                          ->createQuery('a')
                          ->execute();
    }
    
    public static function retrieveInjertoEvolucionOfTrasplanteEnTrasplante($trasplanteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
    {
        return Doctrine::getTable("InjertoEvolucion")->retrieveInjertoEvolucionOfTrasplanteEnTrasplante($trasplanteId, $hydrationMode);
    }
    
    public static function retrieveInjertoEvolucionOfTrasplanteEnEvolucion($trasplanteId, $hydrationMode = Doctrine_Core::HYDRATE_RECORD)
    {
        return Doctrine::getTable("InjertoEvolucion")->retrieveInjertoEvolucionOfTrasplanteEnEvolucion($trasplanteId, $hydrationMode);
    }
    
}


