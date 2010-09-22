/**
 * 
 */
package uy.transplante.reportes.html.cmv;

import java.util.ArrayList;

import uy.transplante.auxiliares.fechas.ManejoFechas;
import logica.Fachada;
import dominio.CMV;
import dominio.CMVusoEnfermedades;

/**
 * @author rodrigo
 *
 */
public class CrearReporteHTMLCmv {

	private String delimiter = "\n";
	
	public String crearReporteCmv(int idTransplante){
		ArrayList<CMV> lista = Fachada.getInstancia().obtenerTodosCMV(idTransplante);
		System.out.println(lista.size());
		String aux = "";
		aux += "<div class='div_box'>" +  this.delimiter ;
		aux +="<p class='titulo'>Lista de CMV</p>" +  this.delimiter ;
		aux +="<ol>" + this.delimiter;
		for(int x=0;x<lista.size();x++){
			aux +="<li>" + this.delimiter;
			aux =  this.reporteCmv(lista.get(x), aux);
			aux +="</li>" + this.delimiter;
		}
		aux +="</ol>" + this.delimiter;
		aux +="</div> " +  this.delimiter ;
		return aux;
		
		
	}
	
	
	
	private String reporteCmv(CMV cmv, String aux){
		if(cmv != null){
			aux +="<ul class='lista_cmv'>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Fecha: </label>" +ManejoFechas.FORMATOESPANOL.format(cmv.getFecha().getTime()) + "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Diagnosito: </label>" +cmv.getDiagnostico().getNombre() + "</li>" +  this.delimiter ;
			Boolean activado = false;
			if(cmv.isTmAnti()){
				aux +="<li><label class='label_cmv'>Tratamiento Anti: </label> SI </li>" +  this.delimiter ;
				activado = true;
			}
			if(cmv.isSindromeViral()){
				aux +="<li><label class='label_cmv'>Sindrome Viral: </label> SI </li>" +  this.delimiter ;
				activado = true;
			}
			if(cmv.isProfilaxis()){
				aux +="<li><label class='label_cmv'>Profilaxis: </label> SI </li>" +  this.delimiter ;
				activado = true;
			}
			if(!activado){
				aux +="<li><label class='label_cmv'>Emfermedad: </label>" + this.delimiter;
				aux +="<ol>";
				for (int x = 0; x < cmv.getEnfermedades().size(); x++) {
					CMVusoEnfermedades enfermedad = cmv.getEnfermedades().get(x);
					aux += "<li>" + enfermedad.getEnfermedad().getNombre() + "</li>" + this.delimiter;
				}
				aux +="</ol>";
				aux += "</li>" +  this.delimiter ;
			}
			aux +="<li><label class='label_cmv'>Droga usada:</label>"+ cmv.getDroga().getNombre() + "</li>"+  this.delimiter ;
			
			aux +="<li><label class='label_cmv'>Dias de tratamiento:</label>"+ String.valueOf(cmv.getDiasTm()) +"</li>"+  this.delimiter ;
			
			aux +="<li><label class='label_cmv'>Efecto secundario:</label>"+ cmv.getEfectoSecundario() + "</li>"+  this.delimiter ;
			
			aux +="</ul>" +  this.delimiter ;
		}
		return aux;
	}
	
}
