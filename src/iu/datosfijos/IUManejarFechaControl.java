package iu.datosfijos;

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

import logica.Fachada;
import dominio.FechaControl;

public class IUManejarFechaControl extends JFrame implements java.util.Observer {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;

	private Fachada instancia = Fachada.getInstancia();
	private JScrollPane jScrollPaneFechaControl = null;
	private JList jListFechaControl = null;
	private JLabel jLabelTiposInduccion = null;
	private JButton jButtonAgregar = null;
	private JButton jButtonModificar = null;
	private JButton jButtonEliminar = null;
	private JButton jButtonAtras = null;

	private ArrayList<FechaControl> lista = new ArrayList<FechaControl>(); // @jve:decl-index=0:

	/**
	 * This is the default constructor
	 */
	public IUManejarFechaControl() {
		super();
		initialize();
		cargarDatos();
		Fachada.getInstancia().agregarObservador(this);
	}

	private void cargarDatos() {
		this.lista = Fachada.getInstancia().obtenerTodasFechasControl();
		this.jListFechaControl.setListData(this.lista.toArray());
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(443, 370);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Manejar Tipos de Fechas de Controles");
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
			jLabelTiposInduccion = new JLabel();
			jLabelTiposInduccion.setBounds(new Rectangle(25, 21, 232, 22));
			jLabelTiposInduccion.setFont(new Font("Dialog", Font.BOLD, 18));
			jLabelTiposInduccion.setText("Tipos de Fecha de Control");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(204, 255, 204));
			jContentPane.add(getJScrollPaneFechaControl(), null);
			jContentPane.add(jLabelTiposInduccion, null);
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
	 * This method initializes jScrollPaneFechaControl
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneFechaControl() {
		if (jScrollPaneFechaControl == null) {
			jScrollPaneFechaControl = new JScrollPane();
			jScrollPaneFechaControl.setBounds(new Rectangle(20, 51, 242, 253));
			jScrollPaneFechaControl.setViewportView(getJListFechaControl());
		}
		return jScrollPaneFechaControl;
	}

