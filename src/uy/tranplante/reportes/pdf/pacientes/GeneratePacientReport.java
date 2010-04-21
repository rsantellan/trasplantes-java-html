/**
 * 
 */
package uy.tranplante.reportes.pdf.pacientes;

import uy.tranplante.reportes.pdf.estaticos.DocumentoBasico;
import auxiliares.ManejoFechas;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;

import logica.Fachada;
import dominio.Paciente;
import dominio.PacientePerdidaInjerto;

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
		table.addCell(DocumentoBasico.cellWithNoBorder("THE: "));
		table.addCell(DocumentoBasico.cellWithNoBorder(String.valueOf(p.getThe())));
		table.addCell(DocumentoBasico.cellWithNoBorder("Cedula de identidad: "));
		table.addCell(DocumentoBasico.cellWithNoBorder(p.getCi()));
		table.addCell(DocumentoBasico.cellWithNoBorder("Nombre: "));
		table.addCell(DocumentoBasico.cellWithNoBorder(p.getNombre()));
		table.addCell(DocumentoBasico.cellWithNoBorder("Apellido: "));
		table.addCell(DocumentoBasico.cellWithNoBorder(p.getApellido()));
		table.addCell(DocumentoBasico.cellWithNoBorder("FNR: "));
		table.addCell(DocumentoBasico.cellWithNoBorder(String.valueOf(p.getNum_fnr())));
		table.addCell(DocumentoBasico.cellWithNoBorder("Raza: "));
		table.addCell(DocumentoBasico.cellWithNoBorder(p.getRaza()));
		table.addCell(DocumentoBasico.cellWithNoBorder("Sexo: "));
		table.addCell(DocumentoBasico.cellWithNoBorder(p.getSexo()));
		table.addCell(DocumentoBasico.cellWithNoBorder("Fecha de nacimiento: "));
		table.addCell(DocumentoBasico.cellWithNoBorder(ManejoFechas.formatoEspanol.format(p.getFecha_nacimiento().getTime())));
		table.addCell(DocumentoBasico.cellWithNoBorder("Fecha de dialisis: "));
		table.addCell(DocumentoBasico.cellWithNoBorder(ManejoFechas.formatoEspanol.format(p.getFecha_dialisis().getTime())));
		table.addCell(DocumentoBasico.cellWithNoBorder("Grupo sanguineo: "));
		table.addCell(DocumentoBasico.cellWithNoBorder(p.getGrupoSanguineo()));
		table.addCell(DocumentoBasico.cellWithNoBorder("Nefropatia: "));
		table.addCell(DocumentoBasico.cellWithNoBorder(p.getTipoNefropatia().getNefropatia()));
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
			table.addCell(DocumentoBasico.cellWithNoBorder("Fecha de la perdida: "));
			table.addCell(DocumentoBasico.cellWithNoBorder(ManejoFechas.formatoEspanol.format(auxPerdida.getFechaPerdida().getTime())));
			table.addCell(DocumentoBasico.cellWithNoBorder("Causa de la perdida: "));
			table.addCell(DocumentoBasico.cellWithNoBorder(auxPerdida.getCausa().getDetalle()));
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
			table.addCell(DocumentoBasico.cellWithNoBorder("Fecha de la muerte: "));
			table.addCell(DocumentoBasico.cellWithNoBorder(ManejoFechas.formatoEspanol.format(p.getMuertePaciente().getFechaMuerte().getTime())));
			table.addCell(DocumentoBasico.cellWithNoBorder("Causa de la muerte: "));
			table.addCell(DocumentoBasico.cellWithNoBorder(p.getMuertePaciente().getCausa().getDetalle()));
			table.addCell(DocumentoBasico.cellWithNoBorder("Trasplante Funcionando: "));
			if(p.getMuertePaciente().isTrFuncionando()){
				table.addCell(DocumentoBasico.cellWithNoBorder("SI"));
			}else{
				table.addCell(DocumentoBasico.cellWithNoBorder("NO"));
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
