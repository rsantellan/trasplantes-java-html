package uy.transplante.dominio;

import java.util.ArrayList;

import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.dominio.BrkTrasplanteInmunosupresores;

public class TrasplanteInmunosupresoresUsado implements IPersistente{

	private Inmunosupresores inmunosupresores;
	private boolean dato;
	private int idTrasplante;
	private BrkTrasplanteInmunosupresores broker = new BrkTrasplanteInmunosupresores(this);
	

	public Inmunosupresores getInmunosupresores() {
		return inmunosupresores;
	}

	public void setInmunosupresores(Inmunosupresores inmunosupresores) {
		this.inmunosupresores = inmunosupresores;
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

	public TrasplanteInmunosupresoresUsado(){
		this.setInmunosupresores(new Inmunosupresores());
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
		this.getInmunosupresores().leer();
	}

	@SuppressWarnings("all")
	private ArrayList<TrasplanteInmunosupresoresUsado> obtenerTodosSimple() {
		return  broker.obtenerTodos();
	}
	
	public ArrayList<TrasplanteInmunosupresoresUsado> obtenerTodos() {
		ArrayList<TrasplanteInmunosupresoresUsado> salida = this.obtenerTodosSimple();
		if(salida.size()>0){
			String sql = " WHERE";
			for(int x=0;x<salida.size();x++){
				TrasplanteInmunosupresoresUsado aux = salida.get(x);
				sql += " id = " + aux.getInmunosupresores().getId();
				if(x != salida.size() - 1){
					sql += " OR";
				}
			}
			Inmunosupresores i = new Inmunosupresores();
			ArrayList<Inmunosupresores> listaInmunosupresores = i.obtenerTodosCondicion(sql); 
			for(int x=0;x<salida.size();x++){
				TrasplanteInmunosupresoresUsado aux = salida.get(x);
				boolean encontro = false;
				int y = 0;
				while(!encontro){
					Inmunosupresores s1 = (Inmunosupresores) listaInmunosupresores.get(y);
					if(s1.getId() == aux.getInmunosupresores().getId()){
						aux.setInmunosupresores(s1);
						aux.getInmunosupresores().setId(aux.getInmunosupresores().getId());
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
		return this.getInmunosupresores().toString() + " - " + this.isDato();
	}

	
	public int contar() {
		return broker.contar();
	}

}