	/**
	 * This method initializes jListFechaControl
	 * 
	 * @return javax.swing.JList
	 */
	private JList getJListFechaControl() {
		if (jListFechaControl == null) {
			jListFechaControl = new JList();
		}
		return jListFechaControl;
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
			jButtonAgregar
					.addActionListener(new java.awt.event.ActionListener() {
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
			jButtonModificar
					.addActionListener(new java.awt.event.ActionListener() {
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
			jButtonEliminar
					.addActionListener(new java.awt.event.ActionListener() {
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

	private void salir() {
		this.instancia.eliminarObservador(this);
		this.dispose();
	}

	private void agregar() {
		String nueva = "";
		nueva = JOptionPane.showInputDialog(this,
				"Ingrese el nombre de la nueva Fecha de Control :",
				"Confirmar", 3);
		if (nueva != null) {
			if (!nueva.equalsIgnoreCase("") || !nueva.equalsIgnoreCase(" ")) {
				FechaControl m = new FechaControl();
				m.setFecha(nueva);
				if (this.lista.contains(m)) {
					JOptionPane
							.showMessageDialog(
									this,
									"Ese tipo de Fecha de Control ya se encuentra ingresado",
									"Error", 2);
				} else {
					nueva = JOptionPane
							.showInputDialog(
									this,
									"Ingrese la cantidad de a�os desde el trasplante\n a la de la nueva Fecha de Control :",
									"Confirmar", 3);
					boolean ok = false;
					if (nueva != null) {
						try {
							int num = Integer.valueOf(nueva);
							m.setAnos(num);
							ok = true;
						} catch (Exception e) {
							JOptionPane.showMessageDialog(this,
									"Solo ingrese numeros.", "Error", 2);
						}
					}
					if (ok) {
						nueva = JOptionPane
								.showInputDialog(
										this,
										"Ingrese la cantidad de meses desde el trasplante\n a la de la nueva Fecha de Control :",
										"Confirmar", 3);
						ok = false;
						if (nueva != null) {
							try {
								int num = Integer.valueOf(nueva);
								m.setMeses(num);
								ok = true;
							} catch (Exception e) {
								JOptionPane.showMessageDialog(this,
										"Solo ingrese numeros.", "Error", 2);
							}
						}
					}
					if (ok) {
						nueva = JOptionPane
								.showInputDialog(
										this,
										"Ingrese la cantidad de dias desde el trasplante\n a la de la nueva Fecha de Control :",
										"Confirmar", 3);
						ok = false;
						if (nueva != null) {
							try {
								int num = Integer.valueOf(nueva);
								m.setDias(num);
								ok = true;
							} catch (Exception e) {
								JOptionPane.showMessageDialog(this,
										"Solo ingrese numeros.", "Error", 2);
							}
						}
					}
					if (ok)
						Fachada.getInstancia().guardarFechaControl(m);
				}
			}
		}
	}

	private boolean modificarNombre(FechaControl original, FechaControl nueva) {
		String nuevaS = "";
		nuevaS = JOptionPane
				.showInputDialog(
						this,
						"Ingrese el nuevo tiempo de la Fecha de Control\nDeje en blanco para no modificar :",
						"Confirmar", 3);
		if (nuevaS != null) {
			if (!nuevaS.equalsIgnoreCase("") && !nuevaS.equalsIgnoreCase(" ")) {
				nueva.setFecha(nuevaS);
				return true;
			} else {
				nueva.setFecha(original.getFecha());
			}
		} else {
			nueva.setFecha(original.getFecha());
		}
		return false;

	}

	private void modificarAno(FechaControl original, FechaControl nueva) {
		String nuevaS = "";
		nuevaS = JOptionPane
				.showInputDialog(
						this,
						"Ingrese la cantidad de a�os desde el trasplante\n a la de la nueva Fecha de Control\nDeje en blanco para no modificar :",
						"Confirmar", 3);
		if (nuevaS != null) {
			if (!nuevaS.equalsIgnoreCase("") && !nuevaS.equalsIgnoreCase(" ")) {
				int i = 0;
				try {
					i = Integer.parseInt(nuevaS);
				} catch (Exception e) {
					JOptionPane
							.showMessageDialog(
									this,
									"Solo ingrese numeros, a quedado por defecto en 0.",
									"Error", 2);
					i = 0;
				}
				nueva.setAnos(i);
			} else {
				nueva.setAnos(original.getAnos());
			}
		}
	}

	private void modificarMeses(FechaControl original, FechaControl nueva) {
		String nuevaS = "";
		nuevaS = JOptionPane
				.showInputDialog(
						this,
						"Ingrese la cantidad de meses desde el trasplante\n a la de la nueva Fecha de Control\nDeje en blanco para no modificar :",
						"Confirmar", 3);
		if (nuevaS != null) {
			if (!nuevaS.equalsIgnoreCase("") && !nuevaS.equalsIgnoreCase(" ")) {
				int i = 0;
				try {
					i = Integer.parseInt(nuevaS);
				} catch (Exception e) {
					JOptionPane
							.showMessageDialog(
									this,
									"Solo ingrese numeros, a quedado por defecto en 0.",
									"Error", 2);
					i = 0;
				}
				nueva.setMeses(i);
			} else {
				nueva.setMeses(original.getMeses());
			}
		}
	}

	private void modificarDias(FechaControl original, FechaControl nueva) {
		String nuevaS = "";
		nuevaS = JOptionPane
				.showInputDialog(
						this,
						"Ingrese la cantidad de dias desde el trasplante\n a la de la nueva Fecha de Control\nDeje en blanco para no modificar :",
						"Confirmar", 3);
		if (nuevaS != null) {
			if (!nuevaS.equalsIgnoreCase("") && !nuevaS.equalsIgnoreCase(" ")) {
				int i = 0;
				try {
					i = Integer.parseInt(nuevaS);
				} catch (Exception e) {
					JOptionPane
							.showMessageDialog(
									this,
									"Solo ingrese numeros, a quedado por defecto en 0.",
									"Error", 2);
					i = 0;
				}
				nueva.setMeses(i);
			} else {
				nueva.setDias(original.getDias());
			}
		}
	}

	private void modificar() {
		FechaControl m = (FechaControl) this.jListFechaControl
				.getSelectedValue();
		if (m != null) {
			FechaControl aux = new FechaControl();
			boolean cambiar = this.modificarNombre(m, aux);
			boolean ok = true;
			if (cambiar) {
				if (this.lista.contains(aux)) {
					ok = false;
					JOptionPane
							.showMessageDialog(
									this,
									"La Fecha de Control que quiere ingresar ya existe",
									"Error", 2);
				}
			}
			if(ok){
				aux.setId(m.getId());
				this.modificarAno(m, aux);
				this.modificarMeses(m, aux);
				this.modificarDias(m, aux);
				Fachada.getInstancia().guardarFechaControl(aux);
			}
		}
	}

	private void eliminar() {
		FechaControl m = (FechaControl) this.jListFechaControl
				.getSelectedValue();
		if (m != null) {
			String nueva = "";
			nueva = JOptionPane
					.showInputDialog(
							this,
							"Esta seguro de querer eliminar la Fecha de Control\n(Escriba Si para confirmar) :",
							"Confirmar", 3);
			if (nueva != null) {
				if (nueva.equalsIgnoreCase("si"))
					Fachada.getInstancia().eliminarFechaControl(m);
			}
		}
	}
} // @jve:decl-index=0:visual-constraint="10,10"
