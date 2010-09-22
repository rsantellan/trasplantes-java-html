package uy.transplante.dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import persistencia.BrkEvolucionTrasplante;
import persistencia.broker.IPersistente;
import uy.transplante.auxiliares.fechas.ManejoFechas;

public class EvolucionTrasplante implements IPersistente{
	private int idTrasplante;
	private Calendar fecha;
	private double pas;
	private double pad;
	private double diuresis;
	private double peso;
	private double urea;
	private double creatinina;
	private double ht;
	private double hb;
	private double gb;
	private double plaquetas;
	private double sodio;
	private double potasio;
	private double cloro;
	private double calcio;
	private double fosforo;
	private double glicemia;
	private double uricemia;
	private double protU;
	private double cCreatinina;
	private double cUrea;
	private double naU;
	private double kU;
	private double cyaPV;
	private double cyaPP;
	private double fkP;
	private double mfmP;
	private double eveP;
	private double bd;
	private double bi;
	private double tgo;
	private double tgp;
	private double gammagt;
	private double fAlc;
	private double tProt;
	private double kptt;
	private double howell;
	private double fibrinogeno;
	private double colesterol;
	private double hdl;
	private double ldl;
	private double rAt;
	private double tg;
	private double hna1c;
	private double albumina;
	private double globulinas;
	private String pthi;
	private double numPthi;
	private String otros;
	
	private BrkEvolucionTrasplante broker = new BrkEvolucionTrasplante(this);
	
	public int getIdTrasplante() {
		return idTrasplante;
	}

