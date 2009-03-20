package dominio;

import java.util.ArrayList;

import persistencia.BrkCausaMuerteDonante;
import persistencia.IPersistente;

public class CausaMuerteDonante implements IPersistente{
	
	private int id;
	private String detalle;
	private BrkCausaMuerteDonante broker = new BrkCausaMuerteDonante(this);
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	
	public void eliminar() {
		broker.eliminar();
	}

	
	public int getOid() {
		return this.getId();
	}

	
	public void guardar() {
		broker.guardar();
	}

	
	public void leer() {
		broker.leer();
	}

	
	public ArrayList<CausaMuerteDonante> obtenerTodos() {
		return broker.obtenerTodos();
	}
	
	
	public String toString(){
		return this.getDetalle();
	}
	
	
	public boolean equals(Object o){
		try{
			CausaMuerteDonante p = (CausaMuerteDonante) o;
			return this.getDetalle().equalsIgnoreCase(p.getDetalle());
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	}

	public static CausaMuerteDonante devolverCausa(ArrayList<CausaMuerteDonante> lista, int id){
		if(lista==null) return null;
		CausaMuerteDonante salida = null;
		boolean encontro = false;
		int x=0;
		while(x<lista.size() && !encontro){
			CausaMuerteDonante aux = lista.get(x);
			if(aux.getId() == id){
				salida = lista.get(x);
				encontro = true;
			}
			x++;
		}
		return salida;
	}
	public int contar() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
