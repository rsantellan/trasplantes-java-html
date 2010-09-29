package uy.transplante.logica;

import uy.mysql.backup.MysqlBackupManager;

public class ControlBackUp {

	public int inicializarBackUp() {
		MysqlBackupManager.getInstancia().doBackUp();
		return 0;
	}


	public int inicializarRestore(String path) {
		Fachada.getInstancia().guardarLog(5, "Termino el volcado de datos");
		MysqlBackupManager.getInstancia().restoreBackUp(path);
		Fachada.getInstancia().guardarLog(5, "Termino el volcado de datos");
		return 0;
	}

	
}
