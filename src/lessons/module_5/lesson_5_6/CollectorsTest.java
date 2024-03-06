package lessons.module_5.lesson_5_6;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class CollectorsTest {
    public static void main(String[] args) {

        Stream<Student> str1 = Stream.of(
                new Student("Bilbo", 80),
                new Student("John1", 15),
                new Student("John", 50),
                new Student("John", 30),
                new Student("Jane", 20),
                new Student("Doe", 20),
                new Student("Harry", 15),
                new Student("Frodo", 50)
        );


//        List<Student> collect = str1.collect(new MyCollector());

        Map<String, Student> collect = str1.collect(new MyMapCollector());

        System.out.println(collect);

    }

    private static void collecting() {
        BiConsumer<String, Integer> biOut = (k, v) -> System.out.println(k + " : " + v);

        Stream<Student> str1 = Stream.of(
                new Student("Bilbo", 80),
                new Student("John1", 15),
                new Student("John", 50),
                new Student("John", 30),
                new Student("Jane", 20),
                new Student("Doe", 20),
                new Student("Harry", 15),
                new Student("Frodo", 50)
        );

//        List<Student> collect = str1.collect(Collectors.toList());

//        Set<Student> collect = str1.collect(Collectors.toSet());


//        Map<String, Integer> collect = str1.collect(Collectors.toMap(Student::getName, Student::getAge));
//        collect.forEach(biOut);


//        Map<String, Integer> collect = str1.collect(Collectors.toMap(Student::getName, Student::getAge, Integer::sum));
//        collect.forEach(biOut);

//        TreeSet<Student> collect = str1.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Student::getName))));
//        System.out.println(collect);


//        Optional<Student> collect = str1.min(Comparator.comparing(Student::getName));
//
//        System.out.println(collect.get());


//        Map<Boolean, List<Student>> map = str1.collect(Collectors.partitioningBy((s) -> s.getName().equals("John")));
//
//        map.forEach((k,v)->{
//            System.out.println(k+" -> "+v);
//        });

//        IntSummaryStatistics stats = str1.collect(Collectors.summarizingInt(Student::getAge));
//
//        System.out.println(stats);

//        Integer collect = str1.collect(Collectors.summingInt(Student::getAge));
//        System.out.println(collect);

//        Long j = str1.collect(Collectors.filtering((s) -> s.getName().startsWith("J"), Collectors.counting()));
//        System.out.println(j);
//        Map<Integer, List<Student>> collect = str1.collect(Collectors.groupingBy(Student::getAge));
//        collect.forEach((k, v) -> {
//            System.out.println(k + " : " + v);
//        });


//        Optional<Student> collect = str1.reduce((s1, s2) -> new Student(s1.getName(), s1.getAge() + s2.getAge()));
//
//        System.out.println(collect.get());


//        String collect = str1
//                .map(Student::getName)
//                .collect(Collectors.joining(", ","[","]"));
//
//        System.out.println(collect);
    }
}
