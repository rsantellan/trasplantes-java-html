package logica;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import auxiliares.ManejoFechas;

import dominio.CausaMuerteDonante;
import dominio.Donante;
import dominio.FechaControl;
import dominio.Generico;
import dominio.GenericoAuxiliar;
import dominio.Induccion;
import dominio.Inmunosupresores;
import dominio.Paciente;
import dominio.PacientePreTrasplante;
import dominio.Trasplante;

public class ControlConsultas {

	public ArrayList<Paciente> consultaXCausaMuerteDonante(CausaMuerteDonante c) {
		Donante auxDon = new Donante();
		ArrayList<Donante> listaDonantes = new ArrayList<Donante>();
		auxDon.setCausaMuerte(c);
		auxDon.setNumCausaMuerte(c.getId());
		listaDonantes = auxDon.obtenerTodos();
		ArrayList<Paciente> listaPacientes = new ArrayList<Paciente>();
		for (int x = 0; x < listaDonantes.size(); x++) {
			Trasplante t = new Trasplante();
			t.buscarTrasplanteDonante(listaDonantes.get(x));
			PacientePreTrasplante auxPre = new PacientePreTrasplante();
			auxPre.setId(t.getPreTrasplante());
			auxPre.leerMinimo();
			auxPre.setTrasplante(t);
			Paciente auxPac = new Paciente();
			auxPac.setThe(auxPre.getThe());
			auxPac.leerSoloPaciente();
			auxPac.getListaPreTrasplantes().add(auxPre);
			listaPacientes.add(auxPac);
		}
		return listaPacientes;
	}

	public ArrayList<Paciente> consultaXCQObesidadLinfocele() {
		Trasplante t = new Trasplante();
		ArrayList<Trasplante> listaTrasplantes = t
				.obtenerTodosCQObesosInfeccionHerida();
		ArrayList<Paciente> listaPacientes = new ArrayList<Paciente>();
		for (int x = 0; x < listaTrasplantes.size(); x++) {
			PacientePreTrasplante pre = new PacientePreTrasplante();
			pre.setId(listaTrasplantes.get(x).getPreTrasplante());
			pre.leerMinimo();
			pre.setTrasplante(listaTrasplantes.get(x));
			Paciente pa = new Paciente();
			pa.setThe(pre.getThe());
			pa.leerSoloPaciente();
			pa.getListaPreTrasplantes().add(pre);
			listaPacientes.add(pa);
		}
		return listaPacientes;
	}

