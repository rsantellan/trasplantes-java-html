/**
 * 
 */
package uy.transplante.iu.windows.auxiliaries;

import java.awt.Component;

import javax.swing.JOptionPane;

/**
 * @author rodrigo
 *
 */
public class IUAuxiliarPaneles {

	public static int warning = JOptionPane.WARNING_MESSAGE;
	public static int error = JOptionPane.ERROR_MESSAGE;
	public static int plain = JOptionPane.PLAIN_MESSAGE;
	public static int information = JOptionPane.INFORMATION_MESSAGE;
	public static int question = JOptionPane.QUESTION_MESSAGE;
	
	public static boolean jOptionPane(Component componente, String texto, String title){
		int n = JOptionPane.showConfirmDialog(
				componente,
			    texto,
			    title,
			    JOptionPane.YES_NO_OPTION);
		if(n == JOptionPane.YES_OPTION){
			return true;
		}
		return false;
	}
	
	public static String jOptionPaneDialog(Component componente, String texto, String title, int opcion){
		String nueva = "";
		nueva = JOptionPane
				.showInputDialog(
						componente,
						texto,
						title,
						opcion);
		return nueva;
	}
	
	public static void jOptionMessageDialog(Component componente, String texto, String title, int opcion){
		JOptionPane.showMessageDialog(componente,texto , title, opcion);
	}
}
