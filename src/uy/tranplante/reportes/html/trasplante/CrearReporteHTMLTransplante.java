/**
 * 
 */
package uy.tranplante.reportes.html.trasplante;

import java.util.ArrayList;

import auxiliares.ManejoFechas;
import logica.Fachada;
import dominio.PacientePreTrasplante;
import dominio.Trasplante;
import dominio.TrasplanteReoperacion;

/**
 * @author rodrigo
 * 
 */
public class CrearReporteHTMLTransplante {

	private String delimiter = "\n";

	public String preTransplante(int idPreTransplante) {
		PacientePreTrasplante pt = new PacientePreTrasplante();
		pt.setId(idPreTransplante);
		Fachada.getInstancia().cambie();
		pt.leer();
		String aux = "";
		aux += "<hr>" +  this.delimiter ;
		
		aux += "<div class='div_box'>" +  this.delimiter ;
		aux +="<p class='titulo'>PRE TRANSPLANTE</p>" +  this.delimiter ;
		aux +="<ul class='lista_pre_transplante'>" +  this.delimiter ;
		aux +="<li><label class='label_pre_transplante'>Fecha de ingreso a la lista: </label>" +ManejoFechas.formatoEspanol.format(pt.getFecha_ingreso_lista().getTime()) + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_pre_transplante'>Fecha de egreso: </label>" + ManejoFechas.formatoEspanol.format(pt.getFecha_egreso().getTime()) + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_pre_transplante'>Modalidad d: </label>" +pt.getModalidad_d() + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_pre_transplante'>pbr: </label>"; 
		if (pt.isPbr()) {
			aux += "SI";
		} else {
			aux += "NO";
		}	
		aux += "</li>" +  this.delimiter ;
		aux +="<li><label class='label_pre_transplante'>Diabetes: </label>" + pt.getDiabetes() + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_pre_transplante'>hta: </label>";
		if (pt.isHta()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</li>" +  this.delimiter ;
		aux +="<li><label class='label_pre_transplante'>Obesidad: </label>";
		if (pt.isObesidad()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</li>" +  this.delimiter ;
		aux +="<li><label class='label_pre_transplante'>imc: </label>" + pt.getImc() + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_pre_transplante'>dislipemia: </label>";
		if (pt.isDislipemia()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux +="</li>" +  this.delimiter ;
		aux +="<li><label class='label_pre_transplante'>tabaquismo: </label>";
		if (pt.isTabaquismo()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</li>" +  this.delimiter ;
		aux +="<li><label class='label_pre_transplante'>iam: </label>";
		if (pt.isAve()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</li>" +  this.delimiter ;
		aux +="<li><label class='label_pre_transplante'>ave: </label>";
		if (pt.isAve()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux +="</li>" +  this.delimiter ;
		aux +="<li><label class='label_pre_transplante'>revascCardio: </label>";
		if (pt.isRevascCardio()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux +="</li>" +  this.delimiter ;
		aux +="<li><label class='label_pre_transplante'>origen: </label>"+pt.getOrigen()+"</li>" +  this.delimiter ;
		aux +="<li><label class='label_pre_transplante'>perdidaInjerto: </label> Ver perdida de injerto</li>" +  this.delimiter ;
		aux +="</ul>" +  this.delimiter ;
		aux +="</div> " +  this.delimiter ;
		return aux;
	}

	public String transplante(int idTransplante) {
		Trasplante t = new Trasplante();
		t.setId(idTransplante);
		Fachada.getInstancia().cambie();
		t.leer();
		String aux = "";
		
aux += "<hr>" +  this.delimiter ;
		
		aux += "<div class='div_box'>" +  this.delimiter ;
		aux +="<p class='titulo'>TRANSPLANTE</p>" +  this.delimiter ;
		aux +="<ul class='lista_transplante'>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>Fecha del transplante: </label>" +ManejoFechas.formatoEspanol.format(t.getFecha().getTime()) + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>Número de transplante: </label>" + String.valueOf(t.getNumTr()) + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>Número del donante: </label>" +t.getNumDonante() + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>Inestabilidad Hemod: </label>";
		if (t.isInstabHemod()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>Riñon: </label>" +t.getRinhon() + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>Anomalia Vascular: </label>";
		if (t.isAnomaliaVasc()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>Número de arterias: </label>" + String.valueOf(t.getNumArt()) + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>Número de venas: </label>" + String.valueOf(t.getNumVenas()) + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>Ureter: </label>"+ t.getUreter() + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>Número de comp A B: </label>" + String.valueOf(t.getNumCompAB()) +"</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>Número de incomp A B: </label>" + String.valueOf(t.getNumIncompAB()) + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>Número de compatibilidad DR: </label>"+String.valueOf(t.getNumCompDR())+"</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>Número de incomp DR: </label>"+String.valueOf(t.getNumIncompDR())+"</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>AUTOAC: </label>";
		if (t.isAutoac()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>Pra Max: </label>"+ String.valueOf(t.getPraMax()) +"</li>" +  this.delimiter ;
		
		aux +="<li><label class='label_transplante'>Pra tr: </label>" +String.valueOf(t.getPraTR()) + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>Tranfusiones previas: </label>";
		if (t.isTransPrevias()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>Número de Tranfusiones: </label>" +String.valueOf(t.getNumTransf()) + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>Embarazo: </label>" + t.getEmbarazo() +"</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>Número de embarazo: </label>" +String.valueOf(t.getNumEmbarazo()) + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>Liq Perfusion: </label>" +t.getLiqPerfusion() +"</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>TQ de banco: </label>";
		if (t.isTqDeBanco()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>Lado del implante: </label>" + t.getLadoImplante() + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>Anast Venosa: </label>" + t.getAnastVenosa() + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>Anast Arterial: </label>" + t.getAnastArterial() +"</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>Anast Ureteral: </label>" + t.getAnastUterial() + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>T_ISQ_CAL_MIN: </label>"+ String.valueOf(t.getTIsqCalMin()) + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>T_ISQ_FRIA_HS: </label>"+ String.valueOf(t.getTIsqFriqHs()) + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>T_ISQ_FRIA_MIN: </label>"+ String.valueOf(t.getTIsqFriaMin()) + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>T_ISQ_TIBIA_HS: </label>"+ String.valueOf(t.getTIsqTibiaHs()) +"</li>" +  this.delimiter ;
		
		aux +="<li><label class='label_transplante'>Reperfusion: </label>" +t.getRepercusion() + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>SANGRADO_I_OP: </label>";
		if (t.isSangradoIOp()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>LESION_ARTERIAL: </label>";
		if (t.isLesionArterial()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>LESION_VENOSA: </label>";
		if (t.isLesionVenosa()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>NECESIDAD_REPEFUNDIR: </label>";		
		if (t.isNecesidadRepefundir()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>OTRAS_COMPL_QUIRUR: </label>" + t.getOtrasComplicacionesQuirurgicas() +"</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>DIURESIS_I_OP: </label>";
		if (t.isDiuresisIOp()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux +="</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>CR_INICIAL: </label>" + String.valueOf(t.getCrInicial()) + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>DIA_REC_DIURESIS: </label>"+ String.valueOf(t.getDiaRecFuncional()) + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>DIA_REC_FUNCIONAL: </label>" + String.valueOf(t.getDiaRecFuncional()) +"</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>DIALISIS: </label>";
		if (t.isDialisis()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux +="</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>NUM_DE_HD: </label>"+ String.valueOf(t.getNumDeHd()) +"</li>" +  this.delimiter ;
		aux +="<li><label class='label_transplante'>Fecha de alta: </label>"+ ManejoFechas.formatoEspanol.format(t.getFechaAlta().getTime()) + "</li>" +  this.delimiter ;
		
		aux +="</ul>" +  this.delimiter ;
		aux +="</div> " +  this.delimiter ;
		
		
//		aux += "<table width=\"200\" border=\"2\">" + this.delimiter;
//		aux += "<tr>" + this.delimiter;
//		aux += "<td>" + this.delimiter;
//		aux += "<div align=\"center\">" + this.delimiter;
//		aux += "<p class=\"Estilo1\">Transplante</p>" + this.delimiter;
//		aux += "<hr>" + this.delimiter;
//		aux += "<table width=\"600\" height=\"383\" border=\"0\">" + this.delimiter;
//		aux += "<tr>" + this.delimiter;
//		aux += "<td><strong>Fecha del transplante:</strong></td>" + this.delimiter;
//		aux += "<td>"+ManejoFechas.formatoEspanol.format(t.getFecha().getTime())+"</td>" + this.delimiter;
//		aux += "<td><strong>Número de transplante: </strong></td>" + this.delimiter;
//		aux += "<td>"+String.valueOf(t.getNumTr())+"</td>" + this.delimiter;
//		aux += "<td><strong>Número del donante</strong></td>" + this.delimiter;
//		aux += "<td>"+t.getNumDonante()+"</td>" + this.delimiter;
//		aux += "</tr>" + this.delimiter;
//		aux += "<tr>" + this.delimiter;
//		aux += "<td><strong>Inestabilidad Hemod</strong></td>" + this.delimiter;
//		aux += "<td>";
//		if (t.isInstabHemod()) {
//			aux += "SI";
//		} else {
//			aux += "NO";
//		}
//		aux += "</td>" + this.delimiter;
//		aux += "<td><strong>Riñon: </strong></td>" + this.delimiter;
//		aux += "<td>"+t.getRinhon()+"</td>" + this.delimiter;
//		aux += "<td><strong>Anomalia Vascular</strong></td>" + this.delimiter;
//		aux += "<td>";
//		if (t.isAnomaliaVasc()) {
//			aux += "SI";
//		} else {
//			aux += "NO";
//		}
//		aux += "</td>" + this.delimiter;
//		aux += "</tr>" + this.delimiter;
//		aux += "<tr>" + this.delimiter;
//		aux += "<td><strong>Número de arterias:</strong></td>" + this.delimiter;
//		aux += "<td>"+String.valueOf(t.getNumArt())+"</td>" + this.delimiter;
//		aux += "<td><strong>Número de venas:</strong></td>" + this.delimiter;
//		aux += "<td>"+String.valueOf(t.getNumVenas())+"</td>" + this.delimiter;
//		aux += "<td><strong>Ureter:</strong></td>" + this.delimiter;
//		aux += "<td>"+t.getUreter()+"</td>" + this.delimiter;
//		aux += "</tr>" + this.delimiter;
//		aux += "<tr>" + this.delimiter;
		
//		aux += "<td><strong>Número de comp A B:</strong></td>" + this.delimiter;
//		aux += "<td>"+String.valueOf(t.getNumCompAB())+"</td>" + this.delimiter;
//		aux += "<td><strong>Número de incomp A B:</strong></td>" + this.delimiter;
//		aux += "<td>"+String.valueOf(t.getNumIncompAB())+"</td>" + this.delimiter;
//		aux += "<td><strong>Número de compatibilidad DR</strong></td>"	+ this.delimiter;
//		aux += "<td>"+String.valueOf(t.getNumCompDR())+"</td>" + this.delimiter;
		
//		aux += "</tr>" + this.delimiter;
//		aux += "<tr>" + this.delimiter;

//		aux += "<td><strong>Número de incomp DR:</strong></td>"	+ this.delimiter;
//		aux += "<td>"+String.valueOf(t.getNumIncompDR())+"</td>" + this.delimiter;
//		aux += "<td><strong>AUTOAC:</strong></td>" + this.delimiter;
//		aux += "<td>";
//		if (t.isAutoac()) {
//			aux += "SI";
//		} else {
//			aux += "NO";
//		}
//		aux += "</td>" + this.delimiter;
//		aux += "<td><strong>Pra Max:</strong></td>" + this.delimiter;
//		aux += "<td>"+String.valueOf(t.getPraMax())+"</td>" + this.delimiter;
//		
//		aux += "</tr>" + this.delimiter;
//		aux += "<tr>" + this.delimiter;
		
//		aux += "<td><strong>Pra tr:</strong></td>" + this.delimiter;
//		aux += "<td>"+String.valueOf(t.getPraTR())+"</td>" + this.delimiter;
//		aux += "<td><strong>Tranfusiones previas:</strong></td>" + this.delimiter;
//		aux += "<td>";
//		if (t.isTransPrevias()) {
//			aux += "SI";
//		} else {
//			aux += "NO";
//		}
//		aux += "</td>" + this.delimiter;
//		aux += "<td><strong>Número de Tranfusiones:</strong></td>"+ this.delimiter;
//		aux += "<td>"+String.valueOf(t.getNumTransf())+"</td>" + this.delimiter;
//		aux += "</tr>" + this.delimiter;
//		aux += "<tr>" + this.delimiter;
		
//		aux += "<td><strong>Embarazo:</strong></td>" + this.delimiter;
//		aux += "<td>"+t.getEmbarazo()+"</td>" + this.delimiter;
//		aux += "<td><strong>Número de embarazo:</strong></td>" + this.delimiter;
//		aux += "<td>"+String.valueOf(t.getNumEmbarazo())+"</td>" + this.delimiter;
//		aux += "<td><strong>Liq Perfusion:</strong></td>" + this.delimiter;
//		aux += "<td>"+t.getLiqPerfusion()+"</td>" + this.delimiter;
//		aux += "</tr>" + this.delimiter;
//		aux += "<tr>" + this.delimiter;
		
//		aux += "<td><strong>TQ de banco:</strong></td>" + this.delimiter;
//		aux += "<td>";
//		if (t.isTqDeBanco()) {
//			aux += "SI";
//		} else {
//			aux += "NO";
//		}
//		aux += "</td>" + this.delimiter;
//		aux += "<td><strong>Lado del implante:</strong></td>" + this.delimiter;
//		aux += "<td>"+t.getLadoImplante()+"</td>" + this.delimiter;
//		aux += "<td><strong>Anast Venosa:</strong></td>" + this.delimiter;
//		aux += "<td>"+t.getAnastVenosa()+"</td>" + this.delimiter;
//		aux += "</tr>" + this.delimiter;
//		aux += "<tr>" + this.delimiter;
		
//		aux += "<td><strong>Anast Arterial:</strong></td>" + this.delimiter;
//		aux += "<td>"+t.getAnastArterial()+"</td>" + this.delimiter;
//		aux += "<td><strong>Anast Ureteral:</strong></td>" + this.delimiter;
//		aux += "<td>"+t.getAnastUterial()+"</td>" + this.delimiter;
//		aux += "<td><strong>T_ISQ_CAL_MIN:</strong></td>" + this.delimiter;
//		aux += "<td>"+String.valueOf(t.getTIsqCalMin())+"</td>" + this.delimiter;
//		aux += "</tr>" + this.delimiter;
//		aux += "<tr>" + this.delimiter;
		
//		aux += "<td><strong>T_ISQ_FRIA_HS:</strong></td>" + this.delimiter;
//		aux += "<td>"+String.valueOf(t.getTIsqFriqHs())+"</td>" + this.delimiter;
//		aux += "<td><strong>T_ISQ_FRIA_MIN:</strong></td>" + this.delimiter;
//		aux += "<td>"+String.valueOf(t.getTIsqFriaMin())+"</td>" + this.delimiter;
//		aux += "<td><strong>T_ISQ_TIBIA_HS:</strong></td>" + this.delimiter;
//		aux += "<td>"+String.valueOf(t.getTIsqTibiaHs())+"</td>" + this.delimiter;
//		aux += "</tr>" + this.delimiter;
//		aux += "<tr>" + this.delimiter;
		
//		aux += "<td><strong>Reperfusion:</strong></td>" + this.delimiter;
//		aux += "<td>"+t.getRepercusion()+"</td>" + this.delimiter;
//		aux += "<td><strong>SANGRADO_I_OP:</strong></td>" + this.delimiter;
//		aux += "<td>";
//		if (t.isSangradoIOp()) {
//			aux += "SI";
//		} else {
//			aux += "NO";
//		}
//		aux += "</td>" + this.delimiter;
//		aux += "<td><strong>LESION_ARTERIAL:</strong></td>" + this.delimiter;
//		aux += "<td>";
//		if (t.isLesionArterial()) {
//			aux += "SI";
//		} else {
//			aux += "NO";
//		}
//		aux += "</td>" + this.delimiter;
//		aux += "</tr>" + this.delimiter;
//		aux += "<tr>" + this.delimiter;
		
//		aux += "<td><strong>LESION_VENOSA:</strong></td>" + this.delimiter;
//		aux += "<td>";
//		if (t.isLesionVenosa()) {
//			aux += "SI";
//		} else {
//			aux += "NO";
//		}
//		aux += "</td>" + this.delimiter;
//		aux += "<td><strong>NECESIDAD_REPEFUNDIR:</strong></td>" + this.delimiter;
//		aux += "<td>";
//		if (t.isNecesidadRepefundir()) {
//			aux += "SI";
//		} else {
//			aux += "NO";
//		}
//		aux += "</td>" + this.delimiter;
//		aux += "<td><strong>OTRAS_COMPL_QUIRUR:</strong></td>" + this.delimiter;
//		aux += "<td>"+t.getOtrasComplicacionesQuirurgicas()+"</td>" + this.delimiter;
//		aux += "</tr>" + this.delimiter;
//		aux += "<tr>" + this.delimiter;
		
//		aux += "<td><strong>DIURESIS_I_OP:</strong></td>" + this.delimiter;
//		aux += "<td>";
//		if (t.isDiuresisIOp()) {
//			aux += "SI";
//		} else {
//			aux += "NO";
//		}
//		aux += "</td>" + this.delimiter;
//		aux += "<td><strong>CR_INICIAL:</strong></td>" + this.delimiter;
//		aux += "<td>"+String.valueOf(t.getCrInicial())+"</td>" + this.delimiter;
//		aux += "<td><strong>DIA_REC_DIURESIS:</strong></td>" + this.delimiter;
//		aux += "<td>"+String.valueOf(t.getDiaRecDiuresis())+"</td>" + this.delimiter;
//		aux += "</tr>" + this.delimiter;
//		aux += "<tr>" + this.delimiter;
		
//		aux += "<td><strong>DIA_REC_FUNCIONAL:</strong></td>" + this.delimiter;
//		aux += "<td>"+String.valueOf(t.getDiaRecFuncional())+"</td>" + this.delimiter;
//		aux += "<td><strong>DIALISIS:</strong></td>" + this.delimiter;
//		aux += "<td>";
//		if (t.isDialisis()) {
//			aux += "SI";
//		} else {
//			aux += "NO";
//		}
//		aux += "</td>" + this.delimiter;
//		aux += "<td><strong>NUM_DE_HD:</strong></td>" + this.delimiter;
//		aux += "<td>"+String.valueOf(t.getNumDeHd())+"</td>" + this.delimiter;
//		aux += "</tr>" + this.delimiter;
		
//		aux += "<tr>" + this.delimiter;
/*		aux += "<td><strong>Fecha de alta:</strong></td>" + this.delimiter;
		aux += "<td>"+ManejoFechas.formatoEspanol.format(t.getFechaAlta().getTime())+"</td>" + this.delimiter;
		aux += "<td></td>" + this.delimiter;
		aux += "<td></td>" + this.delimiter;
		aux += "<td></td>" + this.delimiter;
		aux += "<td></td>" + this.delimiter;
		aux += "</tr>" + this.delimiter;
		

		
		aux += "</table>" + this.delimiter;
		aux += "<table width=\"600\" height=\"100\" border=\"0\">" + this.delimiter;
		aux += "<tr>" + this.delimiter;
		aux += "<td><strong>Comentario:</strong></td>" + this.delimiter;
		aux += "<td>"+t.getComentario()+"</td>" + this.delimiter;
		aux += "</tr>" + this.delimiter;		
		aux += "</table>" + this.delimiter;
		aux += "</div>" + this.delimiter;
		aux += "</td>" + this.delimiter;
		aux += "</tr>" + this.delimiter;
		aux += "</table>" + this.delimiter;*/
		return aux;
	}
	
	public String reoperaciones(int idTransplante){
		TrasplanteReoperacion treo = new TrasplanteReoperacion();
		treo.setIdTrasplante(idTransplante);
		Fachada.getInstancia().cambie();
		String aux = "";
		
		
		aux += "<div class='div_box'>" +  this.delimiter ;
		aux +="<p class='titulo'>RE OPERACIONES</p>" +  this.delimiter ;
		aux +="<ol>" +  this.delimiter ;
		ArrayList<TrasplanteReoperacion> lista = treo.obtenerTodos();
		for(int x =0;x< lista.size();x++){
			aux += "<li>" +  this.delimiter ;
			aux += "<ul class='lista_re_operacion'>" +  this.delimiter ;
			TrasplanteReoperacion tr = (TrasplanteReoperacion) lista.get(x);
			aux +="<li><label class='label_re_operacion'>Fecha: </label>" +ManejoFechas.formatoEspanol.format(tr.getFecha().getTime()) + "</li>" +  this.delimiter ;
			aux +="<li><label class='label_re_operacion'>Descripción: </label>" + tr.getComentario() + "</li>" +  this.delimiter ;
			aux +="<li><label class='label_re_operacion'>Complicacación: </label>" +tr.getComplicacion().getComentario() + "</li>" +  this.delimiter ;
			aux += "</ul>" +  this.delimiter ;
			aux += "</li>" +  this.delimiter ;
		}
		aux +="</ol>" +  this.delimiter ;
		aux +="</div>" +  this.delimiter ;
		return aux;
	}
	
}
