package uy.transplante.reportes.registrouruguayotrasplantes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import uy.transplante.auxiliares.fechas.ManejoFechas;

import logica.Fachada;

import dominio.CMV;
import dominio.CausaMuerteDonante;
import dominio.Donante;
import dominio.EvolucionInjerto;
import dominio.Paciente;
import dominio.PacientePerdidaInjerto;
import dominio.PacientePreTrasplante;
import dominio.Trasplante;
import dominio.TrasplanteInduccionUsado;

public class CrearReporteFondoPreTrasplante_RA_CMV {

	private String exportar = "";
	private int lugar = 0;

	public int getLugar() {
		return lugar;
	}

	public void setLugar(int lugar) {
		this.lugar = lugar;
	}

	public String getExportar() {
		return exportar;
	}

	public void setExportar(String exportar) {
		this.exportar = exportar;
	}

	public CrearReporteFondoPreTrasplante_RA_CMV() {

	}

	public void crear(int year) {
		exportar = this.cabezal(year);
		exportar += this.inicioTabla();
		exportar += this.datosTabla(year);
		exportar += this.cerrarTabla();
		exportar += this.pie();
		System.out.println(exportar);
		System.out.println();
		System.out.println(System.getProperty("user.dir"));
		java.io.File unArchivo = new java.io.File(System
				.getProperty("user.dir")
				+ "/exportacionFondoEstadisticos.xls");

		FileWriter buf;

		try {
			buf = new FileWriter(unArchivo);
			buf.write(exportar);
			buf.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		}
	}

	public void crear() {
		exportar = this.cabezal();
		exportar += this.inicioTabla();
		exportar += this.datosTabla();
		exportar += this.cerrarTabla();
		exportar += this.pie();
		System.out.println(exportar);
		System.out.println();
		System.out.println(System.getProperty("user.dir"));
		java.io.File unArchivo = new java.io.File(System
				.getProperty("user.dir")
				+ "/exportacionFondoEstadisticos.xls");
		FileWriter buf;
		try {
			buf = new FileWriter(unArchivo);
			buf.write(exportar);
			buf.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		}
		java.io.File archivoHTML = new java.io.File(System
				.getProperty("user.dir")
				+ "/exportacionFondoEstadisticos.html");
		FileWriter bufHTML;
		try {
			bufHTML = new FileWriter(archivoHTML);
			bufHTML.write(exportar);
			bufHTML.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		}
		this.setLugar(-2);
	}

	public String cabezal() {
		String aux = "";
		aux = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" ";
		aux += "\"http://www.w3.org/TR/html4/loose.dtd\">";
		aux += "<html>";
		aux += "<head>";
		aux += "<title>Reporte Fondo</title>";
		aux += "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">";
		aux += "<style type=\"text/css\">";
		aux += "<!--" + ".Estilo1 {" + "font-size: 24px;"
				+ "font-weight: bold;" + "}" + ".Estilo3 {font-size: 24px}"
				+ "-->" + "</style>" + "</head>" +

				"<body>";
		return aux;
	}

	public String cabezal(int year) {
		String aux = "";
		aux = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" ";
		aux += "\"http://www.w3.org/TR/html4/loose.dtd\">";
		aux += "<html>";
		aux += "<head>";
		aux += "<title>Reporte Fondo</title>";
		aux += "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">";
		aux += "<style type=\"text/css\">";
		aux += "<!--" + ".Estilo1 {" + "font-size: 24px;"
				+ "font-weight: bold;" + "}" + ".Estilo3 {font-size: 24px}"
				+ "-->" + "</style>" + "</head>" +

				"<body>";
		aux += "<div align=\"center\">"
				+ "<p class=\"Estilo1\">REPORTE DEL PACIENTE DEL A&Ntilde;O : "
				+ year + "</p><hr>";
		return aux;
	}