	private void arreglarDatosGenericos(Generico g) {
		ArrayList<Object> listaAux = new ArrayList<Object>();
		for (int x = 0; x < g.getListaObtenida().size(); x++) {
			int pos = x % g.getListaDada().size();
			String es = g.getListaDada().get(pos);
			if (es.equalsIgnoreCase(Generico.fechas)) {
				Calendar c = new GregorianCalendar();
				try {
					c.setTime(ManejoFechas.formatoIngles.parse(g
							.getListaObtenida().get(x).toString()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				listaAux.add(ManejoFechas.formatoEspanol.format(c.getTime()));
			} else {
				if (es.equalsIgnoreCase(Generico.letras)) {
					if (g.getListaObtenida().get(x).toString()
							.equalsIgnoreCase("null")) {
						listaAux.add(" - ");
					} else {
						listaAux.add(g.getListaObtenida().get(x).toString());
					}
				} else {
					listaAux.add(g.getListaObtenida().get(x).toString());
				}
			}
		}
		g.setListaObtenida(listaAux);
	}

	public Generico consultaPacientesTabaquismo() {
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO, PP.TABAQUISMO FROM PACIENTES P, pacientepretrasplante PP, Trasplante T";
		sql += " WHERE TABAQUISMO = true and p.the = pp.the AND pp.id = t.pretrasplante";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.VF);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("TABAQUISMO");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaPacientesDislipemia() {
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO, PP.DISLIPEMIA FROM PACIENTES P, pacientepretrasplante PP, Trasplante T";
		sql += " WHERE DISLIPEMIA = true and p.the = pp.the AND pp.id = t.pretrasplante";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.VF);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("DISLIPEMIA");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaIMCPacientesConObesidad() {
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO, PP.OBESIDAD, PP.IMC FROM PACIENTES P, pacientepretrasplante PP, Trasplante T";
		sql += " WHERE OBESIDAD = true and p.the = pp.the AND pp.id = t.pretrasplante";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.VF);
		g.getListaDada().add(Generico.letras);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("OBESIDAD");
		g.getListaNombre().add("IMC");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaIMCPacientesSinObesidad() {
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO, PP.OBESIDAD, PP.IMC FROM PACIENTES P, pacientepretrasplante PP, Trasplante T";
		sql += " WHERE OBESIDAD = false and p.the = pp.the AND pp.id = t.pretrasplante";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.VF);
		g.getListaDada().add(Generico.letras);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("OBESIDAD");
		g.getListaNombre().add("IMC");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaPacientesConHta() {
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO, PP.HTA FROM PACIENTES P, pacientepretrasplante PP, Trasplante T";
		sql += " WHERE HTA = true and p.the = pp.the AND pp.id = t.pretrasplante";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.VF);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("HTA");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaPacientesConDiabetes() {
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO, PP.DIABETES FROM PACIENTES P, pacientepretrasplante PP, Trasplante T";
		sql += " WHERE NOT DIABETES = 'No' and p.the = pp.the AND pp.id = t.pretrasplante ORDER BY DIABETES";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("DIABETES");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaPacientesPorSexo() {
		String sql = "SELECT P.THE, P.NOMBRE, P.APELLIDO, P.SEXO FROM pacientes P";
		sql += " ORDER BY P.SEXO";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("SEXO");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaPacientesPorOrigen() {
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO, PP.ORIGEN FROM PACIENTES P, pacientepretrasplante PP, Trasplante T";
		sql += " WHERE p.the = pp.the AND pp.id = t.pretrasplante ORDER BY ORIGEN";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("ORIGEN");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaPacientesPorEdad() {
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO, P.FECHA_NACIMIENTO, T.fecha ,";
		sql += "(YEAR(fecha) - YEAR(FECHA_NACIMIENTO))- IF(RIGHT(fecha,5) < RIGHT(FECHA_NACIMIENTO,5),1,0) AS age";
		sql += " FROM PACIENTES P, pacientepretrasplante PP, Trasplante T";
		sql += " WHERE p.the = pp.the AND pp.id = t.pretrasplante ORDER BY AGE";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.fechas);
		g.getListaDada().add(Generico.fechas);
		g.getListaDada().add(Generico.integer);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("FECHA NACIMIENTO");
		g.getListaNombre().add("FECHA TRASPLANTE");
		g.getListaNombre().add("EDAD");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaPacientesTiempoEnLista() {
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO, PP.FECHA_INGRESO_LISTA ,T.fecha,";
		sql += "(Month(T.fecha) - Month(PP.FECHA_INGRESO_LISTA)) + ((Year(T.fecha) - Year(PP.FECHA_INGRESO_LISTA)) * 12) - If( Day(T.fecha) - Day(PP.FECHA_INGRESO_LISTA) < 0 , 1 , 0 )  AS meses";
		sql += " FROM PACIENTES P, pacientepretrasplante PP, Trasplante T";
		sql += " WHERE p.the = pp.the AND pp.id = t.pretrasplante ORDER BY meses";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.fechas);
		g.getListaDada().add(Generico.fechas);
		g.getListaDada().add(Generico.integer);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("FECHA INGRESO LISTA");
		g.getListaNombre().add("FECHA TRASPLANTE");
		g.getListaNombre().add("MESES");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaPacientesMuerte() {
		String sql = "SELECT P.THE, P.NOMBRE, P.APELLIDO, T.fecha , PM.FECHA_MUERTE, PCM.Detalles, PM.TR_Funcionando";
		sql += " FROM PACIENTES P, pacientepretrasplante PP, Trasplante T, paciente_muerte PM, paciente_causa_muerte PCM";
		sql += " WHERE p.the = pp.the AND pp.id = t.pretrasplante AND P.THE = PM.THE AND PM.CAUSA = PCM.ID";
		sql += " ORDER BY PM.TR_Funcionando";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.fechas);
		g.getListaDada().add(Generico.fechas);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.VF);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("FECHA TRASPLANTE");
		g.getListaNombre().add("FECHA FALLECIMIENTO");
		g.getListaNombre().add("CAUSA");
		g.getListaNombre().add("TRASPLANTE FUNCIONANDO");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaPacientesNefropatiasPBR() {
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO, N.NEFROPATIA, PP.PBR";
		sql += " FROM PACIENTES P, pacientepretrasplante PP, NEFROPATIA N, Trasplante T";
		sql += " WHERE p.the = pp.the AND P.NEFROPATIA = N.ID AND pp.id = t.pretrasplante ORDER BY PP.PBR";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.VF);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("NEFROPATIA");
		g.getListaNombre().add("PBR");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaTranfusionesEmbarazos() {
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO, T.TRANS_PREVIAS,T.NUM_TRANSF, T.EMBARAZO, T.NUM_EMBARAZO";
		sql += " FROM PACIENTES P, pacientepretrasplante PP, Trasplante T";
		sql += " WHERE p.the = pp.the AND pp.id = t.pretrasplante";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.VF);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.integer);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("TRANFUSIONES PREVIAS");
		g.getListaNombre().add("NUMERO TRANFUSIONES");
		g.getListaNombre().add("EMBARAZO");
		g.getListaNombre().add("NUMERO DE EMBARAZOS");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaTipoSangrePacienteDonante() {
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO, P.GRUPO_SANG, D.ID, D.GRUPO_SANG";
		sql += " FROM PACIENTES P, pacientepretrasplante PP, Trasplante T, donante D";
		sql += " WHERE p.the = pp.the AND pp.id = t.pretrasplante AND T.ID_DONANTE = D.ID";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("GRUPO SANGUINEO PACIENTE");
		g.getListaNombre().add("ID DONANTE");
		g.getListaNombre().add("GRUPO SANGUINEO DONANTE");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaNumArteriasVenasYUreter() {
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO, T.NUM_ART, T.NUM_VENAS, T.URETER";
		sql += " FROM PACIENTES P, pacientepretrasplante PP, Trasplante T";
		sql += " WHERE p.the = pp.the AND pp.id = t.pretrasplante ORDER BY P.THE";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("N° ARTERIAS");
		g.getListaNombre().add("N° VENAS");
		g.getListaNombre().add("URETER");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaLadoRinhonAnomalia() {
		String sql = "SELECT P.THE, T.ID,  P.NOMBRE, P.APELLIDO, T.RINHON, T.ANOMALIA_VASC";
		sql += " FROM PACIENTES P, pacientepretrasplante PP, Trasplante T";
		sql += " WHERE p.the = pp.the AND pp.id = t.pretrasplante ORDER BY P.THE";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.VF);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("RIÑON");
		g.getListaNombre().add("ANOMALIA VASCULAR");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaDonanteCausaMuerte(int idCausa) {
		String sql = "SELECT P.THE,T.ID, P.NOMBRE, P.APELLIDO, D.ID, DCM.DETALLES";
		sql += " FROM PACIENTES P, pacientepretrasplante PP, Trasplante T, donante D, donante_causa_muerte DCM";
		sql += " WHERE p.the = pp.the AND pp.id = t.pretrasplante AND T.ID_DONANTE = D.ID AND D.CAUSA_MUERTE_DONANTE = DCM.ID";
		sql += " AND DCM.ID =" + idCausa;
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("ID DONANTE");
		g.getListaNombre().add("CAUSA MUERTE");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaPacienteInastabilidadHemodinamica() {
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO, T.INESTAB_HEMOD";
		sql += " FROM PACIENTES P, pacientepretrasplante PP, Trasplante T";
		sql += " WHERE p.the = pp.the AND pp.id = t.pretrasplante AND T.INESTAB_HEMOD = true";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.VF);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("INESTABILIDAD HEMODINAMICA");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaPacienteEdadDonanteEdad() {
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO,";
		sql += " (YEAR(fecha) - YEAR(FECHA_NACIMIENTO))- IF(RIGHT(fecha,5) < RIGHT(FECHA_NACIMIENTO,5),1,0) AS age,";
		sql += " D.ID, D.EDAD_DONANTE";
		sql += " FROM PACIENTES P, pacientepretrasplante PP, Trasplante T, DONANTE D";
		sql += " WHERE p.the = pp.the AND pp.id = t.pretrasplante AND T.ID_DONANTE = D.ID ORDER BY D.EDAD_DONANTE";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.integer);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("EDAD DEL PACIENTE");
		g.getListaNombre().add("ID DONANTE");
		g.getListaNombre().add("EDAD DEL DONANTE");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaSexoPacienteDonante() {
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO, P.SEXO, D.ID, D.SEXO_DONANTE";
		sql += " FROM PACIENTES P, pacientepretrasplante PP, Trasplante T, donante D";
		sql += " WHERE p.the = pp.the AND pp.id = t.pretrasplante AND T.ID_DONANTE = D.ID";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("SEXO PACIENTE");
		g.getListaNombre().add("ID DONANTE");
		g.getListaNombre().add("SEXO DONANTE");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaTipoDonantePaciente() {
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO, D.ID, D.TIPO_DONANTE, D.RELACION_FILIAR";
		sql += " FROM PACIENTES P, pacientepretrasplante PP, Trasplante T, donante D";
		sql += " WHERE p.the = pp.the AND pp.id = t.pretrasplante AND T.ID_DONANTE = D.ID";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("ID DONANTE");
		g.getListaNombre().add("TIPO DONANTE");
		g.getListaNombre().add("REALACION FILIAR");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaPacienteVariosTrasplantes() {
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO, T.NUM_TR";
		sql += " FROM PACIENTES P, pacientepretrasplante PP, Trasplante T";
		sql += " WHERE p.the = pp.the AND pp.id = t.pretrasplante AND T.NUM_TR > 1";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.integer);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("CANTIDAD TRASPLANTES");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaPacienteFechaTrasplantes() {
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO, T.FECHA";
		sql += " FROM PACIENTES P, pacientepretrasplante PP, Trasplante T";
		sql += " WHERE p.the = pp.the AND pp.id = t.pretrasplante";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.fechas);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("FECHA TRASPLANTE");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaTrasplantesCompatibilidadIncompatibilidadPRA() {
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO, T.NUM_COMP_A_B, T.NUM_COMP_DR,";
		sql += "T.NUM_IMCOMP_A_B, T.NUM_IMCOMP_DR, T.AUTOAC, T.PRA_MAX, T.PRA_TR";
		sql += " FROM PACIENTES P, pacientepretrasplante PP, Trasplante T";
		sql += " WHERE p.the = pp.the AND pp.id = t.pretrasplante";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.VF);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("COMPATIBILIDAD AB");
		g.getListaNombre().add("COMPATIBILIDAD DR");
		g.getListaNombre().add("INCOMPATIBILIDAD AB");
		g.getListaNombre().add("INCOMPATIBILIDAD DR");
		g.getListaNombre().add("AUTOAC");
		g.getListaNombre().add("PRA MAX");
		g.getListaNombre().add("PRA TR");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaTrasplantesPorCirugia() {
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO, T.TQ_DE_BANCO, T.LADO_IMPLANTE,";
		sql += "T.ANAST_VENOSA, T.ANAST_ARTERIAL, T.ANAST_URETERAL, T.REPERCUSION, T.SANGRADO_I_OP,";
		sql += "T.LESION_ARTERIAL, T.LESION_VENOSA, T.NECESIDAD_REPEFUNDIR, T.OTRAS_COMPL_QUIRUR, T.DIURESIS_I_OP";
		sql += " FROM PACIENTES P, pacientepretrasplante PP, Trasplante T";
		sql += " WHERE p.the = pp.the AND pp.id = t.pretrasplante";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.VF);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.VF);
		g.getListaDada().add(Generico.VF);
		g.getListaDada().add(Generico.VF);
		g.getListaDada().add(Generico.VF);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.VF);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("TQ DE BANCO");
		g.getListaNombre().add("LADO DEL IMPLANTE");
		g.getListaNombre().add("ANAST VENOSA");
		g.getListaNombre().add("ANAST ARTERIAL");
		g.getListaNombre().add("ANAST URETERAL");
		g.getListaNombre().add("REPERFUSION");
		g.getListaNombre().add("SANGRADO I OP");
		g.getListaNombre().add("LESION ARTERIAL");
		g.getListaNombre().add("LESION VENOSA");
		g.getListaNombre().add("NECESIDAD REPEFUNDIR");
		g.getListaNombre().add("OTRAS COMPLICACIONES");
		g.getListaNombre().add("DIURESIS I OP");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaTrasplantesIsquemiaDiuresis(boolean diuresis) {
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO, T.T_ISQ_CAL_MIN, T.T_ISQ_FRIA_HS,";
		sql += "T.T_ISQ_FRIA_MIN, T.T_ISQ_TIBIA_HS, T.REPERCUSION, T.DIURESIS_I_OP";
		sql += " FROM PACIENTES P, pacientepretrasplante PP, Trasplante T";
		sql += " WHERE p.the = pp.the AND pp.id = t.pretrasplante";
		sql += " AND T.DIURESIS_I_OP = " + diuresis;
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.VF);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("T ISQ CAL MIN");
		g.getListaNombre().add("T ISQ FRIA HS");
		g.getListaNombre().add("T ISQ FRIA MIN");
		g.getListaNombre().add("T ISQ TIBIA HS");
		g.getListaNombre().add("REPERFUSION");
		g.getListaNombre().add("DIURESIS I OP");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	private Generico agregarInduccionEnGenerico(Generico original,
			Generico induccion, int largo) {
		ArrayList<Object> nuevosDatos = new ArrayList<Object>();
		int x = 0;
		int y = 0;
		int pos = 0;
		Integer id = 0;
		while (x < original.getListaObtenida().size()) {
			nuevosDatos.add(original.getListaObtenida().get(x).toString());
			if (pos == 1) {
				id = Integer.parseInt(original.getListaObtenida().get(x)
						.toString());
			}
			if (pos == largo - 1) {
				if (y < induccion.getListaObtenida().size()) {
					Integer idT = Integer.parseInt(induccion.getListaObtenida()
							.get(y).toString());
					if (id == idT) {
						nuevosDatos.add(induccion.getListaObtenida().get(y + 1)
								.toString());
						y += 2;
						id = 0;
					} else {
						nuevosDatos.add("false");
					}
				} else {
					nuevosDatos.add("false");
				}
				pos = 0;
			} else {
				pos++;
			}
			x++;
		}
		original.setListaObtenida(nuevosDatos);
		return original;
	}

	public Generico consultaTrasplantesInduccion(
			ArrayList<Induccion> listaInducciones) {
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO";
		sql += " FROM PACIENTES P, pacientepretrasplante PP, Trasplante T";
		sql += " WHERE p.the = pp.the AND pp.id = t.pretrasplante";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.leer();
		for (int x = 0; x < listaInducciones.size(); x++) {
			Induccion aux = (Induccion) listaInducciones.get(x);
			String auxSQL = "SELECT I.id_trasplante, I.valor";
			auxSQL += " FROM trasplante_induccion I WHERE I.id_induccion ="
					+ aux.getId();
			Generico gAux = new Generico();
			gAux.setSql(auxSQL);
			gAux.getListaDada().add(Generico.integer);
			gAux.getListaDada().add(Generico.VF);
			gAux.leer();
			g = agregarInduccionEnGenerico(g, gAux, g.getListaNombre().size());
			g.getListaDada().add(Generico.VF);
			g.getListaNombre().add(aux.getTipo());
		}
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaTrasplantesInmunosupresor(
			ArrayList<Inmunosupresores> listaInmunosupresores) {
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO";
		sql += " FROM PACIENTES P, pacientepretrasplante PP, Trasplante T";
		sql += " WHERE p.the = pp.the AND pp.id = t.pretrasplante";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.leer();
		for (int x = 0; x < listaInmunosupresores.size(); x++) {
			Inmunosupresores aux = (Inmunosupresores) listaInmunosupresores
					.get(x);
			String auxSQL = "SELECT I.id_trasplante, I.valor";
			auxSQL += " FROM trasplante_inmunosupresores I WHERE I.id_inmunosupresores ="
					+ aux.getId();
			Generico gAux = new Generico();
			gAux.setSql(auxSQL);
			gAux.getListaDada().add(Generico.integer);
			gAux.getListaDada().add(Generico.VF);
			gAux.leer();
			g = agregarInduccionEnGenerico(g, gAux, g.getListaNombre().size());
			g.getListaDada().add(Generico.VF);
			g.getListaNombre().add(aux.getTipo());
		}
		this.arreglarDatosGenericos(g);
		return g;
	}

	private Generico arreglarDatosTrasplantesDiuresisEnBQ(Generico g) {
		ArrayList<Object> nuevosDatos = new ArrayList<Object>();
		int pos = 0;
		for (int x = 0; x < g.getListaObtenida().size(); x++) {
			if (pos != 11) {
				nuevosDatos.add(g.getListaObtenida().get(x).toString());
				pos++;
			} else {
				Integer aux = Integer.parseInt(g.getListaObtenida().get(x)
						.toString());
				pos = 0;
				if (aux > 0) {
					nuevosDatos.add("SI");
				} else {
					nuevosDatos.add("NO");
				}
			}
		}
		g.setListaObtenida(nuevosDatos);
		return g;
	}

	public Generico consultaTrasplantesDiuresisEnBQ() {
		String sql = "SELECT P.THE, T.id, P.NOMBRE, P.APELLIDO, T.CR_INICIAL, T.DIURESIS_I_OP, T.DIA_REC_DIURESIS, T.DIA_REC_FUNCIONAL,";
		sql += "T.DIALISIS, T.NUM_DE_HD, (SELECT RA FROM injerto_evolucion I where trasplante = true and pp.id = I.pretrasplante) as RA,";
		sql += "(SELECT II.RESULTADO_PBR FROM injerto_evolucion_pbr II where II.resultado_pbr = 4 AND";
		sql += " II.PreTrasplante IN (SELECT IE.PreTrasplante FROM injerto_evolucion IE where trasplante = true and pp.id = IE.PreTrasplante)) as NTA";
		sql += " FROM PACIENTES P, pacientepretrasplante PP, Trasplante T ";
		sql += " WHERE p.the = pp.the AND pp.id = t.pretrasplante";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.Float);
		g.getListaDada().add(Generico.VF);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.VF);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.VF);
		g.getListaDada().add(Generico.integer);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("CR INICIAL");
		g.getListaNombre().add("DIURESIS I OP");
		g.getListaNombre().add("DIAS REC DIURESIS");
		g.getListaNombre().add("DIAS REC FUNCIONAL");
		g.getListaNombre().add("DIALISIS");
		g.getListaNombre().add("N° DE HD");
		g.getListaNombre().add("RA 1° MES");
		g.getListaNombre().add("NTA 1° MES");
		g.leer();
		this.arreglarDatosGenericos(g);
		g = this.arreglarDatosTrasplantesDiuresisEnBQ(g);
		return g;
	}

	public Generico consultaTrasplantesGermenesInfecciones(int idGermen,
			int idInfeccion, boolean evolucion, FechaControl f) {
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO,";
		sql += "T.FECHA, TC.FECHA AS FECHA_COMPLICACION, M.NOMBRE AS MEDICACION, TC.INTERNADO,";
		sql += "TC.DIAS_DE_INTERNACION, I.NOMBRE AS INFECCION, G.NOMBRE AS GERMEN, TC.EVOLUCION";
		sql += " FROM PACIENTES P, pacientepretrasplante PP, Trasplante T, trasplante_complicaciones TC, medicaciones M,";
		sql += " complicaciones_inf CI, infeccion I, germenes G ";
		sql += " WHERE p.the = pp.the AND pp.id = t.pretrasplante AND PP.ID = TC.IdPreTrasplante AND M.ID = TC.MEDICACION";
		sql += " AND CI.ID_TR_COMPLICACION = TC.ID AND I.ID = CI.INFECCION AND G.ID = CI.GERMEN";
		if (idInfeccion > 0) {
			sql += " AND I.ID = " + idInfeccion;
		}
		if (idGermen > 0) {
			sql += " AND G.ID = " + idGermen;
		}
		// sql += " AND TC.EVOLUCION = " + evolucion;
		sql += " ORDER BY TC.EVOLUCION";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.fechas);
		g.getListaDada().add(Generico.fechas);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.VF);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.VF);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("FECHA TRASPLANTE");
		g.getListaNombre().add("FECHA COMPLICACION");
		g.getListaNombre().add("MEDICACION");
		g.getListaNombre().add("INTERNADO");
		g.getListaNombre().add("DIAS INTERNADO");
		g.getListaNombre().add("INFECCION");
		g.getListaNombre().add("GERMEN");
		g.getListaNombre().add("EN TRASPLANTE");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaPacientesReoperaciones() {
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO, (SELECT COUNT(id_trasplante) FROM trasplante_reoperacion WHERE TR.id_trasplante = T.ID) AS REOPERACIONES";
		sql += " FROM PACIENTES P, pacientepretrasplante PP, Trasplante T, trasplante_reoperacion TR";
		sql += " WHERE p.the = pp.the AND pp.id = t.pretrasplante";
		sql += " ORDER BY REOPERACIONES DESC";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.integer);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("RE OPERACIONES");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public ArrayList<Integer> consultaComplicacionesPorMes(int desde, int hasta) {
		ArrayList<Integer> salida = new ArrayList<Integer>();
		if (desde > hasta)
			return salida;
		for (int x = desde; x < hasta; x++) {
			String sql = "SELECT COUNT(*) FROM pacientepretrasplante PP, Trasplante T, trasplante_complicaciones TC";
			sql += " WHERE pp.id = t.pretrasplante AND pp.id = tc.IdPreTrasplante AND ";
			sql += "ADDDATE(t.fecha,INTERVAL " + x
					+ " MONTH) <= TC.fecha and ADDDATE(ADDDATE(t.fecha,INTERVAL "
					+ (x + 1) + " MONTH),INTERVAL -1 DAY) >= TC.fecha";
			Generico g = new Generico();
			g.setSql(sql);
			g.getListaDada().add(Generico.integer);
			g.leer();
			salida.add((Integer) g.getListaObtenida().get(0));
		}
		return salida;
	}

	public ArrayList<Integer> consultaComplicacionesPorDias(int desde, int hasta) {
		ArrayList<Integer> salida = new ArrayList<Integer>();
		if (desde > hasta)
			return salida;
		for (int x = desde; x < hasta; x++) {
			String sql = "SELECT COUNT(*) FROM pacientepretrasplante PP, Trasplante T, trasplante_complicaciones TC";
			sql += " WHERE pp.id = t.pretrasplante AND pp.id = tc.IdPreTrasplante AND ";
			sql += "ADDDATE(t.fecha,INTERVAL " + x
					+ " DAY) <= TC.fecha and ADDDATE(t.fecha,INTERVAL "
					+ (x + 1) + " DAY) >= TC.fecha";
			Generico g = new Generico();
			g.setSql(sql);
			g.getListaDada().add(Generico.integer);
			g.leer();
			salida.add((Integer) g.getListaObtenida().get(0));
		}
		return salida;
	}

	public ArrayList<Integer> consultaComplicacionesPorYear(int desde, int hasta) {
		ArrayList<Integer> salida = new ArrayList<Integer>();
		if (desde > hasta)
			return salida;
		for (int x = desde; x < hasta; x++) {
			String sql = "SELECT COUNT(*) FROM pacientepretrasplante PP, Trasplante T, trasplante_complicaciones TC";
			sql += " WHERE pp.id = t.pretrasplante AND pp.id = tc.IdPreTrasplante AND ";
			sql += "ADDDATE(t.fecha,INTERVAL " + x
					+ " YEAR) <= TC.fecha and ADDDATE(ADDDATE(t.fecha,INTERVAL "
					+ (x + 1) + " YEAR),INTERVAL -1 DAY) >= TC.fecha";
			Generico g = new Generico();
			g.setSql(sql);
			g.getListaDada().add(Generico.integer);
			g.leer();
			salida.add((Integer) g.getListaObtenida().get(0));
		}
		return salida;
	}

	public Generico consultaPacientesComplicacionesInfecciosasEntreFechas(int desde,
			int hasta, int tipo){
		if (desde > hasta)
			return new Generico();
		if (tipo != 1 && tipo != 2 && tipo != 3)
			return new Generico();
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO, M.NOMBRE, I.NOMBRE, G.NOMBRE ";
		sql += " FROM PACIENTES P, pacientepretrasplante PP, Trasplante T, trasplante_complicaciones TC, medicaciones M, complicaciones_inf CI, infeccion I, germenes G ";
		sql += " WHERE p.the = pp.the AND pp.id = t.pretrasplante AND pp.id = tc.IdPreTrasplante AND M.ID = TC.MEDICACION AND CI.ID_TR_COMPLICACION = TC.id AND I.ID = CI.INFECCION AND CI.GERMEN = G.ID ";
		sql += " AND ";
		switch (tipo) {
		case 1:
			sql += "ADDDATE(t.fecha,INTERVAL " + desde
			+ " MONTH) <= TC.fecha and ADDDATE(t.fecha,INTERVAL " + (hasta)
			+ " MONTH) >= TC.fecha";
			break;
		case 2:
			sql += "ADDDATE(t.fecha,INTERVAL " + desde
			+ " DAY) <= TC.fecha and ADDDATE(t.fecha,INTERVAL " + (hasta)
			+ " DAY) >= TC.fecha";
			break;
		case 3:
			sql += "ADDDATE(t.fecha,INTERVAL " + desde
			+ " YEAR) <= TC.fecha and ADDDATE(t.fecha,INTERVAL " + (hasta)
			+ " YEAR) >= TC.fecha";
			break;
		default:
			break;
		}
		sql += " ORDER BY P.THE";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("MEDICACION");
		g.getListaNombre().add("INFECCION");
		g.getListaNombre().add("GERMEN");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}
	
	public Generico consultaPacientesComplicacionesNoInfecciosasEntreFechas(int desde,
			int hasta, int tipo){
		if (desde > hasta)
			return new Generico();
		if (tipo != 1 && tipo != 2 && tipo != 3)
			return new Generico();
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO, M.NOMBRE, CT.TIPO, CT.NOMBRE ";
		sql += " FROM PACIENTES P, pacientepretrasplante PP, Trasplante T, trasplante_complicaciones TC, medicaciones M, complicaciones_no_inf CNI, complicaciones_tipos CT ";
		sql += " WHERE p.the = pp.the AND pp.id = t.pretrasplante AND pp.id = tc.IdPreTrasplante AND M.ID = TC.MEDICACION AND CNI.ID_TR_COMPLICACION = TC.ID AND CNI.ID_COMPLICACION = CT.ID ";
		sql += " AND ";
		switch (tipo) {
		case 1:
			sql += "ADDDATE(t.fecha,INTERVAL " + desde
			+ " MONTH) <= TC.fecha and ADDDATE(t.fecha,INTERVAL " + (hasta)
			+ " MONTH) >= TC.fecha";
			break;
		case 2:
			sql += "ADDDATE(t.fecha,INTERVAL " + desde
			+ " DAY) <= TC.fecha and ADDDATE(t.fecha,INTERVAL " + (hasta)
			+ " DAY) >= TC.fecha";
			break;
		case 3:
			sql += "ADDDATE(t.fecha,INTERVAL " + desde
			+ " YEAR) <= TC.fecha and ADDDATE(t.fecha,INTERVAL " + (hasta)
			+ " YEAR) >= TC.fecha";
			break;
		default:
			break;
		}
		sql += " ORDER BY P.THE";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("MEDICACION");
		g.getListaNombre().add("TIPO");
		g.getListaNombre().add("NOMBRE");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}
	
	public Generico consultaPacientesCantidadComplicaciones(int desde,
			int hasta, int tipo) {
		if (desde > hasta)
			return new Generico();
		if (tipo != 1 && tipo != 2 && tipo != 3)
			return new Generico();
		String sql = "SELECT P.THE, T.ID, P.NOMBRE, P.APELLIDO,";
		sql += "(SELECT COUNT(IdPreTrasplante) FROM trasplante_complicaciones TC WHERE pp.id = t.pretrasplante AND pp.id = tc.IdPreTrasplante AND ";
		switch (tipo) {
		case 1:
			sql += "ADDDATE(t.fecha,INTERVAL " + desde
			+ " MONTH) <= TC.fecha and ADDDATE(t.fecha,INTERVAL " + (hasta)
			+ " MONTH) >= TC.fecha";
			break;
		case 2:
			sql += "ADDDATE(t.fecha,INTERVAL " + desde
			+ " DAY) <= TC.fecha and ADDDATE(t.fecha,INTERVAL " + (hasta)
			+ " DAY) >= TC.fecha";
			break;
		case 3:
			sql += "ADDDATE(t.fecha,INTERVAL " + desde
			+ " YEAR) <= TC.fecha and ADDDATE(t.fecha,INTERVAL " + (hasta)
			+ " YEAR) >= TC.fecha";
			break;
		default:
			break;
		}
		sql += ") AS CANTIDAD ";
		sql += " FROM PACIENTES P, pacientepretrasplante PP, Trasplante T";
		sql += " WHERE p.the = pp.the AND pp.id = t.pretrasplante";
		sql += " ORDER BY CANTIDAD DESC";
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.integer);
		g.getListaNombre().add("THE");
		g.getListaNombre().add("ID TRASPLANTE");
		g.getListaNombre().add("NOMBRE");
		g.getListaNombre().add("APELLIDO");
		g.getListaNombre().add("CANTIDAD");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}

	public Generico consultaPacientesComplicacionesInfecciosasDetalles(int desde,
			int hasta, int tipo, int the) {
		if (desde > hasta)
			return new Generico();
		if (tipo != 1 && tipo != 2 && tipo != 3)
			return new Generico();
		String sql = "";
		sql += " SELECT tc.fecha, m.nombre as medicacion, tc.internado, tc.DIAS_DE_INTERNACION as dias, i.nombre as infeccion, g.nombre as germen ";
		sql += " FROM trasplante_complicaciones tc, medicaciones m,complicaciones_inf ci, infeccion i, germenes g,";
		sql += " PACIENTES P, pacientepretrasplante PP, Trasplante T ";
		sql += " where tc.medicacion = m.id ";
		sql += " and ci.ID_TR_COMPLICACION = tc.id ";
		sql += " and ci.infeccion = i.id ";
		sql += " and ci.germen = g.id ";
		sql += " and p.the = pp.the ";
		sql += " and pp.id = tc.IdPreTrasplante ";
		sql += " AND pp.id = t.pretrasplante ";
		sql += " and p.the = " + the;
		sql += " AND ";//"ADDDATE(t.fecha,INTERVAL " + desde + " MONTH) <= TC.fecha and ADDDATE(t.fecha,INTERVAL " + hasta + " MONTH) >= TC.fecha";
		switch (tipo) {
		case 1:
			sql += "ADDDATE(t.fecha,INTERVAL " + desde
			+ " MONTH) <= TC.fecha and ADDDATE(t.fecha,INTERVAL " + (hasta)
			+ " MONTH) >= TC.fecha";
			break;
		case 2:
			sql += "ADDDATE(t.fecha,INTERVAL " + desde
			+ " DAY) <= TC.fecha and ADDDATE(t.fecha,INTERVAL " + (hasta)
			+ " DAY) >= TC.fecha";
			break;
		case 3:
			sql += "ADDDATE(t.fecha,INTERVAL " + desde
			+ " YEAR) <= TC.fecha and ADDDATE(t.fecha,INTERVAL " + (hasta)
			+ " YEAR) >= TC.fecha";
			break;
		default:
			break;
		}
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.fechas);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.VF);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaNombre().add("FECHA");
		g.getListaNombre().add("MEDICACION");
		g.getListaNombre().add("INTERNADO");
		g.getListaNombre().add("DIAS");
		g.getListaNombre().add("INFECCION");
		g.getListaNombre().add("GERMEN");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}
	
