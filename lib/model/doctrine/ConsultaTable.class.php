<?php

/**
 * ConsultaTable
 * 
 * This class has been auto-generated by the Doctrine ORM Framework
 */
class ConsultaTable extends Doctrine_Table
{
    /**
     * Returns an instance of this class.
     *
     * @return object ConsultaTable
     */
    public static function getInstance()
    {
        return Doctrine_Core::getTable('Consulta');
    }
    
	public function retrieveConsultaTotalReporteDeFondo($year = NULL)
	{
	  $sql = "select 
				p.id AS P_ID, 
				ppt.id AS PPT_ID, 
				t.id AS T_ID, 
				p.fecha_dialisis AS FECHA_DIALISIS,
				p.sin_dialisis AS SIN_DIALISIS, 
				t.fecha AS T_FECHA, 
				'THE' AS CENTRO, 
				ppt.the AS THE,
                                p.nombre AS NOMBRE,
                                p.apellido AS APELLIDO,
				ppt.diabetes AS DIABETES, 
				n.nombre AS NEFROPATIA, 
				MONTH(t.fecha) AS MES_TRASPLANTE, 
				YEAR(t.fecha) AS FECHA_TRASPLANTE,
				MONTH(t.fecha_alta) AS MES_ALTA, 
				YEAR(t.fecha_alta) AS FECHA_ALTA,
				t.edad_receptor AS EDAD_RECEPTOR, 
				p.sexo AS SEXO, 
				ppt.meses_en_lista AS MESES_EN_LISTA, 
				d.edad_donante AS EDAD_DONANTE, 
				d.sexo_donante AS SEXO_DONANTE, 
				d.tipo_donante AS TIPO_DONANTE, 
				dcm.nombre AS CAUSA_MUERTE_DONANTE, 
				t.numero_incompatibilidad_ab AS NUMERO_INCOMPATIBILIDAD_AB, 
				t.numero_incompatibilidad_dr AS NUMERO_INCOMPATIBILIDAD_DR,  
				t.t_isq_fria_hs AS T_ISQ_FRIA_HS,
				t.t_isq_fria_min AS T_ISQ_FRIA_MIN 
			  from 
				trasplante t, 
				paciente_pre_trasplante ppt, 
				pacientes p, 
				nefropatia n, 
				donante d, 
				donante_causa_muerte dcm 
			  where 
				t.paciente_pre_trasplante_id = ppt.id 
			  and 
				ppt.paciente_id = p.id 
			  and 
				n.id = p.nefropatia_id 
			  and 
				t.donante_id = d.id 
			  and 
				dcm.id = d.donante_causa_muerte_id ";
		$params = array();
		if(!is_null($year))
		{
		  $sql .= "and YEAR(t.fecha) = ?";
		  $params[] = $year;
		}
	
		$sql .= " order by t.fecha asc";
	  $conn = Doctrine_Manager::getInstance()->getCurrentConnection(); 
      return $conn->fetchAssoc($sql, $params);
	}
	
	public function retrievePacienteCausaDeMuerte($paciente_id)
	{
	  $sql = "select pm.fecha_muerte AS FECHA_MUERTE, IF( pm.transplante_funcionando =0,  'NO',  'SI' ) AS TRASPLANTE_FUNCIONANDO, pcm.nombre AS CAUSA_MUERTE from pacientes p, paciente_muerte pm, paciente_causa_muerte pcm where p.id = pm.paciente_id and pm.causa_muerte_id = pcm.id and p.id = ? order by p.id";
	  $conn = Doctrine_Manager::getInstance()->getCurrentConnection(); 
      return $conn->fetchAssoc($sql, array($paciente_id));
	}
	
	public function retrievePreTrasplantePerdidaInjerto($pre_trasplante_id)
	{
	  $sql = "select ppi.fecha_perdida, pcpi.nombre from paciente_pre_trasplante ppt, paciente_perdida_injerto ppi,  paciente_causa_perdida_injerto pcpi where ppt.id = ppi.paciente_pre_trasplante_id and pcpi.id = ppi.paciente_causa_perdida_injerto_id and ppt.id = ?";
	  $conn = Doctrine_Manager::getInstance()->getCurrentConnection(); 
      return $conn->fetchAssoc($sql, array($pre_trasplante_id));
	}
	
