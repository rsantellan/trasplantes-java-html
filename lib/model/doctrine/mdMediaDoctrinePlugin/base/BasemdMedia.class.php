<?php

/**
 * BasemdMedia
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 * 
 * @property integer $id
 * @property string $object_class_name
 * @property integer $object_id
 * @property Doctrine_Collection $mdMediaAlbum
 * 
 * @method integer             getId()                Returns the current record's "id" value
 * @method string              getObjectClassName()   Returns the current record's "object_class_name" value
 * @method integer             getObjectId()          Returns the current record's "object_id" value
 * @method Doctrine_Collection getMdMediaAlbum()      Returns the current record's "mdMediaAlbum" collection
 * @method mdMedia             setId()                Sets the current record's "id" value
 * @method mdMedia             setObjectClassName()   Sets the current record's "object_class_name" value
 * @method mdMedia             setObjectId()          Sets the current record's "object_id" value
 * @method mdMedia             setMdMediaAlbum()      Sets the current record's "mdMediaAlbum" collection
 * 
 * @package    transplantes
 * @subpackage model
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: Builder.php 7490 2010-03-29 19:53:27Z jwage $
 */
abstract class BasemdMedia extends sfDoctrineRecord
{
    public function setTableDefinition()
    {
        $this->setTableName('md_media');
        $this->hasColumn('id', 'integer', 4, array(
             'type' => 'integer',
             'primary' => true,
             'autoincrement' => true,
             'length' => 4,
             ));
        $this->hasColumn('object_class_name', 'string', 128, array(
             'type' => 'string',
             'notnull' => true,
             'length' => 128,
             ));
        $this->hasColumn('object_id', 'integer', 4, array(
             'type' => 'integer',
             'notnull' => true,
             'length' => 4,
             ));


        $this->index('md_media_index', array(
             'fields' => 
             array(
              0 => 'object_class_name',
              1 => 'object_id',
             ),
             'type' => 'unique',
             ));
    }

    public function setUp()
    {
        parent::setUp();
        $this->hasMany('mdMediaAlbum', array(
             'local' => 'id',
             'foreign' => 'md_media_id'));
    }
}