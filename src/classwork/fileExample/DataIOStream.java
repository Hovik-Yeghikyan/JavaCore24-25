package classwork.fileExample;
import java.io.*;
public class DataIOStream {

    public static final String FILE_PATH = "C:\\Users\\hovoe\\IdeaProjects\\JavaCore 24-25\\src\\classwork\\fileExample\\myFile.txt";

    public static void main(String[] args) throws IOException {
       write();
       read();
    }

    public static void write() throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream(FILE_PATH));
        out.writeBoolean(true);
        out.writeInt(785);
        out.close();
    }

    public static void read() throws IOException {
        DataInputStream inputStream = new DataInputStream(new FileInputStream(FILE_PATH));
        System.out.println(inputStream.readBoolean());
        System.out.println(inputStream.readInt());
        inputStream.close();
    }
}
