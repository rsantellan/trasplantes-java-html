package iu.datosfijos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import logica.Fachada;
import dominio.Serol;

public class IUManejarSerol extends JFrame implements java.util.Observer {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;

	private Fachada instancia = Fachada.getInstancia();
	private JScrollPane jScrollPaneCausaPerdidaInjerto = null;
	private JList jListCausaPerdidaInjerto = null;
	private JLabel jLabelTiposSerol = null;
	private JButton jButtonAgregar = null;
	private JButton jButtonModificar = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonAtras = null;
	
	private ArrayList<Serol> lista;  //  @jve:decl-index=0:
	private JButton jButtonModificarDatos = null;
	/**
	 * This is the default constructor
	 */
	public IUManejarSerol() {
		super();
		initialize();
		cargarDatos();
	}

	private void cargarDatos(){
		this.lista = Fachada.getInstancia().obtenerTodosLosSerol();
		this.jListCausaPerdidaInjerto.setListData(this.lista.toArray());
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(443, 370);
		this.setContentPane(getJContentPane());
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setTitle("Manejar Tipos de Serol");
		this.instancia.agregarObservador(this);
		this.setLocationByPlatform(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelTiposSerol = new JLabel();
			jLabelTiposSerol.setBounds(new Rectangle(60, 20, 146, 22));
			jLabelTiposSerol.setFont(new Font("Dialog", Font.BOLD, 18));
			jLabelTiposSerol.setText("Tipos de Serol");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(204, 255, 204));
			jContentPane.add(getJScrollPaneCausaPerdidaInjerto(), null);
			jContentPane.add(jLabelTiposSerol, null);
			jContentPane.add(getJButtonAgregar(), null);
			jContentPane.add(getJButtonModificar(), null);
			jContentPane.add(getJButtonEliminar(), null);
			jContentPane.add(getJButtonAtras(), null);
			jContentPane.add(getJButtonModificarDatos(), null);
		}
		return jContentPane;
	}

	public void update(Observable o, Object arg) {
		this.cargarDatos();
	}

	/**
	 * This method initializes jScrollPaneCausaPerdidaInjerto	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneCausaPerdidaInjerto() {
		if (jScrollPaneCausaPerdidaInjerto == null) {
			jScrollPaneCausaPerdidaInjerto = new JScrollPane();
			jScrollPaneCausaPerdidaInjerto.setBounds(new Rectangle(20, 51, 242, 253));
			jScrollPaneCausaPerdidaInjerto.setViewportView(getJListCausaPerdidaInjerto());
		}
		return jScrollPaneCausaPerdidaInjerto;
	}

	/**
	 * This method initializes jListCausaPerdidaInjerto	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJListCausaPerdidaInjerto() {
		if (jListCausaPerdidaInjerto == null) {
			jListCausaPerdidaInjerto = new JList();
		}
		return jListCausaPerdidaInjerto;
	}

	/**
	 * This method initializes jButtonAgregar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAgregar() {
		if (jButtonAgregar == null) {
			jButtonAgregar = new JButton();
			jButtonAgregar.setBounds(new Rectangle(281, 44, 123, 35));
			jButtonAgregar.setText("Agregar");
			jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					agregar();
				}
			});
		}
		return jButtonAgregar;
	}

	/**
	 * This method initializes jButtonModificar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonModificar() {
		if (jButtonModificar == null) {
			jButtonModificar = new JButton();
			jButtonModificar.setBounds(new Rectangle(280, 97, 124, 35));
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
			jButtonEliminar.setBounds(new Rectangle(281, 200, 124, 35));
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
	 * This method initializes jButtonAtras	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAtras() {
		if (jButtonAtras == null) {
			jButtonAtras = new JButton();
			jButtonAtras.setBounds(new Rectangle(304, 260, 101, 35));
			jButtonAtras.setText("Atras");
			jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salir();
				}
			});
		}
		return jButtonAtras;
	}

	private void salir(){
		this.instancia.eliminarObservador(this);
		this.dispose();
	}
	
	private void agregar(){
		String nueva = "";
		nueva = JOptionPane.showInputDialog(this, "Ingrese el nombre del nuevo Serol :", "Confirmar", 3);
		if(nueva != null){
			if(!nueva.equalsIgnoreCase("")|| !nueva.equalsIgnoreCase(" ")){
				Serol s = new Serol();
				s.setTipo(nueva);
				if(this.lista.contains(s)){
					JOptionPane.showMessageDialog(this,"Ese tipo de serol ya se encuentra ingresado" , "Error", 2);
				}else{
					Fachada.getInstancia().guardarSerol(s);
				}
			}
		}
	}
	
	private void modificar(){
		Serol s = (Serol) this.jListCausaPerdidaInjerto.getSelectedValue();
		if(s!= null){
			JOptionPane.showMessageDialog(this,"Todos los trasplantes y Donantes que esten asociados con este serol se veran afectados" , "Atencion", 2);
			String nueva = "";
			nueva = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre del Serol :", "Confirmar", 3);
			if(nueva != null){
				if(!nueva.equalsIgnoreCase("")|| !nueva.equalsIgnoreCase(" ")){
					Serol aux = new Serol();
					aux.setTipo(nueva);
					if(this.lista.contains(aux)){
						JOptionPane.showMessageDialog(this,"El Serol que quiere ingresar ya existe" , "Error", 2);
					}else{
						s.setTipo(nueva);
						Fachada.getInstancia().guardarSerol(s);
					}
				}
			}
		}
	}
	private void eliminar(){
		Serol s = (Serol) this.jListCausaPerdidaInjerto.getSelectedValue();
		if(s!= null){
			String respuesta = "";
			respuesta = JOptionPane.showInputDialog(this, "Esta a punto de eliminar un Serol, todos los datos de ese Serol seran eliminados.\n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
			if(respuesta==null)respuesta="No";
			if(respuesta.equalsIgnoreCase("Si")){
				boolean eliminar = Fachada.getInstancia().verificarEliminacionSerol(s);
				if(!eliminar){
					JOptionPane.showMessageDialog(this,"Existe por lo menos un Trasplante o Donante con ese Serol.\nPor lo tanto no se puede borrar." , "Error", 2);
				}else{
					Fachada.getInstancia().eliminarSerol(s);
				}
			}
		}
	}

	/**
	 * This method initializes jButtonModificarDatos	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonModificarDatos() {
		if (jButtonModificarDatos == null) {
			jButtonModificarDatos = new JButton();
			jButtonModificarDatos.setBounds(new Rectangle(281, 152, 128, 35));
			jButtonModificarDatos.setText("Modificar datos");
			jButtonModificarDatos.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					modificarDatos();
				}
			});
		}
		return jButtonModificarDatos;
	}
	private void modificarDatos(){
		Serol s = (Serol) this.jListCausaPerdidaInjerto.getSelectedValue();
		if (s != null) {
			IUManejarSerolDatos iuDatos = new IUManejarSerolDatos(s);
			iuDatos.setVisible(true);
		}
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
