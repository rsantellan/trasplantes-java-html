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
import auxiliares.ModeloDatosListaDonantes;
import auxiliares.TableSorter;
import dominio.Donante;

public class IUDonanteSeleccionar extends JFrame implements java.util.Observer{

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPaneDonantes = null;
	private JTable jTableDonantes = null;

	private ArrayList<Donante> listaDonates = new ArrayList<Donante>();
	private Fachada instancia = Fachada.getInstancia();
	private JButton jButtonModificar = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonMasDatos = null;
	private JButton jButtonSalir = null;
	/**
	 * This is the default constructor
	 */
	public IUDonanteSeleccionar() {
		super();
		initialize();
		Fachada.getInstancia().agregarObservador(this);
		cargarDatos();
	}

	private void cargarDatos(){
		//Traigo todos los pacientes
		listaDonates = Fachada.getInstancia().obtenerTodosDonantesSolo();
		ModeloDatosListaDonantes md = new ModeloDatosListaDonantes(listaDonates);
		TableSorter sortPacientes = new TableSorter(md);
		this.jTableDonantes.setModel(sortPacientes);
		sortPacientes.addMouseListenerToHeaderInTable(this.getJTableDonantes());
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(817, 429);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Seleccionar Donante");
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
			jContentPane.add(getJScrollPaneDonantes(), null);
			jContentPane.add(getJButtonModificar(), null);
			jContentPane.add(getJButtonEliminar(), null);
			jContentPane.add(getJButtonMasDatos(), null);
			jContentPane.add(getJButtonSalir(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPaneDonantes	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneDonantes() {
		if (jScrollPaneDonantes == null) {
			jScrollPaneDonantes = new JScrollPane();
			jScrollPaneDonantes.setBounds(new Rectangle(18, 20, 616, 257));
			jScrollPaneDonantes.setViewportView(getJTableDonantes());
		}
		return jScrollPaneDonantes;
	}

	/**
	 * This method initializes jTableDonantes	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableDonantes() {
		if (jTableDonantes == null) {
			jTableDonantes = new JTable();
			jTableDonantes.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		return jTableDonantes;
	}

	public void update(Observable arg0, Object arg1) {
		Observable o = arg0;
		if(o==instancia){
			if(Fachada.getInstancia().getLugar() == Fachada.DONANTE){
				this.cargarDatos();
			}
		}
	}

	public void salir(){
		Fachada.getInstancia().EliminarObservador(this);
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
			jButtonModificar.setBounds(new Rectangle(650, 35, 126, 32));
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
			jButtonEliminar.setBounds(new Rectangle(650, 103, 126, 32));
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
	 * This method initializes jButtonMasDatos	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonMasDatos() {
		if (jButtonMasDatos == null) {
			jButtonMasDatos = new JButton();
			jButtonMasDatos.setBounds(new Rectangle(119, 331, 219, 33));
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
			jButtonSalir.setBounds(new Rectangle(647, 331, 126, 32));
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
		int fila  = this.jTableDonantes.getSelectedRow();
		if(fila<0) return;
		Donante d = this.listaDonates.get(fila);
		if(d != null){
			Donante modificar = new Donante(d);
			IUDonanteModificar iu = new IUDonanteModificar(modificar,false);
			iu.setVisible(true);
		}
	}
	
	private void mostrar(){
		int fila  = this.jTableDonantes.getSelectedRow();
		if(fila<0) return;
		Donante d = this.listaDonates.get(fila);
		if(d != null){
			IUDonanteModificar iu = new IUDonanteModificar(d,true);
			iu.setVisible(true);
		}
	}
	private void eliminar(){
		int fila  = this.jTableDonantes.getSelectedRow();
		if(fila<0) return;
		Donante d = this.listaDonates.get(fila);
		if(d != null){
			String respuesta = "";
			respuesta = JOptionPane.showInputDialog(this, "Est� a punto de eliminar a el donante : " + d.toString() + "\nEsto solo podra ser posible si no tiene un Trasplante asociado\n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
			if(respuesta==null)respuesta="No";
			if(respuesta.equalsIgnoreCase("Si")){
				if(Fachada.getInstancia().eliminarDonante(d)){
					JOptionPane.showMessageDialog(this,"Borrado con exito" , "Correcto", JOptionPane.PLAIN_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(this,"El donante pertenece a un trasplante" , "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
