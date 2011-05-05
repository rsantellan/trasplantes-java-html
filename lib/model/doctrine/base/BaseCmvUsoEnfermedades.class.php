<?php

/**
 * BaseCmvUsoEnfermedades
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 * 
 * @property integer $cmv_id
 * @property integer $cmv_emfermedades_id
 * @property Cmv $Cmv
 * @property Cmvemfermedades $Cmvemfermedades
 * 
 * @method integer            getCmvId()               Returns the current record's "cmv_id" value
 * @method integer            getCmvEmfermedadesId()   Returns the current record's "cmv_emfermedades_id" value
 * @method Cmv                getCmv()                 Returns the current record's "Cmv" value
 * @method Cmvemfermedades    getCmvemfermedades()     Returns the current record's "Cmvemfermedades" value
 * @method CmvUsoEnfermedades setCmvId()               Sets the current record's "cmv_id" value
 * @method CmvUsoEnfermedades setCmvEmfermedadesId()   Sets the current record's "cmv_emfermedades_id" value
 * @method CmvUsoEnfermedades setCmv()                 Sets the current record's "Cmv" value
 * @method CmvUsoEnfermedades setCmvemfermedades()     Sets the current record's "Cmvemfermedades" value
 * 
 * @package    transplantes
 * @subpackage model
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: Builder.php 7490 2010-03-29 19:53:27Z jwage $
 */
abstract class BaseCmvUsoEnfermedades extends sfDoctrineRecord
{
    public function setTableDefinition()
    {
        $this->setTableName('cmv_uso_enfermedades');
        $this->hasColumn('cmv_id', 'integer', 4, array(
             'type' => 'integer',
             'primary' => true,
             'length' => 4,
             ));
        $this->hasColumn('cmv_emfermedades_id', 'integer', 4, array(
             'type' => 'integer',
             'primary' => true,
             'length' => 4,
             ));

        $this->option('symfony', array(
             'form' => false,
             'filter' => false,
             ));
    }

    public function setUp()
    {
        parent::setUp();
        $this->hasOne('Cmv', array(
             'local' => 'cmv_id',
             'foreign' => 'id',
             'onDelete' => 'CASCADE'));

        $this->hasOne('Cmvemfermedades', array(
             'local' => 'cmv_emfermedades_id',
             'foreign' => 'id',
             'onDelete' => 'CASCADE'));

        $timestampable0 = new Doctrine_Template_Timestampable(array(
             ));
        $this->actAs($timestampable0);
    }
}