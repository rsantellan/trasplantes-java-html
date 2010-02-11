package iu.windows.logic;

import iu.paciente.IUPacientePreTrasplante;
import dominio.Paciente;
import dominio.PacientePreTrasplante;

public class IUPacientePreTrasplanteLogic {

	public void iuVerPreTrasplante(Paciente p, PacientePreTrasplante pre){
		IUPacientePreTrasplante iuVer = new IUPacientePreTrasplante(
				p, pre, true);
		iuVer.setVisible(true);
	}
	
	
}
