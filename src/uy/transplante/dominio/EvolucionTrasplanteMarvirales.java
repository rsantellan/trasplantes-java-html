package uy.transplante.dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import persistencia.BrkEvolucionTrasplanteMarvirales;
import persistencia.broker.IPersistente;

public class EvolucionTrasplanteMarvirales implements IPersistente{
	private int idTrasplante;
	private Calendar fecha;
	private boolean hsv;
	private String aghbs;
	private String hbsac;
	private String hbcac;
	private String hvc;
	private String hiv;

	private BrkEvolucionTrasplanteMarvirales broker = new BrkEvolucionTrasplanteMarvirales(this);
	
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
	
	public boolean isHsv() {
		return hsv;
	}
	public void setHsv(boolean hsv) {
		this.hsv = hsv;
	}
	public String getAghbs() {
		return aghbs;
	}
	public void setAghbs(String aghbs) {
		this.aghbs = aghbs;
	}
	public String getHbsac() {
		return hbsac;
	}
	public void setHbsac(String hbsac) {
		this.hbsac = hbsac;
	}
	public String getHbcac() {
		return hbcac;
	}
	public void setHbcac(String hbcac) {
		this.hbcac = hbcac;
	}
	public String getHvc() {
		return hvc;
	}
	public void setHvc(String hvc) {
		this.hvc = hvc;
	}
	public String getHiv() {
		return hiv;
	}
	public void setHiv(String hiv) {
		this.hiv = hiv;
	}
	public EvolucionTrasplanteMarvirales() {
		this.setFecha(new GregorianCalendar());
	}
	
	
	public void eliminar() {
		broker.eliminar();
	}
	
	public int getOid() {
		ArrayList<EvolucionTrasplanteMarvirales> aux = this.obtenerTodos();
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
	public ArrayList<EvolucionTrasplanteMarvirales> obtenerTodos() {
		return broker.obtenerTodos();
	}
	
	public int contar() {
		// TODO Auto-generated method stub
		return 0;
	}
}
