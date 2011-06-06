<?php

/**
 * BaseTrasplante
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 * 
 * @property integer $id
 * @property integer $paciente_pre_trasplante_id
 * @property date $fecha
 * @property integer $numero_de_transplantes_realizados
 * @property integer $donante_id
 * @property integer $inestab_hemodial
 * @property string $rinhon
 * @property integer $anomalia_vascular
 * @property integer $numero_arterias
 * @property integer $numero_venas
 * @property string $ureter
 * @property integer $numero_compatibilidad_ab
 * @property integer $numero_compatibilidad_dr
 * @property integer $numero_incompatibilidad_ab
 * @property integer $numero_incompatibilidad_dr
 * @property integer $autoac
 * @property string $pra_max
 * @property string $pra_tr
 * @property integer $trans_previas
 * @property integer $numero_transf
 * @property enum $embarazo
 * @property integer $numero_embarazo
 * @property enum $liquido_perfusion
 * @property integer $tq_de_banco
 * @property enum $lado_implante
 * @property enum $anast_venosa
 * @property enum $anast_arterial
 * @property enum $anast_ureteral
 * @property integer $t_isq_cal_min
 * @property integer $t_isq_fria_hs
 * @property integer $t_isq_fria_min
 * @property integer $t_isq_tibia_hs
 * @property enum $reperfusion
 * @property integer $sangrado_i_op
 * @property integer $lesion_arterial
 * @property integer $lesion_venosa
 * @property integer $necesidad_repefundir
 * @property string $otras_compl_quirur
 * @property integer $diuresis_i_op
 * @property float $cr_inicial
 * @property integer $dia_rec_diuresis
 * @property integer $dia_rec_funcional
 * @property integer $dialisis
 * @property integer $num_de_hd
 * @property string $comentario
 * @property date $fecha_alta
 * @property integer $edad_receptor
 * @property Pacientepretrasplante $Pacientepretrasplante
 * @property Donante $Donante
 * @property Doctrine_Collection $Cmv
 * @property Doctrine_Collection $TrasplanteSerol
 * @property Doctrine_Collection $TrasplanteComplicaciones
 * @property Doctrine_Collection $TrasplanteInduccion
 * @property Doctrine_Collection $TrasplanteInmunosupresores
 * @property Doctrine_Collection $EvolucionTrasplanteCmv
 * @property Doctrine_Collection $EvolucionTrasplanteEcg
 * @property Doctrine_Collection $EvolucionTrasplanteEcoCardio
 * @property Doctrine_Collection $EvolucionTrasplanteNutricion
 * @property Doctrine_Collection $EvolucionTrasplanteParaclinica
 * @property Doctrine_Collection $EvolucionTrasplanteEcodopler
 * @property Doctrine_Collection $EvolucionTrasplanteEcografia
 * @property Doctrine_Collection $EvolucionTrasplanteMarvirales
 * @property Doctrine_Collection $EvolucionTrasplanteTxtorax
 * @property Doctrine_Collection $EvolucionTrasplanteExamenes
 * @property Doctrine_Collection $TrasplanteReoperacion
 * @property Doctrine_Collection $InjertoEvolucion
 * 
 * @method integer               getId()                                Returns the current record's "id" value
 * @method integer               getPacientePreTrasplanteId()           Returns the current record's "paciente_pre_trasplante_id" value
 * @method date                  getFecha()                             Returns the current record's "fecha" value
 * @method integer               getNumeroDeTransplantesRealizados()    Returns the current record's "numero_de_transplantes_realizados" value
 * @method integer               getDonanteId()                         Returns the current record's "donante_id" value
 * @method integer               getInestabHemodial()                   Returns the current record's "inestab_hemodial" value
 * @method string                getRinhon()                            Returns the current record's "rinhon" value
 * @method integer               getAnomaliaVascular()                  Returns the current record's "anomalia_vascular" value
 * @method integer               getNumeroArterias()                    Returns the current record's "numero_arterias" value
 * @method integer               getNumeroVenas()                       Returns the current record's "numero_venas" value
 * @method string                getUreter()                            Returns the current record's "ureter" value
 * @method integer               getNumeroCompatibilidadAb()            Returns the current record's "numero_compatibilidad_ab" value
 * @method integer               getNumeroCompatibilidadDr()            Returns the current record's "numero_compatibilidad_dr" value
 * @method integer               getNumeroIncompatibilidadAb()          Returns the current record's "numero_incompatibilidad_ab" value
 * @method integer               getNumeroIncompatibilidadDr()          Returns the current record's "numero_incompatibilidad_dr" value
 * @method integer               getAutoac()                            Returns the current record's "autoac" value
 * @method string                getPraMax()                            Returns the current record's "pra_max" value
 * @method string                getPraTr()                             Returns the current record's "pra_tr" value
 * @method integer               getTransPrevias()                      Returns the current record's "trans_previas" value
 * @method integer               getNumeroTransf()                      Returns the current record's "numero_transf" value
 * @method enum                  getEmbarazo()                          Returns the current record's "embarazo" value
 * @method integer               getNumeroEmbarazo()                    Returns the current record's "numero_embarazo" value
 * @method enum                  getLiquidoPerfusion()                  Returns the current record's "liquido_perfusion" value
 * @method integer               getTqDeBanco()                         Returns the current record's "tq_de_banco" value
 * @method enum                  getLadoImplante()                      Returns the current record's "lado_implante" value
 * @method enum                  getAnastVenosa()                       Returns the current record's "anast_venosa" value
 * @method enum                  getAnastArterial()                     Returns the current record's "anast_arterial" value
 * @method enum                  getAnastUreteral()                     Returns the current record's "anast_ureteral" value
 * @method integer               getTIsqCalMin()                        Returns the current record's "t_isq_cal_min" value
 * @method integer               getTIsqFriaHs()                        Returns the current record's "t_isq_fria_hs" value
 * @method integer               getTIsqFriaMin()                       Returns the current record's "t_isq_fria_min" value
 * @method integer               getTIsqTibiaHs()                       Returns the current record's "t_isq_tibia_hs" value
 * @method enum                  getReperfusion()                       Returns the current record's "reperfusion" value
 * @method integer               getSangradoIOp()                       Returns the current record's "sangrado_i_op" value
 * @method integer               getLesionArterial()                    Returns the current record's "lesion_arterial" value
 * @method integer               getLesionVenosa()                      Returns the current record's "lesion_venosa" value
 * @method integer               getNecesidadRepefundir()               Returns the current record's "necesidad_repefundir" value
 * @method string                getOtrasComplQuirur()                  Returns the current record's "otras_compl_quirur" value
 * @method integer               getDiuresisIOp()                       Returns the current record's "diuresis_i_op" value
 * @method float                 getCrInicial()                         Returns the current record's "cr_inicial" value
 * @method integer               getDiaRecDiuresis()                    Returns the current record's "dia_rec_diuresis" value
 * @method integer               getDiaRecFuncional()                   Returns the current record's "dia_rec_funcional" value
 * @method integer               getDialisis()                          Returns the current record's "dialisis" value
 * @method integer               getNumDeHd()                           Returns the current record's "num_de_hd" value
 * @method string                getComentario()                        Returns the current record's "comentario" value
 * @method date                  getFechaAlta()                         Returns the current record's "fecha_alta" value
 * @method integer               getEdadReceptor()                      Returns the current record's "edad_receptor" value
 * @method Pacientepretrasplante getPacientepretrasplante()             Returns the current record's "Pacientepretrasplante" value
 * @method Donante               getDonante()                           Returns the current record's "Donante" value
 * @method Doctrine_Collection   getCmv()                               Returns the current record's "Cmv" collection
 * @method Doctrine_Collection   getTrasplanteSerol()                   Returns the current record's "TrasplanteSerol" collection
 * @method Doctrine_Collection   getTrasplanteComplicaciones()          Returns the current record's "TrasplanteComplicaciones" collection
 * @method Doctrine_Collection   getTrasplanteInduccion()               Returns the current record's "TrasplanteInduccion" collection
 * @method Doctrine_Collection   getTrasplanteInmunosupresores()        Returns the current record's "TrasplanteInmunosupresores" collection
 * @method Doctrine_Collection   getEvolucionTrasplanteCmv()            Returns the current record's "EvolucionTrasplanteCmv" collection
 * @method Doctrine_Collection   getEvolucionTrasplanteEcg()            Returns the current record's "EvolucionTrasplanteEcg" collection
 * @method Doctrine_Collection   getEvolucionTrasplanteEcoCardio()      Returns the current record's "EvolucionTrasplanteEcoCardio" collection
 * @method Doctrine_Collection   getEvolucionTrasplanteNutricion()      Returns the current record's "EvolucionTrasplanteNutricion" collection
 * @method Doctrine_Collection   getEvolucionTrasplanteParaclinica()    Returns the current record's "EvolucionTrasplanteParaclinica" collection
 * @method Doctrine_Collection   getEvolucionTrasplanteEcodopler()      Returns the current record's "EvolucionTrasplanteEcodopler" collection
 * @method Doctrine_Collection   getEvolucionTrasplanteEcografia()      Returns the current record's "EvolucionTrasplanteEcografia" collection
 * @method Doctrine_Collection   getEvolucionTrasplanteMarvirales()     Returns the current record's "EvolucionTrasplanteMarvirales" collection
 * @method Doctrine_Collection   getEvolucionTrasplanteTxtorax()        Returns the current record's "EvolucionTrasplanteTxtorax" collection
 * @method Doctrine_Collection   getEvolucionTrasplanteExamenes()       Returns the current record's "EvolucionTrasplanteExamenes" collection
 * @method Doctrine_Collection   getTrasplanteReoperacion()             Returns the current record's "TrasplanteReoperacion" collection
 * @method Doctrine_Collection   getInjertoEvolucion()                  Returns the current record's "InjertoEvolucion" collection
 * @method Trasplante            setId()                                Sets the current record's "id" value
 * @method Trasplante            setPacientePreTrasplanteId()           Sets the current record's "paciente_pre_trasplante_id" value
 * @method Trasplante            setFecha()                             Sets the current record's "fecha" value
 * @method Trasplante            setNumeroDeTransplantesRealizados()    Sets the current record's "numero_de_transplantes_realizados" value
 * @method Trasplante            setDonanteId()                         Sets the current record's "donante_id" value
 * @method Trasplante            setInestabHemodial()                   Sets the current record's "inestab_hemodial" value
 * @method Trasplante            setRinhon()                            Sets the current record's "rinhon" value
 * @method Trasplante            setAnomaliaVascular()                  Sets the current record's "anomalia_vascular" value
 * @method Trasplante            setNumeroArterias()                    Sets the current record's "numero_arterias" value
 * @method Trasplante            setNumeroVenas()                       Sets the current record's "numero_venas" value
 * @method Trasplante            setUreter()                            Sets the current record's "ureter" value
 * @method Trasplante            setNumeroCompatibilidadAb()            Sets the current record's "numero_compatibilidad_ab" value
 * @method Trasplante            setNumeroCompatibilidadDr()            Sets the current record's "numero_compatibilidad_dr" value
 * @method Trasplante            setNumeroIncompatibilidadAb()          Sets the current record's "numero_incompatibilidad_ab" value
 * @method Trasplante            setNumeroIncompatibilidadDr()          Sets the current record's "numero_incompatibilidad_dr" value
 * @method Trasplante            setAutoac()                            Sets the current record's "autoac" value
 * @method Trasplante            setPraMax()                            Sets the current record's "pra_max" value
 * @method Trasplante            setPraTr()                             Sets the current record's "pra_tr" value
 * @method Trasplante            setTransPrevias()                      Sets the current record's "trans_previas" value
 * @method Trasplante            setNumeroTransf()                      Sets the current record's "numero_transf" value
 * @method Trasplante            setEmbarazo()                          Sets the current record's "embarazo" value
 * @method Trasplante            setNumeroEmbarazo()                    Sets the current record's "numero_embarazo" value
 * @method Trasplante            setLiquidoPerfusion()                  Sets the current record's "liquido_perfusion" value
 * @method Trasplante            setTqDeBanco()                         Sets the current record's "tq_de_banco" value
 * @method Trasplante            setLadoImplante()                      Sets the current record's "lado_implante" value
 * @method Trasplante            setAnastVenosa()                       Sets the current record's "anast_venosa" value
 * @method Trasplante            setAnastArterial()                     Sets the current record's "anast_arterial" value
 * @method Trasplante            setAnastUreteral()                     Sets the current record's "anast_ureteral" value
 * @method Trasplante            setTIsqCalMin()                        Sets the current record's "t_isq_cal_min" value
 * @method Trasplante            setTIsqFriaHs()                        Sets the current record's "t_isq_fria_hs" value
 * @method Trasplante            setTIsqFriaMin()                       Sets the current record's "t_isq_fria_min" value
 * @method Trasplante            setTIsqTibiaHs()                       Sets the current record's "t_isq_tibia_hs" value
 * @method Trasplante            setReperfusion()                       Sets the current record's "reperfusion" value
 * @method Trasplante            setSangradoIOp()                       Sets the current record's "sangrado_i_op" value
 * @method Trasplante            setLesionArterial()                    Sets the current record's "lesion_arterial" value
 * @method Trasplante            setLesionVenosa()                      Sets the current record's "lesion_venosa" value
 * @method Trasplante            setNecesidadRepefundir()               Sets the current record's "necesidad_repefundir" value
 * @method Trasplante            setOtrasComplQuirur()                  Sets the current record's "otras_compl_quirur" value
 * @method Trasplante            setDiuresisIOp()                       Sets the current record's "diuresis_i_op" value
 * @method Trasplante            setCrInicial()                         Sets the current record's "cr_inicial" value
 * @method Trasplante            setDiaRecDiuresis()                    Sets the current record's "dia_rec_diuresis" value
 * @method Trasplante            setDiaRecFuncional()                   Sets the current record's "dia_rec_funcional" value
 * @method Trasplante            setDialisis()                          Sets the current record's "dialisis" value
 * @method Trasplante            setNumDeHd()                           Sets the current record's "num_de_hd" value
 * @method Trasplante            setComentario()                        Sets the current record's "comentario" value
 * @method Trasplante            setFechaAlta()                         Sets the current record's "fecha_alta" value
 * @method Trasplante            setEdadReceptor()                      Sets the current record's "edad_receptor" value
 * @method Trasplante            setPacientepretrasplante()             Sets the current record's "Pacientepretrasplante" value
 * @method Trasplante            setDonante()                           Sets the current record's "Donante" value
 * @method Trasplante            setCmv()                               Sets the current record's "Cmv" collection
 * @method Trasplante            setTrasplanteSerol()                   Sets the current record's "TrasplanteSerol" collection
 * @method Trasplante            setTrasplanteComplicaciones()          Sets the current record's "TrasplanteComplicaciones" collection
 * @method Trasplante            setTrasplanteInduccion()               Sets the current record's "TrasplanteInduccion" collection
 * @method Trasplante            setTrasplanteInmunosupresores()        Sets the current record's "TrasplanteInmunosupresores" collection
 * @method Trasplante            setEvolucionTrasplanteCmv()            Sets the current record's "EvolucionTrasplanteCmv" collection
 * @method Trasplante            setEvolucionTrasplanteEcg()            Sets the current record's "EvolucionTrasplanteEcg" collection
 * @method Trasplante            setEvolucionTrasplanteEcoCardio()      Sets the current record's "EvolucionTrasplanteEcoCardio" collection
 * @method Trasplante            setEvolucionTrasplanteNutricion()      Sets the current record's "EvolucionTrasplanteNutricion" collection
 * @method Trasplante            setEvolucionTrasplanteParaclinica()    Sets the current record's "EvolucionTrasplanteParaclinica" collection
 * @method Trasplante            setEvolucionTrasplanteEcodopler()      Sets the current record's "EvolucionTrasplanteEcodopler" collection
 * @method Trasplante            setEvolucionTrasplanteEcografia()      Sets the current record's "EvolucionTrasplanteEcografia" collection
 * @method Trasplante            setEvolucionTrasplanteMarvirales()     Sets the current record's "EvolucionTrasplanteMarvirales" collection
 * @method Trasplante            setEvolucionTrasplanteTxtorax()        Sets the current record's "EvolucionTrasplanteTxtorax" collection
 * @method Trasplante            setEvolucionTrasplanteExamenes()       Sets the current record's "EvolucionTrasplanteExamenes" collection
 * @method Trasplante            setTrasplanteReoperacion()             Sets the current record's "TrasplanteReoperacion" collection
 * @method Trasplante            setInjertoEvolucion()                  Sets the current record's "InjertoEvolucion" collection
 * 
 * @package    transplantes
 * @subpackage model
 * @author     Rodrigo Santellan
 * @version    SVN: $Id: Builder.php 7490 2010-03-29 19:53:27Z jwage $
 */
