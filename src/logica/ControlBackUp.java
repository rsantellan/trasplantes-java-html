package logica;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import copiaArchivos.CopiarArchivos;

import uy.auxiliares.zipeo.ZipSimple;

public class ControlBackUp {

	private String nombre;
	private String nombreRespaldo;
	private String nombreArchivoSQL;
	private static String lugar = "c://Trasplante";// System.getProperty("user.dir");
	private static String lugarExtraccion = "c://Trasplante//";
	private static String lugarBD = "C:\\Program Files\\MySQL\\MySQL\\bin\\";

	private String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private String getNombreRespaldo() {
		return nombreRespaldo;
	}

	private void setNombreRespaldo(String nombreRespaldo) {
		this.nombreRespaldo = nombreRespaldo;
	}

	private String getNombreArchivoSQL() {
		return nombreArchivoSQL;
	}

	private void setNombreArchivoSQL(String nombreArchivoSQL) {
		this.nombreArchivoSQL = nombreArchivoSQL;
	}

	public int inicializarBackUp(int paso) {
		int salida = 0;
		switch (paso) {
		case 0:
			if (this.backUpPaso1()) {
				salida = 0;
			} else {
				salida = -1;
			}

			break;

		case 1:
			if (this.backUpPaso2()) {
				salida = 0;
			} else {
				salida = -1;
			}

			break;
		case 2:
			if (this.backUpPaso3()) {
				salida = 0;
			} else {
				salida = -1;
			}
			break;
		default:
			break;
		}

		return salida;
	}

	private boolean backUpPaso1() {
		boolean salida = true;
		Calendar aux = new GregorianCalendar();
		SimpleDateFormat formatoEspanol = new SimpleDateFormat(
				"dd-MM-yyyy-HHmmss");
		String retornoDeCarro = System.getProperty("line.separator");
		String lugarDirectorio = this.crearDirectorio();
		if (lugarDirectorio == null) {
			this.setNombre("");
			return false;
		}
		lugarDirectorio += "\\";
		String nombreArchivo = lugarDirectorio + "trasplante"
				+ formatoEspanol.format(aux.getTime());
		String crearBAT = "@echo off"
				+ retornoDeCarro
				+ "cd c:\\"
				+ retornoDeCarro
				+ "cd Program Files"
				+ retornoDeCarro
				+ "cd MySQL"
				+ retornoDeCarro
				+ "cd MySQL"
				+ retornoDeCarro
				+ "cd bin"
				+ retornoDeCarro
				+ "mysqldump --opt -u medico --password=\"medico\" trasplante > "
				+ nombreArchivo + ".sql" + retornoDeCarro + "exit";
		java.io.File unArchivo;
		unArchivo = new java.io.File(lugar + "\\backup.bat");
		try {
			if (unArchivo.exists()) {
				unArchivo.delete();
			}
			FileWriter buf = new FileWriter(unArchivo);
			buf.write(crearBAT);
			buf.close();
			java.io.File auxArchivo = new java.io.File(lugar + "\\backup.bat");
			buf = new FileWriter(auxArchivo);
			buf.write(crearBAT);
			buf.close();
			this.setNombre(nombreArchivo);
			TimeUnit.SECONDS.sleep(2);
		} catch (Exception e) {
			System.out.println("Error con java.io.File");
			System.out.println(e.getMessage());
			Fachada.getInstancia().guardarLog(
					"Error con java.io.File AL CREAR EL BAT de backup");
			salida = false;
		}
		return salida;
	}

	private String crearDirectorio() {
		String directorio = "c:\\Trasplante";
		java.io.File file = new java.io.File(directorio);
		if (!file.exists()) {
			if (!file.mkdir()) {
				System.out.println("NO CUENTA CON LOS PERMISOS NECESARIOS");
				Fachada.getInstancia().guardarLog(
						"[ERROR] En el paso de crear directorio de BackUp");
				return null;
			}
		}
		return directorio;
	}

	private boolean backUpPaso2() {
		boolean salida = true;
		Runtime aplicacion = Runtime.getRuntime();
		try {
			Process i = aplicacion.exec("cmd.exe /c start " + lugar
					+ "\\backup.bat");
			TimeUnit.SECONDS.sleep(5);
			Fachada.getInstancia().guardarLog("BORRANDO EL BAT.");
			borrarBATBackUp();
			Fachada.getInstancia().guardarLog("BAT BORRADO.");
			TimeUnit.SECONDS.sleep(5);
			i.destroy();
			aplicacion.runFinalization();
		} catch (IOException e) {
			e.printStackTrace();
			salida = false;
			Fachada.getInstancia().guardarLog("[ERROR] En el paso 2 de BackUp");
		} catch (InterruptedException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog("[ERROR] En el paso 2 de BackUp");
			salida = false;
		}
		return salida;
	}

	private void borrarBATBackUp() {
		try {
			java.io.File unArchivo;
			unArchivo = new java.io.File(lugar + "\\backup.bat");
			if (unArchivo.exists()) {
				Fachada.getInstancia().guardarLog(
						"EL BAT DE BACKUP NO EXISTE PARA BORRARLO");
				unArchivo.delete();
			}
		} catch (Exception e) {
			Fachada.getInstancia().guardarLog(
					"ERROR AL BORRAR EL BAT DE BACKUP.");
			System.out.println("Error con java.io.File");
		}
	}

