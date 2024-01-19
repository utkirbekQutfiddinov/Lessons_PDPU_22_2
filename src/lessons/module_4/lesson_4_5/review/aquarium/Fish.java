package lessons.module_4.lesson_4_5.review.aquarium;

import java.util.Random;

public class Fish implements Runnable{
    private Boolean isAlive;
    private Long lifeDuration;
    private Long birthTime;
    private Long lastTime;
    private boolean male;
    private boolean adult;
    private static Random rand=new Random();

    private int length;
    private int heigth;
    private int width;

    private int x;
    private int y;
    private int z;

    public Fish(int length, int heigth, int width){
        lifeDuration=rand.nextLong(1000,5000);
        birthTime=System.currentTimeMillis();
        male= rand.nextBoolean();
        adult=false;
        x= rand.nextInt(length);
        y= rand.nextInt(heigth);
        z= rand.nextInt(width);

    }

    @Override
    public void run() {
        while (isAlive){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            x= rand.nextInt(length);
            y= rand.nextInt(heigth);
            z= rand.nextInt(width);


            //TODO: check if x,y,z are equal with another fishe's coordinates
            if(isMeet(null,null)){
                meet(this, null);
            }
        }
    }

    private boolean isMeet(Fish f1, Fish f2) {
        return false;
    }

    private void meet(Fish fish1 , Fish fish) {

    }
}
