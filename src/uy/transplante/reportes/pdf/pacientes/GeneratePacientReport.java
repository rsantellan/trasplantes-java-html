/**
 * 
 */
package uy.transplante.reportes.pdf.pacientes;

import uy.transplante.reportes.pdf.estaticos.DocumentoBasico;
import uy.transplante.auxiliares.fechas.ManejoFechas;
import uy.transplante.dominio.Paciente;
import uy.transplante.dominio.PacientePerdidaInjerto;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;

import logica.Fachada;

/**
 * @author rodrigo
 *
 */
public class GeneratePacientReport {

	public static Document soloPaciente(int id , Document document) throws DocumentException{
		Paciente p = new Paciente();
		p.setThe(id);
		Fachada.getInstancia().cambie();
		p.leer();
		p.leerDatos();
		PdfPTable table = new PdfPTable(4);
		table.addCell(DocumentoBasico.cellNoBorderNoColor("THE: "));
		table.addCell(DocumentoBasico.cellNoBorderNoColor(String.valueOf(p.getThe())));
		table.addCell(DocumentoBasico.cellNoBorderNoColor("Cedula de identidad: "));
		table.addCell(DocumentoBasico.cellNoBorderNoColor(p.getCi()));
		table.addCell(DocumentoBasico.cellNoBorderColor("Nombre: "));
		table.addCell(DocumentoBasico.cellNoBorderColor(p.getNombre()));
		table.addCell(DocumentoBasico.cellNoBorderColor("Apellido: "));
		table.addCell(DocumentoBasico.cellNoBorderColor(p.getApellido()));
		table.addCell(DocumentoBasico.cellNoBorderNoColor("FNR: "));
		table.addCell(DocumentoBasico.cellNoBorderNoColor(String.valueOf(p.getNum_fnr())));
		table.addCell(DocumentoBasico.cellNoBorderNoColor("Raza: "));
		table.addCell(DocumentoBasico.cellNoBorderNoColor(p.getRaza()));
		table.addCell(DocumentoBasico.cellNoBorderColor("Sexo: "));
		table.addCell(DocumentoBasico.cellNoBorderColor(p.getSexo()));
		table.addCell(DocumentoBasico.cellNoBorderColor("Fecha de nacimiento: "));
		table.addCell(DocumentoBasico.cellNoBorderColor(ManejoFechas.FORMATOESPANOL.format(p.getFecha_nacimiento().getTime())));
		table.addCell(DocumentoBasico.cellNoBorderNoColor("Fecha de dialisis: "));
		table.addCell(DocumentoBasico.cellNoBorderNoColor(ManejoFechas.FORMATOESPANOL.format(p.getFecha_dialisis().getTime())));
		table.addCell(DocumentoBasico.cellNoBorderNoColor("Grupo sanguineo: "));
		table.addCell(DocumentoBasico.cellNoBorderNoColor(p.getGrupoSanguineo()));
		table.addCell(DocumentoBasico.cellNoBorderColor("Nefropatia: "));
		table.addCell(DocumentoBasico.cellNoBorderColor(p.getTipoNefropatia().getNefropatia()));
		table.setWidthPercentage(100);
		
		Chunk chunk = new Chunk("Reporte basico del paciente número " + p.getThe());
		chunk.setTextRenderMode(PdfContentByte.TEXT_RENDER_MODE_FILL_STROKE,
				  0.3f, BaseColor.BLUE);

		Paragraph paragraph = new Paragraph(chunk);
		paragraph.setAlignment(Element.ALIGN_LEFT);
		document.add(paragraph);
		document.add(Chunk.NEWLINE);
		document.add(table);
		return document;
	}
	
	public static Document pacientePerdidaInjertos(int id , Document document) throws DocumentException{
		Paciente p = new Paciente();
		p.setThe(id);
		Fachada.getInstancia().cambie();
		p.leer();
		p.leerDatos();
		PdfPTable table = new PdfPTable(2);
		for(int x=0;x<p.getListaPerdidas().size();x++){
			PacientePerdidaInjerto auxPerdida = (PacientePerdidaInjerto) p.getListaPerdidas().get(x);
			table.addCell(DocumentoBasico.cellNoBorderNoColor("Fecha de la perdida: "));
			table.addCell(DocumentoBasico.cellNoBorderNoColor(ManejoFechas.FORMATOESPANOL.format(auxPerdida.getFechaPerdida().getTime())));
			table.addCell(DocumentoBasico.cellNoBorderColor("Causa de la perdida: "));
			table.addCell(DocumentoBasico.cellNoBorderColor(auxPerdida.getCausa().getDetalle()));
		}
		table.setWidthPercentage(100);
		
		Chunk chunk = new Chunk("Reporte de perdidas del paciente número " + p.getThe());
		chunk.setTextRenderMode(PdfContentByte.TEXT_RENDER_MODE_FILL_STROKE,
				  0.3f, BaseColor.BLUE);

		Paragraph paragraph = new Paragraph(chunk);
		paragraph.setAlignment(Element.ALIGN_LEFT);
		document.add(paragraph);
		document.add(Chunk.NEWLINE);
		document.add(table);
		return document;
	}
	
	public static Document pacienteMuerte(int id , Document document) throws DocumentException{
		Paciente p = new Paciente();
		p.setThe(id);
		Fachada.getInstancia().cambie();
		p.leer();
		p.leerDatos();
		PdfPTable table = new PdfPTable(2);

		if(p.getMuertePaciente() != null){
			table.addCell(DocumentoBasico.cellNoBorderNoColor("Fecha de la muerte: "));
			table.addCell(DocumentoBasico.cellNoBorderNoColor(ManejoFechas.FORMATOESPANOL.format(p.getMuertePaciente().getFechaMuerte().getTime())));
			table.addCell(DocumentoBasico.cellNoBorderColor("Causa de la muerte: "));
			table.addCell(DocumentoBasico.cellNoBorderColor(p.getMuertePaciente().getCausa().getDetalle()));
			table.addCell(DocumentoBasico.cellNoBorderNoColor("Trasplante Funcionando: "));
			if(p.getMuertePaciente().isTrFuncionando()){
				table.addCell(DocumentoBasico.cellNoBorderNoColor("SI"));
			}else{
				table.addCell(DocumentoBasico.cellNoBorderNoColor("NO"));
			}
		}
		table.setWidthPercentage(100);
		
		Chunk chunk = new Chunk("Reporte de muerte del paciente número " + p.getThe());
		chunk.setTextRenderMode(PdfContentByte.TEXT_RENDER_MODE_FILL_STROKE,
				  0.3f, BaseColor.BLUE);

		Paragraph paragraph = new Paragraph(chunk);
		paragraph.setAlignment(Element.ALIGN_LEFT);
		document.add(paragraph);
		document.add(Chunk.NEWLINE);
		document.add(table);
		return document;
	}
}
