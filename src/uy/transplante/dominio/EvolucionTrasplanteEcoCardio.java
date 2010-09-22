package uy.transplante.dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import persistencia.BrkEvolucionTrasplanteEcoCardio;
import persistencia.broker.basico.IPersistente;

public class EvolucionTrasplanteEcoCardio implements IPersistente{
	private int idTrasplante;
	private Calendar fecha;
	private boolean feviNormal;
	private boolean insufHipodiast;
	private boolean iAo;
	private boolean eAo;
	private boolean iM;
	private boolean eM;
	private boolean iP;
	private boolean eP;
	private boolean iT;
	private boolean eT;
	private boolean derrame;
	private boolean calcifValvular;
	private boolean hvi;
	private BrkEvolucionTrasplanteEcoCardio broker = new BrkEvolucionTrasplanteEcoCardio(this);
	
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
	
	public boolean isFeviNormal() {
		return feviNormal;
	}
	public void setFeviNormal(boolean feviNormal) {
		this.feviNormal = feviNormal;
	}
	public boolean isInsufHipodiast() {
		return insufHipodiast;
	}
	public void setInsufHipodiast(boolean insufHipodiast) {
		this.insufHipodiast = insufHipodiast;
	}
	public boolean isIAo() {
		return iAo;
	}
	public void setIAo(boolean ao) {
		iAo = ao;
	}
	public boolean isEAo() {
		return eAo;
	}
	public void setEAo(boolean ao) {
		eAo = ao;
	}
	public boolean isIM() {
		return iM;
	}
	public void setIM(boolean im) {
		iM = im;
	}
	public boolean isEM() {
		return eM;
	}
	public void setEM(boolean em) {
		eM = em;
	}
	public boolean isIP() {
		return iP;
	}
	public void setIP(boolean ip) {
		iP = ip;
	}
	public boolean isEP() {
		return eP;
	}
	public void setEP(boolean ep) {
		eP = ep;
	}
	public boolean isIT() {
		return iT;
	}
	public void setIT(boolean it) {
		iT = it;
	}
	public boolean isET() {
		return eT;
	}
	public void setET(boolean et) {
		eT = et;
	}
	public boolean isDerrame() {
		return derrame;
	}
	public void setDerrame(boolean derrame) {
		this.derrame = derrame;
	}
	public boolean isCalcifValvular() {
		return calcifValvular;
	}
	public void setCalcifValvular(boolean calcifValvular) {
		this.calcifValvular = calcifValvular;
	}
	
	public boolean isHvi() {
		return hvi;
	}
	public void setHvi(boolean hvi) {
		this.hvi = hvi;
	}
	public EvolucionTrasplanteEcoCardio() {
		this.setFecha(new GregorianCalendar());
	}
	
	
	public void eliminar() {
		broker.eliminar();
	}
	
	public int getOid() {
		ArrayList<EvolucionTrasplanteEcoCardio> aux = this.obtenerTodos();
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
	public ArrayList<EvolucionTrasplanteEcoCardio> obtenerTodos() {
		return broker.obtenerTodos();
	}
	
	public int contar() {
		// TODO Auto-generated method stub
		return 0;
	}
}
