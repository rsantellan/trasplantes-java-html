package testeo;

import java.util.List;

public class ClasesConsulta {

	public static int PACIENTE = 1;
	public static int NEFROPATIA = 2;
	
	private int id;
	private String nombre;
	private List<String> seleccionados;
	private String tabla;
	private String prefijo;
	private int[] padres;
	private String[] conexiones;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}



	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	/**
	 * @return the seleccionados
	 */
	public List<String> getSeleccionados() {
		return seleccionados;
	}



	/**
	 * @param seleccionados the seleccionados to set
	 */
	public void setSeleccionados(List<String> seleccionados) {
		this.seleccionados = seleccionados;
	}



	/**
	 * @return the tabla
	 */
	public String getTabla() {
		return tabla;
	}



	/**
	 * @param tabla the tabla to set
	 */
	public void setTabla(String tabla) {
		this.tabla = tabla;
	}



	/**
	 * @return the prefijo
	 */
	public String getPrefijo() {
		return prefijo;
	}



	/**
	 * @param prefijo the prefijo to set
	 */
	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}



	/**
	 * @return the padres
	 */
	public int[] getPadres() {
		return padres;
	}



	/**
	 * @param padres the padres to set
	 */
	public void setPadres(int[] padres) {
		this.padres = padres;
	}

	

	/**
	 * @return the conexiones
	 */
	public String[] getConexiones() {
		return conexiones;
	}



	/**
	 * @param conexiones the conexiones to set
	 */
	public void setConexiones(String[] conexiones) {
		this.conexiones = conexiones;
	}



	/**
	 * @param id
	 * @param nombre
	 * @param seleccionados
	 * @param tabla
	 * @param prefijo
	 * @param padres
	 * @param conexiones
	 */
	public ClasesConsulta(int id, String nombre, List<String> seleccionados,
			String tabla, String prefijo, int[] padres, String[] conexiones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.seleccionados = seleccionados;
		this.tabla = tabla;
		this.prefijo = prefijo;
		this.padres = padres;
		this.conexiones = conexiones;
		
	}



	
	
}
