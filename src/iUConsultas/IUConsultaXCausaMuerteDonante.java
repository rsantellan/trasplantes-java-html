package iUConsultas;

import impresion.PrintUtilities;

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
import auxiliares.TableSorter;
import auxiliaresConsultas.AModeloDatosConsultaGenerico;

import dominio.CausaMuerteDonante;
import dominio.Generico;
import javax.swing.ImageIcon;

public class IUConsultaXCausaMuerteDonante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelSeleccione = null;
	private JLabel jLabelGermen = null;
	private JComboBox jComboBoxCausas = null;
	private JButton jButtonBuscar = null;
	private JScrollPane jScrollPaneConsulta = null;
	private JTable jTableConsulta = null;
	private ArrayList<CausaMuerteDonante> lista;  //  @jve:decl-index=0:
	private JButton jButtonAtras = null;
	private JButton jButtonImprimir = null;
	private JLabel jLabelCantidadRegistros = null;
	/**
	 * This is the default constructor
	 */
	public IUConsultaXCausaMuerteDonante() {
		super();
		initialize();
		cargarDatos();
	}
	
	private void cargarDatos(){
		this.lista = Fachada.getInstancia().obtenerTodasCausasMuerteDonante();
		for(int x=0;x<lista.size();x++){
			this.jComboBoxCausas.addItem(lista.get(x));
		}
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(1149, 663);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Consulta por causa muerte donante.");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelCantidadRegistros = new JLabel();
			jLabelCantidadRegistros.setBounds(new Rectangle(838, 558, 245, 49));
			jLabelCantidadRegistros.setText("");
			jLabelGermen = new JLabel();
			jLabelGermen.setBounds(new Rectangle(145, 68, 233, 36));
			jLabelGermen.setFont(new Font("Arial Narrow", Font.BOLD, 24));
			jLabelGermen.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelGermen.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelGermen.setText("Causas de muertes:");
			jLabelGermen.setBackground(new Color(204, 255, 204));
			jLabelSeleccione = new JLabel();
			jLabelSeleccione.setBounds(new Rectangle(27, 14, 861, 30));
			jLabelSeleccione.setBackground(new Color(204, 255, 204));
			jLabelSeleccione.setFont(new Font("Arial Narrow", Font.BOLD, 24));
			jLabelSeleccione.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelSeleccione.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelSeleccione.setText("Seleccione una causa de muerte y presione buscar.");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 204));
			jContentPane.add(jLabelSeleccione, null);
			jContentPane.add(jLabelGermen, null);
			jContentPane.add(getJComboBoxCausas(), null);
			jContentPane.add(getJButtonBuscar(), null);
			jContentPane.add(getJScrollPaneConsulta(), null);
			jContentPane.add(getJButtonAtras(), null);
			jContentPane.add(getJButtonImprimir(), null);
			jContentPane.add(jLabelCantidadRegistros, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jComboBoxCausas	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxCausas() {
		if (jComboBoxCausas == null) {
			jComboBoxCausas = new JComboBox();
			jComboBoxCausas.setBounds(new Rectangle(408, 65, 222, 35));
		}
		return jComboBoxCausas;
	}

	/**
	 * This method initializes jButtonBuscar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonBuscar() {
		if (jButtonBuscar == null) {
			jButtonBuscar = new JButton();
			jButtonBuscar.setBounds(new Rectangle(660, 64, 123, 38));
			jButtonBuscar.setText("Buscar");
			jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					buscar();
				}
			});
		}
		return jButtonBuscar;
	}

	/**
	 * This method initializes jScrollPaneConsulta	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneConsulta() {
		if (jScrollPaneConsulta == null) {
			jScrollPaneConsulta = new JScrollPane();
			jScrollPaneConsulta.setBounds(new Rectangle(26, 129, 1100, 412));
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

	
	private void buscar(){
		CausaMuerteDonante auxCausa = new CausaMuerteDonante();
		auxCausa = (CausaMuerteDonante)this.jComboBoxCausas.getSelectedItem();
		Generico g = new Generico();
		g = Fachada.getInstancia().consultaDonanteCausaMuerte(auxCausa.getId());
		AModeloDatosConsultaGenerico md = new AModeloDatosConsultaGenerico(g);
		TableSorter sorter = new TableSorter(md);
		this.jTableConsulta.setModel(sorter);
		sorter.addMouseListenerToHeaderInTable(this.getJTableConsulta());
		this.jLabelCantidadRegistros.setText("Cantidad de donantes que fallecieron : " + this.getJTableConsulta().getRowCount());
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
	
	private void salir(){
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
			jButtonImprimir.setBounds(new Rectangle(34, 564, 108, 48));
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
}  //  @jve:decl-index=0:visual-constraint="10,10"
