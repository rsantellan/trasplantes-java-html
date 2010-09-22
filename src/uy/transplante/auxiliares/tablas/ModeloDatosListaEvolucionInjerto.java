package uy.transplante.auxiliares.tablas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import uy.transplante.auxiliares.fechas.ManejoFechas;
import uy.transplante.dominio.EvolucionInjerto;


public class ModeloDatosListaEvolucionInjerto extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Nombres de los campos
	private String[] columnNames =  {"Fecha","Rechazo Agudo","Rechazo Cronico","GP de Novo","Recidiva GP","Tratamiento"};
	private String data[][];

	public int numColumns = columnNames.length;
	public int numRows;
	private ArrayList<EvolucionInjerto> datos;

	public ModeloDatosListaEvolucionInjerto(ArrayList<EvolucionInjerto> p){
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
			EvolucionInjerto p = this.datos.get(x);
			data[x] [0] = ManejoFechas.FORMATOESPANOL.format(p.getFecha().getTime());
			if(p.isRa()){
				data[x] [1] = "Si";
			}else{
				data[x] [1] = "No";
			}
			if(p.isRc()){
				data[x] [2] = "Si";
			}else{
				data[x] [2] = "No";
			}
			if(p.isGpNovo()){
				data[x] [3] = "Si";
			}else{
				data[x] [3] = "No";
			}
			if(p.isRecidivaGp()){
				data[x] [4] = "Si";
			}else{
				data[x] [4] = "No";
			}
			data[x] [5] = p.getTratamiento().getNombre();
		}
	}
}
