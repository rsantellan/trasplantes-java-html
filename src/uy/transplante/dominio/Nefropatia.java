package uy.transplante.dominio;

import java.util.ArrayList;

import persistencia.BrkNefropatia;
import persistencia.broker.IPersistente;

public class Nefropatia implements IPersistente{
//ATRIBUTOS
	private int id;
	private String nefropatia;
	private BrkNefropatia broker = new BrkNefropatia(this);
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNefropatia() {
		return nefropatia;
	}

	public void setNefropatia(String nefropatia) {
		this.nefropatia = nefropatia;
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
	public ArrayList<Nefropatia> obtenerTodos() {
		return broker.obtenerTodos();
	}

	
	public String toString(){
		return this.getNefropatia();
	}
	
	
	public boolean equals(Object o){
		try{
			Nefropatia n = (Nefropatia) o;
			 return this.getNefropatia().equalsIgnoreCase(n.getNefropatia());
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
		
	}

	
	public int contar() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
