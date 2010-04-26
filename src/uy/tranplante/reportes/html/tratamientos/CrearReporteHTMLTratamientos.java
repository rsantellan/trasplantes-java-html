/**
 * 
 */
package uy.tranplante.reportes.html.tratamientos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import auxiliares.ManejoFechas;

import dominio.Tratamiento;
import logica.Fachada;

/**
 * @author rodrigo
 * 
 */
public class CrearReporteHTMLTratamientos {

	private ArrayList<Tratamiento> lista = new ArrayList<Tratamiento>();
	private ArrayList<Tratamiento> listaActivos = new ArrayList<Tratamiento>(); // @jve:decl-index=0:
	private ArrayList<Tratamiento> listaNoActivos = new ArrayList<Tratamiento>();
	private String delimiter = "\n";

	public String tratamientos(int idPaciente) {
		String aux = "";
		this.lista = Fachada.getInstancia()
				.obtenerTodosTratamientos(idPaciente);
		Calendar c = new GregorianCalendar();
		c.clear();
		c.set(1950, 1, 1);
		this.listaActivos.clear();
		this.listaNoActivos.clear();
		for (int x = 0; x < lista.size(); x++) {
			Tratamiento t = lista.get(x);
			if (t.getFecha_fin().equals(c)) {
				this.listaActivos.add(t);
			} else {
				this.listaNoActivos.add(t);
			}
		}

		aux += "<table width=\"200\" border=\"2\">" + this.delimiter;
		aux += "<tr>" + this.delimiter;
		aux += "<td>" + this.delimiter;
		aux += "<div align=\"center\">" + this.delimiter;
		aux += "<p class=\"Estilo1\">Tratamientos</p>" + this.delimiter;
		aux += "<hr>" + this.delimiter;
		aux += "<h3>Activos</h3> <hr>" + this.delimiter;
		
		aux += "<table width=\"800\" height=\"100\" border=\"0\">" + this.delimiter;
		for (int x = 0; x < this.listaActivos.size(); x++) {
			Tratamiento t = lista.get(x);
			aux += "<tr>" + this.delimiter;
			aux += "<td><strong>Fecha de inicio:</strong></td>" + this.delimiter;
			aux += "<td>"+ManejoFechas.formatoEspanol.format(t.getFecha_inicio().getTime())+"</td>" + this.delimiter;
			aux += "<td><strong>Fecha de fin: </strong></td>" + this.delimiter;
			aux += "<td>-</td>" + this.delimiter;
			aux += "<td><strong>Medicación</strong></td>" + this.delimiter;
			aux += "<td>"+t.getMedicacion().getNombre()+"</td>" + this.delimiter;
			aux += "<td><strong>Dosis</strong></td>" + this.delimiter;
			aux += "<td>"+t.getDosis()+"</td>" + this.delimiter;
			aux += "</tr>" + this.delimiter;
		}
		aux += "</table>"+ this.delimiter;
		
		aux += "<h3>Inactivos</h3> <hr>" + this.delimiter;
		aux += "<table width=\"800\" height=\"100\" border=\"0\">" + this.delimiter;
		for (int x = 0; x < this.listaNoActivos.size(); x++) {
			Tratamiento t = lista.get(x);
			aux += "<tr>" + this.delimiter;
			aux += "<td><strong>Fecha de inicio:</strong></td>" + this.delimiter;
			aux += "<td>"+ManejoFechas.formatoEspanol.format(t.getFecha_inicio().getTime())+"</td>" + this.delimiter;
			aux += "<td><strong>Fecha de fin: </strong></td>" + this.delimiter;
			aux += "<td>"+ManejoFechas.formatoEspanol.format(t.getFecha_fin().getTime())+"</td>" + this.delimiter;
			aux += "<td><strong>Medicación</strong></td>" + this.delimiter;
			aux += "<td>"+t.getMedicacion().getNombre()+"</td>" + this.delimiter;
			aux += "<td><strong>Dosis</strong></td>" + this.delimiter;
			aux += "<td>"+t.getDosis()+"</td>" + this.delimiter;
			aux += "</tr>" + this.delimiter;
		}
		aux += "</table>"+ this.delimiter;
		
		
		return aux;
	}
}
