package iu.evolucion;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import uy.transplante.dominio.EvolucionTrasplanteCMV;

import logica.Fachada;

import com.toedter.calendar.JDateChooser;


public class IUEvolucionCMVManejar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelFecha = null;
	private JDateChooser jDateChooserFecha = null;
	private JCheckBox jCheckBoxIgG_CMV = null;
	private JCheckBox jCheckBoxIgM_CMV = null;
	private JCheckBox jCheckBoxPCR_CMV = null;
	private JCheckBox jCheckBoxAg_pp65 = null;
	private JButton jButtonSalir = null;
	private JButton jButtonGuardar = null;
	private int idTrasplante;

	/**
	 * This is the default constructor
	 */
	public IUEvolucionCMVManejar(int idTrasplante,EvolucionTrasplanteCMV e, Calendar fecha) {
		super();
		initialize();
		this.jDateChooserFecha.setCalendar(fecha);
		this.jDateChooserFecha.setEnabled(false);
		this.idTrasplante = idTrasplante;
		if(e!=null){
			this.cargarDatos(e);
		}
	}
	
	public IUEvolucionCMVManejar(int idTrasplante,EvolucionTrasplanteCMV e, Calendar fecha,boolean ver) {
		super();
		initialize();
		this.jDateChooserFecha.setCalendar(fecha);
		this.jDateChooserFecha.setEnabled(false);
		this.idTrasplante = idTrasplante;
		this.jButtonGuardar.setVisible(true);
		if(e!=null){
			this.cargarDatos(e);
		}
	}
	
	private void cargarDatos(EvolucionTrasplanteCMV e){
		this.jCheckBoxAg_pp65.setSelected(e.isAg_pp65());
		this.jCheckBoxIgG_CMV.setSelected(e.isIgG_CMV());
		this.jCheckBoxIgM_CMV.setSelected(e.isIgM_CMV());
		this.jCheckBoxPCR_CMV.setSelected(e.isPCR_CMV());
	}


	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(530, 296);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Evolucion CMV");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelFecha = new JLabel();
			jLabelFecha.setBounds(new Rectangle(98, 19, 153, 31));
			jLabelFecha.setText("Fecha :");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(204, 255, 204));
			jContentPane.add(jLabelFecha, null);
			jContentPane.add(getJDateChooserFecha(), null);
			jContentPane.add(getJCheckBoxIgG_CMV(), null);
			jContentPane.add(getJCheckBoxIgM_CMV(), null);
			jContentPane.add(getJCheckBoxPCR_CMV(), null);
			jContentPane.add(getJCheckBoxAg_pp65(), null);
			jContentPane.add(getJButtonSalir(), null);
			jContentPane.add(getJButtonGuardar(), null);
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
	 * This method initializes jCheckBoxIgG_CMV	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxIgG_CMV() {
		if (jCheckBoxIgG_CMV == null) {
			jCheckBoxIgG_CMV = new JCheckBox();
			jCheckBoxIgG_CMV.setBounds(new Rectangle(50, 71, 193, 36));
			jCheckBoxIgG_CMV.setText("IgG_CMV");
			jCheckBoxIgG_CMV.setBackground(new Color(204, 255, 204));
		}
		return jCheckBoxIgG_CMV;
	}

	/**
	 * This method initializes jCheckBoxIgM_CMV	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxIgM_CMV() {
		if (jCheckBoxIgM_CMV == null) {
			jCheckBoxIgM_CMV = new JCheckBox();
			jCheckBoxIgM_CMV.setBounds(new Rectangle(269, 72, 199, 36));
			jCheckBoxIgM_CMV.setText("IgM_CMV");
			jCheckBoxIgM_CMV.setBackground(new Color(204, 255, 204));
		}
		return jCheckBoxIgM_CMV;
	}

	/**
	 * This method initializes jCheckBoxPCR_CMV	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPCR_CMV() {
		if (jCheckBoxPCR_CMV == null) {
			jCheckBoxPCR_CMV = new JCheckBox();
			jCheckBoxPCR_CMV.setBounds(new Rectangle(44, 130, 191, 42));
			jCheckBoxPCR_CMV.setText("PCR_CMV");
			jCheckBoxPCR_CMV.setBackground(new Color(204, 255, 204));
		}
		return jCheckBoxPCR_CMV;
	}

	/**
	 * This method initializes jCheckBoxAg_pp65	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxAg_pp65() {
		if (jCheckBoxAg_pp65 == null) {
			jCheckBoxAg_pp65 = new JCheckBox();
			jCheckBoxAg_pp65.setBounds(new Rectangle(271, 135, 195, 43));
			jCheckBoxAg_pp65.setText("Ag_pp65");
			jCheckBoxAg_pp65.setBackground(new Color(204, 255, 204));
		}
		return jCheckBoxAg_pp65;
	}

	/**
	 * This method initializes jButtonSalir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSalir() {
		if (jButtonSalir == null) {
			jButtonSalir = new JButton();
			jButtonSalir.setBounds(new Rectangle(46, 208, 151, 34));
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
			jButtonGuardar.setBounds(new Rectangle(259, 209, 165, 32));
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
		EvolucionTrasplanteCMV e = new EvolucionTrasplanteCMV();
		e.setFecha(this.jDateChooserFecha.getCalendar());
		e.setAg_pp65(this.jCheckBoxAg_pp65.isSelected());
		e.setIgG_CMV(this.jCheckBoxIgG_CMV.isSelected());
		e.setIgM_CMV(this.jCheckBoxIgM_CMV.isSelected());
		e.setPCR_CMV(this.jCheckBoxPCR_CMV.isSelected());
		e.setIdTrasplante(this.idTrasplante);
		Fachada.getInstancia().guardarEvolucionCMV(e);
		this.salir();
	}
	
	private void salir(){
		this.dispose();
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
