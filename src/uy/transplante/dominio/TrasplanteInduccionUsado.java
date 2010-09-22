package uy.transplante.dominio;

import java.util.ArrayList;

import persistencia.BrkTrasplanteInduccion;
import persistencia.broker.basico.IPersistente;

public class TrasplanteInduccionUsado implements IPersistente{

	private Induccion induccion;
	private boolean dato;
	private int idTrasplante;
	private BrkTrasplanteInduccion broker = new BrkTrasplanteInduccion(this);
	

	public Induccion getInduccion() {
		return induccion;
	}

	public void setInduccion(Induccion induccion) {
		this.induccion = induccion;
	}

	public boolean isDato() {
		return dato;
	}

	public void setDato(boolean dato) {
		this.dato = dato;
	}

	public int getIdTrasplante() {
		return idTrasplante;
	}

	public void setIdTrasplante(int idTrasplante) {
		this.idTrasplante = idTrasplante;
	}

	public TrasplanteInduccionUsado(){
		this.setInduccion(new Induccion());
	}
	
	
	public void eliminar() {
		broker.eliminar();
	}

	
	public int getOid() {
		return 0;
	}

	
	public void guardar() {
		broker.guardar();
	}

	
	public void leer() {
		broker.leer();
		this.getInduccion().leer();
	}

	@SuppressWarnings("all")
	private ArrayList<TrasplanteInduccionUsado> obtenerTodosSimple() {
		return  broker.obtenerTodos();
	}
	
	public ArrayList<TrasplanteInduccionUsado> obtenerTodos() {
		ArrayList<TrasplanteInduccionUsado> salida = this.obtenerTodosSimple();
		if(salida.size()>0){
			String sql = " WHERE";
			for(int x=0;x<salida.size();x++){
				TrasplanteInduccionUsado aux = salida.get(x);
				sql += " id = " + aux.getInduccion().getId();
				if(x != salida.size() - 1){
					sql += " OR";
				}
			}
			Induccion i = new Induccion();
			ArrayList<Induccion> listaInducciones = i.obtenerTodosCondicion(sql); 
			for(int x=0;x<salida.size();x++){
				TrasplanteInduccionUsado aux = salida.get(x);
				boolean encontro = false;
				int y = 0;
				while(!encontro){
					Induccion s1 = (Induccion) listaInducciones.get(y);
					if(s1.getId() == aux.getInduccion().getId()){
						aux.setInduccion(s1);
						aux.getInduccion().setId(aux.getInduccion().getId());
						encontro = true;
					}else{
						y += 1;
					}
				}
			}
		}
		return salida;
	}
	
	
	public String toString(){
		return this.getInduccion().toString() + " - " + this.isDato();
	}

	
	public int contar() {
		return broker.contar();
	}

}
