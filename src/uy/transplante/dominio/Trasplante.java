package uy.transplante.dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import uy.transplante.auxiliares.fechas.ManejoFechas;

import persistencia.BrkTrasplante;
import persistencia.broker.basico.IPersistente;

public class Trasplante implements IPersistente{
	private int id;
	private int preTrasplante;
	private Calendar fecha;
	private Calendar fechaAlta;
	private int numTr;
	private Donante donante;
	private String numDonante;
	private boolean instabHemod;
	private String rinhon;
	private boolean anomaliaVasc;
	private int numArt;
	private int numVenas;
	private String ureter;
	private int numCompAB;
	private int numCompDR;
	private int numIncompAB;
	private int numIncompDR;
	private boolean autoac;
	private String praMax;
	private String praTR;
	private boolean transPrevias;
	private int numTransf;
	private String embarazo;
	private int numEmbarazo;
	private String liqPerfusion;
	private boolean tqDeBanco;
	private String ladoImplante;
	private String anastVenosa;
	private String anastArterial;
	private String anastUterial;
	private int tIsqCalMin;
	private int tIsqFriqHs;
	private int tIsqFriaMin;
	private int tIsqTibiaHs;
	private String Repercusion;
	private boolean sangradoIOp;
	private boolean lesionArterial;
	private boolean lesionVenosa;
	private boolean necesidadRepefundir;
	private String otrasComplicacionesQuirurgicas;
	private boolean diuresisIOp;
	private float crInicial;
	private int diaRecDiuresis;
	private int diaRecFuncional;
	private boolean dialisis;
	private int numDeHd;
	private String comentario;
	private EvolucionInjerto evolucion;
	private ArrayList<TrasplanteSerolUsado> listaSeroles = new ArrayList<TrasplanteSerolUsado>();
	private ArrayList<TrasplanteInduccionUsado> listaInducciones = new ArrayList<TrasplanteInduccionUsado>();
	private ArrayList<TrasplanteInmunosupresoresUsado> listaInmunosupresores = new ArrayList<TrasplanteInmunosupresoresUsado>();
	private ArrayList<TrasplanteReoperacion> listaReoperaciones = new ArrayList<TrasplanteReoperacion>();
	private ArrayList<TrasplanteComplicacionesNoInf> listaComplicacionesNoInf = new ArrayList<TrasplanteComplicacionesNoInf>();
	private ArrayList<TrasplanteComplicacionesInf> listaComplicacionesInf = new ArrayList<TrasplanteComplicacionesInf>();
	private ArrayList<EvolucionTrasplanteTotal> controlEvolucion = new ArrayList<EvolucionTrasplanteTotal>();
	private ArrayList<CMV> listaCMV = new ArrayList<CMV>();
	private BrkTrasplante broker = new BrkTrasplante(this);
	
	private boolean buscaCUrolPrimerMesNoObesos = false;
	private boolean buscaCUrolPrimerMesObesos = false;
	private boolean buscarCQObesosOtrasComplicaciones = false;
	private boolean buscarCQObesosLinfocele = false;
	private boolean buscarCQObesosInfeccionHe = false;
	private boolean buscarCQObesosHemaP = false;
	private boolean buscarCQObesosEventracion = false;
	private boolean buscarCQNoObesosOtrasComplicaciones = false;
	private boolean buscarCQNoObesosLinfocele = false;
	private boolean buscarCQNoObesosInfeccionHe = false;
	private boolean buscarCQNoObesosHemaP = false;
	private boolean buscarCQNoObesosEventracion = false;
	private boolean buscarVariosTrasplantes = false;
	private boolean buscarInestabHemo = false;
	private boolean buscarPaciente = false;
	private boolean buscarDonante = false;
	private boolean buscarDiuresis = false;
	private boolean buscarPorYear = false;
	private int buscarPorYearDato = 0;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPreTrasplante() {
		return preTrasplante;
	}

