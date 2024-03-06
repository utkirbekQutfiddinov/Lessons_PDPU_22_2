package lessons.module_5.lesson_5_6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MyCollector implements Collector<Student, Set<Student>, List<Student>> {
    @Override
    public Supplier<Set<Student>> supplier() {
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<Student>, Student> accumulator() {
        return Set::add;
    }

    @Override
    public BinaryOperator<Set<Student>> combiner() {
        return (idish1, idish2) -> {
            idish1.addAll(idish2);
            return idish1;
        };
    }

    @Override
    public Function<Set<Student>, List<Student>> finisher() {
        return ArrayList::new;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of();
    }
}
