package iu.evolucion;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.util.Calendar;
import java.util.GregorianCalendar;

import auxiliares.ManejoFechas;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import com.toedter.calendar.JDateChooser;

import dominio.EvolucionTrasplanteEcografia;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;

import logica.Fachada;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class IUEvolucionEcografiaManejar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelFecha = null;
	private JDateChooser jDateChooserFecha = null;
	private JLabel jLabelEstructura = null;
	private JLabel jLabelDilatacion = null;
	private JRadioButton jRadioButtonSiDilatacion = null;
	private JRadioButton jRadioButtonNoDilatacion = null;
	private JLabel jLabelColecciones = null;
	private JRadioButton jRadioButtonSiLitiasin = null;
	private JRadioButton jRadioButtonNoLitiasin = null;
	private JLabel jLabelEjeArterial = null;
	private JLabel jLabelIndice = null;
	private JTextField jTextFieldEspesor = null;
	private JButton jButtonAtras = null;
	private JButton jButtonGuardar = null;
	private int idTrasplante;
	private Calendar fecha = new GregorianCalendar();
	private EvolucionTrasplanteEcografia usado = null;
	private JButton jButtonEliminar = null;
	private JTextField jTextFieldDiametros = null;
	private JScrollPane jScrollPaneTexto = null;
	private JTextArea jTextAreaVejiga = null;
	private JLabel jLabel = null;
	private JScrollPane jScrollPane = null;
	private JTextArea jTextAreaOtros = null;

	/**
	 * This is the default constructor
	 */
	public IUEvolucionEcografiaManejar(int idTrasplante, Calendar fecha) {
		super();
		initialize();
		this.idTrasplante = idTrasplante;
		this.fecha = fecha;
		cargarDatos();
	}

	private void cargarDatos() {
		this.getJDateChooserFecha().setCalendar(this.fecha);
		this.getJDateChooserFecha().setEnabled(false);
		this.usado = Fachada.getInstancia().buscarEvolucionTrasplanteEcografia(this.idTrasplante, this.fecha);
		if(usado != null){
			this.getJRadioButtonSiDilatacion().setSelected(usado.isDilatacion());
			this.getJRadioButtonNoDilatacion().setSelected(!usado.isDilatacion());
			this.getJRadioButtonSiLitiasin().setSelected(usado.isLitiasin());
			this.getJRadioButtonNoLitiasin().setSelected(!usado.isLitiasin());
			this.getJTextFieldDiametros().setText(this.usado.getDiametros());
			this.getJTextAreaVejiga().setText(this.usado.getVejiga());
			this.getJTextFieldEspesor().setText(String.valueOf(this.usado.getEspesor()));
		}else{
			this.getJButtonEliminar().setVisible(false);
			this.siLitiasin();
			this.siDilatacion();
		}
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(410, 639);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Ecografia del injerto");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(7, 328, 77, 35));
			jLabel.setText("Otros");
			jLabelIndice = new JLabel();
			jLabelIndice.setBounds(new Rectangle(5, 283, 151, 34));
			jLabelIndice.setText("Espesor control :");
			jLabelEjeArterial = new JLabel();
			jLabelEjeArterial.setBounds(new Rectangle(5, 180, 151, 34));
			jLabelEjeArterial.setText("Vejiga :");
			jLabelColecciones = new JLabel();
			jLabelColecciones.setBounds(new Rectangle(5, 140, 151, 34));
			jLabelColecciones.setText("Litiasin :");
			jLabelDilatacion = new JLabel();
			jLabelDilatacion.setBounds(new Rectangle(5, 100, 151, 34));
			jLabelDilatacion.setText("Dilatacion :");
			jLabelEstructura = new JLabel();
			jLabelEstructura.setBounds(new Rectangle(5, 60, 151, 34));
			jLabelEstructura.setText("Diametros :");
			jLabelFecha = new JLabel();
			jLabelFecha.setBounds(new Rectangle(37, 13, 78, 30));
			jLabelFecha.setText("Fecha :");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(204, 255, 204));
			jContentPane.add(jLabelFecha, null);
			jContentPane.add(getJDateChooserFecha(), null);
			jContentPane.add(jLabelEstructura, null);
			jContentPane.add(jLabelDilatacion, null);
			jContentPane.add(getJRadioButtonSiDilatacion(), null);
			jContentPane.add(getJRadioButtonNoDilatacion(), null);
			jContentPane.add(jLabelColecciones, null);
			jContentPane.add(getJRadioButtonSiLitiasin(), null);
			jContentPane.add(getJRadioButtonNoLitiasin(), null);
			jContentPane.add(jLabelEjeArterial, null);
			jContentPane.add(jLabelIndice, null);
			jContentPane.add(getJTextFieldEspesor(), null);
			jContentPane.add(getJButtonAtras(), null);
			jContentPane.add(getJButtonGuardar(), null);
			jContentPane.add(getJButtonEliminar(), null);
			jContentPane.add(getJTextFieldDiametros(), null);
			jContentPane.add(getJScrollPaneTexto(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJScrollPane(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jDateChooserFecha
	 * 
	 * @return com.toedter.calendar.JDateChooser
	 */
	private JDateChooser getJDateChooserFecha() {
		if (jDateChooserFecha == null) {
			jDateChooserFecha = new JDateChooser();
			jDateChooserFecha.setBounds(new Rectangle(123, 11, 226, 35));
		}
		return jDateChooserFecha;
	}

	/**
	 * This method initializes jRadioButtonSiDilatacion
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonSiDilatacion() {
		if (jRadioButtonSiDilatacion == null) {
			jRadioButtonSiDilatacion = new JRadioButton();
			jRadioButtonSiDilatacion.setBounds(new Rectangle(168, 100, 71, 34));
			jRadioButtonSiDilatacion.setText("Si");
			jRadioButtonSiDilatacion.setBackground(new Color(204, 255, 204));
			jRadioButtonSiDilatacion
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							siDilatacion();
						}
					});
		}
		return jRadioButtonSiDilatacion;
	}

	/**
	 * This method initializes jRadioButtonNoDilatacion
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonNoDilatacion() {
		if (jRadioButtonNoDilatacion == null) {
			jRadioButtonNoDilatacion = new JRadioButton();
			jRadioButtonNoDilatacion.setBounds(new Rectangle(268, 100, 71, 34));
			jRadioButtonNoDilatacion.setText("No");
			jRadioButtonNoDilatacion.setBackground(new Color(204, 255, 204));
			jRadioButtonNoDilatacion
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							noDilatacion();
						}
					});
		}
		return jRadioButtonNoDilatacion;
	}

	private void siDilatacion() {
		this.getJRadioButtonSiDilatacion().setSelected(true);
		this.getJRadioButtonNoDilatacion().setSelected(false);
	}

	private void noDilatacion() {
		this.getJRadioButtonSiDilatacion().setSelected(false);
		this.getJRadioButtonNoDilatacion().setSelected(true);
	}

	/**
	 * This method initializes jRadioButtonSiLitiasin
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonSiLitiasin() {
		if (jRadioButtonSiLitiasin == null) {
			jRadioButtonSiLitiasin = new JRadioButton();
			jRadioButtonSiLitiasin
					.setBounds(new Rectangle(168, 140, 71, 34));
			jRadioButtonSiLitiasin.setText("Si");
			jRadioButtonSiLitiasin.setBackground(new Color(204, 255, 204));
			jRadioButtonSiLitiasin
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							siLitiasin();
						}
					});
		}
		return jRadioButtonSiLitiasin;
	}

	/**
	 * This method initializes jRadioButtonNoLitiasin
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonNoLitiasin() {
		if (jRadioButtonNoLitiasin == null) {
			jRadioButtonNoLitiasin = new JRadioButton();
			jRadioButtonNoLitiasin
					.setBounds(new Rectangle(268, 140, 71, 34));
			jRadioButtonNoLitiasin.setText("No");
			jRadioButtonNoLitiasin.setBackground(new Color(204, 255, 204));
			jRadioButtonNoLitiasin
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							noColecciones();
						}
					});
		}
		return jRadioButtonNoLitiasin;
	}

	private void siLitiasin() {
		this.getJRadioButtonSiLitiasin().setSelected(true);
		this.getJRadioButtonNoLitiasin().setSelected(false);
	}

	private void noColecciones() {
		this.getJRadioButtonSiLitiasin().setSelected(false);
		this.getJRadioButtonNoLitiasin().setSelected(true);
	}

	/**
	 * This method initializes jTextFieldEspesor
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldEspesor() {
		if (jTextFieldEspesor == null) {
			jTextFieldEspesor = new JTextField();
			jTextFieldEspesor.setBounds(new Rectangle(164, 283, 214, 28));
		}
		return jTextFieldEspesor;
	}

	/**
	 * This method initializes jButtonAtras
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAtras() {
		if (jButtonAtras == null) {
			jButtonAtras = new JButton();
			jButtonAtras.setBounds(new Rectangle(11, 500, 120, 34));
			jButtonAtras.setText("Atras");
			jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salir();
				}
			});
		}
		return jButtonAtras;
	}

	private void salir() {
		this.dispose();
	}

	/**
	 * This method initializes jButtonGuardar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonGuardar() {
		if (jButtonGuardar == null) {
			jButtonGuardar = new JButton();
			jButtonGuardar.setBounds(new Rectangle(253, 500, 120, 34));
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

	private void guardar() {
		EvolucionTrasplanteEcografia aux;
		if (usado == null) {
			aux = new EvolucionTrasplanteEcografia();
		} else {
			aux = usado;
		}
		aux.setIdTrasplante(this.idTrasplante);
		aux.setFecha(this.getJDateChooserFecha().getCalendar());
		aux.setDiametros(this.getJTextFieldDiametros().getText());
		aux.setDilatacion(this.getJRadioButtonSiDilatacion().isSelected());
		aux.setLitiasin(this.getJRadioButtonSiLitiasin().isSelected());
		aux.setVejiga(this.getJTextAreaVejiga().getText());
		try {
			if (this.getJTextFieldEspesor().getText().equalsIgnoreCase("")
					|| this.getJTextFieldEspesor().getText().equalsIgnoreCase(
							" ")) {
				aux.setEspesor(0);
			} else {
				aux.setEspesor(Integer.parseInt(this
						.getJTextFieldEspesor().getText()));
			}
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this,
					"El numero ingresado en Espesor control es erroneo",
					"ERROR", 3);
			return;
		}
		aux.setOtros(this.getJTextAreaOtros().getText());
		Fachada.getInstancia().guardarEvolucionTrasplanteEcografia(aux);
		JOptionPane.showMessageDialog(this,
				"Examen guardado con exito",
				"OK", 1);
		this.salir();
	}

	/**
	 * This method initializes jButtonEliminar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonEliminar() {
		if (jButtonEliminar == null) {
			jButtonEliminar = new JButton();
			jButtonEliminar.setBounds(new Rectangle(131, 550, 120, 34));
			jButtonEliminar.setText("Eliminar");
			jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					eliminar();
				}
			});
		}
		return jButtonEliminar;
	}
	
	private void eliminar(){
		if(this.usado != null){
			String respuesta = "";
			respuesta = JOptionPane.showInputDialog(this, "Esta seguro de eliminar el examen del dia: "+ManejoFechas.FORMATOESPANOL.format(this.usado.getFecha().getTime()) + "\n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
			if(respuesta==null)respuesta="No";
			if(respuesta.equalsIgnoreCase("Si")){
				Fachada.getInstancia().eliminarEvolucionTrasplanteEcografia(this.usado);
				JOptionPane.showMessageDialog(this,
						"Examen eliminado con exito",
						"OK", 1);
				this.salir();
			}
		}
	}

	/**
	 * This method initializes jTextFieldDiametros	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldDiametros() {
		if (jTextFieldDiametros == null) {
			jTextFieldDiametros = new JTextField();
			jTextFieldDiametros.setBounds(new Rectangle(164, 60, 214, 28));
		}
		return jTextFieldDiametros;
	}

	/**
	 * This method initializes jScrollPaneTexto	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneTexto() {
		if (jScrollPaneTexto == null) {
			jScrollPaneTexto = new JScrollPane();
			jScrollPaneTexto.setBounds(new Rectangle(164, 181, 214, 81));
			jScrollPaneTexto.setViewportView(getJTextAreaVejiga());
		}
		return jScrollPaneTexto;
	}

	/**
	 * This method initializes jTextAreaVejiga	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextAreaVejiga() {
		if (jTextAreaVejiga == null) {
			jTextAreaVejiga = new JTextArea();
		}
		return jTextAreaVejiga;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(98, 325, 280, 163));
			jScrollPane.setViewportView(getJTextAreaOtros());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTextAreaOtros	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextAreaOtros() {
		if (jTextAreaOtros == null) {
			jTextAreaOtros = new JTextArea();
		}
		return jTextAreaOtros;
	}
} // @jve:decl-index=0:visual-constraint="10,10"
