package uy.transplante.consultas.creador.iu;

import iu.consultas.IUConsultaGenerica;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.Rectangle;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JComboBox;
import javax.swing.WindowConstants;

import logica.Fachada;

import javax.swing.JList;

import uy.transplante.dominio.Generico;
import uy.transplante.dominio.GenericoAuxiliar;

public class IUCreadorConsultas extends JFrame implements java.util.Observer{

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTabbedPane jTabbedPaneConsultas = null;
	private JInternalFrame jInternalFrameCrear = null;
	private JPanel jContentPaneCrear = null;
	private JScrollPane jScrollPaneConsulta = null;
	private JTextArea jTextAreaConsulta = null;
	private JTextField jTextFieldNombre = null;
	private JButton jButtonGuardar = null;
	private JButton jButtonUsar = null;
	private JLabel jLabelNombre = null;
	private JButton jButtonSalir = null;
	private JComboBox jComboBoxTipos = null;
	private JLabel jLabelTipos = null;
	private JButton jButtonSiguiente = null;
	/**
	 * This is the default constructor
	 */
	public IUCreadorConsultas() {
		super();
		initialize();
		cargarDatos();
		this.ocultar();
		Fachada.getInstancia().cambie();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(1023, 601);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Creador de Consultas Beta 0.1");
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
			jContentPane.add(getJTabbedPaneConsultas(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTabbedPaneConsultas	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPaneConsultas() {
		if (jTabbedPaneConsultas == null) {
			jTabbedPaneConsultas = new JTabbedPane();
			jTabbedPaneConsultas.setBounds(new Rectangle(5, 5, 986, 535));
			jTabbedPaneConsultas.addTab("Crear", null, getJInternalFrameCrear(), null);
			jTabbedPaneConsultas.addTab("Cargar", null, getJInternalFrameLeer(), null);
		}
		return jTabbedPaneConsultas;
	}

	/**
	 * This method initializes jInternalFrameCrear	
	 * 	
	 * @return javax.swing.JInternalFrame	
	 */
	private JInternalFrame getJInternalFrameCrear() {
		if (jInternalFrameCrear == null) {
			jInternalFrameCrear = new JInternalFrame();
			jInternalFrameCrear.setTitle("Crear");
			jInternalFrameCrear.setContentPane(getJContentPaneCrear());
		}
		return jInternalFrameCrear;
	}

	/**
	 * This method initializes jContentPaneCrear	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPaneCrear() {
		if (jContentPaneCrear == null) {
			jLabelNombreTabla = new JLabel();
			jLabelNombreTabla.setBounds(new Rectangle(614, 265, 186, 36));
			jLabelNombreTabla.setText("Nombre en tabla");
			jLabelTipos = new JLabel();
			jLabelTipos.setBounds(new Rectangle(42, 303, 287, 47));
			jLabelTipos.setText("JLabel");
			jLabelNombre = new JLabel();
			jLabelNombre.setBounds(new Rectangle(16, 236, 260, 40));
			jLabelNombre.setText("Ingrese el nombre de la consulta:");
			jContentPaneCrear = new JPanel();
			jContentPaneCrear.setLayout(null);
			jContentPaneCrear.setBackground(new Color(204, 255, 204));
			jContentPaneCrear.add(getJScrollPaneConsulta(), null);
			jContentPaneCrear.add(getJTextFieldNombre(), null);
			jContentPaneCrear.add(getJButtonGuardar(), null);
			jContentPaneCrear.add(getJButtonUsar(), null);
			jContentPaneCrear.add(jLabelNombre, null);
			jContentPaneCrear.add(getJButtonSalir(), null);
			jContentPaneCrear.add(getJComboBoxTipos(), null);
			jContentPaneCrear.add(jLabelTipos, null);
			jContentPaneCrear.add(getJButtonSiguiente(), null);
			jContentPaneCrear.add(getJTextFieldNombrePantalla(), null);
			jContentPaneCrear.add(jLabelNombreTabla, null);
		}
		return jContentPaneCrear;
	}

	/**
	 * This method initializes jScrollPaneConsulta	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneConsulta() {
		if (jScrollPaneConsulta == null) {
			jScrollPaneConsulta = new JScrollPane();
			jScrollPaneConsulta.setBounds(new Rectangle(14, 13, 938, 192));
			jScrollPaneConsulta.setViewportView(getJTextAreaConsulta());
		}
		return jScrollPaneConsulta;
	}

	/**
	 * This method initializes jTextAreaConsulta	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextAreaConsulta() {
		if (jTextAreaConsulta == null) {
			jTextAreaConsulta = new JTextArea();
		}
		return jTextAreaConsulta;
	}

	/**
	 * This method initializes jTextFieldNombre	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNombre() {
		if (jTextFieldNombre == null) {
			jTextFieldNombre = new JTextField();
			jTextFieldNombre.setBounds(new Rectangle(304, 240, 277, 35));
		}
		return jTextFieldNombre;
	}

	/**
	 * This method initializes jButtonGuardar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonGuardar() {
		if (jButtonGuardar == null) {
			jButtonGuardar = new JButton();
			jButtonGuardar.setBounds(new Rectangle(803, 415, 142, 48));
			jButtonGuardar.setText("Guardar y Usar");
			jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					guardarUsar();
				}
			});
		}
		return jButtonGuardar;
	}

	/**
	 * This method initializes jButtonUsar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonUsar() {
		if (jButtonUsar == null) {
			jButtonUsar = new JButton();
			jButtonUsar.setBounds(new Rectangle(455, 410, 154, 49));
			jButtonUsar.setText("Usar");
			jButtonUsar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					soloUsar();
				}
			});
		}
		return jButtonUsar;
	}

	/**
	 * This method initializes jButtonSalir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSalir() {
		if (jButtonSalir == null) {
			jButtonSalir = new JButton();
			jButtonSalir.setBounds(new Rectangle(35, 407, 195, 46));
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
	 * This method initializes jComboBoxTipos	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxTipos() {
		if (jComboBoxTipos == null) {
			jComboBoxTipos = new JComboBox();
			jComboBoxTipos.setBounds(new Rectangle(340, 304, 246, 44));
		}
		return jComboBoxTipos;
	}

	/**
	 * This method initializes jButtonSiguiente	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSiguiente() {
		if (jButtonSiguiente == null) {
			jButtonSiguiente = new JButton();
			jButtonSiguiente.setBounds(new Rectangle(771, 311, 152, 36));
			jButtonSiguiente.setText("Siguiente");
			jButtonSiguiente.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					guardarTipoDato();
				}
			});
		}
		return jButtonSiguiente;
	}

	private void usar(){
		String sql = this.getJTextAreaConsulta().getText();
		char asterisco = '*';
		char finalizar = ';';
		char sentencia[] = sql.toCharArray();
		String atributo = "";
		ArrayList<String> aux = new ArrayList<String>();
		int formu = 0;
		for(int x=0;x<sentencia.length;x++){
			if(sentencia[x] == asterisco || sentencia[x] == finalizar){
				x = sentencia.length-1;
			}
			if(sentencia[x] == ' '){
				aux.add(atributo);
				atributo = "";
				x = sentencia.length -1;
			}
			if(sentencia[x] != ','){
				if(sentencia[x] == '('){
					formu++;
					aux.add("Formula " + formu);
					while(sentencia[x] != ')'){
						x++;
					}
				}else{
					atributo += sentencia[x];
					if(atributo.equalsIgnoreCase("SELECT")){
						atributo = "";
						x++;
					}else{
						if(atributo.equalsIgnoreCase("FROM")){
							x = sentencia.length;
							atributo = "";
						}
						
						
					}
				}
			}else{
				aux.add(atributo);
				atributo = "";
			}
		}
		System.out.println("Resultado");
		for(int x=0;x<aux.size();x++){
			System.out.println(aux.get(x).toString());
		}
		this.datos = aux;
	}
	
	private ArrayList<String> datos;
	private int pos = -1;
	private boolean guardar = false;
	
	private boolean chequearSentenciaSQL(){
		boolean salida = true;
		char[] delete = {'D','E','L','E','T','E'};
		char[] insert = {'I','N','S','E','R','T'};
		char asterisco = '*';
		char puntoComa = ';';
		String sql = this.getJTextAreaConsulta().getText();
		sql = sql.toUpperCase();
		char[] texto = sql.toCharArray();
		int puntero = 0;
		int lugar = 0;
		//Si lugar = 1 esta en delete si lugar = 2 esta en insert
		int x= 0;
		while(x < texto.length){
			if(texto[x] == asterisco) return false;
			if(texto[x] == puntoComa) return false;
			switch (lugar) {
			case 0:
				if(texto[x] == delete[0]){
					lugar = 1;
					puntero = 1;
				}else{
					if(texto[x] == insert[0]){
						lugar = 2;
						puntero = 1;
					}
				}
				x ++;
				break;
			case 1:
				if(texto[x] == delete[puntero]){
					puntero += 1;
					if(puntero == delete.length){
						return false;
					}
					x ++;
				}else{
					lugar = 0;
					puntero = 0;
				}
				break;
			case 2:
				if(texto[x] == insert[puntero]){
					puntero += 1;
					if(puntero == insert.length){
						return false;
					}
					x ++;
				}else{
					lugar = 0;
					puntero = 0;
				}
				break;
			default:
				break;
			}
		}
		return salida;
	}
	
	private void guardarUsar(){
		if(this.chequearSentenciaSQL()){
			this.guardar = true;
			usar();
			mostrar();
			siguiente();
		}else{
			System.out.println("Mal");
		}
		
	}
	
	private void soloUsar(){
		if(this.chequearSentenciaSQL()){
			usar();
			mostrar();
			siguiente();
		}else{
			System.out.println("Mal");
		}
		
	}
	private void mostrar(){
		this.jLabelTipos.setVisible(true);
		this.jLabelNombreTabla.setVisible(true);
		this.getJComboBoxTipos().setVisible(true);
		this.getJTextFieldNombrePantalla().setVisible(true);
		this.getJButtonSiguiente().setVisible(true);
		this.getJButtonUsar().setVisible(false);
		this.getJButtonGuardar().setVisible(false);
		this.getJTextAreaConsulta().setEnabled(false);
		this.getJTextFieldNombre().setEnabled(false);
	}
	
	private void ocultar(){
		this.jLabelTipos.setVisible(false);
		this.jLabelNombreTabla.setVisible(false);
		this.getJComboBoxTipos().setVisible(false);
		this.getJTextFieldNombrePantalla().setVisible(false);
		this.getJButtonSiguiente().setVisible(false);
		this.getJButtonUsar().setVisible(true);
		this.getJButtonGuardar().setVisible(true);
		this.getJTextAreaConsulta().setEnabled(true);
		this.getJTextFieldNombre().setEnabled(true);
	}
	
	private void siguiente(){
		pos++;
		if(pos >= this.datos.size()){
			System.out.println("---------------------------------------------------");
			System.out.println("---------------------------------------------------");
			System.out.println("---------------------------------------------------");
			String tip = "";
			String nom = "";
			for(int x=0;x<this.tipos.size();x++){
				System.out.println(this.datos.get(x).toString());
				System.out.println(this.tipos.get(x));
				System.out.println(this.nombre.get(x));
				tip += this.tipos.get(x).toString() +"|";
				nom += this.nombre.get(x).toString() +"|";
			}
			if(this.guardar){
				GenericoAuxiliar ga = new GenericoAuxiliar();
				ga.setNombre(this.getJTextFieldNombre().getText());
				ga.setSentencia(this.getJTextAreaConsulta().getText());
				ga.setNombres(nom);
				ga.setTipos(tip);
				System.out.println(ga.getNombre());
				System.out.println(ga.getNombres());
				System.out.println(ga.getTipos());
				System.out.println(ga.getSentencia());
				Fachada.getInstancia().guardarGenericoAuxiliar(ga);
			}
			g.setSql(this.getJTextAreaConsulta().getText());
			g.setListaDada(this.tipos);
			g.setListaNombre(this.nombre);
			g.leer();
			IUConsultaGenerica iu = new IUConsultaGenerica(g);
			iu.setVisible(true);
			this.ocultar();
		}else{
			this.jLabelTipos.setText("El tipo de: " + this.datos.get(pos).toString() + " es.");
		}
		
	}
	
	private Generico g = new Generico();  //  @jve:decl-index=0:
	private ArrayList<String> tipos = new ArrayList<String>();  //  @jve:decl-index=0:
	private JTextField jTextFieldNombrePantalla = null;
	private JLabel jLabelNombreTabla = null;
	
	private ArrayList<String> nombre = new ArrayList<String>();  //  @jve:decl-index=0:
	private JInternalFrame jInternalFrameLeer = null;
	private JPanel jContentPaneLeer = null;
	private JButton jButtonConsultar = null;
	private JButton jButtonEliminar = null;
	private JScrollPane jScrollPaneConsultas = null;
	private JList jListConsultas = null;
	
	private void guardarTipoDato(){
		tipos.add((String) this.getJComboBoxTipos().getSelectedItem());
		this.nombre.add(this.getJTextFieldNombrePantalla().getText());
		siguiente();
	}
	
	private void cargarDatos(){
		this.getJComboBoxTipos().addItem(Generico.fechas);
		this.getJComboBoxTipos().addItem(Generico.FLOAT);
		this.getJComboBoxTipos().addItem(Generico.integer);
		this.getJComboBoxTipos().addItem(Generico.character);
		this.getJComboBoxTipos().addItem(Generico.letras);
		this.getJComboBoxTipos().addItem(Generico.VF);
		
		cargarConsultasCreadas();
	}

	private void cargarConsultasCreadas(){
		ArrayList<GenericoAuxiliar> lista = Fachada.getInstancia().obtenerTodasConsultasCreadas();
		this.getJListConsultas().setListData(lista.toArray());
	}
	/**
	 * This method initializes jTextFieldNombrePantalla	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNombrePantalla() {
		if (jTextFieldNombrePantalla == null) {
			jTextFieldNombrePantalla = new JTextField();
			jTextFieldNombrePantalla.setBounds(new Rectangle(611, 310, 146, 37));
		}
		return jTextFieldNombrePantalla;
	}

	/**
	 * This method initializes jInternalFrameLeer	
	 * 	
	 * @return javax.swing.JInternalFrame	
	 */
	private JInternalFrame getJInternalFrameLeer() {
		if (jInternalFrameLeer == null) {
			jInternalFrameLeer = new JInternalFrame();
			jInternalFrameLeer.setTitle("Cargar");
			jInternalFrameLeer.setContentPane(getJContentPaneLeer());
		}
		return jInternalFrameLeer;
	}

	/**
	 * This method initializes jContentPaneLeer	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPaneLeer() {
		if (jContentPaneLeer == null) {
			jContentPaneLeer = new JPanel();
			jContentPaneLeer.setLayout(null);
			jContentPaneLeer.setBackground(new Color(153, 255, 204));
			jContentPaneLeer.add(getJButtonConsultar(), null);
			jContentPaneLeer.add(getJButtonEliminar(), null);
			jContentPaneLeer.add(getJScrollPaneConsultas(), null);
		}
		return jContentPaneLeer;
	}

	/**
	 * This method initializes jButtonConsultar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonConsultar() {
		if (jButtonConsultar == null) {
			jButtonConsultar = new JButton();
			jButtonConsultar.setBounds(new Rectangle(338, 44, 169, 34));
			jButtonConsultar.setText("Consultar");
			jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cargarConsulta();
				}
			});
		}
		return jButtonConsultar;
	}
	
	private void cargarConsulta(){
		GenericoAuxiliar ga  = (GenericoAuxiliar) this.getJListConsultas().getSelectedValue();
		if(ga==null)return;
		Generico g = Fachada.getInstancia().convertirAuxiliarGenerico(ga);
		IUConsultaGenerica iu = new IUConsultaGenerica(g);
		iu.setVisible(true);
	}
	
	private void salir(){
		this.dispose();
		System.exit(0);
	}

	/**
	 * This method initializes jButtonEliminar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonEliminar() {
		if (jButtonEliminar == null) {
			jButtonEliminar = new JButton();
			jButtonEliminar.setBounds(new Rectangle(342, 159, 169, 34));
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
		GenericoAuxiliar ga = (GenericoAuxiliar) this.getJListConsultas().getSelectedValue();
		if(ga==null)return;
		String nueva = "";
		nueva = JOptionPane
				.showInputDialog(
						this,
						"Esta seguro de querer eliminar la Consulta\n(Escriba Si para confirmar) :",
						"Confirmar", 3);
		if (nueva != null) {
			if (nueva.equalsIgnoreCase("si")){
				Fachada.getInstancia().eliminarGenericoAuxiliar(ga);
			}
		}
	}


	public void update(Observable arg0, Object arg1) {
		if(Fachada.getInstancia().getLugar() == Fachada.CREADOR_CONSULTAS)
		cargarConsultasCreadas();
	}

	/**
	 * This method initializes jScrollPaneConsultas	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneConsultas() {
		if (jScrollPaneConsultas == null) {
			jScrollPaneConsultas = new JScrollPane();
			jScrollPaneConsultas.setBounds(new Rectangle(25, 75, 240, 366));
			jScrollPaneConsultas.setViewportView(getJListConsultas());
		}
		return jScrollPaneConsultas;
	}

	/**
	 * This method initializes jListConsultas	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJListConsultas() {
		if (jListConsultas == null) {
			jListConsultas = new JList();
		}
		return jListConsultas;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
