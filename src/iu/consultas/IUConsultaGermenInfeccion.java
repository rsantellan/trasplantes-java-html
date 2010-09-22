package iu.consultas;

import uy.transplante.auxiliares.consultas.AModeloDatosConsultaGenerico;
import uy.transplante.auxiliares.impresion.PrintUtilities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import logica.Fachada;
import uy.transplante.auxiliares.tablas.TableSorter;
import dominio.FechaControl;
import dominio.Generico;
import dominio.Germenes;
import dominio.Infeccion;
import javax.swing.JDesktopPane;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;


public class IUConsultaGermenInfeccion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelSeleccione = null;
	private JLabel jLabelGermen = null;
	private JComboBox jComboBoxGermenes = null;
	private JButton jButtonBuscarGermen = null;
	private JLabel jLabelInfeccion = null;
	private JComboBox jComboBoxInfeccion = null;
	private JButton jButtonBuscarInfeccion = null;
	private JScrollPane jScrollPaneConsulta = null;
	private JTable jTableConsulta = null;
	private ArrayList<Germenes> listaGermenes;
	private ArrayList<Infeccion> listaInfecciones;
	private ArrayList<FechaControl> listaFechas;
	private JButton jButtonAtras = null;
	private JDesktopPane jDesktopPaneFecha = null;
	private JCheckBox jCheckBoxUsarFecha = null;
	private JComboBox jComboBoxFechas = null;
	private JLabel jLabelFechas = null;
	private JLabel jLabelCriterio = null;
	private JButton jButtonImprimir = null;
	private JLabel jLabelCantidadRegistros = null;
	/**
	 * This is the default constructor
	 */
	public IUConsultaGermenInfeccion() {
		super();
		initialize();
		cargarDatos();
	}

	private void cargarDatos() {
		this.listaGermenes = Fachada.getInstancia().obtenerTodosGermenes();
		for (int x = 0; x < listaGermenes.size(); x++) {
			this.jComboBoxGermenes.addItem(listaGermenes.get(x));
		}
		this.listaInfecciones = Fachada.getInstancia()
				.obtenerTodasInfecciones();
		for (int x = 0; x < listaInfecciones.size(); x++) {
			this.jComboBoxInfeccion.addItem(listaInfecciones.get(x));
		}
		this.listaFechas = Fachada.getInstancia().obtenerTodasFechasControl();
		for (int x = 0; x < listaFechas.size(); x++) {
			this.jComboBoxFechas.addItem(listaFechas.get(x));
		}

	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(1149, 647);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Consulta por germen e infeccion.");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelCantidadRegistros = new JLabel();
			jLabelCantidadRegistros.setBounds(new Rectangle(856, 560, 244, 41));
			jLabelCantidadRegistros.setText("");
			jLabelInfeccion = new JLabel();
			jLabelInfeccion.setBounds(new Rectangle(540, 216, 155, 36));
			jLabelInfeccion.setFont(new Font("Arial Narrow", Font.BOLD, 24));
			jLabelInfeccion.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelInfeccion.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelInfeccion.setText("Infeccion :");
			jLabelInfeccion.setBackground(new Color(204, 255, 204));
			jLabelGermen = new JLabel();
			jLabelGermen.setBounds(new Rectangle(20, 218, 114, 36));
			jLabelGermen.setFont(new Font("Arial Narrow", Font.BOLD, 24));
			jLabelGermen.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelGermen.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelGermen.setText("Germen:");
			jLabelGermen.setBackground(new Color(204, 255, 204));
			jLabelSeleccione = new JLabel();
			jLabelSeleccione.setBounds(new Rectangle(27, 14, 861, 30));
			jLabelSeleccione.setBackground(new Color(204, 255, 204));
			jLabelSeleccione.setFont(new Font("Arial Narrow", Font.BOLD, 24));
			jLabelSeleccione.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelSeleccione.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelSeleccione
					.setText("Seleccione el germen o la infeccion y presione buscar.");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabelSeleccione, null);
			jContentPane.add(jLabelGermen, null);
			jContentPane.add(getJComboBoxGermenes(), null);
			jContentPane.add(getJButtonBuscarGermen(), null);
			jContentPane.add(jLabelInfeccion, null);
			jContentPane.add(getJComboBoxInfeccion(), null);
			jContentPane.add(getJButtonBuscarInfeccion(), null);
			jContentPane.add(getJScrollPaneConsulta(), null);
			jContentPane.add(getJButtonAtras(), null);
			jContentPane.add(getJDesktopPaneFecha(), null);
			jContentPane.add(getJButtonImprimir(), null);
			jContentPane.add(jLabelCantidadRegistros, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jComboBoxGermenes
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxGermenes() {
		if (jComboBoxGermenes == null) {
			jComboBoxGermenes = new JComboBox();
			jComboBoxGermenes.setBounds(new Rectangle(142, 219, 222, 35));
		}
		return jComboBoxGermenes;
	}

	/**
	 * This method initializes jButtonBuscarGermen
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonBuscarGermen() {
		if (jButtonBuscarGermen == null) {
			jButtonBuscarGermen = new JButton();
			jButtonBuscarGermen.setBounds(new Rectangle(384, 216, 123, 38));
			jButtonBuscarGermen.setText("Buscar");
			jButtonBuscarGermen
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							buscarGermen();
						}
					});
		}
		return jButtonBuscarGermen;
	}

	/**
	 * This method initializes jComboBoxInfeccion
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxInfeccion() {
		if (jComboBoxInfeccion == null) {
			jComboBoxInfeccion = new JComboBox();
			jComboBoxInfeccion.setBounds(new Rectangle(710, 215, 278, 36));
		}
		return jComboBoxInfeccion;
	}

	/**
	 * This method initializes jButtonBuscarInfeccion
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonBuscarInfeccion() {
		if (jButtonBuscarInfeccion == null) {
			jButtonBuscarInfeccion = new JButton();
			jButtonBuscarInfeccion.setBounds(new Rectangle(1000, 213, 121, 37));
			jButtonBuscarInfeccion
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							buscarInfeccion();
						}
					});
			jButtonBuscarInfeccion.setText("Buscar");
		}
		return jButtonBuscarInfeccion;
	}

	/**
	 * This method initializes jScrollPaneConsulta
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneConsulta() {
		if (jScrollPaneConsulta == null) {
			jScrollPaneConsulta = new JScrollPane();
			jScrollPaneConsulta.setBounds(new Rectangle(26, 266, 1100, 275));
			jScrollPaneConsulta.setViewportView(getJTableConsulta());
		}
		return jScrollPaneConsulta;
	}

	/**
	 * This method initializes jTableConsulta
	 * 
	 * @return javax.swing.JTable
	 */
	private JTable getJTableConsulta() {
		if (jTableConsulta == null) {
			jTableConsulta = new JTable();
			jTableConsulta.setRowHeight(24);
		}
		return jTableConsulta;
	}

	private void buscarGermen() {
		int k = this.jComboBoxFechas.getSelectedIndex();
		if(k != 0){
			k = k -1;
		}
		//FechaControl inicio = (FechaControl) this.jComboBoxFechas.getItemAt(k);
		FechaControl f = (FechaControl) this.jComboBoxFechas.getSelectedItem();
		if(!this.jCheckBoxUsarFecha.isSelected()) f=null;
		Generico g = new Generico();
		Germenes germen = (Germenes) this.jComboBoxGermenes.getSelectedItem();
		g = Fachada.getInstancia().consultaTrasplantesGermenesInfecciones(germen.getId(),0,false,f);
		AModeloDatosConsultaGenerico md = new AModeloDatosConsultaGenerico(g);
		TableSorter sortPacientes = new TableSorter(md);
		this.jTableConsulta.setModel(sortPacientes);
		sortPacientes.addMouseListenerToHeaderInTable(this.getJTableConsulta());
		this.jLabelCantidadRegistros.setText("Cantidad de pacientes : " + this.getJTableConsulta().getRowCount());
	}

	private void buscarInfeccion() {
		int k = this.jComboBoxFechas.getSelectedIndex();
		if(k != 0){
			k = k -1;
		}
		//FechaControl inicio = (FechaControl) this.jComboBoxFechas.getItemAt(k);
		FechaControl f = (FechaControl) this.jComboBoxFechas.getSelectedItem();
		if(!this.jCheckBoxUsarFecha.isSelected()) f=null;
		Infeccion i = (Infeccion) this.jComboBoxInfeccion.getSelectedItem();
		Generico g = new Generico();
		g = Fachada.getInstancia().consultaTrasplantesGermenesInfecciones(0,i.getId(),false,f);
		AModeloDatosConsultaGenerico md = new AModeloDatosConsultaGenerico(g);
		TableSorter sortPacientes = new TableSorter(md);
		this.jTableConsulta.setModel(sortPacientes);
		sortPacientes.addMouseListenerToHeaderInTable(this.getJTableConsulta());
		this.jLabelCantidadRegistros.setText("Cantidad de pacientes : " + this.getJTableConsulta().getRowCount());
	}

	/**
	 * This method initializes jButtonAtras
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAtras() {
		if (jButtonAtras == null) {
			jButtonAtras = new JButton();
			jButtonAtras.setBounds(new Rectangle(513, 561, 150, 40));
			jButtonAtras.setText("Atras");
			jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salir();
				}
			});
		}
		return jButtonAtras;
	}

	private void salir() {
		this.dispose();
	}

	/**
	 * This method initializes jDesktopPaneFecha
	 * 
	 * @return javax.swing.JDesktopPane
	 */
	private JDesktopPane getJDesktopPaneFecha() {
		if (jDesktopPaneFecha == null) {
			jLabelCriterio = new JLabel();
			jLabelCriterio.setBounds(new Rectangle(174, 58, 560, 26));
			jLabelCriterio
					.setText("Al usarse una fecha, se pondra como fecha inferior la anterior.");
			jLabelFechas = new JLabel();
			jLabelFechas.setBounds(new Rectangle(220, 10, 155, 28));
			jLabelFechas.setText("Fechas :");
			jDesktopPaneFecha = new JDesktopPane();
			jDesktopPaneFecha.setBounds(new Rectangle(139, 60, 844, 104));
			jDesktopPaneFecha.add(getJCheckBoxUsarFecha(), null);
			jDesktopPaneFecha.add(getJComboBoxFechas(), null);
			jDesktopPaneFecha.add(jLabelFechas, null);
			jDesktopPaneFecha.add(jLabelCriterio, null);
		}
		return jDesktopPaneFecha;
	}

	/**
	 * This method initializes jCheckBoxUsarFecha
	 * 
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxUsarFecha() {
		if (jCheckBoxUsarFecha == null) {
			jCheckBoxUsarFecha = new JCheckBox();
			jCheckBoxUsarFecha.setBounds(new Rectangle(34, 11, 171, 19));
			jCheckBoxUsarFecha.setText("Usar Control de fecha");
		}
		return jCheckBoxUsarFecha;
	}

	/**
	 * This method initializes jComboBoxFechas
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxFechas() {
		if (jComboBoxFechas == null) {
			jComboBoxFechas = new JComboBox();
			jComboBoxFechas.setBounds(new Rectangle(385, 9, 410, 27));
		}
		return jComboBoxFechas;
	}

	/**
	 * This method initializes jButtonImprimir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonImprimir() {
		if (jButtonImprimir == null) {
			jButtonImprimir = new JButton();
			jButtonImprimir.setBounds(new Rectangle(29, 559, 90, 38));
			jButtonImprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/impresora.gif")));
			//jButtonImprimir.setText("Imprimir");
			jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Imprimir();
				}
			});
		}
		return jButtonImprimir;
	}
	
	private void Imprimir(){
		PrintUtilities impresora = new PrintUtilities(this.jScrollPaneConsulta);
		impresora.print();
	}
} // @jve:decl-index=0:visual-constraint="10,10"
