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
		      "<td>" + ManejoFechas.formatoEspanol.format(p.getFecha_nacimiento().getTime()) + "</td>" + this.delimiter + 
		    "</tr>" + this.delimiter +
		    "<tr>" + this.delimiter +
		      "<td><strong>FECHA DE DIALISIS</strong></td>" + this.delimiter +
		      "<td>" +ManejoFechas.formatoEspanol.format(p.getFecha_dialisis().getTime()) +"</td>" + this.delimiter +
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
			aux += "<table width=\"600\" border=\"2\">"+ this.delimiter +
			   "<tr>" + this.delimiter +
			   "<td>" + this.delimiter ;
			aux += "<p align=\"center\"><strong><span class=\"Estilo3\">PERDIDA DE INJERTO</span></strong></p>" + this.delimiter ;
			for(int x=0;x<p.getListaPerdidas().size();x++){
				PacientePerdidaInjerto auxPerdida = (PacientePerdidaInjerto) p.getListaPerdidas().get(x);
				aux += "<p align=\"center\"><strong>FECHA DE LA PERDIDA: </strong>"+ ManejoFechas.formatoEspanol.format(auxPerdida.getFechaPerdida().getTime()) + "</p>" + this.delimiter;
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
			aux += "<table width=\"600\" border=\"2\">"+ this.delimiter +
			   "<tr>" + this.delimiter +
			   "<td>" + this.delimiter ;
			aux += "<p align=\"center\"><strong><span class=\"Estilo3\">MUERTE DEL PACIENTE</span></strong></p>" + this.delimiter ;
			aux += "<p align=\"center\"><strong>FECHA DE LA MUERTE: </strong>"+ ManejoFechas.formatoEspanol.format(p.getMuertePaciente().getFechaMuerte().getTime()) + "</p>" + this.delimiter ;
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
		      "" + ManejoFechas.formatoEspanol.format(p.getFecha_nacimiento().getTime()) + "<br>" +
		    "<strong>FECHA DE DIALISIS </strong>" +
		      "" +ManejoFechas.formatoEspanol.format(p.getFecha_dialisis().getTime()) +"<br>" +
		      "<strong>GRUPO SANGUINEO </strong>" +
		      ""+p.getGrupoSanguineo()+"<br>"+
		    "<strong>NEFROPATIA </strong>" +
		      ""+p.getTipoNefropatia().getNefropatia()+"<br>"+
		      "</div>";
		return aux;
	}
	
	
}
