<?php

/**
 * BaseTrasplanteComplicacionesInfecciosas
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 * 
 * @property integer $id
 * @property integer $trasplante_id
 * @property date $fecha
 * @property integer $medicacion_id
 * @property integer $infeccion_id
 * @property integer $germen_id
 * @property integer $internado
 * @property integer $dias_de_internacion
 * @property integer $evolucion
 * @property string $comentario
 * @property Medicaciones $Medicaciones
 * @property Trasplante $Trasplante
 * @property Infeccion $Infeccion
 * @property Germenes $Germenes
 * @property Doctrine_Collection $TrasplanteReoperacion
 * 
 * @method integer                             getId()                    Returns the current record's "id" value
 * @method integer                             getTrasplanteId()          Returns the current record's "trasplante_id" value
 * @method date                                getFecha()                 Returns the current record's "fecha" value
 * @method integer                             getMedicacionId()          Returns the current record's "medicacion_id" value
 * @method integer                             getInfeccionId()           Returns the current record's "infeccion_id" value
 * @method integer                             getGermenId()              Returns the current record's "germen_id" value
 * @method integer                             getInternado()             Returns the current record's "internado" value
 * @method integer                             getDiasDeInternacion()     Returns the current record's "dias_de_internacion" value
 * @method integer                             getEvolucion()             Returns the current record's "evolucion" value
 * @method string                              getComentario()            Returns the current record's "comentario" value
 * @method Medicaciones                        getMedicaciones()          Returns the current record's "Medicaciones" value
 * @method Trasplante                          getTrasplante()            Returns the current record's "Trasplante" value
 * @method Infeccion                           getInfeccion()             Returns the current record's "Infeccion" value
 * @method Germenes                            getGermenes()              Returns the current record's "Germenes" value
 * @method Doctrine_Collection                 getTrasplanteReoperacion() Returns the current record's "TrasplanteReoperacion" collection
 * @method TrasplanteComplicacionesInfecciosas setId()                    Sets the current record's "id" value
 * @method TrasplanteComplicacionesInfecciosas setTrasplanteId()          Sets the current record's "trasplante_id" value
 * @method TrasplanteComplicacionesInfecciosas setFecha()                 Sets the current record's "fecha" value
 * @method TrasplanteComplicacionesInfecciosas setMedicacionId()          Sets the current record's "medicacion_id" value
 * @method TrasplanteComplicacionesInfecciosas setInfeccionId()           Sets the current record's "infeccion_id" value
 * @method TrasplanteComplicacionesInfecciosas setGermenId()              Sets the current record's "germen_id" value
 * @method TrasplanteComplicacionesInfecciosas setInternado()             Sets the current record's "internado" value
 * @method TrasplanteComplicacionesInfecciosas setDiasDeInternacion()     Sets the current record's "dias_de_internacion" value
 * @method TrasplanteComplicacionesInfecciosas setEvolucion()             Sets the current record's "evolucion" value
 * @method TrasplanteComplicacionesInfecciosas setComentario()            Sets the current record's "comentario" value
 * @method TrasplanteComplicacionesInfecciosas setMedicaciones()          Sets the current record's "Medicaciones" value
 * @method TrasplanteComplicacionesInfecciosas setTrasplante()            Sets the current record's "Trasplante" value
 * @method TrasplanteComplicacionesInfecciosas setInfeccion()             Sets the current record's "Infeccion" value
 * @method TrasplanteComplicacionesInfecciosas setGermenes()              Sets the current record's "Germenes" value
 * @method TrasplanteComplicacionesInfecciosas setTrasplanteReoperacion() Sets the current record's "TrasplanteReoperacion" collection
 * 
 * @package    transplantes
 * @subpackage model
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: Builder.php 7490 2010-03-29 19:53:27Z jwage $
 */
abstract class BaseTrasplanteComplicacionesInfecciosas extends sfDoctrineRecord
{
    public function setTableDefinition()
    {
        $this->setTableName('trasplante_complicaciones_infecciosas');
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
        $this->hasColumn('infeccion_id', 'integer', 4, array(
             'type' => 'integer',
             'notnull' => true,
             'length' => 4,
             ));
        $this->hasColumn('germen_id', 'integer', 4, array(
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

        $this->hasOne('Infeccion', array(
             'local' => 'infeccion_id',
             'foreign' => 'id'));

        $this->hasOne('Germenes', array(
             'local' => 'germen_id',
             'foreign' => 'id'));

        $this->hasMany('TrasplanteReoperacion', array(
             'local' => 'id',
             'foreign' => 'trasplante_complicacion_infeccion_id'));
    }
}