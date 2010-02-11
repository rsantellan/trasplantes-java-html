package iu.evolucion;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;

import dominio.EvolucionTrasplanteExamenes;

import javax.swing.JList;
import javax.swing.JButton;

import logica.Fachada;

public class IUEvolucionExamenesManejar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JComboBox jComboBoxExamenes = null;
	private JLabel jLabelExamenesParaRealizar = null;
	private JRadioButton jRadioButtonNormal = null;
	private JRadioButton jRadioButtonPatologico = null;
	private JScrollPane jScrollPaneComentario = null;
	private JTextArea jTextAreaComentario = null;
	private JLabel jLabelComentario = null;
	private JLabel jLabelFecha = null;
	private JDateChooser jDateChooserFecha = null;
	private JLabel jLabelExamenesRealizados = null;
	private JScrollPane jScrollPaneRealizados = null;
	private JList jListRealizados = null;
	private JButton jButtonAtras = null;
	private JButton jButtonGuardar = null;
	private JButton jButtonEliminar = null;
	private int idTrasplante;
	private Calendar fecha = new GregorianCalendar();
	private EvolucionTrasplanteExamenes usada = null;
	ArrayList<EvolucionTrasplanteExamenes> lista = new ArrayList<EvolucionTrasplanteExamenes>();
	private boolean muletilla = false;
	/**
	 * This is the default constructor
	 */
	public IUEvolucionExamenesManejar(int id, Calendar fecha) {
		super();
		initialize();
		this.idTrasplante = id;
		this.fecha = fecha;
		cargarDatos();
	}

	private void cargarDatos(){
		lista = Fachada.getInstancia().obtenerTodosEvolucionExamenes(this.idTrasplante,fecha);
		this.jListRealizados.setListData(lista.toArray());
		ArrayList<EvolucionTrasplanteExamenes> aux = new ArrayList<EvolucionTrasplanteExamenes>();
		EvolucionTrasplanteExamenes a1 = new EvolucionTrasplanteExamenes();
		a1.setTipo(EvolucionTrasplanteExamenes.GINECOLOGO);
		aux.add(a1);
		EvolucionTrasplanteExamenes a2 = new EvolucionTrasplanteExamenes();
		a2.setTipo(EvolucionTrasplanteExamenes.OFTALMOLOGO);
		aux.add(a2);
		EvolucionTrasplanteExamenes a3 = new EvolucionTrasplanteExamenes();
		a3.setTipo(EvolucionTrasplanteExamenes.RXOSEAS);
		aux.add(a3);
		EvolucionTrasplanteExamenes a4 = new EvolucionTrasplanteExamenes();
		a4.setTipo(EvolucionTrasplanteExamenes.UROLOGO);
		aux.add(a4);
		EvolucionTrasplanteExamenes a5 = new EvolucionTrasplanteExamenes();
		a5.setTipo(EvolucionTrasplanteExamenes.TAC);
		aux.add(a5);
		EvolucionTrasplanteExamenes a6 = new EvolucionTrasplanteExamenes();
		a6.setTipo(EvolucionTrasplanteExamenes.RNM);
		aux.add(a6);
		EvolucionTrasplanteExamenes a7 = new EvolucionTrasplanteExamenes();
		a7.setTipo(EvolucionTrasplanteExamenes.CENTELLO_GRAMA);
		aux.add(a7);
		for(int x=0;x<lista.size();x++){
			EvolucionTrasplanteExamenes aux1 = (EvolucionTrasplanteExamenes) lista.get(x);
			if(aux.contains(aux1)){
				aux.remove(aux1);
			}
		}
		if(aux.size()>0){
			for(int x=0;x<aux.size();x++){
				this.getJComboBoxExamenes().addItem(aux.get(x));
			}
		}else{
			this.getJComboBoxExamenes().setVisible(false);
		}
		this.getJDateChooserFecha().setCalendar(this.fecha);
		this.getJDateChooserFecha().setEnabled(false);
		this.normal();
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(541, 438);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Otros Examenes");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelExamenesRealizados = new JLabel();
			jLabelExamenesRealizados.setBounds(new Rectangle(300, 47, 172, 35));
			jLabelExamenesRealizados.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelExamenesRealizados.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelExamenesRealizados.setText("Examenes realizados");
			jLabelExamenesRealizados.setBackground(new Color(255, 255, 204));
			jLabelFecha = new JLabel();
			jLabelFecha.setBounds(new Rectangle(123, 6, 193, 31));
			jLabelFecha.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelFecha.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelFecha.setText("Fecha Realizados");
			jLabelFecha.setBackground(new Color(255, 255, 204));
			jLabelComentario = new JLabel();
			jLabelComentario.setBounds(new Rectangle(27, 171, 217, 28));
			jLabelComentario.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelComentario.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelComentario.setText("Comentario");
			jLabelComentario.setBackground(new Color(255, 255, 204));
			jLabelExamenesParaRealizar = new JLabel();
			jLabelExamenesParaRealizar.setBounds(new Rectangle(34, 48, 205, 32));
			jLabelExamenesParaRealizar.setBackground(new Color(255, 255, 204));
			jLabelExamenesParaRealizar.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelExamenesParaRealizar.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelExamenesParaRealizar.setText("Examenes para realizar");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 204));
			jContentPane.add(getJComboBoxExamenes(), null);
			jContentPane.add(jLabelExamenesParaRealizar, null);
			jContentPane.add(getJRadioButtonNormal(), null);
			jContentPane.add(getJRadioButtonPatologico(), null);
			jContentPane.add(getJScrollPaneComentario(), null);
			jContentPane.add(jLabelComentario, null);
			jContentPane.add(jLabelFecha, null);
			jContentPane.add(getJDateChooserFecha(), null);
			jContentPane.add(jLabelExamenesRealizados, null);
			jContentPane.add(getJScrollPaneRealizados(), null);
			jContentPane.add(getJButtonAtras(), null);
			jContentPane.add(getJButtonGuardar(), null);
			jContentPane.add(getJButtonEliminar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jComboBoxExamenes	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxExamenes() {
		if (jComboBoxExamenes == null) {
			jComboBoxExamenes = new JComboBox();
			jComboBoxExamenes.setBounds(new Rectangle(31, 90, 210, 33));
		}
		return jComboBoxExamenes;
	}

	/**
	 * This method initializes jRadioButtonNormal	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonNormal() {
		if (jRadioButtonNormal == null) {
			jRadioButtonNormal = new JRadioButton();
			jRadioButtonNormal.setBounds(new Rectangle(31, 135, 100, 27));
			jRadioButtonNormal.setBackground(new Color(255, 255, 204));
			jRadioButtonNormal.setText("Normal");
			jRadioButtonNormal.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					normal();
				}
			});
		}
		return jRadioButtonNormal;
	}

	/**
	 * This method initializes jRadioButtonPatologico	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonPatologico() {
		if (jRadioButtonPatologico == null) {
			jRadioButtonPatologico = new JRadioButton();
			jRadioButtonPatologico.setBounds(new Rectangle(148, 136, 94, 27));
			jRadioButtonPatologico.setText("Patologico");
			jRadioButtonPatologico.setBackground(new Color(255, 255, 204));
			jRadioButtonPatologico.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					patologico();
				}
			});
		}
		return jRadioButtonPatologico;
	}

	/**
	 * This method initializes jScrollPaneComentario	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneComentario() {
		if (jScrollPaneComentario == null) {
			jScrollPaneComentario = new JScrollPane();
			jScrollPaneComentario.setBounds(new Rectangle(30, 205, 209, 127));
			jScrollPaneComentario.setViewportView(getJTextAreaComentario());
		}
		return jScrollPaneComentario;
	}

	/**
	 * This method initializes jTextAreaComentario	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextAreaComentario() {
		if (jTextAreaComentario == null) {
			jTextAreaComentario = new JTextArea();
		}
		return jTextAreaComentario;
	}

	/**
	 * This method initializes jDateChooserFecha	
	 * 	
	 * @return com.toedter.calendar.JDateChooser	
	 */
	private JDateChooser getJDateChooserFecha() {
		if (jDateChooserFecha == null) {
			jDateChooserFecha = new JDateChooser();
			jDateChooserFecha.setBounds(new Rectangle(325, 6, 182, 33));
		}
		return jDateChooserFecha;
	}

	/**
	 * This method initializes jScrollPaneRealizados	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneRealizados() {
		if (jScrollPaneRealizados == null) {
			jScrollPaneRealizados = new JScrollPane();
			jScrollPaneRealizados.setBounds(new Rectangle(300, 96, 172, 175));
			jScrollPaneRealizados.setViewportView(getJListRealizados());
		}
		return jScrollPaneRealizados;
	}

	/**
	 * This method initializes jListRealizados	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJListRealizados() {
		if (jListRealizados == null) {
			jListRealizados = new JList();
			jListRealizados
					.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
						public void valueChanged(javax.swing.event.ListSelectionEvent e) {
							mostrarExamen();
						}
					});
		}
		return jListRealizados;
	}

	/**
	 * This method initializes jButtonAtras	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAtras() {
		if (jButtonAtras == null) {
			jButtonAtras = new JButton();
			jButtonAtras.setBounds(new Rectangle(12, 360, 132, 36));
			jButtonAtras.setText("Atras");
			jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salir();
				}
			});
		}
		return jButtonAtras;
	}

	/**
	 * This method initializes jButtonGuardar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonGuardar() {
		if (jButtonGuardar == null) {
			jButtonGuardar = new JButton();
			jButtonGuardar.setBounds(new Rectangle(360, 360, 132, 36));
			jButtonGuardar.setText("Guardar");
			jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					guardar();
				}
			});
		}
		return jButtonGuardar;
	}

	/**
	 * This method initializes jButtonEliminar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonEliminar() {
		if (jButtonEliminar == null) {
			jButtonEliminar = new JButton();
			jButtonEliminar.setBounds(new Rectangle(317, 279, 132, 36));
			jButtonEliminar.setText("Eliminar");
			jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					eliminar();
				}
			});
		}
		return jButtonEliminar;
	}

	private void normal(){
		this.getJRadioButtonNormal().setSelected(true);
		this.getJRadioButtonPatologico().setSelected(false);
		this.getJTextAreaComentario().setEnabled(false);
	}
	
	private void patologico(){
		this.getJRadioButtonNormal().setSelected(false);
		this.getJRadioButtonPatologico().setSelected(true);
		this.getJTextAreaComentario().setEnabled(true);
	}
	
	private void mostrarExamen(){
		this.getJComboBoxExamenes().setVisible(false);
		EvolucionTrasplanteExamenes aux = (EvolucionTrasplanteExamenes) this.getJListRealizados().getSelectedValue();
		this.usada = aux;
		if(aux == null) return;
		this.jLabelExamenesParaRealizar.setText(aux.getTipo());
		if(aux.isNormal()){
			this.normal();
			this.jTextAreaComentario.setText("");
		}else{
			this.patologico();
			this.jTextAreaComentario.setText(aux.getComentario());
		}
	}
	
	private void guardar(){
		if(this.usada == null){
			EvolucionTrasplanteExamenes nueva = new EvolucionTrasplanteExamenes();
			nueva.setNormal(this.getJRadioButtonNormal().isSelected());
			EvolucionTrasplanteExamenes combo = (EvolucionTrasplanteExamenes) this.jComboBoxExamenes.getSelectedItem();
			nueva.setTipo((String) combo.getTipo());
			nueva.setComentario(this.getJTextAreaComentario().getText());
			nueva.setIdTrasplante(this.idTrasplante);
			nueva.setFecha(this.fecha);
			Fachada.getInstancia().guardarEvolucionTrasplanteExamenes(nueva);
			this.getJListRealizados().removeAll();
			this.lista.add(nueva);
			this.getJListRealizados().setListData(this.lista.toArray());
			this.jTextAreaComentario.setText("");
			this.normal();
			if(this.getJComboBoxExamenes().getItemCount()==1){
				this.getJComboBoxExamenes().addItem(new EvolucionTrasplanteExamenes());
				muletilla = true;
				this.getJComboBoxExamenes().removeItemAt(0);
				this.getJComboBoxExamenes().setVisible(false);
			}else{
				this.getJComboBoxExamenes().removeItemAt(this.getJComboBoxExamenes().getSelectedIndex());
			}
		}else{
			this.lista.remove(this.usada);
			this.usada.setNormal(this.getJRadioButtonNormal().isSelected());
			if(this.getJRadioButtonNormal().isSelected()){
				this.usada.setComentario("");
			}else{
				this.usada.setComentario(this.getJTextAreaComentario().getText());
			}
			this.usada.setIdTrasplante(this.idTrasplante);
			this.usada.setFecha(this.fecha);
			Fachada.getInstancia().guardarEvolucionTrasplanteExamenes(this.usada);
			this.jTextAreaComentario.setText("");
			this.normal();
			this.getJListRealizados().removeAll();
			this.lista.add(this.usada);
			this.getJListRealizados().setListData(this.lista.toArray());
			if(!muletilla){
				this.getJComboBoxExamenes().setVisible(true);
			}
		}
		jLabelExamenesParaRealizar.setText("Examenes para realizar");
		this.usada = null;
	}
	
	private void eliminar(){
		if(this.usada == null) return;
		String respuesta = "";
		respuesta = JOptionPane.showInputDialog(this, "Est� a punto de eliminar el examen" + this.usada.getTipo()+"\n(Ingrese SI para eliminar) Confirmar: ", "Confirmar", 1);
		if(respuesta==null)respuesta="No";
		if(respuesta.equalsIgnoreCase("Si")){
			Fachada.getInstancia().eliminarEvolucionTrasplanteExamenes(this.usada);
			this.jTextAreaComentario.setText("");
			this.normal();
			jLabelExamenesParaRealizar.setText("Examenes para realizar");
			this.getJComboBoxExamenes().addItem(this.usada);
			this.lista.remove(this.usada);
			this.getJListRealizados().removeAll();
			this.getJListRealizados().setListData(this.lista.toArray());
			this.usada = null;
			if(muletilla){
				this.getJComboBoxExamenes().removeItemAt(0);
				this.getJComboBoxExamenes().setVisible(true);
			}
			if(this.getJComboBoxExamenes().getItemCount()>1){
				this.getJComboBoxExamenes().setVisible(true);
			}
		}
	}
	
	private void salir(){
		this.dispose();
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
