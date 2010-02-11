/**
 * 
 */
package testeo.clases.implementacion;

import java.util.HashMap;

import testeo.clases.base.TablaBase;

/**
 * @author rodrigo
 *
 */
public class RegistroTablas {

	private HashMap<Integer, TablaBase> diccionario =  new HashMap<Integer, TablaBase>();
	
	
	/**
	 * @return the diccionario
	 */
	public HashMap<Integer, TablaBase> getDiccionario() {
		return diccionario;
	}


	public RegistroTablas(){
		TablaPacientes p = new TablaPacientes();
		this.getDiccionario().put(p.getIdTabla(), p);
		TablaNefropatia n = new TablaNefropatia();
		this.getDiccionario().put(n.getIdTabla(), n);
		TablaPacienteMuerte pm = new TablaPacienteMuerte();
		this.getDiccionario().put(pm.getIdTabla(), pm);
		TablaPacienteMuerteCausa pmc = new TablaPacienteMuerteCausa();
		this.getDiccionario().put(pmc.getIdTabla(), pmc);
		TablaPacientePreTrasplante preT = new TablaPacientePreTrasplante();
		this.getDiccionario().put(preT.getIdTabla(), preT);
	}
}
