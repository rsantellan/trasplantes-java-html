/**
 * 
 */
package uy.tranplante.reportes.html.testeo;

import uy.tranplante.reportes.html.donante.CrearReporteHTMLDonante;
import uy.tranplante.reportes.html.estatico.HTMLDocumentoBasico;
import uy.tranplante.reportes.html.pacientes.CrearReporteHTMLPaciente;
import uy.tranplante.reportes.html.trasplante.CrearReporteHTMLTransplante;
import uy.tranplante.reportes.html.tratamientos.CrearReporteHTMLTratamientos;

/**
 * @author rodrigo
 *
 */
public class TesteoHTML {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int idPaciente = 14;
		CrearReporteHTMLPaciente htmlPaciente = new CrearReporteHTMLPaciente();
		CrearReporteHTMLDonante htmlDonante = new CrearReporteHTMLDonante();
		CrearReporteHTMLTransplante htmlTransplante = new CrearReporteHTMLTransplante();
		CrearReporteHTMLTratamientos htmlTratamientos = new CrearReporteHTMLTratamientos();
		String salida = htmlPaciente.reportePaciente(idPaciente);
		HTMLDocumentoBasico htmlBasico = new HTMLDocumentoBasico();
		htmlBasico.agregarTexto(salida);
		htmlBasico.agregarTexto(htmlPaciente.perdidaDeInjerto(idPaciente));
		htmlBasico.agregarTexto(htmlPaciente.muerteDePaciente(idPaciente));
		htmlBasico.agregarTexto(htmlDonante.donante("PTG27061975"));
		htmlBasico.agregarTexto(htmlTransplante.preTransplante(idPaciente));
		htmlBasico.agregarTexto(htmlTransplante.transplante(idPaciente));
		htmlBasico.agregarTexto(htmlTratamientos.tratamientos(idPaciente));
		htmlBasico.cerrarDocumento();
	}

}
