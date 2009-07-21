package dominio;

import java.util.ArrayList;

import persistencia.BrkOrganosDonante;
import persistencia.IPersistente;

public class OrganosDonante implements IPersistente{
	private String id;
	private String organo;
	//private ArrayList<String> listaOrganos = new ArrayList<String>();
	private BrkOrganosDonante broker = new BrkOrganosDonante(this);
	
	//Corazon, Pancreas,Pulmon, Rinhon, Intestino, Otros
	
	public String getId() {
		return id;
	}

	public void setId(String the) {
		this.id = the;
	}

	public String getOrgano() {
		return organo;
	}

	public void setOrgano(String organo) {
		this.organo = organo;
	}

	public OrganosDonante(){
		this.setId("");
	}
	
	public void eliminar() {
		broker.eliminar();
	}

	
	public int getOid() {
		return 0;
	}

	
	public void guardar() {
		if(this.getOrgano().equalsIgnoreCase("Riñon")){
			this.setOrgano("Rinhon");
		}
		broker.guardar();
	}

	
	public void leer() {
		broker.leer();
		if(this.getOrgano().equalsIgnoreCase("Rinhon")){
			this.setOrgano("Riñon");
		}
	}

	@SuppressWarnings("all")
	public ArrayList<OrganosDonante> obtenerTodos() {
		ArrayList<OrganosDonante> salida =broker.obtenerTodos();
		for(int x=0;x<salida.size();x++){
			OrganosDonante aux = salida.get(x);
			if(aux.getOrgano().equalsIgnoreCase("Rinhon")){
				aux.setOrgano("Riñon");
			}
		}
		return salida;
	}
	
	
	public String toString(){
		return this.getOrgano();
	}

	
	public int contar() {
		// TODO Auto-generated method stub
		return 0;
	}
}
