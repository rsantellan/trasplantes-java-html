package uy.transplante.dominio;

import java.util.ArrayList;
import java.util.Calendar;

import persistencia.BrkPerdidaInjerto;
import persistencia.broker.IPersistente;
import uy.transplante.auxiliares.fechas.ManejoFechas;

public class PacientePerdidaInjerto implements IPersistente{

	private int the;
	private Calendar fechaPerdida;
	private CausaPerdidaInjerto causa;
	private int numCausa;
	private int numPreTrasplante;
	private boolean buscarNumCausas = false;
	private BrkPerdidaInjerto broker = new BrkPerdidaInjerto(this);
	
	public int getThe() {
		return the;
	}

	public void setThe(int the) {
		this.the = the;
	}

	public Calendar getFechaPerdida() {
		return fechaPerdida;
	}

	public void setFechaPerdida(Calendar fechaPerdida) {
		this.fechaPerdida = fechaPerdida;
	}

	public CausaPerdidaInjerto getCausa() {
		return causa;
	}

	public void setCausa(CausaPerdidaInjerto causa) {
		this.causa = causa;
	}

	public int getNumCausa() {
		return numCausa;
	}

	public void setNumCausa(int numCausa) {
		this.numCausa = numCausa;
	}

	public boolean isBuscarNumCausas() {
		return buscarNumCausas;
	}

	private void setBuscarNumCausas(boolean buscarNumCausas) {
		this.buscarNumCausas = buscarNumCausas;
	}

	public int getNumPreTrasplante() {
		return numPreTrasplante;
	}

	public void setNumPreTrasplante(int numPreTrasplante) {
		this.numPreTrasplante = numPreTrasplante;
	}

	public PacientePerdidaInjerto(){
		
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
		CausaPerdidaInjerto causa = new CausaPerdidaInjerto();
		causa.setId(this.getNumCausa());
		causa.leer();
		this.setCausa(causa);
	}

	@SuppressWarnings("all")
	public ArrayList<PacientePerdidaInjerto> obtenerTodos() {
		ArrayList<PacientePerdidaInjerto> salida = broker.obtenerTodos();
		for(int x=0;x<salida.size();x++){
			PacientePerdidaInjerto m = (PacientePerdidaInjerto) salida.get(x);
			CausaPerdidaInjerto causa = new CausaPerdidaInjerto();
			causa.setId(m.getNumCausa());
			causa.leer();
			m.setCausa(causa);
		}
		return salida;
	}

	
	public String toString(){
		return ManejoFechas.FORMATOESPANOL.format(this.getFechaPerdida().getTime()); 
	}
	
	
	public boolean equals(Object o){
		try{
			PacientePerdidaInjerto m = (PacientePerdidaInjerto) o;
			return (this.getThe() == m.getThe());
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	}

	public int contarNumCausas(){
		this.setBuscarNumCausas(true);
		return this.contar();
	}
	public int contar() {
		return broker.contar();
	}
}
