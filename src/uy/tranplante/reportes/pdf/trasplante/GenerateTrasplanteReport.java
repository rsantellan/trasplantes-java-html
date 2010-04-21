/**
 * 
 */
package uy.tranplante.reportes.pdf.trasplante;

import logica.Fachada;
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

import dominio.Paciente;
import dominio.PacientePreTrasplante;

/**
 * @author rodrigo
 *
 */
public class GenerateTrasplanteReport {

	public static Document preTrasplante(int id , Document document) throws DocumentException{
		document.add(Chunk.NEXTPAGE);
		Paciente p = new Paciente();
		p.setThe(id);
		Fachada.getInstancia().cambie();
		p.leer();
		p.leerDatos();
		p.leerDatosPreTrasplante();
		PdfPTable table = new PdfPTable(4);
		for(int x=0;x<p.getListaPreTrasplantes().size();x++){
			System.out.println(x);
			PacientePreTrasplante pt = (PacientePreTrasplante) p.getListaPreTrasplantes().get(x);
			table.addCell(DocumentoBasico.cellWithNoBorder("Fecha de ingreso a la lista: "));
			table.addCell(DocumentoBasico.cellWithNoBorder(ManejoFechas.formatoEspanol.format(pt.getFecha_ingreso_lista().getTime())));
			table.addCell(DocumentoBasico.cellWithNoBorder("Fecha de egreso: "));
			table.addCell(DocumentoBasico.cellWithNoBorder(ManejoFechas.formatoEspanol.format(pt.getFecha_egreso().getTime())));
			table.addCell(DocumentoBasico.cellWithNoBorder("Modalidad d: "));
			table.addCell(DocumentoBasico.cellWithNoBorder(pt.getModalidad_d()));
			table.addCell(DocumentoBasico.cellWithNoBorder("pbr: "));
			if(pt.isPbr()){
				table.addCell(DocumentoBasico.cellWithNoBorder("SI"));
			}else{
				table.addCell(DocumentoBasico.cellWithNoBorder("NO"));
			}
			table.addCell(DocumentoBasico.cellWithNoBorder("diabetes: "));
			table.addCell(DocumentoBasico.cellWithNoBorder(pt.getDiabetes()));
			table.addCell(DocumentoBasico.cellWithNoBorder("hta: "));
			if(pt.isHta()){
				table.addCell(DocumentoBasico.cellWithNoBorder("SI"));
			}else{
				table.addCell(DocumentoBasico.cellWithNoBorder("NO"));
			}
			table.addCell(DocumentoBasico.cellWithNoBorder("obesidad: "));
			if(pt.isObesidad()){
				table.addCell(DocumentoBasico.cellWithNoBorder("SI"));
			}else{
				table.addCell(DocumentoBasico.cellWithNoBorder("NO"));
			}
			table.addCell(DocumentoBasico.cellWithNoBorder("imc: "));
			table.addCell(DocumentoBasico.cellWithNoBorder(pt.getImc()));
			
			table.addCell(DocumentoBasico.cellWithNoBorder("dislipemia: "));
			if(pt.isDislipemia()){
				table.addCell(DocumentoBasico.cellWithNoBorder("SI"));
			}else{
				table.addCell(DocumentoBasico.cellWithNoBorder("NO"));
			}
			table.addCell(DocumentoBasico.cellWithNoBorder("tabaquismo: "));
			if(pt.isTabaquismo()){
				table.addCell(DocumentoBasico.cellWithNoBorder("SI"));
			}else{
				table.addCell(DocumentoBasico.cellWithNoBorder("NO"));
			}
			table.addCell(DocumentoBasico.cellWithNoBorder("iam: "));
			if(pt.isIam()){
				table.addCell(DocumentoBasico.cellWithNoBorder("SI"));
			}else{
				table.addCell(DocumentoBasico.cellWithNoBorder("NO"));
			}
			table.addCell(DocumentoBasico.cellWithNoBorder("ave: "));
			if(pt.isAve()){
				table.addCell(DocumentoBasico.cellWithNoBorder("SI"));
			}else{
				table.addCell(DocumentoBasico.cellWithNoBorder("NO"));
			}
			table.addCell(DocumentoBasico.cellWithNoBorder("revascCardio: "));
			if(pt.isRevascCardio()){
				table.addCell(DocumentoBasico.cellWithNoBorder("SI"));
			}else{
				table.addCell(DocumentoBasico.cellWithNoBorder("NO"));
			}
			table.addCell(DocumentoBasico.cellWithNoBorder("origen: "));
			table.addCell(DocumentoBasico.cellWithNoBorder(pt.getOrigen()));
			table.addCell(DocumentoBasico.cellWithNoBorder("perdidaInjerto: "));
			table.addCell(DocumentoBasico.cellWithNoBorder("VACIO"));
			table.setWidthPercentage(100);
			
		}
		
		
		
		Chunk chunk = new Chunk("Reporte del pre trasplante paciente número " + p.getThe());
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
