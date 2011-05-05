<?php
// Connection Component Binding
Doctrine_Manager::getInstance()->bindComponent('Infeccion', 'doctrine');

/**
 * BaseInfeccion
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 * 
 * @property integer $id
 * @property string $nombre
 * 
 * @method integer   getId()     Returns the current record's "id" value
 * @method string    getNombre() Returns the current record's "nombre" value
 * @method Infeccion setId()     Sets the current record's "id" value
 * @method Infeccion setNombre() Sets the current record's "nombre" value
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
        $this->hasColumn('id', 'integer', 2, array(
             'type' => 'integer',
             'fixed' => 0,
             'unsigned' => false,
             'primary' => true,
             'autoincrement' => true,
             'length' => 2,
             ));
        $this->hasColumn('nombre', 'string', 50, array(
             'type' => 'string',
             'fixed' => 0,
             'unsigned' => false,
             'primary' => false,
             'notnull' => false,
             'autoincrement' => false,
             'length' => 50,
             ));
    }

    public function setUp()
    {
        parent::setUp();
        
    }
}