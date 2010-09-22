package uy.transplante.iu.consultas;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.WindowConstants;

import java.awt.Rectangle;
import javax.swing.JButton;

import uy.transplante.dominio.Generico;

import logica.Fachada;


public class IUConsultaTransplanteIOP extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JCheckBox jCheckBoxSangradoIOP = null;
	private JCheckBox jCheckBoxLesionArterial = null;
	private JCheckBox jCheckBoxLesionVenosa = null;
	private JCheckBox jCheckBoxNecesidaRepefundir = null;
	private JButton jButtonBuscar = null;
	private JButton jButtonBack = null;

	/**
	 * This is the default constructor
	 */
	public IUConsultaTransplanteIOP() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(466, 211);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Seleccionar los parametros de la consulta");
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(Color.WHITE);
			jContentPane.add(getJCheckBoxSangradoIOP(), null);
			jContentPane.add(getJCheckBoxLesionArterial(), null);
			jContentPane.add(getJCheckBoxLesionVenosa(), null);
			jContentPane.add(getJCheckBoxNecesidaRepefundir(), null);
			jContentPane.add(getJButtonBuscar(), null);
			jContentPane.add(getJButtonBack(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jCheckBoxSangradoIOP	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxSangradoIOP() {
		if (jCheckBoxSangradoIOP == null) {
			jCheckBoxSangradoIOP = new JCheckBox();
			jCheckBoxSangradoIOP.setBounds(new Rectangle(23, 19, 183, 25));
			jCheckBoxSangradoIOP.setText("Sangrado I OP");
			jCheckBoxSangradoIOP.setBackground(new Color(255, 255, 97));
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
			jCheckBoxLesionArterial.setBounds(new Rectangle(250, 19, 183, 25));
			jCheckBoxLesionArterial.setText("Lesion Arterial");
			jCheckBoxLesionArterial.setBackground(new Color(255, 255, 97));
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
			jCheckBoxLesionVenosa.setBounds(new Rectangle(250, 62, 183, 25));
			jCheckBoxLesionVenosa.setText("Lesion Venosa");
			jCheckBoxLesionVenosa.setBackground(new Color(255, 255, 97));
		}
		return jCheckBoxLesionVenosa;
	}

	/**
	 * This method initializes jCheckBoxNecesidaRepefundir	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxNecesidaRepefundir() {
		if (jCheckBoxNecesidaRepefundir == null) {
			jCheckBoxNecesidaRepefundir = new JCheckBox();
			jCheckBoxNecesidaRepefundir.setBounds(new Rectangle(23, 62, 183, 25));
			jCheckBoxNecesidaRepefundir.setText("Necesidad repefundir");
			jCheckBoxNecesidaRepefundir.setBackground(new Color(255, 255, 97));
		}
		return jCheckBoxNecesidaRepefundir;
	}

	/**
	 * This method initializes jButtonBuscar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonBuscar() {
		if (jButtonBuscar == null) {
			jButtonBuscar = new JButton();
			jButtonBuscar.setBounds(new Rectangle(238, 124, 194, 44));
			jButtonBuscar.setBackground(new Color(173, 244, 177));
			jButtonBuscar.setText("Buscar");
			jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					buscar();
				}
			});
		}
		return jButtonBuscar;
	}

	/**
	 * This method initializes jButtonBack	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonBack() {
		if (jButtonBack == null) {
			jButtonBack = new JButton();
			jButtonBack.setBounds(new Rectangle(23, 124, 194, 44));
			jButtonBack.setBackground(new Color(244, 218, 173));
			jButtonBack.setText("Atras");
			jButtonBack.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salir();
				}
			});
		}
		return jButtonBack;
	}

	private void salir() {
		this.dispose();
	}
	
	private void buscar(){
		Generico g = Fachada.getInstancia().consultaTransplantesConSangradoIOpLesionArterialYVenalRepefundirOpciones(this.getJCheckBoxSangradoIOP().isSelected(), this.getJCheckBoxLesionArterial().isSelected(), this.getJCheckBoxLesionVenosa().isSelected(), this.getJCheckBoxNecesidaRepefundir().isSelected());
		IUConsultaGenerica consulta = new IUConsultaGenerica(g);
		consulta.setVisible(true);
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
