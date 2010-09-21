package uy.tranplante.auxiliares.file.selector;

import java.io.File;
import javax.swing.filechooser.*;

public class FiltroSQLZIP extends FileFilter {

	public boolean accept(final File file) {
		boolean correct = false;
		if (file.isDirectory()) {
			correct = true;
		} else {
			final String extension = Utils.getExtension(file);
			if (extension != null) {
				if (extension.equals(Utils.ZIP)) {
					correct = true;
				} else {
					correct = false;
				}
			}
		}

		return correct;
	}

	// The description of this filter
	public String getDescription() {
		return "*.zip";
	}
}
