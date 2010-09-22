package uy.transplante.dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import uy.transplante.auxiliares.fechas.ManejoFechas;

import persistencia.BrkEvolucionInjerto;
import persistencia.broker.IPersistente;

public class EvolucionInjerto implements IPersistente{

	private int idPretrasplante;
	private Calendar fecha;
	private ArrayList<EvolucionInjertoResultadoPBR> listaPBR = new ArrayList<EvolucionInjertoResultadoPBR>();
	private boolean tm;
	private String tmCual;
	private boolean gpNovo;
	private boolean recidivaGp;
	private boolean ra;
	private boolean rc;
	private RaTratamiento tratamiento;
	private boolean enTrasplante = false;
	private BrkEvolucionInjerto broker = new BrkEvolucionInjerto(this);
	
	private boolean buscarPorTratamiento;
	
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

	public ArrayList<EvolucionInjertoResultadoPBR> getListaPBR() {
		return listaPBR;
	}

	public void setListaPBR(ArrayList<EvolucionInjertoResultadoPBR> listaPBR) {
		this.listaPBR = listaPBR;
	}

	public boolean isTm() {
		return tm;
	}

	public void setTm(boolean tm) {
		this.tm = tm;
	}

	public String getTmCual() {
		return tmCual;
	}

	public void setTmCual(String tmCual) {
		this.tmCual = tmCual;
	}

	public boolean isGpNovo() {
		return gpNovo;
	}

	public void setGpNovo(boolean gpNovo) {
		this.gpNovo = gpNovo;
	}

	public boolean isRecidivaGp() {
		return recidivaGp;
	}

	public void setRecidivaGp(boolean recidivaGp) {
		this.recidivaGp = recidivaGp;
	}

	public boolean isRa() {
		return ra;
	}

	public void setRa(boolean ra) {
		this.ra = ra;
	}

	public boolean isRc() {
		return rc;
	}

	public void setRc(boolean rc) {
		this.rc = rc;
	}

	public boolean isBuscarPorTratamiento() {
		return buscarPorTratamiento;
	}

	private void setBuscarPorTratamiento(boolean buscarPorGPdeNovo) {
		this.buscarPorTratamiento = buscarPorGPdeNovo;
	}

	public RaTratamiento getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(RaTratamiento tratamiento) {
		this.tratamiento = tratamiento;
	}

	public boolean isEnTrasplante() {
		return enTrasplante;
	}

	public void setEnTrasplante(boolean enTrasplante) {
		this.enTrasplante = enTrasplante;
	}

	public EvolucionInjerto(){
		this.setFecha(new GregorianCalendar());
		this.setTratamiento(new RaTratamiento());
	}
	
	
	public void eliminar() {
		EvolucionInjertoResultadoPBR aux = new EvolucionInjertoResultadoPBR();
		aux.setIdPretrasplante(this.getIdPretrasplante());
		aux.setFecha(this.getFecha());
		aux.eliminar();
		broker.eliminar();
	}

	
	public int getOid() {
		return this.contar();
	}

	
	public void guardar() {
		broker.guardar();
		if(this.getListaPBR().size()>0)this.getListaPBR().get(0).eliminar();
		for(int x=0;x<this.getListaPBR().size();x++){
			EvolucionInjertoResultadoPBR aux = this.getListaPBR().get(x);
			aux.guardar();
		}
	}

	
	public void leer() {
		broker.leer();
		this.leerGPyPBR();
		this.getTratamiento().leer();
	}

	private void leerGPyPBR(){
		EvolucionInjertoResultadoPBR auxPBR = new EvolucionInjertoResultadoPBR();
		auxPBR.setIdPretrasplante(this.getIdPretrasplante());
		ManejoFechas.FORMATOESPANOL.format(this.getFecha().getTime());
		auxPBR.setFecha(this.getFecha());
		ArrayList<EvolucionInjertoResultadoPBR> lista = auxPBR.obtenerTodos();
		this.setListaPBR(lista);
	}
	
	public ArrayList<EvolucionInjerto> obtenerTodos() {
		this.setFecha(null);
		ArrayList<EvolucionInjerto> salida = this.obtenerTodosMinimo();
		for(int x=0;x<salida.size();x++){
			EvolucionInjerto aux = salida.get(x);
			aux.leerGPyPBR();
			aux.getTratamiento().leer();
		}
		return salida;
	}
	
	@SuppressWarnings("all")
	public ArrayList<EvolucionInjerto> obtenerTodosMinimo() {
		ArrayList<EvolucionInjerto> salida = broker.obtenerTodos();;
		return salida;
	}

	
	public int contar() {
		return broker.contar();
	}
	
	public int cantidadTratamientos(RaTratamiento ra){
		this.setBuscarPorTratamiento(true);
		this.setTratamiento(ra);
		return broker.contar();
	}

}