	public function retrieveTrasplanteInducciones($trasplante_id)
	{
	  $sql = "select i.nombre AS NOMBRE from  induccion i, trasplante t, trasplante_induccion ti where ti.trasplante_id = t.id and i.id = ti.induccion_id and t.id = ?";
	  $conn = Doctrine_Manager::getInstance()->getCurrentConnection(); 
      return $conn->fetchAssoc($sql, array($trasplante_id));
	}
	
	public function retrieveConsultaPreTrasplanteRACMV($year = NULL)
	{
	  $sql = "select 
				p.id AS P_ID, 
				ppt.id AS PPT_ID, 
				t.id AS T_ID, 
				p.fecha_dialisis AS FECHA_DIALISIS,
				p.sin_dialisis AS SIN_DIALISIS, 
				t.fecha AS T_FECHA, 
				'THE' AS CENTRO, 
				ppt.the AS THE, 
                                p.nombre AS NOMBRE,
                                p.apellido AS APELLIDO,                
				ppt.diabetes AS DIABETES, 
				n.nombre AS NEFROPATIA, 
				MONTH(t.fecha) AS MES_TRASPLANTE, 
				YEAR(t.fecha) AS FECHA_TRASPLANTE,
				MONTH(t.fecha_alta) AS MES_ALTA, 
				YEAR(t.fecha_alta) AS FECHA_ALTA,
				t.edad_receptor AS EDAD_RECEPTOR, 
				p.sexo AS SEXO, 
				ppt.meses_en_lista AS MESES_EN_LISTA, 
				d.edad_donante AS EDAD_DONANTE, 
				d.sexo_donante AS SEXO_DONANTE, 
				d.tipo_donante AS TIPO_DONANTE, 
				dcm.nombre AS CAUSA_MUERTE_DONANTE, 
				t.numero_incompatibilidad_ab AS NUMERO_INCOMPATIBILIDAD_AB, 
				t.numero_incompatibilidad_dr AS NUMERO_INCOMPATIBILIDAD_DR,  
				t.t_isq_fria_hs AS T_ISQ_FRIA_HS,
				t.t_isq_fria_min AS T_ISQ_FRIA_MIN,
				IF( ppt.hta =0,  'NO',  'SI' ) AS HTA,
				IF( ppt.obesidad =0,  'NO',  'SI' ) AS OBESIDAD,
				ppt.imc AS IMC,
				IF( ppt.dislipemia =0,  'NO',  'SI' ) AS DISLIPEMIA,
                IF( ppt.tabaquismo =0,  'NO',  'SI' ) AS TABAQUISMO
			  from 
				trasplante t, 
				paciente_pre_trasplante ppt, 
				pacientes p, 
				nefropatia n, 
				donante d, 
				donante_causa_muerte dcm 
			  where 
				t.paciente_pre_trasplante_id = ppt.id 
			  and 
				ppt.paciente_id = p.id 
			  and 
				n.id = p.nefropatia_id 
			  and 
				t.donante_id = d.id 
			  and 
				dcm.id = d.donante_causa_muerte_id ";
		$params = array();
		if(!is_null($year))
		{
		  $sql .= "and YEAR(t.fecha) = ?";
		  $params[] = $year;
		}
	
		$sql .= " order by t.fecha asc";
	  $conn = Doctrine_Manager::getInstance()->getCurrentConnection(); 
      return $conn->fetchAssoc($sql, $params);
	}
	
	public function retrieveTrasplanteInjertoEvolucionConRA($trasplante_id)
	{
	  $sql = "SELECT fecha AS FECHA, en_trasplante AS EN_TRASPLANTE FROM injerto_evolucion WHERE ra =1 AND trasplante_id = ?";
	  $conn = Doctrine_Manager::getInstance()->getCurrentConnection(); 
      return $conn->fetchAssoc($sql, array($trasplante_id));
	}
	
	public function retrieveTrasplanteCmvConEmfermedadSindromeViral($trasplante_id)
	{
	  $sql = "SELECT fecha AS FECHA, cmv_diagnostico_id AS CMV_DIAGNOSTICO_ID, tipo AS TIPO, cmv_droga_id AS CMV_DROGA_ID, dias_tratamiento AS DIAS_TRATAMIENTO, efecto_secundario AS EFECTO_SECUNDARIO FROM cmv WHERE trasplante_id = ? AND tipo =0 UNION SELECT fecha AS FECHA, cmv_diagnostico_id AS CMV_DIAGNOSTICO_ID, tipo AS TIPO, cmv_droga_id AS CMV_DROGA_ID, dias_tratamiento AS DIAS_TRATAMIENTO, efecto_secundario AS EFECTO_SECUNDARIO FROM cmv WHERE trasplante_id = ? AND tipo =2";
	  $conn = Doctrine_Manager::getInstance()->getCurrentConnection(); 
      return $conn->fetchAssoc($sql, array($trasplante_id,$trasplante_id));
	}
    
