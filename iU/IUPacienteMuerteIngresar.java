package iU;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import logica.Fachada;

import com.toedter.calendar.JDateChooser;

import dominio.CausaMuertePaciente;
import dominio.Paciente;
import dominio.PacienteMuerte;

public class IUPacienteMuerteIngresar extends JFrame implements java.util.Observer{

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelFecha = null;
	private JDateChooser jDateChooserMuerte = null;
	private JLabel jLabelTipoMuerte = null;
	private JScrollPane jScrollPaneOpcionesMuerte = null;
	private JList jListOpcionesMuerte = null;
	private ArrayList<CausaMuertePaciente> lista;
	private Paciente miPaciente;
	private JButton jButtonAceptar = null;
	private JButton jButtonCancelar = null;
	private JCheckBox jCheckBoxTRFuncionando = null;
	

	/**
	 * This is the default constructor
	 */
	public IUPacienteMuerteIngresar(Paciente p) {
		super();
		initialize();
		cargarDatos();
		this.miPaciente = p;
		Fachada.getInstancia().agregarObservador(this);
	}

	private void cargarDatos(){
		this.lista = Fachada.getInstancia().obtenerTodasCausaMuertePaciente();
		this.jListOpcionesMuerte.setListData(this.lista.toArray());
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(468, 420);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Muerte del Paciente");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelTipoMuerte = new JLabel();
			jLabelTipoMuerte.setBounds(new Rectangle(4, 103, 184, 34));
			jLabelTipoMuerte.setText("Seleccione la causa de muerte :");
			jLabelFecha = new JLabel();
			jLabelFecha.setBounds(new Rectangle(5, 21, 116, 33));
			jLabelFecha.setText("Fecha de muerte :");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 204));
			jContentPane.add(jLabelFecha, null);
			jContentPane.add(getJDateChooserMuerte(), null);
			jContentPane.add(jLabelTipoMuerte, null);
			jContentPane.add(getJScrollPaneOpcionesMuerte(), null);
			jContentPane.add(getJButtonAceptar(), null);
			jContentPane.add(getJButtonCancelar(), null);
			jContentPane.add(getJCheckBoxTRFuncionando(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jDateChooserMuerte	
	 * 	
	 * @return com.toedter.calendar.JDateChooser	
	 */
	private JDateChooser getJDateChooserMuerte() {
		if (jDateChooserMuerte == null) {
			jDateChooserMuerte = new JDateChooser();
			jDateChooserMuerte.setBounds(new Rectangle(217, 24, 195, 29));
		}
		return jDateChooserMuerte;
	}

	/**
	 * This method initializes jScrollPaneOpcionesMuerte	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneOpcionesMuerte() {
		if (jScrollPaneOpcionesMuerte == null) {
			jScrollPaneOpcionesMuerte = new JScrollPane();
			jScrollPaneOpcionesMuerte.setBounds(new Rectangle(218, 101, 196, 213));
			jScrollPaneOpcionesMuerte.setViewportView(getJListOpcionesMuerte());
		}
		return jScrollPaneOpcionesMuerte;
	}

	/**
	 * This method initializes jListOpcionesMuerte	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJListOpcionesMuerte() {
		if (jListOpcionesMuerte == null) {
			jListOpcionesMuerte = new JList();
		}
		return jListOpcionesMuerte;
	}

	/**
	 * This method initializes jButtonAceptar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAceptar() {
		if (jButtonAceptar == null) {
			jButtonAceptar = new JButton();
			jButtonAceptar.setBounds(new Rectangle(320, 336, 110, 38));
			jButtonAceptar.setText("Confirmar");
			jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					confirmar();
				}
			});
		}
		return jButtonAceptar;
	}

	/**
	 * This method initializes jButtonCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setBounds(new Rectangle(70, 336, 110, 38));
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salir();
				}
			});
		}
		return jButtonCancelar;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Observable o = arg0;
		if(o==Fachada.getInstancia()){
			this.cargarDatos();
		}
	}

	public void salir(){
		Fachada.getInstancia().EliminarObservador(this);
		this.dispose();
	}
	
	private void confirmar(){
		if(jDateChooserMuerte.getCalendar() == null){
			JOptionPane.showMessageDialog(this,"Tiene que ingresar la fecha de fallecimiento" , "Falta información", 2);
		}else{
			CausaMuertePaciente c = (CausaMuertePaciente) this.jListOpcionesMuerte.getSelectedValue();
			if(c!= null){
				PacienteMuerte pm = new PacienteMuerte();
				pm.setThe(this.miPaciente.getThe());
				pm.setFechaMuerte(jDateChooserMuerte.getCalendar());
				pm.setCausa(null);
				pm.setNumCausa(c.getId());
				pm.setTrFuncionando(this.jCheckBoxTRFuncionando.isSelected());
				Fachada.getInstancia().guardarMuertePaciente(pm);
				this.salir();
			}
		}
	}

	/**
	 * This method initializes jCheckBoxTRFuncionando	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTRFuncionando() {
		if (jCheckBoxTRFuncionando == null) {
			jCheckBoxTRFuncionando = new JCheckBox();
			jCheckBoxTRFuncionando.setBounds(new Rectangle(5, 63, 200, 32));
			jCheckBoxTRFuncionando.setBackground(new Color(255, 255, 204));
			jCheckBoxTRFuncionando.setText("Trasplante funcionando");
		}
		return jCheckBoxTRFuncionando;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
