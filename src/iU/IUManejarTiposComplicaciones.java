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
import dominio.TrasplanteTiposComplicaciones;

public class IUManejarTiposComplicaciones extends JFrame implements java.util.Observer {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;

	private Fachada instancia = Fachada.getInstancia();
	private JScrollPane jScrollPaneComplicaciones = null;
	private JList jListComplicaciones = null;
	private JLabel jLabelAntecedentes = null;
	private JButton jButtonAgregar = null;
	private JButton jButtonModificar = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonAtras = null;
	
	private ArrayList<TrasplanteTiposComplicaciones> lista = new ArrayList<TrasplanteTiposComplicaciones>();  //  @jve:decl-index=0:
	/**
	 * This is the default constructor
	 */
	public IUManejarTiposComplicaciones() {
		super();
		initialize();
		cargarDatos();
	}

	private void cargarDatos(){
		this.lista = Fachada.getInstancia().obtenerTodosTiposComplicaciones();
		this.jListComplicaciones.setListData(this.lista.toArray());
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(740, 370);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Manejar los tipos de Complicaciones");
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
			jLabelAntecedentes = new JLabel();
			jLabelAntecedentes.setBounds(new Rectangle(208, 18, 200, 22));
			jLabelAntecedentes.setFont(new Font("Dialog", Font.BOLD, 18));
			jLabelAntecedentes.setText("Tipos de complicacion");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(204, 255, 204));
			jContentPane.add(getJScrollPaneComplicaciones(), null);
			jContentPane.add(jLabelAntecedentes, null);
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
	 * This method initializes jScrollPaneComplicaciones	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneComplicaciones() {
		if (jScrollPaneComplicaciones == null) {
			jScrollPaneComplicaciones = new JScrollPane();
			jScrollPaneComplicaciones.setBounds(new Rectangle(20, 51, 537, 253));
			jScrollPaneComplicaciones.setViewportView(getJListComplicaciones());
		}
		return jScrollPaneComplicaciones;
	}

	/**
	 * This method initializes jListComplicaciones	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJListComplicaciones() {
		if (jListComplicaciones == null) {
			jListComplicaciones = new JList();
		}
		return jListComplicaciones;
	}

	/**
	 * This method initializes jButtonAgregar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAgregar() {
		if (jButtonAgregar == null) {
			jButtonAgregar = new JButton();
			jButtonAgregar.setBounds(new Rectangle(598, 60, 101, 35));
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
			jButtonModificar.setBounds(new Rectangle(598, 130, 101, 35));
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
			jButtonEliminar.setBounds(new Rectangle(598, 196, 101, 35));
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
			jButtonAtras.setBounds(new Rectangle(598, 256, 101, 35));
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
		String tipo = JOptionPane.showInputDialog(this, "Ingrese el nombre de el tipo de la complicacion:", "Confirmar", 3);
		String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre de la complicacion:", "Confirmar", 3);
		if(tipo != null && nombre != null){
			if((!tipo.equalsIgnoreCase("")|| !tipo.equalsIgnoreCase(" ")) && (!nombre.equalsIgnoreCase("")|| !nombre.equalsIgnoreCase(" "))){
				TrasplanteTiposComplicaciones tc = new TrasplanteTiposComplicaciones();
				tc.setTipo(tipo);
				tc.setNombre(nombre);
				if(this.lista.contains(tc)){
					JOptionPane.showMessageDialog(this,"El tipo de complicacion que quiere ingresar ya existe" , "Error", 2);
				}else{
					Fachada.getInstancia().guardarTipoComplicacion(tc);
				}
			}else{
				JOptionPane.showMessageDialog(this,"No puede dejar datos en blancos" , "Error", 2);
				
			}
		}
	}
	
	private void modificar(){
		TrasplanteTiposComplicaciones tc = (TrasplanteTiposComplicaciones) this.jListComplicaciones.getSelectedValue();
		if(tc!= null){
			JOptionPane.showMessageDialog(this,"Todas las complicaciones que esten relacionadas con este tipo de complicacion pasaran a estar relacionados con la nueva" , "Atencion", 2);
			JOptionPane.showMessageDialog(this,"Si quiere dejar un dato igual simplemente deje el dato en blanco" , "Atencion", 2);
			String tipo = JOptionPane.showInputDialog(this, "Ingrese el nuevo tipo de la complicacion :", "Confirmar", 3);
			String nombre = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre de la complicacion :", "Confirmar", 3);
			if(tipo != null && nombre != null){
				TrasplanteTiposComplicaciones aux = new TrasplanteTiposComplicaciones();
				aux.setId(tc.getId());
				if(!tipo.equalsIgnoreCase("")&& !tipo.equalsIgnoreCase(" ")){
					aux.setTipo(tipo);
				}else{
					aux.setTipo(tc.getTipo());
				}
				if(!nombre.equalsIgnoreCase("") && !nombre.equalsIgnoreCase(" ")){
					aux.setNombre(nombre);
				}else{
					aux.setNombre(tc.getNombre());
				}
				if(this.lista.contains(aux)){
					JOptionPane.showMessageDialog(this,"El Tipo de complicacion que quiere ingresar ya existe" , "Error", 2);
				}else{
					Fachada.getInstancia().guardarTipoComplicacion(aux);
				}
			}
		}
	}
	private void eliminar(){
		TrasplanteTiposComplicaciones tc = (TrasplanteTiposComplicaciones) this.jListComplicaciones.getSelectedValue();
		if(tc!= null){
			String respuesta = "";
			respuesta = JOptionPane.showInputDialog(this, "Est� a punto de eliminar un Tipo de complicacion.\n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
			if(respuesta==null)respuesta="No";
			if(respuesta.equalsIgnoreCase("Si")){
				boolean eliminar = Fachada.getInstancia().verificarEliminacionTipoComplicacion(tc);
				if(!eliminar){
					JOptionPane.showMessageDialog(this,"Existe por lo menos una complicacion relacionada con ese tipo.\nPor lo tanto no se puede borrar." , "Error", 2);
				}else{
					Fachada.getInstancia().eliminarTipoComplicacion(tc);
				}
			}

		}
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
