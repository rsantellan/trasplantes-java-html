package uy.transplante.iu.consultas;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;

import uy.transplante.logica.Fachada;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.WindowConstants;
import javax.swing.JButton;

public class IUConsultaLinealComplicacionesTiempo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPaneContein = null;
	private JPanel jPanelGrafica = null;
	private JScrollPane jScrollPaneDetalles = null;
	private JList jListDetalles = null;
	private ArrayList<Integer> datos = new ArrayList<Integer>();  //  @jve:decl-index=0:
	private int desde = 0;
	private int hasta = 0;
	private String tipo = "";  //  @jve:decl-index=0:
	private JButton jButtonSalir = null;
	private JButton jButtonMasDatos = null;
	private JButton jButtonDetalles = null;
	/**
	 * This is the default constructor
	 */
	public IUConsultaLinealComplicacionesTiempo(int desde, int hasta, String tipo) {
		super();
		this.desde = desde;
		this.hasta = hasta;
		this.tipo = tipo;
		System.out.println(this.tipo);
		initialize();
		cargarDatos();
	}

	private void cargarDatos(){
		if(this.datos != null){
			ArrayList<String> lista = new ArrayList<String>();
			Integer cantidad = 0;
			String poner = "";
			if(this.tipo.equalsIgnoreCase("Meses")){
				poner = "mes";
			}
			if(this.tipo.equalsIgnoreCase("Dias")){
				poner = "dia";
			}
			if(this.tipo.equalsIgnoreCase("Años")){
				poner = "año";
			}
			for(int x=0;x<this.datos.size();x++){
				String aux = "La cantidad de complicaciones en el "+ poner +": " + (this.desde + x+1) + " es de " + ((Integer) this.datos.get(x)) ;
				cantidad = cantidad + ((Integer) this.datos.get(x));
				lista.add(aux);
			}
			lista.add("----------------------------------------------");
			lista.add("----------------------------------------------");
			lista.add("----------------------------------------------");
			lista.add("La cantidad de complicaciones en este periodo es de " + cantidad);
			lista.add("El promedio por "+poner+" de complicaciones es de " + (cantidad / this.datos.size()));
			this.getJListDetalles().setListData(lista.toArray());
		}
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(962, 728);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();//crearLinealLibro();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 204));
			jContentPane.add(getJScrollPaneContein(), null);
			jContentPane.add(getJScrollPaneDetalles(), null);
			jContentPane.add(getJButtonSalir(), null);
			jContentPane.add(getJButtonMasDatos(), null);
			jContentPane.add(getJButtonDetalles(), null);
		}
		return jContentPane;
	}

	private JPanel crearLinealLibro() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		if(this.tipo.equalsIgnoreCase("Meses")){
			this.datos = Fachada.getInstancia().consultaComplicacionesPorMes(this.desde,this.hasta);
		}
		if(this.tipo.equalsIgnoreCase("Dias")){
			this.datos = Fachada.getInstancia().consultaComplicacionesPorDias(this.desde, this.hasta);
		}
		if(this.tipo.equalsIgnoreCase("Años")){
			this.datos = Fachada.getInstancia().consultaComplicacionesPorYear(this.desde, this.hasta);
		}
		for(int x=0;x<datos.size();x++){
			dataset.addValue(datos.get(x), "Complicaciones", "" + (x+1));
		}
		/*dataset.addValue(212, "Classes", "JDK 1.0");
		dataset.addValue(504, "Classes", "JDK 1.1");
		dataset.addValue(1520, "Classes", "SDK 1.2");
		dataset.addValue(1842, "Classes", "SDK 1.3");
		dataset.addValue(2991, "Classes", "SDK 1.4");*/
		ChartPanel panel = new ChartPanel(createLineChart(dataset));
		
		panel.setBounds(new Rectangle(64, 390, 29, 34));
		return panel;
	}
	
	/**
	 * Creates a sample chart.
	 * 
	 * @param dataset
	 *            a dataset.
	 * 
	 * @return The chart.
	 */
	private static JFreeChart createLineChart(CategoryDataset dataset) {
		// create the chart...
		JFreeChart chart = ChartFactory.createLineChart(
				"Cantidad de complicaciones por periodo", // chart title
				"Periodo", // domain axis label
				"Cantidad", // range axis label
				dataset, // data
				PlotOrientation.VERTICAL, // orientation
				false, // include legend
				true, // tooltips
				false // urls
				);
		chart.addSubtitle(new TextTitle("Complicaciones infecciosas y no infecciosas"));
		TextTitle source = new TextTitle(
				"Complicaciones por periodo de tiempo");
		source.setFont(new Font("SansSerif", Font.PLAIN, 10));
		source.setPosition(RectangleEdge.BOTTOM);
		source.setHorizontalAlignment(HorizontalAlignment.RIGHT);
		chart.addSubtitle(source);
		chart.setBackgroundPaint(Color.white);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setRangeGridlinePaint(Color.white);
		// customise the range axis...
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		// customise the renderer...
		LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot
				.getRenderer();
		renderer.setDrawOutlines(true);
		renderer.setUseFillPaint(true);
		renderer.setBaseFillPaint(Color.white);
		return chart;
	}

	/**
	 * This method initializes jScrollPaneContein	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneContein() {
		if (jScrollPaneContein == null) {
			jScrollPaneContein = new JScrollPane();
			jScrollPaneContein.setBounds(new Rectangle(10, 43, 922, 430));
			jScrollPaneContein.setViewportView(getJPanelGrafica());
		}
		return jScrollPaneContein;
	}

	/**
	 * This method initializes jPanelGrafica	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelGrafica() {
		if (jPanelGrafica == null) {
			jPanelGrafica = this.crearLinealLibro();
			jPanelGrafica.setLayout(new GridBagLayout());
		}
		return jPanelGrafica;
	}

	/**
	 * This method initializes jScrollPaneDetalles	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneDetalles() {
		if (jScrollPaneDetalles == null) {
			jScrollPaneDetalles = new JScrollPane();
			jScrollPaneDetalles.setBounds(new Rectangle(10, 483, 922, 131));
			jScrollPaneDetalles.setFont(new Font("Dialog", Font.BOLD, 14));
			jScrollPaneDetalles.setViewportView(getJListDetalles());
		}
		return jScrollPaneDetalles;
	}

	/**
	 * This method initializes jListDetalles	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJListDetalles() {
		if (jListDetalles == null) {
			jListDetalles = new JList();
		}
		return jListDetalles;
	}

	/**
	 * This method initializes jButtonSalir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSalir() {
		if (jButtonSalir == null) {
			jButtonSalir = new JButton();
			jButtonSalir.setBounds(new Rectangle(14, 644, 170, 40));
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
	 * This method initializes jButtonMasDatos	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonMasDatos() {
		if (jButtonMasDatos == null) {
			jButtonMasDatos = new JButton();
			jButtonMasDatos.setBounds(new Rectangle(324, 644, 269, 39));
			jButtonMasDatos.setText("Cantidad de infecciones por paciente");
			jButtonMasDatos.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					masDatos();
				}
			});
		}
		return jButtonMasDatos;
	}
	
	private void salir(){
		this.dispose();
	}
	
	private void masDatos(){
		int tipoNum = 1;
		if(this.tipo.equalsIgnoreCase("Meses")){
			tipoNum = 1;
		}
		if(this.tipo.equalsIgnoreCase("Dias")){
			tipoNum = 2;
		}
		if(this.tipo.equalsIgnoreCase("Años")){
			tipoNum = 3;
		}
		IUConsultaGenericaComplicaciones iu = new IUConsultaGenericaComplicaciones(this.desde, this.hasta, tipoNum);
		iu.setVisible(true);
	}

	/**
	 * This method initializes jButtonDetalles	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonDetalles() {
		if (jButtonDetalles == null) {
			jButtonDetalles = new JButton();
			jButtonDetalles.setBounds(new Rectangle(683, 644, 198, 40));
			jButtonDetalles.setText("Detalles de las infecciones");
			jButtonDetalles.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					detalles();
				}
			});
		}
		return jButtonDetalles;
	}
	
	private void detalles(){
		int tipoNum = 1;
		if(this.tipo.equalsIgnoreCase("Meses")){
			tipoNum = 1;
		}
		if(this.tipo.equalsIgnoreCase("Dias")){
			tipoNum = 2;
		}
		if(this.tipo.equalsIgnoreCase("Años")){
			tipoNum = 3;
		}
		IUConsultaComplicacionesPorTiempoSeparadas iuDetalles = new IUConsultaComplicacionesPorTiempoSeparadas(this.desde, this.hasta, tipoNum);
		iuDetalles.setVisible(true);
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
