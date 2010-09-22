package uy.transplante.auxiliares.fechas;

import java.text.SimpleDateFormat;
import java.util.Locale;

public final class ManejoFechas {
	public final static SimpleDateFormat FORMATOINGLES = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
	public final static SimpleDateFormat FORMATOESPANOL = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
	public final static SimpleDateFormat FORMATOHORAS = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
	public final static SimpleDateFormat FORMATOMES = new SimpleDateFormat("MMMMM", Locale.getDefault());
	public final static SimpleDateFormat FORMATOYEAR = new SimpleDateFormat("yyyy", Locale.getDefault());

	
}
