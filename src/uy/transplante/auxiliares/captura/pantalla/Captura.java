package uy.transplante.auxiliares.captura.pantalla;

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

import uy.transplante.logica.Fachada;


final class Captura {

	private Captura(){
		
	}
	
	public static void capturar(final String nombreArchivo){
		try {
			TimeUnit.SECONDS.sleep(1);
			final BufferedImage captura = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			
			// Save as JPEG
			final File file = new File(nombreArchivo + ".jpg");
			ImageIO.write(captura, "jpg", file);
			// Save as PNG
			// File file = new File("screencapture.png");
			// ImageIO.write(screencapture, "png", file);
		} catch (HeadlessException e1) {
			Fachada.getInstancia().guardarLog(3, e1.getMessage());
		} catch (AWTException e1) {
			Fachada.getInstancia().guardarLog(3, e1.getMessage());
		} catch (IOException e) {
			Fachada.getInstancia().guardarLog(3, e.getMessage());
		} catch (InterruptedException e) {
			Fachada.getInstancia().guardarLog(3, e.getMessage());
		}
	}
}
