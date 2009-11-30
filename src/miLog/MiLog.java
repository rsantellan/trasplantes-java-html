package miLog;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

//import encriptado.Blowfish;


public class MiLog {


	private boolean exporto;
	private boolean error;
	
	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public boolean isExporto() {
		return exporto;
	}

	private void setExporto(boolean exporto) {
		this.exporto = exporto;
	}

	public MiLog(){
		this.setExporto(false);
	}
	public void exportar(String texto, boolean error) {
		this.setError(error);
		String log = "";
		String log1 = "";
		if(this.existeLog()){
			log1 = this.leerLog();
		}
		Calendar hoy = new GregorianCalendar();
		SimpleDateFormat formatoEspanol = new SimpleDateFormat("dd-MM-yyyy||HH:ss");
		log = formatoEspanol.format(hoy.getTime()) + System.getProperty("line.separator") +texto+ System.getProperty("line.separator");
		log1 += formatoEspanol.format(hoy.getTime()) + System.getProperty("line.separator") +texto+ System.getProperty("line.separator");
		this.exportarLog(log);
		this.exportarLogMio(log1);
		this.setExporto(true);
		//Mover para arriba para encriptar
		/*log = this.encriptar(log);
		log1 = this.encriptar(log1);*/
	}

	private void exportarLogMio(String texto) {
		try {
			String lugar = System.getProperty("user.dir");
			lugar = "C:\\Trasplante";
			java.io.File unArchivo;
			if(!this.isError()){
				unArchivo  = new java.io.File(lugar + "\\logMio.txt");
			}else{
				unArchivo  = new java.io.File(lugar + "\\logMioError.txt");
			}
			FileWriter buf = new FileWriter(unArchivo);
			buf.write(texto);
			buf.close();
		} catch (Exception e) {
			System.out.println("Error con java.io.File");
		}
	}
	
	private void exportarLog(String texto) {
		try {
			String lugar = System.getProperty("user.dir");
			lugar = "C:\\Trasplante";
			/*java.io.File unArchivo = new java.io.File(lugar + "\\log.txt");
			FileWriter buf = new FileWriter(unArchivo);
			buf.write(exportar);
			buf.close();*/
			
			RandomAccessFile miRan;
			if(!this.isError()){
				miRan = new RandomAccessFile(lugar + "\\log.txt", "rw");
			}else{
				miRan = new RandomAccessFile(lugar + "\\logError.txt", "rw");
			}
			miRan.seek(miRan.length());
			miRan.writeBytes(texto);
		} catch (IOException e) {
			System.out.println("Error con java.io.File");
		}
	}

	private boolean existeLog() {
		String lugar = System.getProperty("user.dir");
		lugar = "C:\\Trasplante";
		String sFichero = lugar + "\\log.txt";
		java.io.File fichero = new java.io.File(sFichero);
		if (!fichero.exists()) {
			this.crearLog();
			return false;
		}
		return true;
	}

	private void crearLog() {
		try {
			String exportar = "";
			String lugar = System.getProperty("user.dir");
			lugar = "C:\\Trasplante";
			java.io.File unArchivo = new java.io.File(lugar + "\\log.txt");
			FileWriter buf = new FileWriter(unArchivo);
			buf.write(exportar);
			buf.close();
		} catch (Exception e) {
			System.out.println("Error con java.io.File");
		}
	}

	private String leerLog() {
		String salida = "";
		try {
			String lugar = System.getProperty("user.dir");
			lugar = "C:\\Trasplante";
			BufferedReader reader = new BufferedReader(new FileReader(lugar + "\\log.txt"));
			String retornoDeCarro = System.getProperty("line.separator");
			String linea;
			StringBuffer lineaTotal = new StringBuffer("");
			linea = reader.readLine();
			while (linea != null) {
				lineaTotal.append(linea);
				lineaTotal.append(retornoDeCarro);
				linea = reader.readLine();
			}
			salida = lineaTotal.toString();
			reader.close();

			return salida;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static String inicioLog(){
		Calendar hoy = new GregorianCalendar();
		SimpleDateFormat formatoEspanol = new SimpleDateFormat("dd-MM-yyyy||HH:ss");
		String fecha = formatoEspanol.format(hoy.getTime());
		String salida = "";
		String retornoDeCarro = System.getProperty("line.separator");
		salida += "********************************************************";
		salida += retornoDeCarro;
		salida += "*                                                      *";
		salida += retornoDeCarro;
		salida += "*                                                      *";
		salida += retornoDeCarro;
		salida += "*                       "+fecha+"              *";
		salida += retornoDeCarro;
		salida += "*                                                      *";
		salida += retornoDeCarro;
		salida += "********************************************************";
		return salida;
	}
	
	/*private String encriptar(String texto){
		String salida = "";
		try {
			salida = Blowfish.encriptar(texto, "t9r7a5s3p1l3a");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salida;
	}*/
	
}
