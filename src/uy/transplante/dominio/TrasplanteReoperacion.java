package uy.transplante.dominio;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import persistencia.BrkTrasplanteReoperacion;
import persistencia.broker.basico.IPersistente;
import uy.transplante.auxiliares.fechas.ManejoFechas;

public class TrasplanteReoperacion implements IPersistente{

	private int idTrasplante;
	private Calendar fecha;
	private int numComplicacion;
	private TrasplanteComplicaciones complicacion;
	private String comentario;
	private BrkTrasplanteReoperacion broker = new BrkTrasplanteReoperacion(this);
	
	
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

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getNumComplicacion() {
		return numComplicacion;
	}

	public void setNumComplicacion(int numComplicacion) {
		this.numComplicacion = numComplicacion;
	}

	public TrasplanteComplicaciones getComplicacion() {
		return complicacion;
	}

	public void setComplicacion(TrasplanteComplicaciones complicacion) {
		this.complicacion = complicacion;
	}

	public TrasplanteReoperacion(){
		this.setFecha(new GregorianCalendar());
		try {
			this.getFecha().setTime(ManejoFechas.FORMATOESPANOL.parse("1900-01-01"));
		} catch (ParseException e) {

		}
	}
	
	public void eliminar() {
		broker.eliminar();
	}

	
	public int getOid() {
		return broker.contar();
	}

	
	public void guardar() {
		broker.guardar();		
	}

	
	public void leer() {
		broker.leer();
		TrasplanteComplicacionesNoInf noInf = new TrasplanteComplicacionesNoInf();
		noInf.setId(this.getNumComplicacion());
		if(noInf.contarTipoInfeccion() > 0){
			noInf.leer();
			this.setComplicacion(noInf);
		}else{
			TrasplanteComplicacionesInf inf = new TrasplanteComplicacionesInf();
			inf.setId(this.getNumComplicacion());
			inf.leer();
			this.setComplicacion(inf);
		}
	}

	
	@SuppressWarnings("all")
	public ArrayList<TrasplanteReoperacion> obtenerTodos() {
		ArrayList<TrasplanteReoperacion> salida =  broker.obtenerTodos();
		for(int x=0;x<salida.size();x++){
			TrasplanteReoperacion aux = salida.get(x);
			TrasplanteComplicacionesNoInf noInf = new TrasplanteComplicacionesNoInf();
			noInf.setId(aux.getNumComplicacion());
			if(noInf.contarTipoInfeccion() > 0){
				noInf.leer();
				aux.setComplicacion(noInf);
			}else{
				TrasplanteComplicacionesInf inf = new TrasplanteComplicacionesInf();
				inf.setId(aux.getNumComplicacion());
				inf.leer();
				aux.setComplicacion(inf);
			}
		}
		return salida;
	}
	
	
	public String toString(){
		if(this.getFecha() != null){
			return ManejoFechas.FORMATOESPANOL.format(this.getFecha().getTime());
		}else{
			return "-";
		}
		
	}

	
	public int contar() {
		// TODO Auto-generated method stub
		return 0;
	}

}
