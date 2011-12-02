<?php

/**
 * BaseMedicaciones
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 * 
 * @property integer $id
 * @property string $nombre
 * @property Doctrine_Collection $TrasplanteComplicacionesInfecciosas
 * @property Doctrine_Collection $TrasplanteComplicacionesNoInfecciosas
 * @property Doctrine_Collection $Tratamiento
 * 
 * @method integer             getId()                                    Returns the current record's "id" value
 * @method string              getNombre()                                Returns the current record's "nombre" value
 * @method Doctrine_Collection getTrasplanteComplicacionesInfecciosas()   Returns the current record's "TrasplanteComplicacionesInfecciosas" collection
 * @method Doctrine_Collection getTrasplanteComplicacionesNoInfecciosas() Returns the current record's "TrasplanteComplicacionesNoInfecciosas" collection
 * @method Doctrine_Collection getTratamiento()                           Returns the current record's "Tratamiento" collection
 * @method Medicaciones        setId()                                    Sets the current record's "id" value
 * @method Medicaciones        setNombre()                                Sets the current record's "nombre" value
 * @method Medicaciones        setTrasplanteComplicacionesInfecciosas()   Sets the current record's "TrasplanteComplicacionesInfecciosas" collection
 * @method Medicaciones        setTrasplanteComplicacionesNoInfecciosas() Sets the current record's "TrasplanteComplicacionesNoInfecciosas" collection
 * @method Medicaciones        setTratamiento()                           Sets the current record's "Tratamiento" collection
 * 
 * @package    transplantes
 * @subpackage model
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: Builder.php 7490 2010-03-29 19:53:27Z jwage $
 */
abstract class BaseMedicaciones extends sfDoctrineRecord
{
    public function setTableDefinition()
    {
        $this->setTableName('medicaciones');
        $this->hasColumn('id', 'integer', 4, array(
             'type' => 'integer',
             'primary' => true,
             'autoincrement' => true,
             'length' => 4,
             ));
        $this->hasColumn('nombre', 'string', 50, array(
             'type' => 'string',
             'notnull' => true,
             'length' => 50,
             ));
    }

    public function setUp()
    {
        parent::setUp();
        $this->hasMany('TrasplanteComplicacionesInfecciosas', array(
             'local' => 'id',
             'foreign' => 'medicacion_id'));

        $this->hasMany('TrasplanteComplicacionesNoInfecciosas', array(
             'local' => 'id',
             'foreign' => 'medicacion_id'));

        $this->hasMany('Tratamiento', array(
             'local' => 'id',
             'foreign' => 'medicacion_id'));
    }
}