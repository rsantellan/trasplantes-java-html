package zipCompress;


import java.util.Hashtable;

/**
 * @author Thilina Hasantha
 * @date: Sep 24, 2008
 * @time: 9:50:18 AM
 */
public class UncompressedFile {
    String path;
    Hashtable<String,BinaryFileData> files=new Hashtable<String, BinaryFileData>();

    public UncompressedFile(String path) {
        this.path = path;
    }

    public void addFile(BinaryFileData binaryFileData){
        files.put(binaryFileData.fileName,binaryFileData);
    }

    public BinaryFileData getFile(String fileName){
        return files.get(fileName);
    }

    public Hashtable<String, BinaryFileData> getFiles() {
        return files;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("Path: "+path + "[ ");
        for(BinaryFileData b:files.values()){
            sb.append("("+b.toString()+")");
        }
        sb.append("]");
        return sb.toString();
    }
}
