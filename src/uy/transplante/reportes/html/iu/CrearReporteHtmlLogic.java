/**
 *
 */
package uy.tranplante.reportes.html.iu;

import dominio.PacientePreTrasplante;
import uy.tranplante.reportes.html.cmv.CrearReporteHTMLCmv;
import uy.tranplante.reportes.html.complicaciones.CrearReporteHTMLComplicaciones;
import uy.tranplante.reportes.html.donante.CrearReporteHTMLDonante;
import uy.tranplante.reportes.html.estatico.HTMLDocumentoBasico;
import uy.tranplante.reportes.html.evolucion.globales.CrearReporteHTMLEvolucionGlobal;
import uy.tranplante.reportes.html.evolucion.injerto.CrearReporteHTMLEvolucionInjerto;
import uy.tranplante.reportes.html.pacientes.CrearReporteHTMLPaciente;
import uy.tranplante.reportes.html.trasplante.CrearReporteHTMLTransplante;
import uy.tranplante.reportes.html.tratamientos.CrearReporteHTMLTratamientos;

/**
 * @author rodrigo
 *
 */
public class CrearReporteHtmlLogic {


	public String crearReporteConParametros(int the, int idPreTrasplante, Boolean reportePaciente, Boolean perdidaDeInjerto, Boolean muerteDePaciente, Boolean preTransplante, Boolean transplante,Boolean reoperaciones, Boolean donante, Boolean tratamientos, Boolean complicacion, Boolean complicacionEnEvolucion, Boolean evolucionInjertoPrimera, Boolean evolucionInjerto, Boolean cmv, Boolean reporteEvolucionCMV, Boolean reporteEvolucionECG, Boolean reporteEvolucionEcocardiograma, Boolean reporteEvolucionMarcadoresVirales, Boolean reporteEvolucionTxTorax, Boolean reporteEvolucionEcografiaInjerto, Boolean reporteEvolucionEcodopler, Boolean reporteEvolucionOtrosExamenes, Boolean reporteEvolucionNutricion, Boolean reporteEvolucionParaclinica){
		
		HTMLDocumentoBasico htmlBasico = new HTMLDocumentoBasico(the, idPreTrasplante);

		//Paciente
		CrearReporteHTMLPaciente htmlPaciente = new CrearReporteHTMLPaciente();

		if(reportePaciente){
			htmlBasico.agregarTexto(htmlPaciente.reportePaciente(the));
		}

		if(perdidaDeInjerto){
			htmlBasico.agregarTexto(htmlPaciente.perdidaDeInjerto(the));
		}

		if(muerteDePaciente){
			htmlBasico.agregarTexto(htmlPaciente.muerteDePaciente(the));
		}

		//Pre Transplante
		PacientePreTrasplante pt = new PacientePreTrasplante();
		pt.setId(idPreTrasplante);
		pt.leer();
		pt.leerTrasplante();
		
		CrearReporteHTMLTransplante htmlTransplante = new CrearReporteHTMLTransplante();
		
		if(preTransplante){
			htmlBasico.agregarTexto(htmlTransplante.preTransplante(pt.getId()));
		}
		
		if(transplante){
			htmlBasico.agregarTexto(htmlTransplante.transplante(pt.getTrasplante().getId()));
		}

		//Donante

		CrearReporteHTMLDonante htmlDonante = new CrearReporteHTMLDonante();

		if(donante){
			htmlBasico.agregarTexto(htmlDonante.donante(pt.getTrasplante().getDonante().getId()));
		}

		//Reoperaciones
		if(reoperaciones){
			htmlBasico.agregarTexto(htmlTransplante.reoperaciones(pt.getTrasplante().getId()));
		}
		
		//Tratamientos
		CrearReporteHTMLTratamientos htmlTratamientos = new CrearReporteHTMLTratamientos();
		if(tratamientos){
			htmlBasico.agregarTexto(htmlTratamientos.tratamientos(the));
		}

		//Complicaciones

		CrearReporteHTMLComplicaciones htmlComplicaciones = new CrearReporteHTMLComplicaciones();

		if(complicacion){
			htmlBasico.agregarTexto(htmlComplicaciones.reporteComplicacionesEnTransplante(pt.getTrasplante().getId()));
		}
		
		if(complicacionEnEvolucion){
			htmlBasico.agregarTexto(htmlComplicaciones.reporteComplicacionesEnEvolucion(pt.getTrasplante().getId()));
		}
		
		//Evolucion del injerto

		CrearReporteHTMLEvolucionInjerto htmlEvolucionInjerto = new CrearReporteHTMLEvolucionInjerto();

		if(evolucionInjertoPrimera){
			htmlBasico.agregarTexto(htmlEvolucionInjerto.crearReportePrimerEvolucionInjerto(pt.getTrasplante().getId()));
		}
		
		if(evolucionInjerto){
			htmlBasico.agregarTexto(htmlEvolucionInjerto.crearReporteEvolucionInjerto(pt.getTrasplante().getId()));
		}
		
		//Reporte Cmv

		CrearReporteHTMLCmv htmlCmv = new CrearReporteHTMLCmv();

		if(cmv){
			htmlBasico.agregarTexto(htmlCmv.crearReporteCmv(pt.getTrasplante().getId()));
		}

		//Reporte de evolucion global

		CrearReporteHTMLEvolucionGlobal htmlEvolucionGlobal = new CrearReporteHTMLEvolucionGlobal(pt.getTrasplante().getId());

		if(reporteEvolucionCMV){
			htmlBasico.agregarTexto(htmlEvolucionGlobal.crearReporteEvolucionCmv());
		}
		if(reporteEvolucionECG){
			htmlBasico.agregarTexto(htmlEvolucionGlobal.crearReporteEvolucionEcg());
		}
		if(reporteEvolucionEcocardiograma){
			htmlBasico.agregarTexto(htmlEvolucionGlobal.crearReporteEvolucionEcocardiograma());
		}
		if(reporteEvolucionMarcadoresVirales){
			htmlBasico.agregarTexto(htmlEvolucionGlobal.crearReporteEvolucionMarcadoresVirales());
		}
		if(reporteEvolucionTxTorax){
			htmlBasico.agregarTexto(htmlEvolucionGlobal.crearReporteEvolucionTxTorax());
		}
		if(reporteEvolucionEcografiaInjerto){
			htmlBasico.agregarTexto(htmlEvolucionGlobal.crearReporteEvolucionEcografiaDelInjerto());
		}
		if(reporteEvolucionEcodopler){
			htmlBasico.agregarTexto(htmlEvolucionGlobal.crearReporteEvolucionEcodopler());
		}
		if(reporteEvolucionOtrosExamenes){
			htmlBasico.agregarTexto(htmlEvolucionGlobal.crearReporteEvolucionOtrosExamenes());
		}
		if(reporteEvolucionNutricion){
			htmlBasico.agregarTexto(htmlEvolucionGlobal.crearReporteEvolucionNutricion());
		}
		if(reporteEvolucionParaclinica){
			htmlBasico.agregarTexto(htmlEvolucionGlobal.crearReporteEvolucionParaclinica());
		}

		htmlBasico.cerrarDocumento();

		return htmlBasico.getFileName();
	}


