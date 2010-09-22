package logica;

import java.util.ArrayList;
import java.util.Calendar;

import uy.transplante.dominio.CMV;
import uy.transplante.dominio.CMVDiagnostico;
import uy.transplante.dominio.CMVDrogas;
import uy.transplante.dominio.CMVEnfermedades;
import uy.transplante.dominio.Germenes;
import uy.transplante.dominio.Induccion;
import uy.transplante.dominio.Infeccion;
import uy.transplante.dominio.Inmunosupresores;
import uy.transplante.dominio.Medicacion;
import uy.transplante.dominio.PacientePreTrasplante;
import uy.transplante.dominio.ResultadoPBR;
import uy.transplante.dominio.Serol;
import uy.transplante.dominio.SerolDatos;
import uy.transplante.dominio.Trasplante;
import uy.transplante.dominio.TrasplanteComplicaciones;
import uy.transplante.dominio.TrasplanteComplicacionesInf;
import uy.transplante.dominio.TrasplanteComplicacionesNoInf;
import uy.transplante.dominio.TrasplanteReoperacion;
import uy.transplante.dominio.TrasplanteTiposComplicaciones;


public class ControlTrasplantes {

	public ArrayList<ResultadoPBR> listarTodosResultadosPBR(){
		ResultadoPBR r = new ResultadoPBR();
		return r.obtenerTodos();
	}

	public void guardarResultadoPBR(ResultadoPBR r){
		r.guardar();
	}
	
	public void eliminarResultadoPBR(ResultadoPBR r){
		r.eliminar();
	}
	
	public ArrayList<Trasplante> listarTodosTR(){
		Trasplante tr = new Trasplante();
		return tr.obtenerTodos();
	}
	
	public ArrayList<Serol> obtenerTodosLosSerol(){
		Serol s = new Serol();
		return s.obtenerTodos();
	}
	public void guardarSerol(Serol s){
		s.guardar();
	}
	public void eliminarSerol(Serol s){
		s.eliminar();
	}
	
	public void guardarSerolDatos(SerolDatos s){
		s.guardar();
	}

	public void eliminarSerolDatos(SerolDatos s){
		s.eliminar();
	}
	
	public ArrayList<Induccion> obtenerTodosLosInduccion(){
		Induccion s = new Induccion();
		return s.obtenerTodos();
	}
	public void guardarInduccion(Induccion s){
		s.guardar();
	}
	public void eliminarInduccion(Induccion s){
		s.eliminar();
	}
	
	public ArrayList<Inmunosupresores> obtenerTodosLosInmunosupresores(){
		Inmunosupresores s = new Inmunosupresores();
		return s.obtenerTodos();
	}
	public void guardarInmunosupresores(Inmunosupresores s){
		s.guardar();
	}
	public void eliminarInmunosupresores(Inmunosupresores s){
		s.eliminar();
	}
	
	public void guardarTrasplante(PacientePreTrasplante pt,Trasplante t){
		pt.guardarTrasplante(t);
	}
	
	public void guardarTrasplante(Trasplante t){
		t.guardar();
	}
	
	public ArrayList<Trasplante> obtenerTodosTrasplantesSimple(){
		Trasplante t = new Trasplante();
		return t.obtenerTodosSoloTrasplante();
	}
	
	public ArrayList<Trasplante> obtenerTodosTrasplantes(){
		Trasplante t = new Trasplante();
		return t.obtenerTodos();
	}
	
	public ArrayList<Trasplante> obtenerTodosSeleccion(){
		Trasplante t = new Trasplante();
		return t.obtenerTodosSeleccion();
	}
	
	public void eliminarTrasplante(Trasplante t){
		t.eliminar();
	}
	
	@SuppressWarnings("all")
	public ArrayList<TrasplanteComplicaciones> obtenerTodasComplicaciones(int idPreTrasplante){
		ArrayList<TrasplanteComplicaciones> salida = new ArrayList<TrasplanteComplicaciones>();
		TrasplanteComplicacionesInf inf = new TrasplanteComplicacionesInf();
		inf.setIdPretrasplante(idPreTrasplante);
		ArrayList<TrasplanteComplicaciones> listaInf = inf.obtenerTodos();
		TrasplanteComplicacionesNoInf noInf = new TrasplanteComplicacionesNoInf();
		noInf.setIdPretrasplante(idPreTrasplante);
		ArrayList<TrasplanteComplicaciones> listaNoInf = noInf.obtenerTodos();
		for(int x=0;x<listaInf.size();x++){
			salida.add(listaInf.get(x));
		}
		for(int x=0;x<listaNoInf.size();x++){
			salida.add(listaNoInf.get(x));
		}
		inf.setEvolucion(true);
		noInf.setEvolucion(true);
		listaInf = inf.obtenerTodos();
		listaNoInf = noInf.obtenerTodos();
		for(int x=0;x<listaInf.size();x++){
			salida.add(listaInf.get(x));
		}
		for(int x=0;x<listaNoInf.size();x++){
			salida.add(listaNoInf.get(x));
		}
		return salida;
	}
	
