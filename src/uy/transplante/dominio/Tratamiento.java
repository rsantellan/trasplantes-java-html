package uy.transplante.dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.dominio.BrkTratamiento;

public class Tratamiento implements IPersistente{
	
//ATRIBUTOS
	private int the;
	private int medicamento;
	private Medicacion medicacion;
	private Calendar fecha_inicio; 
	private Calendar fecha_fin;
	private String dosis;
	private BrkTratamiento broker = new BrkTratamiento(this);
	
	public Tratamiento() {
		super();
		this.fecha_inicio = new GregorianCalendar();
		this.fecha_fin = new GregorianCalendar();
	}
	
	public int getThe() {
		return the;
	}

	public void setThe(int the) {
		this.the = the;
	}

	public int getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(int medicamento) {
		this.medicamento = medicamento;
	}

	public Medicacion getMedicacion() {
		return medicacion;
	}

	public void setMedicacion(Medicacion medicacion) {
		this.medicacion = medicacion;
	}

	public Calendar getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Calendar fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Calendar getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Calendar fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public String getDosis() {
		return dosis;
	}

	public void setDosis(String dosis) {
		this.dosis = dosis;
	}
	
	public void eliminar() {
		broker.eliminar();
	}

	
	public int getOid() {
		return this.contar();
	}

	
	public void guardar() {
		this.setMedicamento(this.getMedicacion().getId());
		broker.guardar();
	}

	
	public void leer() {
		broker.leer();
	}
	
	@SuppressWarnings("all")
	public ArrayList<Tratamiento> obtenerTodos() {
		ArrayList<Tratamiento> salida = broker.obtenerTodos();
		for(int x=0;x<salida.size();x++){
			Tratamiento t = salida.get(x);
			Medicacion m = new Medicacion();
			m.setId(t.getMedicamento());
			m.leer();
			t.setMedicacion(m);
		}
		return salida;
	}
	
	public int contar() {
		return broker.contar();
	}

}
