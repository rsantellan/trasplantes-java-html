package dominio;

import java.util.ArrayList;

import persistencia.BrkGenerico;
import persistencia.IPersistente;

public class Generico implements IPersistente {

	private String sql;
	private ArrayList<Object> listaObtenida = new ArrayList<Object>();
	private ArrayList<String> listaDada = new ArrayList<String>();
	private ArrayList<String> listaNombre = new ArrayList<String>();
	private BrkGenerico broker = new BrkGenerico(this);
	
	public static String letras = "getString";
	public static String letra = "getChar";
	public static String integer = "getInt";
	public static String VF = "getBoolean";
	public static String fechas = "getDATE";
	public static String Float = "getFloat";
	
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

	@Override
	public int contar() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getOid() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void guardar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void leer() {
		broker.leer();

	}

	@Override
	public ArrayList<Generico> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
