package dominio;

import java.util.ArrayList;

import persistencia.BrkMedicacion;
import persistencia.IPersistente;

public class Medicacion implements IPersistente {

	private int id;
	private String nombre;
	private BrkMedicacion broker = new BrkMedicacion(this);
	
	
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

	public Medicacion(){
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

	
	public ArrayList<Medicacion> obtenerTodos() {
		return broker.obtenerTodos();
	}
	
	
	public String toString(){
		return this.getNombre();
	}

	
	public boolean equals(Object o){
		Medicacion aux = (Medicacion) o;
		if(this.getNombre().equalsIgnoreCase(aux.getNombre())){
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
