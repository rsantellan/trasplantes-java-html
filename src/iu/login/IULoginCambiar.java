package iu.login;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import java.awt.Color;
import javax.swing.JCheckBox;

import logica.Fachada;

public class IULoginCambiar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton jButtonOK = null;
	private JPasswordField jPasswordFieldPass = null;
	private JButton jButtonAtras = null;
	private JLabel jLabelRootPass = null;
	private JLabel jLabelPassNueva = null;
	private JPasswordField jPasswordFieldPassNuevo = null;
	private JLabel jLabelPassRep = null;
	private JPasswordField jPasswordFieldPassReint = null;
	private JCheckBox jCheckBoxPassPrimario = null;
	/**
	 * This is the default constructor
	 */
	public IULoginCambiar() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(463, 271);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Cambie su contrase�a");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelPassRep = new JLabel();
			jLabelPassRep.setBounds(new Rectangle(9, 122, 190, 31));
			jLabelPassRep.setText("Reingrese la nueva contrase�a :");
			jLabelPassNueva = new JLabel();
			jLabelPassNueva.setBounds(new Rectangle(9, 82, 190, 32));
			jLabelPassNueva.setText("Ingrese la nueva contrase�a :");
			jLabelRootPass = new JLabel();
			jLabelRootPass.setBounds(new Rectangle(9, 38, 190, 32));
			jLabelRootPass.setText("Ingrese la contrase�a primaria :");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(255, 255, 151));
			jContentPane.add(getJButtonOK(), null);
			jContentPane.add(getJPasswordFieldPass(), null);
			jContentPane.add(getJButtonAtras(), null);
			jContentPane.add(jLabelRootPass, null);
			jContentPane.add(jLabelPassNueva, null);
			jContentPane.add(getJPasswordFieldPassNuevo(), null);
			jContentPane.add(jLabelPassRep, null);
			jContentPane.add(getJPasswordFieldPassReint(), null);
			jContentPane.add(getJCheckBoxPassPrimario(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButtonOK	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonOK() {
		if (jButtonOK == null) {
			jButtonOK = new JButton();
			jButtonOK.setBounds(new Rectangle(276, 187, 134, 35));
			jButtonOK.setText("Cambiar");
			jButtonOK.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					login();
				}
			});
		}
		return jButtonOK;
	}

	private void login(){
		boolean ok = Fachada.getInstancia().cambiarPassword(this.getJPasswordFieldPass().getPassword(), this.getJPasswordFieldPassNuevo().getPassword(), this.getJPasswordFieldPassReint().getPassword(), this.jCheckBoxPassPrimario.isSelected());
		if(ok){
			JOptionPane.showMessageDialog(this,
					"La contrase�a a sido modificada exitosamente",
					"OK", 1);
			this.salir();
		}else{
			JOptionPane.showMessageDialog(this,
					"Ha ingresado mal las contrase�as, verifique que las ingreso correctamente.",
					"ERROR", 3);
		}
	}

	/**
	 * This method initializes jPasswordFieldPass	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getJPasswordFieldPass() {
		if (jPasswordFieldPass == null) {
			jPasswordFieldPass = new JPasswordField();
			jPasswordFieldPass.setBounds(new Rectangle(216, 42, 201, 28));
		}
		return jPasswordFieldPass;
	}

	/**
	 * This method initializes jButtonAtras	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAtras() {
		if (jButtonAtras == null) {
			jButtonAtras = new JButton();
			jButtonAtras.setBounds(new Rectangle(24, 186, 134, 35));
			jButtonAtras.setText("Atras");
			jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					salir();
				}
			});
		}
		return jButtonAtras;
	}

	private void salir(){
		this.dispose();
	}

	/**
	 * This method initializes jPasswordFieldPassNuevo	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getJPasswordFieldPassNuevo() {
		if (jPasswordFieldPassNuevo == null) {
			jPasswordFieldPassNuevo = new JPasswordField();
			jPasswordFieldPassNuevo.setBounds(new Rectangle(216, 82, 201, 28));
		}
		return jPasswordFieldPassNuevo;
	}

	/**
	 * This method initializes jPasswordFieldPassReint	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getJPasswordFieldPassReint() {
		if (jPasswordFieldPassReint == null) {
			jPasswordFieldPassReint = new JPasswordField();
			jPasswordFieldPassReint.setBounds(new Rectangle(216, 122, 201, 28));
		}
		return jPasswordFieldPassReint;
	}

	/**
	 * This method initializes jCheckBoxPassPrimario	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxPassPrimario() {
		if (jCheckBoxPassPrimario == null) {
			jCheckBoxPassPrimario = new JCheckBox();
			jCheckBoxPassPrimario.setBounds(new Rectangle(36, 7, 234, 27));
			jCheckBoxPassPrimario.setText("Cambio Contrase�a primaria");
			jCheckBoxPassPrimario.setBackground(new Color(255, 255, 151));
		}
		return jCheckBoxPassPrimario;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
