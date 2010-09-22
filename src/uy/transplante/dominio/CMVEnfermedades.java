package uy.transplante.dominio;

import java.util.ArrayList;

import persistencia.BrkCMVEmfermedades;
import persistencia.broker.basico.IPersistente;

public class CMVEnfermedades implements IPersistente{

	private int id;
	private String nombre;
	private BrkCMVEmfermedades broker = new BrkCMVEmfermedades(this);
	
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
	public ArrayList<CMVEnfermedades> obtenerTodos() {
		return broker.obtenerTodos();
	}

	
	public boolean equals(Object obj) {
		CMVEnfermedades aux = (CMVEnfermedades) obj;
		if (aux == null) return false;
		return this.nombre.equalsIgnoreCase(aux.getNombre());
	}

	
	public String toString() {
		return this.getNombre();
	}

	
}