	private String inicioTabla() {
		String salida = "<table width=\"1171\" height=\"391\" border=\"2\">";
		salida += "<tr>";
		salida += "<th scope=\"col\">CENTRO:</th>";
		salida += "<th scope=\"col\">NUM REG ASIGNADO POR EL CENTRO</th>";
		salida += "<th scope=\"col\">DIAB&Eacute;TICO PRE TR</th>";
		salida += "<th scope=\"col\">NEFROPATIA (C&Oacute;DIGO DEL FNR)</th>";
		salida += "<th scope=\"col\">MES DEL TRASPLANTE</th>";
		salida += "<th scope=\"col\">A&Ntilde;O DEL TRASPLANTE</th>";
		salida += "<th scope=\"col\">SITUACI&Oacute;N A DIC 08</th>";
		salida += "<th scope=\"col\">MES EGRESO</th>";
		salida += "<th scope=\"col\">A&Ntilde;O EGRESO</th>";
		salida += "<th scope=\"col\">CAUSA MUERTE</th>";
		salida += "<th scope=\"col\">CAUSA PERDIDA INJERTO</th>";
		salida += "<th scope=\"col\"> EDAD AL TRASPLANTE</th>";
		salida += "<th scope=\"col\">SEXO</th>";
		salida += "<th scope=\"col\">MESES EN DIALISIS</th>";
		salida += "<th scope=\"col\">MESES EN LISTA DE ESPERA</th>";
		salida += "<th scope=\"col\">EDAD DE DADOR</th>";
		salida += "<th scope=\"col\">SEXO DADOR</th>";
		salida += "<th scope=\"col\">VIVO O CADAV&Eacute;RICO</th>";
		salida += "<th scope=\"col\">CAUSA MUERTE</th>";
		salida += "<th scope=\"col\">N&deg; INCOMPATIBILIDAD AB</th>";
		salida += "<th scope=\"col\">N&deg; INCOMPATIBILIDAD DR</th>";
		salida += "<th scope=\"col\">IF: ISQUEMIA FR&Iacute;A</th>";
		salida += "<th scope=\"col\">INDUCCI&Oacute;N: MARQUE LO QUE INCLUY&Oacute;</th>";
		salida += "<th scope=\"col\">HTA</th>";
		salida += "<th scope=\"col\">Obesidad</th>";
		salida += "<th scope=\"col\">IMC</th>";
		salida += "<th scope=\"col\">Dislipemia</th>";
		salida += "<th scope=\"col\">Tabaquismo</th>";
		salida += "<th scope=\"col\">Diabetes</th>";
		salida += "<th scope=\"col\">RA Rechazo Agudo</th>";
		salida += "<th scope=\"col\">RA Fecha Rechazo Agudo</th>";
		salida += "<th scope=\"col\">CMV</th>";
		salida += "<th scope=\"col\">CMV Fecha</th>";
		salida += "</tr>";
		return salida;
	}

