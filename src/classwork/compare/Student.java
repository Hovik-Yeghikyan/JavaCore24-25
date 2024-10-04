package classwork.compare;


import java.util.Date;
import java.util.Objects;

public class Student /*implements Comparable<Student>*/ {

    private String name;
    private String surname;
    private int age;
    private Date registerDate;

    public Student(String name, String surname, int age, Date registerDate) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.registerDate = registerDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        if (!Objects.equals(name, student.name)) return false;
        if (!Objects.equals(surname, student.surname)) return false;
        return Objects.equals(registerDate, student.registerDate);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (registerDate != null ? registerDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", registerDate=" + registerDate +
                '}';
    }

    //@Override
//    public int compareTo(Student o) {
////        if (o.age > age) {
////            return -1;
////        } else if (o.age < age) {
////            return 1;
////        }
////        return 0;
//        //return name.compareTo(o.name);
//        return registerDate.compareTo(o.registerDate);
//    }
}
