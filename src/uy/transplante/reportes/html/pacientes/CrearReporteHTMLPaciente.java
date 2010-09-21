/**
 * 
 */
package uy.tranplante.reportes.html.pacientes;

import logica.Fachada;
import dominio.Paciente;
import dominio.PacientePerdidaInjerto;
import auxiliares.ManejoFechas;

/**
 * @author rodrigo
 *
 */
public class CrearReporteHTMLPaciente {

	private Paciente paciente = null;
	private String delimiter = "\n";
	
	private Paciente getPaciente(int idPaciente){
		if(this.paciente == null){
			Paciente p = new Paciente();
			p.setThe(idPaciente);
			Fachada.getInstancia().cambie();
			p.leer();
			p.leerDatos();
			this.paciente = p;
		}
		return this.paciente;
	}
	
	public String reportePaciente(int idPaciente){
	
		Paciente p = this.getPaciente(idPaciente);
		String salida = "";
		salida += "<div class='div_box'>" + this.delimiter +
		  "<p class='titulo'>PACIENTE</p>" + this.delimiter +
		  "<ul class='lista_paciente'>" + this.delimiter +
		    "<li><label class='label_paciente'>THE: </label>" +p.getThe() + "</li>" + this.delimiter +
		    "<li><label class='label_paciente'>CEDULA IDENTIDAD: </label>" +p.getCi() + "</li>" + this.delimiter +
		    "<li><label class='label_paciente'>NOMBRE: </label>" + p.getNombre()+ "</li>" + this.delimiter +
		    "<li><label class='label_paciente'>APELLIDO: </label>"+ p.getApellido()+"</li>" + this.delimiter +
		    "<li><label class='label_paciente'>N&deg; FNR: </label>"+p.getNum_fnr()+"</li>" + this.delimiter + 
		    "<li><label class='label_paciente'>RAZA: </label>" + p.getRaza() +"</li>" + this.delimiter +
		    "<li><label class='label_paciente'>SEXO: </label>"+ p.getSexo() + "</li>" + this.delimiter + 
		    "<li><label class='label_paciente'>FECHA NACIMIENTO: </label>" + ManejoFechas.FORMATOESPANOL.format(p.getFecha_nacimiento().getTime()) + "</li>" + this.delimiter + 
		    "<li><label class='label_paciente'>FECHA DE DIALISIS: </label>" +ManejoFechas.FORMATOESPANOL.format(p.getFecha_dialisis().getTime()) +"</li>" + this.delimiter +
		    "<li><label class='label_paciente'>GRUPO SANGUINEO: </label>"+p.getGrupoSanguineo()+"</li>"+ this.delimiter +
		    "<li><label class='label_paciente'>NEFROPATIA: </label>"+p.getTipoNefropatia().getNefropatia()+"</li>"+ this.delimiter +
		  "</ul>"+ this.delimiter +
		"</div>" + this.delimiter;
		
		return salida;
	}

