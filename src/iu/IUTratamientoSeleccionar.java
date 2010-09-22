package iu;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import logica.Fachada;
import auxiliares.ModeloDatosListaTratamientos;
import auxiliares.TableSorter;
import uy.transplante.iu.observador.seleccionarfecha.IUCalendarChooser;
import dominio.Tratamiento;
import javax.swing.JRadioButton;
import java.awt.Color;

public class IUTratamientoSeleccionar extends JFrame implements java.util.Observer, uy.transplante.iu.observador.seleccionarfecha.ObservadorCalendario{

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPaneDatos = null;
	private JTable jTableDatos = null;
	private int the;
	private ArrayList<Tratamiento> lista = new ArrayList<Tratamiento>();
	private ArrayList<Tratamiento> listaActivos = new ArrayList<Tratamiento>();  //  @jve:decl-index=0:
	private ArrayList<Tratamiento> listaNoActivos = new ArrayList<Tratamiento>();
	private JButton jButtonAgregar = null;
	private JButton jButtonModificar = null;
	private JButton jButtonVer = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonSalir = null;
	private JScrollPane jScrollPaneDatosNoActivos = null;
	private JTable jTableDatosNoActivos = null;
	private JRadioButton jRadioButtonActivos = null;
	private JRadioButton jRadioButtonNoActivos = null;
	private IUCalendarChooser iuCalendar = null;
	/**
	 * This is the default constructor
	 */
	public IUTratamientoSeleccionar(int the) {
		super();
		this.the = the;
		initialize();
		Fachada.getInstancia().agregarObservador(this);
		this.jRadioButtonActivos.setSelected(true);
		this.jScrollPaneDatosNoActivos.setVisible(false);
		this.jTableDatosNoActivos.setVisible(false);
		cargarDatos();
	}

