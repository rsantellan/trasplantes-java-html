package uy.transplante.iu.consultas;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JButton;

import logica.Fachada;

import uy.transplante.auxiliares.consultas.AModeloDatosConsultaGenerico;
import uy.transplante.auxiliares.tablas.TableSorter;
import uy.transplante.dominio.Generico;


public class IUConsultaComplicacionesPorTiempoSeparadas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelComplicacionesInfecciosas = null;
	private JDesktopPane jDesktopPaneComplicacionesInfecciosas = null;
	private JScrollPane jScrollPaneComplicacionesInfecciosas = null;
	private JTable jTableComplicacionesInfecciosas = null;
	private JTabbedPane jTabbedPaneComplicaciones = null;
	private JDesktopPane jDesktopPaneComplicacionesNoInfecciosas = null;
	private JLabel jLabelComplicacionesNoInfecciosas = null;
	private JScrollPane jScrollPaneComplicacionesNoInfecciosas = null;
	private JTable jTableComplicacionesNoInfecciosas = null;
	private JButton jButtonGraficaNoInfecciosas = null;
	private JButton jButtonSalir = null;
	private JButton jButtonGraficaInfecciosas = null;
	private Generico usadoNoInfeccioso = null;
	private Generico usadoInfeccioso = null;
	private int desde = 0;
	private int hasta = 1;
	private int tipo = 1;
	/**
	 * This is the default constructor
	 */
	public IUConsultaComplicacionesPorTiempoSeparadas(int desde, int hasta, int tipo) {
		super();
		this.desde = desde;
		this.hasta = hasta;
		this.tipo = tipo;
		initialize();
		cargarDatos();
	}

	private void cargarDatos(){
		this.usadoInfeccioso = new Generico();
		this.usadoInfeccioso = Fachada.getInstancia().consultaPacientesComplicacionesInfecciosasEntreFechas(desde, hasta, tipo);
		AModeloDatosConsultaGenerico md = new AModeloDatosConsultaGenerico(this.usadoInfeccioso);
		TableSorter sorter = new TableSorter(md);
		this.getJTableComplicacionesInfecciosas().setModel(sorter);
		
		this.usadoNoInfeccioso = new Generico();
		this.usadoNoInfeccioso = Fachada.getInstancia().consultaPacientesComplicacionesNoInfecciosasEntreFechas(desde, hasta, tipo);
		AModeloDatosConsultaGenerico md1 = new AModeloDatosConsultaGenerico(this.usadoNoInfeccioso);
		TableSorter sorter1 = new TableSorter(md1);
		this.getJTableComplicacionesNoInfecciosas().setModel(sorter1);
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(1035, 622);
		this.setContentPane(getJContentPane());
		this.setTitle("Complicaciones separadas");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelComplicacionesInfecciosas = new JLabel();
			jLabelComplicacionesInfecciosas.setText("Complicaciones Infecciosas");
			jLabelComplicacionesInfecciosas.setBounds(new Rectangle(16, 7, 227, 34));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 204));
			jContentPane.add(getJTabbedPaneComplicaciones(), null);
			jContentPane.add(getJButtonSalir(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jDesktopPaneComplicacionesInfecciosas	
	 * 	
	 * @return javax.swing.JDesktopPane	
	 */
	private JDesktopPane getJDesktopPaneComplicacionesInfecciosas() {
		if (jDesktopPaneComplicacionesInfecciosas == null) {
			jDesktopPaneComplicacionesInfecciosas = new JDesktopPane();
			jDesktopPaneComplicacionesInfecciosas.add(jLabelComplicacionesInfecciosas, null);
			jDesktopPaneComplicacionesInfecciosas.add(getJScrollPaneComplicacionesInfecciosas(), null);
			jDesktopPaneComplicacionesInfecciosas.add(getJButtonGraficaInfecciosas(), null);
		}
		return jDesktopPaneComplicacionesInfecciosas;
	}

	/**
	 * This method initializes jScrollPaneComplicacionesInfecciosas	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneComplicacionesInfecciosas() {
		if (jScrollPaneComplicacionesInfecciosas == null) {
			jScrollPaneComplicacionesInfecciosas = new JScrollPane();
			jScrollPaneComplicacionesInfecciosas.setBounds(new Rectangle(5, 46, 974, 390));
			jScrollPaneComplicacionesInfecciosas.setViewportView(getJTableComplicacionesInfecciosas());
		}
		return jScrollPaneComplicacionesInfecciosas;
	}

	/**
	 * This method initializes jTableComplicacionesInfecciosas	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableComplicacionesInfecciosas() {
		if (jTableComplicacionesInfecciosas == null) {
			jTableComplicacionesInfecciosas = new JTable();
		}
		return jTableComplicacionesInfecciosas;
	}

	/**
	 * This method initializes jTabbedPaneComplicaciones	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPaneComplicaciones() {
		if (jTabbedPaneComplicaciones == null) {
			jTabbedPaneComplicaciones = new JTabbedPane();
			jTabbedPaneComplicaciones.setBounds(new Rectangle(4, 0, 1012, 528));
			jTabbedPaneComplicaciones.addTab("Complicaciones Infecciosas", null, getJDesktopPaneComplicacionesInfecciosas(), null);
			jTabbedPaneComplicaciones.addTab("Complicaciones No Infecciosas", null, getJDesktopPaneComplicacionesNoInfecciosas(), null);
		}
		return jTabbedPaneComplicaciones;
	}

	/**
	 * This method initializes jDesktopPaneComplicacionesNoInfecciosas	
	 * 	
	 * @return javax.swing.JDesktopPane	
	 */
	private JDesktopPane getJDesktopPaneComplicacionesNoInfecciosas() {
		if (jDesktopPaneComplicacionesNoInfecciosas == null) {
			jLabelComplicacionesNoInfecciosas = new JLabel();
			jLabelComplicacionesNoInfecciosas.setBounds(new Rectangle(16, 7, 227, 34));
			jLabelComplicacionesNoInfecciosas.setText("Complicaciones No Infecciosas");
			jDesktopPaneComplicacionesNoInfecciosas = new JDesktopPane();
			jDesktopPaneComplicacionesNoInfecciosas.add(jLabelComplicacionesNoInfecciosas, null);
			jDesktopPaneComplicacionesNoInfecciosas.add(getJScrollPaneComplicacionesNoInfecciosas(), null);
			jDesktopPaneComplicacionesNoInfecciosas.add(getJButtonGraficaNoInfecciosas(), null);
		}
		return jDesktopPaneComplicacionesNoInfecciosas;
	}

	/**
	 * This method initializes jScrollPaneComplicacionesNoInfecciosas	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneComplicacionesNoInfecciosas() {
		if (jScrollPaneComplicacionesNoInfecciosas == null) {
			jScrollPaneComplicacionesNoInfecciosas = new JScrollPane();
			jScrollPaneComplicacionesNoInfecciosas.setBounds(new Rectangle(5, 46, 974, 405));
			jScrollPaneComplicacionesNoInfecciosas.setViewportView(getJTableComplicacionesNoInfecciosas());
		}
		return jScrollPaneComplicacionesNoInfecciosas;
	}

	/**
	 * This method initializes jTableComplicacionesNoInfecciosas	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableComplicacionesNoInfecciosas() {
		if (jTableComplicacionesNoInfecciosas == null) {
			jTableComplicacionesNoInfecciosas = new JTable();
		}
		return jTableComplicacionesNoInfecciosas;
	}

	/**
	 * This method initializes jButtonGraficaNoInfecciosas	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonGraficaNoInfecciosas() {
		if (jButtonGraficaNoInfecciosas == null) {
			jButtonGraficaNoInfecciosas = new JButton();
			jButtonGraficaNoInfecciosas.setBounds(new Rectangle(387, 456, 243, 38));
			jButtonGraficaNoInfecciosas.setText("Ver grafica");
			jButtonGraficaNoInfecciosas
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							verGraficaNoInfecciosa();
						}
					});
		}
		return jButtonGraficaNoInfecciosas;
	}

	/**
	 * This method initializes jButtonSalir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSalir() {
		if (jButtonSalir == null) {
			jButtonSalir = new JButton();
			jButtonSalir.setBounds(new Rectangle(416, 545, 195, 35));
			jButtonSalir.setText("Salir");
			jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salir();
				}
			});
		}
		return jButtonSalir;
	}

	/**
	 * This method initializes jButtonGraficaInfecciosas	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonGraficaInfecciosas() {
		if (jButtonGraficaInfecciosas == null) {
			jButtonGraficaInfecciosas = new JButton();
			jButtonGraficaInfecciosas.setBounds(new Rectangle(401, 450, 238, 39));
			jButtonGraficaInfecciosas.setText("Ver grafica");
			jButtonGraficaInfecciosas
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							verGraficaInfecciosa();
						}
					});
		}
		return jButtonGraficaInfecciosas;
	}

	private void verGraficaNoInfecciosa(){
		int fila = this.getJTableComplicacionesNoInfecciosas().getSelectedColumn();
		if(fila<0)return;
		ArrayList<Object> aux = new ArrayList<Object>();
		for(int x=0;x<this.getJTableComplicacionesNoInfecciosas().getRowCount();x++){
			
			int pos = x * this.getJTableComplicacionesNoInfecciosas().getColumnCount();
			aux.add(this.usadoNoInfeccioso.getListaObtenida().get(pos + fila));
			
		}
		IUConsultaGraficaPastel pastel = new IUConsultaGraficaPastel(aux);
		pastel.setVisible(true);
	}
	
	private void verGraficaInfecciosa(){
		int fila = this.getJTableComplicacionesInfecciosas().getSelectedColumn();
		if(fila<0)return;
		ArrayList<Object> aux = new ArrayList<Object>();
		for(int x=0;x<this.getJTableComplicacionesInfecciosas().getRowCount();x++){
			
			int pos = x * this.getJTableComplicacionesInfecciosas().getColumnCount();
			aux.add(this.usadoInfeccioso.getListaObtenida().get(pos + fila));
			
		}
		IUConsultaGraficaPastel pastel = new IUConsultaGraficaPastel(aux);
		pastel.setVisible(true);
	}
	
	private void salir(){
		this.dispose();
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
