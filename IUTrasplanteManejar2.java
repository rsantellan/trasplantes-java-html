package uy.transplante.iu.trasplante;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import uy.transplante.dominio.Induccion;
import uy.transplante.dominio.Inmunosupresores;
import uy.transplante.dominio.PacientePreTrasplante;
import uy.transplante.dominio.Serol;
import uy.transplante.dominio.SerolDatos;
import uy.transplante.dominio.Trasplante;
import uy.transplante.dominio.TrasplanteInduccionUsado;
import uy.transplante.dominio.TrasplanteInmunosupresoresUsado;
import uy.transplante.dominio.TrasplanteSerolUsado;
import uy.transplante.logica.Fachada;



public class IUTrasplanteManejar2 extends JFrame implements java.util.Observer{

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;

	private ArrayList<Induccion> listaInducciones; // @jve:decl-index=0:
	private ArrayList<Inmunosupresores> listaInmunosupresores; // @jve:decl-index=0:
	private ArrayList<Serol> listaSerol;

	private JLabel jLabelElegirInduccion = null;
	private JScrollPane jScrollPaneInducciones = null;
	private JList jListInducciones = null;
	private JLabel jLabelElegirInmunosupresores = null;
	private JScrollPane jScrollPaneInmunosupresores = null;
	private JList jListInmunosupresores = null;
	private JLabel jLabelElegirSerol = null;
	private JLabel jLabelValorSerol = null;
	private JButton jButtonAgregarSerol = null;
	private JScrollPane jScrollPaneSerolDatos = null;
	private JList jListSerolDatos = null;
	private JButton jButtonSacarSerol = null;
	private JLabel jLabelSerolUsado = null;
	private JComboBox jComboBoxSeroles = null;
	private JComboBox jComboBoxSerolesUsados = null;

	private IUTrasplanteManejar iuAnterior;
	private Trasplante trasplante;
	private ArrayList<TrasplanteSerolUsado> listaSerolesUsados = new ArrayList<TrasplanteSerolUsado>(); // @jve:decl-index=0:
	
	private JButton jButtonAnterior = null;
	private JDesktopPane jDesktopPaneDato3 = null;
	private JLabel jLabelComentario = null;
	private JTextArea jTextAreaComentario = null;
	private JDesktopPane jDesktopPaneComentario = null;
	private JScrollPane jScrollPaneComentario = null;
	private JDesktopPane jDesktopPaneDato4 = null;
	private JCheckBox jCheckBoxDialisis = null;
	private JLabel jLabelNumDeHd = null;
	private JTextField jTextFieldNumDeHd = null;
	private JButton jButtonGuardar = null;
	private JButton jButtonSalir = null;
	private JButton jButtonNinguno = null;
	private PacientePreTrasplante pt;
	/**
	 * This is the default constructor
	 */
	public IUTrasplanteManejar2(PacientePreTrasplante pt,
			IUTrasplanteManejar anterior) {
		super();
		initialize();
		cargarDatos();
		this.pt = pt;
		this.trasplante = pt.getTrasplante();
		cargarDatosTrasplante();
		this.iuAnterior = anterior;
		this.setLocation(290, 0);
		Fachada.getInstancia().agregarObservador(this);
		if (this.iuAnterior.isVer()) {
			this.jButtonGuardar.setVisible(false);
		}
	}

	public IUTrasplanteManejar2() {
		super();
		initialize();
		cargarDatos();
		cargarDatosTrasplante();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(673, 544);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Ingresar Trasplante");
	}

