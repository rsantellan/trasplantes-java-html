/**
 * 
 */
package uy.tranplante.reportes.html.donante;

import dominio.Donante;

/**
 * @author rodrigo
 *
 */
public class CrearReporteHTMLDonante {

	private String delimiter = "\n";
	
	public String donante(String idDonante){
		Donante d = new Donante();
		d.setId(idDonante);
		d.leer();
		d.leerDatos();
		String aux = "";
		String relacionFiliar = "";
		if(d.getRelacionFiliar() != null){
			System.out.println("nulo");
		}
		if(d.getRelacionFiliar() == null || d.getRelacionFiliar() == ""){
			relacionFiliar = "NO";
		}else{
			relacionFiliar = d.getRelacionFiliar();
		}
		aux += "<hr><table width=\"600\" border=\"2\">"+ this.delimiter +
		   "<tr>" + this.delimiter +
		   "<td>" + this.delimiter ;
		aux += "<p align=\"center\"><strong><span class=\"Estilo3\">DONANTE</span></strong></p>" + this.delimiter +
		"<div align=\"center\">" + this.delimiter +
		  "<table width=\"600\" border=\"0\">" + this.delimiter +
		    "<tr>" + this.delimiter +
		      "<td width=\"91\"><strong>ID</strong></td>" + this.delimiter +
		      "<td width=\"6\">" +String.valueOf(d.getId()) + "</td>" + this.delimiter +
		      "<td width=\"78\"><strong>EDAD</strong></td>" + this.delimiter +
		      "<td width=\"7\">" + String.valueOf(d.getEdad()) + "</td>" + this.delimiter +
		    "</tr>" + this.delimiter +
		    "<tr>" + this.delimiter +
		      "<td><strong>TIPO</strong></td>" + this.delimiter +
		      "<td>" +d.getTipo() + "</td>" + this.delimiter +
		      "<td><strong>Cr p(mg/dl)</strong></td>" + this.delimiter + 
		      "<td>" + String.valueOf(d.getCrP()) +"</td>"+ this.delimiter +
		    "</tr>" + this.delimiter +
		    "<tr>" + this.delimiter +
		      "<td><p><strong>RELACION FILIAR</strong></p>      </td>" + this.delimiter +
		      "<td>" +relacionFiliar + "</td>" + this.delimiter +
		      "<td><strong>CAUSA DE MUERTE </strong></td>" + this.delimiter +
		      "<td>" +d.getCausaMuerte().getDetalle() +"</td>"+ this.delimiter +
		    "</tr>" + this.delimiter +
		    "<tr>" + this.delimiter +
		      "<td><strong>SEXO</strong></td>" + this.delimiter +
		      "<td>" + d.getSexo() + "</td>" + this.delimiter +
		      "<td><strong>GRUPO SANGUINEO </strong></td>" + this.delimiter +
		      "<td>" + d.getGrupoSanguineo() + "</td>" + this.delimiter +
		    "</tr>" + this.delimiter +
		    "<tr>" + this.delimiter +
		      "<td><strong>CRITERIO EXPANDIDO</strong></td>" + this.delimiter +
		      "<td>" + "</td>" + this.delimiter +
		      "<td><strong>PESO</strong></td>" + this.delimiter +
		      "<td>" + String.valueOf(d.getPeso()) +"</td>"+ this.delimiter +
		    "</tr>" + this.delimiter +
		    "<tr> " + this.delimiter +
		      "<td>&nbsp;</td>" + this.delimiter +
		      "<td>&nbsp;</td>" + this.delimiter +
		      "<td><strong>ALTURA</strong></td>" + this.delimiter +
		      "<td>" + String.valueOf(d.getPeso()) + "</td>" + this.delimiter +
		    "</tr> " + this.delimiter; 
		aux += "<tr>"+ this.delimiter +
		      "<td><strong>SEROLES</strong></td>"+ this.delimiter +
		      "<td>&nbsp;</td>" + this.delimiter +
		      "<td>&nbsp;</td>" + this.delimiter +
		      "<td>&nbsp;</td>" + this.delimiter +
		    "</tr>" + this.delimiter; 
		for(int x=0;x<d.getListaSeroles().size();x++){
			aux += " <tr>"+ this.delimiter +
		      "<td>&nbsp;</td>"+ this.delimiter +
		      "<td>"+d.getListaSeroles().get(x).toString()+"</td>"+ this.delimiter +
		      "<td>&nbsp;</td>"+ this.delimiter +
		      "<td>&nbsp;</td>"+ this.delimiter +
		    "</tr>" + this.delimiter;
		}
		aux += "<tr>"+ this.delimiter +
	      "<td><strong>ANTECEDENTES</strong></td>"+ this.delimiter +
	      "<td>&nbsp;</td>" + this.delimiter +
	      "<td>&nbsp;</td>" + this.delimiter +
	      "<td>&nbsp;</td>" + this.delimiter +
	    "</tr>" + this.delimiter; 
		for(int x=0;x<d.getAntecedentes().size();x++){
			aux += " <tr>"+ this.delimiter +
		      "<td>&nbsp;</td>"+ this.delimiter +
		      "<td>"+d.getAntecedentes().get(x).toString()+"</td>"+ this.delimiter +
		      "<td>&nbsp;</td>"+ this.delimiter +
		      "<td>&nbsp;</td>"+ this.delimiter +
		    "</tr>" + this.delimiter;
		}
		aux += "<tr>"+ this.delimiter +
	      "<td><strong>ORGANOS DONADOS</strong></td>"+ this.delimiter +
	      "<td>&nbsp;</td>" + this.delimiter +
	      "<td>&nbsp;</td>" + this.delimiter +
	      "<td>&nbsp;</td>" + this.delimiter +
	    "</tr>" + this.delimiter;
		for(int x=0;x<d.getOrganos().size();x++){
			aux += " <tr>"+ this.delimiter +
		      "<td>&nbsp;</td>"+ this.delimiter +
		      "<td>"+d.getOrganos().get(x).toString()+"</td>"+ this.delimiter +
		      "<td>&nbsp;</td>"+ this.delimiter +
		      "<td> &nbsp;</td>"+ this.delimiter +
		    "</tr>" + this.delimiter; 
		}
		aux += "<tr>"+this.delimiter +"<td>&nbsp;</td>"+this.delimiter +"<td>&nbsp;</td>"+this.delimiter +"<td>&nbsp;</td>"+this.delimiter +"<td>&nbsp;</td>"+this.delimiter +"</tr>" +this.delimiter;
		aux += "<tr>"+ this.delimiter +
	      "<td><strong>OTROS</strong></td>"+ this.delimiter +
	      "<td>"+ d.getOtros() +"</td>" + this.delimiter +
	      "<td>&nbsp;</td>" + this.delimiter +
	      "<td>&nbsp;</td>" + this.delimiter +
	    "</tr>" + this.delimiter;
		
		aux += "</table>"+ this.delimiter +
		"</div>"+ this.delimiter +
		"<hr>" + this.delimiter ; 
		aux += "</td>" + this.delimiter +
		"</tr>" + this.delimiter +
		"</table>" + this.delimiter; 
		return aux;
	}
}
