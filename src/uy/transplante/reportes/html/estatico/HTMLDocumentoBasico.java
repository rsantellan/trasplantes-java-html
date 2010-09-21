/**
 * 
 */
package uy.tranplante.reportes.html.estatico;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author rodrigo
 *
 */
public class HTMLDocumentoBasico {

	private String html = "";
	private String nombre = "";
	
	/**
	 * 
	 */
	public HTMLDocumentoBasico(int the, int preTransplante) {
		this.html = this.cabezal();
		this.nombre = java.io.File.separatorChar + "reportePaciente"+the+"Pre"+preTransplante+".html";
	}

	public void agregarTexto(String texto){
		this.html += texto;
	}
	
	private String getFile(){
		String directory = "reportes";
		String pathEntero = System.getProperty("user.dir") + java.io.File.separatorChar + directory;
		java.io.File unArchivo = new java.io.File(pathEntero);
		if(unArchivo.isDirectory()){
			System.out.println("Es directorio");
		}else{
			System.out.println("No es directorio");
			if(unArchivo.mkdir()){
				System.out.println("Se creo el directorio");
			}
		}
		return pathEntero + this.nombre;
	}
	public String getFileName(){
		return System.getProperty("user.dir")+this.getFile();
	}
	
	public void cerrarDocumento(){
		this.html += this.pie();
		System.out.println(System.getProperty("user.dir"));
		java.io.File unArchivo = new java.io.File(this.getFile());

		FileWriter buf;

		try {
			buf = new FileWriter(unArchivo);
			buf.write(this.parseStrings(this.html));
			buf.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}catch(Exception e1){
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		}
	}
	
	private String parseStrings(String text){
		String salida = text;
		char[] charList = salida.toCharArray();
		salida = "";
		for(int x = 0; x< charList.length;x++){
			salida += this.changeLetters(charList[x]);
			
		}
		return salida;
	}
	
	private String changeLetters(char letter){
		String aux = "";
		aux += letter;
		switch (letter) {
		case 'ñ':
			aux = "&ntilde;";
			break;
		case 'ú':
			aux = "&uacute;";
			break;
		case 'í':
			aux = "&iacute;";
			break;
		case 'é':
			aux = "&eacute;";
			break;	
		case 'á':
			aux = "&aacute;";
			break;
		case 'ó':
			aux = "&oacute;";
			break;
		default:
			break;
		}
		return aux;
	}
	
	private String cabezal(){
		String aux = "";
		aux = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" ";
		aux += "\"http://www.w3.org/TR/html4/loose.dtd\">";
		aux += "<html>";
		aux += "<head>";
		aux += "<title>Reporte Paciente</title>";
		aux += "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">";
		aux += "<link href='css/reporteHtml.css' rel='stylesheet' type='text/css'>"; 
		aux += "</head>" + "<body>";
		return aux;
	}
	
	private String pie(){
		String aux = "";
		aux += "</body></html>";
		return aux;
	}
}
