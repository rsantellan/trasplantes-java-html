package zipCompress;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author Thilina Hasantha
 * @date: Aug 12, 2008
 * @time: 11:57:38 AM
 */
public class ZipFileUtil {



    public static UncompressedFile extract(String sourcePath,String targetPath) throws IOException {
        byte[] zip = fileToBytes(sourcePath);
        return extract(zip,targetPath);
    }

    public static UncompressedFile extract(byte[] zip,String targetPath) throws IOException {
        ZipEntry oEntry;
        ZipInputStream zIn;
        ByteArrayOutputStream byto;

        ByteArrayInputStream ba = new ByteArrayInputStream(zip);
        zIn = new ZipInputStream(ba);

        UncompressedFile u = new UncompressedFile(targetPath);

        while (true) {
            try {
                oEntry = zIn.getNextEntry();

                if (oEntry == null)
                    break;

                byto = new ByteArrayOutputStream();
                int i;
                byte[] bytData = new byte[1000];
                int k = 0;
                while (true) {
                    i = zIn.read(bytData);
                    if (i == -1)
                        break;
                    byto.write(bytData, 0, i);
                    k += i;
                }
                zIn.closeEntry();
                u.addFile(new BinaryFileData(oEntry.getName(), byto.toByteArray()));
                oEntry = null;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return u;

    }


    public static byte[] compress(UncompressedFile uncompressedFile) throws IOException {
        ByteArrayOutputStream byto = new ByteArrayOutputStream();
        ZipOutputStream zOut = new ZipOutputStream(byto);
        zOut.setLevel(9);
        zOut.setMethod(ZipOutputStream.DEFLATED);
        for (BinaryFileData b : uncompressedFile.files.values()) {
            zOut.putNextEntry(new ZipEntry(b.fileName));
            zOut.write(b.getData());
            zOut.closeEntry();
        }

        zOut.flush();
        zOut.finish();
        zOut.close();
        return byto.toByteArray();

    }

    public static byte[] fileToBytes(String path) throws IOException {
        File f = new File(path);
        FileInputStream fi = new FileInputStream(f);
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        byte[] bytData = new byte[1000];
        int i = 0;
        while (true) {
            i = fi.read(bytData);
            if (i == -1)
                break;
            bo.write(bytData, 0, i);
        }
        return bo.toByteArray();
    }

    public  static void saveUncompressedFile(UncompressedFile uncompressedFile){
        File f=new File(uncompressedFile.getPath());
        if(!(f.exists() && f.isDirectory())){
            f.mkdirs();
        }
        for(BinaryFileData b:uncompressedFile.getFiles().values()){
            try {
                byteArrayToFile(uncompressedFile.getPath()+"/"+ b.getFileName(),b.data);
            } catch (IOException e) {
                e.printStackTrace();  
            }
        }
    }

    public  static void byteArrayToFile(String path,byte[] data) throws IOException {
        File f = new File(path);
        FileOutputStream fo = new FileOutputStream(path);
        fo.write(data);
        fo.flush();
        fo.close();
    }

}