	private void cargarDatos(){
		this.lista = Fachada.getInstancia().obtenerTodosTratamientos(this.the);
		Calendar c = new GregorianCalendar();
		c.clear();
		c.set(1950, 1, 1);
		this.listaActivos.clear();
		this.listaNoActivos.clear();
		for(int x=0;x<lista.size();x++){
			Tratamiento t = lista.get(x);
			if(t.getFecha_fin().equals(c)){
				this.listaActivos.add(t);
			}else{
				this.listaNoActivos.add(t);
			}
		}
		ModeloDatosListaTratamientos md = new ModeloDatosListaTratamientos(listaActivos);
		TableSorter sortPacientes = new TableSorter(md);
		this.jTableDatos.setModel(sortPacientes);
		sortPacientes.addMouseListenerToHeaderInTable(this.getJTableDatos());
		ModeloDatosListaTratamientos md1 = new ModeloDatosListaTratamientos(this.listaNoActivos);
		TableSorter sortDatos = new TableSorter(md1);
		this.jTableDatosNoActivos.setModel(sortDatos);
		sortDatos.addMouseListenerToHeaderInTable(this.getJTableDatosNoActivos());
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(665, 415);
		this.setContentPane(getJContentPane());
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setTitle("Seleccion Tratamientos");
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
			jContentPane.add(getJScrollPaneDatos(), null);
			jContentPane.add(getJButtonAgregar(), null);
			jContentPane.add(getJButtonModificar(), null);
			jContentPane.add(getJButtonVer(), null);
			jContentPane.add(getJButtonEliminar(), null);
			jContentPane.add(getJButtonSalir(), null);
			jContentPane.add(getJScrollPaneDatosNoActivos(), null);
			jContentPane.add(getJRadioButtonActivos(), null);
			jContentPane.add(getJRadioButtonNoActivos(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPaneDatos	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneDatos() {
		if (jScrollPaneDatos == null) {
			jScrollPaneDatos = new JScrollPane();
			jScrollPaneDatos.setBounds(new Rectangle(16, 48, 497, 249));
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
	 * This method initializes jButtonAgregar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAgregar() {
		if (jButtonAgregar == null) {
			jButtonAgregar = new JButton();
			jButtonAgregar.setBounds(new Rectangle(526, 73, 110, 34));
			jButtonAgregar.setText("Agregar");
			jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					agregar();
				}
			});
		}
		return jButtonAgregar;
	}

	private void agregar(){
		IUTratamientoAgregar iuInsertar = new IUTratamientoAgregar(this.the);
		iuInsertar.setVisible(true);
	}


	public void update(Observable arg0, Object arg1) {
		Observable o = arg0;
		if(o==Fachada.getInstancia()){
			if(Fachada.getInstancia().getLugar() == Fachada.TRATAMIENTO){
				this.cargarDatos();
			}
		}
	}
	/**
	 * This method initializes jButtonModificar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonModificar() {
		if (jButtonModificar == null) {
			jButtonModificar = new JButton();
			jButtonModificar.setBounds(new Rectangle(525, 128, 113, 34));
			jButtonModificar.setText("Modificar");
			jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					modificarComplicacion();
				}
			});
		}
		return jButtonModificar;
	}
	
	private void modificarComplicacion(){
		Tratamiento t = null;
		if(this.jRadioButtonActivos.isSelected()){
			int fila  = this.jTableDatos.getSelectedRow();
			if(fila<0) return;
			t = this.listaActivos.get(fila);
		}else{
			int fila  = this.jTableDatosNoActivos.getSelectedRow();
			if(fila<0) return;
			t = this.listaNoActivos.get(fila);
		}
		if(t != null){
			IUTratamientoAgregar iuModificar = new IUTratamientoAgregar(t);
			iuModificar.setVisible(true);
		}
	}

	/**
	 * This method initializes jButtonVer	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonVer() {
		if (jButtonVer == null) {
			jButtonVer = new JButton();
			jButtonVer.setBounds(new Rectangle(197, 321, 128, 30));
			jButtonVer.setText("Terminar");
			jButtonVer.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ver();
				}
			});
		}
		return jButtonVer;
	}
	
	private void ver(){
		Tratamiento t = null;
		if(this.jRadioButtonActivos.isSelected()){
			int fila  = this.jTableDatos.getSelectedRow();
			if(fila<0) return;
			t = this.listaActivos.get(fila);
		}else{
			JOptionPane.showMessageDialog(this,"No puede terminar un tratamiento que ya fue terminado", "Error", JOptionPane.ERROR_MESSAGE);
		}
		if(t != null){
			String respuesta = "";
			respuesta = JOptionPane.showInputDialog(this, "Está a punto de terminar un tratamiento\n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
			if(respuesta==null)respuesta="No";
			if(respuesta.equalsIgnoreCase("Si")){
				this.iuCalendar = new IUCalendarChooser(this);
				this.iuCalendar.setVisible(true);
				this.tratamientoParaTerminar = t;
				this.setEnabled(false);
			}
		}
	}

	private Tratamiento tratamientoParaTerminar = null; 
	/**
	 * This method initializes jButtonEliminar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonEliminar() {
		if (jButtonEliminar == null) {
			jButtonEliminar = new JButton();
			jButtonEliminar.setBounds(new Rectangle(526, 179, 114, 32));
			jButtonEliminar.setText("Eliminar");
			jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					eliminar();
				}
			});
		}
		return jButtonEliminar;
	}

	/**
	 * This method initializes jButtonSalir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSalir() {
		if (jButtonSalir == null) {
			jButtonSalir = new JButton();
			jButtonSalir.setBounds(new Rectangle(523, 321, 112, 37));
			jButtonSalir.setText("Atras");
			jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salir();
				}
			});
		}
		return jButtonSalir;
	}
	private void salir(){
		Fachada.getInstancia().eliminarObservador(this);
		this.dispose();
	}
	
	private void eliminar(){
		Tratamiento t = null;
		if(this.jRadioButtonActivos.isSelected()){
			int fila  = this.jTableDatos.getSelectedRow();
			if(fila<0) return;
			t = this.listaActivos.get(fila);
		}else{
			int fila  = this.jTableDatosNoActivos.getSelectedRow();
			if(fila<0) return;
			t = this.listaNoActivos.get(fila);
		}
		if(t != null){
			String respuesta = "";
			respuesta = JOptionPane.showInputDialog(this, "Está a punto de eliminar un tratamiento\n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
			if(respuesta==null)respuesta="No";
			if(respuesta.equalsIgnoreCase("Si")){
				Fachada.getInstancia().eliminarTratamiento(t);
			}
		}
	}

	/**
	 * This method initializes jScrollPaneDatosNoActivos	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneDatosNoActivos() {
		if (jScrollPaneDatosNoActivos == null) {
			jScrollPaneDatosNoActivos = new JScrollPane();
			jScrollPaneDatosNoActivos.setBounds(new Rectangle(16, 48, 497, 249));
			jScrollPaneDatosNoActivos.setViewportView(getJTableDatosNoActivos());
		}
		return jScrollPaneDatosNoActivos;
	}

	/**
	 * This method initializes jTableDatosNoActivos	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableDatosNoActivos() {
		if (jTableDatosNoActivos == null) {
			jTableDatosNoActivos = new JTable();
		}
		return jTableDatosNoActivos;
	}

	/**
	 * This method initializes jRadioButtonActivos	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonActivos() {
		if (jRadioButtonActivos == null) {
			jRadioButtonActivos = new JRadioButton();
			jRadioButtonActivos.setBounds(new Rectangle(70, 12, 132, 27));
			jRadioButtonActivos.setBackground(new Color(255, 255, 204));
			jRadioButtonActivos.setText("Activos");
			jRadioButtonActivos.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					seleccionarActivos();
				}
			});
		}
		return jRadioButtonActivos;
	}

	/**
	 * This method initializes jRadioButtonNoActivos	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonNoActivos() {
		if (jRadioButtonNoActivos == null) {
			jRadioButtonNoActivos = new JRadioButton();
			jRadioButtonNoActivos.setBounds(new Rectangle(267, 9, 136, 32));
			jRadioButtonNoActivos.setBackground(new Color(255, 255, 204));
			jRadioButtonNoActivos.setText("No Activos");
			jRadioButtonNoActivos.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					seleccionarNoActivos();
				}
			});
		}
		return jRadioButtonNoActivos;
	}
	
	private void seleccionarActivos(){
		this.jScrollPaneDatos.setVisible(true);
		this.jTableDatos.setVisible(true);
		this.jScrollPaneDatosNoActivos.setVisible(false);
		this.jTableDatosNoActivos.setVisible(false);
		this.jRadioButtonNoActivos.setSelected(false);
	}
	
	private void seleccionarNoActivos(){
		this.jScrollPaneDatos.setVisible(false);
		this.jTableDatos.setVisible(false);
		this.jScrollPaneDatosNoActivos.setVisible(true);
		this.jTableDatosNoActivos.setVisible(true);
		this.jRadioButtonActivos.setSelected(false);
	}


	public void actualizar() {
		this.tratamientoParaTerminar.setFecha_fin(this.iuCalendar.obtenerFecha());
		Fachada.getInstancia().guardarTratamiento(this.tratamientoParaTerminar);
		this.tratamientoParaTerminar=null;
		this.iuCalendar.terminar();
		this.setEnabled(true);
		JOptionPane.showMessageDialog(this,"Tratamiento terminado", "Ok", JOptionPane.INFORMATION_MESSAGE);
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
