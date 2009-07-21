package auxiliares;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import dominio.Donante;

public class ModeloDatosListaDonantes extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Nombres de los campos
	private String[] columnNames =  {"ID", "Tipo","Sexo","Otros"};
	private String data[][];

	public int numColumns = columnNames.length;
	public int numRows;
	private ArrayList<Donante> datos;

	public ModeloDatosListaDonantes(ArrayList<Donante> p){
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
			Donante d = this.datos.get(x);
			data[x] [0] = d.getId();
			data[x] [1] = d.getTipo();
			String sexo;
			if(d.getSexo().equalsIgnoreCase("M")){
				sexo = "Masculino";
			}else{
				sexo = "Femenino";
			}
			data[x] [2] = sexo;
			data[x] [3] = d.getOtros();
		}
	}
}
