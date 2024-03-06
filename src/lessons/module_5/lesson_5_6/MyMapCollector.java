package lessons.module_5.lesson_5_6;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MyMapCollector implements Collector<Student, Set<Student>, Map<String, Student>> {
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
    public Function<Set<Student>, Map<String, Student>> finisher() {
        return (idish) -> {
            Map<String, Student> mashina = new HashMap<>();

            Iterator<Student> iterator = idish.iterator();

            while (iterator.hasNext()) {
                Student st = iterator.next();

                mashina.put(st.getName(), st);
            }

            return mashina;
        };
    }


    @Override
    public Set<Characteristics> characteristics() {
        return Set.of();
    }
}
