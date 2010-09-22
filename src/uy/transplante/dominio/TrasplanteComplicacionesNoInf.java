package uy.transplante.dominio;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import uy.transplante.auxiliares.fechas.ManejoFechas;

import persistencia.BrkTrasplanteComplicacionesNoInf;
import persistencia.broker.basico.IPersistente;

public class TrasplanteComplicacionesNoInf extends TrasplanteComplicaciones implements IPersistente{

	private int idComplicacionTipos;
	private TrasplanteTiposComplicaciones complicacion;
	private boolean nuevo = false;
	private boolean borradoTotal = false;
	private BrkTrasplanteComplicacionesNoInf broker = new BrkTrasplanteComplicacionesNoInf(this);
	
	public int getIdComplicacionTipos() {
		return idComplicacionTipos;
	}

	public void setIdComplicacionTipos(int idComplicacionTipos) {
		this.idComplicacionTipos = idComplicacionTipos;
	}


	
	public TrasplanteTiposComplicaciones getComplicacion() {
		return complicacion;
	}

	public void setComplicacion(TrasplanteTiposComplicaciones complicacion) {
		this.complicacion = complicacion;
	}

	public boolean isBorradoTotal() {
		return borradoTotal;
	}

	public void setBorradoTotal(boolean borradoTotal) {
		this.borradoTotal = borradoTotal;
	}

	public TrasplanteComplicacionesNoInf(){
		this.setIdComplicacionTipos(-1);
		this.setComplicacion(new TrasplanteTiposComplicaciones());
		this.setFecha(new GregorianCalendar());
	}
	
	
	public void eliminar() {
		broker.eliminar();
		super.eliminar();
	}

	
	public int getOid() {
		if(this.nuevo){
			return 0;
		}
		return this.getId();
	}

	
	public void guardar() {
		this.setNumMedicacion(this.getMedicacion().getId());
		this.setIdComplicacionTipos(this.getComplicacion().getId());
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
		this.getComplicacion().setId(this.getIdComplicacionTipos());
		this.getComplicacion().leer();
	}

/*	private void leerNoInf(){
		broker.leer();
	}*/
	
	private void leerNoInfeccion(){
		super.leer();
		this.getComplicacion().setId(this.getIdComplicacionTipos());
		this.getComplicacion().leer();
	}
	
	@SuppressWarnings("all")
	public ArrayList obtenerTodos() {
		ArrayList<TrasplanteComplicacionesNoInf> salida = this.obtenerTodosBusqueda();
		for(int x=0;x<salida.size();x++){
			TrasplanteComplicacionesNoInf aux = salida.get(x);
			aux.setEvolucion(this.isEvolucion());
			aux.leerNoInfeccion();
		}
		return salida;
	}

	@SuppressWarnings("all")
	public ArrayList<TrasplanteComplicacionesNoInf> obtenerTodosBusqueda(){
		return broker.obtenerTodos();
	}
	
	public boolean esInfeccion() {
		return false;
	}

	public int contarTipoInfeccion(){
		return broker.contar();
	}
	
	public int contar() {
		return super.contar();
	}

	public void borradoTotal(){
		this.setBorradoTotal(true);
		broker.eliminar();
		TrasplanteComplicacionesInf aux = new TrasplanteComplicacionesInf();
		aux.setIdPretrasplante(this.getIdPretrasplante());
		aux.borradoTotal();
		this.setEvolucion(true);
		super.eliminar();
		this.setEvolucion(false);
		super.eliminar();
	}

	@Override
	public String toString() {
		String salida = "";
		if(this.isEvolucion()){
			salida = "Evolucion: ";
		}else{
			salida = "Internado: ";
		}
		salida += ManejoFechas.FORMATOESPANOL.format(this.getFecha().getTime()) + " - " + this.getComplicacion().getNombre() + "," + this.getComplicacion().getTipo();
		return salida;
	}
	
	
}
