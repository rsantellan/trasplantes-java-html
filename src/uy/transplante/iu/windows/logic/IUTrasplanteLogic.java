/**
 * 
 */
package uy.transplante.iu.windows.logic;

import uy.transplante.dominio.Paciente;
import uy.transplante.dominio.PacientePreTrasplante;
import uy.transplante.dominio.Trasplante;
import uy.transplante.iu.complicacion.IUComplicacionesInfSeleccionar;
import uy.transplante.iu.complicacion.IUComplicacionesNoInfSeleccionar;
import uy.transplante.iu.trasplante.IUTrasplanteFechaAlta;
import uy.transplante.iu.trasplante.IUTrasplanteManejar;

/**
 * @author rodrigo
 *
 */
public class IUTrasplanteLogic {

	public void iuVerTransplante(Paciente p, PacientePreTrasplante pre){
		PacientePreTrasplante ver = new PacientePreTrasplante(
				pre);
		ver.leerTodoTrasplante();
		IUTrasplanteManejar iuModificar = new IUTrasplanteManejar(
				p, ver, true);
		iuModificar.setVisible(true);
	}
	
	public void iuModificarTransplante(Paciente p, PacientePreTrasplante pre){
		PacientePreTrasplante modificar = new PacientePreTrasplante(
				pre);
		modificar.leerTodoTrasplante();
		IUTrasplanteManejar iuModificar = new IUTrasplanteManejar(
				p, modificar, false);
		iuModificar.setVisible(true);
	}
	
	public void iuVerTransplanteComplicacionNoInfecciosa(Trasplante t){
		Trasplante ver = new Trasplante(t);
		ver.leerComplicaciones();
		IUComplicacionesNoInfSeleccionar iuNoInf = new IUComplicacionesNoInfSeleccionar(
				ver, true);
		iuNoInf.setVisible(true);
	}
	
	public void iuVerTransplanteComplicacionInfecciosa(Trasplante t){
		Trasplante ver = new Trasplante(t);
		ver.leerComplicaciones();
		IUComplicacionesInfSeleccionar iuInfSeleccionar = new IUComplicacionesInfSeleccionar(
				ver, true);
		iuInfSeleccionar.setVisible(true);
	}
	
	public void iuIngresarTrasplante(Paciente p, PacientePreTrasplante pre){
		Trasplante unTr = new Trasplante();
		pre.setTrasplante(unTr);
		IUTrasplanteManejar iuTr = new IUTrasplanteManejar(p,pre,false);
		iuTr.setVisible(true);
	}
	
	public void iuAltaTrasplante(Trasplante t){
		IUTrasplanteFechaAlta alta = new IUTrasplanteFechaAlta(t);
		alta.setVisible(true);
	}
}
