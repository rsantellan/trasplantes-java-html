package uy.transplante.iu.evolucion;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.util.Calendar;
import java.util.GregorianCalendar;

import uy.transplante.auxiliares.fechas.ManejoFechas;
import uy.transplante.dominio.EvolucionTrasplanteEcoDopler;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import com.toedter.calendar.JDateChooser;


import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;

import logica.Fachada;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class IUEvolucionEcoDoplerManejar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelFecha = null;
	private JDateChooser jDateChooserFecha = null;
	private JLabel jLabelEstructura = null;
	private JRadioButton jRadioButtonBienEstructura = null;
	private JRadioButton jRadioButtonMalEstructura = null;
	private JLabel jLabelDilatacion = null;
	private JRadioButton jRadioButtonSiDilatacion = null;
	private JRadioButton jRadioButtonNoDilatacion = null;
	private JLabel jLabelColecciones = null;
	private JRadioButton jRadioButtonSiColecciones = null;
	private JRadioButton jRadioButtonNoColecciones = null;
	private JLabel jLabelEjeArterial = null;
	private JRadioButton jRadioButtonBienEjeArterial = null;
	private JRadioButton jRadioButtonMalEjeArterial = null;
	private JLabel jLabelEjeVenoso = null;
	private JRadioButton jRadioButtonBienEjeVenoso = null;
	private JRadioButton jRadioButtonMalEjeVenoso = null;
	private JLabel jLabelArteriaRenal = null;
	private JRadioButton jRadioButtonBienArteriaRenal = null;
	private JRadioButton jRadioButtonMalArteriaRenal = null;
	private JLabel jLabelVenaRenal = null;
	private JRadioButton jRadioButtonBienVenaRenal = null;
	private JRadioButton jRadioButtonMalVenaRenal = null;
	private JLabel jLabelAnastVenosa = null;
	private JRadioButton jRadioButtonBienAnastVenosa = null;
	private JRadioButton jRadioButtonMalAnastVenosa = null;
	private JLabel jLabelAnastRenosa = null;
	private JRadioButton jRadioButtonBienAnastRenosa = null;
	private JRadioButton jRadioButtonMalAnastRenosa = null;
	private JLabel jLabelIndice = null;
	private JTextField jTextFieldIndice = null;
	private JButton jButtonAtras = null;
	private JButton jButtonGuardar = null;
	private int idTrasplante;
	private Calendar fecha = new GregorianCalendar();
	private EvolucionTrasplanteEcoDopler usado = null;
	private JButton jButtonEliminar = null;
	private JScrollPane jScrollPane = null;
	private JTextArea jTextAreaOtros = null;
	private JLabel jLabel = null;

	/**
	 * This is the default constructor
	 */
	public IUEvolucionEcoDoplerManejar(int idTrasplante, Calendar fecha) {
		super();
		initialize();
		this.idTrasplante = idTrasplante;
		this.fecha = fecha;
		cargarDatos();
	}

	private void cargarDatos() {
		this.getJDateChooserFecha().setCalendar(this.fecha);
		this.getJDateChooserFecha().setEnabled(false);
		this.usado = Fachada.getInstancia().buscarEvolucionTrasplanteEcoDopler(
				this.idTrasplante, this.fecha);
		if (usado != null) {
			if (usado.getEstructura().equalsIgnoreCase(
					EvolucionTrasplanteEcoDopler.BIEN)) {
				this.getJRadioButtonBienEstructura().setSelected(true);
			} else {
				this.getJRadioButtonMalEstructura().setSelected(true);
			}
			this.getJRadioButtonSiDilatacion()
					.setSelected(usado.isDilatacion());
			this.getJRadioButtonNoDilatacion().setSelected(
					!usado.isDilatacion());
			this.getJRadioButtonSiColecciones().setSelected(
					usado.isColecciones());
			this.getJRadioButtonNoColecciones().setSelected(
					!usado.isColecciones());
			if (usado.getEjeArterial().equalsIgnoreCase(
					EvolucionTrasplanteEcoDopler.BIEN)) {
				this.getJRadioButtonBienEjeArterial().setSelected(true);
			} else {
				this.getJRadioButtonMalEjeArterial().setSelected(true);
			}
			if (usado.getEjeVenoso().equalsIgnoreCase(
					EvolucionTrasplanteEcoDopler.BIEN)) {
				this.getJRadioButtonBienEjeVenoso().setSelected(true);
			} else {
				this.getJRadioButtonMalEjeVenoso().setSelected(true);
			}
			if (usado.getArteriaRenal().equalsIgnoreCase(
					EvolucionTrasplanteEcoDopler.BIEN)) {
				this.getJRadioButtonBienArteriaRenal().setSelected(true);
			} else {
				this.getJRadioButtonMalArteriaRenal().setSelected(true);
			}
			if (usado.getVenaRenal().equalsIgnoreCase(
					EvolucionTrasplanteEcoDopler.BIEN)) {
				this.getJRadioButtonBienVenaRenal().setSelected(true);
			} else {
				this.getJRadioButtonMalVenaRenal().setSelected(true);
			}
			if (usado.getAnastVenosa().equalsIgnoreCase(
					EvolucionTrasplanteEcoDopler.BIEN)) {
				this.getJRadioButtonBienAnastVenosa().setSelected(true);
			} else {
				this.getJRadioButtonMalAnastVenosa().setSelected(true);
			}
			if (usado.getAnastRenosa().equalsIgnoreCase(
					EvolucionTrasplanteEcoDopler.BIEN)) {
				this.getJRadioButtonBienAnastRenosa().setSelected(true);
			} else {
				this.getJRadioButtonMalAnastRenosa().setSelected(true);
			}
			this.getJTextFieldIndice().setText(
					String.valueOf(this.usado.getIndiceResistencia()));
			this.getJTextAreaOtros().setText(this.usado.getOtros());
		} else {
			this.getJButtonEliminar().setVisible(false);
			this.bienAnastRenosa();
			this.bienAnastVenosa();
			this.bienArteriaRenal();
			this.bienEjeArterial();
			this.bienEjeVenoso();
			this.bienEstructura();
			this.bienVenaRenal();
			this.siColecciones();
			this.siDilatacion();
		}
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(410, 704);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Ecodopler");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(97, 457, 177, 31));
			jLabel.setText("Otros datos:");
			jLabelIndice = new JLabel();
			jLabelIndice.setBounds(new Rectangle(5, 420, 151, 34));
			jLabelIndice.setText("Indice resitencia :");
			jLabelAnastRenosa = new JLabel();
			jLabelAnastRenosa.setBounds(new Rectangle(5, 380, 151, 34));
			jLabelAnastRenosa.setText("Anastomosis renosa :");
			jLabelAnastVenosa = new JLabel();
			jLabelAnastVenosa.setBounds(new Rectangle(5, 340, 151, 34));
			jLabelAnastVenosa.setText("Anastomosis venosa :");
			jLabelVenaRenal = new JLabel();
			jLabelVenaRenal.setBounds(new Rectangle(5, 300, 151, 34));
			jLabelVenaRenal.setText("Vena renal :");
			jLabelArteriaRenal = new JLabel();
			jLabelArteriaRenal.setBounds(new Rectangle(5, 260, 151, 34));
			jLabelArteriaRenal.setText("Arteria renal :");
			jLabelEjeVenoso = new JLabel();
			jLabelEjeVenoso.setBounds(new Rectangle(5, 220, 151, 34));
			jLabelEjeVenoso.setText("Eje eliaco venoso :");
			jLabelEjeArterial = new JLabel();
			jLabelEjeArterial.setBounds(new Rectangle(5, 180, 151, 34));
			jLabelEjeArterial.setText("Eje eliaco arterial :");
			jLabelColecciones = new JLabel();
			jLabelColecciones.setBounds(new Rectangle(5, 140, 151, 34));
			jLabelColecciones.setText("Colecciones perirenales :");
			jLabelDilatacion = new JLabel();
			jLabelDilatacion.setBounds(new Rectangle(5, 100, 151, 34));
			jLabelDilatacion.setText("Dilatacion :");
			jLabelEstructura = new JLabel();
			jLabelEstructura.setBounds(new Rectangle(5, 60, 151, 34));
			jLabelEstructura.setText("Estructura y morfologia :");
			jLabelFecha = new JLabel();
			jLabelFecha.setBounds(new Rectangle(37, 13, 78, 30));
			jLabelFecha.setText("Fecha :");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(204, 255, 204));
			jContentPane.add(jLabelFecha, null);
			jContentPane.add(getJDateChooserFecha(), null);
			jContentPane.add(jLabelEstructura, null);
			jContentPane.add(getJRadioButtonBienEstructura(), null);
			jContentPane.add(getJRadioButtonMalEstructura(), null);
			jContentPane.add(jLabelDilatacion, null);
			jContentPane.add(getJRadioButtonSiDilatacion(), null);
			jContentPane.add(getJRadioButtonNoDilatacion(), null);
			jContentPane.add(jLabelColecciones, null);
			jContentPane.add(getJRadioButtonSiColecciones(), null);
			jContentPane.add(getJRadioButtonNoColecciones(), null);
			jContentPane.add(jLabelEjeArterial, null);
			jContentPane.add(getJRadioButtonBienEjeArterial(), null);
			jContentPane.add(getJRadioButtonMalEjeArterial(), null);
			jContentPane.add(jLabelEjeVenoso, null);
			jContentPane.add(getJRadioButtonBienEjeVenoso(), null);
			jContentPane.add(getJRadioButtonMalEjeVenoso(), null);
			jContentPane.add(jLabelArteriaRenal, null);
			jContentPane.add(getJRadioButtonBienArteriaRenal(), null);
			jContentPane.add(getJRadioButtonMalArteriaRenal(), null);
			jContentPane.add(jLabelVenaRenal, null);
			jContentPane.add(getJRadioButtonBienVenaRenal(), null);
			jContentPane.add(getJRadioButtonMalVenaRenal(), null);
			jContentPane.add(jLabelAnastVenosa, null);
			jContentPane.add(getJRadioButtonBienAnastVenosa(), null);
			jContentPane.add(getJRadioButtonMalAnastVenosa(), null);
			jContentPane.add(jLabelAnastRenosa, null);
			jContentPane.add(getJRadioButtonBienAnastRenosa(), null);
			jContentPane.add(getJRadioButtonMalAnastRenosa(), null);
			jContentPane.add(jLabelIndice, null);
			jContentPane.add(getJTextFieldIndice(), null);
			jContentPane.add(getJButtonAtras(), null);
			jContentPane.add(getJButtonGuardar(), null);
			jContentPane.add(getJButtonEliminar(), null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(jLabel, null);
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
	 * This method initializes jRadioButtonBienEstructura
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonBienEstructura() {
		if (jRadioButtonBienEstructura == null) {
			jRadioButtonBienEstructura = new JRadioButton();
			jRadioButtonBienEstructura
					.setBounds(new Rectangle(168, 60, 71, 34));
			jRadioButtonBienEstructura.setText("Bien");
			jRadioButtonBienEstructura.setBackground(new Color(204, 255, 204));
			jRadioButtonBienEstructura
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							bienEstructura();
						}
					});
		}
		return jRadioButtonBienEstructura;
	}

	/**
	 * This method initializes jRadioButtonMalEstructura
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonMalEstructura() {
		if (jRadioButtonMalEstructura == null) {
			jRadioButtonMalEstructura = new JRadioButton();
			jRadioButtonMalEstructura.setBounds(new Rectangle(268, 60, 71, 34));
			jRadioButtonMalEstructura.setText("Mal");
			jRadioButtonMalEstructura.setBackground(new Color(204, 255, 204));
			jRadioButtonMalEstructura
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							malEstructura();
						}
					});
		}
		return jRadioButtonMalEstructura;
	}

	private void bienEstructura() {
		this.getJRadioButtonBienEstructura().setSelected(true);
		this.getJRadioButtonMalEstructura().setSelected(false);
	}

	private void malEstructura() {
		this.getJRadioButtonBienEstructura().setSelected(false);
		this.getJRadioButtonMalEstructura().setSelected(true);
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
	 * This method initializes jRadioButtonSiColecciones
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonSiColecciones() {
		if (jRadioButtonSiColecciones == null) {
			jRadioButtonSiColecciones = new JRadioButton();
			jRadioButtonSiColecciones
					.setBounds(new Rectangle(168, 140, 71, 34));
			jRadioButtonSiColecciones.setText("Si");
			jRadioButtonSiColecciones.setBackground(new Color(204, 255, 204));
			jRadioButtonSiColecciones
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							siColecciones();
						}
					});
		}
		return jRadioButtonSiColecciones;
	}

	/**
	 * This method initializes jRadioButtonNoColecciones
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonNoColecciones() {
		if (jRadioButtonNoColecciones == null) {
			jRadioButtonNoColecciones = new JRadioButton();
			jRadioButtonNoColecciones
					.setBounds(new Rectangle(268, 140, 71, 34));
			jRadioButtonNoColecciones.setText("No");
			jRadioButtonNoColecciones.setBackground(new Color(204, 255, 204));
			jRadioButtonNoColecciones
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							noColecciones();
						}
					});
		}
		return jRadioButtonNoColecciones;
	}

	private void siColecciones() {
		this.getJRadioButtonSiColecciones().setSelected(true);
		this.getJRadioButtonNoColecciones().setSelected(false);
	}

	private void noColecciones() {
		this.getJRadioButtonSiColecciones().setSelected(false);
		this.getJRadioButtonNoColecciones().setSelected(true);
	}

	/**
	 * This method initializes jRadioButtonBienEjeArterial
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonBienEjeArterial() {
		if (jRadioButtonBienEjeArterial == null) {
			jRadioButtonBienEjeArterial = new JRadioButton();
			jRadioButtonBienEjeArterial.setBounds(new Rectangle(168, 180, 71,
					34));
			jRadioButtonBienEjeArterial.setText("Bien");
			jRadioButtonBienEjeArterial.setBackground(new Color(204, 255, 204));
			jRadioButtonBienEjeArterial
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							bienEjeArterial();
						}
					});
		}
		return jRadioButtonBienEjeArterial;
	}

	/**
	 * This method initializes jRadioButtonMalEjeArterial
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonMalEjeArterial() {
		if (jRadioButtonMalEjeArterial == null) {
			jRadioButtonMalEjeArterial = new JRadioButton();
			jRadioButtonMalEjeArterial
					.setBounds(new Rectangle(268, 180, 71, 34));
			jRadioButtonMalEjeArterial.setText("Mal");
			jRadioButtonMalEjeArterial.setBackground(new Color(204, 255, 204));
			jRadioButtonMalEjeArterial
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							malEjeArterial();
						}
					});
		}
		return jRadioButtonMalEjeArterial;
	}

	private void bienEjeArterial() {
		this.getJRadioButtonBienEjeArterial().setSelected(true);
		this.getJRadioButtonMalEjeArterial().setSelected(false);
	}

	private void malEjeArterial() {
		this.getJRadioButtonBienEjeArterial().setSelected(false);
		this.getJRadioButtonMalEjeArterial().setSelected(true);
	}

	/**
	 * This method initializes jRadioButtonBienEjeVenoso
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonBienEjeVenoso() {
		if (jRadioButtonBienEjeVenoso == null) {
			jRadioButtonBienEjeVenoso = new JRadioButton();
			jRadioButtonBienEjeVenoso
					.setBounds(new Rectangle(168, 220, 71, 34));
			jRadioButtonBienEjeVenoso.setText("Bien");
			jRadioButtonBienEjeVenoso.setBackground(new Color(204, 255, 204));
			jRadioButtonBienEjeVenoso
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							bienEjeVenoso();
						}
					});
		}
		return jRadioButtonBienEjeVenoso;
	}

	/**
	 * This method initializes jRadioButtonMalEjeVenoso
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonMalEjeVenoso() {
		if (jRadioButtonMalEjeVenoso == null) {
			jRadioButtonMalEjeVenoso = new JRadioButton();
			jRadioButtonMalEjeVenoso.setBounds(new Rectangle(268, 220, 71, 34));
			jRadioButtonMalEjeVenoso.setText("Mal");
			jRadioButtonMalEjeVenoso.setBackground(new Color(204, 255, 204));
			jRadioButtonMalEjeVenoso
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							malEjeVenoso();
						}
					});
		}
		return jRadioButtonMalEjeVenoso;
	}

	private void bienEjeVenoso() {
		this.getJRadioButtonBienEjeVenoso().setSelected(true);
		this.getJRadioButtonMalEjeVenoso().setSelected(false);
	}

	private void malEjeVenoso() {
		this.getJRadioButtonBienEjeVenoso().setSelected(false);
		this.getJRadioButtonMalEjeVenoso().setSelected(true);
	}

	/**
	 * This method initializes jRadioButtonBienArteriaRenal
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonBienArteriaRenal() {
		if (jRadioButtonBienArteriaRenal == null) {
			jRadioButtonBienArteriaRenal = new JRadioButton();
			jRadioButtonBienArteriaRenal.setBounds(new Rectangle(168, 260, 71,
					34));
			jRadioButtonBienArteriaRenal.setText("Bien");
			jRadioButtonBienArteriaRenal
					.setBackground(new Color(204, 255, 204));
			jRadioButtonBienArteriaRenal
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							bienArteriaRenal();
						}
					});
		}
		return jRadioButtonBienArteriaRenal;
	}

	/**
	 * This method initializes jRadioButtonMalArteriaRenal
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonMalArteriaRenal() {
		if (jRadioButtonMalArteriaRenal == null) {
			jRadioButtonMalArteriaRenal = new JRadioButton();
			jRadioButtonMalArteriaRenal.setBounds(new Rectangle(268, 260, 71,
					34));
			jRadioButtonMalArteriaRenal.setText("Mal");
			jRadioButtonMalArteriaRenal.setBackground(new Color(204, 255, 204));
			jRadioButtonMalArteriaRenal
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							malArteriaRenal();
						}
					});
		}
		return jRadioButtonMalArteriaRenal;
	}

	private void bienArteriaRenal() {
		this.getJRadioButtonBienArteriaRenal().setSelected(true);
		this.getJRadioButtonMalArteriaRenal().setSelected(false);
	}

	private void malArteriaRenal() {
		this.getJRadioButtonBienArteriaRenal().setSelected(false);
		this.getJRadioButtonMalArteriaRenal().setSelected(true);
	}

	/**
	 * This method initializes jRadioButtonBienVenaRenal
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonBienVenaRenal() {
		if (jRadioButtonBienVenaRenal == null) {
			jRadioButtonBienVenaRenal = new JRadioButton();
			jRadioButtonBienVenaRenal
					.setBounds(new Rectangle(168, 300, 71, 34));
			jRadioButtonBienVenaRenal.setText("Bien");
			jRadioButtonBienVenaRenal.setBackground(new Color(204, 255, 204));
			jRadioButtonBienVenaRenal
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							bienVenaRenal();
						}
					});
		}
		return jRadioButtonBienVenaRenal;
	}

	/**
	 * This method initializes jRadioButtonMalVenaRenal
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonMalVenaRenal() {
		if (jRadioButtonMalVenaRenal == null) {
			jRadioButtonMalVenaRenal = new JRadioButton();
			jRadioButtonMalVenaRenal.setBounds(new Rectangle(268, 300, 71, 34));
			jRadioButtonMalVenaRenal.setText("Mal");
			jRadioButtonMalVenaRenal.setBackground(new Color(204, 255, 204));
			jRadioButtonMalVenaRenal
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							malVenaRenal();
						}
					});
		}
		return jRadioButtonMalVenaRenal;
	}

	private void bienVenaRenal() {
		this.getJRadioButtonBienVenaRenal().setSelected(true);
		this.getJRadioButtonMalVenaRenal().setSelected(false);
	}

	private void malVenaRenal() {
		this.getJRadioButtonBienVenaRenal().setSelected(false);
		this.getJRadioButtonMalVenaRenal().setSelected(true);
	}

	/**
	 * This method initializes jRadioButtonBienAnastVenosa
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonBienAnastVenosa() {
		if (jRadioButtonBienAnastVenosa == null) {
			jRadioButtonBienAnastVenosa = new JRadioButton();
			jRadioButtonBienAnastVenosa.setBounds(new Rectangle(168, 340, 71,
					34));
			jRadioButtonBienAnastVenosa.setText("Bien");
			jRadioButtonBienAnastVenosa.setBackground(new Color(204, 255, 204));
			jRadioButtonBienAnastVenosa
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							bienAnastVenosa();
						}
					});
		}
		return jRadioButtonBienAnastVenosa;
	}

	/**
	 * This method initializes jRadioButtonMalAnastVenosa
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonMalAnastVenosa() {
		if (jRadioButtonMalAnastVenosa == null) {
			jRadioButtonMalAnastVenosa = new JRadioButton();
			jRadioButtonMalAnastVenosa
					.setBounds(new Rectangle(268, 340, 71, 34));
			jRadioButtonMalAnastVenosa.setText("Mal");
			jRadioButtonMalAnastVenosa.setBackground(new Color(204, 255, 204));
			jRadioButtonMalAnastVenosa
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							malAnastVenosa();
						}
					});
		}
		return jRadioButtonMalAnastVenosa;
	}

	private void bienAnastVenosa() {
		this.getJRadioButtonBienAnastVenosa().setSelected(true);
		this.getJRadioButtonMalAnastVenosa().setSelected(false);
	}

	private void malAnastVenosa() {
		this.getJRadioButtonBienAnastVenosa().setSelected(false);
		this.getJRadioButtonMalAnastVenosa().setSelected(true);
	}

	/**
	 * This method initializes jRadioButtonBienAnastRenosa
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonBienAnastRenosa() {
		if (jRadioButtonBienAnastRenosa == null) {
			jRadioButtonBienAnastRenosa = new JRadioButton();
			jRadioButtonBienAnastRenosa.setBounds(new Rectangle(168, 380, 71,
					34));
			jRadioButtonBienAnastRenosa.setText("Bien");
			jRadioButtonBienAnastRenosa.setBackground(new Color(204, 255, 204));
			jRadioButtonBienAnastRenosa
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							bienAnastRenosa();
						}
					});
		}
		return jRadioButtonBienAnastRenosa;
	}

	/**
	 * This method initializes jRadioButtonMalAnastRenosa
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButtonMalAnastRenosa() {
		if (jRadioButtonMalAnastRenosa == null) {
			jRadioButtonMalAnastRenosa = new JRadioButton();
			jRadioButtonMalAnastRenosa
					.setBounds(new Rectangle(268, 380, 71, 34));
			jRadioButtonMalAnastRenosa.setText("Mal");
			jRadioButtonMalAnastRenosa.setBackground(new Color(204, 255, 204));
			jRadioButtonMalAnastRenosa
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							malAnastRenosa();
						}
					});
		}
		return jRadioButtonMalAnastRenosa;
	}

	private void bienAnastRenosa() {
		this.getJRadioButtonBienAnastRenosa().setSelected(true);
		this.getJRadioButtonMalAnastRenosa().setSelected(false);
	}

	private void malAnastRenosa() {
		this.getJRadioButtonBienAnastRenosa().setSelected(false);
		this.getJRadioButtonMalAnastRenosa().setSelected(true);
	}

	/**
	 * This method initializes jTextFieldIndice
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldIndice() {
		if (jTextFieldIndice == null) {
			jTextFieldIndice = new JTextField();
			jTextFieldIndice.setBounds(new Rectangle(171, 424, 158, 28));
		}
		return jTextFieldIndice;
	}

	/**
	 * This method initializes jButtonAtras
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAtras() {
		if (jButtonAtras == null) {
			jButtonAtras = new JButton();
			jButtonAtras.setBounds(new Rectangle(8, 600, 120, 34));
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
			jButtonGuardar.setBounds(new Rectangle(250, 600, 120, 34));
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
		EvolucionTrasplanteEcoDopler aux;
		if (usado == null) {
			aux = new EvolucionTrasplanteEcoDopler();
		} else {
			aux = usado;
		}
		aux.setIdTrasplante(this.idTrasplante);
		aux.setFecha(this.getJDateChooserFecha().getCalendar());
		if (this.getJRadioButtonBienEstructura().isSelected()) {
			aux.setEstructura(EvolucionTrasplanteEcoDopler.BIEN);
		} else {
			aux.setEstructura(EvolucionTrasplanteEcoDopler.MAL);
		}
		aux.setDilatacion(this.getJRadioButtonSiDilatacion().isSelected());
		aux.setColecciones(this.getJRadioButtonSiColecciones().isSelected());
		if (this.getJRadioButtonBienEjeArterial().isSelected()) {
			aux.setEjeArterial(EvolucionTrasplanteEcoDopler.BIEN);
		} else {
			aux.setEjeArterial(EvolucionTrasplanteEcoDopler.MAL);
		}
		if (this.getJRadioButtonBienEjeVenoso().isSelected()) {
			aux.setEjeVenoso(EvolucionTrasplanteEcoDopler.BIEN);
		} else {
			aux.setEjeVenoso(EvolucionTrasplanteEcoDopler.MAL);
		}
		if (this.getJRadioButtonBienArteriaRenal().isSelected()) {
			aux.setArteriaRenal(EvolucionTrasplanteEcoDopler.BIEN);
		} else {
			aux.setArteriaRenal(EvolucionTrasplanteEcoDopler.MAL);
		}
		if (this.getJRadioButtonBienVenaRenal().isSelected()) {
			aux.setVenaRenal(EvolucionTrasplanteEcoDopler.BIEN);
		} else {
			aux.setVenaRenal(EvolucionTrasplanteEcoDopler.MAL);
		}
		if (this.getJRadioButtonBienAnastVenosa().isSelected()) {
			aux.setAnastVenosa(EvolucionTrasplanteEcoDopler.BIEN);
		} else {
			aux.setAnastVenosa(EvolucionTrasplanteEcoDopler.MAL);
		}
		if (this.getJRadioButtonBienAnastRenosa().isSelected()) {
			aux.setAnastRenosa(EvolucionTrasplanteEcoDopler.BIEN);
		} else {
			aux.setAnastRenosa(EvolucionTrasplanteEcoDopler.MAL);
		}
		try {
			if (this.getJTextFieldIndice().getText().equalsIgnoreCase("")
					|| this.getJTextFieldIndice().getText().equalsIgnoreCase(
							" ")) {
				aux.setIndiceResistencia(0);
			} else {
				aux.setIndiceResistencia(Double.parseDouble(this
						.getJTextFieldIndice().getText()));
			}
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this,
					"El numero ingresado en Indice resistencia es erroneo",
					"ERROR", 3);
			return;
		}
		aux.setOtros(this.getJTextAreaOtros().getText());
		Fachada.getInstancia().guardarEvolucionTrasplanteEcoDopler(aux);
		JOptionPane.showMessageDialog(this, "Examen guardado con exito", "OK",
				1);
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
			jButtonEliminar.setBounds(new Rectangle(128, 635, 120, 34));
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
		if (this.usado != null) {
			String respuesta = "";
			respuesta = JOptionPane.showInputDialog(this,
					"Esta seguro de eliminar el examen del dia: "
							+ ManejoFechas.FORMATOESPANOL.format(this.usado
									.getFecha().getTime())
							+ "\n(Ingrese SI para eliminar) Confirmar: ",
					"Confirmar", 1);
			if (respuesta == null)
				respuesta = "No";
			if (respuesta.equalsIgnoreCase("Si")) {
				Fachada.getInstancia().eliminarEvolucionTrasplanteEcoDopler(
						this.usado);
				JOptionPane.showMessageDialog(this,
						"Examen eliminado con exito", "OK", 1);
				this.salir();
			}
		}
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(34, 491, 323, 100));
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
