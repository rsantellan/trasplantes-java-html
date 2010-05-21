package iu;

/*import iu.complicacion.IUComplicacionesInfSeleccionar;
import iu.complicacion.IUComplicacionesNoInfSeleccionar;
import iu.evolucion.IUEvolucionTrasplanteSeleccionar;
import iu.paciente.IUPacienteModificar;
import iu.paciente.IUPacientePreTrasplante;
import iu.trasplante.IUTrasplanteFechaAlta;
import iu.trasplante.IUTrasplanteManejar;
import iu.trasplante.IUTrasplanteReoperacion;*/
import iu.windows.logic.IUCMVLogic;
import iu.windows.logic.IUEvolucionesLogic;
import iu.windows.logic.IUPacienteLogic;
import iu.windows.logic.IUPacientePreTrasplanteLogic;
import iu.windows.logic.IUReoperacionLogic;
import iu.windows.logic.IUTrasplanteLogic;
import iu.windows.logic.IUTratamientosLogic;

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
import dominio.Paciente;
import dominio.PacientePreTrasplante;
//import dominio.Trasplante;

public class IUBuscarPersonaTrasplante extends JFrame implements
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
	private PacientePreTrasplante preTrasplante = null;  //  @jve:decl-index=0:
	private JDesktopPane jDesktopPaneTrasplante = null;
	private JLabel jLabelTrasplante = null;
	private JLabel jLabelInfoTrasplante = null;
	private JButton jButtonModificarTrasplante = null;
	private JButton jButtonMasInfoTrasplante = null;
	private JLabel jLabelComplicaciones = null;
	private JButton jButtonComplicacionesInfTrasplante = null;
	private JDesktopPane jDesktopPanePaciente = null;
	private JLabel jLabelPaciente = null;
	private JLabel jLabelInfoPaciente = null;
	private JButton jButtonVerPaciente = null;
	private JLabel jLabelComplicacionesInf = null;
	private JLabel jLabelComplicacionesNoInf = null;
	private JButton jButtonComplicacionesNoInfTrasplante = null;
	private JMenuBar jJMenuBarAtras = null;
	private JMenu jMenuAtras = null;
	private JMenuItem jMenuItemSalir = null;
	private JDesktopPane jDesktopPanePreTrasplante = null;
	private JLabel jLabelPreTrasplante = null;
	private JScrollPane jScrollPanePreTrasplante = null;
	private JButton jButtonVerPreTrasplante = null;
	private JList jListPreTrasplante = null;
	private JDesktopPane jDesktopPaneEvolucionTrasplante = null;
	private JLabel jLabelEvolucion = null;
	private JButton jButtonManejarEvolucion = null;
	private JLabel jLabelDescTrasplante = null;
	private JLabel jLabelDescEvolucion = null;
	private JDesktopPane jDesktopPaneEvolucionInjerto = null;
	private JLabel jLabelEvolucionInjerto = null;
	private JButton jButtonManejarEvolucionInjerto = null;
	private JLabel jLabelDescEvolucionInjerto = null;
	private JDesktopPane jDesktopPaneCMV = null;
	private JLabel jLabelCMV = null;
	private JButton jButtonManejarCMV = null;
	private JLabel jLabelPrimeraEvolucion = null;
	private JButton jButtonManejarEvolucionTrasplante = null;
	private JButton jButtonTratamiento = null;
	private JButton jButtonReoperacion = null;
	private JButton jButtonAlta = null;
	/**
	 * This is the default constructor
	 */
	public IUBuscarPersonaTrasplante() {
		super();
		initialize();
		Fachada.getInstancia().agregarObservador(this);
		cargarDatos();
	}

	public IUBuscarPersonaTrasplante(Paciente p) {
		super();
		initialize();
		paciente = p;
		Fachada.getInstancia().agregarObservador(this);
		cargarDatos();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		//this.setSize(312, 568);
		this.setSize(1235, 649);
		this.setJMenuBar(getJJMenuBarAtras());
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Buscar");
	}

	private void cargarDatos() {
		this.jLabelBuscarPor.setText("Buscar por apellido del Paciente");
		this.jScrollPaneResultados.setVisible(false);
		this.jListResultados.setVisible(false);

		if (this.paciente != null) {
			this.cargarTodo();
		} else {
			this.jDesktopPanePaciente.setVisible(false);
			this.jDesktopPaneTrasplante.setVisible(false);
			this.jDesktopPanePreTrasplante.setVisible(false);
		}
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
			jContentPane.setBackground(new Color(255, 255, 204));
			jContentPane.add(getJDesktopPaneBuscar(), null);
			jContentPane.add(getJDesktopPaneTrasplante(), null);
			jContentPane.add(getJDesktopPanePaciente(), null);
			jContentPane.add(getJDesktopPanePreTrasplante(), null);
			jContentPane.add(getJDesktopPaneEvolucionTrasplante(), null);
			jContentPane.add(getJDesktopPaneEvolucionInjerto(), null);
			jContentPane.add(getJDesktopPaneCMV(), null);
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
			this.setSize(300, 550);
			this.jScrollPaneResultados.setVisible(true);
			this.jListResultados.setVisible(true);
			this.preTrasplante = null;
		} else {

		}

	}

	private void cargarTodo() {
		//this.setSize(1072, 568);
		this.jDesktopPanePaciente.setVisible(true);
		this.jDesktopPaneTrasplante.setVisible(true);
		this.jLabelInfoPaciente.setText(this.paciente.toString());
		this.jListPreTrasplante.setListData(this.paciente
				.getListaPreTrasplantes().toArray());

	}

	/**
	 * This method initializes jDesktopPaneTrasplante
	 *
	 * @return javax.swing.JDesktopPane
	 */
	private JDesktopPane getJDesktopPaneTrasplante() {
		if (jDesktopPaneTrasplante == null) {
			jLabelPrimeraEvolucion = new JLabel();
			jLabelPrimeraEvolucion.setBounds(new Rectangle(25, 459, 218, 43));
			jLabelPrimeraEvolucion.setText("PBR del 1° mes.");
			jLabelPrimeraEvolucion.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelDescTrasplante = new JLabel();
			jLabelDescTrasplante.setBounds(new Rectangle(10, 5, 401, 38));
			jLabelDescTrasplante.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelDescTrasplante.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelDescTrasplante.setBackground(new Color(255, 51, 51));
			jLabelDescTrasplante.setForeground(Color.red);
			jLabelDescTrasplante.setText("Es la primera internación para la realización del trasplante");
			jLabelComplicacionesNoInf = new JLabel();
			jLabelComplicacionesNoInf
					.setBounds(new Rectangle(23, 385, 219, 40));
			jLabelComplicacionesNoInf.setText("");
			jLabelComplicacionesNoInf
					.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelComplicacionesInf = new JLabel();
			jLabelComplicacionesInf.setBounds(new Rectangle(21, 323, 218, 40));
			jLabelComplicacionesInf.setText("N° Complicaciones Infecciosas:");
			jLabelComplicacionesInf
					.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelComplicaciones = new JLabel();
			jLabelComplicaciones.setBounds(new Rectangle(24, 264, 160, 36));
			jLabelComplicaciones.setText("");
			jLabelComplicaciones.setFont(new Font("Dialog", Font.BOLD
					| Font.ITALIC, 12));
			jLabelComplicaciones.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelInfoTrasplante = new JLabel();
			jLabelInfoTrasplante.setBounds(new Rectangle(7, 103, 401, 41));
			jLabelInfoTrasplante.setText("Info Trasplante");
			jLabelInfoTrasplante.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelTrasplante = new JLabel();
			jLabelTrasplante.setBounds(new Rectangle(105, 49, 170, 45));
			jLabelTrasplante.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelTrasplante.setText("Trasplante");
			jLabelTrasplante.setFont(new Font("Dialog",
					Font.BOLD | Font.ITALIC, 18));
			jDesktopPaneTrasplante = new JDesktopPane();
			jDesktopPaneTrasplante.setBounds(new Rectangle(594, 17, 418, 530));
			jDesktopPaneTrasplante.add(jLabelTrasplante, null);
			jDesktopPaneTrasplante.add(jLabelInfoTrasplante, null);
			jDesktopPaneTrasplante.add(getJButtonModificarTrasplante(), null);
			jDesktopPaneTrasplante.add(getJButtonMasInfoTrasplante(), null);
			jDesktopPaneTrasplante.add(jLabelComplicaciones, null);
			jDesktopPaneTrasplante.add(getJButtonComplicacionesInfTrasplante(),
					null);
			jDesktopPaneTrasplante.add(jLabelComplicacionesInf, null);
			jDesktopPaneTrasplante.add(jLabelComplicacionesNoInf, null);
			jDesktopPaneTrasplante.add(
					getJButtonComplicacionesNoInfTrasplante(), null);
			jDesktopPaneTrasplante.add(jLabelDescTrasplante, null);
			jDesktopPaneTrasplante.add(jLabelPrimeraEvolucion, null);
			jDesktopPaneTrasplante.add(getJButtonManejarEvolucionTrasplante(), null);
			jDesktopPaneTrasplante.add(getJButtonReoperacion(), null);
			jDesktopPaneTrasplante.add(getJButtonAlta(), null);
		}
		return jDesktopPaneTrasplante;
	}

	/**
	 * This method initializes jButtonModificarTrasplante
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonModificarTrasplante() {
		if (jButtonModificarTrasplante == null) {
			jButtonModificarTrasplante = new JButton();
			jButtonModificarTrasplante.setBounds(new Rectangle(236, 151, 133, 39));
			jButtonModificarTrasplante.setText("Modificar");
			jButtonModificarTrasplante
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							modificarTrasplante();
						}
					});
		}
		return jButtonModificarTrasplante;
	}

	/**
	 * This method initializes jButtonMasInfoTrasplante
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonMasInfoTrasplante() {
		if (jButtonMasInfoTrasplante == null) {
			jButtonMasInfoTrasplante = new JButton();
			jButtonMasInfoTrasplante.setBounds(new Rectangle(21, 151, 133, 39));
			jButtonMasInfoTrasplante.setText("Ver");
			jButtonMasInfoTrasplante
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							verTrasplante();
						}
					});
		}
		return jButtonMasInfoTrasplante;
	}

	/**
	 * This method initializes jButtonComplicacionesInfTrasplante
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonComplicacionesInfTrasplante() {
		if (jButtonComplicacionesInfTrasplante == null) {
			jButtonComplicacionesInfTrasplante = new JButton();
			jButtonComplicacionesInfTrasplante.setBounds(new Rectangle(258, 324, 133, 39));
			jButtonComplicacionesInfTrasplante.setText("Ver");
			jButtonComplicacionesInfTrasplante
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							verTrasplanteComplicacionesInf();
						}
					});
		}
		return jButtonComplicacionesInfTrasplante;
	}

	/**
	 * This method initializes jDesktopPanePaciente
	 *
	 * @return javax.swing.JDesktopPane
	 */
	private JDesktopPane getJDesktopPanePaciente() {
		if (jDesktopPanePaciente == null) {
			jLabelInfoPaciente = new JLabel();
			jLabelInfoPaciente.setBounds(new Rectangle(4, 63, 264, 37));
			jLabelInfoPaciente.setText("Info Trasplante");
			jLabelInfoPaciente.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelPaciente = new JLabel();
			jLabelPaciente.setBounds(new Rectangle(46, 13, 178, 37));
			jLabelPaciente.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelPaciente.setText("Paciente");
			jLabelPaciente.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC,
					18));
			jDesktopPanePaciente = new JDesktopPane();
			jDesktopPanePaciente.setBounds(new Rectangle(296, 15, 276, 196));
			jDesktopPanePaciente.add(jLabelPaciente, null);
			jDesktopPanePaciente.add(jLabelInfoPaciente, null);
			jDesktopPanePaciente.add(getJButtonVerPaciente(), null);
		}
		return jDesktopPanePaciente;
	}

	/**
	 * This method initializes jButtonVerPaciente
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonVerPaciente() {
		if (jButtonVerPaciente == null) {
			jButtonVerPaciente = new JButton();
			jButtonVerPaciente.setBounds(new Rectangle(84, 134, 121, 34));
			jButtonVerPaciente.setText("Ver");
			jButtonVerPaciente
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							verPaciente();
						}
					});
		}
		return jButtonVerPaciente;
	}

	private void verPaciente() {
		IUPacienteLogic p = new IUPacienteLogic();
		p.iuPacienteVerVisible(this.paciente);
/*		IUPacienteModificar iu = new IUPacienteModificar(this.paciente, true);
		iu.setVisible(true);*/
	}


	public void update(Observable arg0, Object arg1) {
		Observable o = arg0;
		if (o == Fachada.getInstancia()) {
			if (this.paciente != null) {
				if(Fachada.getInstancia().getLugar() == Fachada.PACIENTE){
					this.paciente.leerDatos();
					this.cargarTodo();
				}
				if (this.preTrasplante != null) {
					if(Fachada.getInstancia().getLugar() == Fachada.PRETRASPLANTE){
						this.preTrasplante.leerTrasplante();
						this.mostrarTrasplante();
					}
					if(Fachada.getInstancia().getLugar() == Fachada.COMPLICACIONES_NO_INFECCIOSAS || Fachada.getInstancia().getLugar() == Fachada.COMPLICACIONES_INFECCIOSAS){
						this.preTrasplante.leerTrasplante();
						this.mostrarComplicaciones();
					}
				}
			}
		}
	}

	private void verTrasplante() {
		IUTrasplanteLogic logic = new IUTrasplanteLogic();
		logic.iuVerTransplante(this.paciente, this.preTrasplante);
		/*PacientePreTrasplante modificar = new PacientePreTrasplante(
				this.preTrasplante);
		modificar.leerTodoTrasplante();
		IUTrasplanteManejar iuModificar = new IUTrasplanteManejar(
				this.paciente, modificar, true);
		iuModificar.setVisible(true);*/
	}

	private void modificarTrasplante() {
		IUTrasplanteLogic logic = new IUTrasplanteLogic();
		logic.iuModificarTransplante(this.paciente, this.preTrasplante);
		/*PacientePreTrasplante modificar = new PacientePreTrasplante(this.preTrasplante);
		modificar.leerTodoTrasplante();
		IUTrasplanteManejar iuModificar = new IUTrasplanteManejar(this.paciente, modificar, false);
		iuModificar.setVisible(true);*/

	}

	/**
	 * This method initializes jButtonComplicacionesNoInfTrasplante
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonComplicacionesNoInfTrasplante() {
		if (jButtonComplicacionesNoInfTrasplante == null) {
			jButtonComplicacionesNoInfTrasplante = new JButton();
			jButtonComplicacionesNoInfTrasplante.setBounds(new Rectangle(258, 384, 133, 39));
			jButtonComplicacionesNoInfTrasplante.setText("Ver");
			jButtonComplicacionesNoInfTrasplante
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							verTrasplanteComplicacionesNoInf();
						}
					});
		}
		return jButtonComplicacionesNoInfTrasplante;
	}

	private void verTrasplanteComplicacionesNoInf() {
		IUTrasplanteLogic logic = new IUTrasplanteLogic();
		logic.iuVerTransplanteComplicacionNoInfecciosa(this.preTrasplante.getTrasplante());
		/*Trasplante modificar = new Trasplante(this.preTrasplante
				.getTrasplante());
		modificar.leerComplicaciones();
		IUComplicacionesNoInfSeleccionar iuNoInf = new IUComplicacionesNoInfSeleccionar(
				modificar, true);
		iuNoInf.setVisible(true);*/
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

	private void verTrasplanteComplicacionesInf() {
		IUTrasplanteLogic logic = new IUTrasplanteLogic();
		logic.iuVerTransplanteComplicacionInfecciosa(this.preTrasplante.getTrasplante());
		/*Trasplante modificar = new Trasplante(this.preTrasplante
				.getTrasplante());
		modificar.leerComplicaciones();
		IUComplicacionesInfSeleccionar iuInfSeleccionar = new IUComplicacionesInfSeleccionar(
				modificar, true);
		iuInfSeleccionar.setVisible(true);*/
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
			jLabelPreTrasplante.setFont(new Font("Dialog", Font.BOLD
					| Font.ITALIC, 18));
			jDesktopPanePreTrasplante = new JDesktopPane();
			jDesktopPanePreTrasplante.setBounds(new Rectangle(300, 240, 272, 250));
			jDesktopPanePreTrasplante.add(jLabelPreTrasplante, null);
			jDesktopPanePreTrasplante.add(getJScrollPanePreTrasplante(), null);
			jDesktopPanePreTrasplante.add(getJButtonVerPreTrasplante(), null);
			jDesktopPanePreTrasplante.add(getJButtonTratamiento(), null);
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
	 * This method initializes jButtonVerPreTrasplante
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonVerPreTrasplante() {
		if (jButtonVerPreTrasplante == null) {
			jButtonVerPreTrasplante = new JButton();
			jButtonVerPreTrasplante.setBounds(new Rectangle(59, 158, 152, 30));
			jButtonVerPreTrasplante.setText("Ver");
			jButtonVerPreTrasplante
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							verPretrasplante();
						}
					});
		}
		return jButtonVerPreTrasplante;
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
						public void valueChanged(
								javax.swing.event.ListSelectionEvent e) {
							cargarTrasplante();
						}
					});
		}
		return jListPreTrasplante;
	}

	private void mostrarPaciente() {
		this.setSize(600, 568);
		this.jDesktopPanePaciente.setVisible(true);
		this.jDesktopPanePreTrasplante.setVisible(true);
		this.jDesktopPaneTrasplante.setVisible(true);
		Paciente usado = (Paciente) this.jListResultados.getSelectedValue();
		if (usado != null) {
			if(this.paciente != null){
				if(this.paciente.equals(usado)) return;
			}
			this.paciente = usado;
			this.paciente.leerDatosPreTrasplante();
			this.cargarTodo();
		}

	}

	private void cargarTrasplante() {
		PacientePreTrasplante pt = (PacientePreTrasplante) this.jListPreTrasplante
				.getSelectedValue();
		if (pt != null) {
			if(this.preTrasplante != null){
				if(this.preTrasplante.equals(pt)) return;
			}
			pt.leerTrasplante();
			if(pt.getTrasplante().getId() == 0){
				JOptionPane.showMessageDialog(this,"El trasplante asociado a este pre trasplante no tiene\nninguna informacion, por favor llenar los datos " , "Error", 2);
				IUTrasplanteLogic logic = new IUTrasplanteLogic();
				logic.iuIngresarTrasplante(this.paciente, pt);
				/*Trasplante unTr = new Trasplante();
				pt.setTrasplante(unTr);
				IUTrasplanteManejar iuTr = new IUTrasplanteManejar(this.paciente,pt,false);
				iuTr.setVisible(true);*/
			}else{
				this.preTrasplante = pt;
				this.mostrarTrasplante();
			}
		}

	}

	private void mostrarTrasplante() {
		this.setSize(1235, 649);
		this.jLabelInfoTrasplante.setText(this.preTrasplante.getTrasplante()
				.toString());
		if(this.preTrasplante.getTrasplante().getFechaAlta() == null){
			this.getJButtonAlta().setText("Dar de alta");
		}else{
			long diasL = this.preTrasplante.getTrasplante().getFechaAlta().getTimeInMillis() - this.preTrasplante.getTrasplante().getFecha().getTimeInMillis();

			//int dias = this.preTrasplante.getTrasplante().getFechaAlta().compareTo(this.preTrasplante.getTrasplante().getFecha());
			this.getJButtonAlta().setText("Dias internado: " + diasL / (1000 * 60 * 60 * 24));
		}
		this.mostrarComplicaciones();
	}

	private void mostrarComplicaciones(){
		int compl = this.preTrasplante.getTrasplante().getListaComplicacionesInf().size() + this.preTrasplante.getTrasplante().getListaComplicacionesNoInf().size();
		this.jLabelComplicaciones.setText("N° Complicaciones: " + String.valueOf(compl));
		this.jLabelComplicacionesInf.setText("N° Complicaciones Infecciosas: " + String.valueOf(this.preTrasplante.getTrasplante().getListaComplicacionesInf().size()));
		this.jLabelComplicacionesNoInf.setText("N° Complicaciones No Infecciosas: " + String.valueOf(this.preTrasplante.getTrasplante().getListaComplicacionesNoInf().size()));

	}

	private void verPretrasplante() {
		if(this.preTrasplante != null){
			IUPacientePreTrasplanteLogic logic = new IUPacientePreTrasplanteLogic();
			logic.iuVerPreTrasplante(this.paciente, this.preTrasplante);
			/*IUPacientePreTrasplante iuMod = new IUPacientePreTrasplante(
					this.paciente, this.preTrasplante, true);
			iuMod.setVisible(true);*/
		}
	}

	/**
	 * This method initializes jDesktopPaneEvolucionTrasplante
	 *
	 * @return javax.swing.JDesktopPane
	 */
	private JDesktopPane getJDesktopPaneEvolucionTrasplante() {
		if (jDesktopPaneEvolucionTrasplante == null) {
			jLabelDescEvolucion = new JLabel();
			jLabelDescEvolucion.setBounds(new Rectangle(8, 7, 176, 49));
			jLabelDescEvolucion.setText("<HTML>Todo lo que sucede <BR>luego del alta del<br> trasplante</HTML>");
			jLabelEvolucion = new JLabel();
			jLabelEvolucion.setBounds(new Rectangle(7, 64, 175, 40));
			jLabelEvolucion.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelEvolucion.setText("Evolucion");
			jLabelEvolucion.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
			jDesktopPaneEvolucionTrasplante = new JDesktopPane();
			jDesktopPaneEvolucionTrasplante.setBounds(new Rectangle(1022, 15, 189, 203));
			jDesktopPaneEvolucionTrasplante.add(jLabelEvolucion, null);
			jDesktopPaneEvolucionTrasplante.add(getJButtonManejarEvolucion(), null);
			jDesktopPaneEvolucionTrasplante.add(jLabelDescEvolucion, null);
		}
		return jDesktopPaneEvolucionTrasplante;
	}

	/**
	 * This method initializes jButtonManejarEvolucion
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonManejarEvolucion() {
		if (jButtonManejarEvolucion == null) {
			jButtonManejarEvolucion = new JButton();
			jButtonManejarEvolucion.setBounds(new Rectangle(37, 117, 128, 46));
			jButtonManejarEvolucion.setText("Manejar");
			jButtonManejarEvolucion.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					manejarEvolucion();
				}
			});
		}
		return jButtonManejarEvolucion;
	}

	private void manejarEvolucion(){
		IUEvolucionesLogic logic = new IUEvolucionesLogic();
		logic.iuManejarEvolucion(this.preTrasplante.getTrasplante(), this.paciente.getThe());
		/*IUEvolucionTrasplanteSeleccionar iuEvolucion = new IUEvolucionTrasplanteSeleccionar(this.preTrasplante.getTrasplante(),this.paciente.getThe());
		iuEvolucion.setVisible(true);*/
	}

	/**
	 * This method initializes jDesktopPaneEvolucionInjerto
	 *
	 * @return javax.swing.JDesktopPane
	 */
	private JDesktopPane getJDesktopPaneEvolucionInjerto() {
		if (jDesktopPaneEvolucionInjerto == null) {
			jLabelDescEvolucionInjerto = new JLabel();
			jLabelDescEvolucionInjerto.setBounds(new Rectangle(8, 7, 176, 49));
			jLabelDescEvolucionInjerto.setText("<HTML>Todo lo que sucede <BR>luego del alta del<br> trasplante al injerto</HTML>");
			jLabelEvolucionInjerto = new JLabel();
			jLabelEvolucionInjerto.setBounds(new Rectangle(7, 64, 175, 48));
			jLabelEvolucionInjerto.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelEvolucionInjerto.setText("<HTML>Evolucion<BR>Injerto</HTML>");
			jLabelEvolucionInjerto.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
			jDesktopPaneEvolucionInjerto = new JDesktopPane();
			jDesktopPaneEvolucionInjerto.setBounds(new Rectangle(1022, 222, 189, 203));
			jDesktopPaneEvolucionInjerto.add(jLabelEvolucionInjerto, null);
			jDesktopPaneEvolucionInjerto.add(getJButtonManejarEvolucionInjerto(), null);
			jDesktopPaneEvolucionInjerto.add(jLabelDescEvolucionInjerto, null);
		}
		return jDesktopPaneEvolucionInjerto;
	}

	/**
	 * This method initializes jButtonManejarEvolucionInjerto
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonManejarEvolucionInjerto() {
		if (jButtonManejarEvolucionInjerto == null) {
			jButtonManejarEvolucionInjerto = new JButton();
			jButtonManejarEvolucionInjerto.setBounds(new Rectangle(27, 134, 128, 46));
			jButtonManejarEvolucionInjerto.setText("Manejar");
			jButtonManejarEvolucionInjerto
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							evolucionInjerto();
						}
					});
		}
		return jButtonManejarEvolucionInjerto;
	}

	private void evolucionInjerto(){
		IUEvolucionesLogic logic = new IUEvolucionesLogic();
		logic.iuManejarPrimeraEvolucionInjerto(this.preTrasplante);
		/*IUInjertoEvolucionSeleccionar injertoSeleccionar = new IUInjertoEvolucionSeleccionar(this.preTrasplante);
		injertoSeleccionar.setVisible(true);*/
	}

	/**
	 * This method initializes jDesktopPaneCMV
	 *
	 * @return javax.swing.JDesktopPane
	 */
	private JDesktopPane getJDesktopPaneCMV() {
		if (jDesktopPaneCMV == null) {
			jLabelCMV = new JLabel();
			jLabelCMV.setBounds(new Rectangle(2, 9, 175, 48));
			jLabelCMV.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelCMV.setText("CMV");
			jLabelCMV.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
			jDesktopPaneCMV = new JDesktopPane();
			jDesktopPaneCMV.setBounds(new Rectangle(1023, 432, 188, 139));
			jDesktopPaneCMV.add(jLabelCMV, null);
			jDesktopPaneCMV.add(getJButtonManejarCMV(), null);
		}
		return jDesktopPaneCMV;
	}

	/**
	 * This method initializes jButtonManejarCMV
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonManejarCMV() {
		if (jButtonManejarCMV == null) {
			jButtonManejarCMV = new JButton();
			jButtonManejarCMV.setBounds(new Rectangle(25, 66, 128, 46));
			jButtonManejarCMV.setText("Manejar");
			jButtonManejarCMV.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					manejarCMV();
				}
			});
		}
		return jButtonManejarCMV;
	}

	private void manejarCMV(){
		IUCMVLogic logic = new IUCMVLogic();
		logic.iuManejarCMV(this.preTrasplante.getTrasplante().getId());
		/*IUCMVSeleccionar cmvSelect = new IUCMVSeleccionar(this.preTrasplante.getTrasplante().getId());
		cmvSelect.setVisible(true);*/
	}

	/**
	 * This method initializes jButtonManejarEvolucionTrasplante
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonManejarEvolucionTrasplante() {
		if (jButtonManejarEvolucionTrasplante == null) {
			jButtonManejarEvolucionTrasplante = new JButton();
			jButtonManejarEvolucionTrasplante.setBounds(new Rectangle(261, 460, 131, 39));
			jButtonManejarEvolucionTrasplante.setText("Manejar");
			jButtonManejarEvolucionTrasplante
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							manejarEvolucionInjertoTrasplante();
						}
					});
		}
		return jButtonManejarEvolucionTrasplante;
	}

	private void manejarEvolucionInjertoTrasplante(){
		IUEvolucionesLogic logic = new IUEvolucionesLogic();
		logic.iuManejarEvolucionInjerto(this.preTrasplante);
	}

	/**
	 * This method initializes jButtonTratamiento
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonTratamiento() {
		if (jButtonTratamiento == null) {
			jButtonTratamiento = new JButton();
			jButtonTratamiento.setBounds(new Rectangle(42, 201, 192, 40));
			jButtonTratamiento.setText("TRATAMIENTOS");
			jButtonTratamiento.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					tratamientos();
				}
			});
		}
		return jButtonTratamiento;
	}

	private void tratamientos(){
		IUTratamientosLogic logic = new IUTratamientosLogic();
		logic.iuSeleccionarTratamientos(this.paciente.getThe());
		/*IUTratamientoSeleccionar tratSel = new IUTratamientoSeleccionar(this.paciente.getThe());
		tratSel.setVisible(true);*/
	}

	/**
	 * This method initializes jButtonReoperacion
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonReoperacion() {
		if (jButtonReoperacion == null) {
			jButtonReoperacion = new JButton();
			jButtonReoperacion.setBounds(new Rectangle(20, 209, 151, 35));
			jButtonReoperacion.setText("Reoperacion");
			jButtonReoperacion.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					reoperaciones();
				}
			});
		}
		return jButtonReoperacion;
	}

	private void reoperaciones(){
		IUReoperacionLogic logic = new IUReoperacionLogic();
		logic.iuReoperaciones(this.preTrasplante.getTrasplante());
		/*IUTrasplanteReoperacion reTrasplante = new IUTrasplanteReoperacion(this.preTrasplante.getTrasplante());
		reTrasplante.setVisible(true);*/
	}

	/**
	 * This method initializes jButtonAlta
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAlta() {
		if (jButtonAlta == null) {
			jButtonAlta = new JButton();
			jButtonAlta.setBounds(new Rectangle(220, 209, 151, 35));
			jButtonAlta.setText("Alta");
			jButtonAlta.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					altaTrasplante();
				}
			});
		}
		return jButtonAlta;
	}

	private void altaTrasplante(){
		IUTrasplanteLogic logic = new IUTrasplanteLogic();
		logic.iuAltaTrasplante(this.preTrasplante.getTrasplante());
		/*IUTrasplanteFechaAlta alta = new IUTrasplanteFechaAlta(this.preTrasplante.getTrasplante());
		alta.setVisible(true);*/
	}
} // @jve:decl-index=0:visual-constraint="10,10"
