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

import uy.transplante.dominio.EvolucionTrasplanteEcoCardio;

import logica.Fachada;

import com.toedter.calendar.JDateChooser;


public class IUEvolucionEcoCardioManejar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelFecha = null;
	private JDateChooser jDateChooserFecha = null;
	private JCheckBox jCheckBoxFEVI = null;
	private JCheckBox jCheckBoxInsuf_Hipodiast = null;
	private JCheckBox jCheckBoxI_Ao = null;
	private JCheckBox jCheckBoxE_Ao = null;
	private JButton jButtonSalir = null;
	private JButton jButtonGuardar = null;
	private int idTrasplante;
	private JCheckBox jCheckBoxIM = null;
	private JCheckBox jCheckBoxEM = null;
	private JCheckBox jCheckBoxIP = null;
	private JCheckBox jCheckBoxEP = null;
	private JCheckBox jCheckBoxIT = null;
	private JCheckBox jCheckBoxET = null;
	private JCheckBox jCheckBoxDerrame = null;
	private JCheckBox jCheckBoxCalcif_valvular = null;
	private JCheckBox jCheckBoxHVI = null;

	/**
	 * This is the default constructor
	 */
	public IUEvolucionEcoCardioManejar(int idTrasplante,EvolucionTrasplanteEcoCardio e, Calendar fecha) {
		super();
		initialize();
		this.jDateChooserFecha.setCalendar(fecha);
		this.jDateChooserFecha.setEnabled(false);
		this.idTrasplante = idTrasplante;
		if(e!=null){
			this.cargarDatos(e);
		}
	}
	
	public IUEvolucionEcoCardioManejar(int idTrasplante,EvolucionTrasplanteEcoCardio e, Calendar fecha, boolean ver) {
		super();
		initialize();
		this.jDateChooserFecha.setCalendar(fecha);
		this.jDateChooserFecha.setEnabled(false);
		this.idTrasplante = idTrasplante;
		this.jButtonGuardar.setVisible(false);
		if(e!=null){
			this.cargarDatos(e);
		}
	}
	
	private void cargarDatos(EvolucionTrasplanteEcoCardio e){
		this.jCheckBoxE_Ao.setSelected(e.isEAo());
		this.jCheckBoxFEVI.setSelected(e.isFeviNormal());
		this.jCheckBoxInsuf_Hipodiast.setSelected(e.isInsufHipodiast());
		this.jCheckBoxI_Ao.setSelected(e.isIAo());
		this.jCheckBoxIM.setSelected(e.isIM());
		this.jCheckBoxEM.setSelected(e.isEM());
		this.jCheckBoxIP.setSelected(e.isIP());
		this.jCheckBoxEP.setSelected(e.isEP());
		this.jCheckBoxIT.setSelected(e.isIT());
		this.jCheckBoxET.setSelected(e.isET());
		this.jCheckBoxDerrame.setSelected(e.isDerrame());
		this.jCheckBoxCalcif_valvular.setSelected(e.isCalcifValvular());
		this.getJCheckBoxHVI().setSelected(e.isHvi());
	}


	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(530, 520);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Evolucion EcoCardiograma");
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
			jContentPane.add(getJCheckBoxFEVI(), null);
			jContentPane.add(getJCheckBoxInsuf_Hipodiast(), null);
			jContentPane.add(getJCheckBoxI_Ao(), null);
			jContentPane.add(getJCheckBoxE_Ao(), null);
			jContentPane.add(getJButtonSalir(), null);
			jContentPane.add(getJButtonGuardar(), null);
			jContentPane.add(getJCheckBoxIM(), null);
			jContentPane.add(getJCheckBoxEM(), null);
			jContentPane.add(getJCheckBoxIP(), null);
			jContentPane.add(getJCheckBoxEP(), null);
			jContentPane.add(getJCheckBoxIT(), null);
			jContentPane.add(getJCheckBoxET(), null);
			jContentPane.add(getJCheckBoxDerrame(), null);
			jContentPane.add(getJCheckBoxCalcif_valvular(), null);
			jContentPane.add(getJCheckBoxHVI(), null);
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
	 * This method initializes jCheckBoxFEVI	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxFEVI() {
		if (jCheckBoxFEVI == null) {
			jCheckBoxFEVI = new JCheckBox();
			jCheckBoxFEVI.setBounds(new Rectangle(50, 71, 193, 36));
			jCheckBoxFEVI.setText("FEVI > 55");
			jCheckBoxFEVI.setBackground(new Color(204, 255, 204));
		}
		return jCheckBoxFEVI;
	}

	/**
	 * This method initializes jCheckBoxInsuf_Hipodiast	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxInsuf_Hipodiast() {
		if (jCheckBoxInsuf_Hipodiast == null) {
			jCheckBoxInsuf_Hipodiast = new JCheckBox();
			jCheckBoxInsuf_Hipodiast.setBounds(new Rectangle(269, 72, 199, 36));
			jCheckBoxInsuf_Hipodiast.setText("Insuficiencia Hipodiastica");
			jCheckBoxInsuf_Hipodiast.setBackground(new Color(204, 255, 204));
		}
		return jCheckBoxInsuf_Hipodiast;
	}

	/**
	 * This method initializes jCheckBoxI_Ao	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxI_Ao() {
		if (jCheckBoxI_Ao == null) {
			jCheckBoxI_Ao = new JCheckBox();
			jCheckBoxI_Ao.setBounds(new Rectangle(42, 121, 191, 42));
			jCheckBoxI_Ao.setText("I Ao");
			jCheckBoxI_Ao.setBackground(new Color(204, 255, 204));
		}
		return jCheckBoxI_Ao;
	}

	/**
	 * This method initializes jCheckBoxE_Ao	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxE_Ao() {
		if (jCheckBoxE_Ao == null) {
			jCheckBoxE_Ao = new JCheckBox();
			jCheckBoxE_Ao.setBounds(new Rectangle(269, 121, 195, 43));
			jCheckBoxE_Ao.setText("E Ao");
			jCheckBoxE_Ao.setBackground(new Color(204, 255, 204));
		}
		return jCheckBoxE_Ao;
	}

	/**
	 * This method initializes jButtonSalir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSalir() {
		if (jButtonSalir == null) {
			jButtonSalir = new JButton();
			jButtonSalir.setBounds(new Rectangle(45, 433, 151, 34));
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
			jButtonGuardar.setBounds(new Rectangle(258, 434, 165, 32));
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
		EvolucionTrasplanteEcoCardio e = new EvolucionTrasplanteEcoCardio();
		e.setFecha(this.jDateChooserFecha.getCalendar());
		e.setEAo(this.jCheckBoxE_Ao.isSelected());
		e.setFeviNormal(this.jCheckBoxFEVI.isSelected());
		e.setInsufHipodiast(this.jCheckBoxInsuf_Hipodiast.isSelected());
		e.setIAo(this.jCheckBoxI_Ao.isSelected());
		e.setIM(this.jCheckBoxIM.isSelected());
		e.setEM(this.jCheckBoxEM.isSelected());
		e.setIP(this.jCheckBoxIP.isSelected());
		e.setEP(this.jCheckBoxEP.isSelected());
		e.setIT(this.jCheckBoxIT.isSelected());
		e.setET(this.jCheckBoxET.isSelected());
		e.setHvi(this.getJCheckBoxHVI().isSelected());
		e.setDerrame(this.jCheckBoxDerrame.isSelected());
		e.setCalcifValvular(this.jCheckBoxCalcif_valvular.isSelected());
		e.setIdTrasplante(this.idTrasplante);
		Fachada.getInstancia().guardarEvolucionEcoCardio(e);
		this.salir();
	}
	
	private void salir(){
		this.dispose();
	}

	/**
	 * This method initializes jCheckBoxIM	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxIM() {
		if (jCheckBoxIM == null) {
			jCheckBoxIM = new JCheckBox();
			jCheckBoxIM.setBounds(new Rectangle(42, 171, 191, 42));
			jCheckBoxIM.setText("I M");
			jCheckBoxIM.setBackground(new Color(204, 255, 204));
		}
		return jCheckBoxIM;
	}

	/**
	 * This method initializes jCheckBoxEM	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxEM() {
		if (jCheckBoxEM == null) {
			jCheckBoxEM = new JCheckBox();
			jCheckBoxEM.setBounds(new Rectangle(269, 171, 195, 43));
			jCheckBoxEM.setText("E M");
			jCheckBoxEM.setBackground(new Color(204, 255, 204));
		}
		return jCheckBoxEM;
	}

	/**
	 * This method initializes jCheckBoxIP	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxIP() {
		if (jCheckBoxIP == null) {
			jCheckBoxIP = new JCheckBox();
			jCheckBoxIP.setBounds(new Rectangle(42, 221, 191, 42));
			jCheckBoxIP.setText("I P");
			jCheckBoxIP.setBackground(new Color(204, 255, 204));
		}
		return jCheckBoxIP;
	}

	/**
	 * This method initializes jCheckBoxEP	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxEP() {
		if (jCheckBoxEP == null) {
			jCheckBoxEP = new JCheckBox();
			jCheckBoxEP.setBounds(new Rectangle(269, 221, 195, 43));
			jCheckBoxEP.setText("E P");
			jCheckBoxEP.setBackground(new Color(204, 255, 204));
		}
		return jCheckBoxEP;
	}

	/**
	 * This method initializes jCheckBoxIT	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxIT() {
		if (jCheckBoxIT == null) {
			jCheckBoxIT = new JCheckBox();
			jCheckBoxIT.setBounds(new Rectangle(42, 271, 191, 42));
			jCheckBoxIT.setText("I T");
			jCheckBoxIT.setBackground(new Color(204, 255, 204));
		}
		return jCheckBoxIT;
	}

	/**
	 * This method initializes jCheckBoxET	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxET() {
		if (jCheckBoxET == null) {
			jCheckBoxET = new JCheckBox();
			jCheckBoxET.setBounds(new Rectangle(269, 271, 195, 43));
			jCheckBoxET.setText("E T");
			jCheckBoxET.setBackground(new Color(204, 255, 204));
		}
		return jCheckBoxET;
	}

	/**
	 * This method initializes jCheckBoxDerrame	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxDerrame() {
		if (jCheckBoxDerrame == null) {
			jCheckBoxDerrame = new JCheckBox();
			jCheckBoxDerrame.setBounds(new Rectangle(42, 321, 191, 42));
			jCheckBoxDerrame.setText("Derrame");
			jCheckBoxDerrame.setBackground(new Color(204, 255, 204));
		}
		return jCheckBoxDerrame;
	}

	/**
	 * This method initializes jCheckBoxCalcif_valvular	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxCalcif_valvular() {
		if (jCheckBoxCalcif_valvular == null) {
			jCheckBoxCalcif_valvular = new JCheckBox();
			jCheckBoxCalcif_valvular.setBounds(new Rectangle(269, 321, 195, 43));
			jCheckBoxCalcif_valvular.setText("Calcificacion valvular");
			jCheckBoxCalcif_valvular.setBackground(new Color(204, 255, 204));
		}
		return jCheckBoxCalcif_valvular;
	}

	/**
	 * This method initializes jCheckBoxHVI	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxHVI() {
		if (jCheckBoxHVI == null) {
			jCheckBoxHVI = new JCheckBox();
			jCheckBoxHVI.setBounds(new Rectangle(269, 376, 195, 43));
			jCheckBoxHVI.setText("H V I");
			jCheckBoxHVI.setBackground(new Color(204, 255, 204));
		}
		return jCheckBoxHVI;
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
