package uy.tranplante.auxiliares.copia.archivos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class CopiarArchivos {

	public static void copia(String nombreFuente, String nombreDestino) throws IOException{
		FileInputStream fis;
		fis = new FileInputStream(nombreFuente);
		FileOutputStream fos = new FileOutputStream(nombreDestino);
		FileChannel canalFuente = fis.getChannel();
		FileChannel canalDestino = fos.getChannel();
		canalFuente.transferTo(0, canalFuente.size(), canalDestino);
		fis.close();
		fos.close();
	}

}
