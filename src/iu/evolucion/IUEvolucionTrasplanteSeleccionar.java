package iu.evolucion;

import iu.IUTratamientoSeleccionar;
import iu.complicacion.IUComplicacionesInfSeleccionar;
import iu.complicacion.IUComplicacionesNoInfSeleccionar;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import logica.Fachada;
import uy.transplante.auxiliares.tablas.ModeloDatosListaEvoluciones;
import uy.transplante.auxiliares.tablas.TableSorter;
import uy.transplante.dominio.EvolucionTrasplanteTotal;
import uy.transplante.dominio.Trasplante;

public class IUEvolucionTrasplanteSeleccionar extends JFrame implements java.util.Observer{

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private Fachada instancia = Fachada.getInstancia();
	private JButton jButtonSalir = null;
	private JButton jButtonAgregar = null;
	private JButton jButtonModificar = null;
	private Trasplante t;
	private int the;
	private JButton jButtonComplicaciones = null;
	private JButton jButtonComplicacionesNInf = null;
	private JScrollPane jScrollPaneDatos = null;
	private JTable jTableDatos = null;
	private ArrayList<EvolucionTrasplanteTotal> lista = new ArrayList<EvolucionTrasplanteTotal>();
	private JButton jButtonTratamientos = null;
	private boolean inicio = true;
	/**
	 * This is the default constructor
	 */
	public IUEvolucionTrasplanteSeleccionar(Trasplante t, int the) {
		super();
		initialize();
		Fachada.getInstancia().agregarObservador(this);
		this.t = t;
		this.the = the;
		cargarDatos();
		this.inicio = false;
	}

	private void cargarDatos(){
		EvolucionTrasplanteTotal aux = new EvolucionTrasplanteTotal();
		aux.setIdTrasplante(this.t.getId());
		this.lista = aux.obtenerEvoluciones();
		ModeloDatosListaEvoluciones md = new ModeloDatosListaEvoluciones(this.lista);
		TableSorter sortPacientes = new TableSorter(md);
		this.jTableDatos.setModel(sortPacientes);
		sortPacientes.addMouseListenerToHeaderInTable(this.getJTableDatos());
		if(inicio){
			cargarComplicaciones();
		}
	}
	