	public String reportePacienteTable(int idPaciente){
		Paciente p = this.getPaciente(idPaciente);
		String salida = "";
		salida += "<table width=\"200\" border=\"2\">"+ this.delimiter +
			   "<tr>" + this.delimiter +
			   "<td>" + this.delimiter;
		salida += "<div align=\"center\">" + this.delimiter +
		  "<p class=\"Estilo1\">PACIENTE" + 
		"</p>" + this.delimiter +
		 "<hr>" + this.delimiter +
		  "<table width=\"600\" height=\"383\" border=\"0\">" + this.delimiter +
		    "<tr>" + this.delimiter +
		      "<td><strong>THE</strong></td>" + this.delimiter +
		      "<td>" +p.getThe() + "</td>" + this.delimiter +
		      "<td><strong>CEDULA IDENTIDAD </strong></td>" + this.delimiter +
		      "<td>" +p.getCi() + "</td>" + this.delimiter +
		    "</tr>" + this.delimiter +
		    "<tr>" + this.delimiter +
		      "<td><strong>NOMBRE</strong></td>" + this.delimiter +
		      "<td>" + p.getNombre()+ "</td>" + this.delimiter +
		      "<td><strong>APELLIDO</strong></td>" + this.delimiter +
		      "<td>"+ p.getApellido()+"</td>" + this.delimiter +
		    "</tr>" + this.delimiter +
		    "<tr>" + this.delimiter +
		      "<td><strong>N&deg; FNR </strong></td>"+ this.delimiter +
		      "<td>"+p.getNum_fnr()+"</td>" + this.delimiter + 
		      "<td><strong>RAZA</strong></td>" + this.delimiter + 
		      "<td>" + p.getRaza() +"</td>" + this.delimiter +
		    "</tr>" + this.delimiter + 
		    "<tr>" + this.delimiter +
		      "<td><strong>SEXO</strong></td>" + this.delimiter +
		      "<td>"+ p.getSexo() + "</td>" + this.delimiter + 
		      "<td><strong>FECHA NACIMIENTO</strong></td>" + this.delimiter + 
		      "<td>" + ManejoFechas.FORMATOESPANOL.format(p.getFecha_nacimiento().getTime()) + "</td>" + this.delimiter + 
		    "</tr>" + this.delimiter +
		    "<tr>" + this.delimiter +
		      "<td><strong>FECHA DE DIALISIS</strong></td>" + this.delimiter +
		      "<td>" +ManejoFechas.FORMATOESPANOL.format(p.getFecha_dialisis().getTime()) +"</td>" + this.delimiter +
		      "<td><strong>GRUPO SANGUINEO</strong></td>" + this.delimiter +
		      "<td>"+p.getGrupoSanguineo()+"</td>"+ this.delimiter +
		    "</tr>" + this.delimiter +
		    "<tr>" + this.delimiter +
		      "<td><strong>NEFROPATIA</strong></td>" + this.delimiter +
		      "<td>"+p.getTipoNefropatia().getNefropatia()+"</td>"+ this.delimiter +
		      "<td>&nbsp;</td>"+ this.delimiter +
		      "<td>&nbsp;</td>" + this.delimiter +
		    "</tr>" + this.delimiter +
		  "</table>"+ this.delimiter +
		"</div>" + this.delimiter;
		salida += "</td>" + this.delimiter +
				"</tr>" + this.delimiter +
				"</table>" + this.delimiter; 
		return salida;
	}

	
	public String perdidaDeInjerto(int idPaciente){
		Paciente p = this.getPaciente(idPaciente);
		String aux = "";

		if(p.getListaPerdidas().size() > 0){
			aux += "<hr>" + this.delimiter ;
			aux += "<div class='div_box'>" + this.delimiter;
			
			aux += "<p class='titulo'>PERDIDA DE INJERTO</p>" + this.delimiter ;
			aux += "<ol>"+ this.delimiter;
			for(int x=0;x<p.getListaPerdidas().size();x++){
				aux += "<li>" + this.delimiter ;
				aux += "<ul class='lista_perdida_injerto'>"+ this.delimiter;
				PacientePerdidaInjerto auxPerdida = (PacientePerdidaInjerto) p.getListaPerdidas().get(x);
				aux += "<li><label class='label_perdida_injerto'>FECHA DE LA PERDIDA: </label>"+ ManejoFechas.FORMATOESPANOL.format(auxPerdida.getFechaPerdida().getTime()) + "</li>" + this.delimiter;
				aux += "<li><label class='label_perdida_injerto'>CAUSA DE LA PERDIDA: </label>"+ auxPerdida.getCausa().getDetalle() +"</li>" + this.delimiter;
				aux += "</ul>"+ this.delimiter;
				aux += "</li>" + this.delimiter ;
				
			}
			aux += "</ol>"+ this.delimiter;

			aux += "</div>" + this.delimiter;
		}

		return aux;
	}

	public String perdidaDeInjertoTable(int idPaciente){
		Paciente p = this.getPaciente(idPaciente);
		String aux = "";

		if(p.getListaPerdidas().size() > 0){
			aux += "<hr>" + this.delimiter ;
			aux += "<table width=\"600\" border=\"2\">"+ this.delimiter +
			   "<tr>" + this.delimiter +
			   "<td>" + this.delimiter ;
			aux += "<p align=\"center\"><strong><span class=\"Estilo3\">PERDIDA DE INJERTO</span></strong></p>" + this.delimiter ;
			for(int x=0;x<p.getListaPerdidas().size();x++){
				PacientePerdidaInjerto auxPerdida = (PacientePerdidaInjerto) p.getListaPerdidas().get(x);
				aux += "<p align=\"center\"><strong>FECHA DE LA PERDIDA: </strong>"+ ManejoFechas.FORMATOESPANOL.format(auxPerdida.getFechaPerdida().getTime()) + "</p>" + this.delimiter;
				aux += "<p align=\"center\"><strong>CAUSA DE LA PERDIDA: </strong>"+ auxPerdida.getCausa().getDetalle() +"</p>" + this.delimiter;
			}
			aux += "</td>" + this.delimiter +
			"</tr>" + this.delimiter +
			"</table>" + this.delimiter ;
		}

		return aux;
	}
	
