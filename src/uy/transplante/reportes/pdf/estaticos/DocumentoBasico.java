/**
 * 
 */
package uy.transplante.reportes.pdf.estaticos;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;

/**
 * @author rodrigo
 *
 */
public class DocumentoBasico {

	public static Document documentoBasico(){
		return new Document(PageSize.A4, 72, 72, 72, 72);
	}
	
	public static PdfPCell cellWithNoBorder(String text){
		PdfPCell cell = new PdfPCell(new Paragraph(text));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setMinimumHeight(36f);
		return cell;
	}
	
	public static PdfPCell cellNoBorderColor(String text){
		PdfPCell cell = new PdfPCell(new Paragraph(text));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setMinimumHeight(36f);
		//cell.setGrayFill(0.9f);
		cell.setBackgroundColor(BaseColor.CYAN);
		return cell;
	}
	
	public static PdfPCell cellNoBorderNoColor(String text){
		PdfPCell cell = new PdfPCell(new Paragraph(text));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setMinimumHeight(36f);
		//cell.setGrayFill(0.9f);
		//cell.setBackgroundColor(BaseColor.CYAN);
		return cell;
	}
}
