package uy.transplante.iu.consultas;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.util.ArrayList;

public class IUConsultaGraficaPastel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	ArrayList<Object> datos = null;
	/**
	 * This is the default constructor
	 */
	public IUConsultaGraficaPastel(ArrayList<Object> datos) {
		super();
		this.datos = datos;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(966, 491);
		this.setContentPane(getJContentPane());
		this.setTitle("Pastel");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = crearTarta();
			jContentPane.setLayout(new BorderLayout());
		}
		return jContentPane;
	}

	private JPanel crearTarta() {
		ArrayList<Integer> ayuda = new ArrayList<Integer>();
		ArrayList<Object> aux = new ArrayList<Object>();
		for(int x=0;x<this.datos.size();x++){
			if(!aux.contains(this.datos.get(x))){
				aux.add(this.datos.get(x));
				ayuda.add(1);
			}else{
				
				Integer i = ayuda.get(aux.indexOf(this.datos.get(x)));
				i = i + 1;
				ayuda.set(aux.indexOf(this.datos.get(x)), i);
			}
		}
		DefaultPieDataset data = new DefaultPieDataset();
		for(int x=0;x<aux.size();x++){
			data.setValue(aux.get(x).toString() + " Cantidad: " +(Integer) ayuda.get(x) , (Integer) ayuda.get(x));
		}
		/*data.setValue("Si " + 30 + "%", 30);
		data.setValue("No " + 30 + "%", 30);
		data.setValue("Tal vez " + 30 + "%", 30);
		data.setValue("No contesta " + 10 + "%", 10);*/
		JFreeChart chart = ChartFactory.createPieChart("Pastel", data, true,
				true, false);
		ChartPanel panel = new ChartPanel(chart);
		return panel;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
