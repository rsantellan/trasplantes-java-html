/**
 * 
 */
package uy.transplante.iu.windows.logic;

import uy.transplante.dominio.PacientePreTrasplante;
import uy.transplante.dominio.Trasplante;
import uy.transplante.iu.basico.IUInjertoEvolucion;
import uy.transplante.iu.basico.IUInjertoEvolucionSeleccionar;
import uy.transplante.iu.evolucion.IUEvolucionTrasplanteSeleccionar;

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
