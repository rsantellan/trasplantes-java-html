/**
 * 
 */
package uy.tranplante.reportes.pdf.estaticos;

import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;

/**
 * @author rodrigo
 *
 */
public class Imagenes {
	public static Image header() throws BadElementException, MalformedURLException, IOException{
		Image imgBasic = Image.getInstance("image/images.jpeg");
		imgBasic.setAbsolutePosition(450, 750);
		return imgBasic;
	}
}
