/**
 * 
 */
package uy.transplante.iu.windows.logic;

import uy.transplante.iu.backup.IUBackUpProgress;
import uy.transplante.iu.backup.IUBackUpRestoreProgress;
import uy.transplante.iu.basico.IUBuscarPersonaTrasplante;
import uy.transplante.iu.basico.IUPrincipal;
import uy.transplante.iu.consultas.IUConsultaGenerica;
import uy.transplante.iu.consultas.IUConsultaGenericaOpciones;
import uy.transplante.iu.consultas.IUConsultaGermenInfeccion;
import uy.transplante.iu.consultas.IUConsultaMenuLineal;
import uy.transplante.iu.consultas.IUConsultaTransplanteIOP;
import uy.transplante.iu.consultas.IUConsultaXCausaMuerteDonante;
import uy.transplante.iu.datosfijos.IUManejarAntecedentesDonante;
import uy.transplante.iu.datosfijos.IUManejarCMVDiagnostico;
import uy.transplante.iu.datosfijos.IUManejarCMVDrogas;
import uy.transplante.iu.datosfijos.IUManejarCMVEmfermedades;
import uy.transplante.iu.datosfijos.IUManejarCausaMuerteDonante;
import uy.transplante.iu.datosfijos.IUManejarCausaMuertePaciente;
import uy.transplante.iu.datosfijos.IUManejarCausasPerdidaInjerto;
import uy.transplante.iu.datosfijos.IUManejarFechaControl;
import uy.transplante.iu.datosfijos.IUManejarGermenes;
import uy.transplante.iu.datosfijos.IUManejarInduccion;
import uy.transplante.iu.datosfijos.IUManejarInfeccion;
import uy.transplante.iu.datosfijos.IUManejarInmunosupresores;
import uy.transplante.iu.datosfijos.IUManejarMedicacion;
import uy.transplante.iu.datosfijos.IUManejarNefropatias;
import uy.transplante.iu.datosfijos.IUManejarResultadoPBR;
import uy.transplante.iu.datosfijos.IUManejarSerol;
import uy.transplante.iu.datosfijos.IUManejarTiposComplicaciones;
import uy.transplante.iu.datosfijos.IUManejarTratamientoRA;
import uy.transplante.iu.donante.IUDonanteIngresar;
import uy.transplante.iu.donante.IUDonanteSeleccionar;
import uy.transplante.iu.login.IULoginCambiar;
import uy.transplante.iu.paciente.IUPacienteIngresar;
import uy.transplante.iu.paciente.IUPacienteSeleccionar;
import uy.transplante.reportes.html.iu.IUCrearReporteHtml;
import uy.transplante.reportes.registrouruguayotrasplantes.IUCrearReporteFondoPerYear;
import uy.transplante.reportes.registrouruguayotrasplantes.IUCrearReporteFondoTotal;
import uy.transplante.reportes.registrouruguayotrasplantes.IUCrearReporteFondoTotalPreTrasplante;

/**
 * @author rodrigo
 *
 */
public class IUPrincipalLogic {

