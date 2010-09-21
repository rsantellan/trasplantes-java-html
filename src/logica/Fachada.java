package logica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import uy.transplante.auxiliares.milog.MiLog;

import persistencia.broker.basico.ManejadorBD;
import uy.auxiliares.log.ManejadorLogs;
import dominio.AntecedentesDonante;
import dominio.CMV;
import dominio.CMVDiagnostico;
import dominio.CMVDrogas;
import dominio.CMVEnfermedades;
import dominio.CausaMuerteDonante;
import dominio.CausaMuertePaciente;
import dominio.CausaPerdidaInjerto;
import dominio.Donante;
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
import dominio.Generico;
import dominio.GenericoAuxiliar;
import dominio.Germenes;
import dominio.Induccion;
import dominio.Infeccion;
import dominio.Inmunosupresores;
import dominio.Medicacion;
import dominio.Nefropatia;
import dominio.Paciente;
import dominio.PacienteMuerte;
import dominio.PacientePerdidaInjerto;
import dominio.PacientePreTrasplante;
import dominio.RaTratamiento;
import dominio.ResultadoPBR;
import dominio.Serol;
import dominio.SerolDatos;
import dominio.Trasplante;
import dominio.TrasplanteComplicaciones;
import dominio.TrasplanteComplicacionesInf;
import dominio.TrasplanteComplicacionesNoInf;
import dominio.TrasplanteReoperacion;
import dominio.TrasplanteTiposComplicaciones;
import dominio.Tratamiento;

public class Fachada extends Observable{

	private static Fachada instancia = null;
	private ControlPersonas personas;
	private ControlTrasplantes trasplantes;
	private ControlEvolucionTrasplantes evolucion;
	private ControlDatosFijos datosFijos;
	private ControlConsultas consultas;
	private ControlBackUp backUp;
	private boolean ingreEvolucionTrasplante = false;
	private int lugar;
	public static int PACIENTE = 1;
	public static int CAUSAPERDIDAINJERTO = 2;
	public static int PRETRASPLANTE = 2;
	public static int DONANTE = 3;
	public static int TRATAMIENTO = 4;
	public static int SEROL = 5;
	public static int COMPLICACIONES_NO_INFECCIOSAS = 6;
	public static int COMPLICACIONES_INFECCIOSAS = 7;
	public static int EVOLUCION_SIMPLE = 8;
	public static int EVOLUCION_CMV = 9;
	public static int EVOLUCION_ECG = 10;
	public static int EVOLUCION_MARVIRALES = 11;
	public static int EVOLUCION_ECOCARDIO = 12;
	public static int EVOLUCION_TXTORAX = 13;
	public static int EVOLUCION_NUTRICION = 14;
	public static int EVOLUCION_TRASPLANTE_EXAMENES = 15;
	public static int EVOLUCION_INJERTO = 16;
	public static int CREADOR_CONSULTAS = 17;
	public static int MUERTE_PACIENTE = 18;
	public static int NEFROPATIA = 19;
	public static int CAUSA_MUERTE_PACIENTES = 20;
	public static int PERDIDA_INJERTO_PACIENTE = 21;
	public static int ANTECEDENTE_DONANTE = 22;
	public static int CAUSA_MUERTE_DONANTE = 23;
	static Logger logger = Logger.getLogger(Fachada.class);
	public static int LOG_INFO = 0;
	public static int LOG_WARN = 1;
	public static int LOG_ERR = 2;
	public static int LOG_FATAL = 3;
	
	public static Fachada getInstancia(){
		if (instancia == null){
			instancia = new Fachada();
		}
		return instancia;
	} 
	
	public ArrayList<Object> generico(Generico g){
		g.leer();
		return g.getListaObtenida();
	}
	
	private Fachada(){
		ManejadorBD.getInstancia().conectar("jdbc:mysql://localhost:3306/trasplante","medico","medico");
		personas = new ControlPersonas();
		trasplantes = new ControlTrasplantes();
		evolucion = new ControlEvolucionTrasplantes();
		datosFijos = new ControlDatosFijos();
		consultas = new ControlConsultas();
		backUp = new ControlBackUp();
		//miLog = new MiLog();
		this.guardarLog(Fachada.LOG_INFO, MiLog.inicioLog());
	}
	
	public void salir(){
		ManejadorBD.getInstancia().desconectar();
		ManejadorLogs.getInstancia().terminar();
	}
	
	public void cambie(){
		this.setChanged();
		this.notifyObservers();
	}
	
	public void agregarObservador(Observer o){
		this.addObserver(o);
	}
	
	public void eliminarObservador(Observer o){
		this.deleteObserver(o);
	}
	
	public void guardarLog(int type, String texto){
		DOMConfigurator.configure("configuration.xml");
		//int type = 0;
		switch (type) {
			case 0:
				logger.info(texto);
				break;
			case 1:
				logger.warn(texto);
				break;
			case 2:
				logger.error(texto);
				break;
			case 3:
				logger.fatal(texto);
				break;
			default:
				logger.fatal(texto);
				break;
		}
		
	    logger.debug(texto);
	    logger.info(texto);
		//ManejadorLogs.getInstancia().guardarLog(texto);
		//System.out.println(texto);
	}
	
	public void guardarLogError(String texto){
		//ManejadorLogs.getInstancia().guardarLog(texto);
		//System.out.println(texto);
	}
	
