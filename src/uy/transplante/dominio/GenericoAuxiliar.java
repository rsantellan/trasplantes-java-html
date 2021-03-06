package uy.transplante.dominio;

import java.util.ArrayList;

import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.dominio.BrkGenericoAuxiliar;

public class GenericoAuxiliar implements IPersistente {

	public static String separador = "|";
	private int id;
	private String sentencia = "";
	private String nombre = "";
	private String tipos = "";
	private String nombres = "";
	
	private BrkGenericoAuxiliar broker = new BrkGenericoAuxiliar(this);
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSentencia() {
		return sentencia;
	}

	public void setSentencia(String sentencia) {
		this.sentencia = sentencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipos() {
		return tipos;
	}

	public void setTipos(String tipos) {
		this.tipos = tipos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	
	public int contar() {
		return 0;
	}

	
	public void eliminar() {
		broker.eliminar();
	}

	
	public int getOid() {
		return 0;
	}

	
	public void guardar() {
		broker.guardar();
	}

	
	public void leer() {

	}

	
	@SuppressWarnings("all")
	public ArrayList<GenericoAuxiliar> obtenerTodos() {
		return broker.obtenerTodos();
	}

	@Override
	public String toString() {
		return this.getNombre();
	}

	
}
