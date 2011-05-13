<?php

/**
 * BaseTrasplanteComplicaciones
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 * 
 * @property integer $id
 * @property integer $trasplante_id
 * @property date $fecha
 * @property integer $medicacion_id
 * @property integer $internado
 * @property integer $dias_de_internacion
 * @property integer $evolucion
 * @property string $comentario
 * @property integer $infecciosa
 * @property Medicaciones $Medicaciones
 * @property Trasplante $Trasplante
 * @property Doctrine_Collection $ComplicacionesNoInfecciosas
 * 
 * @method integer                  getId()                          Returns the current record's "id" value
 * @method integer                  getTrasplanteId()                Returns the current record's "trasplante_id" value
 * @method date                     getFecha()                       Returns the current record's "fecha" value
 * @method integer                  getMedicacionId()                Returns the current record's "medicacion_id" value
 * @method integer                  getInternado()                   Returns the current record's "internado" value
 * @method integer                  getDiasDeInternacion()           Returns the current record's "dias_de_internacion" value
 * @method integer                  getEvolucion()                   Returns the current record's "evolucion" value
 * @method string                   getComentario()                  Returns the current record's "comentario" value
 * @method integer                  getInfecciosa()                  Returns the current record's "infecciosa" value
 * @method Medicaciones             getMedicaciones()                Returns the current record's "Medicaciones" value
 * @method Trasplante               getTrasplante()                  Returns the current record's "Trasplante" value
 * @method Doctrine_Collection      getComplicacionesNoInfecciosas() Returns the current record's "ComplicacionesNoInfecciosas" collection
 * @method TrasplanteComplicaciones setId()                          Sets the current record's "id" value
 * @method TrasplanteComplicaciones setTrasplanteId()                Sets the current record's "trasplante_id" value
 * @method TrasplanteComplicaciones setFecha()                       Sets the current record's "fecha" value
 * @method TrasplanteComplicaciones setMedicacionId()                Sets the current record's "medicacion_id" value
 * @method TrasplanteComplicaciones setInternado()                   Sets the current record's "internado" value
 * @method TrasplanteComplicaciones setDiasDeInternacion()           Sets the current record's "dias_de_internacion" value
 * @method TrasplanteComplicaciones setEvolucion()                   Sets the current record's "evolucion" value
 * @method TrasplanteComplicaciones setComentario()                  Sets the current record's "comentario" value
 * @method TrasplanteComplicaciones setInfecciosa()                  Sets the current record's "infecciosa" value
 * @method TrasplanteComplicaciones setMedicaciones()                Sets the current record's "Medicaciones" value
 * @method TrasplanteComplicaciones setTrasplante()                  Sets the current record's "Trasplante" value
 * @method TrasplanteComplicaciones setComplicacionesNoInfecciosas() Sets the current record's "ComplicacionesNoInfecciosas" collection
 * 
 * @package    transplantes
 * @subpackage model
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: Builder.php 7490 2010-03-29 19:53:27Z jwage $
 */
abstract class BaseTrasplanteComplicaciones extends sfDoctrineRecord
{
    public function setTableDefinition()
    {
        $this->setTableName('trasplante_complicaciones');
        $this->hasColumn('id', 'integer', 4, array(
             'type' => 'integer',
             'primary' => true,
             'autoincrement' => true,
             'length' => 4,
             ));
        $this->hasColumn('trasplante_id', 'integer', 4, array(
             'type' => 'integer',
             'notnull' => true,
             'length' => 4,
             ));
        $this->hasColumn('fecha', 'date', 25, array(
             'type' => 'date',
             'notnull' => true,
             'length' => 25,
             ));
        $this->hasColumn('medicacion_id', 'integer', 4, array(
             'type' => 'integer',
             'notnull' => true,
             'length' => 4,
             ));
        $this->hasColumn('internado', 'integer', 1, array(
             'type' => 'integer',
             'notnull' => true,
             'length' => 1,
             ));
        $this->hasColumn('dias_de_internacion', 'integer', 2, array(
             'type' => 'integer',
             'default' => 0,
             'length' => 2,
             ));
        $this->hasColumn('evolucion', 'integer', 1, array(
             'type' => 'integer',
             'notnull' => true,
             'length' => 1,
             ));
        $this->hasColumn('comentario', 'string', 1000, array(
             'type' => 'string',
             'length' => 1000,
             ));
        $this->hasColumn('infecciosa', 'integer', 1, array(
             'type' => 'integer',
             'notnull' => true,
             'default' => 0,
             'length' => 1,
             ));
    }

    public function setUp()
    {
        parent::setUp();
        $this->hasOne('Medicaciones', array(
             'local' => 'medicacion_id',
             'foreign' => 'id'));

        $this->hasOne('Trasplante', array(
             'local' => 'trasplante_id',
             'foreign' => 'id'));

        $this->hasMany('ComplicacionesNoInfecciosas', array(
             'local' => 'id',
             'foreign' => 'tr_complicacion_id'));
    }
}