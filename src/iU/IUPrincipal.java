package iU;

import java.awt.Cursor;
import java.awt.Rectangle;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Observable;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;

import logica.Fachada;
import auxiliares.ManejoFechas;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.WindowConstants;

public class IUPrincipal extends JFrame implements java.util.Observer {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenuPersonas = null;
	private JMenu jMenuDonante = null;
	private JMenuItem jMenuItemIngresarD = null;
	private JMenu jMenuReceptor = null;
	private JMenuItem jMenuItemIngresarR = null;
	private JMenuItem jMenuItemModificarR = null;
	private JMenuItem jMenuItemModificarD = null;
	private JLabel jLabelPacientes = null;
	private JLabel jLabelFecha = null;
	private Fachada instancia = Fachada.getInstancia();
	private JMenu jMenuDatosFijos = null;
	private JMenuItem jMenuItemNefropatias = null;
	private JMenuItem jMenuItemCausaMuertePaciente = null;
	private JMenuItem jMenuItemCausasPerdidaInjerto = null;
	private JMenuItem jMenuItemAntecedentesDonante = null;
	private JMenuItem jMenuItemCausaMuerteDonante = null;
	private JMenuItem jMenuItemResultadoPBR = null;
	private JMenuItem jMenuItemManejarSerol = null;
	private JMenuItem jMenuItemManejarInduccion = null;
	private JMenuItem jMenuItemManejarInmunosupresores = null;
	private JMenuItem jMenuItemMedicacion = null;
	private JMenuItem jMenuItemTiposComplicaciones = null;
	private JMenu jMenuBuscar = null;
	private JMenuItem jMenuItemBuscar = null;
	private JMenuItem jMenuItemManejarInfeccion = null;
	private JMenuItem jMenuItemManejarGermenes = null;
	private JMenuItem jMenuItemManejarFechaControl = null;
	private JMenu jMenuConsultas = null;
	private JMenuItem jMenuItemConsultaMuerteDonante = null;
	private JMenu jMenuConsultasNumeros = null;
	private JMenu jMenuConsultasB = null;
	private JMenu jMenuConsultasC = null;
	private JMenuItem jMenuItemCMVDrogas = null;
	private JMenuItem jMenuItemCMVDiagnostico = null;
	private JMenuItem jMenuItemEnfermedades = null;
	private JMenuItem jMenuItemTratamientoRA = null;
	private JMenuItem jMenuItemConsultaTabaquismo = null;
	private JMenuItem jMenuItemConsultaDislipemia = null;
	private JMenuItem jMenuItemConsultaImcPacientesObesos = null;
	private JMenuItem jMenuItemConsultaImcPacientesNoObesos = null;
	private JMenuItem jMenuItemConsultaPacientesConHTA = null;
	private JMenuItem jMenuItemConsultaPacientesConDiabetes = null;
	private JMenuItem jMenuItemConsultaPacientesPorSexo = null;
	private JMenuItem jMenuItemConsultaPacientesPorOrigen = null;
	private JMenuItem jMenuItemConsultaPacientesPorEdad = null;
	private JMenuItem jMenuItemConsultaPacientesTiempoEnLista = null;
	private JMenuItem jMenuItemConsultaPacientesFallecimiento = null;
	private JMenuItem jMenuItemConsultaPacientesNefropatiasPBR = null;
	private JMenuItem jMenuItemConsultaTranfusionesEmbarazos = null;
	private JMenuItem jMenuItemConsultaSangreDonantePaciente = null;
	private JMenuItem jMenuItemConsultaNumArteriasNumVenasYUreter = null;
	private JMenuItem jMenuItemConsultaLadoImplanteYAnomalia = null;
	private JMenuItem jMenuItemConsultaInestabilidadHemodinamica = null;
	private JMenuItem jMenuItemConsultaEdadPacienteDonanteTrasplante = null;
	private JMenuItem jMenuItemConsultaSexoPacienteDonanteTrasplante = null;
	private JMenuItem jMenuItemConsultaTipoDonantePaciente = null;
	private JMenuItem jMenuItemConsultaPacienteVariosTrasplantes = null;
	private JMenuItem jMenuItemConsultaPacienteFechaTrasplantes = null;
	private JMenuItem jMenuItemConsultaTrasplantesCompatibilidadIncompatibilidadPRA = null;
	private JMenuItem jMenuItemConsultaTrasplantesPorCirugia = null;
	private JMenuItem jMenuItemConsultaTrasplantesIsquemiaDiuresis = null;
	private JMenuItem jMenuItemConsultaTrasplantesIsquemiaSinDiuresis = null;
	private JMenuItem jMenuItemConsultaTrasplantesInduccionesINM = null;
	private JMenuItem jMenuItemConsultaTrasplantesInmunosupresores = null;
	private JMenuItem jMenuItemConsultaTrasplantesDiuresisEnBq = null;
	private JMenuItem jMenuItemTrasplantesGermenesInfecciones = null;
	private JMenuItem jMenuItemConsultaReOperaciones = null;
	private JMenu jMenuDatosManagement = null;
	private JMenuItem jMenuItemCambiarPassword = null;
	private JMenuItem jMenuItemBackUp = null;
	private JMenuItem jMenuItemBackUpRestore = null;
	private JMenuItem jMenuItemConsultaComplicacionLineal = null;
	private boolean inicio = false;
	private JButton jButtonSalir = null;
	private JMenu jMenuReportes = null;
	private JMenuItem jMenuItemRegistroUruguayoTrasplante = null;
	private JMenuItem jMenuItemRegistroUruguayoTotal = null;
	//private JMenuItem jMenuItemRegistroUruguayoTotalPreTrasplante = null;
	private JMenuItem jMenuItemRegistroUruguayoTotalPreTrasplante = null;
	
	/**
	 * This is the default constructor
	 */
	public IUPrincipal() {
		super();
		/*
		 * try { UIManager.setLookAndFeel(new Office2003LookAndFeel()); } catch
		 * (Exception e) { }
		 */
		UIManager.put("MenuItem.selectionBackground", Color.WHITE);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(605, 200);
		this.setForeground(new Color(255, 255, 51));
		this.setBackground(Color.red);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("Principal");
		this.setLocationByPlatform(true);
		this.instancia.agregarObservador(this);
		Date hoy = new Date();
		Calendar cHoy = new GregorianCalendar();
		cHoy.setTime(hoy);
		this.jLabelFecha.setText("Hoy es: "
				+ ManejoFechas.formatoEspanol.format(cHoy.getTime()));
		inicio = true;
		cargarDatos();
		inicio = false;
	}

