package iu.evolucion;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import uy.transplante.dominio.EvolucionTrasplanteNutricion;

import logica.Fachada;

import com.toedter.calendar.JDateChooser;


public class IUEvolucionNutricionManejar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelFecha = null;
	private JDateChooser jDateChooserFecha = null;
	private JButton jButtonSalir = null;
	private JButton jButtonGuardar = null;
	private int idTrasplante;
	private JLabel jLabelTalla = null;
	private JTextField jTextFieldTalla = null;
	private JLabel jLabelLateralizado = null;
	private JComboBox jComboBoxEstructuraOsea = null;
	private JLabel jLabelImpresion = null;
	private JComboBox jComboBoxImpresion = null;
	private JLabel jLabelPesoDeseado = null;
	private JTextField jTextFieldPesoDeseado = null;
	private JLabel jLabelPesoReal = null;
	private JTextField jTextFieldPesoReal = null;
	private JLabel jLabelPTricipal = null;
	private JTextField jTextFieldPesoTricipital = null;
	private JLabel jLabelPTricipalP = null;
	private JComboBox jComboBoxPTricipital = null;
	private JLabel jLabelPSubEscapular = null;
	private JTextField jTextFieldPesoSubEscapular = null;
	private JLabel jLabelPSubEscapularP = null;
	private JComboBox jComboBoxPSubEscapular = null;
	private JLabel jLabelSumPliegues = null;
	private JTextField jTextFieldSumaPliegues = null;
	private JLabel jLabelPSumPliegues = null;
	private JComboBox jComboBoxSumaPliegues = null;
	private JLabel jLabelCFBrazo = null;
	private JTextField jTextFieldCFBrazo = null;
	private JLabel jLabelPCFBrazo = null;
	private JComboBox jComboBoxPCFBrazo = null;
	private JLabel jLabelCFMuscBrazo = null;
	private JTextField jTextFieldCFMuscBrazo = null;
	private JLabel jLabelPCFMuscBrazo = null;
	private JComboBox jComboBoxPCFMuscBrazo = null;
	private JLabel jLabelAreaBrazo = null;
	private JTextField jTextFieldAreaBrazo = null;
	private JLabel jLabelAreaMuscBrazo = null;
	private JTextField jTextFieldAreaMuscBrazo = null;
	private JLabel jLabelPAreaMuscBrazo = null;
	private JComboBox jComboBoxPAreaMuscBrazo = null;
	private JLabel jLabelAreaGrasaBrazo = null;
	private JTextField jTextFieldAreaGrasaBrazo = null;
	private JLabel jLabelPAreaGrasaBrazo = null;
	private JComboBox jComboBoxPAreaGrasaBrazo = null;
	private JLabel jLabelAreaCinturaCadera = null;
	private JTextField jTextFieldRCinturaCadera = null;
	private JLabel jLabelDiagNutricional = null;
	private JComboBox jComboBoxDiagNutricional = null;
	/**
	 * This is the default constructor
	 */
	public IUEvolucionNutricionManejar(int idTrasplante,EvolucionTrasplanteNutricion e, Calendar fecha) {
		super();
		initialize();
		this.jDateChooserFecha.setCalendar(fecha);
		this.jDateChooserFecha.setEnabled(false);
		this.idTrasplante = idTrasplante;
		cargarCombos();
		if(e!=null){
			this.cargarDatos(e);
		}else{
			this.cargarVacio();
		}
	}
	
	public IUEvolucionNutricionManejar(int idTrasplante,EvolucionTrasplanteNutricion e, Calendar fecha,boolean ver) {
		super();
		initialize();
		this.jDateChooserFecha.setCalendar(fecha);
		this.jDateChooserFecha.setEnabled(false);
		this.idTrasplante = idTrasplante;
		cargarCombos();
		this.jButtonGuardar.setVisible(false);
		if(e!=null){
			this.cargarDatos(e);
		}else{
			this.cargarVacio();
		}
	}
	
	private void cargarVacio(){
		this.jTextFieldTalla.setText(String.valueOf(0));
		this.jTextFieldPesoDeseado.setText(String.valueOf(0));
		this.jTextFieldPesoReal.setText(String.valueOf(0));
		this.jComboBoxEstructuraOsea.setSelectedItem(0);
		this.jComboBoxImpresion.setSelectedItem(0);
		this.jTextFieldPesoTricipital.setText(String.valueOf(0));
		this.jTextFieldPesoSubEscapular.setText(String.valueOf(0));
		this.jTextFieldSumaPliegues.setText(String.valueOf(0));
		this.jTextFieldCFBrazo.setText(String.valueOf(0));
		this.jTextFieldCFMuscBrazo.setText(String.valueOf(0));
		this.jTextFieldAreaBrazo.setText(String.valueOf(0));
		this.jTextFieldAreaMuscBrazo.setText(String.valueOf(0));
		this.jTextFieldAreaGrasaBrazo.setText(String.valueOf(0));
		this.jTextFieldRCinturaCadera.setText(String.valueOf(0));
	}
	private void cargarCombos(){
		this.jComboBoxEstructuraOsea.addItem("Pequeña");
		this.jComboBoxEstructuraOsea.addItem("Mediana");
		this.jComboBoxEstructuraOsea.addItem("Grande");
		
		this.jComboBoxImpresion.addItem("Adelgazado");
		this.jComboBoxImpresion.addItem("Normopeso");
		this.jComboBoxImpresion.addItem("Sobrepeso");
		this.jComboBoxImpresion.addItem("Obesidad");
		
		this.jComboBoxPTricipital.addItem("<10");
		this.jComboBoxPTricipital.addItem("10-25");
		this.jComboBoxPTricipital.addItem("26-50");
		this.jComboBoxPTricipital.addItem("51-75");
		this.jComboBoxPTricipital.addItem("76-91");
		this.jComboBoxPTricipital.addItem(">90");
		
		this.jComboBoxPSubEscapular.addItem("<10");
		this.jComboBoxPSubEscapular.addItem("10-25");
		this.jComboBoxPSubEscapular.addItem("26-50");
		this.jComboBoxPSubEscapular.addItem("51-75");
		this.jComboBoxPSubEscapular.addItem("76-91");
		this.jComboBoxPSubEscapular.addItem(">90");
		
		this.jComboBoxSumaPliegues.addItem("<10");
		this.jComboBoxSumaPliegues.addItem("10-25");
		this.jComboBoxSumaPliegues.addItem("26-50");
		this.jComboBoxSumaPliegues.addItem("51-75");
		this.jComboBoxSumaPliegues.addItem("76-91");
		this.jComboBoxSumaPliegues.addItem(">90");
		
		this.jComboBoxPCFBrazo.addItem("<10");
		this.jComboBoxPCFBrazo.addItem("10-25");
		this.jComboBoxPCFBrazo.addItem("26-50");
		this.jComboBoxPCFBrazo.addItem("51-75");
		this.jComboBoxPCFBrazo.addItem("76-91");
		this.jComboBoxPCFBrazo.addItem(">90");
		
		this.jComboBoxPCFMuscBrazo.addItem("<10");
		this.jComboBoxPCFMuscBrazo.addItem("10-25");
		this.jComboBoxPCFMuscBrazo.addItem("26-50");
		this.jComboBoxPCFMuscBrazo.addItem("51-75");
		this.jComboBoxPCFMuscBrazo.addItem("76-91");
		this.jComboBoxPCFMuscBrazo.addItem(">90");
		
		this.jComboBoxPAreaMuscBrazo.addItem("<10");
		this.jComboBoxPAreaMuscBrazo.addItem("10-25");
		this.jComboBoxPAreaMuscBrazo.addItem("26-50");
		this.jComboBoxPAreaMuscBrazo.addItem("51-75");
		this.jComboBoxPAreaMuscBrazo.addItem("76-91");
		this.jComboBoxPAreaMuscBrazo.addItem(">90");
		
		this.jComboBoxPAreaGrasaBrazo.addItem("<10");
		this.jComboBoxPAreaGrasaBrazo.addItem("10-25");
		this.jComboBoxPAreaGrasaBrazo.addItem("26-50");
		this.jComboBoxPAreaGrasaBrazo.addItem("51-75");
		this.jComboBoxPAreaGrasaBrazo.addItem("76-91");
		this.jComboBoxPAreaGrasaBrazo.addItem(">90");

		this.jComboBoxDiagNutricional.addItem("Desnleve");
		this.jComboBoxDiagNutricional.addItem("Desnmoderada");
		this.jComboBoxDiagNutricional.addItem("Desnsevera");
		this.jComboBoxDiagNutricional.addItem("Normopeso");
		this.jComboBoxDiagNutricional.addItem("Sobrepeso");
		this.jComboBoxDiagNutricional.addItem("Obesidad");
	}
	private void cargarDatos(EvolucionTrasplanteNutricion e){
		this.jTextFieldTalla.setText(String.valueOf(e.getTalla()));
		this.jTextFieldPesoDeseado.setText(String.valueOf(e.getPesoDeseado()));
		this.jTextFieldPesoReal.setText(String.valueOf(e.getPesoReal()));
		this.jComboBoxEstructuraOsea.setSelectedItem(e.getEstructuraOsea());
		this.jComboBoxImpresion.setSelectedItem(e.getImpresion());
		this.jTextFieldPesoTricipital.setText(String.valueOf(e.getPTricipital()));
		this.jComboBoxPTricipital.setSelectedItem(e.getPTricipitalP());
		this.jTextFieldPesoSubEscapular.setText(String.valueOf(e.getPSubEscapular()));
		this.jComboBoxPSubEscapular.setSelectedItem(e.getPSubEscapularP());
		this.jTextFieldSumaPliegues.setText(String.valueOf(e.getSumPliegues()));
		this.jComboBoxSumaPliegues.setSelectedItem(e.getPSumPliegues());
		this.jTextFieldCFBrazo.setText(String.valueOf(e.getCfBrazo()));
		this.jComboBoxPCFBrazo.setSelectedItem(e.getPCfBrazo());
		this.jTextFieldCFMuscBrazo.setText(String.valueOf(e.getCfMuscBrazo()));
		this.jComboBoxPCFMuscBrazo.setSelectedItem(e.getPCfMuscBrazo());
		this.jTextFieldAreaBrazo.setText(String.valueOf(e.getAreaBrazo()));
		this.jTextFieldAreaMuscBrazo.setText(String.valueOf(e.getAreaMuscBrazo()));
		this.jComboBoxPAreaMuscBrazo.setSelectedItem(e.getPAreaMuscBrazo());
		this.jTextFieldAreaGrasaBrazo.setText(String.valueOf(e.getAreaGrasaBrazo()));
		this.jComboBoxPAreaGrasaBrazo.setSelectedItem(e.getAreaGrasaBrazo());
		this.jTextFieldRCinturaCadera.setText(String.valueOf(e.getRCinturaCadera()));
		this.jComboBoxDiagNutricional.setSelectedItem(e.getDiagNutricional());
	}


	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(745, 612);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Evolucion Nutricion");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelDiagNutricional = new JLabel();
			jLabelDiagNutricional.setBounds(new Rectangle(21, 481, 147, 28));
			jLabelDiagNutricional.setText("Diagnostico Nutricional :");
			jLabelAreaCinturaCadera = new JLabel();
			jLabelAreaCinturaCadera.setBounds(new Rectangle(359, 444, 140, 25));
			jLabelAreaCinturaCadera.setText("Radio Cintura Cadera :");
			jLabelPAreaGrasaBrazo = new JLabel();
			jLabelPAreaGrasaBrazo.setBounds(new Rectangle(21, 444, 145, 24));
			jLabelPAreaGrasaBrazo.setText("P Area Grasa Brazo :");
			jLabelAreaGrasaBrazo = new JLabel();
			jLabelAreaGrasaBrazo.setBounds(new Rectangle(362, 404, 131, 28));
			jLabelAreaGrasaBrazo.setText("Area Grasa Brazo :");
			jLabelPAreaMuscBrazo = new JLabel();
			jLabelPAreaMuscBrazo.setBounds(new Rectangle(22, 404, 143, 30));
			jLabelPAreaMuscBrazo.setText("P Area Musculo Brazo :");
			jLabelAreaMuscBrazo = new JLabel();
			jLabelAreaMuscBrazo.setBounds(new Rectangle(361, 364, 128, 27));
			jLabelAreaMuscBrazo.setText("Area Musculo Brazo :");
			jLabelAreaBrazo = new JLabel();
			jLabelAreaBrazo.setBounds(new Rectangle(24, 368, 139, 25));
			jLabelAreaBrazo.setText("Area Brazo :");
			jLabelPCFMuscBrazo = new JLabel();
			jLabelPCFMuscBrazo.setBounds(new Rectangle(363, 322, 134, 25));
			jLabelPCFMuscBrazo.setText("P CF Musculo Brazo :");
			jLabelCFMuscBrazo = new JLabel();
			jLabelCFMuscBrazo.setBounds(new Rectangle(29, 325, 134, 29));
			jLabelCFMuscBrazo.setText("Cf Musculo Brazo :");
			jLabelPCFBrazo = new JLabel();
			jLabelPCFBrazo.setBounds(new Rectangle(364, 285, 129, 24));
			jLabelPCFBrazo.setText("P CF Brazo :");
			jLabelCFBrazo = new JLabel();
			jLabelCFBrazo.setBounds(new Rectangle(30, 288, 130, 26));
			jLabelCFBrazo.setText("Cf Brazo :");
			jLabelPSumPliegues = new JLabel();
			jLabelPSumPliegues.setBounds(new Rectangle(365, 251, 125, 25));
			jLabelPSumPliegues.setText("Suma Pliegues :");
			jLabelSumPliegues = new JLabel();
			jLabelSumPliegues.setBounds(new Rectangle(33, 250, 122, 33));
			jLabelSumPliegues.setText("Suma Pliegues :");
			jLabelPSubEscapularP = new JLabel();
			jLabelPSubEscapularP.setBounds(new Rectangle(365, 209, 125, 28));
			jLabelPSubEscapularP.setText("Peso SubEscapular P:");
			jLabelPSubEscapular = new JLabel();
			jLabelPSubEscapular.setBounds(new Rectangle(35, 211, 118, 28));
			jLabelPSubEscapular.setText("Peso SubEscapular :");
			jLabelPTricipalP = new JLabel();
			jLabelPTricipalP.setBounds(new Rectangle(366, 169, 112, 30));
			jLabelPTricipalP.setText("Peso Tricipital P :");
			jLabelPTricipal = new JLabel();
			jLabelPTricipal.setBounds(new Rectangle(37, 171, 105, 30));
			jLabelPTricipal.setText("Peso Tricipital :");
			jLabelPesoReal = new JLabel();
			jLabelPesoReal.setBounds(new Rectangle(38, 98, 91, 28));
			jLabelPesoReal.setText("Peso Real :");
			jLabelPesoDeseado = new JLabel();
			jLabelPesoDeseado.setBounds(new Rectangle(370, 60, 94, 29));
			jLabelPesoDeseado.setText("Peso Deseado :");
			jLabelImpresion = new JLabel();
			jLabelImpresion.setBounds(new Rectangle(37, 137, 107, 27));
			jLabelImpresion.setText("Impresion Clinica:");
			jLabelLateralizado = new JLabel();
			jLabelLateralizado.setBounds(new Rectangle(370, 98, 107, 31));
			jLabelLateralizado.setText("Estructura Osea :");
			jLabelTalla = new JLabel();
			jLabelTalla.setBounds(new Rectangle(39, 61, 90, 29));
			jLabelTalla.setText("Talla :");
			jLabelFecha = new JLabel();
			jLabelFecha.setBounds(new Rectangle(98, 19, 153, 31));
			jLabelFecha.setText("Fecha :");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(204, 255, 204));
			jContentPane.add(jLabelFecha, null);
			jContentPane.add(getJDateChooserFecha(), null);
			jContentPane.add(getJButtonSalir(), null);
			jContentPane.add(getJButtonGuardar(), null);
			jContentPane.add(jLabelTalla, null);
			jContentPane.add(getJTextFieldTalla(), null);
			jContentPane.add(jLabelLateralizado, null);
			jContentPane.add(getJComboBoxEstructuraOsea(), null);
			jContentPane.add(jLabelImpresion, null);
			jContentPane.add(getJComboBoxImpresion(), null);
			jContentPane.add(jLabelPesoDeseado, null);
			jContentPane.add(getJTextFieldPesoDeseado(), null);
			jContentPane.add(jLabelPesoReal, null);
			jContentPane.add(getJTextFieldPesoReal(), null);
			jContentPane.add(jLabelPTricipal, null);
			jContentPane.add(getJTextFieldPesoTricipital(), null);
			jContentPane.add(jLabelPTricipalP, null);
			jContentPane.add(getJComboBoxPTricipital(), null);
			jContentPane.add(jLabelPSubEscapular, null);
			jContentPane.add(getJTextFieldPesoSubEscapular(), null);
			jContentPane.add(jLabelPSubEscapularP, null);
			jContentPane.add(getJComboBoxPSubEscapular(), null);
			jContentPane.add(jLabelSumPliegues, null);
			jContentPane.add(getJTextFieldSumaPliegues(), null);
			jContentPane.add(jLabelPSumPliegues, null);
			jContentPane.add(getJComboBoxSumaPliegues(), null);
			jContentPane.add(jLabelCFBrazo, null);
			jContentPane.add(getJTextFieldCFBrazo(), null);
			jContentPane.add(jLabelPCFBrazo, null);
			jContentPane.add(getJComboBoxPCFBrazo(), null);
			jContentPane.add(jLabelCFMuscBrazo, null);
			jContentPane.add(getJTextFieldCFMuscBrazo(), null);
			jContentPane.add(jLabelPCFMuscBrazo, null);
			jContentPane.add(getJComboBoxPCFMuscBrazo(), null);
			jContentPane.add(jLabelAreaBrazo, null);
			jContentPane.add(getJTextFieldAreaBrazo(), null);
			jContentPane.add(jLabelAreaMuscBrazo, null);
			jContentPane.add(getJTextFieldAreaMuscBrazo(), null);
			jContentPane.add(jLabelPAreaMuscBrazo, null);
			jContentPane.add(getJComboBoxPAreaMuscBrazo(), null);
			jContentPane.add(jLabelAreaGrasaBrazo, null);
			jContentPane.add(getJTextFieldAreaGrasaBrazo(), null);
			jContentPane.add(jLabelPAreaGrasaBrazo, null);
			jContentPane.add(getJComboBoxPAreaGrasaBrazo(), null);
			jContentPane.add(jLabelAreaCinturaCadera, null);
			jContentPane.add(getJTextFieldRCinturaCadera(), null);
			jContentPane.add(jLabelDiagNutricional, null);
			jContentPane.add(getJComboBoxDiagNutricional(), null);
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
	 * This method initializes jButtonSalir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSalir() {
		if (jButtonSalir == null) {
			jButtonSalir = new JButton();
			jButtonSalir.setBounds(new Rectangle(167, 532, 151, 34));
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
			jButtonGuardar.setBounds(new Rectangle(380, 533, 165, 32));
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
		EvolucionTrasplanteNutricion e = new EvolucionTrasplanteNutricion();
		e.setFecha(this.jDateChooserFecha.getCalendar());
		e.setImpresion((String)this.jComboBoxImpresion.getSelectedItem());
		e.setEstructuraOsea((String)this.jComboBoxEstructuraOsea.getSelectedItem()); 
		e.setPTricipitalP((String)this.jComboBoxPTricipital.getSelectedItem());
		e.setPSubEscapularP((String)this.jComboBoxPSubEscapular.getSelectedItem());
		e.setPSumPliegues((String)this.jComboBoxSumaPliegues.getSelectedItem());
		e.setPCfBrazo((String)this.jComboBoxPCFBrazo.getSelectedItem());
		e.setPCfMuscBrazo((String)this.jComboBoxPCFMuscBrazo.getSelectedItem());
		e.setPAreaMuscBrazo((String)this.jComboBoxPAreaMuscBrazo.getSelectedItem());
		e.setPAreaGrasaBrazo((String)this.jComboBoxPAreaGrasaBrazo.getSelectedItem());
		e.setDiagNutricional((String)this.jComboBoxDiagNutricional.getSelectedItem());
		boolean error = false;
		String lugar = "Talla";
		try{
			String aux = this.jTextFieldTalla.getText();
			e.setTalla(Integer.parseInt(aux));
			lugar = "Peso Deseado";
			aux = this.jTextFieldPesoDeseado.getText();
			e.setPesoDeseado(Integer.parseInt(aux));
			lugar = "Peso Real";
			aux = this.jTextFieldPesoReal.getText();
			e.setPesoReal(Integer.parseInt(aux));
			lugar = "Peso Tricipital";
			aux = this.jTextFieldPesoTricipital.getText();
			e.setPTricipital(Integer.parseInt(aux));
			lugar = "Peso Sub Escapular";
			aux = this.jTextFieldPesoSubEscapular.getText();
			e.setPSubEscapular(Integer.parseInt(aux));
			lugar = "Peso Deseado";
			aux = this.jTextFieldSumaPliegues.getText();
			e.setSumPliegues(Integer.parseInt(aux));
			/*
			this..setText(String.valueOf(e.()));
			this..setText(String.valueOf(e.()));
			*/
			lugar = "Circunferencia Brazo";
			aux = this.jTextFieldCFBrazo.getText();
			e.setCfBrazo(Integer.parseInt(aux));
			lugar = "Circunferencia Musculo Brazo";
			aux = this.jTextFieldCFMuscBrazo.getText();
			e.setCfMuscBrazo(Integer.parseInt(aux));
			lugar = "Area del brazo";
			aux = this.jTextFieldAreaBrazo.getText();
			e.setAreaBrazo(Integer.parseInt(aux));
			lugar = "Area Musculo del brazo";
			aux = this.jTextFieldAreaMuscBrazo.getText();
			e.setAreaMuscBrazo(Integer.parseInt(aux));
			lugar = "Area de grasa del bazo";
			aux = this.jTextFieldAreaGrasaBrazo.getText();
			e.setAreaGrasaBrazo(Integer.parseInt(aux));
			lugar = "Radio Cintura Cadera";
			aux = this.jTextFieldRCinturaCadera.getText();
			e.setRCinturaCadera(Integer.parseInt(aux));
		}catch(Exception e1){
			JOptionPane.showMessageDialog(this,"Dato mal ingresado en "+lugar, "Error", 2);
			error = true;
		}
		if(!error){
			e.setIdTrasplante(this.idTrasplante);
			Fachada.getInstancia().guardarEvolucionNutricion(e);
			this.salir();
		}

	}
	
	private void salir(){
		this.dispose();
	}

	/**
	 * This method initializes jTextFieldTalla	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldTalla() {
		if (jTextFieldTalla == null) {
			jTextFieldTalla = new JTextField();
			jTextFieldTalla.setBounds(new Rectangle(142, 60, 200, 27));
		}
		return jTextFieldTalla;
	}

	/**
	 * This method initializes jComboBoxEstructuraOsea	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxEstructuraOsea() {
		if (jComboBoxEstructuraOsea == null) {
			jComboBoxEstructuraOsea = new JComboBox();
			jComboBoxEstructuraOsea.setBounds(new Rectangle(481, 99, 189, 27));
		}
		return jComboBoxEstructuraOsea;
	}

	/**
	 * This method initializes jComboBoxImpresion	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxImpresion() {
		if (jComboBoxImpresion == null) {
			jComboBoxImpresion = new JComboBox();
			jComboBoxImpresion.setBounds(new Rectangle(149, 138, 188, 26));
		}
		return jComboBoxImpresion;
	}

	/**
	 * This method initializes jTextFieldPesoDeseado	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldPesoDeseado() {
		if (jTextFieldPesoDeseado == null) {
			jTextFieldPesoDeseado = new JTextField();
			jTextFieldPesoDeseado.setBounds(new Rectangle(475, 61, 199, 28));
		}
		return jTextFieldPesoDeseado;
	}

	/**
	 * This method initializes jTextFieldPesoReal	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldPesoReal() {
		if (jTextFieldPesoReal == null) {
			jTextFieldPesoReal = new JTextField();
			jTextFieldPesoReal.setBounds(new Rectangle(141, 98, 200, 27));
		}
		return jTextFieldPesoReal;
	}

	/**
	 * This method initializes jTextFieldPesoTricipital	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldPesoTricipital() {
		if (jTextFieldPesoTricipital == null) {
			jTextFieldPesoTricipital = new JTextField();
			jTextFieldPesoTricipital.setBounds(new Rectangle(150, 172, 188, 25));
		}
		return jTextFieldPesoTricipital;
	}

	/**
	 * This method initializes jComboBoxPTricipital	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxPTricipital() {
		if (jComboBoxPTricipital == null) {
			jComboBoxPTricipital = new JComboBox();
			jComboBoxPTricipital.setBounds(new Rectangle(493, 173, 182, 26));
		}
		return jComboBoxPTricipital;
	}

	/**
	 * This method initializes jTextFieldPesoSubEscapular	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldPesoSubEscapular() {
		if (jTextFieldPesoSubEscapular == null) {
			jTextFieldPesoSubEscapular = new JTextField();
			jTextFieldPesoSubEscapular.setBounds(new Rectangle(157, 211, 181, 25));
		}
		return jTextFieldPesoSubEscapular;
	}

	/**
	 * This method initializes jComboBoxPSubEscapular	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxPSubEscapular() {
		if (jComboBoxPSubEscapular == null) {
			jComboBoxPSubEscapular = new JComboBox();
			jComboBoxPSubEscapular.setBounds(new Rectangle(498, 209, 176, 25));
		}
		return jComboBoxPSubEscapular;
	}

	/**
	 * This method initializes jTextFieldSumaPliegues	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldSumaPliegues() {
		if (jTextFieldSumaPliegues == null) {
			jTextFieldSumaPliegues = new JTextField();
			jTextFieldSumaPliegues.setBounds(new Rectangle(160, 251, 176, 27));
		}
		return jTextFieldSumaPliegues;
	}

	/**
	 * This method initializes jComboBoxSumaPliegues	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxSumaPliegues() {
		if (jComboBoxSumaPliegues == null) {
			jComboBoxSumaPliegues = new JComboBox();
			jComboBoxSumaPliegues.setBounds(new Rectangle(497, 247, 176, 28));
		}
		return jComboBoxSumaPliegues;
	}

	/**
	 * This method initializes jTextFieldCFBrazo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCFBrazo() {
		if (jTextFieldCFBrazo == null) {
			jTextFieldCFBrazo = new JTextField();
			jTextFieldCFBrazo.setBounds(new Rectangle(163, 291, 171, 25));
		}
		return jTextFieldCFBrazo;
	}

	/**
	 * This method initializes jComboBoxPCFBrazo	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxPCFBrazo() {
		if (jComboBoxPCFBrazo == null) {
			jComboBoxPCFBrazo = new JComboBox();
			jComboBoxPCFBrazo.setBounds(new Rectangle(496, 283, 178, 26));
		}
		return jComboBoxPCFBrazo;
	}

	/**
	 * This method initializes jTextFieldCFMuscBrazo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCFMuscBrazo() {
		if (jTextFieldCFMuscBrazo == null) {
			jTextFieldCFMuscBrazo = new JTextField();
			jTextFieldCFMuscBrazo.setBounds(new Rectangle(165, 325, 169, 27));
		}
		return jTextFieldCFMuscBrazo;
	}

	/**
	 * This method initializes jComboBoxPCFMuscBrazo	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxPCFMuscBrazo() {
		if (jComboBoxPCFMuscBrazo == null) {
			jComboBoxPCFMuscBrazo = new JComboBox();
			jComboBoxPCFMuscBrazo.setBounds(new Rectangle(501, 321, 178, 25));
		}
		return jComboBoxPCFMuscBrazo;
	}

	/**
	 * This method initializes jTextFieldAreaBrazo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldAreaBrazo() {
		if (jTextFieldAreaBrazo == null) {
			jTextFieldAreaBrazo = new JTextField();
			jTextFieldAreaBrazo.setBounds(new Rectangle(165, 366, 166, 28));
		}
		return jTextFieldAreaBrazo;
	}

	/**
	 * This method initializes jTextFieldAreaMuscBrazo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldAreaMuscBrazo() {
		if (jTextFieldAreaMuscBrazo == null) {
			jTextFieldAreaMuscBrazo = new JTextField();
			jTextFieldAreaMuscBrazo.setBounds(new Rectangle(497, 365, 173, 25));
		}
		return jTextFieldAreaMuscBrazo;
	}

	/**
	 * This method initializes jComboBoxPAreaMuscBrazo	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxPAreaMuscBrazo() {
		if (jComboBoxPAreaMuscBrazo == null) {
			jComboBoxPAreaMuscBrazo = new JComboBox();
			jComboBoxPAreaMuscBrazo.setBounds(new Rectangle(165, 407, 165, 25));
		}
		return jComboBoxPAreaMuscBrazo;
	}

	/**
	 * This method initializes jTextFieldAreaGrasaBrazo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldAreaGrasaBrazo() {
		if (jTextFieldAreaGrasaBrazo == null) {
			jTextFieldAreaGrasaBrazo = new JTextField();
			jTextFieldAreaGrasaBrazo.setBounds(new Rectangle(496, 407, 175, 24));
		}
		return jTextFieldAreaGrasaBrazo;
	}

	/**
	 * This method initializes jComboBoxPAreaGrasaBrazo	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxPAreaGrasaBrazo() {
		if (jComboBoxPAreaGrasaBrazo == null) {
			jComboBoxPAreaGrasaBrazo = new JComboBox();
			jComboBoxPAreaGrasaBrazo.setBounds(new Rectangle(165, 445, 165, 23));
		}
		return jComboBoxPAreaGrasaBrazo;
	}

	/**
	 * This method initializes jTextFieldRCinturaCadera	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldRCinturaCadera() {
		if (jTextFieldRCinturaCadera == null) {
			jTextFieldRCinturaCadera = new JTextField();
			jTextFieldRCinturaCadera.setBounds(new Rectangle(506, 446, 166, 23));
		}
		return jTextFieldRCinturaCadera;
	}

	/**
	 * This method initializes jComboBoxDiagNutricional	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxDiagNutricional() {
		if (jComboBoxDiagNutricional == null) {
			jComboBoxDiagNutricional = new JComboBox();
			jComboBoxDiagNutricional.setBounds(new Rectangle(174, 482, 165, 27));
		}
		return jComboBoxDiagNutricional;
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
