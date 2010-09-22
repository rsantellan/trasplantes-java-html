package uy.transplante.dominio;

import java.util.ArrayList;

import persistencia.BrkDonante;
import persistencia.broker.basico.IPersistente;

public class Donante implements IPersistente{
	
	private String id;
	private String tipo;
	private String sexo;
	private int edad;
	private boolean enastabHemod;
	private CausaMuerteDonante causaMuerte;
	private int numCausaMuerte;
	private float crP;
	private String otros;
	private String grupoSanguineo;
	private String relacionFiliar;
	private int peso;
	private int talla;
	private ArrayList<AntecedentesDonante> antecedentes;
	private ArrayList<DonanterefAntecedentes> donRefAntecedentes;
	private ArrayList<OrganosDonante> organos;
	private ArrayList<DonanteSerolUsado> listaSeroles;
	private boolean libres = false;
	private boolean usados = false;
	private BrkDonante broker = new BrkDonante(this);
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isEnastabHemod() {
		return enastabHemod;
	}

	public void setEnastabHemod(boolean enastabHemod) {
		this.enastabHemod = enastabHemod;
	}

	public CausaMuerteDonante getCausaMuerte() {
		return causaMuerte;
	}

	public void setCausaMuerte(CausaMuerteDonante causaMuerte) {
		this.causaMuerte = causaMuerte;
	}

	public int getNumCausaMuerte() {
		return numCausaMuerte;
	}

	public void setNumCausaMuerte(int numCausaMuerte) {
		this.numCausaMuerte = numCausaMuerte;
	}

	public ArrayList<DonanteSerolUsado> getListaSeroles() {
		return listaSeroles;
	}

	public void setListaSeroles(ArrayList<DonanteSerolUsado> listaSeroles) {
		this.listaSeroles = listaSeroles;
	}

	public float getCrP() {
		return crP;
	}

	public void setCrP(float crP) {
		this.crP = crP;
	}

	public String getOtros() {
		return otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}
	
