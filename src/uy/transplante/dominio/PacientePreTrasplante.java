package uy.transplante.dominio;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import uy.transplante.auxiliares.fechas.ManejoFechas;
import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.dominio.BrkPacientePreTrasplante;

public class PacientePreTrasplante implements IPersistente {

	private int id;
	private int the;
	private Calendar fecha_ingreso_lista;
	private Calendar fecha_egreso;
	private String modalidad_d;
	private boolean pbr;
	private String diabetes;
	private boolean hta;
	private boolean obesidad;
	private String imc;
	private boolean dislipemia;
	private boolean tabaquismo;
	private boolean iam;
	private boolean ave;
	private boolean revascCardio;
	private String origen;
	private PacientePerdidaInjerto perdidaInjerto;
	private Trasplante trasplante = null;
	private boolean buscarDiabeticos = false;
	private boolean buscarHTA = false;
	private boolean buscarNoObesidad = false;
	private boolean buscarObesidad = false;
	private boolean buscarDislipemia = false;
	private boolean buscarTabaquismo = false;
	private BrkPacientePreTrasplante broker = new BrkPacientePreTrasplante(this);

	//Si la fecha es 01-01-1800
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getThe() {
		return the;
	}

	public void setThe(int the) {
		this.the = the;
	}

	public Calendar getFecha_ingreso_lista() {
		return fecha_ingreso_lista;
	}

	public void setFecha_ingreso_lista(Calendar fecha_ingreso_lista) {
		this.fecha_ingreso_lista = fecha_ingreso_lista;
	}

	public Calendar getFecha_egreso() {
		return fecha_egreso;
	}

	public void setFecha_egreso(Calendar fecha_egreso) {
		this.fecha_egreso = fecha_egreso;
	}

	public String getModalidad_d() {
		return modalidad_d;
	}

	public void setModalidad_d(String modalidad_d) {
		this.modalidad_d = modalidad_d;
	}

	public boolean isPbr() {
		return pbr;
	}

	public void setPbr(boolean pbr) {
		this.pbr = pbr;
	}

	public String getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(String diabetes) {
		this.diabetes = diabetes;
	}

	public boolean isHta() {
		return hta;
	}

	public void setHta(boolean hta) {
		this.hta = hta;
	}

	public boolean isObesidad() {
		return obesidad;
	}

	public void setObesidad(boolean obesidad) {
		this.obesidad = obesidad;
	}

	public String getImc() {
		return imc;
	}

	public void setImc(String imc) {
		this.imc = imc;
	}

	public boolean isDislipemia() {
		return dislipemia;
	}

	public void setDislipemia(boolean dislipemia) {
		this.dislipemia = dislipemia;
	}

	public boolean isTabaquismo() {
		return tabaquismo;
	}

	public void setTabaquismo(boolean tabaquismo) {
		this.tabaquismo = tabaquismo;
	}

	/**
	 * @return the iam
	 */
	public boolean isIam() {
		return iam;
	}

	/**
	 * @param iam the iam to set
	 */
	public void setIam(boolean iam) {
		this.iam = iam;
	}

	/**
	 * @return the ave
	 */
	public boolean isAve() {
		return ave;
	}

	/**
	 * @param ave the ave to set
	 */
	public void setAve(boolean ave) {
		this.ave = ave;
	}

	/**
	 * @return the revascCardio
	 */
	public boolean isRevascCardio() {
		return revascCardio;
	}

