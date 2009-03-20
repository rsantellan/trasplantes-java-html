package dominio;

import java.util.ArrayList;

import persistencia.BrkTrasplanteTiposComplicaciones;
import persistencia.IPersistente;

public class TrasplanteTiposComplicaciones implements IPersistente {

	private int id;
	private String tipo;
	private String nombre;
	private BrkTrasplanteTiposComplicaciones broker = new BrkTrasplanteTiposComplicaciones(this);
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	
	public ArrayList<TrasplanteTiposComplicaciones> obtenerTodos() {
		return broker.obtenerTodos();
	}
	
	public boolean equals(Object o){
		try{
			TrasplanteTiposComplicaciones s = (TrasplanteTiposComplicaciones) o;
			return this.getTipo().equalsIgnoreCase(s.getTipo()) && this.getNombre().equalsIgnoreCase(s.getNombre());
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	}
	
	
	public String toString(){
		return this.getTipo() + " - "+ this.getNombre();
	}

	
	public int contar() {
		// TODO Auto-generated method stub
		return 0;
	}
}
