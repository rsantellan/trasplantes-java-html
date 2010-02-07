package encriptado;

import java.security.MessageDigest;

public class Md5{

    /**
     * Encripta un String con el algoritmo MD5.
     * @return String
     * @throws Exception
     */
    private static String hash(String clear) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] b = md.digest(clear.getBytes());

        int size = b.length;
        StringBuffer h = new StringBuffer(size);
        for (int i = 0; i < size; i++) {
            int u = b[i]&255; // unsigned conversion
            if (u<16) {
                h.append("0"+Integer.toHexString(u));
            } else {
                h.append(Integer.toHexString(u));
            }
        }
        return h.toString();
    }

    /**
     * Encripta un String con el algoritmo MD5.
     * @return String
     * @throws Exception
     */
    public static String encriptar(String palabra)throws Exception {
        String pe="";
        try {
            pe = hash(palabra);
        } catch (Exception e) {
            throw new Error("<strong>Error: Al encriptar el password</strong>");    
        }
        return pe;
    }
} 