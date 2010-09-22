/**
 * 
 */
package testeo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import uy.transplante.auxiliares.fechas.ManejoFechas;
import uy.transplante.dominio.Generico;
import uy.transplante.dominio.GenericoAuxiliar;

/**
 * @author rodrigo
 *
 */
public class UsarGenericoConGenericoAuxiliar{

	private Generico generico;

	private GenericoAuxiliar genericoAuxiliar;
	
	private String separador = "|";
	
	private String nombreConsulta;
	
	/**
	 * @return the nombreConsulta
	 */
	private String getNombreConsulta() {
		return nombreConsulta;
	}

	/**
	 * @param nombreConsulta the nombreConsulta to set
	 */
	private void setNombreConsulta(String nombreConsulta) {
		this.nombreConsulta = nombreConsulta;
	}

	/**
	 * @return the separador
	 */
	private String getSeparador() {
		return separador;
	}

	/**
	 * @return the genericoAuxiliar
	 */
	private GenericoAuxiliar getGenericoAuxiliar() {
		return genericoAuxiliar;
	}

	/**
	 * @param genericoAuxiliar the genericoAuxiliar to set
	 */
	private void setGenericoAuxiliar(GenericoAuxiliar genericoAuxiliar) {
		this.genericoAuxiliar = genericoAuxiliar;
	}

	/**
	 * @return the generico
	 */
	public Generico getGenerico() {
		return generico;
	}

	/**
	 * @param generico the generico to set
	 */
	private void setGenerico(Generico generico) {
		this.generico = generico;
	}

	public UsarGenericoConGenericoAuxiliar(){
	}
	/**
	 * @param generico
	 * @param nombre
	 */
	public UsarGenericoConGenericoAuxiliar(Generico generico, String nombre) {
		super();
		this.setGenerico(generico);
		this.setGenericoAuxiliar(new GenericoAuxiliar());
		this.setNombreConsulta(nombre);
	}

	private void pasarGenericoAGenericoAuxiliar(){
		String tip = "";
		String nom = "";
		for(int x=0;x<this.getGenerico().getListaDada().size();x++){
			String auxNombre = (String) this.getGenerico().getListaNombre().get(x);
			String auxTipo = (String) this.getGenerico().getListaDada().get(x);
			tip += auxTipo + this.getSeparador();
			nom += auxNombre + this.getSeparador();
		}
		this.getGenericoAuxiliar().setNombre(this.getNombreConsulta());
		this.getGenericoAuxiliar().setSentencia(this.getGenerico().getSql());
		this.getGenericoAuxiliar().setNombres(nom);
		this.getGenericoAuxiliar().setTipos(tip);
	}
	
	public boolean guardar(){
		this.pasarGenericoAGenericoAuxiliar();
		if(this.getGenericoAuxiliar().contar() != 0){
			return false;
		}
		this.getGenericoAuxiliar().guardar();
		return true;
	}
	
	public Generico convertirAuxiliarGenerico(GenericoAuxiliar ga) {
		Generico g = new Generico();
		g.setSql(ga.getSentencia());
		String aux = "";
		for (int x = 0; x < ga.getTipos().length(); x++) {
			if (ga.getTipos().charAt(x) != '|') {
				aux += ga.getTipos().charAt(x);
			} else {
				g.getListaDada().add(aux);
				aux = "";
			}
		}
		for (int x = 0; x < ga.getNombres().length(); x++) {
			if (ga.getNombres().charAt(x) != '|') {
				aux += ga.getNombres().charAt(x);
			} else {
				g.getListaNombre().add(aux);
				aux = "";
			}
		}
		g.leer();
		this.arreglarDatosGenericos(g);
		return g;
	}
	
	private void arreglarDatosGenericos(Generico g) {
		ArrayList<Object> listaAux = new ArrayList<Object>();
		for (int x = 0; x < g.getListaObtenida().size(); x++) {
			int pos = x % g.getListaDada().size();
			String es = g.getListaDada().get(pos);
			if (es.equalsIgnoreCase(Generico.fechas)) {
				Calendar c = new GregorianCalendar();
				try {
					c.setTime(ManejoFechas.FORMATOINGLES.parse(g
							.getListaObtenida().get(x).toString()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				listaAux.add(ManejoFechas.FORMATOESPANOL.format(c.getTime()));
			} else {
				if (es.equalsIgnoreCase(Generico.letras)) {
					if (g.getListaObtenida().get(x).toString()
							.equalsIgnoreCase("null")) {
						listaAux.add(" - ");
					} else {
						listaAux.add(g.getListaObtenida().get(x).toString());
					}
				} else {
					listaAux.add(g.getListaObtenida().get(x).toString());
				}
			}
		}
		g.setListaObtenida(listaAux);
	}
}
