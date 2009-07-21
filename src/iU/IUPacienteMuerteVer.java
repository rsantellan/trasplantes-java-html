package iU;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import logica.Fachada;
import auxiliares.ManejoFechas;
import dominio.Paciente;

public class IUPacienteMuerteVer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelPaciente = null;
	private JLabel jLabelFecha = null;
	private JLabel jLabelCausa = null;
	private Paciente miPaciente;
	private boolean vista;
	private JButton jButtonEliminar = null;
	private JButton jButtonSalir = null;
	private JLabel jLabelFuncionando = null;
	/**
	 * This is the default constructor
	 */
	public IUPacienteMuerteVer(Paciente p, boolean v) {
		super();
		initialize();
		miPaciente = p;
		vista = v;
		cargarDatos();
	}
	
	private void cargarDatos(){
		//miPaciente.getMuertePaciente().leer();
		this.jLabelPaciente.setText("El paciente :" + miPaciente.toString());
		this.jLabelFecha.setText("Fallecion en la fecha : " + ManejoFechas.formatoEspanol.format(miPaciente.getMuertePaciente().getFechaMuerte().getTime()));
		this.jLabelCausa.setText("De : " + miPaciente.getMuertePaciente().getCausa().toString());
		if(this.miPaciente.getMuertePaciente().isTrFuncionando()){
			this.jLabelFuncionando.setText("El trasplante estaba funcionando.");
		}else{
			this.jLabelFuncionando.setText("El trasplante no estaba funcionando.");
		}
		if (!this.vista){
			this.jButtonEliminar.setVisible(false);
			this.jButtonSalir.setVisible(false);
		}
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(440, 294);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Muerte de el paciente");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelFuncionando = new JLabel();
			jLabelFuncionando.setBounds(new Rectangle(15, 162, 394, 32));
			jLabelFuncionando.setText("");
			jLabelCausa = new JLabel();
			jLabelCausa.setBounds(new Rectangle(15, 113, 394, 39));
			jLabelCausa.setText("");
			jLabelFecha = new JLabel();
			jLabelFecha.setBounds(new Rectangle(15, 59, 398, 34));
			jLabelFecha.setText("");
			jLabelPaciente = new JLabel();
			jLabelPaciente.setBounds(new Rectangle(13, 13, 401, 30));
			jLabelPaciente.setText("");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 204));
			jContentPane.add(jLabelPaciente, null);
			jContentPane.add(jLabelFecha, null);
			jContentPane.add(jLabelCausa, null);
			jContentPane.add(getJButtonEliminar(), null);
			jContentPane.add(getJButtonSalir(), null);
			jContentPane.add(jLabelFuncionando, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButtonEliminar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonEliminar() {
		if (jButtonEliminar == null) {
			jButtonEliminar = new JButton();
			jButtonEliminar.setBounds(new Rectangle(280, 208, 124, 30));
			jButtonEliminar.setText("Borrar Datos");
			jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					borrar();
				}
			});
		}
		return jButtonEliminar;
	}

	/**
	 * This method initializes jButtonSalir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSalir() {
		if (jButtonSalir == null) {
			jButtonSalir = new JButton();
			jButtonSalir.setBounds(new Rectangle(30, 208, 124, 30));
			jButtonSalir.setText("Atras");
			jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salir();
				}
			});
		}
		return jButtonSalir;
	}

	private void borrar(){
		Fachada.getInstancia().eliminarMuertePaciente(this.miPaciente);
		this.salir();
	}
	
	private void salir(){
		this.dispose();
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
