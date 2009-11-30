package dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import persistencia.BrkEvolucionTrasplanteTxTorax;
import persistencia.broker.basico.IPersistente;

public class EvolucionTrasplanteTxTorax implements IPersistente{
	private int idTrasplante;
	private Calendar fecha;
	private int rct;
	private boolean foco;
	private String lateralizado;
	private boolean derramePleural;
	private String lateralDerrame;
	private boolean secuelas;
	private String otros;


	private BrkEvolucionTrasplanteTxTorax broker = new BrkEvolucionTrasplanteTxTorax(this);
	
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
	
	public int getRct() {
		return rct;
	}
	public void setRct(int rct) {
		this.rct = rct;
	}
	public boolean isFoco() {
		return foco;
	}
	public void setFoco(boolean foco) {
		this.foco = foco;
	}
	public String getLateralizado() {
		return lateralizado;
	}
	public void setLateralizado(String lateralizado) {
		this.lateralizado = lateralizado;
	}
	public boolean isDerramePleural() {
		return derramePleural;
	}
	public void setDerramePleural(boolean derramePleural) {
		this.derramePleural = derramePleural;
	}
	public String getLateralDerrame() {
		return lateralDerrame;
	}
	public void setLateralDerrame(String lateralDerrame) {
		this.lateralDerrame = lateralDerrame;
	}
	public boolean isSecuelas() {
		return secuelas;
	}
	public void setSecuelas(boolean secuelas) {
		this.secuelas = secuelas;
	}
	public String getOtros() {
		return otros;
	}
	public void setOtros(String otros) {
		this.otros = otros;
	}
	public EvolucionTrasplanteTxTorax() {
		this.setFecha(new GregorianCalendar());
	}
	
	
	public void eliminar() {
		broker.eliminar();
	}
	
	public int getOid() {
		ArrayList<EvolucionTrasplanteTxTorax> aux = this.obtenerTodos();
		if(aux.size()>0){
			return 1;
		}
		return 0;
	}
	
	public void guardar() {
		broker.guardar();
	}
	
	public void leer() {
		broker.leer();
	}
	
	@SuppressWarnings("all")
	public ArrayList<EvolucionTrasplanteTxTorax> obtenerTodos() {
		return broker.obtenerTodos();
	}
	
	public int contar() {
		// TODO Auto-generated method stub
		return 0;
	}
}
