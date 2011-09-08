<?php

/**
 * BaseEvolucionTrasplanteMarvirales
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 * 
 * @property integer $id
 * @property integer $trasplante_id
 * @property date $fecha
 * @property integer $hsv
 * @property enum $aghbs
 * @property enum $hbsac
 * @property enum $hbcac
 * @property enum $hvc
 * @property enum $hiv
 * @property Trasplante $Trasplante
 * 
 * @method integer                       getId()            Returns the current record's "id" value
 * @method integer                       getTrasplanteId()  Returns the current record's "trasplante_id" value
 * @method date                          getFecha()         Returns the current record's "fecha" value
 * @method integer                       getHsv()           Returns the current record's "hsv" value
 * @method enum                          getAghbs()         Returns the current record's "aghbs" value
 * @method enum                          getHbsac()         Returns the current record's "hbsac" value
 * @method enum                          getHbcac()         Returns the current record's "hbcac" value
 * @method enum                          getHvc()           Returns the current record's "hvc" value
 * @method enum                          getHiv()           Returns the current record's "hiv" value
 * @method Trasplante                    getTrasplante()    Returns the current record's "Trasplante" value
 * @method EvolucionTrasplanteMarvirales setId()            Sets the current record's "id" value
 * @method EvolucionTrasplanteMarvirales setTrasplanteId()  Sets the current record's "trasplante_id" value
 * @method EvolucionTrasplanteMarvirales setFecha()         Sets the current record's "fecha" value
 * @method EvolucionTrasplanteMarvirales setHsv()           Sets the current record's "hsv" value
 * @method EvolucionTrasplanteMarvirales setAghbs()         Sets the current record's "aghbs" value
 * @method EvolucionTrasplanteMarvirales setHbsac()         Sets the current record's "hbsac" value
 * @method EvolucionTrasplanteMarvirales setHbcac()         Sets the current record's "hbcac" value
 * @method EvolucionTrasplanteMarvirales setHvc()           Sets the current record's "hvc" value
 * @method EvolucionTrasplanteMarvirales setHiv()           Sets the current record's "hiv" value
 * @method EvolucionTrasplanteMarvirales setTrasplante()    Sets the current record's "Trasplante" value
 * 
 * @package    transplantes
 * @subpackage model
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: Builder.php 7490 2010-03-29 19:53:27Z jwage $
 */
abstract class BaseEvolucionTrasplanteMarvirales extends sfDoctrineRecord
{
    public function setTableDefinition()
    {
        $this->setTableName('evolucion_trasplante_marvirales');
        $this->hasColumn('id', 'integer', 4, array(
             'type' => 'integer',
             'primary' => true,
             'autoincrement' => true,
             'length' => 4,
             ));
        $this->hasColumn('trasplante_id', 'integer', 4, array(
             'type' => 'integer',
             'notnull' => true,
             'length' => 4,
             ));
        $this->hasColumn('fecha', 'date', 25, array(
             'type' => 'date',
             'notnull' => true,
             'length' => 25,
             ));
        $this->hasColumn('hsv', 'integer', 1, array(
             'type' => 'integer',
             'length' => 1,
             ));
        $this->hasColumn('aghbs', 'enum', 13, array(
             'type' => 'enum',
             'length' => 13,
             'values' => 
             array(
              0 => 'Indeterminado',
              1 => 'Negativo',
              2 => 'Positivo',
              3 => 'Sin datos',
             ),
             'notnull' => true,
             ));
        $this->hasColumn('hbsac', 'enum', 13, array(
             'type' => 'enum',
             'length' => 13,
             'values' => 
             array(
              0 => 'Indeterminado',
              1 => 'Negativo',
              2 => 'Positivo',
              3 => 'Sin datos',
             ),
             'notnull' => true,
             ));
        $this->hasColumn('hbcac', 'enum', 13, array(
             'type' => 'enum',
             'length' => 13,
             'values' => 
             array(
              0 => 'Indeterminado',
              1 => 'Negativo',
              2 => 'Positivo',
              3 => 'Sin datos',
             ),
             'notnull' => true,
             ));
        $this->hasColumn('hvc', 'enum', 13, array(
             'type' => 'enum',
             'length' => 13,
             'values' => 
             array(
              0 => 'Indeterminado',
              1 => 'Negativo',
              2 => 'Positivo',
              3 => 'Sin datos',
             ),
             'notnull' => true,
             ));
        $this->hasColumn('hiv', 'enum', 13, array(
             'type' => 'enum',
             'length' => 13,
             'values' => 
             array(
              0 => 'Indeterminado',
              1 => 'Negativo',
              2 => 'Positivo',
              3 => 'Sin datos',
             ),
             'notnull' => true,
             ));
    }

    public function setUp()
    {
        parent::setUp();
        $this->hasOne('Trasplante', array(
             'local' => 'trasplante_id',
             'foreign' => 'id'));
    }
}