	public void setPreTrasplante(int the) {
		this.preTrasplante = the;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	
	public Calendar getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Calendar fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public int getNumTr() {
		return numTr;
	}

	public void setNumTr(int numTr) {
		this.numTr = numTr;
	}

	public Donante getDonante() {
		return donante;
	}

	public void setDonante(Donante donante) {
		this.donante = donante;
	}

	public String getNumDonante() {
		return numDonante;
	}

	public void setNumDonante(String numDonante) {
		this.numDonante = numDonante;
	}

	public boolean isInstabHemod() {
		return instabHemod;
	}

	public void setInstabHemod(boolean instabHemod) {
		this.instabHemod = instabHemod;
	}

	public String getRinhon() {
		return rinhon;
	}

	public void setRinhon(String rinhon) {
		this.rinhon = rinhon;
	}

	public boolean isAnomaliaVasc() {
		return anomaliaVasc;
	}

	public void setAnomaliaVasc(boolean anomaliaVasc) {
		this.anomaliaVasc = anomaliaVasc;
	}

	public int getNumArt() {
		return numArt;
	}

	public void setNumArt(int numArt) {
		this.numArt = numArt;
	}

	public int getNumVenas() {
		return numVenas;
	}

	public void setNumVenas(int numVenas) {
		this.numVenas = numVenas;
	}

	public String getUreter() {
		return ureter;
	}

	public void setUreter(String ureter) {
		this.ureter = ureter;
	}

	public int getNumCompAB() {
		return numCompAB;
	}

	public void setNumCompAB(int numCompAB) {
		this.numCompAB = numCompAB;
	}

	public int getNumCompDR() {
		return numCompDR;
	}

	public void setNumCompDR(int numCompDR) {
		this.numCompDR = numCompDR;
	}

	public int getNumIncompAB() {
		return numIncompAB;
	}

	public void setNumIncompAB(int numIncompAB) {
		this.numIncompAB = numIncompAB;
	}

	public int getNumIncompDR() {
		return numIncompDR;
	}

	public void setNumIncompDR(int numIncompDR) {
		this.numIncompDR = numIncompDR;
	}

	public boolean isAutoac() {
		return autoac;
	}

	public void setAutoac(boolean autoac) {
		this.autoac = autoac;
	}

	public String getPraMax() {
		return praMax;
	}

	public void setPraMax(String praMax) {
		this.praMax = praMax;
	}

	public String getPraTR() {
		return praTR;
	}

	public void setPraTR(String praTR) {
		this.praTR = praTR;
	}

	public boolean isTransPrevias() {
		return transPrevias;
	}

	public void setTransPrevias(boolean transPrevias) {
		this.transPrevias = transPrevias;
	}

	public int getNumTransf() {
		return numTransf;
	}

	public void setNumTransf(int numTransf) {
		this.numTransf = numTransf;
	}

	public String getEmbarazo() {
		return embarazo;
	}

	public void setEmbarazo(String embarazo) {
		this.embarazo = embarazo;
	}

	public int getNumEmbarazo() {
		return numEmbarazo;
	}

	public void setNumEmbarazo(int numEmbarazo) {
		this.numEmbarazo = numEmbarazo;
	}

	public String getLiqPerfusion() {
		return liqPerfusion;
	}

	public void setLiqPerfusion(String liqPerfusion) {
		this.liqPerfusion = liqPerfusion;
	}

	public boolean isTqDeBanco() {
		return tqDeBanco;
	}

	public void setTqDeBanco(boolean tqDeBanco) {
		this.tqDeBanco = tqDeBanco;
	}

	public String getLadoImplante() {
		return ladoImplante;
	}

	public void setLadoImplante(String ladoImplante) {
		this.ladoImplante = ladoImplante;
	}

	public String getAnastVenosa() {
		return anastVenosa;
	}

	public void setAnastVenosa(String anastVenosa) {
		this.anastVenosa = anastVenosa;
	}

	public String getAnastArterial() {
		return anastArterial;
	}

	public void setAnastArterial(String anastArterial) {
		this.anastArterial = anastArterial;
	}

	public String getAnastUterial() {
		return anastUterial;
	}

	public void setAnastUterial(String anastUterial) {
		this.anastUterial = anastUterial;
	}

	public int getTIsqCalMin() {
		return tIsqCalMin;
	}

	public void setTIsqCalMin(int isqCalMin) {
		tIsqCalMin = isqCalMin;
	}

	public int getTIsqFriqHs() {
		return tIsqFriqHs;
	}

	public void setTIsqFriqHs(int isqFriqHs) {
		tIsqFriqHs = isqFriqHs;
	}

	public int getTIsqFriaMin() {
		return tIsqFriaMin;
	}

	public void setTIsqFriaMin(int isqFriaMin) {
		tIsqFriaMin = isqFriaMin;
	}

	public int getTIsqTibiaHs() {
		return tIsqTibiaHs;
	}

	public void setTIsqTibiaHs(int isqTibiaHs) {
		tIsqTibiaHs = isqTibiaHs;
	}

	public String getRepercusion() {
		return Repercusion;
	}

	public void setRepercusion(String repercusion) {
		Repercusion = repercusion;
	}

	public boolean isSangradoIOp() {
		return sangradoIOp;
	}

	public void setSangradoIOp(boolean sangradoIOp) {
		this.sangradoIOp = sangradoIOp;
	}

	public boolean isLesionArterial() {
		return lesionArterial;
	}

	public void setLesionArterial(boolean lesionArterial) {
		this.lesionArterial = lesionArterial;
	}

	public boolean isLesionVenosa() {
		return lesionVenosa;
	}

	public void setLesionVenosa(boolean lesionVenosa) {
		this.lesionVenosa = lesionVenosa;
	}

	public boolean isNecesidadRepefundir() {
		return necesidadRepefundir;
	}

	public void setNecesidadRepefundir(boolean necesidadRepefundir) {
		this.necesidadRepefundir = necesidadRepefundir;
	}

	public String getOtrasComplicacionesQuirurgicas() {
		return otrasComplicacionesQuirurgicas;
	}

	public void setOtrasComplicacionesQuirurgicas(
			String otrasComplicacionesQuirurgicas) {
		this.otrasComplicacionesQuirurgicas = otrasComplicacionesQuirurgicas;
	}

	public boolean isDiuresisIOp() {
		return diuresisIOp;
	}

	public void setDiuresisIOp(boolean diuresisIOp) {
		this.diuresisIOp = diuresisIOp;
	}

	public float getCrInicial() {
		return crInicial;
	}

	public void setCrInicial(float crInicial) {
		this.crInicial = crInicial;
	}

	public int getDiaRecDiuresis() {
		return diaRecDiuresis;
	}

	public void setDiaRecDiuresis(int diaRecDiuresis) {
		this.diaRecDiuresis = diaRecDiuresis;
	}

	public int getDiaRecFuncional() {
		return diaRecFuncional;
	}

	public void setDiaRecFuncional(int diaRecFuncional) {
		this.diaRecFuncional = diaRecFuncional;
	}

	public boolean isDialisis() {
		return dialisis;
	}

	public void setDialisis(boolean dialisis) {
		this.dialisis = dialisis;
	}

	public int getNumDeHd() {
		return numDeHd;
	}

	public void setNumDeHd(int numDeHd) {
		this.numDeHd = numDeHd;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public EvolucionInjerto getEvolucion() {
		return evolucion;
	}

	public void setEvolucion(EvolucionInjerto evolucion) {
		this.evolucion = evolucion;
	}

	public ArrayList<TrasplanteSerolUsado> getListaSeroles() {
		return listaSeroles;
	}

	public void setListaSeroles(ArrayList<TrasplanteSerolUsado> listaSeroles) {
		this.listaSeroles = listaSeroles;
	}

	public ArrayList<TrasplanteInduccionUsado> getListaInducciones() {
		return listaInducciones;
	}

	public void setListaInducciones(
			ArrayList<TrasplanteInduccionUsado> listaInducciones) {
		this.listaInducciones = listaInducciones;
	}

	public ArrayList<TrasplanteInmunosupresoresUsado> getListaInmunosupresores() {
		return listaInmunosupresores;
	}

	public void setListaInmunosupresores(
			ArrayList<TrasplanteInmunosupresoresUsado> listaInmunosupresores) {
		this.listaInmunosupresores = listaInmunosupresores;
	}

	
	public ArrayList<TrasplanteReoperacion> getListaReoperaciones() {
		return listaReoperaciones;
	}

	public void setListaReoperaciones(
			ArrayList<TrasplanteReoperacion> listaReoperaciones) {
		this.listaReoperaciones = listaReoperaciones;
	}

	
	public boolean isBuscarPaciente() {
		return buscarPaciente;
	}

	private void setBuscarPaciente(boolean buscarPaciente) {
		this.buscarPaciente = buscarPaciente;
	}

	public boolean isBuscarDonante() {
		return buscarDonante;
	}

	private void setBuscarDonante(boolean buscarDonante) {
		this.buscarDonante = buscarDonante;
	}


	public ArrayList<TrasplanteComplicacionesNoInf> getListaComplicacionesNoInf() {
		return listaComplicacionesNoInf;
	}

	public void setListaComplicacionesNoInf(
			ArrayList<TrasplanteComplicacionesNoInf> listaComplicacionesNoInf) {
		this.listaComplicacionesNoInf = listaComplicacionesNoInf;
	}

	public ArrayList<TrasplanteComplicacionesInf> getListaComplicacionesInf() {
		return listaComplicacionesInf;
	}

	public void setListaComplicacionesInf(
			ArrayList<TrasplanteComplicacionesInf> listaComplicacionesInf) {
		this.listaComplicacionesInf = listaComplicacionesInf;
	}
	
	public  ArrayList<EvolucionTrasplanteTotal> getControlEvolucion() {
		return controlEvolucion;
	}

	public void setControlEvolucion(ArrayList<EvolucionTrasplanteTotal> controlEvolucion) {
		this.controlEvolucion = controlEvolucion;
	}

	public ArrayList<CMV> getListaCMV() {
		return listaCMV;
	}

	public void setListaCMV(ArrayList<CMV> listaCMV) {
		this.listaCMV = listaCMV;
	}

	public boolean isBuscarVariosTrasplantes() {
		return buscarVariosTrasplantes;
	}

	private void setBuscarVariosTrasplantes(boolean buscarVariosTrasplantes) {
		this.buscarVariosTrasplantes = buscarVariosTrasplantes;
	}

	public boolean isBuscarInestabHemo() {
		return buscarInestabHemo;
	}

	private void setBuscarInestabHemo(boolean buscarInestabHemo) {
		this.buscarInestabHemo = buscarInestabHemo;
	}

	public boolean isBuscarDiuresis() {
		return buscarDiuresis;
	}

	private void setBuscarDiuresis(boolean buscarDiuresis) {
		this.buscarDiuresis = buscarDiuresis;
	}
	
	public boolean isBuscarCQNoObesosEventracion() {
		return buscarCQNoObesosEventracion;
	}

	private void setBuscarCQNoObesosEventracion(boolean buscarCQNoObesosEventracion) {
		this.buscarCQNoObesosEventracion = buscarCQNoObesosEventracion;
	}

	public boolean isBuscarCQNoObesosHemaP() {
		return buscarCQNoObesosHemaP;
	}

	private void setBuscarCQNoObesosHemaP(boolean buscarCQNoObesosHemaP) {
		this.buscarCQNoObesosHemaP = buscarCQNoObesosHemaP;
	}

	public boolean isBuscarCQNoObesosInfeccionHe() {
		return buscarCQNoObesosInfeccionHe;
	}

	private void setBuscarCQNoObesosInfeccionHe(boolean buscarCQNoObesosInfeccionHe) {
		this.buscarCQNoObesosInfeccionHe = buscarCQNoObesosInfeccionHe;
	}

	public boolean isBuscarCQNoObesosLinfocele() {
		return buscarCQNoObesosLinfocele;
	}

	private void setBuscarCQNoObesosLinfocele(boolean buscarCQNoObesosLinfocele) {
		this.buscarCQNoObesosLinfocele = buscarCQNoObesosLinfocele;
	}

	public boolean isBuscarCQNoObesosOtrasComplicaciones() {
		return buscarCQNoObesosOtrasComplicaciones;
	}

	private void setBuscarCQNoObesosOtrasComplicaciones(
			boolean buscarCQNoObesosOtrasComplicaciones) {
		this.buscarCQNoObesosOtrasComplicaciones = buscarCQNoObesosOtrasComplicaciones;
	}

	public boolean isBuscarCQObesosEventracion() {
		return buscarCQObesosEventracion;
	}

	private void setBuscarCQObesosEventracion(boolean buscarCQObesosEventracion) {
		this.buscarCQObesosEventracion = buscarCQObesosEventracion;
	}

	public boolean isBuscarCQObesosHemaP() {
		return buscarCQObesosHemaP;
	}

	private void setBuscarCQObesosHemaP(boolean buscarCQObesosHemaP) {
		this.buscarCQObesosHemaP = buscarCQObesosHemaP;
	}

	public boolean isBuscarCQObesosInfeccionHe() {
		return buscarCQObesosInfeccionHe;
	}

	private void setBuscarCQObesosInfeccionHe(boolean buscarCQObesosInfeccionHe) {
		this.buscarCQObesosInfeccionHe = buscarCQObesosInfeccionHe;
	}

	public boolean isBuscarCQObesosLinfocele() {
		return buscarCQObesosLinfocele;
	}

	private void setBuscarCQObesosLinfocele(boolean buscarCQObesosLinfocele) {
		this.buscarCQObesosLinfocele = buscarCQObesosLinfocele;
	}

	public boolean isBuscarCQObesosOtrasComplicaciones() {
		return buscarCQObesosOtrasComplicaciones;
	}

	private void setBuscarCQObesosOtrasComplicaciones(
			boolean buscarCQObesosOtrasComplicaciones) {
		this.buscarCQObesosOtrasComplicaciones = buscarCQObesosOtrasComplicaciones;
	}
	
	
	
	public boolean isBuscaCUrolPrimerMesNoObesos() {
		return buscaCUrolPrimerMesNoObesos;
	}
	
	@SuppressWarnings("all")
	private void setBuscaCUrolPrimerMesNoObesos(boolean buscaCUrolPrimerMesNoObesos) {
		this.buscaCUrolPrimerMesNoObesos = buscaCUrolPrimerMesNoObesos;
	}

	public boolean isBuscaCUrolPrimerMesObesos() {
		return buscaCUrolPrimerMesObesos;
	}

	@SuppressWarnings("all")
	private void setBuscaCUrolPrimerMesObesos(boolean buscaCUrolPrimerMesObesos) {
		this.buscaCUrolPrimerMesObesos = buscaCUrolPrimerMesObesos;
	}

	
	public boolean isBuscarPorYear() {
		return buscarPorYear;
	}

	private void setBuscarPorYear(boolean buscarPorYear) {
		this.buscarPorYear = buscarPorYear;
	}

	
	public int getBuscarPorYearDato() {
		return buscarPorYearDato;
	}

	private void setBuscarPorYearDato(int buscarPorYearDato) {
		this.buscarPorYearDato = buscarPorYearDato;
	}

	public Trasplante(){
		this.setId(0);
		this.setDonante(new Donante());
		this.setListaInducciones(new ArrayList<TrasplanteInduccionUsado>());
		this.setListaInmunosupresores(new ArrayList<TrasplanteInmunosupresoresUsado>());
		this.setListaSeroles(new ArrayList<TrasplanteSerolUsado>());
		this.setListaReoperaciones(new ArrayList<TrasplanteReoperacion>());
		this.setFecha(new GregorianCalendar());
		
	}
	
	public Trasplante(Trasplante t){
		this.setId(t.getId());
		this.setAnastArterial(t.getAnastArterial());
		this.setAnastUterial(t.getAnastUterial());
		this.setAnastVenosa(t.getAnastVenosa());
		this.setAnomaliaVasc(t.isAnomaliaVasc());
		this.setAutoac(t.isAutoac());
		this.setComentario(t.getComentario());
		this.setCrInicial(t.getCrInicial());
		this.setDialisis(t.isDialisis());
		this.setDiaRecDiuresis(t.getDiaRecDiuresis());
		this.setDiaRecFuncional(t.getDiaRecFuncional());
		this.setDiuresisIOp(t.isDiuresisIOp());
		this.setDonante(t.getDonante());
		this.setEmbarazo(t.getEmbarazo());
		this.setFecha(t.getFecha());
		this.setFechaAlta(t.getFechaAlta());
		this.setId(t.getId());
		this.setInstabHemod(t.isInstabHemod());
		this.setLadoImplante(t.getLadoImplante());
		this.setLesionArterial(t.isLesionArterial());
		this.setLesionVenosa(t.isLesionVenosa());
		this.setLiqPerfusion(t.getLiqPerfusion());
		this.setListaInducciones(t.getListaInducciones());
		this.setListaInmunosupresores(t.getListaInmunosupresores());
		this.setListaReoperaciones(t.getListaReoperaciones());
		this.setListaSeroles(t.getListaSeroles());
		this.setNecesidadRepefundir(t.isNecesidadRepefundir());
		this.setNumArt(t.getNumArt());
		this.setNumCompAB(t.getNumCompAB());
		this.setNumCompDR(t.getNumCompDR());
		this.setNumDeHd(t.getNumDeHd());
		this.setNumDonante(t.getNumDonante());
		this.setNumEmbarazo(t.getNumEmbarazo());
		this.setNumIncompAB(t.getNumIncompAB());
		this.setNumIncompDR(t.getNumIncompDR());
		this.setNumTr(t.getNumTr());
		this.setNumTransf(t.getNumTransf());
		this.setNumVenas(t.getNumVenas());
		this.setOtrasComplicacionesQuirurgicas(t.getOtrasComplicacionesQuirurgicas());
		this.setPraMax(t.getPraMax());
		this.setPraTR(t.getPraTR());
		this.setRepercusion(t.getRepercusion());
		this.setRinhon(t.getRinhon());
		this.setSangradoIOp(t.isSangradoIOp());
		this.setPreTrasplante(t.getPreTrasplante());
		this.setTIsqCalMin(t.getTIsqCalMin());
		this.setTIsqFriaMin(t.getTIsqFriaMin());
		this.setTIsqFriqHs(t.getTIsqFriqHs());
		this.setTIsqTibiaHs(t.getTIsqTibiaHs());
		this.setTqDeBanco(t.isTqDeBanco());
		this.setTransPrevias(t.isTransPrevias());
		this.setUreter(t.getUreter());
		this.setListaComplicacionesInf(t.getListaComplicacionesInf());
		this.setListaComplicacionesNoInf(t.getListaComplicacionesNoInf());
		this.setEvolucion(t.getEvolucion());
	}
	
	public void eliminar() {
		TrasplanteInduccionUsado auxLimpiar = new TrasplanteInduccionUsado();
		auxLimpiar.setIdTrasplante(this.getId());
		auxLimpiar.eliminar();
		TrasplanteInmunosupresoresUsado auxLimpiarInm = new TrasplanteInmunosupresoresUsado();
		auxLimpiarInm.setIdTrasplante(this.getId());
		auxLimpiarInm.eliminar();
		TrasplanteSerolUsado auxLimpiarSer = new TrasplanteSerolUsado();
		auxLimpiarSer.setIdTrasplante(this.getId());
		auxLimpiarSer.eliminar();
		TrasplanteReoperacion aux = new TrasplanteReoperacion();
		aux.setIdTrasplante(this.getId());
		aux.setFecha(null);
		aux.eliminar();
		TrasplanteComplicacionesNoInf auxLCNI = new TrasplanteComplicacionesNoInf();
		auxLCNI.setIdPretrasplante(this.getPreTrasplante());
		auxLCNI.borradoTotal();
		/*for(int x=0;x<this.getListaComplicacionesNoInf().size();x++){
			TrasplanteComplicacionesNoInf auxLCNI = this.getListaComplicacionesNoInf().get(x);
			auxLCNI.eliminar();
		}
		for(int x=0;x<this.getListaComplicacionesInf().size();x++){
			TrasplanteComplicacionesInf auxLCNI = this.getListaComplicacionesInf().get(x);
			auxLCNI.eliminar();
		}*/
		EvolucionTrasplanteTotal evoTotal = new EvolucionTrasplanteTotal();	
		evoTotal.setIdPreTrasplante(this.getPreTrasplante());
		evoTotal.setIdTrasplante(this.getId());
		evoTotal.eliminarTodo();
		/*this.setControlEvolucion(evoTotal.obtenerEvoluciones());
		for(int x=0;x<this.getControlEvolucion().size();x++){
			EvolucionTrasplanteTotal auxEvo = (EvolucionTrasplanteTotal) this.getControlEvolucion().get(x);
			auxEvo.eliminarTodo();
		}
		evoTotal.eliminarTodasComplicaciones();*/
		CMV auxCMV = new CMV();
		auxCMV.setIdTrasplante(this.getId());
		auxCMV.setFecha(null);
		auxCMV.eliminar();
		broker.eliminar();
	}

	
	public int getOid() {
		return this.getId();
	}

	
	public void guardar() {
		this.setNumDonante(this.getDonante().getId());
		broker.guardar();
		this.leerSoloTrasplante();
		boolean limpiar = true;
		for(int x=0;x<this.getListaInducciones().size();x++){
			TrasplanteInduccionUsado aux = this.getListaInducciones().get(x);
			aux.setIdTrasplante(this.getId());
			if(limpiar){
				TrasplanteInduccionUsado auxLimpiar = new TrasplanteInduccionUsado();
				auxLimpiar.setIdTrasplante(aux.getIdTrasplante());
				auxLimpiar.eliminar();
				limpiar = false;
			}
			aux.guardar();
		}
		limpiar = true;
		for(int x=0;x<this.getListaInmunosupresores().size();x++){
			TrasplanteInmunosupresoresUsado aux = this.getListaInmunosupresores().get(x);
			aux.setIdTrasplante(this.getId());
			if(limpiar){
				TrasplanteInmunosupresoresUsado auxLimpiar = new TrasplanteInmunosupresoresUsado();
				auxLimpiar.setIdTrasplante(aux.getIdTrasplante());
				auxLimpiar.eliminar();
				limpiar = false;
			}
			aux.guardar();
		}
		limpiar = true;
		for(int x=0;x<this.getListaSeroles().size();x++){
			TrasplanteSerolUsado aux = this.getListaSeroles().get(x);
			aux.setIdTrasplante(this.getId());
			if(limpiar){
				TrasplanteSerolUsado auxLimpiar = new TrasplanteSerolUsado();
				auxLimpiar.setIdTrasplante(aux.getIdTrasplante());
				auxLimpiar.eliminar();
				limpiar = false;
			}
			aux.guardar();
		}
		limpiar = true;
		for(int x=0;x<this.getListaReoperaciones().size();x++){
			TrasplanteReoperacion aux = this.getListaReoperaciones().get(x);
			aux.setIdTrasplante(this.getId());
			if(limpiar){
				aux.eliminar();
				limpiar = false;
			}
			aux.guardar();
		}
	}

	public Trasplante buscarTrasplanteDonante(Donante d){
		if(d == null) return null;
		this.setBuscarDonante(true);
		this.setDonante(d);
		this.leerSoloTrasplante();
		return this;
	}
	public void leerSoloTrasplante(){
		broker.leer();
	}
	
	public void leerPorPaciente(){
		this.setBuscarPaciente(true);
		this.leerDatosMinimos();
	}
	

	public void leerDatosReoperacion(){
		broker.leer();
		if(this.getId() != 0){
			TrasplanteReoperacion auxReo = new TrasplanteReoperacion();
			auxReo.setIdTrasplante(this.getId());
			this.setListaReoperaciones(auxReo.obtenerTodos());
		}
	}
	
	@SuppressWarnings("all")
	public void leerDatosMinimos(){
		broker.leer();
		if(this.getId() != 0){
			this.donante.setId(this.getNumDonante());
			this.donante.leer();
			EvolucionInjerto auxEvo = new EvolucionInjerto();
			auxEvo.setIdPretrasplante(this.getPreTrasplante());
			auxEvo.setFecha(null);
			auxEvo.setEnTrasplante(true);
			if(auxEvo.contar() != 0){
				auxEvo.leer();
			}else{
				auxEvo = null;
			}
			this.setEvolucion(auxEvo);
			//No Infecciosas
			TrasplanteComplicacionesNoInf tc = new TrasplanteComplicacionesNoInf();
			tc.setIdPretrasplante(this.getPreTrasplante());
			tc.setEvolucion(false);
			this.setListaComplicacionesNoInf(tc.obtenerTodos());
			//Infecciosas
			TrasplanteComplicacionesInf tcinf = new TrasplanteComplicacionesInf();
			tcinf.setIdPretrasplante(this.getPreTrasplante());
			tcinf.setEvolucion(false);
			this.setListaComplicacionesInf(tcinf.obtenerTodos());
		}
	}
	
	public void leerDatosParaBusqueda(){
		broker.leer();
		if(this.id == 0)return;
		this.donante.setId(this.getNumDonante());
		this.donante.leerMinimo();
		//No Infecciosas
		TrasplanteComplicacionesNoInf tc = new TrasplanteComplicacionesNoInf();
		tc.setIdPretrasplante(this.getPreTrasplante());
		tc.setEvolucion(false);
		this.setListaComplicacionesNoInf(tc.obtenerTodosBusqueda());
		//Infecciosas
		TrasplanteComplicacionesInf tcinf = new TrasplanteComplicacionesInf();
		tcinf.setIdPretrasplante(this.getPreTrasplante());
		tcinf.setEvolucion(false);
		this.setListaComplicacionesInf(tcinf.obtenerTodosBusqueda());
	}
	
	@SuppressWarnings("all")
	public void leerComplicaciones(){
		//No Infecciosas
		TrasplanteComplicacionesNoInf tc = new TrasplanteComplicacionesNoInf();
		tc.setIdPretrasplante(this.getPreTrasplante());
		tc.setEvolucion(false);
		this.setListaComplicacionesNoInf(tc.obtenerTodos());
		//Infecciosas
		TrasplanteComplicacionesInf tcinf = new TrasplanteComplicacionesInf();
		tcinf.setIdPretrasplante(this.getPreTrasplante());
		tcinf.setEvolucion(false);
		this.setListaComplicacionesInf(tcinf.obtenerTodos());
	}
	
	public void leer() {
		broker.leer();
		//this.getControlEvolucion().setIdTrasplante(this.getId());
		this.donante.setId(this.getNumDonante());
		this.donante.leer();
		ResultadoPBR resultado = new ResultadoPBR();
		resultado.leer();
		TrasplanteSerolUsado auxSerol = new TrasplanteSerolUsado();
		auxSerol.setIdTrasplante(this.getId());
		this.setListaSeroles(auxSerol.obtenerTodos());
		TrasplanteInmunosupresoresUsado auxInm = new TrasplanteInmunosupresoresUsado();
		auxInm.setIdTrasplante(this.getId());
		this.setListaInmunosupresores(auxInm.obtenerTodos());
		TrasplanteInduccionUsado auxInd = new TrasplanteInduccionUsado();
		auxInd.setIdTrasplante(this.getId());
		this.setListaInducciones(auxInd.obtenerTodos());
		TrasplanteReoperacion auxReo = new TrasplanteReoperacion();
		auxReo.setIdTrasplante(this.getId());
		this.setListaReoperaciones(auxReo.obtenerTodos());
	}

	public void leerInducciones(){
		TrasplanteInduccionUsado auxInd = new TrasplanteInduccionUsado();
		auxInd.setIdTrasplante(this.getId());
		this.setListaInducciones(auxInd.obtenerTodos());
	}
	
	public void leerInmunosupresores(){
		TrasplanteInmunosupresoresUsado auxInm = new TrasplanteInmunosupresoresUsado();
		auxInm.setIdTrasplante(this.getId());
		this.setListaInmunosupresores(auxInm.obtenerTodos());
	}
	
	public void leerEvolucionInjerto(){
		EvolucionInjerto auxEvo = new EvolucionInjerto();
		auxEvo.setIdPretrasplante(this.getPreTrasplante());
		auxEvo.setFecha(null);
		auxEvo.setEnTrasplante(true);
		if(auxEvo.contar() != 0){
			auxEvo.leer();
		}else{
			auxEvo = null;
		}
		this.setEvolucion(auxEvo);
	}
	
	@SuppressWarnings("all")
	public void leerMaximo(){
		broker.leer();
		if(this.getId() != 0){
			//this.getControlEvolucion().setIdTrasplante(this.getId());
			this.donante.setId(this.getNumDonante());
			this.donante.leer();
			/*ResultadoPBR resultado = new ResultadoPBR();
			resultado.leer();*/
			TrasplanteSerolUsado auxSerol = new TrasplanteSerolUsado();
			auxSerol.setIdTrasplante(this.getId());
			this.setListaSeroles(auxSerol.obtenerTodos());
			TrasplanteInmunosupresoresUsado auxInm = new TrasplanteInmunosupresoresUsado();
			auxInm.setIdTrasplante(this.getId());
			this.setListaInmunosupresores(auxInm.obtenerTodos());
			TrasplanteInduccionUsado auxInd = new TrasplanteInduccionUsado();
			auxInd.setIdTrasplante(this.getId());
			this.setListaInducciones(auxInd.obtenerTodos());
			TrasplanteReoperacion auxReo = new TrasplanteReoperacion();
			auxReo.setIdTrasplante(this.getId());
			this.setListaReoperaciones(auxReo.obtenerTodos());
			//No Infecciosas
			TrasplanteComplicacionesNoInf tc = new TrasplanteComplicacionesNoInf();
			tc.setIdPretrasplante(this.getPreTrasplante());
			tc.setEvolucion(false);
			this.setListaComplicacionesNoInf(tc.obtenerTodos());
			//Infecciosas
			TrasplanteComplicacionesInf tcinf = new TrasplanteComplicacionesInf();
			tcinf.setIdPretrasplante(this.getPreTrasplante());
			tcinf.setEvolucion(false);
			this.setListaComplicacionesInf(tcinf.obtenerTodos());
		}
	}
	
	public void leerTodosLosDatos(){
		if(this.getId() != 0){
			TrasplanteSerolUsado auxSerol = new TrasplanteSerolUsado();
			auxSerol.setIdTrasplante(this.getId());
			this.setListaSeroles(auxSerol.obtenerTodos());
			TrasplanteInmunosupresoresUsado auxInm = new TrasplanteInmunosupresoresUsado();
			auxInm.setIdTrasplante(this.getId());
			this.setListaInmunosupresores(auxInm.obtenerTodos());
			TrasplanteInduccionUsado auxInd = new TrasplanteInduccionUsado();
			auxInd.setIdTrasplante(this.getId());
			this.setListaInducciones(auxInd.obtenerTodos());
		}
	}
	
	@SuppressWarnings("all")
	public ArrayList<Trasplante> obtenerTodosSoloTrasplante(){
		return broker.obtenerTodos();
	}
	
	public ArrayList<Trasplante> obtenerTodosInestabHemod(){
		this.setBuscarInestabHemo(true);
		return this.obtenerTodosSoloTrasplante();
	}
	
	public ArrayList<Trasplante> obtenerTodosTrasplanteDonante(){
		ArrayList<Trasplante> salida = obtenerTodosSoloTrasplante();
		for(int x=0;x<salida.size();x++){
			Trasplante t = salida.get(x);
			Donante d = new Donante();
			d.setId(t.getNumDonante());
			d.leer();
			t.setDonante(d);
		}
		return salida;
	}
	
	public ArrayList<Trasplante> obtenerTodos() {
		ArrayList<Trasplante> salida = obtenerTodosSoloTrasplante();
		for(int x=0;x<salida.size();x++){
			Trasplante t = salida.get(x);
			Donante d = new Donante();
			d.setId(t.getNumDonante());
			d.leer();
			t.setDonante(d);
			TrasplanteSerolUsado auxSerol = new TrasplanteSerolUsado();
			auxSerol.setIdTrasplante(t.getId());
			t.setListaSeroles(auxSerol.obtenerTodos());
			TrasplanteInmunosupresoresUsado auxInm = new TrasplanteInmunosupresoresUsado();
			auxInm.setIdTrasplante(t.getId());
			t.setListaInmunosupresores(auxInm.obtenerTodos());
			TrasplanteInduccionUsado auxInd = new TrasplanteInduccionUsado();
			auxInd.setIdTrasplante(t.getId());
			t.setListaInducciones(auxInd.obtenerTodos());
			TrasplanteReoperacion auxReo = new TrasplanteReoperacion();
			auxReo.setIdTrasplante(t.getId());
			t.setListaReoperaciones(auxReo.obtenerTodos());
		}
		return salida;
	}

	public ArrayList<Trasplante> obtenerTodosSeleccion() {
		ArrayList<Trasplante> salida = obtenerTodosSoloTrasplante();
		Donante d = new Donante();
		ArrayList<Donante> listaDonantes = d.obtenerTodosSoloDonante();
		for(int x=0;x<salida.size();x++){
			int y =0;
			Trasplante t = salida.get(x);
			boolean encontro = false;
			while(!encontro){
				Donante auxD = (Donante) listaDonantes.get(y); 
				if(t.getNumDonante().equalsIgnoreCase(auxD.getId())){
					t.setDonante(auxD);
					encontro = true;
				}
				y += 1;
			}
		}
		return salida;
	}
	public ArrayList<Trasplante> obtenerTodosConVariosTrasplantes(){
		this.setBuscarVariosTrasplantes(true);
		return this.obtenerTodosSoloTrasplante();
	}
	
	public ArrayList<Trasplante> obtenerTodosSinDiuresis(){
		this.setBuscarDiuresis(true);
		ArrayList<Trasplante> salida = obtenerTodosSoloTrasplante();
		for(int x=0;x<salida.size();x++){
			Trasplante t = salida.get(x);
			Donante d = new Donante();
			d.setId(t.getNumDonante());
			d.leer();
			t.setDonante(d);
		}
		return salida;
	}
	
	public ArrayList<Trasplante> obtenerTodosSoloInducciones(){
		ArrayList<Trasplante> salida = obtenerTodosSoloTrasplante();
		for(int x=0;x<salida.size();x++){
			Trasplante t = salida.get(x);
			TrasplanteInduccionUsado auxInd = new TrasplanteInduccionUsado();
			auxInd.setIdTrasplante(t.getId());
			t.setListaInducciones(auxInd.obtenerTodos());
		}
		return salida;
	}
	
	public ArrayList<Trasplante> obtenerTodosSoloInmunosupresores(){
		ArrayList<Trasplante> salida = obtenerTodosSoloTrasplante();
		for(int x=0;x<salida.size();x++){
			Trasplante t = salida.get(x);
			TrasplanteInmunosupresoresUsado auxInm = new TrasplanteInmunosupresoresUsado();
			auxInm.setIdTrasplante(t.getId());
			t.setListaInmunosupresores(auxInm.obtenerTodos());
		}
		return salida;
	}
	
	public ArrayList<Trasplante> obtenerTodosCQNoObesosEventr(){
		this.setBuscarCQNoObesosEventracion(true);
		ArrayList<Trasplante> salida =  obtenerTodosSoloTrasplante();
		for(int x=0;x<salida.size();x++){
			salida.get(x).leerDatosReoperacion();
		}
		return salida;
	}
	
	public ArrayList<Trasplante> obtenerTodosCQNoObesosHematomaP(){
		this.setBuscarCQNoObesosHemaP(true);
		ArrayList<Trasplante> salida = obtenerTodosSoloTrasplante();
		for(int x=0;x<salida.size();x++){
			salida.get(x).leerDatosReoperacion();
		}
		return salida;
	}
	
	public ArrayList<Trasplante> obtenerTodosCQNoObesosInfeccionHerida(){
		this.setBuscarCQNoObesosInfeccionHe(true);
		ArrayList<Trasplante> salida = obtenerTodosSoloTrasplante();
		for(int x=0;x<salida.size();x++){
			salida.get(x).leerDatosReoperacion();
		}
		return salida;
	}
	
	public ArrayList<Trasplante> obtenerTodosCQNoObesosLinfocele(){
		this.setBuscarCQNoObesosLinfocele(true);
		ArrayList<Trasplante> salida = obtenerTodosSoloTrasplante();
		for(int x=0;x<salida.size();x++){
			salida.get(x).leerDatosReoperacion();
		}
		return salida;
	}

	public ArrayList<Trasplante> obtenerTodosCQNoObesosOtrasComplicaciones(){
		this.setBuscarCQNoObesosOtrasComplicaciones(true);
		ArrayList<Trasplante> salida = obtenerTodosSoloTrasplante();
		for(int x=0;x<salida.size();x++){
			salida.get(x).leerDatosReoperacion();
		}
		return salida;
	}
	
	public ArrayList<Trasplante> obtenerTodosCQObesosEventr(){
		this.setBuscarCQObesosEventracion(true);
		ArrayList<Trasplante> salida =  obtenerTodosSoloTrasplante();
		for(int x=0;x<salida.size();x++){
			salida.get(x).leerDatosReoperacion();
		}
		return salida;
	}
	
	public ArrayList<Trasplante> obtenerTodosCQObesosHematomaP(){
		this.setBuscarCQObesosHemaP(true);
		ArrayList<Trasplante> salida = obtenerTodosSoloTrasplante();
		for(int x=0;x<salida.size();x++){
			salida.get(x).leerDatosReoperacion();
		}
		return salida;
	}
	
	public ArrayList<Trasplante> obtenerTodosCQObesosInfeccionHerida(){
		this.setBuscarCQObesosInfeccionHe(true);
		ArrayList<Trasplante> salida = obtenerTodosSoloTrasplante();
		for(int x=0;x<salida.size();x++){
			salida.get(x).leerDatosReoperacion();
		}
		return salida;
	}
	
	public ArrayList<Trasplante> obtenerTodosCQObesosLinfocele(){
		this.setBuscarCQObesosLinfocele(true);
		ArrayList<Trasplante> salida = obtenerTodosSoloTrasplante();
		for(int x=0;x<salida.size();x++){
			salida.get(x).leerDatosReoperacion();
		}
		return salida;
	}

	public ArrayList<Trasplante> obtenerTodosCQObesosOtrasComplicaciones(){
		this.setBuscarCQObesosOtrasComplicaciones(true);
		ArrayList<Trasplante> salida = obtenerTodosSoloTrasplante();
		for(int x=0;x<salida.size();x++){
			salida.get(x).leerDatosReoperacion();
		}
		return salida;
	}
	
	public ArrayList<Trasplante> obtenerTodosDelYear(int year){
		this.setBuscarPorYear(true);
		this.setBuscarPorYearDato(year);
		ArrayList<Trasplante> salida = obtenerTodosSoloTrasplante();
		for(int x=0;x<salida.size();x++){
			salida.get(x).leerDatosReoperacion();
		}
		return salida;
	}
	
	public String toString(){
		return "Num:" + this.getNumTr() + " Fecha Trasplante : " + ManejoFechas.FORMATOESPANOL.format(this.getFecha().getTime()); //" Donante:"+ this.getDonante().toString();
	}

	
	public int contar() {
		return broker.contar();
	}
	
	public int getMeses(Calendar fechaDialisis) {
		int elapsed = 0;
		Calendar gc2,gc1,g1,g2;
		g1 = fechaDialisis;
		g2 = this.getFecha();
		//System.out.println(ManejoFechas.formatoEspanol.format(g1.getTime()));
		//System.out.println(ManejoFechas.formatoEspanol.format(g2.getTime()));
		if (g2.after(g1)) {
			gc2 = (Calendar) g2.clone();
			gc1 = (Calendar) g1.clone();
		} else {
			gc2 = (Calendar) g1.clone();
			gc1 = (Calendar) g2.clone();
		}
		while (gc1.before(gc2)) {
			gc1.add(Calendar.MONTH, 1);
			elapsed++;

		}
		return elapsed;
	}
}
