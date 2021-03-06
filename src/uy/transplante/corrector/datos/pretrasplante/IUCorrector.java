package uy.transplante.corrector.datos.pretrasplante;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class IUCorrector extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;

	/**
	 * This is the default constructor
	 */
	public IUCorrector() {
		super();
		initialize();
		CorrectorDatosPreTrasplante aux = new CorrectorDatosPreTrasplante();
		aux.toString();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
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
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
		}
		return jContentPane;
	}

}
