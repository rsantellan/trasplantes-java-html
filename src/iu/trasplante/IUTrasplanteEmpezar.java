package iu.trasplante;

import iu.paciente.IUPacientePreTrasplante;

import java.awt.Color;
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
import dominio.Paciente;
import dominio.PacientePreTrasplante;

public class IUTrasplanteEmpezar extends JFrame implements java.util.Observer{

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelPaciente = null;
	private JButton jButtonEmpezar = null;
	private JButton jButtonModificar = null;
	private JButton jButtonAtras = null;
	private JButton jButtonVer = null;
	private Paciente paciente;
	private JScrollPane jScrollPaneLista = null;
	private JList jListLista = null;
	private JButton jButtonEliminar = null;
	private boolean inicio = true;

	/**
	 * This is the default constructor
	 */
	public IUTrasplanteEmpezar(Paciente p) {
		super();
		initialize();
		this.paciente = p;
		this.paciente.leerDatosBasicos();
		Fachada.getInstancia().agregarObservador(this);
		this.jLabelPaciente.setText("Paciente:"+p.toString());
		this.jListLista.setListData(p.getListaPreTrasplantes().toArray());
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(510, 339);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Empezar o continuar trasplante");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelPaciente = new JLabel();
			jLabelPaciente.setBounds(new Rectangle(15, 12, 452, 36));
			jLabelPaciente.setText("Paciente:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 204));
			jContentPane.add(jLabelPaciente, null);
			jContentPane.add(getJButtonEmpezar(), null);
			jContentPane.add(getJButtonModificar(), null);
			jContentPane.add(getJButtonAtras(), null);
			jContentPane.add(getJButtonVer(), null);
			jContentPane.add(getJScrollPaneLista(), null);
			jContentPane.add(getJButtonEliminar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButtonEmpezar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonEmpezar() {
		if (jButtonEmpezar == null) {
			jButtonEmpezar = new JButton();
			jButtonEmpezar.setBounds(new Rectangle(207, 76, 98, 34));
			jButtonEmpezar.setText("Empezar");
			jButtonEmpezar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					empezar();
				}
			});
		}
		return jButtonEmpezar;
	}

	/**
	 * This method initializes jButtonModificar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonModificar() {
		if (jButtonModificar == null) {
			jButtonModificar = new JButton();
			jButtonModificar.setBounds(new Rectangle(371, 182, 98, 34));
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
	 * This method initializes jButtonAtras	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAtras() {
		if (jButtonAtras == null) {
			jButtonAtras = new JButton();
			jButtonAtras.setBounds(new Rectangle(24, 75, 98, 34));
			jButtonAtras.setText("Atras");
			jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salir();
				}
			});
		}
		return jButtonAtras;
	}

	/**
	 * This method initializes jButtonVer	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonVer() {
		if (jButtonVer == null) {
			jButtonVer = new JButton();
			jButtonVer.setBounds(new Rectangle(372, 238, 98, 34));
			jButtonVer.setText("Ver");
			jButtonVer.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ver();
				}
			});
		}
		return jButtonVer;
	}

	private void salir(){
		Fachada.getInstancia().eliminarObservador(this);
		this.dispose();
	}
	
	private void empezar(){
		if(this.paciente.getListaPreTrasplantes().size() -1 == this.paciente.getListaPerdidas().size()){
			JOptionPane.showMessageDialog(this,"Existe un Pre Trasplante que no tiene asociada una Perdida\nde Injerto por lo tanto no se puede ingresar uno nuevo.\nPor lo tanto no se puede borrar." , "Error", 2);
		}else{
			IUPacientePreTrasplante iuPre = new IUPacientePreTrasplante(this.paciente);
			iuPre.setVisible(true);
		}
		
	}

	/**
	 * This method initializes jScrollPaneLista	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneLista() {
		if (jScrollPaneLista == null) {
			jScrollPaneLista = new JScrollPane();
			jScrollPaneLista.setBounds(new Rectangle(19, 132, 332, 143));
			jScrollPaneLista.setViewportView(getJListLista());
		}
		return jScrollPaneLista;
	}

	/**
	 * This method initializes jListLista	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJListLista() {
		if (jListLista == null) {
			jListLista = new JList();
		}
		return jListLista;
	}

	/**
	 * This method initializes jButtonEliminar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonEliminar() {
		if (jButtonEliminar == null) {
			jButtonEliminar = new JButton();
			jButtonEliminar.setBounds(new Rectangle(372, 135, 98, 35));
			jButtonEliminar.setText("Eliminar");
			jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					eliminar();
				}
			});
		}
		return jButtonEliminar;
	}
	private void modificar(){
		PacientePreTrasplante aux = (PacientePreTrasplante) this.jListLista.getSelectedValue();
		if(aux != null){
			IUPacientePreTrasplante iuMod = new IUPacientePreTrasplante(this.paciente,aux,false);
			iuMod.setVisible(true);
		}
	}
	
	private void ver(){
		PacientePreTrasplante aux = (PacientePreTrasplante) this.jListLista.getSelectedValue();
		if(aux != null){
			IUPacientePreTrasplante iuMod = new IUPacientePreTrasplante(this.paciente,aux,true);
			iuMod.setVisible(true);
		}
	}
	
	private void eliminar(){
		PacientePreTrasplante aux = (PacientePreTrasplante) this.jListLista.getSelectedValue();
		if(aux != null){
			String respuesta = "";
			respuesta = JOptionPane.showInputDialog(this, "Está a punto de eliminar un el inicio de trasplante, se borraran todos los datos asociados.\n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
			if(respuesta==null)respuesta="No";
			if(respuesta.equalsIgnoreCase("Si")){
				Fachada.getInstancia().eliminarPreTrasplante(aux);
			}
			
		}
	}

	public void update(Observable o, Object arg) {
		if(Fachada.getInstancia().getLugar() == Fachada.PRETRASPLANTE || inicio){
			this.paciente.leerDatos();
			this.jListLista.setListData(this.paciente.getListaPreTrasplantes().toArray());
		}
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
