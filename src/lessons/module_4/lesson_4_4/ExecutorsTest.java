package lessons.module_4.lesson_4_4;

import java.util.concurrent.*;

public class ExecutorsTest {
    public static void main(String[] args) {

        Runnable run = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " -> " + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Callable<Integer> call= ()->{
            Thread.sleep(1000);
            return 1;
        };

        ExecutorService service = Executors.newFixedThreadPool(4);
//            ExecutorService service = Executors.newSingleThreadExecutor();
//        ExecutorService service=Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
//            service.execute(run);


            Future<Integer> submit = service.submit(call);
            while(!submit.isDone()) {
                System.out.println("responce did not received yet");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                System.out.println("responce: "+submit.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
//        service.shutdown();
//        if (!service.isShutdown()) {
//            List<Runnable> runnables = service.shutdownNow();
//            System.out.println(runnables.size());
//        }else {
//            System.out.println("all have been completed");
//        }
    }
}
