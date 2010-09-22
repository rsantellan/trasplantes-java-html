package uy.transplante.iu.paciente;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;


import uy.transplante.auxiliares.fechas.ManejoFechas;
import uy.transplante.dominio.CausaPerdidaInjerto;
import uy.transplante.dominio.Paciente;
import uy.transplante.dominio.PacientePerdidaInjerto;
import uy.transplante.dominio.PacientePreTrasplante;
import uy.transplante.logica.Fachada;

import com.toedter.calendar.JDateChooser;


import javax.swing.JDesktopPane;

public class IUPacientePerdidaInjertoIngresar extends JFrame implements
		java.util.Observer {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelFecha = null;
	private JDateChooser jDateChooserMuerte = null;
	private JLabel jLabelTipoMuerte = null;
	private JScrollPane jScrollPaneOpcionesPerdida = null;
	private JList jListOpcionesPerdida = null;
	private ArrayList<CausaPerdidaInjerto> lista; // @jve:decl-index=0:
	private Paciente miPaciente;
	private JButton jButtonAceptar = null;
	private JButton jButtonCancelar = null;
	private JDesktopPane jDesktopPanePerdidas = null;
	private JLabel jLabelPerdidas = null;
	private PacientePerdidaInjerto usado = null;
	private JScrollPane jScrollPanePerdidas = null;
	private JList jListPerdidas = null;
	private JButton jButtonEliminar = null;

	/**
	 * This is the default constructor
	 */
	public IUPacientePerdidaInjertoIngresar(Paciente p) {
		super();
		initialize();
		this.miPaciente = p;
		cargarDatos();
		Fachada.getInstancia().agregarObservador(this);
	}

	private void cargarDatos() {
		this.miPaciente.leerDatosPerdidaInjerto();
		this.lista = Fachada.getInstancia().obtenerTodasCausasPerdidaInjerto();
		this.jListOpcionesPerdida.setListData(this.lista.toArray());
		this.getJListPerdidas().setListData(
				this.miPaciente.getListaPerdidas().toArray());
		this.limpiar();
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
		this.setTitle("Perdida del injerto");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelTipoMuerte = new JLabel();
			jLabelTipoMuerte.setBounds(new Rectangle(6, 113, 198, 34));
			jLabelTipoMuerte.setText("Seleccione la forma de la perdida :");
			jLabelFecha = new JLabel();
			jLabelFecha.setBounds(new Rectangle(7, 67, 132, 33));
			jLabelFecha.setText("Fecha de la perdida :");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 204));
			jContentPane.add(jLabelFecha, null);
			jContentPane.add(getJDateChooserMuerte(), null);
			jContentPane.add(jLabelTipoMuerte, null);
			jContentPane.add(getJScrollPaneOpcionesPerdida(), null);
			jContentPane.add(getJButtonAceptar(), null);
			jContentPane.add(getJButtonCancelar(), null);
			jContentPane.add(getJDesktopPanePerdidas(), null);
			jContentPane.add(getJButtonEliminar(), null);
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
			jDateChooserMuerte.setBounds(new Rectangle(219, 70, 195, 29));
		}
		return jDateChooserMuerte;
	}

	/**
	 * This method initializes jScrollPaneOpcionesPerdida
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneOpcionesPerdida() {
		if (jScrollPaneOpcionesPerdida == null) {
			jScrollPaneOpcionesPerdida = new JScrollPane();
			jScrollPaneOpcionesPerdida.setBounds(new Rectangle(219, 114, 196,
					207));
			jScrollPaneOpcionesPerdida
					.setViewportView(getJListOpcionesPerdida());
		}
		return jScrollPaneOpcionesPerdida;
	}

	/**
	 * This method initializes jListOpcionesPerdida
	 * 
	 * @return javax.swing.JList
	 */
	private JList getJListOpcionesPerdida() {
		if (jListOpcionesPerdida == null) {
			jListOpcionesPerdida = new JList();
		}
		return jListOpcionesPerdida;
	}

	/**
	 * This method initializes jButtonAceptar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAceptar() {
		if (jButtonAceptar == null) {
			jButtonAceptar = new JButton();
			jButtonAceptar.setBounds(new Rectangle(332, 335, 110, 38));
			jButtonAceptar.setText("Guardar");
			jButtonAceptar
					.addActionListener(new java.awt.event.ActionListener() {
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
			jButtonCancelar.setBounds(new Rectangle(10, 335, 110, 38));
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							salir();
						}
					});
		}
		return jButtonCancelar;
	}

	public void update(Observable arg0, Object arg1) {
		Observable o = arg0;
		if (o == Fachada.getInstancia()) {
			if(Fachada.getInstancia().getLugar() == Fachada.PERDIDA_INJERTO_PACIENTE){
				this.cargarDatos();
			}
		}
	}

	public void salir() {
		Fachada.getInstancia().eliminarObservador(this);
		this.dispose();
	}

	private void confirmar() {
		if (jDateChooserMuerte.getCalendar() == null) {
			JOptionPane.showMessageDialog(this,
					"Tiene que ingresar la fecha de fallecimiento",
					"Falta información", 2);
		} else {
			CausaPerdidaInjerto c = (CausaPerdidaInjerto) this.jListOpcionesPerdida
					.getSelectedValue();
			if (c != null) {
				this.miPaciente.leerDatosBasicos();
				this.miPaciente.leerDatosPreTrasplante();
				if(this.miPaciente.getListaPreTrasplantes().size() == this.miPaciente.getListaPerdidas().size()){
					JOptionPane.showMessageDialog(this,"Todos los Pre Trasplante tienen asociada una Perdida\nde Injerto por lo tanto no se puede ingresar uno nuevo." , "Error", 2);
				}else{
					PacientePerdidaInjerto pi = new PacientePerdidaInjerto();
					pi.setThe(this.miPaciente.getThe());
					pi.setFechaPerdida(jDateChooserMuerte.getCalendar());
					pi.setCausa(null);
					pi.setNumCausa(c.getId());
					PacientePreTrasplante pt = (PacientePreTrasplante)this.miPaciente.getListaPreTrasplantes().get(this.miPaciente.getListaPreTrasplantes().size()-1);
					pi.setNumPreTrasplante(pt.getId());
					Fachada.getInstancia().guardarPerdidaInjertoPaciente(pi);
					this.usado = null;
					JOptionPane.showMessageDialog(this,
							"Perdida del injerto ingresada con exito.", "OK", 3);
					this.limpiar();
				}
				
			} else {
				JOptionPane
						.showMessageDialog(
								this,
								"Tiene que seleccionar una forma de perdida del injerto.",
								"Error", 2);
			}
		}
	}

	/**
	 * This method initializes jDesktopPanePerdidas
	 * 
	 * @return javax.swing.JDesktopPane
	 */
	private JDesktopPane getJDesktopPanePerdidas() {
		if (jDesktopPanePerdidas == null) {
			jLabelPerdidas = new JLabel();
			jLabelPerdidas.setBounds(new Rectangle(5, 10, 183, 34));
			jLabelPerdidas.setText("Perdidas de injerto anteriores : ");
			jDesktopPanePerdidas = new JDesktopPane();
			jDesktopPanePerdidas.setBounds(new Rectangle(9, 10, 405, 51));
			jDesktopPanePerdidas.add(jLabelPerdidas, null);
			jDesktopPanePerdidas.add(getJScrollPanePerdidas(), null);
		}
		return jDesktopPanePerdidas;
	}

	private void cargarPerdida() {
		this.usado = (PacientePerdidaInjerto) this.getJListPerdidas()
				.getSelectedValue();
		if (this.usado == null)
			return;
		this.getJDateChooserMuerte().setCalendar(this.usado.getFechaPerdida());
		int pos = this.lista.indexOf(this.usado.getCausa());
		this.jListOpcionesPerdida.setSelectedIndex(pos);
	}

	private void limpiar() {
		this.jDateChooserMuerte.setCalendar(new GregorianCalendar());
		this.jListOpcionesPerdida.clearSelection();
	}

	/**
	 * This method initializes jScrollPanePerdidas
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPanePerdidas() {
		if (jScrollPanePerdidas == null) {
			jScrollPanePerdidas = new JScrollPane();
			jScrollPanePerdidas.setBounds(new Rectangle(209, 13, 187, 30));
			jScrollPanePerdidas.setViewportView(getJListPerdidas());
		}
		return jScrollPanePerdidas;
	}

	/**
	 * This method initializes jListPerdidas
	 * 
	 * @return javax.swing.JList
	 */
	private JList getJListPerdidas() {
		if (jListPerdidas == null) {
			jListPerdidas = new JList();
			jListPerdidas
					.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
						public void valueChanged(
								javax.swing.event.ListSelectionEvent e) {
							cargarPerdida();
						}
					});
		}
		return jListPerdidas;
	}

	/**
	 * This method initializes jButtonEliminar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonEliminar() {
		if (jButtonEliminar == null) {
			jButtonEliminar = new JButton();
			jButtonEliminar.setBounds(new Rectangle(180, 335, 110, 38));
			jButtonEliminar.setText("Eliminar");
			jButtonEliminar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							eliminar();
						}
					});
		}
		return jButtonEliminar;
	}

	private void eliminar() {
		this.usado = (PacientePerdidaInjerto) this.getJListPerdidas()
				.getSelectedValue();
		if (this.usado == null)
			return;
		if(!this.miPaciente.getListaPerdidas().get(this.miPaciente.getListaPerdidas().size()-1).equals(this.usado)){
			JOptionPane.showMessageDialog(this,"Solo puede eliminar la ultima perdida del injerto.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		String respuesta = "";
		respuesta = JOptionPane.showInputDialog(this,
				"Está a punto de eliminar a la perdida del injerto de la fecha : "
						+ ManejoFechas.FORMATOESPANOL.format(this.usado
								.getFechaPerdida().getTime())
						+ "\n(Ingrese SI para eliminar) Confirmar: ",
				"Confirmar", 1);
		if (respuesta == null)
			respuesta = "No";
		if (respuesta.equalsIgnoreCase("Si")) {
			Fachada.getInstancia().eliminarPerdidaInjertoPaciente(this.usado);
			this.limpiar();
			JOptionPane.showMessageDialog(this,
					"Perdida del injerto eliminada con exito.", "OK", 3);
		}
	}
} // @jve:decl-index=0:visual-constraint="10,10"