	public int crearBackUp(){
		return this.backUp.inicializarBackUp();
	}
	
	public int crearRestore(String path){
		return this.backUp.inicializarRestore(path);
	}
	
	public int getLugar(){
		return this.lugar;
	}
	//Esto es de CONTROLPERSONAS!!
	
	public ArrayList<PacientePreTrasplante> buscarPreTrasplantePaciente(Paciente p){
		return personas.buscarPreTrasplantePaciente(p);
	}
	
	public void guardarPreTrasplante(Paciente p, PacientePreTrasplante pt){
		personas.guardarPreTrasplante(p, pt);
		this.lugar = Fachada.PRETRASPLANTE;
		this.cambie();
	}
	
	public int obtenerCantidadPacientes(){
		return personas.obtenerCantidadPacientes();
	}
	public void eliminarPreTrasplante(PacientePreTrasplante pt){
		personas.eliminarPreTrasplante(pt);
		this.lugar = Fachada.PRETRASPLANTE;
		this.cambie();
	}
	public ArrayList<Paciente> obtenerTodosPacientes(){
		return personas.listarTodosLosPacientes();
	}
	
	public ArrayList<Nefropatia> obtenerTodasNefropatias(){
		return datosFijos.listarTodasNefropatias();
	}
	public boolean chequearExistenciaPaciente(Paciente p){
		return personas.chequearExistenciaPaciente(p);
	}
	public int guardarPaciente(Paciente p){
		int num = personas.guardarPaciente(p);
		if(num != 0){
			this.lugar = Fachada.PACIENTE;
			this.cambie();
			
		}
		return num;
	}
	public boolean modificarPaciente(Paciente p){
		boolean result = personas.modificarPaciente(p);
		if(result){
			this.lugar = Fachada.PACIENTE;
			this.cambie();
		}
		return result;
	}
	
	public boolean eliminarPaciente(Paciente p){
		boolean result = personas.eliminarPaciente(p);
		if(result){
			this.lugar = Fachada.PACIENTE;
			this.cambie();
		}
		return result;
	}
	
	public void guardarMuertePaciente(PacienteMuerte pm){
		personas.guardarMuertePaciente(pm);
		this.lugar = Fachada.MUERTE_PACIENTE;
		this.cambie();
	}
	
	public void guardarNefropatia(Nefropatia n){
		datosFijos.guardarNefropatia(n);
		this.lugar = Fachada.NEFROPATIA;
		this.cambie();
	}
	
	public void eliminarNefropatia(Nefropatia n){
		datosFijos.eliminarNefropatia(n);
		this.lugar = Fachada.NEFROPATIA;
		this.cambie();
	}
	
	public ArrayList<CausaMuertePaciente> obtenerTodasCausaMuertePaciente(){
		return datosFijos.listarTodasCausaMuertePaciente();
	}

	public void guardarCausaMuertePaciente(CausaMuertePaciente c){
		datosFijos.guardarCausaMuertePaciente(c);
		this.lugar = Fachada.CAUSA_MUERTE_PACIENTES;
		this.cambie();
	}
	
	public void eliminarCausaMuertePaciente(CausaMuertePaciente c){
		datosFijos.eliminarCausaMuertePaciente(c);
		this.lugar = Fachada.CAUSA_MUERTE_PACIENTES;
		this.cambie();
	}
	
	public ArrayList<PacienteMuerte> obtenerTodosMuertePacientes(){
		return personas.listarTodosMuertePacientes();
	}
	
	public ArrayList<CausaPerdidaInjerto> obtenerTodasCausasPerdidaInjerto(){
		return datosFijos.listarTodasCausasPerdidaInjerto();
	}
	
	public void guardarCausaPerdidaInjerto(CausaPerdidaInjerto c){
		datosFijos.guardarCausaPerdidaInjerto(c);
		this.lugar = Fachada.CAUSAPERDIDAINJERTO;
		this.cambie();
	}
	
	public ArrayList<PacientePerdidaInjerto> obtenerTodosPerdidasInjertos(){
		return personas.listarTodosPerdidasInjertos();
	}
	
	public int obtenerCantidadPerdidasInjerto(Paciente p){
		return 0;
	}
	
	
	public void eliminarCausaPerdidaInjerto(CausaPerdidaInjerto c){
		datosFijos.eliminarCausaPerdidaInjerto(c);
		this.lugar = Fachada.CAUSAPERDIDAINJERTO;
		this.cambie();
	}
	
	public void guardarPerdidaInjertoPaciente(PacientePerdidaInjerto pi){
		personas.guardarPerdidaInjertoPaciente(pi);
		this.lugar = Fachada.PERDIDA_INJERTO_PACIENTE;
		this.cambie();
	}
	public void eliminarMuertePaciente(Paciente p){
		personas.eliminarMuertePaciente(p);
	}
	
	public void eliminarPerdidaInjertoPaciente(PacientePerdidaInjerto p){
		personas.eliminarPerdidaInjertoPaciente(p);
		this.lugar = Fachada.PERDIDA_INJERTO_PACIENTE;
		this.cambie();
	}
	
	public ArrayList<AntecedentesDonante> obtenerTodosAntecedentesDonante(){
		return datosFijos.obtenerTodosAntecedentesDonante();
	}
	
	
	
	public void guardarAntecedenteDonante(AntecedentesDonante a){
		datosFijos.guardarAntecedenteDonante(a);
		this.lugar = Fachada.ANTECEDENTE_DONANTE;
		this.cambie();
	}
	
