package dominio;

import java.util.ArrayList;

import persistencia.BrkAntecedentesDonante;
import persistencia.broker.basico.IPersistente;

public class AntecedentesDonante implements IPersistente{
	
	private int id;
	private String detalle;
	private BrkAntecedentesDonante broker = new BrkAntecedentesDonante(this);
	
	
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

	@SuppressWarnings("all")
	public ArrayList<AntecedentesDonante> obtenerTodos() {
		return broker.obtenerTodos();
	}
	
	
	public String toString(){
		return this.getDetalle();
	}
	
	
	public boolean equals(Object o){
		try{
			AntecedentesDonante p = (AntecedentesDonante) o;
			return this.getDetalle().equalsIgnoreCase(p.getDetalle());
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	}

	public static AntecedentesDonante devolverAntecedente(ArrayList<AntecedentesDonante> lista, int id){
		if(lista==null) return null;
		AntecedentesDonante salida = null;
		boolean encontro = false;
		int x=0;
		while(x<lista.size() && !encontro){
			AntecedentesDonante aux = lista.get(x);
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
