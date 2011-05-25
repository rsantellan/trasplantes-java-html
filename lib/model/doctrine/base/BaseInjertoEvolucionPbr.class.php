<?php

/**
 * BaseInjertoEvolucionPbr
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 * 
 * @property integer $injerto_evolucion_id
 * @property integer $resultado_pbr_id
 * @property InjertoEvolucion $InjertoEvolucion
 * @property ResultadoPbr $ResultadoPbr
 * 
 * @method integer             getInjertoEvolucionId()   Returns the current record's "injerto_evolucion_id" value
 * @method integer             getResultadoPbrId()       Returns the current record's "resultado_pbr_id" value
 * @method InjertoEvolucion    getInjertoEvolucion()     Returns the current record's "InjertoEvolucion" value
 * @method ResultadoPbr        getResultadoPbr()         Returns the current record's "ResultadoPbr" value
 * @method InjertoEvolucionPbr setInjertoEvolucionId()   Sets the current record's "injerto_evolucion_id" value
 * @method InjertoEvolucionPbr setResultadoPbrId()       Sets the current record's "resultado_pbr_id" value
 * @method InjertoEvolucionPbr setInjertoEvolucion()     Sets the current record's "InjertoEvolucion" value
 * @method InjertoEvolucionPbr setResultadoPbr()         Sets the current record's "ResultadoPbr" value
 * 
 * @package    transplantes
 * @subpackage model
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: Builder.php 7490 2010-03-29 19:53:27Z jwage $
 */
abstract class BaseInjertoEvolucionPbr extends sfDoctrineRecord
{
    public function setTableDefinition()
    {
        $this->setTableName('injerto_evolucion_pbr');
        $this->hasColumn('injerto_evolucion_id', 'integer', 4, array(
             'type' => 'integer',
             'primary' => true,
             'length' => 4,
             ));
        $this->hasColumn('resultado_pbr_id', 'integer', 4, array(
             'type' => 'integer',
             'primary' => true,
             'length' => 4,
             ));
    }

    public function setUp()
    {
        parent::setUp();
        $this->hasOne('InjertoEvolucion', array(
             'local' => 'injerto_evolucion_id',
             'foreign' => 'id'));

        $this->hasOne('ResultadoPbr', array(
             'local' => 'resultado_pbr_id',
             'foreign' => 'id'));
    }
}