	public void eliminarAntecedenteDonante(AntecedentesDonante a){
		datosFijos.eliminarAntecedenteDonante(a);
		this.lugar = Fachada.ANTECEDENTE_DONANTE;
		this.cambie();
	}
	
	public ArrayList<CausaMuerteDonante> obtenerTodasCausasMuerteDonante(){
		return datosFijos.listarTodasCausasMuerteDonante();
	}
	
	public void guardarCausaMuerteDonante(CausaMuerteDonante c){
		datosFijos.guardarCausaMuerteDonante(c);
		this.lugar = Fachada.CAUSA_MUERTE_DONANTE;
		this.cambie();
	}
	
	
	public void eliminarCausaMuerteDonante(CausaMuerteDonante c){
		datosFijos.eliminarCausaMuerteDonante(c);
		this.lugar = Fachada.CAUSA_MUERTE_DONANTE;
		this.cambie();
	}
	
	public void guardarDonante(Donante d){
		personas.guardarDonante(d);
		this.lugar = Fachada.DONANTE;
		this.cambie();
	}
	
	public ArrayList<Donante> obtenerTodosDonantes(){
		return personas.obtenerTodosDonantes();
	}
	
	public ArrayList<Donante> obtenerTodosDonantesSolo(){
		return personas.obtenerTodosDonantesSolo();
	}
	
	public ArrayList<Donante> obtenerTodosDonantesLibres(){
		return personas.obtenerTodosDonantesLibres();
	}
	
	
	public boolean eliminarDonante(Donante d){
		if(personas.eliminarDonante(d)){
			this.lugar = Fachada.DONANTE;
			this.cambie();
			return true;
		}
		return false;
	}
	
	
	
	public boolean guardarTratamiento(Tratamiento t){
		boolean salida =  this.personas.guardarTratamiento(t);
		this.lugar = Fachada.TRATAMIENTO;
		this.cambie();
		return salida;
	}
	
	public boolean eliminarTratamiento(Tratamiento t){
		boolean salida =  this.personas.eliminarTratamiento(t);
		this.lugar = Fachada.TRATAMIENTO;
		this.cambie();
		return salida;
	}
	
	public ArrayList<Tratamiento> obtenerTodosTratamientos(int the){
		return this.personas.obtenerTodosTratamientos(the);
	}
	
	//Empieza CONTROL TRASPLANTES
	public ArrayList<Serol> obtenerTodosLosSerol(){
		return trasplantes.obtenerTodosLosSerol();
	}
	
		public void guardarSerol(Serol s){
		trasplantes.guardarSerol(s);
		this.lugar = Fachada.SEROL;
		this.cambie();
	}
	public void eliminarSerol(Serol s){
		trasplantes.eliminarSerol(s);
		this.lugar = Fachada.SEROL;
		this.cambie();
	}
	
	public void guardarSerolDato(SerolDatos s){
		trasplantes.guardarSerolDatos(s);
		this.cambie();
	}

	
	public void eliminarSerolDato(SerolDatos s){
		trasplantes.eliminarSerolDatos(s);
		this.cambie();
	}
	public ArrayList<Induccion> obtenerTodosLosInduccion(){
		return trasplantes.obtenerTodosLosInduccion();
	}
	
	public void guardarInduccion(Induccion s){
		trasplantes.guardarInduccion(s);
		this.cambie();
	}
	
	public void eliminarInduccion(Induccion s){
		trasplantes.eliminarInduccion(s);
		this.cambie();
	}
	
	public ArrayList<Inmunosupresores> obtenerTodosLosInmunosupresores(){
		return trasplantes.obtenerTodosLosInmunosupresores();
	}
	
	public void guardarInmunosupresores(Inmunosupresores s){
		trasplantes.guardarInmunosupresores(s);
		this.cambie();
	}
	public void eliminarInmunosupresores(Inmunosupresores s){
		trasplantes.eliminarInmunosupresores(s);
		this.cambie();
	}
	
	public ArrayList<ResultadoPBR> obtenerTodosResultadosPBR(){
		return trasplantes.listarTodosResultadosPBR();
	}
	
	public void guardarResultadoPBR(ResultadoPBR r){
		trasplantes.guardarResultadoPBR(r);
		this.cambie();
	}
	
	public void eliminarResultadoPBR(ResultadoPBR r){
		trasplantes.eliminarResultadoPBR(r);
		this.cambie();
	}
	
	public ArrayList<Trasplante> obtenerTodosTR(){
		return trasplantes.listarTodosTR();
	}
	
	public void guardarTrasplante(PacientePreTrasplante pt,Trasplante t){
		trasplantes.guardarTrasplante(pt,t);
		this.cambie();
	}
	
	public void guardarTrasplante(Trasplante t){
		trasplantes.guardarTrasplante(t);
		this.lugar = Fachada.PRETRASPLANTE;
		this.cambie();
	}
	
	public ArrayList<Trasplante> obtenerTodosTrasplantesSimple(){
		return trasplantes.obtenerTodosTrasplantesSimple();
	}
	
	public ArrayList<Trasplante> obtenerTodosTrasplantes(){
		 return trasplantes.obtenerTodosTrasplantes();
	}
	
	public ArrayList<Trasplante> obtenerTodosTrasplantesSeleccion(){
		 return trasplantes.obtenerTodosSeleccion();
	}
	