	private boolean backUpPaso3() {
		ZipSimple z = new ZipSimple();
		String[] archivos = new String[] { this.getNombre() + ".sql" };
		z.crearZip(archivos, this.getNombre() + ".zip");
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog("[ERROR] En el paso 3 de BackUp");
			return false;
		}
		return eliminarArchivo();
	}

	private boolean eliminarArchivo() {
		String archivo = this.getNombre() + ".sql";
		java.io.File file = new java.io.File(archivo);
		if (file.exists()) {
			file.delete();
			return true;
		} else {
			return false;
		}
	}

	public int inicializarRestore(String nombre, int paso) {
		int salida = 0;
		switch (paso) {
		case 0:
			this.setNombreRespaldo(nombre);
			if (restorePaso1()) {
				salida = 0;
			} else {
				salida = -1;
			}
			break;
		case 1:
			if (restorePaso2()) {
				salida = 0;
			} else {
				salida = -1;
			}
			break;
		case 2:
			if (restorePaso3()) {
				salida = 0;
			} else {
				salida = -1;
			}
			break;
		case 3:
			if (restorePaso4()) {
				salida = 0;
			} else {
				salida = -1;
			}
			break;
		default:
			break;
		}

		return salida;
	}

	private boolean restorePaso1() {
		boolean retorno = true;
		ZipSimple z = new ZipSimple();
		List<String> lista = z.listarArchivoZip(this.getNombreRespaldo());
		if (lista.size() > 0) {
			z.unpackZip(this.getNombreRespaldo(), lugarExtraccion);
			this.setNombreArchivoSQL(lista.get(0));
		} else {
			retorno = false;
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			retorno = false;
			e.printStackTrace();
			Fachada.getInstancia()
					.guardarLog("[ERROR] En el paso 1 de Restore");
		}
		return retorno;
	}

	private boolean restorePaso2() {
		boolean retorno = true;
		String lugarNuevo = lugarBD + this.getNombreArchivoSQL();
		try {
			CopiarArchivos.copia(lugarExtraccion + this.getNombreArchivoSQL(),
					lugarNuevo);
		} catch (IOException e) {
			System.out.println("ERROR AL COPIAR");
			Fachada.getInstancia()
					.guardarLog("[ERROR] En el paso 2 de Restore");
			e.printStackTrace();
			return false;
		}
		this.crearBAT(this.getNombreArchivoSQL());
		return retorno;
	}

	private void crearBAT(String nombreArchivo) {
		try {
			String retornoDeCarro = System.getProperty("line.separator");
			String crearBAT = "@echo off" + retornoDeCarro + "cd c:\\"
					+ retornoDeCarro + "cd Program Files" + retornoDeCarro
					+ "cd MySQL" + retornoDeCarro + "cd MySQL" + retornoDeCarro
					+ "cd bin" + retornoDeCarro
					+ "mysql -umedico -p\"medico\" trasplante < "
					+ nombreArchivo + retornoDeCarro + "exit";
			java.io.File unArchivo;
			unArchivo = new java.io.File(lugar + "\\restore.bat");
			if (unArchivo.exists()) {
				unArchivo.delete();
			}
			FileWriter buf = new FileWriter(unArchivo);
			buf.write(crearBAT);
			buf.close();
			TimeUnit.SECONDS.sleep(2);
		} catch (Exception e) {
			System.out.println("Error con java.io.File");
			Fachada.getInstancia().guardarLog(
					"[ERROR] En el paso 2 de Restore. Crear el BAT");
		}
	}

	private boolean restorePaso3() {
		boolean retorno = true;
		Runtime aplicacion = Runtime.getRuntime();
		try {
			Process i = aplicacion.exec("cmd.exe /c start " + lugar
					+ "\\restore.bat");
			TimeUnit.SECONDS.sleep(5);
			i.destroy();
		} catch (IOException e) {
			e.printStackTrace();
			Fachada.getInstancia()
					.guardarLog("[ERROR] En el paso 3 de Restore");
			return false;
		} catch (InterruptedException e) {
			e.printStackTrace();
			Fachada.getInstancia()
					.guardarLog("[ERROR] En el paso 3 de Restore");
			return false;
		}
		return retorno;
	}

	private boolean restorePaso4() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			Fachada.getInstancia()
				.guardarLog("[ERROR] En el paso 4 de Restore");
			e.printStackTrace();
			return false;
		}
		this.borrarBATRestore();
		this.borrarArchivosRestore();
		return true;
	}

	private boolean borrarBATRestore() {
		try {
			java.io.File unArchivo;
			unArchivo = new java.io.File(lugar + "\\restore.bat");
			if (unArchivo.exists()) {
				unArchivo.delete();
			}
		} catch (Exception e) {
			System.out.println("Error con java.io.File");
			Fachada.getInstancia().guardarLog(
					"[ERROR] Al borrar el archivo restore.bat");
			return false;
		}
		return true;
	}

	private boolean borrarArchivosRestore() {
		boolean salida = true;

		java.io.File unArchivo;
		unArchivo = new java.io.File(lugarBD + this.getNombreArchivoSQL());

		if (unArchivo.exists()) {
			try {
				if (!unArchivo.delete()) {
					salida = false;
				}

			} catch (Exception e) {
				System.out.println("Error con java.io.File");
				Fachada.getInstancia().guardarLog(
						"[ERROR] Al borrar el archivo de el BIN de MySQL");
				salida = false;
			}
		}

		unArchivo = new java.io.File(lugarExtraccion
				+ this.getNombreArchivoSQL());
		if (unArchivo.exists()) {
			try {
				if (!unArchivo.delete()) {
					salida = false;
				}

			} catch (Exception e) {
				System.out.println("Error con java.io.File");
				Fachada.getInstancia().guardarLog(
						"[ERROR] Al borrar el archivo de el lugar de extraccion.");
				salida = false;
			}
		}
		return salida;
	}
}
