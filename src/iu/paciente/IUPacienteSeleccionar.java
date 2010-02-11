package iu.paciente;

import iu.trasplante.IUTrasplanteEmpezar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import logica.Fachada;
import auxiliares.ModeloDatosListaPacientes;
import auxiliares.TableSorter;
import dominio.Paciente;
import dominio.PacientePreTrasplante;

public class IUPacienteSeleccionar extends JFrame implements java.util.Observer{

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPanePacientes = null;
	private JTable jTablePacientes = null;

	private ArrayList<Paciente> listaPacientes = new ArrayList<Paciente>();
	private JButton jButtonModificar = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonTransplante = null;
	private JButton jButtonMasDatos = null;
	private JButton jButtonSalir = null;
	private JButton jButtonMuerte = null;
	private JDesktopPane jDesktopPaneBuscar = null;
	private JLabel jLabelBuscar = null;
	private JTextField jTextFieldBuscar = null;
	private JButton jButtonBuscar = null;
	private JButton jButtonVerTodos = null;
	private JButton jButtonPerdida = null;
	private boolean todos = false;
	private JButton jButtonCrearVacio = null;
	private boolean inicio = true;
	/**
	 * This is the default constructor
	 */
	public IUPacienteSeleccionar() {
		super();
		initialize();
		Fachada.getInstancia().agregarObservador(this);
		this.todos();
		cargarDatos();
		inicio = false;
	}

