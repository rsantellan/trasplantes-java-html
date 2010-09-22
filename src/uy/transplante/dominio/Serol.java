package uy.transplante.dominio;

import java.util.ArrayList;

import persistencia.BrkSerol;
import persistencia.broker.basico.IPersistente;

public class Serol implements IPersistente {

	private int id;
	private String tipo;
	private ArrayList<SerolDatos> datos = new ArrayList<SerolDatos>();
	//private SerolDatos valor = new SerolDatos();
	private String ayudaSQL = "";
	private BrkSerol broker = new BrkSerol(this);

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

	public ArrayList<SerolDatos> getDatos() {
		return datos;
	}

	public void setDatos(ArrayList<SerolDatos> datos) {
		this.datos = datos;
	}

/*	private SerolDatos getValor() {
		return valor;
	}

	private void setValor(SerolDatos valor) {
		this.valor = valor;
	}*/

	public String getAyudaSQL() {
		return ayudaSQL;
	}

	public void setAyudaSQL(String ayudaSQL) {
		this.ayudaSQL = ayudaSQL;
	}

	public Serol() {
		this.setId(0);
	}

	public void eliminar() {
		this.leerDatos();
		for(int x=0;x<this.getDatos().size();x++){
			SerolDatos sd = (SerolDatos) this.getDatos().get(x);
			sd.eliminar();
		}
		broker.eliminar();
	}

	public int getOid() {
		// TODO Auto-generated method stub
		return this.getId();
	}

	public void guardar() {
		broker.guardar();
	}

	private ArrayList<SerolDatos> listaDatos = null;

	public void leerDatos() {
		SerolDatos sd = new SerolDatos();
		sd.setId(this.getId());
		this.setDatos(sd.obtenerTodos());
	}

	public void leer() {
		this.broker.leer();
		this.leerDatos();
	}

	@SuppressWarnings("all")
	public ArrayList<Serol> obtenerSoloSerol(){
		return broker.obtenerTodos();
	}
	
	public ArrayList<Serol> obtenerTodosCondicion(String sql){
		this.setAyudaSQL(sql);
		return this.obtenerSoloSerol();
	}
	
	public ArrayList<Serol> obtenerTodos() {
		ArrayList<Serol> salida = obtenerSoloSerol();
		SerolDatos sd = new SerolDatos();
		listaDatos = sd.obtenerTodos();
		for (int x = 0; x < salida.size(); x++) {
			Serol aux = (Serol) salida.get(x);
			int y = 0;
			ArrayList<SerolDatos> datosSerol = new ArrayList<SerolDatos>();
			while(y<listaDatos.size()){
				SerolDatos auxSd = (SerolDatos) listaDatos.get(y);
				if(auxSd.getId() == aux.getId()){
					datosSerol.add(auxSd);
					listaDatos.remove(auxSd);
				}else{
					y++;
				}
				
			}
			aux.setDatos(datosSerol);
			//aux.leerDatos();
		}
		return salida;
	}

	public boolean equals(Object o) {
		try {
			Serol s = (Serol) o;
			return this.getTipo().equalsIgnoreCase(s.getTipo());
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public String toString() {
		return this.getTipo();
	}

	public int contar() {
		// TODO Auto-generated method stub
		return 0;
	}

}
