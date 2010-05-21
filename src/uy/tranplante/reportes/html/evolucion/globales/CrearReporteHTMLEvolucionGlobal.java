/**
 * 
 */
package uy.tranplante.reportes.html.evolucion.globales;

import java.util.ArrayList;
import java.util.Calendar;

import logica.Fachada;

import auxiliares.ManejoFechas;
import dominio.EvolucionTrasplante;
import dominio.EvolucionTrasplanteCMV;
import dominio.EvolucionTrasplanteECG;
import dominio.EvolucionTrasplanteEcoCardio;
import dominio.EvolucionTrasplanteEcoDopler;
import dominio.EvolucionTrasplanteEcografia;
import dominio.EvolucionTrasplanteExamenes;
import dominio.EvolucionTrasplanteMarvirales;
import dominio.EvolucionTrasplanteNutricion;
import dominio.EvolucionTrasplanteTotal;
import dominio.EvolucionTrasplanteTxTorax;

/**
 * @author rodrigo
 *
 */
public class CrearReporteHTMLEvolucionGlobal {

	private String delimiter = "\n";
	private ArrayList<EvolucionTrasplanteTotal> lista = new ArrayList<EvolucionTrasplanteTotal>();
	private int idTransplante = 0;
	
	public CrearReporteHTMLEvolucionGlobal(int idTransplante){
		EvolucionTrasplanteTotal aux = new EvolucionTrasplanteTotal();
		aux.setIdTrasplante(idTransplante);
		Fachada.getInstancia().cambie();
		this.lista = aux.obtenerEvoluciones();
		this.idTransplante = idTransplante;
	}
	
	public String crearReporteEvolucionCmv(){
		
		String aux = "";
		aux += "<div class='div_box'>" +  this.delimiter ;
		aux +="<p class='titulo'>Lista de CMV en evolucion</p>" +  this.delimiter ;
		aux +="<ol>" + this.delimiter;
		for(int x=0;x<lista.size();x++){
			Calendar fecha = lista.get(x).getFecha();
			EvolucionTrasplanteCMV auxCmv = new EvolucionTrasplanteCMV();
			auxCmv.setIdTrasplante(this.idTransplante);
			auxCmv.setFecha(fecha);
			ArrayList<EvolucionTrasplanteCMV> listaCMV = auxCmv.obtenerTodos();
			if (listaCMV.size() != 0) {
				aux +="<li>" +this.delimiter;
				aux =  this.reporteEvolucionCmv(listaCMV.get(0), aux);
				aux +="</li>" + this.delimiter;
			}
		}
		aux +="</ol>" + this.delimiter;
		aux +="</div> " +  this.delimiter ;
		return aux;
	}
	
	
	
	private String reporteEvolucionCmv(EvolucionTrasplanteCMV cmv, String aux){
		if(cmv != null){
			aux +="<ul class='lista_cmv'>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Fecha: </label>" +ManejoFechas.formatoEspanol.format(cmv.getFecha().getTime()) + "</li>" +  this.delimiter ;
			if(cmv.isAg_pp65()){
				aux +="<li><label class='label_cmv'>isAg_pp65: </label> SI </li>" +  this.delimiter ;
			}
			if(cmv.isIgG_CMV()){
				aux +="<li><label class='label_cmv'>isIgG_CMV: </label> SI </li>" +  this.delimiter ;
			}
			if(cmv.isIgM_CMV()){
				aux +="<li><label class='label_cmv'>isIgM_CMV: </label> SI </li>" +  this.delimiter ;
			}
			if(cmv.isPCR_CMV()){
				aux +="<li><label class='label_cmv'>isPCR_CMV: </label> SI </li>" +  this.delimiter ;
			}
			aux +="</ul>" +  this.delimiter ;
		}
		return aux;
	}
	
	public String crearReporteEvolucionEcg(){
		
		String aux = "";
		aux += "<div class='div_box'>" +  this.delimiter ;
		aux +="<p class='titulo'>Lista de ECG en evolucion</p>" +  this.delimiter ;
		aux +="<ol>" + this.delimiter;
		for(int x=0;x<lista.size();x++){
			Calendar fecha = lista.get(x).getFecha();
			EvolucionTrasplanteECG auxEcg = new EvolucionTrasplanteECG();
			auxEcg.setIdTrasplante(this.idTransplante);
			auxEcg.setFecha(fecha);
			ArrayList<EvolucionTrasplanteECG> listaECG = auxEcg.obtenerTodos();
			
			if (listaECG.size() != 0) {
				aux +="<li>" +this.delimiter;
				aux =  this.reporteEvolucionEcg(listaECG.get(0), aux);
				aux +="</li>" + this.delimiter;
			}
		}
		aux +="</ol>" + this.delimiter;
		aux +="</div> " +  this.delimiter ;
		return aux;
	}
	
	
	
