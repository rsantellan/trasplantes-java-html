/**
 * 
 */
package uy.transplante.reportes.urologicas;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import uy.transplante.auxiliares.fechas.ManejoFechas;
import uy.transplante.dominio.EvolucionTrasplanteTotal;
import uy.transplante.dominio.Paciente;
import uy.transplante.dominio.PacientePerdidaInjerto;
import uy.transplante.dominio.PacientePreTrasplante;
import uy.transplante.dominio.Trasplante;
import uy.transplante.dominio.TrasplanteComplicacionesNoInf;


/**
 * @author rodrigo
 * @version 0.1
 * 
 */
public class ConsultaUrologicaExcel {

	private String exportar = "";
	private int lugar = 0;
	//private String synch = "";
	
	public int getLugar() {
		return lugar;
	}

	public void setLugar(int lugar) {
		this.lugar = lugar;
	}
	
	public String cabezal() {
		String aux = "";
		aux = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" ";
		aux += "\"http://www.w3.org/TR/html4/loose.dtd\">";
		aux += "<html>";
		aux += "<head>";
		aux += "<title>Consulta Urologica</title>";
		aux += "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">";
		aux += "<style type=\"text/css\">";
		aux += "<!--" + ".Estilo1 {" + "font-size: 24px;"
				+ "font-weight: bold;" + "}" + ".Estilo3 {font-size: 24px}"
				+ "-->" + "</style>" + "</head>" +

				"<body>";
		return aux;
	}
	
	private String inicioTabla() {
		String salida = "<table width=\"1171\" height=\"391\" border=\"2\">";
		salida += "<tr>";
		salida += "<th scope=\"col\">NUM REG ASIGNADO POR EL CENTRO</th>";
		salida += "<th scope=\"col\">EDAD</th>";
		salida += "<th scope=\"col\">NEFROPATIA</th>";
		salida += "<th scope=\"col\">IMC</th>";
		salida += "<th scope=\"col\">FECHA DE TRASPLANTE</th>";
		
		salida += "<th scope=\"col\">ANAST URETERAL</th>";
		salida += "<th scope=\"col\">OTRA COMPLICACION QUIRURGICA</th>";
		salida += "<th scope=\"col\">COMENTARIO DEL TRASPLANTE</th>";
		
		salida += "<th scope=\"col\">FECHA COMPLICACION</th>";
		salida += "<th scope=\"col\">EVOLUCION</th>";
		salida += "<th scope=\"col\">INTERNADO</th>";
		salida += "<th scope=\"col\">CANTIDAD DE DIAS</th>";
		salida += "<th scope=\"col\">COMENTARIO</th>";
		salida += "<th scope=\"col\">COMPLICACION</th>";
		salida += "<th scope=\"col\">MEDICACION</th>";
		
		salida += "<th scope=\"col\">FECHA COMPLICACION</th>";
		salida += "<th scope=\"col\">EVOLUCION</th>";
		salida += "<th scope=\"col\">INTERNADO</th>";
		salida += "<th scope=\"col\">CANTIDAD DE DIAS</th>";
		salida += "<th scope=\"col\">COMENTARIO</th>";
		salida += "<th scope=\"col\">COMPLICACION</th>";
		salida += "<th scope=\"col\">MEDICACION</th>";
		
		salida += "<th scope=\"col\">FECHA COMPLICACION</th>";
		salida += "<th scope=\"col\">EVOLUCION</th>";
		salida += "<th scope=\"col\">INTERNADO</th>";
		salida += "<th scope=\"col\">CANTIDAD DE DIAS</th>";
		salida += "<th scope=\"col\">COMENTARIO</th>";
		salida += "<th scope=\"col\">COMPLICACION</th>";
		salida += "<th scope=\"col\">MEDICACION</th>";
		
		salida += "<th scope=\"col\">PERDIDA INJERTO</th>";
		salida += "<th scope=\"col\">FECHA</th>";
		salida += "<th scope=\"col\">CAUSA</th>";
		salida += "</tr>";
		return salida;
	}
	