	public void eliminarTrasplante(Trasplante t){
		trasplantes.eliminarTrasplante(t);
		this.cambie();
	}
	
	public ArrayList<TrasplanteComplicaciones> obtenerTodasComplicaciones(int idPreTrasplante){
		return trasplantes.obtenerTodasComplicaciones(idPreTrasplante);
	}
	
	public ArrayList<Medicacion> obtenerTodasMedicaciones(){
		return trasplantes.obtenerTodasMedicaciones();
	}
	
	public void guardarMedicacion(Medicacion m){
		trasplantes.guardarMedicacion(m);
		this.cambie();
	}
	
	public void eliminarMedicacion(Medicacion m){
		trasplantes.eliminarMedicacion(m);
		this.cambie();
	}
	
	public ArrayList<CMVEnfermedades> obtenerTodasCMVEmfermedades(){
		return trasplantes.obtenerTodasCMVEmfermedades();
	}
	
	public void guardarEmfermedadCMV(CMVEnfermedades m){
		trasplantes.guardarEmfermedadCMV(m);
		this.cambie();
	}
	
	public void eliminarEmfermedadCMV(CMVEnfermedades m){
		trasplantes.eliminarEmfermedadCMV(m);
		this.cambie();
	}
	
	public ArrayList<CMVDrogas> obtenerTodasCMVDrogas(){
		return trasplantes.obtenerTodasCMVDrogas();
	}
	
	public void guardarDrogaCMV(CMVDrogas m){
		trasplantes.guardarDrogaCMV(m);
		this.cambie();
	}
	
	public void eliminarDrogaCMV(CMVDrogas m){
		trasplantes.eliminarDrogaCMV(m);
		this.cambie();
	}
	
	public ArrayList<CMVDiagnostico> obtenerTodasCMVDiagnostico(){
		return trasplantes.obtenerTodasCMVDiagnostico();
	}
	
	public void guardarDiagnosticoCMV(CMVDiagnostico m){
		trasplantes.guardarDiagnosticoCMV(m);
		this.cambie();
	}
	
	public void eliminarDiagnosticoCMV(CMVDiagnostico m){
		trasplantes.eliminarDiagnosticoCMV(m);
		this.cambie();
	}
	
	public ArrayList<TrasplanteTiposComplicaciones> obtenerTodosTiposComplicaciones(){
		return trasplantes.obtenerTodosTiposComplicaciones();
	}
	
	public int obtenerCantidadComplicacionesInfecciosasEvolucion(int id){
		return trasplantes.obtenerCantidadComplicacionesInfecciosasEvolucion(id);
	}
	
	public int obtenerCantidadComplicacionesNoInfecciosasEvolucion(int id){
		return trasplantes.obtenerCantidadNoComplicacionesInfecciosasEvolucion(id);
	}
	
	public void guardarTipoComplicacion(TrasplanteTiposComplicaciones tc){
		trasplantes.guardarTipoComplicacion(tc);
		this.cambie();
	}
	
	public void eliminarTipoComplicacion(TrasplanteTiposComplicaciones tc){
		trasplantes.eliminarTipoComplicacion(tc);
		this.cambie();
	}
	
	
	public void guardarComplicacionNoInf(TrasplanteComplicacionesNoInf tnf){
		trasplantes.guardarComplicacionNoInf(tnf);
		this.lugar = Fachada.COMPLICACIONES_NO_INFECCIOSAS;
		this.cambie();
	}
	
	public void eliminarComplicacionNoInf(TrasplanteComplicacionesNoInf t){
		trasplantes.eliminarComplicacionNoInf(t);
		this.lugar = Fachada.COMPLICACIONES_NO_INFECCIOSAS;
		this.cambie();
	}
	
	public ArrayList<Infeccion> obtenerTodasInfecciones(){
		return trasplantes.obtenerTodasInfecciones();
	}
	
	public void guardarInfeccion(Infeccion m){
		trasplantes.guardarInfeccion(m);
		this.cambie();
	}
	public void eliminarInfeccion(Infeccion m){
		trasplantes.eliminarInfeccion(m);
		this.cambie();
	}
	
	public ArrayList<Germenes> obtenerTodosGermenes(){
		return trasplantes.obtenerTodosGermenes();
	}
	
	public void guardarGermen(Germenes m){
		trasplantes.guardarGermen(m);
		this.cambie();
	}
	
	public void eliminarGermen(Germenes m){
		trasplantes.eliminarGermen(m);
		this.cambie();
	}
	
	public void guardarComplicacionInf(TrasplanteComplicacionesInf tnf){
		trasplantes.guardarComplicacionInf(tnf);
		this.lugar = Fachada.COMPLICACIONES_INFECCIOSAS;
		this.cambie();
	}
	
	public void eliminarComplicacionInf(TrasplanteComplicacionesInf t){
		trasplantes.eliminarComplicacionInf(t);
		this.lugar = Fachada.COMPLICACIONES_INFECCIOSAS;
		this.cambie();
	}
	
	public ArrayList<CMV> obtenerTodosCMV(int idTrasplate){
		return trasplantes.obtenerTodosCMV(idTrasplate);
	}
	
	public void guardarCMV(CMV c){
		trasplantes.guardarCMV(c);
		this.cambie();
	}
	
