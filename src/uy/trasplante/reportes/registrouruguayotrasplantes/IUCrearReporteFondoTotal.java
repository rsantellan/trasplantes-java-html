package uy.trasplante.reportes.registrouruguayotrasplantes;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.Cursor;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.WindowConstants;
import javax.swing.JProgressBar;

public class IUCrearReporteFondoTotal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton jButtonCrearReporte = null;
	private JTextField jTextFieldReporte = null;
	private JProgressBar jProgressBarProgress = null;

	/**
	 * This is the default constructor
	 */
	public IUCrearReporteFondoTotal() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(427, 238);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Crear Reporte total.");
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
			jContentPane.setBackground(new Color(153, 153, 255));
			jContentPane.add(getJButtonCrearReporte(), null);
			jContentPane.add(getJTextFieldReporte(), null);
			jContentPane.add(getJProgressBarProgress(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButtonCrearReporte	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCrearReporte() {
		if (jButtonCrearReporte == null) {
			jButtonCrearReporte = new JButton();
			jButtonCrearReporte.setBounds(new Rectangle(118, 35, 147, 47));
			jButtonCrearReporte.setBackground(new Color(255, 255, 204));
			jButtonCrearReporte.setText("Crear");
			jButtonCrearReporte.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					crear();
				}
			});
		}
		return jButtonCrearReporte;
	}

	/**
	 * This method initializes jTextFieldReporte	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldReporte() {
		if (jTextFieldReporte == null) {
			jTextFieldReporte = new JTextField();
			jTextFieldReporte.setBounds(new Rectangle(7, 106, 389, 45));
		}
		return jTextFieldReporte;
	}

	private void crear(){
		CrearReporteFondo reporte = new CrearReporteFondo();
		Verificador ver = new Verificador(reporte);
		Thread t = new Thread(ver);
		this.getJProgressBarProgress().setIndeterminate(true);
		t.start();
		Thread eje = new Thread(new Ejecutor(reporte));
		eje.start();
		this.setCursor(Cursor
				.getPredefinedCursor(Cursor.WAIT_CURSOR));
		setCursor(null); // turn off the wait cursor
	}
	
	public void cambiarEstado(String texto){
		this.getJTextFieldReporte().setText(texto);
	}
	
	public void termine(){
		this.getJProgressBarProgress().setIndeterminate(false);
	}
	
	private class Ejecutor implements Runnable{

		CrearReporteFondo c;
		public Ejecutor(CrearReporteFondo c){
			this.c = c;
		}
		

		public void run() {
			c.crear();
			cambiarEstado(c.getExportar());
			termine();
		}
		
	}
	private class Verificador implements Runnable{

		CrearReporteFondo c;
		public Verificador(CrearReporteFondo c){
			this.c = c;
		}

		public void run() {
			int lugar = c.getLugar();
			while(lugar != -2){
				lugar = c.getLugar();
				if(lugar == 0){
					cambiarEstado("Empezando la creacion del documento");
				}else{
					if(lugar == -2){
						cambiarEstado("Finalizada la creacion del Documento");
					}else{
						cambiarEstado("Analizando al transplante numero :" + lugar);
					}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					lugar = -2;
				}
			}
			
		}
		
	}
	/**
	 * This method initializes jProgressBarProgress	
	 * 	
	 * @return javax.swing.JProgressBar	
	 */
	private JProgressBar getJProgressBarProgress() {
		if (jProgressBarProgress == null) {
			jProgressBarProgress = new JProgressBar();
			jProgressBarProgress.setBounds(new Rectangle(7, 159, 387, 34));
		}
		return jProgressBarProgress;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