	private void cargarComplicaciones(){
		this.getJButtonComplicaciones().setText("Complicaciones Infecciosas = " + Fachada.getInstancia().obtenerCantidadComplicacionesInfecciosasEvolucion(this.t.getPreTrasplante()));
		this.getJButtonComplicacionesNInf().setText("Complicaciones No Infecciosas = "+Fachada.getInstancia().obtenerCantidadComplicacionesNoInfecciosasEvolucion(this.t.getPreTrasplante()));

	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(1059, 354);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Seleccionar Evolucion");
		this.setLocationByPlatform(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 204));
			jContentPane.add(getJButtonSalir(), null);
			jContentPane.add(getJButtonAgregar(), null);
			jContentPane.add(getJButtonModificar(), null);
			jContentPane.add(getJButtonComplicaciones(), null);
			jContentPane.add(getJButtonComplicacionesNInf(), null);
			jContentPane.add(getJScrollPaneDatos(), null);
			jContentPane.add(getJButtonTratamientos(), null);
		}
		return jContentPane;
	}

	public void update(Observable arg0, Object arg1) {
		Observable o = arg0;
		if(o==instancia){
			if(Fachada.getInstancia().getLugar() == Fachada.EVOLUCION_SIMPLE 
					|| Fachada.getInstancia().getLugar() == Fachada.EVOLUCION_CMV
					|| Fachada.getInstancia().getLugar() == Fachada.EVOLUCION_ECG
					|| Fachada.getInstancia().getLugar() == Fachada.EVOLUCION_MARVIRALES
					|| Fachada.getInstancia().getLugar() == Fachada.EVOLUCION_ECOCARDIO
					|| Fachada.getInstancia().getLugar() == Fachada.EVOLUCION_TXTORAX
					|| Fachada.getInstancia().getLugar() == Fachada.EVOLUCION_NUTRICION
					|| Fachada.getInstancia().getLugar() == Fachada.EVOLUCION_TRASPLANTE_EXAMENES){
				this.cargarDatos();
			}
			
			if(Fachada.getInstancia().getLugar() == Fachada.COMPLICACIONES_INFECCIOSAS 
					|| Fachada.getInstancia().getLugar() == Fachada.COMPLICACIONES_NO_INFECCIOSAS){
				this.cargarComplicaciones();
			}
		}
	}

	public void salir(){
		Fachada.getInstancia().eliminarObservador(this);
		this.dispose();
	}

	/**
	 * This method initializes jButtonSalir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSalir() {
		if (jButtonSalir == null) {
			jButtonSalir = new JButton();
			jButtonSalir.setBounds(new Rectangle(892, 263, 129, 38));
			jButtonSalir.setText("Atras");
			jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salir();
				}
			});
		}
		return jButtonSalir;
	}

	/**
	 * This method initializes jButtonAgregar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAgregar() {
		if (jButtonAgregar == null) {
			jButtonAgregar = new JButton();
			jButtonAgregar.setBounds(new Rectangle(892, 44, 129, 38));
			jButtonAgregar.setText("Agregar");
			jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					agregar();
				}
			});
		}
		return jButtonAgregar;
	}

	/**
	 * This method initializes jButtonModificar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonModificar() {
		if (jButtonModificar == null) {
			jButtonModificar = new JButton();
			jButtonModificar.setBounds(new Rectangle(892, 113, 129, 38));
			jButtonModificar.setText("Manejar");
			jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					modificar();
				}
			});
		}
		return jButtonModificar;
	}

	private void modificar(){
		int fila  = this.jTableDatos.getSelectedRow();
		if(fila<0) return;
		EvolucionTrasplanteTotal seleccion = this.lista.get(fila);
		if(seleccion != null){
			IUEvolucionTrasplanteElegirTipo elegirInsertar = new IUEvolucionTrasplanteElegirTipo(this.t,seleccion,false);
			elegirInsertar.setVisible(true);
		}
	}
	private void agregar(){
		IUEvolucionTrasplanteElegirTipo elegirInsertar = new IUEvolucionTrasplanteElegirTipo(this.t);
		elegirInsertar.setVisible(true);
	}

	/**
	 * This method initializes jButtonComplicaciones	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonComplicaciones() {
		if (jButtonComplicaciones == null) {
			jButtonComplicaciones = new JButton();
			jButtonComplicaciones.setBounds(new Rectangle(6, 265, 224, 38));
			jButtonComplicaciones.setText("");
			jButtonComplicaciones.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					complicacionesInf();
				}
			});
		}
		return jButtonComplicaciones;
	}
	
	private void complicacionesInf(){
		IUComplicacionesInfSeleccionar auxInf = new IUComplicacionesInfSeleccionar(this.t,false);
		auxInf.setVisible(true);
	}

	/**
	 * This method initializes jButtonComplicacionesNInf	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonComplicacionesNInf() {
		if (jButtonComplicacionesNInf == null) {
			jButtonComplicacionesNInf = new JButton();
			jButtonComplicacionesNInf.setBounds(new Rectangle(254, 266, 235, 38));
			jButtonComplicacionesNInf.setText("");
			jButtonComplicacionesNInf
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							complicacionesNoInf();
						}
					});
		}
		return jButtonComplicacionesNInf;
	}
	
	private void complicacionesNoInf(){
		IUComplicacionesNoInfSeleccionar compNInf = new IUComplicacionesNoInfSeleccionar(this.t,false);
		compNInf.setVisible(true);
	}

	/**
	 * This method initializes jScrollPaneDatos	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneDatos() {
		if (jScrollPaneDatos == null) {
			jScrollPaneDatos = new JScrollPane();
			jScrollPaneDatos.setBounds(new Rectangle(9, 22, 861, 215));
			jScrollPaneDatos.setViewportView(getJTableDatos());
		}
		return jScrollPaneDatos;
	}

	/**
	 * This method initializes jTableDatos	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableDatos() {
		if (jTableDatos == null) {
			jTableDatos = new JTable();
		}
		return jTableDatos;
	}

	/**
	 * This method initializes jButtonTratamientos	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonTratamientos() {
		if (jButtonTratamientos == null) {
			jButtonTratamientos = new JButton();
			jButtonTratamientos.setBounds(new Rectangle(607, 263, 190, 38));
			jButtonTratamientos.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					tratamientos();
				}
			});
			jButtonTratamientos.setText("Tratamientos");
		}
		return jButtonTratamientos;
	}
	
	private void tratamientos(){
		IUTratamientoSeleccionar tratSel = new IUTratamientoSeleccionar(this.the);
		tratSel.setVisible(true);
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
