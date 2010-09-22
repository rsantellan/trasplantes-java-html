package uy.transplante.dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import persistencia.BrkEvolucionTrasplanteNutricion;
import persistencia.broker.basico.IPersistente;

public class EvolucionTrasplanteNutricion implements IPersistente{
	private int idTrasplante;
	private Calendar fecha;
	private int talla;
	private int pesoDeseado;
	private String estructuraOsea;
	private String impresion;
	private int pesoReal;
	private int pTricipital;
	private String pTricipitalP;
	private int pSubEscapular;
	private String pSubEscapularP;
	private int sumPliegues;
	private String pSumPliegues;
	private int cfBrazo;
	private String pCfBrazo;
	private int cfMuscBrazo;
	private String pCfMuscBrazo;
	private int areaBrazo;
	private int areaMuscBrazo;
	private String pAreaMuscBrazo;
	private int areaGrasaBrazo;
	private String pAreaGrasaBrazo;
	private int rCinturaCadera;
	private String diagNutricional;
	
	private BrkEvolucionTrasplanteNutricion broker = new BrkEvolucionTrasplanteNutricion(this);
	
	public int getIdTrasplante() {
		return idTrasplante;
	}
	public void setIdTrasplante(int idTrasplante) {
		this.idTrasplante = idTrasplante;
	}
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	
	public int getTalla() {
		return talla;
	}
	public void setTalla(int talla) {
		this.talla = talla;
	}
	public int getPesoDeseado() {
		return pesoDeseado;
	}
	public void setPesoDeseado(int pesoDeseado) {
		this.pesoDeseado = pesoDeseado;
	}
	public String getEstructuraOsea() {
		return estructuraOsea;
	}
	public void setEstructuraOsea(String estructuraOsea) {
		this.estructuraOsea = estructuraOsea;
	}
	public String getImpresion() {
		return impresion;
	}
	public void setImpresion(String impresion) {
		this.impresion = impresion;
	}
	public int getPesoReal() {
		return pesoReal;
	}
	public void setPesoReal(int pesoReal) {
		this.pesoReal = pesoReal;
	}
	public int getPTricipital() {
		return pTricipital;
	}
	public void setPTricipital(int tricipital) {
		pTricipital = tricipital;
	}
	public String getPTricipitalP() {
		return pTricipitalP;
	}
	public void setPTricipitalP(String tricipitalP) {
		pTricipitalP = tricipitalP;
	}
	public int getPSubEscapular() {
		return pSubEscapular;
	}
	public void setPSubEscapular(int subEscapular) {
		pSubEscapular = subEscapular;
	}
	public String getPSubEscapularP() {
		return pSubEscapularP;
	}
	public void setPSubEscapularP(String subEscapularP) {
		pSubEscapularP = subEscapularP;
	}
	public int getCfBrazo() {
		return cfBrazo;
	}
	public void setCfBrazo(int cfBrazo) {
		this.cfBrazo = cfBrazo;
	}
	public String getPCfBrazo() {
		return pCfBrazo;
	}
	public void setPCfBrazo(String cfBrazo) {
		pCfBrazo = cfBrazo;
	}
	public int getCfMuscBrazo() {
		return cfMuscBrazo;
	}
	public void setCfMuscBrazo(int cfMuscBrazo) {
		this.cfMuscBrazo = cfMuscBrazo;
	}
	public String getPCfMuscBrazo() {
		return pCfMuscBrazo;
	}
	public void setPCfMuscBrazo(String cfMuscBrazo) {
		pCfMuscBrazo = cfMuscBrazo;
	}
	public int getAreaBrazo() {
		return areaBrazo;
	}
	public void setAreaBrazo(int areaBrazo) {
		this.areaBrazo = areaBrazo;
	}
	public int getAreaMuscBrazo() {
		return areaMuscBrazo;
	}
	public void setAreaMuscBrazo(int areaMuscBrazo) {
		this.areaMuscBrazo = areaMuscBrazo;
	}
	public String getPAreaMuscBrazo() {
		return pAreaMuscBrazo;
	}
	public void setPAreaMuscBrazo(String areaMuscBrazo) {
		pAreaMuscBrazo = areaMuscBrazo;
	}
	public int getAreaGrasaBrazo() {
		return areaGrasaBrazo;
	}
	public void setAreaGrasaBrazo(int areaGrasaBrazo) {
		this.areaGrasaBrazo = areaGrasaBrazo;
	}
	public String getPAreaGrasaBrazo() {
		return pAreaGrasaBrazo;
	}
	public void setPAreaGrasaBrazo(String areaGrasaBrazo) {
		pAreaGrasaBrazo = areaGrasaBrazo;
	}
	public int getRCinturaCadera() {
		return rCinturaCadera;
	}
	public void setRCinturaCadera(int cinturaCadera) {
		rCinturaCadera = cinturaCadera;
	}
	public String getDiagNutricional() {
		return diagNutricional;
	}
	public void setDiagNutricional(String diagNutricional) {
		this.diagNutricional = diagNutricional;
	}
	public int getSumPliegues() {
		return sumPliegues;
	}
	public void setSumPliegues(int sumPliegues) {
		this.sumPliegues = sumPliegues;
	}
	public String getPSumPliegues() {
		return pSumPliegues;
	}
	public void setPSumPliegues(String sumPliegues) {
		pSumPliegues = sumPliegues;
	}
	
	public EvolucionTrasplanteNutricion() {
		this.setFecha(new GregorianCalendar());
	}
	
	
	public void eliminar() {
		broker.eliminar();
	}
	
	public int getOid() {
		ArrayList<EvolucionTrasplanteNutricion> aux = this.obtenerTodos();
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
	public ArrayList<EvolucionTrasplanteNutricion> obtenerTodos() {
		return broker.obtenerTodos();
	}
	
	public int contar() {
		// TODO Auto-generated method stub
		return 0;
	}
}
