package auxiliares;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import dominio.TrasplanteComplicacionesNoInf;

public class ModeloDatosListaComplicacionesNoInf extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Nombres de los campos
	private String[] columnNames =  {"Fecha", "Medicacion","Internado","Dias de internacion","Tipo complicacion","Nombre"};
	private String data[][];

	public int numColumns = columnNames.length;
	public int numRows;
	private ArrayList<TrasplanteComplicacionesNoInf> datos;

	public ModeloDatosListaComplicacionesNoInf(ArrayList<TrasplanteComplicacionesNoInf> p){
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
			TrasplanteComplicacionesNoInf p = this.datos.get(x);
			data[x] [0] = ManejoFechas.formatoEspanol.format(p.getFecha().getTime());
			data[x] [1] = p.getMedicacion().getNombre();
			if(p.isInternado()){
				data[x] [2] = "Si";
				data[x] [3] = Integer.toString(p.getDiasInternado());
			}else{
				data[x] [2] = "No";
				data[x] [3] = " - ";
			}
			data[x] [4] = p.getComplicacion().getTipo();
			data[x] [5] = p.getComplicacion().getNombre();
		}
	}
}
