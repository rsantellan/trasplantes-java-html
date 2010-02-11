/**
 * 
 */
package iu.windows.logic;

import iu.IUTratamientoSeleccionar;

/**
 * @author rodrigo
 *
 */
public class IUTratamientosLogic {

	public void iuSeleccionarTratamientos(int the){
		IUTratamientoSeleccionar tratSel = new IUTratamientoSeleccionar(the);
		tratSel.setVisible(true);
	}
}
