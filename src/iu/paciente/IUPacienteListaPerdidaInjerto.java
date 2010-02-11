package iu.paciente;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.Rectangle;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import dominio.Paciente;
import dominio.PacientePerdidaInjerto;

import java.awt.Color;
import java.util.ArrayList;

public class IUPacienteListaPerdidaInjerto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPane = null;
	private JList jListPerdidas = null;
	/**
	 * This is the default constructor
	 */
	public IUPacienteListaPerdidaInjerto(Paciente p) {
		super();
		initialize();
		this.cargarDatos(p);
		
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(518, 403);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Lista de perdidas");
		
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 204));
			jContentPane.add(getJScrollPane(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(30, 15, 407, 318));
			jScrollPane.setViewportView(getJList());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jList	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJList() {
		if (jListPerdidas == null) {
			jListPerdidas = new JList();
		}
		return jListPerdidas;
	}

	private void salir(){
		this.dispose();
	}
	
	private void cargarDatos(Paciente p){
		ArrayList<PacientePerdidaInjerto> lista = new ArrayList<PacientePerdidaInjerto>();
		p.leerDatosPerdidaInjerto();
		lista = p.getListaPerdidas();
		ArrayList<String> listaMostrar = new ArrayList<String>();
		for(PacientePerdidaInjerto aux : lista){
			String mostrar = "";
			mostrar = aux.toString() + " " + aux.getCausa().getDetalle();
			listaMostrar.add(mostrar);
		}
		if(lista.size() > 0){
			this.jListPerdidas.setListData(listaMostrar.toArray());
		}else{
			this.salir();
		}
		
		
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
