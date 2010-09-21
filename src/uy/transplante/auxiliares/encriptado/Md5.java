package uy.transplante.auxiliares.encriptado;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class Md5{

	private Md5(){
		
	}
	
    /**
     * Encripta un String con el algoritmo MD5.
     * @return String
     * @throws NoSuchAlgorithmException 
     * @throws Exception
     */
    private static String hash(final String clear) throws NoSuchAlgorithmException {
        final MessageDigest mdhash = MessageDigest.getInstance("MD5");
        final byte[] auxByte = mdhash.digest(clear.getBytes());

        final int size = auxByte.length;
        final StringBuffer stringBuffer = new StringBuffer(size);
        for (int i = 0; i < size; i++) {
            final int unsignedConv = auxByte[i]&255; // unsigned conversion
            String auxiliary = "";
            if (unsignedConv<16) {
            	auxiliary = "0"+Integer.toHexString(unsignedConv);
            } else {
                auxiliary = Integer.toHexString(unsignedConv);
            }
            stringBuffer.append(auxiliary);
        }
        return stringBuffer.toString();
    }

    /**
     * Encripta un String con el algoritmo MD5.
     * @return String
     * @throws NoSuchAlgorithmException 
     * @throws Exception
     */
    public static String encriptar(final String palabra) throws NoSuchAlgorithmException  {
        return hash(palabra);
    }
} 