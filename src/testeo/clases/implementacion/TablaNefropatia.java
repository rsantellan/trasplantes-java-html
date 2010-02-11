/**
 * 
 */
package testeo.clases.implementacion;

import dominio.Generico;

import testeo.clases.base.ElementoBase;
import testeo.clases.base.TablaBase;

/**
 * @author rodrigo
 * 
 */
public class TablaNefropatia extends TablaBase {

	public TablaNefropatia() {
		this.setPadre(new TablaPacientes());
		this.setUnionSQL("A.NEFROPATIA = B.ID");
		this.setNombreTabla("nefropatia");
		this.setPreFijo("B");
		cargarElementos();
		this.setIdTabla(2);
	}

	private void cargarElementos() {
		ElementoBase ele = new ElementoBase(2);
		ele.setNombreBase("B.NEFROPATIA");
		ele.setNombreMostrado("NEFROPATIA");
		ele.setTipoValor(Generico.letras);
		this.getElementos().add(ele);
	}

}
