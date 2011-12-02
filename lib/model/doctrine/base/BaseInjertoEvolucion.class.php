<?php

/**
 * BaseInjertoEvolucion
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 * 
 * @property integer $id
 * @property integer $trasplante_id
 * @property date $fecha
 * @property integer $tm
 * @property string $tm_cual
 * @property integer $gp_de_novo
 * @property integer $recidiva_gp_de_novo
 * @property integer $ra
 * @property integer $rc
 * @property integer $ra_tratamiento_id
 * @property integer $en_trasplante
 * @property Trasplante $Trasplante
 * @property Ratratamiento $Ratratamiento
 * @property Doctrine_Collection $InjertoEvolucionPbr
 * 
 * @method integer             getId()                   Returns the current record's "id" value
 * @method integer             getTrasplanteId()         Returns the current record's "trasplante_id" value
 * @method date                getFecha()                Returns the current record's "fecha" value
 * @method integer             getTm()                   Returns the current record's "tm" value
 * @method string              getTmCual()               Returns the current record's "tm_cual" value
 * @method integer             getGpDeNovo()             Returns the current record's "gp_de_novo" value
 * @method integer             getRecidivaGpDeNovo()     Returns the current record's "recidiva_gp_de_novo" value
 * @method integer             getRa()                   Returns the current record's "ra" value
 * @method integer             getRc()                   Returns the current record's "rc" value
 * @method integer             getRaTratamientoId()      Returns the current record's "ra_tratamiento_id" value
 * @method integer             getEnTrasplante()         Returns the current record's "en_trasplante" value
 * @method Trasplante          getTrasplante()           Returns the current record's "Trasplante" value
 * @method Ratratamiento       getRatratamiento()        Returns the current record's "Ratratamiento" value
 * @method Doctrine_Collection getInjertoEvolucionPbrs() Returns the current record's "InjertoEvolucionPbrs" collection
 * @method Doctrine_Collection getInjertoEvolucionPbr()  Returns the current record's "InjertoEvolucionPbr" collection
 * @method InjertoEvolucion    setId()                   Sets the current record's "id" value
 * @method InjertoEvolucion    setTrasplanteId()         Sets the current record's "trasplante_id" value
 * @method InjertoEvolucion    setFecha()                Sets the current record's "fecha" value
 * @method InjertoEvolucion    setTm()                   Sets the current record's "tm" value
 * @method InjertoEvolucion    setTmCual()               Sets the current record's "tm_cual" value
 * @method InjertoEvolucion    setGpDeNovo()             Sets the current record's "gp_de_novo" value
 * @method InjertoEvolucion    setRecidivaGpDeNovo()     Sets the current record's "recidiva_gp_de_novo" value
 * @method InjertoEvolucion    setRa()                   Sets the current record's "ra" value
 * @method InjertoEvolucion    setRc()                   Sets the current record's "rc" value
 * @method InjertoEvolucion    setRaTratamientoId()      Sets the current record's "ra_tratamiento_id" value
 * @method InjertoEvolucion    setEnTrasplante()         Sets the current record's "en_trasplante" value
 * @method InjertoEvolucion    setTrasplante()           Sets the current record's "Trasplante" value
 * @method InjertoEvolucion    setRatratamiento()        Sets the current record's "Ratratamiento" value
 * @method InjertoEvolucion    setInjertoEvolucionPbrs() Sets the current record's "InjertoEvolucionPbrs" collection
 * @method InjertoEvolucion    setInjertoEvolucionPbr()  Sets the current record's "InjertoEvolucionPbr" collections
 * @property Doctrine_Collection $InjertoEvolucionPbr
 * 
 * @method integer             getId()                   Returns the current record's "id" value
 * @method integer             getTrasplanteId()         Returns the current record's "trasplante_id" value
 * @method date                getFecha()                Returns the current record's "fecha" value
 * @method integer             getTm()                   Returns the current record's "tm" value
 * @method string              getTmCual()               Returns the current record's "tm_cual" value
 * @method integer             getGpDeNovo()             Returns the current record's "gp_de_novo" value
 * @method integer             getRecidivaGpDeNovo()     Returns the current record's "recidiva_gp_de_novo" value
 * @method integer             getRa()                   Returns the current record's "ra" value
 * @method integer             getRc()                   Returns the current record's "rc" value
 * @method integer             getRaTratamientoId()      Returns the current record's "ra_tratamiento_id" value
 * @method integer             getEnTrasplante()         Returns the current record's "en_trasplante" value
 * @method Trasplante          getTrasplante()           Returns the current record's "Trasplante" value
 * @method Ratratamiento       getRatratamiento()        Returns the current record's "Ratratamiento" value
 * @method Doctrine_Collection getInjertoEvolucionPbrs() Returns the current record's "InjertoEvolucionPbrs" collection
 * @method Doctrine_Collection getInjertoEvolucionPbr()  Returns the current record's "InjertoEvolucionPbr" collection
 * @method InjertoEvolucion    setId()                   Sets the current record's "id" value
 * @method InjertoEvolucion    setTrasplanteId()         Sets the current record's "trasplante_id" value
 * @method InjertoEvolucion    setFecha()                Sets the current record's "fecha" value
 * @method InjertoEvolucion    setTm()                   Sets the current record's "tm" value
 * @method InjertoEvolucion    setTmCual()               Sets the current record's "tm_cual" value
 * @method InjertoEvolucion    setGpDeNovo()             Sets the current record's "gp_de_novo" value
 * @method InjertoEvolucion    setRecidivaGpDeNovo()     Sets the current record's "recidiva_gp_de_novo" value
 * @method InjertoEvolucion    setRa()                   Sets the current record's "ra" value
 * @method InjertoEvolucion    setRc()                   Sets the current record's "rc" value
 * @method InjertoEvolucion    setRaTratamientoId()      Sets the current record's "ra_tratamiento_id" value
 * @method InjertoEvolucion    setEnTrasplante()         Sets the current record's "en_trasplante" value
 * @method InjertoEvolucion    setTrasplante()           Sets the current record's "Trasplante" value
 * @method InjertoEvolucion    setRatratamiento()        Sets the current record's "Ratratamiento" value
 * @method InjertoEvolucion    setInjertoEvolucionPbrs() Sets the current record's "InjertoEvolucionPbrs" collection
 * @method InjertoEvolucion    setInjertoEvolucionPbr()  Sets the current record's "InjertoEvolucionPbr" collection
 * 
 * @package    transplantes
 * @subpackage model
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: Builder.php 7490 2010-03-29 19:53:27Z jwage $
 */
