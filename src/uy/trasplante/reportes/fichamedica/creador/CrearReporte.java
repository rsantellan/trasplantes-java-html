package uy.trasplante.reportes.fichamedica.creador;

import java.awt.BorderLayout;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JFrame;

import logica.Fachada;

import auxiliares.ManejoFechas;

import dominio.Donante;
import dominio.Paciente;
import dominio.PacientePerdidaInjerto;

public class CrearReporte extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;

	/**
	 * This is the default constructor
	 */
	public CrearReporte() {
		super();
		initialize();
		Paciente p = new Paciente();
		p.setThe(9);
		Fachada.getInstancia().cambie();
		p.leer();
		p.leerDatos();
		String exportar = this.cabezal(p);
		
		exportar += this.paciente(p);
		exportar += this.perdidaDeInjerto(p);
		exportar += this.muerteDePaciente(p);
		Donante d = new Donante();
		d.setId("PTG27061975");
		d.leer();
		d.leerDatos();
		exportar += this.donante(d);
		exportar += this.pie();
		
		java.io.File unArchivo = new java.io.File(System.getProperty("user.dir")+"/exportacion.htm");
		FileWriter buf;
		try {
			buf = new FileWriter(unArchivo);
			buf.write(exportar);
			buf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
		}
		return jContentPane;
	}
	
	public String cabezal(Paciente p){
		String aux = "";
		aux = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" ";
		aux += "\"http://www.w3.org/TR/html4/loose.dtd\">";
		aux += "<html>";
		aux += "<head>";
		aux += "<title>Reporte Paciente</title>";
		aux += "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">";
		aux += "<style type=\"text/css\">";
		aux += "<!--" +
		".Estilo1 {" +
			"font-size: 24px;" +
			"font-weight: bold;" +
		"}" +
		".Estilo3 {font-size: 24px}"+
		"-->" +
		"</style>"+
		"</head>" +

		"<body>";
		aux += "<div align=\"center\">" +
		  "<p class=\"Estilo1\">REPORTE DEL PACIENTE : " +p.getApellido() +
		"</p><hr>";
		return aux;
	}
	
	public String pie(){
		String aux = "";
		aux += "</body>" +
		"</html>";
		return aux;
	}
	
	public String pacienteTabla(Paciente p){
		String aux = "";
		aux += "<table width=\"200\" border=\"2\">"+
			   "<tr>" +
			   "<td>";
		aux += "<div align=\"center\">" +
		  "<p class=\"Estilo1\">PACIENTE" +
		"</p>" +
		 "<hr>" +
		  "<table width=\"600\" height=\"383\" border=\"0\">" +
		    "<tr>" +
		      "<td><strong>THE</strong></td>" +
		      "<td>" +p.getThe() + "</td>" +
		      "<td><strong>CEDULA IDENTIDAD </strong></td>" +
		      "<td>" +p.getCi() + "</td>" +
		    "</tr>" +
		    "<tr>" +
		      "<td><strong>NOMBRE</strong></td>" +
		      "<td>" + p.getNombre()+ "</td>" +
		      "<td><strong>APELLIDO</strong></td>" +
		      "<td>"+ p.getApellido()+"</td>" +
		    "</tr>" +
		    "<tr>" +
		      "<td><strong>N&deg; FNR </strong></td>"+
		      "<td>"+p.getNum_fnr()+"</td>" +
		      "<td><strong>RAZA</strong></td>" +
		      "<td>" + p.getRaza() +"</td>" +
		    "</tr>" +
		    "<tr>" +
		      "<td><strong>SEXO</strong></td>" +
		      "<td>"+ p.getSexo() + "</td>" +
		      "<td><strong>FECHA NACIMIENTO</strong></td>" +
		      "<td>" + ManejoFechas.formatoEspanol.format(p.getFecha_nacimiento().getTime()) + "</td>" +
		    "</tr>" +
		    "<tr>" +
		      "<td><strong>FECHA DE DIALISIS</strong></td>" +
		      "<td>" +ManejoFechas.formatoEspanol.format(p.getFecha_dialisis().getTime()) +"</td>" +
		      "<td><strong>GRUPO SANGUINEO</strong></td>" +
		      "<td>"+p.getGrupoSanguineo()+"</td>"+
		    "</tr>" +
		    "<tr>" +
		      "<td><strong>NEFROPATIA</strong></td>" +
		      "<td>"+p.getTipoNefropatia().getNefropatia()+"</td>"+
		      "<td>&nbsp;</td>"+
		      "<td>&nbsp;</td>" +
		    "</tr>" +
		  "</table>"+
		"</div>";
		aux += "</td>" +
				"</tr>" +
				"</table>";
		return aux;
	}
	
	public String paciente(Paciente p){
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
	
	public String perdidaDeInjerto(Paciente p){
		String aux = "";

		if(p.getListaPerdidas().size() > 0){
			aux += "<hr>";
			aux += "<table width=\"200\" border=\"2\">"+
			   "<tr>" +
			   "<td>";
			aux += "<p align=\"center\"><strong><span class=\"Estilo3\">PERDIDA DE INJERTO</span></strong></p>;";
			for(int x=0;x<p.getListaPerdidas().size();x++){
				PacientePerdidaInjerto auxPerdida = (PacientePerdidaInjerto) p.getListaPerdidas().get(x);
				aux += "<p align=\"center\"><strong>FECHA DE LA PERDIDA: </strong>"+ ManejoFechas.formatoEspanol.format(auxPerdida.getFechaPerdida().getTime()) + "</p>";
				aux += "<p align=\"center\"><strong>CAUSA DE LA PERDIDA: </strong>"+ auxPerdida.getCausa().getDetalle() +"</p>";
			}
			aux += "</td>" +
			"</tr>" +
			"</table>";
		}

		return aux;
	}

	public String muerteDePaciente(Paciente p){
		String aux = "";

		if(p.getMuertePaciente() != null){
			aux += "<hr>";
			aux += "<table width=\"200\" border=\"2\">"+
			   "<tr>" +
			   "<td>";
			aux += "<p align=\"center\"><strong><span class=\"Estilo3\">MUERTE DEL PACIENTE</span></strong></p>";
			aux += "<p align=\"center\"><strong>FECHA DE LA MUERTE: </strong>"+ ManejoFechas.formatoEspanol.format(p.getMuertePaciente().getFechaMuerte().getTime()) + "</p>";
			aux += "<p align=\"center\"><strong>CAUSA DE LA MUERTE: </strong>"+ p.getMuertePaciente().getCausa().getDetalle() +"</p>";
			aux += "</td>" +
			"</tr>" +
			"</table>";
		}

		return aux;
	}
	
	public String donante(Donante d){
		String aux = "";
		aux += "<hr><table width=\"200\" border=\"2\">"+
		   "<tr>" +
		   "<td>";
		aux += "<p align=\"center\"><strong><span class=\"Estilo3\">DONANTE</span></strong></p>" +
		"<div align=\"center\">" +
		  "<table width=\"500\" border=\"0\">" +
		    "<tr>" +
		      "<td width=\"91\"><strong>ID</strong></td>" +
		      "<td width=\"6\">" +String.valueOf(d.getId()) + "</td>" +
		      "<td width=\"78\"><strong>EDAD</strong></td>" +
		      "<td width=\"7\">" + String.valueOf(d.getEdad()) + "</td>" +
		    "</tr>" +
		    "<tr>" +
		      "<td><strong>TIPO</strong></td>" +
		      "<td>" +d.getTipo() + "</td>" +
		      "<td><strong>Cr p(mg/dl)</strong></td>" +
		      "<td>" + String.valueOf(d.getCrP()) +"</td>"+
		    "</tr>" +
		    "<tr>" +
		      "<td><p><strong>RELACION FILIAR</strong></p>      </td>" +
		      "<td>" +d.getRelacionFiliar() + "</td>" +
		      "<td><strong>CAUSA DE MUERTE </strong></td>" +
		      "<td>" +d.getCausaMuerte().getDetalle() +"</td>"+
		    "</tr>" +
		    "<tr>" +
		      "<td><strong>SEXO</strong></td>" +
		      "<td>" + d.getSexo() + "</td>" +
		      "<td><strong>GRUPO SANGUINEO </strong></td>" +
		      "<td>" + d.getGrupoSanguineo() + "</td>" +
		    "</tr>" +
		    "<tr>" +
		      "<td><strong>CRITERIO EXPANDIDO</strong></td>" +
		      "<td>" + "</td>" +
		      "<td><strong>PESO</strong></td>" +
		      "<td>" + String.valueOf(d.getPeso()) +"</td>"+
		    "</tr>" +
		    "<tr> " +
		      "<td>&nbsp;</td>" +
		      "<td>&nbsp;</td>" +
		      "<td><strong>ALTURA</strong></td>" +
		      "<td>" + String.valueOf(d.getPeso()) + "</td>" +
		    "</tr> ";
		aux += "<tr>"+
		      "<td><strong>SEROLES</strong></td>"+
		      "<td>&nbsp;</td>" +
		      "<td>&nbsp;</td>" +
		      "<td>&nbsp;</td>" +
		    "</tr>";
		for(int x=0;x<d.getListaSeroles().size();x++){
			aux += " <tr>"+
		      "<td>&nbsp;</td>"+
		      "<td>"+d.getListaSeroles().get(x).toString()+"</td>"+
		      "<td>&nbsp;</td>"+
		      "<td>&nbsp;</td>"+
		    "</tr>";
		}
		aux += "<tr>"+
	      "<td><strong>ANTECEDENTES</strong></td>"+
	      "<td>&nbsp;</td>" +
	      "<td>&nbsp;</td>" +
	      "<td>&nbsp;</td>" +
	    "</tr>";
		for(int x=0;x<d.getAntecedentes().size();x++){
			aux += " <tr>"+
		      "<td>&nbsp;</td>"+
		      "<td>"+d.getAntecedentes().get(x).toString()+"</td>"+
		      "<td>&nbsp;</td>"+
		      "<td>&nbsp;</td>"+
		    "</tr>";
		}
		aux += "<tr>"+
	      "<td><strong>ORGANOS DONADOS</strong></td>"+
	      "<td>&nbsp;</td>" +
	      "<td>&nbsp;</td>" +
	      "<td>&nbsp;</td>" +
	    "</tr>";
		for(int x=0;x<d.getOrganos().size();x++){
			aux += " <tr>"+
		      "<td>&nbsp;</td>"+
		      "<td>"+d.getOrganos().get(x).toString()+"</td>"+
		      "<td>&nbsp;</td>"+
		      "<td>&nbsp;</td>"+
		    "</tr>";
		}
		aux += "<tr>"+
	      "<td><strong>OTROS</strong></td>"+
	      "<td>"+ d.getOtros() +"</td>" +
	      "<td>&nbsp;</td>" +
	      "<td>&nbsp;</td>" +
	    "</tr>";
		
		aux += "</table>"+
		"</div>"+
		"<hr>";
		aux += "</td>" +
		"</tr>" +
		"</table>";
		return aux;
	}
}
