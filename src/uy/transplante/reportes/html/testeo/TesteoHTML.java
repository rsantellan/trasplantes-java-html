/**
 * 
 */
package uy.transplante.reportes.html.testeo;

import uy.transplante.reportes.html.cmv.CrearReporteHTMLCmv;
import uy.transplante.reportes.html.complicaciones.CrearReporteHTMLComplicaciones;
import uy.transplante.reportes.html.donante.CrearReporteHTMLDonante;
import uy.transplante.reportes.html.estatico.HTMLDocumentoBasico;
import uy.transplante.reportes.html.evolucion.globales.CrearReporteHTMLEvolucionGlobal;
import uy.transplante.reportes.html.evolucion.injerto.CrearReporteHTMLEvolucionInjerto;
import uy.transplante.reportes.html.pacientes.CrearReporteHTMLPaciente;
import uy.transplante.reportes.html.trasplante.CrearReporteHTMLTransplante;
import uy.transplante.reportes.html.tratamientos.CrearReporteHTMLTratamientos;

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
		int idPaciente = 7;
		CrearReporteHTMLPaciente htmlPaciente = new CrearReporteHTMLPaciente();
		CrearReporteHTMLDonante htmlDonante = new CrearReporteHTMLDonante();
		CrearReporteHTMLTransplante htmlTransplante = new CrearReporteHTMLTransplante();
		CrearReporteHTMLTratamientos htmlTratamientos = new CrearReporteHTMLTratamientos();
		CrearReporteHTMLComplicaciones htmlComplicaciones = new CrearReporteHTMLComplicaciones();
		CrearReporteHTMLEvolucionInjerto htmlEvolucionInjerto = new CrearReporteHTMLEvolucionInjerto();
		CrearReporteHTMLCmv htmlCmv = new CrearReporteHTMLCmv();
		CrearReporteHTMLEvolucionGlobal htmlEvolucionGlobal = new CrearReporteHTMLEvolucionGlobal(idPaciente);
		
		String salida = htmlPaciente.reportePaciente(idPaciente);
		HTMLDocumentoBasico htmlBasico = new HTMLDocumentoBasico(1,1);
		htmlBasico.agregarTexto(salida);
		//htmlBasico.agregarTexto(htmlPaciente.reportePacienteTable(idPaciente));
		htmlBasico.agregarTexto(htmlPaciente.perdidaDeInjerto(idPaciente));
		htmlBasico.agregarTexto(htmlPaciente.muerteDePaciente(idPaciente));
		
		htmlBasico.agregarTexto(htmlDonante.donante("PTG27061975"));
		htmlBasico.agregarTexto(htmlTransplante.preTransplante(idPaciente));
		htmlBasico.agregarTexto(htmlTransplante.transplante(idPaciente));
		htmlBasico.agregarTexto(htmlTratamientos.tratamientos(idPaciente));
		
		htmlBasico.agregarTexto(htmlTransplante.reoperaciones(idPaciente));
		
		
		htmlBasico.agregarTexto(htmlComplicaciones.reporteComplicacionesEnTransplante(idPaciente));
		
		htmlBasico.agregarTexto(htmlComplicaciones.reporteComplicacionesEnEvolucion(idPaciente));
		
		htmlBasico.agregarTexto(htmlEvolucionInjerto.crearReportePrimerEvolucionInjerto(idPaciente));
		
		htmlBasico.agregarTexto(htmlEvolucionInjerto.crearReporteEvolucionInjerto(idPaciente));
		
		htmlBasico.agregarTexto(htmlCmv.crearReporteCmv(idPaciente));
		
		htmlBasico.agregarTexto(htmlEvolucionGlobal.crearReporteEvolucionCmv());
		
		htmlBasico.agregarTexto(htmlEvolucionGlobal.crearReporteEvolucionEcg());
		
		htmlBasico.agregarTexto(htmlEvolucionGlobal.crearReporteEvolucionEcocardiograma());
		
		htmlBasico.agregarTexto(htmlEvolucionGlobal.crearReporteEvolucionMarcadoresVirales());
		
		htmlBasico.agregarTexto(htmlEvolucionGlobal.crearReporteEvolucionTxTorax());
		
		htmlBasico.agregarTexto(htmlEvolucionGlobal.crearReporteEvolucionEcografiaDelInjerto());
		
		htmlBasico.agregarTexto(htmlEvolucionGlobal.crearReporteEvolucionEcodopler());
		
		htmlBasico.agregarTexto(htmlEvolucionGlobal.crearReporteEvolucionOtrosExamenes());
		
		htmlBasico.agregarTexto(htmlEvolucionGlobal.crearReporteEvolucionNutricion());
		
		htmlBasico.agregarTexto(htmlEvolucionGlobal.crearReporteEvolucionParaclinica());
		
		htmlBasico.cerrarDocumento();
	}

}