	private void cargarDatosTrasplante() {
		this.jTextFieldNumDeHd.setText(Integer.toString(this.trasplante
				.getNumDeHd()));
		this.jCheckBoxDialisis.setSelected(this.trasplante.isDialisis());
		this.jTextAreaComentario.setText(this.trasplante.getComentario());
		// Inducciones
		ArrayList<Object> num = new ArrayList<Object>();
		int indiceMayor = 0;
		while (indiceMayor < this.trasplante.getListaInducciones().size()) {
			int indice = 0;
			boolean termino = false;
			Induccion auxIn = this.trasplante.getListaInducciones()
					.get(indiceMayor).getInduccion();
			while (indice < this.listaInducciones.size() && !termino) {
				Induccion auxInd = this.listaInducciones
						.get(indice);
				if (auxInd.equals(auxIn)) {
					termino = true;

					num.add(indice);
				} else {
					indice++;
				}
			}
			indiceMayor++;
		}
		int[] numInducciones = new int[num.size()];
		for (int i = 0; i < num.size(); i++) {
			numInducciones[i] = (Integer) num.get(i);
		}

		this.jListInducciones.setSelectedIndices(numInducciones);
		// Inmunosupresores
		num = new ArrayList<Object>();
		indiceMayor = 0;
		while (indiceMayor < this.trasplante.getListaInmunosupresores().size()) {
			int indice = 0;
			boolean termino = false;
			Inmunosupresores auxIn = this.trasplante
					.getListaInmunosupresores().get(indiceMayor)
					.getInmunosupresores();
			while (indice < this.listaInducciones.size() && !termino) {
				Inmunosupresores auxInd = this.listaInmunosupresores
						.get(indice);
				if (auxInd.equals(auxIn)) {
					termino = true;
					num.add(indice);
				} else {
					indice++;
				}
			}
			indiceMayor++;
		}
		int[] numInmunosupresores = new int[num.size()];
		for (int i = 0; i < num.size(); i++) {
			numInmunosupresores[i] = (Integer) num.get(i);
		}

		this.jListInmunosupresores.setSelectedIndices(numInmunosupresores);

		// Seroles
		this.listaSerol = Fachada.getInstancia().obtenerTodosLosSerol();
		for (int x = 0; x < this.trasplante.getListaSeroles().size(); x++) {
			this.jComboBoxSerolesUsados.addItem(this.trasplante
					.getListaSeroles().get(x));
			this.listaSerolesUsados.add(this.trasplante.getListaSeroles()
					.get(x));
			this.listaSerol.remove(this.trasplante.getListaSeroles().get(x)
					.getSerol());
		}
		for (int x = 0; x < this.listaSerol.size(); x++) {
			this.jComboBoxSeroles.addItem(this.listaSerol.get(x));
		}
	}

	private void cargarDatos() {
		// Inducciones
		this.listaInducciones = Fachada.getInstancia()
				.obtenerTodosLosInduccion();
		this.jListInducciones.setListData(this.listaInducciones.toArray());
		// Inmunosupresores
		this.listaInmunosupresores = Fachada.getInstancia()
				.obtenerTodosLosInmunosupresores();
		this.jListInmunosupresores.setListData(this.listaInmunosupresores
				.toArray());
		// Serol
	}

