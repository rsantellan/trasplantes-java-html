package uy.transplante.dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.dominio.BrkCmv;

public class CMV implements IPersistente {

	private int idTrasplante;
	private Calendar fecha;
	private CMVDiagnostico diagnostico;
	private boolean tmAnti;
	private boolean sindromeViral;
	private ArrayList<CMVusoEnfermedades> enfermedades;
	private boolean profilaxis;
	private CMVDrogas droga;
	private int diasTm;
	private String efectoSecundario;
	private BrkCmv broker = new BrkCmv(this);

	public int getIdTrasplante() {
		return idTrasplante;
	}

	public void setIdTrasplante(int idTrasplante) {
		this.idTrasplante = idTrasplante;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public CMVDiagnostico getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(CMVDiagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}

	public boolean isTmAnti() {
		return tmAnti;
	}

	public void setTmAnti(boolean tmAnti) {
		this.tmAnti = tmAnti;
	}

	public boolean isSindromeViral() {
		return sindromeViral;
	}

	public void setSindromeViral(boolean sindromeViral) {
		this.sindromeViral = sindromeViral;
	}

	public ArrayList<CMVusoEnfermedades> getEnfermedades() {
		return enfermedades;
	}

	public void setEnfermedades(ArrayList<CMVusoEnfermedades> enfermedades) {
		this.enfermedades = enfermedades;
	}

	public boolean isProfilaxis() {
		return profilaxis;
	}

	public void setProfilaxis(boolean profilaxis) {
		this.profilaxis = profilaxis;
	}

	public CMVDrogas getDroga() {
		return droga;
	}

	public void setDroga(CMVDrogas droga) {
		this.droga = droga;
	}

	public int getDiasTm() {
		return diasTm;
	}

	public void setDiasTm(int diasTm) {
		this.diasTm = diasTm;
	}

	public String getEfectoSecundario() {
		return efectoSecundario;
	}

	public void setEfectoSecundario(String efectoSecundario) {
		this.efectoSecundario = efectoSecundario;
	}

	public CMV() {
		this.setFecha(new GregorianCalendar());
		this.setEnfermedades(new ArrayList<CMVusoEnfermedades>());
	}

	
	public int contar() {
		return broker.contar();
	}

	
	public void eliminar() {
		CMVusoEnfermedades aux = new CMVusoEnfermedades();
		aux.setIdTrasplante(this.getIdTrasplante());
		aux.setFecha(null);
		aux.eliminar();
		broker.eliminar();
	}

	
	public int getOid() {
		return broker.contar();
	}

	
	public void guardar() {
		broker.guardar();
		CMVusoEnfermedades aux = new CMVusoEnfermedades();
		aux.setIdTrasplante(this.getIdTrasplante());
		aux.setFecha(this.getFecha());
		aux.eliminar();
		if (this.getEnfermedades() != null) {
			for (int x = 0; x < this.getEnfermedades().size(); x++) {
				CMVusoEnfermedades aux1 = (CMVusoEnfermedades) this.getEnfermedades().get(x);
				aux1.guardar();
			}
		}
	}

	
	public void leer() {
		broker.leer();
	}

	@SuppressWarnings("all")
	public ArrayList<CMV> obtenerTodos() {
		ArrayList<CMV> salida = broker.obtenerTodos();
		for (int x = 0; x < salida.size(); x++) {
			CMV aux = (CMV) salida.get(x);
			CMVusoEnfermedades auxUso = new CMVusoEnfermedades();
			auxUso.setIdTrasplante(aux.getIdTrasplante());
			auxUso.setFecha(aux.getFecha());
			aux.setEnfermedades(auxUso.obtenerTodos());
		}
		return salida;
	}

}
