package lessons.module_5.lesson_5_5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamApi {
    public static void main(String[] args) throws IOException {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 90, 0);
        Consumer<Object> out = System.out::println;

        nums
                .stream()
                .filter(num -> num > 3)
                .skip(2)
                .limit(3)
                .forEach(out);

        nums.forEach(out);

    }

    private static void workingWithInfiniteStreams(Consumer<Object> out) {
        Stream<Integer> iterate = Stream.iterate(1, (num) -> num + 2);

        Stream<Integer> limit = iterate.limit(10);
        limit.forEach(out);
    }

    private static void terminalOperators(Stream<Integer> str11, Consumer<Object> out) {
        //terminal operators
//        Integer[] str12 = str11.toArray(Integer[]::new);

//        System.out.println(str11.findFirst());
//        System.out.println(str11.count());

//        System.out.println(str11.max(Comparator.comparingInt(i -> i)));
//        System.out.println(str11.min(Comparator.comparingInt(i -> i)));

//        System.out.println(str11.reduce((i, j) -> i + j));

        List<Integer> list = str11.toList();
        list.forEach(out);
    }

    private static Stream<Integer> intermediateOperators(List<Integer> nums) {
        //intermediate operators
        Stream<Integer> str1 = nums.stream();
        Stream<Integer> str2 = str1.filter((num) -> num % 2 == 0);

        Stream<Integer> str3 = str2.map((num) -> 1 + num);

        Stream<Integer> str4 = str3.sorted((o1, o2) -> -1 * o1.compareTo(o2));

//        Stream<Integer> str5 = str4.peek(out);

//        str4.forEach(out);
        Stream<Integer> str6 = str4.skip(2);
        Stream<Integer> str7 = str6.limit(3);


        Stream<Integer> str8 = Stream.of(2, 4, 6, 2, 4, 6, 6, 7, 5, 3);

        Stream<Stream<Integer>> str9 = Stream.of(str7, str8);

        Stream<Integer> str10 = str9.flatMap(str -> str);

        Stream<Integer> str11 = str10.distinct();
        return str11;
    }

    private static void infiniteStreams() {
        IntStream ints = new Random().ints();
        LongStream longs = new Random().longs();

        Stream<Double> doubles = Stream.generate(Math::random);
        Stream<Integer> iterate = Stream.iterate(1, (num) -> num + 2);
    }

    private static void streamusingFIleNio() throws IOException {
        Reader reader = new FileReader("new.txt");
        BufferedReader bfr = new BufferedReader(reader);
        Stream<String> str5 = bfr.lines();

        Path p1 = Path.of("src");
        Stream<String> str6 = Files.lines(p1);
        Stream<Path> str7 = Files.list(p1);
    }

    private static void streamUsingFactoryMethod() {
        Stream<Integer> str4 = Stream.of(1, 2, 3, 4, 5);
    }

    private static void streamFromArrays() {
        String[] strs = new String[]{"a", "b"};
        Stream<String> str3 = Arrays.stream(strs);
    }

    private static void streamFromCollections(List<Integer> nums) {
        Stream<Integer> str1 = nums.stream();
        Stream<Integer> str2 = nums.parallelStream();
    }
}
