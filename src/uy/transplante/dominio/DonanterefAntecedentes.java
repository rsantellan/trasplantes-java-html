package uy.transplante.dominio;

import java.util.ArrayList;

import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.dominio.BrkDonanterefAntecedente;

public class DonanterefAntecedentes implements IPersistente{

	private String idDonante;
	private int idAntecedente;
	private BrkDonanterefAntecedente broker = new BrkDonanterefAntecedente(this);
	
	public String getIdDonante() {
		return idDonante;
	}

	public void setIdDonante(String idDonante) {
		this.idDonante = idDonante;
	}

	public int getIdAntecedente() {
		return idAntecedente;
	}

	public void setIdAntecedente(int idAntecedente) {
		this.idAntecedente = idAntecedente;
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
	}

	@SuppressWarnings("all")
	public ArrayList<DonanterefAntecedentes> obtenerTodos() {
		return broker.obtenerTodos();
	}

	
	public int contar() {
		return broker.contar();
	}

}
