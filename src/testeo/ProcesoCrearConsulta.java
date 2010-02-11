package testeo;

import java.util.HashMap;
import java.util.ArrayList;

public class ProcesoCrearConsulta {

	
	private HashMap<Integer, ClasesConsulta> diccionario = new HashMap<Integer, ClasesConsulta>();
	
	private HashMap<Integer, String> diccionarioSQL = new HashMap<Integer, String>();
	
	/**
	 * @return the diccionarioSQL
	 */
	public HashMap<Integer, String> getDiccionarioSQL() {
		return diccionarioSQL;
	}

	/**
	 * @param diccionarioSQL the diccionarioSQL to set
	 */
	private void setDiccionarioSQL(HashMap<Integer, String> diccionarioSQL) {
		this.diccionarioSQL = diccionarioSQL;
	}
	
	/**
	 * @return the diccionario
	 */
	public HashMap<Integer, ClasesConsulta> getDiccionario() {
		return diccionario;
	}

	/**
	 * @param diccionario the diccionario to set
	 */
	public void setDiccionario(HashMap<Integer, ClasesConsulta> diccionario) {
		this.diccionario = diccionario;
	}

	/**
	 * 
	 * @return
	 */
	public ClasesConsulta crearTablaPaciente(){
		return new ClasesConsulta(ClasesConsulta.PACIENTE, "Paciente", new ArrayList<String>(), "pacientes", "A", null,null);
	}
	
	/**
	 * 
	 * @return
	 */
	public ClasesConsulta crearTablaNefropatia(){
		int[] padre = {ClasesConsulta.PACIENTE};
		String[] union = {"A.NEFROPATIA = B.ID"};
		return new ClasesConsulta(ClasesConsulta.NEFROPATIA, "Nefropatia", new ArrayList<String>(), "nefropatia", "B", padre, union);
	}
	
	/**
	 * Procesa el contenido de las sentencias requeridas.
	 * @return 
	 */
	public String procesar(){
		this.setDiccionarioSQL(new HashMap<Integer, String>());
		String salida = "";
		
		return salida;
	}
	
	public int[] tablasBases(ClasesConsulta inicioA, ClasesConsulta inicioB, int[] resultado){
		if(resultado == null) return null;
		if(inicioA.getId() == inicioB.getId()){
			if(!this.getDiccionario().containsKey(Integer.valueOf(inicioA.getId()))){
				this.agregarClase(inicioA);
			}
			return this.agregarUno(resultado, inicioA.getId());
		}else{
			if(inicioA.getPadres().length == 0 && inicioB.getPadres().length==0) return null;
			int iteradorA = 0;
			boolean encontro = false;
			while(iteradorA <inicioA.getPadres().length){
				int iteradorB = 0;
				System.out.println(encontro + " " +iteradorB);
			}
		}
		return null;
	}
	
	private int[] agregarUno(int[] entrada, int numero){
		int[] salida = new int[entrada.length+1];
		for(int x=0;x<entrada.length;x++){
			salida[x] = entrada[x];
		}
		salida[entrada.length] = numero;
		return salida;
	}
	
	public void agregarClase(ClasesConsulta clase){
		this.getDiccionario().put(Integer.valueOf(clase.getId()), clase);
	}
}