	private String reporteEvolucionEcg(EvolucionTrasplanteECG ecg, String aux){
		if(ecg != null){
			aux +="<ul class='lista_cmv'>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Fecha: </label>" +ManejoFechas.formatoEspanol.format(ecg.getFecha().getTime()) + "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Rs: </label>"+ ecg.getRs() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Hvi: </label>"+ ecg.getHvi() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Onda Q: </label>"+ ecg.getOndaQ() +"</li>" +  this.delimiter ;
			aux +="</ul>" +  this.delimiter ;
		}
		return aux;
	}
	
	public String crearReporteEvolucionEcocardiograma(){
		
		String aux = "";
		aux += "<div class='div_box'>" +  this.delimiter ;
		aux +="<p class='titulo'>Lista de Ecocardiogramas en evolucion</p>" +  this.delimiter ;
		aux +="<ol>" + this.delimiter;
		for(int x=0;x<lista.size();x++){
			Calendar fecha = lista.get(x).getFecha();
			EvolucionTrasplanteEcoCardio auxEco = new EvolucionTrasplanteEcoCardio();
			auxEco.setIdTrasplante(this.idTransplante);
			auxEco.setFecha(fecha);
			ArrayList<EvolucionTrasplanteEcoCardio> listaEco = auxEco.obtenerTodos();
			
			if (listaEco.size() != 0) {
				aux +="<li>" +this.delimiter;
				aux =  this.reporteEvolucionEcocardiograma(listaEco.get(0), aux);
				aux +="</li>" + this.delimiter;
			}
		}
		aux +="</ol>" + this.delimiter;
		aux +="</div> " +  this.delimiter ;
		return aux;
	}
	
	
	
	private String reporteEvolucionEcocardiograma(EvolucionTrasplanteEcoCardio eco, String aux){
		if(eco != null){
			aux +="<ul class='lista_cmv'>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Fecha: </label>" +ManejoFechas.formatoEspanol.format(eco.getFecha().getTime()) + "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>FEVI > 55: </label>";
			if(eco.isFeviNormal()){
				aux += "SI";
			}else{
				aux += "NO";
			}
			aux += "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Insuficiencia Hipos: </label>";
			if(eco.isInsufHipodiast()){
				aux += "SI";
			}else{
				aux += "NO";
			}
			aux += "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>I Ao: </label>";
			if(eco.isIAo()){
				aux += "SI";
			}else{
				aux += "NO";
			}
			aux += "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>E Ao: </label>";
			if(eco.isEAo()){
				aux += "SI";
			}else{
				aux += "NO";
			}
			aux += "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>I M: </label>";
			if(eco.isIM()){
				aux += "SI";
			}else{
				aux += "NO";
			}
			aux += "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>E M: </label>";
			if(eco.isEM()){
				aux += "SI";
			}else{
				aux += "NO";
			}
			aux += "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>I P: </label>";
			if(eco.isIP()){
				aux += "SI";
			}else{
				aux += "NO";
			}
			aux += "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>E P: </label>";
			if(eco.isEP()){
				aux += "SI";
			}else{
				aux += "NO";
			}
			aux += "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>I T: </label>";
			if(eco.isIT()){
				aux += "SI";
			}else{
				aux += "NO";
			}
			aux += "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>E T: </label>";
			if(eco.isET()){
				aux += "SI";
			}else{
				aux += "NO";
			}
			aux += "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Derrame: </label>";
			if(eco.isDerrame()){
				aux += "SI";
			}else{
				aux += "NO";
			}
			aux += "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Calsificacion Valvular: </label>";
			if(eco.isCalcifValvular()){
				aux += "SI";
			}else{
				aux += "NO";
			}
			aux += "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>HVI: </label>";
			if(eco.isHvi()){
				aux += "SI";
			}else{
				aux += "NO";
			}
			aux += "</li>" +  this.delimiter ;
			aux +="</ul>" +  this.delimiter ;
		}
		return aux;
	}
	
