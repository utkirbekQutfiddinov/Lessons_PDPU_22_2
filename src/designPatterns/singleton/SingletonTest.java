package singleton;

import builder.Book;
import singleton.Car;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class SingletonTest {
    private static final ThreadLocal<Book> dateFormat=new ThreadLocal<>();
    public static void main(String[] args) {
//        Thread t1=new Thread(new MyThread());
//        Thread t2=new Thread(new MyThread());
//
//        t1.start();
//        t2.start();


        try(ExecutorService service= Executors.newFixedThreadPool(10)){
            for (int i = 0; i < 1000; i++) {
                service.execute(()->{


                    Book sdf= dateFormat.get();
//                    if (sdf==null){
//                        sdf=new Book();
//                        dateFormat.set(sdf);
//                    }
                    System.out.println(" : sdf="+sdf.hashCode()+", thread="+Thread.currentThread().getName());
                });
            }
        }
    }
    static void a(){
    }
}