	public String getGrupoSanguineo() {
		return grupoSanguineo;
	}

	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}


	public ArrayList<AntecedentesDonante> getAntecedentes() {
		return antecedentes;
	}

	public void setAntecedentes(ArrayList<AntecedentesDonante> antecedentes) {
		this.antecedentes = antecedentes;
	}

	
	public ArrayList<DonanterefAntecedentes> getDonRefAntecedentes() {
		return donRefAntecedentes;
	}

	public void setDonRefAntecedentes(
			ArrayList<DonanterefAntecedentes> donRefAntecedentes) {
		this.donRefAntecedentes = donRefAntecedentes;
	}

	
	public ArrayList<OrganosDonante> getOrganos() {
		return organos;
	}

	public void setOrganos(ArrayList<OrganosDonante> organos) {
		this.organos = organos;
	}

	
	public String getRelacionFiliar() {
		return relacionFiliar;
	}

	public void setRelacionFiliar(String relacionFiliar) {
		this.relacionFiliar = relacionFiliar;
	}

	
	public boolean isLibres() {
		return libres;
	}

	private void setLibres(boolean libres) {
		this.libres = libres;
	}

	public boolean isUsados() {
		return usados;
	}

	public void setUsados(boolean usados) {
		this.usados = usados;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getTalla() {
		return talla;
	}

	public void setTalla(int talla) {
		this.talla = talla;
	}

	public Donante(){
		this.setId("");
		this.setAntecedentes(new ArrayList<AntecedentesDonante>());
		this.setCausaMuerte(new CausaMuerteDonante());
		this.setDonRefAntecedentes(new ArrayList<DonanterefAntecedentes>());
		this.setOrganos(new ArrayList<OrganosDonante>());
		this.setListaSeroles(new ArrayList<DonanteSerolUsado>());
		this.setLibres(false);
	}
	
	public Donante(Donante d){
		this.setAntecedentes(d.getAntecedentes());
		this.setCausaMuerte(d.getCausaMuerte());
		this.setCrP(d.getCrP());
		this.setDonRefAntecedentes(d.getDonRefAntecedentes());
		this.setEdad(d.getEdad());
		this.setEnastabHemod(d.isEnastabHemod());
		this.setGrupoSanguineo(d.getGrupoSanguineo());
		this.setId(d.getId());
		this.setListaSeroles(d.getListaSeroles());
		this.setNumCausaMuerte(d.getNumCausaMuerte());
		this.setOrganos(d.getOrganos());
		this.setOtros(d.getOtros());
		this.setRelacionFiliar(d.getRelacionFiliar());
		this.setSexo(d.getSexo());
		this.setTipo(d.getTipo());
		this.setLibres(false);
		this.setPeso(d.getPeso());
		this.setTalla(d.getTalla());
	}
	
	public void eliminar() {
		broker.eliminar();
		this.volcarAntecedentes();
		if(this.getDonRefAntecedentes().size()>0){
			this.getDonRefAntecedentes().get(0).eliminar();
		}
		if(this.getOrganos().size()>0){
			this.getOrganos().get(0).eliminar();
		}
		if(this.getListaSeroles().size()>0){
			DonanteSerolUsado aux = new DonanteSerolUsado();
			aux.setIdDonante(this.getId());
			aux.setSerol(null);
			aux.eliminar();
		}
	}

	@SuppressWarnings("all")
	private ArrayList<Donante> obtenerSoloParteDonantes(){
		return broker.obtenerTodos();	
	}
	
	public int getOid() {
		//Tendria que fijarme si existe en la base de datos...
		//Me fijo si existe en la base de datos si existe devuelvo 1 si no 0
		ArrayList<Donante> lista = this.obtenerSoloParteDonantes();
		int x=0;
		boolean existe = false;
		while(!existe && x<lista.size()){
			Donante aux = lista.get(x);
			if(aux.getId().equalsIgnoreCase(this.getId())){
				existe = true;
			}else{
				x++;
			}
		}
		if(existe){
			return 1;
		}else{
			return 0;
		}
	}

	
	public void guardar() {
		broker.guardar();
		this.volcarAntecedentes();
		//Hago esto por que asi no me tengo que estar complicando con los update y que si no esta borrarlo de vuelta
		if(this.getDonRefAntecedentes().size()>0){
			this.getDonRefAntecedentes().get(0).eliminar();
		}
		for(int x=0;x<this.getDonRefAntecedentes().size();x++){
			this.getDonRefAntecedentes().get(x).guardar();
		}
		if(this.getOrganos().size()>0){
			this.getOrganos().get(0).eliminar();
		}
		for(int k=0;k<this.getOrganos().size();k++){
			this.getOrganos().get(k).guardar();
		}
		DonanteSerolUsado aux = new DonanteSerolUsado();
		aux.setIdDonante(this.getId());
		aux.setSerol(null);
		aux.eliminar();
		for(int m=0;m<this.getListaSeroles().size();m++){
			 aux = this.listaSeroles.get(m);
			aux.setIdDonante(this.getId());
			aux.guardar();
		}
	}

	
	public void leer() {
		this.leerMinimo();
		this.leerDatos();
	}

	public void leerMinimo(){
		broker.leer();
	}
	
	public void leerDatos(){
		CausaMuerteDonante c = new CausaMuerteDonante();
		c.setId(this.getNumCausaMuerte());
		c.leer();
		this.setCausaMuerte(c);
		DonanterefAntecedentes da = new DonanterefAntecedentes();
		da.setIdDonante(this.getId());
		this.setDonRefAntecedentes(da.obtenerTodos());
		this.volcarDonanteRefAntecedentes();
		OrganosDonante od = new OrganosDonante();
		od.setId(this.getId());
		this.setOrganos(od.obtenerTodos());
		DonanteSerolUsado d = new DonanteSerolUsado();
		d.setIdDonante(this.getId());
		this.setListaSeroles(d.obtenerTodos());
	}
	
	@SuppressWarnings("all")
	public ArrayList<Donante> obtenerTodosSoloDonante() {
		return broker.obtenerTodos();
	}
	
	public ArrayList<Donante> obtenerTodos() {
		ArrayList<Donante> salida = obtenerTodosSoloDonante();
		CausaMuerteDonante c = new CausaMuerteDonante();
		ArrayList<CausaMuerteDonante> listaCausaMuerte = c.obtenerTodos();
		Serol s = new Serol();
		ArrayList<Serol> listaSeroles =  s.obtenerTodos();
		for(int x=0;x<salida.size();x++){
			Donante aux = salida.get(x);
			aux.setCausaMuerte(CausaMuerteDonante.devolverCausa(listaCausaMuerte, aux.getNumCausaMuerte()));
			DonanterefAntecedentes da = new DonanterefAntecedentes();
			da.setIdDonante(aux.getId());
			aux.setDonRefAntecedentes(da.obtenerTodos());
			aux.volcarDonanteRefAntecedentes();
			OrganosDonante od = new OrganosDonante();
			od.setId(aux.getId());
			aux.setOrganos(od.obtenerTodos());
			DonanteSerolUsado d = new DonanteSerolUsado();
			aux.setListaSeroles(d.obtenerLista(listaSeroles));
		}
		return salida;
	}

	public ArrayList<Donante> obtenerTodosUsados() {
		this.setUsados(true);
		ArrayList<Donante> salida = obtenerTodosSoloDonante();
		for(int x=0;x<salida.size();x++){
			Donante aux = salida.get(x);
			CausaMuerteDonante c = new CausaMuerteDonante();
			c.setId(aux.getNumCausaMuerte());
			c.leer();
			aux.setCausaMuerte(c);
			DonanterefAntecedentes da = new DonanterefAntecedentes();
			da.setIdDonante(aux.getId());
			aux.setDonRefAntecedentes(da.obtenerTodos());
			aux.volcarDonanteRefAntecedentes();
			OrganosDonante od = new OrganosDonante();
			od.setId(aux.getId());
			aux.setOrganos(od.obtenerTodos());
			DonanteSerolUsado d = new DonanteSerolUsado();
			d.setIdDonante(aux.getId());
			aux.setListaSeroles(d.obtenerTodos());
		}
		return salida;
	}
	
	public ArrayList<Donante> obtenerTodosLibres() {
		this.setLibres(true);
		ArrayList<Donante> salida = obtenerTodosSoloDonante();
		for(int x=0;x<salida.size();x++){
			Donante aux = salida.get(x);
			CausaMuerteDonante c = new CausaMuerteDonante();
			c.setId(aux.getNumCausaMuerte());
			c.leer();
			aux.setCausaMuerte(c);
			DonanterefAntecedentes da = new DonanterefAntecedentes();
			da.setIdDonante(aux.getId());
			aux.setDonRefAntecedentes(da.obtenerTodos());
			aux.volcarDonanteRefAntecedentes();
			OrganosDonante od = new OrganosDonante();
			od.setId(aux.getId());
			aux.setOrganos(od.obtenerTodos());
			DonanteSerolUsado d = new DonanteSerolUsado();
			d.setIdDonante(aux.getId());
			aux.setListaSeroles(d.obtenerTodos());
		}
		return salida;
	}
	
	
	public boolean equals(Object o){
		if(o == null)return false;
		Donante d = (Donante) o;
		return (this.getId().equalsIgnoreCase(d.getId()));
	}
	
	
	public String toString(){
		return this.getId();
	}

	private ArrayList<AntecedentesDonante> listaAntecedentesDonanteBusqueda = null;
	
	public void volcarDonanteRefAntecedentes(){
		this.getAntecedentes().clear();
		AntecedentesDonante a = new AntecedentesDonante();
		if(this.getDonRefAntecedentes().size() == 0) return;
		this.listaAntecedentesDonanteBusqueda = a.obtenerTodos();
		for(int x=0;x<this.getDonRefAntecedentes().size();x++){
			this.getAntecedentes().add(AntecedentesDonante.devolverAntecedente(this.listaAntecedentesDonanteBusqueda, this.getDonRefAntecedentes().get(x).getIdAntecedente()));
		}
	}
	
	public void volcarAntecedentes(){
		this.getDonRefAntecedentes().clear();
		for(int x=0;x<this.getAntecedentes().size();x++){
			AntecedentesDonante aux = this.getAntecedentes().get(x);
			DonanterefAntecedentes da = new DonanterefAntecedentes();
			da.setIdDonante(this.getId());
			da.setIdAntecedente(aux.getId());
			this.getDonRefAntecedentes().add(da);
		}
	}

	
	public int contar() {
		return broker.contar();
	}
}