	private void cargarDatosSerolCombo() {
		if (this.jComboBoxSeroles.getItemCount() == 0) {
			this.jListSerolDatos.removeAll();
		} else {
			Serol serol = (Serol) this.jComboBoxSeroles.getSelectedItem();
			if (serol != null) {
				this.jListSerolDatos.setListData(serol.getDatos().toArray());
			}
		}
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelNumDeHd = new JLabel();
			jLabelNumDeHd.setText("N° de HD :");
			jLabelNumDeHd.setBounds(new Rectangle(25, 59, 118, 29));
			jLabelComentario = new JLabel();
			jLabelComentario.setText("Comentario traplante:");
			jLabelComentario.setBounds(new Rectangle(3, 14, 131, 32));
			jLabelSerolUsado = new JLabel();
			jLabelSerolUsado.setText("Serol Usado");
			jLabelSerolUsado.setBounds(new Rectangle(423, 115, 137, 25));
			jLabelValorSerol = new JLabel();
			jLabelValorSerol.setText("Valor Serol");
			jLabelValorSerol.setBounds(new Rectangle(201, 115, 176, 25));
			jLabelElegirSerol = new JLabel();
			jLabelElegirSerol.setText("Elegir Serol");
			jLabelElegirSerol.setBounds(new Rectangle(16, 115, 164, 25));
			jLabelElegirInmunosupresores = new JLabel();
			jLabelElegirInmunosupresores.setText("Elegir Inmunosupresores");
			jLabelElegirInmunosupresores.setBounds(new Rectangle(375, 4, 173,
					28));
			jLabelElegirInduccion = new JLabel();
			jLabelElegirInduccion.setText("Elegir Inducciones");
			jLabelElegirInduccion.setBounds(new Rectangle(28, 1, 145, 24));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 204));
			jContentPane.add(getJButtonAnterior(), null);
			jContentPane.add(getJDesktopPaneDato3(), null);
			jContentPane.add(getJDesktopPaneComentario(), null);
			jContentPane.add(getJDesktopPaneDato4(), null);
			jContentPane.add(getJButtonGuardar(), null);
			jContentPane.add(getJButtonSalir(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPaneInducciones
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneInducciones() {
		if (jScrollPaneInducciones == null) {
			jScrollPaneInducciones = new JScrollPane();
			jScrollPaneInducciones.setBounds(new Rectangle(14, 29, 228, 81));
			jScrollPaneInducciones.setViewportView(getJListInducciones());
		}
		return jScrollPaneInducciones;
	}

	/**
	 * This method initializes jListInducciones
	 * 
	 * @return javax.swing.JList
	 */
	private JList getJListInducciones() {
		if (jListInducciones == null) {
			jListInducciones = new JList();
		}
		return jListInducciones;
	}

	/**
	 * This method initializes jScrollPaneInmunosupresores
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneInmunosupresores() {
		if (jScrollPaneInmunosupresores == null) {
			jScrollPaneInmunosupresores = new JScrollPane();
			jScrollPaneInmunosupresores.setBounds(new Rectangle(335, 33, 250,
					76));
			jScrollPaneInmunosupresores
					.setViewportView(getJListInmunosupresores());
		}
		return jScrollPaneInmunosupresores;
	}

	/**
	 * This method initializes jListInmunosupresores
	 * 
	 * @return javax.swing.JList
	 */
	private JList getJListInmunosupresores() {
		if (jListInmunosupresores == null) {
			jListInmunosupresores = new JList();
		}
		return jListInmunosupresores;
	}

	/**
	 * This method initializes jButtonAgregarSerol
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAgregarSerol() {
		if (jButtonAgregarSerol == null) {
			jButtonAgregarSerol = new JButton();
			jButtonAgregarSerol.setText(">>");
			jButtonAgregarSerol.setBounds(new Rectangle(326, 142, 65, 30));
			jButtonAgregarSerol
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							agregarSerol();
						}
					});
		}
		return jButtonAgregarSerol;
	}

	/**
	 * This method initializes jScrollPaneSerolDatos
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneSerolDatos() {
		if (jScrollPaneSerolDatos == null) {
			jScrollPaneSerolDatos = new JScrollPane();
			jScrollPaneSerolDatos.setBounds(new Rectangle(177, 142, 144, 68));
			jScrollPaneSerolDatos.setViewportView(getJListSerolDatos());
		}
		return jScrollPaneSerolDatos;
	}

	/**
	 * This method initializes jListSerolDatos
	 * 
	 * @return javax.swing.JList
	 */
	private JList getJListSerolDatos() {
		if (jListSerolDatos == null) {
			jListSerolDatos = new JList();
		}
		return jListSerolDatos;
	}

	/**
	 * This method initializes jButtonSacarSerol
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonSacarSerol() {
		if (jButtonSacarSerol == null) {
			jButtonSacarSerol = new JButton();
			jButtonSacarSerol.setText("<<");
			jButtonSacarSerol.setBounds(new Rectangle(326, 176, 65, 30));
			jButtonSacarSerol
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							sacarSerol();
						}
					});
		}
		return jButtonSacarSerol;
	}

	private void agregarSerol() {
		TrasplanteSerolUsado s = new TrasplanteSerolUsado();
		s.setSerol((Serol) this.jComboBoxSeroles.getSelectedItem());
		if(s.getSerol().getTipo().equalsIgnoreCase(" - ")){
			return;
		}
		s.setDato((SerolDatos) this.jListSerolDatos.getSelectedValue());
		if (s.getDato() != null && s.getSerol() != null) {
			this.jComboBoxSerolesUsados.addItem(s);
			this.listaSerolesUsados.add(s);
			this.jComboBoxSeroles.removeItem(s.getSerol());
		}
	}

	/**
	 * This method initializes jComboBoxSeroles
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxSeroles() {
		if (jComboBoxSeroles == null) {
			jComboBoxSeroles = new JComboBox();
			jComboBoxSeroles.setBounds(new Rectangle(15, 143, 148, 35));
			jComboBoxSeroles
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							cargarDatosSerolCombo();
						}
					});
		}
		return jComboBoxSeroles;
	}

	/**
	 * This method initializes jComboBoxSerolesUsados
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxSerolesUsados() {
		if (jComboBoxSerolesUsados == null) {
			jComboBoxSerolesUsados = new JComboBox();
			jComboBoxSerolesUsados.setBounds(new Rectangle(407, 140, 191, 39));
		}
		return jComboBoxSerolesUsados;
	}

	private int guardarLocalmente() {
		Trasplante t = this.trasplante;
		int salida = 0;
		try {
			if (!this.jTextFieldNumDeHd.getText().equalsIgnoreCase("")
					&& !this.jTextFieldNumDeHd.getText().equalsIgnoreCase(" ")) {
				t
						.setNumDeHd(Integer.parseInt(this.jTextFieldNumDeHd
								.getText()));
			}
		} catch (Exception e) {
			System.out.println(e);
			salida = 1;
		}
		if(t.getNumDeHd() < 0){
			t.setNumDeHd(0);
			salida = 1;
		}
		t.setDialisis(this.jCheckBoxDialisis.isSelected());
		t.setComentario(this.jTextAreaComentario.getText());
		int[] num = this.jListInmunosupresores.getSelectedIndices();
		// Inmunosupresores
		ArrayList<TrasplanteInmunosupresoresUsado> listaInm = new ArrayList<TrasplanteInmunosupresoresUsado>();
		for (int x = 0; x < num.length; x++) {
			TrasplanteInmunosupresoresUsado aux = new TrasplanteInmunosupresoresUsado();
			aux.setDato(true);
			aux
					.setInmunosupresores(this.listaInmunosupresores
							.get(num[x]));
			listaInm.add(aux);
		}
		t.setListaInmunosupresores(listaInm);
		// Inducciones
		num = this.jListInducciones.getSelectedIndices();
		ArrayList<TrasplanteInduccionUsado> listaInd = new ArrayList<TrasplanteInduccionUsado>();
		for (int x = 0; x < num.length; x++) {
			TrasplanteInduccionUsado aux = new TrasplanteInduccionUsado();
			aux.setDato(true);
			aux.setInduccion(this.listaInducciones.get(num[x]));
			listaInd.add(aux);
		}
		t.setListaInducciones(listaInd);
		t.setListaSeroles(this.listaSerolesUsados);

		/*
		 * Reoperaciones
		 * t.setReoperacion(this.jCheckBoxReoperacion.isSelected());
		 * t.setCausaReoperacion(this.jTextAreaCausaReoperacion.getText());
		 */
		
		return salida;
	}

	private void volver() {
		if (!this.iuAnterior.isVer()) {
			this.guardarLocalmente();
		}
		this.iuAnterior.cargarTrasplante(this.trasplante);
		Fachada.getInstancia().eliminarObservador(this);
		this.dispose();
	}

	/**
	 * This method initializes jButtonAnterior
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAnterior() {
		if (jButtonAnterior == null) {
			jButtonAnterior = new JButton();
			jButtonAnterior.setBounds(new Rectangle(11, 443, 111, 38));
			jButtonAnterior.setText("<<Volver<<");
			jButtonAnterior
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							volver();
						}
					});
		}
		return jButtonAnterior;
	}

	private void sacarSerol() {
		TrasplanteSerolUsado ts = (TrasplanteSerolUsado) this.jComboBoxSerolesUsados
				.getSelectedItem();
		if (ts != null) {
			this.listaSerolesUsados.remove(ts);
			this.jComboBoxSeroles.addItem(ts.getSerol());
			this.jComboBoxSerolesUsados.removeItem(ts);
		}
	}

	/**
	 * This method initializes jDesktopPaneDato3
	 * 
	 * @return javax.swing.JDesktopPane
	 */
   /*
	private JDesktopPane getJDesktopPaneDato3() {
		if (jDesktopPaneDato3 == null) {
			jDesktopPaneDato3 = new JDesktopPane();
			jDesktopPaneDato3.setBounds(new Rectangle(13, 20, 604, 227));
			jDesktopPaneDato3.add(getJScrollPaneInducciones(), null);
			jDesktopPaneDato3.add(jLabelElegirInduccion, null);
      
			jDesktopPaneDato3.add(jLabelElegirInmunosupresores, null);
			jDesktopPaneDato3.add(getJScrollPaneInmunosupresores(), null);
      
			jDesktopPaneDato3.add(jLabelElegirSerol, null);
			jDesktopPaneDato3.add(jLabelValorSerol, null);
			jDesktopPaneDato3.add(jLabelSerolUsado, null);
			jDesktopPaneDato3.add(getJComboBoxSeroles(), null);
			jDesktopPaneDato3.add(getJComboBoxSerolesUsados(), null);
			jDesktopPaneDato3.add(getJButtonAgregarSerol(), null);
			jDesktopPaneDato3.add(getJButtonSacarSerol(), null);
			jDesktopPaneDato3.add(getJScrollPaneSerolDatos(), null);
			jDesktopPaneDato3.add(getJButtonNinguno(), null);
		}
		return jDesktopPaneDato3;
	}
*/
	/**
	 * This method initializes jTextAreaComentario
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextAreaComentario() {
		if (jTextAreaComentario == null) {
			jTextAreaComentario = new JTextArea();
			jTextAreaComentario.setLineWrap(true);
			jTextAreaComentario.setForeground(new Color(0, 51, 51));
		}
		return jTextAreaComentario;
	}

	/**
	 * This method initializes jDesktopPaneComentario
	 * 
	 * @return javax.swing.JDesktopPane
	 */
   /*
	private JDesktopPane getJDesktopPaneComentario() {
		if (jDesktopPaneComentario == null) {
			jDesktopPaneComentario = new JDesktopPane();
			jDesktopPaneComentario.setBounds(new Rectangle(12, 265, 432, 140));
			jDesktopPaneComentario.add(getJScrollPaneComentario(), null);
			jDesktopPaneComentario.add(jLabelComentario, null);
		}
		return jDesktopPaneComentario;
	}
*/
	/**
	 * This method initializes jScrollPaneComentario
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneComentario() {
		if (jScrollPaneComentario == null) {
			jScrollPaneComentario = new JScrollPane();
			jScrollPaneComentario.setBounds(new Rectangle(133, 11, 293, 124));
			jScrollPaneComentario.setViewportView(getJTextAreaComentario());
		}
		return jScrollPaneComentario;
	}

	/**
	 * This method initializes jDesktopPaneDato4
	 * 
	 * @return javax.swing.JDesktopPane
	 */
	private JDesktopPane getJDesktopPaneDato4() {
		if (jDesktopPaneDato4 == null) {
			jDesktopPaneDato4 = new JDesktopPane();
			jDesktopPaneDato4.setBounds(new Rectangle(446, 265, 176, 139));
			jDesktopPaneDato4.add(getJCheckBoxDialisis(), null);
      
			jDesktopPaneDato4.add(jLabelNumDeHd, null);
      jDesktopPaneDato4.add(getJTextFieldNumDeHd(), null);
		}
		return jDesktopPaneDato4;
	}

	/**
	 * This method initializes jCheckBoxDialisis
	 * 
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxDialisis() {
		if (jCheckBoxDialisis == null) {
			jCheckBoxDialisis = new JCheckBox();
			jCheckBoxDialisis.setText("Dialisis");
			jCheckBoxDialisis.setBounds(new Rectangle(20, 16, 113, 30));
		}
		return jCheckBoxDialisis;
	}

	/**
	 * This method initializes jTextFieldNumDeHd
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldNumDeHd() {
		if (jTextFieldNumDeHd == null) {
			jTextFieldNumDeHd = new JTextField();
			jTextFieldNumDeHd.setBounds(new Rectangle(8, 95, 148, 27));
		}
		return jTextFieldNumDeHd;
	}

	/**
	 * This method initializes jButtonGuardar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonGuardar() {
		if (jButtonGuardar == null) {
			jButtonGuardar = new JButton();
			jButtonGuardar.setBounds(new Rectangle(435, 443, 138, 39));
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

	/**
	 * This method initializes jButtonSalir
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonSalir() {
		if (jButtonSalir == null) {
			jButtonSalir = new JButton();
			jButtonSalir.setBounds(new Rectangle(200, 445, 138, 39));
			jButtonSalir.setText("Cancelar");
			jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salir();
				}
			});
		}
		return jButtonSalir;
	}

	private void salir() {
		iuAnterior.salir();
		Fachada.getInstancia().eliminarObservador(this);
		this.dispose();
	}

	private void guardar() {
		int resultado = guardarLocalmente();
		Trasplante t = this.trasplante;
		if (!t.getDonante().getId().equalsIgnoreCase("")) {
			if(resultado == 1){
				JOptionPane.showMessageDialog(this,
						"El numero de dialisis que ingreso es incorrecto por lo tanto se a guardado con 0.",
						"Error", 2);
			}
			Fachada.getInstancia().guardarTrasplante(this.pt, t);
			this.salir();
		} else {
			JOptionPane.showMessageDialog(this,
					"Un trasplante tiene que tener un Donante asosciado.",
					"Error", 2);
		}

	}

	/**
	 * This method initializes jButtonNinguno
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonNinguno() {
		if (jButtonNinguno == null) {
			jButtonNinguno = new JButton();
			jButtonNinguno.setBounds(new Rectangle(246, 54, 83, 30));
			jButtonNinguno.setText("Ninguno");
			jButtonNinguno
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							sacarIndEInm();
						}
					});
		}
		return jButtonNinguno;
	}

	private void sacarIndEInm() {
		// Inducciones
		this.jListInducciones.setListData(this.listaInducciones.toArray());
		// Inmunosupresores
		this.jListInmunosupresores.setListData(this.listaInmunosupresores
				.toArray());
	}

	public void update(Observable arg0, Object arg1) {
		Observable o = arg0;
		if (o == Fachada.getInstancia()) {
			/*System.out.println("Error del removeAllItems() en IUTrasplanteManejar2");
			this.jComboBoxSeroles.removeAllItems();
			cargarDatos();
			cargarDatosTrasplante();*/
		}
		
	}
} // @jve:decl-index=0:visual-constraint="10,10"
