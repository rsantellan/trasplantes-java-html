<?php

/**
 * BasemdContent
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 * 
 * @property integer $id
 * @property integer $md_user_id
 * @property string $object_class
 * @property integer $object_id
 * @property mdUser $mdUser
 * @property Doctrine_Collection $mdContentRelation
 * 
 * @method integer             getId()                Returns the current record's "id" value
 * @method integer             getMdUserId()          Returns the current record's "md_user_id" value
 * @method string              getObjectClass()       Returns the current record's "object_class" value
 * @method integer             getObjectId()          Returns the current record's "object_id" value
 * @method mdUser              getMdUser()            Returns the current record's "mdUser" value
 * @method Doctrine_Collection getMdContentRelation() Returns the current record's "mdContentRelation" collection
 * @method mdContent           setId()                Sets the current record's "id" value
 * @method mdContent           setMdUserId()          Sets the current record's "md_user_id" value
 * @method mdContent           setObjectClass()       Sets the current record's "object_class" value
 * @method mdContent           setObjectId()          Sets the current record's "object_id" value
 * @method mdContent           setMdUser()            Sets the current record's "mdUser" value
 * @method mdContent           setMdContentRelation() Sets the current record's "mdContentRelation" collection
 * 
 * @package    transplantes
 * @subpackage model
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: Builder.php 7490 2010-03-29 19:53:27Z jwage $
 */
abstract class BasemdContent extends sfDoctrineRecord
{
    public function setTableDefinition()
    {
        $this->setTableName('md_content');
        $this->hasColumn('id', 'integer', 4, array(
             'type' => 'integer',
             'primary' => true,
             'autoincrement' => true,
             'length' => 4,
             ));
        $this->hasColumn('md_user_id', 'integer', 4, array(
             'type' => 'integer',
             'notnull' => true,
             'length' => 4,
             ));
        $this->hasColumn('object_class', 'string', 128, array(
             'type' => 'string',
             'notnull' => true,
             'length' => 128,
             ));
        $this->hasColumn('object_id', 'integer', 4, array(
             'type' => 'integer',
             'notnull' => true,
             'length' => 4,
             ));
    }

    public function setUp()
    {
        parent::setUp();
        $this->hasOne('mdUser', array(
             'local' => 'md_user_id',
             'foreign' => 'id'));

        $this->hasMany('mdContentRelation', array(
             'local' => 'id',
             'foreign' => 'md_content_id_first'));

        $timestampable0 = new Doctrine_Template_Timestampable(array(
             ));
        $this->actAs($timestampable0);
    }
}