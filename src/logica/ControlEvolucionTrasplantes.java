package logica;

import java.util.ArrayList;
import java.util.Calendar;

import dominio.EvolucionInjerto;
import dominio.EvolucionTrasplante;
import dominio.EvolucionTrasplanteCMV;
import dominio.EvolucionTrasplanteECG;
import dominio.EvolucionTrasplanteEcoCardio;
import dominio.EvolucionTrasplanteEcoDopler;
import dominio.EvolucionTrasplanteEcografia;
import dominio.EvolucionTrasplanteExamenes;
import dominio.EvolucionTrasplanteMarvirales;
import dominio.EvolucionTrasplanteNutricion;
import dominio.EvolucionTrasplanteTxTorax;
import dominio.FechaControl;
import dominio.RaTratamiento;

public class ControlEvolucionTrasplantes {

	
	public ArrayList<FechaControl> obtenerTodasFechasControl(){
		FechaControl f = new FechaControl();
		return f.obtenerTodos();
	}
	
	public void guardarFechaControl(FechaControl m){
		m.guardar();
	}
	
	public void eliminarFechaControl(FechaControl m){
		m.eliminar();
	}
	
	public void guardarEvolucionSimple(EvolucionTrasplante et){
		et.guardar();
	}
	
	public boolean existeEvolucionTrasplante(EvolucionTrasplante usado){
		ArrayList<EvolucionTrasplante> aux = usado.obtenerTodos();
		if(aux.size() >0){
			return true;
		}else{
			return false;
		}
	}
	
	public void guardarEvolucionCMV(EvolucionTrasplanteCMV e){
		e.guardar();
	}
	
	public void guardarEvolucionECG(EvolucionTrasplanteECG e){
		e.guardar();
	}
	
	public void guardarEvolucionMarvirales(EvolucionTrasplanteMarvirales e){
		e.guardar();
	}
	
	public void guardarEvolucionEcoCardio(EvolucionTrasplanteEcoCardio e){
		e.guardar();
	}
	
	public void guardarEvolucionTxTorax(EvolucionTrasplanteTxTorax e){
		e.guardar();
	}
	
	public void guardarEvolucionNutricion(EvolucionTrasplanteNutricion e){
		e.guardar();
	}
	
	public void eliminarEvolucionTrasplante(EvolucionTrasplante e){
		e.eliminar();
	}
	
	public void eliminarEvolucionTrasplanteCMV(EvolucionTrasplanteCMV e){
		e.eliminar();
	}
	
	public void eliminarEvolucionTrasplanteECG(EvolucionTrasplanteECG e){
		e.eliminar();
	}
	
	public void eliminarEvolucionTrasplanteEcoCardio(EvolucionTrasplanteEcoCardio e){
		e.eliminar();
	}
	
	public void eliminarEvolucionTrasplanteMarvirales(EvolucionTrasplanteMarvirales e){
		e.eliminar();
	}
	
	public void eliminarEvolucionTrasplanteTxTorax(EvolucionTrasplanteTxTorax e){
		e.eliminar();
	}
	
	public void eliminarEvolucionTrasplanteNutricion(EvolucionTrasplanteNutricion e){
		e.eliminar();
	}
	
	public void guardarEvolucionInjerto(EvolucionInjerto aux){
		aux.guardar();
	}
	
	public ArrayList<EvolucionInjerto> obtenertodosEvolucionInjerto(int idPretrasplante){
		EvolucionInjerto aux = new EvolucionInjerto();
		aux.setIdPretrasplante(idPretrasplante);
		return aux.obtenerTodos();
	}
	
	public void eliminarEvolucionInjerto(EvolucionInjerto aux){
		aux.eliminar();
	}
	
	public ArrayList<EvolucionTrasplanteExamenes> obtenerTodosEvolucionExamenes(int id, Calendar fecha){
		EvolucionTrasplanteExamenes aux = new EvolucionTrasplanteExamenes();
		aux.setIdTrasplante(id);
		aux.setFecha(fecha);
		return aux.obtenerTodos();
	}
	
	public void guardarEvolucionTrasplanteExamenes(EvolucionTrasplanteExamenes e){
		e.guardar();
	}
	
	public void eliminarEvolucionTrasplanteExamenes(EvolucionTrasplanteExamenes e){
		e.eliminar();
	}
	public EvolucionTrasplanteEcoDopler buscarEvolucionTrasplanteEcoDopler(int id, Calendar fecha){
		EvolucionTrasplanteEcoDopler aux = new EvolucionTrasplanteEcoDopler();
		aux.setIdTrasplante(id);
		aux.setFecha(fecha);
		if(aux.contar() > 0){
			aux.leer();
		}else{
			aux = null;
		}
		return aux;
	}
	
	public void guardarEvolucionTrasplanteEcoDopler(EvolucionTrasplanteEcoDopler e){
		e.guardar();
	}
	
	public void eliminarEvolucionTrasplanteEcoDopler(EvolucionTrasplanteEcoDopler e){
		e.eliminar();
	}
	
	public EvolucionTrasplanteEcografia buscarEvolucionTrasplanteEcografia(int id, Calendar fecha){
		EvolucionTrasplanteEcografia aux = new EvolucionTrasplanteEcografia();
		aux.setIdTrasplante(id);
		aux.setFecha(fecha);
		if(aux.contar() > 0){
			aux.leer();
		}else{
			aux = null;
		}
		return aux;
	}
	
	public void guardarEvolucionTrasplanteEcografia(EvolucionTrasplanteEcografia e){
		e.guardar();
	}
	
	public void eliminarEvolucionTrasplanteEcografia(EvolucionTrasplanteEcografia e){
		e.eliminar();
	}
	
	
	
	public ArrayList<RaTratamiento> obtenerTodosRaTratamiento(){
		RaTratamiento aux =  new RaTratamiento();
		return aux.obtenerTodos();
	}
	
	public void guardarRaTratamiento(RaTratamiento m){
		m.guardar();
	}
	
	public void eliminarRaTratamiento(RaTratamiento m){
		m.eliminar();
	}
}