	public void eliminarCMV(CMV c){
		trasplantes.eliminarCMV(c);
		this.cambie();
	}
	
	public boolean verificarFechaCMV(int id, Calendar fecha){
		return trasplantes.verificarFechaCMV(id,fecha);
	}

	public void guardarReoperacion(TrasplanteReoperacion t){
		trasplantes.guardarReoperacion(t);
		this.cambie();
	}
	
	public void eliminarReoperacion(TrasplanteReoperacion t){
		trasplantes.eliminarReoperacion(t);
		this.cambie();
	}
	
	public ArrayList<Trasplante> obtenerTraspalantesDelYear(int year){
		return trasplantes.obtenerTraspalantesDelYear(year);
	}
	//Evolucion del trasplante.
	
	public boolean estadoIngresoEvolucion(){
		return this.ingreEvolucionTrasplante;
	}
	
	public void cambiarEstadoIngresoEvolucionVerdadero(){
		this.ingreEvolucionTrasplante = true;
	}
	
	public void cambiarEstadoIngresoEvolucionNegativo(){
		this.ingreEvolucionTrasplante = true;
	}
	
	public ArrayList<FechaControl> obtenerTodasFechasControl(){
		return evolucion.obtenerTodasFechasControl();
	}
	
	public void guardarFechaControl(FechaControl m){
		evolucion.guardarFechaControl(m);
		this.cambie();
	}
	
	public void eliminarFechaControl(FechaControl m){
		evolucion.eliminarFechaControl(m);
		this.cambie();
	}
	

	public void guardarEvolucionSimple(EvolucionTrasplante et){
		evolucion.guardarEvolucionSimple(et);
		this.cambiarEstadoIngresoEvolucionVerdadero();
		this.lugar = Fachada.EVOLUCION_SIMPLE;
		this.cambie();
	}
	
	public boolean existeEvolucionTrasplante(EvolucionTrasplante usado){
		return evolucion.existeEvolucionTrasplante(usado);
	}

	
	public void guardarEvolucionCMV(EvolucionTrasplanteCMV e){
		evolucion.guardarEvolucionCMV(e);
		this.cambiarEstadoIngresoEvolucionVerdadero();
		this.lugar = Fachada.EVOLUCION_CMV;
		this.cambie();
	}
	
	
	public void guardarEvolucionECG(EvolucionTrasplanteECG e){
		evolucion.guardarEvolucionECG(e);
		this.cambiarEstadoIngresoEvolucionVerdadero();
		this.lugar = Fachada.EVOLUCION_ECG;
		this.cambie();
	}
	
	
	public void guardarEvolucionMarvirales(EvolucionTrasplanteMarvirales e){
		evolucion.guardarEvolucionMarvirales(e);
		this.cambiarEstadoIngresoEvolucionVerdadero();
		this.lugar = Fachada.EVOLUCION_MARVIRALES;
		this.cambie();
	}
	
	public void guardarEvolucionEcoCardio(EvolucionTrasplanteEcoCardio e){
		evolucion.guardarEvolucionEcoCardio(e);
		this.cambiarEstadoIngresoEvolucionVerdadero();
		this.lugar = Fachada.EVOLUCION_ECOCARDIO;
		this.cambie();
	}
	
	
	public void guardarEvolucionTxTorax(EvolucionTrasplanteTxTorax e){
		evolucion.guardarEvolucionTxTorax(e);
		this.cambiarEstadoIngresoEvolucionVerdadero();
		this.lugar = Fachada.EVOLUCION_TXTORAX;
		this.cambie();
	}
	
	
	public void guardarEvolucionNutricion(EvolucionTrasplanteNutricion e){
		evolucion.guardarEvolucionNutricion(e);
		this.cambiarEstadoIngresoEvolucionVerdadero();
		this.lugar = Fachada.EVOLUCION_NUTRICION;
		this.cambie();
	}
	
	public void eliminarEvolucionTrasplante(EvolucionTrasplante e){
		evolucion.eliminarEvolucionTrasplante(e);
		this.cambiarEstadoIngresoEvolucionVerdadero();
		this.lugar = Fachada.EVOLUCION_SIMPLE;
		this.cambie();
	}
	
	public void eliminarEvolucionTrasplanteCMV(EvolucionTrasplanteCMV e){
		evolucion.eliminarEvolucionTrasplanteCMV(e);
		this.cambiarEstadoIngresoEvolucionVerdadero();
		this.lugar = Fachada.EVOLUCION_CMV;
		this.cambie();
	}
	
	public void eliminarEvolucionTrasplanteECG(EvolucionTrasplanteECG e){
		evolucion.eliminarEvolucionTrasplanteECG(e);
		this.cambiarEstadoIngresoEvolucionVerdadero();
		this.lugar = Fachada.EVOLUCION_ECG;
		this.cambie();
	}
	
	public void eliminarEvolucionTrasplanteEcoCardio(EvolucionTrasplanteEcoCardio e){
		evolucion.eliminarEvolucionTrasplanteEcoCardio(e);
		this.cambiarEstadoIngresoEvolucionVerdadero();
		this.lugar = Fachada.EVOLUCION_ECOCARDIO;
		this.cambie();
	}
	
	public void eliminarEvolucionTrasplanteMarvirales(EvolucionTrasplanteMarvirales e){
		evolucion.eliminarEvolucionTrasplanteMarvirales(e);
		this.cambiarEstadoIngresoEvolucionVerdadero();
		this.lugar = Fachada.EVOLUCION_MARVIRALES;
		this.cambie();
	}
	
