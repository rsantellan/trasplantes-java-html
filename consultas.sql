INSERT INTO `consulta` (`id`, `nombre`, `sentencia`) VALUES

(null, 'consultaPacientesNefropatiasPBR', 'SELECT pp.the as THE, p.nombre as NOMBRE, p.apellido as APELLIDO, n.nombre as NEFROPATIA, pp.pbr as PBR FROM pacientes p, paciente_pre_trasplante pp, nefropatia n, trasplante t where p.id = pp.paciente_id AND p.nefropatia_id = n.id AND pp.id = t.paciente_pre_trasplante_id  ORDER BY pp.pbr'),

(null, 'consultaPacientesTabaquismo', 'SELECT pp.the as THE, p.nombre as NOMBRE, p.apellido as APELLIDO, pp.tabaquismo as TABAQUISMO FROM pacientes p, paciente_pre_trasplante pp, trasplante t where p.id = pp.paciente_id AND pp.id = t.paciente_pre_trasplante_id and pp.tabaquismo = true'),

(null, 'consultaIMCPacientesConObesidad', 'SELECT pp.the as THE, p.nombre as NOMBRE, p.apellido as APELLIDO, pp.obesidad as OBESIDAD FROM pacientes p, paciente_pre_trasplante pp, trasplante t where p.id = pp.paciente_id AND pp.id = t.paciente_pre_trasplante_id and pp.obesidad = true'),

(null, 'consultaIMCPacientesSinObesidad', 'SELECT pp.the as THE, p.nombre as NOMBRE, p.apellido as APELLIDO, pp.obesidad as OBESIDAD FROM pacientes p, paciente_pre_trasplante pp, trasplante t where p.id = pp.paciente_id AND pp.id = t.paciente_pre_trasplante_id and pp.obesidad = false'),

(null, 'consultaPacientesConHta', 'SELECT pp.the as THE, p.nombre as NOMBRE, p.apellido as APELLIDO, pp.hta as HTA FROM pacientes p, paciente_pre_trasplante pp, trasplante t where p.id = pp.paciente_id AND pp.id = t.paciente_pre_trasplante_id and pp.hta = true'),

(null, 'consultaPacientesPorSexo', 'SELECT pp.the as THE, p.nombre as NOMBRE, p.apellido as APELLIDO, p.sexo as SEXO FROM pacientes p, paciente_pre_trasplante pp where p.id = pp.paciente_id order by p.sexo'),

(null, 'consultaPacientesPorEdad', 'SELECT P.THE, T.pretrasplante, P.NOMBRE, P.APELLIDO, P.FECHA_NACIMIENTO, T.fecha ,(YEAR(fecha) - YEAR(FECHA_NACIMIENTO))- IF(RIGHT(fecha,5) < RIGHT(FECHA_NACIMIENTO,5),1,0) AS age FROM pacientes P, pacientepretrasplante PP, trasplante T WHERE P.the = PP.the AND PP.id = T.pretrasplante ORDER BY AGE'),

(null, 'consultaPacientesTiempoEnLista', 'SELECT P.THE, T.pretrasplante, P.NOMBRE, P.APELLIDO, PP.FECHA_INGRESO_LISTA ,T.fecha, (Month(T.fecha) - Month(PP.FECHA_INGRESO_LISTA)) + ((Year(T.fecha) - Year(PP.FECHA_INGRESO_LISTA)) * 12) - If( Day(T.fecha) - Day(PP.FECHA_INGRESO_LISTA) < 0 , 1 , 0 )  AS meses FROM pacientes P, pacientepretrasplante PP, trasplante T WHERE P.the = PP.the AND PP.id = T.pretrasplante ORDER BY meses'),

