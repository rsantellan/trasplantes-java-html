package auxiliares;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import dominio.Paciente;

public class ModeloDatosListaPacientes extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Nombres de los campos
	private String[] columnNames =  {"Numero THE", "Nombre","Apellido","CI"};
	private String data[][];

	public int numColumns = columnNames.length;
	public int numRows;
	private ArrayList<Paciente> datos;

	public ModeloDatosListaPacientes(ArrayList<Paciente> p){
		this.datos = p;
		if(datos != null){
			preCargarLineas();
		}
	}

	public int getColumnCount() {
		return this.numColumns;
	}

	@Override
	public String getColumnName(int col){
		return columnNames[col];
	}

	public int getRowCount() {
		return this.numRows;
	}

	public Object getValueAt(int arg0, int arg1) {
		return data[arg0][arg1];
	}

	public void preCargarLineas(){
		numRows = this.datos.size();
		data = new String [numRows] [numColumns] ;
		for(int x= 0; x<this.datos.size();x++){
			Paciente p = this.datos.get(x);
			data[x] [0] = Integer.toString(p.getThe());
			data[x] [1] = p.getNombre();
			data[x] [2] = p.getApellido();
			data[x] [3] = p.getCi();
		}
	}
}
