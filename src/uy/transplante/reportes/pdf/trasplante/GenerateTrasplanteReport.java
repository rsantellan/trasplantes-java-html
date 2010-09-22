/**
 * 
 */
package uy.transplante.reportes.pdf.trasplante;

import logica.Fachada;
import uy.transplante.reportes.pdf.estaticos.DocumentoBasico;
import uy.transplante.auxiliares.fechas.ManejoFechas;
import uy.transplante.dominio.Paciente;
import uy.transplante.dominio.PacientePreTrasplante;
import uy.transplante.dominio.Trasplante;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;


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
		
		for(int x=0;x<p.getListaPreTrasplantes().size();x++){
			PdfPTable table = new PdfPTable(4);
			System.out.println(x);
			PacientePreTrasplante pt = (PacientePreTrasplante) p.getListaPreTrasplantes().get(x);
			table.addCell(DocumentoBasico.cellNoBorderNoColor("Fecha de ingreso a la lista: "));
			table.addCell(DocumentoBasico.cellNoBorderNoColor(ManejoFechas.FORMATOESPANOL.format(pt.getFecha_ingreso_lista().getTime())));
			table.addCell(DocumentoBasico.cellNoBorderNoColor("Fecha de egreso: "));
			table.addCell(DocumentoBasico.cellNoBorderNoColor(ManejoFechas.FORMATOESPANOL.format(pt.getFecha_egreso().getTime())));
			table.addCell(DocumentoBasico.cellNoBorderColor("Modalidad d: "));
			table.addCell(DocumentoBasico.cellNoBorderColor(pt.getModalidad_d()));
			table.addCell(DocumentoBasico.cellNoBorderColor("pbr: "));
			if(pt.isPbr()){
				table.addCell(DocumentoBasico.cellNoBorderColor("SI"));
			}else{
				table.addCell(DocumentoBasico.cellNoBorderColor("NO"));
			}
			table.addCell(DocumentoBasico.cellNoBorderNoColor("diabetes: "));
			table.addCell(DocumentoBasico.cellNoBorderNoColor(pt.getDiabetes()));
			table.addCell(DocumentoBasico.cellNoBorderNoColor("hta: "));
			if(pt.isHta()){
				table.addCell(DocumentoBasico.cellNoBorderNoColor("SI"));
			}else{
				table.addCell(DocumentoBasico.cellNoBorderNoColor("NO"));
			}
			table.addCell(DocumentoBasico.cellNoBorderColor("obesidad: "));
			if(pt.isObesidad()){
				table.addCell(DocumentoBasico.cellNoBorderColor("SI"));
			}else{
				table.addCell(DocumentoBasico.cellNoBorderColor("NO"));
			}
			table.addCell(DocumentoBasico.cellNoBorderColor("imc: "));
			table.addCell(DocumentoBasico.cellNoBorderColor(pt.getImc()));
			
			table.addCell(DocumentoBasico.cellNoBorderNoColor("dislipemia: "));
			if(pt.isDislipemia()){
				table.addCell(DocumentoBasico.cellNoBorderNoColor("SI"));
			}else{
				table.addCell(DocumentoBasico.cellNoBorderNoColor("NO"));
			}
			table.addCell(DocumentoBasico.cellNoBorderNoColor("tabaquismo: "));
			if(pt.isTabaquismo()){
				table.addCell(DocumentoBasico.cellNoBorderNoColor("SI"));
			}else{
				table.addCell(DocumentoBasico.cellNoBorderNoColor("NO"));
			}
			table.addCell(DocumentoBasico.cellNoBorderColor("iam: "));
			if(pt.isIam()){
				table.addCell(DocumentoBasico.cellNoBorderColor("SI"));
			}else{
				table.addCell(DocumentoBasico.cellNoBorderColor("NO"));
			}
			table.addCell(DocumentoBasico.cellNoBorderColor("ave: "));
			if(pt.isAve()){
				table.addCell(DocumentoBasico.cellNoBorderColor("SI"));
			}else{
				table.addCell(DocumentoBasico.cellNoBorderColor("NO"));
			}
			table.addCell(DocumentoBasico.cellNoBorderNoColor("revascCardio: "));
			if(pt.isRevascCardio()){
				table.addCell(DocumentoBasico.cellNoBorderNoColor("SI"));
			}else{
				table.addCell(DocumentoBasico.cellNoBorderNoColor("NO"));
			}
			table.addCell(DocumentoBasico.cellNoBorderNoColor("origen: "));
			table.addCell(DocumentoBasico.cellNoBorderNoColor(pt.getOrigen()));
			table.addCell(DocumentoBasico.cellNoBorderColor("perdidaInjerto: "));
			table.addCell(DocumentoBasico.cellNoBorderColor("VACIO"));
			table.setWidthPercentage(100);
			
			Chunk chunk = new Chunk("Reporte del pre trasplante paciente número " + p.getThe());
			chunk.setTextRenderMode(PdfContentByte.TEXT_RENDER_MODE_FILL_STROKE,
					  0.3f, BaseColor.BLUE);

			Paragraph paragraph = new Paragraph(chunk);
			paragraph.setAlignment(Element.ALIGN_LEFT);
			document.add(paragraph);
			document.add(Chunk.NEWLINE);
			document.add(table);
			document = GenerateTrasplanteReport.trasplante(pt.getId(), document);
			document.add(Chunk.NEWLINE);
		}
		
		
		
		
		return document;
	}
	
	public static Document trasplante(int idPreTransplante , Document document) throws DocumentException{
		document.add(Chunk.NEXTPAGE);
		Trasplante t = new Trasplante();
		t.setPreTrasplante(idPreTransplante);
		Fachada.getInstancia().cambie();
		t.leer();
		PdfPTable table = new PdfPTable(4);
		
		table.addCell(DocumentoBasico.cellNoBorderNoColor("Fecha del transplante: "));
		table.addCell(DocumentoBasico.cellNoBorderNoColor(ManejoFechas.FORMATOESPANOL.format(t.getFecha().getTime())));
		table.addCell(DocumentoBasico.cellNoBorderNoColor("Número de transplante: "));
		table.addCell(DocumentoBasico.cellNoBorderNoColor(String.valueOf(t.getNumTr())));
		
		table.addCell(DocumentoBasico.cellNoBorderColor("Número del donante "));
		table.addCell(DocumentoBasico.cellNoBorderColor(t.getNumDonante()));
		table.addCell(DocumentoBasico.cellNoBorderColor("Inestabilidad Hemod "));
		if(t.isInstabHemod()){
			table.addCell(DocumentoBasico.cellNoBorderColor("SI"));
		}else{
			table.addCell(DocumentoBasico.cellNoBorderColor("NO"));
		}
		
		table.addCell(DocumentoBasico.cellNoBorderNoColor("Riñon: "));
		table.addCell(DocumentoBasico.cellNoBorderNoColor(t.getRinhon()));
		table.addCell(DocumentoBasico.cellNoBorderNoColor("Anomalia Vascular: "));
		if(t.isAnomaliaVasc()){
			table.addCell(DocumentoBasico.cellNoBorderNoColor("SI"));
		}else{
			table.addCell(DocumentoBasico.cellNoBorderNoColor("NO"));
		}
		
		table.addCell(DocumentoBasico.cellNoBorderColor("Número de arterias: "));
		table.addCell(DocumentoBasico.cellNoBorderColor(String.valueOf(t.getNumArt())));
		table.addCell(DocumentoBasico.cellNoBorderColor("Número de venas: "));
		table.addCell(DocumentoBasico.cellNoBorderColor(String.valueOf(t.getNumVenas())));
		
		table.addCell(DocumentoBasico.cellNoBorderNoColor("Ureter: "));
		table.addCell(DocumentoBasico.cellNoBorderNoColor(t.getUreter()));
		table.addCell(DocumentoBasico.cellNoBorderNoColor("Número de comp A B: "));
		table.addCell(DocumentoBasico.cellNoBorderNoColor(String.valueOf(t.getNumCompAB())));
		
		table.addCell(DocumentoBasico.cellNoBorderColor("Número de incomp A B: "));
		table.addCell(DocumentoBasico.cellNoBorderColor(String.valueOf(t.getNumIncompAB())));
		table.addCell(DocumentoBasico.cellNoBorderColor("Número de compatibilidad DR: "));
		table.addCell(DocumentoBasico.cellNoBorderColor(String.valueOf(t.getNumCompDR())));
		
		table.addCell(DocumentoBasico.cellNoBorderNoColor("Número de incomp DR: "));
		table.addCell(DocumentoBasico.cellNoBorderNoColor(String.valueOf(t.getNumIncompDR())));
		table.addCell(DocumentoBasico.cellNoBorderNoColor("AUTOAC: "));
		if(t.isAutoac()){
			table.addCell(DocumentoBasico.cellNoBorderNoColor("SI"));
		}else{
			table.addCell(DocumentoBasico.cellNoBorderNoColor("NO"));
		}
		
		table.addCell(DocumentoBasico.cellNoBorderColor("Pra Max: "));
		table.addCell(DocumentoBasico.cellNoBorderColor(String.valueOf(t.getPraMax())));
		table.addCell(DocumentoBasico.cellNoBorderColor("Pra tr: "));
		table.addCell(DocumentoBasico.cellNoBorderColor(String.valueOf(t.getPraTR())));
		
		table.addCell(DocumentoBasico.cellNoBorderNoColor("Tranfusiones previas: "));
		if(t.isTransPrevias()){
			table.addCell(DocumentoBasico.cellNoBorderNoColor("SI"));
		}else{
			table.addCell(DocumentoBasico.cellNoBorderNoColor("NO"));
		}
		table.addCell(DocumentoBasico.cellNoBorderNoColor("Número de Tranfusiones: "));
		table.addCell(DocumentoBasico.cellNoBorderNoColor(String.valueOf(t.getNumTransf())));
		
		table.addCell(DocumentoBasico.cellNoBorderColor("Número de Tranfusiones: "));
		table.addCell(DocumentoBasico.cellNoBorderColor(String.valueOf(t.getNumTransf())));
		table.addCell(DocumentoBasico.cellNoBorderColor("Embarazo: "));
		table.addCell(DocumentoBasico.cellNoBorderColor(t.getEmbarazo()));
		
		table.addCell(DocumentoBasico.cellNoBorderNoColor("Número de embarazo: "));
		table.addCell(DocumentoBasico.cellNoBorderNoColor(String.valueOf(t.getNumEmbarazo())));
		table.addCell(DocumentoBasico.cellNoBorderNoColor("Liq Perfusion: "));
		table.addCell(DocumentoBasico.cellNoBorderNoColor(t.getLiqPerfusion()));
		
		table.addCell(DocumentoBasico.cellNoBorderColor("TQ de banco: "));
		if(t.isTqDeBanco()){
			table.addCell(DocumentoBasico.cellNoBorderColor("SI"));
		}else{
			table.addCell(DocumentoBasico.cellNoBorderColor("NO"));
		}
		table.addCell(DocumentoBasico.cellNoBorderColor("Lado del implante: "));
		table.addCell(DocumentoBasico.cellNoBorderColor(t.getLadoImplante()));
		
		table.addCell(DocumentoBasico.cellNoBorderNoColor("Anast Venosa: "));
		table.addCell(DocumentoBasico.cellNoBorderNoColor(t.getAnastVenosa()));
		table.addCell(DocumentoBasico.cellNoBorderNoColor("Anast Arterial: "));
		table.addCell(DocumentoBasico.cellNoBorderNoColor(t.getAnastArterial()));
		
		table.addCell(DocumentoBasico.cellNoBorderColor("Anast Ureteral: "));
		table.addCell(DocumentoBasico.cellNoBorderColor(t.getAnastUterial()));
		table.addCell(DocumentoBasico.cellNoBorderColor("T_ISQ_CAL_MIN: "));
		table.addCell(DocumentoBasico.cellNoBorderColor(String.valueOf(t.getTIsqCalMin())));
		
		table.addCell(DocumentoBasico.cellNoBorderNoColor("T_ISQ_FRIA_HS: "));
		table.addCell(DocumentoBasico.cellNoBorderNoColor(String.valueOf(t.getTIsqFriqHs())));
		table.addCell(DocumentoBasico.cellNoBorderNoColor("T_ISQ_FRIA_MIN: "));
		table.addCell(DocumentoBasico.cellNoBorderNoColor(String.valueOf(t.getTIsqFriaMin())));
		

		table.addCell(DocumentoBasico.cellNoBorderColor("T_ISQ_TIBIA_HS: "));
		table.addCell(DocumentoBasico.cellNoBorderColor(String.valueOf(t.getTIsqTibiaHs())));
		table.addCell(DocumentoBasico.cellNoBorderColor("Reperfusion: "));
		table.addCell(DocumentoBasico.cellNoBorderColor(t.getRepercusion()));
		
		table.addCell(DocumentoBasico.cellNoBorderNoColor("SANGRADO_I_OP: "));
		if(t.isSangradoIOp()){
			table.addCell(DocumentoBasico.cellNoBorderNoColor("SI"));
		}else{
			table.addCell(DocumentoBasico.cellNoBorderNoColor("NO"));
		}
		table.addCell(DocumentoBasico.cellNoBorderNoColor("LESION_ARTERIAL: "));
		if(t.isLesionArterial()){
			table.addCell(DocumentoBasico.cellNoBorderNoColor("SI"));
		}else{
			table.addCell(DocumentoBasico.cellNoBorderNoColor("NO"));
		}
		
		table.addCell(DocumentoBasico.cellNoBorderColor("LESION_VENOSA: "));
		if(t.isLesionVenosa()){
			table.addCell(DocumentoBasico.cellNoBorderColor("SI"));
		}else{
			table.addCell(DocumentoBasico.cellNoBorderColor("NO"));
		}
		table.addCell(DocumentoBasico.cellNoBorderColor("NECESIDAD_REPEFUNDIR: "));
		if(t.isNecesidadRepefundir()){
			table.addCell(DocumentoBasico.cellNoBorderColor("SI"));
		}else{
			table.addCell(DocumentoBasico.cellNoBorderColor("NO"));
		}
		
		table.addCell(DocumentoBasico.cellNoBorderNoColor("OTRAS_COMPL_QUIRUR: "));
		table.addCell(DocumentoBasico.cellNoBorderNoColor(t.getOtrasComplicacionesQuirurgicas()));
		table.addCell(DocumentoBasico.cellNoBorderNoColor("DIURESIS_I_OP: "));
		if(t.isDiuresisIOp()){
			table.addCell(DocumentoBasico.cellNoBorderNoColor("SI"));
		}else{
			table.addCell(DocumentoBasico.cellNoBorderNoColor("NO"));
		}
		
		table.addCell(DocumentoBasico.cellNoBorderColor("CR_INICIAL: "));
		table.addCell(DocumentoBasico.cellNoBorderColor(String.valueOf(t.getCrInicial())));
		table.addCell(DocumentoBasico.cellNoBorderColor("DIA_REC_DIURESIS: "));
		table.addCell(DocumentoBasico.cellNoBorderColor(String.valueOf(t.getDiaRecDiuresis())));
		
		table.addCell(DocumentoBasico.cellNoBorderNoColor("DIA_REC_FUNCIONAL: "));
		table.addCell(DocumentoBasico.cellNoBorderNoColor(String.valueOf(t.getDiaRecFuncional())));
		table.addCell(DocumentoBasico.cellNoBorderNoColor("DIALISIS: "));
		if(t.isDialisis()){
			table.addCell(DocumentoBasico.cellNoBorderNoColor("SI"));
		}else{
			table.addCell(DocumentoBasico.cellNoBorderNoColor("NO"));
		}
		
		table.addCell(DocumentoBasico.cellNoBorderColor("NUM_DE_HD: "));
		table.addCell(DocumentoBasico.cellNoBorderColor(String.valueOf(t.getNumDeHd())));
		table.addCell(DocumentoBasico.cellNoBorderColor("Comentario: "));
		table.addCell(DocumentoBasico.cellNoBorderColor(t.getComentario()));
		
		table.addCell(DocumentoBasico.cellNoBorderNoColor("Fecha de alta: "));
		table.addCell(DocumentoBasico.cellNoBorderNoColor(ManejoFechas.FORMATOESPANOL.format(t.getFechaAlta().getTime())));
		table.addCell(DocumentoBasico.cellNoBorderNoColor(" "));
		table.addCell(DocumentoBasico.cellNoBorderNoColor(" "));
		
		
		table.setWidthPercentage(100);
		
		Chunk chunk = new Chunk("Reporte del trasplante paciente número " + t.getId());
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
