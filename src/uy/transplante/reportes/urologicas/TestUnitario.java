package uy.transplante.reportes.urologicas;

import logica.Fachada;

public class TestUnitario {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConsultaUrologicaExcel consulta = new ConsultaUrologicaExcel();
		Fachada.getInstancia().cambie();
		consulta.consultaUrologica();
	}

}
