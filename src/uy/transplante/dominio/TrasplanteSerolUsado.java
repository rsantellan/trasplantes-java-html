package uy.transplante.dominio;

import java.util.ArrayList;

import persistencia.BrkTrasplanteSerol;
import persistencia.broker.IPersistente;

public class TrasplanteSerolUsado implements IPersistente{

	private Serol serol;
	private SerolDatos dato;
	private int idTrasplante;
	private BrkTrasplanteSerol broker = new BrkTrasplanteSerol(this);
	
	public Serol getSerol() {
		return serol;
	}

	public void setSerol(Serol serol) {
		this.serol = serol;
	}

	public SerolDatos getDato() {
		return dato;
	}

	public void setDato(SerolDatos dato) {
		this.dato = dato;
	}

	
	public int getIdTrasplante() {
		return idTrasplante;
	}

	public void setIdTrasplante(int idTrasplante) {
		this.idTrasplante = idTrasplante;
	}

	public TrasplanteSerolUsado(){
		this.setDato(new SerolDatos());
		this.setSerol(new Serol());
	}
	
	public TrasplanteSerolUsado(TrasplanteSerolUsado d){
		this.setDato(d.getDato());
		this.setSerol(d.getSerol());
		this.setIdTrasplante((d.getIdTrasplante()));
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
		this.getSerol().leer();
		this.getDato().setId(this.getSerol().getId());
	}

	@SuppressWarnings("all")
	private ArrayList<TrasplanteSerolUsado> obtenerTodosSimple() {
		return  broker.obtenerTodos();
	}
	
	public ArrayList<TrasplanteSerolUsado> obtenerTodos() {
		ArrayList<TrasplanteSerolUsado> salida = this.obtenerTodosSimple();
		if(salida.size() == 0){
			return salida;
		}
		String sql = " WHERE";
		for(int x=0;x<salida.size();x++){
			TrasplanteSerolUsado aux = salida.get(x);
			sql += " id = " + aux.getSerol().getId();
			if(x != salida.size() - 1){
				sql += " OR";
			}
		}
		Serol s = new Serol();
		ArrayList<Serol> listaSeroles = s.obtenerTodosCondicion(sql); 
		for(int x=0;x<salida.size();x++){
			TrasplanteSerolUsado aux = salida.get(x);
			boolean encontro = false;
			int y = 0;
			while(!encontro){
				Serol s1 = (Serol) listaSeroles.get(y);
				if(s1.getId() == aux.getSerol().getId()){
					aux.setSerol(s1);
					aux.getDato().setId(aux.getSerol().getId());
					encontro = true;
				}else{
					y += 1;
				}
			}
		}
		return salida;
	}
	
	
	public String toString(){
		return this.getSerol().toString() + " - " + this.getDato().toString();
	}

	
	public int contar() {
		return broker.contar();
	}

}
