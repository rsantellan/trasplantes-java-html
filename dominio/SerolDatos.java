package dominio;

import java.util.ArrayList;

import persistencia.BrkSerolDatos;
import persistencia.IPersistente;

public class SerolDatos implements IPersistente{

	private int id;
	private String tipo;
	private String viejo;
	private BrkSerolDatos broker = new BrkSerolDatos(this);
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getViejo() {
		return viejo;
	}
	public void setViejo(String viejo) {
		this.viejo = viejo;
	}
	public SerolDatos(){
		this.setId(0);
		this.setViejo(null);
	}
	
	public void eliminar() {
		broker.eliminar();
	}

	
	public int getOid() {
		// TODO Auto-generated method stub
		/*ArrayList<SerolDatos> lista = this.obtenerTodos();
		int x=0;
		boolean existe = false;
		while(!existe && x<lista.size()){
			SerolDatos aux = (SerolDatos) lista.get(x);
			if(this.equals(aux)){
				existe = true;
			}else{
				x++;
			}
		}
		if(existe){
			return 1;
		}else{
			return 0;
		}*/
		if(this.getViejo() == null){
			return 0;
		}else{
			return 1;
		}
	}

	
	public void guardar() {
		broker.guardar();
	}

	
	public void leer() {
		this.broker.leer();
	}

	
	public ArrayList<SerolDatos> obtenerTodos() {
		return broker.obtenerTodos();
	}
	
	
	public boolean equals(Object o){
		try{
			SerolDatos s = (SerolDatos) o;
			return (this.getId()==s.getId() && this.getTipo().equalsIgnoreCase(s.getTipo()));
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	}
	
	
	public String toString(){
		return this.getTipo();
	}
	
	public int contar() {
		// TODO Auto-generated method stub
		return 0;
	}

}