	public String crearReporteEvolucionMarcadoresVirales(){
		
		String aux = "";
		aux += "<div class='div_box'>" +  this.delimiter ;
		aux +="<p class='titulo'>Lista de Marcadores Virales en evolucion</p>" +  this.delimiter ;
		aux +="<ol>" + this.delimiter;
		for(int x=0;x<lista.size();x++){
			Calendar fecha = lista.get(x).getFecha();
			EvolucionTrasplanteMarvirales auxMar = new EvolucionTrasplanteMarvirales();
			auxMar.setIdTrasplante(this.idTransplante);
			auxMar.setFecha(fecha);
			ArrayList<EvolucionTrasplanteMarvirales> listaMar = auxMar.obtenerTodos();
			
			if (listaMar.size() != 0) {
				aux +="<li>" +this.delimiter;
				aux =  this.reporteEvolucionMarcadoresVirales(listaMar.get(0), aux);
				aux +="</li>" + this.delimiter;
			}
		}
		aux +="</ol>" + this.delimiter;
		aux +="</div> " +  this.delimiter ;
		return aux;
	}
	
	
	
	private String reporteEvolucionMarcadoresVirales(EvolucionTrasplanteMarvirales mar, String aux){
		if(mar != null){
			aux +="<ul class='lista_cmv'>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Fecha: </label>" +ManejoFechas.formatoEspanol.format(mar.getFecha().getTime()) + "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Hbs Ag: </label>"+ mar.getAghbs() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Hbs Ac: </label>"+ mar.getHbsac() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Hbc Ac: </label>"+ mar.getHbcac() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>HVC: </label>"+ mar.getHvc() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>HIV: </label>"+ mar.getHiv() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Herpes Virus: </label>";
			if(mar.isHsv()){
				aux += "SI";
			}else{
				aux += "NO";
			}
			aux += "</li>" +  this.delimiter ;
			aux +="</ul>" +  this.delimiter ;
		}
		return aux;
	}
	
	public String crearReporteEvolucionTxTorax(){
		
		String aux = "";
		aux += "<div class='div_box'>" +  this.delimiter ;
		aux +="<p class='titulo'>Lista de Tx Torax en evolucion</p>" +  this.delimiter ;
		aux +="<ol>" + this.delimiter;
		for(int x=0;x<lista.size();x++){
			Calendar fecha = lista.get(x).getFecha();
			EvolucionTrasplanteTxTorax auxTx = new EvolucionTrasplanteTxTorax();
			auxTx.setIdTrasplante(this.idTransplante);
			auxTx.setFecha(fecha);
			ArrayList<EvolucionTrasplanteTxTorax> listaTx = auxTx.obtenerTodos();
			
			if (listaTx.size() != 0) {
				aux +="<li>" +this.delimiter;
				aux =  this.reporteEvolucionTxTorax(listaTx.get(0), aux);
				aux +="</li>" + this.delimiter;
			}
		}
		aux +="</ol>" + this.delimiter;
		aux +="</div> " +  this.delimiter ;
		return aux;
	}
	
	
	
	private String reporteEvolucionTxTorax(EvolucionTrasplanteTxTorax tx, String aux){
		if(tx != null){
			aux +="<ul class='lista_cmv'>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Fecha: </label>" +ManejoFechas.formatoEspanol.format(tx.getFecha().getTime()) + "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>RC/T: </label>"+ tx.getRct() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Foco: </label>";
			if(tx.isFoco()){
				aux += "SI";
			}else{
				aux += "NO";
			}
			aux += "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Lateralizado: </label>"+ tx.getLateralizado() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Derrame Pleural: </label>";
			if(tx.isDerramePleural()){
				aux += "SI";
			}else{
				aux += "NO";
			}
			aux += "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Lateral derrame: </label>"+ tx.getLateralDerrame() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Secuelas: </label>";
			if(tx.isSecuelas()){
				aux += "SI";
			}else{
				aux += "NO";
			}
			aux += "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Otros: </label>"+ tx.getOtros() +"</li>" +  this.delimiter ;
			aux +="</ul>" +  this.delimiter ;
		}
		return aux;
	}
	
	public String crearReporteEvolucionEcografiaDelInjerto(){
		
		String aux = "";
		aux += "<div class='div_box'>" +  this.delimiter ;
		aux +="<p class='titulo'>Lista de Ecografia del injerto en evolucion</p>" +  this.delimiter ;
		aux +="<ol>" + this.delimiter;
		for(int x=0;x<lista.size();x++){
			Calendar fecha = lista.get(x).getFecha();
			EvolucionTrasplanteEcografia eco = Fachada.getInstancia().buscarEvolucionTrasplanteEcografia(this.idTransplante, fecha);
			if(eco != null){
				aux +="<li>" +this.delimiter;
				aux =  this.reporteEvolucionEcografiaDelInjerto(eco, aux);
				aux +="</li>" + this.delimiter;
			}
		}
		aux +="</ol>" + this.delimiter;
		aux +="</div> " +  this.delimiter ;
		return aux;
	}
	
	
	
