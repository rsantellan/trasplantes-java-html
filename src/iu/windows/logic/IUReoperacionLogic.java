/**
 * 
 */
package iu.windows.logic;

import uy.transplante.dominio.Trasplante;
import iu.trasplante.IUTrasplanteReoperacion;

/**
 * @author rodrigo
 *
 */
public class IUReoperacionLogic {

	public void iuReoperaciones(Trasplante t){
		IUTrasplanteReoperacion reTrasplante = new IUTrasplanteReoperacion(t);
		reTrasplante.setVisible(true);
	}
}
