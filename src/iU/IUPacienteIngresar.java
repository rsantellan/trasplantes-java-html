package iU;

import java.awt.Color;
import java.awt.Rectangle;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import logica.Fachada;

import auxiliares.ManejoFechas;

import com.toedter.calendar.JDateChooser;

import dominio.Nefropatia;
import dominio.Paciente;
import javax.swing.JCheckBox;

public class IUPacienteIngresar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelThe = null;
	private JTextField jTextFieldThe = null;
	private JLabel jLabelCi = null;
	private JTextField jTextFieldCi = null;
	private JLabel jLabelNombre = null;
	private JTextField jTextFieldNombre = null;
	private JLabel jLabelApellido = null;
	private JTextField jTextFieldApellido = null;
	private JLabel jLabelNumFnr = null;
	private JTextField jTextFieldNum_Fnr = null;
	private JLabel jLabelRaza = null;
	private JComboBox jComboBoxRaza = null;
	private JLabel jLabelSexo = null;
	private JRadioButton jRadioButtonMasculino = null;
	private JRadioButton jRadioButtonFemenino = null;
	private JLabel jLabelFechaNacimiento = null;
	private JDateChooser jDateChooserFechaNacimiento = null;
	private JLabel jLabelFechaDialisis = null;
	private JDateChooser jDateChooserFechaDialisis = null;
	private JButton jButtonCancelar = null;
	private JButton jButtonGuardar = null;
	private JLabel jLabelNefropatia = null;
	private JComboBox jComboBoxNefropatia = null;
	private ArrayList<Nefropatia> nefropatias;
	private JLabel jLabelGrupoSanguineo = null;
	private JComboBox jComboBoxGrupoSanguineo = null;
	private JCheckBox jCheckBoxSinDialisis = null;

	/**
	 * This is the default constructor
	 */

	public IUPacienteIngresar() {
		super();
		initialize();
		cargaDatos();
	}

	private void cargaDatos() {
		// Raza
		this.jComboBoxRaza.addItem("Blanca");
		this.jComboBoxRaza.addItem("Negra");
		this.jComboBoxRaza.addItem("Asiática");
		this.jComboBoxRaza.addItem("Indio americana");

		// Nefropatia
		this.nefropatias = Fachada.getInstancia().obtenerTodasNefropatias();
		for (int x = 0; x < this.nefropatias.size(); x++) {
			this.jComboBoxNefropatia.addItem(this.nefropatias.get(x));
		}
		// Radio button de sexo
		this.jRadioButtonMasculino.setSelected(true);
		// Grupo Sanguineo
		String aux = "A";
		this.jComboBoxGrupoSanguineo.addItem(aux);
		aux = "B";
		this.jComboBoxGrupoSanguineo.addItem(aux);
		aux = "AB";
		this.jComboBoxGrupoSanguineo.addItem(aux);
		aux = "O";
		this.jComboBoxGrupoSanguineo.addItem(aux);

	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(678, 383);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Ingresar Paciente ");
		this.setLocationByPlatform(true);
		// Look & Feel
		try {
			// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Error setting native LAF: " + e);
		}
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelGrupoSanguineo = new JLabel();
			jLabelGrupoSanguineo.setBounds(new Rectangle(369, 187, 100, 32));
			jLabelGrupoSanguineo.setText("Grupo Sanguineo:");
			jLabelNefropatia = new JLabel();
			jLabelNefropatia.setBounds(new Rectangle(13, 251, 94, 30));
			jLabelNefropatia.setText("Nefropatia");
			jLabelFechaDialisis = new JLabel();
			jLabelFechaDialisis.setBounds(new Rectangle(16, 209, 116, 30));
			jLabelFechaDialisis.setText("Fecha Dialisis");
			jLabelFechaNacimiento = new JLabel();
			jLabelFechaNacimiento.setBounds(new Rectangle(370, 144, 116, 30));
			jLabelFechaNacimiento.setText("Fecha Nacimiento");
			jLabelSexo = new JLabel();
			jLabelSexo.setBounds(new Rectangle(16, 144, 94, 30));
			jLabelSexo.setText("Sexo :");
			jLabelRaza = new JLabel();
			jLabelRaza.setBounds(new Rectangle(370, 97, 94, 30));
			jLabelRaza.setText("Raza :");
			jLabelNumFnr = new JLabel();
			jLabelNumFnr.setBounds(new Rectangle(16, 97, 94, 30));
			jLabelNumFnr.setText("Nº FNR :");
			jLabelApellido = new JLabel();
			jLabelApellido.setBounds(new Rectangle(370, 60, 94, 30));
			jLabelApellido.setText("Apellido :");
			jLabelNombre = new JLabel();
			jLabelNombre.setBounds(new Rectangle(16, 60, 94, 30));
			jLabelNombre.setText("Nombre :");
			jLabelCi = new JLabel();
			jLabelCi.setBounds(new Rectangle(371, 16, 94, 30));
			jLabelCi.setText("Cedula Identidad");
			jLabelThe = new JLabel();
			jLabelThe.setBounds(new Rectangle(16, 16, 94, 30));
			jLabelThe.setText("THE");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 204));
			jContentPane.add(jLabelThe, null);
			jContentPane.add(getJTextFieldThe(), null);
			jContentPane.add(jLabelCi, null);
			jContentPane.add(getJTextFieldCi(), null);
			jContentPane.add(jLabelNombre, null);
			jContentPane.add(getJTextFieldNombre(), null);
			jContentPane.add(jLabelApellido, null);
			jContentPane.add(getJTextFieldApellido(), null);
			jContentPane.add(jLabelNumFnr, null);
			jContentPane.add(getJTextFieldNum_Fnr(), null);
			jContentPane.add(jLabelRaza, null);
			jContentPane.add(getJComboBoxRaza(), null);
			jContentPane.add(jLabelSexo, null);
			jContentPane.add(getJRadioButtonMasculino(), null);
			jContentPane.add(getJRadioButtonFemenino(), null);
			jContentPane.add(jLabelFechaNacimiento, null);
			jContentPane.add(getJDateChooserFechaNacimiento(), null);
			jContentPane.add(jLabelFechaDialisis, null);
			jContentPane.add(getJDateChooserFechaDialisis(), null);
			jContentPane.add(getJButtonCancelar(), null);
			jContentPane.add(getJButtonGuardar(), null);
			jContentPane.add(jLabelNefropatia, null);
			jContentPane.add(getJComboBoxNefropatia(), null);
			jContentPane.add(jLabelGrupoSanguineo, null);
			jContentPane.add(getJComboBoxGrupoSanguineo(), null);
			jContentPane.add(getJCheckBoxSinDialisis(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextFieldThe
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldThe() {
		if (jTextFieldThe == null) {
			jTextFieldThe = new JTextField();
			jTextFieldThe.setBounds(new Rectangle(136, 16, 170, 33));
			jTextFieldThe.setEnabled(false);
		}
		return jTextFieldThe;
	}

	/**
	 * This method initializes jTextFieldCi
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldCi() {
		if (jTextFieldCi == null) {
			jTextFieldCi = new JTextField();
			jTextFieldCi.setBounds(new Rectangle(479, 16, 170, 33));
			jTextFieldCi.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					char c = e.getKeyChar();
					if (!((Character.isDigit(c) || (c == java.awt.event.KeyEvent.VK_PERIOD) || (c == '-')
							|| (c == java.awt.event.KeyEvent.VK_BACK_SPACE) || (c == java.awt.event.KeyEvent.VK_DELETE)))) {
						getToolkit().beep();
						e.consume();
					}

				}
			});
		}
		return jTextFieldCi;
	}

	/**
	 * This method initializes jTextFieldNombre
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldNombre() {
		if (jTextFieldNombre == null) {
			jTextFieldNombre = new JTextField();
			jTextFieldNombre.setBounds(new Rectangle(135, 60, 170, 33));
		}
		return jTextFieldNombre;
	}

	/**
	 * This method initializes jTextFieldApellido
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldApellido() {
		if (jTextFieldApellido == null) {
			jTextFieldApellido = new JTextField();
			jTextFieldApellido.setBounds(new Rectangle(479, 60, 170, 33));
		}
		return jTextFieldApellido;
	}

	/**
	 * This method initializes jTextFieldNum_Fnr
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldNum_Fnr() {
		if (jTextFieldNum_Fnr == null) {
			jTextFieldNum_Fnr = new JTextField();
			jTextFieldNum_Fnr.setBounds(new Rectangle(135, 97, 170, 33));
		}
		return jTextFieldNum_Fnr;
	}

	/**
	 * This method initializes jComboBoxRaza
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxRaza() {
		if (jComboBoxRaza == null) {
			jComboBoxRaza = new JComboBox();
			jComboBoxRaza.setBounds(new Rectangle(481, 97, 170, 33));
		}
		return jComboBoxRaza;
	}

	/**
	 * This method initializes jRadioButtonMasculino
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonMasculino() {
		if (jRadioButtonMasculino == null) {
			jRadioButtonMasculino = new JRadioButton();
			jRadioButtonMasculino.setBounds(new Rectangle(153, 144, 42, 26));
			jRadioButtonMasculino.setText("M");
			jRadioButtonMasculino.setBackground(new Color(255, 255, 204));
			jRadioButtonMasculino
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							seleccionaMasculino();
						}
					});
		}
		return jRadioButtonMasculino;
	}

	/**
	 * This method initializes jRadioButtonFemenino
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonFemenino() {
		if (jRadioButtonFemenino == null) {
			jRadioButtonFemenino = new JRadioButton();
			jRadioButtonFemenino.setBounds(new Rectangle(219, 144, 45, 25));
			jRadioButtonFemenino.setText("F");
			jRadioButtonFemenino.setBackground(new Color(255, 255, 204));
			jRadioButtonFemenino
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							seleccionaFemenino();
						}
					});
		}
		return jRadioButtonFemenino;
	}

	/**
	 * This method initializes jDateChooserFechaNacimiento
	 * 
	 * @return com.toedter.calendar.JDateChooser
	 */
	private JDateChooser getJDateChooserFechaNacimiento() {
		if (jDateChooserFechaNacimiento == null) {
			jDateChooserFechaNacimiento = new JDateChooser();
			jDateChooserFechaNacimiento.setBounds(new Rectangle(501, 144, 148,
					32));
		}
		return jDateChooserFechaNacimiento;
	}

	/**
	 * This method initializes jDateChooserFechaDialisis
	 * 
	 * @return com.toedter.calendar.JDateChooser
	 */
	private JDateChooser getJDateChooserFechaDialisis() {
		if (jDateChooserFechaDialisis == null) {
			jDateChooserFechaDialisis = new JDateChooser();
			jDateChooserFechaDialisis
					.setBounds(new Rectangle(157, 209, 148, 32));
		}
		return jDateChooserFechaDialisis;
	}

	/**
	 * This method initializes jButtonCancelar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setBounds(new Rectangle(243, 298, 121, 37));
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

	/**
	 * This method initializes jButtonGuardar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonGuardar() {
		if (jButtonGuardar == null) {
			jButtonGuardar = new JButton();
			jButtonGuardar.setBounds(new Rectangle(396, 299, 121, 37));
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
	 * This method initializes jComboBoxNefropatia
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxNefropatia() {
		if (jComboBoxNefropatia == null) {
			jComboBoxNefropatia = new JComboBox();
			jComboBoxNefropatia.setBounds(new Rectangle(134, 251, 222, 33));
		}
		return jComboBoxNefropatia;
	}

	private void seleccionaMasculino() {
		this.jRadioButtonMasculino.setSelected(true);
		this.jRadioButtonFemenino.setSelected(false);
	}

	private void seleccionaFemenino() {
		this.jRadioButtonMasculino.setSelected(false);
		this.jRadioButtonFemenino.setSelected(true);
	}

	private void guardar() {
		// Chequeo que tenga todos los datos basicos.
		boolean todoOk = true;
		if (this.jTextFieldNombre.getText().equalsIgnoreCase("")
				|| this.jTextFieldNombre.getText().equalsIgnoreCase(" ")) {
			todoOk = false;
			JOptionPane.showMessageDialog(this,
					"Tiene que ingresar por lo menos un nombre",
					"Falta información", 2);
		}
		if (this.jTextFieldApellido.getText().equalsIgnoreCase("")
				|| this.jTextFieldApellido.getText().equalsIgnoreCase(" ")) {
			todoOk = false;
			JOptionPane.showMessageDialog(this,
					"Tiene que ingresar por lo menos un apellido",
					"Falta información", 2);
		}
		if (this.jTextFieldCi.getText().equalsIgnoreCase("")
				|| this.jTextFieldCi.getText().equalsIgnoreCase(" ")) {
			todoOk = false;
			JOptionPane.showMessageDialog(this,
					"Tiene que ingresar la Cedula de identidad",
					"Falta información", 2);
		}
		if (this.jTextFieldNum_Fnr.getText().equalsIgnoreCase("")
				|| this.jTextFieldNum_Fnr.getText().equalsIgnoreCase(" ")) {
			todoOk = false;
			JOptionPane.showMessageDialog(this, "Tiene que ingresar en Nº FNR",
					"Falta información", 2);
		}
		if (this.jDateChooserFechaNacimiento.getCalendar() == null) {
			todoOk = false;
			JOptionPane.showMessageDialog(this,
					"Tiene que ingresar la fecha de nacimiento",
					"Falta información", 2);
		}
		if(!this.getJCheckBoxSinDialisis().isSelected()){
			if (this.jDateChooserFechaDialisis.getCalendar() == null) {
				todoOk = false;
				JOptionPane.showMessageDialog(this,
						"Tiene que ingresar la fecha de comienzo de dialisis",
						"Falta información", 2);
			}
		}
		
		if (todoOk) {
			boolean fechasOK = true;
			if (this.jDateChooserFechaNacimiento.getCalendar().after(
					this.jDateChooserFechaDialisis.getCalendar())) {
				fechasOK = false;
			}
			if (fechasOK) {
				Paciente p = new Paciente();
				p.setNombre(this.jTextFieldNombre.getText());
				p.setApellido(this.jTextFieldApellido.getText());
				p.setCi(this.jTextFieldCi.getText());
				try {
					p.setNum_fnr(Integer.parseInt(this.jTextFieldNum_Fnr
							.getText()));
				} catch (Exception e) {

					JOptionPane
							.showMessageDialog(
									this,
									"El Nº FNR tiene que ser un valor numerico",
									"Información incorrecta",
									JOptionPane.ERROR_MESSAGE);
					return;
				}
				p.setRaza(this.jComboBoxRaza.getSelectedItem().toString());
				if (this.jRadioButtonFemenino.isSelected()) {
					p.setSexo("F");
				} else {
					p.setSexo("M");
				}
				p.setFecha_nacimiento(this.jDateChooserFechaNacimiento
						.getCalendar());
				if (this.jCheckBoxSinDialisis.isSelected()) {
					try {
						p.getFecha_dialisis().setTime(
								(ManejoFechas.formatoEspanol
										.parse("01-01-1800")));
					} catch (ParseException e) {
						System.out.println(e);
					}
				} else {
					p.setFecha_dialisis(this.jDateChooserFechaDialisis
							.getCalendar());
				}
				p.setTipoNefropatia((Nefropatia) this.jComboBoxNefropatia
						.getSelectedItem());
				p.setNumNefropatia(p.getTipoNefropatia().getId());
				p.setGrupoSanguineo((String) this.getJComboBoxGrupoSanguineo()
						.getSelectedItem());
				if (Fachada.getInstancia().chequearExistenciaPaciente(p)) {
					Fachada.getInstancia().guardarPaciente(p);
					JOptionPane.showMessageDialog(this,
							"Paciente ingresado con exito.", "Ingreso", 1);
					this.salir();
				} else {
					JOptionPane.showMessageDialog(this,
							"El paciente que quiere ingresar ya existe.",
							"Ingreso", 2);
				}
			} else {
				JOptionPane
						.showMessageDialog(
								this,
								"Las fechas no son consistentes.\nFijese que tengan coherencia.",
								"Ingreso", 2);
			}
		}
	}

	private void salir() {
		this.dispose();
	}

	/**
	 * This method initializes jComboBoxGrupoSanguineo
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxGrupoSanguineo() {
		if (jComboBoxGrupoSanguineo == null) {
			jComboBoxGrupoSanguineo = new JComboBox();
			jComboBoxGrupoSanguineo.setBounds(new Rectangle(489, 189, 162, 27));
		}
		return jComboBoxGrupoSanguineo;
	}

	/**
	 * This method initializes jCheckBoxSinDialisis
	 * 
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxSinDialisis() {
		if (jCheckBoxSinDialisis == null) {
			jCheckBoxSinDialisis = new JCheckBox();
			jCheckBoxSinDialisis.setBounds(new Rectangle(16, 181, 265, 24));
			jCheckBoxSinDialisis.setText("Sin dialisis");
			jCheckBoxSinDialisis.setBackground(new Color(255, 255, 204));
			jCheckBoxSinDialisis
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							sinDialisis();
						}
					});
		}
		return jCheckBoxSinDialisis;
	}

	private void sinDialisis() {
		if (this.jCheckBoxSinDialisis.isSelected()) {
			this.jLabelFechaDialisis.setVisible(false);
			this.jDateChooserFechaDialisis.setVisible(false);
		} else {
			this.jLabelFechaDialisis.setVisible(true);
			this.jDateChooserFechaDialisis.setVisible(true);
		}
	}

} // @jve:decl-index=0:visual-constraint="10,10"
