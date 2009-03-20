package zipCompress;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipCompress {

	public ZipCompress() {

	}

	public static boolean zipFileInternet(String from, String to) {
		// Create a buffer for reading the files
		byte[] buf = new byte[1024];
		try {
			// Create the ZIP file
			String outFilename = to;
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
					outFilename));

			// Compress the files

			FileInputStream in = new FileInputStream(from);

			// Add ZIP entry to output stream.
			out.putNextEntry(new ZipEntry(from));

			// Transfer bytes from the file to the ZIP file
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}

			// Complete the entry
			out.closeEntry();
			in.close();

			// Complete the ZIP file
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static void gzipFile(String from, String to) throws IOException {
	    FileInputStream in = new FileInputStream(from);
	    GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(to));
	    byte[] buffer = new byte[4096];
	    int bytesRead;
	    while ((bytesRead = in.read(buffer)) != -1)
	      out.write(buffer, 0, bytesRead);
	    in.close();
	    out.close();
	  }

	  /** Zip the contents of the directory, and save it in the zipfile */
	  public static void zipDirectory(String dir, String zipfile)
	      throws IOException, IllegalArgumentException {
	    // Check that the directory is a directory, and get its contents
	    File d = new File(dir);
	    if (!d.isDirectory())
	      throw new IllegalArgumentException("Not a directory:  "
	          + dir);
	    String[] entries = d.list();
	    byte[] buffer = new byte[4096]; // Create a buffer for copying
	    int bytesRead;

	    ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));

	    for (int i = 0; i < entries.length; i++) {
	      File f = new File(d, entries[i]);
	      if (f.isDirectory())
	        continue;//Ignore directory
	      FileInputStream in = new FileInputStream(f); // Stream to read file
	      ZipEntry entry = new ZipEntry(f.getPath()); // Make a ZipEntry
	      out.putNextEntry(entry); // Store entry
	      while ((bytesRead = in.read(buffer)) != -1)
	        out.write(buffer, 0, bytesRead);
	      in.close(); 
	    }
	    out.close();
	  }
	  
	  public static void unzip(File f) throws IOException{
		  ZipFile zip;
		  zip = new ZipFile(f);
		  Enumeration e = zip.entries();
		  while( e.hasMoreElements() ) {
		   ZipEntry zen = (ZipEntry) e.nextElement();
		   if (zen.isDirectory()){
		    continue;
		   }
		   int size =(int) zen.getSize();
		   InputStream zis = zip.getInputStream(zen);
		   String extractfile = f.getParentFile().getAbsolutePath() + File.separator + zen.getName();
		   
		   writeFile(zis, new File(extractfile),size);
		   zis.close();
		  }
		  zip.close();  
		 }

		 /***
		  * Permite Escribir un archivo de un jar a disco
		  * @throws IOException
		  */
		 public static void writeFile(InputStream zis, File file,int size) throws IOException {
		  File parentFile = file.getParentFile();
		  if(!parentFile.exists()){
		   parentFile.mkdirs();// this is important
		  }

		  FileOutputStream fos = null;
		  try {
		   fos = new FileOutputStream(file);
		   byte[] byteStream = new byte[ (int) size];
		   int buf = -1;
		   int rb = 0;
		   while ( ( ( (int) size - rb) > 0)) {
		    buf = zis.read(byteStream, rb, (int) size - rb);

		    if (buf == -1) {
		     break;
		    }
		    rb += buf;
		   }
		   fos.write(byteStream);
		  }
		  catch(IOException e) {
		   throw new IOException("UNZIP_ERROR");
		  }finally {
		   if(fos != null){
		    fos.close();
		   }
		  }
		 }
}