	public void crear(){
		exportar = this.cabezal();
		exportar += this.inicioTabla();
		exportar += this.consultaUrologica();
		exportar += this.cerrarTabla();
		exportar += this.pie();
		System.out.println(exportar);
		System.out.println();
		System.out.println(System.getProperty("user.dir"));
		java.io.File unArchivo = new java.io.File(System.getProperty("user.dir")+ "/ConsultaUrologica.xls");
		FileWriter buf;
		try {
			buf = new FileWriter(unArchivo);
			buf.write(exportar);
			buf.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}catch(Exception e1){
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		}
		java.io.File archivoHTML = new java.io.File(System.getProperty("user.dir") + "/ConsultaUrologica.html");
		FileWriter bufHTML;
		try {
			bufHTML = new FileWriter(archivoHTML);
			bufHTML.write(exportar);
			bufHTML.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}catch(Exception e1){
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		}
		this.setLugar(-2);
	}
	
	public String consultaUrologica() {
		Paciente p = new Paciente();
		List<Paciente> listaPacientes = p.obtenerTodos();
		int maximoRecorrida = 0;
		int total = 0;
		String salida = "";
		for (int x = 0; x < listaPacientes.size(); x++) {
			Paciente aux = listaPacientes.get(x);
			ArrayList<PacientePreTrasplante> listaPreTrasplantes = aux
					.buscarPreTrasplantePaciente();
			for (int y = 0; y < listaPreTrasplantes.size(); y++) {
				PacientePreTrasplante pacientePreTrasplante = listaPreTrasplantes.get(y);
				pacientePreTrasplante.leerTrasplante();
				Trasplante trasplante = pacientePreTrasplante.getTrasplante();
				salida += "<tr>";
				int maximo = 0;
				salida += "<td>" + aux.getThe() + "</td>";
				
				salida += "<td>" + aux.calcularEdad(new GregorianCalendar()) + "</td>";
				
				salida += "<td>" + aux.getTipoNefropatia().toString() + "</td>";

				
				salida += "<td>" + pacientePreTrasplante.getImc() + "</td>";
				
				salida += "<td>" + ManejoFechas.FORMATOESPANOL.format(trasplante.getFecha().getTime()) + "</td>";

				salida += "<td>" + trasplante.getAnastUterial() + "</td>";

				salida += "<td>" + trasplante.getOtrasComplicacionesQuirurgicas() + "</td>";

				salida += "<td>" + trasplante.getComentario() + "</td>";
			
				trasplante.leerComplicaciones();
				for (int k = 0; k < trasplante.getListaComplicacionesNoInf()
						.size(); k++) {
					TrasplanteComplicacionesNoInf complicacionNoInfecciosa = trasplante
							.getListaComplicacionesNoInf().get(k);
					int numeroComplicacion = complicacionNoInfecciosa
							.getIdComplicacionTipos();
					if (numeroComplicacion == 1 || numeroComplicacion == 68
							|| numeroComplicacion == 72
							|| numeroComplicacion == 73
							|| numeroComplicacion == 78
							|| numeroComplicacion == 85
							|| numeroComplicacion == 88
							|| numeroComplicacion == 91) {
						total++;
						if (!complicacionNoInfecciosa.isEvolucion()) {
							maximo++;
							salida += "<td BGCOLOR='#FFFF66'>" + ManejoFechas.FORMATOESPANOL.format(complicacionNoInfecciosa.getFecha().getTime()) + "</td>";

							salida += "<td BGCOLOR='#FFFF66'>" + complicacionNoInfecciosa.isEvolucion() + "</td>";
							
							salida += "<td BGCOLOR='#FFFF66'>" + complicacionNoInfecciosa.isInternado() + "</td>";

							salida += "<td BGCOLOR='#FFFF66'>" + complicacionNoInfecciosa.getDiasInternado() + "</td>";
							
							salida += "<td BGCOLOR='#FFFF66'>" + complicacionNoInfecciosa.getComentario() + "</td>";
							
							salida += "<td BGCOLOR='#FFFF66'>" + complicacionNoInfecciosa.getComentario() + "</td>";

							salida += "<td BGCOLOR='#FFFF66'>" + complicacionNoInfecciosa.getMedicacion().getNombre() + "</td>";
						}

					}
				}
				EvolucionTrasplanteTotal auxE = new EvolucionTrasplanteTotal();
				auxE.setIdPreTrasplante(trasplante.getPreTrasplante());
				auxE.setIdTrasplante(trasplante.getId());
				auxE.datosComplicacionesNoInf();
				ArrayList<TrasplanteComplicacionesNoInf> listaComplicacionesNoInfecciosas = auxE.getListaComplicacionesNoInf();
				for (int l = 0; l < listaComplicacionesNoInfecciosas.size(); l++) {
					TrasplanteComplicacionesNoInf complicacionNoInfecciosaEvolucion = listaComplicacionesNoInfecciosas.get(l);
					int numeroComplicacionEvolucion = complicacionNoInfecciosaEvolucion
							.getIdComplicacionTipos();
					if (numeroComplicacionEvolucion == 1
							|| numeroComplicacionEvolucion == 68
							|| numeroComplicacionEvolucion == 72
							|| numeroComplicacionEvolucion == 73
							|| numeroComplicacionEvolucion == 78
							|| numeroComplicacionEvolucion == 85
							|| numeroComplicacionEvolucion == 88
							|| numeroComplicacionEvolucion == 91) {
						total++;
						if (complicacionNoInfecciosaEvolucion.isEvolucion()) {
							maximo++;
							salida += "<td BGCOLOR='#99FF66'>" + ManejoFechas.FORMATOESPANOL.format(complicacionNoInfecciosaEvolucion.getFecha().getTime()) + "</td>";

							salida += "<td BGCOLOR='#99FF66'>" + complicacionNoInfecciosaEvolucion.isEvolucion() + "</td>";

							salida += "<td BGCOLOR='#99FF66'>" + complicacionNoInfecciosaEvolucion.isInternado() + "</td>";
							
							salida += "<td BGCOLOR='#99FF66'>" + complicacionNoInfecciosaEvolucion.getDiasInternado() + "</td>";

							salida += "<td BGCOLOR='#99FF66'>" + complicacionNoInfecciosaEvolucion.getComentario() + "</td>";

							salida += "<td BGCOLOR='#99FF66'>" + complicacionNoInfecciosaEvolucion.getComplicacion().getNombre() + "</td>";

							salida += "<td BGCOLOR='#99FF66'>" + complicacionNoInfecciosaEvolucion.getMedicacion().getNombre() + "</td>";
						}
					}
				}
				if(maximo <3){
					while(maximo <3){
						salida += "<td BGCOLOR='#000000'>-</td>";
						salida += "<td BGCOLOR='#000000'>-</td>";
						salida += "<td BGCOLOR='#000000'>-</td>";
						salida += "<td BGCOLOR='#000000'>-</td>";
						salida += "<td BGCOLOR='#000000'>-</td>";
						salida += "<td BGCOLOR='#000000'>-</td>";
						salida += "<td BGCOLOR='#000000'>-</td>";
						maximo++;
					}
				}
				aux.leerDatosPerdidaInjerto();
				int perdidas = 0;
				for (int i = 0; i < aux.getListaPerdidas().size(); i++) {
					perdidas++;
					PacientePerdidaInjerto perdida = aux.getListaPerdidas().get(i);
					if (perdida.getNumPreTrasplante() == pacientePreTrasplante.getId()) {
						salida += "<td>" + ManejoFechas.FORMATOESPANOL.format(perdida.getFechaPerdida().getTime()) + "</td>";
						salida += "<td>" + perdida.getCausa().getDetalle() + "</td>";
					}else{
						salida += "<td>-</td>";
						salida += "<td>-</td>";
					}
				}
				if(perdidas == 0){
					salida += "<td>-</td>";
					salida += "<td>-</td>";
				}
				if (maximo > maximoRecorrida) {
					maximoRecorrida = maximo;
				}
			}

		}
		System.out.println(maximoRecorrida);
		System.out.println("Total : " + total);
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
