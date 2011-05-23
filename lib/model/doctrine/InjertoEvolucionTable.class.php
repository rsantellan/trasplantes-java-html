<?php

/**
 * InjertoEvolucionTable
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 */
class InjertoEvolucionTable extends Doctrine_Table
{
    /**
     * Returns an instance of this class.
     *
     * @return object InjertoEvolucionTable
     */
    public static function getInstance()
    {
        return Doctrine_Core::getTable('InjertoEvolucion');
    }
    
    public function retrieveByTrasplanteIdAndDate($trasplanteId, $fecha)
    {
      $query = $this->createQuery("ie")
              ->addWhere("ie.trasplante_id = ?", $trasplanteId)
              ->addWhere("ie.fecha = ?", $fecha);
      return $query->fetchOne();
    }    
}