(null, 'consultaPacientesMuerte', 'SELECT pacientes.nombre AS NOMBRE, pacientes.apellido AS APELLIDO, paciente_pre_trasplante.the AS THE, trasplante.fecha AS FECHA, paciente_muerte.fecha_muerte AS FECHA_MUERTE, paciente_muerte.transplante_funcionando AS FUNCIONANDO, paciente_causa_muerte.nombre AS CAUSA FROM paciente_muerte INNER JOIN paciente_causa_muerte ON (paciente_muerte.causa_muerte_id = paciente_causa_muerte.id) INNER JOIN pacientes ON (pacientes.id = paciente_muerte.paciente_id) INNER JOIN paciente_pre_trasplante ON (paciente_pre_trasplante.paciente_id = pacientes.id) INNER JOIN trasplante ON (paciente_pre_trasplante.id = trasplante.paciente_pre_trasplante_id)'),

(null, 'consultaPacientesNefropatiasPBR', 'SELECT
  paciente_pre_trasplante.the AS THE,  
  pacientes.nombre AS NOMBRE,
  pacientes.apellido AS APELLIDO,
  paciente_pre_trasplante.pbr AS PBR,
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
  trasplante.trans_previas AS TRANSFUSIONES_PREVIAS,
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
  trasplante.anomalia_vascular AS ANOMALIA
FROM
  pacientes
  INNER JOIN paciente_pre_trasplante ON (paciente_pre_trasplante.paciente_id = pacientes.id)
  INNER JOIN trasplante ON (trasplante.paciente_pre_trasplante_id = paciente_pre_trasplante.id)'),

(null, 'consultaPacienteInastabilidadHemodinamica', 'SELECT 
  paciente_pre_trasplante.the AS THE,
  pacientes.nombre AS NOMBRE,
  pacientes.apellido AS APELLIDO,
  trasplante.inestab_hemodial AS INESTABILIDAD
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
  pacientes.sexo AS SEXO_RECEPTOR,
  donante.sexo_donante AS SEXO_DONANTE
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
  trasplante.autoac AS AUTOAC,
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
  trasplante.sangrado_i_op AS SANGRADO_I_OP,
  trasplante.lesion_arterial AS LESION_ARTERIAL,
  trasplante.lesion_venosa AS LESION_VENOSA,
  trasplante.necesidad_repefundir AS NECESIDAD_REPEFUNDIR,
  trasplante.otras_compl_quirur AS OTRAS_COMPLICACIONES,
  trasplante.diuresis_i_op AS DIURESIS_I_OP
FROM
  paciente_pre_trasplante
  INNER JOIN pacientes ON (paciente_pre_trasplante.paciente_id = pacientes.id)
  INNER JOIN trasplante ON (paciente_pre_trasplante.id = trasplante.paciente_pre_trasplante_id)'),

(null, 'consultaTrasplantesDiuresisEnBQ', 'SELECT 
  paciente_pre_trasplante.the AS THE,
  pacientes.nombre AS NOMBRE,
  pacientes.apellido AS APELLIDO,
  trasplante.cr_inicial,
  trasplante.dia_rec_diuresis,
  trasplante.dia_rec_funcional,
  trasplante.dialisis,
  trasplante.num_de_hd
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
  trasplante.sangrado_i_op,
  trasplante.lesion_arterial,
  trasplante.lesion_venosa,
  trasplante.necesidad_repefundir
FROM
  paciente_pre_trasplante
  INNER JOIN pacientes ON (paciente_pre_trasplante.paciente_id = pacientes.id)
  INNER JOIN trasplante ON (paciente_pre_trasplante.id = trasplante.paciente_pre_trasplante_id)
WHERE
  (trasplante.sangrado_i_op = true OR trasplante.lesion_arterial = true OR trasplante.lesion_venosa = true OR trasplante.necesidad_repefundir = true) '),

(null, 'consultaPacientesDislipemia', 'SELECT pp.the as THE, p.nombre as NOMBRE, p.apellido as APELLIDO, pp.dislipemia as DISLIPEMIA FROM pacientes p, paciente_pre_trasplante pp, trasplante t where p.id = pp.paciente_id AND pp.id = t.paciente_pre_trasplante_id and pp.dislipemia = true');


