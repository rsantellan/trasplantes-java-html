/**
 * 
 */
package uy.tranplante.reportes.html.trasplante;

import auxiliares.ManejoFechas;
import logica.Fachada;
import dominio.PacientePreTrasplante;
import dominio.Trasplante;

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
		aux += "<hr>" + this.delimiter;
		aux += "<table width=\"200\" border=\"2\">" + this.delimiter;
		aux += "<tr>" + this.delimiter;
		aux += "<td>" + this.delimiter;
		aux += "<div align=\"center\">" + this.delimiter;
		aux += "<p class=\"Estilo1\">Pre Transplante</p>" + this.delimiter;
		aux += "<hr>" + this.delimiter;
		aux += "<table width=\"600\" height=\"383\" border=\"0\">"
				+ this.delimiter;
		aux += "<tr>" + this.delimiter;
		aux += "<td><strong>Fecha de ingreso a la lista:</strong></td>"
				+ this.delimiter;
		aux += "<td>"
				+ ManejoFechas.formatoEspanol.format(pt
						.getFecha_ingreso_lista().getTime()) + "</td>"
				+ this.delimiter;
		aux += "<td><strong>Fecha de egreso: </strong></td>" + this.delimiter;
		aux += "<td>"
				+ ManejoFechas.formatoEspanol.format(pt.getFecha_egreso()
						.getTime()) + "</td>" + this.delimiter;
		aux += "</tr>" + this.delimiter;
		aux += "<tr>" + this.delimiter;
		aux += "<td><strong>Modalidad d:</strong></td>" + this.delimiter;
		aux += "<td>" + pt.getModalidad_d() + "</td>" + this.delimiter;
		aux += "<td><strong>pbr:</strong></td>" + this.delimiter;
		aux += "<td>";
		if (pt.isPbr()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</td>" + this.delimiter;
		aux += "</tr>" + this.delimiter;
		aux += "<tr>" + this.delimiter;
		aux += "<td><strong>Diabetes: </strong></td>" + this.delimiter;
		aux += "<td>" + pt.getDiabetes() + "</td>" + this.delimiter;
		aux += "<td><strong>hta:</strong></td>" + this.delimiter;
		aux += "<td>";
		if (pt.isHta()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</td>" + this.delimiter;
		aux += "</tr>" + this.delimiter;
		aux += "<tr>" + this.delimiter;
		aux += "<td><strong>Obesidad:</strong></td>" + this.delimiter;
		aux += "<td>";
		if (pt.isObesidad()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</td>" + this.delimiter;
		aux += "<td><strong>imc:</strong></td>" + this.delimiter;
		aux += "<td>" + pt.getImc() + "</td>" + this.delimiter;
		aux += "</tr>" + this.delimiter;
		aux += "<tr>" + this.delimiter;
		aux += "<td><strong>dislipemia:</strong></td>" + this.delimiter;
		aux += "<td>";
		if (pt.isDislipemia()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</td>" + this.delimiter;
		aux += "<td><strong>tabaquismo:</strong></td>" + this.delimiter;
		aux += "<td>";
		if (pt.isTabaquismo()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</td>" + this.delimiter;
		aux += "</tr>" + this.delimiter;
		aux += "<tr>" + this.delimiter;
		aux += "<td><strong>iam</strong></td>" + this.delimiter;
		aux += "<td>";
		if (pt.isIam()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</td>" + this.delimiter;
		aux += "<td><strong>ave</strong></td>" + this.delimiter;
		aux += "<td>";
		if (pt.isAve()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</td>" + this.delimiter;
		aux += "</tr>" + this.delimiter;
		aux += "<tr>" + this.delimiter;
		aux += "<td><strong>revascCardio</strong></td>" + this.delimiter;
		aux += "<td>";
		if (pt.isRevascCardio()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</td>" + this.delimiter;
		aux += "<td><strong>origen</strong></td>" + this.delimiter;
		aux += "<td>" + pt.getOrigen() + "</td>" + this.delimiter;
		aux += "</tr>" + this.delimiter;
		aux += "<tr>" + this.delimiter;
		aux += "<td><strong>perdidaInjerto</strong></td>" + this.delimiter;
		aux += "<td> - </td>" + this.delimiter;
		aux += "<td></td>" + this.delimiter;
		aux += "<td></td>" + this.delimiter;
		aux += "</tr>" + this.delimiter;
		aux += "</table>" + this.delimiter;
		aux += "</div>" + this.delimiter;
		aux += "</td>" + this.delimiter;
		aux += "</tr>" + this.delimiter;
		aux += "</table>" + this.delimiter;
		return aux;
	}

	public String transplante(int idTransplante) {
		Trasplante t = new Trasplante();
		t.setId(idTransplante);
		Fachada.getInstancia().cambie();
		t.leer();
		String aux = "";
		aux += "<table width=\"200\" border=\"2\">" + this.delimiter;
		aux += "<tr>" + this.delimiter;
		aux += "<td>" + this.delimiter;
		aux += "<div align=\"center\">" + this.delimiter;
		aux += "<p class=\"Estilo1\">Transplante</p>" + this.delimiter;
		aux += "<hr>" + this.delimiter;
		aux += "<table width=\"600\" height=\"383\" border=\"0\">" + this.delimiter;
		aux += "<tr>" + this.delimiter;
		aux += "<td><strong>Fecha del transplante:</strong></td>" + this.delimiter;
		aux += "<td>"+ManejoFechas.formatoEspanol.format(t.getFecha().getTime())+"</td>" + this.delimiter;
		aux += "<td><strong>Número de transplante: </strong></td>" + this.delimiter;
		aux += "<td>"+String.valueOf(t.getNumTr())+"</td>" + this.delimiter;
		aux += "<td><strong>Número del donante</strong></td>" + this.delimiter;
		aux += "<td>"+t.getNumDonante()+"</td>" + this.delimiter;
		aux += "</tr>" + this.delimiter;
		aux += "<tr>" + this.delimiter;
		aux += "<td><strong>Inestabilidad Hemod</strong></td>" + this.delimiter;
		aux += "<td>";
		if (t.isInstabHemod()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</td>" + this.delimiter;
		aux += "<td><strong>Riñon: </strong></td>" + this.delimiter;
		aux += "<td>"+t.getRinhon()+"</td>" + this.delimiter;
		aux += "<td><strong>Anomalia Vascular</strong></td>" + this.delimiter;
		aux += "<td>";
		if (t.isAnomaliaVasc()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</td>" + this.delimiter;
		aux += "</tr>" + this.delimiter;
		aux += "<tr>" + this.delimiter;
		aux += "<td><strong>Número de arterias:</strong></td>" + this.delimiter;
		aux += "<td>"+String.valueOf(t.getNumArt())+"</td>" + this.delimiter;
		aux += "<td><strong>Número de venas:</strong></td>" + this.delimiter;
		aux += "<td>"+String.valueOf(t.getNumVenas())+"</td>" + this.delimiter;
		aux += "<td><strong>Ureter:</strong></td>" + this.delimiter;
		aux += "<td>"+t.getUreter()+"</td>" + this.delimiter;
		aux += "</tr>" + this.delimiter;
		aux += "<tr>" + this.delimiter;
		
		aux += "<td><strong>Número de comp A B:</strong></td>" + this.delimiter;
		aux += "<td>"+String.valueOf(t.getNumCompAB())+"</td>" + this.delimiter;
		aux += "<td><strong>Número de incomp A B:</strong></td>" + this.delimiter;
		aux += "<td>"+String.valueOf(t.getNumIncompAB())+"</td>" + this.delimiter;
		aux += "<td><strong>Número de compatibilidad DR</strong></td>"	+ this.delimiter;
		aux += "<td>"+String.valueOf(t.getNumCompDR())+"</td>" + this.delimiter;
		
		aux += "</tr>" + this.delimiter;
		aux += "<tr>" + this.delimiter;

		aux += "<td><strong>Número de incomp DR:</strong></td>"	+ this.delimiter;
		aux += "<td>"+String.valueOf(t.getNumIncompDR())+"</td>" + this.delimiter;
		aux += "<td><strong>AUTOAC:</strong></td>" + this.delimiter;
		aux += "<td>";
		if (t.isAutoac()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</td>" + this.delimiter;
		aux += "<td><strong>Pra Max:</strong></td>" + this.delimiter;
		aux += "<td>"+String.valueOf(t.getPraMax())+"</td>" + this.delimiter;
		
		aux += "</tr>" + this.delimiter;
		aux += "<tr>" + this.delimiter;
		
		aux += "<td><strong>Pra tr:</strong></td>" + this.delimiter;
		aux += "<td>"+String.valueOf(t.getPraTR())+"</td>" + this.delimiter;
		aux += "<td><strong>Tranfusiones previas:</strong></td>" + this.delimiter;
		aux += "<td>";
		if (t.isTransPrevias()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</td>" + this.delimiter;
		aux += "<td><strong>Número de Tranfusiones:</strong></td>"+ this.delimiter;
		aux += "<td>"+String.valueOf(t.getNumTransf())+"</td>" + this.delimiter;
		aux += "</tr>" + this.delimiter;
		aux += "<tr>" + this.delimiter;
		
		aux += "<td><strong>Embarazo:</strong></td>" + this.delimiter;
		aux += "<td>"+t.getEmbarazo()+"</td>" + this.delimiter;
		aux += "<td><strong>Número de embarazo:</strong></td>" + this.delimiter;
		aux += "<td>"+String.valueOf(t.getNumEmbarazo())+"</td>" + this.delimiter;
		aux += "<td><strong>Liq Perfusion:</strong></td>" + this.delimiter;
		aux += "<td>"+t.getLiqPerfusion()+"</td>" + this.delimiter;
		aux += "</tr>" + this.delimiter;
		aux += "<tr>" + this.delimiter;
		
		aux += "<td><strong>TQ de banco:</strong></td>" + this.delimiter;
		aux += "<td>";
		if (t.isTqDeBanco()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</td>" + this.delimiter;
		aux += "<td><strong>Lado del implante:</strong></td>" + this.delimiter;
		aux += "<td>"+t.getLadoImplante()+"</td>" + this.delimiter;
		aux += "<td><strong>Anast Venosa:</strong></td>" + this.delimiter;
		aux += "<td>"+t.getAnastVenosa()+"</td>" + this.delimiter;
		aux += "</tr>" + this.delimiter;
		aux += "<tr>" + this.delimiter;
		
		aux += "<td><strong>Anast Arterial:</strong></td>" + this.delimiter;
		aux += "<td>"+t.getAnastArterial()+"</td>" + this.delimiter;
		aux += "<td><strong>Anast Ureteral:</strong></td>" + this.delimiter;
		aux += "<td>"+t.getAnastUterial()+"</td>" + this.delimiter;
		aux += "<td><strong>T_ISQ_CAL_MIN:</strong></td>" + this.delimiter;
		aux += "<td>"+String.valueOf(t.getTIsqCalMin())+"</td>" + this.delimiter;
		aux += "</tr>" + this.delimiter;
		aux += "<tr>" + this.delimiter;
		
		aux += "<td><strong>T_ISQ_FRIA_HS:</strong></td>" + this.delimiter;
		aux += "<td>"+String.valueOf(t.getTIsqFriqHs())+"</td>" + this.delimiter;
		aux += "<td><strong>T_ISQ_FRIA_MIN:</strong></td>" + this.delimiter;
		aux += "<td>"+String.valueOf(t.getTIsqFriaMin())+"</td>" + this.delimiter;
		aux += "<td><strong>T_ISQ_TIBIA_HS:</strong></td>" + this.delimiter;
		aux += "<td>"+String.valueOf(t.getTIsqTibiaHs())+"</td>" + this.delimiter;
		aux += "</tr>" + this.delimiter;
		aux += "<tr>" + this.delimiter;
		
		aux += "<td><strong>Reperfusion:</strong></td>" + this.delimiter;
		aux += "<td>"+t.getRepercusion()+"</td>" + this.delimiter;
		aux += "<td><strong>SANGRADO_I_OP:</strong></td>" + this.delimiter;
		aux += "<td>";
		if (t.isSangradoIOp()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</td>" + this.delimiter;
		aux += "<td><strong>LESION_ARTERIAL:</strong></td>" + this.delimiter;
		aux += "<td>";
		if (t.isLesionArterial()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</td>" + this.delimiter;
		aux += "</tr>" + this.delimiter;
		aux += "<tr>" + this.delimiter;
		
		aux += "<td><strong>LESION_VENOSA:</strong></td>" + this.delimiter;
		aux += "<td>";
		if (t.isLesionVenosa()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</td>" + this.delimiter;
		aux += "<td><strong>NECESIDAD_REPEFUNDIR:</strong></td>" + this.delimiter;
		aux += "<td>";
		if (t.isNecesidadRepefundir()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</td>" + this.delimiter;
		aux += "<td><strong>OTRAS_COMPL_QUIRUR:</strong></td>" + this.delimiter;
		aux += "<td>"+t.getOtrasComplicacionesQuirurgicas()+"</td>" + this.delimiter;
		aux += "</tr>" + this.delimiter;
		aux += "<tr>" + this.delimiter;
		
		aux += "<td><strong>DIURESIS_I_OP:</strong></td>" + this.delimiter;
		aux += "<td>";
		if (t.isDiuresisIOp()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</td>" + this.delimiter;
		aux += "<td><strong>CR_INICIAL:</strong></td>" + this.delimiter;
		aux += "<td>"+String.valueOf(t.getCrInicial())+"</td>" + this.delimiter;
		aux += "<td><strong>DIA_REC_DIURESIS:</strong></td>" + this.delimiter;
		aux += "<td>"+String.valueOf(t.getDiaRecDiuresis())+"</td>" + this.delimiter;
		aux += "</tr>" + this.delimiter;
		aux += "<tr>" + this.delimiter;
		
		aux += "<td><strong>DIA_REC_FUNCIONAL:</strong></td>" + this.delimiter;
		aux += "<td>"+String.valueOf(t.getDiaRecFuncional())+"</td>" + this.delimiter;
		aux += "<td><strong>DIALISIS:</strong></td>" + this.delimiter;
		aux += "<td>";
		if (t.isDialisis()) {
			aux += "SI";
		} else {
			aux += "NO";
		}
		aux += "</td>" + this.delimiter;
		aux += "<td><strong>NUM_DE_HD:</strong></td>" + this.delimiter;
		aux += "<td>"+String.valueOf(t.getNumDeHd())+"</td>" + this.delimiter;
		aux += "</tr>" + this.delimiter;
		
		aux += "<tr>" + this.delimiter;
		aux += "<td><strong>Fecha de alta:</strong></td>" + this.delimiter;
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
		aux += "</table>" + this.delimiter;
		return aux;
	}
}
