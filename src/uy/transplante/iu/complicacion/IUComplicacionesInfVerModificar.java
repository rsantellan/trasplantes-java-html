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

import logica.Fachada;

import com.toedter.calendar.JDateChooser;

import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import uy.transplante.dominio.Germenes;
import uy.transplante.dominio.Infeccion;
import uy.transplante.dominio.Medicacion;
import uy.transplante.dominio.TrasplanteComplicacionesInf;

public class IUComplicacionesInfVerModificar extends JFrame {

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
	private TrasplanteComplicacionesInf complicacion;
	private boolean ver;
	private JLabel jLabelGermen = null;
	private JComboBox jComboBoxGermenes = null;
	private JDesktopPane jDesktopPaneObservaciones = null;
	private JLabel jLabelObservaciones = null;
	private JScrollPane jScrollPaneObservaciones = null;
	private JTextArea jTextAreaObservaciones = null;
	

	/**
	 * This is the default constructor
	 */
	public IUComplicacionesInfVerModificar(TrasplanteComplicacionesInf complicacion, boolean ver) {
		super();
		this.complicacion = complicacion;
		this.ver = ver;
		initialize();
		cargarDatos();
		cargarComplicacion();
	}

	private void cargarComplicacion(){
		this.jDateChooserFecha.setCalendar(this.complicacion.getFecha());
		this.jCheckBoxInternado.setSelected(this.complicacion.isInternado());
		this.jTextFieldDias.setText(Integer.toString(this.complicacion.getDiasInternado()));
		this.jComboBoxMedicacion.setSelectedItem(this.complicacion.getMedicacion());
		this.jComboBoxTipo.setSelectedItem(this.complicacion.getInfeccion());
		this.jComboBoxGermenes.setSelectedItem(this.complicacion.getGermen());
		if(!this.complicacion.isEvolucion()){
			this.jCheckBoxInternado.setEnabled(false);
			this.jTextFieldDias.setEnabled(false);
		}
		this.jTextAreaObservaciones.setText(this.complicacion.getComentario());
	}
	private void cargarDatos(){
		ArrayList<Medicacion> medicaciones = Fachada.getInstancia().obtenerTodasMedicaciones();
		for(int x=0;x<medicaciones.size();x++){
			this.jComboBoxMedicacion.addItem(medicaciones.get(x));
		}
		ArrayList<Infeccion> tipos = Fachada.getInstancia().obtenerTodasInfecciones();
		for (int x = 0; x < tipos.size(); x++) {
			this.jComboBoxTipo.addItem(tipos.get(x));
		}
		ArrayList<Germenes> tiposGermen = Fachada.getInstancia().obtenerTodosGermenes();
		for (int x = 0; x < tiposGermen.size(); x++) {
			this.jComboBoxGermenes.addItem(tiposGermen.get(x));
		}
		if(this.ver){
			this.jButtonGuardar.setVisible(false);
		}else{
			this.jButtonGuardar.setVisible(true);
		}
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(426, 491);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		if(this.ver){
			this.setTitle("Ver Complicacion No Infecciosa");
		}else{
			this.setTitle("Modificar Complicacion No Infecciosa");
		}
		
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelGermen = new JLabel();
			jLabelGermen.setBounds(new Rectangle(18, 218, 140, 24));
			jLabelGermen.setText("Germen:");
			jLabelTipo = new JLabel();
			jLabelTipo.setBounds(new Rectangle(19, 137, 135, 29));
			jLabelTipo.setText("Lugar de infeccion:");
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
			jContentPane.add(jLabelGermen, null);
			jContentPane.add(getJComboBoxGermenes(), null);
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
			jButtonSalir.setBounds(new Rectangle(12, 413, 116, 36));
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
			jButtonGuardar.setBounds(new Rectangle(279, 413, 116, 36));
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
		if (this.jDateChooserFecha.getCalendar() != null) {
			TrasplanteComplicacionesInf tnf = new TrasplanteComplicacionesInf();
			tnf.setId(this.complicacion.getId());
			tnf.setIdPretrasplante(this.complicacion.getIdPretrasplante());
			tnf.setEvolucion(this.complicacion.isEvolucion());
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
			tnf.setInfeccion((Infeccion) this.jComboBoxTipo.getSelectedItem());
			tnf.setGermen((Germenes)this.jComboBoxGermenes.getSelectedItem());
			tnf.setComentario(this.jTextAreaObservaciones.getText());
			Fachada.getInstancia().guardarComplicacionInf(tnf);
			this.salir();
		}
	}
	
	private void salir(){
		this.dispose();
	}

	/**
	 * This method initializes jComboBoxGermenes	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxGermenes() {
		if (jComboBoxGermenes == null) {
			jComboBoxGermenes = new JComboBox();
			jComboBoxGermenes.setBounds(new Rectangle(17, 251, 379, 31));
		}
		return jComboBoxGermenes;
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
			jDesktopPaneObservaciones.setBounds(new Rectangle(17, 298, 378, 105));
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
}  //  @jve:decl-index=0:visual-constraint="10,10"
