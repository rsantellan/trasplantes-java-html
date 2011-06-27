<?php

/**
 * BaseInfeccion
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 * 
 * @property integer $id
 * @property string $nombre
 * @property Doctrine_Collection $ComplicacionesInfecciosas
 * 
 * @method integer             getId()                        Returns the current record's "id" value
 * @method string              getNombre()                    Returns the current record's "nombre" value
 * @method Doctrine_Collection getComplicacionesInfecciosas() Returns the current record's "ComplicacionesInfecciosas" collection
 * @method Infeccion           setId()                        Sets the current record's "id" value
 * @method Infeccion           setNombre()                    Sets the current record's "nombre" value
 * @method Infeccion           setComplicacionesInfecciosas() Sets the current record's "ComplicacionesInfecciosas" collection
 * 
 * @package    transplantes
 * @subpackage model
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: Builder.php 7490 2010-03-29 19:53:27Z jwage $
 */
abstract class BaseInfeccion extends sfDoctrineRecord
{
    public function setTableDefinition()
    {
        $this->setTableName('infeccion');
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
        $this->hasMany('ComplicacionesInfecciosas', array(
             'local' => 'id',
             'foreign' => 'infeccion_id'));
    }
}