<?php
// Connection Component Binding
Doctrine_Manager::getInstance()->bindComponent('PacientePerdidaInjerto', 'doctrine');

/**
 * BasePacientePerdidaInjerto
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 * 
 * @property integer $the
 * @property integer $causa
 * @property date $fecha_perdida
 * @property integer $id_pretrasplante
 * 
 * @method integer                getThe()              Returns the current record's "the" value
 * @method integer                getCausa()            Returns the current record's "causa" value
 * @method date                   getFechaPerdida()     Returns the current record's "fecha_perdida" value
 * @method integer                getIdPretrasplante()  Returns the current record's "id_pretrasplante" value
 * @method PacientePerdidaInjerto setThe()              Sets the current record's "the" value
 * @method PacientePerdidaInjerto setCausa()            Sets the current record's "causa" value
 * @method PacientePerdidaInjerto setFechaPerdida()     Sets the current record's "fecha_perdida" value
 * @method PacientePerdidaInjerto setIdPretrasplante()  Sets the current record's "id_pretrasplante" value
 * 
 * @package    transplantes
 * @subpackage model
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: Builder.php 7490 2010-03-29 19:53:27Z jwage $
 */
abstract class BasePacientePerdidaInjerto extends sfDoctrineRecord
{
    public function setTableDefinition()
    {
        $this->setTableName('paciente_perdida_injerto');
        $this->hasColumn('the', 'integer', 4, array(
             'type' => 'integer',
             'fixed' => 0,
             'unsigned' => false,
             'primary' => true,
             'autoincrement' => false,
             'length' => 4,
             ));
        $this->hasColumn('causa', 'integer', 2, array(
             'type' => 'integer',
             'fixed' => 0,
             'unsigned' => false,
             'primary' => false,
             'notnull' => false,
             'autoincrement' => false,
             'length' => 2,
             ));
        $this->hasColumn('fecha_perdida', 'date', 25, array(
             'type' => 'date',
             'fixed' => 0,
             'unsigned' => false,
             'primary' => true,
             'default' => '1900-01-01',
             'autoincrement' => false,
             'length' => 25,
             ));
        $this->hasColumn('id_pretrasplante', 'integer', 4, array(
             'type' => 'integer',
             'fixed' => 0,
             'unsigned' => false,
             'primary' => false,
             'default' => '0',
             'notnull' => true,
             'autoincrement' => false,
             'length' => 4,
             ));
    }

    public function setUp()
    {
        parent::setUp();
        
    }
}