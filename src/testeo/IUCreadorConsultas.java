package testeo;

import impresion.PrintUtilities;

//import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
//import javax.swing.WindowConstants;
//import java.awt.Dimension;
import javax.swing.JInternalFrame;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBox;
import javax.swing.JTabbedPane;
import javax.swing.JButton;

public class IUCreadorConsultas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JInternalFrame jInternalFramePacientes = null;
	private JPanel jContentPacientes = null;
	private JMenuBar jJMenuBarOpciones = null;
	private JMenu jMenuOpciones = null;
	private JMenuItem jMenuItemPacientes = null;
	private JCheckBox jCheckBoxPacienteTHE = null;
	private JCheckBox jCheckBoxPacienteCI = null;
	private JCheckBox jCheckBoxPacienteNombre = null;
	private JCheckBox jCheckBoxPacienteApellido = null;
	private JCheckBox jCheckBoxPacienteNumFnr = null;
	private JCheckBox jCheckBoxPacienteRaza = null;
	private JCheckBox jCheckBoxPacienteSexo = null;
	private JCheckBox jCheckBoxPacienteFechaNacimiento = null;
	private JCheckBox jCheckBoxPacienteFechaDialisis = null;
	private JCheckBox jCheckBoxPacienteNefropatia = null;
	private JCheckBox jCheckBoxPacienteGrupoSanguineo = null;
	private JMenu jMenuEjecutar = null;
	private JMenuItem jMenuItemSinCondiciones = null;
	private JMenuItem jMenuItemConCondiciones = null;
	private ProcesoCrearConsulta procesamiento = new ProcesoCrearConsulta();  //  @jve:decl-index=0:
	/**
	 * This is the default constructor
	 */
	public IUCreadorConsultas() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(624, 570);
		this.setJMenuBar(getJJMenuBarOpciones());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Crear Consulta");
		this.jInternalFramePacientes.setVisible(true);
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
			jContentPane.add(getJInternalFramePacientes(), null);
			jContentPane.add(getJInternalFramePreTrasplante(), null);
			jContentPane.add(getJInternalFrameMuertePaciente(), null);
			jContentPane.add(getJInternalFramePerdidaInjerto(), null);
			jContentPane.add(getJTabbedPane1(), null);
			jContentPane.add(getJInternalFrameDonante(), null);
			jContentPane.add(getJInternalFramerReoperacion(), null);
			jContentPane.add(getJButtonImprimir(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jInternalFramePacientes	
	 * 	
	 * @return javax.swing.JInternalFrame	
	 */
	private JInternalFrame getJInternalFramePacientes() {
		if (jInternalFramePacientes == null) {
			jInternalFramePacientes = new JInternalFrame();
			jInternalFramePacientes.setBounds(new Rectangle(26, 36, 561, 456));
			jInternalFramePacientes.setTitle("Pacientes");
			jInternalFramePacientes.setContentPane(getJContentPacientes());
		}
		return jInternalFramePacientes;
	}

	/**
	 * This method initializes jContentPacientes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPacientes() {
		if (jContentPacientes == null) {
			jContentPacientes = new JPanel();
			jContentPacientes.setLayout(null);
			jContentPacientes.add(getJCheckBoxPacienteTHE(), null);
			jContentPacientes.add(getJCheckBoxPacienteCI(), null);
			jContentPacientes.add(getJCheckBoxPacienteNombre(), null);
			jContentPacientes.add(getJCheckBoxPacienteApellido(), null);
			jContentPacientes.add(getJCheckBoxPacienteNumFnr(), null);
			jContentPacientes.add(getJCheckBoxPacienteRaza(), null);
			jContentPacientes.add(getJCheckBoxPacienteSexo(), null);
			jContentPacientes.add(getJCheckBoxPacienteFechaNacimiento(), null);
			jContentPacientes.add(getJCheckBoxPacienteFechaDialisis(), null);
			jContentPacientes.add(getJCheckBoxPacienteNefropatia(), null);
			jContentPacientes.add(getJCheckBoxPacienteGrupoSanguineo(), null);
		}
		return jContentPacientes;
	}

	/**
	 * This method initializes jJMenuBarOpciones	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBarOpciones() {
		if (jJMenuBarOpciones == null) {
			jJMenuBarOpciones = new JMenuBar();
			jJMenuBarOpciones.add(getJMenuOpciones());
			jJMenuBarOpciones.add(getJMenuEjecutar());
		}
		return jJMenuBarOpciones;
	}

	/**
	 * This method initializes jMenuOpciones	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuOpciones() {
		if (jMenuOpciones == null) {
			jMenuOpciones = new JMenu();
			jMenuOpciones.setText("Seleccionar tabla");
			jMenuOpciones.add(getJMenuItemPacientes());
			jMenuOpciones.add(getJMenuItemPreTrasplante());
			jMenuOpciones.add(getJMenuItemMuertePaciente());
			jMenuOpciones.add(getJMenuItemPerdidaInjerto());
			jMenuOpciones.add(getJMenuItemTrasplante());
			jMenuOpciones.add(getJMenuItemDonante());
			jMenuOpciones.add(getJMenuItemReoperaciones());
		}
		return jMenuOpciones;
	}

	/**
	 * This method initializes jMenuItemPacientes	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemPacientes() {
		if (jMenuItemPacientes == null) {
			jMenuItemPacientes = new JMenuItem();
			jMenuItemPacientes.setText("Pacientes");
			jMenuItemPacientes.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					mostrarPacientes();
				}
			});
		}
		return jMenuItemPacientes;
	}

	/**
	 * This method initializes jCheckBoxPacienteTHE	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPacienteTHE() {
		if (jCheckBoxPacienteTHE == null) {
			jCheckBoxPacienteTHE = new JCheckBox();
			jCheckBoxPacienteTHE.setBounds(new Rectangle(11, 15, 135, 23));
			jCheckBoxPacienteTHE.setText("THE");
		}
		return jCheckBoxPacienteTHE;
	}

	/**
	 * This method initializes jCheckBoxPacienteCI	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPacienteCI() {
		if (jCheckBoxPacienteCI == null) {
			jCheckBoxPacienteCI = new JCheckBox();
			jCheckBoxPacienteCI.setBounds(new Rectangle(11, 47, 138, 26));
			jCheckBoxPacienteCI.setText("CI");
		}
		return jCheckBoxPacienteCI;
	}

	/**
	 * This method initializes jCheckBoxPacienteNombre	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPacienteNombre() {
		if (jCheckBoxPacienteNombre == null) {
			jCheckBoxPacienteNombre = new JCheckBox();
			jCheckBoxPacienteNombre.setBounds(new Rectangle(15, 88, 127, 28));
			jCheckBoxPacienteNombre.setText("Nombre");
		}
		return jCheckBoxPacienteNombre;
	}

	/**
	 * This method initializes jCheckBoxPacienteApellido	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPacienteApellido() {
		if (jCheckBoxPacienteApellido == null) {
			jCheckBoxPacienteApellido = new JCheckBox();
			jCheckBoxPacienteApellido.setBounds(new Rectangle(13, 137, 136, 30));
			jCheckBoxPacienteApellido.setText("Apellido");
		}
		return jCheckBoxPacienteApellido;
	}

	/**
	 * This method initializes jCheckBoxPacienteNumFnr	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPacienteNumFnr() {
		if (jCheckBoxPacienteNumFnr == null) {
			jCheckBoxPacienteNumFnr = new JCheckBox();
			jCheckBoxPacienteNumFnr.setBounds(new Rectangle(13, 181, 140, 29));
			jCheckBoxPacienteNumFnr.setText("Numero de FNR");
		}
		return jCheckBoxPacienteNumFnr;
	}

	/**
	 * This method initializes jCheckBoxPacienteRaza	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPacienteRaza() {
		if (jCheckBoxPacienteRaza == null) {
			jCheckBoxPacienteRaza = new JCheckBox();
			jCheckBoxPacienteRaza.setBounds(new Rectangle(13, 226, 144, 32));
			jCheckBoxPacienteRaza.setText("Raza");
		}
		return jCheckBoxPacienteRaza;
	}

	/**
	 * This method initializes jCheckBoxPacienteSexo	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPacienteSexo() {
		if (jCheckBoxPacienteSexo == null) {
			jCheckBoxPacienteSexo = new JCheckBox();
			jCheckBoxPacienteSexo.setBounds(new Rectangle(254, 9, 149, 34));
			jCheckBoxPacienteSexo.setText("Sexo");
		}
		return jCheckBoxPacienteSexo;
	}

	/**
	 * This method initializes jCheckBoxPacienteFechaNacimiento	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPacienteFechaNacimiento() {
		if (jCheckBoxPacienteFechaNacimiento == null) {
			jCheckBoxPacienteFechaNacimiento = new JCheckBox();
			jCheckBoxPacienteFechaNacimiento.setBounds(new Rectangle(252, 72, 155, 30));
			jCheckBoxPacienteFechaNacimiento.setText("Fecha de Nacimiento");
		}
		return jCheckBoxPacienteFechaNacimiento;
	}

	/**
	 * This method initializes jCheckBoxPacienteFechaDialisis	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPacienteFechaDialisis() {
		if (jCheckBoxPacienteFechaDialisis == null) {
			jCheckBoxPacienteFechaDialisis = new JCheckBox();
			jCheckBoxPacienteFechaDialisis.setBounds(new Rectangle(250, 124, 160, 41));
			jCheckBoxPacienteFechaDialisis.setText("Fecha de Dialisis");
		}
		return jCheckBoxPacienteFechaDialisis;
	}

	/**
	 * This method initializes jCheckBoxPacienteNefropatia	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPacienteNefropatia() {
		if (jCheckBoxPacienteNefropatia == null) {
			jCheckBoxPacienteNefropatia = new JCheckBox();
			jCheckBoxPacienteNefropatia.setBounds(new Rectangle(248, 178, 164, 40));
			jCheckBoxPacienteNefropatia.setText("Nefropatia");
		}
		return jCheckBoxPacienteNefropatia;
	}

	/**
	 * This method initializes jCheckBoxPacienteGrupoSanguineo	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPacienteGrupoSanguineo() {
		if (jCheckBoxPacienteGrupoSanguineo == null) {
			jCheckBoxPacienteGrupoSanguineo = new JCheckBox();
			jCheckBoxPacienteGrupoSanguineo.setBounds(new Rectangle(246, 235, 171, 40));
			jCheckBoxPacienteGrupoSanguineo.setText("Grupo Sanguineo");
		}
		return jCheckBoxPacienteGrupoSanguineo;
	}

	/**
	 * This method initializes jMenuEjecutar	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuEjecutar() {
		if (jMenuEjecutar == null) {
			jMenuEjecutar = new JMenu();
			jMenuEjecutar.setText("Crear Sentencia");
			jMenuEjecutar.add(getJMenuItemSinCondiciones());
			jMenuEjecutar.add(getJMenuItemConCondiciones());
		}
		return jMenuEjecutar;
	}

	/**
	 * This method initializes jMenuItemSinCondiciones	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemSinCondiciones() {
		if (jMenuItemSinCondiciones == null) {
			jMenuItemSinCondiciones = new JMenuItem();
			jMenuItemSinCondiciones.setText("Sin condiciones");
			jMenuItemSinCondiciones.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					generarSinCondiciones();
				}
			});
		}
		return jMenuItemSinCondiciones;
	}

	
	private void generarSinCondiciones(){
		ArrayList<String> atFinales = new ArrayList<String>();
		generarPaciente(atFinales);
		generarPreTrasplante(atFinales);
		generarMuertePaciente(atFinales);
		generarPerdidaInjerto(atFinales);
		generarTrasplante(atFinales);
		generarDonante(atFinales);
		generarReoperacion(atFinales);
		uniones();
		String sentencia = "SELECT ";
		for(int x=0;x<atFinales.size();x++){
			if(x!=0){
				sentencia += ", ";
			}
			sentencia += atFinales.get(x);
		}
		sentencia += " FROM ";
		for(int x=0;x < this.tablasUsadas.size();x++){
			if(x!=0){
				sentencia += ", ";
			}
			sentencia += this.tablasUsadas.get(x);	
		}
		if (this.junturas.size()>0){
			sentencia += " WHERE ";
			for(int x=0;x<this.junturas.size();x++){
				if(x !=0){
					sentencia += " AND ";
				}
				sentencia += this.junturas.get(x);
			}
		}
		Consola.println(sentencia);
	}
	private ArrayList<String> cosasPaciente = new ArrayList<String>();  //  @jve:decl-index=0:
	private ArrayList<String> tablasUsadas = new ArrayList<String>();  //  @jve:decl-index=0:
	private ArrayList<String> junturas = new ArrayList<String>();  //  @jve:decl-index=0:
	private JInternalFrame jInternalFramePreTrasplante = null;
	private JPanel jContentPanePreTrasplante = null;
	private JCheckBox jCheckBoxPreTrasplanteFechaIngreso = null;
	private JCheckBox jCheckBoxPreTrasplanteFechaEgreso = null;
	private JCheckBox jCheckBoxPreTrasplanteModalidadDialisis = null;
	private JCheckBox jCheckBoxPreTrasplantePBR = null;
	private JCheckBox jCheckBoxPreTrasplanteDiabetes = null;
	private JCheckBox jCheckBoxPreTrasplanteHTA = null;
	private JCheckBox jCheckBoxPreTrasplanteObesidad = null;
	private JCheckBox jCheckBoxPreTrasplanteIMC = null;
	private JCheckBox jCheckBoxPreTrasplanteDislipemia = null;
	private JCheckBox jCheckBoxPreTrasplanteTabaquismo = null;
	private JCheckBox jCheckBoxPreTrasplanteOrigen = null;
	
	private void generarPaciente(ArrayList<String> atFinales){
		ClasesConsulta clasePaciente = this.procesamiento.crearTablaPaciente();
		if(this.getJCheckBoxPacienteTHE().isSelected()) clasePaciente.getSeleccionados().add("A.THE");
		if(this.getJCheckBoxPacienteCI().isSelected()) clasePaciente.getSeleccionados().add("A.CI");
		if(this.getJCheckBoxPacienteNumFnr().isSelected()) clasePaciente.getSeleccionados().add("A.NUM_FNR");
		if(this.getJCheckBoxPacienteNombre().isSelected()) clasePaciente.getSeleccionados().add("A.Nombre");
		if(this.getJCheckBoxPacienteApellido().isSelected())clasePaciente.getSeleccionados().add("A.Apellido");
		if(this.getJCheckBoxPacienteFechaDialisis().isSelected()) clasePaciente.getSeleccionados().add("A.FECHA_DIALISIS");
		if(this.getJCheckBoxPacienteFechaNacimiento().isSelected()) clasePaciente.getSeleccionados().add("A.FECHA_NACIMIENTO");
		if(this.getJCheckBoxPacienteGrupoSanguineo().isSelected()) clasePaciente.getSeleccionados().add("A.GRUPO_SANG");
		if(this.getJCheckBoxPacienteRaza().isSelected()) clasePaciente.getSeleccionados().add("A.Raza");
		if(this.getJCheckBoxPacienteSexo().isSelected()) clasePaciente.getSeleccionados().add("A.Sexo");
		
		
		if(this.getJCheckBoxPacienteNefropatia().isSelected()){
			ClasesConsulta claseNefropatia = this.procesamiento.crearTablaNefropatia();
			claseNefropatia.getSeleccionados().add("ClasesConsulta");
			this.procesamiento.agregarClase(claseNefropatia);
		}
		if(clasePaciente.getSeleccionados().size()>0){
			this.procesamiento.agregarClase(clasePaciente);
		}
	}
	
	private void uniones(){
		TrasplanteReoperacion();
		this.TrasplantePacienteGlobal();

	}
	private void TrasplanteReoperacion(){
		if(this.cosasReoperacion.size()>0){
			if(this.cosasPaciente.size()>0 || this.cosasMuertePaciente.size()>0 || this.cosasPerdidaTrasplante.size()>0){
				if(!this.junturas.contains("A.THE = E.THE"))this.junturas.add("A.THE = E.THE");
				if(!this.junturas.contains("H.PreTrasplante = E.ID"))this.junturas.add("H.PreTrasplante = E.ID");
				if(!this.junturas.contains("H.ID = K.id_trasplante"))this.junturas.add("H.ID = K.id_trasplante");
				if(!this.tablasUsadas.contains("pacientes A")) this.tablasUsadas.add("pacientes A");
				if(!this.tablasUsadas.contains("pacientepretrasplante E")) this.tablasUsadas.add("pacientepretrasplante E");
				if(!this.tablasUsadas.contains("trasplante H")) this.tablasUsadas.add("trasplante H");
				if(this.cosasMuertePaciente.size()>0){
					if(!this.junturas.contains("A.THE = C.THE"))this.junturas.add("A.THE = C.THE");
					if(!this.tablasUsadas.contains("trasplante H")) this.tablasUsadas.add("trasplante H");
				}
				if(this.cosasPerdidaTrasplante.size()>0){
					if(!this.junturas.contains("")) this.junturas.add("");
					if(!this.tablasUsadas.contains("trasplante H")) this.tablasUsadas.add("trasplante H");
				}
			}
		}
	}
	
	private void TrasplantePacienteGlobal(){
		this.TrasplantePaciente();
		this.PacientePerdidaInjerto();
		this.PacientePreTrasplante();
		this.PacienteMuerte();
	}
	
	
	
	private void TrasplantePaciente(){
		if(this.cosasTrasplante.size()>0){
			if(this.cosasPaciente.size()>0){
				this.junturas.add("H.PreTrasplante = E.ID");
				this.junturas.add("A.THE = E.THE");
				if(!this.tablasUsadas.contains("pacientepretrasplante E"))this.tablasUsadas.add("pacientepretrasplante E");
				if(this.cosasPerdidaTrasplante.size()>0){
					if(this.cosasPaciente.size()>0)this.junturas.add("A.THE = F.THE");
				}
				if(this.cosasPreTrasplante.size()>0 && this.cosasPaciente.size()>0) {
					this.junturas.add("A.THE = E.THE");
				}
				if(this.cosasMuertePaciente.size()>0 && this.cosasPaciente.size()>0) {
					this.junturas.add("A.THE = C.THE");
				}
			}
		}
	}
	private void PacientePerdidaInjerto(){
		if(this.cosasPerdidaTrasplante.size()>0){
			if(this.cosasPaciente.size()>0){
				this.junturas.add("A.THE = F.THE");
			}
		}
	}
	private void PacientePreTrasplante(){
		if(this.cosasPreTrasplante.size()>0 && this.cosasPaciente.size()>0) {
			this.junturas.add("A.THE = E.THE");
		}
	}
	private void PacienteMuerte(){
		if(this.cosasMuertePaciente.size()>0 && this.cosasPaciente.size()>0) {
			this.junturas.add("A.THE = C.THE");
		}
	}
	/**
	 * This method initializes jMenuItemConCondiciones	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemConCondiciones() {
		if (jMenuItemConCondiciones == null) {
			jMenuItemConCondiciones = new JMenuItem();
			jMenuItemConCondiciones.setText("Con Condiciones");
		}
		return jMenuItemConCondiciones;
	}

	/**
	 * This method initializes jInternalFramePreTrasplante	
	 * 	
	 * @return javax.swing.JInternalFrame	
	 */
	private JInternalFrame getJInternalFramePreTrasplante() {
		if (jInternalFramePreTrasplante == null) {
			jInternalFramePreTrasplante = new JInternalFrame();
			jInternalFramePreTrasplante.setBounds(new Rectangle(26, 36, 561, 456));
			jInternalFramePreTrasplante.setContentPane(getJContentPanePreTrasplante());
			jInternalFramePreTrasplante.setTitle("PreTrasplante");
			jInternalFramePreTrasplante.setContentPane(getJContentPanePreTrasplante());
		}
		return jInternalFramePreTrasplante;
	}

	/**
	 * This method initializes jContentPanePreTrasplante	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPanePreTrasplante() {
		if (jContentPanePreTrasplante == null) {
			jContentPanePreTrasplante = new JPanel();
			jContentPanePreTrasplante.setLayout(null);
			jContentPanePreTrasplante.add(getJCheckBoxPreTrasplanteFechaIngreso(), null);
			jContentPanePreTrasplante.add(getJCheckBoxPreTrasplanteFechaEgreso(), null);
			jContentPanePreTrasplante.add(getJCheckBoxPreTrasplanteModalidadDialisis(), null);
			jContentPanePreTrasplante.add(getJCheckBoxPreTrasplantePBR(), null);
			jContentPanePreTrasplante.add(getJCheckBoxPreTrasplanteDiabetes(), null);
			jContentPanePreTrasplante.add(getJCheckBoxPreTrasplanteHTA(), null);
			jContentPanePreTrasplante.add(getJCheckBoxPreTrasplanteObesidad(), null);
			jContentPanePreTrasplante.add(getJCheckBoxPreTrasplanteIMC(), null);
			jContentPanePreTrasplante.add(getJCheckBoxPreTrasplanteDislipemia(), null);
			jContentPanePreTrasplante.add(getJCheckBoxPreTrasplanteTabaquismo(), null);
			jContentPanePreTrasplante.add(getJCheckBoxPreTrasplanteOrigen(), null);
		}
		return jContentPanePreTrasplante;
	}

	/**
	 * This method initializes jCheckBoxPreTrasplanteFechaIngreso	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPreTrasplanteFechaIngreso() {
		if (jCheckBoxPreTrasplanteFechaIngreso == null) {
			jCheckBoxPreTrasplanteFechaIngreso = new JCheckBox();
			jCheckBoxPreTrasplanteFechaIngreso.setBounds(new Rectangle(21, 18, 200, 30));
			jCheckBoxPreTrasplanteFechaIngreso.setText("Fecha de Ingreso a la lista");
		}
		return jCheckBoxPreTrasplanteFechaIngreso;
	}

	/**
	 * This method initializes jCheckBoxPreTrasplanteFechaEgreso	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPreTrasplanteFechaEgreso() {
		if (jCheckBoxPreTrasplanteFechaEgreso == null) {
			jCheckBoxPreTrasplanteFechaEgreso = new JCheckBox();
			jCheckBoxPreTrasplanteFechaEgreso.setBounds(new Rectangle(26, 66, 195, 39));
			jCheckBoxPreTrasplanteFechaEgreso.setText("Fecha de Egreso de la lista");
		}
		return jCheckBoxPreTrasplanteFechaEgreso;
	}

	/**
	 * This method initializes jCheckBoxPreTrasplanteModalidadDialisis	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPreTrasplanteModalidadDialisis() {
		if (jCheckBoxPreTrasplanteModalidadDialisis == null) {
			jCheckBoxPreTrasplanteModalidadDialisis = new JCheckBox();
			jCheckBoxPreTrasplanteModalidadDialisis.setBounds(new Rectangle(26, 118, 199, 38));
			jCheckBoxPreTrasplanteModalidadDialisis.setText("Modalidad de Dialisis");
		}
		return jCheckBoxPreTrasplanteModalidadDialisis;
	}

	/**
	 * This method initializes jCheckBoxPreTrasplantePBR	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPreTrasplantePBR() {
		if (jCheckBoxPreTrasplantePBR == null) {
			jCheckBoxPreTrasplantePBR = new JCheckBox();
			jCheckBoxPreTrasplantePBR.setBounds(new Rectangle(25, 170, 204, 30));
			jCheckBoxPreTrasplantePBR.setText("PBR");
		}
		return jCheckBoxPreTrasplantePBR;
	}

	/**
	 * This method initializes jCheckBoxPreTrasplanteDiabetes	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPreTrasplanteDiabetes() {
		if (jCheckBoxPreTrasplanteDiabetes == null) {
			jCheckBoxPreTrasplanteDiabetes = new JCheckBox();
			jCheckBoxPreTrasplanteDiabetes.setBounds(new Rectangle(24, 214, 208, 31));
			jCheckBoxPreTrasplanteDiabetes.setText("Diabetes");
		}
		return jCheckBoxPreTrasplanteDiabetes;
	}

	/**
	 * This method initializes jCheckBoxPreTrasplanteHTA	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPreTrasplanteHTA() {
		if (jCheckBoxPreTrasplanteHTA == null) {
			jCheckBoxPreTrasplanteHTA = new JCheckBox();
			jCheckBoxPreTrasplanteHTA.setBounds(new Rectangle(23, 258, 212, 33));
			jCheckBoxPreTrasplanteHTA.setText("HTA");
		}
		return jCheckBoxPreTrasplanteHTA;
	}

	/**
	 * This method initializes jCheckBoxPreTrasplanteObesidad	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPreTrasplanteObesidad() {
		if (jCheckBoxPreTrasplanteObesidad == null) {
			jCheckBoxPreTrasplanteObesidad = new JCheckBox();
			jCheckBoxPreTrasplanteObesidad.setBounds(new Rectangle(346, 17, 185, 34));
			jCheckBoxPreTrasplanteObesidad.setText("Obesidad");
		}
		return jCheckBoxPreTrasplanteObesidad;
	}

	/**
	 * This method initializes jCheckBoxPreTrasplanteIMC	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPreTrasplanteIMC() {
		if (jCheckBoxPreTrasplanteIMC == null) {
			jCheckBoxPreTrasplanteIMC = new JCheckBox();
			jCheckBoxPreTrasplanteIMC.setBounds(new Rectangle(342, 67, 193, 43));
			jCheckBoxPreTrasplanteIMC.setText("IMC");
		}
		return jCheckBoxPreTrasplanteIMC;
	}

	/**
	 * This method initializes jCheckBoxPreTrasplanteDislipemia	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPreTrasplanteDislipemia() {
		if (jCheckBoxPreTrasplanteDislipemia == null) {
			jCheckBoxPreTrasplanteDislipemia = new JCheckBox();
			jCheckBoxPreTrasplanteDislipemia.setBounds(new Rectangle(340, 127, 196, 41));
			jCheckBoxPreTrasplanteDislipemia.setText("Dislipemia");
		}
		return jCheckBoxPreTrasplanteDislipemia;
	}

	/**
	 * This method initializes jCheckBoxPreTrasplanteTabaquismo	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPreTrasplanteTabaquismo() {
		if (jCheckBoxPreTrasplanteTabaquismo == null) {
			jCheckBoxPreTrasplanteTabaquismo = new JCheckBox();
			jCheckBoxPreTrasplanteTabaquismo.setBounds(new Rectangle(339, 189, 200, 37));
			jCheckBoxPreTrasplanteTabaquismo.setText("Tabaquismo");
		}
		return jCheckBoxPreTrasplanteTabaquismo;
	}

	/**
	 * This method initializes jCheckBoxPreTrasplanteOrigen	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPreTrasplanteOrigen() {
		if (jCheckBoxPreTrasplanteOrigen == null) {
			jCheckBoxPreTrasplanteOrigen = new JCheckBox();
			jCheckBoxPreTrasplanteOrigen.setBounds(new Rectangle(335, 242, 208, 39));
			jCheckBoxPreTrasplanteOrigen.setText("Origen");
		}
		return jCheckBoxPreTrasplanteOrigen;
	}

	
	private ArrayList<String> cosasPreTrasplante = new ArrayList<String>();  //  @jve:decl-index=0:
	private JMenuItem jMenuItemPreTrasplante = null;
	private JInternalFrame jInternalFrameMuertePaciente = null;
	private JPanel jContentPaneMuertePaciente = null;
	private JCheckBox jCheckBoxMuertePacienteCausa = null;
	private JCheckBox jCheckBoxMuertePacienteFecha = null;
	private JCheckBox jCheckBoxMuertePacienteTRFuncionando = null;
	private void generarPreTrasplante(ArrayList<String> atFinales){
		if(this.jCheckBoxPreTrasplanteDiabetes.isSelected()) this.cosasPreTrasplante.add("E.diabetes");
		if(this.jCheckBoxPreTrasplanteDislipemia.isSelected()) this.cosasPreTrasplante.add("E.dislipemia");
		if(this.jCheckBoxPreTrasplanteFechaEgreso.isSelected()) this.cosasPreTrasplante.add("E.FECHA_EGRESO");
		if(this.jCheckBoxPreTrasplanteFechaIngreso.isSelected()) this.cosasPreTrasplante.add("E.FECHA_INGRESO_LISTA");
		if(this.jCheckBoxPreTrasplanteHTA.isSelected()) this.cosasPreTrasplante.add("E.hta");
		if(this.jCheckBoxPreTrasplanteIMC.isSelected()) this.cosasPreTrasplante.add("E.imc");
		if(this.jCheckBoxPreTrasplanteModalidadDialisis.isSelected()) this.cosasPreTrasplante.add("E.MODALIDAD_D");
		if(this.jCheckBoxPreTrasplanteObesidad.isSelected()) this.cosasPreTrasplante.add("E.obesidad");
		if(this.jCheckBoxPreTrasplanteOrigen.isSelected()) this.cosasPreTrasplante.add("E.Origen");
		if(this.jCheckBoxPreTrasplantePBR.isSelected()) this.cosasPreTrasplante.add("E.pbr");
		if(this.jCheckBoxPreTrasplanteTabaquismo.isSelected()) this.cosasPreTrasplante.add("E.tabaquismo");
		
		if(this.cosasPreTrasplante.size()>0) this.tablasUsadas.add("pacientepretrasplante E");
		for(int x = 0; x<this.cosasPreTrasplante.size();x++){
			atFinales.add(this.cosasPreTrasplante.get(x));
		}
	}

	/**
	 * This method initializes jMenuItemPreTrasplante	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemPreTrasplante() {
		if (jMenuItemPreTrasplante == null) {
			jMenuItemPreTrasplante = new JMenuItem();
			jMenuItemPreTrasplante.setText("PreTrasplante");
			jMenuItemPreTrasplante.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					mostrarPreTrasplante();
				}
			});
		}
		return jMenuItemPreTrasplante;
	}
	
	private void mostrarPreTrasplante(){
		this.jInternalFramePreTrasplante.setVisible(true);
		this.jInternalFramePacientes.setVisible(false);
		this.jInternalFrameMuertePaciente.setVisible(false);
		this.jInternalFramePerdidaInjerto.setVisible(false);
		this.jTabbedPane1.setVisible(false);
		this.jInternalFrameDonante.setVisible(false);
		this.jInternalFramerReoperacion.setVisible(false);
	}
	
	private void mostrarPacientes(){
		this.jInternalFramePacientes.setVisible(true);
		this.jInternalFramePreTrasplante.setVisible(false);
		this.jInternalFrameMuertePaciente.setVisible(false);
		this.jInternalFramePerdidaInjerto.setVisible(false);
		this.jTabbedPane1.setVisible(false);
		this.jInternalFrameDonante.setVisible(false);
		this.jInternalFramerReoperacion.setVisible(false);
	}

	private  void mostrarMuertePaciente(){
		this.jInternalFrameMuertePaciente.setVisible(true);
		this.jInternalFramePreTrasplante.setVisible(false);
		this.jInternalFramePacientes.setVisible(false);
		this.jInternalFramePerdidaInjerto.setVisible(false);
		this.jTabbedPane1.setVisible(false);
		this.jInternalFrameDonante.setVisible(false);
		this.jInternalFramerReoperacion.setVisible(false);
	}
	
	private void mostrarPerdidaInjerto(){
		this.jInternalFramePerdidaInjerto.setVisible(true);
		this.jInternalFrameMuertePaciente.setVisible(false);
		this.jInternalFramePreTrasplante.setVisible(false);
		this.jInternalFramePacientes.setVisible(false);
		this.jTabbedPane1.setVisible(false);
		this.jInternalFrameDonante.setVisible(false);
		this.jInternalFramerReoperacion.setVisible(false);
	}
	private void mostrarTrasplante(){
		this.jTabbedPane1.setVisible(true);
		this.jInternalFramePerdidaInjerto.setVisible(false);
		this.jInternalFrameMuertePaciente.setVisible(false);
		this.jInternalFramePreTrasplante.setVisible(false);
		this.jInternalFramePacientes.setVisible(false);
		this.jInternalFrameDonante.setVisible(false);
		this.jInternalFramerReoperacion.setVisible(false);
	}
	
	private void mostrarDonante(){
		this.jInternalFrameDonante.setVisible(true);
		this.jTabbedPane1.setVisible(false);
		this.jInternalFramePerdidaInjerto.setVisible(false);
		this.jInternalFrameMuertePaciente.setVisible(false);
		this.jInternalFramePreTrasplante.setVisible(false);
		this.jInternalFramePacientes.setVisible(false);
		this.jInternalFramerReoperacion.setVisible(false);
	}
	
	private void mostrarReoperacion(){
		this.jInternalFramerReoperacion.setVisible(true);
		this.jInternalFrameDonante.setVisible(false);
		this.jTabbedPane1.setVisible(false);
		this.jInternalFramePerdidaInjerto.setVisible(false);
		this.jInternalFrameMuertePaciente.setVisible(false);
		this.jInternalFramePreTrasplante.setVisible(false);
		this.jInternalFramePacientes.setVisible(false);
	}
	/**
	 * This method initializes jInternalFrameMuertePaciente	
	 * 	
	 * @return javax.swing.JInternalFrame	
	 */
	private JInternalFrame getJInternalFrameMuertePaciente() {
		if (jInternalFrameMuertePaciente == null) {
			jInternalFrameMuertePaciente = new JInternalFrame();
			jInternalFrameMuertePaciente.setBounds(new Rectangle(26, 36, 561, 456));
			jInternalFrameMuertePaciente.setTitle("Muerte Paciente");
			jInternalFrameMuertePaciente.setContentPane(getJContentPaneMuertePaciente());
		}
		return jInternalFrameMuertePaciente;
	}

	/**
	 * This method initializes jContentPaneMuertePaciente	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPaneMuertePaciente() {
		if (jContentPaneMuertePaciente == null) {
			jContentPaneMuertePaciente = new JPanel();
			jContentPaneMuertePaciente.setLayout(null);
			jContentPaneMuertePaciente.add(getJCheckBoxMuertePacienteCausa(), null);
			jContentPaneMuertePaciente.add(getJCheckBoxMuertePacienteFecha(), null);
			jContentPaneMuertePaciente.add(getJCheckBoxMuertePacienteTRFuncionando(), null);
		}
		return jContentPaneMuertePaciente;
	}

	/**
	 * This method initializes jCheckBoxMuertePacienteCausa	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxMuertePacienteCausa() {
		if (jCheckBoxMuertePacienteCausa == null) {
			jCheckBoxMuertePacienteCausa = new JCheckBox();
			jCheckBoxMuertePacienteCausa.setBounds(new Rectangle(21, 18, 200, 30));
			jCheckBoxMuertePacienteCausa.setText("Causa de muerte");
		}
		return jCheckBoxMuertePacienteCausa;
	}

	/**
	 * This method initializes jCheckBoxMuertePacienteFecha	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxMuertePacienteFecha() {
		if (jCheckBoxMuertePacienteFecha == null) {
			jCheckBoxMuertePacienteFecha = new JCheckBox();
			jCheckBoxMuertePacienteFecha.setBounds(new Rectangle(26, 66, 195, 39));
			jCheckBoxMuertePacienteFecha.setText("Fecha de Muerte");
		}
		return jCheckBoxMuertePacienteFecha;
	}

	/**
	 * This method initializes jCheckBoxMuertePacienteTRFuncionando	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxMuertePacienteTRFuncionando() {
		if (jCheckBoxMuertePacienteTRFuncionando == null) {
			jCheckBoxMuertePacienteTRFuncionando = new JCheckBox();
			jCheckBoxMuertePacienteTRFuncionando.setBounds(new Rectangle(26, 118, 199, 38));
			jCheckBoxMuertePacienteTRFuncionando.setText("Trasplante Funcionando");
		}
		return jCheckBoxMuertePacienteTRFuncionando;
	}
	
	private ArrayList<String> cosasMuertePaciente = new ArrayList<String>();
	private JMenuItem jMenuItemMuertePaciente = null;
	private JInternalFrame jInternalFramePerdidaInjerto = null;
	private JPanel jContentPanePerdidaInjerto = null;
	private JCheckBox jCheckBoxPerdidaInjertoCausa = null;
	private JCheckBox jCheckBoxPerdidaInjertoFecha = null;
	private void generarMuertePaciente(ArrayList<String> atFinales){
		if(this.jCheckBoxMuertePacienteFecha.isSelected()) this.cosasMuertePaciente.add("C.FECHA_MUERTE");
		if(this.jCheckBoxMuertePacienteTRFuncionando.isSelected()) this.cosasMuertePaciente.add("C.TR_Funcionando");
		if(this.jCheckBoxMuertePacienteCausa.isSelected()){
			this.cosasMuertePaciente.add("D.DETALLES Causa_Muerte");
			this.tablasUsadas.add("paciente_causa_muerte D");
			this.junturas.add("C.CAUSA = D.ID");
		}
		if(this.cosasMuertePaciente.size()>0) this.tablasUsadas.add("paciente_muerte C");
		for(int x = 0; x<this.cosasMuertePaciente.size();x++){
			atFinales.add(this.cosasMuertePaciente.get(x));
		}
	}

	/**
	 * This method initializes jMenuItemMuertePaciente	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemMuertePaciente() {
		if (jMenuItemMuertePaciente == null) {
			jMenuItemMuertePaciente = new JMenuItem();
			jMenuItemMuertePaciente.setText("Muerte del Paciente");
			jMenuItemMuertePaciente.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					mostrarMuertePaciente();
				}
			});
		}
		return jMenuItemMuertePaciente;
	}

	/**
	 * This method initializes jInternalFramePerdidaInjerto	
	 * 	
	 * @return javax.swing.JInternalFrame	
	 */
	private JInternalFrame getJInternalFramePerdidaInjerto() {
		if (jInternalFramePerdidaInjerto == null) {
			jInternalFramePerdidaInjerto = new JInternalFrame();
			jInternalFramePerdidaInjerto.setBounds(new Rectangle(26, 36, 561, 456));
			jInternalFramePerdidaInjerto.setContentPane(getJContentPanePerdidaInjerto());
			jInternalFramePerdidaInjerto.setTitle("Perdida del Injerto");
			jInternalFramePerdidaInjerto.setContentPane(getJContentPanePerdidaInjerto());
		}
		return jInternalFramePerdidaInjerto;
	}

	/**
	 * This method initializes jContentPanePerdidaInjerto	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPanePerdidaInjerto() {
		if (jContentPanePerdidaInjerto == null) {
			jContentPanePerdidaInjerto = new JPanel();
			jContentPanePerdidaInjerto.setLayout(null);
			jContentPanePerdidaInjerto.add(getJCheckBoxPerdidaInjertoCausa(), null);
			jContentPanePerdidaInjerto.add(getJCheckBoxPerdidaInjertoFecha(), null);
		}
		return jContentPanePerdidaInjerto;
	}

	/**
	 * This method initializes jCheckBoxPerdidaInjertoCausa	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPerdidaInjertoCausa() {
		if (jCheckBoxPerdidaInjertoCausa == null) {
			jCheckBoxPerdidaInjertoCausa = new JCheckBox();
			jCheckBoxPerdidaInjertoCausa.setBounds(new Rectangle(21, 18, 200, 30));
			jCheckBoxPerdidaInjertoCausa.setText("Causa de muerte");
		}
		return jCheckBoxPerdidaInjertoCausa;
	}

	/**
	 * This method initializes jCheckBoxPerdidaInjertoFecha	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPerdidaInjertoFecha() {
		if (jCheckBoxPerdidaInjertoFecha == null) {
			jCheckBoxPerdidaInjertoFecha = new JCheckBox();
			jCheckBoxPerdidaInjertoFecha.setBounds(new Rectangle(26, 66, 195, 39));
			jCheckBoxPerdidaInjertoFecha.setText("Fecha de Muerte");
		}
		return jCheckBoxPerdidaInjertoFecha;
	}
	
	private ArrayList<String> cosasPerdidaTrasplante = new ArrayList<String>();  //  @jve:decl-index=0:
	private JMenuItem jMenuItemPerdidaInjerto = null;
	private JTabbedPane jTabbedPane1 = null;
	private JInternalFrame jInternalFrameTrasplante = null;
	private JPanel jContentPaneTrasplante = null;
	private JCheckBox jCheckBoxTrasplanteFecha = null;
	private JCheckBox jCheckBoxTrasplanteNumTr = null;
	private JCheckBox jCheckBoxTrasplanteInestabHemo = null;
	private JCheckBox jCheckBoxTrasplanteRinhon = null;
	private JCheckBox jCheckBoxTrasplanteAnomVas = null;
	private JCheckBox jCheckBoxTrasplanteNumArt = null;
	private JCheckBox jCheckBoxTrasplanteNumVenas = null;
	private JCheckBox jCheckBoxTrasplanteUreter = null;
	private JCheckBox jCheckBoxTrasplanteNumCompAB = null;
	private JCheckBox jCheckBoxTrasplanteNumCompDr = null;
	private JCheckBox jCheckBoxTrasplanteNumIncompAB = null;
	private JInternalFrame jInternalFrameTrasplante2 = null;
	private JPanel jContentPaneTrasplante2 = null;
	private JCheckBox jCheckBoxTrasplanteNumIncomDr = null;
	private JCheckBox jCheckBoxTrasplanteAutoAc = null;
	private JCheckBox jCheckBoxTrasplantePRAMax = null;
	private JCheckBox jCheckBoxTrasplantePRA_TR = null;
	private JCheckBox jCheckBoxTrasplanteTRANS_PREVIAS = null;
	private JCheckBox jCheckBoxTrasplanteNUM_TRANSF = null;
	private JCheckBox jCheckBoxTrasplanteEMBARAZO = null;
	private JCheckBox jCheckBoxTrasplanteNUM_EMBARAZO = null;
	private JCheckBox jCheckBoxTrasplanteLIQ_PERFUSION = null;
	private JCheckBox jCheckBoxTrasplanteTQ_DE_BANCO = null;
	private JCheckBox jCheckBoxTrasplanteLADO_IMPLANTE = null;
	private JInternalFrame jInternalFrameTrasplante3 = null;
	private JPanel jContentPaneTrasplante3 = null;
	private JCheckBox jCheckBoxTrasplanteANAST_VENOSA = null;
	private JCheckBox jCheckBoxTrasplanteANAST_ARTERIAL = null;
	private JCheckBox jCheckBoxTrasplanteANAST_URETERAL = null;
	private JCheckBox jCheckBoxTrasplanteT_ISQ_CAL_MIN = null;
	private JCheckBox jCheckBoxTrasplanteT_ISQ_FRIA_HS = null;
	private JCheckBox jCheckBoxTrasplanteT_ISQ_FRIA_MIN = null;
	private JCheckBox jCheckBoxTrasplanteT_ISQ_TIBIA_HS = null;
	private JCheckBox jCheckBoxTrasplanteREPERCUSION = null;
	private JCheckBox jCheckBoxTrasplanteSANGRADO_I_OP = null;
	private JCheckBox jCheckBoxTrasplanteLESION_ARTERIAL = null;
	private JCheckBox jCheckBoxTrasplanteLESION_VENOSA = null;
	private JInternalFrame jInternalFrameTrasplante4 = null;
	private JPanel jContentPaneTrasplante4 = null;
	private JCheckBox jCheckBoxTrasplanteNECESIDAD_REPEFUNDIR = null;
	private JCheckBox jCheckBoxTrasplanteOTRAS_COMPL_QUIRUR = null;
	private JCheckBox jCheckBoxTrasplanteDIURESIS_I_OP = null;
	private JCheckBox jCheckBoxTrasplanteCR_INICIAL = null;
	private JCheckBox jCheckBoxTrasplanteDIA_REC_DIURESIS = null;
	private JCheckBox jCheckBoxTrasplanteDIA_REC_FUNCIONAL = null;
	private JCheckBox jCheckBoxTrasplanteDIALISIS = null;
	private JCheckBox jCheckBoxTrasplanteNUM_DE_HD = null;
	private JCheckBox jCheckBoxTrasplanteCOMENTARIO = null;
	
	private void generarPerdidaInjerto(ArrayList<String> atFinales){
		if(this.jCheckBoxPerdidaInjertoFecha.isSelected()) this.cosasPerdidaTrasplante.add("F.FECHA_PERDIDA");
		if(this.jCheckBoxPerdidaInjertoCausa.isSelected()){
			this.cosasPerdidaTrasplante.add("G.DETALLES causa_perdida");
			this.tablasUsadas.add("paciente_causa_perdida_injerto G");
			this.junturas.add("F.CAUSA = G.ID");
		}
				
		if(this.cosasPerdidaTrasplante.size()>0) this.tablasUsadas.add("paciente_perdida_injerto F");
		for(int x = 0; x<this.cosasPerdidaTrasplante.size();x++){
			atFinales.add(this.cosasPerdidaTrasplante.get(x));
		}
	}

	/**
	 * This method initializes jMenuItemPerdidaInjerto	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemPerdidaInjerto() {
		if (jMenuItemPerdidaInjerto == null) {
			jMenuItemPerdidaInjerto = new JMenuItem();
			jMenuItemPerdidaInjerto.setText("Perdida del injerto");
			jMenuItemPerdidaInjerto.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					mostrarPerdidaInjerto();
				}
			});
		}
		return jMenuItemPerdidaInjerto;
	}

	/**
	 * This method initializes jTabbedPane1	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane1() {
		if (jTabbedPane1 == null) {
			jTabbedPane1 = new JTabbedPane();
			jTabbedPane1.setBounds(new Rectangle(26, 36, 561, 456));
			jTabbedPane1.addTab("Datos 1", null, getJInternalFrameTrasplante(), null);
			jTabbedPane1.addTab("Datos 2", null, getJInternalFrameTrasplante2(), null);
			jTabbedPane1.addTab("Datos 3", null, getJInternalFrameTrasplante3(), null);
			jTabbedPane1.addTab("Datos 4", null, getJInternalFrameTrasplante4(), null);
		}
		return jTabbedPane1;
	}

	/**
	 * This method initializes jInternalFrameTrasplante	
	 * 	
	 * @return javax.swing.JInternalFrame	
	 */
	private JInternalFrame getJInternalFrameTrasplante() {
		if (jInternalFrameTrasplante == null) {
			jInternalFrameTrasplante = new JInternalFrame();
			jInternalFrameTrasplante.setBounds(new Rectangle(5, 5, 613, 351));
			jInternalFrameTrasplante.setContentPane(getJContentPaneTrasplante());
		}
		return jInternalFrameTrasplante;
	}

	/**
	 * This method initializes jContentPaneTrasplante	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPaneTrasplante() {
		if (jContentPaneTrasplante == null) {
			jContentPaneTrasplante = new JPanel();
			jContentPaneTrasplante.setLayout(null);
			jContentPaneTrasplante.add(getJCheckBoxTrasplanteFecha(), null);
			jContentPaneTrasplante.add(getJCheckBoxTrasplanteNumTr(), null);
			jContentPaneTrasplante.add(getJCheckBoxTrasplanteInestabHemo(), null);
			jContentPaneTrasplante.add(getJCheckBoxTrasplanteRinhon(), null);
			jContentPaneTrasplante.add(getJCheckBoxTrasplanteAnomVas(), null);
			jContentPaneTrasplante.add(getJCheckBoxTrasplanteNumArt(), null);
			jContentPaneTrasplante.add(getJCheckBoxTrasplanteNumVenas(), null);
			jContentPaneTrasplante.add(getJCheckBoxTrasplanteUreter(), null);
			jContentPaneTrasplante.add(getJCheckBoxTrasplanteNumCompAB(), null);
			jContentPaneTrasplante.add(getJCheckBoxTrasplanteNumCompDr(), null);
			jContentPaneTrasplante.add(getJCheckBoxTrasplanteNumIncompAB(), null);
		}
		return jContentPaneTrasplante;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteFecha	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteFecha() {
		if (jCheckBoxTrasplanteFecha == null) {
			jCheckBoxTrasplanteFecha = new JCheckBox();
			jCheckBoxTrasplanteFecha.setBounds(new Rectangle(8, 9, 200, 30));
			jCheckBoxTrasplanteFecha.setText("Fecha");
		}
		return jCheckBoxTrasplanteFecha;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteNumTr	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteNumTr() {
		if (jCheckBoxTrasplanteNumTr == null) {
			jCheckBoxTrasplanteNumTr = new JCheckBox();
			jCheckBoxTrasplanteNumTr.setBounds(new Rectangle(8, 55, 195, 39));
			jCheckBoxTrasplanteNumTr.setText("Numero Trasplante");
		}
		return jCheckBoxTrasplanteNumTr;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteInestabHemo	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteInestabHemo() {
		if (jCheckBoxTrasplanteInestabHemo == null) {
			jCheckBoxTrasplanteInestabHemo = new JCheckBox();
			jCheckBoxTrasplanteInestabHemo.setBounds(new Rectangle(11, 109, 199, 38));
			jCheckBoxTrasplanteInestabHemo.setText("Inastibilidad Hemodialisis");
		}
		return jCheckBoxTrasplanteInestabHemo;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteRinhon	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteRinhon() {
		if (jCheckBoxTrasplanteRinhon == null) {
			jCheckBoxTrasplanteRinhon = new JCheckBox();
			jCheckBoxTrasplanteRinhon.setBounds(new Rectangle(15, 163, 204, 30));
			jCheckBoxTrasplanteRinhon.setText("Rinon");
		}
		return jCheckBoxTrasplanteRinhon;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteAnomVas	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteAnomVas() {
		if (jCheckBoxTrasplanteAnomVas == null) {
			jCheckBoxTrasplanteAnomVas = new JCheckBox();
			jCheckBoxTrasplanteAnomVas.setBounds(new Rectangle(14, 202, 208, 31));
			jCheckBoxTrasplanteAnomVas.setText("Anomalia Vascular");
		}
		return jCheckBoxTrasplanteAnomVas;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteNumArt	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteNumArt() {
		if (jCheckBoxTrasplanteNumArt == null) {
			jCheckBoxTrasplanteNumArt = new JCheckBox();
			jCheckBoxTrasplanteNumArt.setBounds(new Rectangle(14, 249, 212, 33));
			jCheckBoxTrasplanteNumArt.setText("Numero de Arterias");
		}
		return jCheckBoxTrasplanteNumArt;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteNumVenas	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteNumVenas() {
		if (jCheckBoxTrasplanteNumVenas == null) {
			jCheckBoxTrasplanteNumVenas = new JCheckBox();
			jCheckBoxTrasplanteNumVenas.setBounds(new Rectangle(346, 17, 185, 34));
			jCheckBoxTrasplanteNumVenas.setText("Numero de Venas");
		}
		return jCheckBoxTrasplanteNumVenas;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteUreter	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteUreter() {
		if (jCheckBoxTrasplanteUreter == null) {
			jCheckBoxTrasplanteUreter = new JCheckBox();
			jCheckBoxTrasplanteUreter.setBounds(new Rectangle(342, 67, 193, 43));
			jCheckBoxTrasplanteUreter.setText("Ureter");
		}
		return jCheckBoxTrasplanteUreter;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteNumCompAB	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteNumCompAB() {
		if (jCheckBoxTrasplanteNumCompAB == null) {
			jCheckBoxTrasplanteNumCompAB = new JCheckBox();
			jCheckBoxTrasplanteNumCompAB.setBounds(new Rectangle(340, 127, 196, 41));
			jCheckBoxTrasplanteNumCompAB.setText("N# Compatibilidad A B");
		}
		return jCheckBoxTrasplanteNumCompAB;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteNumCompDr	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteNumCompDr() {
		if (jCheckBoxTrasplanteNumCompDr == null) {
			jCheckBoxTrasplanteNumCompDr = new JCheckBox();
			jCheckBoxTrasplanteNumCompDr.setBounds(new Rectangle(339, 189, 200, 37));
			jCheckBoxTrasplanteNumCompDr.setText("N# Compatibildad DR");
		}
		return jCheckBoxTrasplanteNumCompDr;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteNumIncompAB	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteNumIncompAB() {
		if (jCheckBoxTrasplanteNumIncompAB == null) {
			jCheckBoxTrasplanteNumIncompAB = new JCheckBox();
			jCheckBoxTrasplanteNumIncompAB.setBounds(new Rectangle(335, 242, 208, 39));
			jCheckBoxTrasplanteNumIncompAB.setText("N# Incompatibilidad A B");
		}
		return jCheckBoxTrasplanteNumIncompAB;
	}

	/**
	 * This method initializes jInternalFrameTrasplante2	
	 * 	
	 * @return javax.swing.JInternalFrame	
	 */
	private JInternalFrame getJInternalFrameTrasplante2() {
		if (jInternalFrameTrasplante2 == null) {
			jInternalFrameTrasplante2 = new JInternalFrame();
			jInternalFrameTrasplante2.setContentPane(getJContentPaneTrasplante2());
		}
		return jInternalFrameTrasplante2;
	}

	/**
	 * This method initializes jContentPaneTrasplante2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPaneTrasplante2() {
		if (jContentPaneTrasplante2 == null) {
			jContentPaneTrasplante2 = new JPanel();
			jContentPaneTrasplante2.setLayout(null);
			jContentPaneTrasplante2.add(getJCheckBoxTrasplanteNumIncomDr(), null);
			jContentPaneTrasplante2.add(getJCheckBoxTrasplanteAutoAc(), null);
			jContentPaneTrasplante2.add(getJCheckBoxTrasplantePRAMax(), null);
			jContentPaneTrasplante2.add(getJCheckBoxTrasplantePRA_TR(), null);
			jContentPaneTrasplante2.add(getJCheckBoxTrasplanteTRANS_PREVIAS(), null);
			jContentPaneTrasplante2.add(getJCheckBoxTrasplanteNUM_TRANSF(), null);
			jContentPaneTrasplante2.add(getJCheckBoxTrasplanteEMBARAZO(), null);
			jContentPaneTrasplante2.add(getJCheckBoxTrasplanteNUM_EMBARAZO(), null);
			jContentPaneTrasplante2.add(getJCheckBoxTrasplanteLIQ_PERFUSION(), null);
			jContentPaneTrasplante2.add(getJCheckBoxTrasplanteTQ_DE_BANCO(), null);
			jContentPaneTrasplante2.add(getJCheckBoxTrasplanteLADO_IMPLANTE(), null);
		}
		return jContentPaneTrasplante2;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteNumIncomDr	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteNumIncomDr() {
		if (jCheckBoxTrasplanteNumIncomDr == null) {
			jCheckBoxTrasplanteNumIncomDr = new JCheckBox();
			jCheckBoxTrasplanteNumIncomDr.setBounds(new Rectangle(8, 9, 200, 30));
			jCheckBoxTrasplanteNumIncomDr.setText("N# Incompatibilidad Dr");
		}
		return jCheckBoxTrasplanteNumIncomDr;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteAutoAc	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteAutoAc() {
		if (jCheckBoxTrasplanteAutoAc == null) {
			jCheckBoxTrasplanteAutoAc = new JCheckBox();
			jCheckBoxTrasplanteAutoAc.setBounds(new Rectangle(8, 55, 195, 39));
			jCheckBoxTrasplanteAutoAc.setText("AutoAc");
		}
		return jCheckBoxTrasplanteAutoAc;
	}

	/**
	 * This method initializes jCheckBoxTrasplantePRAMax	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplantePRAMax() {
		if (jCheckBoxTrasplantePRAMax == null) {
			jCheckBoxTrasplantePRAMax = new JCheckBox();
			jCheckBoxTrasplantePRAMax.setBounds(new Rectangle(11, 109, 199, 38));
			jCheckBoxTrasplantePRAMax.setText("PRA Maximo");
		}
		return jCheckBoxTrasplantePRAMax;
	}

	/**
	 * This method initializes jCheckBoxTrasplantePRA_TR	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplantePRA_TR() {
		if (jCheckBoxTrasplantePRA_TR == null) {
			jCheckBoxTrasplantePRA_TR = new JCheckBox();
			jCheckBoxTrasplantePRA_TR.setBounds(new Rectangle(15, 163, 204, 30));
			jCheckBoxTrasplantePRA_TR.setText("PRA Trasplante");
		}
		return jCheckBoxTrasplantePRA_TR;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteTRANS_PREVIAS	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteTRANS_PREVIAS() {
		if (jCheckBoxTrasplanteTRANS_PREVIAS == null) {
			jCheckBoxTrasplanteTRANS_PREVIAS = new JCheckBox();
			jCheckBoxTrasplanteTRANS_PREVIAS.setBounds(new Rectangle(14, 202, 208, 31));
			jCheckBoxTrasplanteTRANS_PREVIAS.setText("Tranferencias Previas");
		}
		return jCheckBoxTrasplanteTRANS_PREVIAS;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteNUM_TRANSF	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteNUM_TRANSF() {
		if (jCheckBoxTrasplanteNUM_TRANSF == null) {
			jCheckBoxTrasplanteNUM_TRANSF = new JCheckBox();
			jCheckBoxTrasplanteNUM_TRANSF.setBounds(new Rectangle(14, 249, 212, 33));
			jCheckBoxTrasplanteNUM_TRANSF.setText("N# de Tranfusiones");
		}
		return jCheckBoxTrasplanteNUM_TRANSF;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteEMBARAZO	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteEMBARAZO() {
		if (jCheckBoxTrasplanteEMBARAZO == null) {
			jCheckBoxTrasplanteEMBARAZO = new JCheckBox();
			jCheckBoxTrasplanteEMBARAZO.setBounds(new Rectangle(346, 17, 185, 34));
			jCheckBoxTrasplanteEMBARAZO.setText("Embarazo");
		}
		return jCheckBoxTrasplanteEMBARAZO;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteNUM_EMBARAZO	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteNUM_EMBARAZO() {
		if (jCheckBoxTrasplanteNUM_EMBARAZO == null) {
			jCheckBoxTrasplanteNUM_EMBARAZO = new JCheckBox();
			jCheckBoxTrasplanteNUM_EMBARAZO.setBounds(new Rectangle(342, 67, 193, 43));
			jCheckBoxTrasplanteNUM_EMBARAZO.setText("N# Embarazo");
		}
		return jCheckBoxTrasplanteNUM_EMBARAZO;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteLIQ_PERFUSION	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteLIQ_PERFUSION() {
		if (jCheckBoxTrasplanteLIQ_PERFUSION == null) {
			jCheckBoxTrasplanteLIQ_PERFUSION = new JCheckBox();
			jCheckBoxTrasplanteLIQ_PERFUSION.setBounds(new Rectangle(340, 127, 196, 41));
			jCheckBoxTrasplanteLIQ_PERFUSION.setText("Liquido de Perfusion");
		}
		return jCheckBoxTrasplanteLIQ_PERFUSION;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteTQ_DE_BANCO	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteTQ_DE_BANCO() {
		if (jCheckBoxTrasplanteTQ_DE_BANCO == null) {
			jCheckBoxTrasplanteTQ_DE_BANCO = new JCheckBox();
			jCheckBoxTrasplanteTQ_DE_BANCO.setBounds(new Rectangle(339, 189, 200, 37));
			jCheckBoxTrasplanteTQ_DE_BANCO.setText("TQ de Banco");
		}
		return jCheckBoxTrasplanteTQ_DE_BANCO;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteLADO_IMPLANTE	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteLADO_IMPLANTE() {
		if (jCheckBoxTrasplanteLADO_IMPLANTE == null) {
			jCheckBoxTrasplanteLADO_IMPLANTE = new JCheckBox();
			jCheckBoxTrasplanteLADO_IMPLANTE.setBounds(new Rectangle(335, 242, 208, 39));
			jCheckBoxTrasplanteLADO_IMPLANTE.setText("Lado del implante");
		}
		return jCheckBoxTrasplanteLADO_IMPLANTE;
	}

	/**
	 * This method initializes jInternalFrameTrasplante3	
	 * 	
	 * @return javax.swing.JInternalFrame	
	 */
	private JInternalFrame getJInternalFrameTrasplante3() {
		if (jInternalFrameTrasplante3 == null) {
			jInternalFrameTrasplante3 = new JInternalFrame();
			jInternalFrameTrasplante3.setTitle("Datos 3");
			jInternalFrameTrasplante3.setContentPane(getJContentPaneTrasplante3());
		}
		return jInternalFrameTrasplante3;
	}

	/**
	 * This method initializes jContentPaneTrasplante3	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPaneTrasplante3() {
		if (jContentPaneTrasplante3 == null) {
			jContentPaneTrasplante3 = new JPanel();
			jContentPaneTrasplante3.setLayout(null);
			jContentPaneTrasplante3.add(getJCheckBoxTrasplanteANAST_VENOSA(), null);
			jContentPaneTrasplante3.add(getJCheckBoxTrasplanteANAST_ARTERIAL(), null);
			jContentPaneTrasplante3.add(getJCheckBoxTrasplanteANAST_URETERAL(), null);
			jContentPaneTrasplante3.add(getJCheckBoxTrasplanteT_ISQ_CAL_MIN(), null);
			jContentPaneTrasplante3.add(getJCheckBoxTrasplanteT_ISQ_FRIA_HS(), null);
			jContentPaneTrasplante3.add(getJCheckBoxTrasplanteT_ISQ_FRIA_MIN(), null);
			jContentPaneTrasplante3.add(getJCheckBoxTrasplanteT_ISQ_TIBIA_HS(), null);
			jContentPaneTrasplante3.add(getJCheckBoxTrasplanteREPERCUSION(), null);
			jContentPaneTrasplante3.add(getJCheckBoxTrasplanteSANGRADO_I_OP(), null);
			jContentPaneTrasplante3.add(getJCheckBoxTrasplanteLESION_ARTERIAL(), null);
			jContentPaneTrasplante3.add(getJCheckBoxTrasplanteLESION_VENOSA(), null);
		}
		return jContentPaneTrasplante3;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteANAST_VENOSA	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteANAST_VENOSA() {
		if (jCheckBoxTrasplanteANAST_VENOSA == null) {
			jCheckBoxTrasplanteANAST_VENOSA = new JCheckBox();
			jCheckBoxTrasplanteANAST_VENOSA.setBounds(new Rectangle(8, 9, 200, 30));
			jCheckBoxTrasplanteANAST_VENOSA.setText("Anast Venosa");
		}
		return jCheckBoxTrasplanteANAST_VENOSA;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteANAST_ARTERIAL	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteANAST_ARTERIAL() {
		if (jCheckBoxTrasplanteANAST_ARTERIAL == null) {
			jCheckBoxTrasplanteANAST_ARTERIAL = new JCheckBox();
			jCheckBoxTrasplanteANAST_ARTERIAL.setBounds(new Rectangle(8, 55, 195, 39));
			jCheckBoxTrasplanteANAST_ARTERIAL.setText("Anast Arterial");
		}
		return jCheckBoxTrasplanteANAST_ARTERIAL;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteANAST_URETERAL	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteANAST_URETERAL() {
		if (jCheckBoxTrasplanteANAST_URETERAL == null) {
			jCheckBoxTrasplanteANAST_URETERAL = new JCheckBox();
			jCheckBoxTrasplanteANAST_URETERAL.setBounds(new Rectangle(11, 109, 199, 38));
			jCheckBoxTrasplanteANAST_URETERAL.setText("Anast Ureteral");
		}
		return jCheckBoxTrasplanteANAST_URETERAL;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteT_ISQ_CAL_MIN	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteT_ISQ_CAL_MIN() {
		if (jCheckBoxTrasplanteT_ISQ_CAL_MIN == null) {
			jCheckBoxTrasplanteT_ISQ_CAL_MIN = new JCheckBox();
			jCheckBoxTrasplanteT_ISQ_CAL_MIN.setBounds(new Rectangle(15, 163, 204, 30));
			jCheckBoxTrasplanteT_ISQ_CAL_MIN.setText("T Isq Calor Minuto");
		}
		return jCheckBoxTrasplanteT_ISQ_CAL_MIN;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteT_ISQ_FRIA_HS	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteT_ISQ_FRIA_HS() {
		if (jCheckBoxTrasplanteT_ISQ_FRIA_HS == null) {
			jCheckBoxTrasplanteT_ISQ_FRIA_HS = new JCheckBox();
			jCheckBoxTrasplanteT_ISQ_FRIA_HS.setBounds(new Rectangle(14, 202, 208, 31));
			jCheckBoxTrasplanteT_ISQ_FRIA_HS.setText("T Isq Fria Horas");
		}
		return jCheckBoxTrasplanteT_ISQ_FRIA_HS;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteT_ISQ_FRIA_MIN	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteT_ISQ_FRIA_MIN() {
		if (jCheckBoxTrasplanteT_ISQ_FRIA_MIN == null) {
			jCheckBoxTrasplanteT_ISQ_FRIA_MIN = new JCheckBox();
			jCheckBoxTrasplanteT_ISQ_FRIA_MIN.setBounds(new Rectangle(14, 249, 212, 33));
			jCheckBoxTrasplanteT_ISQ_FRIA_MIN.setText("T Isq Fria Minutos");
		}
		return jCheckBoxTrasplanteT_ISQ_FRIA_MIN;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteT_ISQ_TIBIA_HS	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteT_ISQ_TIBIA_HS() {
		if (jCheckBoxTrasplanteT_ISQ_TIBIA_HS == null) {
			jCheckBoxTrasplanteT_ISQ_TIBIA_HS = new JCheckBox();
			jCheckBoxTrasplanteT_ISQ_TIBIA_HS.setBounds(new Rectangle(346, 17, 185, 34));
			jCheckBoxTrasplanteT_ISQ_TIBIA_HS.setText("T Isq Tibia Horas");
		}
		return jCheckBoxTrasplanteT_ISQ_TIBIA_HS;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteREPERCUSION	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteREPERCUSION() {
		if (jCheckBoxTrasplanteREPERCUSION == null) {
			jCheckBoxTrasplanteREPERCUSION = new JCheckBox();
			jCheckBoxTrasplanteREPERCUSION.setBounds(new Rectangle(342, 67, 193, 43));
			jCheckBoxTrasplanteREPERCUSION.setText("Reperfusion");
		}
		return jCheckBoxTrasplanteREPERCUSION;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteSANGRADO_I_OP	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteSANGRADO_I_OP() {
		if (jCheckBoxTrasplanteSANGRADO_I_OP == null) {
			jCheckBoxTrasplanteSANGRADO_I_OP = new JCheckBox();
			jCheckBoxTrasplanteSANGRADO_I_OP.setBounds(new Rectangle(340, 127, 196, 41));
			jCheckBoxTrasplanteSANGRADO_I_OP.setText("Sangrado I Op");
		}
		return jCheckBoxTrasplanteSANGRADO_I_OP;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteLESION_ARTERIAL	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteLESION_ARTERIAL() {
		if (jCheckBoxTrasplanteLESION_ARTERIAL == null) {
			jCheckBoxTrasplanteLESION_ARTERIAL = new JCheckBox();
			jCheckBoxTrasplanteLESION_ARTERIAL.setBounds(new Rectangle(339, 189, 200, 37));
			jCheckBoxTrasplanteLESION_ARTERIAL.setText("Lesion Arterial");
		}
		return jCheckBoxTrasplanteLESION_ARTERIAL;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteLESION_VENOSA	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteLESION_VENOSA() {
		if (jCheckBoxTrasplanteLESION_VENOSA == null) {
			jCheckBoxTrasplanteLESION_VENOSA = new JCheckBox();
			jCheckBoxTrasplanteLESION_VENOSA.setBounds(new Rectangle(335, 242, 208, 39));
			jCheckBoxTrasplanteLESION_VENOSA.setText("Lesion Venosa");
		}
		return jCheckBoxTrasplanteLESION_VENOSA;
	}

	/**
	 * This method initializes jInternalFrameTrasplante4	
	 * 	
	 * @return javax.swing.JInternalFrame	
	 */
	private JInternalFrame getJInternalFrameTrasplante4() {
		if (jInternalFrameTrasplante4 == null) {
			jInternalFrameTrasplante4 = new JInternalFrame();
			jInternalFrameTrasplante4.setTitle("Datos 3");
			jInternalFrameTrasplante4.setContentPane(getJContentPaneTrasplante4());
		}
		return jInternalFrameTrasplante4;
	}

	/**
	 * This method initializes jContentPaneTrasplante4	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPaneTrasplante4() {
		if (jContentPaneTrasplante4 == null) {
			jContentPaneTrasplante4 = new JPanel();
			jContentPaneTrasplante4.setLayout(null);
			jContentPaneTrasplante4.add(getJCheckBoxTrasplanteNECESIDAD_REPEFUNDIR(), null);
			jContentPaneTrasplante4.add(getJCheckBoxTrasplanteOTRAS_COMPL_QUIRUR(), null);
			jContentPaneTrasplante4.add(getJCheckBoxTrasplanteDIURESIS_I_OP(), null);
			jContentPaneTrasplante4.add(getJCheckBoxTrasplanteCR_INICIAL(), null);
			jContentPaneTrasplante4.add(getJCheckBoxTrasplanteDIA_REC_DIURESIS(), null);
			jContentPaneTrasplante4.add(getJCheckBoxTrasplanteDIA_REC_FUNCIONAL(), null);
			jContentPaneTrasplante4.add(getJCheckBoxTrasplanteDIALISIS(), null);
			jContentPaneTrasplante4.add(getJCheckBoxTrasplanteNUM_DE_HD(), null);
			jContentPaneTrasplante4.add(getJCheckBoxTrasplanteCOMENTARIO(), null);
		}
		return jContentPaneTrasplante4;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteNECESIDAD_REPEFUNDIR	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteNECESIDAD_REPEFUNDIR() {
		if (jCheckBoxTrasplanteNECESIDAD_REPEFUNDIR == null) {
			jCheckBoxTrasplanteNECESIDAD_REPEFUNDIR = new JCheckBox();
			jCheckBoxTrasplanteNECESIDAD_REPEFUNDIR.setBounds(new Rectangle(8, 9, 200, 30));
			jCheckBoxTrasplanteNECESIDAD_REPEFUNDIR.setText("Necesidad de Repefundir");
		}
		return jCheckBoxTrasplanteNECESIDAD_REPEFUNDIR;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteOTRAS_COMPL_QUIRUR	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteOTRAS_COMPL_QUIRUR() {
		if (jCheckBoxTrasplanteOTRAS_COMPL_QUIRUR == null) {
			jCheckBoxTrasplanteOTRAS_COMPL_QUIRUR = new JCheckBox();
			jCheckBoxTrasplanteOTRAS_COMPL_QUIRUR.setBounds(new Rectangle(8, 55, 248, 39));
			jCheckBoxTrasplanteOTRAS_COMPL_QUIRUR.setText("Otras complicaciones Quirurgicas");
		}
		return jCheckBoxTrasplanteOTRAS_COMPL_QUIRUR;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteDIURESIS_I_OP	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteDIURESIS_I_OP() {
		if (jCheckBoxTrasplanteDIURESIS_I_OP == null) {
			jCheckBoxTrasplanteDIURESIS_I_OP = new JCheckBox();
			jCheckBoxTrasplanteDIURESIS_I_OP.setBounds(new Rectangle(11, 109, 199, 38));
			jCheckBoxTrasplanteDIURESIS_I_OP.setText("Diuresis I Op");
		}
		return jCheckBoxTrasplanteDIURESIS_I_OP;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteCR_INICIAL	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteCR_INICIAL() {
		if (jCheckBoxTrasplanteCR_INICIAL == null) {
			jCheckBoxTrasplanteCR_INICIAL = new JCheckBox();
			jCheckBoxTrasplanteCR_INICIAL.setBounds(new Rectangle(15, 163, 204, 30));
			jCheckBoxTrasplanteCR_INICIAL.setText("Cr Inicial");
		}
		return jCheckBoxTrasplanteCR_INICIAL;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteDIA_REC_DIURESIS	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteDIA_REC_DIURESIS() {
		if (jCheckBoxTrasplanteDIA_REC_DIURESIS == null) {
			jCheckBoxTrasplanteDIA_REC_DIURESIS = new JCheckBox();
			jCheckBoxTrasplanteDIA_REC_DIURESIS.setBounds(new Rectangle(14, 202, 227, 31));
			jCheckBoxTrasplanteDIA_REC_DIURESIS.setText("Dias de recuperacion de diuresis");
		}
		return jCheckBoxTrasplanteDIA_REC_DIURESIS;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteDIA_REC_FUNCIONAL	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteDIA_REC_FUNCIONAL() {
		if (jCheckBoxTrasplanteDIA_REC_FUNCIONAL == null) {
			jCheckBoxTrasplanteDIA_REC_FUNCIONAL = new JCheckBox();
			jCheckBoxTrasplanteDIA_REC_FUNCIONAL.setBounds(new Rectangle(14, 249, 212, 33));
			jCheckBoxTrasplanteDIA_REC_FUNCIONAL.setText("Dias de recuperacion funcional");
		}
		return jCheckBoxTrasplanteDIA_REC_FUNCIONAL;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteDIALISIS	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteDIALISIS() {
		if (jCheckBoxTrasplanteDIALISIS == null) {
			jCheckBoxTrasplanteDIALISIS = new JCheckBox();
			jCheckBoxTrasplanteDIALISIS.setBounds(new Rectangle(346, 17, 185, 34));
			jCheckBoxTrasplanteDIALISIS.setText("Dialisis");
		}
		return jCheckBoxTrasplanteDIALISIS;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteNUM_DE_HD	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteNUM_DE_HD() {
		if (jCheckBoxTrasplanteNUM_DE_HD == null) {
			jCheckBoxTrasplanteNUM_DE_HD = new JCheckBox();
			jCheckBoxTrasplanteNUM_DE_HD.setBounds(new Rectangle(342, 67, 193, 43));
			jCheckBoxTrasplanteNUM_DE_HD.setText("N# de Hemo Dialisis");
		}
		return jCheckBoxTrasplanteNUM_DE_HD;
	}

	/**
	 * This method initializes jCheckBoxTrasplanteCOMENTARIO	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTrasplanteCOMENTARIO() {
		if (jCheckBoxTrasplanteCOMENTARIO == null) {
			jCheckBoxTrasplanteCOMENTARIO = new JCheckBox();
			jCheckBoxTrasplanteCOMENTARIO.setBounds(new Rectangle(340, 127, 196, 41));
			jCheckBoxTrasplanteCOMENTARIO.setText("Comentario");
		}
		return jCheckBoxTrasplanteCOMENTARIO;
	}
	
	private ArrayList<String> cosasTrasplante = new ArrayList<String>();
	private JMenuItem jMenuItemTrasplante = null;
	private JInternalFrame jInternalFrameDonante = null;
	private JPanel jContentPaneDonante = null;
	private JCheckBox jCheckBoxDonanteId = null;
	private JCheckBox jCheckBoxDonanteTipo = null;
	private JCheckBox jCheckBoxDonanteSexo = null;
	private JCheckBox jCheckBoxDonanteEdad = null;
	private JCheckBox jCheckBoxDonanteEnastHemo = null;
	private JCheckBox jCheckBoxDonanteCausaMuerte = null;
	private JCheckBox jCheckBoxDonanteCrP = null;
	private JCheckBox jCheckBoxDonanteOtros = null;
	private JCheckBox jCheckBoxDonanteGrupoSang = null;
	private JCheckBox jCheckBoxDonanteRelacionFiliar = null;
	private JCheckBox jCheckBoxDonantePeso = null;
	private JCheckBox jCheckBoxDonanteAltura = null;
	private JCheckBox jCheckBoxDonanteOrganos = null;
	private JCheckBox jCheckBoxDonanteAntecedentes = null;
	private JMenuItem jMenuItemDonante = null;
	
	private void generarTrasplante(ArrayList<String> atFinales){
		if(this.jCheckBoxTrasplanteFecha.isSelected()) this.cosasTrasplante.add("H.FECHA");
		if(this.jCheckBoxTrasplanteNumTr.isSelected()) this.cosasTrasplante.add("H.NUM_TR");
		if(this.jCheckBoxTrasplanteInestabHemo.isSelected()) this.cosasTrasplante.add("H.INESTAB_HEMOD");
		if(this.jCheckBoxTrasplanteRinhon.isSelected()) this.cosasTrasplante.add("H.RINHON");
		if(this.jCheckBoxTrasplanteAnomVas.isSelected()) this.cosasTrasplante.add("H.ANOMALIA_VASC");
		if(this.jCheckBoxTrasplanteNumArt.isSelected()) this.cosasTrasplante.add("H.NUM_ART");
		if(this.jCheckBoxTrasplanteNumVenas.isSelected()) this.cosasTrasplante.add("H.NUM_VENAS");
		if(this.jCheckBoxTrasplanteUreter.isSelected()) this.cosasTrasplante.add("H.URETER");
		if(this.jCheckBoxTrasplanteNumCompAB.isSelected()) this.cosasTrasplante.add("H.NUM_COMP_A_B");
		if(this.jCheckBoxTrasplanteNumCompDr.isSelected()) this.cosasTrasplante.add("H.NUM_COMP_DR");
		if(this.jCheckBoxTrasplanteNumIncompAB.isSelected()) this.cosasTrasplante.add("H.NUM_IMCOMP_A_B");
		if(this.jCheckBoxTrasplanteNumIncomDr.isSelected()) this.cosasTrasplante.add("H.NUM_IMCOMP_DR");
		if(this.jCheckBoxTrasplanteAutoAc.isSelected()) this.cosasTrasplante.add("H.AUTOAC");
		if(this.jCheckBoxTrasplantePRAMax.isSelected()) this.cosasTrasplante.add("H.PRA_MAX");
		if(this.jCheckBoxTrasplantePRA_TR.isSelected()) this.cosasTrasplante.add("H.PRA_TR");
		if(this.jCheckBoxTrasplanteTRANS_PREVIAS.isSelected()) this.cosasTrasplante.add("H.TRANS_PREVIAS");
		if(this.jCheckBoxTrasplanteNUM_TRANSF.isSelected()) this.cosasTrasplante.add("H.NUM_TRANSF");
		if(this.jCheckBoxTrasplanteEMBARAZO.isSelected()) this.cosasTrasplante.add("H.EMBARAZO");
		if(this.jCheckBoxTrasplanteNUM_EMBARAZO.isSelected()) this.cosasTrasplante.add("H.NUM_EMBARAZO");
		if(this.jCheckBoxTrasplanteLIQ_PERFUSION.isSelected()) this.cosasTrasplante.add("H.LIQ_PERFUSION");
		if(this.jCheckBoxTrasplanteTQ_DE_BANCO.isSelected()) this.cosasTrasplante.add("H.TQ_DE_BANCO");
		if(this.jCheckBoxTrasplanteLADO_IMPLANTE.isSelected()) this.cosasTrasplante.add("H.LADO_IMPLANTE");
		if(this.jCheckBoxTrasplanteANAST_VENOSA.isSelected()) this.cosasTrasplante.add("H.ANAST_VENOSA");
		if(this.jCheckBoxTrasplanteANAST_ARTERIAL.isSelected()) this.cosasTrasplante.add("H.ANAST_ARTERIAL");
		if(this.jCheckBoxTrasplanteANAST_URETERAL.isSelected()) this.cosasTrasplante.add("H.ANAST_URETERAL");
		if(this.jCheckBoxTrasplanteT_ISQ_CAL_MIN.isSelected()) this.cosasTrasplante.add("H.T_ISQ_CAL_MIN");
		if(this.jCheckBoxTrasplanteT_ISQ_FRIA_HS.isSelected()) this.cosasTrasplante.add("H.T_ISQ_FRIA_HS");
		if(this.jCheckBoxTrasplanteT_ISQ_FRIA_MIN.isSelected()) this.cosasTrasplante.add("H.T_ISQ_FRIA_MIN");
		if(this.jCheckBoxTrasplanteT_ISQ_TIBIA_HS.isSelected()) this.cosasTrasplante.add("H.T_ISQ_TIBIA_HS");
		if(this.jCheckBoxTrasplanteREPERCUSION.isSelected()) this.cosasTrasplante.add("H.REPERCUSION");
		if(this.jCheckBoxTrasplanteSANGRADO_I_OP.isSelected()) this.cosasTrasplante.add("H.SANGRADO_I_OP");
		if(this.jCheckBoxTrasplanteLESION_ARTERIAL.isSelected()) this.cosasTrasplante.add("H.LESION_ARTERIAL");
		if(this.jCheckBoxTrasplanteLESION_VENOSA.isSelected()) this.cosasTrasplante.add("H.LESION_VENOSA");
		if(this.jCheckBoxTrasplanteNECESIDAD_REPEFUNDIR.isSelected()) this.cosasTrasplante.add("H.NECESIDAD_REPEFUNDIR");
		if(this.jCheckBoxTrasplanteDIURESIS_I_OP.isSelected()) this.cosasTrasplante.add("H.DIURESIS_I_OP");
		if(this.jCheckBoxTrasplanteCR_INICIAL.isSelected()) this.cosasTrasplante.add("H.CR_INICIAL");
		if(this.jCheckBoxTrasplanteOTRAS_COMPL_QUIRUR.isSelected()) this.cosasTrasplante.add("H.OTRAS_COMPL_QUIRUR");
		if(this.jCheckBoxTrasplanteDIA_REC_DIURESIS.isSelected()) this.cosasTrasplante.add("H.DIA_REC_DIURESIS");
		if(this.jCheckBoxTrasplanteDIA_REC_FUNCIONAL.isSelected()) this.cosasTrasplante.add("H.DIA_REC_FUNCIONAL");
		if(this.jCheckBoxTrasplanteNUM_DE_HD.isSelected()) this.cosasTrasplante.add("H.NUM_DE_HD");
		if(this.jCheckBoxTrasplanteCOMENTARIO.isSelected()) this.cosasTrasplante.add("H.COMENTARIO");
		if(this.cosasTrasplante.size()>0) this.tablasUsadas.add("trasplante H");
		for(int x = 0; x<this.cosasTrasplante.size();x++){
			atFinales.add(this.cosasTrasplante.get(x));
		}
	}

	/**
	 * This method initializes jMenuItemTrasplante	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemTrasplante() {
		if (jMenuItemTrasplante == null) {
			jMenuItemTrasplante = new JMenuItem();
			jMenuItemTrasplante.setText("Trasplante");
			jMenuItemTrasplante.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					mostrarTrasplante();
				}
			});
		}
		return jMenuItemTrasplante;
	}

	/**
	 * This method initializes jInternalFrameDonante	
	 * 	
	 * @return javax.swing.JInternalFrame	
	 */
	private JInternalFrame getJInternalFrameDonante() {
		if (jInternalFrameDonante == null) {
			jInternalFrameDonante = new JInternalFrame();
			jInternalFrameDonante.setBounds(new Rectangle(26, 36, 561, 456));
			jInternalFrameDonante.setTitle("Donante");
			jInternalFrameDonante.setContentPane(getJContentPaneDonante());
		}
		return jInternalFrameDonante;
	}

	/**
	 * This method initializes jContentPaneDonante	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPaneDonante() {
		if (jContentPaneDonante == null) {
			jContentPaneDonante = new JPanel();
			jContentPaneDonante.setLayout(null);
			jContentPaneDonante.add(getJCheckBoxDonanteId(), null);
			jContentPaneDonante.add(getJCheckBoxDonanteTipo(), null);
			jContentPaneDonante.add(getJCheckBoxDonanteSexo(), null);
			jContentPaneDonante.add(getJCheckBoxDonanteEdad(), null);
			jContentPaneDonante.add(getJCheckBoxDonanteEnastHemo(), null);
			jContentPaneDonante.add(getJCheckBoxDonanteCausaMuerte(), null);
			jContentPaneDonante.add(getJCheckBoxDonanteCrP(), null);
			jContentPaneDonante.add(getJCheckBoxDonanteOtros(), null);
			jContentPaneDonante.add(getJCheckBoxDonanteGrupoSang(), null);
			jContentPaneDonante.add(getJCheckBoxDonanteRelacionFiliar(), null);
			jContentPaneDonante.add(getJCheckBoxDonantePeso(), null);
			jContentPaneDonante.add(getJCheckBoxDonanteAltura(), null);
			jContentPaneDonante.add(getJCheckBoxDonanteOrganos(), null);
			jContentPaneDonante.add(getJCheckBoxDonanteAntecedentes(), null);
		}
		return jContentPaneDonante;
	}

	/**
	 * This method initializes jCheckBoxDonanteId	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxDonanteId() {
		if (jCheckBoxDonanteId == null) {
			jCheckBoxDonanteId = new JCheckBox();
			jCheckBoxDonanteId.setBounds(new Rectangle(8, 9, 200, 30));
			jCheckBoxDonanteId.setText("ID");
		}
		return jCheckBoxDonanteId;
	}

	/**
	 * This method initializes jCheckBoxDonanteTipo	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxDonanteTipo() {
		if (jCheckBoxDonanteTipo == null) {
			jCheckBoxDonanteTipo = new JCheckBox();
			jCheckBoxDonanteTipo.setBounds(new Rectangle(8, 55, 195, 39));
			jCheckBoxDonanteTipo.setText("Tipo");
		}
		return jCheckBoxDonanteTipo;
	}

	/**
	 * This method initializes jCheckBoxDonanteSexo	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxDonanteSexo() {
		if (jCheckBoxDonanteSexo == null) {
			jCheckBoxDonanteSexo = new JCheckBox();
			jCheckBoxDonanteSexo.setBounds(new Rectangle(11, 109, 199, 38));
			jCheckBoxDonanteSexo.setText("Sexo");
		}
		return jCheckBoxDonanteSexo;
	}

	/**
	 * This method initializes jCheckBoxDonanteEdad	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxDonanteEdad() {
		if (jCheckBoxDonanteEdad == null) {
			jCheckBoxDonanteEdad = new JCheckBox();
			jCheckBoxDonanteEdad.setBounds(new Rectangle(15, 163, 204, 30));
			jCheckBoxDonanteEdad.setText("Edad");
		}
		return jCheckBoxDonanteEdad;
	}

	/**
	 * This method initializes jCheckBoxDonanteEnastHemo	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxDonanteEnastHemo() {
		if (jCheckBoxDonanteEnastHemo == null) {
			jCheckBoxDonanteEnastHemo = new JCheckBox();
			jCheckBoxDonanteEnastHemo.setBounds(new Rectangle(14, 202, 208, 31));
			jCheckBoxDonanteEnastHemo.setText("Enastibilidad Hemodialisis");
		}
		return jCheckBoxDonanteEnastHemo;
	}

	/**
	 * This method initializes jCheckBoxDonanteCausaMuerte	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxDonanteCausaMuerte() {
		if (jCheckBoxDonanteCausaMuerte == null) {
			jCheckBoxDonanteCausaMuerte = new JCheckBox();
			jCheckBoxDonanteCausaMuerte.setBounds(new Rectangle(14, 249, 212, 33));
			jCheckBoxDonanteCausaMuerte.setText("Causa de Muerte");
		}
		return jCheckBoxDonanteCausaMuerte;
	}

	/**
	 * This method initializes jCheckBoxDonanteCrP	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxDonanteCrP() {
		if (jCheckBoxDonanteCrP == null) {
			jCheckBoxDonanteCrP = new JCheckBox();
			jCheckBoxDonanteCrP.setBounds(new Rectangle(346, 17, 185, 34));
			jCheckBoxDonanteCrP.setText("Cr P");
		}
		return jCheckBoxDonanteCrP;
	}

	/**
	 * This method initializes jCheckBoxDonanteOtros	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxDonanteOtros() {
		if (jCheckBoxDonanteOtros == null) {
			jCheckBoxDonanteOtros = new JCheckBox();
			jCheckBoxDonanteOtros.setBounds(new Rectangle(342, 67, 193, 43));
			jCheckBoxDonanteOtros.setText("Otros");
		}
		return jCheckBoxDonanteOtros;
	}

	/**
	 * This method initializes jCheckBoxDonanteGrupoSang	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxDonanteGrupoSang() {
		if (jCheckBoxDonanteGrupoSang == null) {
			jCheckBoxDonanteGrupoSang = new JCheckBox();
			jCheckBoxDonanteGrupoSang.setBounds(new Rectangle(340, 127, 196, 41));
			jCheckBoxDonanteGrupoSang.setText("Grupo Sanguineo");
		}
		return jCheckBoxDonanteGrupoSang;
	}

	/**
	 * This method initializes jCheckBoxDonanteRelacionFiliar	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxDonanteRelacionFiliar() {
		if (jCheckBoxDonanteRelacionFiliar == null) {
			jCheckBoxDonanteRelacionFiliar = new JCheckBox();
			jCheckBoxDonanteRelacionFiliar.setBounds(new Rectangle(339, 189, 200, 37));
			jCheckBoxDonanteRelacionFiliar.setText("Relacion Filiar");
		}
		return jCheckBoxDonanteRelacionFiliar;
	}

	/**
	 * This method initializes jCheckBoxDonantePeso	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxDonantePeso() {
		if (jCheckBoxDonantePeso == null) {
			jCheckBoxDonantePeso = new JCheckBox();
			jCheckBoxDonantePeso.setBounds(new Rectangle(335, 242, 208, 39));
			jCheckBoxDonantePeso.setText("Peso");
		}
		return jCheckBoxDonantePeso;
	}

	/**
	 * This method initializes jCheckBoxDonanteAltura	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxDonanteAltura() {
		if (jCheckBoxDonanteAltura == null) {
			jCheckBoxDonanteAltura = new JCheckBox();
			jCheckBoxDonanteAltura.setBounds(new Rectangle(346, 298, 197, 47));
			jCheckBoxDonanteAltura.setText("Altura");
		}
		return jCheckBoxDonanteAltura;
	}

	/**
	 * This method initializes jCheckBoxDonanteOrganos	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxDonanteOrganos() {
		if (jCheckBoxDonanteOrganos == null) {
			jCheckBoxDonanteOrganos = new JCheckBox();
			jCheckBoxDonanteOrganos.setBounds(new Rectangle(24, 295, 205, 44));
			jCheckBoxDonanteOrganos.setText("Organos");
		}
		return jCheckBoxDonanteOrganos;
	}

	/**
	 * This method initializes jCheckBoxDonanteAntecedentes	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxDonanteAntecedentes() {
		if (jCheckBoxDonanteAntecedentes == null) {
			jCheckBoxDonanteAntecedentes = new JCheckBox();
			jCheckBoxDonanteAntecedentes.setBounds(new Rectangle(18, 361, 216, 46));
			jCheckBoxDonanteAntecedentes.setText("Antecedentes");
		}
		return jCheckBoxDonanteAntecedentes;
	}

	/**
	 * This method initializes jMenuItemDonante	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemDonante() {
		if (jMenuItemDonante == null) {
			jMenuItemDonante = new JMenuItem();
			jMenuItemDonante.setText("Donante");
			jMenuItemDonante.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					mostrarDonante();
				}
			});
		}
		return jMenuItemDonante;
	}
	
	private ArrayList<String> cosasDonante = new ArrayList<String>();
	private JInternalFrame jInternalFramerReoperacion = null;
	private JPanel jContentPaneReoperacion = null;
	private JCheckBox jCheckBoxReoperacionFecha = null;
	private JCheckBox jCheckBoxReoperacionDescripcion = null;
	
	private void generarDonante(ArrayList<String> atFinales){
		if(this.jCheckBoxDonanteId.isSelected()) this.cosasDonante.add("L.ID");
		if(this.jCheckBoxDonanteTipo.isSelected()) this.cosasDonante.add("L.TIPO_DONANTE");
		if(this.jCheckBoxDonanteSexo.isSelected()) this.cosasDonante.add("L.SEXO_DONANTE");
		if(this.jCheckBoxDonanteEdad.isSelected()) this.cosasDonante.add("L.EDAD_DONANTE");
		if(this.jCheckBoxDonanteEnastHemo.isSelected()) this.cosasDonante.add("L.ENASTAB_HEMOD");
		if(this.jCheckBoxDonanteCausaMuerte.isSelected()){
			this.tablasUsadas.add("donante_causa_muerte M");
			this.junturas.add("L.CAUSA_MUERTE_DONANTE = M.ID");
			this.cosasDonante.add("M.DETALLES");
		}
		if(this.jCheckBoxDonanteCrP.isSelected()) this.cosasDonante.add("L.CR_P");
		if(this.jCheckBoxDonanteOtros.isSelected()) this.cosasDonante.add("L.OTROS");
		if(this.jCheckBoxDonanteGrupoSang.isSelected()) this.cosasDonante.add("L.GRUPO_SANG");
		if(this.jCheckBoxDonanteRelacionFiliar.isSelected()) this.cosasDonante.add("L.RELACION_FILIAR");
		if(this.jCheckBoxDonantePeso.isSelected()) this.cosasDonante.add("L.PESO");
		if(this.jCheckBoxDonanteAltura.isSelected()) this.cosasDonante.add("L.ALTURA");
		if(this.jCheckBoxDonanteOrganos.isSelected()){
			this.tablasUsadas.add("donante_organos O");
			this.junturas.add("L.ID = O.ID_DONANTE");
			this.cosasDonante.add("O.ORGANO");
		}
		if(this.jCheckBoxDonanteAntecedentes.isSelected()){
			this.tablasUsadas.add("donante_antecedentes N");
			this.junturas.add("L.ID = N.ID");
			this.cosasDonante.add("N.DETALLES");
		}
		if(this.cosasDonante.size()>0) this.tablasUsadas.add("donante L");
		for(int x = 0; x<this.cosasDonante.size();x++){
			atFinales.add(this.cosasDonante.get(x));
		}
	}

	/**
	 * This method initializes jInternalFramerReoperacion	
	 * 	
	 * @return javax.swing.JInternalFrame	
	 */
	private JInternalFrame getJInternalFramerReoperacion() {
		if (jInternalFramerReoperacion == null) {
			jInternalFramerReoperacion = new JInternalFrame();
			jInternalFramerReoperacion.setBounds(new Rectangle(26, 36, 561, 456));
			jInternalFramerReoperacion.setContentPane(getJContentPaneReoperacion());
		}
		return jInternalFramerReoperacion;
	}

	/**
	 * This method initializes jContentPaneReoperacion	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPaneReoperacion() {
		if (jContentPaneReoperacion == null) {
			jContentPaneReoperacion = new JPanel();
			jContentPaneReoperacion.setLayout(null);
			jContentPaneReoperacion.add(getJCheckBoxReoperacionFecha(), null);
			jContentPaneReoperacion.add(getJCheckBoxReoperacionDescripcion(), null);
		}
		return jContentPaneReoperacion;
	}

	/**
	 * This method initializes jCheckBoxReoperacionFecha	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxReoperacionFecha() {
		if (jCheckBoxReoperacionFecha == null) {
			jCheckBoxReoperacionFecha = new JCheckBox();
			jCheckBoxReoperacionFecha.setBounds(new Rectangle(8, 9, 200, 30));
			jCheckBoxReoperacionFecha.setText("Fecha");
		}
		return jCheckBoxReoperacionFecha;
	}

	/**
	 * This method initializes jCheckBoxReoperacionDescripcion	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxReoperacionDescripcion() {
		if (jCheckBoxReoperacionDescripcion == null) {
			jCheckBoxReoperacionDescripcion = new JCheckBox();
			jCheckBoxReoperacionDescripcion.setBounds(new Rectangle(8, 55, 195, 39));
			jCheckBoxReoperacionDescripcion.setText("Descripcion");
		}
		return jCheckBoxReoperacionDescripcion;
	}
	
	private ArrayList<String> cosasReoperacion = new ArrayList<String>();
	private JMenuItem jMenuItemReoperaciones = null;
	private JButton jButtonImprimir = null;
	
	private void generarReoperacion(ArrayList<String> atFinales){
		if(this.jCheckBoxReoperacionFecha.isSelected()) this.cosasReoperacion.add("K.FECHA");
		if(this.jCheckBoxReoperacionDescripcion.isSelected()) this.cosasReoperacion.add("K.descripcion");
		
		if(this.cosasReoperacion.size()>0) this.tablasUsadas.add("trasplante_reoperacion K");
		for(int x = 0; x<this.cosasReoperacion.size();x++){
			atFinales.add(this.cosasReoperacion.get(x));
		}
	}

	/**
	 * This method initializes jMenuItemReoperaciones	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemReoperaciones() {
		if (jMenuItemReoperaciones == null) {
			jMenuItemReoperaciones = new JMenuItem();
			jMenuItemReoperaciones.setText("Reoperaciones");
			jMenuItemReoperaciones.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					mostrarReoperacion();
				}
			});
		}
		return jMenuItemReoperaciones;
	}

	/**
	 * This method initializes jButtonImprimir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonImprimir() {
		if (jButtonImprimir == null) {
			jButtonImprimir = new JButton();
			jButtonImprimir.setBounds(new Rectangle(453, 8, 95, 18));
			jButtonImprimir.setText("Imprimir");
			jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Imprimir();
				}
			});
		}
		return jButtonImprimir;
	}
	
	private void Imprimir(){
		PrintUtilities print = new PrintUtilities(this.jContentPacientes);
		print.print();
	}
}  //  @jve:decl-index=0:visual-constraint="298,-28"
