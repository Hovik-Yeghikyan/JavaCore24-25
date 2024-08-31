package classwork.student;

public class Student {
    String name;
    String surname;
    String phoneNumber;
    int age;
    String lessonName;
    String email;

    public Student(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    String printStudentShort() {
        return "Name = " + name + ", " + "Surname =  " + surname +
                ", " + "Phone = " + phoneNumber;
    }

    String printStudentFull() {
        return "Name = " + name + ", " + "Surname =  " + surname +
                ", " + "Phone = " + phoneNumber + "Email = " + email + ", age = "
                + age + " " + "lessonName = " + lessonName;
    }
}
