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

import uy.transplante.dominio.RaTratamiento;
import uy.transplante.logica.Fachada;


public class IUManejarTratamientoRA extends JFrame implements java.util.Observer {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;

	private Fachada instancia = Fachada.getInstancia();
	private JScrollPane jScrollPaneMedicacion = null;
	private JList jListMedicacion = null;
	private JLabel jLabelTiposInduccion = null;
	private JButton jButtonAgregar = null;
	private JButton jButtonModificar = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonAtras = null;
	
	private ArrayList<RaTratamiento> lista;  //  @jve:decl-index=0:
	/**
	 * This is the default constructor
	 */
	public IUManejarTratamientoRA() {
		super();
		initialize();
		cargarDatos();
	}

	private void cargarDatos(){
		this.lista = Fachada.getInstancia().obtenerTodosRaTratamiento();
		this.jListMedicacion.setListData(this.lista.toArray());
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
		this.setTitle("Manejar Tipos de Tratamiento RA");
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
			jLabelTiposInduccion.setBounds(new Rectangle(60, 20, 231, 22));
			jLabelTiposInduccion.setFont(new Font("Dialog", Font.BOLD, 18));
			jLabelTiposInduccion.setText("Tipos de Tratamiento RA");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(204, 255, 204));
			jContentPane.add(getJScrollPaneMedicacion(), null);
			jContentPane.add(jLabelTiposInduccion, null);
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
	 * This method initializes jScrollPaneMedicacion	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneMedicacion() {
		if (jScrollPaneMedicacion == null) {
			jScrollPaneMedicacion = new JScrollPane();
			jScrollPaneMedicacion.setBounds(new Rectangle(20, 51, 242, 253));
			jScrollPaneMedicacion.setViewportView(getJListMedicacion());
		}
		return jScrollPaneMedicacion;
	}

	/**
	 * This method initializes jListMedicacion	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJListMedicacion() {
		if (jListMedicacion == null) {
			jListMedicacion = new JList();
		}
		return jListMedicacion;
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
		nueva = JOptionPane.showInputDialog(this, "Ingrese el nombre del nuevo Tratamiento RA :", "Confirmar", 3);
		if(nueva != null){
			if(!nueva.equalsIgnoreCase("")|| !nueva.equalsIgnoreCase(" ")){
				RaTratamiento m = new RaTratamiento();
				m.setNombre(nueva);
				if(this.lista.contains(m)){
					JOptionPane.showMessageDialog(this,"Ese tipo de Tratamiento RA ya se encuentra ingresado" , "Error", 2);
				}else{
					Fachada.getInstancia().guardarRaTratamiento(m);
				}
			}
		}
	}
	
	private void modificar(){
		RaTratamiento m = (RaTratamiento) this.jListMedicacion.getSelectedValue();
		if(m!= null){
			JOptionPane.showMessageDialog(this,"Todas las complicaciones que esten asociados con este Tratamiento RA se veran afectados" , "Atencion", 2);
			String nueva = "";
			nueva = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre de la Tratamiento RA :", "Confirmar", 3);
			if(nueva != null){
				if(!nueva.equalsIgnoreCase("")|| !nueva.equalsIgnoreCase(" ")){
					RaTratamiento aux = new RaTratamiento();
					aux.setNombre(nueva);
					if(this.lista.contains(aux)){
						JOptionPane.showMessageDialog(this,"El Tratamiento RA que quiere ingresar ya existe" , "Error", 2);
					}else{
						m.setNombre(nueva);
						Fachada.getInstancia().guardarRaTratamiento(m);
					}
				}
			}
		}
	}
	private void eliminar(){
		RaTratamiento m = (RaTratamiento) this.jListMedicacion.getSelectedValue();
		if(m!= null){
			String respuesta = "";
			respuesta = JOptionPane.showInputDialog(this, "Está a punto de eliminar un Tratamiento RA\n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
			if(respuesta==null)respuesta="No";
			if(respuesta.equalsIgnoreCase("Si")){
				boolean eliminar = Fachada.getInstancia().verificarEliminacionRaTratamiento(m);
				if(!eliminar){
					JOptionPane.showMessageDialog(this,"Existe por lo menos una complicaciones con este Tratamiento RA.\nPor lo tanto no se puede borrar." , "Error", 2);
				}else{
					Fachada.getInstancia().eliminarRaTratamiento(m);
				}
			}
			
		}
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
