package dominio;

import java.util.ArrayList;
import java.util.Calendar;

import persistencia.BrkMuertePaciente;
import persistencia.IPersistente;
import auxiliares.ManejoFechas;

public class PacienteMuerte implements IPersistente{

	private int the;
	private Calendar fechaMuerte;
	private CausaMuertePaciente causa;
	private int numCausa;
	private boolean trFuncionando;
	private BrkMuertePaciente broker = new BrkMuertePaciente(this);
	
	public int getThe() {
		return the;
	}

	public void setThe(int the) {
		this.the = the;
	}

	public Calendar getFechaMuerte() {
		return fechaMuerte;
	}

	public void setFechaMuerte(Calendar fechaMuerte) {
		this.fechaMuerte = fechaMuerte;
	}

	public CausaMuertePaciente getCausa() {
		return causa;
	}

	public void setCausa(CausaMuertePaciente causa) {
		this.causa = causa;
	}

	public int getNumCausa() {
		return numCausa;
	}

	public void setNumCausa(int numCausa) {
		this.numCausa = numCausa;
	}

	
	public boolean isTrFuncionando() {
		return trFuncionando;
	}

	public void setTrFuncionando(boolean trFuncionando) {
		this.trFuncionando = trFuncionando;
	}

	
	public void eliminar() {
		broker.eliminar();
	}

	
	public int getOid() {
		if (this.getCausa() == null){
			return 0;
		}else{
			return this.getThe();
		}
	}

	
	public void guardar() {
		broker.guardar();
	}

	
	public void leer() {
		broker.leer();
		CausaMuertePaciente causa = new CausaMuertePaciente();
		causa.setId(this.getNumCausa());
		causa.leer();
		this.setCausa(causa);
	}

	@SuppressWarnings("all")
	public ArrayList<PacienteMuerte> obtenerTodos() {
		ArrayList<PacienteMuerte> salida = broker.obtenerTodos();
		for(int x=0;x<salida.size();x++){
			PacienteMuerte m = salida.get(x);
			CausaMuertePaciente causa = new CausaMuertePaciente();
			causa.setId(m.getNumCausa());
			causa.leer();
			m.setCausa(causa);
		}
		return salida;
	}

	
	public String toString(){
		String aux = "";
		if(this.isTrFuncionando()){
			aux = "/nEl trasplante estaba funcionando.";
		}else{
			aux = "/nEl trasplante no estaba funcionando.";
		}
		return this.getThe() + " - " + ManejoFechas.formatoEspanol.format(this.getFechaMuerte().getTime())+" - " + this.getCausa().toString() + " "+aux; 
	}
	
	
	public boolean equals(Object o){
		try{
			PacienteMuerte m = (PacienteMuerte) o;
			return (this.getThe() == m.getThe());
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	}

	
	public int contar() {
		return broker.contar();
	}
}
