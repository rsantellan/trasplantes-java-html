package dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import persistencia.BrkEvolucionTrasplanteCMV;
import persistencia.IPersistente;

public class EvolucionTrasplanteCMV implements IPersistente{
	private int idTrasplante;
	private Calendar fecha;
	private boolean IgG_CMV;
	private boolean IgM_CMV;
	private boolean PCR_CMV;
	private boolean Ag_pp65;
	private BrkEvolucionTrasplanteCMV broker = new BrkEvolucionTrasplanteCMV(this);
	
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
	public boolean isIgG_CMV() {
		return IgG_CMV;
	}
	public void setIgG_CMV(boolean igG_CMV) {
		IgG_CMV = igG_CMV;
	}
	public boolean isIgM_CMV() {
		return IgM_CMV;
	}
	public void setIgM_CMV(boolean igM_CMV) {
		IgM_CMV = igM_CMV;
	}
	public boolean isPCR_CMV() {
		return PCR_CMV;
	}
	public void setPCR_CMV(boolean pcr_cmv) {
		PCR_CMV = pcr_cmv;
	}
	public boolean isAg_pp65() {
		return Ag_pp65;
	}
	public void setAg_pp65(boolean ag_pp65) {
		Ag_pp65 = ag_pp65;
	}
	
	public EvolucionTrasplanteCMV() {
		this.setFecha(new GregorianCalendar());
	}
	
	
	public void eliminar() {
		broker.eliminar();
	}
	
	public int getOid() {
		ArrayList<EvolucionTrasplanteCMV> aux = this.obtenerTodos();
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
	
	public ArrayList<EvolucionTrasplanteCMV> obtenerTodos() {
		return broker.obtenerTodos();
	}
	
	public int contar() {
		// TODO Auto-generated method stub
		return 0;
	}
}