	public void cargarDatos() {
		//this.setVisible(true);
		this.jLabelPacientes
				.setText("El n�mero de pacientes registrado es de :"
						+ Fachada.getInstancia().obtenerCantidadPacientes());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelFecha = new JLabel();
			jLabelFecha.setBounds(new Rectangle(7, 112, 208, 24));
			jLabelFecha.setText("JLabel");
			jLabelPacientes = new JLabel();
			jLabelPacientes.setBounds(new Rectangle(7, 73, 326, 28));
			jLabelPacientes.setText("JLabel");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(Color.WHITE);
			jContentPane.add(jLabelPacientes, null);
			jContentPane.add(jLabelFecha, null);
			jContentPane.add(getJButtonSalir(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jJMenuBar
	 * 
	 * @return javax.swing.JMenuBar
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.setBackground(new Color(153, 255, 172));
			jJMenuBar.setForeground(new Color(102, 255, 172));
			jJMenuBar.add(getJMenuBuscar());
			jJMenuBar.add(getJMenuConsultas());
			jJMenuBar.add(getJMenuPersonas());
			jJMenuBar.add(getJMenuDatosFijos());
			jJMenuBar.add(getJMenuReportes());
			jJMenuBar.add(Box.createHorizontalGlue());
			jJMenuBar.add(getJMenuDatosManagement());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenuPersonas
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenuPersonas() {
		if (jMenuPersonas == null) {
			jMenuPersonas = new JMenu();
			jMenuPersonas.setText("Personas");
			jMenuPersonas.setBackground(new Color(153, 255, 172));
			jMenuPersonas.add(getJMenuReceptor());
			jMenuPersonas.add(getJMenuDonante());
		}
		return jMenuPersonas;
	}

	/**
	 * This method initializes jMenuDonante
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenuDonante() {
		if (jMenuDonante == null) {
			jMenuDonante = new JMenu();
			jMenuDonante.setText("Donante");
			jMenuDonante.add(getJMenuItemIngresarD());
			jMenuDonante.add(getJMenuItemModificarD());
		}
		return jMenuDonante;
	}

	/**
	 * This method initializes jMenuItemIngresarD
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemIngresarD() {
		if (jMenuItemIngresarD == null) {
			jMenuItemIngresarD = new JMenuItem();
			jMenuItemIngresarD.setText("Ingresar");
			jMenuItemIngresarD
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							ingresarDonante();
						}
					});
		}
		return jMenuItemIngresarD;
	}

	/**
	 * This method initializes jMenuReceptor
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenuReceptor() {
		if (jMenuReceptor == null) {
			jMenuReceptor = new JMenu();
			jMenuReceptor.setText("Receptor");
			jMenuReceptor.setBackground(new Color(255, 255, 204));
			// jMenuReceptor.setForeground(new Color(255, 255, 204));
			jMenuReceptor.add(getJMenuItemIngresarR());
			jMenuReceptor.add(getJMenuItemModificarR());
		}
		return jMenuReceptor;
	}

	/**
	 * This method initializes jMenuItemIngresarR
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemIngresarR() {
		if (jMenuItemIngresarR == null) {
			jMenuItemIngresarR = new JMenuItem();
			jMenuItemIngresarR.setText("Ingresar");
			jMenuItemIngresarR.setBackground(new Color(255, 255, 204));
			jMenuItemIngresarR
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							ingresarPaciente();
						}
					});
		}
		return jMenuItemIngresarR;
	}

	/**
	 * This method initializes jMenuItemModificarR
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemModificarR() {
		if (jMenuItemModificarR == null) {
			jMenuItemModificarR = new JMenuItem();
			jMenuItemModificarR.setText("Manejar");
			jMenuItemModificarR.setBackground(new Color(255, 255, 204));
			jMenuItemModificarR
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							seleccionarPaciente();
						}
					});
		}
		return jMenuItemModificarR;
	}

	/**
	 * This method initializes jMenuItemModificarD
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemModificarD() {
		if (jMenuItemModificarD == null) {
			jMenuItemModificarD = new JMenuItem();
			jMenuItemModificarD.setText("Manejar");
			jMenuItemModificarD
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							modificarDonante();
						}
					});
		}
		return jMenuItemModificarD;
	}

	private void ingresarPaciente() {
		IUPrincipalLogic.ingresarPaciente();
	}

	private void seleccionarPaciente() {
		IUPrincipalLogic.seleccionarPaciente();
	}

	public void update(Observable o, Object arg) {
		if(o == Fachada.getInstancia()){
			if((Fachada.getInstancia().getLugar() == Fachada.PACIENTE) || inicio){
				cargarDatos();
			}
		}
		
	}

	/**
	 * This method initializes jMenuDatosFijos
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenuDatosFijos() {
		if (jMenuDatosFijos == null) {
			jMenuDatosFijos = new JMenu();
			jMenuDatosFijos.setText("Datos Fijos");
			jMenuDatosFijos.add(getJMenuItemNefropatias());
			jMenuDatosFijos.add(getJMenuItemCausaMuertePaciente());
			jMenuDatosFijos.add(getJMenuItemCausasPerdidaInjerto());
			jMenuDatosFijos.add(getJMenuItemAntecedentesDonante());
			jMenuDatosFijos.add(getJMenuItemCausaMuerteDonante());
			jMenuDatosFijos.add(getJMenuItemResultadoPBR());
			jMenuDatosFijos.add(getJMenuItemManejarSerol());
			jMenuDatosFijos.add(getJMenuItemManejarInduccion());
			jMenuDatosFijos.add(getJMenuItemManejarInmunosupresores());
			jMenuDatosFijos.add(getJMenuItemMedicacion());
			jMenuDatosFijos.add(getJMenuItemTiposComplicaciones());
			jMenuDatosFijos.add(getJMenuItemManejarInfeccion());
			jMenuDatosFijos.add(getJMenuItemManejarGermenes());
			jMenuDatosFijos.add(getJMenuItemManejarFechaControl());
			jMenuDatosFijos.add(getJMenuItemCMVDrogas());
			jMenuDatosFijos.add(getJMenuItemCMVDiagnostico());
			jMenuDatosFijos.add(getJMenuItemEnfermedades());
			jMenuDatosFijos.add(getJMenuItemTratamientoRA());
		}
		return jMenuDatosFijos;
	}

	/**
	 * This method initializes jMenuItemNefropatias
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemNefropatias() {
		if (jMenuItemNefropatias == null) {
			jMenuItemNefropatias = new JMenuItem();
			jMenuItemNefropatias.setText("Nefropatias");
			jMenuItemNefropatias.setBackground(new Color(204, 255, 204));
			jMenuItemNefropatias
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							nefropatias();
						}
					});
		}
		return jMenuItemNefropatias;
	}

	private void nefropatias() {
		IUPrincipalLogic.nefropatias();
	}

	/**
	 * This method initializes jMenuItemCausaMuertePaciente
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemCausaMuertePaciente() {
		if (jMenuItemCausaMuertePaciente == null) {
			jMenuItemCausaMuertePaciente = new JMenuItem();
			jMenuItemCausaMuertePaciente
					.setText("Causas de Muerte de Pacientes");
			jMenuItemCausaMuertePaciente
					.setBackground(new Color(204, 255, 204));
			jMenuItemCausaMuertePaciente
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							causasMuertePacientes();
						}
					});
		}
		return jMenuItemCausaMuertePaciente;
	}

	public void causasMuertePacientes() {
		IUPrincipalLogic.causasMuertePacientes();
	}

	/**
	 * This method initializes jMenuItemCausasPerdidaInjerto
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemCausasPerdidaInjerto() {
		if (jMenuItemCausasPerdidaInjerto == null) {
			jMenuItemCausasPerdidaInjerto = new JMenuItem();
			jMenuItemCausasPerdidaInjerto.setText("Causas Perdida Injerto");
			jMenuItemCausasPerdidaInjerto
					.setBackground(new Color(204, 255, 204));
			jMenuItemCausasPerdidaInjerto
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							causasPerdidaInjerto();
						}
					});
		}
		return jMenuItemCausasPerdidaInjerto;
	}

	private void causasPerdidaInjerto() {
		IUPrincipalLogic.causasPerdidaInjerto();
	}

	/**
	 * This method initializes jMenuItemAntecedentesDonante
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemAntecedentesDonante() {
		if (jMenuItemAntecedentesDonante == null) {
			jMenuItemAntecedentesDonante = new JMenuItem();
			jMenuItemAntecedentesDonante.setText("Antecedentes Donante");
			jMenuItemAntecedentesDonante
					.setBackground(new Color(204, 255, 204));
			jMenuItemAntecedentesDonante
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							antecedentesDonante();
						}
					});
		}
		return jMenuItemAntecedentesDonante;
	}

	private void antecedentesDonante() {
		IUPrincipalLogic.antecedentesDonante();
	}

	/**
	 * This method initializes jMenuItemCausaMuerteDonante
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemCausaMuerteDonante() {
		if (jMenuItemCausaMuerteDonante == null) {
			jMenuItemCausaMuerteDonante = new JMenuItem();
			jMenuItemCausaMuerteDonante.setText("Causa Muerte del Donante");
			jMenuItemCausaMuerteDonante.setBackground(new Color(204, 255, 204));
			jMenuItemCausaMuerteDonante
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							causaMuerteDonante();
						}
					});
		}
		return jMenuItemCausaMuerteDonante;
	}

	private void causaMuerteDonante() {
		IUPrincipalLogic.causaMuerteDonante();
	}

	private void ingresarDonante() {
		IUPrincipalLogic.ingresarDonante();
	}

	private void modificarDonante() {
		IUPrincipalLogic.modificarDonante();
	}

	/**
	 * This method initializes jMenuItemResultadoPBR
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemResultadoPBR() {
		if (jMenuItemResultadoPBR == null) {
			jMenuItemResultadoPBR = new JMenuItem();
			jMenuItemResultadoPBR.setText("Resultado PBR");
			jMenuItemResultadoPBR.setBackground(new Color(204, 255, 204));
			jMenuItemResultadoPBR
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							resultadoPBR();
						}
					});
		}
		return jMenuItemResultadoPBR;
	}

	private void resultadoPBR() {
		IUPrincipalLogic.resultadoPBR();
	}

	/**
	 * This method initializes jMenuItemManejarSerol
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemManejarSerol() {
		if (jMenuItemManejarSerol == null) {
			jMenuItemManejarSerol = new JMenuItem();
			jMenuItemManejarSerol.setText("Serol");
			jMenuItemManejarSerol.setBackground(new Color(204, 255, 204));
			jMenuItemManejarSerol
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							manejarSerol();
						}
					});
		}
		return jMenuItemManejarSerol;
	}

	private void manejarSerol() {
		IUPrincipalLogic.manejarSerol();
	}

	/**
	 * This method initializes jMenuItemManejarInduccion
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemManejarInduccion() {
		if (jMenuItemManejarInduccion == null) {
			jMenuItemManejarInduccion = new JMenuItem();
			jMenuItemManejarInduccion.setText("Induccion");
			jMenuItemManejarInduccion.setBackground(new Color(204, 255, 204));
			jMenuItemManejarInduccion
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							manejarInduccion();
						}
					});
		}
		return jMenuItemManejarInduccion;
	}

	private void manejarInduccion() {
		IUPrincipalLogic.manejarInduccion();
	}

	/**
	 * This method initializes jMenuItemManejarInmunosupresores
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemManejarInmunosupresores() {
		if (jMenuItemManejarInmunosupresores == null) {
			jMenuItemManejarInmunosupresores = new JMenuItem();
			jMenuItemManejarInmunosupresores.setText("Inmunosupresores");
			jMenuItemManejarInmunosupresores.setBackground(new Color(204, 255,
					204));
			jMenuItemManejarInmunosupresores
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							manejarInmunosupresores();
						}
					});
		}
		return jMenuItemManejarInmunosupresores;
	}

	private void manejarInmunosupresores() {
		IUPrincipalLogic.manejarInmunosupresores();
	}

	/**
	 * This method initializes jMenuItemMedicacion
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemMedicacion() {
		if (jMenuItemMedicacion == null) {
			jMenuItemMedicacion = new JMenuItem();
			jMenuItemMedicacion.setText("Medicaciones");
			jMenuItemMedicacion.setBackground(new Color(204, 255, 204));
			jMenuItemMedicacion
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							manejarMedicacion();
						}
					});
		}
		return jMenuItemMedicacion;
	}

	private void manejarMedicacion() {
		IUPrincipalLogic.manejarMedicacion();
	}

	/**
	 * This method initializes jMenuItemTiposComplicaciones
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemTiposComplicaciones() {
		if (jMenuItemTiposComplicaciones == null) {
			jMenuItemTiposComplicaciones = new JMenuItem();
			jMenuItemTiposComplicaciones.setText("Tipos de Complicaciones");
			jMenuItemTiposComplicaciones
					.setBackground(new Color(204, 255, 204));
			jMenuItemTiposComplicaciones
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							manejarTiposComplicaciones();
						}
					});
		}
		return jMenuItemTiposComplicaciones;
	}

	private void manejarTiposComplicaciones() {
		IUPrincipalLogic.manejarTiposComplicaciones();
	}

	/**
	 * This method initializes jMenuBuscar
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenuBuscar() {
		if (jMenuBuscar == null) {
			jMenuBuscar = new JMenu();
			jMenuBuscar.setText("Buscar");
			jMenuBuscar.add(getJMenuItemBuscar());
		}
		return jMenuBuscar;
	}

	private void buscar() {
		IUPrincipalLogic.buscar();
	}

	/**
	 * This method initializes jMenuItemBuscar
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemBuscar() {
		if (jMenuItemBuscar == null) {
			jMenuItemBuscar = new JMenuItem();
			jMenuItemBuscar.setText("Buscar Persona");
			jMenuItemBuscar.setBackground(new Color(255, 255, 204));
			jMenuItemBuscar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							buscar();
						}
					});
		}
		return jMenuItemBuscar;
	}

	/**
	 * This method initializes jMenuItemManejarInfeccion
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemManejarInfeccion() {
		if (jMenuItemManejarInfeccion == null) {
			jMenuItemManejarInfeccion = new JMenuItem();
			jMenuItemManejarInfeccion.setText("Infecciones");
			jMenuItemManejarInfeccion.setBackground(new Color(204, 255, 204));
			jMenuItemManejarInfeccion
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							manejarInfecciones();
						}
					});
		}
		return jMenuItemManejarInfeccion;
	}

	private void manejarInfecciones() {
		IUPrincipalLogic.manejarInfecciones();
	}

	/**
	 * This method initializes jMenuItemManejarGermenes
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemManejarGermenes() {
		if (jMenuItemManejarGermenes == null) {
			jMenuItemManejarGermenes = new JMenuItem();
			jMenuItemManejarGermenes.setText("Germenes");
			jMenuItemManejarGermenes.setBackground(new Color(204, 255, 204));
			jMenuItemManejarGermenes
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							manejarGermenes();
						}
					});
		}
		return jMenuItemManejarGermenes;
	}

	private void manejarGermenes() {
		IUPrincipalLogic.manejarGermenes();
	}

	/**
	 * This method initializes jMenuItemManejarFechaControl
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemManejarFechaControl() {
		if (jMenuItemManejarFechaControl == null) {
			jMenuItemManejarFechaControl = new JMenuItem();
			jMenuItemManejarFechaControl.setText("Fecha de Control");
			jMenuItemManejarFechaControl
					.setBackground(new Color(204, 255, 204));
			jMenuItemManejarFechaControl
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							manejarFechaDeControl();
						}
					});
		}
		return jMenuItemManejarFechaControl;
	}

	private void manejarFechaDeControl() {
		IUPrincipalLogic.manejarFechaDeControl();
	}
	
	/**
	 * This method initializes jMenuConsultas
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenuConsultas() {
		if (jMenuConsultas == null) {
			jMenuConsultas = new JMenu();
			jMenuConsultas.setText("Consultas");
			jMenuConsultas.add(getJMenuConsultasNumeros());
			jMenuConsultas.add(getJMenuConsultasB());
			jMenuConsultas.add(getJMenuConsultasC());
			jMenuConsultas.add(getJMenuItemTrasplantesGermenesInfecciones());
			jMenuConsultas.add(getJMenuItemConsultaReOperaciones());
			jMenuConsultas.add(getJMenuItemConsultaComplicacionLineal());
		}
		return jMenuConsultas;
	}

	/**
	 * This method initializes jMenuItemTrasplantesGermenesInfecciones
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemTrasplantesGermenesInfecciones() {
		if (jMenuItemTrasplantesGermenesInfecciones == null) {
			jMenuItemTrasplantesGermenesInfecciones = new JMenuItem();
			jMenuItemTrasplantesGermenesInfecciones
					.setText("Germenes e Infeccion");
			jMenuItemTrasplantesGermenesInfecciones.setBackground(new Color(
					204, 204, 255));
			jMenuItemTrasplantesGermenesInfecciones
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaTrasplanteGermenInfeccion();
						}
					});
		}
		return jMenuItemTrasplantesGermenesInfecciones;
	}

	private void consultaTrasplanteGermenInfeccion() {
		IUPrincipalLogic.consultaTrasplanteGermenInfeccion();
	}

	/**
	 * This method initializes jMenuItemConsultaReOperaciones
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaReOperaciones() {
		if (jMenuItemConsultaReOperaciones == null) {
			jMenuItemConsultaReOperaciones = new JMenuItem();
			jMenuItemConsultaReOperaciones
					.setText("ReOperaciones");
			jMenuItemConsultaReOperaciones.setBackground(new Color(
					204, 204, 255));
			jMenuItemConsultaReOperaciones
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenericaOpciones(0);
						}
					});
		}
		return jMenuItemConsultaReOperaciones;
	}
	
	/**
	 * This method initializes jMenuItemConsultaTabaquismo
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaTabaquismo() {
		if (jMenuItemConsultaTabaquismo == null) {
			jMenuItemConsultaTabaquismo = new JMenuItem();
			jMenuItemConsultaTabaquismo.setText("Pacientes con tabaquismo");
			jMenuItemConsultaTabaquismo.setBackground(new Color(204, 204, 255));
			jMenuItemConsultaTabaquismo
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(0);
						}
					});
		}
		return jMenuItemConsultaTabaquismo;
	}

	/**
	 * This method initializes jMenuItemConsultaDislipemia
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaDislipemia() {
		if (jMenuItemConsultaDislipemia == null) {
			jMenuItemConsultaDislipemia = new JMenuItem();
			jMenuItemConsultaDislipemia.setText("Pacientes con dislipemia");
			jMenuItemConsultaDislipemia.setBackground(new Color(204, 204, 255));
			jMenuItemConsultaDislipemia
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(1);
						}
					});
		}
		return jMenuItemConsultaDislipemia;
	}

	/**
	 * This method initializes jMenuItemConsultaImcPacientesObesos
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaImcPacientesObesos() {
		if (jMenuItemConsultaImcPacientesObesos == null) {
			jMenuItemConsultaImcPacientesObesos = new JMenuItem();
			jMenuItemConsultaImcPacientesObesos
					.setText("IMC de pacientes con obesidad");
			jMenuItemConsultaImcPacientesObesos.setBackground(new Color(204,
					204, 255));
			jMenuItemConsultaImcPacientesObesos
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(2);
						}
					});
		}
		return jMenuItemConsultaImcPacientesObesos;
	}

	/**
	 * This method initializes jMenuItemConsultaImcPacientesNoObesos
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaImcPacientesNoObesos() {
		if (jMenuItemConsultaImcPacientesNoObesos == null) {
			jMenuItemConsultaImcPacientesNoObesos = new JMenuItem();
			jMenuItemConsultaImcPacientesNoObesos
					.setText("IMC de pacientes sin obesidad");
			jMenuItemConsultaImcPacientesNoObesos.setBackground(new Color(204,
					204, 255));
			jMenuItemConsultaImcPacientesNoObesos
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(3);
						}
					});
		}
		return jMenuItemConsultaImcPacientesNoObesos;
	}

	/**
	 * This method initializes jMenuItemConsultaPacientesConHTA
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaPacientesConHTA() {
		if (jMenuItemConsultaPacientesConHTA == null) {
			jMenuItemConsultaPacientesConHTA = new JMenuItem();
			jMenuItemConsultaPacientesConHTA
					.setText("Pacientes con HTA positivo");
			jMenuItemConsultaPacientesConHTA.setBackground(new Color(204, 204,
					255));
			jMenuItemConsultaPacientesConHTA
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(4);
						}
					});
		}
		return jMenuItemConsultaPacientesConHTA;
	}

	/**
	 * This method initializes jMenuItemConsultaPacientesConDiabetes
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaPacientesConDiabetes() {
		if (jMenuItemConsultaPacientesConDiabetes == null) {
			jMenuItemConsultaPacientesConDiabetes = new JMenuItem();
			jMenuItemConsultaPacientesConDiabetes
					.setText("Pacientes con Diabetes");
			jMenuItemConsultaPacientesConDiabetes.setBackground(new Color(204,
					204, 255));
			jMenuItemConsultaPacientesConDiabetes
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(5);
						}
					});
		}
		return jMenuItemConsultaPacientesConDiabetes;
	}

	/**
	 * This method initializes jMenuItemConsultaPacientesPorSexo
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaPacientesPorSexo() {
		if (jMenuItemConsultaPacientesPorSexo == null) {
			jMenuItemConsultaPacientesPorSexo = new JMenuItem();
			jMenuItemConsultaPacientesPorSexo
					.setText("Lista pacientes por sexo");
			jMenuItemConsultaPacientesPorSexo.setBackground(new Color(204, 204,
					255));
			jMenuItemConsultaPacientesPorSexo
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(6);
						}
					});
		}
		return jMenuItemConsultaPacientesPorSexo;
	}

	/**
	 * This method initializes jMenuItemConsultaPacientesPorOrigen
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaPacientesPorOrigen() {
		if (jMenuItemConsultaPacientesPorOrigen == null) {
			jMenuItemConsultaPacientesPorOrigen = new JMenuItem();
			jMenuItemConsultaPacientesPorOrigen
					.setText("Lista pacientes por origen");
			jMenuItemConsultaPacientesPorOrigen.setBackground(new Color(204,
					204, 255));
			jMenuItemConsultaPacientesPorOrigen
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(7);
						}
					});
		}
		return jMenuItemConsultaPacientesPorOrigen;
	}

	/**
	 * This method initializes jMenuItemConsultaPacientesPorEdad
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaPacientesPorEdad() {
		if (jMenuItemConsultaPacientesPorEdad == null) {
			jMenuItemConsultaPacientesPorEdad = new JMenuItem();
			jMenuItemConsultaPacientesPorEdad
					.setText("Lista pacientes por edad al trasplantarse");
			jMenuItemConsultaPacientesPorEdad.setBackground(new Color(204, 204,
					255));
			jMenuItemConsultaPacientesPorEdad
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(8);
						}
					});
		}
		return jMenuItemConsultaPacientesPorEdad;
	}

	/**
	 * This method initializes jMenuItemConsultaPacientesTiempoEnLista
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaPacientesTiempoEnLista() {
		if (jMenuItemConsultaPacientesTiempoEnLista == null) {
			jMenuItemConsultaPacientesTiempoEnLista = new JMenuItem();
			jMenuItemConsultaPacientesTiempoEnLista
					.setText("Tiempo en lista de los pacientes");
			jMenuItemConsultaPacientesTiempoEnLista.setBackground(new Color(
					204, 204, 255));
			jMenuItemConsultaPacientesTiempoEnLista
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(9);
						}
					});
		}
		return jMenuItemConsultaPacientesTiempoEnLista;
	}

	/**
	 * This method initializes jMenuItemConsultaPacientesFallecimiento
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaPacientesFallecimiento() {
		if (jMenuItemConsultaPacientesFallecimiento == null) {
			jMenuItemConsultaPacientesFallecimiento = new JMenuItem();
			jMenuItemConsultaPacientesFallecimiento
					.setText("Informacion del fallecimiento de pacientes");
			jMenuItemConsultaPacientesFallecimiento.setBackground(new Color(
					204, 204, 255));
			jMenuItemConsultaPacientesFallecimiento
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(10);
						}
					});
		}
		return jMenuItemConsultaPacientesFallecimiento;
	}

	/**
	 * This method initializes jMenuItemConsultaPacientesNefropatiasPBR
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaPacientesNefropatiasPBR() {
		if (jMenuItemConsultaPacientesNefropatiasPBR == null) {
			jMenuItemConsultaPacientesNefropatiasPBR = new JMenuItem();
			jMenuItemConsultaPacientesNefropatiasPBR
					.setText("Informacion nefropatias y pbr del pacientes");
			jMenuItemConsultaPacientesNefropatiasPBR.setBackground(new Color(
					204, 204, 255));
			jMenuItemConsultaPacientesNefropatiasPBR
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(11);
						}
					});
		}
		return jMenuItemConsultaPacientesNefropatiasPBR;
	}

	/**
	 * This method initializes jMenuItemConsultaTranfusionesEmbarazos
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaTranfusionesEmbarazos() {
		if (jMenuItemConsultaTranfusionesEmbarazos == null) {
			jMenuItemConsultaTranfusionesEmbarazos = new JMenuItem();
			jMenuItemConsultaTranfusionesEmbarazos
					.setText("Tranfusiones y embarazos");
			jMenuItemConsultaTranfusionesEmbarazos.setBackground(new Color(204,
					204, 255));
			jMenuItemConsultaTranfusionesEmbarazos
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(12);
						}
					});
		}
		return jMenuItemConsultaTranfusionesEmbarazos;
	}

	/**
	 * This method initializes jMenuItemConsultaSangreDonantePaciente
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaSangreDonantePaciente() {
		if (jMenuItemConsultaSangreDonantePaciente == null) {
			jMenuItemConsultaSangreDonantePaciente = new JMenuItem();
			jMenuItemConsultaSangreDonantePaciente
					.setText("Grupo sanguineo donante y paciente");
			jMenuItemConsultaSangreDonantePaciente.setBackground(new Color(204,
					204, 255));
			jMenuItemConsultaSangreDonantePaciente
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(13);
						}
					});
		}
		return jMenuItemConsultaSangreDonantePaciente;
	}

	/**
	 * This method initializes jMenuItemConsultaNumArteriasNumVenasYUreter
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaNumArteriasNumVenasYUreter() {
		if (jMenuItemConsultaNumArteriasNumVenasYUreter == null) {
			jMenuItemConsultaNumArteriasNumVenasYUreter = new JMenuItem();
			jMenuItemConsultaNumArteriasNumVenasYUreter
					.setText("N� Arterias, N� Venas y Ureter");
			jMenuItemConsultaNumArteriasNumVenasYUreter
					.setBackground(new Color(204, 204, 255));
			jMenuItemConsultaNumArteriasNumVenasYUreter
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(14);
						}
					});
		}
		return jMenuItemConsultaNumArteriasNumVenasYUreter;
	}

	/**
	 * This method initializes jMenuItemConsultaLadoImplanteYAnomalia
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaLadoImplanteYAnomalia() {
		if (jMenuItemConsultaLadoImplanteYAnomalia == null) {
			jMenuItemConsultaLadoImplanteYAnomalia = new JMenuItem();
			jMenuItemConsultaLadoImplanteYAnomalia
					.setText("Lado del implante y anomalia");
			jMenuItemConsultaLadoImplanteYAnomalia.setBackground(new Color(204,
					204, 255));
			jMenuItemConsultaLadoImplanteYAnomalia
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(15);
						}
					});
		}
		return jMenuItemConsultaLadoImplanteYAnomalia;
	}

	/**
	 * This method initializes jMenuItemConsultaInestabilidadHemodinamica
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaInestabilidadHemodinamica() {
		if (jMenuItemConsultaInestabilidadHemodinamica == null) {
			jMenuItemConsultaInestabilidadHemodinamica = new JMenuItem();
			jMenuItemConsultaInestabilidadHemodinamica
					.setText("Pacientes con Inestabilidad Hemodinamica");
			jMenuItemConsultaInestabilidadHemodinamica.setBackground(new Color(
					204, 204, 255));
			jMenuItemConsultaInestabilidadHemodinamica
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(16);
						}
					});
		}
		return jMenuItemConsultaInestabilidadHemodinamica;
	}

	/**
	 * This method initializes jMenuItemConsultaEdadPacienteDonanteTrasplante
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaEdadPacienteDonanteTrasplante() {
		if (jMenuItemConsultaEdadPacienteDonanteTrasplante == null) {
			jMenuItemConsultaEdadPacienteDonanteTrasplante = new JMenuItem();
			jMenuItemConsultaEdadPacienteDonanteTrasplante
					.setText("Edad del paciente y donante al momento del trasplante");
			jMenuItemConsultaEdadPacienteDonanteTrasplante
					.setBackground(new Color(204, 204, 255));
			jMenuItemConsultaEdadPacienteDonanteTrasplante
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(17);
						}
					});
		}
		return jMenuItemConsultaEdadPacienteDonanteTrasplante;
	}

	/**
	 * This method initializes jMenuItemConsultaSexoPacienteDonanteTrasplante
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaSexoPacienteDonanteTrasplante() {
		if (jMenuItemConsultaSexoPacienteDonanteTrasplante == null) {
			jMenuItemConsultaSexoPacienteDonanteTrasplante = new JMenuItem();
			jMenuItemConsultaSexoPacienteDonanteTrasplante
					.setText("Sexo del paciente y donante");
			jMenuItemConsultaSexoPacienteDonanteTrasplante
					.setBackground(new Color(204, 204, 255));
			jMenuItemConsultaSexoPacienteDonanteTrasplante
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(18);
						}
					});
		}
		return jMenuItemConsultaSexoPacienteDonanteTrasplante;
	}

	/**
	 * This method initializes jMenuItemConsultaTipoDonantePaciente
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaTipoDonantePaciente() {
		if (jMenuItemConsultaTipoDonantePaciente == null) {
			jMenuItemConsultaTipoDonantePaciente = new JMenuItem();
			jMenuItemConsultaTipoDonantePaciente
					.setText("Tipo de donante y relacion filiar con el paciente");
			jMenuItemConsultaTipoDonantePaciente.setBackground(new Color(204,
					204, 255));
			jMenuItemConsultaTipoDonantePaciente
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(19);
						}
					});
		}
		return jMenuItemConsultaTipoDonantePaciente;
	}

	/**
	 * This method initializes jMenuItemConsultaPacienteVariosTrasplantes
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaPacienteVariosTrasplantes() {
		if (jMenuItemConsultaPacienteVariosTrasplantes == null) {
			jMenuItemConsultaPacienteVariosTrasplantes = new JMenuItem();
			jMenuItemConsultaPacienteVariosTrasplantes
					.setText("Pacientes con varios trasplantes");
			jMenuItemConsultaPacienteVariosTrasplantes.setBackground(new Color(
					204, 204, 255));
			jMenuItemConsultaPacienteVariosTrasplantes
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(20);
						}
					});
		}
		return jMenuItemConsultaPacienteVariosTrasplantes;
	}

	/**
	 * This method initializes jMenuItemConsultaPacienteFechaTrasplantes
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaPacienteFechaTrasplantes() {
		if (jMenuItemConsultaPacienteFechaTrasplantes == null) {
			jMenuItemConsultaPacienteFechaTrasplantes = new JMenuItem();
			jMenuItemConsultaPacienteFechaTrasplantes
					.setText("Fecha del trasplante");
			jMenuItemConsultaPacienteFechaTrasplantes.setBackground(new Color(
					204, 204, 255));
			jMenuItemConsultaPacienteFechaTrasplantes
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(21);
						}
					});
		}
		return jMenuItemConsultaPacienteFechaTrasplantes;
	}

	/**
	 * This method initializes
	 * jMenuItemConsultaTrasplantesCompatibilidadIncompatibilidadPRA
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaTrasplantesCompatibilidadIncompatibilidadPRA() {
		if (jMenuItemConsultaTrasplantesCompatibilidadIncompatibilidadPRA == null) {
			jMenuItemConsultaTrasplantesCompatibilidadIncompatibilidadPRA = new JMenuItem();
			jMenuItemConsultaTrasplantesCompatibilidadIncompatibilidadPRA
					.setText("Compatibilidad, Incompatibilidad y PRA");
			jMenuItemConsultaTrasplantesCompatibilidadIncompatibilidadPRA
					.setBackground(new Color(204, 204, 255));
			jMenuItemConsultaTrasplantesCompatibilidadIncompatibilidadPRA
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(22);
						}
					});
		}
		return jMenuItemConsultaTrasplantesCompatibilidadIncompatibilidadPRA;
	}

	/**
	 * This method initializes jMenuItemConsultaTrasplantesPorCirugia
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaTrasplantesPorCirugia() {
		if (jMenuItemConsultaTrasplantesPorCirugia == null) {
			jMenuItemConsultaTrasplantesPorCirugia = new JMenuItem();
			jMenuItemConsultaTrasplantesPorCirugia
					.setText("Datos cirurgicos del trasplante");
			jMenuItemConsultaTrasplantesPorCirugia.setBackground(new Color(204,
					204, 255));
			jMenuItemConsultaTrasplantesPorCirugia
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(23);
						}
					});
		}
		return jMenuItemConsultaTrasplantesPorCirugia;
	}

	/**
	 * This method initializes jMenuItemConsultaTrasplantesIsquemiaDiuresis
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaTrasplantesIsquemiaDiuresis() {
		if (jMenuItemConsultaTrasplantesIsquemiaDiuresis == null) {
			jMenuItemConsultaTrasplantesIsquemiaDiuresis = new JMenuItem();
			jMenuItemConsultaTrasplantesIsquemiaDiuresis
					.setText("Isquemia con Diuresis en BQ");
			jMenuItemConsultaTrasplantesIsquemiaDiuresis
					.setBackground(new Color(204, 204, 255));
			jMenuItemConsultaTrasplantesIsquemiaDiuresis
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(24);
						}
					});
		}
		return jMenuItemConsultaTrasplantesIsquemiaDiuresis;
	}

	/**
	 * This method initializes jMenuItemConsultaTrasplantesIsquemiaSinDiuresis
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaTrasplantesIsquemiaSinDiuresis() {
		if (jMenuItemConsultaTrasplantesIsquemiaSinDiuresis == null) {
			jMenuItemConsultaTrasplantesIsquemiaSinDiuresis = new JMenuItem();
			jMenuItemConsultaTrasplantesIsquemiaSinDiuresis
					.setText("Isquemia sin Diuresis en BQ");
			jMenuItemConsultaTrasplantesIsquemiaSinDiuresis
					.setBackground(new Color(204, 204, 255));
			jMenuItemConsultaTrasplantesIsquemiaSinDiuresis
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(25);
						}
					});
		}
		return jMenuItemConsultaTrasplantesIsquemiaSinDiuresis;
	}

	/**
	 * This method initializes jMenuItemConsultaTrasplantesInduccionesINM
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaTrasplantesInduccionesINM() {
		if (jMenuItemConsultaTrasplantesInduccionesINM == null) {
			jMenuItemConsultaTrasplantesInduccionesINM = new JMenuItem();
			jMenuItemConsultaTrasplantesInduccionesINM.setText("Induccion INM");
			jMenuItemConsultaTrasplantesInduccionesINM.setBackground(new Color(
					204, 204, 255));
			jMenuItemConsultaTrasplantesInduccionesINM
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(26);
						}
					});
		}
		return jMenuItemConsultaTrasplantesInduccionesINM;
	}

	/**
	 * This method initializes jMenuItemConsultaTrasplantesInmunosupresores
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaTrasplantesInmunosupresores() {
		if (jMenuItemConsultaTrasplantesInmunosupresores == null) {
			jMenuItemConsultaTrasplantesInmunosupresores = new JMenuItem();
			jMenuItemConsultaTrasplantesInmunosupresores
					.setText("Inmunosupresores");
			jMenuItemConsultaTrasplantesInmunosupresores
					.setBackground(new Color(204, 204, 255));
			jMenuItemConsultaTrasplantesInmunosupresores
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(27);
						}
					});
		}
		return jMenuItemConsultaTrasplantesInmunosupresores;
	}

	/**
	 * This method initializes jMenuItemConsultaTrasplantesDiuresisEnBq
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaTrasplantesDiuresisEnBq() {
		if (jMenuItemConsultaTrasplantesDiuresisEnBq == null) {
			jMenuItemConsultaTrasplantesDiuresisEnBq = new JMenuItem();
			jMenuItemConsultaTrasplantesDiuresisEnBq.setText("Diuresis en BQ");
			jMenuItemConsultaTrasplantesDiuresisEnBq.setBackground(new Color(
					204, 204, 255));
			jMenuItemConsultaTrasplantesDiuresisEnBq
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaGenerica(28);
						}
					});
		}
		return jMenuItemConsultaTrasplantesDiuresisEnBq;
	}

	private void consultaGenerica(int id) {
		IUPrincipalLogic.consultaGenerica(id);
	}

	private void consultaGenericaOpciones(int id){
		IUPrincipalLogic.consultaGenericaOpciones(id);
	}
	
	/**
	 * This method initializes jMenuItemConsultaMuerteDonante
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaMuerteDonante() {
		if (jMenuItemConsultaMuerteDonante == null) {
			jMenuItemConsultaMuerteDonante = new JMenuItem();
			jMenuItemConsultaMuerteDonante
					.setText("Por causa muerte del donante");
			jMenuItemConsultaMuerteDonante.setBackground(new Color(204, 204,
					255));
			jMenuItemConsultaMuerteDonante
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consCausaMuerteDonante();
						}
					});
		}
		return jMenuItemConsultaMuerteDonante;
	}

	private void consCausaMuerteDonante() {
		IUPrincipalLogic.consCausaMuerteDonante();
	}

	/**
	 * This method initializes jMenuConsultasNumeros
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenuConsultasNumeros() {
		if (jMenuConsultasNumeros == null) {
			jMenuConsultasNumeros = new JMenu();
			jMenuConsultasNumeros.setText("Numeros");
			jMenuConsultasNumeros.add(getJMenuItemConsultaTabaquismo());
			jMenuConsultasNumeros.add(getJMenuItemConsultaDislipemia());
			jMenuConsultasNumeros.add(getJMenuItemConsultaImcPacientesObesos());
			jMenuConsultasNumeros
					.add(getJMenuItemConsultaImcPacientesNoObesos());
			jMenuConsultasNumeros.add(getJMenuItemConsultaPacientesConHTA());
			jMenuConsultasNumeros
					.add(getJMenuItemConsultaPacientesConDiabetes());
			jMenuConsultasNumeros.add(getJMenuItemConsultaPacientesPorSexo());
			jMenuConsultasNumeros.add(getJMenuItemConsultaPacientesPorOrigen());
			jMenuConsultasNumeros.add(getJMenuItemConsultaPacientesPorEdad());
			jMenuConsultasNumeros
					.add(getJMenuItemConsultaPacientesTiempoEnLista());
			jMenuConsultasNumeros
					.add(getJMenuItemConsultaPacientesFallecimiento());
			jMenuConsultasNumeros
					.add(getJMenuItemConsultaPacientesNefropatiasPBR());

		}
		return jMenuConsultasNumeros;
	}

	/**
	 * This method initializes jMenuConsultasB
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenuConsultasB() {
		if (jMenuConsultasB == null) {
			jMenuConsultasB = new JMenu();
			jMenuConsultasB.setText("B");
			jMenuConsultasB.add(getJMenuItemConsultaTranfusionesEmbarazos());
			jMenuConsultasB.add(getJMenuItemConsultaSangreDonantePaciente());
			jMenuConsultasB
					.add(getJMenuItemConsultaNumArteriasNumVenasYUreter());
			jMenuConsultasB.add(getJMenuItemConsultaLadoImplanteYAnomalia());
			jMenuConsultasB.add(getJMenuItemConsultaMuerteDonante());
			jMenuConsultasB
					.add(getJMenuItemConsultaInestabilidadHemodinamica());
			jMenuConsultasB
					.add(getJMenuItemConsultaEdadPacienteDonanteTrasplante());
			jMenuConsultasB
					.add(getJMenuItemConsultaSexoPacienteDonanteTrasplante());
			jMenuConsultasB.add(getJMenuItemConsultaTipoDonantePaciente());
			jMenuConsultasB
					.add(getJMenuItemConsultaPacienteVariosTrasplantes());
			jMenuConsultasB.add(getJMenuItemConsultaPacienteFechaTrasplantes());
			jMenuConsultasB
					.add(getJMenuItemConsultaTrasplantesCompatibilidadIncompatibilidadPRA());
			jMenuConsultasB.add(getJMenuItemConsultaTrasplantesPorCirugia());
			jMenuConsultasB
					.add(getJMenuItemConsultaTrasplantesIsquemiaDiuresis());
			jMenuConsultasB
					.add(getJMenuItemConsultaTrasplantesIsquemiaSinDiuresis());
			jMenuConsultasB
					.add(getJMenuItemConsultaTrasplantesInduccionesINM());
			jMenuConsultasB
					.add(getJMenuItemConsultaTrasplantesInmunosupresores());
		}
		return jMenuConsultasB;
	}

	/**
	 * This method initializes jMenuConsultasC
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenuConsultasC() {
		if (jMenuConsultasC == null) {
			jMenuConsultasC = new JMenu();
			jMenuConsultasC.setText("C");
			jMenuConsultasC.add(getJMenuItemConsultaTrasplantesDiuresisEnBq());
		}
		return jMenuConsultasC;
	}

	/**
	 * This method initializes jMenuItemCMVDrogas
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemCMVDrogas() {
		if (jMenuItemCMVDrogas == null) {
			jMenuItemCMVDrogas = new JMenuItem();
			jMenuItemCMVDrogas.setText("Drogas CMV");
			jMenuItemCMVDrogas.setBackground(new Color(204, 255, 204));
			jMenuItemCMVDrogas
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							manejarCMVDrogas();
						}
					});
		}
		return jMenuItemCMVDrogas;
	}

	private void manejarCMVDrogas() {
		IUPrincipalLogic.manejarCMVDrogas();
	}

	/**
	 * This method initializes jMenuItemCMVDiagnostico
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemCMVDiagnostico() {
		if (jMenuItemCMVDiagnostico == null) {
			jMenuItemCMVDiagnostico = new JMenuItem();
			jMenuItemCMVDiagnostico.setText("DiagnosticosCMV");
			jMenuItemCMVDiagnostico.setBackground(new Color(204, 255, 204));
			jMenuItemCMVDiagnostico
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							manejarCMVDiagnostico();
						}
					});
		}
		return jMenuItemCMVDiagnostico;
	}

	private void manejarCMVDiagnostico() {
		IUPrincipalLogic.manejarCMVDiagnostico();
	}

	/**
	 * This method initializes jMenuItemEnfermedades
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemEnfermedades() {
		if (jMenuItemEnfermedades == null) {
			jMenuItemEnfermedades = new JMenuItem();
			jMenuItemEnfermedades.setText("Enfermedades CMV");
			jMenuItemEnfermedades.setBackground(new Color(204, 255, 204));
			jMenuItemEnfermedades
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							manejarCMVEnfermedades();
						}
					});
		}
		return jMenuItemEnfermedades;
	}

	private void manejarCMVEnfermedades() {
		IUPrincipalLogic.manejarCMVEnfermedades();
	}

	/**
	 * This method initializes jMenuItemTratamientoRA
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemTratamientoRA() {
		if (jMenuItemTratamientoRA == null) {
			jMenuItemTratamientoRA = new JMenuItem();
			jMenuItemTratamientoRA.setText("Tratamiento RA");
			jMenuItemTratamientoRA.setBackground(new Color(204, 255, 204));
			jMenuItemTratamientoRA
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							manejarTratamientoRA();
						}
					});
		}
		return jMenuItemTratamientoRA;
	}

	private void manejarTratamientoRA() {
		IUPrincipalLogic.manejarTratamientoRA();
	}

	/**
	 * This method initializes jMenuDatosManagement
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenuDatosManagement() {
		if (jMenuDatosManagement == null) {
			jMenuDatosManagement = new JMenu();
			jMenuDatosManagement.setText("Respaldo y Contrase�as");
			jMenuDatosManagement.add(getJMenuItemCambiarPassword());
			jMenuDatosManagement.add(getJMenuItemBackUp());
			jMenuDatosManagement.add(getJMenuItemBackUpRestore());
		}
		return jMenuDatosManagement;
	}

	/**
	 * This method initializes jMenuItemCambiarPassword
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemCambiarPassword() {
		if (jMenuItemCambiarPassword == null) {
			jMenuItemCambiarPassword = new JMenuItem();
			jMenuItemCambiarPassword.setText("Cambiar Contrase�as");
			jMenuItemCambiarPassword
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							cambiarPassword();
						}
					});
		}
		return jMenuItemCambiarPassword;
	}
	
	private void cambiarPassword(){
		IUPrincipalLogic.cambiarPassword();
	}
	
	/**
	 * This method initializes jMenuItemBackUp
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemBackUp() {
		if (jMenuItemBackUp == null) {
			jMenuItemBackUp = new JMenuItem();
			jMenuItemBackUp.setText("Crear BackUp");
			jMenuItemBackUp
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							crearBackUp();
						}
					});
		}
		return jMenuItemBackUp;
	}
	
	private void crearBackUp(){
		IUPrincipalLogic.crearBackUp(this);
	}
	
	/**
	 * This method initializes jMenuItemBackUpRestore
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemBackUpRestore() {
		if (jMenuItemBackUpRestore == null) {
			jMenuItemBackUpRestore = new JMenuItem();
			jMenuItemBackUpRestore.setText("Restaurar BackUp");
			jMenuItemBackUpRestore
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							restoreBackUp();
						}
					});
		}
		return jMenuItemBackUpRestore;
	}
	
	private void restoreBackUp(){
		IUPrincipalLogic.restoreBackUp(this);
	}

	/**
	 * This method initializes jMenuItemConsultaComplicacionLineal	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemConsultaComplicacionLineal() {
		if (jMenuItemConsultaComplicacionLineal == null) {
			jMenuItemConsultaComplicacionLineal = new JMenuItem();
			jMenuItemConsultaComplicacionLineal.setText("Consulta complicaciones por tiempo");
			jMenuItemConsultaComplicacionLineal
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							consultaLinealesComplicaciones();
						}
					});
		}
		return jMenuItemConsultaComplicacionLineal;
	}
	
	
	private void consultaLinealesComplicaciones(){
		IUPrincipalLogic.consultaLinealesComplicaciones();
	}

	/**
	 * This method initializes jButtonSalir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSalir() {
		if (jButtonSalir == null) {
			jButtonSalir = new JButton();
			jButtonSalir.setBounds(new Rectangle(489, 98, 92, 33));
			jButtonSalir.setBackground(new Color(255, 255, 204));
			jButtonSalir.setText("Salir");
			jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salir();
				}
			});
		}
		return jButtonSalir;
	}
	
	private void salir(){
		this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		Fachada.getInstancia().salir();
		System.exit(0);
	}

	/**
	 * This method initializes jMenuReportes	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuReportes() {
		if (jMenuReportes == null) {
			jMenuReportes = new JMenu();
			jMenuReportes.setText("Reportes");
			jMenuReportes.add(getJMenuItemRegistroUruguayoTrasplante());
			jMenuReportes.add(getJMenuItemRegistroUruguayoTotal());
			//jMenuReportes.add(getJMenuItemRegistroUruguayoTotalPreTrasplante());
			jMenuReportes.add(getJMenuItemRegistroUruguayoTotalPreTrasplante());
		}
		return jMenuReportes;
	}

	/**
	 * This method initializes jMenuItemRegistroUruguayoTrasplante	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemRegistroUruguayoTrasplante() {
		if (jMenuItemRegistroUruguayoTrasplante == null) {
			jMenuItemRegistroUruguayoTrasplante = new JMenuItem();
			jMenuItemRegistroUruguayoTrasplante.setText("Registro Nacional de Trasplantes Por A�o.");
			jMenuItemRegistroUruguayoTrasplante
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							reporteRegistroUruguayo();
						}
					});
		}
		return jMenuItemRegistroUruguayoTrasplante;
	}
	
	private void reporteRegistroUruguayo(){
		IUPrincipalLogic.reporteRegistroUruguayo();
	}

	/**
	 * This method initializes jMenuItemRegistroUruguayoTotal	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemRegistroUruguayoTotal() {
		if (jMenuItemRegistroUruguayoTotal == null) {
			jMenuItemRegistroUruguayoTotal = new JMenuItem();
			jMenuItemRegistroUruguayoTotal.setText("Registro Uruguayo Total");
			jMenuItemRegistroUruguayoTotal
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							reporteRegistroUruguayoTotal();
						}
					});
		}
		return jMenuItemRegistroUruguayoTotal;
	}
	
	private void reporteRegistroUruguayoTotal(){
		IUPrincipalLogic.reporteRegistroUruguayoTotal();
	}
	
	private void reporteRegistroUruguayoTotalPreTrasplante(){
		IUPrincipalLogic.reporteRegistroUruguayoTotalPreTrasplante();
	}

/**
 * This method initializes jMenuItemRegistroUruguayoTotalPreTrasplante	
 * 	
 * @return javax.swing.JMenuItem	
 */
private JMenuItem getJMenuItemRegistroUruguayoTotalPreTrasplante() {
	if (jMenuItemRegistroUruguayoTotalPreTrasplante == null) {
		jMenuItemRegistroUruguayoTotalPreTrasplante = new JMenuItem();
		jMenuItemRegistroUruguayoTotalPreTrasplante.setText("Registro Uruguayo Total Con Pre Trasplante, RA y CMV");
		jMenuItemRegistroUruguayoTotalPreTrasplante
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						reporteRegistroUruguayoTotalPreTrasplante();
					}
				});
	}
	return jMenuItemRegistroUruguayoTotalPreTrasplante;
}
	
	
} // @jve:decl-index=0:visual-constraint="10,10"
