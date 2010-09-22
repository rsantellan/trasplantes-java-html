package iu.paciente;

import iu.trasplante.IUTrasplanteManejar;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import uy.transplante.dominio.Paciente;
import uy.transplante.dominio.PacientePreTrasplante;
import uy.transplante.dominio.Trasplante;

import logica.Fachada;

import com.toedter.calendar.JDateChooser;


public class IUPacientePreTrasplante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelFechaIngresoLista = null;
	private JDateChooser jDateChooserFechaIngresoLista = null;
	private JLabel jLabelModalidad = null;
	private JComboBox jComboBoxModalidad = null;
	private JCheckBox jCheckBoxPBR = null;
	private JCheckBox jCheckBoxHTA = null;
	private JCheckBox jCheckBoxObesidad = null;
	private JCheckBox jCheckBoxDislipemia = null;
	private JCheckBox jCheckBoxTabaquismo = null;
	private JLabel jLabelOrigen = null;
	private JComboBox jComboBoxOrigen = null;
	private JLabel jLabelIMC = null;
	private JComboBox jComboBoxIMC = null;
	private JButton jButtonCancelar = null;
	private JButton jButtonGuardar = null;
	private JLabel jLabelDiabetes = null;
	private JComboBox jComboBoxDiabetes = null;
	private Paciente paciente;
	private PacientePreTrasplante pt = null;
	private JLabel jLabelMesesEnLista = null;
	private boolean continuar = true;
	private JCheckBox jCheckBoxIam = null;
	private JCheckBox jCheckBoxAve = null;
	private JCheckBox jCheckBoxRevascCardio = null;

	/**
	 * This is the default constructor
	 */
	public IUPacientePreTrasplante(Paciente p) {
		super();
		initialize();
		cargarDatos();
		this.paciente = p;
		this.jLabelMesesEnLista.setVisible(false);
	}

	public IUPacientePreTrasplante(Paciente p, PacientePreTrasplante pt, boolean ver) {
		super();
		initialize();
		cargarDatos();
		this.paciente = p;
		this.pt = pt;
		cargarTodo();
		this.continuar = false;
		if(ver){
			this.jButtonGuardar.setVisible(false);
			this.jLabelMesesEnLista.setVisible(true);
			this.jLabelMesesEnLista.setText("Meses en lista : " + String.valueOf(pt.getMeses()));
			
		}else{
			this.jLabelMesesEnLista.setVisible(false);
		}
	}
	
	private void cargarTodo(){
		this.jDateChooserFechaIngresoLista.setCalendar(this.pt.getFecha_ingreso_lista());
		this.jComboBoxModalidad.setSelectedItem(this.pt.getModalidad_d());
		this.jCheckBoxDislipemia.setSelected(this.pt.isDislipemia());
		this.jCheckBoxHTA.setSelected(this.pt.isHta());
		this.jCheckBoxObesidad.setSelected(this.pt.isObesidad());
		this.jCheckBoxPBR.setSelected(this.pt.isPbr());
		this.jCheckBoxTabaquismo.setSelected(this.pt.isTabaquismo());
		this.jComboBoxDiabetes.setSelectedItem(this.pt.getDiabetes());
		this.jComboBoxOrigen.setSelectedItem(this.pt.getOrigen());
		this.jComboBoxIMC.setSelectedItem(this.pt.getImc());
		this.getJCheckBoxAve().setSelected(this.pt.isAve());
		this.getJCheckBoxIam().setSelected(this.pt.isIam());
		this.getJCheckBoxRevascCardio().setSelected(this.pt.isRevascCardio());
	}
	
	private void cargarDatos(){
		//Modalidad
		this.jComboBoxModalidad.addItem("HD");
		this.jComboBoxModalidad.addItem("DPCA");
		this.jComboBoxModalidad.addItem("HD+DPCA");
		this.jComboBoxModalidad.addItem("TR");
		this.jComboBoxModalidad.addItem("HD+TR");
		this.jComboBoxModalidad.addItem("DPCA+TR");
		this.jComboBoxModalidad.addItem("HD+TR+DPCA");
		this.jComboBoxModalidad.addItem("TM");
		//IMC
		this.jComboBoxIMC.addItem("<20");
		this.jComboBoxIMC.addItem("entre 20 y 25");
		this.jComboBoxIMC.addItem(">25");
		//Origen
		this.jComboBoxOrigen.addItem("MSP");
		this.jComboBoxOrigen.addItem("IAMC");
		this.jComboBoxOrigen.addItem("Otra");
		//Diabetes
		this.jComboBoxDiabetes.addItem("No");
		this.jComboBoxDiabetes.addItem("Tipo I");
		this.jComboBoxDiabetes.addItem("Tipo II");
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(418, 427);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Paciente pre Trasplante");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelMesesEnLista = new JLabel();
			jLabelMesesEnLista.setBounds(new Rectangle(15, 53, 136, 26));
			jLabelMesesEnLista.setText("Meses en Lista :");
			jLabelDiabetes = new JLabel();
			jLabelDiabetes.setBounds(new Rectangle(12, 189, 126, 31));
			jLabelDiabetes.setText("Diabetes :");
			jLabelIMC = new JLabel();
			jLabelIMC.setBounds(new Rectangle(11, 269, 123, 31));
			jLabelIMC.setText(" IMC :");
			jLabelOrigen = new JLabel();
			jLabelOrigen.setBounds(new Rectangle(11, 232, 122, 29));
			jLabelOrigen.setText("Origen");
			jLabelModalidad = new JLabel();
			jLabelModalidad.setBounds(new Rectangle(12, 84, 138, 30));
			jLabelModalidad.setText("Modalidad D");
			jLabelFechaIngresoLista = new JLabel();
			jLabelFechaIngresoLista.setBounds(new Rectangle(15, 16, 137, 30));
			jLabelFechaIngresoLista.setText("Fecha Ingreso Lista");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 204));
			jContentPane.add(jLabelFechaIngresoLista, null);
			jContentPane.add(getJDateChooserFechaIngresoLista(), null);
			jContentPane.add(jLabelModalidad, null);
			jContentPane.add(getJComboBoxModalidad(), null);
			jContentPane.add(getJCheckBoxPBR(), null);
			jContentPane.add(getJCheckBoxHTA(), null);
			jContentPane.add(getJCheckBoxObesidad(), null);
			jContentPane.add(getJCheckBoxDislipemia(), null);
			jContentPane.add(getJCheckBoxTabaquismo(), null);
			jContentPane.add(jLabelOrigen, null);
			jContentPane.add(getJComboBoxOrigen(), null);
			jContentPane.add(jLabelIMC, null);
			jContentPane.add(getJComboBoxIMC(), null);
			jContentPane.add(getJButtonCancelar(), null);
			jContentPane.add(getJButtonGuardar(), null);
			jContentPane.add(jLabelDiabetes, null);
			jContentPane.add(getJComboBoxDiabetes(), null);
			jContentPane.add(jLabelMesesEnLista, null);
			jContentPane.add(getJCheckBoxIam(), null);
			jContentPane.add(getJCheckBoxAve(), null);
			jContentPane.add(getJCheckBoxRevascCardio(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jDateChooserFechaIngresoLista	
	 * 	
	 * @return com.toedter.calendar.JDateChooser	
	 */
	private JDateChooser getJDateChooserFechaIngresoLista() {
		if (jDateChooserFechaIngresoLista == null) {
			jDateChooserFechaIngresoLista = new JDateChooser();
			jDateChooserFechaIngresoLista.setBounds(new Rectangle(180, 16, 167, 29));
		}
		return jDateChooserFechaIngresoLista;
	}

	/**
	 * This method initializes jComboBoxModalidad	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxModalidad() {
		if (jComboBoxModalidad == null) {
			jComboBoxModalidad = new JComboBox();
			jComboBoxModalidad.setBounds(new Rectangle(177, 84, 168, 30));
		}
		return jComboBoxModalidad;
	}

	/**
	 * This method initializes jCheckBoxPBR	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPBR() {
		if (jCheckBoxPBR == null) {
			jCheckBoxPBR = new JCheckBox();
			jCheckBoxPBR.setBounds(new Rectangle(12, 128, 74, 18));
			jCheckBoxPBR.setText("PBR");
			jCheckBoxPBR.setBackground(new Color(255, 255, 204));
		}
		return jCheckBoxPBR;
	}

	/**
	 * This method initializes jCheckBoxHTA	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxHTA() {
		if (jCheckBoxHTA == null) {
			jCheckBoxHTA = new JCheckBox();
			jCheckBoxHTA.setBounds(new Rectangle(105, 127, 57, 20));
			jCheckBoxHTA.setText("HTA");
			jCheckBoxHTA.setBackground(new Color(255, 255, 204));
		}
		return jCheckBoxHTA;
	}

	/**
	 * This method initializes jCheckBoxObesidad	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxObesidad() {
		if (jCheckBoxObesidad == null) {
			jCheckBoxObesidad = new JCheckBox();
			jCheckBoxObesidad.setBounds(new Rectangle(177, 129, 89, 18));
			jCheckBoxObesidad.setText("Obesidad");
			jCheckBoxObesidad.setBackground(new Color(255, 255, 204));
		}
		return jCheckBoxObesidad;
	}

	/**
	 * This method initializes jCheckBoxDislipemia	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxDislipemia() {
		if (jCheckBoxDislipemia == null) {
			jCheckBoxDislipemia = new JCheckBox();
			jCheckBoxDislipemia.setBounds(new Rectangle(281, 129, 104, 17));
			jCheckBoxDislipemia.setText("Dislipemia");
			jCheckBoxDislipemia.setBackground(new Color(255, 255, 204));
		}
		return jCheckBoxDislipemia;
	}

	/**
	 * This method initializes jCheckBoxTabaquismo	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTabaquismo() {
		if (jCheckBoxTabaquismo == null) {
			jCheckBoxTabaquismo = new JCheckBox();
			jCheckBoxTabaquismo.setBounds(new Rectangle(11, 158, 117, 17));
			jCheckBoxTabaquismo.setText("Tabaquismo");
			jCheckBoxTabaquismo.setBackground(new Color(255, 255, 204));
		}
		return jCheckBoxTabaquismo;
	}

	/**
	 * This method initializes jComboBoxOrigen	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxOrigen() {
		if (jComboBoxOrigen == null) {
			jComboBoxOrigen = new JComboBox();
			jComboBoxOrigen.setBounds(new Rectangle(162, 231, 179, 30));
		}
		return jComboBoxOrigen;
	}

	/**
	 * This method initializes jComboBoxIMC	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxIMC() {
		if (jComboBoxIMC == null) {
			jComboBoxIMC = new JComboBox();
			jComboBoxIMC.setBounds(new Rectangle(163, 270, 180, 28));
		}
		return jComboBoxIMC;
	}

	/**
	 * This method initializes jButtonCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setBounds(new Rectangle(6, 320, 137, 26));
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
			jButtonGuardar.setBounds(new Rectangle(214, 322, 137, 26));
			jButtonGuardar.setText("Guardar");
			jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					guardar();
				}
			});
		}
		return jButtonGuardar;
	}


	/**
	 * This method initializes jComboBoxDiabetes	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxDiabetes() {
		if (jComboBoxDiabetes == null) {
			jComboBoxDiabetes = new JComboBox();
			jComboBoxDiabetes.setBounds(new Rectangle(162, 189, 181, 33));
		}
		return jComboBoxDiabetes;
	}

	private void salir(){
		this.dispose();
	}
	
	private void guardar(){
		PacientePreTrasplante aux = new PacientePreTrasplante();
		if(this.pt != null){
			aux.setId(this.pt.getId());
		}
		aux.setThe(this.paciente.getThe());
		aux.setFecha_ingreso_lista(this.jDateChooserFechaIngresoLista.getCalendar());
		aux.setModalidad_d((String)this.jComboBoxModalidad.getSelectedItem());
		aux.setPbr(this.jCheckBoxPBR.isSelected());
		aux.setHta(this.jCheckBoxHTA.isSelected());
		aux.setObesidad(this.jCheckBoxObesidad.isSelected());
		aux.setDislipemia(this.jCheckBoxDislipemia.isSelected());
		aux.setDiabetes((String)this.jComboBoxDiabetes.getSelectedItem());
		aux.setOrigen((String)this.jComboBoxOrigen.getSelectedItem());
		aux.setTabaquismo(this.jCheckBoxTabaquismo.isSelected());
		aux.setImc((String)this.jComboBoxIMC.getSelectedItem());
		aux.setIam(this.getJCheckBoxIam().isSelected());
		aux.setAve(this.getJCheckBoxAve().isSelected());
		aux.setRevascCardio(this.getJCheckBoxRevascCardio().isSelected());
		if(aux.getFecha_ingreso_lista().after(this.paciente.getFecha_dialisis())){
			Fachada.getInstancia().guardarPreTrasplante(this.paciente,aux);
			if(this.continuar){
				aux.leerMinimo();
				Trasplante unTr = new Trasplante();
				aux.setTrasplante(unTr);
				IUTrasplanteManejar iuTr = new IUTrasplanteManejar(this.paciente,aux,false);
				iuTr.setVisible(true);
			}
			this.salir();
		}
	}

	/**
	 * This method initializes jCheckBoxIam	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxIam() {
		if (jCheckBoxIam == null) {
			jCheckBoxIam = new JCheckBox();
			jCheckBoxIam.setBounds(new Rectangle(124, 158, 60, 17));
			jCheckBoxIam.setText("IAM");
			jCheckBoxIam.setBackground(new Color(255, 255, 204));
		}
		return jCheckBoxIam;
	}

	/**
	 * This method initializes jCheckBoxAve	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxAve() {
		if (jCheckBoxAve == null) {
			jCheckBoxAve = new JCheckBox();
			jCheckBoxAve.setBounds(new Rectangle(178, 158, 60, 17));
			jCheckBoxAve.setText("AVE");
			jCheckBoxAve.setBackground(new Color(255, 255, 204));
		}
		return jCheckBoxAve;
	}

	/**
	 * This method initializes jCheckBoxRevascCardio	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxRevascCardio() {
		if (jCheckBoxRevascCardio == null) {
			jCheckBoxRevascCardio = new JCheckBox();
			jCheckBoxRevascCardio.setBounds(new Rectangle(241, 158, 130, 17));
			jCheckBoxRevascCardio.setText("Revasc Cardio");
			jCheckBoxRevascCardio.setBackground(new Color(255, 255, 204));
		}
		return jCheckBoxRevascCardio;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
