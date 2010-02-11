package iu.datosfijos;

import iu.windows.auxiliaries.IUAuxiliarPaneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
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
import dominio.SerolDatos;

public class IUManejarSerolDatos extends JFrame implements java.util.Observer {

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
	
	private Serol activo;
	/**
	 * This is the default constructor
	 */
	public IUManejarSerolDatos(Serol s) {
		super();
		this.activo = s;
		initialize();
		cargarDatos();
	}

	private void cargarDatos(){
		this.activo.leerDatos();
		this.jListCausaPerdidaInjerto.setListData(this.activo.getDatos().toArray());
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
		this.setTitle("Manejar los datos del Serol :" + this.activo.toString());
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
			jLabelTiposSerol.setText("Datos del Serol " + this.activo.toString());
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(204, 255, 204));
			jContentPane.add(getJScrollPaneCausaPerdidaInjerto(), null);
			jContentPane.add(jLabelTiposSerol, null);
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
		nueva = JOptionPane.showInputDialog(this, "Ingrese el nombre del nuevo datos del Serol :" +  this.activo.toString(), "Confirmar", 3);
		if(nueva != null){
			if(!nueva.equalsIgnoreCase("")|| !nueva.equalsIgnoreCase(" ")){
				SerolDatos sd = new SerolDatos();
				sd.setId(this.activo.getId());
				sd.setTipo(nueva);
				if(this.activo.getDatos().contains(sd)){
					JOptionPane.showMessageDialog(this,"Ese tipo de dato ya se encuentra ingresado" , "Error", 2);
				}else{
					Fachada.getInstancia().guardarSerolDato(sd);
				}
			}
		}
	}
	
	private void modificar(){
		SerolDatos sd = (SerolDatos) this.jListCausaPerdidaInjerto.getSelectedValue();
		if(sd!= null){
			IUAuxiliarPaneles.jOptionMessageDialog(this, "Todos los trasplantes que esten asociados con este serol se veran afectados.", "Advertencia",IUAuxiliarPaneles.warning);
			String nueva = "";
			nueva = IUAuxiliarPaneles.jOptionPaneDialog(this, "Ingrese el nuevo nombre del dato del Serol :"+ this.activo.toString(), "Confirmar", IUAuxiliarPaneles.question);
			//nueva = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre del dato del Serol :"+ this.activo.toString(), "Confirmar", 3);
			if(nueva != null){
				if(!nueva.equalsIgnoreCase("")|| !nueva.equalsIgnoreCase(" ")){
					SerolDatos aux = new SerolDatos();
					aux.setId(this.activo.getId());
					aux.setTipo(nueva);
					if(this.activo.getDatos().contains(aux)){
						IUAuxiliarPaneles.jOptionMessageDialog(this, "El Serol que quiere ingresar ya existe", "Error",IUAuxiliarPaneles.error);
					}else{
						sd.setViejo(sd.getTipo());
						sd.setTipo(nueva);
						Fachada.getInstancia().guardarSerolDato(sd);
					}
				}
			}
		}
	}
	private void eliminar(){
		SerolDatos sd = (SerolDatos) this.jListCausaPerdidaInjerto.getSelectedValue();
		if(sd!= null){
			String respuesta = "";
			respuesta = JOptionPane.showInputDialog(this, "Esta a punto de eliminar un Dato de serol\n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
			if(respuesta==null)respuesta="No";
			if(respuesta.equalsIgnoreCase("Si")){
				boolean eliminar = Fachada.getInstancia().verificarEliminacionSerolDatos(sd);
				if(!eliminar){
					IUAuxiliarPaneles.jOptionMessageDialog(this, "Existe un trasplante o un donante con ese dato.", "Advertencia",IUAuxiliarPaneles.warning);
				}else{
					Fachada.getInstancia().eliminarSerolDato(sd);
				}
			}
		}
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
