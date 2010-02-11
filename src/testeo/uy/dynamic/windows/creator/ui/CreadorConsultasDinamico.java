package testeo.uy.dynamic.windows.creator.ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JFrame;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import testeo.clases.base.ElementoBase;
import testeo.clases.base.TablaBase;
import testeo.clases.implementacion.TablaNefropatia;
import testeo.clases.implementacion.TablaPacienteMuerte;
import testeo.clases.implementacion.TablaPacienteMuerteCausa;
import testeo.clases.implementacion.TablaPacientePreTrasplante;
import testeo.clases.implementacion.TablaPacientes;
import testeo.clases.procesamiento.ProcesarConsulta;
import testeo.uy.dynamic.windows.creator.DynamicCreation;
import testeo.uy.dynamic.windows.creator.input.types.IInputDataType;
import testeo.uy.dynamic.windows.creator.input.types.MiCheckBox;

public class CreadorConsultasDinamico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBarTables = null;
	private JMenu jMenuTables = null;
	private JMenu jMenuAcciones = null;
	private JMenuItem jMenuItemCrear = null;

	/**
	 * This is the default constructor
	 */
	public CreadorConsultasDinamico() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(900, 587);
		this.setJMenuBar(getJJMenuBarTables());
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
		
	}

	private void agregarInternalFrame(TablaBase tabla, DynamicCreation dyn){
		List<JComponent> lista = new ArrayList<JComponent>();
		List<IInputDataType> elem = new ArrayList<IInputDataType>();
		for(ElementoBase b : tabla.getElementos()){
			elem.add(b);
		}
		List<MiCheckBox> listaAux = dyn.crearAPartirDeLista(elem,10, 10, 250, 30);
		for(MiCheckBox ch : listaAux){
			lista.add(ch);
		}
		JInternalFrame frame = dyn.getJInternalFrame(tabla.getNombreTabla(), new Rectangle(43, 37, 467, 300), lista);
		jContentPane.add(frame, null);
	}
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			DynamicCreation dyn = new DynamicCreation();
			//jContentPane =  dyn.getJContentPane();
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			
			agregarInternalFrame(new TablaPacientes(), dyn);
			agregarInternalFrame(new TablaNefropatia(), dyn);
			agregarInternalFrame(new TablaPacienteMuerte(), dyn);
			agregarInternalFrame(new TablaPacienteMuerteCausa(), dyn);
			agregarInternalFrame(new TablaPacientePreTrasplante(), dyn);
			
			this.getJMenuTables();
			List<JMenuItem> listaItems = dyn.listaItems();
			for(JMenuItem item : listaItems){
				item.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						JMenuItem aux = (JMenuItem) e.getSource();
						hideShow(aux.getText());
					}
				});
				this.getJMenuTables().add(item);
			}
			
		}
		return jContentPane;
	}

	private void hideShow(String texto){
		this.startJInternalFrames(this,texto);
	}
	
	private void startJInternalFrames(Component component, String name){
		for (Component child : ((Container) component).getComponents()) {
	    	if(child != null){
	    		if(child.getClass().toString().contains("JInternalFrame")){
	    			JInternalFrame aux = (JInternalFrame) child;
	    			if(aux.getTitle().equalsIgnoreCase(name)){
	    				aux.setVisible(!aux.isVisible());
	    				aux.toFront();
	    			}else{
	    				aux.toBack();
	    			}
	    		}
	    	}
	    	this.startJInternalFrames(child,name);
	    }
	}

	private void buscarActivosMiCheckBox(){
		this.printNodes(this, "MiCheckBox");
		ProcesarConsulta proceso = new ProcesarConsulta();
		proceso.procesamiento(listaActivos);
		listaActivos.clear();
	}
	
	private List<MiCheckBox> listaActivos = new ArrayList<MiCheckBox>();
	
	private void printNodes(Component component,String type ){
		 for (Component child : ((Container) component).getComponents()) {
		    	//System.out.println(child.getClass());
		    	if(child != null){
		    		if(child.getClass().toString().contains(type)){
		    			MiCheckBox aux = (MiCheckBox) child;
		    			if(aux.isSelected()){
		    				//System.out.println(child.toString());
		    				this.listaActivos.add(aux);
		    			}
		    			
		    		}
		    	}
		    	printNodes(child,type);
		    }
	}
	
/*	private void action(){
		this.printFrameNamesComponents(this);
	}*/
	
	void printNames(Component component) {
	    System.out.println(component.getName());
	    for (Component child : ((Container) component).getComponents()) {
	    	System.out.println(child.getClass());
	    	if(child != null){
	    		System.out.println(child.toString());
	    	}
	        printNames(child);
	    }
	}

	void printFrameNamesComponents(JFrame frame) {
	    printNames(frame.getContentPane());
	}

	/**
	 * This method initializes jJMenuBarTables	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBarTables() {
		if (jJMenuBarTables == null) {
			jJMenuBarTables = new JMenuBar();
			jJMenuBarTables.add(getJMenuTables());
			jJMenuBarTables.add(getJMenuAcciones());
		}
		return jJMenuBarTables;
	}

	/**
	 * This method initializes jMenuTables	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuTables() {
		if (jMenuTables == null) {
			jMenuTables = new JMenu();
			jMenuTables.setText("Tables");
		}
		return jMenuTables;
	}

	/**
	 * This method initializes jMenuAcciones	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuAcciones() {
		if (jMenuAcciones == null) {
			jMenuAcciones = new JMenu();
			jMenuAcciones.setText("Acciones");
			jMenuAcciones.add(getJMenuItemCrear());
		}
		return jMenuAcciones;
	}

	/**
	 * This method initializes jMenuItemCrear	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemCrear() {
		if (jMenuItemCrear == null) {
			jMenuItemCrear = new JMenuItem();
			jMenuItemCrear.setText("Crear");
			jMenuItemCrear.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					buscarActivosMiCheckBox();
				}
			});
		}
		return jMenuItemCrear;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