abstract class BaseInjertoEvolucion extends sfDoctrineRecord
{
    public function setTableDefinition()
    {
        $this->setTableName('injerto_evolucion');
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
        $this->hasColumn('tm', 'integer', 1, array(
             'type' => 'integer',
             'default' => 0,
             'length' => 1,
             ));
        $this->hasColumn('tm_cual', 'string', 255, array(
             'type' => 'string',
             'length' => 255,
             ));
        $this->hasColumn('gp_de_novo', 'integer', 1, array(
             'type' => 'integer',
             'default' => 0,
             'length' => 1,
             ));
        $this->hasColumn('recidiva_gp_de_novo', 'integer', 1, array(
             'type' => 'integer',
             'default' => 0,
             'length' => 1,
             ));
        $this->hasColumn('ra', 'integer', 1, array(
             'type' => 'integer',
             'default' => 0,
             'length' => 1,
             ));
        $this->hasColumn('rc', 'integer', 1, array(
             'type' => 'integer',
             'default' => 0,
             'length' => 1,
             ));
        $this->hasColumn('ra_tratamiento_id', 'integer', 4, array(
             'type' => 'integer',
             'notnull' => true,
             'length' => 4,
             ));
        $this->hasColumn('en_trasplante', 'integer', 1, array(
             'type' => 'integer',
             'default' => 0,
             'length' => 1,
             ));
    }

    public function setUp()
    {
        parent::setUp();
        $this->hasOne('Trasplante', array(
             'local' => 'trasplante_id',
             'foreign' => 'id'));

        $this->hasOne('Ratratamiento', array(
             'local' => 'ra_tratamiento_id',
             'foreign' => 'id'));

        $this->hasMany('ResultadoPbr as InjertoEvolucionPbrs', array(
             'refClass' => 'InjertoEvolucionPbr',
             'local' => 'injerto_evolucion_id',
             'foreign' => 'resultado_pbr_id'));

        $this->hasMany('InjertoEvolucionPbr', array(
             'local' => 'id',
             'foreign' => 'injerto_evolucion_id'));
    }
}