package uy.transplante.iu.complicacion;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


import com.toedter.calendar.JDateChooser;

import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import uy.transplante.dominio.Medicacion;
import uy.transplante.dominio.TrasplanteComplicacionesNoInf;
import uy.transplante.dominio.TrasplanteTiposComplicaciones;
import uy.transplante.logica.Fachada;

public class IUComplicacionesNoInfInsertar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelFecha = null;
	private JDateChooser jDateChooserFecha = null;
	private JCheckBox jCheckBoxInternado = null;
	private JLabel jLabelDias = null;
	private JTextField jTextFieldDias = null;
	private JLabel jLabelMedicacion = null;
	private JComboBox jComboBoxMedicacion = null;
	private JLabel jLabelTipo = null;
	private JComboBox jComboBoxTipo = null;
	private JButton jButtonSalir = null;
	private JButton jButtonGuardar = null;
	private int the;
	private boolean esTrasplante;
	private JDesktopPane jDesktopPaneObservaciones = null;
	private JLabel jLabelObservaciones = null;
	private JScrollPane jScrollPaneObservaciones = null;
	private JTextArea jTextAreaObservaciones = null;

	/**
	 * This is the default constructor
	 */
	public IUComplicacionesNoInfInsertar(int the, boolean esTrasplante) {
		super();
		this.the = the;
		this.esTrasplante = esTrasplante;
		initialize();
		cargarDatos();
	}

	private void cargarDatos() {
		ArrayList<Medicacion> medicaciones = Fachada.getInstancia()
				.obtenerTodasMedicaciones();
		for (int x = 0; x < medicaciones.size(); x++) {
			this.jComboBoxMedicacion.addItem(medicaciones.get(x));
		}
		ArrayList<TrasplanteTiposComplicaciones> tipos = Fachada.getInstancia()
				.obtenerTodosTiposComplicaciones();
		for (int x = 0; x < tipos.size(); x++) {
			this.jComboBoxTipo.addItem(tipos.get(x));
		}
		if(this.esTrasplante){
			this.jCheckBoxInternado.setSelected(true);
			this.jCheckBoxInternado.setEnabled(false);
			this.jTextFieldDias.setEnabled(false);
			this.jTextFieldDias.setText("0");
		}
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(426, 411);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Insertar Complicacion No Infecciosa");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelTipo = new JLabel();
			jLabelTipo.setBounds(new Rectangle(19, 137, 135, 29));
			jLabelTipo.setText("Tipo:");
			jLabelMedicacion = new JLabel();
			jLabelMedicacion.setBounds(new Rectangle(20, 95, 131, 30));
			jLabelMedicacion.setText("Medicacion:");
			jLabelDias = new JLabel();
			jLabelDias.setBounds(new Rectangle(181, 60, 63, 31));
			jLabelDias.setText("Dias:");
			jLabelFecha = new JLabel();
			jLabelFecha.setBounds(new Rectangle(17, 14, 132, 33));
			jLabelFecha.setText("Fecha");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 204));
			jContentPane.add(jLabelFecha, null);
			jContentPane.add(getJDateChooserFecha(), null);
			jContentPane.add(getJCheckBoxInternado(), null);
			jContentPane.add(jLabelDias, null);
			jContentPane.add(getJTextFieldDias(), null);
			jContentPane.add(jLabelMedicacion, null);
			jContentPane.add(getJComboBoxMedicacion(), null);
			jContentPane.add(jLabelTipo, null);
			jContentPane.add(getJComboBoxTipo(), null);
			jContentPane.add(getJButtonSalir(), null);
			jContentPane.add(getJButtonGuardar(), null);
			jContentPane.add(getJDesktopPaneObservaciones(), null);
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
			jDateChooserFecha.setBounds(new Rectangle(180, 16, 215, 33));
		}
		return jDateChooserFecha;
	}

	/**
	 * This method initializes jCheckBoxInternado
	 * 
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxInternado() {
		if (jCheckBoxInternado == null) {
			jCheckBoxInternado = new JCheckBox();
			jCheckBoxInternado.setBounds(new Rectangle(17, 64, 132, 29));
			jCheckBoxInternado.setText("Internado");
			jCheckBoxInternado.setBackground(new Color(255, 255, 204));
		}
		return jCheckBoxInternado;
	}

	/**
	 * This method initializes jTextFieldDias
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldDias() {
		if (jTextFieldDias == null) {
			jTextFieldDias = new JTextField();
			jTextFieldDias.setBounds(new Rectangle(269, 61, 126, 30));
		}
		return jTextFieldDias;
	}

	/**
	 * This method initializes jComboBoxMedicacion
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxMedicacion() {
		if (jComboBoxMedicacion == null) {
			jComboBoxMedicacion = new JComboBox();
			jComboBoxMedicacion.setBounds(new Rectangle(180, 97, 216, 33));
		}
		return jComboBoxMedicacion;
	}

	/**
	 * This method initializes jComboBoxTipo
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxTipo() {
		if (jComboBoxTipo == null) {
			jComboBoxTipo = new JComboBox();
			jComboBoxTipo.setBounds(new Rectangle(19, 174, 380, 35));
		}
		return jComboBoxTipo;
	}

	/**
	 * This method initializes jButtonSalir
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonSalir() {
		if (jButtonSalir == null) {
			jButtonSalir = new JButton();
			jButtonSalir.setBounds(new Rectangle(13, 327, 116, 36));
			jButtonSalir.setText("Cancelar");
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
			jButtonGuardar.setBounds(new Rectangle(280, 327, 116, 36));
			jButtonGuardar.setText("Guardar");
			jButtonGuardar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							guardar();
						}
					});
		}
		return jButtonGuardar;
	}

	private void guardar() {
		if (this.jDateChooserFecha.getCalendar() != null) {
			TrasplanteComplicacionesNoInf tnf = new TrasplanteComplicacionesNoInf();
			tnf.setIdPretrasplante(this.the);
			tnf.setEvolucion(!this.esTrasplante);
			tnf.setFecha(this.jDateChooserFecha.getCalendar());
			tnf.setInternado(this.jCheckBoxInternado.isSelected());
			if (this.jCheckBoxInternado.isSelected()) {
				while (this.jTextFieldDias.getText().equalsIgnoreCase("")&& this.jTextFieldDias.getText().equalsIgnoreCase(" ")) {
					this.jTextFieldDias.setText(JOptionPane.showInputDialog(this,
								"Como eligio que el paciente estuvo internado tiene que poner un numero de dias que estuvo internado: ",
								"Confirmar", 1));
				}
				tnf.setDiasInternado(Integer.parseInt(this.jTextFieldDias.getText()));
			} else {
				tnf.setDiasInternado(0);
			}
			tnf.setMedicacion((Medicacion) this.jComboBoxMedicacion.getSelectedItem());
			tnf.setComplicacion((TrasplanteTiposComplicaciones) this.jComboBoxTipo.getSelectedItem());
			tnf.setComentario(this.jTextAreaObservaciones.getText());
			Fachada.getInstancia().guardarComplicacionNoInf(tnf);
			this.salir();
		}
	}

	private void salir() {
		this.dispose();
	}

	/**
	 * This method initializes jDesktopPaneObservaciones	
	 * 	
	 * @return javax.swing.JDesktopPane	
	 */
	private JDesktopPane getJDesktopPaneObservaciones() {
		if (jDesktopPaneObservaciones == null) {
			jLabelObservaciones = new JLabel();
			jLabelObservaciones.setBounds(new Rectangle(5, 2, 138, 24));
			jLabelObservaciones.setText("Observaciones:");
			jDesktopPaneObservaciones = new JDesktopPane();
			jDesktopPaneObservaciones.setBounds(new Rectangle(18, 219, 380, 103));
			jDesktopPaneObservaciones.add(jLabelObservaciones, null);
			jDesktopPaneObservaciones.add(getJScrollPaneObservaciones(), null);
		}
		return jDesktopPaneObservaciones;
	}

	/**
	 * This method initializes jScrollPaneObservaciones	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneObservaciones() {
		if (jScrollPaneObservaciones == null) {
			jScrollPaneObservaciones = new JScrollPane();
			jScrollPaneObservaciones.setBounds(new Rectangle(5, 28, 362, 68));
			jScrollPaneObservaciones.setViewportView(getJTextAreaObservaciones());
		}
		return jScrollPaneObservaciones;
	}

	/**
	 * This method initializes jTextAreaObservaciones	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextAreaObservaciones() {
		if (jTextAreaObservaciones == null) {
			jTextAreaObservaciones = new JTextArea();
		}
		return jTextAreaObservaciones;
	}
} // @jve:decl-index=0:visual-constraint="10,10"
