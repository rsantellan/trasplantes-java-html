/**
 * 
 */
package testeo.uy.dynamic.windows.creator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import testeo.uy.dynamic.windows.creator.DatosParaVentanas;
import testeo.uy.dynamic.windows.creator.input.types.IInputDataType;
import testeo.uy.dynamic.windows.creator.input.types.MiCheckBox;

/**
 * @author Rodrigo Santellan
 *
 */
public class DynamicCreation {

	private List<String> nombresIconos = new ArrayList<String>();
	
	private int y = 0;
	
	/**
	 * @return the y
	 */
	private int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	private void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the nombresIconos
	 */
	public List<String> getNombresIconos() {
		return nombresIconos;
	}

	/**
	 * This method returns a JInternalFrame
	 * 	
	 * @return javax.swing.JInternalFrame	
	 */
	public JInternalFrame getJInternalFrame(String name, Rectangle bounds, List<JComponent> componentList) {
		JInternalFrame frame = new JInternalFrame();
		frame.setBounds(bounds);
		frame.setTitle(name);
		frame.setVisible(false);
		frame.setClosable(false);
		frame.setMaximizable(true);
		frame.setIconifiable(true);
		JPanel panel = new JPanel();
		
		panel.setLayout(null);
		for(JComponent aux : componentList){
			if(aux.getClass().getName().contains("MiCheckBox")){
				MiCheckBox check = (MiCheckBox) aux;
				check.setContenedor(panel);
				panel.add(check);
			}else{
				panel.add(aux);
			}
			
		}
		panel.setAutoscrolls(true);
		panel.setSize(400,this.getY());
		panel.setPreferredSize(new Dimension(418, this.getY()));
		panel.setMaximumSize(new Dimension(418, this.getY()));
		JPanel p = new JPanel();
		p.setPreferredSize(new Dimension(418, this.getY()));
		p.setVisible(true);
		p.setSize(500, this.getY());
		p.setLayout(new BorderLayout());
		p.add(panel, BorderLayout.CENTER);
		JScrollPane scroll = new JScrollPane(p);
		scroll.setVisible(true);
		scroll.setSize(400,800);
		frame.add(scroll);
		frame.setResizable(true);
		this.getNombresIconos().add(frame.getTitle());
		return frame;
	}
	
	/**
	 * This method return a JCheckBox
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	public JCheckBox getJCheckBox(String text, Rectangle bounds) {
		
		MiCheckBox miCheck = new MiCheckBox();
		miCheck.setBounds(bounds);
		miCheck.setText(text);
		miCheck.setVisible(true);
		
		return miCheck;
	}
	
	public List<MiCheckBox> crearAPartirDeLista(DatosParaVentanas[] datos, int sX, int sY, int fX, int fY){
		List<MiCheckBox> salida = new ArrayList<MiCheckBox>();
		int y = 0;
		for(int x=0;x<datos.length;x++){
			MiCheckBox aux = new MiCheckBox();
			aux.setBounds(new Rectangle(sX, sY + y, fX, fY));
			aux.setText(datos[x].toString());
			aux.setVisible(true);
			salida.add(aux);
			y += 50;
		}
		return salida;
	}
	
	public List<MiCheckBox> crearAPartirDeLista(IInputDataType[] datos, int sX, int sY, int fX, int fY){
		List<MiCheckBox> salida = new ArrayList<MiCheckBox>();
		int y = 0;
		for(IInputDataType dato : datos){
			MiCheckBox aux = new MiCheckBox();
			aux.setBounds(new Rectangle(sX, sY + y, fX, fY));
			aux.setDato(dato);
			aux.setVisible(true);
			aux.setText(dato.datosString());
			salida.add(aux);
			y += 50;
		}
		return salida;
	}
	
	public List<MiCheckBox> crearAPartirDeLista(List<IInputDataType> datos, int sX, int sY, int fX, int fY){
		List<MiCheckBox> salida = new ArrayList<MiCheckBox>();
		this.setY(0);
		for(IInputDataType dato : datos){
			MiCheckBox aux = new MiCheckBox();
			aux.setBounds(new Rectangle(sX, sY + this.getY(), fX, fY));
			aux.setDato(dato);
			aux.setVisible(true);
			aux.setText(dato.datosString());
			salida.add(aux);
			this.setY(this.getY() + 50) ;
		}
		return salida;
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJContentPane() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		int y = 0;
		for(int x=0;x<4;x++){
			JCheckBox check = this.getJCheckBox("Test " + x, new Rectangle(10, 10 + y, 154, 30));
			y += 50;
			panel.add(check,null);
		}
		return panel;
	}
	
	
	public List<JMenuItem> listaItems(){
		List<JMenuItem> salida = new ArrayList<JMenuItem>();
		for(String texto : this.getNombresIconos()){
			salida.add(this.getJMenuItem(texto));
		}
		
		return salida;
	}
	/**
	 * This method initializes jMenuItemCrear	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem(String texto) {
		JCheckBoxMenuItem menu = new JCheckBoxMenuItem();
		//JMenuItem menu = new JMenuItem();
		menu.setText(texto);
		return menu;
	}
}