	public String muerteDePaciente(int idPaciente){
		Paciente p = this.getPaciente(idPaciente);
		String aux = "";

		if(p.getMuertePaciente() != null){
			aux += "<hr>" + this.delimiter ;
			aux += "<div class='div_box'>" + this.delimiter;
			aux += "<p class='titulo'>MUERTE DEL PACIENTE</p>" + this.delimiter;
			aux += "<ul class='lista_nuerte_paciente'>"+ this.delimiter;
			aux += "<li><strong>FECHA DE LA MUERTE: </strong>"+ ManejoFechas.FORMATOESPANOL.format(p.getMuertePaciente().getFechaMuerte().getTime()) + "</li>" + this.delimiter ;
			aux += "<li><strong>CAUSA DE LA MUERTE: </strong>"+ p.getMuertePaciente().getCausa().getDetalle() +"</li>" + this.delimiter ;
			aux += "</ul>" + this.delimiter ;
			aux += "</div>";
		}

		return aux;
	}
	
	public String muerteDePacienteTable(int idPaciente){
		Paciente p = this.getPaciente(idPaciente);
		String aux = "";

		if(p.getMuertePaciente() != null){
			aux += "<hr>" + this.delimiter ;
			aux += "<table width=\"600\" border=\"2\">"+ this.delimiter +
			   "<tr>" + this.delimiter +
			   "<td>" + this.delimiter ;
			aux += "<p align=\"center\"><strong><span class=\"Estilo3\">MUERTE DEL PACIENTE</span></strong></p>" + this.delimiter ;
			aux += "<p align=\"center\"><strong>FECHA DE LA MUERTE: </strong>"+ ManejoFechas.FORMATOESPANOL.format(p.getMuertePaciente().getFechaMuerte().getTime()) + "</p>" + this.delimiter ;
			aux += "<p align=\"center\"><strong>CAUSA DE LA MUERTE: </strong>"+ p.getMuertePaciente().getCausa().getDetalle() +"</p>" + this.delimiter ;
			aux += "</td>" + this.delimiter +
			"</tr>" + this.delimiter +
			"</table>" + this.delimiter ;
		}

		return aux;
	}
	
	//No usado por el momento...
	public String reportePaciente2(int idPaciente){
		Paciente p = this.getPaciente(idPaciente);
		String aux = "";
		aux += "<div align=\"left\">" +
		  "<p class=\"Estilo1\">PACIENTE" +
		"</p>" +
		 "<hr>" +
		 "<strong>THE </strong>" +
		      p.getThe() + "<br>" +
		      "<strong>CEDULA IDENTIDAD </strong>" +
		      " " +p.getCi() + "<br>" +
		    "<strong>NOMBRE </strong>" +
		      " " + p.getNombre()+ "<br>" +
		      "<strong>APELLIDO </strong>" +
		      ""+ p.getApellido()+" <br>" +
		    "<strong>FNR </strong>"+
		      ""+p.getNum_fnr()+"<br>" +
		      "<strong>RAZA </strong>" +
		      "" + p.getRaza() +"<br>" +
		    "<strong>SEXO </strong>" +
		      ""+ p.getSexo() + "<br>" +
		      "<strong>FECHA NACIMIENTO </strong>" +
		      "" + ManejoFechas.FORMATOESPANOL.format(p.getFecha_nacimiento().getTime()) + "<br>" +
		    "<strong>FECHA DE DIALISIS </strong>" +
		      "" +ManejoFechas.FORMATOESPANOL.format(p.getFecha_dialisis().getTime()) +"<br>" +
		      "<strong>GRUPO SANGUINEO </strong>" +
		      ""+p.getGrupoSanguineo()+"<br>"+
		    "<strong>NEFROPATIA </strong>" +
		      ""+p.getTipoNefropatia().getNefropatia()+"<br>"+
		      "</div>";
		return aux;
	}
	
	
}
