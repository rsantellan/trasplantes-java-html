package iu.trasplante;

import iu.donante.IUDonanteModificar;
import iu.paciente.IUPacienteModificar;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.toedter.calendar.JDateChooser;

import dominio.Paciente;
import dominio.PacientePreTrasplante;
import dominio.Trasplante;

public class IUTrasplanteManejar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelNombreReceptor = null;
	private JButton jButtonDatosReceptor = null;
	private JLabel jLabelDatosDonante = null;
	private JButton jButtonDatosDonante = null;
	private JLabel jLabelFechaTrasplante = null;
	private JDateChooser jDateChooserFechaTrasplante = null;
	private JLabel jLabelNumeroTrasplante = null;
	private JTextField jTextFieldNumTrasplante = null;
	private JButton jButtonCambiarDonante = null;
	private JCheckBox jCheckBoxInestabHemo = null;
	private JLabel jLabelRinhon = null;
	private JComboBox jComboBoxRinhon = null;
	private JCheckBox jCheckBoxAnomaliaVasc = null;
	private JLabel jLabelNumArterias = null;
	private JComboBox jComboBoxNumArterias = null;
	private JLabel jLabelNumVenas = null;
	private JComboBox jComboBoxNumVenas = null;
	private JLabel jLabelUreter = null;
	private JComboBox jComboBoxUreter = null;
	private JLabel jLabelNumCompatibilidadAB = null;
	private JTextField jTextFieldNumCompatibilidadAB = null;
	private JLabel jLabelNumCompatibilidadDR = null;
	private JTextField jTextFieldNumCompatibilidadDR = null;
	private JLabel jLabelNumInCompatibilidadAB = null;
	private JTextField jTextFieldNumIncompatibilidadAB = null;
	private JLabel jLabelNumIncompatibilidadDR = null;
	private JTextField jTextFieldNumIncompatibilidadDR = null;
	private JCheckBox jCheckBoxAutoAc = null;
	private JLabel jLabelPraMax = null;
	private JTextField jTextFieldPRAMax = null;
	private JLabel jLabelPraTR = null;
	private JTextField jTextFieldPRATR = null;
	private JCheckBox jCheckBoxTransPrevia = null;
	private JLabel jLabelNumTrans = null;
	private JTextField jTextFieldNumTrans = null;
	private JLabel jLabelEmbarazo = null;
	private JComboBox jComboBoxEmbarazo = null;
	private JLabel jLabelNumEmbarazo = null;
	private JTextField jTextFieldNumEmbarazo = null;
	private JLabel jLabelLiqPerfusion = null;
	private JComboBox jComboBoxLiqPerfusion = null;
	private JCheckBox jCheckBoxTQDeBanco = null;
	private JLabel jLabelLadoImplante = null;
	private JComboBox jComboBoxLadoImplante = null;
	private JLabel jLabelAnastVenosa = null;
	private JComboBox jComboBoxAnastVenosa = null;
	private JLabel jLabelAnastArterial = null;
	private JComboBox jComboBoxAnastArterial = null;
	private JLabel jLabelAnastUterial = null;
	private JComboBox jComboBoxAnastUterial = null;
	private JLabel jLabelTisqcalmin = null;
	private JTextField jTextFieldTisqCalMin = null;
	private JLabel jLabelTisqFriqHs = null;
	private JTextField jTextFieldTisqFriqHs = null;
	private JLabel jLabelTisqFriaMin = null;
	private JTextField jTextFieldTisqFriaMin = null;
	private JLabel jLabelTisqTibiaHs = null;
	private JTextField jTextFieldTisqTibiaHs = null;
	private JLabel jLabelRepercusion = null;
	private JComboBox jComboBoxRepercusion = null;
	private JCheckBox jCheckBoxSangradoIOP = null;
	private JCheckBox jCheckBoxLesionArterial = null;
	private JCheckBox jCheckBoxLesionVenosa = null;
	private JCheckBox jCheckBoxNecesidadRepenfundir = null;
	private JLabel jLabelOtrasComplicacionesQ = null;
	private JTextArea jTextAreaOtrasComplicacionesQuirurgicas = null;
	private JCheckBox jCheckBoxDiuresisIOP = null;
	private JLabel jLabelCrInicial = null;
	private JTextField jTextFieldCrInicial = null;
	private JLabel jLabelDiasRecDiuresis = null;
	private JTextField jTextFieldDiaRecDiuresis = null;
	private JLabel jLabelDiasRecFuncional = null;
	private JTextField jTextFieldDiaRecFuncional = null;
	private JButton jButtonGuardar = null;
	private Trasplante trasplante;
	private IUTrasplanteManejar2 iuIngresar;
	private JButton jButtonSiguiente = null;
	private JDesktopPane jDesktopPaneDato7 = null;
	private JDesktopPane jDesktopPane = null;
	private JDesktopPane jDesktopDato5 = null;
	private JDesktopPane jDesktopPaneDatos3 = null;
	private JDesktopPane jDesktopPaneDatos2 = null;
	private JDesktopPane jDesktopPaneDatos1 = null;

	private boolean ver;
	private JScrollPane jScrollPaneOComplicacionesQuirurgicas = null;
	private Paciente p;
	private PacientePreTrasplante pt;
	private JLabel jLabelEdad = null;

	/**
	 * This is the default constructor
	 */
	public IUTrasplanteManejar(Paciente p, PacientePreTrasplante pt, boolean ver) {
		super();
		this.trasplante = pt.getTrasplante();
		this.p = p;
		this.pt = pt;
		this.ver = ver;
		initialize();
		cargarDatosFijos();
		cargarDatosTrasplante();
		if (this.ver) {
			this.jButtonCambiarDonante.setVisible(false);
		}
	}

	public boolean isVer() {
		return this.ver;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(982, 718);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		if (this.ver) {
			this.setTitle("Ver trasplante");
		} else {
			this.setTitle("Insertar/Modificar trasplante");
		}

	}

	public void salir() {
		this.dispose();
	}

	public Trasplante devolverTrasplante() {
		return this.pt.getTrasplante();
	}

	public void cargarTrasplante(Trasplante t) {
		this.trasplante = t;
		this.cargarDatosTrasplante();
	}

	private void cargarDatosTrasplante() {
		this.jLabelNombreReceptor.setText("Receptor:" + this.p.toString());
		if (this.trasplante.getId() == 0) {
			this.jLabelEdad.setVisible(false);
		} else {
			this.jLabelEdad.setVisible(true);
			this.jLabelEdad.setText("Edad del receptor: "
					+ this.p.calcularEdad(this.trasplante.getFecha())
					+ " a�os.");
		}
		if (this.trasplante != null) {
			if (this.trasplante.getDonante().getId().equalsIgnoreCase("")) {
				this.jLabelDatosDonante.setText("Donante: ----");
			} else {
				this.jLabelDatosDonante.setText("Donante:"
						+ this.trasplante.getDonante().toString());
			}
			this.jTextFieldNumTrasplante.setText(Integer
					.toString(this.trasplante.getNumTr()));
			this.jDateChooserFechaTrasplante.setCalendar(this.trasplante
					.getFecha());
			this.jComboBoxRinhon.setSelectedItem(this.trasplante.getRinhon());
			this.jComboBoxNumArterias.setSelectedItem(this.trasplante
					.getNumArt());
			this.jComboBoxNumVenas.setSelectedItem(this.trasplante
					.getNumVenas());
			this.jComboBoxUreter.setSelectedItem(this.trasplante.getUreter());
			this.jTextFieldNumCompatibilidadAB.setText(Integer
					.toString(this.trasplante.getNumCompAB()));
			this.jTextFieldNumCompatibilidadDR.setText(Integer
					.toString(this.trasplante.getNumCompDR()));
			this.jTextFieldNumIncompatibilidadAB.setText(Integer
					.toString(this.trasplante.getNumIncompAB()));
			this.jTextFieldNumIncompatibilidadDR.setText(Integer
					.toString(this.trasplante.getNumIncompDR()));
			this.jTextFieldPRAMax.setText(this.trasplante.getPraMax());
			this.jTextFieldPRATR.setText(this.trasplante.getPraTR());
			this.jCheckBoxTransPrevia.setSelected(this.trasplante
					.isTransPrevias());
			this.jTextFieldNumTrans.setText(Integer.toString(this.trasplante
					.getNumTransf()));
			this.jComboBoxEmbarazo.setSelectedItem(this.trasplante
					.getEmbarazo());
			this.jTextFieldNumEmbarazo.setText(Integer.toString(this.trasplante
					.getNumEmbarazo()));
			this.jComboBoxLiqPerfusion.setSelectedItem(this.trasplante
					.getLiqPerfusion());
			this.jComboBoxLadoImplante.setSelectedItem(this.trasplante
					.getLadoImplante());
			this.jComboBoxAnastVenosa.setSelectedItem(this.trasplante
					.getAnastVenosa());
			this.jComboBoxAnastArterial.setSelectedItem(this.trasplante
					.getAnastArterial());
			this.jComboBoxAnastUterial.setSelectedItem(this.trasplante
					.getAnastUterial());
			this.jTextFieldTisqCalMin.setText(Integer.toString(this.trasplante
					.getTIsqCalMin()));
			this.jTextFieldTisqFriqHs.setText(Integer.toString(this.trasplante
					.getTIsqFriqHs()));
			this.jTextFieldTisqFriaMin.setText(Integer.toString(this.trasplante
					.getTIsqFriaMin()));
			this.jTextFieldTisqTibiaHs.setText(Integer.toString(this.trasplante
					.getTIsqTibiaHs()));
			this.jComboBoxRepercusion.setSelectedItem(this.trasplante
					.getRepercusion());
			this.jCheckBoxSangradoIOP.setSelected(this.trasplante
					.isSangradoIOp());
			this.jCheckBoxLesionArterial.setSelected(this.trasplante
					.isLesionArterial());
			this.jCheckBoxTQDeBanco.setSelected(this.trasplante.isTqDeBanco());
			this.jCheckBoxAutoAc.setSelected(this.trasplante.isAutoac());
			this.jCheckBoxDiuresisIOP.setSelected(this.trasplante
					.isDiuresisIOp());
			this.jCheckBoxAnomaliaVasc.setSelected(this.trasplante
					.isAnomaliaVasc());
			this.jCheckBoxInestabHemo.setSelected(this.trasplante
					.isInstabHemod());
			this.jCheckBoxLesionVenosa.setSelected(this.trasplante
					.isLesionVenosa());
			this.jCheckBoxNecesidadRepenfundir.setSelected(this.trasplante
					.isNecesidadRepefundir());
			this.jTextAreaOtrasComplicacionesQuirurgicas
					.setText(this.trasplante
							.getOtrasComplicacionesQuirurgicas());
			this.jTextFieldCrInicial.setText(Float.toString(this.trasplante
					.getCrInicial()));
			this.jTextFieldDiaRecDiuresis.setText(Integer
					.toString(this.trasplante.getDiaRecDiuresis()));
			this.jTextFieldDiaRecFuncional.setText(Integer
					.toString(this.trasplante.getDiaRecFuncional()));

		}
	}

	private void cargarDatosFijos() {
		String aux;
		// Ri�on
		aux = "Derecho";
		this.jComboBoxRinhon.addItem(aux);
		aux = "Izquierdo";
		this.jComboBoxRinhon.addItem(aux);
		// Numero Arterias y Numero de Venas
		int auxInt;
		auxInt = 1;
		this.jComboBoxNumArterias.addItem(auxInt);
		this.jComboBoxNumVenas.addItem(auxInt);
		auxInt = 2;
		this.jComboBoxNumArterias.addItem(auxInt);
		this.jComboBoxNumVenas.addItem(auxInt);
		auxInt = 3;
		this.jComboBoxNumArterias.addItem(auxInt);
		this.jComboBoxNumVenas.addItem(auxInt);
		// Ureter
		aux = "Unico";
		this.jComboBoxUreter.addItem(aux);
		aux = "Doble";
		this.jComboBoxUreter.addItem(aux);
		// Embarazo
		aux = "si";
		this.jComboBoxEmbarazo.addItem(aux);
		aux = "no";
		this.jComboBoxEmbarazo.addItem(aux);
		aux = "no aplica";
		this.jComboBoxEmbarazo.addItem(aux);
		// Liquido Perfusion
		aux = "Eurocollins";
		this.jComboBoxLiqPerfusion.addItem(aux);
		aux = "WC";
		this.jComboBoxLiqPerfusion.addItem(aux);
		aux = "Custodiol";
		this.jComboBoxLiqPerfusion.addItem(aux);
		aux = "Otro";
		this.jComboBoxLiqPerfusion.addItem(aux);
		// Lado Implante
		aux = "Derecho";
		this.jComboBoxLadoImplante.addItem(aux);
		aux = "Izquierdo";
		this.jComboBoxLadoImplante.addItem(aux);
		// Anast Venosa y
		aux = "Termino lateral";
		this.jComboBoxAnastArterial.addItem(aux);
		this.jComboBoxAnastVenosa.addItem(aux);
		aux = "Termino terminal";
		this.jComboBoxAnastArterial.addItem(aux);
		this.jComboBoxAnastVenosa.addItem(aux);
		aux = "otra";
		this.jComboBoxAnastArterial.addItem(aux);
		this.jComboBoxAnastVenosa.addItem(aux);
		// Anast Uterial
		aux = "Alferez";
		this.jComboBoxAnastUterial.addItem(aux);
		aux = "Taguchi";
		this.jComboBoxAnastUterial.addItem(aux);
		aux = "Gregoire";
		this.jComboBoxAnastUterial.addItem(aux);
		aux = "Lick";
		this.jComboBoxAnastUterial.addItem(aux);
		aux = "Otra";
		this.jComboBoxAnastUterial.addItem(aux);
		// Repercusion
		aux = "buena";
		this.jComboBoxRepercusion.addItem(aux);
		aux = "regular";
		this.jComboBoxRepercusion.addItem(aux);
		aux = "mala";
		this.jComboBoxRepercusion.addItem(aux);

	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelEdad = new JLabel();
			jLabelEdad.setBounds(new Rectangle(456, 17, 154, 30));
			jLabelEdad.setText("Edad :");
			jLabelDiasRecFuncional = new JLabel();
			jLabelDiasRecFuncional.setText("Dias Rec Funcional :");
			jLabelDiasRecFuncional.setBounds(new Rectangle(2, 85, 123, 23));
			jLabelDiasRecDiuresis = new JLabel();
			jLabelDiasRecDiuresis.setText("Dias Rec Diuresis :");
			jLabelDiasRecDiuresis.setBounds(new Rectangle(2, 50, 108, 27));
			jLabelCrInicial = new JLabel();
			jLabelCrInicial.setText("Cr Inicial :");
			jLabelCrInicial.setBounds(new Rectangle(2, 16, 67, 27));
			jLabelOtrasComplicacionesQ = new JLabel();
			jLabelOtrasComplicacionesQ
					.setText("Otras Complicaciones Quirurgicas :");
			jLabelOtrasComplicacionesQ
					.setBounds(new Rectangle(9, 141, 204, 27));
			jLabelRepercusion = new JLabel();
			jLabelRepercusion.setText("Reperfusion :");
			jLabelRepercusion.setBounds(new Rectangle(4, 131, 93, 29));
			jLabelTisqTibiaHs = new JLabel();
			jLabelTisqTibiaHs.setText("T Isq Tibia Hs :");
			jLabelTisqTibiaHs.setBounds(new Rectangle(5, 99, 86, 27));
			jLabelTisqFriaMin = new JLabel();
			jLabelTisqFriaMin.setText("T Isq Fria min :");
			jLabelTisqFriaMin.setBounds(new Rectangle(6, 67, 93, 26));
			jLabelTisqFriqHs = new JLabel();
			jLabelTisqFriqHs.setText("T Isq Fri q Hs :");
			jLabelTisqFriqHs.setBounds(new Rectangle(6, 36, 101, 27));
			jLabelTisqcalmin = new JLabel();
			jLabelTisqcalmin.setText("T Isq cal Min :");
			jLabelTisqcalmin.setBounds(new Rectangle(7, 6, 88, 28));
			jLabelAnastUterial = new JLabel();
			jLabelAnastUterial.setText("Anast Ureteral :");
			jLabelAnastUterial.setBounds(new Rectangle(5, 253, 93, 24));
			jLabelAnastArterial = new JLabel();
			jLabelAnastArterial.setText("Anast Arterial :");
			jLabelAnastArterial.setBounds(new Rectangle(4, 221, 103, 27));
			jLabelAnastVenosa = new JLabel();
			jLabelAnastVenosa.setText("Anast Venosa :");
			jLabelAnastVenosa.setBounds(new Rectangle(3, 190, 101, 26));
			jLabelLadoImplante = new JLabel();
			jLabelLadoImplante.setText("Lado Implante :");
			jLabelLadoImplante.setBounds(new Rectangle(3, 159, 102, 27));
			jLabelLiqPerfusion = new JLabel();
			jLabelLiqPerfusion.setText("Liquido Perfusion :");
			jLabelLiqPerfusion.setBounds(new Rectangle(2, 127, 112, 28));
			jLabelNumEmbarazo = new JLabel();
			jLabelNumEmbarazo.setText("N� Embarazo :");
			jLabelNumEmbarazo.setBounds(new Rectangle(8, 159, 103, 21));
			jLabelEmbarazo = new JLabel();
			jLabelEmbarazo.setText("Embarazo :");
			jLabelEmbarazo.setBounds(new Rectangle(9, 126, 74, 23));
			jLabelNumTrans = new JLabel();
			jLabelNumTrans.setText("Num Transf :");
			jLabelNumTrans.setBounds(new Rectangle(10, 95, 75, 26));
			jLabelPraTR = new JLabel();
			jLabelPraTR.setText("PRA TR :");
			jLabelPraTR.setBounds(new Rectangle(11, 35, 59, 24));
			jLabelPraMax = new JLabel();
			jLabelPraMax.setText("PRA Max :");
			jLabelPraMax.setBounds(new Rectangle(11, 5, 67, 26));
			jLabelNumIncompatibilidadDR = new JLabel();
			jLabelNumIncompatibilidadDR.setText("N� Compatibilidad DR :");
			jLabelNumIncompatibilidadDR
					.setBounds(new Rectangle(3, 108, 133, 23));
			jLabelNumInCompatibilidadAB = new JLabel();
			jLabelNumInCompatibilidadAB.setText("N� Incompatibilidad AB :");
			jLabelNumInCompatibilidadAB
					.setBounds(new Rectangle(2, 73, 139, 28));
			jLabelNumCompatibilidadDR = new JLabel();
			jLabelNumCompatibilidadDR.setText("N� Compatibilidad DR :");
			jLabelNumCompatibilidadDR.setBounds(new Rectangle(3, 42, 135, 25));
			jLabelNumCompatibilidadAB = new JLabel();
			jLabelNumCompatibilidadAB.setText("N� Compatibilidad AB :");
			jLabelNumCompatibilidadAB.setBounds(new Rectangle(4, 9, 132, 25));
			jLabelUreter = new JLabel();
			jLabelUreter.setText("Ureter :");
			jLabelUreter.setBounds(new Rectangle(2, 99, 69, 25));
			jLabelNumVenas = new JLabel();
			jLabelNumVenas.setText("N�mero Venas :");
			jLabelNumVenas.setBounds(new Rectangle(2, 70, 133, 25));
			jLabelNumArterias = new JLabel();
			jLabelNumArterias.setText("N�mero Arterias :");
			jLabelNumArterias.setBounds(new Rectangle(2, 40, 133, 25));
			jLabelRinhon = new JLabel();
			jLabelRinhon.setText("Ri�on :");
			jLabelRinhon.setBounds(new Rectangle(3, 8, 67, 26));
			jLabelNumeroTrasplante = new JLabel();
			jLabelNumeroTrasplante.setBounds(new Rectangle(621, 56, 128, 26));
			jLabelNumeroTrasplante.setText("N�mero Trasplante:");
			jLabelFechaTrasplante = new JLabel();
			jLabelFechaTrasplante.setBounds(new Rectangle(619, 19, 128, 26));
			jLabelFechaTrasplante.setText("Fecha del Trasplante:");
			jLabelDatosDonante = new JLabel();
			jLabelDatosDonante.setBounds(new Rectangle(16, 58, 283, 28));
			jLabelDatosDonante.setText("Donante :");
			jLabelNombreReceptor = new JLabel();
			jLabelNombreReceptor.setBounds(new Rectangle(16, 17, 283, 28));
			jLabelNombreReceptor.setText("Receptor :");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 204));
			jContentPane.add(jLabelNombreReceptor, null);
			jContentPane.add(getJButtonDatosReceptor(), null);
			jContentPane.add(jLabelDatosDonante, null);
			jContentPane.add(getJButtonDatosDonante(), null);
			jContentPane.add(jLabelFechaTrasplante, null);
			jContentPane.add(getJDateChooserFechaTrasplante(), null);
			jContentPane.add(jLabelNumeroTrasplante, null);
			jContentPane.add(getJTextFieldNumTrasplante(), null);
			jContentPane.add(getJButtonCambiarDonante(), null);
			jContentPane.add(getJButtonGuardar(), null);
			jContentPane.add(getJButtonSiguiente(), null);
			jContentPane.add(getJDesktopPaneDato7(), null);
			jContentPane.add(getJDesktopPane(), null);
			jContentPane.add(getJDesktopDato5(), null);
			jContentPane.add(getJDesktopPaneDatos3(), null);
			jContentPane.add(getJDesktopPaneDatos2(), null);
			jContentPane.add(getJDesktopPaneDatos1(), null);
			jContentPane.add(jLabelEdad, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButtonDatosReceptor
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonDatosReceptor() {
		if (jButtonDatosReceptor == null) {
			jButtonDatosReceptor = new JButton();
			jButtonDatosReceptor.setBounds(new Rectangle(309, 17, 132, 27));
			jButtonDatosReceptor.setText("Datos Receptor");
			jButtonDatosReceptor
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							mostrarPaciente();
						}
					});
		}
		return jButtonDatosReceptor;
	}

	/**
	 * This method initializes jButtonDatosDonante
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonDatosDonante() {
		if (jButtonDatosDonante == null) {
			jButtonDatosDonante = new JButton();
			jButtonDatosDonante.setBounds(new Rectangle(309, 58, 132, 27));
			jButtonDatosDonante.setText("Datos Donante");
			jButtonDatosDonante
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							mostrarDonante();
						}
					});
		}
		return jButtonDatosDonante;
	}

	/**
	 * This method initializes jDateChooserFechaTrasplante
	 * 
	 * @return com.toedter.calendar.JDateChooser
	 */
	private JDateChooser getJDateChooserFechaTrasplante() {
		if (jDateChooserFechaTrasplante == null) {
			jDateChooserFechaTrasplante = new JDateChooser();
			jDateChooserFechaTrasplante.setBounds(new Rectangle(771, 19, 131,
					27));
		}
		return jDateChooserFechaTrasplante;
	}

	/**
	 * This method initializes jTextFieldNumTrasplante
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldNumTrasplante() {
		if (jTextFieldNumTrasplante == null) {
			jTextFieldNumTrasplante = new JTextField();
			jTextFieldNumTrasplante.setBounds(new Rectangle(772, 55, 131, 27));
		}
		return jTextFieldNumTrasplante;
	}

	/**
	 * This method initializes jButtonCambiarDonante
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCambiarDonante() {
		if (jButtonCambiarDonante == null) {
			jButtonCambiarDonante = new JButton();
			jButtonCambiarDonante.setBounds(new Rectangle(460, 58, 87, 27));
			jButtonCambiarDonante.setText("Cambiar");
			jButtonCambiarDonante
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							cambiarDonante();
						}
					});
		}
		return jButtonCambiarDonante;
	}

	/**
	 * This method initializes jCheckBoxInestabHemo
	 * 
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxInestabHemo() {
		if (jCheckBoxInestabHemo == null) {
			jCheckBoxInestabHemo = new JCheckBox();
			jCheckBoxInestabHemo.setText("Inestab Hemodial");
			jCheckBoxInestabHemo.setBounds(new Rectangle(10, 74, 128, 26));
			jCheckBoxInestabHemo.setBackground(Color.WHITE);
		}
		return jCheckBoxInestabHemo;
	}

	/**
	 * This method initializes jComboBoxRinhon
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxRinhon() {
		if (jComboBoxRinhon == null) {
			jComboBoxRinhon = new JComboBox();
			jComboBoxRinhon.setBounds(new Rectangle(133, 8, 145, 28));
		}
		return jComboBoxRinhon;
	}

	/**
	 * This method initializes jCheckBoxAnomaliaVasc
	 * 
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxAnomaliaVasc() {
		if (jCheckBoxAnomaliaVasc == null) {
			jCheckBoxAnomaliaVasc = new JCheckBox();
			jCheckBoxAnomaliaVasc.setText("Anomalia Vascular");
			jCheckBoxAnomaliaVasc.setBounds(new Rectangle(152, 38, 133, 25));
			jCheckBoxAnomaliaVasc.setBackground(Color.WHITE);
		}
		return jCheckBoxAnomaliaVasc;
	}

	/**
	 * This method initializes jComboBoxNumArterias
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxNumArterias() {
		if (jComboBoxNumArterias == null) {
			jComboBoxNumArterias = new JComboBox();
			jComboBoxNumArterias.setBounds(new Rectangle(147, 40, 133, 25));
		}
		return jComboBoxNumArterias;
	}

	/**
	 * This method initializes jComboBoxNumVenas
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxNumVenas() {
		if (jComboBoxNumVenas == null) {
			jComboBoxNumVenas = new JComboBox();
			jComboBoxNumVenas.setBounds(new Rectangle(146, 68, 133, 25));
		}
		return jComboBoxNumVenas;
	}

	/**
	 * This method initializes jComboBoxUreter
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxUreter() {
		if (jComboBoxUreter == null) {
			jComboBoxUreter = new JComboBox();
			jComboBoxUreter.setBounds(new Rectangle(145, 96, 133, 25));
		}
		return jComboBoxUreter;
	}

	/**
	 * This method initializes jTextFieldNumCompatibilidadAB
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldNumCompatibilidadAB() {
		if (jTextFieldNumCompatibilidadAB == null) {
			jTextFieldNumCompatibilidadAB = new JTextField();
			jTextFieldNumCompatibilidadAB.setBounds(new Rectangle(147, 8, 92,
					27));
		}
		return jTextFieldNumCompatibilidadAB;
	}

	/**
	 * This method initializes jTextFieldNumCompatibilidadDR
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldNumCompatibilidadDR() {
		if (jTextFieldNumCompatibilidadDR == null) {
			jTextFieldNumCompatibilidadDR = new JTextField();
			jTextFieldNumCompatibilidadDR.setBounds(new Rectangle(147, 40, 92,
					27));
		}
		return jTextFieldNumCompatibilidadDR;
	}

	/**
	 * This method initializes jTextFieldNumIncompatibilidadAB
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldNumIncompatibilidadAB() {
		if (jTextFieldNumIncompatibilidadAB == null) {
			jTextFieldNumIncompatibilidadAB = new JTextField();
			jTextFieldNumIncompatibilidadAB.setBounds(new Rectangle(147, 71,
					92, 27));
		}
		return jTextFieldNumIncompatibilidadAB;
	}

	/**
	 * This method initializes jTextFieldNumIncompatibilidadDR
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldNumIncompatibilidadDR() {
		if (jTextFieldNumIncompatibilidadDR == null) {
			jTextFieldNumIncompatibilidadDR = new JTextField();
			jTextFieldNumIncompatibilidadDR.setBounds(new Rectangle(147, 104,
					92, 27));
		}
		return jTextFieldNumIncompatibilidadDR;
	}

	/**
	 * This method initializes jCheckBoxAutoAc
	 * 
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxAutoAc() {
		if (jCheckBoxAutoAc == null) {
			jCheckBoxAutoAc = new JCheckBox();
			jCheckBoxAutoAc.setText("Anticuerpos preformados");
			jCheckBoxAutoAc.setBounds(new Rectangle(8, 190, 209, 26));
			jCheckBoxAutoAc.setBackground(Color.WHITE);
		}
		return jCheckBoxAutoAc;
	}

	/**
	 * This method initializes jTextFieldPRAMax
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldPRAMax() {
		if (jTextFieldPRAMax == null) {
			jTextFieldPRAMax = new JTextField();
			jTextFieldPRAMax.setBounds(new Rectangle(115, 6, 105, 25));
		}
		return jTextFieldPRAMax;
	}

	/**
	 * This method initializes jTextFieldPRATR
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldPRATR() {
		if (jTextFieldPRATR == null) {
			jTextFieldPRATR = new JTextField();
			jTextFieldPRATR.setBounds(new Rectangle(115, 37, 105, 25));
		}
		return jTextFieldPRATR;
	}

	/**
	 * This method initializes jCheckBoxTransPrevia
	 * 
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxTransPrevia() {
		if (jCheckBoxTransPrevia == null) {
			jCheckBoxTransPrevia = new JCheckBox();
			jCheckBoxTransPrevia.setText("Transf Previa");
			jCheckBoxTransPrevia.setBounds(new Rectangle(9, 64, 104, 28));
			jCheckBoxTransPrevia.setBackground(Color.WHITE);
		}
		return jCheckBoxTransPrevia;
	}

	/**
	 * This method initializes jTextFieldNumTrans
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldNumTrans() {
		if (jTextFieldNumTrans == null) {
			jTextFieldNumTrans = new JTextField();
			jTextFieldNumTrans.setBounds(new Rectangle(115, 95, 105, 25));
		}
		return jTextFieldNumTrans;
	}

	/**
	 * This method initializes jComboBoxEmbarazo
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxEmbarazo() {
		if (jComboBoxEmbarazo == null) {
			jComboBoxEmbarazo = new JComboBox();
			jComboBoxEmbarazo.setBounds(new Rectangle(93, 125, 128, 25));
		}
		return jComboBoxEmbarazo;
	}

	/**
	 * This method initializes jTextFieldNumEmbarazo
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldNumEmbarazo() {
		if (jTextFieldNumEmbarazo == null) {
			jTextFieldNumEmbarazo = new JTextField();
			jTextFieldNumEmbarazo.setBounds(new Rectangle(115, 156, 105, 25));
		}
		return jTextFieldNumEmbarazo;
	}

	/**
	 * This method initializes jComboBoxLiqPerfusion
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxLiqPerfusion() {
		if (jComboBoxLiqPerfusion == null) {
			jComboBoxLiqPerfusion = new JComboBox();
			jComboBoxLiqPerfusion.setBounds(new Rectangle(144, 126, 135, 25));
		}
		return jComboBoxLiqPerfusion;
	}

	/**
	 * This method initializes jCheckBoxTQDeBanco
	 * 
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxTQDeBanco() {
		if (jCheckBoxTQDeBanco == null) {
			jCheckBoxTQDeBanco = new JCheckBox();
			jCheckBoxTQDeBanco.setText("TQ de Banco");
			jCheckBoxTQDeBanco.setBounds(new Rectangle(10, 38, 108, 28));
			jCheckBoxTQDeBanco.setBackground(Color.WHITE);
		}
		return jCheckBoxTQDeBanco;
	}

	/**
	 * This method initializes jComboBoxLadoImplante
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxLadoImplante() {
		if (jComboBoxLadoImplante == null) {
			jComboBoxLadoImplante = new JComboBox();
			jComboBoxLadoImplante.setBounds(new Rectangle(168, 155, 111, 25));
		}
		return jComboBoxLadoImplante;
	}

	/**
	 * This method initializes jComboBoxAnastVenosa
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxAnastVenosa() {
		if (jComboBoxAnastVenosa == null) {
			jComboBoxAnastVenosa = new JComboBox();
			jComboBoxAnastVenosa.setBounds(new Rectangle(139, 189, 139, 25));
		}
		return jComboBoxAnastVenosa;
	}

	/**
	 * This method initializes jComboBoxAnastArterial
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxAnastArterial() {
		if (jComboBoxAnastArterial == null) {
			jComboBoxAnastArterial = new JComboBox();
			jComboBoxAnastArterial.setBounds(new Rectangle(137, 220, 141, 25));
		}
		return jComboBoxAnastArterial;
	}

	/**
	 * This method initializes jComboBoxAnastUterial
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxAnastUterial() {
		if (jComboBoxAnastUterial == null) {
			jComboBoxAnastUterial = new JComboBox();
			jComboBoxAnastUterial.setBounds(new Rectangle(146, 251, 132, 26));
		}
		return jComboBoxAnastUterial;
	}

	/**
	 * This method initializes jTextFieldTisqCalMin
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldTisqCalMin() {
		if (jTextFieldTisqCalMin == null) {
			jTextFieldTisqCalMin = new JTextField();
			jTextFieldTisqCalMin.setBounds(new Rectangle(110, 7, 102, 27));
		}
		return jTextFieldTisqCalMin;
	}

	/**
	 * This method initializes jTextFieldTisqFriqHs
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldTisqFriqHs() {
		if (jTextFieldTisqFriqHs == null) {
			jTextFieldTisqFriqHs = new JTextField();
			jTextFieldTisqFriqHs.setBounds(new Rectangle(110, 38, 102, 27));
		}
		return jTextFieldTisqFriqHs;
	}

	/**
	 * This method initializes jTextFieldTisqFriaMin
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldTisqFriaMin() {
		if (jTextFieldTisqFriaMin == null) {
			jTextFieldTisqFriaMin = new JTextField();
			jTextFieldTisqFriaMin.setBounds(new Rectangle(110, 67, 102, 27));
		}
		return jTextFieldTisqFriaMin;
	}

	/**
	 * This method initializes jTextFieldTisqTibiaHs
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldTisqTibiaHs() {
		if (jTextFieldTisqTibiaHs == null) {
			jTextFieldTisqTibiaHs = new JTextField();
			jTextFieldTisqTibiaHs.setBounds(new Rectangle(110, 98, 102, 27));
		}
		return jTextFieldTisqTibiaHs;
	}

	/**
	 * This method initializes jComboBoxRepercusion
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxRepercusion() {
		if (jComboBoxRepercusion == null) {
			jComboBoxRepercusion = new JComboBox();
			jComboBoxRepercusion.setBounds(new Rectangle(110, 132, 130, 26));
		}
		return jComboBoxRepercusion;
	}

	/**
	 * This method initializes jCheckBoxSangradoIOP
	 * 
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxSangradoIOP() {
		if (jCheckBoxSangradoIOP == null) {
			jCheckBoxSangradoIOP = new JCheckBox();
			jCheckBoxSangradoIOP.setText("Sangrado IOP");
			jCheckBoxSangradoIOP.setBounds(new Rectangle(10, 9, 120, 25));
			jCheckBoxSangradoIOP.setBackground(Color.WHITE);
		}
		return jCheckBoxSangradoIOP;
	}

	/**
	 * This method initializes jCheckBoxLesionArterial
	 * 
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxLesionArterial() {
		if (jCheckBoxLesionArterial == null) {
			jCheckBoxLesionArterial = new JCheckBox();
			jCheckBoxLesionArterial.setText("Lesion Arterial");
			jCheckBoxLesionArterial.setBounds(new Rectangle(152, 9, 123, 24));
			jCheckBoxLesionArterial.setBackground(Color.WHITE);
		}
		return jCheckBoxLesionArterial;
	}

	/**
	 * This method initializes jCheckBoxLesionVenosa
	 * 
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxLesionVenosa() {
		if (jCheckBoxLesionVenosa == null) {
			jCheckBoxLesionVenosa = new JCheckBox();
			jCheckBoxLesionVenosa.setText("Lesion Venosa");
			jCheckBoxLesionVenosa.setBounds(new Rectangle(152, 74, 119, 26));
			jCheckBoxLesionVenosa.setBackground(Color.WHITE);
		}
		return jCheckBoxLesionVenosa;
	}

	/**
	 * This method initializes jCheckBoxNecesidadRepenfundir
	 * 
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxNecesidadRepenfundir() {
		if (jCheckBoxNecesidadRepenfundir == null) {
			jCheckBoxNecesidadRepenfundir = new JCheckBox();
			jCheckBoxNecesidadRepenfundir.setText("Necesidad Repefundir");
			jCheckBoxNecesidadRepenfundir.setBounds(new Rectangle(10, 112, 158,
					26));
			jCheckBoxNecesidadRepenfundir.setBackground(Color.WHITE);
		}
		return jCheckBoxNecesidadRepenfundir;
	}

	/**
	 * This method initializes jTextAreaOtrasComplicacionesQuirurgicas
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextAreaOtrasComplicacionesQuirurgicas() {
		if (jTextAreaOtrasComplicacionesQuirurgicas == null) {
			jTextAreaOtrasComplicacionesQuirurgicas = new JTextArea();
			jTextAreaOtrasComplicacionesQuirurgicas.setForeground(new Color(0,
					51, 51));
			jTextAreaOtrasComplicacionesQuirurgicas.setLineWrap(true);
		}
		return jTextAreaOtrasComplicacionesQuirurgicas;
	}

	/**
	 * This method initializes jCheckBoxDiuresisIOP
	 * 
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxDiuresisIOP() {
		if (jCheckBoxDiuresisIOP == null) {
			jCheckBoxDiuresisIOP = new JCheckBox();
			jCheckBoxDiuresisIOP.setText("Diuresis IOP");
			jCheckBoxDiuresisIOP.setBounds(new Rectangle(75, 168, 104, 25));
			jCheckBoxDiuresisIOP.setBackground(Color.WHITE);
		}
		return jCheckBoxDiuresisIOP;
	}

	/**
	 * This method initializes jTextFieldCrInicial
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldCrInicial() {
		if (jTextFieldCrInicial == null) {
			jTextFieldCrInicial = new JTextField();
			jTextFieldCrInicial.setBounds(new Rectangle(126, 17, 90, 21));
		}
		return jTextFieldCrInicial;
	}

	/**
	 * This method initializes jTextFieldDiaRecDiuresis
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldDiaRecDiuresis() {
		if (jTextFieldDiaRecDiuresis == null) {
			jTextFieldDiaRecDiuresis = new JTextField();
			jTextFieldDiaRecDiuresis.setBounds(new Rectangle(126, 52, 90, 21));
		}
		return jTextFieldDiaRecDiuresis;
	}

	/**
	 * This method initializes jTextFieldDiaRecFuncional
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldDiaRecFuncional() {
		if (jTextFieldDiaRecFuncional == null) {
			jTextFieldDiaRecFuncional = new JTextField();
			jTextFieldDiaRecFuncional.setBounds(new Rectangle(126, 84, 90, 21));
		}
		return jTextFieldDiaRecFuncional;
	}

	/**
	 * This method initializes jButtonGuardar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonGuardar() {
		if (jButtonGuardar == null) {
			jButtonGuardar = new JButton();
			jButtonGuardar.setBounds(new Rectangle(54, 629, 145, 39));
			jButtonGuardar.setText("Cancelar");
			jButtonGuardar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							salir();
						}
					});
		}
		return jButtonGuardar;
	}

	private void guardarLocalmente() {
		if (this.trasplante == null) {
			this.trasplante = new Trasplante();
		}
		Trasplante t = this.trasplante;
		t.setFecha(this.jDateChooserFechaTrasplante.getCalendar());
		t.setRinhon((String) this.jComboBoxRinhon.getSelectedItem());
		t.setNumArt((Integer) this.jComboBoxNumArterias.getSelectedItem());
		t.setNumVenas((Integer) this.jComboBoxNumVenas.getSelectedItem());
		t.setUreter((String) this.jComboBoxUreter.getSelectedItem());
		try {
			if (!this.jTextFieldNumTrasplante.getText().equalsIgnoreCase("")
					&& !this.jTextFieldNumTrasplante.getText()
							.equalsIgnoreCase(" ")) {
				t.setNumTr(Integer.parseInt(this.jTextFieldNumTrasplante
						.getText()));
			}
			if (!this.jTextFieldNumCompatibilidadAB.getText().equalsIgnoreCase(
					"")
					&& !this.jTextFieldNumCompatibilidadAB.getText()
							.equalsIgnoreCase(" ")) {
				t
						.setNumCompAB(Integer
								.parseInt(this.jTextFieldNumCompatibilidadAB
										.getText()));

			}
			if (!this.jTextFieldNumCompatibilidadDR.getText().equalsIgnoreCase(
					"")
					&& !this.jTextFieldNumCompatibilidadDR.getText()
							.equalsIgnoreCase(" ")) {
				t
						.setNumCompDR(Integer
								.parseInt(this.jTextFieldNumCompatibilidadDR
										.getText()));
			}
			if (!this.jTextFieldNumIncompatibilidadAB.getText()
					.equalsIgnoreCase("")
					&& !this.jTextFieldNumIncompatibilidadAB.getText()
							.equalsIgnoreCase(" ")) {
				t.setNumIncompAB(Integer
						.parseInt(this.jTextFieldNumIncompatibilidadAB
								.getText()));
			}
			if (!this.jTextFieldNumIncompatibilidadDR.getText()
					.equalsIgnoreCase("")
					&& !this.jTextFieldNumIncompatibilidadDR.getText()
							.equalsIgnoreCase(" ")) {
				t.setNumIncompDR(Integer
						.parseInt(this.jTextFieldNumIncompatibilidadDR
								.getText()));
			}
			if (!this.jTextFieldNumTrans.getText().equalsIgnoreCase("")
					&& !this.jTextFieldNumTrans.getText().equalsIgnoreCase(" ")) {
				t.setNumTransf(Integer.parseInt(this.jTextFieldNumTrans
						.getText()));
			}
			if (!this.jTextFieldNumEmbarazo.getText().equalsIgnoreCase("")
					&& !this.jTextFieldNumEmbarazo.getText().equalsIgnoreCase(
							" ")) {
				t.setNumEmbarazo(Integer.parseInt(this.jTextFieldNumEmbarazo
						.getText()));
			}
			if (!this.jTextFieldTisqCalMin.getText().equalsIgnoreCase("")
					&& !this.jTextFieldTisqCalMin.getText().equalsIgnoreCase(
							" ")) {
				t.setTIsqCalMin(Integer.parseInt(this.jTextFieldTisqCalMin
						.getText()));
			}
			if (!this.jTextFieldTisqFriqHs.getText().equalsIgnoreCase("")
					&& !this.jTextFieldTisqFriqHs.getText().equalsIgnoreCase(
							" ")) {
				t.setTIsqFriqHs(Integer.parseInt(this.jTextFieldTisqFriqHs
						.getText()));
			}
			if (!this.jTextFieldTisqFriaMin.getText().equalsIgnoreCase("")
					&& !this.jTextFieldTisqFriaMin.getText().equalsIgnoreCase(
							" ")) {
				t.setTIsqFriaMin(Integer.parseInt(this.jTextFieldTisqFriaMin
						.getText()));
			}
			if (!this.jTextFieldTisqTibiaHs.getText().equalsIgnoreCase("")
					&& !this.jTextFieldTisqTibiaHs.getText().equalsIgnoreCase(
							" ")) {
				t.setTIsqTibiaHs(Integer.parseInt(this.jTextFieldTisqTibiaHs
						.getText()));
			}
			if (!this.jTextFieldCrInicial.getText().equalsIgnoreCase("")
					&& !this.jTextFieldCrInicial.getText()
							.equalsIgnoreCase(" ")) {
				t.setCrInicial(Float.parseFloat(this.jTextFieldCrInicial
						.getText()));
			}
			if (!this.jTextFieldDiaRecDiuresis.getText().equalsIgnoreCase("")
					&& !this.jTextFieldDiaRecDiuresis.getText()
							.equalsIgnoreCase(" ")) {
				t.setDiaRecDiuresis(Integer
						.parseInt(this.jTextFieldDiaRecDiuresis.getText()));
			}
			if (!this.jTextFieldDiaRecFuncional.getText().equalsIgnoreCase("")
					&& !this.jTextFieldDiaRecFuncional.getText()
							.equalsIgnoreCase(" ")) {
				t.setDiaRecFuncional(Integer
						.parseInt(this.jTextFieldDiaRecFuncional.getText()));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		t.setPraMax(this.jTextFieldPRAMax.getText());
		t.setPraTR(this.jTextFieldPRATR.getText());
		t.setTransPrevias(this.jCheckBoxTransPrevia.isSelected());

		t.setEmbarazo((String) this.jComboBoxEmbarazo.getSelectedItem());

		t
				.setLiqPerfusion((String) this.jComboBoxLiqPerfusion
						.getSelectedItem());
		t
				.setLadoImplante((String) this.jComboBoxLadoImplante
						.getSelectedItem());
		t.setAnastVenosa((String) this.jComboBoxAnastVenosa.getSelectedItem());
		t.setAnastArterial((String) this.jComboBoxAnastArterial
				.getSelectedItem());
		t
				.setAnastUterial((String) this.jComboBoxAnastUterial
						.getSelectedItem());

		t.setRepercusion((String) this.jComboBoxRepercusion.getSelectedItem());
		t.setSangradoIOp(this.jCheckBoxSangradoIOP.isSelected());
		t.setLesionArterial(this.jCheckBoxLesionArterial.isSelected());
		t.setTqDeBanco(this.jCheckBoxTQDeBanco.isSelected());
		t.setAutoac(this.jCheckBoxAutoAc.isSelected());
		t.setDiuresisIOp(this.jCheckBoxDiuresisIOP.isSelected());
		t.setAnomaliaVasc(this.jCheckBoxAnomaliaVasc.isSelected());
		t.setInstabHemod(this.jCheckBoxInestabHemo.isSelected());
		t.setLesionVenosa(this.jCheckBoxLesionVenosa.isSelected());
		t.setNecesidadRepefundir(this.jCheckBoxNecesidadRepenfundir
				.isSelected());
		t
				.setOtrasComplicacionesQuirurgicas(this.jTextAreaOtrasComplicacionesQuirurgicas
						.getText());

	}

	public void actualizarTrasplante(Trasplante t) {
		this.trasplante = t;
		this.cargarDatosTrasplante();
	}

	/**
	 * This method initializes jButtonSiguiente
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonSiguiente() {
		if (jButtonSiguiente == null) {
			jButtonSiguiente = new JButton();
			jButtonSiguiente.setBounds(new Rectangle(793, 629, 145, 39));
			jButtonSiguiente.setText("Siguiente");
			jButtonSiguiente
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							seguirTrasplante();
						}
					});
		}
		return jButtonSiguiente;
	}

	private void seguirTrasplante() {
		if (!this.ver) {
			this.guardarLocalmente();
		}
		this.iuIngresar = new IUTrasplanteManejar2(this.pt, this);
		this.iuIngresar.setVisible(true);
	}

	/**
	 * This method initializes jDesktopPaneDato7
	 * 
	 * @return javax.swing.JDesktopPane
	 */
	private JDesktopPane getJDesktopPaneDato7() {
		if (jDesktopPaneDato7 == null) {
			jDesktopPaneDato7 = new JDesktopPane();
			jDesktopPaneDato7.setBounds(new Rectangle(614, 412, 238, 121));
			jDesktopPaneDato7.add(getJTextFieldCrInicial(), null);
			jDesktopPaneDato7.add(jLabelCrInicial, null);
			jDesktopPaneDato7.add(jLabelDiasRecDiuresis, null);
			jDesktopPaneDato7.add(getJTextFieldDiaRecDiuresis(), null);
			jDesktopPaneDato7.add(jLabelDiasRecFuncional, null);
			jDesktopPaneDato7.add(getJTextFieldDiaRecFuncional(), null);
		}
		return jDesktopPaneDato7;
	}

	/**
	 * This method initializes jDesktopPane
	 * 
	 * @return javax.swing.JDesktopPane
	 */
	private JDesktopPane getJDesktopPane() {
		if (jDesktopPane == null) {
			jDesktopPane = new JDesktopPane();
			jDesktopPane.setBounds(new Rectangle(614, 99, 342, 216));
			jDesktopPane.add(getJCheckBoxSangradoIOP(), null);
			jDesktopPane.add(getJCheckBoxLesionArterial(), null);
			jDesktopPane.add(getJCheckBoxTQDeBanco(), null);
			jDesktopPane.add(getJCheckBoxAnomaliaVasc(), null);
			jDesktopPane.add(getJCheckBoxInestabHemo(), null);
			jDesktopPane.add(getJCheckBoxLesionVenosa(), null);
			jDesktopPane.add(getJCheckBoxNecesidadRepenfundir(), null);
			jDesktopPane.add(jLabelOtrasComplicacionesQ, null);
			jDesktopPane.add(getJScrollPaneOComplicacionesQuirurgicas(), null);
		}
		return jDesktopPane;
	}

	/**
	 * This method initializes jDesktopDato5
	 * 
	 * @return javax.swing.JDesktopPane
	 */
	private JDesktopPane getJDesktopDato5() {
		if (jDesktopDato5 == null) {
			jDesktopDato5 = new JDesktopPane();
			jDesktopDato5.setBounds(new Rectangle(298, 412, 294, 218));
			jDesktopDato5.add(jLabelTisqcalmin, null);
			jDesktopDato5.add(getJTextFieldTisqCalMin(), null);
			jDesktopDato5.add(jLabelTisqFriqHs, null);
			jDesktopDato5.add(getJTextFieldTisqFriqHs(), null);
			jDesktopDato5.add(jLabelTisqFriaMin, null);
			jDesktopDato5.add(getJTextFieldTisqFriaMin(), null);
			jDesktopDato5.add(jLabelTisqTibiaHs, null);
			jDesktopDato5.add(getJTextFieldTisqTibiaHs(), null);
			jDesktopDato5.add(jLabelRepercusion, null);
			jDesktopDato5.add(getJComboBoxRepercusion(), null);
			jDesktopDato5.add(getJCheckBoxDiuresisIOP(), null);
		}
		return jDesktopDato5;
	}

	/**
	 * This method initializes jDesktopPaneDatos3
	 * 
	 * @return javax.swing.JDesktopPane
	 */
	private JDesktopPane getJDesktopPaneDatos3() {
		if (jDesktopPaneDatos3 == null) {
			jDesktopPaneDatos3 = new JDesktopPane();
			jDesktopPaneDatos3.setBounds(new Rectangle(298, 99, 292, 285));
			jDesktopPaneDatos3.add(jLabelRinhon, null);
			jDesktopPaneDatos3.add(getJComboBoxRinhon(), null);
			jDesktopPaneDatos3.add(jLabelNumArterias, null);
			jDesktopPaneDatos3.add(getJComboBoxNumArterias(), null);
			jDesktopPaneDatos3.add(jLabelNumVenas, null);
			jDesktopPaneDatos3.add(getJComboBoxNumVenas(), null);
			jDesktopPaneDatos3.add(jLabelUreter, null);
			jDesktopPaneDatos3.add(getJComboBoxUreter(), null);
			jDesktopPaneDatos3.add(jLabelLiqPerfusion, null);
			jDesktopPaneDatos3.add(getJComboBoxLiqPerfusion(), null);
			jDesktopPaneDatos3.add(jLabelLadoImplante, null);
			jDesktopPaneDatos3.add(getJComboBoxLadoImplante(), null);
			jDesktopPaneDatos3.add(jLabelAnastVenosa, null);
			jDesktopPaneDatos3.add(getJComboBoxAnastVenosa(), null);
			jDesktopPaneDatos3.add(jLabelAnastArterial, null);
			jDesktopPaneDatos3.add(getJComboBoxAnastArterial(), null);
			jDesktopPaneDatos3.add(jLabelAnastUterial, null);
			jDesktopPaneDatos3.add(getJComboBoxAnastUterial(), null);
		}
		return jDesktopPaneDatos3;
	}

	/**
	 * This method initializes jDesktopPaneDatos2
	 * 
	 * @return javax.swing.JDesktopPane
	 */
	private JDesktopPane getJDesktopPaneDatos2() {
		if (jDesktopPaneDatos2 == null) {
			jDesktopPaneDatos2 = new JDesktopPane();
			jDesktopPaneDatos2.setBounds(new Rectangle(18, 412, 255, 156));
			jDesktopPaneDatos2.add(jLabelNumCompatibilidadAB, null);
			jDesktopPaneDatos2.add(getJTextFieldNumCompatibilidadAB(), null);
			jDesktopPaneDatos2.add(jLabelNumCompatibilidadDR, null);
			jDesktopPaneDatos2.add(getJTextFieldNumCompatibilidadDR(), null);
			jDesktopPaneDatos2.add(jLabelNumInCompatibilidadAB, null);
			jDesktopPaneDatos2.add(getJTextFieldNumIncompatibilidadAB(), null);
			jDesktopPaneDatos2.add(jLabelNumIncompatibilidadDR, null);
			jDesktopPaneDatos2.add(getJTextFieldNumIncompatibilidadDR(), null);
		}
		return jDesktopPaneDatos2;
	}

	/**
	 * This method initializes jDesktopPaneDatos1
	 * 
	 * @return javax.swing.JDesktopPane
	 */
	private JDesktopPane getJDesktopPaneDatos1() {
		if (jDesktopPaneDatos1 == null) {
			jDesktopPaneDatos1 = new JDesktopPane();
			jDesktopPaneDatos1.setBounds(new Rectangle(18, 99, 242, 231));
			jDesktopPaneDatos1.add(jLabelPraMax, null);
			jDesktopPaneDatos1.add(getJTextFieldPRAMax(), null);
			jDesktopPaneDatos1.add(jLabelPraTR, null);
			jDesktopPaneDatos1.add(getJTextFieldPRATR(), null);
			jDesktopPaneDatos1.add(getJCheckBoxTransPrevia(), null);
			jDesktopPaneDatos1.add(jLabelNumTrans, null);
			jDesktopPaneDatos1.add(getJTextFieldNumTrans(), null);
			jDesktopPaneDatos1.add(jLabelEmbarazo, null);
			jDesktopPaneDatos1.add(getJComboBoxEmbarazo(), null);
			jDesktopPaneDatos1.add(jLabelNumEmbarazo, null);
			jDesktopPaneDatos1.add(getJTextFieldNumEmbarazo(), null);
			jDesktopPaneDatos1.add(getJCheckBoxAutoAc(), null);
		}
		return jDesktopPaneDatos1;
	}

	private void mostrarPaciente() {
		IUPacienteModificar iu = new IUPacienteModificar(this.p, true);
		iu.setVisible(true);
	}

	private void cambiarDonante() {
		this.guardarLocalmente();
		IUTrasplanteDonanteSeleccionar iuDonante = new IUTrasplanteDonanteSeleccionar(
				this);
		iuDonante.setVisible(true);
	}

	private void mostrarDonante() {
		if (this.trasplante != null) {
			if (this.trasplante.getDonante() != null) {
				if (this.trasplante.getDonante().getId().equalsIgnoreCase("")){
					JOptionPane.showMessageDialog(this,"No hay ningun Donante asociado con este trasplante.\nPor lo tanto no se puede mostrar ningun dato." , "Error", 2);
					return;
				}
				IUDonanteModificar iu = new IUDonanteModificar(this.trasplante
						.getDonante(), true);
				iu.setVisible(true);
			}
		}

	}

	/**
	 * This method initializes jScrollPaneOComplicacionesQuirurgicas
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneOComplicacionesQuirurgicas() {
		if (jScrollPaneOComplicacionesQuirurgicas == null) {
			jScrollPaneOComplicacionesQuirurgicas = new JScrollPane();
			jScrollPaneOComplicacionesQuirurgicas.setBounds(new Rectangle(11,
					172, 278, 39));
			jScrollPaneOComplicacionesQuirurgicas
					.setViewportView(getJTextAreaOtrasComplicacionesQuirurgicas());
		}
		return jScrollPaneOComplicacionesQuirurgicas;
	}
} // @jve:decl-index=0:visual-constraint="10,10"
