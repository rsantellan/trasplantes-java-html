package logica;

import java.util.ArrayList;

import dominio.CausaMuertePaciente;
import dominio.Donante;
import dominio.Paciente;
import dominio.PacienteMuerte;
import dominio.PacientePerdidaInjerto;
import dominio.PacientePreTrasplante;
import dominio.Trasplante;
import dominio.Tratamiento;

public class ControlPersonas {
	
	public int agregarPaciente(){
		//Devuelve el numero que se le asigna al paciente
		return 0;
	}
	
	public boolean modificarPaciente(Paciente p){
		p.guardar();
		return true;
	}
	
	public ArrayList<Paciente> listarTodosLosPacientes(){
		Paciente aux = new Paciente();
		return aux.obtenerTodosSoloPaciente();
	}
	
	public int guardarPaciente(Paciente p){
		p.guardar();
		return p.getThe();
	}
	
	public boolean chequearExistenciaPaciente(Paciente p){
		ArrayList<Paciente> aux = p.obtenerTodosSoloPaciente();
		if(aux.size()>0){
			return false;
		}else{
			return true;
		}
	}
	public boolean eliminarPaciente(Paciente p){
		p.leerDatos();
		p.eliminar();
		return this.chequearExistenciaPaciente(p);
	}
	

	
	public void agregarCausaMuertePaciente(CausaMuertePaciente c){
		c.guardar();
	}
	
	public void guardarPerdidaInjertoPaciente(PacientePerdidaInjerto pi){
		Paciente p = new Paciente();
		p.setThe(pi.getThe());
		p.leerDatosPreTrasplante();
		p.leerDatosPreTrasplante();
		PacientePreTrasplante pre = (PacientePreTrasplante) p.getListaPreTrasplantes().get(p.getListaPreTrasplantes().size()-1);
		pi.setNumPreTrasplante(pre.getId());
		pi.guardar();
	}

	public void eliminarPerdidaInjertoPaciente(PacientePerdidaInjerto p){
		p.eliminar();
	}
	
	public ArrayList<PacienteMuerte> listarTodosMuertePacientes(){
		PacienteMuerte m = new PacienteMuerte();
		return m.obtenerTodos();
	}
	
	public ArrayList<PacientePerdidaInjerto> listarTodosPerdidasInjertos(){
		PacientePerdidaInjerto p = new PacientePerdidaInjerto();
		return p.obtenerTodos();
	}
	


	
	public void guardarMuertePaciente(PacienteMuerte pm){
		pm.guardar();
	}
	
	public void eliminarMuertePaciente(Paciente p){
		p.eliminarMuertePaciente();
	}
	
	//Esto va a preTrasplante
	/*public void eliminarPerdidaInjertoPaciente(Paciente p){
		p.eliminarPerdidaInjertoPaciente();
	}*/
	
	public void guardarDonante(Donante d){
		d.guardar();
	}
	
	public ArrayList<Donante> obtenerTodosDonantes(){
		Donante d = new Donante();
		return d.obtenerTodos();
	}
	
	public ArrayList<Donante> obtenerTodosDonantesSolo(){
		Donante d = new Donante();
		return d.obtenerTodosSoloDonante();
	}
	
	public ArrayList<Donante> obtenerTodosDonantesLibres(){
		Donante d = new Donante();
		return d.obtenerTodosLibres();
	}
	public boolean eliminarDonante(Donante d){
		//Tengo que controlar que no existe un Trasplante con este donante
		boolean existencia = false;
		if(existencia){
			return false;
		}else{
			d.eliminar();
			return true;
		}
	}
	
	public void guardarPreTrasplante(Paciente p, PacientePreTrasplante pt){
		pt.guardar();
		p.getListaPreTrasplantes().add(pt);
	}
	
	public void eliminarPreTrasplante(PacientePreTrasplante pt){
		pt.eliminar();
	}
	
	public int obtenerCantidadPacientes(){
		Paciente aux = new Paciente();
		return aux.contar();
	}
	
	public ArrayList<PacientePreTrasplante> buscarPreTrasplantePaciente(Paciente p){
		ArrayList<PacientePreTrasplante> salida = p.buscarPreTrasplantePaciente();
		for(int x=0;x<salida.size();x++){
			PacientePreTrasplante aux = (PacientePreTrasplante) salida.get(x);
			aux.setTrasplante(new Trasplante());
			aux.getTrasplante().setPreTrasplante(aux.getId());
			aux.leerMaximoTrasplante();
		}
		return salida;
	}
	
	public boolean guardarTratamiento(Tratamiento t){
		 t.guardar();
		return true;
	}
	
	public ArrayList<Tratamiento> obtenerTodosTratamientos(int the){
		Tratamiento t = new Tratamiento();
		t.setThe(the);
		return t.obtenerTodos();
	}
	
	public boolean eliminarTratamiento(Tratamiento t){
		t.eliminar();
		return true;
	}
}