	/**
	 * Crea la pantalla de ingresar pacientes.
	 */
	public static void ingresarPaciente() {
		IUPacienteIngresar iu = new IUPacienteIngresar();
		iu.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de seleccionar pacientes.
	 */
	public static void seleccionarPaciente() {
		IUPacienteSeleccionar iu = new IUPacienteSeleccionar();
		iu.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de ingresar nefropatias.
	 */
	public static void nefropatias() {
		IUManejarNefropatias iu = new IUManejarNefropatias();
		iu.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de ingresar causas de muerte de pacientes.
	 */
	public static void causasMuertePacientes() {
		IUManejarCausaMuertePaciente iu = new IUManejarCausaMuertePaciente();
		iu.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de ingresar causas de perdidas de injertos.
	 */
	public static void causasPerdidaInjerto() {
		IUManejarCausasPerdidaInjerto iu = new IUManejarCausasPerdidaInjerto();
		iu.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de ingresar antecedentes de donantes.
	 */
	public static void antecedentesDonante() {
		IUManejarAntecedentesDonante iu = new IUManejarAntecedentesDonante();
		iu.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de ingresar causa de muerte de donantes.
	 */
	public static void causaMuerteDonante() {
		IUManejarCausaMuerteDonante iu = new IUManejarCausaMuerteDonante();
		iu.setVisible(true);
	}

	/**
	 * Crea la pantalla de ingresar donantes.
	 */
	public static void ingresarDonante() {
		IUDonanteIngresar iu = new IUDonanteIngresar();
		iu.setVisible(true);
	}

	/**
	 * Crea la pantalla de ingresar modificar donantes.
	 */
	public static void modificarDonante() {
		IUDonanteSeleccionar iu = new IUDonanteSeleccionar();
		iu.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de ingresar resultados PBR.
	 */
	public static void resultadoPBR() {
		IUManejarResultadoPBR iu = new IUManejarResultadoPBR();
		iu.setVisible(true);
	}

	/**
	 * Crea la pantalla de ingresar seroles
	 */
	public static void manejarSerol() {
		IUManejarSerol iuSerol = new IUManejarSerol();
		iuSerol.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de ingresar seroles
	 */
	public static void manejarInduccion() {
		IUManejarInduccion iuInduccion = new IUManejarInduccion();
		iuInduccion.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de ingresar inmunosupresores
	 */
	public static void manejarInmunosupresores() {
		IUManejarInmunosupresores iuInmunosupresores = new IUManejarInmunosupresores();
		iuInmunosupresores.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de ingresar medicaciones
	 */
	public static void manejarMedicacion() {
		IUManejarMedicacion iuMedicacion = new IUManejarMedicacion();
		iuMedicacion.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de ingresar tipos de complicaciones
	 */
	public static void manejarTiposComplicaciones() {
		IUManejarTiposComplicaciones iuCom = new IUManejarTiposComplicaciones();
		iuCom.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de buscar pacientes
	 */
	public static void buscar() {
		IUBuscarPersonaTrasplante iuBuscar = new IUBuscarPersonaTrasplante();
		iuBuscar.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de ingresar Infecciones.
	 */
	public static void manejarInfecciones() {
		IUManejarInfeccion iuInfeccion = new IUManejarInfeccion();
		iuInfeccion.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de ingresar Infecciones.
	 */
	public static void manejarGermenes() {
		IUManejarGermenes iuGermenes = new IUManejarGermenes();
		iuGermenes.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de ingresar Fechas de Control.
	 */
	public static void manejarFechaDeControl() {
		IUManejarFechaControl iuFecha = new IUManejarFechaControl();
		iuFecha.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de consulta trasplante filtrando por germenes e Infecciones.
	 */
	public static void consultaTrasplanteGermenInfeccion() {
		IUConsultaGermenInfeccion consultaGI = new IUConsultaGermenInfeccion();
		consultaGI.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de consulta generica
	 */
	public static void consultaGenerica(int id) {
		IUConsultaGenerica consulta = new IUConsultaGenerica(id);
		consulta.setVisible(true);
	}

	public static void consultaTransplantesIOP(){
		IUConsultaTransplanteIOP consulta = new IUConsultaTransplanteIOP();
		consulta.setVisible(true);
	}
	/**
	 * Crea la pantalla de consulta generica con opciones
	 */
	public static void consultaGenericaOpciones(int id){
		IUConsultaGenericaOpciones consulta = new IUConsultaGenericaOpciones(id);
		consulta.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de ingresar Droga CMV
	 */
	public static void manejarCMVDrogas() {
		IUManejarCMVDrogas mCmvDrogas = new IUManejarCMVDrogas();
		mCmvDrogas.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de ingresar Diagnostico CMV
	 */
	public static void manejarCMVDiagnostico() {
		IUManejarCMVDiagnostico mCmvDiagnostico = new IUManejarCMVDiagnostico();
		mCmvDiagnostico.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de ingresar Enfermedades CMV
	 */
	public static void manejarCMVEnfermedades() {
		IUManejarCMVEmfermedades mCmvEnfermedades = new IUManejarCMVEmfermedades();
		mCmvEnfermedades.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de ingresar Tratamiento RA
	 */
	public static void manejarTratamientoRA() {
		IUManejarTratamientoRA manTrata = new IUManejarTratamientoRA();
		manTrata.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de cambiar el password.
	 */
	public static void cambiarPassword(){
		IULoginCambiar cambio = new IULoginCambiar();
		cambio.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de crear un Back Up.
	 */
	public static void crearBackUp(IUPrincipal principal){
		IUBackUpProgress backUp = new IUBackUpProgress(principal);
		backUp.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de restaurar un Back Up.
	 */
	public static void restoreBackUp(IUPrincipal principal){
		IUBackUpRestoreProgress restore = new IUBackUpRestoreProgress(principal);
		restore.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de una consulta de complicaciones de forma lineal.
	 */
	public static void consultaLinealesComplicaciones(){
		IUConsultaMenuLineal consultaLineal = new IUConsultaMenuLineal();
		consultaLineal.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de creacion del reporte para el registro uruguayo 
	 */
	public static void reporteRegistroUruguayo(){
		IUCrearReporteFondoPerYear iuReporteRegistro = new IUCrearReporteFondoPerYear();
		iuReporteRegistro.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de creacion del reporte para el registro uruguayo total
	 */
	public static void reporteRegistroUruguayoTotal(){
		IUCrearReporteFondoTotal iuReporteRegistro = new IUCrearReporteFondoTotal();
		iuReporteRegistro.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de creacion del reporte para el registro uruguayo total con datos del pretrasplante
	 */
	public static void reporteRegistroUruguayoTotalPreTrasplante(){
		IUCrearReporteFondoTotalPreTrasplante iuReporteRegistro = new IUCrearReporteFondoTotalPreTrasplante();
		iuReporteRegistro.setVisible(true);
	}
	
	/**
	 * Crea la pantalla de Consulta de donante por causa de muerte
	 */
	public static void consCausaMuerteDonante() {
		IUConsultaXCausaMuerteDonante conCMDon = new IUConsultaXCausaMuerteDonante();
		conCMDon.setVisible(true);
	}
	
	public static void crearReporteHtml(){
		IUCrearReporteHtml iuReporteHtml = new IUCrearReporteHtml();
		iuReporteHtml.setVisible(true);
	}
}
