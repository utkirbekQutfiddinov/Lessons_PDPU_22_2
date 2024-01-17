package threads;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread{

    public static int count=100;
    private Lock firstChopStick;
    private Lock secondChopStick;
    private final boolean isDead;


    public MyThread(boolean isDead, String name, Lock firstChopStick, Lock secondChopStick){
        super(name);
        this.firstChopStick=firstChopStick;
        this.secondChopStick=secondChopStick;
        this.isDead=isDead;
    }
    @Override
    public void run() {
        while (count>0){
            firstChopStick.lock();
            try {
                if (count < 90 && isDead) {
                    System.out.println(1 / 0);
                }
            }catch (Exception e){
                firstChopStick.unlock();
            }
            if (!secondChopStick.tryLock()) {
                System.out.println(this.getName()+" unlocked the first lock");
               firstChopStick.unlock();
                try {
                    int time=new Random().nextInt()%1000;
                    time=time<0?time*-1:time;
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
            if(count>0){
                System.out.print(this.getName()+" 1ta manti yedi");
                count--;
                System.out.println(". Qoldi: "+count);
            }
            secondChopStick.unlock();
            firstChopStick.unlock();
        }

        }
    }

}
