package iu.backup;

import iu.IUPrincipal;

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
import java.io.File;

import logica.Fachada;
import javax.swing.WindowConstants;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JFileChooser;

import uy.transplante.auxiliares.file.selector.FiltroSQLZIP;

public class IUBackUpRestoreProgress extends JFrame implements
		PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton jButtonOK = null;
	private JPasswordField jPasswordFieldPass = null;
	private IUPrincipal principal;
	private File archivo = null;
	private JFileChooser chooser = null;
	private boolean cambio1 = false;
	private boolean cambio2 = false;
	private boolean terminoBackUp = false;

	class TaskBackUp extends SwingWorker<Void, Void> {
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
			terminoBackUp = true;
		}

		private void empezar() {
			cambio1 = true;
			Cursor hourglassCursor = new Cursor(Cursor.WAIT_CURSOR);
			setCursor(hourglassCursor);
			this.setProgress(50);
			int aux = Fachada.getInstancia().crearBackUp();
			if(aux == -1){
				error();
				return;
			}
			Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
			setCursor(normalCursor);
			this.setProgress(99);
			this.setProgress(100);
		}
	}

	class TaskRestore extends SwingWorker<Void, Void> {
		/*
		 * Main task. Executed in background thread.
		 */
		@Override
		public Void doInBackground() {
			//Creo este loop para poder sincronizar con el BackUp
			while (!terminoBackUp) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
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
			cambio2 = true;
			Cursor hourglassCursor = new Cursor(Cursor.WAIT_CURSOR);
			setCursor(hourglassCursor);
			this.setProgress(50);
			int aux = Fachada.getInstancia().crearRestore(
					archivo.getAbsolutePath());
			if(aux == -1){
				error();
				return;
			}
			Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
			setCursor(normalCursor);
			this.setProgress(99);
			this.setProgress(100);
			
		}

	}

	/**
	 * This is the default constructor
	 */
	public IUBackUpRestoreProgress(IUPrincipal principal) {
		super();
		initialize();
		this.principal = principal;
		this.principal.setVisible(false);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(327, 318);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setLocation(100, 100);
		this.setContentPane(getJContentPane());
		this.setTitle("Ingrese contraseña maestra");
		this.getJProgressBar().setVisible(false);
		this.getJProgressBarRestauracion().setVisible(false);
		this.jLabelBackUp.setVisible(false);
		this.jLabelRest.setVisible(false);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelRest = new JLabel();
			jLabelRest.setBounds(new Rectangle(61, 99, 204, 33));
			jLabelRest.setText("Restaurando...");
			jLabelBackUp = new JLabel();
			jLabelBackUp.setBounds(new Rectangle(48, 2, 216, 35));
			jLabelBackUp.setText("Creando punto de restauracion...");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 153));
			jContentPane.add(getJButtonOK(), null);
			jContentPane.add(getJPasswordFieldPass(), null);
			jContentPane.add(getJButtonCancelar(), null);
			jContentPane.add(getJProgressBar(), null);
			jContentPane.add(jLabelBackUp, null);
			jContentPane.add(getJProgressBarRestauracion(), null);
			jContentPane.add(jLabelRest, null);
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
			jButtonOK.setBounds(new Rectangle(57, 159, 156, 49));
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
	private JLabel jLabelBackUp = null;
	private JProgressBar jProgressBarRestauracion = null;
	private JLabel jLabelRest = null;

	private void login() {
		int num = Fachada.getInstancia().verificarIngresoRoot(
				this.getJPasswordFieldPass().getPassword());
		if (num > 0) {
			if (num == 1) {
				String respuesta = "";
				respuesta = JOptionPane.showInputDialog(this,
						"¿Esta seguro de querer restaurar la base de datos?.",
						"Confirmar", 1);
				if (respuesta == null)
					respuesta = "No";
				if (respuesta.equalsIgnoreCase("Si")) {
					this.chooser = new JFileChooser();
					this.chooser.addChoosableFileFilter(new FiltroSQLZIP());
					this.chooser.setAcceptAllFileFilterUsed(false);
					File f = new File(System.getProperty("user.dir")+"/Trasplante/");
					this.chooser.setCurrentDirectory(f);
					int salida = this.chooser.showDialog(this, "Abrir");

					if (salida == JFileChooser.APPROVE_OPTION) {
						this.archivo = this.chooser.getSelectedFile();
						this.setCursor(Cursor
								.getPredefinedCursor(Cursor.WAIT_CURSOR));
						this.getJButtonCancelar().setVisible(false);
						this.getJButtonOK().setVisible(false);
						this.getJPasswordFieldPass().setVisible(false);
						this.getJProgressBar().setVisible(true);
						this.getJProgressBarRestauracion().setVisible(true);
						this.jLabelBackUp.setVisible(true);
						this.jLabelRest.setVisible(true);
						TaskBackUp tb = new TaskBackUp();
						tb.addPropertyChangeListener(this);
						tb.execute();
						TaskRestore t = new TaskRestore();
						t.addPropertyChangeListener(this);
						t.execute();
					} else {

					}
				} else {
					this.dispose();
				}
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
			jPasswordFieldPass.setBounds(new Rectangle(38, 43, 223, 41));
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
			jButtonCancelar.setBounds(new Rectangle(70, 242, 117, 30));
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
			jProgressBar.setBounds(new Rectangle(12, 39, 274, 48));
		}
		return jProgressBar;
	}

	/**
	 * Invoked when task's progress property changes.
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		if ("progress" == evt.getPropertyName()) {
			if (cambio1) {
				int progress = (Integer) evt.getNewValue();
				jProgressBar.setValue(progress);
				cambio1 = false;
			}
			if (cambio2) {
				int progress = (Integer) evt.getNewValue();
				jProgressBarRestauracion.setValue(progress);
				cambio2 = false;
			}
		}
	}

	private void error() {
		JOptionPane.showMessageDialog(this, "Error al crear el Respaldo",
				"ERROR", JOptionPane.ERROR_MESSAGE);
		this.dispose();
		this.principal.setVisible(true);
	}

	private void termino() {
		JOptionPane.showMessageDialog(this, "Restauracion creada con exito",
				"OK", JOptionPane.PLAIN_MESSAGE);
		this.dispose();
		this.principal.cargarDatos();

		this.principal.setVisible(true);
	}

	/**
	 * This method initializes jProgressBarRestauracion
	 * 
	 * @return javax.swing.JProgressBar
	 */
	private JProgressBar getJProgressBarRestauracion() {
		if (jProgressBarRestauracion == null) {
			jProgressBarRestauracion = new JProgressBar(0, 100);
			jProgressBarRestauracion.setBounds(new Rectangle(12, 138, 274, 48));
			jProgressBarRestauracion.setForeground(new Color(102, 102, 255));
			jProgressBarRestauracion.setStringPainted(true);
			jProgressBarRestauracion.setValue(0);
			jProgressBarRestauracion.setBackground(new Color(204, 255, 204));
		}
		return jProgressBarRestauracion;
	}
} // @jve:decl-index=0:visual-constraint="10,10"
