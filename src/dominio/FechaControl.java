package dominio;

import java.util.ArrayList;

import persistencia.BrkFechaControl;
import persistencia.broker.basico.IPersistente;

public class FechaControl implements IPersistente {

	private int id;
	private String fecha;
	private int anos;
	private int meses;
	private int dias;
	private BrkFechaControl broker = new BrkFechaControl(this);
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public FechaControl(){
		this.setId(0);
		this.setFecha("");
	}
	
	public int getAnos() {
		return anos;
	}

	public void setAnos(int anos) {
		this.anos = anos;
	}

	public int getMeses() {
		return meses;
	}

	public void setMeses(int meses) {
		this.meses = meses;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	
	public void eliminar() {
		broker.eliminar();
	}

	
	public int getOid() {
		return this.getId();
	}

	
	public void guardar() {
		broker.guardar();		
	}

	
	public void leer() {
		broker.leer();		
	}

	@SuppressWarnings("all")
	public ArrayList<FechaControl> obtenerTodos() {
		return broker.obtenerTodos();
	}
	
	
	public String toString(){
		String salida = this.getFecha() + ": ";
		if(this.getAnos() != 0){
			salida += this.getAnos() + " AÑOS";
		}
		if(this.getMeses() != 0){
			salida += ", "+ this.getMeses() + " MESES";
		}
		if(this.getDias() !=0){
			salida += ", "+this.getDias()+" DIAS.";
		}
		return salida;
	}

	
	public boolean equals(Object o){
		if(o == null)return false;
		FechaControl aux = (FechaControl) o;
		if(this.getFecha().equalsIgnoreCase(aux.getFecha())){
			return true;
		}else{
			return false;
		}
		
	}

	
	public int contar() {
		// TODO Auto-generated method stub
		return 0;
	}
}
