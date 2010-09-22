package uy.transplante.auxiliares.consultas;

import javax.swing.table.AbstractTableModel;

import dominio.Generico;

public class AModeloDatosConsultaGenerico extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Nombres de los campos
	private String[] columnNames = {};
	private String data[][];

	public int numColumns = columnNames.length;
	public int numRows;
	private Generico datos;

	public AModeloDatosConsultaGenerico(Generico g) {
		columnNames = new String[g.getListaNombre().size()];
		for(int x=0;x<columnNames.length;x++){
			columnNames[x] = g.getListaNombre().get(x);
		}
		numColumns = columnNames.length;
		datos = g;
		preCargarLineas();
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
		numRows = this.datos.getListaObtenida().size() / this.datos.getListaNombre().size();
		data = new String[numRows][numColumns];
		int y = 0;
		for (int x = 0; x < this.datos.getListaObtenida().size(); x++) {
			int pos = x % this.datos.getListaDada().size();
			if(x!=0){
				if(pos==0){
					y++;
				}
			}
			if(this.datos.getListaDada().get(pos).equalsIgnoreCase(Generico.VF)){
				if(this.datos.getListaObtenida().get(x).toString().equalsIgnoreCase("true")){
					data[y][pos] = "SI";
				}else{
					data[y][pos] = "NO";
				}
			}else{
				data[y][pos] = this.datos.getListaObtenida().get(x).toString();
			}
		}
	}
}
