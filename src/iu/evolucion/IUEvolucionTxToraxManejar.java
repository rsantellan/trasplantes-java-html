package iu.evolucion;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import logica.Fachada;

import com.toedter.calendar.JDateChooser;

import dominio.EvolucionTrasplanteTxTorax;

public class IUEvolucionTxToraxManejar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelFecha = null;
	private JDateChooser jDateChooserFecha = null;
	private JCheckBox jCheckBoxDerramePleural = null;
	private JCheckBox jCheckBoxFoco = null;
	private JButton jButtonSalir = null;
	private JButton jButtonGuardar = null;
	private int idTrasplante;
	private JCheckBox jCheckBoxSecuelas = null;
	private JLabel jLabelRct = null;
	private JTextField jTextFieldRCT = null;
	private JLabel jLabelLateralizado = null;
	private JComboBox jComboBoxLateralizado = null;
	private JLabel jLabelLateralDerrame = null;
	private JComboBox jComboBoxLateralDerrame = null;
	private JLabel jLabelOtros = null;
	private JScrollPane jScrollPaneOtros = null;
	private JTextArea jTextAreaotros = null;

	/**
	 * This is the default constructor
	 */
	public IUEvolucionTxToraxManejar(int idTrasplante,EvolucionTrasplanteTxTorax e, Calendar fecha) {
		super();
		initialize();
		this.jDateChooserFecha.setCalendar(fecha);
		this.jDateChooserFecha.setEnabled(false);
		this.idTrasplante = idTrasplante;
		cargarCombos();
		if(e!=null){
			this.cargarDatos(e);
		}
	}
	
	public IUEvolucionTxToraxManejar(int idTrasplante,EvolucionTrasplanteTxTorax e, Calendar fecha,boolean ver) {
		super();
		initialize();
		this.jDateChooserFecha.setCalendar(fecha);
		this.jDateChooserFecha.setEnabled(false);
		this.idTrasplante = idTrasplante;
		cargarCombos();
		this.jButtonGuardar.setVisible(false);
		if(e!=null){
			this.cargarDatos(e);
		}
	}
	
	private void cargarCombos(){
		this.jComboBoxLateralDerrame.addItem("Izquierda");
		this.jComboBoxLateralDerrame.addItem("Derecha");
		this.jComboBoxLateralDerrame.addItem("Bilateral");
		this.jComboBoxLateralizado.addItem("Izquierda");
		this.jComboBoxLateralizado.addItem("Derecha");
		this.jComboBoxLateralizado.addItem("Bilateral");
	}
	private void cargarDatos(EvolucionTrasplanteTxTorax e){
		this.jCheckBoxDerramePleural.setSelected(e.isDerramePleural());
		this.jCheckBoxFoco.setSelected(e.isFoco());
		this.jCheckBoxSecuelas.setSelected(e.isSecuelas());
		this.jTextFieldRCT.setText(String.valueOf(e.getRct()));
		this.jTextAreaotros.setText(e.getOtros());
		this.jComboBoxLateralDerrame.setSelectedItem(e.getLateralDerrame());
		this.jComboBoxLateralizado.setSelectedItem(e.getLateralizado());
	}


	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(530, 442);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Evolucion Tx Torax");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelOtros = new JLabel();
			jLabelOtros.setBounds(new Rectangle(46, 244, 65, 31));
			jLabelOtros.setText("Otros :");
			jLabelLateralDerrame = new JLabel();
			jLabelLateralDerrame.setBounds(new Rectangle(181, 149, 115, 27));
			jLabelLateralDerrame.setText("Lateral Derrame :");
			jLabelLateralizado = new JLabel();
			jLabelLateralizado.setBounds(new Rectangle(183, 100, 107, 31));
			jLabelLateralizado.setText("Lateralizado :");
			jLabelRct = new JLabel();
			jLabelRct.setBounds(new Rectangle(39, 61, 66, 29));
			jLabelRct.setText("RC/T :");
			jLabelFecha = new JLabel();
			jLabelFecha.setBounds(new Rectangle(98, 19, 153, 31));
			jLabelFecha.setText("Fecha :");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(204, 255, 204));
			jContentPane.add(jLabelFecha, null);
			jContentPane.add(getJDateChooserFecha(), null);
			jContentPane.add(getJCheckBoxDerramePleural(), null);
			jContentPane.add(getJCheckBoxFoco(), null);
			jContentPane.add(getJButtonSalir(), null);
			jContentPane.add(getJButtonGuardar(), null);
			jContentPane.add(getJCheckBoxSecuelas(), null);
			jContentPane.add(jLabelRct, null);
			jContentPane.add(getJTextFieldRCT(), null);
			jContentPane.add(jLabelLateralizado, null);
			jContentPane.add(getJComboBoxLateralizado(), null);
			jContentPane.add(jLabelLateralDerrame, null);
			jContentPane.add(getJComboBoxLateralDerrame(), null);
			jContentPane.add(jLabelOtros, null);
			jContentPane.add(getJScrollPaneOtros(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jDateChooserFecha	
	 * 	
	 * @return com.toedter.calendar.JDateChooser	
	 */
	private JDateChooser getJDateChooserFecha() {
		if (jDateChooserFecha == null) {
			jDateChooserFecha = new JDateChooser();
			jDateChooserFecha.setBounds(new Rectangle(266, 19, 210, 32));
		}
		return jDateChooserFecha;
	}

	/**
	 * This method initializes jCheckBoxDerramePleural	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxDerramePleural() {
		if (jCheckBoxDerramePleural == null) {
			jCheckBoxDerramePleural = new JCheckBox();
			jCheckBoxDerramePleural.setBounds(new Rectangle(42, 149, 126, 36));
			jCheckBoxDerramePleural.setText("Derrame Pleural");
			jCheckBoxDerramePleural.setBackground(new Color(204, 255, 204));
		}
		return jCheckBoxDerramePleural;
	}

	/**
	 * This method initializes jCheckBoxFoco	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxFoco() {
		if (jCheckBoxFoco == null) {
			jCheckBoxFoco = new JCheckBox();
			jCheckBoxFoco.setBounds(new Rectangle(40, 101, 76, 36));
			jCheckBoxFoco.setText("Foco");
			jCheckBoxFoco.setBackground(new Color(204, 255, 204));
		}
		return jCheckBoxFoco;
	}

	/**
	 * This method initializes jButtonSalir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSalir() {
		if (jButtonSalir == null) {
			jButtonSalir = new JButton();
			jButtonSalir.setBounds(new Rectangle(64, 344, 151, 34));
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
	 * This method initializes jButtonGuardar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonGuardar() {
		if (jButtonGuardar == null) {
			jButtonGuardar = new JButton();
			jButtonGuardar.setBounds(new Rectangle(277, 345, 165, 32));
			jButtonGuardar.setText("Guardar");
			jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					guardar();
				}
			});
		}
		return jButtonGuardar;
	}

	private void guardar(){
		EvolucionTrasplanteTxTorax e = new EvolucionTrasplanteTxTorax();
		e.setFecha(this.jDateChooserFecha.getCalendar());
		e.setDerramePleural(this.jCheckBoxDerramePleural.isSelected());
		e.setFoco(this.jCheckBoxFoco.isSelected());
		e.setSecuelas(this.jCheckBoxSecuelas.isSelected());
		e.setLateralDerrame((String)this.jComboBoxLateralDerrame.getSelectedItem());
		e.setLateralizado((String)this.jComboBoxLateralizado.getSelectedItem()); 
		boolean error = false;
		try{
			String aux = this.jTextFieldRCT.getText();
			e.setRct(Integer.parseInt(aux));
		}catch(Exception e1){
			JOptionPane.showMessageDialog(this,"Dato mal ingresado en RC/T", "Error", 2);
			error = true;
		}
		if(!error){
			e.setOtros(this.jTextAreaotros.getText());
			e.setIdTrasplante(this.idTrasplante);
			Fachada.getInstancia().guardarEvolucionTxTorax(e);
			this.salir();
		}

	}
	
	private void salir(){
		this.dispose();
	}

	/**
	 * This method initializes jCheckBoxSecuelas	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxSecuelas() {
		if (jCheckBoxSecuelas == null) {
			jCheckBoxSecuelas = new JCheckBox();
			jCheckBoxSecuelas.setBounds(new Rectangle(43, 200, 99, 36));
			jCheckBoxSecuelas.setText("Secuelas");
			jCheckBoxSecuelas.setBackground(new Color(204, 255, 204));
		}
		return jCheckBoxSecuelas;
	}

	/**
	 * This method initializes jTextFieldRCT	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldRCT() {
		if (jTextFieldRCT == null) {
			jTextFieldRCT = new JTextField();
			jTextFieldRCT.setBounds(new Rectangle(131, 61, 200, 27));
		}
		return jTextFieldRCT;
	}

	/**
	 * This method initializes jComboBoxLateralizado	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxLateralizado() {
		if (jComboBoxLateralizado == null) {
			jComboBoxLateralizado = new JComboBox();
			jComboBoxLateralizado.setBounds(new Rectangle(309, 100, 162, 27));
		}
		return jComboBoxLateralizado;
	}

	/**
	 * This method initializes jComboBoxLateralDerrame	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxLateralDerrame() {
		if (jComboBoxLateralDerrame == null) {
			jComboBoxLateralDerrame = new JComboBox();
			jComboBoxLateralDerrame.setBounds(new Rectangle(310, 149, 159, 26));
		}
		return jComboBoxLateralDerrame;
	}

	/**
	 * This method initializes jScrollPaneOtros	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneOtros() {
		if (jScrollPaneOtros == null) {
			jScrollPaneOtros = new JScrollPane();
			jScrollPaneOtros.setBounds(new Rectangle(133, 244, 338, 83));
			jScrollPaneOtros.setViewportView(getJTextAreaotros());
		}
		return jScrollPaneOtros;
	}

	/**
	 * This method initializes jTextAreaotros	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextAreaotros() {
		if (jTextAreaotros == null) {
			jTextAreaotros = new JTextArea();
		}
		return jTextAreaotros;
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
