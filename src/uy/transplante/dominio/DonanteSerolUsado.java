package uy.transplante.dominio;

import java.util.ArrayList;

import persistencia.BrkDonanteSerol;
import persistencia.broker.IPersistente;

public class DonanteSerolUsado implements IPersistente{

	private Serol serol;
	private SerolDatos dato;
	private String idDonante;
	private BrkDonanteSerol broker = new BrkDonanteSerol(this);
	
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

	
	public String getIdDonante() {
		return idDonante;
	}

	public void setIdDonante(String idDonante) {
		this.idDonante = idDonante;
	}

	public DonanteSerolUsado(){
		this.setDato(new SerolDatos());
		this.setSerol(new Serol());
	}
	
	public DonanteSerolUsado(DonanteSerolUsado d){
		this.setDato(d.getDato());
		this.setSerol(d.getSerol());
		this.setIdDonante(d.getIdDonante());
	}
	
	
	public void eliminar() {
		broker.eliminar();
	}

	
	public int getOid() {
		return 0;
	}

	
	public void guardar() {
/*		DonanteSerolUsado aux = new DonanteSerolUsado();
		aux.setIdDonante(this.getIdDonante());
		aux.getSerol().setId(this.getSerol().getId());
		aux.leer();
		if(aux.getDato().getTipo().equalsIgnoreCase(this.getDato().getTipo())){
			broker.eliminar();
		}
*/		broker.guardar();
	}

	
	public void leer() {
		broker.leer();
		this.getSerol().leer();
		this.getDato().setId(this.getSerol().getId());
	}

	@SuppressWarnings("all")
	private ArrayList<DonanteSerolUsado> obtenerTodosSimple() {
		return  broker.obtenerTodos();
	}
	
	public ArrayList<DonanteSerolUsado> obtenerTodos() {
		ArrayList<DonanteSerolUsado> salida = obtenerTodosSimple();
		if(salida.size() == 0) return salida;
		String sql = " WHERE";
		for(int x=0;x<salida.size();x++){
			DonanteSerolUsado aux = salida.get(x);
			sql += " id = " + aux.getSerol().getId();
			if(x != salida.size() - 1){
				sql += " OR";
			}
		}
		Serol s = new Serol();
		ArrayList<Serol> listaSeroles = s.obtenerTodosCondicion(sql); 
		for(int x=0;x<salida.size();x++){
			DonanteSerolUsado aux = salida.get(x);
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
	
	public ArrayList<DonanteSerolUsado> obtenerLista(ArrayList<Serol> listaSeroles){
		if(listaSeroles==null) return null;
		ArrayList<DonanteSerolUsado> salida = obtenerTodosSimple();
		for(int x=0;x<salida.size();x++){
			boolean encontro = false;
			int y=0;
			DonanteSerolUsado auxDo = (DonanteSerolUsado) salida.get(x);
			while(y<listaSeroles.size() && !encontro){
				Serol aux = listaSeroles.get(y);
				if(aux.getId() == auxDo.getSerol().getId()){
					auxDo.setSerol(aux);
					auxDo.getDato().setId(aux.getId());
					encontro = true;
				}
				y++;
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
