package zipCompress;

/**
 * @author Thilina Hasantha
 * @date: Sep 24, 2008
 * @time: 9:47:42 AM
 */
public class BinaryFileData {
    String fileName;
    byte[] data;

    public BinaryFileData(String fileName, byte[] data) {
        this.fileName = fileName;
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }



    public String toString() {
        return fileName +","+data.length;
    }
}
