package uy.transplante.dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import persistencia.BrkEvolucionTrasplanteEcografia;
import persistencia.broker.basico.IPersistente;

public class EvolucionTrasplanteEcografia implements IPersistente{

	private int idTrasplante;
	private Calendar fecha = new GregorianCalendar();
	private String diametros;
	private boolean dilatacion;
	private boolean litiasin;
	private String vejiga;
	private int espesor;
	private String otros;
	private BrkEvolucionTrasplanteEcografia broker = new BrkEvolucionTrasplanteEcografia(this);
	
	public int getIdTrasplante() {
		return idTrasplante;
	}

	public void setIdTrasplante(int idTrasplante) {
		this.idTrasplante = idTrasplante;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public String getDiametros() {
		return diametros;
	}

	public void setDiametros(String diametros) {
		this.diametros = diametros;
	}

	public boolean isDilatacion() {
		return dilatacion;
	}

	public void setDilatacion(boolean dilatacion) {
		this.dilatacion = dilatacion;
	}

	public boolean isLitiasin() {
		return litiasin;
	}

	public void setLitiasin(boolean litiasin) {
		this.litiasin = litiasin;
	}

	public String getVejiga() {
		return vejiga;
	}

	public void setVejiga(String vejiga) {
		this.vejiga = vejiga;
	}

	public int getEspesor() {
		return espesor;
	}

	public void setEspesor(int espesor) {
		this.espesor = espesor;
	}

	/**
	 * @return the otros
	 */
	public String getOtros() {
		return otros;
	}

	/**
	 * @param otros the otros to set
	 */
	public void setOtros(String otros) {
		this.otros = otros;
	}

	public int contar() {
		return broker.contar();
	}

	
	public void eliminar() {
		broker.eliminar();
	}

	
	public int getOid() {
		return this.contar();
	}

	
	public void guardar() {
		broker.guardar();
	}

	
	public void leer() {
		broker.leer();
	}

	@SuppressWarnings("all")
	public ArrayList<EvolucionTrasplanteEcografia> obtenerTodos() {
		return broker.obtenerTodos();
	}

}
