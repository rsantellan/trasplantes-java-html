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
public class TablaPacientePreTrasplante extends TablaBase {

	public TablaPacientePreTrasplante() {
		this.setPadre(new TablaPacientes());
		this.setUnionSQL("A.THE = E.THE");
		this.setNombreTabla("pacientepretrasplante");
		this.setPreFijo("E");
		cargarElementos();
		this.setIdTabla(5);
	}

	private void cargarElementos() {
		ElementoBase ele = new ElementoBase(5);
		ele.setNombreBase("E.diabetes");
		ele.setNombreMostrado("Diabetes");
		ele.setTipoValor(Generico.VF);
		this.getElementos().add(ele);
		ele = new ElementoBase(5);
		ele.setNombreBase("E.dislipemia");
		ele.setNombreMostrado("Dislipemia");
		ele.setTipoValor(Generico.VF);
		this.getElementos().add(ele);
		ele = new ElementoBase(5);
		ele.setNombreBase("E.FECHA_EGRESO");
		ele.setNombreMostrado("Fecha de egreso");
		ele.setTipoValor(Generico.fechas);
		this.getElementos().add(ele);
		ele = new ElementoBase(5);
		ele.setNombreBase("E.FECHA_INGRESO_LISTA");
		ele.setNombreMostrado("Fecha de ingreso a lista");
		ele.setTipoValor(Generico.fechas);
		this.getElementos().add(ele);
		ele = new ElementoBase(5);
		ele.setNombreBase("E.hta");
		ele.setNombreMostrado("HTA");
		ele.setTipoValor(Generico.VF);
		this.getElementos().add(ele);
		ele = new ElementoBase(5);
		ele.setNombreBase("E.imc");
		ele.setNombreMostrado("IMC");
		ele.setTipoValor(Generico.letras);
		this.getElementos().add(ele);
		ele = new ElementoBase(5);
		ele.setNombreBase("E.MODALIDAD_D");
		ele.setNombreMostrado("Modalidad D");
		ele.setTipoValor(Generico.letras);
		this.getElementos().add(ele);
		ele = new ElementoBase(5);
		ele.setNombreBase("E.obesidad");
		ele.setNombreMostrado("Obesidad");
		ele.setTipoValor(Generico.VF);
		this.getElementos().add(ele);
		ele = new ElementoBase(5);
		ele.setNombreBase("E.Origen");
		ele.setNombreMostrado("Origen");
		ele.setTipoValor(Generico.letras);
		this.getElementos().add(ele);
		ele = new ElementoBase(5);
		ele.setNombreBase("E.pbr");
		ele.setNombreMostrado("PBR");
		ele.setTipoValor(Generico.VF);
		this.getElementos().add(ele);
		ele = new ElementoBase(5);
		ele.setNombreBase("E.tabaquismo");
		ele.setNombreMostrado("Tabaquismo");
		ele.setTipoValor(Generico.VF);
		this.getElementos().add(ele);
	}

	/*
	if(this.jCheckBoxPreTrasplanteDiabetes.isSelected()) this.cosasPreTrasplante.add("E.diabetes");
	if(this.jCheckBoxPreTrasplanteDislipemia.isSelected()) this.cosasPreTrasplante.add("E.dislipemia");
	if(this.jCheckBoxPreTrasplanteFechaEgreso.isSelected()) this.cosasPreTrasplante.add("E.FECHA_EGRESO");
	if(this.jCheckBoxPreTrasplanteFechaIngreso.isSelected()) this.cosasPreTrasplante.add("E.FECHA_INGRESO_LISTA");
	if(this.jCheckBoxPreTrasplanteHTA.isSelected()) this.cosasPreTrasplante.add("E.hta");
	if(this.jCheckBoxPreTrasplanteIMC.isSelected()) this.cosasPreTrasplante.add("E.imc");
	if(this.jCheckBoxPreTrasplanteModalidadDialisis.isSelected()) this.cosasPreTrasplante.add("E.MODALIDAD_D");
	if(this.jCheckBoxPreTrasplanteObesidad.isSelected()) this.cosasPreTrasplante.add("E.obesidad");
	if(this.jCheckBoxPreTrasplanteOrigen.isSelected()) this.cosasPreTrasplante.add("E.Origen");
	if(this.jCheckBoxPreTrasplantePBR.isSelected()) this.cosasPreTrasplante.add("E.pbr");
	if(this.jCheckBoxPreTrasplanteTabaquismo.isSelected()) this.cosasPreTrasplante.add("E.tabaquismo");
	
	if(this.cosasPreTrasplante.size()>0) this.tablasUsadas.add("pacientepretrasplante E");
	*/
}
