package iU;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import logica.Fachada;

import com.toedter.calendar.JDateChooser;

import dominio.EvolucionTrasplanteECG;

public class IUEvolucionECGManejar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelFecha = null;
	private JDateChooser jDateChooserFecha = null;
	private JButton jButtonSalir = null;
	private JButton jButtonGuardar = null;
	private int idTrasplante;
	private JComboBox jComboBoxRs = null;
	private JLabel jLabelRs = null;
	private JLabel jLabelHVI = null;
	private JComboBox jComboBoxHVI = null;
	private JLabel jLabelOndaQ = null;
	private JComboBox jComboBoxOndaQ = null;

	/**
	 * This is the default constructor
	 */
	public IUEvolucionECGManejar(int idTrasplante,EvolucionTrasplanteECG e, Calendar fecha) {
		super();
		initialize();
		this.jDateChooserFecha.setCalendar(fecha);
		this.jDateChooserFecha.setEnabled(false);
		this.idTrasplante = idTrasplante;
		cargarCombo();
		if(e!=null){
			this.cargarDatos(e);
		}
	}
	
	public IUEvolucionECGManejar(int idTrasplante,EvolucionTrasplanteECG e, Calendar fecha,boolean ver) {
		super();
		initialize();
		this.jDateChooserFecha.setCalendar(fecha);
		this.jDateChooserFecha.setEnabled(false);
		this.idTrasplante = idTrasplante;
		cargarCombo();
		if(e!=null){
			this.cargarDatos(e);
		}
		this.jButtonGuardar.setVisible(false);
	}
	
	private void cargarDatos(EvolucionTrasplanteECG e){
		this.jComboBoxHVI.setSelectedItem(e.getHvi());
		this.jComboBoxOndaQ.setSelectedItem(e.getOndaQ());
		this.jComboBoxRs.setSelectedItem(e.getRs());
	}


	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(394, 296);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Evolucion ECG");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelOndaQ = new JLabel();
			jLabelOndaQ.setBounds(new Rectangle(11, 150, 94, 28));
			jLabelOndaQ.setText("Onda Q :");
			jLabelHVI = new JLabel();
			jLabelHVI.setBounds(new Rectangle(11, 110, 94, 28));
			jLabelHVI.setText("HVI :");
			jLabelRs = new JLabel();
			jLabelRs.setBounds(new Rectangle(11, 69, 94, 28));
			jLabelRs.setText("Rs :");
			jLabelFecha = new JLabel();
			jLabelFecha.setBounds(new Rectangle(15, 19, 93, 31));
			jLabelFecha.setText("Fecha :");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(204, 255, 204));
			jContentPane.add(jLabelFecha, null);
			jContentPane.add(getJDateChooserFecha(), null);
			jContentPane.add(getJButtonSalir(), null);
			jContentPane.add(getJButtonGuardar(), null);
			jContentPane.add(getJComboBoxRs(), null);
			jContentPane.add(jLabelRs, null);
			jContentPane.add(jLabelHVI, null);
			jContentPane.add(getJComboBoxHVI(), null);
			jContentPane.add(jLabelOndaQ, null);
			jContentPane.add(getJComboBoxOndaQ(), null);
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
			jDateChooserFecha.setBounds(new Rectangle(120, 20, 210, 32));
		}
		return jDateChooserFecha;
	}

	/**
	 * This method initializes jButtonSalir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSalir() {
		if (jButtonSalir == null) {
			jButtonSalir = new JButton();
			jButtonSalir.setBounds(new Rectangle(14, 207, 151, 34));
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
			jButtonGuardar.setBounds(new Rectangle(174, 208, 165, 32));
			jButtonGuardar.setText("Guardar");
			jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					guardar();
				}
			});
		}
		return jButtonGuardar;
	}

	private void cargarCombo(){
		this.jComboBoxRs.addItem("Ausente");
		this.jComboBoxRs.addItem("Presente");
		this.jComboBoxRs.addItem("Falta");
		this.jComboBoxHVI.addItem("Ausente");
		this.jComboBoxHVI.addItem("Presente");
		this.jComboBoxHVI.addItem("Falta");
		this.jComboBoxOndaQ.addItem("Ausente");
		this.jComboBoxOndaQ.addItem("Presente");
		this.jComboBoxOndaQ.addItem("Falta");
	}
	
	private void guardar(){
		EvolucionTrasplanteECG e = new EvolucionTrasplanteECG();
		e.setFecha(this.jDateChooserFecha.getCalendar());
		e.setHvi((String)this.jComboBoxHVI.getSelectedItem());
		e.setOndaQ((String)this.jComboBoxOndaQ.getSelectedItem());
		e.setRs((String)this.jComboBoxRs.getSelectedItem());
		e.setIdTrasplante(this.idTrasplante);
		Fachada.getInstancia().guardarEvolucionECG(e);
		this.salir();
	}
	
	private void salir(){
		this.dispose();
	}

	/**
	 * This method initializes jComboBoxRs	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxRs() {
		if (jComboBoxRs == null) {
			jComboBoxRs = new JComboBox();
			jComboBoxRs.setBounds(new Rectangle(121, 67, 210, 32));
		}
		return jComboBoxRs;
	}

	/**
	 * This method initializes jComboBoxHVI	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxHVI() {
		if (jComboBoxHVI == null) {
			jComboBoxHVI = new JComboBox();
			jComboBoxHVI.setBounds(new Rectangle(121, 110, 210, 32));
		}
		return jComboBoxHVI;
	}

	/**
	 * This method initializes jComboBoxOndaQ	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxOndaQ() {
		if (jComboBoxOndaQ == null) {
			jComboBoxOndaQ = new JComboBox();
			jComboBoxOndaQ.setBounds(new Rectangle(121, 150, 210, 32));
		}
		return jComboBoxOndaQ;
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
