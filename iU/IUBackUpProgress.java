package iU;

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
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import logica.Fachada;
import javax.swing.WindowConstants;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JProgressBar;

import zipCompress.BinaryFileData;
import zipCompress.UncompressedFile;
import zipCompress.ZipFileUtil;

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
			Runtime aplicacion = Runtime.getRuntime();
			this.setProgress(5);
			String nombreArchivo = crearBAT();
			if (nombreArchivo.isEmpty()) {
				error();
				return;
			}
			try {
				TimeUnit.SECONDS.sleep(2);
				this.setProgress(20);
				Process i = aplicacion.exec("cmd.exe /c start c:\\backup.bat");
				this.setProgress(45);
				TimeUnit.SECONDS.sleep(5);
				this.setProgress(55);
				TimeUnit.SECONDS.sleep(5);
				this.setProgress(65);
				borrarBAT();
				TimeUnit.SECONDS.sleep(5);
				i.destroy();
				this.setProgress(75);
				TimeUnit.SECONDS.sleep(5);
				this.setProgress(85);
				this.crearZip(nombreArchivo);
				eliminarArchivo(nombreArchivo);
				aplicacion.runFinalization();
				this.setProgress(100);
				// System.out.println("Respaldo creado con exito");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Error");
			}
		}

		private void eliminarArchivo(String nombreArchivo){
			String archivo = nombreArchivo + ".sql";
			java.io.File file = new java.io.File(archivo);
			if(file.exists()){
				file.delete();
			}
		}
		
		private void crearZip(String nombreArchivo) {
			String archivo = nombreArchivo + ".sql";
			try {
				UncompressedFile u = new UncompressedFile(nombreArchivo + ".zip");
				u.addFile(new BinaryFileData(archivo,ZipFileUtil.fileToBytes(archivo)));
				byte[] b = ZipFileUtil.compress(u);
				ZipFileUtil.byteArrayToFile(u.getPath(), b);
			} catch (IOException e1) {
				Fachada.getInstancia().guardarLog(e1.getMessage());
				e1.printStackTrace();
			}
		}

		private String crearDirectorio() {
			String directorio = "c:\\Trasplante";
			java.io.File file = new java.io.File(directorio);
			if (!file.exists()) {
				if (!file.mkdir()) {
					System.out.println("NO CUENTA CON LOS PERMISOS NECESARIOS");
					return null;
				}
			}
			return directorio;
		}

		private String crearBAT() {
			try {
				this.setProgress(5);
				Calendar aux = new GregorianCalendar();
				SimpleDateFormat formatoEspanol = new SimpleDateFormat(
						"dd-MM-yyyy-HHmmss");
				String retornoDeCarro = System.getProperty("line.separator");
				String lugarDirectorio = this.crearDirectorio();
				if (lugarDirectorio == null)
					return "";
				lugarDirectorio += "\\";
				String nombreArchivo = lugarDirectorio + "trasplante"
						+ formatoEspanol.format(aux.getTime());
				String crearBAT = "@echo off"
						+ retornoDeCarro
						+ "cd c:\\"
						+ retornoDeCarro
						+ "cd Program Files"
						+ retornoDeCarro
						+ "cd MySQL"
						+ retornoDeCarro
						+ "cd MySQL"
						+ retornoDeCarro
						+ "cd bin"
						+ retornoDeCarro
						+ "mysqldump --opt -u medico --password=\"medico\" trasplante > "
						+ nombreArchivo + ".sql" + retornoDeCarro + "exit";
				String lugar = "c:";
				this.setProgress(10);
				java.io.File unArchivo;
				unArchivo = new java.io.File(lugar + "\\backup.bat");
				if (unArchivo.exists()) {
					unArchivo.delete();
				}
				FileWriter buf = new FileWriter(unArchivo);
				buf.write(crearBAT);
				buf.close();
				this.setProgress(15);
				return nombreArchivo;
			} catch (Exception e) {
				System.out.println("Error con java.io.File");
			}
			return "";
		}

		private void borrarBAT() {
			try {
				String lugar = "c:";
				java.io.File unArchivo;
				unArchivo = new java.io.File(lugar + "\\backup.bat");
				if (unArchivo.exists()) {
					unArchivo.delete();
				}
			} catch (Exception e) {
				System.out.println("Error con java.io.File");
			}
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
