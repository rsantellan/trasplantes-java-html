package logica;

import uy.mysql.backup.MysqlBackupManager;

public class ControlBackUp {

	public int inicializarBackUp() {
		MysqlBackupManager.getInstancia().doBackUp();
		return 0;
	}


	public int inicializarRestore(String path) {
		MysqlBackupManager.getInstancia().restoreBackUp(path);
		return 0;
	}

	
}
