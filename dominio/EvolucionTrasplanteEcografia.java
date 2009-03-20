package dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import persistencia.BrkEvolucionTrasplanteEcografia;
import persistencia.IPersistente;

public class EvolucionTrasplanteEcografia implements IPersistente{

	private int idTrasplante;
	private Calendar fecha = new GregorianCalendar();
	private String diametros;
	private boolean dilatacion;
	private boolean litiasin;
	private String vejiga;
	private int espesor;
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

	@Override
	public int contar() {
		return broker.contar();
	}

	@Override
	public void eliminar() {
		broker.eliminar();
	}

	@Override
	public int getOid() {
		return this.contar();
	}

	@Override
	public void guardar() {
		broker.guardar();
	}

	@Override
	public void leer() {
		broker.leer();
	}

	@Override
	public ArrayList<EvolucionTrasplanteEcografia> obtenerTodos() {
		return broker.obtenerTodos();
	}

}
