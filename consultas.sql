INSERT INTO `consulta` (`id`, `nombre`, `sentencia`) VALUES

(null, 'consultaPacientesNefropatiasPBR', 'SELECT pp.the as THE, p.nombre as NOMBRE, p.apellido as APELLIDO, n.nombre as NEFROPATIA, pp.pbr as PBR FROM pacientes p, paciente_pre_trasplante pp, nefropatia n, trasplante t where p.id = pp.paciente_id AND p.nefropatia_id = n.id AND pp.id = t.paciente_pre_trasplante_id  ORDER BY pp.pbr'),

(null, 'consultaPacientesTabaquismo', 'SELECT pp.the as THE, p.nombre as NOMBRE, p.apellido as APELLIDO, pp.tabaquismo as TABAQUISMO FROM pacientes p, paciente_pre_trasplante pp, trasplante t where p.id = pp.paciente_id AND pp.id = t.paciente_pre_trasplante_id and pp.tabaquismo = true'),

(null, 'consultaIMCPacientesConObesidad', 'SELECT pp.the as THE, p.nombre as NOMBRE, p.apellido as APELLIDO, pp.obesidad as OBESIDAD FROM pacientes p, paciente_pre_trasplante pp, trasplante t where p.id = pp.paciente_id AND pp.id = t.paciente_pre_trasplante_id and pp.obesidad = true'),

(null, 'consultaIMCPacientesSinObesidad', 'SELECT pp.the as THE, p.nombre as NOMBRE, p.apellido as APELLIDO, pp.obesidad as OBESIDAD FROM pacientes p, paciente_pre_trasplante pp, trasplante t where p.id = pp.paciente_id AND pp.id = t.paciente_pre_trasplante_id and pp.obesidad = false'),

(null, 'consultaPacientesConHta', 'SELECT pp.the as THE, p.nombre as NOMBRE, p.apellido as APELLIDO, pp.hta as HTA FROM pacientes p, paciente_pre_trasplante pp, trasplante t where p.id = pp.paciente_id AND pp.id = t.paciente_pre_trasplante_id and pp.hta = true'),

(null, 'consultaPacientesPorSexo', 'SELECT pp.the as THE, p.nombre as NOMBRE, p.apellido as APELLIDO, p.sexo as SEXO FROM pacientes p, paciente_pre_trasplante pp where p.id = pp.paciente_id order by p.sexo'),

(null, 'consultaPacientesPorEdad', 'SELECT P.THE, T.pretrasplante, P.NOMBRE, P.APELLIDO, P.FECHA_NACIMIENTO, T.fecha ,(YEAR(fecha) - YEAR(FECHA_NACIMIENTO))- IF(RIGHT(fecha,5) < RIGHT(FECHA_NACIMIENTO,5),1,0) AS age FROM pacientes P, pacientepretrasplante PP, trasplante T WHERE P.the = PP.the AND PP.id = T.pretrasplante ORDER BY AGE'),

(null, 'consultaPacientesTiempoEnLista', 'SELECT P.THE, T.pretrasplante, P.NOMBRE, P.APELLIDO, PP.FECHA_INGRESO_LISTA ,T.fecha, (Month(T.fecha) - Month(PP.FECHA_INGRESO_LISTA)) + ((Year(T.fecha) - Year(PP.FECHA_INGRESO_LISTA)) * 12) - If( Day(T.fecha) - Day(PP.FECHA_INGRESO_LISTA) < 0 , 1 , 0 )  AS meses FROM pacientes P, pacientepretrasplante PP, trasplante T WHERE P.the = PP.the AND PP.id = T.pretrasplante ORDER BY meses'),

(null, 'consultaPacientesDislipemia', 'SELECT pp.the as THE, p.nombre as NOMBRE, p.apellido as APELLIDO, pp.dislipemia as DISLIPEMIA FROM pacientes p, paciente_pre_trasplante pp, trasplante t where p.id = pp.paciente_id AND pp.id = t.paciente_pre_trasplante_id and pp.dislipemia = true');


