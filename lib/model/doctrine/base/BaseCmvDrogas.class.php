<?php

/**
 * BaseCmvDrogas
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 * 
 * @property integer $id
 * @property string $nombre
 * 
 * @method integer   getId()     Returns the current record's "id" value
 * @method string    getNombre() Returns the current record's "nombre" value
 * @method CmvDrogas setId()     Sets the current record's "id" value
 * @method CmvDrogas setNombre() Sets the current record's "nombre" value
 * 
 * @package    transplantes
 * @subpackage model
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: Builder.php 7490 2010-03-29 19:53:27Z jwage $
 */
abstract class BaseCmvDrogas extends sfDoctrineRecord
{
    public function setTableDefinition()
    {
        $this->setTableName('cmv_drogas');
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
        
    }
}