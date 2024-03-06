package lessons.module_5.lesson_5_6;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ComparatorsTest {
    public static void main(String[] args) {
        comparators();


    }

    private static void comparators() {
        Consumer<Student> out = System.out::println;

        Stream<Student> str1 = Stream.of(
                new Student("Bilbo", 80),
                new Student("John", 15),
                new Student("Jane", 20),
                new Student("Doe", 20),
                new Student("Harry", 21),
                new Student("Frodo", 25)
        );

//        str1.sorted(Comparator.comparing(s -> s, new MyComparator())).forEach(out);

        str1.sorted(Comparator.comparing(Student::getAge, Integer::compareTo)).forEach(out);
//        str1.sorted(Comparator.comparingInt(Student::getAge)).forEach(out);
//        str1.sorted(Comparator.comparingLong(Student::getAge)).forEach(out);
    }

    private static void simpleComparing(Consumer<Integer> out) {
        Stream<Integer> str1 = Stream.of(1, 6, 2, 9, 1, 2, 10);


        str1.sorted(Comparator.reverseOrder()).forEach(out);
        str1.sorted(Comparator.naturalOrder()).forEach(out);
    }
}
