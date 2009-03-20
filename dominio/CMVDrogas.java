package dominio;

import java.util.ArrayList;

import persistencia.BrkCMVDrogas;
import persistencia.IPersistente;

public class CMVDrogas implements IPersistente{

	private int id;
	private String nombre;
	private BrkCMVDrogas broker = new BrkCMVDrogas(this);
	
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

	
	public ArrayList<CMVDrogas> obtenerTodos() {
		return broker.obtenerTodos();
	}
	
	public String toString(){
		return this.getNombre();
	}

}
