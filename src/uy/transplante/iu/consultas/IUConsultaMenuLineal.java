package uy.transplante.iu.consultas;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.WindowConstants;

public class IUConsultaMenuLineal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelDesde = null;
	private JComboBox jComboBoxDesde = null;
	private JLabel jLabelHasta = null;
	private JComboBox jComboBoxHasta = null;
	private JButton jButtonBuscar = null;
	private JComboBox jComboBoxTipo = null;

	/**
	 * This is the default constructor
	 */
	public IUConsultaMenuLineal() {
		super();
		initialize();
		cargarCombos();
	}

	private void cargarCombos(){
		for(int x=0;x<36;x++){
			this.getJComboBoxDesde().addItem(x);
			this.getJComboBoxHasta().addItem(x);
		}
		this.getJComboBoxTipo().addItem("Meses");
		this.getJComboBoxTipo().addItem("Dias");
		this.getJComboBoxTipo().addItem("Años");
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(477, 226);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Menu consulta lineal");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelHasta = new JLabel();
			jLabelHasta.setBounds(new Rectangle(244, 31, 74, 32));
			jLabelHasta.setText("Hasta");
			jLabelDesde = new JLabel();
			jLabelDesde.setBounds(new Rectangle(20, 31, 87, 31));
			jLabelDesde.setText("Desde");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 204));
			jContentPane.add(jLabelDesde, null);
			jContentPane.add(getJComboBoxDesde(), null);
			jContentPane.add(jLabelHasta, null);
			jContentPane.add(getJComboBoxHasta(), null);
			jContentPane.add(getJButtonBuscar(), null);
			jContentPane.add(getJComboBoxTipo(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jComboBoxDesde	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxDesde() {
		if (jComboBoxDesde == null) {
			jComboBoxDesde = new JComboBox();
			jComboBoxDesde.setBounds(new Rectangle(122, 31, 104, 31));
		}
		return jComboBoxDesde;
	}

	/**
	 * This method initializes jComboBoxHasta	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxHasta() {
		if (jComboBoxHasta == null) {
			jComboBoxHasta = new JComboBox();
			jComboBoxHasta.setBounds(new Rectangle(338, 31, 105, 30));
		}
		return jComboBoxHasta;
	}

	/**
	 * This method initializes jButtonBuscar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonBuscar() {
		if (jButtonBuscar == null) {
			jButtonBuscar = new JButton();
			jButtonBuscar.setBounds(new Rectangle(194, 138, 138, 35));
			jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					buscar();
				}
			});
			jButtonBuscar.setText("Buscar");
		}
		return jButtonBuscar;
	}

	/**
	 * This method initializes jComboBoxTipo	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxTipo() {
		if (jComboBoxTipo == null) {
			jComboBoxTipo = new JComboBox();
			jComboBoxTipo.setBounds(new Rectangle(106, 76, 291, 36));
			jComboBoxTipo.setBackground(Color.white);
		}
		return jComboBoxTipo;
	}

	private void buscar(){
		int desde = (Integer) this.getJComboBoxDesde().getSelectedItem();
		int hasta = (Integer) this.getJComboBoxHasta().getSelectedItem();
		String tipo = (String) this.getJComboBoxTipo().getSelectedItem();
		IUConsultaLinealComplicacionesTiempo iu = new IUConsultaLinealComplicacionesTiempo(desde,hasta,tipo);
		iu.setVisible(true);
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