	public ArrayList<Medicacion> obtenerTodasMedicaciones(){
		Medicacion m = new Medicacion();
		return m.obtenerTodos();
	}
	public void guardarMedicacion(Medicacion m){
		m.guardar();
	}
	
	public void eliminarMedicacion(Medicacion m){
		m.eliminar();
	}
	
	public ArrayList<CMVEnfermedades> obtenerTodasCMVEmfermedades(){
		CMVEnfermedades e = new CMVEnfermedades();
		return e.obtenerTodos();
	}
	
	public ArrayList<TrasplanteTiposComplicaciones> obtenerTodosTiposComplicaciones(){
		TrasplanteTiposComplicaciones tc = new TrasplanteTiposComplicaciones();
		return tc.obtenerTodos();
	}
	
	public int obtenerCantidadComplicacionesInfecciosasEvolucion(int id){
		TrasplanteComplicacionesInf aux = new TrasplanteComplicacionesInf();
		aux.setIdPretrasplante(id);
		return aux.buscarCantidadComplicacionesInfecciosasEvolucion();
	}
	
	public int obtenerCantidadNoComplicacionesInfecciosasEvolucion(int id){
		TrasplanteComplicacionesNoInf aux = new TrasplanteComplicacionesNoInf();
		aux.setIdPretrasplante(id);
		return aux.buscarCantidadComplicacionesNoInfecciosasEvolucion();
	}
	
	public void guardarEmfermedadCMV(CMVEnfermedades m){
		m.guardar();
	}
	
	public void eliminarEmfermedadCMV(CMVEnfermedades m){
		m.eliminar();
	}
	
	public ArrayList<CMVDrogas> obtenerTodasCMVDrogas(){
		CMVDrogas aux = new CMVDrogas();
		return aux.obtenerTodos();
	}
	
	public void guardarDrogaCMV(CMVDrogas m){
		m.guardar();
	}
	
	public void eliminarDrogaCMV(CMVDrogas m){
		m.eliminar();
	}
	
	public ArrayList<CMVDiagnostico> obtenerTodasCMVDiagnostico(){
		CMVDiagnostico aux = new CMVDiagnostico();
		return aux.obtenerTodos();
	}
	
	public void guardarDiagnosticoCMV(CMVDiagnostico m){
		m.guardar();
	}
	
	public void eliminarDiagnosticoCMV(CMVDiagnostico m){
		m.eliminar();
	}
	
	public void guardarTipoComplicacion(TrasplanteTiposComplicaciones tc){
		tc.guardar();
	}
	
	public void eliminarTipoComplicacion(TrasplanteTiposComplicaciones tc){
		tc.eliminar();
	}
	
	public void guardarComplicacionNoInf(TrasplanteComplicacionesNoInf tnf){
		tnf.guardar();
	}
	
	public void eliminarComplicacionNoInf(TrasplanteComplicacionesNoInf t){
		t.eliminar();
	}
	
	public ArrayList<Infeccion> obtenerTodasInfecciones(){
		Infeccion aux = new Infeccion();
		return aux.obtenerTodos();
	}
	
	public void guardarInfeccion(Infeccion m){
		m.guardar();
	}
	
	public void eliminarInfeccion(Infeccion m){
		m.eliminar();
	}
	
	public ArrayList<Germenes> obtenerTodosGermenes(){
		Germenes aux = new Germenes();
		return aux.obtenerTodos();
	}
	
	public void guardarGermen(Germenes m){
		m.guardar();
	}
	
	public void eliminarGermen(Germenes m){
		m.eliminar();
	}
	
	public void guardarComplicacionInf(TrasplanteComplicacionesInf tnf){
		tnf.guardar();
	}
	
	public void eliminarComplicacionInf(TrasplanteComplicacionesInf t){
		t.eliminar();
	}
	
	public boolean verificarFechaCMV(int id, Calendar fecha){
		CMV aux = new CMV();
		aux.setIdTrasplante(id);
		aux.setFecha(fecha);
		return aux.contar() == 0;
	}
	
	public void guardarCMV(CMV c){
		c.guardar();
	}
	
	public ArrayList<CMV> obtenerTodosCMV(int idTrasplate){
		CMV aux = new CMV();
		aux.setIdTrasplante(idTrasplate);
		aux.setFecha(null);
		return aux.obtenerTodos();
	}
	
	public void eliminarCMV(CMV c){
		c.eliminar();
	}
	
	public boolean fechaEvolucionInjertoCorrecta(int idPreTrasplante,Calendar c){
		Trasplante t = new Trasplante();
		t.setPreTrasplante(idPreTrasplante);
		t.leerDatosMinimos();
		return c.after(t.getFecha());
	}
	
	public void guardarReoperacion(TrasplanteReoperacion t){
		t.guardar();
	}
	
	public void eliminarReoperacion(TrasplanteReoperacion t){
		t.eliminar();
	}
	
	public ArrayList<Trasplante> obtenerTraspalantesDelYear(int year){
		Trasplante t = new Trasplante();
		return t.obtenerTodosDelYear(year);
	}
}
