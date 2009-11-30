package dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import persistencia.BrkCmvUsoEnfermedad;
import persistencia.broker.basico.IPersistente;

public class CMVusoEnfermedades implements IPersistente {

	private int idTrasplante;
	private Calendar fecha;
	private CMVEnfermedades enfermedad;
	private int numViejo;
	private BrkCmvUsoEnfermedad broker = new BrkCmvUsoEnfermedad(this);

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

	public CMVEnfermedades getEnfermedad() {
		return enfermedad;
	}

	public int getNumViejo() {
		return numViejo;
	}

	public void setNumViejo(int numViejo) {
		this.numViejo = numViejo;
	}

	public void setEnfermedad(CMVEnfermedades enfermedad) {
		if (this.getEnfermedad() == null) {
			this.setNumViejo(0);
		} else {
			this.setNumViejo(this.getEnfermedad().getId());
		}
		this.enfermedad = enfermedad;
	}

	public CMVusoEnfermedades(){
		this.setFecha(new GregorianCalendar());
	}
	
	public int contar() {
		return broker.contar();
	}

	
	public void eliminar() {
		broker.eliminar();
	}

	
	public int getOid() {
		return broker.contar();
	}

	
	public void guardar() {
		broker.guardar();
	}

	
	public void leer() {
		broker.leer();
	}

	@SuppressWarnings("all")
	public ArrayList<CMVusoEnfermedades> obtenerTodos() {
		return broker.obtenerTodos();
	}

}
