package lessons.module_4.lesson_4_5.review;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class ThreadLocalReview {
    static ThreadLocal<Knife> knives = ThreadLocal.withInitial(new Supplier<Knife>() {
        @Override
        public Knife get() {
            return new Knife();
        }
    });

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < 10000; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    method();
                }
            });
        }
    }

    private static void method() {
        Knife knife = knives.get();
        knife.cut();
    }
}
