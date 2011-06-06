<?php

/**
 * BaseGermenes
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
 * @method Germenes            setId()                        Sets the current record's "id" value
 * @method Germenes            setNombre()                    Sets the current record's "nombre" value
 * @method Germenes            setComplicacionesInfecciosas() Sets the current record's "ComplicacionesInfecciosas" collection
 * 
 * @package    transplantes
 * @subpackage model
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: Builder.php 7490 2010-03-29 19:53:27Z jwage $
 */
abstract class BaseGermenes extends sfDoctrineRecord
{
    public function setTableDefinition()
    {
        $this->setTableName('germenes');
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
             'foreign' => 'germen_id'));
    }
}