package classwork.compare;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompareExample {
    public static void main(String[] args) throws ParseException {
        //Set<Student> students = new TreeSet<>(new DateComparator()/*.reversed()*/);
        List<Student> students = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        students.add(new Student("Poxos", "Poxosyan", 22, simpleDateFormat.parse("11-01-2023")));
        students.add(new Student("Aram", "Poxosyan", 32, simpleDateFormat.parse("02-03-2023")));
        //  students.add(new Student("Aram","Petrosyan",50,simpleDateFormat.parse("06-03-2023")));
        students.add(new Student("Zaven", "Poxosyan", 45, simpleDateFormat.parse("05-04-2023")));
        //students.sort(new AgeComparator());
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });
        //students.sort(Comparator.comparing(Student::getSurname));

        for (Student student : students) {
            System.out.println(student);
        }

        String text = """
                sdfhshsfhhffshshsh shsdfhdshsghsgh shsfghshgsg hs shshwrth""";
        System.out.println(text);
    }
}