	private String reporteEvolucionEcografiaDelInjerto(EvolucionTrasplanteEcografia eco, String aux){
		if(eco != null){
			aux +="<ul class='lista_cmv'>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Fecha: </label>" +ManejoFechas.formatoEspanol.format(eco.getFecha().getTime()) + "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Diametros: </label>"+ eco.getDiametros() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Dilatación: </label>";
			if(eco.isDilatacion()){
				aux += "SI";
			}else{
				aux += "NO";
			}
			aux += "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Litiasin: </label>";
			if(eco.isLitiasin()){
				aux += "SI";
			}else{
				aux += "NO";
			}
			aux += "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Vegija: </label>"+ eco.getVejiga() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Espesor Control: </label>"+ eco.getEspesor() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Otros: </label>"+ eco.getOtros() +"</li>" +  this.delimiter ;
			aux +="</ul>" +  this.delimiter ;
		}
		return aux;
	}
	
	public String crearReporteEvolucionEcodopler(){
		String aux = "";
		aux += "<div class='div_box'>" +  this.delimiter ;
		aux +="<p class='titulo'>Lista de Ecodopler en evolucion</p>" +  this.delimiter ;
		aux +="<ol>" + this.delimiter;
		for(int x=0;x<lista.size();x++){
			Calendar fecha = lista.get(x).getFecha();
			EvolucionTrasplanteEcoDopler eco = Fachada.getInstancia().buscarEvolucionTrasplanteEcoDopler(this.idTransplante, fecha);
			if(eco != null){
				aux +="<li>" +this.delimiter;
				aux =  this.reporteEvolucionEcodopler(eco, aux);
				aux +="</li>" + this.delimiter;
			}
		}
		aux +="</ol>" + this.delimiter;
		aux +="</div> " +  this.delimiter ;
		return aux;
	}
	
	private String reporteEvolucionEcodopler(EvolucionTrasplanteEcoDopler eco, String aux){
		if(eco != null){
			aux +="<ul class='lista_cmv'>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Fecha: </label>" +ManejoFechas.formatoEspanol.format(eco.getFecha().getTime()) + "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Estructura: </label>"+ eco.getEstructura() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Dilatación: </label>";
			if(eco.isDilatacion()){
				aux += "SI";
			}else{
				aux += "NO";
			}
			aux += "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Colecciones: </label>";
			if(eco.isColecciones()){
				aux += "SI";
			}else{
				aux += "NO";
			}
			aux += "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Eje eliaco arterial: </label>"+ eco.getEjeArterial() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Eje eliaco venoso: </label>"+ eco.getEjeVenoso() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Arterial Renal: </label>"+ eco.getArteriaRenal() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Venal Renal: </label>"+ eco.getVenaRenal() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Anastomosis venosa: </label>"+ eco.getAnastVenosa() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Anastomosis renosa: </label>"+ eco.getAnastRenosa() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Otros: </label>"+ eco.getOtros() +"</li>" +  this.delimiter ;
			aux +="</ul>" +  this.delimiter ;
		}
		return aux;
	}
	
	public String crearReporteEvolucionOtrosExamenes(){
		String aux = "";
		aux += "<div class='div_box'>" +  this.delimiter ;
		aux +="<p class='titulo'>Lista de otros examenes en evolucion</p>" +  this.delimiter ;
		aux +="<ol>" + this.delimiter;
		for(int x=0;x<lista.size();x++){
			Calendar fecha = lista.get(x).getFecha();
			ArrayList<EvolucionTrasplanteExamenes> listaExamenes = Fachada.getInstancia().obtenerTodosEvolucionExamenes(this.idTransplante,fecha);  
			for (EvolucionTrasplanteExamenes evolucionTrasplanteExamenes : listaExamenes) {
				aux +="<li>" +this.delimiter;
				aux =  this.reporteEvolucionOtrosExamenes(evolucionTrasplanteExamenes, aux);
				aux +="</li>" + this.delimiter;
			}
		}
		aux +="</ol>" + this.delimiter;
		aux +="</div> " +  this.delimiter ;
		return aux;
	}
	
