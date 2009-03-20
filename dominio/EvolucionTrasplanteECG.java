package dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import persistencia.BrkEvolucionTrasplanteECG;
import persistencia.IPersistente;

public class EvolucionTrasplanteECG implements IPersistente{
	private int idTrasplante;
	private Calendar fecha;
	private String rs;
	private String hvi;
	private String ondaQ;

	private BrkEvolucionTrasplanteECG broker = new BrkEvolucionTrasplanteECG(this);
	
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
	
	public String getRs() {
		return rs;
	}
	public void setRs(String rs) {
		this.rs = rs;
	}
	public String getHvi() {
		return hvi;
	}
	public void setHvi(String hvi) {
		this.hvi = hvi;
	}
	public String getOndaQ() {
		return ondaQ;
	}
	public void setOndaQ(String ondaQ) {
		this.ondaQ = ondaQ;
	}
	public EvolucionTrasplanteECG() {
		this.setFecha(new GregorianCalendar());
	}
	
	
	public void eliminar() {
		broker.eliminar();
	}
	
	public int getOid() {
		ArrayList<EvolucionTrasplanteECG> aux = this.obtenerTodos();
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
	
	public ArrayList<EvolucionTrasplanteECG> obtenerTodos() {
		return broker.obtenerTodos();
	}
	
	public int contar() {
		// TODO Auto-generated method stub
		return 0;
	}
}
