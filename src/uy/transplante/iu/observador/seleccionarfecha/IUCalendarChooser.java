package uy.transplante.iu.observador.seleccionarfecha;

import javax.swing.JPanel;
import javax.swing.JFrame;
import com.toedter.calendar.JCalendar;
import java.awt.Rectangle;
import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.WindowConstants;

public class IUCalendarChooser extends JFrame implements ObservadoCalendario{

	private static final long serialVersionUID = 1L;
	private transient JPanel jContentPane = null;
	private transient JCalendar jCalendarFecha = null;
	private transient JButton jButtonUsar = null;

	/**
	 * This is the default constructor
	 */
	public IUCalendarChooser(final ObservadorCalendario obs) {
		super();
		initialize();
		this.agregarObsevador(obs);
		this.jCalendarFecha.setCalendar(new GregorianCalendar());
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(608, 338);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(this.getJContentPane());
		this.setTitle("Seleccione la fecha");
		this.setResizable(false);
		
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
			jContentPane.setBackground(Color.white);
			jContentPane.add(getJCalendarFecha(), null);
			jContentPane.add(getJButtonUsar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jCalendarFecha	
	 * 	
	 * @return com.toedter.calendar.JCalendar	
	 */
	private JCalendar getJCalendarFecha() {
		if (jCalendarFecha == null) {
			jCalendarFecha = new JCalendar();
			jCalendarFecha.setBounds(new Rectangle(41, 9, 481, 233));
			jCalendarFecha.setBackground(Color.white);
		}
		return jCalendarFecha;
	}

	/**
	 * This method initializes jButtonUsar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonUsar() {
		if (jButtonUsar == null) {
			jButtonUsar = new JButton();
			jButtonUsar.setBounds(new Rectangle(195, 251, 184, 44));
			jButtonUsar.setBackground(new Color(204, 255, 204));
			jButtonUsar.setText("Usar");
			jButtonUsar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(final java.awt.event.ActionEvent event) {
					notificarCambios();
				}
			});
		}
		return jButtonUsar;
	}

	public Calendar obtenerFecha(){
		return this.jCalendarFecha.getCalendar();
	}

	public void terminar(){
		this.dispose();
	}
	private transient ObservadorCalendario observer;
	
	public void agregarObsevador(final ObservadorCalendario observer) {
		this.observer = observer;
	}

	public void notificarCambios() {
		this.observer.actualizar();
	}
	
	
}  //  @jve:decl-index=0:visual-constraint="10,10"


