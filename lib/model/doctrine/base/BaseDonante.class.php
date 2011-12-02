<?php

/**
 * BaseDonante
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 * 
 * @property integer $id
 * @property string $identificador
 * @property enum $tipo_donante
 * @property enum $sexo_donante
 * @property integer $edad_donante
 * @property integer $enastab_hemod
 * @property integer $donante_causa_muerte_id
 * @property float $cr_p
 * @property string $otros
 * @property enum $grupo_sanguineo
 * @property enum $relacion_filiar
 * @property integer $peso
 * @property float $altura
 * @property DonanteCausaMuerte $DonanteCausaMuerte
 * @property Doctrine_Collection $DonanteOrganos
 * @property Doctrine_Collection $DonanteAntecedentes
 * @property Doctrine_Collection $DonanteSerol
 * @property Doctrine_Collection $Trasplante
 * 
 * @method integer             getId()                      Returns the current record's "id" value
 * @method string              getIdentificador()           Returns the current record's "identificador" value
 * @method enum                getTipoDonante()             Returns the current record's "tipo_donante" value
 * @method enum                getSexoDonante()             Returns the current record's "sexo_donante" value
 * @method integer             getEdadDonante()             Returns the current record's "edad_donante" value
 * @method integer             getEnastabHemod()            Returns the current record's "enastab_hemod" value
 * @method integer             getDonanteCausaMuerteId()    Returns the current record's "donante_causa_muerte_id" value
 * @method float               getCrP()                     Returns the current record's "cr_p" value
 * @method string              getOtros()                   Returns the current record's "otros" value
 * @method enum                getGrupoSanguineo()          Returns the current record's "grupo_sanguineo" value
 * @method enum                getRelacionFiliar()          Returns the current record's "relacion_filiar" value
 * @method integer             getPeso()                    Returns the current record's "peso" value
 * @method float               getAltura()                  Returns the current record's "altura" value
 * @method DonanteCausaMuerte  getDonanteCausaMuerte()      Returns the current record's "DonanteCausaMuerte" value
 * @method Doctrine_Collection getDonanteOrganos()          Returns the current record's "DonanteOrganos" collection
 * @method Doctrine_Collection getDonanteAntecedentes()     Returns the current record's "DonanteAntecedentes" collection
 * @method Doctrine_Collection getDonanteSerol()            Returns the current record's "DonanteSerol" collection
 * @method Doctrine_Collection getTrasplante()              Returns the current record's "Trasplante" collection
 * @method Donante             setId()                      Sets the current record's "id" value
 * @method Donante             setIdentificador()           Sets the current record's "identificador" value
 * @method Donante             setTipoDonante()             Sets the current record's "tipo_donante" value
 * @method Donante             setSexoDonante()             Sets the current record's "sexo_donante" value
 * @method Donante             setEdadDonante()             Sets the current record's "edad_donante" value
 * @method Donante             setEnastabHemod()            Sets the current record's "enastab_hemod" value
 * @method Donante             setDonanteCausaMuerteId()    Sets the current record's "donante_causa_muerte_id" value
 * @method Donante             setCrP()                     Sets the current record's "cr_p" value
 * @method Donante             setOtros()                   Sets the current record's "otros" value
 * @method Donante             setGrupoSanguineo()          Sets the current record's "grupo_sanguineo" value
 * @method Donante             setRelacionFiliar()          Sets the current record's "relacion_filiar" value
 * @method Donante             setPeso()                    Sets the current record's "peso" value
 * @method Donante             setAltura()                  Sets the current record's "altura" value
 * @method Donante             setDonanteCausaMuerte()      Sets the current record's "DonanteCausaMuerte" value
 * @method Donante             setDonanteOrganos()          Sets the current record's "DonanteOrganos" collection
 * @method Donante             setDonanteAntecedentes()     Sets the current record's "DonanteAntecedentes" collection
 * @method Donante             setDonanteSerol()            Sets the current record's "DonanteSerol" collection
 * @method Donante             setTrasplante()              Sets the current record's "Trasplante" collection
 * 
 * @package    transplantes
 * @subpackage model
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: Builder.php 7490 2010-03-29 19:53:27Z jwage $
 */
abstract class BaseDonante extends sfDoctrineRecord
{
    public function setTableDefinition()
    {
        $this->setTableName('donante');
        $this->hasColumn('id', 'integer', 4, array(
             'type' => 'integer',
             'primary' => true,
             'autoincrement' => true,
             'length' => 4,
             ));
        $this->hasColumn('identificador', 'string', 20, array(
             'type' => 'string',
             'unique' => true,
             'length' => 20,
             ));
        $this->hasColumn('tipo_donante', 'enum', 10, array(
             'type' => 'enum',
             'length' => 10,
             'values' => 
             array(
              0 => 'Cadavérico',
              1 => 'Vivo',
             ),
             'notnull' => true,
             ));
        $this->hasColumn('sexo_donante', 'enum', 1, array(
             'type' => 'enum',
             'length' => 1,
             'values' => 
             array(
              0 => 'M',
              1 => 'F',
             ),
             'notnull' => true,
             ));
        $this->hasColumn('edad_donante', 'integer', 1, array(
             'type' => 'integer',
             'length' => 1,
             ));
        $this->hasColumn('enastab_hemod', 'integer', 1, array(
             'type' => 'integer',
             'length' => 1,
             ));
        $this->hasColumn('donante_causa_muerte_id', 'integer', 4, array(
             'type' => 'integer',
             'notnull' => true,
             'length' => 4,
             ));
        $this->hasColumn('cr_p', 'float', null, array(
             'type' => 'float',
             'default' => 0,
             'length' => '',
             ));
        $this->hasColumn('otros', 'string', 255, array(
             'type' => 'string',
             'length' => 255,
             ));
        $this->hasColumn('grupo_sanguineo', 'enum', 2, array(
             'type' => 'enum',
             'length' => 2,
             'values' => 
             array(
              0 => 'A',
              1 => 'B',
              2 => 'AB',
              3 => 'O',
             ),
             'notnull' => true,
             ));
        $this->hasColumn('relacion_filiar', 'enum', 13, array(
             'type' => 'enum',
             'length' => 13,
             'values' => 
             array(
              0 => 'sin relacion',
              1 => 'padre/madre',
              2 => 'hermano/a',
              3 => 'Hijo/a',
              4 => 'esposo/a',
              5 => 'otro',
             ),
             'default' => 'sin relacion',
             ));
        $this->hasColumn('peso', 'integer', 4, array(
             'type' => 'integer',
             'length' => 4,
             ));
        $this->hasColumn('altura', 'float', null, array(
             'type' => 'float',
             'length' => '',
             ));
    }

    public function setUp()
    {
        parent::setUp();
        $this->hasOne('DonanteCausaMuerte', array(
             'local' => 'donante_causa_muerte_id',
             'foreign' => 'id'));

        $this->hasMany('Organos as DonanteOrganos', array(
             'refClass' => 'DonanteOrganos',
             'local' => 'donante_id',
             'foreign' => 'organo_id'));

        $this->hasMany('AntecedentesDeDonante as DonanteAntecedentes', array(
             'refClass' => 'DonanteAntecedentes',
             'local' => 'donante_id',
             'foreign' => 'antecedente_de_donante_id'));

        $this->hasMany('DonanteSerol', array(
             'local' => 'id',
             'foreign' => 'donante_id'));

        $this->hasMany('Trasplante', array(
             'local' => 'id',
             'foreign' => 'donante_id'));
    }
}