package iu.windows.logic;

import uy.transplante.dominio.Paciente;
import uy.transplante.dominio.PacientePreTrasplante;
import iu.paciente.IUPacientePreTrasplante;

public class IUPacientePreTrasplanteLogic {

	public void iuVerPreTrasplante(Paciente p, PacientePreTrasplante pre){
		IUPacientePreTrasplante iuVer = new IUPacientePreTrasplante(
				p, pre, true);
		iuVer.setVisible(true);
	}
	
	
}
