package iUConsultas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;

import javax.swing.JInternalFrame;
import javax.swing.WindowConstants;
import java.awt.Rectangle;
import java.util.ArrayList;

import logica.Fachada;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;

public class IUConsultaGrafica extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JInternalFrame jInternalFrame = null;
	private JPanel jContentPane1 = null;

	private JInternalFrame jInternalFrame1 = null;
	private JPanel jContentPane2 = null;

	private JInternalFrame jInternalFrame3 = null;
	private JPanel jContentPane3 = null;
	
	private JInternalFrame jInternalFrame4 = null;
	private JPanel jContentPane4 = null;
	private JScrollPane jScrollPaneDatos = null;
	private JPanel jPanel5 = null;

	/**
	 * This is the default constructor
	 */
	public IUConsultaGrafica() {
		super();
		initialize();
		this.getJInternalFrame().setVisible(true);
		this.getJInternalFrame1().setVisible(true);
		this.getJInternalFrame3().setVisible(true);
		this.getJInternalFrame4().setVisible(true);
		// this.jContentPane1 = crearTarta();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(1000, 557);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Pruebas");
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
			jContentPane.add(getJInternalFrame(), null);
			jContentPane.add(getJInternalFrame1(), null);
			jContentPane.add(getJInternalFrame3(), null);
			jContentPane.add(getJScrollPaneDatos(), null);
			jContentPane.add(getJInternalFrame4(), null);
		}
		return jContentPane;
	}

	private JPanel crearTarta() {
		DefaultPieDataset data = new DefaultPieDataset();
		data.setValue("Si " + 30 + "%", 30);
		data.setValue("No " + 30 + "%", 30);
		data.setValue("Tal vez " + 30 + "%", 30);
		data.setValue("No contesta " + 10 + "%", 10);
		JFreeChart chart = ChartFactory.createPieChart("Muestra", data, true,
				true, false);
		ChartPanel panel = new ChartPanel(chart);
		return panel;
	}

	/**
	 * This method initializes jInternalFrame
	 * 
	 * @return javax.swing.JInternalFrame
	 */
	private JInternalFrame getJInternalFrame() {
		if (jInternalFrame == null) {
			jInternalFrame = new JInternalFrame();
			jInternalFrame.setBounds(new Rectangle(35, 17, 421, 258));
			jInternalFrame.setTitle("Prueba");
			jInternalFrame.setContentPane(getJContentPane1());
		}
		return jInternalFrame;
	}

	/**
	 * This method initializes jContentPane1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane1() {
		if (jContentPane1 == null) {
			jContentPane1 = crearTarta();
			jContentPane1.setLayout(new BorderLayout());
		}
		return jContentPane1;
	}

	private JPanel crearBarras() {
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		data.addValue(1.0, "1", "Columna 1");
		data.addValue(2.0, "1", "Columna 2");
		data.addValue(3.0, "1", "Columna 3");
		data.addValue(4.0, "1", "Columna 4");
		data.addValue(4.0, "2", "Columna 1");
		data.addValue(3.0, "2", "Columna 2");
		data.addValue(2.0, "2", "Columna 3");
		data.addValue(1.0, "2", "Columna 4");
		JFreeChart chart = ChartFactory.createBarChart("Bar char", "Categoria",
				"Valor", data, PlotOrientation.VERTICAL, true, true, false);
		ChartPanel panel = new ChartPanel(chart, false);
		return panel;
	}

	/**
	 * This method initializes jInternalFrame1
	 * 
	 * @return javax.swing.JInternalFrame1
	 */
	private JInternalFrame getJInternalFrame1() {
		if (jInternalFrame1 == null) {
			jInternalFrame1 = new JInternalFrame();
			jInternalFrame1.setBounds(new Rectangle(5, 60, 421, 258));
			jInternalFrame1.setTitle("Prueba");
			jInternalFrame1.setContentPane(getJContentPane2());
		}
		return jInternalFrame1;
	}

	/**
	 * This method initializes jContentPane2
	 * 
	 * @return javax.swing.JPane2
	 */
	private JPanel getJContentPane2() {
		if (jContentPane2 == null) {
			jContentPane2 = crearBarras();
			jContentPane2.setLayout(new BorderLayout());
		}
		return jContentPane2;
	}

