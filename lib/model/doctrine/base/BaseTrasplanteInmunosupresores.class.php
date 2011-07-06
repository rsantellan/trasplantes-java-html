<?php

/**
 * BaseTrasplanteInmunosupresores
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 * 
 * @property integer $trasplante_id
 * @property integer $inmunosupresores_id
 * @property Trasplante $Trasplante
 * @property Inmunosupresores $Inmunosupresores
 * 
 * @method integer                    getTrasplanteId()        Returns the current record's "trasplante_id" value
 * @method integer                    getInmunosupresoresId()  Returns the current record's "inmunosupresores_id" value
 * @method Trasplante                 getTrasplante()          Returns the current record's "Trasplante" value
 * @method Inmunosupresores           getInmunosupresores()    Returns the current record's "Inmunosupresores" value
 * @method TrasplanteInmunosupresores setTrasplanteId()        Sets the current record's "trasplante_id" value
 * @method TrasplanteInmunosupresores setInmunosupresoresId()  Sets the current record's "inmunosupresores_id" value
 * @method TrasplanteInmunosupresores setTrasplante()          Sets the current record's "Trasplante" value
 * @method TrasplanteInmunosupresores setInmunosupresores()    Sets the current record's "Inmunosupresores" value
 * 
 * @package    transplantes
 * @subpackage model
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: Builder.php 7490 2010-03-29 19:53:27Z jwage $
 */
abstract class BaseTrasplanteInmunosupresores extends sfDoctrineRecord
{
    public function setTableDefinition()
    {
        $this->setTableName('trasplante_inmunosupresores');
        $this->hasColumn('trasplante_id', 'integer', 4, array(
             'type' => 'integer',
             'primary' => true,
             'length' => 4,
             ));
        $this->hasColumn('inmunosupresores_id', 'integer', 4, array(
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
        $this->hasOne('Trasplante', array(
             'local' => 'trasplante_id',
             'foreign' => 'id'));

        $this->hasOne('Inmunosupresores', array(
             'local' => 'inmunosupresores_id',
             'foreign' => 'id'));
    }
}