	public void eliminarEvolucionTrasplanteTxTorax(EvolucionTrasplanteTxTorax e){
		evolucion.eliminarEvolucionTrasplanteTxTorax(e);
		this.cambiarEstadoIngresoEvolucionVerdadero();
		this.lugar = Fachada.EVOLUCION_TXTORAX;
		this.cambie();
	}
	
	public void eliminarEvolucionTrasplanteNutricion(EvolucionTrasplanteNutricion e){
		evolucion.eliminarEvolucionTrasplanteNutricion(e);
		this.cambiarEstadoIngresoEvolucionVerdadero();
		this.lugar = Fachada.EVOLUCION_NUTRICION;
		this.cambie();
	}
	
	public ArrayList<EvolucionTrasplanteExamenes> obtenerTodosEvolucionExamenes(int id, Calendar fecha){
		return evolucion.obtenerTodosEvolucionExamenes(id, fecha);
	}
	
	
	
	public void guardarEvolucionTrasplanteExamenes(EvolucionTrasplanteExamenes e){
		evolucion.guardarEvolucionTrasplanteExamenes(e);
		this.cambiarEstadoIngresoEvolucionVerdadero();
		this.lugar = Fachada.EVOLUCION_TRASPLANTE_EXAMENES;
		this.cambie();
	}
	public void eliminarEvolucionTrasplanteExamenes(EvolucionTrasplanteExamenes e){
		evolucion.eliminarEvolucionTrasplanteExamenes(e);
		this.cambiarEstadoIngresoEvolucionVerdadero();
		this.lugar = Fachada.EVOLUCION_TRASPLANTE_EXAMENES;
		this.cambie();
	}
	
	public EvolucionTrasplanteEcografia buscarEvolucionTrasplanteEcografia(int id, Calendar fecha){
		return evolucion.buscarEvolucionTrasplanteEcografia(id,fecha);
	}
	
	public void guardarEvolucionTrasplanteEcografia(EvolucionTrasplanteEcografia e){
		evolucion.guardarEvolucionTrasplanteEcografia(e);
		this.cambiarEstadoIngresoEvolucionVerdadero();
		this.lugar = Fachada.EVOLUCION_TRASPLANTE_EXAMENES;
		this.cambie();
	}
	
	public void eliminarEvolucionTrasplanteEcografia(EvolucionTrasplanteEcografia e){
		evolucion.eliminarEvolucionTrasplanteEcografia(e);
		this.cambiarEstadoIngresoEvolucionVerdadero();
		this.lugar = Fachada.EVOLUCION_TRASPLANTE_EXAMENES;
		this.cambie();
	}
	
	public EvolucionTrasplanteEcoDopler buscarEvolucionTrasplanteEcoDopler(int id, Calendar fecha){
		return evolucion.buscarEvolucionTrasplanteEcoDopler(id,fecha);
	}
	
	public void guardarEvolucionTrasplanteEcoDopler(EvolucionTrasplanteEcoDopler e){
		evolucion.guardarEvolucionTrasplanteEcoDopler(e);
		this.cambiarEstadoIngresoEvolucionVerdadero();
		this.lugar = Fachada.EVOLUCION_TRASPLANTE_EXAMENES;
		this.cambie();
	}
	
	public void eliminarEvolucionTrasplanteEcoDopler(EvolucionTrasplanteEcoDopler e){
		evolucion.eliminarEvolucionTrasplanteEcoDopler(e);
		this.cambiarEstadoIngresoEvolucionVerdadero();
		this.lugar = Fachada.EVOLUCION_TRASPLANTE_EXAMENES;
		this.cambie();
	}
	
	public ArrayList<RaTratamiento> obtenerTodosRaTratamiento(){
		return evolucion.obtenerTodosRaTratamiento();
	}
	
	public void guardarRaTratamiento(RaTratamiento m){
		evolucion.guardarRaTratamiento(m);
		this.cambie();
	}
	
	public void eliminarRaTratamiento(RaTratamiento m){
		evolucion.eliminarRaTratamiento(m);
		this.cambie();
	}
	//Evolucion del injerto.
	
	public boolean fechaEvolucionInjertoCorrecta(int idPreTrasplante,Calendar c){
		return trasplantes.fechaEvolucionInjertoCorrecta(idPreTrasplante,c); 
	}
	
	
	
	public void guardarEvolucionInjerto(EvolucionInjerto aux){
		evolucion.guardarEvolucionInjerto(aux);
		this.lugar = Fachada.EVOLUCION_INJERTO;
		this.cambie();
	}
	
	public ArrayList<EvolucionInjerto> obtenertodosEvolucionInjerto(int idPretrasplante){
		return evolucion.obtenertodosEvolucionInjerto(idPretrasplante);
	}
	
	public void eliminarEvolucionInjerto(EvolucionInjerto aux){
		evolucion.eliminarEvolucionInjerto(aux);
		this.lugar = Fachada.EVOLUCION_INJERTO;
		this.cambie();
	}
	
	public boolean verificarEliminacionAntecedenteDonante(AntecedentesDonante a){
		return datosFijos.verificarEliminacionAntecedenteDonante(a);
	}
	
	public boolean verificarEliminacionCausaMuerteDonante(CausaMuerteDonante a){
		return datosFijos.verificarEliminacionCausaMuerteDonante(a);
	}
	
