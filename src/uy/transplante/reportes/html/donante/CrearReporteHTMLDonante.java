/**
 * 
 */
package uy.transplante.reportes.html.donante;

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
		aux += "<hr>" +  this.delimiter ;
		
		aux += "<div class='div_box'>" +  this.delimiter ;
		aux +="<p class='titulo'>DONANTE</p>" +  this.delimiter ;
		aux +="<ul class='lista_donante'>" +  this.delimiter ;
		aux +="<li><label class='label_donante'>ID: </label>" +String.valueOf(d.getId()) + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_donante'>EDAD: </label>" + String.valueOf(d.getEdad()) + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_donante'>TIPO: </label>" +d.getTipo() + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_donante'>Cr p(mg/dl): </label>" + String.valueOf(d.getCrP()) +"</li>" +  this.delimiter ;
		aux +="<li><label class='label_donante'>RELACION FILIAR: </label>" +relacionFiliar + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_donante'>CAUSA DE MUERTE: </label>" +d.getCausaMuerte().getDetalle() +"</li>" +  this.delimiter ;
		aux +="<li><label class='label_donante'>SEXO: </label>" + d.getSexo() + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_donante'>GRUPO SANGUINEO: </label>" + d.getGrupoSanguineo() + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_donante'>CRITERIO EXPANDIDO: </label></li>" +  this.delimiter ;
		aux +="<li><label class='label_donante'>PESO: </label>" + String.valueOf(d.getPeso()) +"</li>" +  this.delimiter ;
		aux +="<li><label class='label_donante'>ALTURA: </label>" + String.valueOf(d.getTalla()) + "</li>" +  this.delimiter ;
		aux +="<li><label class='label_donante'>SEROLES: </label></li>" +  this.delimiter ;
		aux +="<ol>" +  this.delimiter ;
		for(int x=0;x<d.getListaSeroles().size();x++){
			aux += "<li>"+d.getListaSeroles().get(x).toString()+"</li>"+ this.delimiter;
		}
		aux +="</ol>" +  this.delimiter ;
		aux +="<li><label class='label_donante'>ANTECEDENTES: </label></li>" +  this.delimiter ;
		aux +="<ol>" +  this.delimiter ;
		for(int x=0;x<d.getAntecedentes().size();x++){
			aux += "<li>"+d.getAntecedentes().get(x).toString()+"</li>"+ this.delimiter;
		}
		aux +="</ol>" +  this.delimiter ;
		aux +="<li><label class='label_donante'>ORGANOS DONADOS: </label></li>" +  this.delimiter ;
		aux +="<ol>" +  this.delimiter ;
		for(int x=0;x<d.getOrganos().size();x++){
			aux += "<li>"+d.getOrganos().get(x).toString()+"</li>"+ this.delimiter; 
		}
		aux +="</ol>" +  this.delimiter ;
		aux +="<li><label class='label_donante'>OTROS: </label>"+ d.getOtros() +"</li>" +  this.delimiter ;
		aux +="</ul>" +  this.delimiter ;
		aux +="</div> " +  this.delimiter ;
		
		
		
		return aux;
	}

	public String donanteTable(String idDonante){
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
