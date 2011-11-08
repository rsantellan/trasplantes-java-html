<?php

/**
 * BaseEvolucionTrasplanteCmv
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 * 
 * @property integer $id
 * @property integer $trasplante_id
 * @property date $fecha
 * @property integer $igg_cmv
 * @property integer $igm_cmv
 * @property integer $pcr_cmv
 * @property integer $ag_pp65
 * @property Trasplante $Trasplante
 * 
 * @method integer                getId()            Returns the current record's "id" value
 * @method integer                getTrasplanteId()  Returns the current record's "trasplante_id" value
 * @method date                   getFecha()         Returns the current record's "fecha" value
 * @method integer                getIggCmv()        Returns the current record's "igg_cmv" value
 * @method integer                getIgmCmv()        Returns the current record's "igm_cmv" value
 * @method integer                getPcrCmv()        Returns the current record's "pcr_cmv" value
 * @method integer                getAgPp65()        Returns the current record's "ag_pp65" value
 * @method Trasplante             getTrasplante()    Returns the current record's "Trasplante" value
 * @method EvolucionTrasplanteCmv setId()            Sets the current record's "id" value
 * @method EvolucionTrasplanteCmv setTrasplanteId()  Sets the current record's "trasplante_id" value
 * @method EvolucionTrasplanteCmv setFecha()         Sets the current record's "fecha" value
 * @method EvolucionTrasplanteCmv setIggCmv()        Sets the current record's "igg_cmv" value
 * @method EvolucionTrasplanteCmv setIgmCmv()        Sets the current record's "igm_cmv" value
 * @method EvolucionTrasplanteCmv setPcrCmv()        Sets the current record's "pcr_cmv" value
 * @method EvolucionTrasplanteCmv setAgPp65()        Sets the current record's "ag_pp65" value
 * @method EvolucionTrasplanteCmv setTrasplante()    Sets the current record's "Trasplante" value
 * 
 * @package    transplantes
 * @subpackage model
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: Builder.php 7490 2010-03-29 19:53:27Z jwage $
 */
abstract class BaseEvolucionTrasplanteCmv extends sfDoctrineRecord
{
    public function setTableDefinition()
    {
        $this->setTableName('evolucion_trasplante_cmv');
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
        $this->hasColumn('igg_cmv', 'integer', 1, array(
             'type' => 'integer',
             'default' => 0,
             'length' => 1,
             ));
        $this->hasColumn('igm_cmv', 'integer', 1, array(
             'type' => 'integer',
             'default' => 0,
             'length' => 1,
             ));
        $this->hasColumn('pcr_cmv', 'integer', 1, array(
             'type' => 'integer',
             'default' => 0,
             'length' => 1,
             ));
        $this->hasColumn('ag_pp65', 'integer', 1, array(
             'type' => 'integer',
             'default' => 0,
             'length' => 1,
             ));
    }

    public function setUp()
    {
        parent::setUp();
        $this->hasOne('Trasplante', array(
             'local' => 'trasplante_id',
             'foreign' => 'id'));

        $evoluciontrasplantecounterbehavior0 = new EvolucionTrasplanteCounterBehavior();
        $this->actAs($evoluciontrasplantecounterbehavior0);
    }
}