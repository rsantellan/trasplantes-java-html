<?php

/**
 * BaseConsultaCampo
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 * 
 * @property integer $id
 * @property string $nombre
 * @property integer $consulta_id
 * @property Consulta $Consulta
 * 
 * @method integer       getId()          Returns the current record's "id" value
 * @method string        getNombre()      Returns the current record's "nombre" value
 * @method integer       getConsultaId()  Returns the current record's "consulta_id" value
 * @method Consulta      getConsulta()    Returns the current record's "Consulta" value
 * @method ConsultaCampo setId()          Sets the current record's "id" value
 * @method ConsultaCampo setNombre()      Sets the current record's "nombre" value
 * @method ConsultaCampo setConsultaId()  Sets the current record's "consulta_id" value
 * @method ConsultaCampo setConsulta()    Sets the current record's "Consulta" value
 * 
 * @package    transplantes
 * @subpackage model
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: Builder.php 7490 2010-03-29 19:53:27Z jwage $
 */
abstract class BaseConsultaCampo extends sfDoctrineRecord
{
    public function setTableDefinition()
    {
        $this->setTableName('consulta_campo');
        $this->hasColumn('id', 'integer', 4, array(
             'type' => 'integer',
             'primary' => true,
             'autoincrement' => true,
             'length' => 4,
             ));
        $this->hasColumn('nombre', 'string', 45, array(
             'type' => 'string',
             'notnull' => true,
             'length' => 45,
             ));
        $this->hasColumn('consulta_id', 'integer', 4, array(
             'type' => 'integer',
             'notnull' => true,
             'length' => 4,
             ));
    }

    public function setUp()
    {
        parent::setUp();
        $this->hasOne('Consulta', array(
             'local' => 'consulta_id',
             'foreign' => 'id'));
    }
}