abstract class BaseTrasplante extends sfDoctrineRecord
{
    public function setTableDefinition()
    {
        $this->setTableName('trasplante');
        $this->hasColumn('id', 'integer', 4, array(
             'type' => 'integer',
             'primary' => true,
             'autoincrement' => true,
             'length' => 4,
             ));
        $this->hasColumn('paciente_pre_trasplante_id', 'integer', 4, array(
             'type' => 'integer',
             'notnull' => true,
             'length' => 4,
             ));
        $this->hasColumn('fecha', 'date', 25, array(
             'type' => 'date',
             'notnull' => true,
             'length' => 25,
             ));
        $this->hasColumn('numero_de_transplantes_realizados', 'integer', 4, array(
             'type' => 'integer',
             'length' => 4,
             ));
        $this->hasColumn('donante_id', 'integer', 4, array(
             'type' => 'integer',
             'notnull' => true,
             'length' => 4,
             ));
        $this->hasColumn('inestab_hemodial', 'integer', 1, array(
             'type' => 'integer',
             'length' => 1,
             ));
        $this->hasColumn('rinhon', 'string', 10, array(
             'type' => 'string',
             'length' => 10,
             ));
        $this->hasColumn('anomalia_vascular', 'integer', 1, array(
             'type' => 'integer',
             'length' => 1,
             ));
        $this->hasColumn('numero_arterias', 'integer', 1, array(
             'type' => 'integer',
             'length' => 1,
             ));
        $this->hasColumn('numero_venas', 'integer', 1, array(
             'type' => 'integer',
             'length' => 1,
             ));
        $this->hasColumn('ureter', 'string', 5, array(
             'type' => 'string',
             'length' => 5,
             ));
        $this->hasColumn('numero_compatibilidad_ab', 'integer', 3, array(
             'type' => 'integer',
             'length' => 3,
             ));
        $this->hasColumn('numero_compatibilidad_dr', 'integer', 3, array(
             'type' => 'integer',
             'length' => 3,
             ));
        $this->hasColumn('numero_incompatibilidad_ab', 'integer', 3, array(
             'type' => 'integer',
             'length' => 3,
             ));
        $this->hasColumn('numero_incompatibilidad_dr', 'integer', 3, array(
             'type' => 'integer',
             'length' => 3,
             ));
        $this->hasColumn('autoac', 'integer', 1, array(
             'type' => 'integer',
             'length' => 1,
             ));
        $this->hasColumn('pra_max', 'string', 10, array(
             'type' => 'string',
             'length' => 10,
             ));
        $this->hasColumn('pra_tr', 'string', 20, array(
             'type' => 'string',
             'length' => 20,
             ));
        $this->hasColumn('trans_previas', 'integer', 1, array(
             'type' => 'integer',
             'length' => 1,
             ));
        $this->hasColumn('numero_transf', 'integer', 1, array(
             'type' => 'integer',
             'length' => 1,
             ));
        $this->hasColumn('embarazo', 'enum', 9, array(
             'type' => 'enum',
             'length' => 9,
             'values' => 
             array(
              0 => 'si',
              1 => 'no',
              2 => 'no aplica',
             ),
             'notnull' => true,
             'default' => 'no aplica',
             ));
        $this->hasColumn('numero_embarazo', 'integer', 1, array(
             'type' => 'integer',
             'default' => 0,
             'length' => 1,
             ));
        $this->hasColumn('liquido_perfusion', 'enum', 12, array(
             'type' => 'enum',
             'length' => 12,
             'values' => 
             array(
              0 => 'Eurocollins',
              1 => 'WC',
              2 => 'Custodiol',
              3 => 'Otro',
             ),
             'notnull' => true,
             ));
        $this->hasColumn('tq_de_banco', 'integer', 1, array(
             'type' => 'integer',
             'length' => 1,
             ));
        $this->hasColumn('lado_implante', 'enum', 12, array(
             'type' => 'enum',
             'length' => 12,
             'values' => 
             array(
              0 => 'Derecho',
              1 => 'Izquierdo',
             ),
             'notnull' => true,
             ));
        $this->hasColumn('anast_venosa', 'enum', 17, array(
             'type' => 'enum',
             'length' => 17,
             'values' => 
             array(
              0 => 'Termino lateral',
              1 => 'Termino terminal',
              2 => 'otra',
             ),
             'notnull' => true,
             ));
        $this->hasColumn('anast_arterial', 'enum', 17, array(
             'type' => 'enum',
             'length' => 17,
             'values' => 
             array(
              0 => 'Termino lateral',
              1 => 'Termino terminal',
              2 => 'otra',
             ),
             'notnull' => true,
             ));
        $this->hasColumn('anast_ureteral', 'enum', 9, array(
             'type' => 'enum',
             'length' => 9,
             'values' => 
             array(
              0 => 'Alferez',
              1 => 'Taguchi',
              2 => 'Gregoire',
              3 => 'Lick',
              4 => 'Otra',
             ),
             'notnull' => true,
             ));
        $this->hasColumn('t_isq_cal_min', 'integer', 3, array(
             'type' => 'integer',
             'default' => 0,
             'length' => 3,
             ));
        $this->hasColumn('t_isq_fria_hs', 'integer', 3, array(
             'type' => 'integer',
             'default' => 0,
             'length' => 3,
             ));
        $this->hasColumn('t_isq_fria_min', 'integer', 3, array(
             'type' => 'integer',
             'default' => 0,
             'length' => 3,
             ));
        $this->hasColumn('t_isq_tibia_hs', 'integer', 3, array(
             'type' => 'integer',
             'default' => 0,
             'length' => 3,
             ));
        $this->hasColumn('reperfusion', 'enum', 7, array(
             'type' => 'enum',
             'length' => 7,
             'values' => 
             array(
              0 => 'buena',
              1 => 'regular',
              2 => 'mala',
             ),
             'notnull' => true,
             ));
        $this->hasColumn('sangrado_i_op', 'integer', 1, array(
             'type' => 'integer',
             'length' => 1,
             ));
        $this->hasColumn('lesion_arterial', 'integer', 1, array(
             'type' => 'integer',
             'length' => 1,
             ));
        $this->hasColumn('lesion_venosa', 'integer', 1, array(
             'type' => 'integer',
             'length' => 1,
             ));
        $this->hasColumn('necesidad_repefundir', 'integer', 1, array(
             'type' => 'integer',
             'length' => 1,
             ));
        $this->hasColumn('otras_compl_quirur', 'string', 250, array(
             'type' => 'string',
             'length' => 250,
             ));
        $this->hasColumn('diuresis_i_op', 'integer', 1, array(
             'type' => 'integer',
             'length' => 1,
             ));
        $this->hasColumn('cr_inicial', 'float', null, array(
             'type' => 'float',
             'default' => 0,
             'length' => '',
             ));
        $this->hasColumn('dia_rec_diuresis', 'integer', 2, array(
             'type' => 'integer',
             'default' => 0,
             'length' => 2,
             ));
        $this->hasColumn('dia_rec_funcional', 'integer', 2, array(
             'type' => 'integer',
             'default' => 0,
             'length' => 2,
             ));
        $this->hasColumn('dialisis', 'integer', 1, array(
             'type' => 'integer',
             'length' => 1,
             ));
        $this->hasColumn('num_de_hd', 'integer', 2, array(
             'type' => 'integer',
             'length' => 2,
             ));
        $this->hasColumn('comentario', 'string', 255, array(
             'type' => 'string',
             'length' => 255,
             ));
        $this->hasColumn('fecha_alta', 'date', 25, array(
             'type' => 'date',
             'length' => 25,
             ));
        $this->hasColumn('edad_receptor', 'integer', 2, array(
             'type' => 'integer',
             'default' => 0,
             'length' => 2,
             ));
    }

