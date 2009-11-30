package dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import persistencia.BrkEvolucionInjertoPBR;
import persistencia.broker.basico.IPersistente;

public class EvolucionInjertoResultadoPBR implements IPersistente{

	private int idPretrasplante;
	private Calendar fecha;
	private ResultadoPBR pbr;
	private boolean ultimo = false;
	private int numPBR = 0;
	
	private BrkEvolucionInjertoPBR broker = new BrkEvolucionInjertoPBR(this);
	
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

	public ResultadoPBR getPbr() {
		return pbr;
	}

	public void setPbr(ResultadoPBR pbr) {
		if(!this.isUltimo()){
			this.setUltimo(true);
			if(this.pbr == null) {
				this.setNumPBR(0);
			}else{
				this.setNumPBR(this.pbr.getId());
			}
		}
		this.pbr = pbr;
	}

	public boolean isUltimo() {
		return ultimo;
	}

	public void setUltimo(boolean ultimo) {
		this.ultimo = ultimo;
	}

	public int getNumPBR() {
		return numPBR;
	}

	private void setNumPBR(int numPBR) {
		this.numPBR = numPBR;
	}

	public EvolucionInjertoResultadoPBR() {
		this.setFecha(new GregorianCalendar());
		this.setPbr(new ResultadoPBR());
	}

	
	public void eliminar() {
		broker.eliminar();
	}

	
	public int getOid() {
		return this.contar();
	}

	
	public void guardar() {
		broker.guardar();
	}

	
	public void leer() {
		broker.leer();
	}

	
	public ArrayList<EvolucionInjertoResultadoPBR> obtenerTodos() {
		ArrayList<EvolucionInjertoResultadoPBR> salida = this.obtenerTodosMinimo();
		return salida;
	}
	
	@SuppressWarnings("all")
	public ArrayList<EvolucionInjertoResultadoPBR> obtenerTodosMinimo() {
		return broker.obtenerTodos();
	}
	
	public int contar() {
		this.setNumPBR(this.getPbr().getId());
		return broker.contar();
	}

	public String toString(){
		return this.getIdPretrasplante() + " - " + this.getPbr().toString();
	}
}
