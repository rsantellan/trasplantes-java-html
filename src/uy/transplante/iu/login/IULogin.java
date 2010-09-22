package uy.transplante.iu.login;


import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import uy.transplante.iu.basico.IUPrincipal;
import uy.transplante.logica.Fachada;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class IULogin extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton jButtonOK = null;
	private JPasswordField jPasswordFieldPass = null;

	/**
	 * This is the default constructor
	 */
	public IULogin() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 175);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Ingrese su contraseña");
		
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
			jContentPane.setBackground(new Color(255, 255, 153));
			jContentPane.add(getJButtonOK(), null);
			jContentPane.add(getJPasswordFieldPass(), null);
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
			jButtonOK.setBounds(new Rectangle(59, 78, 156, 49));
			jButtonOK.setText("INGRESAR");
			jButtonOK.setMnemonic(KeyEvent.VK_ENTER);
			jButtonOK.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					login();
				}
			});
		}
		return jButtonOK;
	}

	 public void actionPerformed(ActionEvent e) {
	       login();
	    }

	private int intentos = 0;

	private void login() {
		int num = Fachada.getInstancia().verificarIngreso(
				this.getJPasswordFieldPass().getPassword());
		if (num > 0) {
			if (num == 1) {
				IUPrincipal iu = new IUPrincipal();
				iu.setVisible(true);
				this.dispose();
			} else {
				JOptionPane
						.showMessageDialog(
								this,
								"La contraseña ha caducado, por favor ingrese una nueva",
								"Advertencia", 2);
				IULoginCambiar cambio = new IULoginCambiar();
				cambio.setVisible(true);
				/*this.getJPasswordFieldPass().setFocusable(true);
				this.getJPasswordFieldPass().requestFocus();*/
			}
		} else {
			intentos = intentos + 1;
			JOptionPane.showMessageDialog(this,
					"Ha ingresado mal la contraseña, le quedan"
							+ (3 - intentos) + " intentos.", "ERROR", 3);
			this.getJPasswordFieldPass().setText("");
		}
		if (intentos == 3) {
			this.dispose();
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
			jPasswordFieldPass.setBounds(new Rectangle(29, 16, 223, 41));
			jPasswordFieldPass.addActionListener(this);
		}
		return jPasswordFieldPass;
	}

} // @jve:decl-index=0:visual-constraint="10,10"
