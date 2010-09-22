package uy.transplante.iu.basico;

import javax.swing.JPanel;
import javax.swing.JFrame;
import com.toedter.calendar.JDateChooser;


import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import logica.Fachada;
import javax.swing.WindowConstants;
import javax.swing.JRadioButton;

import uy.transplante.dominio.CMV;
import uy.transplante.dominio.CMVDiagnostico;
import uy.transplante.dominio.CMVDrogas;
import uy.transplante.dominio.CMVEnfermedades;
import uy.transplante.dominio.CMVusoEnfermedades;

public class IUCMVManejar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JDateChooser jDateChooserFecha = null;
	private JLabel jLabelFecha = null;
	private JLabel jLabelDiagnostico = null;
	private JComboBox jComboBoxDiagnosticos = null;
	private JComboBox jComboBoxEnfermedades = null;
	private JButton jButtonUsar = null;
	private JButton jButtonQuitar = null;
	private JComboBox jComboBoxEnfermedadesUsadas = null;
	private JLabel jLabelDroga = null;
	private JComboBox jComboBoxDroga = null;
	private JLabel jLabelDiasTratamient = null;
	private JTextField jTextFieldDiasTratamiento = null;
	private JLabel jLabelEfectoSecundario = null;
	private JScrollPane jScrollPaneEfectos2 = null;
	private JTextArea jTextAreaEfectosSecundarios = null;
	private JButton jButtonGuardar = null;
	private JButton jButtonSalir = null;
	private int id;
	private CMV usado = null;
	private JRadioButton jRadioButtonTratamientoAnticipado = null;
	private JRadioButton jRadioButtonSindromeViral = null;
	private JRadioButton jRadioButtonEnfermedad = null;
	private JRadioButton jRadioButtonProfilaxis = null;

	/**
	 * This is the default constructor
	 */
	public IUCMVManejar(int idTrasplante, boolean ver, CMV usado) {
		super();
		initialize();
		this.ocultarEnfermedad();
		id = idTrasplante;
		cargarDatos();
		this.usado = usado;
		if (ver) {
			this.jButtonGuardar.setVisible(false);
		}
		if (usado != null) {
			cargarDatosCMV(usado);
		}
	}

	private void cargarDatos() {
		ArrayList<CMVDiagnostico> listaDiag = Fachada.getInstancia()
				.obtenerTodasCMVDiagnostico();
		for (int x = 0; x < listaDiag.size(); x++) {
			this.jComboBoxDiagnosticos.addItem(listaDiag.get(x));
		}
		ArrayList<CMVDrogas> listaDro = Fachada.getInstancia()
				.obtenerTodasCMVDrogas();
		for (int x = 0; x < listaDro.size(); x++) {
			this.jComboBoxDroga.addItem(listaDro.get(x));
		}
		ArrayList<CMVEnfermedades> listaEnf = Fachada.getInstancia()
				.obtenerTodasCMVEmfermedades();
		for (int x = 0; x < listaEnf.size(); x++) {
			this.jComboBoxEnfermedades.addItem(listaEnf.get(x));
		}
	}

	private void cargarDatosCMV(CMV usado) {
		this.jDateChooserFecha.setCalendar(usado.getFecha());
		this.jComboBoxDiagnosticos.setSelectedItem(usado.getDiagnostico());
		this.jRadioButtonTratamientoAnticipado.setSelected(usado.isTmAnti());
		this.jRadioButtonSindromeViral.setSelected(usado.isSindromeViral());
		if (usado.getEnfermedades() == null) {
			this.jRadioButtonEnfermedad.setSelected(false);
		} else {
			if (usado.getEnfermedades().size() == 0){
				this.jRadioButtonEnfermedad.setSelected(false);
			}else{
				this.jRadioButtonEnfermedad.setSelected(true);
				this.mostrarEnfermedad();
			}
			for (int x = 0; x < usado.getEnfermedades().size(); x++) {
				this.jComboBoxEnfermedadesUsadas.addItem(usado
						.getEnfermedades().get(x).getEnfermedad());
				this.jComboBoxEnfermedades.removeItem(usado.getEnfermedades()
						.get(x).getEnfermedad());
			}
		}
		this.jRadioButtonProfilaxis.setSelected(usado.isProfilaxis());
		this.jComboBoxDroga.setSelectedItem(usado.getDroga());
		this.jTextFieldDiasTratamiento.setText(String
				.valueOf(usado.getDiasTm()));
		this.jTextAreaEfectosSecundarios.setText(usado.getEfectoSecundario());
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(587, 546);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Manejar CMV");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelEfectoSecundario = new JLabel();
			jLabelEfectoSecundario.setBounds(new Rectangle(23, 364, 133, 31));
			jLabelEfectoSecundario
					.setText("<HTML>Suspencion por efecto <BR> secundario, ¿Cual? </HTML>:");
			jLabelDiasTratamient = new JLabel();
			jLabelDiasTratamient.setBounds(new Rectangle(25, 320, 130, 30));
			jLabelDiasTratamient.setText("Dias de tratamiento :");
			jLabelDroga = new JLabel();
			jLabelDroga.setBounds(new Rectangle(27, 279, 124, 27));
			jLabelDroga.setText("Droga Usada :");
			jLabelDiagnostico = new JLabel();
			jLabelDiagnostico.setBounds(new Rectangle(24, 64, 106, 26));
			jLabelDiagnostico.setText("Diagnostico :");
			jLabelFecha = new JLabel();
			jLabelFecha.setBounds(new Rectangle(25, 16, 75, 31));
			jLabelFecha.setText("Fecha :");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 204));
			jContentPane.add(getJDateChooserFecha(), null);
			jContentPane.add(jLabelFecha, null);
			jContentPane.add(jLabelDiagnostico, null);
			jContentPane.add(getJComboBoxDiagnosticos(), null);
			jContentPane.add(getJComboBoxEnfermedades(), null);
			jContentPane.add(getJButtonUsar(), null);
			jContentPane.add(getJButtonQuitar(), null);
			jContentPane.add(getJComboBoxEnfermedadesUsadas(), null);
			jContentPane.add(jLabelDroga, null);
			jContentPane.add(getJComboBoxDroga(), null);
			jContentPane.add(jLabelDiasTratamient, null);
			jContentPane.add(getJTextFieldDiasTratamiento(), null);
			jContentPane.add(jLabelEfectoSecundario, null);
			jContentPane.add(getJScrollPaneEfectos2(), null);
			jContentPane.add(getJButtonGuardar(), null);
			jContentPane.add(getJButtonSalir(), null);
			jContentPane.add(getJRadioButtonTratamientoAnticipado(), null);
			jContentPane.add(getJRadioButtonSindromeViral(), null);
			jContentPane.add(getJRadioButtonEnfermedad(), null);
			jContentPane.add(getJRadioButtonProfilaxis(), null);
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
			jDateChooserFecha.setBounds(new Rectangle(114, 15, 299, 33));
		}
		return jDateChooserFecha;
	}

	/**
	 * This method initializes jComboBoxDiagnosticos
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxDiagnosticos() {
		if (jComboBoxDiagnosticos == null) {
			jComboBoxDiagnosticos = new JComboBox();
			jComboBoxDiagnosticos.setBounds(new Rectangle(139, 56, 276, 33));
		}
		return jComboBoxDiagnosticos;
	}

	/**
	 * This method initializes jComboBoxEnfermedades
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxEnfermedades() {
		if (jComboBoxEnfermedades == null) {
			jComboBoxEnfermedades = new JComboBox();
			jComboBoxEnfermedades.setBounds(new Rectangle(25, 206, 193, 32));
		}
		return jComboBoxEnfermedades;
	}

	/**
	 * This method initializes jButtonUsar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonUsar() {
		if (jButtonUsar == null) {
			jButtonUsar = new JButton();
			jButtonUsar.setBounds(new Rectangle(249, 192, 80, 21));
			jButtonUsar.setText("Usar");
			jButtonUsar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					agregarEnfermedad();
				}
			});
		}
		return jButtonUsar;
	}

	/**
	 * This method initializes jButtonQuitar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonQuitar() {
		if (jButtonQuitar == null) {
			jButtonQuitar = new JButton();
			jButtonQuitar.setBounds(new Rectangle(249, 221, 80, 21));
			jButtonQuitar.setText("Quitar");
			jButtonQuitar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							quitarEnfermedad();
						}
					});
		}
		return jButtonQuitar;
	}

	/**
	 * This method initializes jComboBoxEnfermedadesUsadas
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxEnfermedadesUsadas() {
		if (jComboBoxEnfermedadesUsadas == null) {
			jComboBoxEnfermedadesUsadas = new JComboBox();
			jComboBoxEnfermedadesUsadas.setBounds(new Rectangle(339, 206, 193,
					32));
		}
		return jComboBoxEnfermedadesUsadas;
	}

	/**
	 * This method initializes jComboBoxDroga
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxDroga() {
		if (jComboBoxDroga == null) {
			jComboBoxDroga = new JComboBox();
			jComboBoxDroga.setBounds(new Rectangle(175, 277, 279, 30));
		}
		return jComboBoxDroga;
	}

	/**
	 * This method initializes jTextFieldDiasTratamiento
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldDiasTratamiento() {
		if (jTextFieldDiasTratamiento == null) {
			jTextFieldDiasTratamiento = new JTextField();
			jTextFieldDiasTratamiento
					.setBounds(new Rectangle(175, 319, 279, 31));
		}
		return jTextFieldDiasTratamiento;
	}

	/**
	 * This method initializes jScrollPaneEfectos2
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneEfectos2() {
		if (jScrollPaneEfectos2 == null) {
			jScrollPaneEfectos2 = new JScrollPane();
			jScrollPaneEfectos2.setBounds(new Rectangle(175, 362, 274, 80));
			jScrollPaneEfectos2
					.setViewportView(getJTextAreaEfectosSecundarios());
		}
		return jScrollPaneEfectos2;
	}

	/**
	 * This method initializes jTextAreaEfectosSecundarios
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextAreaEfectosSecundarios() {
		if (jTextAreaEfectosSecundarios == null) {
			jTextAreaEfectosSecundarios = new JTextArea();
		}
		return jTextAreaEfectosSecundarios;
	}

	/**
	 * This method initializes jButtonGuardar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonGuardar() {
		if (jButtonGuardar == null) {
			jButtonGuardar = new JButton();
			jButtonGuardar.setBounds(new Rectangle(413, 465, 144, 39));
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
	 * This method initializes jButtonSalir
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonSalir() {
		if (jButtonSalir == null) {
			jButtonSalir = new JButton();
			jButtonSalir.setBounds(new Rectangle(35, 465, 144, 39));
			jButtonSalir.setText("Salir");
			jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salir();
				}
			});
		}
		return jButtonSalir;
	}

	private void agregarEnfermedad() {
		if (this.jComboBoxEnfermedades.getItemCount() != 0) {
			CMVEnfermedades aux = (CMVEnfermedades) this.jComboBoxEnfermedades
					.getSelectedItem();
			this.jComboBoxEnfermedadesUsadas.addItem(aux);
			this.jComboBoxEnfermedades.removeItem(aux);
		}
	}

	private void quitarEnfermedad() {
		CMVEnfermedades aux = (CMVEnfermedades) this.jComboBoxEnfermedadesUsadas
				.getSelectedItem();
		this.jComboBoxEnfermedades.addItem(aux);
		this.jComboBoxEnfermedadesUsadas.removeItem(aux);
	}

	private void salir() {
		this.dispose();
	}

	private void guardar() {
		boolean verificarFecha = true;
		if (this.usado == null)
			verificarFecha = Fachada.getInstancia().verificarFechaCMV(this.id,
					this.jDateChooserFecha.getCalendar());

		if (!verificarFecha) {
			JOptionPane.showMessageDialog(this,
					"En esa fecha ya existe una CMV", "Error", 2);
		} else {
			CMV aux = new CMV();
			aux.setIdTrasplante(this.id);
			if (this.usado != null) {
				aux.setFecha(this.usado.getFecha());
			} else {
				aux.setFecha(this.jDateChooserFecha.getCalendar());
			}
			aux.setDiagnostico((CMVDiagnostico) this.jComboBoxDiagnosticos
					.getSelectedItem());
			aux.setTmAnti(this.jRadioButtonTratamientoAnticipado.isSelected());
			aux.setSindromeViral(this.jRadioButtonSindromeViral.isSelected());
			if (this.jRadioButtonEnfermedad.isSelected()) {
				for (int x = 0; x < this.jComboBoxEnfermedadesUsadas
						.getItemCount(); x++) {
					CMVEnfermedades auxEnf = (CMVEnfermedades) this.jComboBoxEnfermedadesUsadas
							.getItemAt(x);
					CMVusoEnfermedades auxUso = new CMVusoEnfermedades();
					auxUso.setIdTrasplante(this.id);
					auxUso.setFecha(aux.getFecha());
					auxUso.setEnfermedad(auxEnf);
					aux.getEnfermedades().add(auxUso);
				}
			}else{
				aux.setEnfermedades(null);
			}
			aux.setProfilaxis(this.jRadioButtonProfilaxis.isSelected());
			aux.setDroga((CMVDrogas) this.jComboBoxDroga.getSelectedItem());
			boolean guardar = true;
			try {
				aux.setDiasTm(Integer.parseInt(this.jTextFieldDiasTratamiento
						.getText()));
			} catch (Exception e) {
				guardar = false;
				JOptionPane.showMessageDialog(this,
						"Ingrese solamente numeros enteros", "Error", 2);
			}
			aux.setEfectoSecundario(this.jTextAreaEfectosSecundarios.getText());
			if (guardar) {
				Fachada.getInstancia().guardarCMV(aux);
				this.salir();
			}
		}
	}

	/**
	 * This method initializes jRadioButtonTratamientoAnticipado
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonTratamientoAnticipado() {
		if (jRadioButtonTratamientoAnticipado == null) {
			jRadioButtonTratamientoAnticipado = new JRadioButton();
			jRadioButtonTratamientoAnticipado.setBounds(new Rectangle(24, 105,
					164, 31));
			jRadioButtonTratamientoAnticipado.setBackground(new Color(255, 255, 204));
			jRadioButtonTratamientoAnticipado.setText("Tratamiento anticipado");
			jRadioButtonTratamientoAnticipado
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							manejarRadioTr();
						}
					});
		}
		return jRadioButtonTratamientoAnticipado;
	}

	/**
	 * This method initializes jRadioButtonSindromeViral
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonSindromeViral() {
		if (jRadioButtonSindromeViral == null) {
			jRadioButtonSindromeViral = new JRadioButton();
			jRadioButtonSindromeViral
					.setBounds(new Rectangle(209, 105, 121, 29));
			jRadioButtonSindromeViral.setText("Sindrome Viral");
			jRadioButtonSindromeViral.setBackground(new Color(255, 255, 204));
			jRadioButtonSindromeViral
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							manejarRadioSV();
						}
					});
		}
		return jRadioButtonSindromeViral;
	}

	/**
	 * This method initializes jRadioButtonEnfermedad
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonEnfermedad() {
		if (jRadioButtonEnfermedad == null) {
			jRadioButtonEnfermedad = new JRadioButton();
			jRadioButtonEnfermedad.setBounds(new Rectangle(27, 156, 102, 35));
			jRadioButtonEnfermedad.setText("Enfermedad");
			jRadioButtonEnfermedad.setBackground(new Color(255, 255, 204));
			jRadioButtonEnfermedad
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							manejarRadioEnf();
						}
					});
		}
		return jRadioButtonEnfermedad;
	}

	/**
	 * This method initializes jRadioButtonProfilaxis
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonProfilaxis() {
		if (jRadioButtonProfilaxis == null) {
			jRadioButtonProfilaxis = new JRadioButton();
			jRadioButtonProfilaxis.setBounds(new Rectangle(209, 155, 118, 26));
			jRadioButtonProfilaxis.setText("Profilaxis");
			jRadioButtonProfilaxis.setBackground(new Color(255, 255, 204));
			jRadioButtonProfilaxis
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							manejarRadioPr();
						}
					});
		}
		return jRadioButtonProfilaxis;
	}

	private void ocultarEnfermedad() {
		this.jComboBoxEnfermedades.setVisible(false);
		this.jComboBoxEnfermedadesUsadas.setVisible(false);
		this.jButtonQuitar.setVisible(false);
		this.jButtonUsar.setVisible(false);
	}

	private void mostrarEnfermedad() {
		this.jComboBoxEnfermedades.setVisible(true);
		this.jComboBoxEnfermedadesUsadas.setVisible(true);
		this.jButtonQuitar.setVisible(true);
		this.jButtonUsar.setVisible(true);
	}

	private void manejarRadioTr() {
		if (this.jRadioButtonTratamientoAnticipado.isSelected()) {
			this.jRadioButtonTratamientoAnticipado.setSelected(true);
			this.jRadioButtonEnfermedad.setSelected(false);
			this.jRadioButtonProfilaxis.setSelected(false);
			this.jRadioButtonSindromeViral.setSelected(false);
			this.ocultarEnfermedad();
		}
	}

	private void manejarRadioSV() {
		if (this.jRadioButtonSindromeViral.isSelected()) {
			this.jRadioButtonEnfermedad.setSelected(false);
			this.jRadioButtonProfilaxis.setSelected(false);
			this.jRadioButtonTratamientoAnticipado.setSelected(false);
			this.ocultarEnfermedad();
		}
	}

	private void manejarRadioPr() {
		if (this.jRadioButtonProfilaxis.isSelected()) {
			this.jRadioButtonEnfermedad.setSelected(false);
			this.jRadioButtonSindromeViral.setSelected(false);
			this.jRadioButtonTratamientoAnticipado.setSelected(false);
			this.ocultarEnfermedad();
		}
	}

	private void manejarRadioEnf() {
		if (this.jRadioButtonEnfermedad.isSelected()) {
			this.jRadioButtonProfilaxis.setSelected(false);
			this.jRadioButtonSindromeViral.setSelected(false);
			this.jRadioButtonTratamientoAnticipado.setSelected(false);
			this.mostrarEnfermedad();
		}
	}
} // @jve:decl-index=0:visual-constraint="10,10"
