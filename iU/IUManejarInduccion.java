package iU;

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
import dominio.Induccion;

public class IUManejarInduccion extends JFrame implements java.util.Observer {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;

	private Fachada instancia = Fachada.getInstancia();
	private JScrollPane jScrollPaneCausaPerdidaInjerto = null;
	private JList jListCausaPerdidaInjerto = null;
	private JLabel jLabelTiposInduccion = null;
	private JButton jButtonAgregar = null;
	private JButton jButtonModificar = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonAtras = null;
	
	private ArrayList<Induccion> lista;  //  @jve:decl-index=0:
	/**
	 * This is the default constructor
	 */
	public IUManejarInduccion() {
		super();
		initialize();
		cargarDatos();
	}

	private void cargarDatos(){
		this.lista = Fachada.getInstancia().obtenerTodosLosInduccion();
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
		this.setTitle("Manejar Tipos de Induccion");
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
			jLabelTiposInduccion = new JLabel();
			jLabelTiposInduccion.setBounds(new Rectangle(60, 20, 187, 22));
			jLabelTiposInduccion.setFont(new Font("Dialog", Font.BOLD, 18));
			jLabelTiposInduccion.setText("Tipos de Induccion");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(204, 255, 204));
			jContentPane.add(getJScrollPaneCausaPerdidaInjerto(), null);
			jContentPane.add(jLabelTiposInduccion, null);
			jContentPane.add(getJButtonAgregar(), null);
			jContentPane.add(getJButtonModificar(), null);
			jContentPane.add(getJButtonEliminar(), null);
			jContentPane.add(getJButtonAtras(), null);
		}
		return jContentPane;
	}

	@Override
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
		this.instancia.EliminarObservador(this);
		this.dispose();
	}
	
	private void agregar(){
		String nueva = "";
		nueva = JOptionPane.showInputDialog(this, "Ingrese el nombre del nuevo Induccion :", "Confirmar", 3);
		if(nueva != null){
			if(!nueva.equalsIgnoreCase("")|| !nueva.equalsIgnoreCase(" ")){
				Induccion s = new Induccion();
				s.setTipo(nueva);
				if(this.lista.contains(s)){
					JOptionPane.showMessageDialog(this,"Ese tipo de Induccion ya se encuentra ingresado" , "Error", 2);
				}else{
					Fachada.getInstancia().guardarInduccion(s);
				}
			}
		}
	}
	
	private void modificar(){
		Induccion s = (Induccion) this.jListCausaPerdidaInjerto.getSelectedValue();
		if(s!= null){
			JOptionPane.showMessageDialog(this,"Todos los trasplantes que esten asociados con este Induccion se veran afectados" , "Atencion", 2);
			String nueva = "";
			nueva = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre del Induccion :", "Confirmar", 3);
			if(nueva != null){
				if(!nueva.equalsIgnoreCase("")|| !nueva.equalsIgnoreCase(" ")){
					Induccion aux = new Induccion();
					aux.setTipo(nueva);
					if(this.lista.contains(aux)){
						JOptionPane.showMessageDialog(this,"El Induccion que quiere ingresar ya existe" , "Error", 2);
					}else{
						s.setTipo(nueva);
						Fachada.getInstancia().guardarInduccion(s);
					}
				}
			}
		}
	}
	private void eliminar(){
		Induccion s = (Induccion) this.jListCausaPerdidaInjerto.getSelectedValue();
		if(s!= null){
			boolean eliminar = Fachada.getInstancia().verificarEliminacionInduccion(s);
			if(!eliminar){
				JOptionPane.showMessageDialog(this,"Existe por lo menos un paciente con esta Causa de Perdida del Injerto.\nPor lo tanto no se puede borrar." , "Error", 2);
			}else{
				Fachada.getInstancia().eliminarInduccion(s);
			}
		}
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
