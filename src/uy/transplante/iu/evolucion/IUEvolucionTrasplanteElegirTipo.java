package uy.transplante.iu.evolucion;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import uy.transplante.dominio.EvolucionTrasplante;
import uy.transplante.dominio.EvolucionTrasplanteCMV;
import uy.transplante.dominio.EvolucionTrasplanteECG;
import uy.transplante.dominio.EvolucionTrasplanteEcoCardio;
import uy.transplante.dominio.EvolucionTrasplanteMarvirales;
import uy.transplante.dominio.EvolucionTrasplanteNutricion;
import uy.transplante.dominio.EvolucionTrasplanteTotal;
import uy.transplante.dominio.EvolucionTrasplanteTxTorax;
import uy.transplante.dominio.Trasplante;
import uy.transplante.logica.Fachada;


import com.toedter.calendar.JDateChooser;


public class IUEvolucionTrasplanteElegirTipo extends JFrame implements
		java.util.Observer {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private Trasplante t;
	private Calendar fecha = new GregorianCalendar();

	private EvolucionTrasplante evoClasica = null;
	private EvolucionTrasplanteCMV evoCMV = null;
	private EvolucionTrasplanteECG evoECG = null;
	private JLabel jLabelFecha = null;
	private JDateChooser jDateChooserFecha = null;
	private JLabel jLabelClasica = null;
	private JButton jButtonClasicaInsertar = null;
	private JButton jButtonClasicaModificar = null;
	private JButton jButtonClasicaEliminar = null;
	private JDesktopPane jDesktopPaneClasica = null;
	private JDesktopPane jDesktopPaneCMV = null;
	private JLabel jLabelCMV1 = null;
	private JButton jButtonCMVInsertar = null;
	private JButton jButtonCMVModificar = null;
	private JButton jButtonCMVEliminar = null;
	private JDesktopPane jDesktopPaneECG = null;
	private JLabel jLabelECG = null;
	private JButton jButtonECGInsertar = null;
	private JButton jButtonECGModificar = null;
	private JButton jButtonECGEliminar = null;
	private JDesktopPane jDesktopPaneMarvirales = null;
	private JLabel jLabelMarvirales = null;
	private JButton jButtonMarviralesInsertar = null;
	private JButton jButtonMarviralesModificar = null;
	private JButton jButtonMarviralesEliminar = null;
	private EvolucionTrasplanteMarvirales evoMarvilares = null;
	private JDesktopPane jDesktopPaneEcoCardio = null;
	private JLabel jLabelEcoCardio = null;
	private JButton jButtonEcoCardioInsertar = null;
	private JButton jButtonEcoCardioModificar = null;
	private JButton jButtonEcoCardioEliminar = null;
	private EvolucionTrasplanteEcoCardio evoEcoCardio = null;
	private JButton jButtonVerClasica = null;
	private JButton jButtonVerCMV = null;
	private JButton jButtonVerECG = null;
	private JButton jButtonVerMarvirales = null;
	private JButton jButtonVerEcoCardio = null;
	private JDesktopPane jDesktopPaneTxTorax = null;
	private JLabel jLabelTxTorax = null;
	private JButton jButtonoInsertarTxTorax = null;
	private JButton jButtonModificarTxTorax = null;
	private JButton jButtonEliminarTxTorax = null;
	private JButton jButtonVerTxTorax = null;
	private EvolucionTrasplanteTxTorax evoTxTorax = null;
	private JDesktopPane jDesktopPaneNutricion = null;
	private JLabel jLabelNutricion = null;
	private JButton jButtonInsertarNutricion = null;
	private JButton jButtonModificarNutricion = null;
	private JButton jButtonEliminarNutricion = null;
	private JButton jButtonVerNutricion = null;
	private EvolucionTrasplanteNutricion evoNutricion;
	private JButton jButtonAtras = null;
	private JButton jButtonBorrar = null;
	private boolean fechaFija= false;
	private JDesktopPane jDesktopPaneOtrosExamenes = null;
	private JLabel jLabelOtrosExamenes = null;
	private JButton jButtonInsertarOtrosExamenes = null;
	private JButton jButtonInsertarEcoDopler = null;
	private JButton jButtonInsertarEcografia = null;
	/**
	 * This is the default constructor
	 */
	public IUEvolucionTrasplanteElegirTipo(Trasplante t) {
		super();
		initialize();
		this.t = t;
		this.cargarDatos();
		Fachada.getInstancia().agregarObservador(this);
	}

	public IUEvolucionTrasplanteElegirTipo(Trasplante t, EvolucionTrasplanteTotal evo,boolean ver) {
		super();
		initialize();
		this.t = t;
		this.jDateChooserFecha.setCalendar(evo.getFecha());
		this.fecha = evo.getFecha();
		Fachada.getInstancia().agregarObservador(this);
		this.fechaFija = true;
		cargarDatos();
	}

	private void cargarDatos() {
		if(this.fechaFija){
			comprobarfecha();
			cargarClasico();
			cargarCMV();
			cargarECG();
			cargarMarvirales();
			cargarEcoCardio();
			cargarTxTorax();
			cargarNutricion();
		}else{
			desactivarBotonesEliminar();
		}
	}

	private void desactivarBotonesEliminar(){
		this.jButtonClasicaModificar.setEnabled(false);
		this.jButtonClasicaEliminar.setEnabled(false);
		this.jButtonVerClasica.setEnabled(false);
		this.jButtonCMVModificar.setEnabled(false);
		this.jButtonCMVEliminar.setEnabled(false);
		this.jButtonVerCMV.setEnabled(false);
		this.jButtonECGModificar.setEnabled(false);
		this.jButtonECGEliminar.setEnabled(false);
		this.jButtonVerECG.setEnabled(false);
		this.jButtonMarviralesModificar.setEnabled(false);
		this.jButtonMarviralesEliminar.setEnabled(false);
		this.jButtonVerMarvirales.setEnabled(false);
		this.jButtonEcoCardioModificar.setEnabled(false);
		this.jButtonEcoCardioEliminar.setEnabled(false);
		this.jButtonVerEcoCardio.setEnabled(false);
		this.jButtonModificarTxTorax.setEnabled(false);
		this.jButtonEliminarTxTorax.setEnabled(false);
		this.jButtonVerTxTorax.setEnabled(false);
		this.jButtonModificarNutricion.setEnabled(false);
		this.jButtonEliminarNutricion.setEnabled(false);
		this.jButtonVerNutricion.setEnabled(false);
	}
	
	private void cargarNutricion() {
		EvolucionTrasplanteNutricion aux = new EvolucionTrasplanteNutricion();
		aux.setIdTrasplante(this.t.getId());
		aux.setFecha(this.fecha);
		ArrayList<EvolucionTrasplanteNutricion> lista = aux.obtenerTodos();
		if (lista.size() == 0) {
			this.jButtonInsertarNutricion.setEnabled(true);
			this.jButtonModificarNutricion.setEnabled(false);
			this.jButtonEliminarNutricion.setEnabled(false);
			this.jButtonVerNutricion.setEnabled(false);

		} else {
			this.jButtonInsertarNutricion.setEnabled(false);
			this.jButtonModificarNutricion.setEnabled(true);
			this.jButtonEliminarNutricion.setEnabled(true);
			this.jButtonVerNutricion.setEnabled(true);

			this.evoNutricion = lista.get(0);
		}
	}
	
	private void cargarTxTorax() {
		EvolucionTrasplanteTxTorax aux = new EvolucionTrasplanteTxTorax();
		aux.setIdTrasplante(this.t.getId());
		aux.setFecha(this.fecha);
		ArrayList<EvolucionTrasplanteTxTorax> lista = aux.obtenerTodos();
		if (lista.size() == 0) {
			this.jButtonoInsertarTxTorax.setEnabled(true);
			this.jButtonModificarTxTorax.setEnabled(false);
			this.jButtonEliminarTxTorax.setEnabled(false);
			this.jButtonVerTxTorax.setEnabled(false);

		} else {
			this.jButtonoInsertarTxTorax.setEnabled(false);
			this.jButtonModificarTxTorax.setEnabled(true);
			this.jButtonEliminarTxTorax.setEnabled(true);
			this.jButtonVerTxTorax.setEnabled(true);

			this.evoTxTorax = lista.get(0);
		}
	}
	
	private void cargarEcoCardio() {
		EvolucionTrasplanteEcoCardio aux = new EvolucionTrasplanteEcoCardio();
		aux.setIdTrasplante(this.t.getId());
		aux.setFecha(this.fecha);
		ArrayList<EvolucionTrasplanteEcoCardio> lista = aux.obtenerTodos();
		if (lista.size() == 0) {
			this.jButtonEcoCardioInsertar.setEnabled(true);
			this.jButtonEcoCardioModificar.setEnabled(false);
			this.jButtonEcoCardioEliminar.setEnabled(false);
			this.jButtonVerEcoCardio.setEnabled(false);

		} else {
			this.jButtonEcoCardioInsertar.setEnabled(false);
			this.jButtonEcoCardioModificar.setEnabled(true);
			this.jButtonEcoCardioEliminar.setEnabled(true);
			this.jButtonVerEcoCardio.setEnabled(true);

			this.evoEcoCardio = lista.get(0);
		}
	}

	private void cargarMarvirales() {
		EvolucionTrasplanteMarvirales aux = new EvolucionTrasplanteMarvirales();
		aux.setIdTrasplante(this.t.getId());
		aux.setFecha(this.fecha);
		ArrayList<EvolucionTrasplanteMarvirales> lista = aux.obtenerTodos();
		if (lista.size() == 0) {
			this.jButtonMarviralesInsertar.setEnabled(true);
			this.jButtonMarviralesModificar.setEnabled(false);
			this.jButtonMarviralesEliminar.setEnabled(false);
			this.jButtonVerMarvirales.setEnabled(false);
		} else {
			this.jButtonMarviralesInsertar.setEnabled(false);
			this.jButtonMarviralesModificar.setEnabled(true);
			this.jButtonMarviralesEliminar.setEnabled(true);
			this.jButtonVerMarvirales.setEnabled(true);
			this.evoMarvilares = lista.get(0);
		}
	}

	private void cargarECG() {
		EvolucionTrasplanteECG aux = new EvolucionTrasplanteECG();
		aux.setIdTrasplante(this.t.getId());
		aux.setFecha(this.fecha);
		ArrayList<EvolucionTrasplanteECG> lista = aux.obtenerTodos();
		if (lista.size() == 0) {
			this.jButtonECGInsertar.setEnabled(true);
			this.jButtonECGModificar.setEnabled(false);
			this.jButtonECGEliminar.setEnabled(false);
			this.jButtonVerECG.setEnabled(false);
		} else {
			this.jButtonECGInsertar.setEnabled(false);
			this.jButtonECGModificar.setEnabled(true);
			this.jButtonECGEliminar.setEnabled(true);
			this.jButtonVerECG.setEnabled(true);
			this.evoECG = lista.get(0);
		}
	}

	private void cargarCMV() {
		EvolucionTrasplanteCMV aux = new EvolucionTrasplanteCMV();
		aux.setIdTrasplante(this.t.getId());
		aux.setFecha(this.fecha);
		ArrayList<EvolucionTrasplanteCMV> lista = aux.obtenerTodos();
		if (lista.size() == 0) {
			this.jButtonCMVInsertar.setEnabled(true);
			this.jButtonCMVModificar.setEnabled(false);
			this.jButtonCMVEliminar.setEnabled(false);
			this.jButtonVerCMV.setEnabled(false);
		} else {
			this.jButtonCMVInsertar.setEnabled(false);
			this.jButtonCMVModificar.setEnabled(true);
			this.jButtonCMVEliminar.setEnabled(true);
			this.jButtonVerCMV.setEnabled(true);
			this.evoCMV = lista.get(0);
		}
	}

	private void cargarClasico() {
		EvolucionTrasplante auxEv = new EvolucionTrasplante();
		auxEv.setIdTrasplante(this.t.getId());
		auxEv.setFecha(this.fecha);
		ArrayList<EvolucionTrasplante> listaEv = auxEv.obtenerTodos();
		if (listaEv.size() == 0) {
			this.jButtonClasicaInsertar.setEnabled(true);
			this.jButtonClasicaModificar.setEnabled(false);
			this.jButtonClasicaEliminar.setEnabled(false);
			this.jButtonVerClasica.setEnabled(false);
		} else {
			this.jButtonClasicaInsertar.setEnabled(false);
			this.jButtonClasicaModificar.setEnabled(true);
			this.jButtonClasicaEliminar.setEnabled(true);
			this.jButtonVerClasica.setEnabled(true);
			this.evoClasica = listaEv.get(0);
		}
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(1141, 570);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.jButtonBorrar.setVisible(false);
		this.setTitle("Elegir tipo de evolucion");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelClasica = new JLabel();
			jLabelClasica.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelClasica.setBounds(new Rectangle(103, 14, 121, 32));
			jLabelClasica.setText("Paraclinica");
			jLabelFecha = new JLabel();
			jLabelFecha.setBounds(new Rectangle(125, 13, 116, 32));
			jLabelFecha.setText("Fecha: ");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 204));
			jContentPane.add(jLabelFecha, null);
			jContentPane.add(getJDateChooserFecha(), null);
			jContentPane.add(getJDesktopPaneClasica(), null);
			jContentPane.add(getJDesktopPaneCMV(), null);
			jContentPane.add(getJDesktopPaneECG(), null);
			jContentPane.add(getJDesktopPaneMarvirales(), null);
			jContentPane.add(getJDesktopPaneEcoCardio(), null);
			jContentPane.add(getJDesktopPaneTxTorax(), null);
			jContentPane.add(getJDesktopPaneNutricion(), null);
			jContentPane.add(getJButtonAtras(), null);
			jContentPane.add(getJButtonBorrar(), null);
			jContentPane.add(getJDesktopPaneOtrosExamenes(), null);
		}
		return jContentPane;
	}

	private boolean chequearFecha() {
		Calendar aux = this.t.getFecha();
		aux.add(Calendar.DAY_OF_YEAR, -1);
		if (aux.before(this.jDateChooserFecha.getCalendar())) {
			return true;
		} else {
			return false;
		}
	}

	public void update(Observable arg0, Object arg1) {
		Observable o = arg0;
		if (o == Fachada.getInstancia()) {
			if(Fachada.getInstancia().getLugar() == Fachada.EVOLUCION_SIMPLE
					|| Fachada.getInstancia().getLugar() == Fachada.EVOLUCION_CMV
					|| Fachada.getInstancia().getLugar() == Fachada.EVOLUCION_ECG
					|| Fachada.getInstancia().getLugar() == Fachada.EVOLUCION_MARVIRALES
					|| Fachada.getInstancia().getLugar() == Fachada.EVOLUCION_ECOCARDIO
					|| Fachada.getInstancia().getLugar() == Fachada.EVOLUCION_TXTORAX
					|| Fachada.getInstancia().getLugar() == Fachada.EVOLUCION_NUTRICION){
				
				if(Fachada.getInstancia().estadoIngresoEvolucion()){
					this.fechaFija = true;
					this.cargarDatos();
				}
			}
		}

	}

	/**
	 * This method initializes jDateChooserFecha
	 * 
	 * @return com.toedter.calendar.JDateChooser
	 */
	private JDateChooser getJDateChooserFecha() {
		if (jDateChooserFecha == null) {
			jDateChooserFecha = new JDateChooser();
			jDateChooserFecha.setBounds(new Rectangle(264, 13, 226, 32));
		}
		return jDateChooserFecha;
	}

	/**
	 * This method initializes jButtonClasicaInsertar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonClasicaInsertar() {
		if (jButtonClasicaInsertar == null) {
			jButtonClasicaInsertar = new JButton();
			jButtonClasicaInsertar.setText("Ingresar");
			jButtonClasicaInsertar.setBounds(new Rectangle(6, 56, 98, 27));
			jButtonClasicaInsertar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							guardarClasica();
						}
					});
		}
		return jButtonClasicaInsertar;
	}

	/**
	 * This method initializes jButtonClasicaModificar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonClasicaModificar() {
		if (jButtonClasicaModificar == null) {
			jButtonClasicaModificar = new JButton();
			jButtonClasicaModificar.setText("Modificar");
			jButtonClasicaModificar.setBounds(new Rectangle(117, 56, 98, 27));
			jButtonClasicaModificar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							modificarClasica();
						}
					});
		}
		return jButtonClasicaModificar;
	}

	/**
	 * This method initializes jButtonClasicaEliminar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonClasicaEliminar() {
		if (jButtonClasicaEliminar == null) {
			jButtonClasicaEliminar = new JButton();
			jButtonClasicaEliminar.setText("Eliminar");
			jButtonClasicaEliminar.setBounds(new Rectangle(227, 56, 98, 27));
			jButtonClasicaEliminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					eliminarClasica();
				}
			});
		}
		return jButtonClasicaEliminar;
	}

	/**
	 * This method initializes jDesktopPaneClasica
	 * 
	 * @return javax.swing.JDesktopPane
	 */
	private JDesktopPane getJDesktopPaneClasica() {
		if (jDesktopPaneClasica == null) {
			jDesktopPaneClasica = new JDesktopPane();
			jDesktopPaneClasica.setBounds(new Rectangle(18, 70, 337, 123));
			jDesktopPaneClasica.add(jLabelClasica, null);
			jDesktopPaneClasica.add(getJButtonClasicaInsertar(), null);
			jDesktopPaneClasica.add(getJButtonClasicaModificar(), null);
			jDesktopPaneClasica.add(getJButtonClasicaEliminar(), null);
			jDesktopPaneClasica.add(getJButtonVerClasica(), null);
		}
		return jDesktopPaneClasica;
	}

	/**
	 * This method initializes jDesktopPaneCMV
	 * 
	 * @return javax.swing.JDesktopPane
	 */
	private JDesktopPane getJDesktopPaneCMV() {
		if (jDesktopPaneCMV == null) {
			jLabelCMV1 = new JLabel();
			jLabelCMV1.setBounds(new Rectangle(103, 14, 121, 32));
			jLabelCMV1.setText("CMV");
			jLabelCMV1.setHorizontalAlignment(SwingConstants.CENTER);
			jDesktopPaneCMV = new JDesktopPane();
			jDesktopPaneCMV.setBounds(new Rectangle(416, 69, 340, 126));
			jDesktopPaneCMV.add(jLabelCMV1, null);
			jDesktopPaneCMV.add(getJButtonCMVInsertar(), null);
			jDesktopPaneCMV.add(getJButtonCMVModificar(), null);
			jDesktopPaneCMV.add(getJButtonCMVEliminar(), null);
			jDesktopPaneCMV.add(getJButtonVerCMV(), null);
		}
		return jDesktopPaneCMV;
	}

	/**
	 * This method initializes jButtonCMVInsertar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCMVInsertar() {
		if (jButtonCMVInsertar == null) {
			jButtonCMVInsertar = new JButton();
			jButtonCMVInsertar.setBounds(new Rectangle(6, 56, 98, 27));
			jButtonCMVInsertar.setText("Ingresar");
			jButtonCMVInsertar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							cmvInsertar();
						}
					});
		}
		return jButtonCMVInsertar;
	}

	/**
	 * This method initializes jButtonCMVModificar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCMVModificar() {
		if (jButtonCMVModificar == null) {
			jButtonCMVModificar = new JButton();
			jButtonCMVModificar.setBounds(new Rectangle(117, 56, 98, 27));
			jButtonCMVModificar.setText("Modificar");
			jButtonCMVModificar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							cmvModificar();
						}
					});
		}
		return jButtonCMVModificar;
	}

	/**
	 * This method initializes jButtonCMVEliminar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCMVEliminar() {
		if (jButtonCMVEliminar == null) {
			jButtonCMVEliminar = new JButton();
			jButtonCMVEliminar.setBounds(new Rectangle(227, 56, 98, 27));
			jButtonCMVEliminar.setText("Eliminar");
			jButtonCMVEliminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					eliminarCMV();
				}
			});
		}
		return jButtonCMVEliminar;
	}

	private void guardarClasica() {
		if (this.chequearFecha()) {
			IUEvolucionManejarSimple clasica = new IUEvolucionManejarSimple(
					this.t, this.jDateChooserFecha.getCalendar());
			clasica.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this,
					"La fecha tiene que ser mayor a la del dia del trasplante",
					"Error", 2);
		}
	}

	private void modificarClasica() {
		if (this.evoClasica != null) {
			IUEvolucionManejarSimple clasica = new IUEvolucionManejarSimple(
					this.t, this.evoClasica, this.fecha);
			clasica.setVisible(true);
		}
	}

	private void verClasica() {
		if (this.evoClasica != null) {
			IUEvolucionManejarSimple clasica = new IUEvolucionManejarSimple(
					this.t, this.evoClasica, this.fecha, true);
			clasica.setVisible(true);
		}
	}

	private void cmvInsertar() {
		if (this.chequearFecha()) {
			IUEvolucionCMVManejar cmv = new IUEvolucionCMVManejar(this.t
					.getId(), null, this.jDateChooserFecha.getCalendar());
			cmv.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this,
					"La fecha tiene que ser mayor a la del dia del trasplante",
					"Error", 2);
		}
	}

	private void cmvModificar() {
		if (this.evoClasica != null) {
			IUEvolucionCMVManejar cmv = new IUEvolucionCMVManejar(this.t
					.getId(), this.evoCMV, this.jDateChooserFecha.getCalendar());
			cmv.setVisible(true);
		}
	}

	private void cmvVer() {
		if (this.evoClasica != null) {
			IUEvolucionCMVManejar cmv = new IUEvolucionCMVManejar(this.t
					.getId(), this.evoCMV,
					this.jDateChooserFecha.getCalendar(), true);
			cmv.setVisible(true);
		}
	}

	/**
	 * This method initializes jDesktopPaneECG
	 * 
	 * @return javax.swing.JDesktopPane
	 */
	private JDesktopPane getJDesktopPaneECG() {
		if (jDesktopPaneECG == null) {
			jLabelECG = new JLabel();
			jLabelECG.setBounds(new Rectangle(103, 14, 121, 32));
			jLabelECG.setText("ECG");
			jLabelECG.setHorizontalAlignment(SwingConstants.CENTER);
			jDesktopPaneECG = new JDesktopPane();
			jDesktopPaneECG.setBounds(new Rectangle(777, 70, 339, 128));
			jDesktopPaneECG.add(jLabelECG, null);
			jDesktopPaneECG.add(getJButtonECGInsertar(), null);
			jDesktopPaneECG.add(getJButtonECGModificar(), null);
			jDesktopPaneECG.add(getJButtonECGEliminar(), null);
			jDesktopPaneECG.add(getJButtonVerECG(), null);
		}
		return jDesktopPaneECG;
	}

	/**
	 * This method initializes jButtonECGInsertar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonECGInsertar() {
		if (jButtonECGInsertar == null) {
			jButtonECGInsertar = new JButton();
			jButtonECGInsertar.setBounds(new Rectangle(6, 56, 98, 27));
			jButtonECGInsertar.setText("Ingresar");
			jButtonECGInsertar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							ecgIngresar();
						}
					});
		}
		return jButtonECGInsertar;
	}

	/**
	 * This method initializes jButtonECGModificar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonECGModificar() {
		if (jButtonECGModificar == null) {
			jButtonECGModificar = new JButton();
			jButtonECGModificar.setBounds(new Rectangle(117, 56, 98, 27));
			jButtonECGModificar.setText("Modificar");
			jButtonECGModificar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							ecgModificar();
						}
					});
		}
		return jButtonECGModificar;
	}

	/**
	 * This method initializes jButtonECGEliminar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonECGEliminar() {
		if (jButtonECGEliminar == null) {
			jButtonECGEliminar = new JButton();
			jButtonECGEliminar.setBounds(new Rectangle(227, 56, 98, 27));
			jButtonECGEliminar.setText("Eliminar");
			jButtonECGEliminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					eliminarECG();
				}
			});
		}
		return jButtonECGEliminar;
	}

	private void ecgIngresar() {
		if (this.chequearFecha()) {
			IUEvolucionECGManejar ecg = new IUEvolucionECGManejar(this.t
					.getId(), null, this.jDateChooserFecha.getCalendar());
			ecg.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this,
					"La fecha tiene que ser mayor a la del dia del trasplante",
					"Error", 2);
		}
	}

	private void ecgModificar() {
		if (this.evoECG != null) {
			IUEvolucionECGManejar ecg = new IUEvolucionECGManejar(this.t
					.getId(), this.evoECG, this.jDateChooserFecha.getCalendar());
			ecg.setVisible(true);
		}

	}

	private void ecgVer() {
		if (this.evoECG != null) {
			IUEvolucionECGManejar ecg = new IUEvolucionECGManejar(this.t
					.getId(), this.evoECG,
					this.jDateChooserFecha.getCalendar(), true);
			ecg.setVisible(true);
		}

	}

	/**
	 * This method initializes jDesktopPaneMarvirales
	 * 
	 * @return javax.swing.JDesktopPane
	 */
	private JDesktopPane getJDesktopPaneMarvirales() {
		if (jDesktopPaneMarvirales == null) {
			jLabelMarvirales = new JLabel();
			jLabelMarvirales.setBounds(new Rectangle(103, 14, 121, 32));
			jLabelMarvirales.setText("Marcadores Virales");
			jLabelMarvirales.setHorizontalAlignment(SwingConstants.CENTER);
			jDesktopPaneMarvirales = new JDesktopPane();
			jDesktopPaneMarvirales.setBounds(new Rectangle(413, 213, 338, 124));
			jDesktopPaneMarvirales.add(jLabelMarvirales, null);
			jDesktopPaneMarvirales.add(getJButtonMarviralesInsertar(), null);
			jDesktopPaneMarvirales.add(getJButtonMarviralesModificar(), null);
			jDesktopPaneMarvirales.add(getJButtonMarviralesEliminar(), null);
			jDesktopPaneMarvirales.add(getJButtonVerMarvirales(), null);
		}
		return jDesktopPaneMarvirales;
	}

	/**
	 * This method initializes jButtonMarviralesInsertar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonMarviralesInsertar() {
		if (jButtonMarviralesInsertar == null) {
			jButtonMarviralesInsertar = new JButton();
			jButtonMarviralesInsertar.setBounds(new Rectangle(6, 56, 98, 27));
			jButtonMarviralesInsertar.setText("Ingresar");
			jButtonMarviralesInsertar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							marviralIngresar();
						}
					});
		}
		return jButtonMarviralesInsertar;
	}

	/**
	 * This method initializes jButtonMarviralesModificar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonMarviralesModificar() {
		if (jButtonMarviralesModificar == null) {
			jButtonMarviralesModificar = new JButton();
			jButtonMarviralesModificar
					.setBounds(new Rectangle(117, 56, 98, 27));
			jButtonMarviralesModificar.setText("Modificar");
			jButtonMarviralesModificar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							marviralModificar();
						}
					});
		}
		return jButtonMarviralesModificar;
	}

	/**
	 * This method initializes jButtonMarviralesEliminar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonMarviralesEliminar() {
		if (jButtonMarviralesEliminar == null) {
			jButtonMarviralesEliminar = new JButton();
			jButtonMarviralesEliminar.setBounds(new Rectangle(227, 56, 98, 27));
			jButtonMarviralesEliminar.setText("Eliminar");
			jButtonMarviralesEliminar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							eliminarMarvirales();
						}
					});
		}
		return jButtonMarviralesEliminar;
	}

	private void marviralIngresar() {
		if (this.chequearFecha()) {
			IUEvolucionMarvilaresManejar mar = new IUEvolucionMarvilaresManejar(
					this.t.getId(), null, this.jDateChooserFecha.getCalendar());
			mar.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this,
					"La fecha tiene que ser mayor a la del dia del trasplante",
					"Error", 2);
		}
	}

	private void marviralModificar() {
		if (this.evoMarvilares != null) {
			IUEvolucionMarvilaresManejar marv = new IUEvolucionMarvilaresManejar(
					this.t.getId(), this.evoMarvilares, this.jDateChooserFecha
							.getCalendar());
			marv.setVisible(true);
		}
	}
	
	private void marviralesVer() {
		if (this.evoMarvilares != null) {
			IUEvolucionMarvilaresManejar marv = new IUEvolucionMarvilaresManejar(
					this.t.getId(), this.evoMarvilares, this.jDateChooserFecha
							.getCalendar());
			marv.setVisible(true);
		}
	}

	/**
	 * This method initializes jDesktopPaneEcoCardio
	 * 
	 * @return javax.swing.JDesktopPane
	 */
	private JDesktopPane getJDesktopPaneEcoCardio() {
		if (jDesktopPaneEcoCardio == null) {
			jLabelEcoCardio = new JLabel();
			jLabelEcoCardio.setBounds(new Rectangle(103, 14, 121, 32));
			jLabelEcoCardio.setText("Ecocardiograma");
			jLabelEcoCardio.setHorizontalAlignment(SwingConstants.CENTER);
			jDesktopPaneEcoCardio = new JDesktopPane();
			jDesktopPaneEcoCardio.setBounds(new Rectangle(19, 212, 338, 126));
			jDesktopPaneEcoCardio.add(jLabelEcoCardio, null);
			jDesktopPaneEcoCardio.add(getJButtonEcoCardioInsertar(), null);
			jDesktopPaneEcoCardio.add(getJButtonEcoCardioModificar(), null);
			jDesktopPaneEcoCardio.add(getJButtonEcoCardioEliminar(), null);
			jDesktopPaneEcoCardio.add(getJButtonVerEcoCardio(), null);
		}
		return jDesktopPaneEcoCardio;
	}

	/**
	 * This method initializes jButtonEcoCardioInsertar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonEcoCardioInsertar() {
		if (jButtonEcoCardioInsertar == null) {
			jButtonEcoCardioInsertar = new JButton();
			jButtonEcoCardioInsertar.setBounds(new Rectangle(6, 56, 98, 27));
			jButtonEcoCardioInsertar.setText("Ingresar");
			jButtonEcoCardioInsertar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ecoCardioIngresar();
				}
			});
		}
		return jButtonEcoCardioInsertar;
	}

	private void ecoCardioIngresar() {
		if (this.chequearFecha()) {
			IUEvolucionEcoCardioManejar ecoCar = new IUEvolucionEcoCardioManejar(this.t
					.getId(), null, this.jDateChooserFecha.getCalendar());
			ecoCar.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this,
					"La fecha tiene que ser mayor a la del dia del trasplante",
					"Error", 2);
		}
	}
	
	private void ecoCardioModificar() {
		if (this.evoEcoCardio != null) {
			IUEvolucionEcoCardioManejar ecoCar1 = new IUEvolucionEcoCardioManejar(
					this.t.getId(), this.evoEcoCardio, this.jDateChooserFecha
							.getCalendar());
			ecoCar1.setVisible(true);
		}
	}
	
	private void ecoCardioVer() {
		if (this.evoEcoCardio != null) {
			IUEvolucionEcoCardioManejar ecoCar2 = new IUEvolucionEcoCardioManejar(
					this.t.getId(), this.evoEcoCardio, this.jDateChooserFecha
							.getCalendar(),true);
			ecoCar2.setVisible(true);
		}
	}
	/**
	 * This method initializes jButtonEcoCardioModificar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonEcoCardioModificar() {
		if (jButtonEcoCardioModificar == null) {
			jButtonEcoCardioModificar = new JButton();
			jButtonEcoCardioModificar.setBounds(new Rectangle(117, 56, 98, 27));
			jButtonEcoCardioModificar.setText("Modificar");
			jButtonEcoCardioModificar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							ecoCardioModificar();
						}
					});
		}
		return jButtonEcoCardioModificar;
	}

	/**
	 * This method initializes jButtonEcoCardioEliminar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonEcoCardioEliminar() {
		if (jButtonEcoCardioEliminar == null) {
			jButtonEcoCardioEliminar = new JButton();
			jButtonEcoCardioEliminar.setBounds(new Rectangle(227, 56, 98, 27));
			jButtonEcoCardioEliminar.setText("Eliminar");
			jButtonEcoCardioEliminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					eliminarEcoCardio();
				}
			});
		}
		return jButtonEcoCardioEliminar;
	}

	/**
	 * This method initializes jButtonVerClasica
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonVerClasica() {
		if (jButtonVerClasica == null) {
			jButtonVerClasica = new JButton();
			jButtonVerClasica.setBounds(new Rectangle(117, 90, 98, 27));
			jButtonVerClasica.setText("Ver");
			jButtonVerClasica
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							verClasica();
						}
					});
		}
		return jButtonVerClasica;
	}

	/**
	 * This method initializes jButtonVerCMV
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonVerCMV() {
		if (jButtonVerCMV == null) {
			jButtonVerCMV = new JButton();
			jButtonVerCMV.setBounds(new Rectangle(117, 90, 98, 27));
			jButtonVerCMV.setText("Ver");
			jButtonVerCMV
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							cmvVer();
						}
					});
		}
		return jButtonVerCMV;
	}

	/**
	 * This method initializes jButtonVerECG
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonVerECG() {
		if (jButtonVerECG == null) {
			jButtonVerECG = new JButton();
			jButtonVerECG.setBounds(new Rectangle(117, 90, 98, 27));
			jButtonVerECG.setText("Ver");
			jButtonVerECG
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							ecgVer();
						}
					});
		}
		return jButtonVerECG;
	}

	/**

	 * This method initializes jButtonVerMarvirales
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonVerMarvirales() {
		if (jButtonVerMarvirales == null) {
			jButtonVerMarvirales = new JButton();
			jButtonVerMarvirales.setBounds(new Rectangle(117, 90, 98, 27));
			jButtonVerMarvirales.setText("Ver");
			jButtonVerMarvirales.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					marviralesVer();
				}
			});
		}
		return jButtonVerMarvirales;
	}

	/**
	 * This method initializes jButtonVerEcoCardio
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonVerEcoCardio() {
		if (jButtonVerEcoCardio == null) {
			jButtonVerEcoCardio = new JButton();
			jButtonVerEcoCardio.setBounds(new Rectangle(117, 90, 98, 27));
			jButtonVerEcoCardio.setText("Ver");
			jButtonVerEcoCardio.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ecoCardioVer();
				}
			});
		}
		return jButtonVerEcoCardio;
	}

	/**
	 * This method initializes jDesktopPaneTxTorax	
	 * 	
	 * @return javax.swing.JDesktopPane	
	 */
	private JDesktopPane getJDesktopPaneTxTorax() {
		if (jDesktopPaneTxTorax == null) {
			jLabelTxTorax = new JLabel();
			jLabelTxTorax.setBounds(new Rectangle(103, 14, 121, 32));
			jLabelTxTorax.setText("Tx Torax");
			jLabelTxTorax.setHorizontalAlignment(SwingConstants.CENTER);
			jDesktopPaneTxTorax = new JDesktopPane();
			jDesktopPaneTxTorax.setBounds(new Rectangle(777, 214, 336, 131));
			jDesktopPaneTxTorax.add(jLabelTxTorax, null);
			jDesktopPaneTxTorax.add(getJButtonoInsertarTxTorax(), null);
			jDesktopPaneTxTorax.add(getJButtonModificarTxTorax(), null);
			jDesktopPaneTxTorax.add(getJButtonEliminarTxTorax(), null);
			jDesktopPaneTxTorax.add(getJButtonVerTxTorax(), null);
		}
		return jDesktopPaneTxTorax;
	}

	/**
	 * This method initializes jButtonoInsertarTxTorax	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonoInsertarTxTorax() {
		if (jButtonoInsertarTxTorax == null) {
			jButtonoInsertarTxTorax = new JButton();
			jButtonoInsertarTxTorax.setBounds(new Rectangle(6, 56, 98, 27));
			jButtonoInsertarTxTorax.setText("Ingresar");
			jButtonoInsertarTxTorax.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txToraxIngresar();
				}
			});
		}
		return jButtonoInsertarTxTorax;
	}

	/**
	 * This method initializes jButtonModificarTxTorax	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonModificarTxTorax() {
		if (jButtonModificarTxTorax == null) {
			jButtonModificarTxTorax = new JButton();
			jButtonModificarTxTorax.setBounds(new Rectangle(117, 56, 98, 27));
			jButtonModificarTxTorax.setText("Modificar");
			jButtonModificarTxTorax.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txToraxModificar();
				}
			});
		}
		return jButtonModificarTxTorax;
	}

	/**
	 * This method initializes jButtonEliminarTxTorax	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonEliminarTxTorax() {
		if (jButtonEliminarTxTorax == null) {
			jButtonEliminarTxTorax = new JButton();
			jButtonEliminarTxTorax.setBounds(new Rectangle(227, 56, 98, 27));
			jButtonEliminarTxTorax.setText("Eliminar");
			jButtonEliminarTxTorax.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					eliminarTxTorax();
				}
			});
		}
		return jButtonEliminarTxTorax;
	}

	/**
	 * This method initializes jButtonVerTxTorax	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonVerTxTorax() {
		if (jButtonVerTxTorax == null) {
			jButtonVerTxTorax = new JButton();
			jButtonVerTxTorax.setBounds(new Rectangle(117, 90, 98, 27));
			jButtonVerTxTorax.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txToraxVer();
				}
			});
			jButtonVerTxTorax.setText("Ver");
		}
		return jButtonVerTxTorax;
	}
	
	private void txToraxIngresar(){
		if (this.chequearFecha()) {
			IUEvolucionTxToraxManejar ecoTx = new IUEvolucionTxToraxManejar(this.t
					.getId(), null, this.jDateChooserFecha.getCalendar());
			ecoTx.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this,
					"La fecha tiene que ser mayor a la del dia del trasplante",
					"Error", 2);
		}
	}
	
	private void txToraxModificar(){
		if (this.evoTxTorax != null) {
			IUEvolucionTxToraxManejar evoTx = new IUEvolucionTxToraxManejar(
					this.t.getId(), this.evoTxTorax, this.jDateChooserFecha
							.getCalendar());
			evoTx.setVisible(true);
		}
	}
	
	private void txToraxVer(){
		if (this.evoTxTorax != null) {
			IUEvolucionTxToraxManejar evoTx = new IUEvolucionTxToraxManejar(
					this.t.getId(), this.evoTxTorax, this.jDateChooserFecha
							.getCalendar(),true);
			evoTx.setVisible(true);
		}
	}

	/**
	 * This method initializes jDesktopPaneNutricion	
	 * 	
	 * @return javax.swing.JDesktopPane	
	 */
	private JDesktopPane getJDesktopPaneNutricion() {
		if (jDesktopPaneNutricion == null) {
			jLabelNutricion = new JLabel();
			jLabelNutricion.setBounds(new Rectangle(103, 14, 121, 32));
			jLabelNutricion.setText("Nutricion");
			jLabelNutricion.setHorizontalAlignment(SwingConstants.CENTER);
			jDesktopPaneNutricion = new JDesktopPane();
			jDesktopPaneNutricion.setBounds(new Rectangle(412, 371, 338, 136));
			jDesktopPaneNutricion.add(jLabelNutricion, null);
			jDesktopPaneNutricion.add(getJButtonInsertarNutricion(), null);
			jDesktopPaneNutricion.add(getJButtonModificarNutricion(), null);
			jDesktopPaneNutricion.add(getJButtonEliminarNutricion(), null);
			jDesktopPaneNutricion.add(getJButtonVerNutricion(), null);
		}
		return jDesktopPaneNutricion;
	}

	/**
	 * This method initializes jButtonInsertarNutricion	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonInsertarNutricion() {
		if (jButtonInsertarNutricion == null) {
			jButtonInsertarNutricion = new JButton();
			jButtonInsertarNutricion.setBounds(new Rectangle(6, 56, 98, 27));
			jButtonInsertarNutricion.setText("Ingresar");
			jButtonInsertarNutricion.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					nutricionIngresar();
				}
			});
		}
		return jButtonInsertarNutricion;
	}

	/**
	 * This method initializes jButtonModificarNutricion	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonModificarNutricion() {
		if (jButtonModificarNutricion == null) {
			jButtonModificarNutricion = new JButton();
			jButtonModificarNutricion.setBounds(new Rectangle(117, 56, 98, 27));
			jButtonModificarNutricion.setText("Modificar");
			jButtonModificarNutricion
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							nutricionModificar();
						}
					});
		}
		return jButtonModificarNutricion;
	}

	/**
	 * This method initializes jButtonEliminarNutricion	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonEliminarNutricion() {
		if (jButtonEliminarNutricion == null) {
			jButtonEliminarNutricion = new JButton();
			jButtonEliminarNutricion.setBounds(new Rectangle(227, 56, 98, 27));
			jButtonEliminarNutricion.setText("Eliminar");
			jButtonEliminarNutricion.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					eliminarNutricion();
				}
			});
		}
		return jButtonEliminarNutricion;
	}

	/**
	 * This method initializes jButtonVerNutricion	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonVerNutricion() {
		if (jButtonVerNutricion == null) {
			jButtonVerNutricion = new JButton();
			jButtonVerNutricion.setBounds(new Rectangle(117, 90, 98, 27));
			jButtonVerNutricion.setText("Ver");
			jButtonVerNutricion.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					nutricionVer();
				}
			});
		}
		return jButtonVerNutricion;
	}
	
	private void nutricionIngresar(){
		if (this.chequearFecha()) {
			IUEvolucionNutricionManejar ecoTx = new IUEvolucionNutricionManejar(this.t
					.getId(), null, this.jDateChooserFecha.getCalendar());
			ecoTx.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this,
					"La fecha tiene que ser mayor a la del dia del trasplante",
					"Error", 2);
		}
	}
	
	private void nutricionModificar(){
		if (this.evoNutricion != null) {
			IUEvolucionNutricionManejar evoTx = new IUEvolucionNutricionManejar(
					this.t.getId(), this.evoNutricion, this.jDateChooserFecha
							.getCalendar());
			evoTx.setVisible(true);
		}
	}
	
	private void nutricionVer(){
		if (this.evoNutricion != null) {
			IUEvolucionNutricionManejar evoTx = new IUEvolucionNutricionManejar(
					this.t.getId(), this.evoNutricion, this.jDateChooserFecha
							.getCalendar(),true);
			evoTx.setVisible(true);
		}
	}

	/**
	 * This method initializes jButtonAtras	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAtras() {
		if (jButtonAtras == null) {
			jButtonAtras = new JButton();
			jButtonAtras.setBounds(new Rectangle(103, 442, 197, 43));
			jButtonAtras.setText("Atras");
			jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salir();
				}
			});
		}
		return jButtonAtras;
	}

	/**
	 * This method initializes jButtonBorrar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonBorrar() {
		if (jButtonBorrar == null) {
			jButtonBorrar = new JButton();
			jButtonBorrar.setBounds(new Rectangle(101, 361, 197, 43));
			jButtonBorrar.setText("Borrar Todo");
			jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					borrarTodo();
				}
			});
		}
		return jButtonBorrar;
	}
	
	private void salir(){
		Fachada.getInstancia().eliminarObservador(this);
		Fachada.getInstancia().cambiarEstadoIngresoEvolucionNegativo();
		this.dispose();
	}
	
	private void comprobarfecha(){
		if(this.fechaFija){
			this.fecha = this.jDateChooserFecha.getCalendar();
		}
	}
	private void eliminarClasica(){
		String respuesta = "";
		respuesta = JOptionPane.showInputDialog(this, "Está a punto de eliminar una evolucion\n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
		if(respuesta==null)respuesta="No";
		if(respuesta.equalsIgnoreCase("Si")){
			comprobarfecha();
			EvolucionTrasplante aux = new EvolucionTrasplante();
			aux.setIdTrasplante(this.t.getId());
			aux.setFecha(this.fecha);
			Fachada.getInstancia().eliminarEvolucionTrasplante(aux);
		}
	}
	
	private void eliminarCMV(){
		String respuesta = "";
		respuesta = JOptionPane.showInputDialog(this, "Está a punto de eliminar una evolucion\n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
		if(respuesta==null)respuesta="No";
		if(respuesta.equalsIgnoreCase("Si")){
			comprobarfecha();
			EvolucionTrasplanteCMV aux = new EvolucionTrasplanteCMV();
			aux.setIdTrasplante(this.t.getId());
			aux.setFecha(this.fecha);
			Fachada.getInstancia().eliminarEvolucionTrasplanteCMV(aux);
		}
	}
	
	private void eliminarECG(){
		String respuesta = "";
		respuesta = JOptionPane.showInputDialog(this, "Está a punto de eliminar una evolucion\n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
		if(respuesta==null)respuesta="No";
		if(respuesta.equalsIgnoreCase("Si")){
			comprobarfecha();
			EvolucionTrasplanteECG aux = new EvolucionTrasplanteECG();
			aux.setIdTrasplante(this.t.getId());
			aux.setFecha(this.fecha);
			Fachada.getInstancia().eliminarEvolucionTrasplanteECG(aux);
		}
	}
	
	private void eliminarEcoCardio(){
		String respuesta = "";
		respuesta = JOptionPane.showInputDialog(this, "Está a punto de eliminar una evolucion\n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
		if(respuesta==null)respuesta="No";
		if(respuesta.equalsIgnoreCase("Si")){
			comprobarfecha();
			EvolucionTrasplanteEcoCardio aux = new EvolucionTrasplanteEcoCardio();
			aux.setIdTrasplante(this.t.getId());
			aux.setFecha(this.fecha);
			Fachada.getInstancia().eliminarEvolucionTrasplanteEcoCardio(aux);
		}
	}
	
	private void eliminarMarvirales(){
		String respuesta = "";
		respuesta = JOptionPane.showInputDialog(this, "Está a punto de eliminar una evolucion\n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
		if(respuesta==null)respuesta="No";
		if(respuesta.equalsIgnoreCase("Si")){
			comprobarfecha();
			EvolucionTrasplanteMarvirales aux = new EvolucionTrasplanteMarvirales();
			aux.setIdTrasplante(this.t.getId());
			aux.setFecha(this.fecha);
			Fachada.getInstancia().eliminarEvolucionTrasplanteMarvirales(aux);
		}
	}
	
	private void eliminarTxTorax(){
		String respuesta = "";
		respuesta = JOptionPane.showInputDialog(this, "Está a punto de eliminar una evolucion\n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
		if(respuesta==null)respuesta="No";
		if(respuesta.equalsIgnoreCase("Si")){
			comprobarfecha();
			EvolucionTrasplanteTxTorax aux = new EvolucionTrasplanteTxTorax();
			aux.setIdTrasplante(this.t.getId());
			aux.setFecha(this.fecha);
			Fachada.getInstancia().eliminarEvolucionTrasplanteTxTorax(aux);
		}
	}
	
	private void eliminarNutricion(){
		String respuesta = "";
		respuesta = JOptionPane.showInputDialog(this, "Está a punto de eliminar una evolucion\n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
		if(respuesta==null)respuesta="No";
		if(respuesta.equalsIgnoreCase("Si")){
			comprobarfecha();
			EvolucionTrasplanteNutricion aux = new EvolucionTrasplanteNutricion();
			aux.setIdTrasplante(this.t.getId());
			aux.setFecha(this.fecha);
			Fachada.getInstancia().eliminarEvolucionTrasplanteNutricion(aux);
		}
	}
	
	private void borrarTodo(){
		String respuesta = "";
		respuesta = JOptionPane.showInputDialog(this, "Está a punto de eliminar todas las evoluciones de esta fecha\n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
		if(respuesta==null)respuesta="No";
		if(respuesta.equalsIgnoreCase("Si")){
			comprobarfecha();
			EvolucionTrasplante aux = new EvolucionTrasplante();
			aux.setIdTrasplante(this.t.getId());
			aux.setFecha(this.fecha);
			Fachada.getInstancia().eliminarEvolucionTrasplante(aux);
			EvolucionTrasplanteNutricion aux1 = new EvolucionTrasplanteNutricion();
			aux1.setIdTrasplante(this.t.getId());
			aux1.setFecha(this.fecha);
			Fachada.getInstancia().eliminarEvolucionTrasplanteNutricion(aux1);
			EvolucionTrasplanteTxTorax aux2 = new EvolucionTrasplanteTxTorax();
			aux2.setIdTrasplante(this.t.getId());
			aux2.setFecha(this.fecha);
			Fachada.getInstancia().eliminarEvolucionTrasplanteTxTorax(aux2);
			EvolucionTrasplanteMarvirales aux3 = new EvolucionTrasplanteMarvirales();
			aux3.setIdTrasplante(this.t.getId());
			aux3.setFecha(this.fecha);
			Fachada.getInstancia().eliminarEvolucionTrasplanteMarvirales(aux3);
			EvolucionTrasplanteEcoCardio aux4 = new EvolucionTrasplanteEcoCardio();
			aux4.setIdTrasplante(this.t.getId());
			aux4.setFecha(this.fecha);
			Fachada.getInstancia().eliminarEvolucionTrasplanteEcoCardio(aux4);
			EvolucionTrasplanteECG aux5 = new EvolucionTrasplanteECG();
			aux5.setIdTrasplante(this.t.getId());
			aux5.setFecha(this.fecha);
			Fachada.getInstancia().eliminarEvolucionTrasplanteECG(aux5);
			EvolucionTrasplanteCMV aux6 = new EvolucionTrasplanteCMV();
			aux6.setIdTrasplante(this.t.getId());
			aux6.setFecha(this.fecha);
			Fachada.getInstancia().eliminarEvolucionTrasplanteCMV(aux6);
		}
	}

	/**
	 * This method initializes jDesktopPaneOtrosExamenes	
	 * 	
	 * @return javax.swing.JDesktopPane	
	 */
	private JDesktopPane getJDesktopPaneOtrosExamenes() {
		if (jDesktopPaneOtrosExamenes == null) {
			jLabelOtrosExamenes = new JLabel();
			jLabelOtrosExamenes.setBounds(new Rectangle(103, 14, 121, 32));
			jLabelOtrosExamenes.setText("Otros Examenes");
			jLabelOtrosExamenes.setHorizontalAlignment(SwingConstants.CENTER);
			jDesktopPaneOtrosExamenes = new JDesktopPane();
			jDesktopPaneOtrosExamenes.setBounds(new Rectangle(777, 369, 338, 139));
			jDesktopPaneOtrosExamenes.add(jLabelOtrosExamenes, null);
			jDesktopPaneOtrosExamenes.add(getJButtonInsertarOtrosExamenes(), null);
			jDesktopPaneOtrosExamenes.add(getJButtonInsertarEcoDopler(), null);
			jDesktopPaneOtrosExamenes.add(getJButtonInsertarEcografia(), null);
		}
		return jDesktopPaneOtrosExamenes;
	}

	/**
	 * This method initializes jButtonInsertarOtrosExamenes	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonInsertarOtrosExamenes() {
		if (jButtonInsertarOtrosExamenes == null) {
			jButtonInsertarOtrosExamenes = new JButton();
			jButtonInsertarOtrosExamenes.setBounds(new Rectangle(9, 55, 98, 27));
			jButtonInsertarOtrosExamenes.setText("Ingresar");
			jButtonInsertarOtrosExamenes
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							otrosExamenes();
						}
					});
		}
		return jButtonInsertarOtrosExamenes;
	}
	
	private void otrosExamenes(){
		IUEvolucionExamenesManejar otrosExamenes = new IUEvolucionExamenesManejar(this.t.getId(),this.jDateChooserFecha.getCalendar());
		otrosExamenes.setVisible(true);
		this.fecha = this.jDateChooserFecha.getCalendar();
	}

	/**
	 * This method initializes jButtonInsertarEcoDopler	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonInsertarEcoDopler() {
		if (jButtonInsertarEcoDopler == null) {
			jButtonInsertarEcoDopler = new JButton();
			jButtonInsertarEcoDopler.setBounds(new Rectangle(124, 55, 98, 27));
			jButtonInsertarEcoDopler.setText("Ecodopler");
			jButtonInsertarEcoDopler.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ecodopler();
				}
			});
		}
		return jButtonInsertarEcoDopler;
	}
	
	private void ecodopler(){
		IUEvolucionEcoDoplerManejar eco = new IUEvolucionEcoDoplerManejar(this.t.getId(), this.jDateChooserFecha.getCalendar());
		eco.setVisible(true);
		this.fecha = this.jDateChooserFecha.getCalendar();
	}

	/**
	 * This method initializes jButtonInsertarEcografia	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonInsertarEcografia() {
		if (jButtonInsertarEcografia == null) {
			jButtonInsertarEcografia = new JButton();
			jButtonInsertarEcografia.setBounds(new Rectangle(234, 55, 98, 27));
			jButtonInsertarEcografia.setText("Ecografia");
			jButtonInsertarEcografia.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ecografia();
				}
			});
		}
		return jButtonInsertarEcografia;
	}
	
	private void ecografia(){
		IUEvolucionEcografiaManejar eco = new IUEvolucionEcografiaManejar(this.t.getId(), this.jDateChooserFecha.getCalendar());
		eco.setVisible(true);
		this.fecha = this.jDateChooserFecha.getCalendar();
	}
} // @jve:decl-index=0:visual-constraint="10,10"
