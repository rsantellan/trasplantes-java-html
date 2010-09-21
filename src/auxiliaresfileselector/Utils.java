package auxiliaresfileselector;

import java.io.File;
import javax.swing.ImageIcon;

import logica.Fachada;

final class Utils {
	public final static String JPEG = "jpeg";
    public final static String JPG = "jpg";
    public final static String GIF = "gif";
    public final static String TIFF = "tiff";
    public final static String TIF = "tif";
    public final static String PNG = "png";
    public final static String SQL = "sql";
    public final static String ZIP = "zip";

    private Utils(){
    	
    }
    /*
     * Get the extension of a file.
     */
    public static String getExtension(final File file) {
        String ext = null;
        final String string = file.getName();
        final int index = string.lastIndexOf('.');

        if (index > 0 &&  index < string.length() - 1) {
            ext = string.substring(index+1).toLowerCase();
        }
        return ext;
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(final String path) {
        final java.net.URL imgURL = Utils.class.getResource(path);
        ImageIcon returnObject = null;
        try{
        	assert (imgURL) != null;
        	returnObject = new ImageIcon(imgURL);
        }catch(AssertionError as){
            Fachada.getInstancia().guardarLog(3, "Couldn't find file: " + path);
        }
        return returnObject;
    }

}
