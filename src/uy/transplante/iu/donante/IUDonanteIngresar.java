package uy.transplante.iu.donante;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import uy.transplante.dominio.AntecedentesDonante;
import uy.transplante.dominio.CausaMuerteDonante;
import uy.transplante.dominio.Donante;
import uy.transplante.dominio.DonanteSerolUsado;
import uy.transplante.dominio.OrganosDonante;
import uy.transplante.dominio.Serol;
import uy.transplante.dominio.SerolDatos;

import logica.Fachada;

public class IUDonanteIngresar extends JFrame implements java.util.Observer {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelId = null;
	private JTextField jTextFieldId = null;
	private JLabel jLabelTipo = null;
	private JRadioButton jRadioButtonVivo = null;
	private JRadioButton jRadioButtonCadaverico = null;
	private JLabel jLabelSexo = null;
	private JRadioButton jRadioButtonMasculino = null;
	private JRadioButton jRadioButtonFemenino = null;
	private JLabel jLabelEdad = null;
	private JTextField jTextFieldEdad = null;
	private JCheckBox jCheckBoxEnastHemo = null;
	private JLabel jLabelCausaMuerte = null;
	private JComboBox jComboBoxCausasMuertes = null;
	private JLabel jLabelAntecedentes = null;
	private JLabel jLabelCrP = null;
	private JTextField jTextFieldCrP = null;
	private JLabel jLabelOtros = null;
	private JScrollPane jScrollPaneOtros = null;
	private JTextArea jTextAreaOtros = null;
	private JButton jButtonGuardar = null;
	private JButton jButtonSalir = null;
	private ArrayList<AntecedentesDonante> antecedentes; // @jve:decl-index=0:
	private ArrayList<CausaMuerteDonante> causasMuerte;
	private ArrayList<String> organos = new ArrayList<String>(); // @jve:decl-index=0:
	private Fachada instancia = Fachada.getInstancia();
	private JScrollPane jScrollPaneAntecedentes = null;
	private JList jListAntecedentes = null;
	private JLabel jLabelOrganos = null;
	private JScrollPane jScrollPaneOrganos = null;
	private JList jListOrganos = null;
	private JLabel jLabelElegirSerol = null;
	private JComboBox jComboBoxElegirSerol = null;
	private JLabel jLabelElegirSerolDatos = null;
	private JScrollPane jScrollPaneSerolDatos = null;
	private JList jListSerolDato = null;
	private JButton jButtonAgregarSerol = null;
	private JButton jButtonEliminarSerol = null;
	private JComboBox jComboBoxSerolesUsados = null;
	private JLabel jLabelSerolUsados = null;
	private ArrayList<DonanteSerolUsado> listaSerolesUsados = new ArrayList<DonanteSerolUsado>();
	private ArrayList<Serol> listaSeroles;
	private JLabel jLabelGrupoSanguineo = null;
	private JComboBox jComboBoxGrupoSanguineo = null;
	private JLabel jLabelRelacionFiliar = null;
	private JComboBox jComboBoxRelacionFiliar = null;
	private JLabel jLabelPeso = null;
	private JTextField jTextFieldPeso = null;
	private JLabel jLabelAltura = null;
	private JTextField jTextFieldAltura = null;
	private boolean cargarAntecedentes = true;
	private boolean cargarSeroles = true;
	private boolean cargarCausaMuerte = true;

	/**
	 * This is the default constructor
	 */
	public IUDonanteIngresar() {
		super();
		initialize();
		instancia.agregarObservador(this);
		// Los pongo aca para que los datos no se vean afectados
		this.jRadioButtonVivo.setSelected(true);
		this.jRadioButtonMasculino.setSelected(true);
		cargarDatos();
		this.cargarSeroles = false;
		this.cargarAntecedentes = false;
		this.cargarCausaMuerte = false;
	}

	
	
