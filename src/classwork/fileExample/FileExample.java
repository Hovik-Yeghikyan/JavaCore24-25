package classwork.fileExample;

import java.io.File;
import java.io.IOException;

public class FileExample {

    public static final String FILE_PATH = "C:\\Users\\hovoe\\IdeaProjects\\JavaCore 24-25\\src\\classwork\\fileExample\\myFile.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(FILE_PATH);
//        System.out.println(file.exists());
//        System.out.println(file.delete());
//        System.out.println(file.exists());
        if (!file.exists()){
            System.out.println(file.createNewFile());
        }
      //  System.out.println("is file? " + file.isFile());
      //  System.out.println("is directory? " + file.isDirectory());
    //    System.out.println(file.length());
        System.out.println(File.separator);
    }
}
