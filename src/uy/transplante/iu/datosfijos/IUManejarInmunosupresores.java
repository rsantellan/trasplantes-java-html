package uy.transplante.iu.datosfijos;

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

import uy.transplante.dominio.Inmunosupresores;

import logica.Fachada;

public class IUManejarInmunosupresores extends JFrame implements java.util.Observer {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;

	private Fachada instancia = Fachada.getInstancia();
	private JScrollPane jScrollPaneCausaPerdidaInjerto = null;
	private JList jListCausaPerdidaInjerto = null;
	private JLabel jLabelTiposInmunosupresores = null;
	private JButton jButtonAgregar = null;
	private JButton jButtonModificar = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonAtras = null;
	
	private ArrayList<Inmunosupresores> lista;  //  @jve:decl-index=0:
	/**
	 * This is the default constructor
	 */
	public IUManejarInmunosupresores() {
		super();
		initialize();
		cargarDatos();
	}

	private void cargarDatos(){
		this.lista = Fachada.getInstancia().obtenerTodosLosInmunosupresores();
		this.jListCausaPerdidaInjerto.setListData(this.lista.toArray());
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(443, 370);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Manejar Tipos de Inmunosupresores");
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
			jLabelTiposInmunosupresores = new JLabel();
			jLabelTiposInmunosupresores.setBounds(new Rectangle(17, 20, 257, 22));
			jLabelTiposInmunosupresores.setFont(new Font("Dialog", Font.BOLD, 18));
			jLabelTiposInmunosupresores.setText("Tipos de Inmunosupresores");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(204, 255, 204));
			jContentPane.add(getJScrollPaneCausaPerdidaInjerto(), null);
			jContentPane.add(jLabelTiposInmunosupresores, null);
			jContentPane.add(getJButtonAgregar(), null);
			jContentPane.add(getJButtonModificar(), null);
			jContentPane.add(getJButtonEliminar(), null);
			jContentPane.add(getJButtonAtras(), null);
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
			jButtonAgregar.setBounds(new Rectangle(304, 64, 101, 35));
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
			jButtonModificar.setBounds(new Rectangle(304, 134, 101, 35));
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
			jButtonEliminar.setBounds(new Rectangle(304, 200, 101, 35));
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
		nueva = JOptionPane.showInputDialog(this, "Ingrese el nombre del nuevo Inmunosupresores :", "Confirmar", 3);
		if(nueva != null){
			if(!nueva.equalsIgnoreCase("")|| !nueva.equalsIgnoreCase(" ")){
				Inmunosupresores s = new Inmunosupresores();
				s.setTipo(nueva);
				if(this.lista.contains(s)){
					JOptionPane.showMessageDialog(this,"Ese tipo de Inmunosupresores ya se encuentra ingresado" , "Error", 2);
				}else{
					Fachada.getInstancia().guardarInmunosupresores(s);
				}
			}
		}
	}
	
	private void modificar(){
		Inmunosupresores s = (Inmunosupresores) this.jListCausaPerdidaInjerto.getSelectedValue();
		if(s!= null){
			JOptionPane.showMessageDialog(this,"Todos los trasplantes que esten asociados con este Inmunosupresores se veran afectados" , "Atencion", 2);
			String nueva = "";
			nueva = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre del Inmunosupresores :", "Confirmar", 3);
			if(nueva != null){
				if(!nueva.equalsIgnoreCase("")|| !nueva.equalsIgnoreCase(" ")){
					Inmunosupresores aux = new Inmunosupresores();
					aux.setTipo(nueva);
					if(this.lista.contains(aux)){
						JOptionPane.showMessageDialog(this,"El Inmunosupresores que quiere ingresar ya existe" , "Error", 2);
					}else{
						s.setTipo(nueva);
						Fachada.getInstancia().guardarInmunosupresores(s);
					}
				}
			}
		}
	}
	private void eliminar(){
		Inmunosupresores s = (Inmunosupresores) this.jListCausaPerdidaInjerto.getSelectedValue();
		if(s!= null){
			String respuesta = "";
			respuesta = JOptionPane.showInputDialog(this, "Está a punto de eliminar un Inmunosupresor\n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
			if(respuesta==null)respuesta="No";
			if(respuesta.equalsIgnoreCase("Si")){
				boolean eliminar = Fachada.getInstancia().verificarEliminacionInmunosupresor(s);
				if(!eliminar){
					JOptionPane.showMessageDialog(this,"Existe por lo menos un trasplante con este Inmunosupresor.\nPor lo tanto no se puede borrar." , "Error", 2);
				}else{
					Fachada.getInstancia().eliminarInmunosupresores(s);
				}	
			}
		}
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
