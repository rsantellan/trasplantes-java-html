/**
 * 
 */
package testeo.clases.base;

import java.util.List;

import testeo.uy.dynamic.windows.creator.input.types.IInputDataType;




/**
 * @author rodrigo
 *
 */
public class ElementoBase  implements IInputDataType {

	private String nombreMostrado;
	
	private String nombreBase;
	
	private List<String> posiblesValores;

	private String tipoValor;
	
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
	private void setIdTabla(int idTabla) {
		this.idTabla = idTabla;
	}

	/**
	 * @return the valor
	 */
	public String getTipoValor() {
		return tipoValor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setTipoValor(String tipoValor) {
		this.tipoValor = tipoValor;
	}

	/**
	 * @return the nombreMostrado
	 */
	public String getNombreMostrado() {
		return nombreMostrado;
	}

	/**
	 * @param nombreMostrado the nombreMostrado to set
	 */
	public void setNombreMostrado(String nombreMostrado) {
		this.nombreMostrado = nombreMostrado;
	}

	/**
	 * @return the nombreBase
	 */
	public String getNombreBase() {
		return nombreBase;
	}

	/**
	 * @param nombreBase the nombreBase to set
	 */
	public void setNombreBase(String nombreBase) {
		this.nombreBase = nombreBase;
	}

	/**
	 * @return the posiblesValores
	 */
	public List<String> getPosiblesValores() {
		return posiblesValores;
	}

	/**
	 * @param posiblesValores the posiblesValores to set
	 */
	public void setPosiblesValores(List<String> posiblesValores) {
		this.posiblesValores = posiblesValores;
	}

	/**
	 * @param idTabla
	 */
	public ElementoBase(int idTabla) {
		super();
		this.setIdTabla(idTabla);
	}

	@Override
	public String datosString() {
		return this.getNombreMostrado();
	}
	
	
	
}