	private String formarTabla(ArrayList<Trasplante> lista) {
		String salida = "";
		if (lista.size() > 0) {
			for (int x = 0; x < lista.size(); x++) {
				Trasplante t = (Trasplante) lista.get(x);
				salida += "<tr>";
				salida += "<td><Strong>HE</Strong></td>";
				System.out.println(String.valueOf(t.getId()));
				this.setLugar(t.getId());
				PacientePreTrasplante pt = new PacientePreTrasplante();
				pt.setId(t.getPreTrasplante());
				pt.leer();
				Paciente p = new Paciente();
				p.setThe(pt.getThe());
				p.leer();
				salida += "<td>" + p.getThe() + "</td>";
				salida += "<td>" + pt.getDiabetes() + "</td>";

				salida += "<td>" + p.getTipoNefropatia().getNefropatia()
						+ "</td>";
				salida += "<td>"
						+ ManejoFechas.FORMATOMES
								.format(t.getFecha().getTime()) + "</td>";
				salida += "<td>"
						+ ManejoFechas.FORMATOYEAR.format(t.getFecha()
								.getTime()) + "</td>";
				String estado = "1: EN DIALISIS";
				if (t.getFechaAlta() == null) {
					estado = "3. VIVO EN TR";
				}
				boolean murio = false;
				if (p.getMuertePaciente() != null) {
					if (p.getMuertePaciente().getFechaMuerte() != null) {
						estado = "2: FALLECIO EN TR";
						murio = true;
					}
				}
				salida += "<td>" + estado + "</td>";
				if (!murio) {
					salida += "<td> Sin Alta </td>";
					salida += "<td> Sin Alta </td>";
				} else {
					salida += "<td>"
							+ ManejoFechas.FORMATOMES.format(p
									.getMuertePaciente().getFechaMuerte()
									.getTime()) + "</td>";
					salida += "<td>"
							+ ManejoFechas.FORMATOYEAR.format(p
									.getMuertePaciente().getFechaMuerte()
									.getTime()) + "</td>";
				}
				/*
				 * if (t.getFechaAlta() == null) { salida +=
				 * "<td> Sin Alta </td>"; salida += "<td> Sin Alta </td>"; }
				 * else { salida += "<td>" +
				 * ManejoFechas.formatoMes.format(t.getFechaAlta() .getTime()) +
				 * "</td>"; salida += "<td>" +
				 * ManejoFechas.formatoYear.format(t.getFechaAlta() .getTime())
				 * + "</td>"; }
				 */

				if (p.getMuertePaciente() != null) {
					if (p.getMuertePaciente().getFechaMuerte() != null) {
						salida += "<td>"
								+ p.getMuertePaciente().getCausa().getDetalle()
								+ "</td>";
					} else {
						salida += "<td> Sin Muerte </td>";
					}
				} else {
					salida += "<td> Sin Muerte </td>";
				}
				if (p.getListaPerdidas().size() > 0) {
					PacientePerdidaInjerto auxPerdida = (PacientePerdidaInjerto) p
							.getListaPerdidas().get(0);
					System.out.println(auxPerdida.getNumCausa());
					salida += "<td> Tuvo una perdida </td>";
				} else {
					salida += "<td> Sin Perdida </td>";
				}

				salida += "<td>" + String.valueOf(p.calcularEdad(t.getFecha()))
						+ "</td>";
				salida += "<td>" + p.getSexo() + "</td>";
				salida += "<td>"
						+ String.valueOf(t.getMeses(p.getFecha_dialisis()))
						+ "</td>";
				salida += "<td>" + String.valueOf(pt.getMeses()) + "</td>";
				Donante d = new Donante();
				d.setId(t.getNumDonante());
				d.leerMinimo();
				salida += "<td>" + String.valueOf(d.getEdad()) + "</td>";
				salida += "<td>" + d.getSexo() + "</td>";
				salida += "<td>" + d.getTipo() + "</td>";
				CausaMuerteDonante cd = new CausaMuerteDonante();
				cd.setId(d.getNumCausaMuerte());
				cd.leer();
				salida += "<td>" + cd.getDetalle() + "</td>";
				salida += "<td>" + String.valueOf(t.getNumIncompAB()) + "</td>";
				salida += "<td>" + String.valueOf(t.getNumIncompDR()) + "</td>";
				salida += "<td>" + String.valueOf(t.getTIsqFriqHs()) + " : "
						+ String.valueOf(t.getTIsqFriaMin()) + "</td>";
				salida += "<td>";
				t.leerInducciones();
				for (int i = 0; i < t.getListaInducciones().size(); i++) {
					TrasplanteInduccionUsado aux = (TrasplanteInduccionUsado) t
							.getListaInducciones().get(i);
					salida += aux.getInduccion().getTipo();
					salida += " - ";
				}
				salida += "</td>";
				salida += "<td>";
				if (pt.isHta()) {
					salida += "VERDADERO";
				} else {
					salida += "FALSO";
				}
				salida += "</td>";
				salida += "<td>";
				if (pt.isObesidad()) {
					salida += "VERDADERO";
				} else {
					salida += "FALSO";
				}
				salida += "</td>";
				salida += "<td>";
				salida += pt.getImc();
				salida += "</td>";
				salida += "<td>";
				if (pt.isDislipemia()) {
					salida += "VERDADERO";
				} else {
					salida += "FALSO";
				}
				salida += "</td>";
				salida += "<td>";
				if (pt.isTabaquismo()) {
					salida += "VERDADERO";
				} else {
					salida += "FALSO";
				}
				salida += "</td>";
				salida += "<td>";
				salida += pt.getDiabetes();
				salida += "</td>";
				pt.setTrasplante(t);
				PacientePreTrasplante modificar = new PacientePreTrasplante(pt);
				modificar.getTrasplante().leerEvolucionInjerto();
				ArrayList<EvolucionInjerto> listaEvolucionesInjerto = new ArrayList<EvolucionInjerto>();
				listaEvolucionesInjerto = Fachada.getInstancia()
						.obtenertodosEvolucionInjerto(pt.getId());
				String auxFechaEvolucion = " - " + "<br>";;
				String auxEvolucion = "FALSO" + "<br>";;
				if (modificar.getTrasplante().getEvolucion() != null) {
					if (modificar.getTrasplante().getEvolucion().isRa()) {
						auxEvolucion = "VERDADERO";
						auxFechaEvolucion = ManejoFechas.FORMATOESPANOL
								.format(modificar.getTrasplante().getFecha()
										.getTime());
					}
				}
				for (EvolucionInjerto evolucion : listaEvolucionesInjerto) {
					if (evolucion.isRa()) {
						auxEvolucion += "<br>" + "VERDADERO";
						auxFechaEvolucion += "<br>"
								+ ManejoFechas.FORMATOESPANOL.format(modificar
										.getTrasplante().getFecha().getTime());
					}
				}
				salida += "<td>";
				salida += auxEvolucion;
				salida += "</td>";
				salida += "<td>";
				salida += auxFechaEvolucion;
				salida += "</td>";
				ArrayList<CMV> listaCMV = new ArrayList<CMV>();
				listaCMV = Fachada.getInstancia().obtenerTodosCMV(t.getId());
				String auxCMV = " - " + "<br>";;
				String auxFechaCMV = " - " + "<br>";;
				for(CMV cmv : listaCMV){
					if(cmv.isSindromeViral()){
						auxCMV += "Sindrome Viral" + "<br>";
						auxFechaCMV += ManejoFechas.FORMATOESPANOL.format(cmv.getFecha().getTime())+ "<br>";
					}else{
						if(cmv.getEnfermedades() != null){
							auxCMV += "Enfermedad " + "<br>";
							auxFechaCMV += ManejoFechas.FORMATOESPANOL.format(cmv.getFecha().getTime())+ "<br>";
						}
					}
				}
				salida += "<td>";
				salida += auxCMV;
				salida += "</td>";
				salida += "<td>";
				salida += auxFechaCMV;
				salida += "</td>";
				salida += "</tr>";
			}
		}
		return salida;
	}

	private String datosTabla(int year) {
		String salida = "";
		ArrayList<Trasplante> lista = Fachada.getInstancia()
				.obtenerTraspalantesDelYear(year);
		salida = this.formarTabla(lista);
		return salida;
	}

	private String datosTabla() {
		String salida = "";
		ArrayList<Trasplante> lista = Fachada.getInstancia()
				.obtenerTodosTrasplantesSimple();
		salida = this.formarTabla(lista);
		return salida;
	}

	private String cerrarTabla() {
		return "</table>";
	}

	public String pie() {
		String aux = "";
		aux += "</body>" + "</html>";
		return aux;
	}

}
