package lessons.module_4.lesson_4_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {
    static ThreadLocal<Car> threadLocal=ThreadLocal.withInitial(() -> new Car());
    public static void main(String[] args) {

        ExecutorService service= Executors.newFixedThreadPool(2);

        for (int i = 0; i < 1_000_000; i++) {
            service.execute(() -> {
                method();
            });
        }
    }


    public static void method(){
        Car car= threadLocal.get();

        for (int i1 = 0; i1 < 10; i1++) {
            System.out.println(Thread.currentThread().getName() + " -> " + car.hashCode());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
