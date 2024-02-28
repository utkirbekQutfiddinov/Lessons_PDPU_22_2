package lessons.module_5.lesson_5_4;

import java.util.function.Function;

public class MyParser implements Function<String,Integer> {
    @Override
    public Integer apply(String s) {
        return Integer.parseInt(s);
    }
}