	public void setIdTrasplante(int idPreTrasplante) {
		this.idTrasplante = idPreTrasplante;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public double getPas() {
		return pas;
	}

	public void setPas(double pas) {
		this.pas = pas;
	}

	public double getPad() {
		return pad;
	}

	public void setPad(double pad) {
		this.pad = pad;
	}

	public double getDiuresis() {
		return diuresis;
	}

	public void setDiuresis(double diuresis) {
		this.diuresis = diuresis;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getUrea() {
		return urea;
	}

	public void setUrea(double urea) {
		this.urea = urea;
	}

	public double getCreatinina() {
		return creatinina;
	}

	public void setCreatinina(double creatinina) {
		this.creatinina = creatinina;
	}

	public double getHt() {
		return ht;
	}

	public void setHt(double ht) {
		this.ht = ht;
	}

	public double getHb() {
		return hb;
	}

	public void setHb(double hb) {
		this.hb = hb;
	}

	public double getGb() {
		return gb;
	}

	public void setGb(double gb) {
		this.gb = gb;
	}

	public double getPlaquetas() {
		return plaquetas;
	}

	public void setPlaquetas(double plaquetas) {
		this.plaquetas = plaquetas;
	}

	public double getSodio() {
		return sodio;
	}

	public void setSodio(double sodio) {
		this.sodio = sodio;
	}

	public double getPotasio() {
		return potasio;
	}

	public void setPotasio(double potasio) {
		this.potasio = potasio;
	}

	public double getCloro() {
		return cloro;
	}

	public void setCloro(double cloro) {
		this.cloro = cloro;
	}

	public double getCalcio() {
		return calcio;
	}

	public void setCalcio(double calcio) {
		this.calcio = calcio;
	}

	public double getFosforo() {
		return fosforo;
	}

	public void setFosforo(double fosforo) {
		this.fosforo = fosforo;
	}

	public double getGlicemia() {
		return glicemia;
	}

	public void setGlicemia(double glicemia) {
		this.glicemia = glicemia;
	}

	public double getUricemia() {
		return uricemia;
	}

	public void setUricemia(double uricemia) {
		this.uricemia = uricemia;
	}

	public double getProtU() {
		return protU;
	}

	public void setProtU(double protU) {
		this.protU = protU;
	}

	public double getCCreatinina() {
		return cCreatinina;
	}

	public void setCCreatinina(double creatinina) {
		cCreatinina = creatinina;
	}

	public double getCUrea() {
		return cUrea;
	}

	public void setCUrea(double urea) {
		cUrea = urea;
	}

	public double getNaU() {
		return naU;
	}

	public void setNaU(double naU) {
		this.naU = naU;
	}

	public double getKU() {
		return kU;
	}

	public void setKU(double ku) {
		kU = ku;
	}

	public double getCyaPV() {
		return cyaPV;
	}

	public void setCyaPV(double cyaPV) {
		this.cyaPV = cyaPV;
	}

	public double getCyaPP() {
		return cyaPP;
	}

	public void setCyaPP(double cyaPP) {
		this.cyaPP = cyaPP;
	}

	public double getFkP() {
		return fkP;
	}

	public void setFkP(double fkP) {
		this.fkP = fkP;
	}

	public double getMfmP() {
		return mfmP;
	}

	public void setMfmP(double mfmP) {
		this.mfmP = mfmP;
	}

	public double getEveP() {
		return eveP;
	}

	public void setEveP(double eveP) {
		this.eveP = eveP;
	}

	public double getBd() {
		return bd;
	}

	public void setBd(double bd) {
		this.bd = bd;
	}

	public double getBi() {
		return bi;
	}

	public void setBi(double bi) {
		this.bi = bi;
	}

	public double getTgo() {
		return tgo;
	}

	public void setTgo(double tgo) {
		this.tgo = tgo;
	}

	public double getTgp() {
		return tgp;
	}

	public void setTgp(double tgp) {
		this.tgp = tgp;
	}

	public double getGammagt() {
		return gammagt;
	}

	public void setGammagt(double gammagt) {
		this.gammagt = gammagt;
	}

	public double getFAlc() {
		return fAlc;
	}

	public void setFAlc(double alc) {
		fAlc = alc;
	}

	public double getTProt() {
		return tProt;
	}

	public void setTProt(double prot) {
		tProt = prot;
	}

	public double getKptt() {
		return kptt;
	}

	public void setKptt(double kptt) {
		this.kptt = kptt;
	}

	public double getHowell() {
		return howell;
	}

	public void setHowell(double howell) {
		this.howell = howell;
	}

	public double getFibrinogeno() {
		return fibrinogeno;
	}

	public void setFibrinogeno(double fibrinogeno) {
		this.fibrinogeno = fibrinogeno;
	}

	public double getColesterol() {
		return colesterol;
	}

	public void setColesterol(double colesterol) {
		this.colesterol = colesterol;
	}

	public double getHdl() {
		return hdl;
	}

	public void setHdl(double hdl) {
		this.hdl = hdl;
	}

	public double getLdl() {
		return ldl;
	}

	public void setLdl(double ldl) {
		this.ldl = ldl;
	}

	public double getRAt() {
		return rAt;
	}

	public void setRAt(double at) {
		rAt = at;
	}

	public double getTg() {
		return tg;
	}

	public void setTg(double tg) {
		this.tg = tg;
	}

	public double getHna1c() {
		return hna1c;
	}

	public void setHna1c(double hna1c) {
		this.hna1c = hna1c;
	}

	public double getAlbumina() {
		return albumina;
	}

	public void setAlbumina(double albumina) {
		this.albumina = albumina;
	}

	public double getGlobulinas() {
		return globulinas;
	}

	public void setGlobulinas(double globulinas) {
		this.globulinas = globulinas;
	}

	public String getPthi() {
		return pthi;
	}

	public void setPthi(String pthi) {
		this.pthi = pthi;
	}

	public String getOtros() {
		return otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	public double getNumPthi() {
		return numPthi;
	}

	public void setNumPthi(double numPthi) {
		this.numPthi = numPthi;
	}

	public EvolucionTrasplante() {
		this.setFecha(new GregorianCalendar());
	}

	
	public void eliminar() {
		broker.eliminar();		
	}

	
	public int getOid() {
		//Tengo que ir a buscar si existe en tal caso, es una modificacion.
		ArrayList<EvolucionTrasplante> aux = this.obtenerTodos();
		if(aux.size()>0){
			return 1;
		}
		return 0;
	}

	
	public void guardar() {
		broker.guardar();
	}

	
	public void leer() {
		broker.leer();
	}

	@SuppressWarnings("all")
	public ArrayList<EvolucionTrasplante> obtenerTodos() {
		ArrayList<EvolucionTrasplante> salida = broker.obtenerTodos();
		return salida;
	}
	
	
	public String toString(){
		return "Evolucion correspondiente a : " + ManejoFechas.FORMATOESPANOL.format(this.getFecha().getTime());
	}

	
	public int contar() {
		// TODO Auto-generated method stub
		return 0;
	}

}
