/**
 * 
 */
package iu.windows.logic;

import iu.trasplante.IUTrasplanteReoperacion;
import dominio.Trasplante;

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
