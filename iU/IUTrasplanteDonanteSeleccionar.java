package iU;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import logica.Fachada;
import auxiliares.ModeloDatosListaDonantes;
import auxiliares.TableSorter;
import dominio.Donante;
import dominio.Trasplante;

public class IUTrasplanteDonanteSeleccionar extends JFrame implements java.util.Observer{

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPaneDonantes = null;
	private JTable jTableDonantes = null;

	private ArrayList<Donante> listaDonates = new ArrayList<Donante>();
	private JButton jButtonModificar = null;
	private JButton jButtonMasDatos = null;
	private JButton jButtonSalir = null;
	private IUTrasplanteManejar iuTrasplante;
	private JLabel jLabelNoHay = null;
	private JButton jButtonCrear = null;
	/**
	 * This is the default constructor
	 */
	public IUTrasplanteDonanteSeleccionar(IUTrasplanteManejar t) {
		super();
		initialize();
		Fachada.getInstancia().agregarObservador(this);
		cargarDatos();
		this.iuTrasplante = t;
	}

	private void cargarDatos(){
		//Traigo todos los pacientes
		listaDonates = Fachada.getInstancia().obtenerTodosDonantesSolo();
		if(listaDonates.size()>0){
			ModeloDatosListaDonantes md = new ModeloDatosListaDonantes(listaDonates);
			TableSorter sortPacientes = new TableSorter(md);
			this.jTableDonantes.setModel(sortPacientes);
			sortPacientes.addMouseListenerToHeaderInTable(this.getJTableDonantes());
			this.jLabelNoHay.setVisible(false);
		}else{
			this.jLabelNoHay.setVisible(true);
		}

	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(817, 429);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Seleccionar Donante");
		this.setLocationByPlatform(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelNoHay = new JLabel();
			jLabelNoHay.setBounds(new Rectangle(43, 287, 371, 37));
			jLabelNoHay.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelNoHay.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelNoHay.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
			jLabelNoHay.setForeground(Color.red);
			jLabelNoHay.setText("No hay Donante que no esten relacionados con un trasplante");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 204));
			jContentPane.add(getJScrollPaneDonantes(), null);
			jContentPane.add(getJButtonModificar(), null);
			jContentPane.add(getJButtonMasDatos(), null);
			jContentPane.add(getJButtonSalir(), null);
			jContentPane.add(jLabelNoHay, null);
			jContentPane.add(getJButtonCrear(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPaneDonantes	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneDonantes() {
		if (jScrollPaneDonantes == null) {
			jScrollPaneDonantes = new JScrollPane();
			jScrollPaneDonantes.setBounds(new Rectangle(18, 20, 616, 257));
			jScrollPaneDonantes.setViewportView(getJTableDonantes());
		}
		return jScrollPaneDonantes;
	}

	/**
	 * This method initializes jTableDonantes	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableDonantes() {
		if (jTableDonantes == null) {
			jTableDonantes = new JTable();
			jTableDonantes.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		return jTableDonantes;
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

	/**
	 * This method initializes jButtonModificar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonModificar() {
		if (jButtonModificar == null) {
			jButtonModificar = new JButton();
			jButtonModificar.setBounds(new Rectangle(650, 103, 126, 32));
			jButtonModificar.setText("Usar Donante");
			jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					usarDonante();
				}
			});
		}
		return jButtonModificar;
	}

	/**
	 * This method initializes jButtonMasDatos	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonMasDatos() {
		if (jButtonMasDatos == null) {
			jButtonMasDatos = new JButton();
			jButtonMasDatos.setBounds(new Rectangle(119, 331, 219, 33));
			jButtonMasDatos.setText("Ver todos los datos");
			jButtonMasDatos.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					mostrar();
				}
			});
		}
		return jButtonMasDatos;
	}

	/**
	 * This method initializes jButtonSalir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSalir() {
		if (jButtonSalir == null) {
			jButtonSalir = new JButton();
			jButtonSalir.setBounds(new Rectangle(503, 328, 126, 32));
			jButtonSalir.setText("Atras");
			jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salir();
				}
			});
		}
		return jButtonSalir;
	}
	
	private void mostrar(){
		int fila  = this.jTableDonantes.getSelectedRow();
		if(fila<0) return;
		Donante d = this.listaDonates.get(fila);
		if(d != null){
			IUDonanteModificar iu = new IUDonanteModificar(d,true);
			iu.setVisible(true);
		}
	}
	
	
	private void usarDonante(){
		int fila  = this.jTableDonantes.getSelectedRow();
		if(fila<0) return;
		Donante d = this.listaDonates.get(fila);
		if(d != null){
			Trasplante t = this.iuTrasplante.devolverTrasplante();
			t.setDonante(d);
			this.iuTrasplante.cargarTrasplante(t);
			this.salir();
		}
	}
	
	private void crear(){
		IUDonanteIngresar iu = new IUDonanteIngresar();
		iu.setVisible(true);
	}

	/**
	 * This method initializes jButtonCrear	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCrear() {
		if (jButtonCrear == null) {
			jButtonCrear = new JButton();
			jButtonCrear.setBounds(new Rectangle(650, 35, 126, 32));
			jButtonCrear.setText("Crear Donante");
			jButtonCrear.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					crear();
				}
			});
		}
		return jButtonCrear;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
