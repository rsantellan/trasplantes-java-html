<?php

/**
 * BaseEvolucionTrasplanteTxtorax
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 * 
 * @property integer $id
 * @property integer $trasplante_id
 * @property date $fecha
 * @property integer $rct
 * @property integer $foco
 * @property enum $lateralizado
 * @property integer $derrame_pleural
 * @property enum $lateral_derrame
 * @property integer $secuelas
 * @property string $otros
 * @property Trasplante $Trasplante
 * 
 * @method integer                    getId()              Returns the current record's "id" value
 * @method integer                    getTrasplanteId()    Returns the current record's "trasplante_id" value
 * @method date                       getFecha()           Returns the current record's "fecha" value
 * @method integer                    getRct()             Returns the current record's "rct" value
 * @method integer                    getFoco()            Returns the current record's "foco" value
 * @method enum                       getLateralizado()    Returns the current record's "lateralizado" value
 * @method integer                    getDerramePleural()  Returns the current record's "derrame_pleural" value
 * @method enum                       getLateralDerrame()  Returns the current record's "lateral_derrame" value
 * @method integer                    getSecuelas()        Returns the current record's "secuelas" value
 * @method string                     getOtros()           Returns the current record's "otros" value
 * @method Trasplante                 getTrasplante()      Returns the current record's "Trasplante" value
 * @method EvolucionTrasplanteTxtorax setId()              Sets the current record's "id" value
 * @method EvolucionTrasplanteTxtorax setTrasplanteId()    Sets the current record's "trasplante_id" value
 * @method EvolucionTrasplanteTxtorax setFecha()           Sets the current record's "fecha" value
 * @method EvolucionTrasplanteTxtorax setRct()             Sets the current record's "rct" value
 * @method EvolucionTrasplanteTxtorax setFoco()            Sets the current record's "foco" value
 * @method EvolucionTrasplanteTxtorax setLateralizado()    Sets the current record's "lateralizado" value
 * @method EvolucionTrasplanteTxtorax setDerramePleural()  Sets the current record's "derrame_pleural" value
 * @method EvolucionTrasplanteTxtorax setLateralDerrame()  Sets the current record's "lateral_derrame" value
 * @method EvolucionTrasplanteTxtorax setSecuelas()        Sets the current record's "secuelas" value
 * @method EvolucionTrasplanteTxtorax setOtros()           Sets the current record's "otros" value
 * @method EvolucionTrasplanteTxtorax setTrasplante()      Sets the current record's "Trasplante" value
 * 
 * @package    transplantes
 * @subpackage model
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: Builder.php 7490 2010-03-29 19:53:27Z jwage $
 */
abstract class BaseEvolucionTrasplanteTxtorax extends sfDoctrineRecord
{
    public function setTableDefinition()
    {
        $this->setTableName('evolucion_trasplante_txtorax');
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
        $this->hasColumn('rct', 'integer', 4, array(
             'type' => 'integer',
             'default' => 0,
             'length' => 4,
             ));
        $this->hasColumn('foco', 'integer', 1, array(
             'type' => 'integer',
             'length' => 1,
             ));
        $this->hasColumn('lateralizado', 'enum', 9, array(
             'type' => 'enum',
             'length' => 9,
             'values' => 
             array(
              0 => 'Izquierda',
              1 => 'Derecha',
              2 => 'Bilateral',
             ),
             'notnull' => true,
             ));
        $this->hasColumn('derrame_pleural', 'integer', 1, array(
             'type' => 'integer',
             'length' => 1,
             ));
        $this->hasColumn('lateral_derrame', 'enum', 9, array(
             'type' => 'enum',
             'length' => 9,
             'values' => 
             array(
              0 => 'Izquierda',
              1 => 'Derecha',
              2 => 'Bilateral',
             ),
             'notnull' => true,
             ));
        $this->hasColumn('secuelas', 'integer', 1, array(
             'type' => 'integer',
             'length' => 1,
             ));
        $this->hasColumn('otros', 'string', 255, array(
             'type' => 'string',
             'length' => 255,
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