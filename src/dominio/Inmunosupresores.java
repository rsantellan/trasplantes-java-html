package dominio;

import java.util.ArrayList;

import persistencia.BrkInmunosupresores;
import persistencia.IPersistente;

public class Inmunosupresores implements IPersistente{

	private int id;
	private String tipo;
	private String ayudaSQL = "";
	private BrkInmunosupresores broker = new BrkInmunosupresores(this);
	
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
	
	public Inmunosupresores(){
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
	public ArrayList<Inmunosupresores> obtenerTodos() {
		return broker.obtenerTodos();
	}
	
	public ArrayList<Inmunosupresores> obtenerTodosCondicion(String sql){
		this.setAyudaSQL(sql);
		return this.obtenerTodos();
	}
	
	public boolean equals(Object o){
		try{
			Inmunosupresores s = (Inmunosupresores) o;
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
