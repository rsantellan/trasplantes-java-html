package uy.transplante.auxiliares.milog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

//import encriptado.Blowfish;

public class MiLog {

	private boolean exporto;
	private boolean error;
	
	private final static String SEPARADOR = System.getProperty("line.separator");

	private final static String DIRECTORY = System.getProperty("user.dir");
	
	private final static String FILE = "log.txt";
	
	public boolean isError() {
		return error;
	}

	public void setError(final boolean error) {
		this.error = error;
	}

	public boolean isExporto() {
		return exporto;
	}

	private void setExporto(final boolean exporto) {
		this.exporto = exporto;
	}

	public MiLog() {
		this.setExporto(false);
	}

	public void exportar(final String texto, final boolean error) throws IOException {
		this.setError(error);
		final StringBuffer log = new StringBuffer();
		final StringBuffer log1 = new StringBuffer();
		//String log = "";
		//String log1 = "";
		if (this.existeLog()) {
			log1.append(this.leerLog());
		}
		final Calendar hoy = new GregorianCalendar();
		final SimpleDateFormat formatoEspanol = new SimpleDateFormat(
				"dd-MM-yyyy||HH:ss", Locale.getDefault());
		log.append(formatoEspanol.format(hoy.getTime()));
		log.append(MiLog.SEPARADOR);
		log.append(texto);
		log.append(MiLog.SEPARADOR);

		log1.append(formatoEspanol.format(hoy.getTime()));
		log1.append(MiLog.SEPARADOR);
		log1.append(texto);
		log1.append(MiLog.SEPARADOR);

		this.exportarLog(log.toString());
		this.exportarLogMio(log1.toString());
		this.setExporto(true);
	}

	private void exportarLogMio(final String texto) throws IOException {
		final String lugar = MiLog.DIRECTORY;
		java.io.File unArchivo;
		if (this.isError()) {
			unArchivo = new java.io.File(lugar + "\\logMioError.txt");
		} else {
			unArchivo = new java.io.File(lugar + "\\logMio.txt");
		}
		final FileWriter buf = new FileWriter(unArchivo);
		buf.write(texto);
		buf.close();
	}

	private void exportarLog(final String texto) throws IOException {
		final String lugar = MiLog.DIRECTORY;
		RandomAccessFile miRan;
		if (this.isError()) {
			miRan = new RandomAccessFile(lugar + "\\logError.txt", "rw");
		} else {
			miRan = new RandomAccessFile(lugar + "\\" + MiLog.FILE, "rw");
		}
		miRan.seek(miRan.length());
		miRan.writeBytes(texto);
	}

	private boolean existeLog() throws IOException {
		final String lugar = MiLog.DIRECTORY;
		final String sFichero = lugar + "\\"+ MiLog.FILE;
		final java.io.File fichero = new java.io.File(sFichero);
		boolean retorno = false;
		if (fichero.exists()) {
			retorno = true;
		}else{
			this.crearLog();
			retorno = false;
		}
		return retorno;
	}

	private void crearLog() throws IOException {
		final String lugar = MiLog.DIRECTORY;
		final java.io.File unArchivo = new java.io.File(lugar + "\\"+ MiLog.FILE);
		final FileWriter buf = new FileWriter(unArchivo);
		buf.write("");
		buf.close();
	}

	private String leerLog() throws IOException {
		String salida = "";
		final String lugar = MiLog.DIRECTORY;
		final BufferedReader reader = new BufferedReader(new FileReader(lugar
				+ "\\log.txt"));
		final StringBuffer lineaTotal = new StringBuffer("");
		String linea = reader.readLine();
		while (linea != null) {
			lineaTotal.append(linea);
			lineaTotal.append(MiLog.SEPARADOR);
			linea = reader.readLine();
		}
		salida = lineaTotal.toString();
		reader.close();

		return salida;
	}

	public static String inicioLog() {
		final Calendar hoy = new GregorianCalendar();
		final SimpleDateFormat formatoEspanol = new SimpleDateFormat(
				"dd-MM-yyyy||HH:ss", Locale.getDefault());
		final StringBuffer salida = new StringBuffer(350);
		final String fecha = formatoEspanol.format(hoy.getTime());
		salida.append(MiLog.SEPARADOR);
		salida.append("********************************************************");
		salida.append(MiLog.SEPARADOR);
		salida.append("*                                                      *");
		salida.append(MiLog.SEPARADOR);
		salida.append("*                                                      *");
		salida.append(MiLog.SEPARADOR);
		salida.append("*                       " + fecha + "              *");
		salida.append(MiLog.SEPARADOR);
		salida.append("*                                                      *");
		salida.append(MiLog.SEPARADOR);
		salida.append("********************************************************");
		return salida.toString();
	}
}
