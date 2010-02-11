/**
 * 
 */
package testeo.clases.procesamiento;

import iu.consultas.IUConsultaGenerica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import logica.Fachada;

import dominio.Generico;

import testeo.clases.base.ElementoBase;
import testeo.clases.base.TablaBase;
import testeo.clases.implementacion.RegistroTablas;
import testeo.uy.dynamic.windows.creator.input.types.MiCheckBox;

/**
 * @author rodrigo
 *
 */
public class ProcesarConsulta {

	private HashMap<Integer, TablaBase> diccionarioTablas =  new HashMap<Integer, TablaBase>();
	
	
	public void procesamiento(List<MiCheckBox> lista){
		Generico g = new Generico();
		RegistroTablas registro = new RegistroTablas();
		String listaSQL = "";
		for(int x = 0;x<lista.size();x++){
			MiCheckBox in = (MiCheckBox) lista.get(x);
			ElementoBase elemento = (ElementoBase)in.getDato();
			listaSQL += elemento.getNombreBase();
			g.getListaDada().add(elemento.getTipoValor());
			g.getListaNombre().add(elemento.getNombreMostrado());
			if(x+1 != lista.size()){
				listaSQL += ", ";
			}
			TablaBase tabla = registro.getDiccionario().get(elemento.getIdTabla());
			if(!this.diccionarioTablas.containsKey(tabla.getIdTabla())){
				this.diccionarioTablas.put(tabla.getIdTabla(), tabla);
			}
			
		}
		
		Collection<TablaBase> listaTablasDiccionario = this.diccionarioTablas.values();
		String tablasSQL = "";
		int y = 0;
		ArrayList<String> listaCondiciones = new ArrayList<String>();
		HashMap<Integer, Boolean> tablasDeWhere = new HashMap<Integer, Boolean>();
		HashMap<Integer, Boolean> tablasDeUsadas = new HashMap<Integer, Boolean>();
		for(TablaBase a : listaTablasDiccionario){
			if(!tablasDeUsadas.containsKey(a.getIdTabla())){
				tablasSQL += a.getNombreTabla() + " " + a.getPreFijo();
				listaCondiciones.add(a.getUnionSQL());
				tablasDeWhere.put(a.getIdTabla(), true);
				if(y+1 != listaTablasDiccionario.size()){
					tablasSQL += " ,";
				}
			}
			
			y++;
		}
		String sql = "SELECT "+ listaSQL + " FROM " + tablasSQL;
		String sqlCond = " WHERE ";
		int adding = 0;
		
		for(int x=0;x<listaCondiciones.size();x++){
			String s =(String)listaCondiciones.get(x);
			if(s!= null){
				sqlCond += s;
				adding ++;
				if(x+1 != listaCondiciones.size()){
					sqlCond += " AND ";
				}
			}
		}
		if(adding > 0){
			sql += sqlCond;
		}
		g.setSql(sql);
		Fachada.getInstancia().cambie();
		System.out.println(sql);
		g.leer();
		mostrar(g);
		System.out.println(sql);
	}
	
/*	private void manejarWhere(){
		
	}*/
	
	private void mostrar(Generico g){
		if(g == null) return;
		IUConsultaGenerica iu = new IUConsultaGenerica(g);
		iu.setVisible(true);
	}
}
