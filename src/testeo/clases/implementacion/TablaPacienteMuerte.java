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
public class TablaPacienteMuerte extends TablaBase {

	public TablaPacienteMuerte() {
		this.setPadre(new TablaPacientes());
		this.setUnionSQL("A.THE = C.THE");
		this.setNombreTabla("paciente_muerte");
		this.setPreFijo("C");
		cargarElementos();
		this.setIdTabla(3);
	}

	private void cargarElementos() {
		ElementoBase ele = new ElementoBase(3);
		ele.setNombreBase("C.FECHA_MUERTE");
		ele.setNombreMostrado("FECHA de Muerte");
		ele.setTipoValor(Generico.fechas);
		this.getElementos().add(ele);
		ele = new ElementoBase(3);
		ele.setNombreBase("C.TR_Funcionando");
		ele.setNombreMostrado("Trasplante funcionando");
		ele.setTipoValor(Generico.VF);
		this.getElementos().add(ele);
	}
	
}
