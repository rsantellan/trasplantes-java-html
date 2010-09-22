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

import uy.transplante.dominio.ResultadoPBR;

import logica.Fachada;

public class IUManejarResultadoPBR extends JFrame implements java.util.Observer {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;

	private Fachada instancia = Fachada.getInstancia();
	private JScrollPane jScrollPaneResultadoPBR = null;
	private JList jListResultadoPBR = null;
	private JLabel jLabelAntecedentes = null;
	private JButton jButtonAgregar = null;
	private JButton jButtonModificar = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonAtras = null;
	
	private ArrayList<ResultadoPBR> lista = new ArrayList<ResultadoPBR>();  //  @jve:decl-index=0:
	/**
	 * This is the default constructor
	 */
	public IUManejarResultadoPBR() {
		super();
		initialize();
		cargarDatos();
	}

	private void cargarDatos(){
		this.lista = Fachada.getInstancia().obtenerTodosResultadosPBR();
		this.jListResultadoPBR.setListData(this.lista.toArray());
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
		this.setTitle("Manejar los tipos de Resultados PBR");
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
			jLabelAntecedentes.setBounds(new Rectangle(208, 18, 152, 22));
			jLabelAntecedentes.setFont(new Font("Dialog", Font.BOLD, 18));
			jLabelAntecedentes.setText("Resultados PBR");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(204, 255, 204));
			jContentPane.add(getJScrollPaneResultadoPBR(), null);
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
	 * This method initializes jScrollPaneResultadoPBR	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneResultadoPBR() {
		if (jScrollPaneResultadoPBR == null) {
			jScrollPaneResultadoPBR = new JScrollPane();
			jScrollPaneResultadoPBR.setBounds(new Rectangle(20, 51, 537, 253));
			jScrollPaneResultadoPBR.setViewportView(getJListResultadoPBR());
		}
		return jScrollPaneResultadoPBR;
	}

	/**
	 * This method initializes jListResultadoPBR	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJListResultadoPBR() {
		if (jListResultadoPBR == null) {
			jListResultadoPBR = new JList();
		}
		return jListResultadoPBR;
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
		this.instancia.eliminarObservador(this);
		this.dispose();
	}
	
	private void agregar(){
		String grado = "";
		grado = JOptionPane.showInputDialog(this, "Ingrese el nombre de el nuevo grado del Resultado PBR:", "Confirmar", 3);
		String criterio = JOptionPane.showInputDialog(this, "Ingrese el nombre de el nuevo criterio del Resultado PBR:", "Confirmar", 3);
		if(grado != null && criterio != null){
			if((!grado.equalsIgnoreCase("")|| !grado.equalsIgnoreCase(" ")) && (!criterio.equalsIgnoreCase("")|| !criterio.equalsIgnoreCase(" "))){
				ResultadoPBR r = new ResultadoPBR();
				r.setGrado(grado);
				r.setCriterio(criterio);
				if(this.lista.contains(r)){
					JOptionPane.showMessageDialog(this,"El Resultado PBR que quiere ingresar ya existe" , "Error", 2);
				}else{
					Fachada.getInstancia().guardarResultadoPBR(r);
				}
			}else{
				JOptionPane.showMessageDialog(this,"No puede dejar datos en blancos" , "Error", 2);
				
			}
		}
	}
	
	private void modificar(){
		ResultadoPBR r = (ResultadoPBR) this.jListResultadoPBR.getSelectedValue();
		if(r!= null){
			JOptionPane.showMessageDialog(this,"Todos los Transplantes que esten relacionados con este Resultado PBR pasaran a estar relacionados con la nueva" , "Atencion", 2);
			JOptionPane.showMessageDialog(this,"Si quiere dejar un dato igual simplemente deje el dato en blanco" , "Atencion", 2);
			String grado = "";
			grado = JOptionPane.showInputDialog(this, "Ingrese el nuevo grado del Resultado PBR :", "Confirmar", 3);
			String criterio = "";
			criterio = JOptionPane.showInputDialog(this, "Ingrese el nuevo criterio del Resultado PBR :", "Confirmar", 3);
			if(grado != null && criterio != null){
				ResultadoPBR aux = new ResultadoPBR();
				aux.setId(r.getId());
				if(!grado.equalsIgnoreCase("")&& !grado.equalsIgnoreCase(" ")){
					aux.setGrado(grado);
				}else{
					aux.setGrado(r.getGrado());
				}
				if(!criterio.equalsIgnoreCase("") && !criterio.equalsIgnoreCase(" ")){
					aux.setCriterio(criterio);
				}else{
					aux.setCriterio(r.getCriterio());
				}
				if(this.lista.contains(aux)){
					JOptionPane.showMessageDialog(this,"El Resultado PBR que quiere ingresar ya existe" , "Error", 2);
				}else{
					Fachada.getInstancia().guardarResultadoPBR(aux);
				}
			}
		}
	}
	private void eliminar(){
		ResultadoPBR r = (ResultadoPBR) this.jListResultadoPBR.getSelectedValue();
		if(r!= null){
			String respuesta = "";
			respuesta = JOptionPane.showInputDialog(this, "Está a punto de eliminar un Resultado PBR\n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
			if(respuesta==null)respuesta="No";
			if(respuesta.equalsIgnoreCase("Si")){
				boolean eliminar = Fachada.getInstancia().verificarEliminacionResultadoPBR(r);
				if(!eliminar){
					JOptionPane.showMessageDialog(this,"Existe por lo menos un trasplante con este Resultado PBR.\nPor lo tanto no se puede borrar." , "Error", 2);
				}else{
					Fachada.getInstancia().eliminarResultadoPBR(r);
				}
			}
		}
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
