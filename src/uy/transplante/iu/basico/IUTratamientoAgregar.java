package uy.transplante.iu.basico;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;


import javax.swing.JButton;

import uy.transplante.dominio.Medicacion;
import uy.transplante.dominio.Tratamiento;

import logica.Fachada;

public class IUTratamientoAgregar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelMedicacion = null;
	private JComboBox jComboBoxMedicacion = null;
	private JLabel jLabelDosis = null;
	private JTextField jTextFieldDosis = null;
	private JLabel jLabelFechaInicio = null;
	private JDateChooser jDateChooserFechaInicio = null;
	private JButton jButtonCancelar = null;
	private JButton jButtonGuardar = null;
	private int the = -1;
	private Tratamiento t = null;

	/**
	 * This is the default constructor
	 */
	public IUTratamientoAgregar(int the) {
		super();
		initialize();
		this.the = the;
		cargarDatos();
	}

	public IUTratamientoAgregar(Tratamiento t) {
		super();
		initialize();
		this.t = t;
		this.jTextFieldDosis.setText(t.getDosis());
		this.jDateChooserFechaInicio.setCalendar(t.getFecha_inicio());
		this.jComboBoxMedicacion.addItem(t.getMedicacion());
	}
	
	private void cargarDatos() {
		ArrayList<Medicacion> medicaciones = Fachada.getInstancia()
				.obtenerTodasMedicaciones();
		for (int x = 0; x < medicaciones.size(); x++) {
			this.jComboBoxMedicacion.addItem(medicaciones.get(x));
		}
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(416, 247);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Agregar Tratamiento");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelFechaInicio = new JLabel();
			jLabelFechaInicio.setBounds(new Rectangle(28, 99, 105, 31));
			jLabelFechaInicio.setText("Fecha Inicio:");
			jLabelDosis = new JLabel();
			jLabelDosis.setBounds(new Rectangle(29, 60, 103, 28));
			jLabelDosis.setText("Dosis / Dia: ");
			jLabelMedicacion = new JLabel();
			jLabelMedicacion.setBounds(new Rectangle(29, 15, 102, 32));
			jLabelMedicacion.setText("Medicacion :");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 204));
			jContentPane.add(jLabelMedicacion, null);
			jContentPane.add(getJComboBoxMedicacion(), null);
			jContentPane.add(jLabelDosis, null);
			jContentPane.add(getJTextFieldDosis(), null);
			jContentPane.add(jLabelFechaInicio, null);
			jContentPane.add(getJDateChooserFechaInicio(), null);
			jContentPane.add(getJButtonCancelar(), null);
			jContentPane.add(getJButtonGuardar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jComboBoxMedicacion	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxMedicacion() {
		if (jComboBoxMedicacion == null) {
			jComboBoxMedicacion = new JComboBox();
			jComboBoxMedicacion.setBounds(new Rectangle(150, 16, 235, 30));
		}
		return jComboBoxMedicacion;
	}

	/**
	 * This method initializes jTextFieldDosis	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldDosis() {
		if (jTextFieldDosis == null) {
			jTextFieldDosis = new JTextField();
			jTextFieldDosis.setBounds(new Rectangle(149, 56, 236, 33));
		}
		return jTextFieldDosis;
	}

	/**
	 * This method initializes jDateChooserFechaInicio	
	 * 	
	 * @return com.toedter.calendar.JDateChooser	
	 */
	private JDateChooser getJDateChooserFechaInicio() {
		if (jDateChooserFechaInicio == null) {
			jDateChooserFechaInicio = new JDateChooser();
			jDateChooserFechaInicio.setBounds(new Rectangle(148, 99, 236, 33));
		}
		return jDateChooserFechaInicio;
	}

	/**
	 * This method initializes jButtonCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setBounds(new Rectangle(16, 168, 129, 28));
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salir();
				}
			});
		}
		return jButtonCancelar;
	}

	/**
	 * This method initializes jButtonGuardar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonGuardar() {
		if (jButtonGuardar == null) {
			jButtonGuardar = new JButton();
			jButtonGuardar.setBounds(new Rectangle(250, 168, 129, 28));
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
		if(this.t != null){
			this.t.setDosis(this.jTextFieldDosis.getText());
			JOptionPane.showMessageDialog(this,"Solo se cambiara la dosis ", "Advertencia", 1);
			Fachada.getInstancia().guardarTratamiento(this.t);
		}else{
			Tratamiento aux = new Tratamiento();
			aux.setThe(this.the);
			aux.setFecha_inicio(this.jDateChooserFechaInicio.getCalendar());
			Calendar c = new GregorianCalendar();
			c.clear();
			c.set(1950, 1, 1);
			aux.setFecha_fin(c);
			aux.setDosis(this.jTextFieldDosis.getText());
			aux.setMedicacion((Medicacion) this.jComboBoxMedicacion.getSelectedItem());
			Fachada.getInstancia().guardarTratamiento(aux);
		}
		this.salir();
	}
	
	private void salir(){
		this.dispose();
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
