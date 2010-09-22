package uy.transplante.iu.basico;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import uy.transplante.auxiliares.fechas.ManejoFechas;
import uy.transplante.dominio.EvolucionInjerto;
import uy.transplante.dominio.EvolucionInjertoResultadoPBR;
import uy.transplante.dominio.RaTratamiento;
import uy.transplante.dominio.ResultadoPBR;

import com.toedter.calendar.JDateChooser;


import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Calendar;

import logica.Fachada;
import java.awt.Color;

public class IUInjertoEvolucion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JDateChooser jDateChooserFechaControl = null;
	private JLabel jLabelFecha = null;
	private JComboBox jComboBoxPBR = null;
	private JScrollPane jScrollPaneTratamiento = null;
	private JTextArea jTextAreaTratamiento = null;
	private JCheckBox jCheckBoxGPNovo = null;
	private JCheckBox jCheckBoxRA = null;
	private JCheckBox jCheckBoxRC = null;
	private JButton jButtonSalir = null;
	private JButton jButtonGuardar = null;
	private int idPreTrasplante;
	private JButton jButtonUsar = null;
	private JButton jButtonQuitar = null;
	private JComboBox jComboBoxPBRUsados = null;
	private EvolucionInjerto viejo = null;
	private JLabel jLabelFechaOK = null;
	private JLabel jLabelTratamiento = null;
	private JCheckBox jCheckBoxGPNovoRecidiva = null;
	private JLabel jLabelPBR = null;
	private JLabel jLabelOtros = null;
	private JComboBox jComboBoxTratamiento = null;
	private boolean esTrasplante;
	private Calendar fecha = null;
	private JButton jButtonEliminar = null;

	/**
	 * This is the default constructor
	 */
	public IUInjertoEvolucion(int idPretrasplante, EvolucionInjerto e,
			boolean ver, boolean esTrasplante) {
		super();
		initialize();
		cargarDatosFijos();
		this.idPreTrasplante = idPretrasplante;
		this.esTrasplante = esTrasplante;
		this.jLabelFechaOK.setVisible(false);
		this.getJButtonEliminar().setVisible(false);
		if (ver) {
			this.jButtonGuardar.setVisible(false);
		}
		if (e != null) {
			this.cargar(e);
			this.viejo = e;
			if (!ver)
				this.jLabelFechaOK.setVisible(true);

		}
	}

	public IUInjertoEvolucion(int idPretrasplante, Calendar fecha,
			EvolucionInjerto e, boolean ver, boolean esTrasplante) {
		super();
		this.fecha = fecha;
		initialize();
		cargarDatosFijos();
		this.idPreTrasplante = idPretrasplante;
		this.esTrasplante = esTrasplante;
		this.jLabelFechaOK.setVisible(false);
		this.jButtonEliminar.setVisible(false);
		if (ver) {
			this.jButtonGuardar.setVisible(false);
		}
		if (e != null) {
			this.cargar(e);
			this.viejo = e;
			if (!ver)
				this.jLabelFechaOK.setVisible(true);
			if (esTrasplante)
				this.jButtonEliminar.setVisible(true);
		}
	}

	private void cargar(EvolucionInjerto e) {
		this.jDateChooserFechaControl.setCalendar(e.getFecha());
		for (int x = 0; x < e.getListaPBR().size(); x++) {
			this.jComboBoxPBRUsados.addItem(e.getListaPBR().get(x).getPbr());
			this.jComboBoxPBR.removeItem(e.getListaPBR().get(x).getPbr());
		}
		this.jComboBoxTratamiento.setSelectedItem(e.getTratamiento());
		this.jCheckBoxRA.setSelected(e.isRa());
		this.jCheckBoxRC.setSelected(e.isRc());
		this.jCheckBoxGPNovo.setSelected(e.isGpNovo());
		this.jCheckBoxGPNovoRecidiva.setSelected(e.isRecidivaGp());
		this.jTextAreaTratamiento.setText(e.getTmCual());
	}

	private void cargarDatosFijos() {
		ArrayList<ResultadoPBR> listaPBR = Fachada.getInstancia()
				.obtenerTodosResultadosPBR();
		for (int i = 0; i < listaPBR.size(); i++) {
			this.jComboBoxPBR.addItem(listaPBR.get(i));
		}
		ArrayList<RaTratamiento> listaRa = Fachada.getInstancia()
				.obtenerTodosRaTratamiento();
		for (int x = 0; x < listaRa.size(); x++) {
			this.jComboBoxTratamiento.addItem(listaRa.get(x));
		}
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(725, 411);
		this.setResizable(false);
		this.setLocation(new Point(100, 0));
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Evolucion del Injerto");
		if (this.fecha != null) {
			this.setTitle(this.getTitle() + " la fecha del trasplante es :"
					+ ManejoFechas.FORMATOESPANOL.format(this.fecha.getTime()));
		}
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelOtros = new JLabel();
			jLabelOtros.setBounds(new Rectangle(112, 187, 104, 30));
			jLabelOtros.setText("Otros :");
			jLabelPBR = new JLabel();
			jLabelPBR.setBounds(new Rectangle(11, 83, 87, 26));
			jLabelPBR.setText("PBR :");
			jLabelTratamiento = new JLabel();
			jLabelTratamiento.setBounds(new Rectangle(126, 141, 90, 26));
			jLabelTratamiento.setText("Tratamiento :");
			jLabelFechaOK = new JLabel();
			jLabelFechaOK.setBounds(new Rectangle(547, 23, 163, 28));
			jLabelFechaOK.setForeground(new Color(255, 51, 51));
			jLabelFechaOK
					.setText("<HTML>Aunque modifique la fecha se guardara con la original</HTML>");
			jLabelFecha = new JLabel();
			jLabelFecha.setBounds(new Rectangle(165, 21, 128, 34));
			jLabelFecha.setText("Fecha del control:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 204));
			jContentPane.add(getJDateChooserFechaControl(), null);
			jContentPane.add(jLabelFecha, null);
			jContentPane.add(getJComboBoxPBR(), null);
			jContentPane.add(getJScrollPaneTratamiento(), null);
			jContentPane.add(getJCheckBoxGPNovo(), null);
			jContentPane.add(getJCheckBoxRA(), null);
			jContentPane.add(getJCheckBoxRC(), null);
			jContentPane.add(getJButtonSalir(), null);
			jContentPane.add(getJButtonGuardar(), null);
			jContentPane.add(getJButtonUsar(), null);
			jContentPane.add(getJButtonQuitar(), null);
			jContentPane.add(getJComboBoxPBRUsados(), null);
			jContentPane.add(jLabelFechaOK, null);
			jContentPane.add(jLabelTratamiento, null);
			jContentPane.add(getJCheckBoxGPNovoRecidiva(), null);
			jContentPane.add(jLabelPBR, null);
			jContentPane.add(jLabelOtros, null);
			jContentPane.add(getJComboBoxTratamiento(), null);
			jContentPane.add(getJButtonEliminar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jDateChooserFechaControl
	 * 
	 * @return com.toedter.calendar.JDateChooser
	 */
	private JDateChooser getJDateChooserFechaControl() {
		if (jDateChooserFechaControl == null) {
			jDateChooserFechaControl = new JDateChooser();
			jDateChooserFechaControl.setBounds(new Rectangle(320, 20, 221, 39));
		}
		return jDateChooserFechaControl;
	}

	/**
	 * This method initializes jComboBoxPBR
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxPBR() {
		if (jComboBoxPBR == null) {
			jComboBoxPBR = new JComboBox();
			jComboBoxPBR.setBounds(new Rectangle(106, 81, 288, 35));
		}
		return jComboBoxPBR;
	}

	/**
	 * This method initializes jScrollPaneTratamiento
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneTratamiento() {
		if (jScrollPaneTratamiento == null) {
			jScrollPaneTratamiento = new JScrollPane();
			jScrollPaneTratamiento.setBounds(new Rectangle(233, 185, 280, 55));
			jScrollPaneTratamiento.setViewportView(getJTextAreaTratamiento());
		}
		return jScrollPaneTratamiento;
	}

	/**
	 * This method initializes jTextAreaTratamiento
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextAreaTratamiento() {
		if (jTextAreaTratamiento == null) {
			jTextAreaTratamiento = new JTextArea();
		}
		return jTextAreaTratamiento;
	}

	/**
	 * This method initializes jCheckBoxGPNovo
	 * 
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxGPNovo() {
		if (jCheckBoxGPNovo == null) {
			jCheckBoxGPNovo = new JCheckBox();
			jCheckBoxGPNovo.setBounds(new Rectangle(390, 267, 92, 25));
			jCheckBoxGPNovo.setBackground(new Color(255, 255, 204));
			jCheckBoxGPNovo.setText("GP de Novo");
		}
		return jCheckBoxGPNovo;
	}

	/**
	 * This method initializes jCheckBoxRA
	 * 
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxRA() {
		if (jCheckBoxRA == null) {
			jCheckBoxRA = new JCheckBox();
			jCheckBoxRA.setBounds(new Rectangle(19, 268, 127, 27));
			jCheckBoxRA.setBackground(new Color(255, 255, 204));
			jCheckBoxRA.setText("Rechazo Agudo");
		}
		return jCheckBoxRA;
	}

	/**
	 * This method initializes jCheckBoxRC
	 * 
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxRC() {
		if (jCheckBoxRC == null) {
			jCheckBoxRC = new JCheckBox();
			jCheckBoxRC.setBounds(new Rectangle(193, 268, 138, 27));
			jCheckBoxRC.setBackground(new Color(255, 255, 204));
			jCheckBoxRC.setText("Rechazo Cronico");
		}
		return jCheckBoxRC;
	}

	/**
	 * This method initializes jButtonSalir
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonSalir() {
		if (jButtonSalir == null) {
			jButtonSalir = new JButton();
			jButtonSalir.setBounds(new Rectangle(34, 322, 130, 38));
			jButtonSalir.setText("Salir");
			jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salir();
				}
			});
		}
		return jButtonSalir;
	}

	/**
	 * This method initializes jButtonGuardar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonGuardar() {
		if (jButtonGuardar == null) {
			jButtonGuardar = new JButton();
			jButtonGuardar.setBounds(new Rectangle(484, 322, 130, 38));
			jButtonGuardar.setText("Guardar");
			jButtonGuardar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							guardar();
						}
					});
		}
		return jButtonGuardar;
	}

	private void salir() {
		this.dispose();
	}

	private void guardar() {

		boolean fechaOK = true;
		if (this.viejo == null) {
			if (this.fecha == null) {
				fechaOK = Fachada.getInstancia().fechaEvolucionInjertoCorrecta(
						this.idPreTrasplante,
						this.jDateChooserFechaControl.getCalendar());
			} else {
				Calendar aux = (Calendar) this.fecha.clone();
				aux.add(Calendar.MONTH, 1);
				aux.add(Calendar.DAY_OF_MONTH, 1);
				if (this.jDateChooserFechaControl.getCalendar().before(aux)) {
					fechaOK = true;
				} else {
					fechaOK = false;
					JOptionPane
							.showMessageDialog(
									this,
									"La fecha tiene que estar comprendida entre la fecha del trasplante y un mes despues de este.",
									"Atencion", 2);
				}
			}
		}
		if (fechaOK) {
			EvolucionInjerto aux = new EvolucionInjerto();
			aux.setIdPretrasplante(this.idPreTrasplante);
			if (this.viejo == null) {
				aux.setFecha(this.jDateChooserFechaControl.getCalendar());
			} else {
				aux.setFecha(this.viejo.getFecha());
			}
			if (this.jComboBoxPBRUsados.getItemCount() > 0) {
				for (int x = 0; x < this.jComboBoxPBRUsados.getItemCount(); x++) {
					ResultadoPBR auxPBR = (ResultadoPBR) this.jComboBoxPBRUsados
							.getItemAt(x);
					EvolucionInjertoResultadoPBR auxEvPBR = new EvolucionInjertoResultadoPBR();
					auxEvPBR.setFecha(aux.getFecha());
					auxEvPBR.setIdPretrasplante(aux.getIdPretrasplante());
					auxEvPBR.setPbr(auxPBR);
					aux.getListaPBR().add(auxEvPBR);
				}
			}
			aux.setTratamiento((RaTratamiento) this.jComboBoxTratamiento
					.getSelectedItem());
			aux.setTmCual(this.jTextAreaTratamiento.getText());
			aux.setGpNovo(this.jCheckBoxGPNovo.isSelected());
			aux.setRecidivaGp(this.jCheckBoxGPNovoRecidiva.isSelected());
			aux.setRa(this.jCheckBoxRA.isSelected());
			aux.setRc(this.jCheckBoxRC.isSelected());
			aux.setEnTrasplante(this.esTrasplante);
			Fachada.getInstancia().guardarEvolucionInjerto(aux);
			this.salir();
		}
	}

	/**
	 * This method initializes jButtonUsar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonUsar() {
		if (jButtonUsar == null) {
			jButtonUsar = new JButton();
			jButtonUsar.setBounds(new Rectangle(406, 82, 74, 20));
			jButtonUsar.setText("Usar");
			jButtonUsar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					usarPBR();
				}
			});
		}
		return jButtonUsar;
	}

	/**
	 * This method initializes jButtonQuitar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonQuitar() {
		if (jButtonQuitar == null) {
			jButtonQuitar = new JButton();
			jButtonQuitar.setBounds(new Rectangle(406, 106, 74, 20));
			jButtonQuitar.setText("Quitar");
			jButtonQuitar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							quitarPBR();
						}
					});
		}
		return jButtonQuitar;
	}

	/**
	 * This method initializes jComboBoxPBRUsados
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxPBRUsados() {
		if (jComboBoxPBRUsados == null) {
			jComboBoxPBRUsados = new JComboBox();
			jComboBoxPBRUsados.setBounds(new Rectangle(485, 82, 224, 32));
		}
		return jComboBoxPBRUsados;
	}

	private void usarPBR() {
		if (this.jComboBoxPBR.getItemCount() > 0) {
			ResultadoPBR aux = (ResultadoPBR) this.jComboBoxPBR
					.getSelectedItem();
			this.jComboBoxPBRUsados.addItem(aux);
			this.jComboBoxPBR.removeItem(aux);
		}
	}

	private void quitarPBR() {
		if (this.jComboBoxPBRUsados.getItemCount() > 0) {
			ResultadoPBR aux = (ResultadoPBR) this.jComboBoxPBRUsados
					.getSelectedItem();
			this.jComboBoxPBR.addItem(aux);
			this.jComboBoxPBRUsados.removeItem(aux);
		}
	}

	/**
	 * This method initializes jCheckBoxGPNovoRecidiva
	 * 
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxGPNovoRecidiva() {
		if (jCheckBoxGPNovoRecidiva == null) {
			jCheckBoxGPNovoRecidiva = new JCheckBox();
			jCheckBoxGPNovoRecidiva.setBounds(new Rectangle(509, 267, 105, 27));
			jCheckBoxGPNovoRecidiva.setBackground(new Color(255, 255, 204));
			jCheckBoxGPNovoRecidiva.setText("Recidiva GP");
		}
		return jCheckBoxGPNovoRecidiva;
	}

	/**
	 * This method initializes jComboBoxTratamiento
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxTratamiento() {
		if (jComboBoxTratamiento == null) {
			jComboBoxTratamiento = new JComboBox();
			jComboBoxTratamiento.setBounds(new Rectangle(232, 140, 280, 34));
		}
		return jComboBoxTratamiento;
	}

	/**
	 * This method initializes jButtonEliminar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonEliminar() {
		if (jButtonEliminar == null) {
			jButtonEliminar = new JButton();
			jButtonEliminar.setBounds(new Rectangle(276, 322, 130, 38));
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
		String respuesta = "";
		respuesta = JOptionPane
				.showInputDialog(
						this,
						"Está a punto de eliminar una evolucion del injerto\n(Ingrese SI para eliminar) Confirmar: ",
						"Confirmar", 1);
		if (respuesta == null)
			respuesta = "No";
		if (respuesta.equalsIgnoreCase("Si")) {
			Fachada.getInstancia().eliminarEvolucionInjerto(this.viejo);
			this.salir();
		}
	}
} // @jve:decl-index=0:visual-constraint="10,10"
