/**
 * 
 */
package uy.tranplante.reportes.pdf.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import uy.tranplante.reportes.pdf.estaticos.DocumentoBasico;
import uy.tranplante.reportes.pdf.estaticos.Imagenes;
import uy.tranplante.reportes.pdf.pacientes.GeneratePacientReport;
import uy.tranplante.reportes.pdf.trasplante.GenerateTrasplanteReport;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author rodrigo
 *
 */
public class PdfTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Document document = DocumentoBasico.documentoBasico();
		PdfWriter pdfWriter;
		try {
			pdfWriter = PdfWriter.getInstance(document,
					new FileOutputStream("paciente 0.1.pdf"));
			pdfWriter.setPdfVersion(PdfWriter.PDF_VERSION_1_7);
			document.addTitle("Esto es una prueba");
			document.addSubject("Esto es una prueba de metadata");
			document.addCreator("Rodrigo Santellan");
			document.addAuthor("Rodrigo Santellan");
			document.addHeader("Test 01", "02");
			document.open();
			document.add(Imagenes.header());
			int id = 5;
			document = GeneratePacientReport.soloPaciente(id, document);
			document = GeneratePacientReport.pacientePerdidaInjertos(id, document);
			document = GeneratePacientReport.pacienteMuerte(id, document);
			document = GenerateTrasplanteReport.preTrasplante(id, document);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.close();
	}

}
