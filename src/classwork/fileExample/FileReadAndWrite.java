package classwork.fileExample;

import java.io.*;

public class FileReadAndWrite {

    public static final String FILE_PATH = "C:\\Users\\hovoe\\IdeaProjects\\JavaCore 24-25\\src\\classwork\\fileExample\\myFile.txt";

    public static void main(String[] args) throws IOException {
        write();
        read();
    }

    public static void write() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH));
        for (int i = 0; i < 1000; i++) {
            bw.write("Hello");
            bw.newLine();
        }
        bw.close();
    }

    public static void read() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
//            String line = "";
//            int lineNumber = 1;
//            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println(lineNumber++ + " " + line);
//            }
            int c;
            while ((c = bufferedReader.read()) != -1) {
                System.out.println((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
