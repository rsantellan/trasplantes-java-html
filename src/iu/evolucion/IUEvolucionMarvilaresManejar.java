package iu.evolucion;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import uy.transplante.dominio.EvolucionTrasplanteMarvirales;

import logica.Fachada;

import com.toedter.calendar.JDateChooser;


public class IUEvolucionMarvilaresManejar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelFecha = null;
	private JDateChooser jDateChooserFecha = null;
	private JButton jButtonSalir = null;
	private JButton jButtonGuardar = null;
	private int idTrasplante;
	private JComboBox jComboBoxAgHBS = null;
	private JLabel jLabelAgHBS = null;
	private JLabel jLabelHBSAc = null;
	private JComboBox jComboBoxHBSAc = null;
	private JLabel jLabelHBSACore = null;
	private JComboBox jComboBoxHBSACore = null;
	private JLabel jLabelHVC = null;
	private JComboBox jComboBoxHVC = null;
	private JLabel jLabelHIV = null;
	private JComboBox jComboBoxHIV = null;
	private JCheckBox jCheckBoxHSV = null;

	/**
	 * This is the default constructor
	 */
	public IUEvolucionMarvilaresManejar(int idTrasplante,EvolucionTrasplanteMarvirales e, Calendar fecha) {
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
	
	public IUEvolucionMarvilaresManejar(int idTrasplante,EvolucionTrasplanteMarvirales e, Calendar fecha,boolean ver) {
		super();
		initialize();
		this.jDateChooserFecha.setCalendar(fecha);
		this.jDateChooserFecha.setEnabled(false);
		this.idTrasplante = idTrasplante;
		cargarCombo();
		this.jButtonGuardar.setVisible(false);
		if(e!=null){
			this.cargarDatos(e);
		}
	}
	
	private void cargarDatos(EvolucionTrasplanteMarvirales e){
		this.jComboBoxHBSAc.setSelectedItem(e.getHbsac());
		this.jComboBoxHBSACore.setSelectedItem(e.getHbcac());
		this.jComboBoxAgHBS.setSelectedItem(e.getAghbs());
		this.jComboBoxHVC.setSelectedItem(e.getHvc());
		this.jComboBoxHIV.setSelectedItem(e.getHiv());
		this.jCheckBoxHSV.setSelected(e.isHsv());
	}


	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(394, 439);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Evolucion Marcadores virales");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelHIV = new JLabel();
			jLabelHIV.setBounds(new Rectangle(11, 230, 94, 28));
			jLabelHIV.setText("HIV :");
			jLabelHVC = new JLabel();
			jLabelHVC.setBounds(new Rectangle(11, 190, 94, 28));
			jLabelHVC.setText("HVC :");
			jLabelHBSACore = new JLabel();
			jLabelHBSACore.setBounds(new Rectangle(11, 150, 94, 28));
			jLabelHBSACore.setText("Hbc Ac :");
			jLabelHBSAc = new JLabel();
			jLabelHBSAc.setBounds(new Rectangle(11, 110, 94, 28));
			jLabelHBSAc.setText("Hbs Ac :");
			jLabelAgHBS = new JLabel();
			jLabelAgHBS.setBounds(new Rectangle(11, 69, 94, 28));
			jLabelAgHBS.setText("Hbs Ag:");
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
			jContentPane.add(getJComboBoxAgHBS(), null);
			jContentPane.add(jLabelAgHBS, null);
			jContentPane.add(jLabelHBSAc, null);
			jContentPane.add(getJComboBoxHBSAc(), null);
			jContentPane.add(jLabelHBSACore, null);
			jContentPane.add(getJComboBoxHBSACore(), null);
			jContentPane.add(jLabelHVC, null);
			jContentPane.add(getJComboBoxHVC(), null);
			jContentPane.add(jLabelHIV, null);
			jContentPane.add(getJComboBoxHIV(), null);
			jContentPane.add(getJCheckBoxHSV(), null);
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
			jButtonSalir.setBounds(new Rectangle(12, 359, 151, 34));
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
			jButtonGuardar.setBounds(new Rectangle(172, 360, 165, 32));
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
		this.jComboBoxAgHBS.addItem("Indeterminado");
		this.jComboBoxAgHBS.addItem("Negativo");
		this.jComboBoxAgHBS.addItem("Positivo");
		this.jComboBoxAgHBS.addItem("Sin datos");
		this.jComboBoxHBSAc.addItem("Indeterminado");
		this.jComboBoxHBSAc.addItem("Negativo");
		this.jComboBoxHBSAc.addItem("Positivo");
		this.jComboBoxHBSAc.addItem("Sin datos");
		this.jComboBoxHBSACore.addItem("Indeterminado");
		this.jComboBoxHBSACore.addItem("Negativo");
		this.jComboBoxHBSACore.addItem("Positivo");
		this.jComboBoxHBSACore.addItem("Sin datos");
		this.jComboBoxHVC.addItem("Indeterminado");
		this.jComboBoxHVC.addItem("Negativo");
		this.jComboBoxHVC.addItem("Positivo");
		this.jComboBoxHVC.addItem("Sin datos");
		this.jComboBoxHIV.addItem("Indeterminado");
		this.jComboBoxHIV.addItem("Negativo");
		this.jComboBoxHIV.addItem("Positivo");
		this.jComboBoxHIV.addItem("Sin datos");
	}
	
	private void guardar(){
		EvolucionTrasplanteMarvirales e = new EvolucionTrasplanteMarvirales();
		e.setFecha(this.jDateChooserFecha.getCalendar());
		e.setHbsac((String)this.jComboBoxHBSAc.getSelectedItem());
		e.setHbcac((String)this.jComboBoxHBSACore.getSelectedItem());
		e.setAghbs((String)this.jComboBoxAgHBS.getSelectedItem());
		e.setHvc((String) this.jComboBoxHVC.getSelectedItem());
		e.setHiv((String) this.jComboBoxHIV.getSelectedItem());
		e.setHsv(this.jCheckBoxHSV.isSelected());
		e.setIdTrasplante(this.idTrasplante);
		Fachada.getInstancia().guardarEvolucionMarvirales(e);
		this.salir();
	}
	
	private void salir(){
		this.dispose();
	}

	/**
	 * This method initializes jComboBoxAgHBS	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxAgHBS() {
		if (jComboBoxAgHBS == null) {
			jComboBoxAgHBS = new JComboBox();
			jComboBoxAgHBS.setBounds(new Rectangle(121, 67, 210, 32));
		}
		return jComboBoxAgHBS;
	}

	/**
	 * This method initializes jComboBoxHBSAc	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxHBSAc() {
		if (jComboBoxHBSAc == null) {
			jComboBoxHBSAc = new JComboBox();
			jComboBoxHBSAc.setBounds(new Rectangle(121, 110, 210, 32));
		}
		return jComboBoxHBSAc;
	}

	/**
	 * This method initializes jComboBoxHBSACore	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxHBSACore() {
		if (jComboBoxHBSACore == null) {
			jComboBoxHBSACore = new JComboBox();
			jComboBoxHBSACore.setBounds(new Rectangle(121, 150, 210, 32));
		}
		return jComboBoxHBSACore;
	}

	/**
	 * This method initializes jComboBoxHVC	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxHVC() {
		if (jComboBoxHVC == null) {
			jComboBoxHVC = new JComboBox();
			jComboBoxHVC.setBounds(new Rectangle(121, 190, 210, 32));
		}
		return jComboBoxHVC;
	}

	/**
	 * This method initializes jComboBoxHIV	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxHIV() {
		if (jComboBoxHIV == null) {
			jComboBoxHIV = new JComboBox();
			jComboBoxHIV.setBounds(new Rectangle(121, 230, 210, 32));
		}
		return jComboBoxHIV;
	}

	/**
	 * This method initializes jCheckBoxHSV	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxHSV() {
		if (jCheckBoxHSV == null) {
			jCheckBoxHSV = new JCheckBox();
			jCheckBoxHSV.setBounds(new Rectangle(13, 271, 198, 29));
			jCheckBoxHSV.setBackground(new Color(204, 255, 204));
			jCheckBoxHSV.setText("Herpes Virus");
		}
		return jCheckBoxHSV;
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
