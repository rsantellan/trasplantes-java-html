package dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import persistencia.BrkEvolucionTrasplanteExamenes;
import persistencia.IPersistente;

public class EvolucionTrasplanteExamenes implements IPersistente{
	public static String GINECOLOGO = "GINECOLOGO";
	public static String UROLOGO = "UROLOGO";
	public static String OFTALMOLOGO = "OFTALMOLOGO";
	public static String RXOSEAS = "RX OSEAS";
	
	private int idTrasplante;
	private Calendar fecha = new GregorianCalendar();
	private boolean normal;
	private String comentario;
	private String tipo;
	private BrkEvolucionTrasplanteExamenes broker = new BrkEvolucionTrasplanteExamenes(this);
	
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

	public boolean isNormal() {
		return normal;
	}

	public void setNormal(boolean normal) {
		this.normal = normal;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public EvolucionTrasplanteExamenes() {
		this.tipo = "";
	}

	@Override
	public int contar() {
		return broker.contar();
	}

	@Override
	public void eliminar() {
		broker.eliminar();
	}

	@Override
	public int getOid() {
		return broker.contar();
	}

	@Override
	public void guardar() {
		broker.guardar();
	}

	@Override
	public void leer() {
		broker.leer();
	}

	@Override
	public ArrayList<EvolucionTrasplanteExamenes> obtenerTodos() {
		return broker.obtenerTodos();
	}

	@Override
	public boolean equals(Object obj) {
		EvolucionTrasplanteExamenes aux = (EvolucionTrasplanteExamenes) obj;
		return this.tipo.equalsIgnoreCase(aux.tipo);
	}

	public String toString(){
		return this.getTipo();
	}
	
}
