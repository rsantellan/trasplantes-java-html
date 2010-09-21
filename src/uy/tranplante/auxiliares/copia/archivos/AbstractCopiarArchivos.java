package uy.tranplante.auxiliares.copia.archivos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

final class AbstractCopiarArchivos {

	private AbstractCopiarArchivos(){
		
	}
	
	public static void copia(final String nombreFuente, final String nombreDestino) throws IOException{
		FileInputStream fis;
		fis = new FileInputStream(nombreFuente);
		final FileOutputStream fos = new FileOutputStream(nombreDestino);
		final FileChannel canalFuente = fis.getChannel();
		final FileChannel canalDestino = fos.getChannel();
		canalFuente.transferTo(0, canalFuente.size(), canalDestino);
		fis.close();
		fos.close();
	}

}
