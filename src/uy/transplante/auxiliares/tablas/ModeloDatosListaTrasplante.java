package uy.transplante.auxiliares.tablas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import uy.transplante.auxiliares.fechas.ManejoFechas;

import dominio.Trasplante;

public class ModeloDatosListaTrasplante extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Nombres de los campos
	private String[] columnNames =  {"Id trasplante","N° Receptor", "N° Donante","Fecha","N° trasplante"};
	private String data[][];

	public int numColumns = columnNames.length;
	public int numRows;
	private ArrayList<Trasplante> datos;

	public ModeloDatosListaTrasplante(ArrayList<Trasplante> t){
		this.datos = t;
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
			Trasplante t = this.datos.get(x);
			data[x] [0] = Integer.toString(t.getId());
			data[x] [1] = Integer.toString(t.getPreTrasplante());
			data[x] [2] = t.getDonante().getId();
			data[x] [3] =  ManejoFechas.FORMATOESPANOL.format(t.getFecha().getTime());
			data[x] [4] = Integer.toString(t.getNumTr());
		}
	}
}
