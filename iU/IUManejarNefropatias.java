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
import dominio.Nefropatia;

public class IUManejarNefropatias extends JFrame implements java.util.Observer {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;

	private Fachada instancia = Fachada.getInstancia();
	private JScrollPane jScrollPaneNefropatias = null;
	private JList jListNefropatias = null;
	private JLabel jLabelNefropatias = null;
	private JButton jButtonAgregar = null;
	private JButton jButtonModificar = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonAtras = null;
	
	private ArrayList<Nefropatia> lista;  //  @jve:decl-index=0:
	/**
	 * This is the default constructor
	 */
	public IUManejarNefropatias() {
		super();
		initialize();
		cargarDatos();
	}

	private void cargarDatos(){
		this.lista = Fachada.getInstancia().obtenerTodasNefropatias();
		this.jListNefropatias.setListData(this.lista.toArray());
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
		this.setTitle("Manejar Nefropatias");
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
			jLabelNefropatias = new JLabel();
			jLabelNefropatias.setBounds(new Rectangle(60, 20, 111, 22));
			jLabelNefropatias.setFont(new Font("Dialog", Font.BOLD, 18));
			jLabelNefropatias.setText("Nefropatias");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(204, 255, 204));
			jContentPane.add(getJScrollPaneNefropatias(), null);
			jContentPane.add(jLabelNefropatias, null);
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
	 * This method initializes jScrollPaneNefropatias	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneNefropatias() {
		if (jScrollPaneNefropatias == null) {
			jScrollPaneNefropatias = new JScrollPane();
			jScrollPaneNefropatias.setBounds(new Rectangle(20, 51, 242, 253));
			jScrollPaneNefropatias.setViewportView(getJListNefropatias());
		}
		return jScrollPaneNefropatias;
	}

	/**
	 * This method initializes jListNefropatias	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJListNefropatias() {
		if (jListNefropatias == null) {
			jListNefropatias = new JList();
		}
		return jListNefropatias;
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
		nueva = JOptionPane.showInputDialog(this, "Ingrese el nombre de la nueva Nefropatia :", "Confirmar", 3);
		if(nueva != null){
			if(!nueva.equalsIgnoreCase("")|| !nueva.equalsIgnoreCase(" ")){
				Nefropatia n = new Nefropatia();
				n.setNefropatia(nueva);
				if(this.lista.contains(n)){
					JOptionPane.showMessageDialog(this,"La nefropatia que quiere ingresar ya existe" , "Error", 2);
				}else{
					Fachada.getInstancia().guardarNefropatia(n);
				}
			}
		}
	}
	
	private void modificar(){
		Nefropatia n = (Nefropatia) this.jListNefropatias.getSelectedValue();
		if(n!= null){
			JOptionPane.showMessageDialog(this,"Todos los pacientes que esten relacionados con esta Nefropatia pasaran a estar relacionados con la nueva" , "Atencion", 2);
			String nueva = "";
			nueva = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre de la nueva Nefropatia :", "Confirmar", 3);
			if(nueva != null){
				if(!nueva.equalsIgnoreCase("")|| !nueva.equalsIgnoreCase(" ")){
					Nefropatia aux = new Nefropatia();
					aux.setNefropatia(nueva);
					if(this.lista.contains(aux)){
						JOptionPane.showMessageDialog(this,"La nefropatia que quiere ingresar ya existe" , "Error", 2);
					}else{
						n.setNefropatia(nueva);
						Fachada.getInstancia().guardarNefropatia(n);
					}
				}
			}
		}
	}
	private void eliminar(){
		Nefropatia n = (Nefropatia) this.jListNefropatias.getSelectedValue();
		if(n!= null){
			boolean eliminar = Fachada.getInstancia().verificarEliminacionNefropatia(n);
			if(!eliminar){
				JOptionPane.showMessageDialog(this,"Existe por lo menos un paciente con esta Nefropatia.\nPor lo tanto no se puede borrar." , "Error", 2);
			}else{
				Fachada.getInstancia().eliminarNefropatia(n);
			}
		}
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
