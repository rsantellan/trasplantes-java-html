package capturaPantalla;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

public class Captura {

	public static void capturar(String nombreArchivo){
		try {
			TimeUnit.SECONDS.sleep(1);
			BufferedImage captura = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			
			// Save as JPEG
			File file = new File(nombreArchivo + ".jpg");
			ImageIO.write(captura, "jpg", file);
			// Save as PNG
			// File file = new File("screencapture.png");
			// ImageIO.write(screencapture, "png", file);
		} catch (HeadlessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
