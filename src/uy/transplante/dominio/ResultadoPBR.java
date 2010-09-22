package uy.transplante.dominio;

import java.util.ArrayList;

import persistencia.BrkResultadoPBR;
import persistencia.broker.basico.IPersistente;

public class ResultadoPBR implements IPersistente {

	private int id;
	private String grado;
	private String criterio;
	private BrkResultadoPBR broker = new BrkResultadoPBR(this);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getCriterio() {
		return criterio;
	}

	public void setCriterio(String criterio) {
		this.criterio = criterio;
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
	public ArrayList<ResultadoPBR> obtenerTodos() {
		return broker.obtenerTodos();
	}

	public String toString() {
		return this.getGrado() + " - " + this.getCriterio();
	}

	public boolean equals(Object o) {
		if(o == null)return false;
		ResultadoPBR r = (ResultadoPBR) o;
		boolean salida = false;
		/*if (r.getId() == this.getId()) {
			return salida;
		}*/
		if (r.getGrado().equalsIgnoreCase(this.getGrado())) {
			if (r.getCriterio().equalsIgnoreCase(this.getCriterio())) {
				salida = true;
			}
		}

		return salida;
	}

	public int contar() {
		// TODO Auto-generated method stub
		return 0;
	}

}
