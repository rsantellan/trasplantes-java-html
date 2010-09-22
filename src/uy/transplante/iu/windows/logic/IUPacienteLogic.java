/**
 * 
 */
package uy.transplante.iu.windows.logic;

import uy.transplante.dominio.Paciente;
import uy.transplante.iu.paciente.IUPacienteModificar;

/**
 * @author rodrigo
 *
 */
public class IUPacienteLogic {

	public void iuPacienteVerVisible(Paciente p){
		IUPacienteModificar iu = new IUPacienteModificar(p, true);
		iu.setVisible(true);
	}
}