	private String reporteEvolucionOtrosExamenes(EvolucionTrasplanteExamenes eco, String aux){
		if(eco != null){
			aux +="<ul class='lista_cmv'>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Fecha: </label>" +ManejoFechas.formatoEspanol.format(eco.getFecha().getTime()) + "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Tipo de examen: </label>"+ eco.getTipo() +"</li>" +  this.delimiter ;
			if(eco.isNormal()){
				aux +="<li><label class='label_cmv'>Normal: </label>SI</li>";
			}else{
				aux +="<li><label class='label_cmv'>Patologico: </label>SI</li>";
				aux +="<li><label class='label_cmv'>Comentario: </label>"+eco.getComentario()+"</li>";
				
			}
			aux +="</ul>" +  this.delimiter ;
		}
		return aux;
	}
	
	public String crearReporteEvolucionNutricion(){
		String aux = "";
		aux += "<div class='div_box'>" +  this.delimiter ;
		aux +="<p class='titulo'>Lista de nutriciones en evolucion</p>" +  this.delimiter ;
		aux +="<ol>" + this.delimiter;
		for(int x=0;x<lista.size();x++){
			Calendar fecha = lista.get(x).getFecha();
			EvolucionTrasplanteNutricion auxNut = new EvolucionTrasplanteNutricion();
			auxNut.setIdTrasplante(this.idTransplante);
			auxNut.setFecha(fecha);
			ArrayList<EvolucionTrasplanteNutricion> listaNut = auxNut.obtenerTodos();
			for (EvolucionTrasplanteNutricion evolucionTrasplanteNutricion : listaNut) {
				aux +="<li>" +this.delimiter;
				aux =  this.reporteEvolucionNutricion(evolucionTrasplanteNutricion, aux);
				aux +="</li>" + this.delimiter;
			}
		}
		aux +="</ol>" + this.delimiter;
		aux +="</div> " +  this.delimiter ;
		return aux;
	}
	
