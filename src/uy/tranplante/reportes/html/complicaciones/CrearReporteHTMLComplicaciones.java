/**
 * 
 */
package uy.tranplante.reportes.html.complicaciones;

import java.util.ArrayList;

import auxiliares.ManejoFechas;
import logica.Fachada;
import dominio.EvolucionTrasplanteTotal;
import dominio.Trasplante;
import dominio.TrasplanteComplicacionesInf;
import dominio.TrasplanteComplicacionesNoInf;

/**
 * @author rodrigo
 *
 */
public class CrearReporteHTMLComplicaciones {

	private String delimiter = "\n";
	
	public String reporteComplicacionesEnTransplante(int idTransplante){
		String aux = "";
		Trasplante t = new Trasplante();
		t.setId(idTransplante);
		Fachada.getInstancia().cambie();
		t.leerDatosParaBusqueda();
		t.leerComplicaciones();
		
		aux += "<div class='div_box'>" +  this.delimiter ;
		aux +="<p class='titulo'>COMPLICACIONES NO INFECCIOSAS INTERNADO</p>" +  this.delimiter ;
		aux +="<ol>" +  this.delimiter ;
		for(int x =0;x< t.getListaComplicacionesNoInf().size();x++){
			aux += "<li>" +  this.delimiter ;
			aux += "<ul class='lista_complicaciones'>" +  this.delimiter ;
			TrasplanteComplicacionesNoInf tc = t.getListaComplicacionesNoInf().get(x);
			aux +="<li><label class='label_complicaciones'>Fecha de inicio: </label>" +ManejoFechas.formatoEspanol.format(tc.getFecha().getTime())+ "</li>" +  this.delimiter ;
			aux +="<li><label class='label_complicaciones'>Internado: </label> SI </li>" +  this.delimiter ;
			aux +="<li><label class='label_complicaciones'>Medicación: </label>" +tc.getMedicacion().getNombre() + "</li>" +  this.delimiter ;
			aux +="<li><label class='label_complicaciones'>Tipo: </label>" + tc.getComplicacion().getNombre() + "</li>" +  this.delimiter ;
			aux +="<li><label class='label_complicaciones'>Observaciones: </label>" + tc.getComentario() + "</li>" +  this.delimiter ;
			aux += "</ul>" +  this.delimiter ;
			aux += "</li>" +  this.delimiter ;
		}
		aux +="</ol>" +  this.delimiter ;
		aux +="</div>" +  this.delimiter ;
		
		aux +="<br />" + this.delimiter;
		
		aux += "<div class='div_box'>" +  this.delimiter ;
		aux +="<p class='titulo'>COMPLICACIONES INFECCIOSAS INTERNADO</p>" +  this.delimiter ;
		aux +="<ol>" +  this.delimiter ;
		for(int x =0;x< t.getListaComplicacionesInf().size();x++){
			aux += "<li>" +  this.delimiter ;
			aux += "<ul class='lista_complicaciones'>" +  this.delimiter ;
			TrasplanteComplicacionesInf tc = t.getListaComplicacionesInf().get(x);
			aux +="<li><label class='label_complicaciones'>Fecha de inicio: </label>" +ManejoFechas.formatoEspanol.format(tc.getFecha().getTime())+ "</li>" +  this.delimiter ;
			aux +="<li><label class='label_complicaciones'>Internado: </label> SI </li>" +  this.delimiter ;
			aux +="<li><label class='label_complicaciones'>Medicación: </label>" +tc.getMedicacion().getNombre() + "</li>" +  this.delimiter ;
			aux +="<li><label class='label_complicaciones'>Lugar de infeccion: </label>" + tc.getInfeccion().getNombre() + "</li>" +  this.delimiter ;
			aux +="<li><label class='label_complicaciones'>Germen: </label>" + tc.getGermen().getNombre() + "</li>" +  this.delimiter ;
			aux +="<li><label class='label_complicaciones'>Observaciones: </label>" + tc.getComentario() + "</li>" +  this.delimiter ;
			aux += "</ul>" +  this.delimiter ;
			aux += "</li>" +  this.delimiter ;
		}
		aux +="</ol>" +  this.delimiter ;
		aux +="</div>" +  this.delimiter ;
		
		return aux;
	}
	
