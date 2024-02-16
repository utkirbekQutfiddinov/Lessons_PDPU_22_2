package lessons.module_4.lesson_4_5.review.aquarium;

import java.util.*;
import java.util.logging.Logger;

public class Aquarium implements Runnable {
    private final List<Fish> fishlar = new ArrayList<>();
    private final List<Fish> fishList=Collections.synchronizedList(fishlar);
    private final int MAX_SIZE = 500;
    private final int MIN_SIZE = 0;
    private final Random rand=SingletonRandom.getInstance();
    private final Logger logger=Logger.getLogger("");


    @Override
    public void run() {
        {
            System.out.println("Aquarium started...");
            generateNewFishes(50);

            while (fishList.size() < MAX_SIZE && fishList.size() > MIN_SIZE) {
                reportFishCount();
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (int i=0; i<fishList.size(); i++) {
                    Fish f1 = fishList.get(i);
                    if (!f1.isAlive()) {
                        fishList.remove(f1);
                        i--;
                        continue;
                    }

                    for (int j=0; j<fishList.size(); j++) {
                        Fish f2 = fishList.get(j);
                        if (!f2.isAlive()) {
                            fishList.remove(f2);
                            j--;
                            continue;
                        }

                        if (!f1.equals(f2)
                                && f1.getX() == f2.getX()
                                && f1.getY() == f2.getY()
//                            && f2.getZ() == f2.getZ()
                                && f1.isAdult()
                                && f2.isAdult()
                                && f1.isCanBreed()
                                && f2.isCanBreed()
                                && f1.isMale() != f2.isMale()) {
                            System.out.println(f1.hashCode()+" fish and "+f2.hashCode()+" fish have been met");
                            generateNewFishes(1);
                        }

                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Aquarium finished...");
        }
    }

    private void reportFishCount() {
        int maleCount=0;
        int adultCount=0;
        int liveCount=0;
        for (int i = 0; i < fishList.size(); i++) {
            if(fishList.get(i).isMale()){
                maleCount++;
            }
            if(fishList.get(i).isAdult()){
                adultCount++;
            }
            if(fishList.get(i).isAlive()){
                liveCount++;
            }
        }

        System.out.println("Total count: "+fishList.size());
        System.out.println("Male count: "+maleCount);
        System.out.println("Female count: "+(fishList.size()-maleCount));
        System.out.println("Adult count: "+adultCount);
        System.out.println("Live count: "+liveCount);
        System.out.println("**********************************");
    }

    private void generateNewFishes(int fishCount) {
        System.out.println("New fishes count:" +fishCount);
        System.out.println("***********************");
        for (int i = 0; i < fishCount; i++) {
            Fish newFish = new Fish();
            new Thread(newFish).start();
            fishList.add(newFish);
        }
    }
}
