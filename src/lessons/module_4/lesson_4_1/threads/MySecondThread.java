package threads;

import java.util.concurrent.atomic.*;

public class MySecondThread implements Runnable{
    public static AtomicLong count=new AtomicLong(0);
    private String name;
    public MySecondThread(String name){
        this.name=name;
    }

    @Override
    public void run() {

        for (int i = 0; i < 1_000_000; i++) {
            inc();
        }
        System.out.println(name+" : done");
    }

    private static void inc(){
        count.getAndIncrement();
    }
}