	private void cargarDatos() {
		// Cargo las Causas de muerte y los antecedentes
		if(this.cargarAntecedentes){
			antecedentes = Fachada.getInstancia().obtenerTodosAntecedentesDonante();
			this.jListAntecedentes.setListData(antecedentes.toArray());
		}
		if(this.cargarCausaMuerte){
			causasMuerte = Fachada.getInstancia().obtenerTodasCausasMuerteDonante();
			for (int x = 0; x < causasMuerte.size(); x++) {
				this.jComboBoxCausasMuertes.addItem(causasMuerte.get(x));
			}
		}
		// Cargo los tipos de organos.
		organos.add("Corazon");
		organos.add("Pancreas");
		organos.add("Pulmon");
		organos.add("Riñon");
		organos.add("Intestino");
		organos.add("Otros");
		this.jListOrganos.setListData(organos.toArray());
		if(this.cargarSeroles){
			listaSeroles = Fachada.getInstancia().obtenerTodosLosSerol();
			for (int x = 0; x < listaSeroles.size(); x++) {
				this.jComboBoxElegirSerol.addItem(listaSeroles.get(x));
			}
		}
		// Grupo Sanguineo
		String aux = "A";
		this.jComboBoxGrupoSanguineo.addItem(aux);
		aux = "B";
		this.jComboBoxGrupoSanguineo.addItem(aux);
		aux = "AB";
		this.jComboBoxGrupoSanguineo.addItem(aux);
		aux = "O";
		this.jComboBoxGrupoSanguineo.addItem(aux);

		// Relacion Filiar
		aux = "padre/madre";
		this.jComboBoxRelacionFiliar.addItem(aux);
		aux = "hermano/a";
		this.jComboBoxRelacionFiliar.addItem(aux);
		aux = "Hijo/a";
		this.jComboBoxRelacionFiliar.addItem(aux);
		aux = "esposo/a";
		this.jComboBoxRelacionFiliar.addItem(aux);
		aux = "otro";
		this.jComboBoxRelacionFiliar.addItem(aux);
	}

