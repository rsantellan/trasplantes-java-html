package dominio;

import java.util.ArrayList;
import java.util.Calendar;

import auxiliares.ManejoFechas;

public class EvolucionTrasplanteTotal {
	private int idTrasplante;
	private int idPreTrasplante;
	private Calendar fecha;
	private EvolucionTrasplante evoTrasplante = null;
	private EvolucionTrasplanteCMV evoTrasplanteCMV = null;
	private EvolucionTrasplanteECG evoTrasplanteECG = null;
	private EvolucionTrasplanteMarvirales evoTrasplanteMarvirales = null;
	private EvolucionTrasplanteEcoCardio evoTrasplanteEcoCardio = null;
	private EvolucionTrasplanteNutricion evoTrasplanteNutricion = null;
	private EvolucionTrasplanteTxTorax evoTrasplanteTxTorax = null;
	private EvolucionTrasplanteExamenes evoTrasplantesExamenes = null;
	private EvolucionTrasplanteEcografia evoTrasplantesEcografias = null;
	private EvolucionTrasplanteEcoDopler evoTrasplantesEcodopler = null;
	private ArrayList<TrasplanteComplicacionesNoInf> listaComplicacionesNoInf = new ArrayList<TrasplanteComplicacionesNoInf>();
	private ArrayList<TrasplanteComplicacionesInf> listaComplicacionesInf = new ArrayList<TrasplanteComplicacionesInf>();
	
	public int getIdTrasplante() {
		return idTrasplante;
	}
	
	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public void setIdTrasplante(int idTrasplante) {
		this.idTrasplante = idTrasplante;
	}
	
	public int getIdPreTrasplante() {
		return idPreTrasplante;
	}

	public void setIdPreTrasplante(int idPreTrasplante) {
		this.idPreTrasplante = idPreTrasplante;
	}

	public EvolucionTrasplante getEvoTrasplante() {
		return evoTrasplante;
	}

	public void setEvoTrasplante(EvolucionTrasplante evoTrasplante) {
		this.evoTrasplante = evoTrasplante;
	}

	public EvolucionTrasplanteCMV getEvoTrasplanteCMV() {
		return evoTrasplanteCMV;
	}

	public void setEvoTrasplanteCMV(EvolucionTrasplanteCMV evoTrasplanteCMV) {
		this.evoTrasplanteCMV = evoTrasplanteCMV;
	}

	public EvolucionTrasplanteECG getEvoTrasplanteECG() {
		return evoTrasplanteECG;
	}

	public void setEvoTrasplanteECG(EvolucionTrasplanteECG evoTrasplanteECG) {
		this.evoTrasplanteECG = evoTrasplanteECG;
	}

	public EvolucionTrasplanteMarvirales getEvoTrasplanteMarvirales() {
		return evoTrasplanteMarvirales;
	}

	public void setEvoTrasplanteMarvirales(
			EvolucionTrasplanteMarvirales evoTrasplanteMarvirales) {
		this.evoTrasplanteMarvirales = evoTrasplanteMarvirales;
	}

	public EvolucionTrasplanteEcoCardio getEvoTrasplanteEcoCardio() {
		return evoTrasplanteEcoCardio;
	}

	public void setEvoTrasplanteEcoCardio(
			EvolucionTrasplanteEcoCardio evoTrasplanteEcoCardio) {
		this.evoTrasplanteEcoCardio = evoTrasplanteEcoCardio;
	}

	public EvolucionTrasplanteNutricion getEvoTrasplanteNutricion() {
		return evoTrasplanteNutricion;
	}

	public void setEvoTrasplanteNutricion(
			EvolucionTrasplanteNutricion evoTrasplanteNutricion) {
		this.evoTrasplanteNutricion = evoTrasplanteNutricion;
	}

	public EvolucionTrasplanteTxTorax getEvoTrasplanteTxTorax() {
		return evoTrasplanteTxTorax;
	}

	public void setEvoTrasplanteTxTorax(
			EvolucionTrasplanteTxTorax evoTrasplanteTxTorax) {
		this.evoTrasplanteTxTorax = evoTrasplanteTxTorax;
	}

	public EvolucionTrasplanteExamenes getEvoTrasplantesExamenes() {
		return evoTrasplantesExamenes;
	}

