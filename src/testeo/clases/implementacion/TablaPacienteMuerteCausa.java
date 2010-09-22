/**
 * 
 */
package testeo.clases.implementacion;


import testeo.clases.base.ElementoBase;
import testeo.clases.base.TablaBase;
import uy.transplante.dominio.Generico;

/**
 * @author rodrigo
 * 
 */
public class TablaPacienteMuerteCausa extends TablaBase {

	public TablaPacienteMuerteCausa() {
		this.setPadre(new TablaPacienteMuerte());
		this.setUnionSQL("C.CAUSA = D.ID");
		this.setNombreTabla("paciente_causa_muerte");
		this.setPreFijo("D");
		cargarElementos();
		this.setIdTabla(4);
	}

	private void cargarElementos() {
		ElementoBase ele = new ElementoBase(4);
		ele.setNombreBase("D.DETALLES");
		ele.setNombreMostrado("Causa de Muerte");
		ele.setTipoValor(Generico.letras);
		this.getElementos().add(ele);
	}
}