	private void todos(){
		//Traigo todos los pacientes
		listaPacientes = Fachada.getInstancia().obtenerTodosPacientes();
	}
	private void cargarDatos(){
		ModeloDatosListaPacientes md = new ModeloDatosListaPacientes(listaPacientes);
		TableSorter sortPacientes = new TableSorter(md);
		this.jTablePacientes.setModel(sortPacientes);
		sortPacientes.addMouseListenerToHeaderInTable(this.getJTablePacientes());
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(903, 543);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Seleccionar Paciente");
		this.setLocationByPlatform(true);
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
			jContentPane.add(getJScrollPanePacientes(), null);
			jContentPane.add(getJButtonModificar(), null);
			jContentPane.add(getJButtonEliminar(), null);
			jContentPane.add(getJButtonTransplante(), null);
			jContentPane.add(getJButtonMasDatos(), null);
			jContentPane.add(getJButtonSalir(), null);
			jContentPane.add(getJButtonMuerte(), null);
			jContentPane.add(getJDesktopPaneBuscar(), null);
			jContentPane.add(getJButtonPerdida(), null);
			jContentPane.add(getJButtonCrearVacio(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPanePacientes	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPanePacientes() {
		if (jScrollPanePacientes == null) {
			jScrollPanePacientes = new JScrollPane();
			jScrollPanePacientes.setBounds(new Rectangle(33, 20, 528, 407));
			jScrollPanePacientes.setViewportView(getJTablePacientes());
		}
		return jScrollPanePacientes;
	}

	/**
	 * This method initializes jTablePacientes	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTablePacientes() {
		if (jTablePacientes == null) {
			jTablePacientes = new JTable();
			jTablePacientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		return jTablePacientes;
	}

	public void update(Observable arg0, Object arg1) {
		Observable o = arg0;
		if(o==Fachada.getInstancia()){
			if((Fachada.getInstancia().getLugar() == Fachada.PACIENTE) || inicio){
				if(todos) this.todos();
				this.todos = false;
				this.cargarDatos();
			}
		}
	}

	public void salir(){
		Fachada.getInstancia().eliminarObservador(this);
		this.dispose();
	}

	/**
	 * This method initializes jButtonModificar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonModificar() {
		if (jButtonModificar == null) {
			jButtonModificar = new JButton();
			jButtonModificar.setBounds(new Rectangle(595, 242, 126, 32));
			jButtonModificar.setText("Modificar");
			jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					modificar();
				}
			});
		}
		return jButtonModificar;
	}

	/**
	 * This method initializes jButtonEliminar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonEliminar() {
		if (jButtonEliminar == null) {
			jButtonEliminar = new JButton();
			jButtonEliminar.setBounds(new Rectangle(736, 242, 126, 32));
			jButtonEliminar.setText("Eliminar");
			jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					eliminar();
				}
			});
		}
		return jButtonEliminar;
	}

	/**
	 * This method initializes jButtonTransplante	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonTransplante() {
		if (jButtonTransplante == null) {
			jButtonTransplante = new JButton();
			jButtonTransplante.setBounds(new Rectangle(594, 307, 126, 32));
			jButtonTransplante.setText("Transplante");
			jButtonTransplante.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					trasplante();
				}
			});
		}
		return jButtonTransplante;
	}

	/**
	 * This method initializes jButtonMasDatos	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonMasDatos() {
		if (jButtonMasDatos == null) {
			jButtonMasDatos = new JButton();
			jButtonMasDatos.setBounds(new Rectangle(115, 444, 219, 33));
			jButtonMasDatos.setText("Ver todos los datos");
			jButtonMasDatos.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					mostrar();
				}
			});
		}
		return jButtonMasDatos;
	}

	/**
	 * This method initializes jButtonSalir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSalir() {
		if (jButtonSalir == null) {
			jButtonSalir = new JButton();
			jButtonSalir.setBounds(new Rectangle(715, 448, 126, 32));
			jButtonSalir.setText("Atras");
			jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salir();
				}
			});
		}
		return jButtonSalir;
	}
	
	private void modificar(){
		int fila  = this.jTablePacientes.getSelectedRow();
		if(fila<0) return;
		Paciente p = this.listaPacientes.get(fila);
		if(p != null){
			Paciente modificar = new Paciente(p);
			IUPacienteModificar iu = new IUPacienteModificar(modificar,false);
			iu.setVisible(true);
		}
	}
	
	private void mostrar(){
		int fila  = this.jTablePacientes.getSelectedRow();
		if(fila<0) return;
		Paciente p = this.listaPacientes.get(fila);
		if(p != null){
			IUPacienteModificar iu = new IUPacienteModificar(p,true);
			iu.setVisible(true);
		}
	}
	private void eliminar(){
		int fila  = this.jTablePacientes.getSelectedRow();
		if(fila<0) return;
		Paciente p = this.listaPacientes.get(fila);
		if(p != null){
			String respuesta = "";
			respuesta = JOptionPane.showInputDialog(this, "Est� a punto de eliminar a el paciente : " + p.toString() + "\nSe eliminar�n todos los datos relacionados a el mismo.\nPor un motivo de seguridad quedara vacio el n�mero THE que tenia el paciente\n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
			if(respuesta==null)respuesta="No";
			if(respuesta.equalsIgnoreCase("Si")){
				ArrayList<PacientePreTrasplante> salida = null;
				salida = Fachada.getInstancia().buscarPreTrasplantePaciente(p);
				boolean borrar = true;
				if(salida != null){
					respuesta = JOptionPane.showInputDialog(this, "El paciente : " + p.toString() + " Esta relacionado con un trasplante\nToda la informacion del trasplante tambien sera eliminada.\n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
					if(respuesta==null){
						respuesta="No";
						borrar = false;
					}
					if(!respuesta.equalsIgnoreCase("Si")){
						borrar = false;
					}else{
						p.setListaPreTrasplantes(salida);
						JOptionPane.showMessageDialog(this,
								"Los donantes relacionados con los trasplantes no van a ser eliminados.",
								"Atencion", 2);
					}
				}
				
				if(borrar){
					this.todos = true;
					Fachada.getInstancia().eliminarPaciente(p);
				}
			}
		}
	}

	/**
	 * This method initializes jButtonMuerte	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonMuerte() {
		if (jButtonMuerte == null) {
			jButtonMuerte = new JButton();
			jButtonMuerte.setBounds(new Rectangle(593, 367, 126, 32));
			jButtonMuerte.setText("Muerte");
			jButtonMuerte.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					verIngresarMuerte();
				}
			});
		}
		return jButtonMuerte;
	}
	
	private void verIngresarMuerte(){
		int fila  = this.jTablePacientes.getSelectedRow();
		if(fila<0) return;
		Paciente p = this.listaPacientes.get(fila);
		//p.leer();
		if(p != null){
			Paciente modificar = new Paciente(p);
			modificar.leerDatosMuerte();
			if(modificar.getMuertePaciente() == null){
				IUPacienteMuerteIngresar iuMuerte = new IUPacienteMuerteIngresar(modificar);
				iuMuerte.setVisible(true);
			}else{
				IUPacienteMuerteVer iuVerMuerte = new IUPacienteMuerteVer(modificar,true);
				iuVerMuerte.setVisible(true);
			}
			
		}
	}

	private void trasplante(){
		int fila  = this.jTablePacientes.getSelectedRow();
		if(fila<0) return;
		Paciente p = this.listaPacientes.get(fila);
		if(p != null){
			p.leerDatosPreTrasplante();
			IUTrasplanteEmpezar iuEmpezar =  new IUTrasplanteEmpezar(p);
			iuEmpezar.setVisible(true);
		}

	}

	/**
	 * This method initializes jDesktopPaneBuscar	
	 * 	
	 * @return javax.swing.JDesktopPane	
	 */
	private JDesktopPane getJDesktopPaneBuscar() {
		if (jDesktopPaneBuscar == null) {
			jLabelBuscar = new JLabel();
			jLabelBuscar.setBounds(new Rectangle(42, 9, 180, 35));
			jLabelBuscar.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelBuscar.setText("Buscar");
			jLabelBuscar.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
			jDesktopPaneBuscar = new JDesktopPane();
			jDesktopPaneBuscar.setBounds(new Rectangle(601, 22, 254, 172));
			jDesktopPaneBuscar.add(jLabelBuscar, null);
			jDesktopPaneBuscar.add(getJTextFieldBuscar(), null);
			jDesktopPaneBuscar.add(getJButtonBuscar(), null);
			jDesktopPaneBuscar.add(getJButtonVerTodos(), null);
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
			jTextFieldBuscar.setBounds(new Rectangle(18, 56, 215, 32));
		}
		return jTextFieldBuscar;
	}

	/**
	 * This method initializes jButtonBuscar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonBuscar() {
		if (jButtonBuscar == null) {
			jButtonBuscar = new JButton();
			jButtonBuscar.setBounds(new Rectangle(62, 98, 123, 27));
			jButtonBuscar.setText("Buscar");
			jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					buscar();
				}
			});
		}
		return jButtonBuscar;
	}

	/**
	 * This method initializes jButtonVerTodos	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonVerTodos() {
		if (jButtonVerTodos == null) {
			jButtonVerTodos = new JButton();
			jButtonVerTodos.setText("Todos");
			jButtonVerTodos.setBounds(new Rectangle(62, 130, 123, 27));
			jButtonVerTodos.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					mostrarTodos();
				}
			});
		}
		return jButtonVerTodos;
	}
	
	private void buscar(){
		if (!this.jTextFieldBuscar.getText().equalsIgnoreCase("")
				|| !this.jTextFieldBuscar.getText().equalsIgnoreCase(" ")) {
			Paciente aux = new Paciente();
			aux.setApellido(this.jTextFieldBuscar.getText());
			this.listaPacientes = aux.obtenerTodosSoloPaciente();
			
			this.cargarDatos();
		}
	}
	
	private void mostrarTodos(){
		this.todos();
		this.cargarDatos();
	}

	/**
	 * This method initializes jButtonPerdida	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonPerdida() {
		if (jButtonPerdida == null) {
			jButtonPerdida = new JButton();
			jButtonPerdida.setBounds(new Rectangle(736, 367, 126, 32));
			jButtonPerdida.setText("Perdida Injerto");
			jButtonPerdida.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ingresarPerdida();
				}
			});
		}
		return jButtonPerdida;
	}
	
	private void ingresarPerdida(){
		int fila  = this.jTablePacientes.getSelectedRow();
		if(fila<0) return;
		Paciente p = this.listaPacientes.get(fila);
		if(p != null){
			IUPacientePerdidaInjertoIngresar perdidaI = new IUPacientePerdidaInjertoIngresar(p);
			perdidaI.setVisible(true);
		}
	}

	/**
	 * This method initializes jButtonCrearVacio	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCrearVacio() {
		if (jButtonCrearVacio == null) {
			jButtonCrearVacio = new JButton();
			jButtonCrearVacio.setBounds(new Rectangle(738, 307, 126, 32));
			jButtonCrearVacio.setText("Crear Vacio");
			jButtonCrearVacio.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					crearVacio();
				}
			});
		}
		return jButtonCrearVacio;
	}
	
	private void crearVacio(){
		String respuesta = "";
		respuesta = JOptionPane.showInputDialog(this, "Est� a punto de crear un lugar vacio \nEsto puede realizarse para no perder la numeracion del THE\n(Ingrese SI para ingresar)", "Confirmar", 1);
		if(respuesta==null)respuesta="No";
		if(respuesta.equalsIgnoreCase("Si")){
			Fachada.getInstancia().crearPacienteDummie();
		}
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
