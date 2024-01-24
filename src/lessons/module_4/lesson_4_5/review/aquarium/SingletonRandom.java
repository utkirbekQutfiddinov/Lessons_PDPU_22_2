package lessons.module_4.lesson_4_5.review.aquarium;

import java.util.Random;

public class SingletonRandom {
    private static Random instance;


    public static Random getInstance(){
        if(instance==null){
            synchronized (SingletonRandom.class){
                if(instance==null){
                    instance=new Random();
                }
            }
        }

        return instance;
    }
}
