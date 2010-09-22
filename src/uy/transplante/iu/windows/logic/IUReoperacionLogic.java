/**
 * 
 */
package uy.transplante.iu.windows.logic;

import uy.transplante.dominio.Trasplante;
import uy.transplante.iu.trasplante.IUTrasplanteReoperacion;

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
