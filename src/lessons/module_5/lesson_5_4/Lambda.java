package lessons.module_5.lesson_5_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.*;

public class Lambda {
    public static void main(String[] args) {

        /** Functional interfaces:
         *  Runnable, Callable
         *  Function <K,Ch>: apply, compose, andThen
         *  Predicate<T> = Function<T,Boolean>: test
         *  Supplier<Integer>: T get()
         *  Consumer<Integer>: void accept(T);
         *  BiFunction<K1,K2,Ch>:
         *  UnaryOparator:
         *  BinaryOparator:
         *
         *  final & effectively final variables
         */


        int a = 10;


        int b = a;

        Runnable test = () -> System.out.println(b);


        test.run();


        a++;
        System.out.println(a);
    }

    private static void biop() {
        BinaryOperator<Integer> bin = (a, b) -> a + b;
        System.out.println(bin.apply(12, 23));
    }

    private static void unary() {
        UnaryOperator<Integer> uno = (a) -> a * 2;

        System.out.println(uno.apply(10));
    }

    private static void bifunction() {
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;

        System.out.println(sum.apply(12, 23));
    }

    private static void consumer() {
        Consumer<String> con = System.out::println;
        con.accept("salom");
    }

    private static void supplier() {
        Supplier<Book> sup1 = () -> new Book("Java", "Cay Horstman");

        for (int i = 0; i < 10; i++) {
            System.out.println(sup1.get());
        }
    }

    private static void funcAndPredicate() {
        Function<String, Integer> func1 = (text) -> {
            return Integer.parseInt(text);
        };

        Function<Boolean, String> func2 = (b) -> {
            if (b) {
                return "12";
            } else {
                return "34";
            }
        };

//        Function<Integer, Boolean> func3 =(i)-> i>18;
        Predicate<Integer> func4 = i -> i > 18;
        Predicate<Integer> func5 = i -> i < 27;
        System.out.println(func4.test(25));
        System.out.println(func4.negate().test(30));
        System.out.println(func4.and(func5).test(40));//(a)->a<27
        System.out.println(func4.or(func5).test(40));//(a)->a<27

//        System.out.println(parser1.compose(func2).compose(func3).apply(12));

//        System.out.println(apply1);
//
//        Integer apply = parser.apply("1232");
//        System.out.println(apply);

//        System.out.println(func3.andThen(func2).andThen(func1).apply(20) + 1);
    }

    private static void mehtodReference() {
        MyInterface my = MyRunnable::myPrint;

//        my.print("salom pdp");
//        my.print("salom java");


        List<String> texts = new ArrayList<>() {{
            add("salom1");
            add("salom2");
            add("salom3");
            add("salom4");
        }};

        texts.forEach((s) -> {
            System.out.print(s + " kirib keldi");
            System.out.println("...");
        });

        //method reference
    }

    private static void lambda() {
        Runnable runnable = () -> System.out.println("salom");

//        MyInterface my = (a, b) -> a > b;
//
//        System.out.println(my.print(23, 45));

//        runnable.run();


        // () -> {}
        // (args...) -> {return ...}
    }
}
