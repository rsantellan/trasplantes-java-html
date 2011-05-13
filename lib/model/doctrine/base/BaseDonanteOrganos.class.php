<?php

/**
 * BaseDonanteOrganos
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 * 
 * @property integer $donante_id
 * @property integer $organo_id
 * @property Donante $Donante
 * @property Organos $Organos
 * 
 * @method integer        getDonanteId()  Returns the current record's "donante_id" value
 * @method integer        getOrganoId()   Returns the current record's "organo_id" value
 * @method Donante        getDonante()    Returns the current record's "Donante" value
 * @method Organos        getOrganos()    Returns the current record's "Organos" value
 * @method DonanteOrganos setDonanteId()  Sets the current record's "donante_id" value
 * @method DonanteOrganos setOrganoId()   Sets the current record's "organo_id" value
 * @method DonanteOrganos setDonante()    Sets the current record's "Donante" value
 * @method DonanteOrganos setOrganos()    Sets the current record's "Organos" value
 * 
 * @package    transplantes
 * @subpackage model
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: Builder.php 7490 2010-03-29 19:53:27Z jwage $
 */
abstract class BaseDonanteOrganos extends sfDoctrineRecord
{
    public function setTableDefinition()
    {
        $this->setTableName('donante_organos');
        $this->hasColumn('donante_id', 'integer', 4, array(
             'type' => 'integer',
             'primary' => true,
             'length' => 4,
             ));
        $this->hasColumn('organo_id', 'integer', 4, array(
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
        $this->hasOne('Donante', array(
             'local' => 'donante_id',
             'foreign' => 'id',
             'onDelete' => 'CASCADE'));

        $this->hasOne('Organos', array(
             'local' => 'organo_id',
             'foreign' => 'id',
             'onDelete' => 'CASCADE'));
    }
}