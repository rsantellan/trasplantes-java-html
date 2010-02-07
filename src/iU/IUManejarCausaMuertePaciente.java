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
import dominio.CausaMuertePaciente;

public class IUManejarCausaMuertePaciente extends JFrame implements java.util.Observer {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;

	private Fachada instancia = Fachada.getInstancia();
	private JScrollPane jScrollPaneCausaMuerteP = null;
	private JList jListCausaMuerteP = null;
	private JLabel jLabelCausaMuerteP = null;
	private JButton jButtonAgregar = null;
	private JButton jButtonModificar = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonAtras = null;
	
	private ArrayList<CausaMuertePaciente> lista;  //  @jve:decl-index=0:
	/**
	 * This is the default constructor
	 */
	public IUManejarCausaMuertePaciente() {
		super();
		initialize();
		cargarDatos();
	}

	private void cargarDatos(){
		this.lista = Fachada.getInstancia().obtenerTodasCausaMuertePaciente();
		this.jListCausaMuerteP.setListData(this.lista.toArray());
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
		this.setTitle("Manejar Causas de Muerte del Paciente");
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
			jLabelCausaMuerteP = new JLabel();
			jLabelCausaMuerteP.setBounds(new Rectangle(60, 20, 152, 22));
			jLabelCausaMuerteP.setFont(new Font("Dialog", Font.BOLD, 18));
			jLabelCausaMuerteP.setText("Causa de Muerte");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(204, 255, 204));
			jContentPane.add(getJScrollPaneCausaMuerteP(), null);
			jContentPane.add(jLabelCausaMuerteP, null);
			jContentPane.add(getJButtonAgregar(), null);
			jContentPane.add(getJButtonModificar(), null);
			jContentPane.add(getJButtonEliminar(), null);
			jContentPane.add(getJButtonAtras(), null);
		}
		return jContentPane;
	}

	public void update(Observable o, Object arg) {
		if(Fachada.getInstancia().getLugar() == Fachada.CAUSA_MUERTE_PACIENTES){
			this.cargarDatos();
		}
	}

	/**
	 * This method initializes jScrollPaneCausaMuerteP	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneCausaMuerteP() {
		if (jScrollPaneCausaMuerteP == null) {
			jScrollPaneCausaMuerteP = new JScrollPane();
			jScrollPaneCausaMuerteP.setBounds(new Rectangle(20, 51, 242, 253));
			jScrollPaneCausaMuerteP.setViewportView(getJListCausaMuerteP());
		}
		return jScrollPaneCausaMuerteP;
	}

	/**
	 * This method initializes jListCausaMuerteP	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJListCausaMuerteP() {
		if (jListCausaMuerteP == null) {
			jListCausaMuerteP = new JList();
		}
		return jListCausaMuerteP;
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
		nueva = JOptionPane.showInputDialog(this, "Ingrese el nombre de la nueva Causa de Muerte del Paciente:", "Confirmar", 3);
		if(nueva != null){
			if(!nueva.equalsIgnoreCase("")|| !nueva.equalsIgnoreCase(" ")){
				CausaMuertePaciente c = new CausaMuertePaciente();
				c.setDetalle(nueva);
				if(this.lista.contains(c)){
					JOptionPane.showMessageDialog(this,"La Causa de Muerte del Paciente que quiere ingresar ya existe" , "Error", 2);
				}else{
					Fachada.getInstancia().guardarCausaMuertePaciente(c);
				}
			}
		}
	}
	
	private void modificar(){
		CausaMuertePaciente c = (CausaMuertePaciente) this.jListCausaMuerteP.getSelectedValue();
		if(c!= null){
			JOptionPane.showMessageDialog(this,"Todos los pacientes que esten relacionados con esta Causa de Muerte pasaran a estar relacionados con la nueva" , "Atencion", 2);
			String nueva = "";
			nueva = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre de la Causa de Muerte :", "Confirmar", 3);
			if(nueva != null){
				if(!nueva.equalsIgnoreCase("")|| !nueva.equalsIgnoreCase(" ")){
					CausaMuertePaciente aux = new CausaMuertePaciente();
					aux.setDetalle(nueva);
					if(this.lista.contains(aux)){
						JOptionPane.showMessageDialog(this,"La Causa de Muerte que quiere ingresar ya existe" , "Error", 2);
					}else{
						c.setDetalle(nueva);
						Fachada.getInstancia().guardarCausaMuertePaciente(c);
					}
				}
			}
		}
	}
	private void eliminar(){
		CausaMuertePaciente c = (CausaMuertePaciente) this.jListCausaMuerteP.getSelectedValue();
		if(c!= null){
			String respuesta = "";
			respuesta = JOptionPane.showInputDialog(this, "Est� a punto de eliminar una Causa de muerte de pacientes.\n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
			if(respuesta==null)respuesta="No";
			if(respuesta.equalsIgnoreCase("Si")){
				boolean eliminar = Fachada.getInstancia().verificarEliminacionCausaMuertePaciente(c);
				if(!eliminar){
					JOptionPane.showMessageDialog(this,"Existe por lo menos un paciente con esta Causa de Muerte.\nPor lo tanto no se puede borrar." , "Error", 2);
				}else{
					Fachada.getInstancia().eliminarCausaMuertePaciente(c);
				}
			}

		}
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
