package uy.transplante.dominio;

import java.util.ArrayList;
import java.util.Calendar;

import persistencia.BrkTrasplanteComplicaciones;
import persistencia.broker.IPersistente;

public abstract class TrasplanteComplicaciones implements IPersistente{

	private int id;
	private int idPretrasplante;
	private Calendar fecha;
	private int numMedicacion;
	private Medicacion medicacion;
	private boolean internado;
	private int diasInternado;
	private boolean evolucion;
	private String comentario;
	private boolean buscarComplicacionesInfecciosasEvolucion = false;
	private boolean buscarComplicacionesNoInfecciosasEvolucion = false;
	
	private BrkTrasplanteComplicaciones broker = new BrkTrasplanteComplicaciones(this);
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPretrasplante() {
		return idPretrasplante;
	}

	public void setIdPretrasplante(int idPretrasplante) {
		this.idPretrasplante = idPretrasplante;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public int getNumMedicacion() {
		return numMedicacion;
	}

	public void setNumMedicacion(int numMedicacion) {
		this.numMedicacion = numMedicacion;
	}

	public Medicacion getMedicacion() {
		return medicacion;
	}

	public void setMedicacion(Medicacion medicacion) {
		this.medicacion = medicacion;
	}

	public boolean isInternado() {
		return internado;
	}

	public void setInternado(boolean internado) {
		this.internado = internado;
	}

	public int getDiasInternado() {
		return diasInternado;
	}

	public void setDiasInternado(int diasInternado) {
		this.diasInternado = diasInternado;
	}

	public boolean isEvolucion() {
		return evolucion;
	}

	public void setEvolucion(boolean evolucion) {
		this.evolucion = evolucion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public boolean isBuscarComplicacionesInfecciosasEvolucion() {
		return buscarComplicacionesInfecciosasEvolucion;
	}

	private void setBuscarComplicacionesInfecciosasEvolucion(
			boolean buscarComplicacionesInfecciosasEvolucion) {
		this.buscarComplicacionesInfecciosasEvolucion = buscarComplicacionesInfecciosasEvolucion;
	}

	public boolean isBuscarComplicacionesNoInfecciosasEvolucion() {
		return buscarComplicacionesNoInfecciosasEvolucion;
	}

	private void setBuscarComplicacionesNoInfecciosasEvolucion(
			boolean buscarComplicacionesNoInfecciosasEvolucion) {
		this.buscarComplicacionesNoInfecciosasEvolucion = buscarComplicacionesNoInfecciosasEvolucion;
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
		Medicacion med = new Medicacion();
		med.setId(this.getNumMedicacion());
		med.leer();
		this.setMedicacion(med);
	}

	
	@SuppressWarnings("all")
	public ArrayList<TrasplanteComplicaciones> obtenerTodos() {
		ArrayList<TrasplanteComplicaciones> salida = broker.obtenerTodos();
		for(int x=0;x<salida.size();x++){
			TrasplanteComplicaciones aux = salida.get(x);
			Medicacion med = new Medicacion();
			med.setId(aux.getNumMedicacion());
			med.leer();
			aux.setMedicacion(med);
		}
		return salida;
	}
	
	public boolean medicacionUsada(int numMedicacion){
		this.setNumMedicacion(numMedicacion);
		return this.contar() == 0;
	}
	
	public int contar() {
		return broker.contar();
	}
	
	public int buscarCantidadComplicacionesInfecciosasEvolucion(){
		this.setBuscarComplicacionesInfecciosasEvolucion(true);
		return broker.contar();
	}
	
	public int buscarCantidadComplicacionesNoInfecciosasEvolucion(){
		this.setBuscarComplicacionesNoInfecciosasEvolucion(true);
		return broker.contar();
	}

	public abstract boolean esInfeccion();

}
