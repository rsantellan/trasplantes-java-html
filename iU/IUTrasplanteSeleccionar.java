package iU;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import logica.Fachada;
import auxiliares.ModeloDatosListaTrasplante;
import auxiliares.TableSorter;
import dominio.Trasplante;

public class IUTrasplanteSeleccionar extends JFrame implements java.util.Observer{

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPaneTrasplante = null;
	private JTable jTableTrasplante = null;

	private ArrayList<Trasplante> listaTrasplantes = new ArrayList<Trasplante>();  //  @jve:decl-index=0:
	private Fachada instancia = Fachada.getInstancia();  //  @jve:decl-index=0:
	private JButton jButtonMasDatos = null;
	private JButton jButtonSalir = null;
	private JButton jButtonModificar = null;
	private JButton jButtonEliminar = null;
	/**
	 * This is the default constructor
	 */
	public IUTrasplanteSeleccionar() {
		super();
		initialize();
		Fachada.getInstancia().agregarObservador(this);
		cargarDatos();
	}

	private void cargarDatos(){
		//Traigo todos los pacientes
		listaTrasplantes = Fachada.getInstancia().obtenerTodosTrasplantesSeleccion();
		ModeloDatosListaTrasplante md = new ModeloDatosListaTrasplante(listaTrasplantes);
		TableSorter sortTrasplante = new TableSorter(md);
		this.jTableTrasplante.setModel(sortTrasplante);
		sortTrasplante.addMouseListenerToHeaderInTable(this.getJTableTrasplante());
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(686, 543);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Seleccionar Traplante");
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
			jContentPane.add(getJScrollPaneTrasplante(), null);
			jContentPane.add(getJButtonMasDatos(), null);
			jContentPane.add(getJButtonSalir(), null);
			jContentPane.add(getJButtonModificar(), null);
			jContentPane.add(getJButtonEliminar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPaneTrasplante	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneTrasplante() {
		if (jScrollPaneTrasplante == null) {
			jScrollPaneTrasplante = new JScrollPane();
			jScrollPaneTrasplante.setBounds(new Rectangle(33, 20, 443, 407));
			jScrollPaneTrasplante.setViewportView(getJTableTrasplante());
		}
		return jScrollPaneTrasplante;
	}

	/**
	 * This method initializes jTableTrasplante	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableTrasplante() {
		if (jTableTrasplante == null) {
			jTableTrasplante = new JTable();
			jTableTrasplante.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		return jTableTrasplante;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Observable o = arg0;
		if(o==instancia){
			this.cargarDatos();
		}
	}

	private void salir(){
		Fachada.getInstancia().EliminarObservador(this);
		this.dispose();
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
			jButtonSalir.setBounds(new Rectangle(499, 450, 126, 32));
			jButtonSalir.setText("Atras");
			jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salir();
				}
			});
		}
		return jButtonSalir;
	}
	
	
	private void mostrar(){
		int fila  = this.jTableTrasplante.getSelectedRow();
		if(fila<0) return;
		Trasplante t = this.listaTrasplantes.get(fila);
		if(t != null){
			/*IUTrasplanteManejar iuVer = new IUTrasplanteManejar(t,true);
			iuVer.setVisible(true);*/
		}
	}

	/**
	 * This method initializes jButtonModificar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonModificar() {
		if (jButtonModificar == null) {
			jButtonModificar = new JButton();
			jButtonModificar.setBounds(new Rectangle(516, 72, 134, 42));
			jButtonModificar.setText("Modificar");
			jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					modificarTrasplante();
				}
			});
		}
		return jButtonModificar;
	}
	
	private void modificarTrasplante(){
		int fila  = this.jTableTrasplante.getSelectedRow();
		if(fila<0) return;
		Trasplante t = this.listaTrasplantes.get(fila);
		if(t != null){
			//Trasplante modificar = new Trasplante(t);
			/*IUTrasplanteManejar iuModificar = new IUTrasplanteManejar(modificar,false);
			iuModificar.setVisible(true);*/
		}

	}

	/**
	 * This method initializes jButtonEliminar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonEliminar() {
		if (jButtonEliminar == null) {
			jButtonEliminar = new JButton();
			jButtonEliminar.setBounds(new Rectangle(516, 141, 134, 42));
			jButtonEliminar.setText("Eliminar");
			jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					eliminar();
				}
			});
		}
		return jButtonEliminar;
	}
	
	private void eliminar(){
		int fila  = this.jTableTrasplante.getSelectedRow();
		if(fila<0) return;
		Trasplante t = this.listaTrasplantes.get(fila);
		if(t != null){
			String respuesta = "";
			respuesta = JOptionPane.showInputDialog(this, "Está a punto de eliminar a el trasplante : " + t.toString() + "\nSe eliminarán todos los datos relacionados a el mismo.\n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
			if(respuesta==null)respuesta="No";
			if(respuesta.equalsIgnoreCase("Si")){
				t.leerTodosLosDatos();
				Fachada.getInstancia().eliminarTrasplante(t);
			}
		}
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