	public String crearReporteTotal(int the, int idPreTrasplante){
		HTMLDocumentoBasico htmlBasico = new HTMLDocumentoBasico(the, idPreTrasplante);

		//Paciente
		CrearReporteHTMLPaciente htmlPaciente = new CrearReporteHTMLPaciente();

		htmlBasico.agregarTexto(htmlPaciente.reportePaciente(the));

		htmlBasico.agregarTexto(htmlPaciente.perdidaDeInjerto(the));

		htmlBasico.agregarTexto(htmlPaciente.muerteDePaciente(the));

		//Pre Transplante
		PacientePreTrasplante pt = new PacientePreTrasplante();
		pt.setId(idPreTrasplante);
		pt.leer();
		pt.leerTrasplante();

		CrearReporteHTMLTransplante htmlTransplante = new CrearReporteHTMLTransplante();
		htmlBasico.agregarTexto(htmlTransplante.preTransplante(pt.getId()));

		htmlBasico.agregarTexto(htmlTransplante.transplante(pt.getTrasplante().getId()));

		//Donante

		CrearReporteHTMLDonante htmlDonante = new CrearReporteHTMLDonante();
		htmlBasico.agregarTexto(htmlDonante.donante(pt.getTrasplante().getDonante().getId()));

		//Reoperaciones
		htmlBasico.agregarTexto(htmlTransplante.reoperaciones(pt.getTrasplante().getId()));

		//Tratamientos
		CrearReporteHTMLTratamientos htmlTratamientos = new CrearReporteHTMLTratamientos();

		htmlBasico.agregarTexto(htmlTratamientos.tratamientos(the));

		//Complicaciones

		CrearReporteHTMLComplicaciones htmlComplicaciones = new CrearReporteHTMLComplicaciones();

		htmlBasico.agregarTexto(htmlComplicaciones.reporteComplicacionesEnTransplante(pt.getTrasplante().getId()));

		htmlBasico.agregarTexto(htmlComplicaciones.reporteComplicacionesEnEvolucion(pt.getTrasplante().getId()));

		//Evolucion del injerto

		CrearReporteHTMLEvolucionInjerto htmlEvolucionInjerto = new CrearReporteHTMLEvolucionInjerto();

		htmlBasico.agregarTexto(htmlEvolucionInjerto.crearReportePrimerEvolucionInjerto(pt.getTrasplante().getId()));

		htmlBasico.agregarTexto(htmlEvolucionInjerto.crearReporteEvolucionInjerto(pt.getTrasplante().getId()));

		//Reporte Cmv

		CrearReporteHTMLCmv htmlCmv = new CrearReporteHTMLCmv();

		htmlBasico.agregarTexto(htmlCmv.crearReporteCmv(pt.getTrasplante().getId()));


		//Reporte de evolucion global

		CrearReporteHTMLEvolucionGlobal htmlEvolucionGlobal = new CrearReporteHTMLEvolucionGlobal(pt.getTrasplante().getId());

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
		
		return htmlBasico.getFileName();
	}



}
