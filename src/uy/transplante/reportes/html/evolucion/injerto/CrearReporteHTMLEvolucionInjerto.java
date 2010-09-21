/**
 * 
 */
package uy.transplante.reportes.html.evolucion.injerto;

import java.util.ArrayList;

import auxiliares.ManejoFechas;
import logica.Fachada;
import dominio.EvolucionInjerto;
import dominio.Trasplante;

/**
 * @author rodrigo
 *
 */
public class CrearReporteHTMLEvolucionInjerto {

	private String delimiter = "\n";
	
	public String crearReportePrimerEvolucionInjerto(int idTransplante){
		Trasplante t = new Trasplante();
		t.setId(idTransplante);
		Fachada.getInstancia().cambie();
		t.leer();
		t.leerEvolucionInjerto();
		EvolucionInjerto ei = t.getEvolucion();
		String aux = "";
		aux += "<div class='div_box'>" +  this.delimiter ;
		aux +="<p class='titulo'>EVOLUCION DEL INJERTO EN EL PRIMER MES</p>" +  this.delimiter ;
		aux =  this.getReportOfEvolutionOfInjert(ei, aux);
		aux +="</div> " +  this.delimiter ;
		return aux;
	}
	
	public String crearReporteEvolucionInjerto(int idPreTrasplante){
		String aux = "";
		aux += "<div class='div_box'>" +  this.delimiter ;
		aux +="<p class='titulo'>EVOLUCION DEL INJERTO DESPUES DEL PRIMER MES</p>" +  this.delimiter ;
		ArrayList<EvolucionInjerto> lista = Fachada.getInstancia().obtenertodosEvolucionInjerto(idPreTrasplante);
		for(int x=0;x<lista.size();x++){
			aux =  this.getReportOfEvolutionOfInjert(lista.get(x), aux);
		}
		aux +="</div> " +  this.delimiter ;
		return aux;
	}
	
	private String getReportOfEvolutionOfInjert(EvolucionInjerto ei, String aux){
		if(ei != null){
			aux +="<ul class='lista_evolucion_injerto'>" +  this.delimiter ;
			aux +="<li><label class='label_evolucion_injerto'>FECHA: </label>" +ManejoFechas.FORMATOESPANOL.format(ei.getFecha().getTime()) + "</li>" +  this.delimiter ;
			aux +="<li><label class='label_evolucion_injerto'>Lista de pbr usados: </label><ol>"+  this.delimiter ;
			for (int x = 0; x < ei.getListaPBR().size(); x++) {
				aux += "<li>" + ei.getListaPBR().get(x).getPbr().toString() +"</li>";
			}
			aux +="</ol>";
			aux += "</li>" +  this.delimiter ;
			aux +="<li><label class='label_evolucion_injerto'>Tratamiento: </label>" +ei.getTratamiento().getNombre() + "</li>" +  this.delimiter ;
			aux +="<li><label class='label_evolucion_injerto'>Otros: </label>" + ei.getTmCual() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_evolucion_injerto'>Rechazo agudo: </label>";
			if (ei.isRa()) {
				aux += "SI";
			} else {
				aux += "NO";
			}
			aux += "</li>" +  this.delimiter ;
			aux +="<li><label class='label_evolucion_injerto'>Rechazo cronico: </label>";
			if (ei.isRc()) {
				aux += "SI";
			} else {
				aux += "NO";
			}
			aux += "</li>" +  this.delimiter ;
			aux +="<li><label class='label_evolucion_injerto'>Gp de novo: </label>";
			if (ei.isGpNovo()) {
				aux += "SI";
			} else {
				aux += "NO";
			}
			aux += "</li>" +  this.delimiter ;
			aux +="<li><label class='label_evolucion_injerto'>Reicidiva Gp: </label>";
			if (ei.isRecidivaGp()) {
				aux += "SI";
			} else {
				aux += "NO";
			}
			aux += "</li>" +  this.delimiter ;
			aux +="</ul>" +  this.delimiter ;
		}
		return aux;
	}
}
