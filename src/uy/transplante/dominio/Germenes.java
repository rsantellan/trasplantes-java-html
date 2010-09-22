package uy.transplante.dominio;

import java.util.ArrayList;

import persistencia.BrkGermenes;
import persistencia.broker.IPersistente;

public class Germenes implements IPersistente {

	private int id;
	private String nombre;
	private BrkGermenes broker = new BrkGermenes(this);
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Germenes(){
		this.setId(0);
		this.setNombre("");
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
	public ArrayList<Germenes> obtenerTodos() {
		return broker.obtenerTodos();
	}
	
	
	public String toString(){
		return this.getNombre();
	}
	
	public boolean equals(Object o){
		if(o == null)return false;
		Germenes aux = (Germenes) o;
		if((aux.getId() == this.getId()) && (aux.getNombre().equalsIgnoreCase(this.getNombre()))){
			return true;
		}
		return false;
	}

	
	public int contar() {
		// TODO Auto-generated method stub
		return 0;
	}

}
