package uy.transplante.dominio;

import java.util.ArrayList;

import persistencia.BrkCMVDiagnostico;
import persistencia.broker.basico.IPersistente;

public class CMVDiagnostico implements IPersistente{

	private int id;
	private String nombre;
	private BrkCMVDiagnostico broker = new BrkCMVDiagnostico(this);
	
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
	public ArrayList<CMVDiagnostico> obtenerTodos() {
		return broker.obtenerTodos();
	}

	public String toString(){
		return this.getNombre();
	}

	
	public boolean equals(Object obj) {
		if(obj == null)return false;
		CMVDiagnostico aux = (CMVDiagnostico) obj;
		return this.getNombre().equalsIgnoreCase(aux.getNombre());
	}
	
	
}
