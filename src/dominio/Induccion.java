package dominio;

import java.util.ArrayList;

import persistencia.BrkInduccion;
import persistencia.broker.basico.IPersistente;

public class Induccion implements IPersistente{

	private int id;
	private String tipo;
	private String ayudaSQL = "";
	private BrkInduccion broker = new BrkInduccion(this);
	
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
	
	public String getAyudaSQL() {
		return ayudaSQL;
	}

	public void setAyudaSQL(String ayudaSQL) {
		this.ayudaSQL = ayudaSQL;
	}
	
	public Induccion(){
		this.setId(0);
	}
	
	public void eliminar() {
		broker.eliminar();
	}

	
	public int getOid() {
		// TODO Auto-generated method stub
		return this.getId();
	}

	
	public void guardar() {
		broker.guardar();
	}

	
	public void leer() {
		this.broker.leer();
	}


	@SuppressWarnings("all")
	public ArrayList<Induccion> obtenerTodos() {
		return broker.obtenerTodos();
	}
	
	public ArrayList<Induccion> obtenerTodosCondicion(String sql){
		this.setAyudaSQL(sql);
		return this.obtenerTodos();
	}
	
	public boolean equals(Object o){
		try{
			Induccion s = (Induccion) o;
			return this.getTipo().equalsIgnoreCase(s.getTipo());
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	}
	
	
	public String toString(){
		return this.getTipo();
	}
	
	public int contar() {
		// TODO Auto-generated method stub
		return 0;
	}

}
