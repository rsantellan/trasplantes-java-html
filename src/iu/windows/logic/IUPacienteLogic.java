/**
 * 
 */
package iu.windows.logic;

import iu.paciente.IUPacienteModificar;
import dominio.Paciente;

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
