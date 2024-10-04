package classwork.fileExample.serialization;

import java.io.*;

public class SerializationDemo {

    public static final String FILE_PATH = "C:\\Users\\hovoe\\IdeaProjects\\JavaCore 24-25\\src\\classwork\\fileExample\\serialization\\example.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        Student student = new Student("Poxos", "Poxosyan", 45, "poxos@mai;.ru");
//
//        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
//            objectOutputStream.writeObject(student);
//        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Object object = objectInputStream.readObject();
            if (object instanceof Student student) {
                System.out.println(student);
            }
        }
    }
}