    public function retrievePacientesInducciones()
    {
      $sql = "
      select
        paciente_pre_trasplante.id AS ID,
        paciente_pre_trasplante.the AS THE,
        pacientes.nombre AS NOMBRE,
        pacientes.apellido AS APELLIDO,
        trasplante_induccion.induccion_id AS INDUCCION
      from
        paciente_pre_trasplante
        INNER JOIN pacientes ON (paciente_pre_trasplante.paciente_id = pacientes.id)
        INNER JOIN trasplante ON (trasplante.paciente_pre_trasplante_id = paciente_pre_trasplante.id)
        INNER JOIN trasplante_induccion ON (trasplante_induccion.trasplante_id = trasplante.id)  
      ";
      $conn = Doctrine_Manager::getInstance()->getCurrentConnection(); 
      return $conn->fetchAssoc($sql);
    }
    
    public function retrievePacientesInmunosupresores()
    {
      $sql = "
      select
        paciente_pre_trasplante.id AS ID,
        paciente_pre_trasplante.the AS THE,
        pacientes.nombre AS NOMBRE,
        pacientes.apellido AS APELLIDO,
        trasplante_inmunosupresores.inmunosupresores_id AS INMUNOSUPRESOR
      from
        paciente_pre_trasplante
        INNER JOIN pacientes ON (paciente_pre_trasplante.paciente_id = pacientes.id)
        INNER JOIN trasplante ON (trasplante.paciente_pre_trasplante_id = paciente_pre_trasplante.id)
        INNER JOIN trasplante_inmunosupresores ON (trasplante_inmunosupresores.trasplante_id = trasplante.id) 
      ";
      $conn = Doctrine_Manager::getInstance()->getCurrentConnection(); 
      return $conn->fetchAssoc($sql);
    }
    