	public String reporteComplicacionesEnEvolucion(int idTransplante){
		String aux = "";
		Trasplante t = new Trasplante();
		t.setId(idTransplante);
		Fachada.getInstancia().cambie();
		t.leerDatosMinimos();
		EvolucionTrasplanteTotal auxE = new EvolucionTrasplanteTotal();
		auxE.setIdPreTrasplante(t.getPreTrasplante());
		auxE.setIdTrasplante(t.getId());
		auxE.datosComplicacionesInf();
		
		ArrayList<TrasplanteComplicacionesNoInf> listaNoInfecciosa = auxE.getListaComplicacionesNoInf();
		
		
		aux += "<div class='div_box'>" +  this.delimiter ;
		aux +="<p class='titulo'>COMPLICACIONES NO INFECCIOSAS</p>" +  this.delimiter ;
		aux +="<ol>" +  this.delimiter ;
		for(int x =0;x< listaNoInfecciosa.size();x++){
			aux += "<li>" +  this.delimiter ;
			aux += "<ul class='lista_complicaciones'>" +  this.delimiter ;
			TrasplanteComplicacionesNoInf tc = listaNoInfecciosa.get(x);
			aux +="<li><label class='label_complicaciones'>Fecha de inicio: </label>" +ManejoFechas.formatoEspanol.format(tc.getFecha().getTime())+ "</li>" +  this.delimiter ;
			aux +="<li><label class='label_complicaciones'>Internado: </label>";
			if(tc.isInternado()){
				aux += "SI";
			}else{
				aux += "NO";
			}
			aux +=  "</li>" +  this.delimiter ;
			aux +="<li><label class='label_complicaciones'>Dias Internado: </label>" + String.valueOf(tc.getDiasInternado()) + "</li>" +  this.delimiter ;
			aux +="<li><label class='label_complicaciones'>Medicación: </label>" +tc.getMedicacion().getNombre() + "</li>" +  this.delimiter ;
			aux +="<li><label class='label_complicaciones'>Tipo: </label>" + tc.getComplicacion().getNombre() + "</li>" +  this.delimiter ;
			aux +="<li><label class='label_complicaciones'>Observaciones: </label>" + tc.getComentario() + "</li>" +  this.delimiter ;
			aux += "</ul>" +  this.delimiter ;
			aux += "</li>" +  this.delimiter ;
		}
		aux +="</ol>" +  this.delimiter ;
		aux +="</div>" +  this.delimiter ;
		
		aux +="<br />" + this.delimiter;
		
		
		ArrayList<TrasplanteComplicacionesInf> listaInfecciosa = auxE.getListaComplicacionesInf();
		
		
		
		
		aux += "<div class='div_box'>" +  this.delimiter ;
		aux +="<p class='titulo'>COMPLICACIONES INFECCIOSAS</p>" +  this.delimiter ;
		aux +="<ol>" +  this.delimiter ;
		for(int x =0;x< listaInfecciosa.size();x++){
			aux += "<li>" +  this.delimiter ;
			aux += "<ul class='lista_complicaciones'>" +  this.delimiter ;
			TrasplanteComplicacionesInf tc = listaInfecciosa.get(x);
			aux +="<li><label class='label_complicaciones'>Fecha de inicio: </label>" +ManejoFechas.formatoEspanol.format(tc.getFecha().getTime())+ "</li>" +  this.delimiter ;
			aux +="<li><label class='label_complicaciones'>Internado: </label>";
			if(tc.isInternado()){
				aux += "SI";
			}else{
				aux += "NO";
			}
			aux +=  "</li>" +  this.delimiter ;
			aux +="<li><label class='label_complicaciones'>Dias Internado: </label>" + String.valueOf(tc.getDiasInternado()) + "</li>" +  this.delimiter ;
			aux +="<li><label class='label_complicaciones'>Medicación: </label>" +tc.getMedicacion().getNombre() + "</li>" +  this.delimiter ;
			aux +="<li><label class='label_complicaciones'>Lugar de infeccion: </label>" + tc.getInfeccion().getNombre() + "</li>" +  this.delimiter ;
			aux +="<li><label class='label_complicaciones'>Germen: </label>" + tc.getGermen().getNombre() + "</li>" +  this.delimiter ;
			aux +="<li><label class='label_complicaciones'>Observaciones: </label>" + tc.getComentario() + "</li>" +  this.delimiter ;
			aux += "</ul>" +  this.delimiter ;
			aux += "</li>" +  this.delimiter ;
		}
		aux +="</ol>" +  this.delimiter ;
		aux +="</div>" +  this.delimiter ;
		
		return aux;
	}
}
