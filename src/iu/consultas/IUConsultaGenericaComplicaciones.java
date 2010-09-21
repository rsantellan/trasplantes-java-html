package iu.consultas;

import impresion.PrintUtilities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
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

import dominio.Generico;

import auxiliares.ManejoFechas;
import auxiliares.TableSorter;
import auxiliaresConsultas.AModeloDatosConsultaGenerico;


public class IUConsultaGenericaComplicaciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelSeleccione = null;
	private JScrollPane jScrollPaneConsulta = null;
	private JTable jTableConsulta = null;
	private JButton jButtonAtras = null;
	private JButton jButtonImprimir = null;
	private int id =0;
	private Generico usado = null;
	private JLabel jLabelCantidadRegistros = null;
	private JButton jButtonMasDatos = null;
	private int desde = 0;
	private int hasta = 1;
	private int tipo = 1;
	private JScrollPane jScrollPaneComplicacionesInf = null;
	private JTable jTableComplicacionesInf = null;
	private JScrollPane jScrollPaneComplicacionesNoInf = null;
	private JTable jTableComplicacionesNoInf = null;
	/**
	 * This is the default constructor
	 */
	public IUConsultaGenericaComplicaciones() {
		super();
		initialize();
		cargarDatos();
	}

	public IUConsultaGenericaComplicaciones(int desde, int hasta, int tipo) {
		super();
		this.desde = desde;
		this.hasta = hasta;
		this.tipo = tipo;
		initialize();
		cargarDatos();
	}
	
	private void cargarDatos(){
		Calendar c = new GregorianCalendar();
		System.out.println(ManejoFechas.FORMATOHORAS.format(c.getTime()));
		this.getJScrollPaneComplicacionesInf().setVisible(false);
		this.getJScrollPaneComplicacionesNoInf().setVisible(false);
		Generico g = new Generico();
		g = Fachada.getInstancia().consultaPacientesCantidadComplicaciones(this.desde, this.hasta, this.tipo);
		AModeloDatosConsultaGenerico md = new AModeloDatosConsultaGenerico(g);
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
		if(id == 0){
			Integer cantidad = 0;
			for(int x=0;x<this.getJTableConsulta().getRowCount();x++){
				int lugar = g.getListaNombre().size() * x;
				cantidad = cantidad + Integer.parseInt(g.getListaObtenida().get(lugar + 4).toString());
			}
			this.jLabelCantidadRegistros.setText("Cantidad de reoperaciones : " + String.valueOf(cantidad));
		}
		
		this.usado = g;
		c = new GregorianCalendar();
		System.out.println(ManejoFechas.FORMATOHORAS.format(c.getTime()));
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
			jContentPane.add(getJButtonMasDatos(), null);
			jContentPane.add(getJScrollPaneComplicacionesInf(), null);
			jContentPane.add(getJScrollPaneComplicacionesNoInf(), null);
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
			jButtonImprimir.setBounds(new Rectangle(29, 559, 90, 38));
			jButtonImprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/impresora.gif")));
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
	 * This method initializes jButtonMasDatos	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonMasDatos() {
		if (jButtonMasDatos == null) {
			jButtonMasDatos = new JButton();
			jButtonMasDatos.setBounds(new Rectangle(149, 559, 110, 38));
			jButtonMasDatos.setText("Mas Datos");
			jButtonMasDatos.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					masDatos();
				}
			});
		}
		return jButtonMasDatos;
	}
	
	
	private void masDatos(){
		int fila = this.getJTableConsulta().getSelectedRow();
		if(fila<0)return;
		int lugar = this.usado.getListaNombre().size() * fila;
		if(Integer.parseInt(this.usado.getListaObtenida().get(lugar + 4).toString()) > 0){
			System.out.println(lugar);
			System.out.println(this.usado.getListaObtenida().get(lugar).toString());
			Generico g = Fachada.getInstancia().consultaPacientesComplicacionesInfecciosasDetalles(this.desde, this.hasta, this.tipo, lugar);
			AModeloDatosConsultaGenerico md = new AModeloDatosConsultaGenerico(g);
			TableSorter sorter = new TableSorter(md);
			this.getJTableComplicacionesInf().setModel(sorter);
			sorter.addMouseListenerToHeaderInTable(this.getJTableComplicacionesInf());
			int i = this.jTableComplicacionesInf.getColumnCount();
			TableColumn column = null;
			for(int k=0;k<i;k++){
				  column = this.jTableComplicacionesInf.getColumnModel().getColumn(k);
				  if(k == 14){
					  column.setPreferredWidth(200);
				  }else{
					  column.setPreferredWidth(100);
				  }
			}
			
			Generico g1 = Fachada.getInstancia().consultaPacientesComplicacionesInfecciosasDetalles(this.desde, this.hasta, this.tipo, lugar);
			AModeloDatosConsultaGenerico md1 = new AModeloDatosConsultaGenerico(g1);
			TableSorter sorter1 = new TableSorter(md1);
			this.getJTableComplicacionesInf().setModel(sorter1);
			sorter.addMouseListenerToHeaderInTable(this.getJTableComplicacionesNoInf());
			int i1 = this.jTableComplicacionesNoInf.getColumnCount();
			TableColumn column1 = null;
			for(int k=0;k<i1;k++){
				  column1 = this.jTableComplicacionesNoInf.getColumnModel().getColumn(k);
				  if(k == 14){
					  column1.setPreferredWidth(200);
				  }else{
					  column1.setPreferredWidth(100);
				  }
			}
			
			this.getJScrollPaneComplicacionesInf().setVisible(true);
			this.getJScrollPaneComplicacionesNoInf().setVisible(true);
			this.getJScrollPaneConsulta().setVisible(false);
		}
		
	}

	/**
	 * This method initializes jScrollPaneComplicacionesInf	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneComplicacionesInf() {
		if (jScrollPaneComplicacionesInf == null) {
			jScrollPaneComplicacionesInf = new JScrollPane();
			jScrollPaneComplicacionesInf.setBounds(new Rectangle(8, 71, 1118, 202));
			jScrollPaneComplicacionesInf.setViewportView(getJTableComplicacionesInf());
		}
		return jScrollPaneComplicacionesInf;
	}

	/**
	 * This method initializes jTableComplicacionesInf	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableComplicacionesInf() {
		if (jTableComplicacionesInf == null) {
			jTableComplicacionesInf = new JTable();
		}
		return jTableComplicacionesInf;
	}

	/**
	 * This method initializes jScrollPaneComplicacionesNoInf	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneComplicacionesNoInf() {
		if (jScrollPaneComplicacionesNoInf == null) {
			jScrollPaneComplicacionesNoInf = new JScrollPane();
			jScrollPaneComplicacionesNoInf.setBounds(new Rectangle(6, 290, 1124, 227));
			jScrollPaneComplicacionesNoInf.setViewportView(getJTableComplicacionesNoInf());
		}
		return jScrollPaneComplicacionesNoInf;
	}

	/**
	 * This method initializes jTableComplicacionesNoInf	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableComplicacionesNoInf() {
		if (jTableComplicacionesNoInf == null) {
			jTableComplicacionesNoInf = new JTable();
		}
		return jTableComplicacionesNoInf;
	}
} // @jve:decl-index=0:visual-constraint="10,10"