	/**
	 * @param revascCardio the revascCardio to set
	 */
	public void setRevascCardio(boolean revascCardio) {
		this.revascCardio = revascCardio;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public PacientePerdidaInjerto getPerdidaInjerto() {
		return perdidaInjerto;
	}

	public void setPerdidaInjerto(PacientePerdidaInjerto perdidaInjerto) {
		this.perdidaInjerto = perdidaInjerto;
	}

	public Trasplante getTrasplante() {
		return trasplante;
	}

	public void setTrasplante(Trasplante trasplante) {
		this.trasplante = trasplante;
	}

	
	public boolean isBuscarDiabeticos() {
		return buscarDiabeticos;
	}

	public void setBuscarDiabeticos(boolean buscarDiabeticos) {
		this.buscarDiabeticos = buscarDiabeticos;
	}

	public boolean isBuscarHTA() {
		return buscarHTA;
	}

	public void setBuscarHTA(boolean buscarHTA) {
		this.buscarHTA = buscarHTA;
	}

	public boolean isBuscarNoObesidad() {
		return buscarNoObesidad;
	}

	public void setBuscarNoObesidad(boolean buscarObesidad) {
		this.buscarNoObesidad = buscarObesidad;
	}
	
	public boolean isBuscarObesidad() {
		return buscarObesidad;
	}

	public void setBuscarObesidad(boolean buscarObesidad) {
		this.buscarObesidad = buscarObesidad;
	}

	public boolean isBuscarDislipemia() {
		return buscarDislipemia;
	}

	public void setBuscarDislipemia(boolean buscarDislipemia) {
		this.buscarDislipemia = buscarDislipemia;
	}

	public boolean isBuscarTabaquismo() {
		return buscarTabaquismo;
	}

	public void setBuscarTabaquismo(boolean buscarTabaquismo) {
		this.buscarTabaquismo = buscarTabaquismo;
	}

	public PacientePreTrasplante() {
		this.setId(0);
		this.fecha_egreso = new GregorianCalendar();
		this.fecha_ingreso_lista = new GregorianCalendar();
		String auxStr = "1900-1-1";
		try {
			this.getFecha_egreso().setTime(
					ManejoFechas.FORMATOINGLES.parse(auxStr));
		} catch (ParseException e) {
			System.out.println(e);
		}
	}

	public PacientePreTrasplante(PacientePreTrasplante p) {
		this.setId(p.getId());
		this.setThe(p.getThe());
		this.setDiabetes(p.getDiabetes());
		this.setDislipemia(p.isDislipemia());
		this.setFecha_egreso(p.getFecha_egreso());
		this.setFecha_ingreso_lista(p.getFecha_ingreso_lista());
		this.setObesidad(p.isObesidad());
		this.setOrigen(p.getOrigen());
		this.setPbr(p.isPbr());
		this.setTabaquismo(p.isTabaquismo());
		this.setPerdidaInjerto(p.getPerdidaInjerto());
		Trasplante aux = new Trasplante(p.getTrasplante());
		this.setTrasplante(aux);
	}

	
	public void eliminar() {
		//Elimino la evolucion del injerto
		EvolucionInjerto evo = new EvolucionInjerto();
		evo.setIdPretrasplante(this.getId());
		evo.setFecha(null);
		evo.eliminar();
		
		//Elimino el trasplante
		this.setTrasplante(new Trasplante());
		this.leerMaximoTrasplante();
		this.getTrasplante().eliminar();
		//Elimino la perdida del injerto
		/*if(this.getPerdidaInjerto() != null){
			this.getPerdidaInjerto().eliminar();
		}*/
		
		//Elimino el preTrasplante
		broker.eliminar();
	}

	
	public int getOid() {
		return this.getId();
	}

	
	public void guardar() {
		broker.guardar();
	}

	public void guardarTrasplante(Trasplante t) {
		t.setPreTrasplante(this.getId());
		t.guardar();
		this.setFecha_egreso(t.getFecha());
		this.guardar();
	}

	
	public void leer() {
		broker.leer();
		Trasplante t = new Trasplante();
		t.setPreTrasplante(this.getId());
		t.leerDatosMinimos();
	}

	public void leerMinimo(){
		broker.leer();
	}
	
	public void leerTrasplante() {
		Trasplante t = new Trasplante();
		t.setPreTrasplante(this.getId());
		t.leerDatosParaBusqueda();
		this.setTrasplante(t);
	}

	public void leerTodoTrasplante() {
		Trasplante t = new Trasplante(this.getTrasplante());
		t.setPreTrasplante(this.getId());
		t.leerTodosLosDatos();
		this.setTrasplante(t);
	}
	
	public void leerMaximoTrasplante() {
		Trasplante t = new Trasplante(this.getTrasplante());
		t.setPreTrasplante(this.getId());
		t.leerSoloTrasplante();
		this.setTrasplante(t);
	}
	
	@SuppressWarnings("all")
	public ArrayList<PacientePreTrasplante> obtenerTodos() {
		return broker.obtenerTodos();
	}

	public ArrayList<PacientePreTrasplante> obtenerTodosDiabeticos() {
		this.setBuscarDiabeticos(true);
		return obtenerTodos();
	}
	
	public ArrayList<PacientePreTrasplante> obtenerTodosHTA() {
		this.setBuscarHTA(true);
		return obtenerTodos();
	}
	
	public ArrayList<PacientePreTrasplante> obtenerTodosNoObesidad() {
		this.setBuscarNoObesidad(true);
		return obtenerTodos();
	}
	
	public ArrayList<PacientePreTrasplante> obtenerTodosObesidad() {
		this.setBuscarObesidad(true);
		return obtenerTodos();
	}
	
	public ArrayList<PacientePreTrasplante> obtenerTodosDislipemia() {
		this.setBuscarDislipemia(true);
		return obtenerTodos();
	}
	
	public ArrayList<PacientePreTrasplante> obtenerTodosTabaquismo() {
		this.setBuscarTabaquismo(true);
		return obtenerTodos();
	}
	
	public String toString() {
		return "Fecha ingreso:"
				+ ManejoFechas.FORMATOESPANOL.format(this
						.getFecha_ingreso_lista().getTime());
	}

	public int getMeses() {
		int elapsed = 0;
		Calendar gc2,gc1,g1,g2;
		g1 = this.getFecha_ingreso_lista();
		g2 = this.getFecha_egreso();
		if (g2.after(g1)) {
			gc2 = (Calendar) g2.clone();
			gc1 = (Calendar) g1.clone();
		} else {
			gc2 = (Calendar) g1.clone();
			gc1 = (Calendar) g2.clone();
		}
		System.out.println("Ingreso a Lista");
		System.out.println(ManejoFechas.FORMATOESPANOL.format(g1.getTime()));
		System.out.println("Egreso de Lista");
		System.out.println(ManejoFechas.FORMATOESPANOL.format(g2.getTime()));
		System.out.println("-----------------------------------------------");
		System.out.println(ManejoFechas.FORMATOESPANOL.format(gc1.getTime()));
		System.out.println(ManejoFechas.FORMATOESPANOL.format(gc2.getTime()));
		System.out.println("-----------------------------------------------");
		
		
		while (gc1.before(gc2)) {
			gc1.add(Calendar.MONTH, 1);
			elapsed++;

		}
		System.out.println(String.valueOf(elapsed));
		System.out.println("-----------------------------------------------");
		return elapsed;
	}

	
	public int contar() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(Object arg0) {
		if(arg0 == null)return false;
		PacientePreTrasplante aux = (PacientePreTrasplante) arg0;
		return this.getId() == aux.getId();
	}
	
	
}
