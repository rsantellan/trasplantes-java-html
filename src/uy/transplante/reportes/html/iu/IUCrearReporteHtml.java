package uy.transplante.reportes.html.iu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import logica.Fachada;
import javax.swing.JCheckBox;

import uy.transplante.dominio.Paciente;
import uy.transplante.dominio.PacientePreTrasplante;

public class IUCrearReporteHtml extends JFrame implements
		java.util.Observer {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JDesktopPane jDesktopPaneBuscar = null;
	private JLabel jLabelBuscar = null;
	private JLabel jLabelBuscarPor = null;
	private JTextField jTextFieldBuscar = null;
	private JScrollPane jScrollPaneResultados = null;
	private JList jListResultados = null;
	private JButton jButtonBuscar = null;

	private Paciente paciente = null;
	private PacientePreTrasplante preTrasplante = null;

	private JMenuBar jJMenuBarAtras = null;
	private JMenu jMenuAtras = null;
	private JMenuItem jMenuItemSalir = null;
	private JButton jButtonCreateReport = null;
	private JDesktopPane jDesktopPanePreTrasplante = null;
	private JLabel jLabelPreTrasplante = null;
	private JScrollPane jScrollPanePreTrasplante = null;
	private JList jListPreTrasplante = null;
	private JCheckBox jCheckBoxPacienteBasico = null;
	private JCheckBox jCheckBoxPerdidaDelInjerto = null;
	private JCheckBox jCheckBoxMuerteDelPaciente = null;
	private JCheckBox jCheckBoxPreTransplante = null;
	private JCheckBox jCheckBoxTransplante = null;
	private JCheckBox jCheckBoxDonante = null;
	private JCheckBox jCheckBoxReoperacion = null;
	private JCheckBox jCheckBoxTratamiento = null;
	private JCheckBox jCheckBoxComplicacionesTransplante = null;
	private JCheckBox jCheckBoxComplicacionesEvolucion = null;
	private JCheckBox jCheckBoxPbrPrimerMes = null;
	private JCheckBox jCheckBoxPbrTotal = null;
	private JCheckBox jCheckBoxCmv = null;
	private JLabel jLabel = null;
	private JCheckBox jCheckBoxCmvEvolucion = null;
	private JCheckBox jCheckBoxEcgEvolucion = null;
	private JCheckBox jCheckBoxEcocardiograma = null;
	private JCheckBox jCheckBoxMarcadoresVirales = null;
	private JCheckBox jCheckBoxTxTorax = null;
	private JCheckBox jCheckBoxEcografiaInjertos = null;
	private JCheckBox jCheckBoxEcodopler = null;
	private JCheckBox jCheckBoxOtrosExamenes = null;
	private JCheckBox jCheckBoxNutricion = null;
	private JCheckBox jCheckBoxParaclinica = null;
	private JCheckBox jCheckBoxTodos = null;
	/**
	 * This is the default constructor
	 */
	public IUCrearReporteHtml() {
		super();
		initialize();
		Fachada.getInstancia().agregarObservador(this);
		this.getJButtonCreateReport().setEnabled(false);
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(956, 630);
		//this.setSize(1235, 649);
		this.setJMenuBar(getJJMenuBarAtras());
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Buscar");
	}


	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(321, 293, 120, 30));
			jLabel.setText("Evoluciones: ");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 204));
			jContentPane.add(getJDesktopPaneBuscar(), null);
			jContentPane.add(getJButtonCreateReport(), null);
			jContentPane.add(getJDesktopPanePreTrasplante(), null);
			jContentPane.add(getJCheckBoxPacienteBasico(), null);
			jContentPane.add(getJCheckBoxPerdidaDelInjerto(), null);
			jContentPane.add(getJCheckBoxMuerteDelPaciente(), null);
			jContentPane.add(getJCheckBoxPreTransplante(), null);
			jContentPane.add(getJCheckBoxTransplante(), null);
			jContentPane.add(getJCheckBoxDonante(), null);
			jContentPane.add(getJCheckBoxReoperacion(), null);
			jContentPane.add(getJCheckBoxTratamiento(), null);
			jContentPane.add(getJCheckBoxComplicacionesTransplante(), null);
			jContentPane.add(getJCheckBoxComplicacionesEvolucion(), null);
			jContentPane.add(getJCheckBoxPbrPrimerMes(), null);
			jContentPane.add(getJCheckBoxPbrTotal(), null);
			jContentPane.add(getJCheckBoxCmv(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJCheckBoxCmvEvolucion(), null);
			jContentPane.add(getJCheckBoxEcgEvolucion(), null);
			jContentPane.add(getJCheckBoxEcocardiograma(), null);
			jContentPane.add(getJCheckBoxMarcadoresVirales(), null);
			jContentPane.add(getJCheckBoxTxTorax(), null);
			jContentPane.add(getJCheckBoxEcografiaInjertos(), null);
			jContentPane.add(getJCheckBoxEcodopler(), null);
			jContentPane.add(getJCheckBoxOtrosExamenes(), null);
			jContentPane.add(getJCheckBoxNutricion(), null);
			jContentPane.add(getJCheckBoxParaclinica(), null);
			jContentPane.add(getJCheckBoxTodos(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jDesktopPaneBuscar
	 *
	 * @return javax.swing.JDesktopPane
	 */
	private JDesktopPane getJDesktopPaneBuscar() {
		if (jDesktopPaneBuscar == null) {
			jLabelBuscarPor = new JLabel();
			jLabelBuscarPor.setBounds(new Rectangle(31, 58, 197, 30));
			jLabelBuscarPor.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelBuscarPor.setText("Buscar Por");
			jLabelBuscar = new JLabel();
			jLabelBuscar.setBounds(new Rectangle(37, 11, 180, 35));
			jLabelBuscar.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelBuscar
					.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
			jLabelBuscar.setText("Buscar");
			jDesktopPaneBuscar = new JDesktopPane();
			jDesktopPaneBuscar.setBounds(new Rectangle(10, 14, 277, 476)); // 456
			jDesktopPaneBuscar.add(jLabelBuscar, null);
			jDesktopPaneBuscar.add(jLabelBuscarPor, null);
			jDesktopPaneBuscar.add(getJTextFieldBuscar(), null);
			jDesktopPaneBuscar.add(getJButtonBuscar(), null);
			jDesktopPaneBuscar.add(getJScrollPaneResultados(), null);
		}
		return jDesktopPaneBuscar;
	}

	/**
	 * This method initializes jTextFieldBuscar
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldBuscar() {
		if (jTextFieldBuscar == null) {
			jTextFieldBuscar = new JTextField();
			jTextFieldBuscar.setBounds(new Rectangle(24, 98, 215, 32));
		}
		return jTextFieldBuscar;
	}

	/**
	 * This method initializes jScrollPaneResultados
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneResultados() {
		if (jScrollPaneResultados == null) {
			jScrollPaneResultados = new JScrollPane();
			jScrollPaneResultados.setBounds(new Rectangle(17, 188, 230, 260));
			jScrollPaneResultados.setViewportView(getJListResultados());
		}
		return jScrollPaneResultados;
	}

	/**
	 * This method initializes jListResultados
	 *
	 * @return javax.swing.JList
	 */
	private JList getJListResultados() {
		if (jListResultados == null) {
			jListResultados = new JList();
			jListResultados
					.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
						public void valueChanged(
								javax.swing.event.ListSelectionEvent e) {
							mostrarPaciente();
						}
					});
		}
		return jListResultados;
	}

	/**
	 * This method initializes jButtonBuscar
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonBuscar() {
		if (jButtonBuscar == null) {
			jButtonBuscar = new JButton();
			jButtonBuscar.setBounds(new Rectangle(69, 138, 123, 27));
			jButtonBuscar.setText("Buscar");
			jButtonBuscar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							buscar();
						}
					});
		}
		return jButtonBuscar;
	}

	private void buscar() {
		if (!this.jTextFieldBuscar.getText().equalsIgnoreCase("")
				|| !this.jTextFieldBuscar.getText().equalsIgnoreCase(" ")) {
			Paciente aux = new Paciente();
			aux.setApellido(this.jTextFieldBuscar.getText());
			ArrayList<Paciente> lista = aux.obtenerTodosSoloPaciente();
			this.jListResultados.clearSelection();
			this.jListResultados.setListData(lista.toArray());
			this.jListResultados.clearSelection();
			jDesktopPaneBuscar.setBounds(new Rectangle(10, 14, 260, 456));
			//this.setSize(300, 550);
			this.jScrollPaneResultados.setVisible(true);
			this.jListResultados.setVisible(true);
		} else {

		}
		this.getJButtonCreateReport().setEnabled(false);
	}

	public void update(Observable arg0, Object arg1) {
		Observable o = arg0;
		if (o == Fachada.getInstancia()) {

		}
	}


	/**
	 * This method initializes jJMenuBarAtras
	 *
	 * @return javax.swing.JMenuBar
	 */
	private JMenuBar getJJMenuBarAtras() {
		if (jJMenuBarAtras == null) {
			jJMenuBarAtras = new JMenuBar();
			jJMenuBarAtras.setBackground(new Color(255, 255, 204));
			jJMenuBarAtras.add(getJMenuAtras());
		}
		return jJMenuBarAtras;
	}

	/**
	 * This method initializes jMenuAtras
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenuAtras() {
		if (jMenuAtras == null) {
			jMenuAtras = new JMenu();
			jMenuAtras.setBackground(new Color(255, 255, 204));
			jMenuAtras.setText("Salir");
			jMenuAtras.add(getJMenuItemSalir());
		}
		return jMenuAtras;
	}

	/**
	 * This method initializes jMenuItemSalir
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemSalir() {
		if (jMenuItemSalir == null) {
			jMenuItemSalir = new JMenuItem();
			jMenuItemSalir.setText("Salir");
			jMenuItemSalir.setBackground(new Color(255, 255, 204));
			jMenuItemSalir
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							salir();
						}
					});
		}
		return jMenuItemSalir;
	}

	private void salir() {
		Fachada.getInstancia().eliminarObservador(this);
		this.dispose();
	}


	/**
	 * This method initializes jButtonCreateReport
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCreateReport() {
		if (jButtonCreateReport == null) {
			jButtonCreateReport = new JButton();
			jButtonCreateReport.setBounds(new Rectangle(490, 489, 160, 32));
			jButtonCreateReport.setText("Crear reporte");
			jButtonCreateReport.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					createReport();
				}
			});
		}
		return jButtonCreateReport;
	}

	private void createReport(){
		CrearReporteHtmlLogic logic = new CrearReporteHtmlLogic();
		String archivo = "";
		if(!this.getJCheckBoxTodos().isSelected()){
			archivo = logic.crearReporteConParametros(this.paciente.getThe(), this.preTrasplante.getId(), this.getJCheckBoxPacienteBasico().isSelected(), this.getJCheckBoxPerdidaDelInjerto().isSelected(), this.getJCheckBoxMuerteDelPaciente().isSelected(), this.getJCheckBoxPreTransplante().isSelected(), this.getJCheckBoxTransplante().isSelected(), this.getJCheckBoxReoperacion().isSelected(), this.getJCheckBoxDonante().isSelected(), this.getJCheckBoxTratamiento().isSelected(), this.getJCheckBoxComplicacionesTransplante().isSelected(), this.getJCheckBoxComplicacionesEvolucion().isSelected(), this.getJCheckBoxPbrPrimerMes().isSelected(), this.getJCheckBoxPbrTotal().isSelected(), this.getJCheckBoxCmv().isSelected(), this.getJCheckBoxCmvEvolucion().isSelected(), this.getJCheckBoxEcgEvolucion().isSelected(), this.getJCheckBoxEcocardiograma().isSelected(), this.getJCheckBoxMarcadoresVirales().isSelected(), this.getJCheckBoxTxTorax().isSelected(), this.getJCheckBoxEcografiaInjertos().isSelected(), this.getJCheckBoxEcodopler().isSelected(), this.getJCheckBoxOtrosExamenes().isSelected(), this.getJCheckBoxNutricion().isSelected(), this.getJCheckBoxParaclinica().isSelected());
		}else{
			archivo = logic.crearReporteTotal(this.paciente.getThe(), this.preTrasplante.getId());
		}
		
		JOptionPane.showMessageDialog(this,"Se creo el reporte, este se encuentra en: " +archivo , "Reporte Creado", JOptionPane.INFORMATION_MESSAGE);
	}

	private void mostrarPaciente() {
		Paciente usado = (Paciente) this.jListResultados.getSelectedValue();
		if (usado != null) {
			if(this.paciente != null){
				if(this.paciente.equals(usado)) return;
			}
			this.paciente = usado;
			System.out.println(this.paciente.getNombre());
			this.getJButtonCreateReport().setEnabled(false);
			this.paciente.leerDatosPreTrasplante();
			this.cargarTodo();
		}

	}

	/**
	 * This method initializes jDesktopPanePreTrasplante
	 *
	 * @return javax.swing.JDesktopPane
	 */
	private JDesktopPane getJDesktopPanePreTrasplante() {
		if (jDesktopPanePreTrasplante == null) {
			jLabelPreTrasplante = new JLabel();
			jLabelPreTrasplante.setBounds(new Rectangle(15, 14, 236, 42));
			jLabelPreTrasplante.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelPreTrasplante.setText("Pre Trasplante");
			jLabelPreTrasplante.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
			jDesktopPanePreTrasplante = new JDesktopPane();
			jDesktopPanePreTrasplante.setBounds(new Rectangle(321, 21, 272, 162));
			jDesktopPanePreTrasplante.add(jLabelPreTrasplante, null);
			jDesktopPanePreTrasplante.add(getJScrollPanePreTrasplante(), null);
		}
		return jDesktopPanePreTrasplante;
	}

	/**
	 * This method initializes jScrollPanePreTrasplante
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPanePreTrasplante() {
		if (jScrollPanePreTrasplante == null) {
			jScrollPanePreTrasplante = new JScrollPane();
			jScrollPanePreTrasplante.setBounds(new Rectangle(12, 66, 238, 76));
			jScrollPanePreTrasplante.setViewportView(getJListPreTrasplante());
		}
		return jScrollPanePreTrasplante;
	}

	/**
	 * This method initializes jListPreTrasplante
	 *
	 * @return javax.swing.JList
	 */
	private JList getJListPreTrasplante() {
		if (jListPreTrasplante == null) {
			jListPreTrasplante = new JList();
			jListPreTrasplante
					.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
						public void valueChanged(javax.swing.event.ListSelectionEvent e) {
							mostrarDatos();
						}
					});
		}
		return jListPreTrasplante;
	}

	private void cargarTodo() {
		this.jListPreTrasplante.setListData(this.paciente
				.getListaPreTrasplantes().toArray());

	}

	private void mostrarDatos() {
		PacientePreTrasplante pt = (PacientePreTrasplante) this.jListPreTrasplante
				.getSelectedValue();
		if (pt != null) {
			if(this.preTrasplante != null){
				if(this.preTrasplante.equals(pt)) return;
			}
			this.preTrasplante = pt;
			System.out.println(this.preTrasplante.getId());
			this.getJButtonCreateReport().setEnabled(true);
		}
	}

	/**
	 * This method initializes jCheckBoxPacienteBasico
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxPacienteBasico() {
		if (jCheckBoxPacienteBasico == null) {
			jCheckBoxPacienteBasico = new JCheckBox();
			jCheckBoxPacienteBasico.setBounds(new Rectangle(614, 23, 141, 31));
			jCheckBoxPacienteBasico.setText("Paciente basico");
			jCheckBoxPacienteBasico.setBackground(Color.white);
		}
		return jCheckBoxPacienteBasico;
	}

	/**
	 * This method initializes jCheckBoxPerdidaDelInjerto
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxPerdidaDelInjerto() {
		if (jCheckBoxPerdidaDelInjerto == null) {
			jCheckBoxPerdidaDelInjerto = new JCheckBox();
			jCheckBoxPerdidaDelInjerto.setBounds(new Rectangle(612, 61, 163, 31));
			jCheckBoxPerdidaDelInjerto.setText("Perdida del injerto");
			jCheckBoxPerdidaDelInjerto.setBackground(Color.white);
		}
		return jCheckBoxPerdidaDelInjerto;
	}

	/**
	 * This method initializes jCheckBoxMuerteDelPaciente
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxMuerteDelPaciente() {
		if (jCheckBoxMuerteDelPaciente == null) {
			jCheckBoxMuerteDelPaciente = new JCheckBox();
			jCheckBoxMuerteDelPaciente.setBounds(new Rectangle(611, 104, 172, 31));
			jCheckBoxMuerteDelPaciente.setText("Muerte del paciente");
			jCheckBoxMuerteDelPaciente.setBackground(Color.white);
		}
		return jCheckBoxMuerteDelPaciente;
	}

	/**
	 * This method initializes jCheckBoxPreTransplante
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxPreTransplante() {
		if (jCheckBoxPreTransplante == null) {
			jCheckBoxPreTransplante = new JCheckBox();
			jCheckBoxPreTransplante.setBounds(new Rectangle(607, 148, 171, 31));
			jCheckBoxPreTransplante.setText("Pre Transplante");
			jCheckBoxPreTransplante.setBackground(Color.white);
		}
		return jCheckBoxPreTransplante;
	}

	/**
	 * This method initializes jCheckBoxTransplante
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxTransplante() {
		if (jCheckBoxTransplante == null) {
			jCheckBoxTransplante = new JCheckBox();
			jCheckBoxTransplante.setBounds(new Rectangle(790, 25, 124, 31));
			jCheckBoxTransplante.setText("Transplante");
			jCheckBoxTransplante.setBackground(Color.white);
		}
		return jCheckBoxTransplante;
	}

	/**
	 * This method initializes jCheckBoxDonante
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxDonante() {
		if (jCheckBoxDonante == null) {
			jCheckBoxDonante = new JCheckBox();
			jCheckBoxDonante.setBounds(new Rectangle(791, 62, 108, 31));
			jCheckBoxDonante.setText("Donante");
			jCheckBoxDonante.setBackground(Color.white);
		}
		return jCheckBoxDonante;
	}

	/**
	 * This method initializes jCheckBoxReoperacion
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxReoperacion() {
		if (jCheckBoxReoperacion == null) {
			jCheckBoxReoperacion = new JCheckBox();
			jCheckBoxReoperacion.setBounds(new Rectangle(322, 201, 138, 31));
			jCheckBoxReoperacion.setText("Reoperaciones");
			jCheckBoxReoperacion.setBackground(Color.white);
		}
		return jCheckBoxReoperacion;
	}

	/**
	 * This method initializes jCheckBoxTratamiento
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxTratamiento() {
		if (jCheckBoxTratamiento == null) {
			jCheckBoxTratamiento = new JCheckBox();
			jCheckBoxTratamiento.setBounds(new Rectangle(792, 104, 114, 31));
			jCheckBoxTratamiento.setText("Tratamiento");
			jCheckBoxTratamiento.setBackground(Color.white);
		}
		return jCheckBoxTratamiento;
	}

	/**
	 * This method initializes jCheckBoxComplicacionesTransplante
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxComplicacionesTransplante() {
		if (jCheckBoxComplicacionesTransplante == null) {
			jCheckBoxComplicacionesTransplante = new JCheckBox();
			jCheckBoxComplicacionesTransplante.setBounds(new Rectangle(485, 201, 227, 31));
			jCheckBoxComplicacionesTransplante.setText("Complicaciones Transplante");
			jCheckBoxComplicacionesTransplante.setBackground(Color.white);
		}
		return jCheckBoxComplicacionesTransplante;
	}

	/**
	 * This method initializes jCheckBoxComplicacionesEvolucion
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxComplicacionesEvolucion() {
		if (jCheckBoxComplicacionesEvolucion == null) {
			jCheckBoxComplicacionesEvolucion = new JCheckBox();
			jCheckBoxComplicacionesEvolucion.setBounds(new Rectangle(725, 201, 227, 31));
			jCheckBoxComplicacionesEvolucion.setText("Complicaciones Evolucion");
			jCheckBoxComplicacionesEvolucion.setBackground(Color.white);
		}
		return jCheckBoxComplicacionesEvolucion;
	}

	/**
	 * This method initializes jCheckBoxPbrPrimerMes
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxPbrPrimerMes() {
		if (jCheckBoxPbrPrimerMes == null) {
			jCheckBoxPbrPrimerMes = new JCheckBox();
			jCheckBoxPbrPrimerMes.setBounds(new Rectangle(322, 246, 138, 31));
			jCheckBoxPbrPrimerMes.setText("Pbr 1° mes");
			jCheckBoxPbrPrimerMes.setBackground(Color.white);
		}
		return jCheckBoxPbrPrimerMes;
	}

	/**
	 * This method initializes jCheckBoxPbrTotal
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxPbrTotal() {
		if (jCheckBoxPbrTotal == null) {
			jCheckBoxPbrTotal = new JCheckBox();
			jCheckBoxPbrTotal.setBounds(new Rectangle(488, 246, 138, 31));
			jCheckBoxPbrTotal.setText("Pbr Total");
			jCheckBoxPbrTotal.setBackground(Color.white);
		}
		return jCheckBoxPbrTotal;
	}

	/**
	 * This method initializes jCheckBoxCmv
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxCmv() {
		if (jCheckBoxCmv == null) {
			jCheckBoxCmv = new JCheckBox();
			jCheckBoxCmv.setBounds(new Rectangle(646, 244, 69, 32));
			jCheckBoxCmv.setText("Cmv");
			jCheckBoxCmv.setBackground(Color.white);
		}
		return jCheckBoxCmv;
	}

	/**
	 * This method initializes jCheckBoxCmvEvolucion
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxCmvEvolucion() {
		if (jCheckBoxCmvEvolucion == null) {
			jCheckBoxCmvEvolucion = new JCheckBox();
			jCheckBoxCmvEvolucion.setBounds(new Rectangle(322, 332, 69, 32));
			jCheckBoxCmvEvolucion.setText("Cmv");
			jCheckBoxCmvEvolucion.setBackground(Color.white);
		}
		return jCheckBoxCmvEvolucion;
	}

	/**
	 * This method initializes jCheckBoxEcgEvolucion
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxEcgEvolucion() {
		if (jCheckBoxEcgEvolucion == null) {
			jCheckBoxEcgEvolucion = new JCheckBox();
			jCheckBoxEcgEvolucion.setBounds(new Rectangle(420, 332, 69, 32));
			jCheckBoxEcgEvolucion.setText("Ecg");
			jCheckBoxEcgEvolucion.setBackground(Color.white);
		}
		return jCheckBoxEcgEvolucion;
	}

	/**
	 * This method initializes jCheckBoxEcocardiograma
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxEcocardiograma() {
		if (jCheckBoxEcocardiograma == null) {
			jCheckBoxEcocardiograma = new JCheckBox();
			jCheckBoxEcocardiograma.setBounds(new Rectangle(515, 332, 154, 32));
			jCheckBoxEcocardiograma.setText("Ecocardiograma");
			jCheckBoxEcocardiograma.setBackground(Color.white);
		}
		return jCheckBoxEcocardiograma;
	}

	/**
	 * This method initializes jCheckBoxMarcadoresVirales
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxMarcadoresVirales() {
		if (jCheckBoxMarcadoresVirales == null) {
			jCheckBoxMarcadoresVirales = new JCheckBox();
			jCheckBoxMarcadoresVirales.setBounds(new Rectangle(697, 332, 196, 32));
			jCheckBoxMarcadoresVirales.setText("Marcadores Virales");
			jCheckBoxMarcadoresVirales.setBackground(Color.white);
		}
		return jCheckBoxMarcadoresVirales;
	}

	/**
	 * This method initializes jCheckBoxTxTorax
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxTxTorax() {
		if (jCheckBoxTxTorax == null) {
			jCheckBoxTxTorax = new JCheckBox();
			jCheckBoxTxTorax.setBounds(new Rectangle(322, 375, 94, 32));
			jCheckBoxTxTorax.setText("Tx Torax");
			jCheckBoxTxTorax.setBackground(Color.white);
		}
		return jCheckBoxTxTorax;
	}

	/**
	 * This method initializes jCheckBoxEcografiaInjertos
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxEcografiaInjertos() {
		if (jCheckBoxEcografiaInjertos == null) {
			jCheckBoxEcografiaInjertos = new JCheckBox();
			jCheckBoxEcografiaInjertos.setBounds(new Rectangle(430, 375, 157, 32));
			jCheckBoxEcografiaInjertos.setText("Ecografia Injerto");
			jCheckBoxEcografiaInjertos.setBackground(Color.white);
		}
		return jCheckBoxEcografiaInjertos;
	}

	/**
	 * This method initializes jCheckBoxEcodopler
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxEcodopler() {
		if (jCheckBoxEcodopler == null) {
			jCheckBoxEcodopler = new JCheckBox();
			jCheckBoxEcodopler.setBounds(new Rectangle(611, 375, 97, 32));
			jCheckBoxEcodopler.setText("Ecodopler");
			jCheckBoxEcodopler.setBackground(Color.white);
		}
		return jCheckBoxEcodopler;
	}

	/**
	 * This method initializes jCheckBoxOtrosExamenes
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxOtrosExamenes() {
		if (jCheckBoxOtrosExamenes == null) {
			jCheckBoxOtrosExamenes = new JCheckBox();
			jCheckBoxOtrosExamenes.setBounds(new Rectangle(731, 376, 142, 32));
			jCheckBoxOtrosExamenes.setText("Otros examenes");
			jCheckBoxOtrosExamenes.setBackground(Color.white);
		}
		return jCheckBoxOtrosExamenes;
	}

	/**
	 * This method initializes jCheckBoxNutricion
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxNutricion() {
		if (jCheckBoxNutricion == null) {
			jCheckBoxNutricion = new JCheckBox();
			jCheckBoxNutricion.setBounds(new Rectangle(322, 424, 94, 32));
			jCheckBoxNutricion.setText("Nutricion");
			jCheckBoxNutricion.setBackground(Color.white);
		}
		return jCheckBoxNutricion;
	}

	/**
	 * This method initializes jCheckBoxParaclinica
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxParaclinica() {
		if (jCheckBoxParaclinica == null) {
			jCheckBoxParaclinica = new JCheckBox();
			jCheckBoxParaclinica.setBounds(new Rectangle(434, 426, 127, 29));
			jCheckBoxParaclinica.setText("Para clinica");
			jCheckBoxParaclinica.setBackground(Color.white);
		}
		return jCheckBoxParaclinica;
	}

	/**
	 * This method initializes jCheckBoxTodos
	 *
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxTodos() {
		if (jCheckBoxTodos == null) {
			jCheckBoxTodos = new JCheckBox();
			jCheckBoxTodos.setBounds(new Rectangle(709, 488, 144, 33));
			jCheckBoxTodos.setText("Elegir todos.");
			jCheckBoxTodos.setBackground(Color.white);
		}
		return jCheckBoxTodos;
	}
} // @jve:decl-index=0:visual-constraint="10,10"