    public function retrieveGermenesInfeccionesData($germen = null, $infeccion = null)
    {
      $sql = "SELECT  
                paciente_pre_trasplante.the AS THE,
                  pacientes.nombre AS NOMBRE,
                  pacientes.apellido AS APELLIDO,
                  trasplante.fecha AS FECHA,
                  trasplante_complicaciones_infecciosas.fecha AS FECHA_COMPLICACION,
                  medicaciones.nombre AS MEDICACION,
                  IF( trasplante_complicaciones_infecciosas.internado =1,  \"Si\",  \"No\" ) AS INTERNADO,
                  trasplante_complicaciones_infecciosas.dias_de_internacion AS DIAS_INTERNADO,
                  IF( trasplante_complicaciones_infecciosas.evolucion =1,  \"Si\",  \"No\" ) AS EN_EVOLUCION,
                  infeccion.nombre AS INFECCION,
                  germenes.nombre AS GERMEN
                FROM
                  pacientes
                  INNER JOIN paciente_pre_trasplante ON (paciente_pre_trasplante.paciente_id = pacientes.id)
                  INNER JOIN trasplante ON (trasplante.paciente_pre_trasplante_id = paciente_pre_trasplante.id)
                  INNER JOIN trasplante_complicaciones_infecciosas ON (trasplante.id = trasplante_complicaciones_infecciosas.trasplante_id)
                  INNER JOIN medicaciones ON (trasplante_complicaciones_infecciosas.medicacion_id = medicaciones.id)
                  INNER JOIN germenes ON (trasplante_complicaciones_infecciosas.germen_id = germenes.id)
                  INNER JOIN infeccion ON (trasplante_complicaciones_infecciosas.infeccion_id = infeccion.id)";
      $have_where = false;
      $params = array();
      if(!is_null($germen) && (int) $germen > 0)
      {
        $sql .= " WHERE germenes.id = :germen_id";
        $params["germen_id"] = $germen;
        $have_where = true;
      }
      if(!is_null($infeccion) && (int) $infeccion > 0)
      {
        if($have_where)
        {
          $sql .= " AND ";
        }
        else
        {
          $sql .= " WHERE ";
        }
        $sql .= " infeccion.id = :infeccion_id";
        $params["infeccion_id"] = $infeccion;
      }
      
      $sql .= " ORDER BY
                  trasplante.fecha";
      
      $conn = Doctrine_Manager::getInstance()->getCurrentConnection(); 
      return $conn->fetchAssoc($sql, $params);
    }
    
    public function loadConsultas()
    {
      $sql = "INSERT INTO `consulta` (`id`, `nombre`, `sentencia`) VALUES

      (null, 'consultaPacientesNefropatiasPBR', 'SELECT pp.the as THE, p.nombre as NOMBRE, p.apellido as APELLIDO, n.nombre as NEFROPATIA, pp.pbr as PBR FROM pacientes p, paciente_pre_trasplante pp, nefropatia n, trasplante t where p.id = pp.paciente_id AND p.nefropatia_id = n.id AND pp.id = t.paciente_pre_trasplante_id  ORDER BY pp.pbr'),

      (null, 'consultaPacientesTabaquismo', 'SELECT pp.the as THE, p.nombre as NOMBRE, p.apellido as APELLIDO, IF( pp.tabaquismo =1,  \"Si\",  \"No\" ) AS TABAQUISMO FROM pacientes p, paciente_pre_trasplante pp, trasplante t where p.id = pp.paciente_id AND pp.id = t.paciente_pre_trasplante_id and pp.tabaquismo = true'),

      (null, 'consultaIMCPacientesConObesidad', 'SELECT pp.the as THE, p.nombre as NOMBRE, p.apellido as APELLIDO, IF( pp.obesidad =1,  \"Si\",  \"No\" ) AS OBESIDAD FROM pacientes p, paciente_pre_trasplante pp, trasplante t where p.id = pp.paciente_id AND pp.id = t.paciente_pre_trasplante_id and pp.obesidad = true'),

      (null, 'consultaIMCPacientesSinObesidad', 'SELECT pp.the as THE, p.nombre as NOMBRE, p.apellido as APELLIDO, IF( pp.obesidad =1,  \"Si\",  \"No\" ) AS OBESIDAD FROM pacientes p, paciente_pre_trasplante pp, trasplante t where p.id = pp.paciente_id AND pp.id = t.paciente_pre_trasplante_id and pp.obesidad = false'),

      (null, 'consultaPacientesConHta', 'SELECT pp.the as THE, p.nombre as NOMBRE, p.apellido as APELLIDO, IF( pp.hta =1,  \"Si\",  \"No\" ) AS HTA FROM pacientes p, paciente_pre_trasplante pp, trasplante t where p.id = pp.paciente_id AND pp.id = t.paciente_pre_trasplante_id and pp.hta = true'),

      (null, 'consultaPacientesPorSexo', 'SELECT pp.the as THE, p.nombre as NOMBRE, p.apellido as APELLIDO, IF( p.sexo =\"F\",  \"Femenino\",  \"Masculino\" ) AS SEXO FROM pacientes p, paciente_pre_trasplante pp where p.id = pp.paciente_id order by p.sexo'),

      (null, 'consultaPacientesPorEdad', 'SELECT 
          paciente_pre_trasplante.the AS THE,
          pacientes.nombre AS NOMBRE,
          pacientes.apellido AS APELLIDO,
          pacientes.fecha_nacimiento AS NACIMIENTO,
          trasplante.fecha AS TRASPLANTE,
          trasplante.edad_receptor AS EDAD
        FROM
          pacientes
          INNER JOIN paciente_pre_trasplante ON (paciente_pre_trasplante.paciente_id = pacientes.id)
          INNER JOIN trasplante ON (paciente_pre_trasplante.id = trasplante.paciente_pre_trasplante_id)
        ORDER BY
          trasplante.edad_receptor'),

      (null, 'consultaPacientesTiempoEnLista', 'SELECT 
          paciente_pre_trasplante.the AS THE,
          pacientes.nombre AS NOMBRE,
          pacientes.apellido AS APELLIDO,
          paciente_pre_trasplante.fecha_ingreso_lista AS INGRESO,
          paciente_pre_trasplante.fecha_egreso AS EGRESO,
          paciente_pre_trasplante.meses_en_lista AS MESES
        FROM
          pacientes
          INNER JOIN paciente_pre_trasplante ON (paciente_pre_trasplante.paciente_id = pacientes.id)
        ORDER BY
          paciente_pre_trasplante.meses_en_lista'),

      (null, 'consultaPacientesMuerte', 'SELECT pacientes.nombre AS NOMBRE, pacientes.apellido AS APELLIDO, paciente_pre_trasplante.the AS THE, trasplante.fecha AS FECHA, paciente_muerte.fecha_muerte AS FECHA_MUERTE, IF( paciente_muerte.transplante_funcionando =1,  \"Si\",  \"No\" ) AS FUNCIONANDO, paciente_causa_muerte.nombre AS CAUSA FROM paciente_muerte INNER JOIN paciente_causa_muerte ON (paciente_muerte.causa_muerte_id = paciente_causa_muerte.id) INNER JOIN pacientes ON (pacientes.id = paciente_muerte.paciente_id) INNER JOIN paciente_pre_trasplante ON (paciente_pre_trasplante.paciente_id = pacientes.id) INNER JOIN trasplante ON (paciente_pre_trasplante.id = trasplante.paciente_pre_trasplante_id)'),

      (null, 'consultaPacientesNefropatiasPBR', 'SELECT
        paciente_pre_trasplante.the AS THE,  
        pacientes.nombre AS NOMBRE,
        pacientes.apellido AS APELLIDO,
        IF( paciente_pre_trasplante.pbr =1,  \"Si\",  \"No\" ) AS PBR,
        nefropatia.nombre AS NEFROPATIA
      FROM
        pacientes
        INNER JOIN paciente_pre_trasplante ON (paciente_pre_trasplante.paciente_id = pacientes.id)
        INNER JOIN nefropatia ON (pacientes.nefropatia_id = nefropatia.id)
      ORDER BY
        paciente_pre_trasplante.pbr'),

      (null, 'consultaTranfusionesEmbarazos', 'SELECT 
        paciente_pre_trasplante.the AS THE,
        pacientes.nombre AS NOMBRE,
        pacientes.apellido AS APELLIDO,
        IF( trasplante.trans_previas =1,  \"Si\",  \"No\" ) AS TRANSFUSIONES_PREVIAS,
        trasplante.numero_transf AS NUMERO_TRANSFUSIONES,
        trasplante.embarazo AS EMBARAZO,
        trasplante.numero_embarazo AS NUMERO_EMBARAZO
      FROM
        pacientes
        INNER JOIN paciente_pre_trasplante ON (paciente_pre_trasplante.paciente_id = pacientes.id)
        INNER JOIN trasplante ON (paciente_pre_trasplante.id = trasplante.paciente_pre_trasplante_id)
      ORDER BY
        trasplante.embarazo'),


      (null, 'consultaTipoSangrePacienteDonante', 'SELECT 
        paciente_pre_trasplante.the AS THE,
        pacientes.nombre AS NOMBRE,
        pacientes.apellido AS APELLIDO,
        pacientes.grupo_sanguineo AS GRUPO_PACIENTE,
        donante.grupo_sanguineo AS GRUPO_DONANTE
      FROM
        pacientes
        INNER JOIN paciente_pre_trasplante ON (paciente_pre_trasplante.paciente_id = pacientes.id)
        INNER JOIN trasplante ON (trasplante.paciente_pre_trasplante_id = paciente_pre_trasplante.id)
        INNER JOIN donante ON (trasplante.donante_id = donante.id)'),

      (null, 'consultaNumArteriasVenasYUreter', 'SELECT 
        paciente_pre_trasplante.the AS THE,
        pacientes.nombre AS NOMBRE,
        pacientes.apellido AS APELLIDO,
        trasplante.numero_arterias AS ARTERIAS,
        trasplante.numero_venas AS VENAS,
        trasplante.ureter AS URETER
      FROM
        pacientes
        INNER JOIN paciente_pre_trasplante ON (paciente_pre_trasplante.paciente_id = pacientes.id)
        INNER JOIN trasplante ON (trasplante.paciente_pre_trasplante_id = paciente_pre_trasplante.id)'),

      (null, 'consultaLadoRinhonAnomalia', 'SELECT 
        paciente_pre_trasplante.the AS THE,
        pacientes.nombre AS NOMBRE,
        pacientes.apellido AS APELLIDO,
        trasplante.rinhon AS RIÑON,
        IF( trasplante.anomalia_vascular =1,  \"Si\",  \"No\" ) AS ANOMALIA
      FROM
        pacientes
        INNER JOIN paciente_pre_trasplante ON (paciente_pre_trasplante.paciente_id = pacientes.id)
        INNER JOIN trasplante ON (trasplante.paciente_pre_trasplante_id = paciente_pre_trasplante.id)'),

      (null, 'consultaPacienteInastabilidadHemodinamica', 'SELECT 
        paciente_pre_trasplante.the AS THE,
        pacientes.nombre AS NOMBRE,
        pacientes.apellido AS APELLIDO,
        IF( trasplante.inestab_hemodial =1,  \"Si\",  \"No\" ) AS INESTABILIDAD
      FROM
        pacientes
        INNER JOIN paciente_pre_trasplante ON (paciente_pre_trasplante.paciente_id = pacientes.id)
        INNER JOIN trasplante ON (trasplante.paciente_pre_trasplante_id = paciente_pre_trasplante.id)
      WHERE
        trasplante.inestab_hemodial = true'),

      (null, 'consultaPacienteEdadDonanteEdad', 'SELECT 
        paciente_pre_trasplante.the AS THE,
        pacientes.nombre AS NOMBRE,
        pacientes.apellido AS APELLIDO,
        trasplante.edad_receptor AS EDAD_RECEPTOR,
        donante.edad_donante AS EDAD_DONANTE
      FROM
        pacientes
        INNER JOIN paciente_pre_trasplante ON (paciente_pre_trasplante.paciente_id = pacientes.id)
        INNER JOIN trasplante ON (trasplante.paciente_pre_trasplante_id = paciente_pre_trasplante.id)
        INNER JOIN donante ON (trasplante.donante_id = donante.id)'),

      (null, 'consultaSexoPacienteDonante', 'SELECT 
        paciente_pre_trasplante.the AS THE,
        pacientes.nombre AS NOMBRE,
        pacientes.apellido AS APELLIDO,
        IF( pacientes.sexo =\"F\",  \"Femenino\",  \"Masculino\" ) AS SEXO_RECEPTOR,
        IF( donante.sexo_donante =\"F\",  \"Femenino\",  \"Masculino\" ) AS SEXO_DONANTE
      FROM
        pacientes
        INNER JOIN paciente_pre_trasplante ON (paciente_pre_trasplante.paciente_id = pacientes.id)
        INNER JOIN trasplante ON (trasplante.paciente_pre_trasplante_id = paciente_pre_trasplante.id)
        INNER JOIN donante ON (trasplante.donante_id = donante.id)'),

      (null, 'consultaTipoDonantePaciente', 'SELECT 
        paciente_pre_trasplante.the AS THE,
        pacientes.nombre AS NOMBRE,
        pacientes.apellido AS APELLIDO,
        donante.tipo_donante AS TIPO_DONANTE,
        donante.relacion_filiar AS RELACION_FILIAR
      FROM
        pacientes
        INNER JOIN paciente_pre_trasplante ON (paciente_pre_trasplante.paciente_id = pacientes.id)
        INNER JOIN trasplante ON (trasplante.paciente_pre_trasplante_id = paciente_pre_trasplante.id)
        INNER JOIN donante ON (trasplante.donante_id = donante.id)'),


      (null, 'consultaPacienteVariosTrasplantes', 'SELECT 
        paciente_pre_trasplante.the AS THE,
        pacientes.nombre AS NOMBRE,
        pacientes.apellido AS APELLIDO,
        trasplante.numero_de_transplantes_realizados AS CANTIDAD
      FROM
        pacientes
        INNER JOIN paciente_pre_trasplante ON (paciente_pre_trasplante.paciente_id = pacientes.id)
        INNER JOIN trasplante ON (trasplante.paciente_pre_trasplante_id = paciente_pre_trasplante.id)
        INNER JOIN donante ON (trasplante.donante_id = donante.id)
      WHERE
        trasplante.numero_de_transplantes_realizados > 1'),

      (null, 'consultaPacienteFechaTrasplantes', 'SELECT 
        paciente_pre_trasplante.the AS THE,
        pacientes.nombre AS NOMBRE,
        pacientes.apellido AS APELLIDO,
        trasplante.fecha AS FECHA
      FROM
        pacientes
        INNER JOIN paciente_pre_trasplante ON (paciente_pre_trasplante.paciente_id = pacientes.id)
        INNER JOIN trasplante ON (trasplante.paciente_pre_trasplante_id = paciente_pre_trasplante.id)
        INNER JOIN donante ON (trasplante.donante_id = donante.id)
      ORDER BY
        trasplante.fecha'),

      (null, 'consultaTrasplantesCompatibilidadIncompatibilidadPRA', 'SELECT 
        paciente_pre_trasplante.the AS THE,
        pacientes.nombre AS NOMBRE,
        pacientes.apellido AS APELLIDO,
        trasplante.numero_compatibilidad_ab AS COMPATIBILIDAD_AB,
        trasplante.numero_compatibilidad_dr AS COMPATIBILIDAD_DR,
        trasplante.numero_incompatibilidad_ab AS INCOMPATIBILIDAD_AB,
        trasplante.numero_incompatibilidad_dr AS INCOMPATIBILIDAD_DR,
        IF( trasplante.autoac =1,  \"Si\",  \"No\" ) AS AUTOAC,
        trasplante.pra_max AS PRA_MAX,
        trasplante.pra_tr AS PRA_TR
      FROM
        pacientes
        INNER JOIN paciente_pre_trasplante ON (paciente_pre_trasplante.paciente_id = pacientes.id)
        INNER JOIN trasplante ON (trasplante.paciente_pre_trasplante_id = paciente_pre_trasplante.id)
        INNER JOIN donante ON (trasplante.donante_id = donante.id)'),

      (null, 'consultaTrasplantesPorCirugia', 'SELECT 
        paciente_pre_trasplante.the AS THE,
        pacientes.nombre AS NOMBRE,
        pacientes.apellido AS APELLIDO,
        trasplante.tq_de_banco AS TQ_BANCO,
        trasplante.lado_implante AS LADO_IMPLANTE,
        trasplante.anast_venosa AS ANAST_VENOSA,
        trasplante.anast_arterial AS ANAST_ARTERIAL,
        trasplante.anast_ureteral As ANAST_URETERAL,
        trasplante.reperfusion AS REPERFUSION,
        IF( trasplante.sangrado_i_op =1,  \"Si\",  \"No\" ) AS SANGRADO_I_OP,
        IF( trasplante.lesion_arterial =1,  \"Si\",  \"No\" ) AS LESION_ARTERIAL,
        IF( trasplante.lesion_venosa =1,  \"Si\",  \"No\" ) AS LESION_VENOSA,
        IF( trasplante.necesidad_repefundir =1,  \"Si\",  \"No\" ) AS NECESIDAD_REPEFUNDIR,
        trasplante.otras_compl_quirur AS OTRAS_COMPLICACIONES,
        IF( trasplante.diuresis_i_op =1,  \"Si\",  \"No\" ) AS DIURESIS_I_OP
      FROM
        paciente_pre_trasplante
        INNER JOIN pacientes ON (paciente_pre_trasplante.paciente_id = pacientes.id)
        INNER JOIN trasplante ON (paciente_pre_trasplante.id = trasplante.paciente_pre_trasplante_id)'),

      (null, 'consultaTrasplantesDiuresisEnBQ', 'SELECT 
        paciente_pre_trasplante.the AS THE,
        pacientes.nombre AS NOMBRE,
        pacientes.apellido AS APELLIDO,
        trasplante.cr_inicial AS CR_INICIAL,
        trasplante.dia_rec_diuresis AS DIAS_REC_DIURESIS,
        trasplante.dia_rec_funcional AS DIAS_REC_FUNCIONAL,
        IF( trasplante.dialisis =1,  \"Si\",  \"No\" ) AS DIALISIS,
        trasplante.num_de_hd AS NUM_DIALISIS
      FROM
        paciente_pre_trasplante
        INNER JOIN pacientes ON (paciente_pre_trasplante.paciente_id = pacientes.id)
        INNER JOIN trasplante ON (paciente_pre_trasplante.id = trasplante.paciente_pre_trasplante_id)
        INNER JOIN injerto_evolucion ON (trasplante.id = injerto_evolucion.trasplante_id)
        INNER JOIN injerto_evolucion_pbr ON (injerto_evolucion.id = injerto_evolucion_pbr.injerto_evolucion_id)
      WHERE
        injerto_evolucion.en_trasplante = true AND 
        injerto_evolucion_pbr.resultado_pbr_id = 4'),

      (null, 'consultaPacientesReoperaciones', 'SELECT 
        paciente_pre_trasplante.the AS THE,
        pacientes.nombre AS NOMBRE,
        pacientes.apellido AS APELLIDO,
        COUNT(trasplante_reoperacion.id) AS CANTIDAD
      FROM
        paciente_pre_trasplante
        INNER JOIN pacientes ON (paciente_pre_trasplante.paciente_id = pacientes.id)
        INNER JOIN trasplante ON (paciente_pre_trasplante.id = trasplante.paciente_pre_trasplante_id)
        LEFT OUTER JOIN trasplante_reoperacion ON (trasplante.id = trasplante_reoperacion.trasplante_id)
      GROUP BY
        trasplante.id
      ORDER BY CANTIDAD DESC'),

      (null, 'consultaTransplantesConSangradoIOpLesionArterialYVenalRepefundir', 'SELECT 
        paciente_pre_trasplante.the AS THE,
        pacientes.nombre AS NOMBRE,
        pacientes.apellido AS APELLIDO,
        IF( trasplante.sangrado_i_op =1,  \"Si\",  \"No\" ) AS SANGRADO_I_OP,
        IF( trasplante.lesion_arterial =1,  \"Si\",  \"No\" ) AS LESION_ARTERIAL,
        IF( trasplante.lesion_venosa =1,  \"Si\",  \"No\" ) AS LESION_VENOSA,
        IF( trasplante.necesidad_repefundir =1,  \"Si\",  \"No\" ) AS NECESIDAD_REPEFUNDIR
      FROM
        paciente_pre_trasplante
        INNER JOIN pacientes ON (paciente_pre_trasplante.paciente_id = pacientes.id)
        INNER JOIN trasplante ON (paciente_pre_trasplante.id = trasplante.paciente_pre_trasplante_id)
      WHERE
        (trasplante.sangrado_i_op = true OR trasplante.lesion_arterial = true OR trasplante.lesion_venosa = true OR trasplante.necesidad_repefundir = true) '),
        
      (null, 'consultaDonanteCausaMuerte', 'SELECT 
          paciente_pre_trasplante.the AS THE,
          pacientes.nombre AS NOMBRE,
          pacientes.apellido AS APELLIDO,
          donante.identificador AS IDENTIFICADOR,
          donante_causa_muerte.nombre AS CAUSA
        FROM
          pacientes
          INNER JOIN paciente_pre_trasplante ON (paciente_pre_trasplante.paciente_id = pacientes.id)
          INNER JOIN trasplante ON (trasplante.paciente_pre_trasplante_id = paciente_pre_trasplante.id)
          INNER JOIN donante ON (trasplante.donante_id = donante.id)
          INNER JOIN donante_causa_muerte ON (donante.donante_causa_muerte_id = donante_causa_muerte.id)'),  

      (null, 'consultaTrasplantesIsquemiaDiuresis', 'SELECT 
          paciente_pre_trasplante.the AS THE,
          pacientes.nombre AS NOMBRE,
          pacientes.apellido AS APELLIDO,
          trasplante.t_isq_cal_min AS T_ISQ_CAL_MIN,
          trasplante.t_isq_fria_hs AS T_ISQ_FRIA_HS,
          trasplante.t_isq_fria_min AS T_ISQ_FRIA_MIN,
          trasplante.t_isq_tibia_hs AS T_ISQ_TIBIA_HS,
          trasplante.reperfusion AS REPERFUSION,
          IF( trasplante.diuresis_i_op =1,  \"Si\",  \"No\" ) AS DIURESIS
        FROM
          paciente_pre_trasplante
          INNER JOIN pacientes ON (paciente_pre_trasplante.paciente_id = pacientes.id)
          INNER JOIN trasplante ON (paciente_pre_trasplante.id = trasplante.paciente_pre_trasplante_id)
        ORDER BY trasplante.diuresis_i_op ASC'),
      

      (null, 'consultaPacientesDislipemia', 'SELECT pp.the as THE, p.nombre as NOMBRE, p.apellido as APELLIDO, IF( pp.dislipemia =1,  \"Si\",  \"No\" ) AS DISLIPEMIA FROM pacientes p, paciente_pre_trasplante pp, trasplante t where p.id = pp.paciente_id AND pp.id = t.paciente_pre_trasplante_id and pp.dislipemia = true'),
      
      (null, 'consultaPacientesConDiabetes', 'SELECT pp.the as THE, p.nombre as NOMBRE, p.apellido as APELLIDO, pp.diabetes as DIABETES FROM pacientes p, paciente_pre_trasplante pp where p.id = pp.paciente_id  and pp.diabetes <> \'No\' '),
      
      (null, 'consultaPacientesPorOrigen', 'SELECT pp.the as THE, p.nombre as NOMBRE, p.apellido as APELLIDO, pp.origen as ORIGEN FROM pacientes p, paciente_pre_trasplante pp where p.id = pp.paciente_id order by pp.origen')
      
      ";
      $conn = Doctrine_Manager::getInstance()->getCurrentConnection(); 
      $conn->execute($sql);
    }
    
    
}
