package uy.transplante.dominio;

import java.util.ArrayList;

import persistencia.BrkRaTratamiento;
import persistencia.broker.IPersistente;

public class RaTratamiento implements IPersistente{

	private int id;
	private String nombre;
	private BrkRaTratamiento broker = new BrkRaTratamiento(this);
	
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

	
	public int contar() {
		return broker.contar();
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
	public ArrayList<RaTratamiento> obtenerTodos() {
		return broker.obtenerTodos();
	}

	
	public boolean equals(Object obj) {
		if(obj == null)return false;
		RaTratamiento aux = (RaTratamiento) obj;
		return this.getNombre().equalsIgnoreCase(aux.getNombre());
	}

	
	public String toString() {
		return this.getNombre();
	}

	
}
