package uy.transplante.dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import persistencia.BrkEvolucionTrasplanteEcoDopler;
import persistencia.broker.basico.IPersistente;

public class EvolucionTrasplanteEcoDopler implements IPersistente{
	private int idTrasplante;
	private Calendar fecha;
	private String estructura;
	private boolean dilatacion;
	private boolean colecciones;
	private String ejeArterial;
	private String ejeVenoso;
	private String arteriaRenal;
	private String venaRenal;
	private String anastVenosa;
	private String anastRenosa;
	private double indiceResistencia;
	private String otros = "";
	public static String BIEN = "Bien";
	public static String MAL = "Mal";
	private BrkEvolucionTrasplanteEcoDopler broker = new BrkEvolucionTrasplanteEcoDopler(this);
	
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
	
	public String getEstructura() {
		return estructura;
	}
	public void setEstructura(String estructura) {
		this.estructura = estructura;
	}
	public boolean isDilatacion() {
		return dilatacion;
	}
	public void setDilatacion(boolean dilatacion) {
		this.dilatacion = dilatacion;
	}
	public boolean isColecciones() {
		return colecciones;
	}
	public void setColecciones(boolean colecciones) {
		this.colecciones = colecciones;
	}
	public String getEjeArterial() {
		return ejeArterial;
	}
	public void setEjeArterial(String ejeArterial) {
		this.ejeArterial = ejeArterial;
	}
	public String getEjeVenoso() {
		return ejeVenoso;
	}
	public void setEjeVenoso(String ejeVenoso) {
		this.ejeVenoso = ejeVenoso;
	}
	public String getArteriaRenal() {
		return arteriaRenal;
	}
	public void setArteriaRenal(String arteriaRenal) {
		this.arteriaRenal = arteriaRenal;
	}
	public String getVenaRenal() {
		return venaRenal;
	}
	public void setVenaRenal(String venaRenal) {
		this.venaRenal = venaRenal;
	}
	public String getAnastVenosa() {
		return anastVenosa;
	}
	public void setAnastVenosa(String anastVenosa) {
		this.anastVenosa = anastVenosa;
	}
	public String getAnastRenosa() {
		return anastRenosa;
	}
	public void setAnastRenosa(String anastRenosa) {
		this.anastRenosa = anastRenosa;
	}
	public double getIndiceResistencia() {
		return indiceResistencia;
	}
	public void setIndiceResistencia(double indiceResistencia) {
		this.indiceResistencia = indiceResistencia;
	}
	public EvolucionTrasplanteEcoDopler() {
		this.setFecha(new GregorianCalendar());
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
	public ArrayList<EvolucionTrasplanteEcoDopler> obtenerTodos() {
		return broker.obtenerTodos();
	}
	
	public int contar() {
		return broker.contar();
	}
}
