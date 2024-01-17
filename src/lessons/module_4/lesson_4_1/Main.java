import threads.MySecondThread;
import threads.MyThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {


       String[] names=new String[]{ "Ilyosbek Mamashukurov",
        "Muhammadumar",
        "Muhammadaziz Yo'ldoshev",
        "Ali Negmatov",
        "Muhammadaziz Ergashev",
        "Asadbek Abdinazarov",
        "Sharifboyev Abdurahmon",
        "Ahmadjonov Isfandiyor",
        "Suhrob Hosiljonov",
        "Jahongir Esanboyev",
        "Baxrombek Isamaxamatov",
        "Yusufbek Murodov",
        "Muhammadanasxon Madaminov",
        "Samandar Orifjonov",
        "Tursunali Tojaliyev",
        "Xusniddin Muhiddinov",
        "Salimov Qudratilla",
        "Javohir",
        "Rashidov Shohjahon",
        "Asadbek Isakulov",
        "Aslamov Doston"
       };

//       int a=new Random().nextInt()%21;
//       a=a>0?a:a*-1;
//
//
//        System.out.println(names[a]);


//        Thread[] ths=new Thread[5];

//        for (int i = 0; i < 5; i++) {
////            ths[i]=new Thread(()->{
////                for (int j = 0; j < 9; j++) {
////                    System.out.println(j+" : "+Thread.currentThread().getName());
////                }
////            });
//
//            ths[i]=new MyThread("Thread:"+i*5);
////            ths[i]=new Thread(new Runnable() {
////                @Override
////                public void run() {
////                    for (int j = 0; j < 10; j++) {
////                        System.out.println(j+" : "+Thread.currentThread().getName());
////                    }
////                }
////            });
//            ths[i].start();
//            System.out.println(ths[i].getName());
//        }

        /**
         * Thread lifecycle:
         * 1. new
         * 2. runnable (running)
         * 3. waiting
         * 4. blocked
         * 5. terminated
         */


//        Thread t=new Thread(()->{
//            try {
//                sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("child died");
//        });
//        t.start();
////        t.join();
//        t.join(20000);
//
//        System.out.println("main died");

//        List<Thread> threads=new ArrayList<>();
//
            Thread t1=new Thread(new MySecondThread("birinchi"));
            Thread t2=new Thread(new MySecondThread("ikkinchi"));
            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            }catch (InterruptedException e){
                e.printStackTrace();
        }

        System.out.println(MySecondThread.count);

    }
}
