package uy.transplante.auxiliares.tablas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import uy.transplante.auxiliares.fechas.ManejoFechas;

import dominio.EvolucionTrasplanteTotal;

public class ModeloDatosListaEvoluciones extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Nombres de los campos
	private String[] columnNames =  {"Fecha", "Id Trasplante","Paraclinica","ECG","CMV","Nutricion","Tx Torax","Eco Cardio","Virales","Ecodopler","Ecografias","Otros Examenes"};
	private String data[][];

	public int numColumns = columnNames.length;
	public int numRows;
	private ArrayList<EvolucionTrasplanteTotal> datos;

	public ModeloDatosListaEvoluciones(ArrayList<EvolucionTrasplanteTotal> p){
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
			EvolucionTrasplanteTotal p = this.datos.get(x);
			data[x] [0] = ManejoFechas.FORMATOESPANOL.format(p.getFecha().getTime());
			data[x] [1] = String.valueOf(p.getIdTrasplante());
			if(p.getEvoTrasplante() == null){
				data[x] [2] = "-";
			}else{
				data[x] [2] = "Si";
			}
			
			if(p.getEvoTrasplanteECG() == null){
				data[x] [3] = "-";
			}else{
				data[x] [3] = "Si";
			}

			if(p.getEvoTrasplanteCMV() == null){
				data[x] [4] = "-";
			}else{
				data[x] [4] = "Si";
			}
			
			if(p.getEvoTrasplanteNutricion() == null){
				data[x] [5] = "-";
			}else{
				data[x] [5] = "Si";
			}
			
			if(p.getEvoTrasplanteTxTorax() == null){
				data[x] [6] = "-";
			}else{
				data[x] [6] = "Si";
			}
			
			if(p.getEvoTrasplanteEcoCardio() == null){
				data[x] [7] = "-";
			}else{
				data[x] [7] = "Si";
			}
			
			if(p.getEvoTrasplanteMarvirales() == null){
				data[x] [8] = "-";
			}else{
				data[x] [8] = "Si";
			}
			if(p.getEvoTrasplantesEcodopler() == null){
				data[x] [9] = "-";
			}else{
				data[x] [9] = "Si";
			}
			if(p.getEvoTrasplantesEcografias() == null){
				data[x] [10] = "-";
			}else{
				data[x] [10] = "Si";
			}
			if(p.getEvoTrasplantesExamenes() == null){
				data[x] [11] = "-";
			}else{
				data[x] [11] = "Si";
			}
		}
	}
}
