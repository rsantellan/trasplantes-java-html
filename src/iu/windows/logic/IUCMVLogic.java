package iu.windows.logic;

import iu.IUCMVSeleccionar;

public class IUCMVLogic {

	public void iuManejarCMV(int id){
		IUCMVSeleccionar cmvSelect = new IUCMVSeleccionar(id);
		cmvSelect.setVisible(true);
	}
}
