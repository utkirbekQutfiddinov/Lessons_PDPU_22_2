package lessons.module_4.lesson_4_5.review.forkJoin;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool=new ForkJoinPool();

        int[] ints=new int[1000];
        Random rand=new Random();
        for (int i = 0; i < 1000; i++) {
            ints[i]=rand.nextInt(10000);
        }

        long begin=System.currentTimeMillis();
        System.out.println(pool.submit(new RecursiveTaskUz<Integer>(ints, 0, ints.length)).get());
        long end=System.currentTimeMillis();
        System.out.println(end-begin);

    }



}
