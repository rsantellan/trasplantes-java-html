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

import uy.transplante.dominio.AntecedentesDonante;
import uy.transplante.logica.Fachada;


public class IUManejarAntecedentesDonante extends JFrame implements java.util.Observer {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;

	private Fachada instancia = Fachada.getInstancia();
	private JScrollPane jScrollPaneAntecedentes = null;
	private JList jListAntecedentes = null;
	private JLabel jLabelAntecedentes = null;
	private JButton jButtonAgregar = null;
	private JButton jButtonModificar = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonAtras = null;
	
	private ArrayList<AntecedentesDonante> lista;  //  @jve:decl-index=0:
	/**
	 * This is the default constructor
	 */
	public IUManejarAntecedentesDonante() {
		super();
		initialize();
		cargarDatos();
	}

	private void cargarDatos(){
		this.lista = Fachada.getInstancia().obtenerTodosAntecedentesDonante();
		this.jListAntecedentes.setListData(this.lista.toArray());
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
		this.setTitle("Manejar los tipos de Antecedentes del Donante");
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
			jLabelAntecedentes.setBounds(new Rectangle(60, 20, 152, 22));
			jLabelAntecedentes.setFont(new Font("Dialog", Font.BOLD, 18));
			jLabelAntecedentes.setText("Antecedentes");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(204, 255, 204));
			jContentPane.add(getJScrollPaneAntecedentes(), null);
			jContentPane.add(jLabelAntecedentes, null);
			jContentPane.add(getJButtonAgregar(), null);
			jContentPane.add(getJButtonModificar(), null);
			jContentPane.add(getJButtonEliminar(), null);
			jContentPane.add(getJButtonAtras(), null);
		}
		return jContentPane;
	}

	public void update(Observable o, Object arg) {
		if(Fachada.getInstancia().getLugar() == Fachada.ANTECEDENTE_DONANTE){
			this.cargarDatos();
		}
	}

	/**
	 * This method initializes jScrollPaneAntecedentes	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneAntecedentes() {
		if (jScrollPaneAntecedentes == null) {
			jScrollPaneAntecedentes = new JScrollPane();
			jScrollPaneAntecedentes.setBounds(new Rectangle(20, 51, 242, 253));
			jScrollPaneAntecedentes.setViewportView(getJListAntecedentes());
		}
		return jScrollPaneAntecedentes;
	}

	/**
	 * This method initializes jListAntecedentes	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJListAntecedentes() {
		if (jListAntecedentes == null) {
			jListAntecedentes = new JList();
		}
		return jListAntecedentes;
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
		nueva = JOptionPane.showInputDialog(this, "Ingrese el nombre de el nuevo Antecedente del Donante:", "Confirmar", 3);
		if(nueva != null){
			if(!nueva.equalsIgnoreCase("")|| !nueva.equalsIgnoreCase(" ")){
				AntecedentesDonante a = new AntecedentesDonante();
				a.setDetalle(nueva);
				if(this.lista.contains(a)){
					JOptionPane.showMessageDialog(this,"El Antecedente que quiere ingresar ya existe" , "Error", 2);
				}else{
					Fachada.getInstancia().guardarAntecedenteDonante(a);
				}
			}
		}
	}
	
	private void modificar(){
		AntecedentesDonante a = (AntecedentesDonante) this.jListAntecedentes.getSelectedValue();
		if(a!= null){
			JOptionPane.showMessageDialog(this,"Todos los Donante relacionados con este Antecedente pasaran a estar relacionados con la nueva" , "Atencion", 2);
			String nueva = "";
			nueva = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre del Antecedente :", "Confirmar", 3);
			if(nueva != null){
				if(!nueva.equalsIgnoreCase("")|| !nueva.equalsIgnoreCase(" ")){
					AntecedentesDonante aux = new AntecedentesDonante();
					aux.setDetalle(nueva);
					if(this.lista.contains(aux)){
						JOptionPane.showMessageDialog(this,"El Antecedente que quiere ingresar ya existe" , "Error", 2);
					}else{
						a.setDetalle(nueva);
						Fachada.getInstancia().guardarAntecedenteDonante(a);
					}
				}
			}
		}
	}
	private void eliminar(){
		AntecedentesDonante a = (AntecedentesDonante) this.jListAntecedentes.getSelectedValue();
		if(a!= null){
			String respuesta = "";
			respuesta = JOptionPane.showInputDialog(this, "Está a punto de eliminar un antecedente de donante\n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
			if(respuesta==null)respuesta="No";
			if(respuesta.equalsIgnoreCase("Si")){
				boolean eliminar = Fachada.getInstancia().verificarEliminacionAntecedenteDonante(a);
				if(!eliminar){
					JOptionPane.showMessageDialog(this,"Existe por lo menos un donante con este Antecedente.\nPor lo tanto no se puede borrar." , "Error", 2);
				}else{
					Fachada.getInstancia().eliminarAntecedenteDonante(a);
				}
			}
			
		}
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
