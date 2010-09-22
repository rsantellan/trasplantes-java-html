package uy.transplante.dominio;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import uy.transplante.auxiliares.fechas.ManejoFechas;

import persistencia.BrkTrasplanteComplicacionesInf;
import persistencia.broker.IPersistente;

public class TrasplanteComplicacionesInf extends TrasplanteComplicaciones implements IPersistente{
	
	private Infeccion infeccion = new Infeccion();
	private Germenes germen = new Germenes();
	private boolean nuevo = false;
	private boolean borradoTotal = false;
	private BrkTrasplanteComplicacionesInf broker = new BrkTrasplanteComplicacionesInf(this);
	
	public Infeccion getInfeccion() {
		return infeccion;
	}

	public void setInfeccion(Infeccion infeccion) {
		this.infeccion = infeccion;
	}

	public Germenes getGermen() {
		return germen;
	}

	public void setGermen(Germenes germen) {
		this.germen = germen;
	}

	public boolean isBorradoTotal() {
		return borradoTotal;
	}

	public void setBorradoTotal(boolean borradoTotal) {
		this.borradoTotal = borradoTotal;
	}
	
	public TrasplanteComplicacionesInf(){
		this.setFecha(new GregorianCalendar());
	}
	
	
	public void eliminar() {
		super.eliminar();
		broker.eliminar();
	}

	
	public int getOid() {
		if(this.nuevo){
			return 0;
		}
		return this.getId();
	}

	
	public void guardar() {
		this.setNumMedicacion(this.getMedicacion().getId());
		super.guardar();
		if(this.getId()==0){
			this.nuevo = true;	
		}
		super.leer();
		broker.guardar();	
	}

	
	public void leer() {
		super.leer();
		broker.leer();
		this.getGermen().leer();
		this.getInfeccion().leer();
	}

	private void leerInfeccion(){
		super.leer();
		this.getGermen().leer();
		this.getInfeccion().leer();
	}
	
	@SuppressWarnings("all")
	public ArrayList obtenerTodos() {
		ArrayList<TrasplanteComplicacionesInf> salida = this.obtenerTodosBusqueda();
		for(int x=0;x<salida.size();x++){
			TrasplanteComplicacionesInf aux = salida.get(x);
			aux.setEvolucion(this.isEvolucion());
			aux.leerInfeccion();
		}
		return salida;
	}

	@SuppressWarnings("all")
	public ArrayList<TrasplanteComplicacionesInf> obtenerTodosBusqueda() {
		return  broker.obtenerTodos();
	}
	
	@SuppressWarnings("all")
	public ArrayList<TrasplanteComplicacionesInf> devolverTodos(){
		return this.obtenerTodos();
	}
	
	public boolean esInfeccion() {
		return true;
	}

	
	public int contar() {
		return broker.contar();
	}
	
	public void borradoTotal(){
		this.setBorradoTotal(true);
		broker.eliminar();
	}

	@Override
	public String toString() {
		String salida = "";
		if(this.isEvolucion()){
			salida = "Evolucion: ";
		}else{
			salida = "Internado: ";
		}
		salida += ManejoFechas.FORMATOESPANOL.format(this.getFecha().getTime()) + " - " + this.getInfeccion();
		return salida;
	}
	
	
}