	public void setEvoTrasplantesExamenes(
			EvolucionTrasplanteExamenes evoTrasplantesExamenes) {
		this.evoTrasplantesExamenes = evoTrasplantesExamenes;
	}

	public EvolucionTrasplanteEcografia getEvoTrasplantesEcografias() {
		return evoTrasplantesEcografias;
	}

	public void setEvoTrasplantesEcografias(
			EvolucionTrasplanteEcografia evoTrasplantesEcografias) {
		this.evoTrasplantesEcografias = evoTrasplantesEcografias;
	}

	public EvolucionTrasplanteEcoDopler getEvoTrasplantesEcodopler() {
		return evoTrasplantesEcodopler;
	}

	public void setEvoTrasplantesEcodopler(
			EvolucionTrasplanteEcoDopler evoTrasplantesEcodopler) {
		this.evoTrasplantesEcodopler = evoTrasplantesEcodopler;
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
	
	public ArrayList<String> fechasEvoluciones(){
		ArrayList<String> salida = new ArrayList<String>();
		EvolucionTrasplante aux = new EvolucionTrasplante();
		aux.setIdTrasplante(this.getIdTrasplante());
		aux.setFecha(null);
		ArrayList<EvolucionTrasplante> listaEvolucion = aux.obtenerTodos();
		for(int x = 0; x<listaEvolucion.size();x++){
			Calendar auxC = listaEvolucion.get(x).getFecha();
			String fecha = ManejoFechas.formatoEspanol.format(auxC.getTime());
			if(!salida.contains(fecha)){
				salida.add(fecha);
			}
		}
		EvolucionTrasplanteCMV auxCMV = new EvolucionTrasplanteCMV();
		auxCMV.setIdTrasplante(this.getIdTrasplante());
		auxCMV.setFecha(null);
		ArrayList<EvolucionTrasplanteCMV> listaCMV = auxCMV.obtenerTodos();
		for(int x=0;x<listaCMV.size(); x++){
			Calendar auxC = listaCMV.get(x).getFecha();
			String fecha = ManejoFechas.formatoEspanol.format(auxC.getTime());
			if(!salida.contains(fecha)){
				salida.add(fecha);
			}
		}
		EvolucionTrasplanteECG auxECG = new EvolucionTrasplanteECG();
		auxECG.setIdTrasplante(this.getIdTrasplante());
		auxECG.setFecha(null);
		ArrayList<EvolucionTrasplanteECG> listaECG = auxECG.obtenerTodos();
		for(int x=0;x<listaECG.size(); x++){
			Calendar auxC = listaECG.get(x).getFecha();
			String fecha = ManejoFechas.formatoEspanol.format(auxC.getTime());
			if(!salida.contains(fecha)){
				salida.add(fecha);
			}
		}
		EvolucionTrasplanteEcoCardio auxEco = new EvolucionTrasplanteEcoCardio();
		auxEco.setIdTrasplante(this.getIdTrasplante());
		auxEco.setFecha(null);
		ArrayList<EvolucionTrasplanteEcoCardio> listaEco = auxEco.obtenerTodos();
		for(int x=0;x<listaEco.size(); x++){
			Calendar auxC = listaEco.get(x).getFecha();
			String fecha = ManejoFechas.formatoEspanol.format(auxC.getTime());
			if(!salida.contains(fecha)){
				salida.add(fecha);
			}
		}
		EvolucionTrasplanteMarvirales auxMar = new EvolucionTrasplanteMarvirales();
		auxMar.setIdTrasplante(this.getIdTrasplante());
		auxMar.setFecha(null);
		ArrayList<EvolucionTrasplanteMarvirales> listaMar = auxMar.obtenerTodos();
		for(int x=0;x<listaMar.size(); x++){
			Calendar auxC = listaMar.get(x).getFecha();
			String fecha = ManejoFechas.formatoEspanol.format(auxC.getTime());
			if(!salida.contains(fecha)){
				salida.add(fecha);
			}
		}
		EvolucionTrasplanteNutricion auxNut = new EvolucionTrasplanteNutricion();
		auxNut.setIdTrasplante(this.getIdTrasplante());
		auxNut.setFecha(null);
		ArrayList<EvolucionTrasplanteNutricion> listaNut = auxNut.obtenerTodos();
		for(int x=0;x<listaNut.size(); x++){
			Calendar auxC = listaNut.get(x).getFecha();
			String fecha = ManejoFechas.formatoEspanol.format(auxC.getTime());
			if(!salida.contains(fecha)){
				salida.add(fecha);
			}
		}
		EvolucionTrasplanteTxTorax auxTx = new EvolucionTrasplanteTxTorax();
		auxTx.setIdTrasplante(this.getIdTrasplante());
		auxTx.setFecha(null);
		ArrayList<EvolucionTrasplanteTxTorax> listaTx = auxTx.obtenerTodos();
		for(int x=0;x<listaTx.size(); x++){
			Calendar auxC = listaTx.get(x).getFecha();
			String fecha = ManejoFechas.formatoEspanol.format(auxC.getTime());
			if(!salida.contains(fecha)){
				salida.add(fecha);
			}
		}
		return salida;
	}
	public ArrayList<EvolucionTrasplanteTotal> obtenerEvoluciones(){
		
		ArrayList<EvolucionTrasplanteTotal> salida =new ArrayList<EvolucionTrasplanteTotal>();
		EvolucionTrasplante aux = new EvolucionTrasplante();
		aux.setIdTrasplante(this.getIdTrasplante());
		aux.setFecha(null);
		ArrayList<EvolucionTrasplante> listaEvolucion = aux.obtenerTodos();
		for(int x = 0; x<listaEvolucion.size();x++){
			EvolucionTrasplanteTotal auxEvo = new EvolucionTrasplanteTotal();
			auxEvo.setIdTrasplante(listaEvolucion.get(x).getIdTrasplante());
			auxEvo.setFecha(listaEvolucion.get(x).getFecha());
			auxEvo.setEvoTrasplante(listaEvolucion.get(x));
			if(!salida.contains(auxEvo)){
				salida.add(auxEvo);
			}
		}
		EvolucionTrasplanteCMV auxCMV = new EvolucionTrasplanteCMV();
		auxCMV.setIdTrasplante(this.getIdTrasplante());
		auxCMV.setFecha(null);
		ArrayList<EvolucionTrasplanteCMV> listaCMV = auxCMV.obtenerTodos();
		for(int x=0;x<listaCMV.size(); x++){
			EvolucionTrasplanteTotal auxEvo = new EvolucionTrasplanteTotal();
			auxEvo.setIdTrasplante(listaCMV.get(x).getIdTrasplante());
			auxEvo.setFecha(listaCMV.get(x).getFecha());
			auxEvo.setEvoTrasplanteCMV(listaCMV.get(x));
			if(!salida.contains(auxEvo)){
				salida.add(auxEvo);
			}else{
				EvolucionTrasplanteTotal auxEvo1 = null;
				int indice = 0;
				boolean termino = false;
				while(indice < salida.size() && !termino){
					if(auxEvo.equals(salida.get(indice))){
						termino = true;
						auxEvo1 = salida.get(indice);
					}
					indice += 1;
				}
				auxEvo1.setEvoTrasplanteCMV(listaCMV.get(x));
			}
		}
		EvolucionTrasplanteECG auxECG = new EvolucionTrasplanteECG();
		auxECG.setIdTrasplante(this.getIdTrasplante());
		auxECG.setFecha(null);
		ArrayList<EvolucionTrasplanteECG> listaECG = auxECG.obtenerTodos();
		for(int x=0;x<listaECG.size(); x++){
			EvolucionTrasplanteTotal auxEvo = new EvolucionTrasplanteTotal();
			auxEvo.setIdTrasplante(listaECG.get(x).getIdTrasplante());
			auxEvo.setFecha(listaECG.get(x).getFecha());
			auxEvo.setEvoTrasplanteECG(listaECG.get(x));
			if(!salida.contains(auxEvo)){
				salida.add(auxEvo);
			}else{
				EvolucionTrasplanteTotal auxEvo1 = null;
				int indice = 0;
				boolean termino = false;
				while(indice < salida.size() && !termino){
					if(auxEvo.equals(salida.get(indice))){
						termino = true;
						auxEvo1 = salida.get(indice);
					}
					indice += 1;
				}
				auxEvo1.setEvoTrasplanteECG(listaECG.get(x));
			}
		}
		EvolucionTrasplanteEcoCardio auxEco = new EvolucionTrasplanteEcoCardio();
		auxEco.setIdTrasplante(this.getIdTrasplante());
		auxEco.setFecha(null);
		ArrayList<EvolucionTrasplanteEcoCardio> listaEco = auxEco.obtenerTodos();
		for(int x=0;x<listaEco.size(); x++){
			EvolucionTrasplanteTotal auxEvo = new EvolucionTrasplanteTotal();
			auxEvo.setIdTrasplante(listaEco.get(x).getIdTrasplante());
			auxEvo.setFecha(listaEco.get(x).getFecha());
			auxEvo.setEvoTrasplanteEcoCardio(listaEco.get(x));
			if(!salida.contains(auxEvo)){
				salida.add(auxEvo);
			}else{
				EvolucionTrasplanteTotal auxEvo1 = null;
				int indice = 0;
				boolean termino = false;
				while(indice < salida.size() && !termino){
					if(auxEvo.equals(salida.get(indice))){
						termino = true;
						auxEvo1 = salida.get(indice);
					}
					indice += 1;
				}
				auxEvo1.setEvoTrasplanteEcoCardio(listaEco.get(x));
			}
		}
		EvolucionTrasplanteMarvirales auxMar = new EvolucionTrasplanteMarvirales();
		auxMar.setIdTrasplante(this.getIdTrasplante());
		auxMar.setFecha(null);
		ArrayList<EvolucionTrasplanteMarvirales> listaMar = auxMar.obtenerTodos();
		for(int x=0;x<listaMar.size(); x++){
			EvolucionTrasplanteTotal auxEvo = new EvolucionTrasplanteTotal();
			auxEvo.setIdTrasplante(listaMar.get(x).getIdTrasplante());
			auxEvo.setFecha(listaMar.get(x).getFecha());
			auxEvo.setEvoTrasplanteMarvirales(listaMar.get(x));
			if(!salida.contains(auxEvo)){
				salida.add(auxEvo);
			}else{
				EvolucionTrasplanteTotal auxEvo1 = null;
				int indice = 0;
				boolean termino = false;
				while(indice < salida.size() && !termino){
					if(auxEvo.equals(salida.get(indice))){
						termino = true;
						auxEvo1 = salida.get(indice);
					}
					indice += 1;
				}
				auxEvo1.setEvoTrasplanteMarvirales(listaMar.get(x));
			}
		}
		EvolucionTrasplanteNutricion auxNut = new EvolucionTrasplanteNutricion();
		auxNut.setIdTrasplante(this.getIdTrasplante());
		auxNut.setFecha(null);
		ArrayList<EvolucionTrasplanteNutricion> listaNut = auxNut.obtenerTodos();
		for(int x=0;x<listaNut.size(); x++){
			EvolucionTrasplanteTotal auxEvo = new EvolucionTrasplanteTotal();
			auxEvo.setIdTrasplante(listaNut.get(x).getIdTrasplante());
			auxEvo.setFecha(listaNut.get(x).getFecha());
			auxEvo.setEvoTrasplanteNutricion(listaNut.get(x));
			if(!salida.contains(auxEvo)){
				salida.add(auxEvo);
			}else{
				EvolucionTrasplanteTotal auxEvo1 = null;
				int indice = 0;
				boolean termino = false;
				while(indice < salida.size() && !termino){
					if(auxEvo.equals(salida.get(indice))){
						termino = true;
						auxEvo1 = salida.get(indice);
					}
					indice += 1;
				}
				auxEvo1.setEvoTrasplanteNutricion(listaNut.get(x));
			}
		}
		
		EvolucionTrasplanteTxTorax auxTx = new EvolucionTrasplanteTxTorax();
		auxTx.setIdTrasplante(this.getIdTrasplante());
		auxTx.setFecha(null);
		ArrayList<EvolucionTrasplanteTxTorax> listaTx = auxTx.obtenerTodos();
		for(int x=0;x<listaTx.size(); x++){
			EvolucionTrasplanteTotal auxEvo = new EvolucionTrasplanteTotal();
			auxEvo.setIdTrasplante(listaTx.get(x).getIdTrasplante());
			auxEvo.setFecha(listaTx.get(x).getFecha());
			auxEvo.setEvoTrasplanteTxTorax(listaTx.get(x));
			if(!salida.contains(auxEvo)){
				salida.add(auxEvo);
			}else{
				EvolucionTrasplanteTotal auxEvo1 = null;
				int indice = 0;
				boolean termino = false;
				while(indice < salida.size() && !termino){
					if(auxEvo.equals(salida.get(indice))){
						termino = true;
						auxEvo1 = salida.get(indice);
					}
					indice += 1;
				}
				auxEvo1.setEvoTrasplanteTxTorax(listaTx.get(x));
			}
		}
		
		EvolucionTrasplanteEcoDopler auxEcoDop = new EvolucionTrasplanteEcoDopler();
		auxEcoDop.setIdTrasplante(this.getIdTrasplante());
		auxEcoDop.setFecha(null);
		ArrayList<EvolucionTrasplanteEcoDopler> listaEcodop = auxEcoDop.obtenerTodos();
		for(int x=0;x<listaEcodop.size();x++){
			EvolucionTrasplanteTotal auxEvo = new EvolucionTrasplanteTotal();
			auxEvo.setIdTrasplante(listaEcodop.get(x).getIdTrasplante());
			auxEvo.setFecha(listaEcodop.get(x).getFecha());
			auxEvo.setEvoTrasplantesEcodopler(listaEcodop.get(x));
			if(!salida.contains(auxEvo)){
				salida.add(auxEvo);
			}else{
				EvolucionTrasplanteTotal auxEvo1 = null;
				int indice = 0;
				boolean termino = false;
				while(indice < salida.size() && !termino){
					if(auxEvo.equals(salida.get(indice))){
						termino = true;
						auxEvo1 = salida.get(indice);
					}
					indice += 1;
				}
				auxEvo1.setEvoTrasplantesEcodopler(listaEcodop.get(x));
			}
		}
		
		EvolucionTrasplanteEcografia auxEcografia = new EvolucionTrasplanteEcografia();
		auxEcografia.setIdTrasplante(this.getIdTrasplante());
		auxEcografia.setFecha(null);
		ArrayList<EvolucionTrasplanteEcografia> listaEcografias = auxEcografia.obtenerTodos();
		for(int x=0;x<listaEcografias.size();x++){
			EvolucionTrasplanteTotal auxEvo = new EvolucionTrasplanteTotal();
			auxEvo.setIdTrasplante(listaEcografias.get(x).getIdTrasplante());
			auxEvo.setFecha(listaEcografias.get(x).getFecha());
			auxEvo.setEvoTrasplantesEcografias(listaEcografias.get(x));
			if(!salida.contains(auxEvo)){
				salida.add(auxEvo);
			}else{
				EvolucionTrasplanteTotal auxEvo1 = null;
				int indice = 0;
				boolean termino = false;
				while(indice < salida.size() && !termino){
					if(auxEvo.equals(salida.get(indice))){
						termino = true;
						auxEvo1 = salida.get(indice);
					}
					indice += 1;
				}
				auxEvo1.setEvoTrasplantesEcografias(listaEcografias.get(x));
			}
		}
		
		EvolucionTrasplanteExamenes auxExamenes = new EvolucionTrasplanteExamenes();
		auxExamenes.setIdTrasplante(this.getIdTrasplante());
		auxExamenes.setFecha(null);
		ArrayList<EvolucionTrasplanteExamenes> listaExames = auxExamenes.obtenerTodos();
		for(int x=0;x<listaExames.size();x++){
			EvolucionTrasplanteTotal auxEvo = new EvolucionTrasplanteTotal();
			auxEvo.setIdTrasplante(listaExames.get(x).getIdTrasplante());
			auxEvo.setFecha(listaExames.get(x).getFecha());
			auxEvo.setEvoTrasplantesExamenes(listaExames.get(x));
			if(!salida.contains(auxEvo)){
				salida.add(auxEvo);
			}else{
				EvolucionTrasplanteTotal auxEvo1 = null;
				int indice = 0;
				boolean termino = false;
				while(indice < salida.size() && !termino){
					if(auxEvo.equals(salida.get(indice))){
						termino = true;
						auxEvo1 = salida.get(indice);
					}
					indice += 1;
				}
				auxEvo1.setEvoTrasplantesExamenes(listaExames.get(x));
			}
		}
		return salida;
	}
	public void datosComplicacionesInf(){
		//Infecciosas
		TrasplanteComplicacionesInf tcinf = new TrasplanteComplicacionesInf();
		tcinf.setIdPretrasplante(this.getIdPreTrasplante());
		tcinf.setEvolucion(true);
		this.setListaComplicacionesInf(tcinf.obtenerTodos());
	}
	
	public void datosComplicacionesNoInf(){
		//No Infecciosas
		TrasplanteComplicacionesNoInf tc = new TrasplanteComplicacionesNoInf();
		tc.setIdPretrasplante(this.getIdPreTrasplante());
		tc.setEvolucion(true);
		this.setListaComplicacionesNoInf(tc.obtenerTodos());
	}

	public void eliminarTodasComplicaciones(){
		TrasplanteComplicacionesInf auxInf = new TrasplanteComplicacionesInf();
		auxInf.setIdPretrasplante(this.getIdPreTrasplante());
		auxInf.setInternado(false);
		auxInf.eliminar();
		TrasplanteComplicacionesNoInf auxNoInf = new TrasplanteComplicacionesNoInf();
		auxNoInf.setIdPretrasplante(this.getIdPreTrasplante());
		auxNoInf.setInternado(false);
		auxNoInf.eliminar();
	}
	
	public void eliminarTodo(){
		this.eliminarEvolucionTrasplante();
		this.eliminarEvolucionCMV();
		this.eliminarEvolucionECG();
		this.eliminarEvolucionEcoCardio();
		this.eliminarEvolucionMarvirales();
		this.eliminarEvolucionNutricion();
		this.eliminarEvolucionTxTorax();
		this.eliminarEvolucionEcoDopler();
		this.eliminarEvolucionEcografia();
		this.eliminarEvolucionExamenes();
	}
	
	private void eliminarEvolucionExamenes(){
		EvolucionTrasplanteExamenes aux = new EvolucionTrasplanteExamenes();
		aux.setIdTrasplante(this.getIdTrasplante());
		aux.setFecha(null);
		aux.eliminar();
	}
	private void eliminarEvolucionEcografia(){
		EvolucionTrasplanteEcografia aux = new EvolucionTrasplanteEcografia();
		aux.setIdTrasplante(this.getIdTrasplante());
		aux.setFecha(null);
		aux.eliminar();
	}
	
	private void eliminarEvolucionEcoDopler(){
		EvolucionTrasplanteEcoDopler aux = new EvolucionTrasplanteEcoDopler();
		aux.setIdTrasplante(this.getIdTrasplante());
		aux.setFecha(null);
		aux.eliminar();
	}
	private void eliminarEvolucionTxTorax(){
		EvolucionTrasplanteTxTorax aux = new EvolucionTrasplanteTxTorax();
		aux.setIdTrasplante(this.getIdTrasplante());
		aux.setFecha(null);
		aux.eliminar();
	}
	private void eliminarEvolucionNutricion(){
		EvolucionTrasplanteNutricion aux = new EvolucionTrasplanteNutricion();
		aux.setIdTrasplante(this.getIdTrasplante());
		aux.setFecha(null);
		aux.eliminar();
	}
	
	private void eliminarEvolucionMarvirales(){
		EvolucionTrasplanteMarvirales aux = new EvolucionTrasplanteMarvirales();
		aux.setIdTrasplante(this.getIdTrasplante());
		aux.setFecha(null);
		aux.eliminar();
	}
	
	private void eliminarEvolucionEcoCardio(){
		EvolucionTrasplanteEcoCardio aux = new EvolucionTrasplanteEcoCardio();
		aux.setIdTrasplante(this.getIdTrasplante());
		aux.setFecha(null);
		aux.eliminar();
	}
	private void eliminarEvolucionECG(){
		EvolucionTrasplanteECG aux = new EvolucionTrasplanteECG();
		aux.setIdTrasplante(this.getIdTrasplante());
		aux.setFecha(null);
		aux.eliminar();
	}
	private void eliminarEvolucionCMV(){
		EvolucionTrasplanteCMV aux = new EvolucionTrasplanteCMV();
		aux.setIdTrasplante(this.getIdTrasplante());
		aux.setFecha(null);
		aux.eliminar();
	}
	private void eliminarEvolucionTrasplante(){
		EvolucionTrasplante aux = new EvolucionTrasplante();
		aux.setIdTrasplante(this.getIdTrasplante());
		aux.setFecha(null);
		aux.eliminar();
	}
	
	public boolean equals(Object obj) {
		EvolucionTrasplanteTotal aux = (EvolucionTrasplanteTotal) obj;
		return ((this.getIdTrasplante() == aux.getIdTrasplante() && (this.getFecha().equals(aux.getFecha()))));
	}
}

