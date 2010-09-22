package uy.transplante.dominio;

import java.util.ArrayList;

import persistencia.BrkGenerico;
import persistencia.broker.IPersistente;

public class Generico implements IPersistente {

	private String sql;
	private ArrayList<Object> listaObtenida = new ArrayList<Object>();
	private ArrayList<String> listaDada = new ArrayList<String>();
	private ArrayList<String> listaNombre = new ArrayList<String>();
	private BrkGenerico broker = new BrkGenerico(this);
	
	public static String letras = "getString";
	public static String character = "getChar";
	public static String integer = "getInt";
	public static String VF = "getBoolean";
	public static String fechas = "getDATE";
	public static String FLOAT = "getFloat";
	
	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public ArrayList<Object> getListaObtenida() {
		return listaObtenida;
	}

	public void setListaObtenida(ArrayList<Object> listaObtenida) {
		this.listaObtenida = listaObtenida;
	}

	public ArrayList<String> getListaDada() {
		return listaDada;
	}

	public void setListaDada(ArrayList<String> listaDada) {
		this.listaDada = listaDada;
	}

	public ArrayList<String> getListaNombre() {
		return listaNombre;
	}

	public void setListaNombre(ArrayList<String> listaNombre) {
		this.listaNombre = listaNombre;
	}

	
	public int contar() {
		return 0;
	}

	
	public void eliminar() {

	}

	
	public int getOid() {
		return 0;
	}

	
	public void guardar() {
		broker.guardar();
	}

	
	public void leer() {
		broker.leer();
	}

	
	public ArrayList<Generico> obtenerTodos() {
		return null;
	}

}
