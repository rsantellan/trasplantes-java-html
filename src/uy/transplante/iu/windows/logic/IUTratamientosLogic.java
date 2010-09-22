/**
 * 
 */
package uy.transplante.iu.windows.logic;

import uy.transplante.iu.basico.IUTratamientoSeleccionar;

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