    public function setUp()
    {
        parent::setUp();
        $this->hasOne('Pacientepretrasplante', array(
             'local' => 'paciente_pre_trasplante_id',
             'foreign' => 'id',
             'onDelete' => 'CASCADE'));

        $this->hasOne('Donante', array(
             'local' => 'donante_id',
             'foreign' => 'id'));

        $this->hasMany('Cmv', array(
             'local' => 'id',
             'foreign' => 'trasplante_id'));

        $this->hasMany('TrasplanteSerol', array(
             'local' => 'id',
             'foreign' => 'trasplante_id'));

        $this->hasMany('TrasplanteComplicaciones', array(
             'local' => 'id',
             'foreign' => 'trasplante_id'));

        $this->hasMany('TrasplanteInduccion', array(
             'local' => 'id',
             'foreign' => 'trasplante_id'));

        $this->hasMany('TrasplanteInmunosupresores', array(
             'local' => 'id',
             'foreign' => 'trasplante_id'));

        $this->hasMany('EvolucionTrasplanteCmv', array(
             'local' => 'id',
             'foreign' => 'trasplante_id'));

        $this->hasMany('EvolucionTrasplanteEcg', array(
             'local' => 'id',
             'foreign' => 'trasplante_id'));

        $this->hasMany('EvolucionTrasplanteEcoCardio', array(
             'local' => 'id',
             'foreign' => 'trasplante_id'));

        $this->hasMany('EvolucionTrasplanteNutricion', array(
             'local' => 'id',
             'foreign' => 'trasplante_id'));

        $this->hasMany('EvolucionTrasplanteParaclinica', array(
             'local' => 'id',
             'foreign' => 'trasplante_id'));

        $this->hasMany('EvolucionTrasplanteEcodopler', array(
             'local' => 'id',
             'foreign' => 'trasplante_id'));

        $this->hasMany('EvolucionTrasplanteEcografia', array(
             'local' => 'id',
             'foreign' => 'trasplante_id'));

        $this->hasMany('EvolucionTrasplanteMarvirales', array(
             'local' => 'id',
             'foreign' => 'trasplante_id'));

        $this->hasMany('EvolucionTrasplanteTxtorax', array(
             'local' => 'id',
             'foreign' => 'trasplante_id'));

        $this->hasMany('EvolucionTrasplanteExamenes', array(
             'local' => 'id',
             'foreign' => 'trasplante_id'));

        $this->hasMany('TrasplanteReoperacion', array(
             'local' => 'id',
             'foreign' => 'trasplante_id'));

        $this->hasMany('InjertoEvolucion', array(
             'local' => 'id',
             'foreign' => 'trasplante_id'));

        $timestampable0 = new Doctrine_Template_Timestampable(array(
             ));
        $this->actAs($timestampable0);
    }
}