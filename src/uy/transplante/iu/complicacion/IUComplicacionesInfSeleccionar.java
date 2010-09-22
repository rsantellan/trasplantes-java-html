package uy.transplante.iu.complicacion;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import uy.transplante.auxiliares.tablas.ModeloDatosListaComplicacionesInf;
import uy.transplante.auxiliares.tablas.TableSorter;
import uy.transplante.dominio.EvolucionTrasplanteTotal;
import uy.transplante.dominio.Trasplante;
import uy.transplante.dominio.TrasplanteComplicacionesInf;
import uy.transplante.logica.Fachada;

public class IUComplicacionesInfSeleccionar extends JFrame implements
		java.util.Observer {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPaneDatos = null;
	private JTable jTableDatos = null;
	private int the;
	private boolean esTrasplante;
	private ArrayList<TrasplanteComplicacionesInf> lista = new ArrayList<TrasplanteComplicacionesInf>();
	private Trasplante t;
	private JButton jButtonAgregar = null;
	private JButton jButtonModificar = null;
	private JButton jButtonVer = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonSalir = null;

	/**
	 * This is the default constructor
	 */
	public IUComplicacionesInfSeleccionar(Trasplante t, boolean esTrasplante) {
		super();
		this.t = t;
		this.the = t.getPreTrasplante();
		if (esTrasplante) {
			this.lista = t.getListaComplicacionesInf();
		} else {
			EvolucionTrasplanteTotal auxE = new EvolucionTrasplanteTotal();
			auxE.setIdPreTrasplante(t.getPreTrasplante());
			auxE.setIdTrasplante(t.getId());
			auxE.datosComplicacionesInf();
			this.lista = auxE.getListaComplicacionesInf();
		}
		this.esTrasplante = esTrasplante;
		initialize();
		Fachada.getInstancia().agregarObservador(this);
		cargarDatos();
	}

	private void cargarDatos() {
		ModeloDatosListaComplicacionesInf md = new ModeloDatosListaComplicacionesInf(
				lista);
		TableSorter sortPacientes = new TableSorter(md);
		this.jTableDatos.setModel(sortPacientes);
		sortPacientes.addMouseListenerToHeaderInTable(this.getJTableDatos());
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
		this.setTitle("Seleccion Complicaciones Infecciosas");
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
			jScrollPaneDatos.setBounds(new Rectangle(15, 15, 497, 249));
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
			jButtonAgregar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							agregar();
						}
					});
		}
		return jButtonAgregar;
	}

	private void agregar() {
		IUComplicacionesInfInsertar iuInsertar = new IUComplicacionesInfInsertar(
				this.the, this.esTrasplante);
		iuInsertar.setVisible(true);
	}

	public void update(Observable arg0, Object arg1) {
		Observable o = arg0;
		if (o == Fachada.getInstancia()) {
			if (Fachada.getInstancia().getLugar() == Fachada.COMPLICACIONES_INFECCIOSAS) {
				if (this.esTrasplante) {
					t.leerDatosMinimos();
					this.lista = t.getListaComplicacionesInf();
				} else {
					EvolucionTrasplanteTotal auxE = new EvolucionTrasplanteTotal();
					auxE.setIdPreTrasplante(t.getPreTrasplante());
					auxE.setIdTrasplante(t.getId());
					auxE.datosComplicacionesInf();
					this.lista = auxE.getListaComplicacionesInf();
				}
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
			jButtonModificar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							modificarComplicacion();
						}
					});
		}
		return jButtonModificar;
	}

	private void modificarComplicacion() {
		int fila = this.jTableDatos.getSelectedRow();
		if (fila < 0)
			return;
		TrasplanteComplicacionesInf t = this.lista.get(fila);
		if (t != null) {
			IUComplicacionesInfVerModificar iuModificar = new IUComplicacionesInfVerModificar(
					t, false);
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
			jButtonVer.setText("Ver");
			jButtonVer.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ver();
				}
			});
		}
		return jButtonVer;
	}

	private void ver() {
		int fila = this.jTableDatos.getSelectedRow();
		if (fila < 0)
			return;
		TrasplanteComplicacionesInf t = this.lista.get(fila);
		if (t != null) {
			IUComplicacionesInfVerModificar iuModificar = new IUComplicacionesInfVerModificar(
					t, true);
			iuModificar.setVisible(true);
		}
	}

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
			jButtonEliminar
					.addActionListener(new java.awt.event.ActionListener() {
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

	private void salir() {
		Fachada.getInstancia().eliminarObservador(this);
		this.dispose();
	}

	private void eliminar() {
		int fila = this.jTableDatos.getSelectedRow();
		if (fila < 0)
			return;
		TrasplanteComplicacionesInf t = this.lista.get(fila);
		if (t != null) {
			String respuesta = "";
			respuesta = JOptionPane
					.showInputDialog(
							this,
							"Está a punto de eliminar una complicacion infecciosa\n(Ingrese SI para eliminar) Confirmar: ",
							"Confirmar", 1);
			if (respuesta == null)
				respuesta = "No";
			if (respuesta.equalsIgnoreCase("Si")) {
				Fachada.getInstancia().eliminarComplicacionInf(t);
			}
		}
	}
} // @jve:decl-index=0:visual-constraint="10,10"
