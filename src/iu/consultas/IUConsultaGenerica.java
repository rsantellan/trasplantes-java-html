package iu.consultas;

import uy.transplante.auxiliares.impresion.PrintUtilities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import javax.swing.ImageIcon;
import javax.swing.table.TableColumn;

import logica.Fachada;


import uy.transplante.auxiliares.consultas.AModeloDatosConsultaGenerico;
import uy.transplante.auxiliares.fechas.ManejoFechas;
import uy.transplante.auxiliares.tablas.TableSorter;
import uy.transplante.dominio.Generico;
import uy.transplante.dominio.Induccion;
import uy.transplante.dominio.Inmunosupresores;


public class IUConsultaGenerica extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelSeleccione = null;
	private JScrollPane jScrollPaneConsulta = null;
	private JTable jTableConsulta = null;
	private JButton jButtonAtras = null;
	private JButton jButtonImprimir = null;
	private int id =0;
	private JLabel jLabelCantidadRegistros = null;
	private Generico usado = null;
	private JButton jButtonPastel = null;
	/**
	 * This is the default constructor
	 */
	public IUConsultaGenerica() {
		super();
		initialize();
		cargarGenerico();
		cargarDatos();
	}

	public IUConsultaGenerica(int id) {
		super();
		this.id = id;
		initialize();
		cargarGenerico();
		cargarDatos();
	}
	
	public IUConsultaGenerica(Generico g) {
		super();
		initialize();
		this.usado = g;
		cargarDatos();
	}
	private void cargarDatos(){
		AModeloDatosConsultaGenerico md = new AModeloDatosConsultaGenerico(this.usado);
		TableSorter sorter = new TableSorter(md);
		this.getJTableConsulta().setModel(sorter);
		sorter.addMouseListenerToHeaderInTable(this.getJTableConsulta());
		int i = this.jTableConsulta.getColumnCount();
		TableColumn column = null;
		for(int k=0;k<i;k++){
			  column = this.jTableConsulta.getColumnModel().getColumn(k);
			  if(k == 14){
				  column.setPreferredWidth(200);
			  }else{
				  column.setPreferredWidth(100);
			  }
		}
		Calendar c = new GregorianCalendar();
		this.jLabelCantidadRegistros.setText("Cantidad de pacientes : " + this.getJTableConsulta().getRowCount());
		c = new GregorianCalendar();
		System.out.println(ManejoFechas.FORMATOHORAS.format(c.getTime()));
	}
	
	private void cargarGenerico(){
		Calendar c = new GregorianCalendar();
		System.out.println(ManejoFechas.FORMATOHORAS.format(c.getTime()));
		Generico g = new Generico();
		switch (id) {
		case 0:
			g = Fachada.getInstancia().consultaPacientesTabaquismo();
			this.jLabelSeleccione.setText("PACIENTES CON TABAQUISMO");
			break;
		case 1:
			g = Fachada.getInstancia().consultaPacientesDislipemia();
			this.jLabelSeleccione.setText("PACIENTES CON DISLIPEMIA");
			break;
		case 2:
			g = Fachada.getInstancia().consultaIMCPacientesConObesidad();
			this.jLabelSeleccione.setText("IMC DE PACIENTES CON OBESIDAD");
			break;
		case 3:
			g = Fachada.getInstancia().consultaIMCPacientesSinObesidad();
			this.jLabelSeleccione.setText("IMC DE PACIENTES SIN OBESIDAD");
			break;
		case 4:
			g = Fachada.getInstancia().consultaPacientesConHta();
			this.jLabelSeleccione.setText("PACIENTES CON HTA");
			break;
		case 5:
			g = Fachada.getInstancia().consultaPacientesConDiabetes();
			this.jLabelSeleccione.setText("PACIENTES CON DIABETES");
			break;
		case 6:
			g = Fachada.getInstancia().consultaPacientesPorSexo();
			this.jLabelSeleccione.setText("LISTA PACIENTES POR SEXO");
			break;
		case 7:
			g = Fachada.getInstancia().consultaPacientesPorOrigen();
			this.jLabelSeleccione.setText("LISTA PACIENTES POR ORIGEN");
			break;
		case 8:
			g = Fachada.getInstancia().consultaPacientesPorEdad();
			this.jLabelSeleccione.setText("LISTA PACIENTES POR EDAD AL TRASPLANTARSE");
			break;
		case 9:
			g = Fachada.getInstancia().consultaPacientesTiempoEnLista();
			this.jLabelSeleccione.setText("TIEMPO EN LISTA DE LOS PACIENTES");
			break;
		case 10:
			g = Fachada.getInstancia().consultaPacientesMuerte();
			this.jLabelSeleccione.setText("INFORMACION DE FALLECIMIENTO DE PACIENTES");
			break;
		case 11:
			g = Fachada.getInstancia().consultaPacientesNefropatiasPBR();
			this.jLabelSeleccione.setText("INFORMACION DE NEFROPATIAS PBR");
			break;
		case 12:
			g = Fachada.getInstancia().consultaTranfusionesEmbarazos();
			this.jLabelSeleccione.setText("TRANFUSIONES Y EMBARAZOS");
			break;
		case 13:
			g = Fachada.getInstancia().consultaTipoSangrePacienteDonante();
			this.jLabelSeleccione.setText("GRUPO SANGUINEO DONANTE Y PACIENTE");
			break;
		case 14:
			g = Fachada.getInstancia().consultaNumArteriasVenasYUreter();
			this.jLabelSeleccione.setText("N° ARTERIAS, VENAS Y URETER");
			break;
		case 15:
			g = Fachada.getInstancia().consultaLadoRinhonAnomalia();
			this.jLabelSeleccione.setText("LADO DEL RIÑON Y ANOMALIA VASCULAR");
			break;
		case 16:
			g = Fachada.getInstancia().consultaPacienteInastabilidadHemodinamica();
			this.jLabelSeleccione.setText("PACIENTES CON INESTABILIDAD HEMODIAL EN EL TRASPLANTE");
			break;
		case 17:
			g = Fachada.getInstancia().consultaPacienteEdadDonanteEdad();
			this.jLabelSeleccione.setText("EDAD DEL PACIENTE Y EL DONANTE AL MOMENTO DEL TRASPLANTE");
			break;
		case 18:
			g = Fachada.getInstancia().consultaSexoPacienteDonante();
			this.jLabelSeleccione.setText("SEXO DEL PACIENTE Y EL DONANTE");
			break;
		case 19:
			g = Fachada.getInstancia().consultaTipoDonantePaciente();
			this.jLabelSeleccione.setText("TIPO DE DONANTE Y RELACION FILIAR CON PACIENTE");
			break;
		case 20:
			g = Fachada.getInstancia().consultaPacienteVariosTrasplantes();
			this.jLabelSeleccione.setText("PACIENTE CON VARIOS TRASPLANTES");
			break;
		case 21:
			g = Fachada.getInstancia().consultaPacienteFechaTrasplantes();
			this.jLabelSeleccione.setText("FECHA DEL TRASPLANTES");
			break;
		case 22:
			g = Fachada.getInstancia().consultaTrasplantesCompatibilidadIncompatibilidadPRA();
			this.jLabelSeleccione.setText("COMPATIBILIDAD, INCOMPATIBILIDAD Y PRA");
			break;
		case 23:
			g = Fachada.getInstancia().consultaTrasplantesPorCirugia();
			this.jLabelSeleccione.setText("DATOS CIRURGICOS DEL TRASPLANTE");
			break;
		case 24:
			g = Fachada.getInstancia().consultaTrasplantesIsquemiaDiuresis(true);
			this.jLabelSeleccione.setText("ISQUEMIA CON DIURESIS EN BQ");
			break;
		case 25:
			g = Fachada.getInstancia().consultaTrasplantesIsquemiaDiuresis(false);
			this.jLabelSeleccione.setText("ISQUEMIA SIN DIURESIS EN BQ");
			break;
		case 26:
			ArrayList<Induccion> listaInducciones = Fachada.getInstancia().obtenerTodosLosInduccion();
			g = Fachada.getInstancia().consultaTrasplantesInduccion(listaInducciones);
			this.jLabelSeleccione.setText("INDUCCIONES INM");
			break;
		case 27:
			ArrayList<Inmunosupresores> listaInmunosupresores = Fachada.getInstancia().obtenerTodosLosInmunosupresores();
			g = Fachada.getInstancia().consultaTrasplantesInmunosupresor(listaInmunosupresores);
			this.jLabelSeleccione.setText("INMUNOSUPRESORES");
			break;
		case 28:
			g = Fachada.getInstancia().consultaTrasplantesDiuresisEnBQ();
			this.jLabelSeleccione.setText("DIURESIS EN BQ");
			break;
		case 29:
			g = Fachada.getInstancia().consultaTransplantesConSangradoIOpLesionArterialYVenalRepefundir();
			this.jLabelSeleccione.setText("Consulta de transplantes con sangrado I OP, lesion arterial y venal y necesidad de repefundir");
		default:
			this.salir();
			break;
		}
		
		this.usado = g;
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
		this.setTitle("Consulta");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelCantidadRegistros = new JLabel();
			jLabelCantidadRegistros.setBounds(new Rectangle(818, 559, 280, 38));
			jLabelCantidadRegistros.setText("");
			jLabelSeleccione = new JLabel();
			jLabelSeleccione.setBounds(new Rectangle(106, 13, 861, 30));
			jLabelSeleccione.setBackground(new Color(204, 255, 204));
			jLabelSeleccione.setFont(new Font("Arial Narrow", Font.BOLD, 24));
			jLabelSeleccione.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelSeleccione.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelSeleccione
					.setText("Consulta");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 204));
			jContentPane.add(jLabelSeleccione, null);
			jContentPane.add(getJScrollPaneConsulta(), null);
			jContentPane.add(getJButtonAtras(), null);
			jContentPane.add(getJButtonImprimir(), null);
			jContentPane.add(jLabelCantidadRegistros, null);
			jContentPane.add(getJButtonPastel(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPaneConsulta
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneConsulta() {
		if (jScrollPaneConsulta == null) {
			jScrollPaneConsulta = new JScrollPane();
			jScrollPaneConsulta.setBounds(new Rectangle(26, 67, 1100, 474));
			jScrollPaneConsulta.setViewportView(getJTableConsulta());
			jScrollPaneConsulta.setBackground(Color.WHITE);
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
			if(this.id == 23 || this.id == 28){
				jTableConsulta.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				jTableConsulta.setIntercellSpacing(new Dimension(10, 3)); 
			}
		}
		return jTableConsulta;
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
	 * This method initializes jButtonImprimir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonImprimir() {
		if (jButtonImprimir == null) {
			jButtonImprimir = new JButton();
			jButtonImprimir.setBounds(new Rectangle(29, 561, 90, 38));
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

	/**
	 * This method initializes jButtonPastel	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonPastel() {
		if (jButtonPastel == null) {
			jButtonPastel = new JButton();
			jButtonPastel.setBounds(new Rectangle(154, 561, 112, 40));
			jButtonPastel.setText("Ver grafica");
			jButtonPastel.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					grafica();
				}
			});
		}
		return jButtonPastel;
	}
	
	private void grafica(){
		int fila = this.getJTableConsulta().getSelectedColumn();
		if(fila<0)return;
		ArrayList<Object> aux = new ArrayList<Object>();
		for(int x=0;x<this.getJTableConsulta().getRowCount();x++){
			
			int pos = x * this.getJTableConsulta().getColumnCount();
			aux.add(this.usado.getListaObtenida().get(pos + fila));
			
		}
		IUConsultaGraficaPastel pastel = new IUConsultaGraficaPastel(aux);
		pastel.setVisible(true);
	}
} // @jve:decl-index=0:visual-constraint="10,10"
