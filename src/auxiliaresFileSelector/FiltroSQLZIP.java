package auxiliaresFileSelector;

import java.io.File;
import javax.swing.filechooser.*;

public class FiltroSQLZIP extends FileFilter {

	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}

		String extension = Utils.getExtension(f);
		if (extension != null) {
			if (extension.equals(Utils.zip)) {
				return true;
			} else {
				return false;
			}

			/*
			 * if (extension.equals(Utils.zip) || extension.equals(Utils.sql)) {
			 * return true; }
			 * 
			 * else { return false; }
			 */
		}

		return false;
	}

	// The description of this filter
	public String getDescription() {
		return "*.zip";
		// return "*.sql, *.zip";
		// return "Solo archivos SQL o ZIP creados con backup";
	}
}
