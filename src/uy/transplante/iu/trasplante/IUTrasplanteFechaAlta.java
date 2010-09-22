package uy.transplante.iu.trasplante;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import uy.transplante.dominio.Trasplante;
import uy.transplante.logica.Fachada;


import com.toedter.calendar.JDateChooser;


public class IUTrasplanteFechaAlta extends JFrame implements java.util.Observer {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelFecha = null;
	private JDateChooser jDateChooserMuerte = null;
	private Trasplante t;
	private JButton jButtonAceptar = null;
	private JButton jButtonCancelar = null;

	/**
	 * This is the default constructor
	 */
	public IUTrasplanteFechaAlta(Trasplante t) {
		super();
		initialize();
		this.t = t;
		if (t.getFechaAlta() != null) {
			this.getJDateChooserMuerte().setCalendar(t.getFechaAlta());
		}
		Fachada.getInstancia().agregarObservador(this);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(468, 186);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Fecha de Alta");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelFecha = new JLabel();
			jLabelFecha.setBounds(new Rectangle(5, 21, 116, 33));
			jLabelFecha.setText("Fecha de alta :");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 204));
			jContentPane.add(jLabelFecha, null);
			jContentPane.add(getJDateChooserMuerte(), null);
			jContentPane.add(getJButtonAceptar(), null);
			jContentPane.add(getJButtonCancelar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jDateChooserMuerte
	 * 
	 * @return com.toedter.calendar.JDateChooser
	 */
	private JDateChooser getJDateChooserMuerte() {
		if (jDateChooserMuerte == null) {
			jDateChooserMuerte = new JDateChooser();
			jDateChooserMuerte.setBounds(new Rectangle(217, 24, 195, 29));
		}
		return jDateChooserMuerte;
	}

	/**
	 * This method initializes jButtonAceptar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAceptar() {
		if (jButtonAceptar == null) {
			jButtonAceptar = new JButton();
			jButtonAceptar.setBounds(new Rectangle(280, 88, 110, 38));
			jButtonAceptar.setText("Confirmar");
			jButtonAceptar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							confirmar();
						}
					});
		}
		return jButtonAceptar;
	}

	/**
	 * This method initializes jButtonCancelar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setBounds(new Rectangle(30, 88, 110, 38));
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							salir();
						}
					});
		}
		return jButtonCancelar;
	}

	public void update(Observable arg0, Object arg1) {
		Observable o = arg0;
		if (o == Fachada.getInstancia()) {
		}
	}

	public void salir() {
		Fachada.getInstancia().eliminarObservador(this);
		this.dispose();
	}

	private void confirmar() {
		if (jDateChooserMuerte.getCalendar() == null) {
			JOptionPane.showMessageDialog(this,
					"Tiene que ingresar la fecha de alta", "Falta información",
					2);
		} else {
			if (this.t.getFecha().after(
					this.getJDateChooserMuerte().getCalendar())) {
				JOptionPane
						.showMessageDialog(
								this,
								"La fecha de alta tiene que ser mayor a la del trasplante",
								"ERROR", JOptionPane.ERROR_MESSAGE);
			} else {
				this.t.setFechaAlta(this.getJDateChooserMuerte().getCalendar());
				Fachada.getInstancia().guardarTrasplante(t);
				this.salir();
			}

		}
	}
} // @jve:decl-index=0:visual-constraint="10,10"
