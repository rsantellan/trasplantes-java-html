package iu.trasplante;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.util.ArrayList;

import uy.transplante.auxiliares.fechas.ManejoFechas;
import uy.transplante.dominio.Trasplante;
import uy.transplante.dominio.TrasplanteComplicaciones;
import uy.transplante.dominio.TrasplanteReoperacion;

import com.toedter.calendar.JDateChooser;


import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.WindowConstants;

import logica.Fachada;
import javax.swing.JList;

public class IUTrasplanteReoperacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JDesktopPane jDesktopPaneDatos = null;
	private JLabel jLabelCausaReoperacion = null;
	private JScrollPane jScrollPaneCausaReoperacion = null;
	private JTextArea jTextAreaCausaReoperacion = null;
	private JLabel jLabelFechaReoperacion = null;
	private JDateChooser jDateChooserReoperacion = null;
	private JComboBox jComboBoxReoperaciones = null;
	private JLabel jLabelElegirReoperacion = null;
	private JButton jButtonAgregarReoperacion = null;
	private JButton jButtonLimpiar = null;
	private JButton jButtonEliminarReoperacion = null;
	private JButton jButtonAtras = null;
	private ArrayList<TrasplanteReoperacion> listaReoperaciones = new ArrayList<TrasplanteReoperacion>();
	private Trasplante trasplante;
	private TrasplanteReoperacion usado = null;
	private JLabel jLabelElegirComplicacion = null;
	private JComboBox jComboBoxComplicaciones = null;
	private JScrollPane jScrollPaneComplicaciones = null;
	private JList jListComplicacion = null;
	
	/**
	 * This is the default constructor
	 */
	public IUTrasplanteReoperacion(Trasplante t) {
		super();
		initialize();
		this.trasplante = t;
		this.setTitle("Ingresar Reoperacion, fecha trasplante: "+ManejoFechas.FORMATOESPANOL.format(t.getFecha().getTime()));
		this.cargarComplicaciones();
		TrasplanteReoperacion treo = new TrasplanteReoperacion();
		treo.setIdTrasplante(t.getId());
		this.trasplante.setListaReoperaciones(treo.obtenerTodos());
		cargarDatos();
		this.getJScrollPaneComplicaciones().setVisible(false);
	}

	private void cargarComplicaciones(){
		ArrayList<TrasplanteComplicaciones> lista = Fachada.getInstancia().obtenerTodasComplicaciones(this.trasplante.getPreTrasplante());
		for(int x=0;x<lista.size();x++){
			this.getJComboBoxComplicaciones().addItem(lista.get(x));
		}
		if(lista.size() == 0){
			this.getJButtonAgregarReoperacion().setEnabled(false);
			JOptionPane.showMessageDialog(this,"No existe ninguna complicación asociada por lo tanto no podra ingresarse ninguna reoperacion.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void cargarDatos(){
		this.listaReoperaciones = this.trasplante.getListaReoperaciones();
		TrasplanteReoperacion treo = new TrasplanteReoperacion();
		treo.setFecha(null);
		this.jComboBoxReoperaciones.addItem(treo);
		for (int x = 0; x < this.listaReoperaciones.size(); x++) {
			this.jComboBoxReoperaciones.addItem(this.listaReoperaciones.get(x));
		}
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(461, 410);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Reoperacion");
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
			jContentPane.add(getJDesktopPaneDatos(), null);
			jContentPane.add(getJButtonAtras(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jDesktopPaneDatos	
	 * 	
	 * @return javax.swing.JDesktopPane	
	 */
	private JDesktopPane getJDesktopPaneDatos() {
		if (jDesktopPaneDatos == null) {
			jLabelElegirComplicacion = new JLabel();
			jLabelElegirComplicacion.setBounds(new Rectangle(39, 89, 286, 28));
			jLabelElegirComplicacion.setText("Complicacion asociada: ");
			jLabelElegirReoperacion = new JLabel();
			jLabelElegirReoperacion.setBounds(new Rectangle(7, 19, 107, 27));
			jLabelElegirReoperacion.setText("Elegir Reoperacion");
			jLabelFechaReoperacion = new JLabel();
			jLabelFechaReoperacion.setBounds(new Rectangle(4, 50, 117, 24));
			jLabelFechaReoperacion.setText("Fecha Reoperacion");
			jLabelCausaReoperacion = new JLabel();
			jLabelCausaReoperacion.setBounds(new Rectangle(7, 181, 122, 24));
			jLabelCausaReoperacion.setText("Comentario");
			jDesktopPaneDatos = new JDesktopPane();
			jDesktopPaneDatos.setBounds(new Rectangle(50, 17, 383, 315));
			jDesktopPaneDatos.add(jLabelCausaReoperacion, null);
			jDesktopPaneDatos.add(getJScrollPaneCausaReoperacion(), null);
			jDesktopPaneDatos.add(jLabelFechaReoperacion, null);
			jDesktopPaneDatos.add(getJDateChooserReoperacion(), null);
			jDesktopPaneDatos.add(getJComboBoxReoperaciones(), null);
			jDesktopPaneDatos.add(jLabelElegirReoperacion, null);
			jDesktopPaneDatos.add(getJButtonAgregarReoperacion(), null);
			jDesktopPaneDatos.add(getJButtonLimpiar(), null);
			jDesktopPaneDatos.add(getJButtonEliminarReoperacion(), null);
			jDesktopPaneDatos.add(jLabelElegirComplicacion, null);
			jDesktopPaneDatos.add(getJComboBoxComplicaciones(), null);
			jDesktopPaneDatos.add(getJScrollPaneComplicaciones(), null);
		}
		return jDesktopPaneDatos;
	}

	/**
	 * This method initializes jScrollPaneCausaReoperacion	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneCausaReoperacion() {
		if (jScrollPaneCausaReoperacion == null) {
			jScrollPaneCausaReoperacion = new JScrollPane();
			jScrollPaneCausaReoperacion.setBounds(new Rectangle(48, 212, 263, 56));
			jScrollPaneCausaReoperacion.setViewportView(getJTextAreaCausaReoperacion());
		}
		return jScrollPaneCausaReoperacion;
	}

	/**
	 * This method initializes jTextAreaCausaReoperacion	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextAreaCausaReoperacion() {
		if (jTextAreaCausaReoperacion == null) {
			jTextAreaCausaReoperacion = new JTextArea();
			jTextAreaCausaReoperacion.setForeground(new Color(0, 51, 51));
			jTextAreaCausaReoperacion.setLineWrap(true);
		}
		return jTextAreaCausaReoperacion;
	}

	/**
	 * This method initializes jDateChooserReoperacion	
	 * 	
	 * @return com.toedter.calendar.JDateChooser	
	 */
	private JDateChooser getJDateChooserReoperacion() {
		if (jDateChooserReoperacion == null) {
			jDateChooserReoperacion = new JDateChooser();
			jDateChooserReoperacion.setBounds(new Rectangle(132, 51, 152, 28));
		}
		return jDateChooserReoperacion;
	}

	/**
	 * This method initializes jComboBoxReoperaciones	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxReoperaciones() {
		if (jComboBoxReoperaciones == null) {
			jComboBoxReoperaciones = new JComboBox();
			jComboBoxReoperaciones.setBounds(new Rectangle(133, 19, 151, 26));
			jComboBoxReoperaciones.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					mostrarReoperacion();
				}
			});
		}
		return jComboBoxReoperaciones;
	}

	/**
	 * This method initializes jButtonAgregarReoperacion	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAgregarReoperacion() {
		if (jButtonAgregarReoperacion == null) {
			jButtonAgregarReoperacion = new JButton();
			jButtonAgregarReoperacion.setBounds(new Rectangle(190, 279, 94, 18));
			jButtonAgregarReoperacion.setText("Agregar");
			jButtonAgregarReoperacion
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							agregarReoperacion();
						}
					});
		}
		return jButtonAgregarReoperacion;
	}

	/**
	 * This method initializes jButtonLimpiar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonLimpiar() {
		if (jButtonLimpiar == null) {
			jButtonLimpiar = new JButton();
			jButtonLimpiar.setBounds(new Rectangle(293, 24, 85, 19));
			jButtonLimpiar.setText("Limpiar");
			jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					limpiarReoperacion();
				}
			});
		}
		return jButtonLimpiar;
	}

	/**
	 * This method initializes jButtonEliminarReoperacion	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonEliminarReoperacion() {
		if (jButtonEliminarReoperacion == null) {
			jButtonEliminarReoperacion = new JButton();
			jButtonEliminarReoperacion.setBounds(new Rectangle(69, 280, 94, 18));
			jButtonEliminarReoperacion.setText("Eliminar");
			jButtonEliminarReoperacion
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							eliminarReoperacion();
						}
					});
		}
		return jButtonEliminarReoperacion;
	}

	/**
	 * This method initializes jButtonAtras	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAtras() {
		if (jButtonAtras == null) {
			jButtonAtras = new JButton();
			jButtonAtras.setBounds(new Rectangle(9, 344, 129, 29));
			jButtonAtras.setText("Atras");
			jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salir();
				}
			});
		}
		return jButtonAtras;
	}

	private void salir(){
		this.dispose();
	}
	
	private void mostrarReoperacion() {
		TrasplanteReoperacion treo = (TrasplanteReoperacion) this.jComboBoxReoperaciones
				.getSelectedItem();
		if(treo.getFecha() != null){
			this.jDateChooserReoperacion.setCalendar(treo.getFecha());
			this.jTextAreaCausaReoperacion.setText(treo.getComentario());
			this.usado = treo;
			this.getJScrollPaneComplicaciones().setVisible(true);
			this.getJComboBoxComplicaciones().setVisible(false);
			ArrayList<TrasplanteComplicaciones> lista = new ArrayList<TrasplanteComplicaciones>();
			lista.add(treo.getComplicacion());
			this.getJListComplicacion().setListData(lista.toArray());
		}
	}
	
	
	private void eliminarReoperacion() {
		TrasplanteReoperacion treo = (TrasplanteReoperacion) this.jComboBoxReoperaciones.getSelectedItem();
		String respuesta = "";
		respuesta = JOptionPane.showInputDialog(this, "Está a punto de eliminar una reoperacion \n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
		if(respuesta==null)respuesta="No";
		if(respuesta.equalsIgnoreCase("Si")){
			if(treo.getFecha() != null){
				Fachada.getInstancia().eliminarReoperacion(treo);
				this.listaReoperaciones.remove(treo);
				this.jComboBoxReoperaciones.removeItem(this.jComboBoxReoperaciones
						.getSelectedItem());
				this.limpiarReoperacion();
				this.getJScrollPaneComplicaciones().setVisible(false);
				this.getJComboBoxComplicaciones().setVisible(true);
				if (this.jComboBoxReoperaciones.getItemCount() == 0) {
					this.jButtonLimpiar.setVisible(false);
				}
			}
		}
		
	}
	
	private void limpiarReoperacion() {
		this.jTextAreaCausaReoperacion.setText("");
		this.jDateChooserReoperacion.setCalendar(null);
		this.usado = null;
		this.getJScrollPaneComplicaciones().setVisible(false);
		this.getJComboBoxComplicaciones().setVisible(true);
		this.getJComboBoxReoperaciones().setSelectedIndex(0);
	}
	
	private void agregarReoperacion() {
		if(this.jDateChooserReoperacion.getCalendar() != null){
			if(this.jDateChooserReoperacion.getCalendar().before(this.trasplante.getFecha())){
				JOptionPane.showMessageDialog(this,"La fecha de la reoperacion tiene que ser posterior a la del trasplante ", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			TrasplanteComplicaciones compli = (TrasplanteComplicaciones) this.getJComboBoxComplicaciones().getSelectedItem();
			if(this.jDateChooserReoperacion.getCalendar().before(compli.getFecha())){
				JOptionPane.showMessageDialog(this,"La fecha de la reoperacion tiene que ser posterior a la de la complicacion asociada ", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			TrasplanteReoperacion treo = new TrasplanteReoperacion();
			if(this.usado != null){
				if(this.jDateChooserReoperacion.getCalendar().equals(this.usado.getFecha())){
					treo.setFecha(this.jDateChooserReoperacion.getCalendar());
					this.usado.setComentario(this.jTextAreaCausaReoperacion.getText());
				}
			}else{
				treo.setFecha(this.jDateChooserReoperacion.getCalendar());
			}
			treo.setComentario(this.jTextAreaCausaReoperacion.getText());
			treo.setIdTrasplante(this.trasplante.getId());
			treo.setNumComplicacion(compli.getId());
			treo.setComplicacion(compli);
			Fachada.getInstancia().guardarReoperacion(treo);
			this.listaReoperaciones.add(treo);
			if(this.usado == null){
				this.jComboBoxReoperaciones.addItem(treo);	
			}
			this.jTextAreaCausaReoperacion.setText("");
			this.jDateChooserReoperacion.setCalendar(null);
			this.getJScrollPaneComplicaciones().setVisible(false);
			this.getJComboBoxComplicaciones().setVisible(true);
		}
	}

	/**
	 * This method initializes jComboBoxComplicaciones	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxComplicaciones() {
		if (jComboBoxComplicaciones == null) {
			jComboBoxComplicaciones = new JComboBox();
			jComboBoxComplicaciones.setBounds(new Rectangle(4, 120, 363, 38));
		}
		return jComboBoxComplicaciones;
	}

	/**
	 * This method initializes jScrollPaneComplicaciones	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneComplicaciones() {
		if (jScrollPaneComplicaciones == null) {
			jScrollPaneComplicaciones = new JScrollPane();
			jScrollPaneComplicaciones.setBounds(new Rectangle(4, 120, 363, 38));
			jScrollPaneComplicaciones.setViewportView(getJListComplicacion());
		}
		return jScrollPaneComplicaciones;
	}

	/**
	 * This method initializes jListComplicacion	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJListComplicacion() {
		if (jListComplicacion == null) {
			jListComplicacion = new JList();
		}
		return jListComplicacion;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
