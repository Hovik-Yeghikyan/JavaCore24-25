package classwork.compare;

import java.util.Comparator;

public class DateComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getRegisterDate().compareTo(o2.getRegisterDate());
    }
}