	public boolean verificarEliminacionCausaMuertePaciente(CausaMuertePaciente a){
		return datosFijos.verificarEliminacionCausaMuertePaciente(a);
	}
	
	public boolean verificarEliminacionCausaPerdidaInjerto(CausaPerdidaInjerto a){
		return datosFijos.verificarEliminacionCausaPerdidaInjerto(a);
	}
	
	public boolean verificarEliminacionGermenes(Germenes a){
		return datosFijos.verificarEliminacionGermenes(a);
	}
	
	public boolean verificarEliminacionInduccion(Induccion i){
		return datosFijos.verificarEliminacionInduccion(i);
	}
	
	public boolean verificarEliminacionInfeccion(Infeccion i){
		return datosFijos.verificarEliminacionInfeccion(i);
	}
	
	public boolean verificarEliminacionInmunosupresor(Inmunosupresores i){
		return datosFijos.verificarEliminacionInmunosupresor(i);
	}
	
	public boolean verificarEliminacionMedicacion(Medicacion i){
		return datosFijos.verificarEliminacionMedicacion(i);
	}
	
	public boolean verificarEliminacionNefropatia(Nefropatia i){
		return datosFijos.verificarEliminacionNefropatia(i);
	}
	
	public boolean verificarEliminacionResultadoPBR(ResultadoPBR i){
		return datosFijos.verificarEliminacionResultadoPBR(i);
	}
	
	public boolean verificarEliminacionSerol(Serol i){
		return datosFijos.verificarEliminacionSerol(i);
	}
	
	public boolean verificarEliminacionSerolDatos(SerolDatos i){
		return datosFijos.verificarEliminacionSerolDatos(i);
	}
	
	public boolean verificarEliminacionTipoComplicacion(TrasplanteTiposComplicaciones i){
		return datosFijos.verificarEliminacionTipoComplicacion(i);
	}
	
	public boolean verificarEliminacionCMVEnfermedad(CMVEnfermedades i){
		return datosFijos.verificarEliminacionCMVEnfermedad(i);
	}
	
	public boolean verificarEliminacionRaTratamiento(RaTratamiento i){
		return datosFijos.verificarEliminacionRaTratamiento(i);
	}
	
	public boolean verificarEliminacionCMVDroga(CMVDrogas m){
		return datosFijos.verificarEliminacionCMVDroga(m);
	}
	
	public boolean verificarEliminacionCMVDiagnostico(CMVDiagnostico m){
		return datosFijos.verificarEliminacionCMVDiagnostico(m);
	}
	
	//Password
	public boolean cambiarPassword(char[] root, char[] pass1, char[] pass2, boolean isRoot){
		return datosFijos.cambiarPassword(root,pass1,pass2,isRoot);
	}
	
	public int verificarIngreso(char[] pass){
		return datosFijos.verificarIngreso(pass);
	}
	
	public int verificarIngresoRoot(char[] pass){
		return datosFijos.verificarIngresoRoot(pass);
	}
	
	public void crearPacienteDummie(){
		datosFijos.crearPacienteDummie();
	}
	
	//Consultas
	public ArrayList<Paciente> consultaXCausaMuerteDonante(CausaMuerteDonante c){
		return consultas.consultaXCausaMuerteDonante(c);
	}
	
	public Generico consultaPacientesTabaquismo(){
		return consultas.consultaPacientesTabaquismo();
	}
	
	public Generico consultaPacientesDislipemia(){
		return consultas.consultaPacientesDislipemia();
	}
	
	public Generico consultaIMCPacientesConObesidad(){
		return consultas.consultaIMCPacientesConObesidad();
	}
	
	public Generico consultaIMCPacientesSinObesidad(){
		return consultas.consultaIMCPacientesSinObesidad();
	}
	
	public Generico consultaPacientesConHta(){
		return consultas.consultaPacientesConHta();
	}

	public Generico consultaPacientesConDiabetes(){
		return consultas.consultaPacientesConDiabetes();
	}
	
	public Generico consultaPacientesPorSexo(){
		return consultas.consultaPacientesPorSexo();
	}
	
	public Generico consultaPacientesPorOrigen(){
		return consultas.consultaPacientesPorOrigen();
	}
	
	public Generico consultaPacientesPorEdad(){
		return consultas.consultaPacientesPorEdad();
	}
	
	public Generico consultaPacientesTiempoEnLista(){
		return consultas.consultaPacientesTiempoEnLista();
	}
	
	public Generico consultaPacientesMuerte(){
		return consultas.consultaPacientesMuerte();
	}
	
	public Generico consultaPacientesNefropatiasPBR(){
		return consultas.consultaPacientesNefropatiasPBR();
	}
	
	public Generico consultaTranfusionesEmbarazos(){
		return consultas.consultaTranfusionesEmbarazos();
	}
	
	public Generico consultaTipoSangrePacienteDonante(){
		return consultas.consultaTipoSangrePacienteDonante();
	}
	
	public Generico consultaNumArteriasVenasYUreter(){
		return consultas.consultaNumArteriasVenasYUreter();
	}
	
	public Generico consultaLadoRinhonAnomalia(){
		return consultas.consultaLadoRinhonAnomalia();
	}
	
	public Generico consultaDonanteCausaMuerte(int idCausa){
		return consultas.consultaDonanteCausaMuerte(idCausa);
	}
	
