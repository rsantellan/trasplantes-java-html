<?php

/**
 * ComplicacionesTiposValoresTable
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 */
class ComplicacionesTiposValoresTable extends Doctrine_Table
{
    /**
     * Returns an instance of this class.
     *
     * @return object ComplicacionesTiposValoresTable
     */
    public static function getInstance()
    {
        return Doctrine_Core::getTable('ComplicacionesTiposValores');
    }
    
    public function retrieveOneByComplicacionTipoIdAndName($complicacionTipoId, $nombre)
    {
      $query = $this->createQuery("ctv")
                ->addWhere("ctv.complicacion_tipo_id = ?", $complicacionTipoId)
                ->addWhere("ctv.nombre = ?", $nombre);
      return $query->fetchOne();
    }
}
