<?php

/**
 * BasePacienteCausaMuerte
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 * 
 * @property integer $id
 * @property string $nombre
 * @property Doctrine_Collection $PacienteMuerte
 * 
 * @method integer             getId()             Returns the current record's "id" value
 * @method string              getNombre()         Returns the current record's "nombre" value
 * @method Doctrine_Collection getPacienteMuerte() Returns the current record's "PacienteMuerte" collection
 * @method PacienteCausaMuerte setId()             Sets the current record's "id" value
 * @method PacienteCausaMuerte setNombre()         Sets the current record's "nombre" value
 * @method PacienteCausaMuerte setPacienteMuerte() Sets the current record's "PacienteMuerte" collection
 * 
 * @package    transplantes
 * @subpackage model
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: Builder.php 7490 2010-03-29 19:53:27Z jwage $
 */
abstract class BasePacienteCausaMuerte extends sfDoctrineRecord
{
    public function setTableDefinition()
    {
        $this->setTableName('paciente_causa_muerte');
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
        $this->hasMany('PacienteMuerte', array(
             'local' => 'id',
             'foreign' => 'causa_muerte_id'));

        $timestampable0 = new Doctrine_Template_Timestampable(array(
             ));
        $this->actAs($timestampable0);
    }
}