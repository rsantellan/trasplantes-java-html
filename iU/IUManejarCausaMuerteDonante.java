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
import dominio.CausaMuerteDonante;

public class IUManejarCausaMuerteDonante extends JFrame implements java.util.Observer {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;

	private Fachada instancia = Fachada.getInstancia();
	private JScrollPane jScrollPaneCausaMuerteDonante = null;
	private JList jListCausaMuerteDonante = null;
	private JLabel jLabelCausaMuerteDonante = null;
	private JButton jButtonAgregar = null;
	private JButton jButtonModificar = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonAtras = null;
	
	private ArrayList<CausaMuerteDonante> lista;  //  @jve:decl-index=0:
	/**
	 * This is the default constructor
	 */
	public IUManejarCausaMuerteDonante() {
		super();
		initialize();
		cargarDatos();
	}

	private void cargarDatos(){
		this.lista = Fachada.getInstancia().obtenerTodasCausasMuerteDonante();
		this.jListCausaMuerteDonante.setListData(this.lista.toArray());
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
		this.setTitle("Manejar las Causas de Muertes del Donante");
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
			jLabelCausaMuerteDonante = new JLabel();
			jLabelCausaMuerteDonante.setBounds(new Rectangle(60, 20, 171, 22));
			jLabelCausaMuerteDonante.setFont(new Font("Dialog", Font.BOLD, 18));
			jLabelCausaMuerteDonante.setText("Causas de Muertes");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(204, 255, 204));
			jContentPane.add(getJScrollPaneCausaMuerteDonante(), null);
			jContentPane.add(jLabelCausaMuerteDonante, null);
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
	 * This method initializes jScrollPaneCausaMuerteDonante	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneCausaMuerteDonante() {
		if (jScrollPaneCausaMuerteDonante == null) {
			jScrollPaneCausaMuerteDonante = new JScrollPane();
			jScrollPaneCausaMuerteDonante.setBounds(new Rectangle(20, 51, 242, 253));
			jScrollPaneCausaMuerteDonante.setViewportView(getJListCausaMuerteDonante());
		}
		return jScrollPaneCausaMuerteDonante;
	}

	/**
	 * This method initializes jListCausaMuerteDonante	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJListCausaMuerteDonante() {
		if (jListCausaMuerteDonante == null) {
			jListCausaMuerteDonante = new JList();
		}
		return jListCausaMuerteDonante;
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
		nueva = JOptionPane.showInputDialog(this, "Ingrese el nombre de la nueva Causa de Muerte del Donante:", "Confirmar", 3);
		if(nueva != null){
			if(!nueva.equalsIgnoreCase("")|| !nueva.equalsIgnoreCase(" ")){
				CausaMuerteDonante c = new CausaMuerteDonante();
				c.setDetalle(nueva);
				if(this.lista.contains(c)){
					JOptionPane.showMessageDialog(this,"La Causa de Muerte que quiere ingresar ya existe" , "Error", 2);
				}else{
					Fachada.getInstancia().guardarCausaMuerteDonante(c);
				}
			}
		}
	}
	
	private void modificar(){
		CausaMuerteDonante a = (CausaMuerteDonante) this.jListCausaMuerteDonante.getSelectedValue();
		if(a!= null){
			JOptionPane.showMessageDialog(this,"Todos los Donante relacionados con este Antecedente pasaran a estar relacionados con la nueva" , "Atencion", 2);
			String nueva = "";
			nueva = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre del Antecedente :", "Confirmar", 3);
			if(nueva != null){
				if(!nueva.equalsIgnoreCase("")|| !nueva.equalsIgnoreCase(" ")){
					CausaMuerteDonante aux = new CausaMuerteDonante();
					aux.setDetalle(nueva);
					if(this.lista.contains(aux)){
						JOptionPane.showMessageDialog(this,"El Antecedente que quiere ingresar ya existe" , "Error", 2);
					}else{
						a.setDetalle(nueva);
						Fachada.getInstancia().guardarCausaMuerteDonante(a);
					}
				}
			}
		}
	}
	private void eliminar(){
		CausaMuerteDonante c = (CausaMuerteDonante) this.jListCausaMuerteDonante.getSelectedValue();
		if(c!= null){
			boolean eliminar = Fachada.getInstancia().verificarEliminacionCausaMuerteDonante(c);
			if(!eliminar){
				JOptionPane.showMessageDialog(this,"Existe por lo menos un donante con esta Causa de Muerte.\nPor lo tanto no se puede borrar." , "Error", 2);
			}else{
				Fachada.getInstancia().eliminarCausaMuerteDonante(c);
			}
		}
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
