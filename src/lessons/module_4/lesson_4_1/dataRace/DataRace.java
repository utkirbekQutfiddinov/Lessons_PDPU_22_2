package dataRace;

import threads.MySecondThread;
import threads.MyThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataRace {
    public static void main(String[] args) {
        System.out.println("Before: "+MyThread.count);
        Lock birinchi=new ReentrantLock();
        Lock ikkinchi=new ReentrantLock();

        MyThread a=new MyThread(true,"A",birinchi,ikkinchi);
        MyThread b=new MyThread(false,"B",ikkinchi,birinchi);

        a.start();
        b.start();
        try{
            a.join();
            b.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

//        Thread[] ts=new Thread[5];
//
//        for (int i = 0; i < 5; i++) {
//            ts[i]=new Thread(new MySecondThread(i+""));
//        }
//
//        for (int i = 0; i < 5; i++) {
//            ts[i].start();
//        }
//
//        for (int i = 0; i < 5; i++) {
//            try {
//                ts[i].join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }



        System.out.println(MySecondThread.count);


    }
}
