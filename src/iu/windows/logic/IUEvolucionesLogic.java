/**
 * 
 */
package iu.windows.logic;

import iu.IUInjertoEvolucion;
import iu.IUInjertoEvolucionSeleccionar;
import iu.evolucion.IUEvolucionTrasplanteSeleccionar;
import dominio.PacientePreTrasplante;
import dominio.Trasplante;

/**
 * @author rodrigo
 *
 */
public class IUEvolucionesLogic {

	public void iuManejarEvolucion(Trasplante t, int the){
		IUEvolucionTrasplanteSeleccionar iuEvolucion = new IUEvolucionTrasplanteSeleccionar(t,the);
		iuEvolucion.setVisible(true);
	}
	
	public void iuManejarPrimeraEvolucionInjerto(PacientePreTrasplante pre){
		IUInjertoEvolucionSeleccionar injertoSeleccionar = new IUInjertoEvolucionSeleccionar(pre);
		injertoSeleccionar.setVisible(true);
	}
	
	public void iuManejarEvolucionInjerto(PacientePreTrasplante pre){
		PacientePreTrasplante ver = new PacientePreTrasplante(
				pre);
		ver.getTrasplante().leerEvolucionInjerto();
		IUInjertoEvolucion iuVer = new IUInjertoEvolucion(ver.getId(),ver.getTrasplante().getFecha(),ver.getTrasplante().getEvolucion(), false,true);
		iuVer.setVisible(true);
	}
}
