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
public class TablaPacientes extends TablaBase {

	public TablaPacientes() {
		this.setPadre(null);
		this.setUnionSQL(null);
		this.setNombreTabla("pacientes");
		this.setPreFijo("A");
		cargarElementos();
		this.setIdTabla(1);
	}

	private void cargarElementos() {
		ElementoBase ele = new ElementoBase(1);
		ele.setNombreBase("A.THE");
		ele.setNombreMostrado("THE");
		ele.setTipoValor(Generico.integer);
		this.getElementos().add(ele);
		ele = new ElementoBase(1);
		ele.setNombreBase("A.CI");
		ele.setNombreMostrado("CI");
		ele.setTipoValor(Generico.letras);
		this.getElementos().add(ele);
		ele = new ElementoBase(1);
		ele.setNombreBase("A.NUM_FNR");
		ele.setNombreMostrado("Numero del FNR");
		ele.setTipoValor(Generico.integer);
		this.getElementos().add(ele);
		ele = new ElementoBase(1);
		ele.setNombreBase("A.Nombre");
		ele.setNombreMostrado("Nombre");
		ele.setTipoValor(Generico.letras);
		this.getElementos().add(ele);
		ele = new ElementoBase(1);
		ele.setNombreBase("A.Apellido");
		ele.setNombreMostrado("Apellido");
		ele.setTipoValor(Generico.letras);
		this.getElementos().add(ele);
		ele = new ElementoBase(1);
		ele.setNombreBase("A.FECHA_DIALISIS");
		ele.setNombreMostrado("Fecha de dialisis");
		ele.setTipoValor(Generico.fechas);
		this.getElementos().add(ele);
		ele = new ElementoBase(1);
		ele.setNombreBase("A.FECHA_NACIMIENTO");
		ele.setNombreMostrado("Fecha de nacimiento");
		ele.setTipoValor(Generico.fechas);
		this.getElementos().add(ele);
		ele = new ElementoBase(1);
		ele.setNombreBase("A.GRUPO_SANG");
		ele.setNombreMostrado("Grupo Sanguineo");
		ele.setTipoValor(Generico.letras);
		this.getElementos().add(ele);
		ele = new ElementoBase(1);
		ele.setNombreBase("A.Raza");
		ele.setNombreMostrado("Raza");
		ele.setTipoValor(Generico.letras);
		this.getElementos().add(ele);
		ele = new ElementoBase(1);
		ele.setNombreBase("A.Sexo");
		ele.setNombreMostrado("Sexo");
		ele.setTipoValor(Generico.character);
		this.getElementos().add(ele);
	}

}