	public Generico consultaPacienteInastabilidadHemodinamica(){
		return consultas.consultaPacienteInastabilidadHemodinamica();
	}
	
	public Generico consultaPacienteEdadDonanteEdad(){
		return consultas.consultaPacienteEdadDonanteEdad();
	}
	
	public Generico consultaSexoPacienteDonante(){
		return consultas.consultaSexoPacienteDonante();
	}
	
	public Generico consultaTipoDonantePaciente(){
		return consultas.consultaTipoDonantePaciente();
	}
	
	public Generico consultaPacienteVariosTrasplantes(){
		return consultas.consultaPacienteVariosTrasplantes();
	}
	
	public Generico consultaPacienteFechaTrasplantes(){
		return consultas.consultaPacienteFechaTrasplantes();
	}
	
	public Generico consultaTrasplantesCompatibilidadIncompatibilidadPRA(){
		return consultas.consultaTrasplantesCompatibilidadIncompatibilidadPRA();
	}
	
	public Generico consultaTrasplantesPorCirugia(){
		return consultas.consultaTrasplantesPorCirugia();
	}
	
	public Generico consultaTrasplantesIsquemiaDiuresis(boolean diuresis){
		return consultas.consultaTrasplantesIsquemiaDiuresis(diuresis);
	}
	
	public Generico consultaTrasplantesInduccion(ArrayList<Induccion> listaInducciones){
		return consultas.consultaTrasplantesInduccion(listaInducciones);
	}
	
	public Generico consultaTrasplantesInmunosupresor(ArrayList<Inmunosupresores> listaInmunosupresores){
		return consultas.consultaTrasplantesInmunosupresor(listaInmunosupresores);
	}
	
	public Generico consultaTrasplantesDiuresisEnBQ(){
		return consultas.consultaTrasplantesDiuresisEnBQ();
	}
	
	public Generico consultaTransplantesConSangradoIOpLesionArterialYVenalRepefundir(){
		return consultas.consultaTransplantesConSangradoIOpLesionArterialYVenalRepefundir();
	}
	
	public Generico consultaTransplantesConSangradoIOpLesionArterialYVenalRepefundirOpciones(boolean i_op, boolean lesArt, boolean lesVen, boolean nec_rep){
		return this.consultas.consultaTransplantesConSangradoIOpLesionArterialYVenalRepefundirOpciones(i_op, lesArt, lesVen, nec_rep);
	}
	
	public Generico consultaTrasplantesGermenesInfecciones(int idGermen, int idInfeccion, boolean evolucion, FechaControl f){
		return consultas.consultaTrasplantesGermenesInfecciones(idGermen,idInfeccion,evolucion, f);
	}
	
	public Generico consultaPacientesReoperaciones(){
		return consultas.consultaPacientesReoperaciones();
	}
	
	public ArrayList<Integer> consultaComplicacionesPorMes(int desde, int hasta){
		return consultas.consultaComplicacionesPorMes(desde,hasta);
	}
	
	public ArrayList<Integer> consultaComplicacionesPorDias(int desde, int hasta){
		return consultas.consultaComplicacionesPorDias(desde,hasta);
	}
	
	public ArrayList<Integer> consultaComplicacionesPorYear(int desde, int hasta){
		return consultas.consultaComplicacionesPorYear(desde,hasta);
	}
	
	//Testeo
	public void guardarGenericoAuxiliar(GenericoAuxiliar ga){
		consultas.guardarGenericoAuxiliar(ga);
		this.lugar = Fachada.CREADOR_CONSULTAS;
		this.cambie();
	}
	
	public ArrayList<GenericoAuxiliar> obtenerTodasConsultasCreadas(){
		return consultas.obtenerTodasConsultasCreadas();
	}
	
	public void eliminarGenericoAuxiliar(GenericoAuxiliar ga){
		consultas.eliminarGenericoAuxiliar(ga);
		this.lugar = Fachada.CREADOR_CONSULTAS;
		this.cambie();
	}
	
	public Generico convertirAuxiliarGenerico(GenericoAuxiliar ga){
		return consultas.convertirAuxiliarGenerico(ga);
	}
	
	public Generico consultaPacientesCantidadComplicaciones(int desde,
			int hasta, int tipo) {
		return consultas.consultaPacientesCantidadComplicaciones(desde,hasta,tipo);
	}
	
	public Generico consultaPacientesComplicacionesInfecciosasEntreFechas(int desde,
			int hasta, int tipo){
		return consultas.consultaPacientesComplicacionesInfecciosasEntreFechas(desde,hasta,tipo);
	}
	
	public Generico consultaPacientesComplicacionesNoInfecciosasEntreFechas(int desde,
			int hasta, int tipo){
		return consultas.consultaPacientesComplicacionesNoInfecciosasEntreFechas(desde,hasta,tipo);
	}
	
	public Generico consultaPacientesComplicacionesInfecciosasDetalles(int desde,
			int hasta, int tipo, int the) {
		return consultas.consultaPacientesComplicacionesInfecciosasDetalles(desde,hasta,tipo,the);
	}
	
	public Generico consultaPacientesComplicacionesNoInfecciosasDetalles(int desde,
			int hasta, int tipo, int the) {
		return consultas.consultaPacientesComplicacionesNoInfecciosasDetalles(desde, hasta, tipo, the);
	}
}
