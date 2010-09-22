package uy.transplante.dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import persistencia.BrkPaciente;
import persistencia.broker.basico.IPersistente;

public class Paciente implements IPersistente{
	
//ATRIBUTOS
	private int the;
	private String ci;
	private String nombre;
	private String apellido;
	private int num_fnr;
	private String raza;
	private String sexo;
	private Calendar fecha_nacimiento; 
	private Calendar fecha_dialisis;
	private String grupoSanguineo;
	private Nefropatia tipoNefropatia;
	private int numNefropatia;
	private PacienteMuerte muertePaciente;
	private ArrayList<PacientePerdidaInjerto> listaPerdidas = new ArrayList<PacientePerdidaInjerto>();
	private ArrayList<PacientePreTrasplante> listaPreTrasplantes = new ArrayList<PacientePreTrasplante>();
	private BrkPaciente broker = new BrkPaciente(this);
	
	public Paciente() {
		super();
		this.fecha_dialisis = new GregorianCalendar();
		this.fecha_nacimiento = new GregorianCalendar();
		this.setCi("");
		this.setApellido("");
		this.setTipoNefropatia(new Nefropatia());

	}
	
	public Paciente(Paciente p){
		this.setApellido(p.getApellido());
		this.setCi(p.getCi());
		this.setFecha_dialisis(p.getFecha_dialisis());
		this.setFecha_nacimiento(p.getFecha_nacimiento());
		this.setGrupoSanguineo(p.getGrupoSanguineo());
		this.setMuertePaciente(p.getMuertePaciente());
		this.setNombre(p.getNombre());
		this.setNum_fnr(p.getNum_fnr());
		this.setNumNefropatia(p.getNumNefropatia());
		this.setRaza(p.getRaza());
		this.setSexo(p.getSexo());
		this.setThe(p.getThe());
		this.setTipoNefropatia(p.getTipoNefropatia());
		this.setListaPreTrasplantes(p.getListaPreTrasplantes());
		this.setListaPerdidas(p.getListaPerdidas());
	}

	public int getThe() {
		return the;
	}