/*	private JPanel crearLineal() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(212, "Classes", "JDK 1.0");
		dataset.addValue(504, "Classes", "JDK 1.1");
		dataset.addValue(1520, "Classes", "SDK 1.2");
		dataset.addValue(1842, "Classes", "SDK 1.3");
		dataset.addValue(2991, "Classes", "SDK 1.4");
		JFreeChart chart = ChartFactory.createLineChart(
				"Java Standard Class Library", "Release", "Cantidad de clases",
				dataset, PlotOrientation.VERTICAL, true, true, true);

		ChartPanel panel = new ChartPanel(chart);
		return panel;
	}*/

	private JPanel crearLinealLibro() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		ArrayList<Integer> datos = Fachada.getInstancia().consultaComplicacionesPorMes(0,6);
		for(int x=0;x<datos.size();x++){
			dataset.addValue(datos.get(x), "Complicaciones", "" + (x+1));
		}
		ChartPanel panel = new ChartPanel(createLineChart(dataset));
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
				"Java Standard Class Library", // chart title
				"Release", // domain axis label
				"Class Count", // range axis label
				dataset, // data
				PlotOrientation.VERTICAL, // orientation
				false, // include legend
				true, // tooltips
				false // urls
				);
		chart.addSubtitle(new TextTitle("Number of Classes By Release"));
		TextTitle source = new TextTitle(
				"Source: Java In A Nutshell (4th Edition) "
						+ "by David Flanagan (O’Reilly)");
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
	 * This method initializes jInternalFrame3
	 * 
	 * @return javax.swing.JInternalFrame3
	 */
	private JInternalFrame getJInternalFrame3() {
		if (jInternalFrame3 == null) {
			jInternalFrame3 = new JInternalFrame();
			jInternalFrame3.setBounds(new Rectangle(5, 60, 850, 450));
			jInternalFrame3.setTitle("Prueba Lineal");
			jInternalFrame3.setContentPane(getJContentPane3());
		}
		return jInternalFrame3;
	}

	/**
	 * This method initializes jContentPane3
	 * 
	 * @return javax.swing.JPane3
	 */
	private JPanel getJContentPane3() {
		if (jContentPane3 == null) {
			jContentPane3 = crearLinealLibro();
			jContentPane3.setLayout(new BorderLayout());
		}
		return jContentPane3;
	}

	private JPanel crearLinealTemporal() {
		TimeSeries s1 = new TimeSeries("Emfermedades", Year.class);
		s1.add(new Year(2000), 1);
		s1.add(new Year(2001), 9);
		s1.add(new Year(2002), 19);
		s1.add(new Year(2003), 5);
		s1.add(new Year(2004), 2);
		s1.add(new Year(2005), 10);
		s1.add(new Year(2006), 1);

		TimeSeriesCollection data = new TimeSeriesCollection();
		data.addSeries(s1);

		JFreeChart chart = ChartFactory.createTimeSeriesChart(
				"Cantidad de emfermedades", "Tiempo", "Cantidad", data, true,
				true, true);
		chart.setBackgroundPaint(Color.GREEN);
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.CYAN);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);
		plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);
		XYItemRenderer r = plot.getRenderer();
		if (r instanceof XYLineAndShapeRenderer) {
			XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
			renderer.setBaseShapesVisible(true);
			renderer.setBaseShapesFilled(true);
		}
		
		ChartPanel panel = new ChartPanel(chart);
		return panel;
	}
	
	/**
	 * This method initializes jInternalFrame4
	 * 
	 * @return javax.swing.JInternalFrame4
	 */
	private JInternalFrame getJInternalFrame4() {
		if (jInternalFrame4 == null) {
			jInternalFrame4 = new JInternalFrame();
			jInternalFrame4.setBounds(new Rectangle(10, 60, 850, 450));
			jInternalFrame4.setTitle("Prueba Lineal");
			jInternalFrame4.setContentPane(getJContentPane4());
		}
		return jInternalFrame4;
	}

	/**
	 * This method initializes jContentPane4
	 * 
	 * @return javax.swing.JPane4
	 */
	private JPanel getJContentPane4() {
		if (jContentPane4 == null) {
			jContentPane4 = crearLinealTemporal();
			jContentPane4.setLayout(new BorderLayout());
		}
		return jContentPane4;
	}

	/**
	 * This method initializes jScrollPaneDatos	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneDatos() {
		if (jScrollPaneDatos == null) {
			jScrollPaneDatos = new JScrollPane();
			jScrollPaneDatos.setBounds(new Rectangle(5, 5, 963, 338));
			jScrollPaneDatos.setViewportView(getJPanel5());
		}
		return jScrollPaneDatos;
	}

	/**
	 * This method initializes jPanel5	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel5() {
		if (jPanel5 == null) {
			jPanel5 = crearLinealLibro();
			jPanel5.setLayout(new GridBagLayout());
		}
		return jPanel5;
	}
} // @jve:decl-index=0:visual-constraint="10,10"
