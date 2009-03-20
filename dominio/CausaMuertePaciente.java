package dominio;

import java.util.ArrayList;

import persistencia.BrkCausaMuertePaciente;
import persistencia.IPersistente;

public class CausaMuertePaciente implements IPersistente{
	
	private int id;
	private String detalle;
	private BrkCausaMuertePaciente broker = new BrkCausaMuertePaciente(this);
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
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

	
	public ArrayList<CausaMuertePaciente> obtenerTodos() {
		return broker.obtenerTodos();
	}
	
	
	public String toString(){
		return this.getDetalle();
	}
	
	
	public boolean equals(Object o){
		try{
			CausaMuertePaciente p = (CausaMuertePaciente) o;
			return this.getDetalle().equalsIgnoreCase(p.getDetalle());
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	}

	
	public int contar() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
