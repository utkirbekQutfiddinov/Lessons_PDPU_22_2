package lessons.module_5.lesson_5_6;

import java.util.Comparator;

public class MyComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAge().equals(o2.getAge())) {
            return -1*o1.getName().compareTo(o2.getName());
        }

        return o1.getAge().compareTo(o2.getAge());
    }
}
