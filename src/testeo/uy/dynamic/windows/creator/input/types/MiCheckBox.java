/**
 * 
 */
package testeo.uy.dynamic.windows.creator.input.types;

import java.awt.Component;

import javax.swing.JCheckBox;

/**
 * @author admin
 *
 */
public class MiCheckBox extends JCheckBox{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6393269323354490353L;

	private IInputDataType dato;
	
	private Component contenedor;
	
	

	/**
	 * @return the dato
	 */
	public IInputDataType getDato() {
		return dato;
	}

	/**
	 * @param dato the dato to set
	 */
	public void setDato(IInputDataType dato) {
		this.dato = dato;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the contenedor
	 */
	public Component getContenedor() {
		return contenedor;
	}

	/**
	 * @param contenedor the contenedor to set
	 */
	public void setContenedor(Component contenedor) {
		this.contenedor = contenedor;
	}

	/* (non-Javadoc)
	 * @see java.awt.Component#toString()
	 */
	@Override
	public String toString() {
		return "####" + dato.datosString();
	}
	
	
	
	
}
