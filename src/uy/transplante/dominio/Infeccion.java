package uy.transplante.dominio;

import java.util.ArrayList;

import persistencia.BrkInfeccion;
import persistencia.broker.basico.IPersistente;

public class Infeccion implements IPersistente {

	private int id;
	private String nombre;
	private BrkInfeccion broker = new BrkInfeccion(this);
	
	
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

	public Infeccion(){
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
	public ArrayList<Infeccion> obtenerTodos() {
		return broker.obtenerTodos();
	}
	
	
	public String toString(){
		return this.getNombre();
	}
	
	
	public boolean equals(Object o){
		if(o == null)return false;
		Infeccion aux = (Infeccion)o;
		if(aux.getId()==this.getId() && aux.getNombre().equalsIgnoreCase(this.getNombre())){
			return true;
		}
		return false;
	}

	
	public int contar() {
		// TODO Auto-generated method stub
		return 0;
	}

}
