<?php

/**
 * BaseTratamiento
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 * 
 * @property integer $id
 * @property integer $paciente_id
 * @property integer $medicacion_id
 * @property string $dosis
 * @property date $fecha_inicio
 * @property date $fecha_fin
 * @property Pacientes $Pacientes
 * @property Medicaciones $Medicaciones
 * 
 * @method integer      getId()            Returns the current record's "id" value
 * @method integer      getPacienteId()    Returns the current record's "paciente_id" value
 * @method integer      getMedicacionId()  Returns the current record's "medicacion_id" value
 * @method string       getDosis()         Returns the current record's "dosis" value
 * @method date         getFechaInicio()   Returns the current record's "fecha_inicio" value
 * @method date         getFechaFin()      Returns the current record's "fecha_fin" value
 * @method Pacientes    getPacientes()     Returns the current record's "Pacientes" value
 * @method Medicaciones getMedicaciones()  Returns the current record's "Medicaciones" value
 * @method Tratamiento  setId()            Sets the current record's "id" value
 * @method Tratamiento  setPacienteId()    Sets the current record's "paciente_id" value
 * @method Tratamiento  setMedicacionId()  Sets the current record's "medicacion_id" value
 * @method Tratamiento  setDosis()         Sets the current record's "dosis" value
 * @method Tratamiento  setFechaInicio()   Sets the current record's "fecha_inicio" value
 * @method Tratamiento  setFechaFin()      Sets the current record's "fecha_fin" value
 * @method Tratamiento  setPacientes()     Sets the current record's "Pacientes" value
 * @method Tratamiento  setMedicaciones()  Sets the current record's "Medicaciones" value
 * 
 * @package    transplantes
 * @subpackage model
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: Builder.php 7490 2010-03-29 19:53:27Z jwage $
 */
abstract class BaseTratamiento extends sfDoctrineRecord
{
    public function setTableDefinition()
    {
        $this->setTableName('tratamiento');
        $this->hasColumn('id', 'integer', 4, array(
             'type' => 'integer',
             'primary' => true,
             'autoincrement' => true,
             'length' => 4,
             ));
        $this->hasColumn('paciente_id', 'integer', 4, array(
             'type' => 'integer',
             'notnull' => true,
             'length' => 4,
             ));
        $this->hasColumn('medicacion_id', 'integer', 4, array(
             'type' => 'integer',
             'notnull' => false,
             'length' => 4,
             ));
        $this->hasColumn('dosis', 'string', 50, array(
             'type' => 'string',
             'default' => '-',
             'length' => 50,
             ));
        $this->hasColumn('fecha_inicio', 'date', 25, array(
             'type' => 'date',
             'notnull' => true,
             'length' => 25,
             ));
        $this->hasColumn('fecha_fin', 'date', 25, array(
             'type' => 'date',
             'length' => 25,
             ));
    }

    public function setUp()
    {
        parent::setUp();
        $this->hasOne('Pacientes', array(
             'local' => 'paciente_id',
             'foreign' => 'id',
             'onDelete' => 'CASCADE'));

        $this->hasOne('Medicaciones', array(
             'local' => 'medicacion_id',
             'foreign' => 'id'));
    }
}