	public Generico consultaPacientesComplicacionesNoInfecciosasDetalles(int desde,
			int hasta, int tipo, int the) {
		if (desde > hasta)
			return new Generico();
		if (tipo != 1 && tipo != 2 && tipo != 3)
			return new Generico();
		String sql = "";
		sql += " SELECT tc.fecha, m.nombre as medicacion, tc.internado, tc.DIAS_DE_INTERNACION as dias, ct.tipo, ct.nombre ";
		sql += " FROM trasplante_complicaciones tc, medicaciones m, complicaciones_no_inf cni, complicaciones_tipos ct,";
		sql += " PACIENTES P, pacientepretrasplante PP, Trasplante T ";
		sql += " where tc.medicacion = m.id ";
		sql += " and cni.ID_TR_COMPLICACION = tc.id ";
		sql += " and cni.ID_COMPLICACION = ct.id ";
		sql += " and p.the = pp.the ";
		sql += " and pp.id = tc.IdPreTrasplante ";
		sql += " AND pp.id = t.pretrasplante ";
		sql += " and p.the = " + the;
		sql += " AND ";//"ADDDATE(t.fecha,INTERVAL " + desde + " MONTH) <= TC.fecha and ADDDATE(t.fecha,INTERVAL " + hasta + " MONTH) >= TC.fecha";
		switch (tipo) {
		case 1:
			sql += "ADDDATE(t.fecha,INTERVAL " + desde
			+ " MONTH) <= TC.fecha and ADDDATE(t.fecha,INTERVAL " + (hasta)
			+ " MONTH) >= TC.fecha";
			break;
		case 2:
			sql += "ADDDATE(t.fecha,INTERVAL " + desde
			+ " DAY) <= TC.fecha and ADDDATE(t.fecha,INTERVAL " + (hasta)
			+ " DAY) >= TC.fecha";
			break;
		case 3:
			sql += "ADDDATE(t.fecha,INTERVAL " + desde
			+ " YEAR) <= TC.fecha and ADDDATE(t.fecha,INTERVAL " + (hasta)
			+ " YEAR) >= TC.fecha";
			break;
		default:
			break;
		}
		Generico g = new Generico();
		g.setSql(sql);
		g.getListaDada().add(Generico.fechas);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.VF);
		g.getListaDada().add(Generico.integer);
		g.getListaDada().add(Generico.letras);
		g.getListaDada().add(Generico.letras);
		g.getListaNombre().add("FECHA");
		g.getListaNombre().add("MEDICACION");
		g.getListaNombre().add("INTERNADO");
		g.getListaNombre().add("DIAS");
		g.getListaNombre().add("TIPO");
		g.getListaNombre().add("NOMBRE");
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}
	
	public void guardarGenericoAuxiliar(GenericoAuxiliar ga) {
		ga.guardar();
	}

	public ArrayList<GenericoAuxiliar> obtenerTodasConsultasCreadas() {
		GenericoAuxiliar ga = new GenericoAuxiliar();
		return ga.obtenerTodos();
	}

	public void eliminarGenericoAuxiliar(GenericoAuxiliar ga) {
		ga.eliminar();
	}

	public Generico convertirAuxiliarGenerico(GenericoAuxiliar ga) {
		Generico g = new Generico();
		g.setSql(ga.getSentencia());
		String aux = "";
		for (int x = 0; x < ga.getTipos().length(); x++) {
			if (ga.getTipos().charAt(x) != '|') {
				aux += ga.getTipos().charAt(x);
			} else {
				g.getListaDada().add(aux);
				aux = "";
			}
		}
		for (int x = 0; x < ga.getNombres().length(); x++) {
			if (ga.getNombres().charAt(x) != '|') {
				aux += ga.getNombres().charAt(x);
			} else {
				g.getListaNombre().add(aux);
				aux = "";
			}
		}
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}
}
