/**
 * 
 */
package testeo.clases.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rodrigo
 *
 */
public abstract class TablaBase {

	private TablaBase padre;
	
	private List<ElementoBase> elementos = new ArrayList<ElementoBase>();
	
	private String unionSQL;
	
	private String nombreTabla;
	
	private String preFijo;

	private int idTabla;
	
	
	/**
	 * @return the idTabla
	 */
	public int getIdTabla() {
		return idTabla;
	}

	/**
	 * @param idTabla the idTabla to set
	 */
	protected void setIdTabla(int idTabla) {
		this.idTabla = idTabla;
	}

	/**
	 * @return the padre
	 */
	public TablaBase getPadre() {
		return padre;
	}

	/**
	 * @param padre the padre to set
	 */
	public void setPadre(TablaBase padre) {
		this.padre = padre;
	}

	/**
	 * @return the elementos
	 */
	public List<ElementoBase> getElementos() {
		return elementos;
	}

	/**
	 * @param elementos the elementos to set
	 */
	public void setElementos(List<ElementoBase> elementos) {
		this.elementos = elementos;
	}

	/**
	 * @return the unionSQL
	 */
	public String getUnionSQL() {
		return unionSQL;
	}

	/**
	 * @param unionSQL the unionSQL to set
	 */
	public void setUnionSQL(String unionSQL) {
		this.unionSQL = unionSQL;
	}

	/**
	 * @return the nombreTabla
	 */
	public String getNombreTabla() {
		return nombreTabla;
	}

	/**
	 * @param nombreTabla the nombreTabla to set
	 */
	public void setNombreTabla(String nombreTabla) {
		this.nombreTabla = nombreTabla;
	}

	/**
	 * @return the preFijo
	 */
	public String getPreFijo() {
		return preFijo;
	}

	/**
	 * @param preFijo the preFijo to set
	 */
	public void setPreFijo(String preFijo) {
		this.preFijo = preFijo;
	}
	
}
