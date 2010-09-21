package uy.trasplante.reportes.registrouruguayotrasplantes;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.WindowConstants;
import javax.swing.JProgressBar;

public class IUCrearReporteFondoPerYear extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextField jTextFieldYear = null;
	private JButton jButtonCrearReporte = null;
	private JTextField jTextFieldReporte = null;
	private JProgressBar jProgressBarProgress = null;

	/**
	 * This is the default constructor
	 */
	public IUCrearReporteFondoPerYear() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(427, 306);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Ingrese el año del reporte.");
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
			jContentPane.add(getJTextFieldYear(), null);
			jContentPane.add(getJButtonCrearReporte(), null);
			jContentPane.add(getJTextFieldReporte(), null);
			jContentPane.add(getJProgressBarProgress(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextFieldYear	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldYear() {
		if (jTextFieldYear == null) {
			jTextFieldYear = new JTextField();
			jTextFieldYear.setBounds(new Rectangle(89, 35, 210, 42));
		}
		return jTextFieldYear;
	}

	/**
	 * This method initializes jButtonCrearReporte	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCrearReporte() {
		if (jButtonCrearReporte == null) {
			jButtonCrearReporte = new JButton();
			jButtonCrearReporte.setBounds(new Rectangle(121, 98, 147, 47));
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
			jTextFieldReporte.setBounds(new Rectangle(9, 162, 389, 45));
		}
		return jTextFieldReporte;
	}

	private void crear(){
		CrearReporteFondo reporte = new CrearReporteFondo();
		boolean todoOK = true;
		int i = 0;
		try{
			i = Integer.valueOf(this.getJTextFieldYear().getText());
		}catch(Exception e){
			todoOK = false;
			JOptionPane.showMessageDialog(this,"Tiene que ingresar un numero" , "Error", JOptionPane.ERROR_MESSAGE);
		}
		if(i<=0){
			todoOK = false;
			JOptionPane.showMessageDialog(this,"Tiene que ingresar un numero positivo" , "Error", JOptionPane.ERROR_MESSAGE);
		}
		if(todoOK){
			Thread hiloEjecutor = new Thread(new Ejecutor(reporte, i));
			Thread hiloVerificador = new Thread(new Verificador(reporte));
			this.getJProgressBarProgress().setIndeterminate(true);
			hiloVerificador.start();
			hiloEjecutor.start();
		}
		
	}
	
	public void cambiarEstado(String texto){
		this.getJTextFieldReporte().setText(texto);
	}
	
	public void termine(){
		this.getJProgressBarProgress().setIndeterminate(false);
	}
	
	private class Ejecutor implements Runnable{

		CrearReporteFondo c;
		private int year = 0;
		public Ejecutor(CrearReporteFondo c, int num){
			this.c = c;
			this.year = num;
		}
		
		public void run() {
			c.crear(this.year);
			cambiarEstado(c.getExportar());
			termine();
		}
		
	}
	private class Verificador implements Runnable{

		private CrearReporteFondo c;
		
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
					cambiarEstado("Analizando al transplante numero :" + lugar);
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
			jProgressBarProgress.setBounds(new Rectangle(11, 222, 385, 35));
		}
		return jProgressBarProgress;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