	public void setThe(int the) {
		this.the = the;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getNum_fnr() {
		return num_fnr;
	}

	public void setNum_fnr(int num_fnr) {
		this.num_fnr = num_fnr;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Calendar getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Calendar fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Calendar getFecha_dialisis() {
		return fecha_dialisis;
	}

	public void setFecha_dialisis(Calendar fecha_dialisis) {
		this.fecha_dialisis = fecha_dialisis;
	}

	public String getGrupoSanguineo() {
		return grupoSanguineo;
	}

	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}

	public Nefropatia getTipoNefropatia() {
		return tipoNefropatia;
	}

	public void setTipoNefropatia(Nefropatia tipoNefropatia) {
		this.tipoNefropatia = tipoNefropatia;
	}

	public int getNumNefropatia() {
		return numNefropatia;
	}

	public void setNumNefropatia(int numNefropatia) {
		this.numNefropatia = numNefropatia;
	}
	
	
	public PacienteMuerte getMuertePaciente() {
		return muertePaciente;
	}

	public void setMuertePaciente(PacienteMuerte muertePaciente) {
		this.muertePaciente = muertePaciente;
	}

	public ArrayList<PacientePreTrasplante> getListaPreTrasplantes() {
		return listaPreTrasplantes;
	}

	public void setListaPreTrasplantes(
			ArrayList<PacientePreTrasplante> listaPreTrasplantes) {
		this.listaPreTrasplantes = listaPreTrasplantes;
	}

	public ArrayList<PacientePerdidaInjerto> getListaPerdidas() {
		return listaPerdidas;
	}

	public void setListaPerdidas(ArrayList<PacientePerdidaInjerto> listaPerdidas) {
		this.listaPerdidas = listaPerdidas;
	}

	public void eliminar() {
		//Elimino la perdida de injertos
		if(this.getListaPerdidas().size() > 0){
			for(int x=0;x<this.getListaPerdidas().size();x++){
				this.getListaPerdidas().get(x).eliminar();
			}
		}
		//Elimino la muerte del paciente
		if(this.getMuertePaciente() != null){
			this.getMuertePaciente().eliminar();
		}
		
		/*if(this.getListaPerdidas().size() !=0){
			for(int x=0;x<this.getListaPerdidas().size();x++){
				PacientePerdidaInjerto auxPer = (PacientePerdidaInjerto) this.getListaPerdidas().get(x);
				auxPer.eliminar();
			}
		}*/
		//Elimino los tratamientos
		Tratamiento t = new Tratamiento();
		t.setFecha_inicio(null);
		t.setThe(this.getThe());
		t.eliminar();
		//Elimino los preTrasplantes.
		if(this.getListaPreTrasplantes().size() != 0){
			for(int x=0;x<this.getListaPreTrasplantes().size();x++){
				PacientePreTrasplante auxPre = (PacientePreTrasplante) this.getListaPreTrasplantes().get(x);
				auxPre.eliminar();
			}
		}
		
		//Elimino el paciente
		broker.eliminar();
	}

	
	public int getOid() {
		return this.getThe();
	}

	
	public void guardar() {
		broker.guardar();
		broker.leer();
	}

	
	public void leer() {
		broker.leer();
		this.getTipoNefropatia().setId(this.getNumNefropatia());
		this.getTipoNefropatia().leer();
		PacienteMuerte pm = new PacienteMuerte();
		pm.setThe(this.getThe());
		pm.leer();
		if(pm.getFechaMuerte() != null){
			this.setMuertePaciente(pm);
		}
	}

	public void leerDatos(){
		this.getTipoNefropatia().setId(this.getNumNefropatia());
		this.getTipoNefropatia().leer();
		PacienteMuerte pm = new PacienteMuerte();
		pm.setThe(this.getThe());
		pm.leer();
		if(pm.getFechaMuerte() != null){
			this.setMuertePaciente(pm);
		}
		PacientePreTrasplante auxPre = new PacientePreTrasplante();
		auxPre.setThe(this.getThe());
		this.setListaPreTrasplantes(auxPre.obtenerTodos());
		PacientePerdidaInjerto auxPer = new PacientePerdidaInjerto();
		auxPer.setThe(this.getThe());
		this.setListaPerdidas(auxPer.obtenerTodos());
	}
	
	public void leerDatosBasicos(){
		this.getTipoNefropatia().setId(this.getNumNefropatia());
		this.getTipoNefropatia().leer();
		PacienteMuerte pm = new PacienteMuerte();
		pm.setThe(this.getThe());
		pm.leer();
		if(pm.getFechaMuerte() != null){
			this.setMuertePaciente(pm);
		}
		PacientePerdidaInjerto auxPer = new PacientePerdidaInjerto();
		auxPer.setThe(this.getThe());
		this.setListaPerdidas(auxPer.obtenerTodos());
	}
	
	public void leerDatosPreTrasplante(){
		PacientePreTrasplante auxPre = new PacientePreTrasplante();
		auxPre.setThe(this.getThe());
		this.setListaPreTrasplantes(auxPre.obtenerTodos());
	}
	
	public void leerDatosPerdidaInjerto(){
		PacientePerdidaInjerto auxPer = new PacientePerdidaInjerto();
		auxPer.setThe(this.getThe());
		this.setListaPerdidas(auxPer.obtenerTodos());
	}
	
	public void leerDatosMuerte(){
		PacienteMuerte pm = new PacienteMuerte();
		pm.setThe(this.getThe());
		pm.leer();
		if(pm.getFechaMuerte() != null){
			this.setMuertePaciente(pm);
		}
	}
	
	public void leerSoloPaciente(){
		broker.leer();
	}
	
	@SuppressWarnings("all")
	public ArrayList<Paciente> obtenerTodosSoloPaciente() {
		return broker.obtenerTodos();
	}
	
	public ArrayList<Paciente> obtenerTodos() {
		ArrayList<Paciente> salida = this.obtenerTodosSoloPaciente();
		for(int x=0;x<salida.size();x++){
			Paciente p = (Paciente) salida.get(x);
			p.getTipoNefropatia().setId(p.getNumNefropatia());
			p.getTipoNefropatia().leer();
		}
		return salida;
	}
	
	
	public String toString(){
		return "THE: " + this.getThe() + " Nombre: " + this.getApellido() + " " + this.getNombre();
	}

	public void eliminarMuertePaciente(){
		this.getMuertePaciente().eliminar();
		this.setMuertePaciente(null);
	}
	
	public int calcularEdad(Calendar fechaTrasplante){
	    Calendar today = fechaTrasplante;
	   
	    int diff_year = today.get(Calendar.YEAR) - this.getFecha_nacimiento().get(Calendar.YEAR);
	    int diff_month = today.get(Calendar.MONTH) - this.getFecha_nacimiento().get(Calendar.MONTH);
	    int diff_day = today.get(Calendar.DAY_OF_MONTH) - this.getFecha_nacimiento().get(Calendar.DAY_OF_MONTH);

	    //Si está en ese año pero todavía no los ha cumplido
	    if(diff_month<0 || (diff_month==0 && diff_day<0)){
	        diff_year = diff_year - 1; //no aparecéran los dos guiones del postincremento :|
	    }
	    return diff_year;
	}
	
	
	public PacientePreTrasplante obtenerUltimoPreTrasplante(){
		PacientePreTrasplante aux = new PacientePreTrasplante();
		aux.setThe(this.getThe());
		ArrayList<PacientePreTrasplante> lista = aux.obtenerTodos();
		if(lista.size() == 0){
			return null;
		}else{
			if(lista.size() == 1){
				return lista.get(0);
			}else{
				int indice = 1;
				aux = lista.get(indice);
				while (indice <lista.size()){
					PacientePreTrasplante aux1 =lista.get(indice);
					if(aux.getFecha_egreso().before(aux1.getFecha_egreso())){
						aux = aux1;
					}
					indice +=1;
				}
				return aux;
			}
		}
	}

	
	public int contar() {
		return broker.contar();
	}
	
	public static ArrayList<Paciente> clonar(ArrayList<Paciente> lista){
		ArrayList<Paciente> salida = new ArrayList<Paciente>();
		for(int x=0;x<lista.size();x++){
			Paciente aux = new Paciente(lista.get(x));
			salida.add(aux);
		}
		return salida;
	}
	
	public ArrayList<PacientePreTrasplante> buscarPreTrasplantePaciente(){
		PacientePreTrasplante pt = new PacientePreTrasplante();
		pt.setThe(this.getThe());
		return pt.obtenerTodos();
	}

	@Override
	public boolean equals(Object arg0) {
		if(arg0 == null)return false;
		Paciente aux = (Paciente) arg0;
		return this.the == aux.the;
	}
	
	
}
