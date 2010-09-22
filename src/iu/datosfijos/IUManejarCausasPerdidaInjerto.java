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

import uy.transplante.dominio.CausaPerdidaInjerto;

import logica.Fachada;

public class IUManejarCausasPerdidaInjerto extends JFrame implements java.util.Observer {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;

	private Fachada instancia = Fachada.getInstancia();
	private JScrollPane jScrollPaneCausaPerdidaInjerto = null;
	private JList jListCausaPerdidaInjerto = null;
	private JLabel jLabelCausaPerdidaInjerto = null;
	private JButton jButtonAgregar = null;
	private JButton jButtonModificar = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonAtras = null;
	
	private ArrayList<CausaPerdidaInjerto> lista;  //  @jve:decl-index=0:
	/**
	 * This is the default constructor
	 */
	public IUManejarCausasPerdidaInjerto() {
		super();
		initialize();
		cargarDatos();
	}

	private void cargarDatos(){
		this.lista = Fachada.getInstancia().obtenerTodasCausasPerdidaInjerto();
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
		this.setTitle("Manejar Causa Perdida Injerto");
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
			jLabelCausaPerdidaInjerto = new JLabel();
			jLabelCausaPerdidaInjerto.setBounds(new Rectangle(60, 20, 146, 22));
			jLabelCausaPerdidaInjerto.setFont(new Font("Dialog", Font.BOLD, 18));
			jLabelCausaPerdidaInjerto.setText("Causas perdida");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(204, 255, 204));
			jContentPane.add(getJScrollPaneCausaPerdidaInjerto(), null);
			jContentPane.add(jLabelCausaPerdidaInjerto, null);
			jContentPane.add(getJButtonAgregar(), null);
			jContentPane.add(getJButtonModificar(), null);
			jContentPane.add(getJButtonEliminar(), null);
			jContentPane.add(getJButtonAtras(), null);
		}
		return jContentPane;
	}

	public void update(Observable o, Object arg) {
		if(Fachada.getInstancia().getLugar() == Fachada.CAUSAPERDIDAINJERTO){
			this.cargarDatos();
		}
		
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
		nueva = JOptionPane.showInputDialog(this, "Ingrese el nombre de la nueva Causa de Perdida del Injerto :", "Confirmar", 3);
		if(nueva != null){
			if(!nueva.equalsIgnoreCase("")|| !nueva.equalsIgnoreCase(" ")){
				CausaPerdidaInjerto c = new CausaPerdidaInjerto();
				c.setDetalle(nueva);
				if(this.lista.contains(c)){
					JOptionPane.showMessageDialog(this,"La Causa de Perdida del Injerto que quiere ingresar ya existe" , "Error", 2);
				}else{
					Fachada.getInstancia().guardarCausaPerdidaInjerto(c);
				}
			}
		}
	}
	
	private void modificar(){
		CausaPerdidaInjerto c = (CausaPerdidaInjerto) this.jListCausaPerdidaInjerto.getSelectedValue();
		if(c!= null){
			JOptionPane.showMessageDialog(this,"Todos los pacientes que esten relacionados con esta Causa de Perdida del Injerto pasaran a estar relacionados con la nueva" , "Atencion", 2);
			String nueva = "";
			nueva = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre de la nueva Causa de Perdida del Injerto :", "Confirmar", 3);
			if(nueva != null){
				if(!nueva.equalsIgnoreCase("")|| !nueva.equalsIgnoreCase(" ")){
					CausaPerdidaInjerto aux = new CausaPerdidaInjerto();
					aux.setDetalle(nueva);
					if(this.lista.contains(aux)){
						JOptionPane.showMessageDialog(this,"La Causa de Perdida del Injerto que quiere ingresar ya existe" , "Error", 2);
					}else{
						c.setDetalle(nueva);
						Fachada.getInstancia().guardarCausaPerdidaInjerto(c);
					}
				}
			}
		}
	}
	private void eliminar(){
		CausaPerdidaInjerto c = (CausaPerdidaInjerto) this.jListCausaPerdidaInjerto.getSelectedValue();
		if(c!= null){
			String respuesta = "";
			respuesta = JOptionPane.showInputDialog(this, "Está a punto de eliminar una causa de perdida de injerto.\n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
			if(respuesta==null)respuesta="No";
			if(respuesta.equalsIgnoreCase("Si")){
				boolean eliminar = Fachada.getInstancia().verificarEliminacionCausaPerdidaInjerto(c);
				if(!eliminar){
					JOptionPane.showMessageDialog(this,"Existe por lo menos un paciente con esta Causa de Perdida del Injerto.\nPor lo tanto no se puede borrar." , "Error", 2);
				}else{
					Fachada.getInstancia().eliminarCausaPerdidaInjerto(c);
				}
			}

		}
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
