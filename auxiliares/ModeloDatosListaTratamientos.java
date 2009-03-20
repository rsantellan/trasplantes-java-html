package auxiliares;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.table.AbstractTableModel;

import dominio.Tratamiento;

public class ModeloDatosListaTratamientos extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Nombres de los campos
	private String[] columnNames = { "Fecha Inicio", "Fecha Fin", "Medicacion",
			"Dosis" };
	private String data[][];

	public int numColumns = columnNames.length;
	public int numRows;
	private ArrayList<Tratamiento> datos;

	public ModeloDatosListaTratamientos(ArrayList<Tratamiento> p) {
		this.datos = p;
		if (datos != null) {
			preCargarLineas();
		}
	}

	public int getColumnCount() {
		return this.numColumns;
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	public int getRowCount() {
		return this.numRows;
	}

	public Object getValueAt(int arg0, int arg1) {
		return data[arg0][arg1];
	}

	public void preCargarLineas() {
		numRows = this.datos.size();
		data = new String[numRows][numColumns];
		Calendar c = new GregorianCalendar();
		c.clear();
		c.set(1950, 1, 1);
		for (int x = 0; x < this.datos.size(); x++) {
			Tratamiento p = this.datos.get(x);
			data[x][0] = ManejoFechas.formatoEspanol.format(p.getFecha_inicio()
					.getTime());
			if (p.getFecha_fin().equals(c)) {
				data[x][1] = " - ";
			} else {
				data[x][1] = ManejoFechas.formatoEspanol.format(p
						.getFecha_fin().getTime());
			}
			data[x][2] = p.getMedicacion().getNombre();
			data[x][3] = p.getDosis();
		}
	}
}
