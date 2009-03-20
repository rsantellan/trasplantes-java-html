package iU;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Calendar;

import javax.swing.JButton;
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

import dominio.EvolucionTrasplante;
import dominio.Trasplante;

public class IUEvolucionManejarSimple extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JDateChooser jDateChooserFecha = null;
	private JLabel jLabelFecha = null;
	private JLabel jLabelPas = null;
	private JTextField jTextFieldPAS = null;
	private JLabel jLabelPad = null;
	private JTextField jTextFieldPAD = null;
	private JLabel jLabelDiuresis = null;
	private JTextField jTextFieldDIURESIS = null;
	private JLabel jLabelPeso = null;
	private JTextField jTextFieldPeso = null;
	private JLabel jLabelUrea = null;
	private JTextField jTextFieldUrea = null;
	private JLabel jLabelCreatinina = null;
	private JTextField jTextFieldCreatinina = null;
	private JLabel jLabelHt = null;
	private JTextField jTextFieldHT = null;
	private JLabel jLabelHB = null;
	private JTextField jTextFieldHB = null;
	private JLabel jLabelGB = null;
	private JTextField jTextFieldGB = null;
	private JLabel jLabelPlaquetas = null;
	private JTextField jTextFieldPlaquetas = null;
	private JLabel jLabelSodio = null;
	private JTextField jTextFieldSodio = null;
	private JLabel jLabelPotasio = null;
	private JTextField jTextFieldPotasio = null;
	private JLabel jLabelCloro = null;
	private JTextField jTextFieldCloro = null;
	private JLabel jLabelCalcio = null;
	private JTextField jTextFieldCalcio = null;
	private JLabel jLabelFosforo = null;
	private JTextField jTextFieldFosforo = null;
	private JLabel jLabelGlicemia = null;
	private JTextField jTextFieldGlicemia = null;
	private JLabel jLabelUricemia = null;
	private JTextField jTextFieldUricemia = null;
	private JLabel jLabelProtU = null;
	private JTextField jTextFieldProtU = null;
	private JLabel jLabelCCreatinina = null;
	private JTextField jTextFieldCCreatinina = null;
	private JLabel jLabelCUrea = null;
	private JTextField jTextFieldCUrea = null;
	private JLabel jLabelNaU = null;
	private JTextField jTextFieldNaU = null;
	private JLabel jLabelKU = null;
	private JTextField jTextFieldKU = null;
	private JLabel jLabelCyAPV = null;
	private JTextField jTextFieldCyAPV = null;
	private JLabel jLabelCyAPP = null;
	private JTextField jTextFieldCyAPP = null;
	private JLabel jLabelFkP = null;
	private JTextField jTextFieldFkP = null;
	private JLabel jLabelMmfP = null;
	private JTextField jTextFieldMMFP = null;
	private JLabel jLabelEveP = null;
	private JTextField jTextFieldEveP = null;
	private JLabel jLabelBd = null;
	private JTextField jTextFieldBd = null;
	private JLabel jLabelBi = null;
	private JTextField jTextFieldBi = null;
	private JLabel jLabelTgo = null;
	private JTextField jTextFieldTgo = null;
	private JLabel jLabelTgp = null;
	private JTextField jTextFieldTgp = null;
	private JLabel jLabelGammaGt = null;
	private JTextField jTextFieldGammagt = null;
	private JLabel jLabelFAlc = null;
	private JTextField jTextFieldFAlc = null;
	private JLabel jLabelTProt = null;
	private JTextField jTextFieldTProt = null;
	private JLabel jLabelKptt = null;
	private JTextField jTextFieldKppt = null;
	private JLabel jLabelHowell = null;
	private JTextField jTextFieldHowell = null;
	private JLabel jLabelFibrinogeno = null;
	private JTextField jTextFieldFibrinogeno = null;
	private JLabel jLabelColesterol = null;
	private JTextField jTextFieldColesterol = null;
	private JLabel jLabelHdl = null;
	private JTextField jTextFieldHdl = null;
	private JLabel jLabelLdl = null;
	private JTextField jTextFieldLdl = null;
	private JLabel jLabelRAt = null;
	private JTextField jTextFieldRAt = null;
	private JLabel jLabelTg = null;
	private JTextField jTextFieldTg = null;
	private JLabel jLabelHNA1C = null;
	private JTextField jTextFieldHNA1C = null;
	private JLabel jLabelAlbulimia = null;
	private JTextField jTextFieldAlbulimia = null;
	private JLabel jLabelGlobulinas = null;
	private JTextField jTextFieldGlobulinas = null;
	private JLabel jLabelPthi = null;
	private JLabel jLabelOtros = null;
	private JScrollPane jScrollPaneOtros = null;
	private JTextArea jTextAreaOtros = null;
	private JButton jButtonGuardar = null;
	private JButton jButtonCancelar = null;
	private Trasplante t;
	private EvolucionTrasplante et;
	private boolean ingresar;
	private JComboBox jComboBoxpthi = null;
	private JLabel jLabelValorPTHi = null;
	private JTextField jTextFieldValorPTHi = null;
	/**
	 * This is the default constructor
	 */
	public IUEvolucionManejarSimple(Trasplante t, Calendar fecha) {
		super();
		initialize();
		this.t = t;
		this.ingresar = true;
		this.jDateChooserFecha.setCalendar(fecha);
		this.jDateChooserFecha.setEnabled(false);
		cargarCombo();
	}

	public IUEvolucionManejarSimple(Trasplante t, EvolucionTrasplante et, Calendar fecha) {
		super();
		initialize();
		this.t = t;
		this.et = et;
		this.ingresar = false;
		this.jDateChooserFecha.setCalendar(fecha);
		this.jDateChooserFecha.setEnabled(false);
		cargarCombo();
		cargarDatos(this.et);
	}
	
	public IUEvolucionManejarSimple(Trasplante t, EvolucionTrasplante et, Calendar fecha, boolean ver) {
		super();
		initialize();
		this.t = t;
		this.et = et;
		this.ingresar = false;
		this.jDateChooserFecha.setCalendar(fecha);
		this.jDateChooserFecha.setEnabled(false);
		cargarCombo();
		cargarDatos(this.et);
		this.jButtonGuardar.setVisible(false);
	}
	
	private void cargarCombo(){
		this.jComboBoxpthi.addItem("Ausente");
		this.jComboBoxpthi.addItem("Presente");
		this.jComboBoxpthi.addItem("Falta");
	}
	private void cargarDatos(EvolucionTrasplante et){
		this.jDateChooserFecha.setCalendar(et.getFecha());
		this.jTextFieldPAS.setText(String.valueOf(et.getPas()));
		this.jTextFieldPAD.setText(String.valueOf(et.getPad()));
		this.jTextFieldDIURESIS.setText(String.valueOf(et.getDiuresis()));
		this.jTextFieldPeso.setText(String.valueOf(et.getPeso()));
		this.jTextFieldUrea.setText(String.valueOf(et.getUrea()));
		this.jTextFieldCreatinina.setText(String.valueOf(et.getCreatinina()));
		this.jTextFieldHT.setText(String.valueOf(et.getHt()));
		this.jTextFieldHB.setText(String.valueOf(et.getHb()));
		this.jTextFieldGB.setText(String.valueOf(et.getGb()));
		this.jTextFieldPlaquetas.setText(String.valueOf(et.getPlaquetas()));
		this.jTextFieldSodio.setText(String.valueOf(et.getSodio()));
		this.jTextFieldPotasio.setText(String.valueOf(et.getPotasio()));
		this.jTextFieldCloro.setText(String.valueOf(et.getCloro()));
		this.jTextFieldCalcio.setText(String.valueOf(et.getCalcio()));
		this.jTextFieldFosforo.setText(String.valueOf(et.getFosforo()));
		this.jTextFieldGlicemia.setText(String.valueOf(et.getGlicemia()));
		this.jTextFieldUricemia.setText(String.valueOf(et.getUricemia()));
		this.jTextFieldProtU.setText(String.valueOf(et.getProtU()));
		this.jTextFieldCCreatinina.setText(String.valueOf(et.getCCreatinina()));
		this.jTextFieldCUrea.setText(String.valueOf(et.getCUrea()));
		this.jTextFieldNaU.setText(String.valueOf(et.getNaU()));
		this.jTextFieldKU.setText(String.valueOf(et.getKU()));
		this.jTextFieldCyAPV.setText(String.valueOf(et.getCyaPV()));
		this.jTextFieldCyAPP.setText(String.valueOf(et.getCyaPP()));
		this.jTextFieldFkP.setText(String.valueOf(et.getFkP()));
		this.jTextFieldMMFP.setText(String.valueOf(et.getMfmP()));
		this.jTextFieldEveP.setText(String.valueOf(et.getEveP()));
		this.jTextFieldBd.setText(String.valueOf(et.getBd()));
		this.jTextFieldBi.setText(String.valueOf(et.getBi()));
		this.jTextFieldTgo.setText(String.valueOf(et.getTgo()));
		this.jTextFieldTgp.setText(String.valueOf(et.getTgp()));
		this.jTextFieldGammagt.setText(String.valueOf(et.getGammagt()));
		this.jTextFieldFAlc.setText(String.valueOf(et.getFAlc()));
		this.jTextFieldTProt.setText(String.valueOf(et.getTProt()));
		this.jTextFieldKppt.setText(String.valueOf(et.getKptt()));
		this.jTextFieldHowell.setText(String.valueOf(et.getHowell()));
		this.jTextFieldColesterol.setText(String.valueOf(et.getColesterol()));
		this.jTextFieldHdl.setText(String.valueOf(et.getHdl()));
		this.jTextFieldLdl.setText(String.valueOf(et.getLdl()));
		this.jTextFieldRAt.setText(String.valueOf(et.getRAt()));
		this.jTextFieldTg.setText(String.valueOf(et.getTg()));
		this.jTextFieldHNA1C.setText(String.valueOf(et.getHna1c()));
		this.jTextFieldAlbulimia.setText(String.valueOf(et.getAlbumina()));
		this.jTextFieldGlobulinas.setText(String.valueOf(et.getGlobulinas()));
		this.jTextFieldFibrinogeno.setText(String.valueOf(et.getFibrinogeno()));
		this.jComboBoxpthi.setSelectedItem(et.getPthi());
		//this.jTextFieldPthi.setText(et.getPthi());
		this.jTextAreaOtros.setText(et.getOtros());
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(1151, 615);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Manejar Evolucion de Trasplante Paraclinica");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelValorPTHi = new JLabel();
			jLabelValorPTHi.setBounds(new Rectangle(869, 393, 79, 26));
			jLabelValorPTHi.setText("Valor PTHi:");
			jLabelOtros = new JLabel();
			jLabelOtros.setBounds(new Rectangle(581, 430, 77, 28));
			jLabelOtros.setText("Otros:");
			jLabelPthi = new JLabel();
			jLabelPthi.setBounds(new Rectangle(870, 360, 77, 28));
			jLabelPthi.setText("PTHi:");
			jLabelGlobulinas = new JLabel();
			jLabelGlobulinas.setBounds(new Rectangle(870, 300, 77, 28));
			jLabelGlobulinas.setText("Globulinas:");
			jLabelAlbulimia = new JLabel();
			jLabelAlbulimia.setBounds(new Rectangle(870, 270, 77, 28));
			jLabelAlbulimia.setText("Albumina:");
			jLabelHNA1C = new JLabel();
			jLabelHNA1C.setBounds(new Rectangle(870, 240, 77, 28));
			jLabelHNA1C.setText("HbA 1C:");
			jLabelTg = new JLabel();
			jLabelTg.setBounds(new Rectangle(870, 210, 77, 28));
			jLabelTg.setText("Tg:");
			jLabelRAt = new JLabel();
			jLabelRAt.setBounds(new Rectangle(870, 180, 77, 28));
			jLabelRAt.setText("R At:");
			jLabelLdl = new JLabel();
			jLabelLdl.setBounds(new Rectangle(870, 150, 77, 28));
			jLabelLdl.setText("Ldl:");
			jLabelHdl = new JLabel();
			jLabelHdl.setBounds(new Rectangle(870, 120, 77, 28));
			jLabelHdl.setText("Hdl:");
			jLabelColesterol = new JLabel();
			jLabelColesterol.setBounds(new Rectangle(870, 90, 77, 28));
			jLabelColesterol.setText("Colesterol:");
			jLabelFibrinogeno = new JLabel();
			jLabelFibrinogeno.setBounds(new Rectangle(870, 330, 77, 28));
			jLabelFibrinogeno.setText("Fibrinogeno:");
			jLabelHowell = new JLabel();
			jLabelHowell.setBounds(new Rectangle(585, 360, 77, 28));
			jLabelHowell.setText("Howell:");
			jLabelKptt = new JLabel();
			jLabelKptt.setBounds(new Rectangle(585, 330, 77, 28));
			jLabelKptt.setText("Kppt:");
			jLabelTProt = new JLabel();
			jLabelTProt.setBounds(new Rectangle(585, 300, 77, 28));
			jLabelTProt.setText("T Prot:");
			jLabelFAlc = new JLabel();
			jLabelFAlc.setBounds(new Rectangle(585, 270, 77, 28));
			jLabelFAlc.setText("F Alc:");
			jLabelGammaGt = new JLabel();
			jLabelGammaGt.setBounds(new Rectangle(585, 240, 77, 28));
			jLabelGammaGt.setText("Gamma gt:");
			jLabelTgp = new JLabel();
			jLabelTgp.setBounds(new Rectangle(585, 210, 77, 28));
			jLabelTgp.setText("Tgp:");
			jLabelTgo = new JLabel();
			jLabelTgo.setBounds(new Rectangle(585, 180, 77, 28));
			jLabelTgo.setText("Tgo:");
			jLabelBi = new JLabel();
			jLabelBi.setBounds(new Rectangle(585, 150, 77, 28));
			jLabelBi.setText("BI:");
			jLabelBd = new JLabel();
			jLabelBd.setBounds(new Rectangle(585, 120, 77, 28));
			jLabelBd.setText("BD:");
			jLabelEveP = new JLabel();
			jLabelEveP.setBounds(new Rectangle(585, 90, 77, 28));
			jLabelEveP.setText("EVE P:");
			jLabelMmfP = new JLabel();
			jLabelMmfP.setBounds(new Rectangle(300, 450, 77, 28));
			jLabelMmfP.setText("MFM P:");
			jLabelFkP = new JLabel();
			jLabelFkP.setBounds(new Rectangle(300, 420, 77, 28));
			jLabelFkP.setText("Fk P:");
			jLabelCyAPP = new JLabel();
			jLabelCyAPP.setBounds(new Rectangle(300, 390, 77, 28));
			jLabelCyAPP.setText("CyA PP:");
			jLabelCyAPV = new JLabel();
			jLabelCyAPV.setBounds(new Rectangle(300, 360, 77, 28));
			jLabelCyAPV.setText("CyA PV:");
			jLabelKU = new JLabel();
			jLabelKU.setBounds(new Rectangle(300, 330, 77, 28));
			jLabelKU.setText("K U:");
			jLabelNaU = new JLabel();
			jLabelNaU.setBounds(new Rectangle(300, 300, 77, 28));
			jLabelNaU.setText("Na U:");
			jLabelCUrea = new JLabel();
			jLabelCUrea.setBounds(new Rectangle(300, 270, 77, 28));
			jLabelCUrea.setText("C Urea:");
			jLabelCCreatinina = new JLabel();
			jLabelCCreatinina.setBounds(new Rectangle(300, 240, 77, 28));
			jLabelCCreatinina.setText("C Creatinina:");
			jLabelProtU = new JLabel();
			jLabelProtU.setBounds(new Rectangle(300, 210, 77, 28));
			jLabelProtU.setText("Prot U:");
			jLabelUricemia = new JLabel();
			jLabelUricemia.setBounds(new Rectangle(300, 180, 77, 28));
			jLabelUricemia.setText("Uricemia:");
			jLabelGlicemia = new JLabel();
			jLabelGlicemia.setBounds(new Rectangle(300, 150, 77, 28));
			jLabelGlicemia.setText("Glicemia:");
			jLabelFosforo = new JLabel();
			jLabelFosforo.setBounds(new Rectangle(300, 120, 77, 28));
			jLabelFosforo.setText("Fosforo:");
			jLabelCalcio = new JLabel();
			jLabelCalcio.setBounds(new Rectangle(300, 90, 77, 28));
			jLabelCalcio.setText("Calcio:");
			jLabelCloro = new JLabel();
			jLabelCloro.setBounds(new Rectangle(15, 450, 77, 28));
			jLabelCloro.setText("CLORO:");
			jLabelPotasio = new JLabel();
			jLabelPotasio.setBounds(new Rectangle(15, 420, 77, 28));
			jLabelPotasio.setText("POTASIO:");
			jLabelSodio = new JLabel();
			jLabelSodio.setBounds(new Rectangle(15, 390, 77, 28));
			jLabelSodio.setText("SODIO:");
			jLabelPlaquetas = new JLabel();
			jLabelPlaquetas.setBounds(new Rectangle(15, 360, 77, 28));
			jLabelPlaquetas.setText("PLAQUETAS:");
			jLabelGB = new JLabel();
			jLabelGB.setBounds(new Rectangle(15, 330, 77, 28));
			jLabelGB.setText("GB:");
			jLabelHB = new JLabel();
			jLabelHB.setBounds(new Rectangle(15, 300, 77, 28));
			jLabelHB.setText("HB:");
			jLabelHt = new JLabel();
			jLabelHt.setBounds(new Rectangle(15, 270, 77, 28));
			jLabelHt.setText("HT:");
			jLabelCreatinina = new JLabel();
			jLabelCreatinina.setBounds(new Rectangle(15, 240, 77, 28));
			jLabelCreatinina.setText("CREATININA:");
			jLabelUrea = new JLabel();
			jLabelUrea.setBounds(new Rectangle(15, 210, 77, 28));
			jLabelUrea.setText("UREA:");
			jLabelPeso = new JLabel();
			jLabelPeso.setBounds(new Rectangle(15, 180, 77, 28));
			jLabelPeso.setText("PESO:");
			jLabelDiuresis = new JLabel();
			jLabelDiuresis.setBounds(new Rectangle(15, 150, 76, 28));
			jLabelDiuresis.setText("DIURESIS:");
			jLabelPad = new JLabel();
			jLabelPad.setBounds(new Rectangle(15, 120, 76, 28));
			jLabelPad.setText("PAD:");
			jLabelPas = new JLabel();
			jLabelPas.setBounds(new Rectangle(15, 90, 77, 28));
			jLabelPas.setText("PAS:");
			jLabelFecha = new JLabel();
			jLabelFecha.setBounds(new Rectangle(420, 29, 55, 32));
			jLabelFecha.setText("Fecha: ");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 204, 204));
			jContentPane.add(getJDateChooserFecha(), null);
			jContentPane.add(jLabelFecha, null);
			jContentPane.add(jLabelPas, null);
			jContentPane.add(getJTextFieldPAS(), null);
			jContentPane.add(jLabelPad, null);
			jContentPane.add(getJTextFieldPAD(), null);
			jContentPane.add(jLabelDiuresis, null);
			jContentPane.add(getJTextFieldDIURESIS(), null);
			jContentPane.add(jLabelPeso, null);
			jContentPane.add(getJTextFieldPeso(), null);
			jContentPane.add(jLabelUrea, null);
			jContentPane.add(getJTextFieldUrea(), null);
			jContentPane.add(jLabelCreatinina, null);
			jContentPane.add(getJTextFieldCreatinina(), null);
			jContentPane.add(jLabelHt, null);
			jContentPane.add(getJTextFieldHT(), null);
			jContentPane.add(jLabelHB, null);
			jContentPane.add(getJTextFieldHB(), null);
			jContentPane.add(jLabelGB, null);
			jContentPane.add(getJTextFieldGB(), null);
			jContentPane.add(jLabelPlaquetas, null);
			jContentPane.add(getJTextFieldPlaquetas(), null);
			jContentPane.add(jLabelSodio, null);
			jContentPane.add(getJTextFieldSodio(), null);
			jContentPane.add(jLabelPotasio, null);
			jContentPane.add(getJTextFieldPotasio(), null);
			jContentPane.add(jLabelCloro, null);
			jContentPane.add(getJTextFieldCloro(), null);
			jContentPane.add(jLabelCalcio, null);
			jContentPane.add(getJTextFieldCalcio(), null);
			jContentPane.add(jLabelFosforo, null);
			jContentPane.add(getJTextFieldFosforo(), null);
			jContentPane.add(jLabelGlicemia, null);
			jContentPane.add(getJTextFieldGlicemia(), null);
			jContentPane.add(jLabelUricemia, null);
			jContentPane.add(getJTextFieldUricemia(), null);
			jContentPane.add(jLabelProtU, null);
			jContentPane.add(getJTextFieldProtU(), null);
			jContentPane.add(jLabelCCreatinina, null);
			jContentPane.add(getJTextFieldCCreatinina(), null);
			jContentPane.add(jLabelCUrea, null);
			jContentPane.add(getJTextFieldCUrea(), null);
			jContentPane.add(jLabelNaU, null);
			jContentPane.add(getJTextFieldNaU(), null);
			jContentPane.add(jLabelKU, null);
			jContentPane.add(getJTextFieldKU(), null);
			jContentPane.add(jLabelCyAPV, null);
			jContentPane.add(getJTextFieldCyAPV(), null);
			jContentPane.add(jLabelCyAPP, null);
			jContentPane.add(getJTextFieldCyAPP(), null);
			jContentPane.add(jLabelFkP, null);
			jContentPane.add(getJTextFieldFkP(), null);
			jContentPane.add(jLabelMmfP, null);
			jContentPane.add(getJTextFieldMMFP(), null);
			jContentPane.add(jLabelEveP, null);
			jContentPane.add(getJTextFieldEveP(), null);
			jContentPane.add(jLabelBd, null);
			jContentPane.add(getJTextFieldBd(), null);
			jContentPane.add(jLabelBi, null);
			jContentPane.add(getJTextFieldBi(), null);
			jContentPane.add(jLabelTgo, null);
			jContentPane.add(getJTextFieldTgo(), null);
			jContentPane.add(jLabelTgp, null);
			jContentPane.add(getJTextFieldTgp(), null);
			jContentPane.add(jLabelGammaGt, null);
			jContentPane.add(getJTextFieldGammagt(), null);
			jContentPane.add(jLabelFAlc, null);
			jContentPane.add(getJTextFieldFAlc(), null);
			jContentPane.add(jLabelTProt, null);
			jContentPane.add(getJTextFieldTProt(), null);
			jContentPane.add(jLabelKptt, null);
			jContentPane.add(getJTextFieldKppt(), null);
			jContentPane.add(jLabelHowell, null);
			jContentPane.add(getJTextFieldHowell(), null);
			jContentPane.add(jLabelFibrinogeno, null);
			jContentPane.add(getJTextFieldFibrinogeno(), null);
			jContentPane.add(jLabelColesterol, null);
			jContentPane.add(getJTextFieldColesterol(), null);
			jContentPane.add(jLabelHdl, null);
			jContentPane.add(getJTextFieldHdl(), null);
			jContentPane.add(jLabelLdl, null);
			jContentPane.add(getJTextFieldLdl(), null);
			jContentPane.add(jLabelRAt, null);
			jContentPane.add(getJTextFieldRAt(), null);
			jContentPane.add(jLabelTg, null);
			jContentPane.add(getJTextFieldTg(), null);
			jContentPane.add(jLabelHNA1C, null);
			jContentPane.add(getJTextFieldHNA1C(), null);
			jContentPane.add(jLabelAlbulimia, null);
			jContentPane.add(getJTextFieldAlbulimia(), null);
			jContentPane.add(jLabelGlobulinas, null);
			jContentPane.add(getJTextFieldGlobulinas(), null);
			jContentPane.add(jLabelPthi, null);
			jContentPane.add(jLabelOtros, null);
			jContentPane.add(getJScrollPaneOtros(), null);
			jContentPane.add(getJButtonGuardar(), null);
			jContentPane.add(getJButtonCancelar(), null);
			jContentPane.add(getJComboBoxpthi(), null);
			jContentPane.add(jLabelValorPTHi, null);
			jContentPane.add(getJTextFieldValorPTHi(), null);
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
			jDateChooserFecha.setBounds(new Rectangle(490, 27, 187, 34));
		}
		return jDateChooserFecha;
	}

	/**
	 * This method initializes jTextFieldPAS
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldPAS() {
		if (jTextFieldPAS == null) {
			jTextFieldPAS = new JTextField();
			jTextFieldPAS.setBounds(new Rectangle(95, 90, 156, 26));
		}
		return jTextFieldPAS;
	}

	/**
	 * This method initializes jTextFieldPAD
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldPAD() {
		if (jTextFieldPAD == null) {
			jTextFieldPAD = new JTextField();
			jTextFieldPAD.setBounds(new Rectangle(95, 120, 156, 26));
		}
		return jTextFieldPAD;
	}

	/**
	 * This method initializes jTextFieldDIURESIS
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldDIURESIS() {
		if (jTextFieldDIURESIS == null) {
			jTextFieldDIURESIS = new JTextField();
			jTextFieldDIURESIS.setBounds(new Rectangle(95, 150, 156, 26));
		}
		return jTextFieldDIURESIS;
	}

	/**
	 * This method initializes jTextFieldPeso
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldPeso() {
		if (jTextFieldPeso == null) {
			jTextFieldPeso = new JTextField();
			jTextFieldPeso.setBounds(new Rectangle(95, 180, 156, 26));
		}
		return jTextFieldPeso;
	}

	/**
	 * This method initializes jTextFieldUrea
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldUrea() {
		if (jTextFieldUrea == null) {
			jTextFieldUrea = new JTextField();
			jTextFieldUrea.setBounds(new Rectangle(95, 210, 156, 26));
		}
		return jTextFieldUrea;
	}

	/**
	 * This method initializes jTextFieldCreatinina
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldCreatinina() {
		if (jTextFieldCreatinina == null) {
			jTextFieldCreatinina = new JTextField();
			jTextFieldCreatinina.setBounds(new Rectangle(95, 240, 156, 26));
		}
		return jTextFieldCreatinina;
	}

	/**
	 * This method initializes jTextFieldHT
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldHT() {
		if (jTextFieldHT == null) {
			jTextFieldHT = new JTextField();
			jTextFieldHT.setBounds(new Rectangle(95, 270, 156, 26));
		}
		return jTextFieldHT;
	}

	/**
	 * This method initializes jTextFieldHB
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldHB() {
		if (jTextFieldHB == null) {
			jTextFieldHB = new JTextField();
			jTextFieldHB.setBounds(new Rectangle(95, 300, 156, 26));
		}
		return jTextFieldHB;
	}

	/**
	 * This method initializes jTextFieldGB
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldGB() {
		if (jTextFieldGB == null) {
			jTextFieldGB = new JTextField();
			jTextFieldGB.setBounds(new Rectangle(95, 330, 156, 26));
		}
		return jTextFieldGB;
	}

	/**
	 * This method initializes jTextFieldPlaquetas
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldPlaquetas() {
		if (jTextFieldPlaquetas == null) {
			jTextFieldPlaquetas = new JTextField();
			jTextFieldPlaquetas.setBounds(new Rectangle(95, 360, 156, 26));
		}
		return jTextFieldPlaquetas;
	}

	/**
	 * This method initializes jTextFieldSodio
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldSodio() {
		if (jTextFieldSodio == null) {
			jTextFieldSodio = new JTextField();
			jTextFieldSodio.setBounds(new Rectangle(95, 390, 156, 26));
		}
		return jTextFieldSodio;
	}

	/**
	 * This method initializes jTextFieldPotasio
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldPotasio() {
		if (jTextFieldPotasio == null) {
			jTextFieldPotasio = new JTextField();
			jTextFieldPotasio.setBounds(new Rectangle(95, 420, 156, 26));
		}
		return jTextFieldPotasio;
	}

	/**
	 * This method initializes jTextFieldCloro
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldCloro() {
		if (jTextFieldCloro == null) {
			jTextFieldCloro = new JTextField();
			jTextFieldCloro.setBounds(new Rectangle(95, 450, 156, 26));
		}
		return jTextFieldCloro;
	}

	/**
	 * This method initializes jTextFieldCalcio
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldCalcio() {
		if (jTextFieldCalcio == null) {
			jTextFieldCalcio = new JTextField();
			jTextFieldCalcio.setBounds(new Rectangle(390, 90, 156, 26));
		}
		return jTextFieldCalcio;
	}

	/**
	 * This method initializes jTextFieldFosforo
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldFosforo() {
		if (jTextFieldFosforo == null) {
			jTextFieldFosforo = new JTextField();
			jTextFieldFosforo.setBounds(new Rectangle(390, 120, 156, 26));
		}
		return jTextFieldFosforo;
	}

	/**
	 * This method initializes jTextFieldGlicemia
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldGlicemia() {
		if (jTextFieldGlicemia == null) {
			jTextFieldGlicemia = new JTextField();
			jTextFieldGlicemia.setBounds(new Rectangle(390, 150, 156, 26));
		}
		return jTextFieldGlicemia;
	}

	/**
	 * This method initializes jTextFieldUricemia
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldUricemia() {
		if (jTextFieldUricemia == null) {
			jTextFieldUricemia = new JTextField();
			jTextFieldUricemia.setBounds(new Rectangle(390, 180, 156, 26));
		}
		return jTextFieldUricemia;
	}

	/**
	 * This method initializes jTextFieldProtU
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldProtU() {
		if (jTextFieldProtU == null) {
			jTextFieldProtU = new JTextField();
			jTextFieldProtU.setBounds(new Rectangle(390, 210, 156, 26));
		}
		return jTextFieldProtU;
	}

	/**
	 * This method initializes jTextFieldCCreatinina
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldCCreatinina() {
		if (jTextFieldCCreatinina == null) {
			jTextFieldCCreatinina = new JTextField();
			jTextFieldCCreatinina.setBounds(new Rectangle(390, 240, 156, 26));
		}
		return jTextFieldCCreatinina;
	}

	/**
	 * This method initializes jTextFieldCUrea
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldCUrea() {
		if (jTextFieldCUrea == null) {
			jTextFieldCUrea = new JTextField();
			jTextFieldCUrea.setBounds(new Rectangle(390, 270, 156, 26));
		}
		return jTextFieldCUrea;
	}

	/**
	 * This method initializes jTextFieldNaU
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldNaU() {
		if (jTextFieldNaU == null) {
			jTextFieldNaU = new JTextField();
			jTextFieldNaU.setBounds(new Rectangle(390, 300, 156, 26));
		}
		return jTextFieldNaU;
	}

	/**
	 * This method initializes jTextFieldKU
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldKU() {
		if (jTextFieldKU == null) {
			jTextFieldKU = new JTextField();
			jTextFieldKU.setBounds(new Rectangle(390, 330, 156, 26));
		}
		return jTextFieldKU;
	}

	/**
	 * This method initializes jTextFieldCyAPV
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldCyAPV() {
		if (jTextFieldCyAPV == null) {
			jTextFieldCyAPV = new JTextField();
			jTextFieldCyAPV.setBounds(new Rectangle(390, 360, 156, 26));
		}
		return jTextFieldCyAPV;
	}

	/**
	 * This method initializes jTextFieldCyAPP
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldCyAPP() {
		if (jTextFieldCyAPP == null) {
			jTextFieldCyAPP = new JTextField();
			jTextFieldCyAPP.setBounds(new Rectangle(390, 390, 156, 26));
		}
		return jTextFieldCyAPP;
	}

	/**
	 * This method initializes jTextFieldFkP
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldFkP() {
		if (jTextFieldFkP == null) {
			jTextFieldFkP = new JTextField();
			jTextFieldFkP.setBounds(new Rectangle(390, 420, 156, 26));
		}
		return jTextFieldFkP;
	}

	/**
	 * This method initializes jTextFieldMMFP
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldMMFP() {
		if (jTextFieldMMFP == null) {
			jTextFieldMMFP = new JTextField();
			jTextFieldMMFP.setBounds(new Rectangle(390, 450, 156, 26));
		}
		return jTextFieldMMFP;
	}

	/**
	 * This method initializes jTextFieldEveP
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldEveP() {
		if (jTextFieldEveP == null) {
			jTextFieldEveP = new JTextField();
			jTextFieldEveP.setBounds(new Rectangle(675, 90, 156, 26));
		}
		return jTextFieldEveP;
	}

	/**
	 * This method initializes jTextFieldBd
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldBd() {
		if (jTextFieldBd == null) {
			jTextFieldBd = new JTextField();
			jTextFieldBd.setBounds(new Rectangle(675, 120, 156, 26));
		}
		return jTextFieldBd;
	}

	/**
	 * This method initializes jTextFieldBi
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldBi() {
		if (jTextFieldBi == null) {
			jTextFieldBi = new JTextField();
			jTextFieldBi.setBounds(new Rectangle(675, 150, 156, 26));
		}
		return jTextFieldBi;
	}

	/**
	 * This method initializes jTextFieldTgo
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldTgo() {
		if (jTextFieldTgo == null) {
			jTextFieldTgo = new JTextField();
			jTextFieldTgo.setBounds(new Rectangle(675, 180, 156, 26));
		}
		return jTextFieldTgo;
	}

	/**
	 * This method initializes jTextFieldTgp
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldTgp() {
		if (jTextFieldTgp == null) {
			jTextFieldTgp = new JTextField();
			jTextFieldTgp.setBounds(new Rectangle(675, 210, 156, 26));
		}
		return jTextFieldTgp;
	}

	/**
	 * This method initializes jTextFieldGammagt
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldGammagt() {
		if (jTextFieldGammagt == null) {
			jTextFieldGammagt = new JTextField();
			jTextFieldGammagt.setBounds(new Rectangle(675, 240, 156, 26));
		}
		return jTextFieldGammagt;
	}

	/**
	 * This method initializes jTextFieldFAlc
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldFAlc() {
		if (jTextFieldFAlc == null) {
			jTextFieldFAlc = new JTextField();
			jTextFieldFAlc.setBounds(new Rectangle(675, 270, 156, 26));
		}
		return jTextFieldFAlc;
	}

	/**
	 * This method initializes jTextFieldTProt
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldTProt() {
		if (jTextFieldTProt == null) {
			jTextFieldTProt = new JTextField();
			jTextFieldTProt.setBounds(new Rectangle(675, 300, 156, 26));
		}
		return jTextFieldTProt;
	}

	/**
	 * This method initializes jTextFieldKppt
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldKppt() {
		if (jTextFieldKppt == null) {
			jTextFieldKppt = new JTextField();
			jTextFieldKppt.setBounds(new Rectangle(675, 330, 156, 26));
		}
		return jTextFieldKppt;
	}

	/**
	 * This method initializes jTextFieldHowell
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldHowell() {
		if (jTextFieldHowell == null) {
			jTextFieldHowell = new JTextField();
			jTextFieldHowell.setBounds(new Rectangle(675, 360, 156, 26));
		}
		return jTextFieldHowell;
	}

	/**
	 * This method initializes jTextFieldFibrinogeno
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldFibrinogeno() {
		if (jTextFieldFibrinogeno == null) {
			jTextFieldFibrinogeno = new JTextField();
			jTextFieldFibrinogeno.setBounds(new Rectangle(960, 330, 156, 26));
		}
		return jTextFieldFibrinogeno;
	}

	/**
	 * This method initializes jTextFieldColesterol
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldColesterol() {
		if (jTextFieldColesterol == null) {
			jTextFieldColesterol = new JTextField();
			jTextFieldColesterol.setBounds(new Rectangle(960, 90, 156, 26));
		}
		return jTextFieldColesterol;
	}

	/**
	 * This method initializes jTextFieldHdl
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldHdl() {
		if (jTextFieldHdl == null) {
			jTextFieldHdl = new JTextField();
			jTextFieldHdl.setBounds(new Rectangle(960, 120, 156, 26));
		}
		return jTextFieldHdl;
	}

	/**
	 * This method initializes jTextFieldLdl
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldLdl() {
		if (jTextFieldLdl == null) {
			jTextFieldLdl = new JTextField();
			jTextFieldLdl.setBounds(new Rectangle(960, 150, 156, 26));
		}
		return jTextFieldLdl;
	}

	/**
	 * This method initializes jTextFieldRAt
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldRAt() {
		if (jTextFieldRAt == null) {
			jTextFieldRAt = new JTextField();
			jTextFieldRAt.setBounds(new Rectangle(960, 180, 156, 26));
		}
		return jTextFieldRAt;
	}

	/**
	 * This method initializes jTextFieldTg
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldTg() {
		if (jTextFieldTg == null) {
			jTextFieldTg = new JTextField();
			jTextFieldTg.setBounds(new Rectangle(960, 210, 156, 26));
		}
		return jTextFieldTg;
	}

	/**
	 * This method initializes jTextFieldHNA1C
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldHNA1C() {
		if (jTextFieldHNA1C == null) {
			jTextFieldHNA1C = new JTextField();
			jTextFieldHNA1C.setBounds(new Rectangle(960, 240, 156, 26));
		}
		return jTextFieldHNA1C;
	}

	/**
	 * This method initializes jTextFieldAlbulimia
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldAlbulimia() {
		if (jTextFieldAlbulimia == null) {
			jTextFieldAlbulimia = new JTextField();
			jTextFieldAlbulimia.setBounds(new Rectangle(960, 270, 156, 26));
		}
		return jTextFieldAlbulimia;
	}

	/**
	 * This method initializes jTextFieldGlobulinas
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldGlobulinas() {
		if (jTextFieldGlobulinas == null) {
			jTextFieldGlobulinas = new JTextField();
			jTextFieldGlobulinas.setBounds(new Rectangle(960, 300, 156, 26));
		}
		return jTextFieldGlobulinas;
	}

	/**
	 * This method initializes jScrollPaneOtros
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneOtros() {
		if (jScrollPaneOtros == null) {
			jScrollPaneOtros = new JScrollPane();
			jScrollPaneOtros.setBounds(new Rectangle(682, 426, 441, 113));
			jScrollPaneOtros.setViewportView(getJTextAreaOtros());
		}
		return jScrollPaneOtros;
	}

	/**
	 * This method initializes jTextAreaOtros
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextAreaOtros() {
		if (jTextAreaOtros == null) {
			jTextAreaOtros = new JTextArea();
		}
		return jTextAreaOtros;
	}

	/**
	 * This method initializes jButtonGuardar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonGuardar() {
		if (jButtonGuardar == null) {
			jButtonGuardar = new JButton();
			jButtonGuardar.setBounds(new Rectangle(918, 541, 170, 35));
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

	/**
	 * This method initializes jButtonCancelar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setBounds(new Rectangle(49, 541, 170, 35));
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salir();
				}
			});
		}
		return jButtonCancelar;
	}

	private void guardar(){
		EvolucionTrasplante usado = this.chequear();
		if(usado != null){
			if(chequearFecha()){
				//Si esta ingresando tengo que chequear que no existe otro con la misma fecha.
				usado.setFecha(this.jDateChooserFecha.getCalendar());
				usado.setIdTrasplante(this.t.getId());
				boolean guardar = true;
				if(this.ingresar){
					if(Fachada.getInstancia().existeEvolucionTrasplante(usado)){
						JOptionPane.showMessageDialog(this,"Ya existe una evolucion clasica para esa fecha.", "Error", 2);
						guardar = false;
						return;
					}
				}
				if(guardar){
					usado.setOtros(this.jTextAreaOtros.getText());
					usado.setPthi((String)this.jComboBoxpthi.getSelectedItem());
					Fachada.getInstancia().guardarEvolucionSimple(usado);
					this.et = usado;
					salir();
				}
			}else{
				JOptionPane.showMessageDialog(this,"La fecha tiene que ser mayor a la del dia del trasplante", "Error", 2);
			}
		}
	}
	
	private void salir(){
		this.dispose();
	}
	private boolean chequearFecha(){
		if(this.t.getFecha().before(this.jDateChooserFecha.getCalendar())){
			return true;
		}else{
			return false;
		}
	}
	private EvolucionTrasplante chequear() {
		String lugar = "";
		try {
			EvolucionTrasplante nuevo = new EvolucionTrasplante();
			lugar = "PAS";
			String aux = this.jTextFieldPAS.getText();
			if(aux.isEmpty()) aux = "0";
			double num = Double.parseDouble(aux);
			nuevo.setPas(num);
			lugar = "PAD";
			aux = this.jTextFieldPAD.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setPad(num);
			lugar = "Diuresis";
			aux = this.jTextFieldDIURESIS.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setDiuresis(num);
			lugar = "Peso";
			aux = this.jTextFieldPeso.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setPeso(num);
			lugar = "Urea";
			aux = this.jTextFieldUrea.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setUrea(num);
			lugar = "Creatinina";
			aux = this.jTextFieldCreatinina.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setCreatinina(num);
			lugar = "HT";
			aux = this.jTextFieldHT.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setHt(num);
			lugar = "HB";
			aux = this.jTextFieldHB.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setHb(num);
			lugar = "GB";
			aux = this.jTextFieldGB.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setGb(num);
			lugar = "Plaquetas";
			aux = this.jTextFieldPlaquetas.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setPlaquetas(num);
			lugar = "Sodio";
			aux = this.jTextFieldSodio.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setSodio(num);
			lugar = "Potasio";
			aux = this.jTextFieldPotasio.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setPotasio(num);
			lugar = "Cloro";
			aux = this.jTextFieldCloro.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setCloro(num);
			lugar = "Calcio";
			aux = this.jTextFieldCalcio.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setCalcio(num);
			lugar = "Fosforo";
			aux = this.jTextFieldFosforo.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setFosforo(num);
			lugar = "Glicemia";
			aux = this.jTextFieldGlicemia.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setGlicemia(num);
			lugar = "Uricemia";
			aux = this.jTextFieldUricemia.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setUricemia(num);
			lugar = "Prot U";
			aux = this.jTextFieldProtU.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setProtU(num);
			lugar = "C Creatinina";
			aux = this.jTextFieldCCreatinina.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setCCreatinina(num);
			lugar = "C Urea";
			aux = this.jTextFieldCUrea.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setCUrea(num);
			lugar = "Na U";
			aux = this.jTextFieldNaU.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setNaU(num);
			lugar = "K U";
			aux = this.jTextFieldKU.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setKU(num);
			lugar = "CyA PV";
			aux = this.jTextFieldCyAPV.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setCyaPV(num);
			lugar = "CyA PP";
			aux = this.jTextFieldCyAPP.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setCyaPP(num);
			lugar = "Fk P";
			aux = this.jTextFieldFkP.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setFkP(num);
			lugar = "MMF P";
			aux = this.jTextFieldMMFP.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setMfmP(num);
			lugar = "EVE P";
			aux = this.jTextFieldEveP.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setEveP(num);
			lugar = "BD";
			aux = this.jTextFieldBd.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setBd(num);
			lugar = "BI";
			aux = this.jTextFieldBi.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setBi(num);
			lugar = "Tgo";
			aux = this.jTextFieldTgo.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setTgo(num);
			lugar = "Tgp";
			aux = this.jTextFieldTgp.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setTgp(num);
			lugar = "Gamma Gt";
			aux = this.jTextFieldGammagt.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setGammagt(num);
			lugar = "F Alc";
			aux = this.jTextFieldFAlc.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setFAlc(num);
			lugar = "T Prot";
			aux = this.jTextFieldTProt.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setTProt(num);
			lugar = "Kppt";
			aux = this.jTextFieldKppt.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setKptt(num);
			lugar = "Howell";
			aux = this.jTextFieldHowell.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setHowell(num);
			lugar = "Colesterol";
			aux = this.jTextFieldColesterol.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setColesterol(num);
			lugar = "Hdl";
			aux = this.jTextFieldHdl.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setHdl(num);
			lugar = "Ldl";
			aux = this.jTextFieldLdl.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setLdl(num);
			lugar = "R At";
			aux = this.jTextFieldRAt.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setRAt(num);
			lugar = "Tg";
			aux = this.jTextFieldTg.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setTg(num);
			lugar = "HNA1C";
			aux = this.jTextFieldHNA1C.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setHna1c(num);
			lugar = "Albulimia";
			aux = this.jTextFieldAlbulimia.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setAlbumina(num);
			lugar = "Globulinas";
			aux = this.jTextFieldGlobulinas.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setGlobulinas(num);
			lugar = "Fibrinogeno";
			aux = this.jTextFieldFibrinogeno.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setFibrinogeno(num);
			lugar = "Valor PTHi";
			aux = this.jTextFieldValorPTHi.getText();
			if(aux.isEmpty()) aux = "0";
			num = Double.parseDouble(aux);
			nuevo.setNumPthi(num);
			return nuevo;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"Dato mal ingresado en " + lugar, "Error", 2);
			return null;
		}

	}

	/**
	 * This method initializes jComboBoxpthi	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxpthi() {
		if (jComboBoxpthi == null) {
			jComboBoxpthi = new JComboBox();
			jComboBoxpthi.setBounds(new Rectangle(960, 360, 156, 26));
		}
		return jComboBoxpthi;
	}

	/**
	 * This method initializes jTextFieldValorPTHi	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldValorPTHi() {
		if (jTextFieldValorPTHi == null) {
			jTextFieldValorPTHi = new JTextField();
			jTextFieldValorPTHi.setBounds(new Rectangle(960, 393, 155, 24));
		}
		return jTextFieldValorPTHi;
	}
} // @jve:decl-index=0:visual-constraint="10,10"
