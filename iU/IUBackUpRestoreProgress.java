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
import java.io.File;
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
import javax.swing.JLabel;
import javax.swing.JFileChooser;

import auxiliaresFileSelector.FiltroSQLZIP;
import auxiliaresFileSelector.Utils;

import copiaArchivos.CopiarArchivos;

import zipCompress.BinaryFileData;
import zipCompress.UncompressedFile;
import zipCompress.ZipCompress;
import zipCompress.ZipFileUtil;


public class IUBackUpRestoreProgress extends JFrame implements PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton jButtonOK = null;
	private JPasswordField jPasswordFieldPass = null;
	private IUPrincipal principal;
	private File archivo = null;
	private JFileChooser chooser = null;
	private boolean cambio1 = false;
	private boolean cambio2 = false;
	
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
		}

		private void empezar() {
			cambio1 = true;
			this.setProgress(0);
			Runtime aplicacion = Runtime.getRuntime();
			cambio1 = true;
			this.setProgress(5);
			String nombreArchivo = crearBAT();
			if (nombreArchivo.isEmpty()) {
				error();
				return;
			}
			try {
				TimeUnit.SECONDS.sleep(2);
				cambio1 = true;
				this.setProgress(20);
				Process i = aplicacion.exec("cmd.exe /c start c:\\backup.bat");
				cambio1 = true;
				this.setProgress(45);
				TimeUnit.SECONDS.sleep(5);
				cambio1 = true;
				this.setProgress(55);
				TimeUnit.SECONDS.sleep(5);
				cambio1 = true;
				this.setProgress(65);
				borrarBAT();
				TimeUnit.SECONDS.sleep(5);
				i.destroy();
				cambio1 = true;
				this.setProgress(75);
				TimeUnit.SECONDS.sleep(5);
				cambio1 = true;
				this.setProgress(85);
				this.crearZip(nombreArchivo);
				eliminarArchivo(nombreArchivo);
				aplicacion.runFinalization();
				cambio1 = true;
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
				cambio1 = true;
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
				cambio1 = true;
				this.setProgress(10);
				java.io.File unArchivo;
				unArchivo = new java.io.File(lugar + "\\backup.bat");
				if (unArchivo.exists()) {
					unArchivo.delete();
				}
				FileWriter buf = new FileWriter(unArchivo);
				buf.write(crearBAT);
				buf.close();
				cambio1 = true;
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
	
	class TaskRestore extends SwingWorker<Void, Void> {
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
			cambio2 = true;
			this.setProgress(0);
			Runtime aplicacion = Runtime.getRuntime();
			try {
				TimeUnit.SECONDS.sleep(3);
				cambio2 = true;
				this.setProgress(5);
				String lugarNuevo = "C:\\Program Files\\MySQL\\MySQL\\bin\\" + archivo.getName();
				CopiarArchivos.copia(archivo.getAbsolutePath(), "C:\\Program Files\\MySQL\\MySQL\\bin\\" + archivo.getName());
				TimeUnit.SECONDS.sleep(3);
				cambio2 = true;
				this.setProgress(10);
				crearBAT(archivo.getName());
				System.out.println(archivo.getName());
				System.out.println(archivo.getAbsolutePath());
				TimeUnit.SECONDS.sleep(2);
				cambio2 = true;
				this.setProgress(20);
				Process i = aplicacion.exec("cmd.exe /c start c:\\restore.bat");
				cambio2 = true;
				this.setProgress(45);
				TimeUnit.SECONDS.sleep(5);
				cambio2 = true;
				this.setProgress(55);
				TimeUnit.SECONDS.sleep(5);
				cambio2 = true;
				this.setProgress(65);
				borrarBAT();
				borrarArchivo(lugarNuevo);
				TimeUnit.SECONDS.sleep(5);
				i.destroy();
				cambio2 = true;
				this.setProgress(75);
				TimeUnit.SECONDS.sleep(5);
				cambio2 = true;
				this.setProgress(85);
				if(i.waitFor() ==0 ){
					System.out.println("Respaldo creado con exito");
				}
				aplicacion.runFinalization();
				cambio2 = true;
				this.setProgress(100);
				// System.out.println("Respaldo creado con exito");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Error");
				errorRestaurar();
			}
		}

		private void crearBAT(String nombreArchivo) {
			try {
				cambio2 = true;
				this.setProgress(5);
				String retornoDeCarro = System.getProperty("line.separator");
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
						+ "mysql -umedico -p\"medico\" trasplante < "
						+ nombreArchivo  
						+ retornoDeCarro + "exit";
				String lugar = "c:";
				cambio2 = true;
				this.setProgress(10);
				java.io.File unArchivo;
				unArchivo = new java.io.File(lugar + "\\restore.bat");
				if (unArchivo.exists()) {
					unArchivo.delete();
				}
				FileWriter buf = new FileWriter(unArchivo);
				buf.write(crearBAT);
				buf.close();
				cambio2 = true;
				this.setProgress(15);
			} catch (Exception e) {
				System.out.println("Error con java.io.File");
			}
		}

		private void borrarArchivo(String lugar) {
			try {
				java.io.File unArchivo;
				unArchivo = new java.io.File(lugar);
				if (unArchivo.exists()) {
					unArchivo.delete();
				}
			} catch (Exception e) {
				System.out.println("Error con java.io.File");
			}
		}
		
		private void borrarBAT() {
			try {
				String lugar = "c:";
				java.io.File unArchivo;
				unArchivo = new java.io.File(lugar + "\\restore.bat");
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
	public IUBackUpRestoreProgress(IUPrincipal principal) {
		super();
		initialize();
		this.principal = principal;
		this.principal.setVisible(false);
		/*JOptionPane
				.showMessageDialog(
						this,
						"Es necesario que ingrese la contraseña maestra para efectuar el backup",
						"Advertencia", 2);*/
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
					File f = new File("c:\\TrasplantesBackUp\\");
					this.chooser.setCurrentDirectory(f);
					int salida = this.chooser.showDialog(this, "Abrir");
					
					if(salida == JFileChooser.APPROVE_OPTION){
						this.archivo = this.chooser.getSelectedFile();
						String extension = Utils.getExtension(this.archivo);
						System.out.println(extension);
						System.out.println(this.archivo.getAbsolutePath());
						if(extension.equalsIgnoreCase(Utils.zip)){
							try {
								File f1 = new File(this.archivo.getAbsoluteFile().toString());
								System.out.println(f1);
								ZipCompress.unzip(f1);
							} catch (IOException e) {
								e.printStackTrace();
								return;
							}
						}
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
					}else{
						
					}
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
		System.out.println(evt.getSource());

		if ("progress" == evt.getPropertyName()) {
			if(cambio1){
				int progress = (Integer) evt.getNewValue();
				jProgressBar.setValue(progress);
				cambio1 = false;
			}
			if(cambio2){
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

	private void errorRestaurar() {
		JOptionPane.showMessageDialog(this, "Error al tratar de restaurar la base de datos",
				"ERROR", JOptionPane.ERROR_MESSAGE);
		this.dispose();
		this.principal.setVisible(true);
	}
	
	private void termino() {
		JOptionPane.showMessageDialog(this, "Restauracion creada con exito", "OK",
				JOptionPane.PLAIN_MESSAGE);
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
