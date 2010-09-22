package uy.transplante.iu.windows.logic;

import uy.transplante.iu.basico.IUCMVSeleccionar;

public class IUCMVLogic {

	public void iuManejarCMV(int id){
		IUCMVSeleccionar cmvSelect = new IUCMVSeleccionar(id);
		cmvSelect.setVisible(true);
	}
}
