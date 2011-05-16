<?php

/**
 * BaseOrganos
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 * 
 * @property integer $id
 * @property string $nombre
 * @property Doctrine_Collection $Donantes
 * @property Doctrine_Collection $DonanteOrganos
 * 
 * @method integer             getId()             Returns the current record's "id" value
 * @method string              getNombre()         Returns the current record's "nombre" value
 * @method Doctrine_Collection getDonantes()       Returns the current record's "Donantes" collection
 * @method Doctrine_Collection getDonanteOrganos() Returns the current record's "DonanteOrganos" collection
 * @method Organos             setId()             Sets the current record's "id" value
 * @method Organos             setNombre()         Sets the current record's "nombre" value
 * @method Organos             setDonantes()       Sets the current record's "Donantes" collection
 * @method Organos             setDonanteOrganos() Sets the current record's "DonanteOrganos" collection
 * 
 * @package    transplantes
 * @subpackage model
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: Builder.php 7490 2010-03-29 19:53:27Z jwage $
 */
abstract class BaseOrganos extends sfDoctrineRecord
{
    public function setTableDefinition()
    {
        $this->setTableName('organos');
        $this->hasColumn('id', 'integer', 4, array(
             'type' => 'integer',
             'primary' => true,
             'autoincrement' => true,
             'length' => 4,
             ));
        $this->hasColumn('nombre', 'string', 255, array(
             'type' => 'string',
             'notnull' => true,
             'length' => 255,
             ));
    }

    public function setUp()
    {
        parent::setUp();
        $this->hasMany('Donante as Donantes', array(
             'refClass' => 'DonanteOrganos',
             'local' => 'organo_id',
             'foreign' => 'donante_id'));

        $this->hasMany('DonanteOrganos', array(
             'local' => 'id',
             'foreign' => 'organo_id'));
    }
}