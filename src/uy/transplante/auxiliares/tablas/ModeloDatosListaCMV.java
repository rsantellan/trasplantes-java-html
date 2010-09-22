package uy.transplante.auxiliares.tablas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import uy.transplante.auxiliares.fechas.ManejoFechas;

import dominio.CMV;

public class ModeloDatosListaCMV extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Nombres de los campos
	private String[] columnNames =  {"Fecha", "Diagnostico","Tratamiento Anticipado","Sindrome Viral","Dias Tratamiento"};
	private String data[][];

	public int numColumns = columnNames.length;
	public int numRows;
	private ArrayList<CMV> datos;

	public ModeloDatosListaCMV(ArrayList<CMV> p){
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

	private void preCargarLineas(){
		numRows = this.datos.size();
		data = new String [numRows] [numColumns] ;
		for(int x= 0; x<this.datos.size();x++){
			CMV p = this.datos.get(x);
			data[x] [0] = ManejoFechas.FORMATOESPANOL.format(p.getFecha().getTime());
			data[x] [1] = p.getDiagnostico().getNombre();
			if(p.isTmAnti()){
				data[x] [2] = "Si";
			}else{
				data[x] [2] = "No";
			}
			if(p.isSindromeViral()){
				data[x] [3] = "Si";
			}else{
				data[x] [3] = "No";
			}
			data[x][4] = String.valueOf(p.getDiasTm());
		}
	}
}