	private String reporteEvolucionNutricion(EvolucionTrasplanteNutricion nut, String aux){
		if(nut != null){
			aux +="<ul class='lista_cmv'>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Fecha: </label>" +ManejoFechas.formatoEspanol.format(nut.getFecha().getTime()) + "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Talla: </label>"+ String.valueOf(nut.getTalla()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Peso deseado: </label>"+ String.valueOf(nut.getPesoDeseado()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Peso real: </label>"+ String.valueOf(nut.getPesoReal()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Estructura osea: </label>"+ nut.getEstructuraOsea() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Impresion clinica: </label>"+ nut.getImpresion() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Peso tricipital: </label>"+ String.valueOf(nut.getPTricipital()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Peso tricipital: </label>"+ nut.getPTricipitalP() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Peso subescapular: </label>"+ String.valueOf(nut.getPSubEscapular()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Peso subescapular: </label>"+ nut.getPSubEscapularP() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Suma pliegues: </label>"+ String.valueOf(nut.getSumPliegues()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Suma pliegues: </label>"+ nut.getPSumPliegues() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Cf Brazo: </label>"+ String.valueOf(nut.getCfBrazo()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Cf Brazo: </label>"+ nut.getPCfBrazo() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Cf Musculo Brazo: </label>"+ String.valueOf(nut.getCfMuscBrazo()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Cf Musculo Brazo: </label>"+ nut.getPCfMuscBrazo() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Area del brazo: </label>"+ String.valueOf(nut.getAreaBrazo()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Area musculo brazo: </label>"+ String.valueOf(nut.getAreaMuscBrazo()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Area musculo brazo: </label>"+ nut.getPAreaMuscBrazo() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Area grasa brazo: </label>"+ String.valueOf(nut.getAreaGrasaBrazo()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Area grasa brazo: </label>"+ nut.getPAreaGrasaBrazo() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Radio cintura cadera: </label>"+ String.valueOf(nut.getRCinturaCadera()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Diagnostico nutricional: </label>"+ nut.getDiagNutricional() +"</li>" +  this.delimiter ;
			aux +="</ul>" +  this.delimiter ;
		}
		return aux;
	}
	
	public String crearReporteEvolucionParaclinica(){
		String aux = "";
		aux += "<div class='div_box'>" +  this.delimiter ;
		aux +="<p class='titulo'>Lista de paraclinicas en evolucion</p>" +  this.delimiter ;
		aux +="<ol>" + this.delimiter;
		for(int x=0;x<lista.size();x++){
			Calendar fecha = lista.get(x).getFecha();
			
			EvolucionTrasplante auxEv = new EvolucionTrasplante();
			auxEv.setIdTrasplante(this.idTransplante);
			auxEv.setFecha(fecha);
			ArrayList<EvolucionTrasplante> listaEv = auxEv.obtenerTodos();
			for (EvolucionTrasplante evolucionTrasplante : listaEv) {
				aux +="<li>" +this.delimiter;
				aux =  this.reporteEvolucionParaclinica(evolucionTrasplante, aux);
				aux +="</li>" + this.delimiter;
			}
		}
		aux +="</ol>" + this.delimiter;
		aux +="</div> " +  this.delimiter ;
		return aux;
	}
	
	private String reporteEvolucionParaclinica(EvolucionTrasplante pc, String aux){
		if(pc != null){
			aux +="<ul class='lista_cmv'>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Fecha: </label>" +ManejoFechas.formatoEspanol.format(pc.getFecha().getTime()) + "</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>PAS: </label>"+ String.valueOf(pc.getPas()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>PAD: </label>"+ String.valueOf(pc.getPad()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Diuresis: </label>"+ String.valueOf(pc.getDiuresis()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Peso: </label>"+ String.valueOf(pc.getPeso()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Urea: </label>"+ String.valueOf(pc.getUrea()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Creatinina: </label>"+ String.valueOf(pc.getCreatinina()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>HT: </label>"+ String.valueOf(pc.getHt()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>GB: </label>"+ String.valueOf(pc.getGb()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Plaquetas: </label>"+ String.valueOf(pc.getPlaquetas()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Sodio: </label>"+ String.valueOf(pc.getSodio()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Potasio: </label>"+ String.valueOf(pc.getPotasio()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Cloro: </label>"+ String.valueOf(pc.getCloro()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Calcio: </label>"+ String.valueOf(pc.getCalcio()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Fosforo: </label>"+ String.valueOf(pc.getFosforo()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Glicemia: </label>"+ String.valueOf(pc.getGlicemia()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Uricemia: </label>"+ String.valueOf(pc.getUricemia()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Prot U: </label>"+ String.valueOf(pc.getProtU()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>C Creatinina: </label>"+ String.valueOf(pc.getCCreatinina()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>C Urea: </label>"+ String.valueOf(pc.getCUrea()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Na U: </label>"+ String.valueOf(pc.getNaU()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>K U: </label>"+ String.valueOf(pc.getKU()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>CyA PV: </label>"+ String.valueOf(pc.getCyaPV()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>CyA PP: </label>"+ String.valueOf(pc.getCyaPP()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Fk P: </label>"+ String.valueOf(pc.getFkP()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>MFM P: </label>"+ String.valueOf(pc.getMfmP()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>EVE P: </label>"+ String.valueOf(pc.getEveP()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>BD: </label>"+ String.valueOf(pc.getBd()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>BI: </label>"+ String.valueOf(pc.getBi()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Tgo: </label>"+ String.valueOf(pc.getTgo()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Tgp: </label>"+ String.valueOf(pc.getTgp()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Gamma gt: </label>"+ String.valueOf(pc.getGammagt()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>F Alc: </label>"+ String.valueOf(pc.getFAlc()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>T Prot: </label>"+ String.valueOf(pc.getTProt()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Kppt: </label>"+ String.valueOf(pc.getKptt()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Howell: </label>"+ String.valueOf(pc.getHowell()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Colesterol: </label>"+ String.valueOf(pc.getColesterol()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>hdl: </label>"+ String.valueOf(pc.getHdl()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Ldl: </label>"+ String.valueOf(pc.getLdl()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>R at: </label>"+ String.valueOf(pc.getRAt()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Tg: </label>"+ String.valueOf(pc.getTg()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>HbA 1c: </label>"+ String.valueOf(pc.getHna1c()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Albulimia: </label>"+ String.valueOf(pc.getAlbumina()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Globulina: </label>"+ String.valueOf(pc.getGlobulinas()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Fibrinogeno: </label>"+ String.valueOf(pc.getFibrinogeno()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>PTHi: </label>"+ pc.getPthi() +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>valor PTHi: </label>"+ String.valueOf(pc.getNumPthi()) +"</li>" +  this.delimiter ;
			aux +="<li><label class='label_cmv'>Otros: </label>"+ pc.getOtros() +"</li>" +  this.delimiter ;
			
			aux +="</ul>" +  this.delimiter ;
		}
		return aux;
	}
}