	private void cargarDatosSerol() {
		Serol serol = (Serol) this.jComboBoxElegirSerol.getSelectedItem();
		if (serol != null) {
			this.jListSerolDato.setListData(serol.getDatos().toArray());
		}
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(711, 770);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Ingresar Donante");
		this.setLocation(100, 0);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelAltura = new JLabel();
			jLabelAltura.setBounds(new Rectangle(360, 238, 117, 28));
			jLabelAltura.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelAltura.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelAltura.setText("Altura :");
			jLabelAltura.setFont(new Font("Dialog", Font.BOLD, 16));
			jLabelPeso = new JLabel();
			jLabelPeso.setBounds(new Rectangle(361, 191, 113, 28));
			jLabelPeso.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelPeso.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelPeso.setText("Peso :");
			jLabelPeso.setFont(new Font("Dialog", Font.BOLD, 16));
			jLabelRelacionFiliar = new JLabel();
			jLabelRelacionFiliar.setBounds(new Rectangle(23, 113, 115, 33));
			jLabelRelacionFiliar.setText("Relacion Filiar:");
			jLabelRelacionFiliar.setFont(new Font("Dialog", Font.BOLD, 16));
			jLabelGrupoSanguineo = new JLabel();
			jLabelGrupoSanguineo.setBounds(new Rectangle(361, 148, 143, 29));
			jLabelGrupoSanguineo.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelGrupoSanguineo
					.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelGrupoSanguineo.setText("Grupo Sanguineo:");
			jLabelGrupoSanguineo.setFont(new Font("Dialog", Font.BOLD, 16));
			jLabelSerolUsados = new JLabel();
			jLabelSerolUsados.setBounds(new Rectangle(513, 310, 150, 35));
			jLabelSerolUsados.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelSerolUsados.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelSerolUsados.setText("Serologias elegidas");
			jLabelSerolUsados.setFont(new Font("Dialog", Font.BOLD, 16));
			jLabelElegirSerolDatos = new JLabel();
			jLabelElegirSerolDatos.setBounds(new Rectangle(239, 303, 116, 29));
			jLabelElegirSerolDatos
					.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelElegirSerolDatos
					.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelElegirSerolDatos.setText("Elegir Dato");
			jLabelElegirSerolDatos.setFont(new Font("Dialog", Font.BOLD, 16));
			jLabelElegirSerol = new JLabel();
			jLabelElegirSerol.setBounds(new Rectangle(23, 298, 128, 35));
			jLabelElegirSerol.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelElegirSerol.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelElegirSerol.setText("Elegir Serologia");
			jLabelElegirSerol.setFont(new Font("Dialog", Font.BOLD, 16));
			jLabelOrganos = new JLabel();
			jLabelOrganos.setBounds(new Rectangle(338, 441, 154, 35));
			jLabelOrganos.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelOrganos.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelOrganos.setText("Organos Donados:");
			jLabelOrganos.setFont(new Font("Dialog", Font.BOLD, 16));
			jLabelOtros = new JLabel();
			jLabelOtros.setBounds(new Rectangle(16, 564, 136, 31));
			jLabelOtros.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelOtros.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelOtros.setText("Otros:");
			jLabelOtros.setFont(new Font("Dialog", Font.BOLD, 16));
			jLabelCrP = new JLabel();
			jLabelCrP.setBounds(new Rectangle(371, 66, 93, 33));
			jLabelCrP.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelCrP.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelCrP.setText("Cr p(mg/dl):");
			jLabelCrP.setFont(new Font("Dialog", Font.BOLD, 16));
			jLabelAntecedentes = new JLabel();
			jLabelAntecedentes.setBounds(new Rectangle(10, 442, 119, 29));
			jLabelAntecedentes.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelAntecedentes.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelAntecedentes.setText("Antecedentes:");
			jLabelAntecedentes.setFont(new Font("Dialog", Font.BOLD, 16));
			jLabelCausaMuerte = new JLabel();
			jLabelCausaMuerte.setBounds(new Rectangle(367, 110, 136, 31));
			jLabelCausaMuerte.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelCausaMuerte.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelCausaMuerte.setText("Causa de muerte:");
			jLabelCausaMuerte.setFont(new Font("Dialog", Font.BOLD, 16));
			jLabelEdad = new JLabel();
			jLabelEdad.setBounds(new Rectangle(373, 24, 93, 33));
			jLabelEdad.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelEdad.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelEdad.setText("Edad:");
			jLabelEdad.setFont(new Font("Dialog", Font.BOLD, 16));
			jLabelSexo = new JLabel();
			jLabelSexo.setBounds(new Rectangle(18, 160, 93, 33));
			jLabelSexo.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelSexo.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelSexo.setText("Sexo:");
			jLabelSexo.setFont(new Font("Dialog", Font.BOLD, 16));
			jLabelTipo = new JLabel();
			jLabelTipo.setBounds(new Rectangle(22, 67, 93, 33));
			jLabelTipo.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelTipo.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelTipo.setText("Tipo:");
			jLabelTipo.setFont(new Font("Dialog", Font.BOLD, 16));
			jLabelId = new JLabel();
			jLabelId.setBounds(new Rectangle(22, 24, 93, 33));
			jLabelId.setFont(new Font("Dialog", Font.BOLD, 16));
			jLabelId.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelId.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabelId.setText("Id:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 204));
			jContentPane.add(jLabelId, null);
			jContentPane.add(getJTextFieldId(), null);
			jContentPane.add(jLabelTipo, null);
			jContentPane.add(getJRadioButtonVivo(), null);
			jContentPane.add(getJRadioButtonCadaverico(), null);
			jContentPane.add(jLabelSexo, null);
			jContentPane.add(getJRadioButtonMasculino(), null);
			jContentPane.add(getJRadioButtonFemenino(), null);
			jContentPane.add(jLabelEdad, null);
			jContentPane.add(getJTextFieldEdad(), null);
			jContentPane.add(getJCheckBoxEnastHemo(), null);
			jContentPane.add(jLabelCausaMuerte, null);
			jContentPane.add(getJComboBoxCausasMuertes(), null);
			jContentPane.add(jLabelAntecedentes, null);
			jContentPane.add(jLabelCrP, null);
			jContentPane.add(getJTextFieldCrP(), null);
			jContentPane.add(jLabelOtros, null);
			jContentPane.add(getJScrollPaneOtros(), null);
			jContentPane.add(getJButtonGuardar(), null);
			jContentPane.add(getJButtonSalir(), null);
			jContentPane.add(getJScrollPaneAntecedentes(), null);
			jContentPane.add(jLabelOrganos, null);
			jContentPane.add(getJScrollPaneOrganos(), null);
			jContentPane.add(jLabelElegirSerol, null);
			jContentPane.add(getJComboBoxElegirSerol(), null);
			jContentPane.add(jLabelElegirSerolDatos, null);
			jContentPane.add(getJScrollPaneSerolDatos(), null);
			jContentPane.add(getJButtonAgregarSerol(), null);
			jContentPane.add(getJButtonEliminarSerol(), null);
			jContentPane.add(getJComboBoxSerolesUsados(), null);
			jContentPane.add(jLabelSerolUsados, null);
			jContentPane.add(jLabelGrupoSanguineo, null);
			jContentPane.add(getJComboBoxGrupoSanguineo(), null);
			jContentPane.add(jLabelRelacionFiliar, null);
			jContentPane.add(getJComboBoxRelacionFiliar(), null);
			jContentPane.add(jLabelPeso, null);
			jContentPane.add(getJTextFieldPeso(), null);
			jContentPane.add(jLabelAltura, null);
			jContentPane.add(getJTextFieldAltura(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextFieldId
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldId() {
		if (jTextFieldId == null) {
			jTextFieldId = new JTextField();
			jTextFieldId.setBounds(new Rectangle(169, 23, 173, 33));
			jTextFieldId.setFont(new Font("Dialog", Font.PLAIN, 16));
		}
		return jTextFieldId;
	}

	/**
	 * This method initializes jRadioButtonVivo
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonVivo() {
		if (jRadioButtonVivo == null) {
			jRadioButtonVivo = new JRadioButton();
			jRadioButtonVivo.setBounds(new Rectangle(141, 73, 71, 24));
			jRadioButtonVivo.setBackground(new Color(255, 255, 204));
			jRadioButtonVivo.setFont(new Font("Dialog", Font.BOLD, 16));
			jRadioButtonVivo.setText("Vivo");
			jRadioButtonVivo
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							cambiarTipoVivo();
						}
					});
		}
		return jRadioButtonVivo;
	}

	/**
	 * This method initializes jRadioButtonCadaverico
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonCadaverico() {
		if (jRadioButtonCadaverico == null) {
			jRadioButtonCadaverico = new JRadioButton();
			jRadioButtonCadaverico.setBounds(new Rectangle(210, 73, 113, 28));
			jRadioButtonCadaverico.setFont(new Font("Dialog", Font.BOLD, 16));
			jRadioButtonCadaverico.setText("Cadaverico");
			jRadioButtonCadaverico.setBackground(new Color(255, 255, 204));
			jRadioButtonCadaverico
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							cambiarTipoCadaverico();
						}
					});
		}
		return jRadioButtonCadaverico;
	}

	/**
	 * This method initializes jRadioButtonMasculino
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonMasculino() {
		if (jRadioButtonMasculino == null) {
			jRadioButtonMasculino = new JRadioButton();
			jRadioButtonMasculino.setBounds(new Rectangle(138, 160, 72, 28));
			jRadioButtonMasculino.setFont(new Font("Dialog", Font.BOLD, 16));
			jRadioButtonMasculino.setText("M");
			jRadioButtonMasculino.setBackground(new Color(255, 255, 204));
			jRadioButtonMasculino
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							cambiarSexoM();
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
			jRadioButtonFemenino.setBounds(new Rectangle(209, 160, 83, 33));
			jRadioButtonFemenino.setFont(new Font("Dialog", Font.BOLD, 16));
			jRadioButtonFemenino.setText("F");
			jRadioButtonFemenino.setBackground(new Color(255, 255, 204));
			jRadioButtonFemenino
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							cambiarSexoF();
						}
					});
		}
		return jRadioButtonFemenino;
	}

	/**
	 * This method initializes jTextFieldEdad
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldEdad() {
		if (jTextFieldEdad == null) {
			jTextFieldEdad = new JTextField();
			jTextFieldEdad.setBounds(new Rectangle(479, 24, 167, 33));
			jTextFieldEdad.setFont(new Font("Dialog", Font.PLAIN, 16));
		}
		return jTextFieldEdad;
	}

	/**
	 * This method initializes jCheckBoxEnastHemo
	 * 
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxEnastHemo() {
		if (jCheckBoxEnastHemo == null) {
			jCheckBoxEnastHemo = new JCheckBox();
			jCheckBoxEnastHemo.setBounds(new Rectangle(18, 195, 247, 30));
			jCheckBoxEnastHemo.setFont(new Font("Dialog", Font.BOLD, 16));
			jCheckBoxEnastHemo.setHorizontalTextPosition(SwingConstants.LEFT);
			jCheckBoxEnastHemo.setBackground(new Color(255, 255, 204));
			jCheckBoxEnastHemo.setText("Donante Criterio Expandido");
		}
		return jCheckBoxEnastHemo;
	}

	/**
	 * This method initializes jComboBoxCausasMuertes
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxCausasMuertes() {
		if (jComboBoxCausasMuertes == null) {
			jComboBoxCausasMuertes = new JComboBox();
			jComboBoxCausasMuertes.setBounds(new Rectangle(509, 110, 168, 32));
		}
		return jComboBoxCausasMuertes;
	}

	/**
	 * This method initializes jTextFieldCrP
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldCrP() {
		if (jTextFieldCrP == null) {
			jTextFieldCrP = new JTextField();
			jTextFieldCrP.setBounds(new Rectangle(478, 66, 182, 33));
			jTextFieldCrP.setFont(new Font("Dialog", Font.PLAIN, 16));
		}
		return jTextFieldCrP;
	}

	/**
	 * This method initializes jScrollPaneOtros
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneOtros() {
		if (jScrollPaneOtros == null) {
			jScrollPaneOtros = new JScrollPane();
			jScrollPaneOtros.setBounds(new Rectangle(186, 561, 487, 104));
			jScrollPaneOtros.setViewportView(getJTextAreaOtros());
		}
		return jScrollPaneOtros;
	}

	/**
	 * This method initializes jTextAreaOtros
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextAreaOtros() {
		if (jTextAreaOtros == null) {
			jTextAreaOtros = new JTextArea();
		}
		return jTextAreaOtros;
	}

	/**
	 * This method initializes jButtonGuardar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonGuardar() {
		if (jButtonGuardar == null) {
			jButtonGuardar = new JButton();
			jButtonGuardar.setBounds(new Rectangle(538, 680, 129, 37));
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
			jButtonSalir.setBounds(new Rectangle(348, 678, 129, 37));
			jButtonSalir.setText("Salir");
			jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salir();
				}
			});
		}
		return jButtonSalir;
	}

	public void update(Observable o, Object arg) {
		if(Fachada.getInstancia().getLugar() == Fachada.SEROL) this.cargarSeroles = true;
		if(Fachada.getInstancia().getLugar() == Fachada.ANTECEDENTE_DONANTE) this.cargarAntecedentes = true;
		if(Fachada.getInstancia().getLugar() == Fachada.CAUSA_MUERTE_DONANTE) this.cargarCausaMuerte = true;;
		this.cargarDatos();
		this.cargarSeroles = false;
		this.cargarAntecedentes = false;
		this.cargarCausaMuerte = false;
	}

	private void guardar() {
		// Chequeo todos los datos
		boolean todoOk = true;
		if (this.jTextFieldId.getText().equalsIgnoreCase("")
				|| this.jTextFieldId.getText().equalsIgnoreCase(" ")) {
			todoOk = false;
			JOptionPane.showMessageDialog(this, "Tiene que ingresar un Id",
					"Falta información", 2);
		}
		if (todoOk) {
			Donante d = new Donante();
			d.setId(this.jTextFieldId.getText());
			if (this.jRadioButtonCadaverico.isSelected()) {
				d.setTipo("Cadavérico");
				d.setRelacionFiliar(null);
			} else {
				d.setTipo("Vivo");
				d.setRelacionFiliar((String) this.jComboBoxRelacionFiliar
						.getSelectedItem());
			}
			if (this.jRadioButtonMasculino.isSelected()) {
				d.setSexo("M");
			} else {
				d.setSexo("F");
			}
			String lugar = "";
			try {
				lugar = "Id";
				d.setEdad(Integer.parseInt(this.jTextFieldEdad.getText()));
				lugar = "Cr p";
				d.setCrP(Float.parseFloat(this.jTextFieldCrP.getText()));
				lugar = "Peso";
				d.setPeso(Integer.parseInt(this.jTextFieldPeso.getText()));
				lugar = "Altura";
				d.setTalla(Integer.parseInt(this.jTextFieldAltura.getText()));
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Dato mal ingresado en "
						+ lugar, "Error", 2);
				return;
			}

			d.setCausaMuerte((CausaMuerteDonante) this.jComboBoxCausasMuertes
					.getSelectedItem());
			d.setNumCausaMuerte(d.getCausaMuerte().getId());
			d.setEnastabHemod(this.jCheckBoxEnastHemo.isSelected());

			ArrayList<AntecedentesDonante> misAntecedentes = new ArrayList<AntecedentesDonante>();
			int[] numerosAntecedentes = this.jListAntecedentes
					.getSelectedIndices();
			for (int x = 0; x < numerosAntecedentes.length; x++) {
				misAntecedentes.add(this.antecedentes
						.get(numerosAntecedentes[x]));
			}
			d.setAntecedentes(misAntecedentes);
			ArrayList<OrganosDonante> misOrganos = new ArrayList<OrganosDonante>();
			int[] numOrganos = this.jListOrganos.getSelectedIndices();
			for (int k = 0; k < numOrganos.length; k++) {
				OrganosDonante aux = new OrganosDonante();
				aux.setId(d.getId());
				aux.setOrgano(this.organos.get(k));
				misOrganos.add(aux);
			}
			d.setOrganos(misOrganos);
			d.setOtros(this.jTextAreaOtros.getText());
			d.setListaSeroles(this.listaSerolesUsados);
			d.setGrupoSanguineo((String) this.jComboBoxGrupoSanguineo
					.getSelectedItem());
			if (d.getOid() == 0) {
				Fachada.getInstancia().guardarDonante(d);
				this.salir();
			} else {
				JOptionPane.showMessageDialog(this,
						"Ya existe un donante con ese ID", "ERROR", 2);
			}

		}
	}

	private void salir() {
		instancia.eliminarObservador(this);
		this.dispose();
	}

	/**
	 * This method initializes jScrollPaneAntecedentes
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneAntecedentes() {
		if (jScrollPaneAntecedentes == null) {
			jScrollPaneAntecedentes = new JScrollPane();
			jScrollPaneAntecedentes
					.setBounds(new Rectangle(140, 433, 184, 113));
			jScrollPaneAntecedentes.setViewportView(getJListAntecedentes());
		}
		return jScrollPaneAntecedentes;
	}

	/**
	 * This method initializes jListAntecedentes
	 * 
	 * @return javax.swing.JList
	 */
	private JList getJListAntecedentes() {
		if (jListAntecedentes == null) {
			jListAntecedentes = new JList();
		}
		return jListAntecedentes;
	}

	/**
	 * This method initializes jScrollPaneOrganos
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneOrganos() {
		if (jScrollPaneOrganos == null) {
			jScrollPaneOrganos = new JScrollPane();
			jScrollPaneOrganos.setBounds(new Rectangle(504, 431, 162, 118));
			jScrollPaneOrganos.setViewportView(getJListOrganos());
		}
		return jScrollPaneOrganos;
	}

	/**
	 * This method initializes jListOrganos
	 * 
	 * @return javax.swing.JList
	 */
	private JList getJListOrganos() {
		if (jListOrganos == null) {
			jListOrganos = new JList();
		}
		return jListOrganos;
	}

	/**
	 * This method initializes jComboBoxElegirSerol
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxElegirSerol() {
		if (jComboBoxElegirSerol == null) {
			jComboBoxElegirSerol = new JComboBox();
			jComboBoxElegirSerol.setBounds(new Rectangle(9, 361, 172, 37));
			jComboBoxElegirSerol
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							cargarDatosSerol();
						}
					});
		}
		return jComboBoxElegirSerol;
	}

	/**
	 * This method initializes jScrollPaneSerolDatos
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneSerolDatos() {
		if (jScrollPaneSerolDatos == null) {
			jScrollPaneSerolDatos = new JScrollPane();
			jScrollPaneSerolDatos.setBounds(new Rectangle(199, 344, 208, 73));
			jScrollPaneSerolDatos.setViewportView(getJListSerolDato());
		}
		return jScrollPaneSerolDatos;
	}

	/**
	 * This method initializes jListSerolDato
	 * 
	 * @return javax.swing.JList
	 */
	private JList getJListSerolDato() {
		if (jListSerolDato == null) {
			jListSerolDato = new JList();
		}
		return jListSerolDato;
	}

	/**
	 * This method initializes jButtonAgregarSerol
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAgregarSerol() {
		if (jButtonAgregarSerol == null) {
			jButtonAgregarSerol = new JButton();
			jButtonAgregarSerol.setBounds(new Rectangle(418, 345, 75, 28));
			jButtonAgregarSerol.setText(">>");
			jButtonAgregarSerol
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							cargarSerol();
						}
					});
		}
		return jButtonAgregarSerol;
	}

	/**
	 * This method initializes jButtonEliminarSerol
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonEliminarSerol() {
		if (jButtonEliminarSerol == null) {
			jButtonEliminarSerol = new JButton();
			jButtonEliminarSerol.setBounds(new Rectangle(419, 383, 75, 28));
			jButtonEliminarSerol.setText("<<");
			jButtonEliminarSerol
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							eliminarSerol();
						}
					});
		}
		return jButtonEliminarSerol;
	}

	/**
	 * This method initializes jComboBoxSerolesUsados
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxSerolesUsados() {
		if (jComboBoxSerolesUsados == null) {
			jComboBoxSerolesUsados = new JComboBox();
			jComboBoxSerolesUsados.setBounds(new Rectangle(502, 360, 172, 37));
		}
		return jComboBoxSerolesUsados;
	}

	private void cargarSerol() {
		DonanteSerolUsado s = new DonanteSerolUsado();
		s.setSerol((Serol) this.jComboBoxElegirSerol.getSelectedItem());
		if(s.getSerol().getTipo().equalsIgnoreCase(" - ")){
			return;
		}
		s.setDato((SerolDatos) this.jListSerolDato.getSelectedValue());
		ArrayList<DonanteSerolUsado> usados = new ArrayList<DonanteSerolUsado>();
		this.jComboBoxSerolesUsados.addItem(s);
		this.listaSerolesUsados.add(s);
		this.jListSerolDato.setListData(usados.toArray());
		this.jComboBoxElegirSerol.removeItem(s.getSerol());

	}

	private void eliminarSerol() {
		DonanteSerolUsado s = (DonanteSerolUsado) this.jComboBoxSerolesUsados
				.getSelectedItem();
		if (s != null) {
			this.jComboBoxElegirSerol.addItem(s.getSerol());
			this.listaSerolesUsados.remove(s);
			this.jComboBoxSerolesUsados.removeItem(s);
			s.leer();
		}
	}

	/**
	 * This method initializes jComboBoxGrupoSanguineo
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxGrupoSanguineo() {
		if (jComboBoxGrupoSanguineo == null) {
			jComboBoxGrupoSanguineo = new JComboBox();
			jComboBoxGrupoSanguineo.setBounds(new Rectangle(509, 151, 170, 32));
		}
		return jComboBoxGrupoSanguineo;
	}

	/**
	 * This method initializes jComboBoxRelacionFiliar
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxRelacionFiliar() {
		if (jComboBoxRelacionFiliar == null) {
			jComboBoxRelacionFiliar = new JComboBox();
			jComboBoxRelacionFiliar.setBounds(new Rectangle(154, 113, 183, 35));
		}
		return jComboBoxRelacionFiliar;
	}

	private void cambiarTipoVivo() {
		if (this.jRadioButtonVivo.isSelected()) {
			this.jRadioButtonCadaverico.setSelected(false);
			this.jComboBoxRelacionFiliar.setVisible(true);
			this.jLabelRelacionFiliar.setVisible(true);
		} else {
			this.jRadioButtonCadaverico.setSelected(true);
			this.jComboBoxRelacionFiliar.setVisible(false);
			this.jLabelRelacionFiliar.setVisible(false);
		}
	}

	private void cambiarTipoCadaverico() {
		if (this.jRadioButtonCadaverico.isSelected()) {
			this.jRadioButtonVivo.setSelected(false);
			this.jComboBoxRelacionFiliar.setVisible(false);
			this.jLabelRelacionFiliar.setVisible(false);
		} else {
			this.jRadioButtonVivo.setSelected(true);
			this.jComboBoxRelacionFiliar.setVisible(true);
			this.jLabelRelacionFiliar.setVisible(true);
		}
	}

	private void cambiarSexoM() {
		if (this.jRadioButtonMasculino.isSelected()) {
			this.jRadioButtonFemenino.setSelected(false);
		} else {
			this.jRadioButtonFemenino.setSelected(true);
		}
	}

	private void cambiarSexoF() {
		if (this.jRadioButtonFemenino.isSelected()) {
			this.jRadioButtonMasculino.setSelected(false);
		} else {
			this.jRadioButtonMasculino.setSelected(true);
		}
	}

	/**
	 * This method initializes jTextFieldPeso
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldPeso() {
		if (jTextFieldPeso == null) {
			jTextFieldPeso = new JTextField();
			jTextFieldPeso.setBounds(new Rectangle(488, 192, 177, 30));
			jTextFieldPeso.setFont(new Font("Dialog", Font.PLAIN, 16));
		}
		return jTextFieldPeso;
	}

	/**
	 * This method initializes jTextFieldAltura
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldAltura() {
		if (jTextFieldAltura == null) {
			jTextFieldAltura = new JTextField();
			jTextFieldAltura.setBounds(new Rectangle(486, 234, 179, 34));
			jTextFieldAltura.setFont(new Font("Dialog", Font.PLAIN, 16));
		}
		return jTextFieldAltura;
	}
} // @jve:decl-index=0:visual-constraint="10,10"
