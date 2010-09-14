package iu.backup;

import iu.IUPrincipal;
import iu.login.IULoginCambiar;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingWorker;

import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;

import logica.Fachada;
import javax.swing.WindowConstants;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JProgressBar;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class IUBackUpProgress extends JFrame implements PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton jButtonOK = null;
	private JPasswordField jPasswordFieldPass = null;
	private IUPrincipal principal;

	class Task extends SwingWorker<Void, Void> {
		/*
		 * Main task. Executed in background thread.
		 */
		@Override
		public Void doInBackground() {
			empezar();
			return null;
		}

		/*
		 * Executed in event dispatching thread
		 */
		@Override
		public void done() {
			Toolkit.getDefaultToolkit().beep();
			setCursor(null); // turn off the wait cursor
			termino();
		}

		private void empezar() {
			this.setProgress(0);
			this.setProgress(10);
			int aux = Fachada.getInstancia().crearBackUp(0);
			if(aux == -1){
				error();
				return;
			}
			this.setProgress(35);
			aux = Fachada.getInstancia().crearBackUp(1);
			if(aux == -1){
				error();
				return;
			}
			this.setProgress(75);
			aux =Fachada.getInstancia().crearBackUp(2);
			if(aux == -1){
				error();
				return;
			}
			this.setProgress(100);
		}
	}

	/**
	 * This is the default constructor
	 */
	public IUBackUpProgress(IUPrincipal principal) {
		super();
		initialize();
		this.principal = principal;
		this.principal.setVisible(false);
		this.jLabelProgreso.setVisible(false);
		JOptionPane
				.showMessageDialog(
						this,
						"Es necesario que ingrese la contraseña maestra para efectuar el backup",
						"Advertencia", 2);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(319, 214);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Ingrese contraseña maestra");
		this.getJProgressBar().setVisible(false);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelProgreso = new JLabel();
			jLabelProgreso.setBounds(new Rectangle(49, 1, 201, 27));
			jLabelProgreso.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelProgreso.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelProgreso.setForeground(new Color(255, 51, 51));
			jLabelProgreso.setText("Progreso...");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 153));
			jContentPane.add(getJButtonOK(), null);
			jContentPane.add(getJPasswordFieldPass(), null);
			jContentPane.add(getJButtonCancelar(), null);
			jContentPane.add(getJProgressBar(), null);
			jContentPane.add(jLabelProgreso, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButtonOK
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonOK() {
		if (jButtonOK == null) {
			jButtonOK = new JButton();
			jButtonOK.setBounds(new Rectangle(59, 78, 156, 49));
			jButtonOK.setText("INGRESAR");
			jButtonOK.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					login();
				}
			});
		}
		return jButtonOK;
	}

	private int intentos = 0;
	private JButton jButtonCancelar = null;
	private JProgressBar jProgressBar = null;
	private JLabel jLabelProgreso = null;
	private void login() {
		int num = Fachada.getInstancia().verificarIngresoRoot(
				this.getJPasswordFieldPass().getPassword());
		if (num > 0) {
			if (num == 1) {
				String respuesta = "";
				respuesta = JOptionPane.showInputDialog(this,
						"Esta seguro de querer crear un archivo de respaldo.",
						"Confirmar", 1);
				if (respuesta == null)
					respuesta = "No";
				if (respuesta.equalsIgnoreCase("Si")) {
					this.jLabelProgreso.setVisible(true);
					this.setCursor(Cursor
							.getPredefinedCursor(Cursor.WAIT_CURSOR));
					this.getJButtonCancelar().setVisible(false);
					this.getJButtonOK().setVisible(false);
					this.getJPasswordFieldPass().setVisible(false);
					this.getJProgressBar().setVisible(true);
					Task t = new Task();
					t.addPropertyChangeListener(this);
					t.execute();
					
					

				} else {
					this.dispose();
				}
			} else {
				JOptionPane
						.showMessageDialog(
								this,
								"La contraseña ha caducado, por favor ingrese una nueva",
								"Advertencia", 2);
				IULoginCambiar cambio = new IULoginCambiar();
				cambio.setVisible(true);
				this.dispose();
			}
		} else {
			intentos = intentos + 1;
			JOptionPane
					.showMessageDialog(
							this,
							"Ha ingresado mal la contraseña, solo pueden generar BackUp los usuarios con contraseña maestra.",
							"ERROR", 3);
		}
	}

	/**
	 * This method initializes jPasswordFieldPass
	 * 
	 * @return javax.swing.JPasswordField
	 */
	private JPasswordField getJPasswordFieldPass() {
		if (jPasswordFieldPass == null) {
			jPasswordFieldPass = new JPasswordField();
			jPasswordFieldPass.setBounds(new Rectangle(29, 16, 223, 41));
		}
		return jPasswordFieldPass;
	}

	/**
	 * This method initializes jButtonCancelar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setBounds(new Rectangle(81, 143, 117, 30));
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

	private void salir() {
		this.dispose();
		this.principal.setVisible(true);
	}

	/**
	 * This method initializes jProgressBar
	 * 
	 * @return javax.swing.JProgressBar
	 */
	private JProgressBar getJProgressBar() {
		if (jProgressBar == null) {
			jProgressBar = new JProgressBar();
			jProgressBar = new JProgressBar(0, 100);
			jProgressBar.setValue(0);
			jProgressBar.setStringPainted(true);
			jProgressBar.setBackground(new Color(204, 255, 204));
			jProgressBar.setForeground(new Color(102, 102, 255));
			jProgressBar.setBounds(new Rectangle(4, 33, 274, 48));
		}
		return jProgressBar;
	}

	/**
	 * Invoked when task's progress property changes.
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		if ("progress" == evt.getPropertyName()) {
			int progress = (Integer) evt.getNewValue();
			jProgressBar.setValue(progress);
		}
	}

	private void error() {
		JOptionPane.showMessageDialog(this, "Error al crear el Respaldo",
				"ERROR", JOptionPane.ERROR_MESSAGE);
		this.dispose();
		this.principal.setVisible(true);
	}

	private void termino() {
		JOptionPane.showMessageDialog(this, "Respaldo creado con exito", "OK",
				JOptionPane.PLAIN_MESSAGE);
		this.dispose();
		this.principal.setVisible(true);
	}
} // @jve:decl-index=0:visual-constraint="10,10"
